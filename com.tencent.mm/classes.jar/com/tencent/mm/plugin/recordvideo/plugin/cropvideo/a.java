package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider.a;
import com.tencent.mm.plugin.recordvideo.e.e;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.h;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropBtn", "Landroid/widget/ImageView;", "cropEnd", "", "cropRecyclerThumbSeekBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "cropStart", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "jumpHideAnimation", "", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "weseeArrowBtn", "weseeBtn", "weseeWrapper", "changeThumbBarPercent", "", "currentTime", "", "forceCropVideo", "isForce", "getSmaller", "a", "b", "getString", "", "resId", "name", "onBackPress", "onClick", "v", "Landroid/view/View;", "onDown", "left", "start", "end", "onMove", "onRecyclerChanged", "onUp", "release", "reset", "resetConfirmStyle", "bgStyleResId", "textColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setCaptureInfo", "setJumpHideAnimation", "jump", "setUIParams", "seekbarHeight", "bgResId", "setVisibility", "visibility", "showWeSeeBtn", "synCropInfo", "Companion", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, c.b, t
{
  public static final a vlY;
  ViewGroup fSZ;
  private com.tencent.mm.ui.widget.a.d iAV;
  public RecordConfigProvider vcC;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d vjo;
  private final ImageView vlP;
  public final EditVideoSeekBarView vlQ;
  private final ViewGroup vlR;
  private final ImageView vlS;
  private final ImageView vlT;
  public com.tencent.mm.media.widget.camerarecordview.b.b vlU;
  public boolean vlV;
  private float vlW;
  public float vlX;
  
  static
  {
    AppMethodBeat.i(75702);
    vlY = new a((byte)0);
    AppMethodBeat.o(75702);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75701);
    this.fSZ = paramViewGroup;
    this.vjo = paramd;
    paramViewGroup = this.fSZ.findViewById(2131299289);
    k.g(paramViewGroup, "parent.findViewById(R.id.editor_crop_video)");
    this.vlP = ((ImageView)paramViewGroup);
    paramViewGroup = this.fSZ.findViewById(2131299288);
    k.g(paramViewGroup, "parent.findViewById(R.id.editor_crop_bar)");
    this.vlQ = ((EditVideoSeekBarView)paramViewGroup);
    this.vlR = ((ViewGroup)this.fSZ.findViewById(2131307099));
    this.vlS = ((ImageView)this.fSZ.findViewById(2131301209));
    this.vlT = ((ImageView)this.fSZ.findViewById(2131301226));
    this.vlX = 1.0F;
    this.vlP.setImageDrawable(am.i(this.fSZ.getContext(), 2131690382, -1));
    this.vlP.setOnClickListener((View.OnClickListener)this);
    this.vlQ.setCancelButtonClickListener((View.OnClickListener)this);
    this.vlQ.setFinishButtonClickListener((View.OnClickListener)this);
    paramViewGroup = this.vlQ.getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(75701);
      throw paramViewGroup;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramViewGroup;
    paramViewGroup.bottomMargin += ap.eb(this.fSZ.getContext());
    this.vlQ.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
    AppMethodBeat.o(75701);
  }
  
  private final void T(float paramFloat1, float paramFloat2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(75697);
    Object localObject = this.vlU;
    int k;
    float f2;
    int i;
    if (localObject != null)
    {
      k = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).gBm - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).cUL;
      f2 = k;
      localObject = this.vcC;
      if (localObject == null) {
        k.fvU();
      }
      i = ((RecordConfigProvider)localObject).vhQ;
      localObject = this.vlU;
      if (localObject == null) {
        k.fvU();
      }
      f2 = (paramFloat2 - paramFloat1) * f2 - gL(i + 250, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).gBm);
      if (f2 >= 0.0F) {
        break label195;
      }
    }
    for (;;)
    {
      i = Math.round(k * paramFloat1);
      int j = (int)f1 / 2;
      k = Math.round(k * paramFloat2);
      int m = (int)f1 / 2;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("EDIT_CROP_VIDEO_LENGTH_START_TIME_INT", i + j);
      ((Bundle)localObject).putInt("EDIT_CROP_VIDEO_LENGTH_END_TIME_INT", k - m);
      this.vjo.a(d.c.voa, (Bundle)localObject);
      AppMethodBeat.o(75697);
      return;
      AppMethodBeat.o(75697);
      return;
      label195:
      f1 = f2;
    }
  }
  
  public static int gL(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private final String getString(int paramInt)
  {
    AppMethodBeat.i(75691);
    if (this.fSZ.getContext() != null)
    {
      String str = this.fSZ.getContext().getString(paramInt);
      k.g(str, "parent.context.getString(resId)");
      AppMethodBeat.o(75691);
      return str;
    }
    AppMethodBeat.o(75691);
    return "";
  }
  
  public final void M(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75692);
    ad.d("MicroMsg.EditCropVideoPlugin", "onRecyclerChanged : " + paramFloat1 + ' ' + paramFloat2);
    this.vlW = paramFloat1;
    this.vlX = paramFloat2;
    T(paramFloat1, paramFloat2);
    AppMethodBeat.o(75692);
  }
  
  public final void N(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75693);
    ad.d("MicroMsg.EditCropVideoPlugin", "onDown : " + paramFloat1 + ' ' + paramFloat2);
    d.b.a(this.vjo, d.c.voc);
    AppMethodBeat.o(75693);
  }
  
  public final void O(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75694);
    ad.d("MicroMsg.EditCropVideoPlugin", "onUp : " + paramFloat1 + ' ' + paramFloat2);
    this.vlW = paramFloat1;
    this.vlX = paramFloat2;
    T(paramFloat1, paramFloat2);
    AppMethodBeat.o(75694);
  }
  
  public final void P(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75695);
    ad.d("MicroMsg.EditCropVideoPlugin", "onMove : " + paramFloat1 + ' ' + paramFloat2);
    AppMethodBeat.o(75695);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    AppMethodBeat.i(75698);
    ViewGroup localViewGroup = this.vlR;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
    if (this.vlQ.getVisibility() == 0)
    {
      d.b.a(this.vjo, d.c.voe);
      this.vlQ.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new b(this));
      AppMethodBeat.o(75698);
      return true;
    }
    AppMethodBeat.o(75698);
    return false;
  }
  
  public final String name()
  {
    return "plugin_video_crop";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75690);
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label46;
      }
      label22:
      if (paramView != null) {
        break label137;
      }
      label26:
      if (paramView != null) {
        break label284;
      }
    }
    for (;;)
    {
      if (paramView == null)
      {
        AppMethodBeat.o(75690);
        return;
        paramView = null;
        break;
        label46:
        if (paramView.intValue() != 2131299263) {
          break label22;
        }
        this.vlQ.tLG.reset();
        d.b.a(this.vjo, d.c.voe);
        this.vlQ.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new c(this));
        paramView = this.vlR;
        if (paramView != null)
        {
          paramView.setVisibility(8);
          AppMethodBeat.o(75690);
          return;
        }
        AppMethodBeat.o(75690);
        return;
        label137:
        if (paramView.intValue() != 2131299265) {
          break label26;
        }
        T(this.vlW, this.vlX);
        d.b.a(this.vjo, d.c.vof);
        if (!this.vlV) {
          this.vlQ.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new d(this));
        }
        paramView = this.vlR;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = this.vlU;
        if (paramView != null)
        {
          int i = paramView.gBm;
          int j = paramView.cUL;
          paramView = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_VIDEO_CROP_DURATION_MS_INT", Integer.valueOf((int)((i - j) * (this.vlX - this.vlW))));
          AppMethodBeat.o(75690);
          return;
        }
        AppMethodBeat.o(75690);
        return;
        label284:
        if (paramView.intValue() == 2131299289)
        {
          ou(false);
          paramView = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.alO("KEY_CLICK_VIDEO_CROP_COUNT_INT");
          AppMethodBeat.o(75690);
          return;
        }
      }
    }
    final boolean bool;
    Context localContext;
    if (paramView.intValue() == 2131307099)
    {
      paramView = e.vtS;
      paramView = this.fSZ.getContext();
      k.g(paramView, "parent.context");
      bool = e.fK(paramView);
      paramView = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(1));
      localContext = this.fSZ.getContext();
      if (!bool) {
        break label445;
      }
    }
    label445:
    for (paramView = getString(2131755769);; paramView = getString(2131755767))
    {
      this.iAV = h.d(localContext, paramView, "", getString(2131755835), getString(2131755691), (DialogInterface.OnClickListener)new e(this, bool), (DialogInterface.OnClickListener)new f(this, bool));
      AppMethodBeat.o(75690);
      return;
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void ou(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(75689);
    this.vlQ.setVisibility(0);
    ad.d("MicroMsg.EditCropVideoPlugin", "forceCropVideo isForce: ".concat(String.valueOf(paramBoolean)));
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = this.vcC;
      if ((localObject1 != null) && (((RecordConfigProvider)localObject1).scene == 2))
      {
        paramBoolean = TextUtils.equals((CharSequence)((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvQ, "0"), (CharSequence)"1");
        boolean bool = aj.eFE().getBoolean("wesee_switch", false);
        ad.i("MicroMsg.EditCropVideoPlugin", "xSwitch: " + paramBoolean + ", commandSwitch:" + bool);
        if ((!paramBoolean) && (!bool)) {
          break label513;
        }
        localBundle.putBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", true);
        localObject1 = this.vlR;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setVisibility(0);
        }
        localObject1 = this.vlR;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)this);
        }
        localObject1 = this.vlS;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable(am.i(this.fSZ.getContext(), 2131690503, -1));
        }
        localObject1 = this.vlT;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable(am.i(this.fSZ.getContext(), 2131690349, -1));
        }
        localObject1 = this.vlR;
        if (localObject1 != null)
        {
          localObject1 = ((ViewGroup)localObject1).getContext();
          if (!ai.aF((Context)localObject1)) {
            break label409;
          }
          localObject1 = this.vlR;
          if (localObject1 == null) {
            break label335;
          }
        }
        label335:
        for (localObject1 = ((ViewGroup)localObject1).getLayoutParams();; localObject1 = null)
        {
          if (localObject1 != null) {
            break label341;
          }
          localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(75689);
          throw ((Throwable)localObject1);
          localObject1 = null;
          break;
        }
        label341:
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject1;
        int i = localMarginLayoutParams.topMargin;
        ViewGroup localViewGroup = this.vlR;
        localObject1 = localObject2;
        if (localViewGroup != null) {
          localObject1 = localViewGroup.getContext();
        }
        localMarginLayoutParams.topMargin = (i + ai.aE((Context)localObject1));
        localObject1 = this.vlR;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localMarginLayoutParams);
        }
        label409:
        localObject1 = WeSeeProvider.vfZ;
        WeSeeProvider.a.delete();
        localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(1));
        localObject1 = e.vtS;
        localObject1 = this.fSZ.getContext();
        k.g(localObject1, "parent.context");
        if (!e.fK((Context)localObject1)) {
          break label531;
        }
        localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_IS_INSTALL_WESEE", Integer.valueOf(1));
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(2));
      this.vjo.a(d.c.vnY, localBundle);
      AppMethodBeat.o(75689);
      return;
      label513:
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(2));
      break;
      label531:
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_IS_INSTALL_WESEE", Integer.valueOf(2));
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(75700);
    this.vlQ.release();
    if (this.iAV != null)
    {
      Object localObject = this.iAV;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(75700);
        throw ((Throwable)localObject);
      }
      if (((Dialog)localObject).isShowing())
      {
        localObject = this.iAV;
        if (localObject != null) {
          ((com.tencent.mm.ui.widget.a.d)localObject).dismiss();
        }
        ad.i("MicroMsg.EditCropVideoPlugin", "release dismiss dialog");
      }
    }
    AppMethodBeat.o(75700);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75699);
    this.vlQ.release();
    AppMethodBeat.o(75699);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75696);
    this.vlP.setVisibility(paramInt);
    AppMethodBeat.o(75696);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onBackPress$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75684);
      k.h(paramAnimator, "animation");
      a.a(this.vlZ).setVisibility(8);
      a.a(this.vlZ).setAlpha(1.0F);
      AppMethodBeat.o(75684);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75685);
      k.h(paramAnimator, "animation");
      a.a(this.vlZ).setVisibility(8);
      a.a(this.vlZ).setAlpha(1.0F);
      AppMethodBeat.o(75685);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75686);
      k.h(paramAnimator, "animation");
      a.a(this.vlZ).setVisibility(8);
      a.a(this.vlZ).setAlpha(1.0F);
      AppMethodBeat.o(75686);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(a parama, boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(75687);
      if (a.b(this.vlZ) != null)
      {
        paramDialogInterface = a.b(this.vlZ);
        if (paramDialogInterface == null)
        {
          paramDialogInterface = new v("null cannot be cast to non-null type android.app.Dialog");
          AppMethodBeat.o(75687);
          throw paramDialogInterface;
        }
        if (((Dialog)paramDialogInterface).isShowing())
        {
          paramDialogInterface = a.b(this.vlZ);
          if (paramDialogInterface != null) {
            paramDialogInterface.dismiss();
          }
          ad.i("MicroMsg.EditCropVideoPlugin", "click ok dismiss dialog");
        }
      }
      ad.i("MicroMsg.EditCropVideoPlugin", "dialog ok isInstallWeSee:" + bool);
      paramDialogInterface = a.c(this.vlZ);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.gBj;
        if (paramDialogInterface == null) {
          break label272;
        }
        paramDialogInterface = a.c(this.vlZ);
        if (paramDialogInterface == null) {
          break label267;
        }
        paramDialogInterface = paramDialogInterface.gBj;
      }
      for (;;)
      {
        if (bool)
        {
          localObject = e.vtS;
          localObject = this.vlZ.fSZ.getContext();
          k.g(localObject, "parent.context");
          if (paramDialogInterface == null) {
            k.fvU();
          }
          k.h(localObject, "context");
          k.h(paramDialogInterface, "videoPath");
          String str = e.rV(ce.asR());
          q.a((Context)localObject, new Intent(), str, paramDialogInterface);
          paramDialogInterface = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.v("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(1));
          paramDialogInterface = new Intent();
          localObject = this.vlZ.fSZ.getContext();
          if (localObject == null)
          {
            paramDialogInterface = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(75687);
            throw paramDialogInterface;
            paramDialogInterface = null;
            break;
            label267:
            paramDialogInterface = null;
            continue;
            label272:
            paramDialogInterface = a.c(this.vlZ);
            if (paramDialogInterface != null)
            {
              paramDialogInterface = paramDialogInterface.gBn;
              continue;
            }
            paramDialogInterface = null;
            continue;
          }
          ((Activity)localObject).setResult(-2, paramDialogInterface);
          paramDialogInterface = this.vlZ.fSZ.getContext();
          if (paramDialogInterface == null)
          {
            paramDialogInterface = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(75687);
            throw paramDialogInterface;
          }
          ((Activity)paramDialogInterface).finish();
          ad.d("MicroMsg.EditCropVideoPlugin", "set RESULT_VIDEO_FINISH");
          AppMethodBeat.o(75687);
          return;
        }
      }
      Object localObject = WeSeeProvider.vfZ;
      paramDialogInterface = q.aCJ(paramDialogInterface);
      k.g(paramDialogInterface, "TakePhotoUtil.parseWeSeeUri(videoPath)");
      WeSeeProvider.a.aZ(paramDialogInterface, System.currentTimeMillis());
      paramDialogInterface = e.vtS;
      paramDialogInterface = this.vlZ.fSZ.getContext();
      k.g(paramDialogInterface, "parent.context");
      e.fL(paramDialogInterface);
      paramDialogInterface = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(3));
      AppMethodBeat.o(75687);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(a parama, boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(75688);
      if (bool)
      {
        paramDialogInterface = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(2));
      }
      for (;;)
      {
        ad.i("MicroMsg.EditCropVideoPlugin", "dialog cancel");
        if (a.b(this.vlZ) == null) {
          break label120;
        }
        paramDialogInterface = a.b(this.vlZ);
        if (paramDialogInterface != null) {
          break;
        }
        paramDialogInterface = new v("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(75688);
        throw paramDialogInterface;
        paramDialogInterface = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(4));
      }
      if (((Dialog)paramDialogInterface).isShowing())
      {
        paramDialogInterface = a.b(this.vlZ);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        ad.i("MicroMsg.EditCropVideoPlugin", "click no dismiss dialog");
      }
      label120:
      AppMethodBeat.o(75688);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a
 * JD-Core Version:    0.7.0.1
 */
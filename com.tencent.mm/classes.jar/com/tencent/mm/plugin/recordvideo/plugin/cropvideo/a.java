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
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.e.f;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.h;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropBtn", "Landroid/widget/ImageView;", "cropEnd", "", "cropRecyclerThumbSeekBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "cropStart", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "jumpHideAnimation", "", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "weseeArrowBtn", "weseeBtn", "weseeWrapper", "changeThumbBarPercent", "", "currentTime", "", "forceCropVideo", "isForce", "getSmaller", "a", "b", "getString", "", "resId", "name", "onBackPress", "onClick", "v", "Landroid/view/View;", "onDown", "left", "start", "end", "onMove", "onRecyclerChanged", "onUp", "release", "reset", "resetConfirmStyle", "bgStyleResId", "textColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setCaptureInfo", "setJumpHideAnimation", "jump", "setUIParams", "seekbarHeight", "bgResId", "setVisibility", "visibility", "showWeSeeBtn", "synCropInfo", "Companion", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, c.b, t
{
  public static final a.a wuE;
  ViewGroup fWU;
  private com.tencent.mm.ui.widget.a.d jaW;
  public RecordConfigProvider rRi;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d rTT;
  public com.tencent.mm.media.widget.camerarecordview.b.b wuA;
  public boolean wuB;
  private float wuC;
  public float wuD;
  private final ImageView wuv;
  public final EditVideoSeekBarView wuw;
  private final ViewGroup wux;
  private final ImageView wuy;
  private final ImageView wuz;
  
  static
  {
    AppMethodBeat.i(75702);
    wuE = new a.a((byte)0);
    AppMethodBeat.o(75702);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75701);
    this.fWU = paramViewGroup;
    this.rTT = paramd;
    paramViewGroup = this.fWU.findViewById(2131299289);
    k.g(paramViewGroup, "parent.findViewById(R.id.editor_crop_video)");
    this.wuv = ((ImageView)paramViewGroup);
    paramViewGroup = this.fWU.findViewById(2131299288);
    k.g(paramViewGroup, "parent.findViewById(R.id.editor_crop_bar)");
    this.wuw = ((EditVideoSeekBarView)paramViewGroup);
    this.wux = ((ViewGroup)this.fWU.findViewById(2131307099));
    this.wuy = ((ImageView)this.fWU.findViewById(2131301209));
    this.wuz = ((ImageView)this.fWU.findViewById(2131301226));
    this.wuD = 1.0F;
    this.wuv.setImageDrawable(am.k(this.fWU.getContext(), 2131690382, -1));
    this.wuv.setOnClickListener((View.OnClickListener)this);
    this.wuw.setCancelButtonClickListener((View.OnClickListener)this);
    this.wuw.setFinishButtonClickListener((View.OnClickListener)this);
    paramViewGroup = this.wuw.getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(75701);
      throw paramViewGroup;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramViewGroup;
    paramViewGroup.bottomMargin += ap.ej(this.fWU.getContext());
    this.wuw.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
    AppMethodBeat.o(75701);
  }
  
  private final void X(float paramFloat1, float paramFloat2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(75697);
    Object localObject = this.wuA;
    int k;
    float f2;
    int i;
    if (localObject != null)
    {
      k = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hbI - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).cSh;
      f2 = k;
      localObject = this.rRi;
      if (localObject == null) {
        k.fOy();
      }
      i = ((RecordConfigProvider)localObject).wqC;
      localObject = this.wuA;
      if (localObject == null) {
        k.fOy();
      }
      f2 = (paramFloat2 - paramFloat1) * f2 - gT(i + 250, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hbI);
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
      this.rTT.a(d.c.wwH, (Bundle)localObject);
      AppMethodBeat.o(75697);
      return;
      AppMethodBeat.o(75697);
      return;
      label195:
      f1 = f2;
    }
  }
  
  public static int gT(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private final String getString(int paramInt)
  {
    AppMethodBeat.i(75691);
    if (this.fWU.getContext() != null)
    {
      String str = this.fWU.getContext().getString(paramInt);
      k.g(str, "parent.context.getString(resId)");
      AppMethodBeat.o(75691);
      return str;
    }
    AppMethodBeat.o(75691);
    return "";
  }
  
  public final void Q(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75692);
    ac.d("MicroMsg.EditCropVideoPlugin", "onRecyclerChanged : " + paramFloat1 + ' ' + paramFloat2);
    this.wuC = paramFloat1;
    this.wuD = paramFloat2;
    X(paramFloat1, paramFloat2);
    AppMethodBeat.o(75692);
  }
  
  public final void R(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75693);
    ac.d("MicroMsg.EditCropVideoPlugin", "onDown : " + paramFloat1 + ' ' + paramFloat2);
    d.b.a(this.rTT, d.c.wwJ);
    AppMethodBeat.o(75693);
  }
  
  public final void S(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75694);
    ac.d("MicroMsg.EditCropVideoPlugin", "onUp : " + paramFloat1 + ' ' + paramFloat2);
    this.wuC = paramFloat1;
    this.wuD = paramFloat2;
    X(paramFloat1, paramFloat2);
    AppMethodBeat.o(75694);
  }
  
  public final void T(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75695);
    ac.d("MicroMsg.EditCropVideoPlugin", "onMove : " + paramFloat1 + ' ' + paramFloat2);
    AppMethodBeat.o(75695);
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(75698);
    ViewGroup localViewGroup = this.wux;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
    if (this.wuw.getVisibility() == 0)
    {
      d.b.a(this.rTT, d.c.wwL);
      this.wuw.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new b(this));
      AppMethodBeat.o(75698);
      return true;
    }
    AppMethodBeat.o(75698);
    return false;
  }
  
  public final void awk() {}
  
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
        this.wuw.uUk.reset();
        d.b.a(this.rTT, d.c.wwL);
        this.wuw.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new c(this));
        paramView = this.wux;
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
        X(this.wuC, this.wuD);
        d.b.a(this.rTT, d.c.wwM);
        if (!this.wuB) {
          this.wuw.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new d(this));
        }
        paramView = this.wux;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = this.wuA;
        if (paramView != null)
        {
          int i = paramView.hbI;
          int j = paramView.cSh;
          paramView = c.wyg;
          c.w("KEY_VIDEO_CROP_DURATION_MS_INT", Integer.valueOf((int)((i - j) * (this.wuD - this.wuC))));
          AppMethodBeat.o(75690);
          return;
        }
        AppMethodBeat.o(75690);
        return;
        label284:
        if (paramView.intValue() == 2131299289)
        {
          pr(false);
          paramView = c.wyg;
          c.aqO("KEY_CLICK_VIDEO_CROP_COUNT_INT");
          AppMethodBeat.o(75690);
          return;
        }
      }
    }
    final boolean bool;
    Context localContext;
    if (paramView.intValue() == 2131307099)
    {
      paramView = f.wDX;
      paramView = this.fWU.getContext();
      k.g(paramView, "parent.context");
      bool = f.fV(paramView);
      paramView = c.wyg;
      c.w("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(1));
      localContext = this.fWU.getContext();
      if (!bool) {
        break label445;
      }
    }
    label445:
    for (paramView = getString(2131755769);; paramView = getString(2131755767))
    {
      this.jaW = h.d(localContext, paramView, "", getString(2131755835), getString(2131755691), (DialogInterface.OnClickListener)new e(this, bool), (DialogInterface.OnClickListener)new f(this, bool));
      AppMethodBeat.o(75690);
      return;
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void pr(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(75689);
    this.wuw.setVisibility(0);
    ac.d("MicroMsg.EditCropVideoPlugin", "forceCropVideo isForce: ".concat(String.valueOf(paramBoolean)));
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = this.rRi;
      if ((localObject1 != null) && (((RecordConfigProvider)localObject1).scene == 2))
      {
        paramBoolean = TextUtils.equals((CharSequence)((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qae, "0"), (CharSequence)"1");
        boolean bool = ai.eUY().getBoolean("wesee_switch", false);
        ac.i("MicroMsg.EditCropVideoPlugin", "xSwitch: " + paramBoolean + ", commandSwitch:" + bool);
        if ((!paramBoolean) && (!bool)) {
          break label513;
        }
        localBundle.putBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", true);
        localObject1 = this.wux;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setVisibility(0);
        }
        localObject1 = this.wux;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)this);
        }
        localObject1 = this.wuy;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable(am.k(this.fWU.getContext(), 2131690503, -1));
        }
        localObject1 = this.wuz;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable(am.k(this.fWU.getContext(), 2131690349, -1));
        }
        localObject1 = this.wux;
        if (localObject1 != null)
        {
          localObject1 = ((ViewGroup)localObject1).getContext();
          if (!aj.aG((Context)localObject1)) {
            break label409;
          }
          localObject1 = this.wux;
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
        ViewGroup localViewGroup = this.wux;
        localObject1 = localObject2;
        if (localViewGroup != null) {
          localObject1 = localViewGroup.getContext();
        }
        localMarginLayoutParams.topMargin = (i + aj.aF((Context)localObject1));
        localObject1 = this.wux;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localMarginLayoutParams);
        }
        label409:
        localObject1 = WeSeeProvider.woL;
        WeSeeProvider.a.delete();
        localObject1 = c.wyg;
        c.w("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(1));
        localObject1 = f.wDX;
        localObject1 = this.fWU.getContext();
        k.g(localObject1, "parent.context");
        if (!f.fV((Context)localObject1)) {
          break label531;
        }
        localObject1 = c.wyg;
        c.w("KEY_IS_INSTALL_WESEE", Integer.valueOf(1));
      }
    }
    for (;;)
    {
      localObject1 = c.wyg;
      c.w("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(2));
      this.rTT.a(d.c.wwF, localBundle);
      AppMethodBeat.o(75689);
      return;
      label513:
      localObject1 = c.wyg;
      c.w("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(2));
      break;
      label531:
      localObject1 = c.wyg;
      c.w("KEY_IS_INSTALL_WESEE", Integer.valueOf(2));
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(75700);
    this.wuw.release();
    if (this.jaW != null)
    {
      Object localObject = this.jaW;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(75700);
        throw ((Throwable)localObject);
      }
      if (((Dialog)localObject).isShowing())
      {
        localObject = this.jaW;
        if (localObject != null) {
          ((com.tencent.mm.ui.widget.a.d)localObject).dismiss();
        }
        ac.i("MicroMsg.EditCropVideoPlugin", "release dismiss dialog");
      }
    }
    AppMethodBeat.o(75700);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75699);
    this.wuw.release();
    AppMethodBeat.o(75699);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75696);
    this.wuv.setVisibility(paramInt);
    AppMethodBeat.o(75696);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onBackPress$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75684);
      k.h(paramAnimator, "animation");
      a.a(this.wuF).setVisibility(8);
      a.a(this.wuF).setAlpha(1.0F);
      AppMethodBeat.o(75684);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75685);
      k.h(paramAnimator, "animation");
      a.a(this.wuF).setVisibility(8);
      a.a(this.wuF).setAlpha(1.0F);
      AppMethodBeat.o(75685);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75686);
      k.h(paramAnimator, "animation");
      a.a(this.wuF).setVisibility(8);
      a.a(this.wuF).setAlpha(1.0F);
      AppMethodBeat.o(75686);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(a parama, boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(75687);
      if (a.b(this.wuF) != null)
      {
        paramDialogInterface = a.b(this.wuF);
        if (paramDialogInterface == null)
        {
          paramDialogInterface = new v("null cannot be cast to non-null type android.app.Dialog");
          AppMethodBeat.o(75687);
          throw paramDialogInterface;
        }
        if (((Dialog)paramDialogInterface).isShowing())
        {
          paramDialogInterface = a.b(this.wuF);
          if (paramDialogInterface != null) {
            paramDialogInterface.dismiss();
          }
          ac.i("MicroMsg.EditCropVideoPlugin", "click ok dismiss dialog");
        }
      }
      ac.i("MicroMsg.EditCropVideoPlugin", "dialog ok isInstallWeSee:" + bool);
      paramDialogInterface = a.c(this.wuF);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.hbF;
        if (paramDialogInterface == null) {
          break label272;
        }
        paramDialogInterface = a.c(this.wuF);
        if (paramDialogInterface == null) {
          break label267;
        }
        paramDialogInterface = paramDialogInterface.hbF;
      }
      for (;;)
      {
        if (bool)
        {
          localObject = f.wDX;
          localObject = this.wuF.fWU.getContext();
          k.g(localObject, "parent.context");
          if (paramDialogInterface == null) {
            k.fOy();
          }
          k.h(localObject, "context");
          k.h(paramDialogInterface, "videoPath");
          String str = f.wy(ce.azI());
          q.a((Context)localObject, new Intent(), str, paramDialogInterface);
          paramDialogInterface = c.wyg;
          c.w("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(1));
          paramDialogInterface = new Intent();
          localObject = this.wuF.fWU.getContext();
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
            paramDialogInterface = a.c(this.wuF);
            if (paramDialogInterface != null)
            {
              paramDialogInterface = paramDialogInterface.hbJ;
              continue;
            }
            paramDialogInterface = null;
            continue;
          }
          ((Activity)localObject).setResult(-2, paramDialogInterface);
          paramDialogInterface = this.wuF.fWU.getContext();
          if (paramDialogInterface == null)
          {
            paramDialogInterface = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(75687);
            throw paramDialogInterface;
          }
          ((Activity)paramDialogInterface).finish();
          ac.d("MicroMsg.EditCropVideoPlugin", "set RESULT_VIDEO_FINISH");
          AppMethodBeat.o(75687);
          return;
        }
      }
      Object localObject = WeSeeProvider.woL;
      paramDialogInterface = q.aIb(paramDialogInterface);
      k.g(paramDialogInterface, "TakePhotoUtil.parseWeSeeUri(videoPath)");
      WeSeeProvider.a.bb(paramDialogInterface, System.currentTimeMillis());
      paramDialogInterface = f.wDX;
      paramDialogInterface = this.wuF.fWU.getContext();
      k.g(paramDialogInterface, "parent.context");
      f.fW(paramDialogInterface);
      paramDialogInterface = c.wyg;
      c.w("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(3));
      AppMethodBeat.o(75687);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(a parama, boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(75688);
      if (bool)
      {
        paramDialogInterface = c.wyg;
        c.w("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(2));
      }
      for (;;)
      {
        ac.i("MicroMsg.EditCropVideoPlugin", "dialog cancel");
        if (a.b(this.wuF) == null) {
          break label120;
        }
        paramDialogInterface = a.b(this.wuF);
        if (paramDialogInterface != null) {
          break;
        }
        paramDialogInterface = new v("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(75688);
        throw paramDialogInterface;
        paramDialogInterface = c.wyg;
        c.w("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(4));
      }
      if (((Dialog)paramDialogInterface).isShowing())
      {
        paramDialogInterface = a.b(this.wuF);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        ac.i("MicroMsg.EditCropVideoPlugin", "click no dismiss dialog");
      }
      label120:
      AppMethodBeat.o(75688);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a
 * JD-Core Version:    0.7.0.1
 */
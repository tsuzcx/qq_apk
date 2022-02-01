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
import com.tencent.mm.model.ch;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.e.f;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropBtn", "Landroid/widget/ImageView;", "cropEnd", "", "cropRecyclerThumbSeekBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "cropStart", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "jumpHideAnimation", "", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "sourceVideoPath", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "weseeArrowBtn", "weseeBtn", "weseeWrapper", "changeThumbBarPercent", "", "currentTime", "", "forceCropVideo", "isForce", "getSmaller", "a", "b", "getString", "resId", "name", "onBackPress", "onClick", "v", "Landroid/view/View;", "onDown", "left", "start", "end", "onMove", "onRecyclerChanged", "onUp", "release", "reset", "resetConfirmStyle", "bgStyleResId", "textColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setCaptureInfo", "captureInfo", "setJumpHideAnimation", "jump", "setUIParams", "seekbarHeight", "bgResId", "setVisibility", "visibility", "showWeSeeBtn", "startLoadThumbBitmap", "synCropInfo", "Companion", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, c.b, t
{
  public static final a.a xSv;
  ViewGroup gsV;
  private String hwB;
  private com.tencent.mm.ui.widget.a.d jxa;
  public RecordConfigProvider sYT;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d tbP;
  private final ImageView xSm;
  public final EditVideoSeekBarView xSn;
  private final ViewGroup xSo;
  private final ImageView xSp;
  private final ImageView xSq;
  public com.tencent.mm.media.widget.camerarecordview.b.b xSr;
  public boolean xSs;
  private float xSt;
  private float xSu;
  
  static
  {
    AppMethodBeat.i(75702);
    xSv = new a.a((byte)0);
    AppMethodBeat.o(75702);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75701);
    this.gsV = paramViewGroup;
    this.tbP = paramd;
    paramViewGroup = this.gsV.findViewById(2131299289);
    p.g(paramViewGroup, "parent.findViewById(R.id.editor_crop_video)");
    this.xSm = ((ImageView)paramViewGroup);
    paramViewGroup = this.gsV.findViewById(2131299288);
    p.g(paramViewGroup, "parent.findViewById(R.id.editor_crop_bar)");
    this.xSn = ((EditVideoSeekBarView)paramViewGroup);
    this.xSo = ((ViewGroup)this.gsV.findViewById(2131307099));
    this.xSp = ((ImageView)this.gsV.findViewById(2131301209));
    this.xSq = ((ImageView)this.gsV.findViewById(2131301226));
    this.xSu = 1.0F;
    this.hwB = "";
    this.xSm.setImageDrawable(ao.k(this.gsV.getContext(), 2131690382, -1));
    this.xSm.setOnClickListener((View.OnClickListener)this);
    this.xSn.setCancelButtonClickListener((View.OnClickListener)this);
    this.xSn.setFinishButtonClickListener((View.OnClickListener)this);
    paramViewGroup = this.xSn.getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(75701);
      throw paramViewGroup;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramViewGroup;
    paramViewGroup.bottomMargin += ar.en(this.gsV.getContext());
    this.xSn.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
    AppMethodBeat.o(75701);
  }
  
  private final void Z(float paramFloat1, float paramFloat2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(75697);
    Object localObject = this.xSr;
    int k;
    float f2;
    int i;
    if (localObject != null)
    {
      k = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hwE - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).dez;
      f2 = k;
      localObject = this.sYT;
      if (localObject == null) {
        p.gkB();
      }
      i = ((RecordConfigProvider)localObject).xOp;
      localObject = this.xSr;
      if (localObject == null) {
        p.gkB();
      }
      f2 = (paramFloat2 - paramFloat1) * f2 - hm(i + 250, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).hwE);
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
      this.tbP.a(d.c.xUL, (Bundle)localObject);
      AppMethodBeat.o(75697);
      return;
      AppMethodBeat.o(75697);
      return;
      label195:
      f1 = f2;
    }
  }
  
  private final String getString(int paramInt)
  {
    AppMethodBeat.i(75691);
    if (this.gsV.getContext() != null)
    {
      String str = this.gsV.getContext().getString(paramInt);
      p.g(str, "parent.context.getString(resId)");
      AppMethodBeat.o(75691);
      return str;
    }
    AppMethodBeat.o(75691);
    return "";
  }
  
  private static int hm(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public final void S(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75692);
    ae.d("MicroMsg.EditCropVideoPlugin", "onRecyclerChanged : " + paramFloat1 + ' ' + paramFloat2);
    this.xSt = paramFloat1;
    this.xSu = paramFloat2;
    Z(paramFloat1, paramFloat2);
    AppMethodBeat.o(75692);
  }
  
  public final void T(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75693);
    ae.d("MicroMsg.EditCropVideoPlugin", "onDown : " + paramFloat1 + ' ' + paramFloat2);
    d.b.a(this.tbP, d.c.xUN);
    AppMethodBeat.o(75693);
  }
  
  public final void U(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75694);
    ae.d("MicroMsg.EditCropVideoPlugin", "onUp : " + paramFloat1 + ' ' + paramFloat2);
    this.xSt = paramFloat1;
    this.xSu = paramFloat2;
    Z(paramFloat1, paramFloat2);
    AppMethodBeat.o(75694);
  }
  
  public final void V(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75695);
    ae.d("MicroMsg.EditCropVideoPlugin", "onMove : " + paramFloat1 + ' ' + paramFloat2);
    AppMethodBeat.o(75695);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(75698);
    ViewGroup localViewGroup = this.xSo;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
    if (this.xSn.getVisibility() == 0)
    {
      d.b.a(this.tbP, d.c.xUP);
      this.xSn.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new b(this));
      AppMethodBeat.o(75698);
      return true;
    }
    AppMethodBeat.o(75698);
    return false;
  }
  
  public final void azm() {}
  
  public final String name()
  {
    return "plugin_video_crop";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75690);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label98;
      }
      label58:
      if (paramView != null) {
        break label178;
      }
      label62:
      if (paramView != null) {
        break label314;
      }
      label66:
      if (paramView != null) {
        break label341;
      }
    }
    label98:
    while (paramView.intValue() != 2131307099) {
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(75690);
        return;
        paramView = null;
        break;
        if (paramView.intValue() != 2131299263) {
          break label58;
        }
        this.xSn.wjy.reset();
        d.b.a(this.tbP, d.c.xUP);
        this.xSn.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new c(this));
        paramView = this.xSo;
        if (paramView != null)
        {
          paramView.setVisibility(8);
          continue;
          if (paramView.intValue() != 2131299265) {
            break label62;
          }
          Z(this.xSt, this.xSu);
          d.b.a(this.tbP, d.c.xUQ);
          if (!this.xSs) {
            this.xSn.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new d(this));
          }
          paramView = this.xSo;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
          paramView = this.xSr;
          if (paramView != null)
          {
            int i = paramView.hwE;
            int j = paramView.dez;
            paramView = c.xWV;
            c.u("KEY_VIDEO_CROP_DURATION_MS_INT", Integer.valueOf((int)((i - j) * (this.xSu - this.xSt))));
            continue;
            if (paramView.intValue() != 2131299289) {
              break label66;
            }
            pV(false);
            paramView = c.xWV;
            c.axc("KEY_CLICK_VIDEO_CROP_COUNT_INT");
          }
        }
      }
    }
    label178:
    label314:
    label341:
    paramView = f.yhx;
    paramView = this.gsV.getContext();
    p.g(paramView, "parent.context");
    final boolean bool = f.gg(paramView);
    paramView = c.xWV;
    c.u("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(1));
    localObject = this.gsV.getContext();
    if (bool) {}
    for (paramView = getString(2131755769);; paramView = getString(2131755767))
    {
      this.jxa = h.e((Context)localObject, paramView, "", getString(2131755835), getString(2131755691), (DialogInterface.OnClickListener)new e(this, bool), (DialogInterface.OnClickListener)new f(this, bool));
      break;
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206625);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206625);
  }
  
  public final void onResume() {}
  
  public final void pV(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(75689);
    Object localObject3 = this.hwB;
    Object localObject1 = this.xSr;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwB;
      if ((p.i(localObject3, localObject1) ^ true))
      {
        localObject1 = this.xSr;
        if (localObject1 != null)
        {
          this.hwB = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwB;
          localObject3 = this.xSn;
          localObject4 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwB;
          localObject5 = this.sYT;
          if (localObject5 == null) {
            p.gkB();
          }
          int j = hm(((RecordConfigProvider)localObject5).xOp, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwE);
          localObject5 = this.sYT;
          if (localObject5 == null) {
            p.gkB();
          }
          localObject5 = ((RecordConfigProvider)localObject5).xOg;
          if (localObject5 == null) {
            break label600;
          }
          i = ((VideoTransPara)localObject5).minDuration;
          label138:
          p.h(localObject4, "path");
          if (!((EditVideoSeekBarView)localObject3).hasInit)
          {
            ((EditVideoSeekBarView)localObject3).hasInit = true;
            ((EditVideoSeekBarView)localObject3).wjy.arV((String)localObject4);
            localObject4 = new VideoTransPara();
            ((VideoTransPara)localObject4).duration = (j / 1000);
            ((VideoTransPara)localObject4).minDuration = i;
            ((EditVideoSeekBarView)localObject3).wjy.setVideoTransPara((VideoTransPara)localObject4);
            ((EditVideoSeekBarView)localObject3).wjy.setOnPreparedListener((c.a)EditVideoSeekBarView.b.xSz);
          }
          this.xSn.setThumbBarSeekListener((c.b)this);
          localObject3 = this.sYT;
          if (localObject3 == null) {
            p.gkB();
          }
          this.xSu = (hm(((RecordConfigProvider)localObject3).xOp, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwE) * 1.0F / ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).hwE);
        }
      }
      this.xSn.setVisibility(0);
      ae.d("MicroMsg.EditCropVideoPlugin", "forceCropVideo isForce: ".concat(String.valueOf(paramBoolean)));
      localObject3 = new Bundle();
      if (!paramBoolean) {
        break label768;
      }
      localObject1 = this.sYT;
      if ((localObject1 == null) || (((RecordConfigProvider)localObject1).scene != 2)) {
        break label768;
      }
      paramBoolean = TextUtils.equals((CharSequence)((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNf, "0"), (CharSequence)"1");
      boolean bool = ak.fox().getBoolean("wesee_switch", false);
      ae.i("MicroMsg.EditCropVideoPlugin", "xSwitch: " + paramBoolean + ", commandSwitch:" + bool);
      if ((!paramBoolean) && (!bool)) {
        break label789;
      }
      ((Bundle)localObject3).putBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", true);
      localObject1 = this.xSo;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(0);
      }
      localObject1 = this.xSo;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)this);
      }
      localObject1 = this.xSp;
      if (localObject1 != null) {
        ((ImageView)localObject1).setImageDrawable(ao.k(this.gsV.getContext(), 2131690503, -1));
      }
      localObject1 = this.xSq;
      if (localObject1 != null) {
        ((ImageView)localObject1).setImageDrawable(ao.k(this.gsV.getContext(), 2131690349, -1));
      }
      localObject1 = this.xSo;
      if (localObject1 == null) {
        break label605;
      }
      localObject1 = ((ViewGroup)localObject1).getContext();
      label542:
      if (!al.aH((Context)localObject1)) {
        break label685;
      }
      localObject1 = this.xSo;
      if (localObject1 == null) {
        break label611;
      }
    }
    label600:
    label605:
    label611:
    for (localObject1 = ((ViewGroup)localObject1).getLayoutParams();; localObject1 = null)
    {
      if (localObject1 != null) {
        break label617;
      }
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(75689);
      throw ((Throwable)localObject1);
      localObject1 = null;
      break;
      i = 0;
      break label138;
      localObject1 = null;
      break label542;
    }
    label617:
    Object localObject4 = (ViewGroup.MarginLayoutParams)localObject1;
    int i = ((ViewGroup.MarginLayoutParams)localObject4).topMargin;
    Object localObject5 = this.xSo;
    localObject1 = localObject2;
    if (localObject5 != null) {
      localObject1 = ((ViewGroup)localObject5).getContext();
    }
    ((ViewGroup.MarginLayoutParams)localObject4).topMargin = (i + al.aG((Context)localObject1));
    localObject1 = this.xSo;
    if (localObject1 != null) {
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    }
    label685:
    localObject1 = WeSeeProvider.xMy;
    WeSeeProvider.a.delete();
    localObject1 = c.xWV;
    c.u("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(1));
    localObject1 = f.yhx;
    localObject1 = this.gsV.getContext();
    p.g(localObject1, "parent.context");
    if (f.gg((Context)localObject1))
    {
      localObject1 = c.xWV;
      c.u("KEY_IS_INSTALL_WESEE", Integer.valueOf(1));
    }
    for (;;)
    {
      localObject1 = c.xWV;
      c.u("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(2));
      label768:
      this.tbP.a(d.c.xUJ, (Bundle)localObject3);
      AppMethodBeat.o(75689);
      return;
      label789:
      localObject1 = c.xWV;
      c.u("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(2));
      break;
      localObject1 = c.xWV;
      c.u("KEY_IS_INSTALL_WESEE", Integer.valueOf(2));
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(75700);
    this.xSn.release();
    if (this.jxa != null)
    {
      Object localObject = this.jxa;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(75700);
        throw ((Throwable)localObject);
      }
      if (((Dialog)localObject).isShowing())
      {
        localObject = this.jxa;
        if (localObject != null) {
          ((com.tencent.mm.ui.widget.a.d)localObject).dismiss();
        }
        ae.i("MicroMsg.EditCropVideoPlugin", "release dismiss dialog");
      }
    }
    AppMethodBeat.o(75700);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75699);
    this.hwB = "";
    this.xSn.release();
    AppMethodBeat.o(75699);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75696);
    this.xSm.setVisibility(paramInt);
    AppMethodBeat.o(75696);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onBackPress$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75684);
      p.h(paramAnimator, "animation");
      a.a(this.xSw).setVisibility(8);
      a.a(this.xSw).setAlpha(1.0F);
      AppMethodBeat.o(75684);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75685);
      p.h(paramAnimator, "animation");
      a.a(this.xSw).setVisibility(8);
      a.a(this.xSw).setAlpha(1.0F);
      AppMethodBeat.o(75685);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75686);
      p.h(paramAnimator, "animation");
      a.a(this.xSw).setVisibility(8);
      a.a(this.xSw).setAlpha(1.0F);
      AppMethodBeat.o(75686);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(a parama, boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(75687);
      if (a.b(this.xSw) != null)
      {
        paramDialogInterface = a.b(this.xSw);
        if (paramDialogInterface == null)
        {
          paramDialogInterface = new v("null cannot be cast to non-null type android.app.Dialog");
          AppMethodBeat.o(75687);
          throw paramDialogInterface;
        }
        if (((Dialog)paramDialogInterface).isShowing())
        {
          paramDialogInterface = a.b(this.xSw);
          if (paramDialogInterface != null) {
            paramDialogInterface.dismiss();
          }
          ae.i("MicroMsg.EditCropVideoPlugin", "click ok dismiss dialog");
        }
      }
      ae.i("MicroMsg.EditCropVideoPlugin", "dialog ok isInstallWeSee:" + bool);
      paramDialogInterface = a.c(this.xSw);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.hwB;
        if (paramDialogInterface == null) {
          break label272;
        }
        paramDialogInterface = a.c(this.xSw);
        if (paramDialogInterface == null) {
          break label267;
        }
        paramDialogInterface = paramDialogInterface.hwB;
      }
      for (;;)
      {
        if (bool)
        {
          localObject = f.yhx;
          localObject = this.xSw.gsV.getContext();
          p.g(localObject, "parent.context");
          if (paramDialogInterface == null) {
            p.gkB();
          }
          p.h(localObject, "context");
          p.h(paramDialogInterface, "videoPath");
          String str = f.zq(ch.aDb());
          q.a((Context)localObject, new Intent(), str, paramDialogInterface);
          paramDialogInterface = c.xWV;
          c.u("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(1));
          paramDialogInterface = new Intent();
          localObject = this.xSw.gsV.getContext();
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
            paramDialogInterface = a.c(this.xSw);
            if (paramDialogInterface != null)
            {
              paramDialogInterface = paramDialogInterface.hwF;
              continue;
            }
            paramDialogInterface = null;
            continue;
          }
          ((Activity)localObject).setResult(-2, paramDialogInterface);
          paramDialogInterface = this.xSw.gsV.getContext();
          if (paramDialogInterface == null)
          {
            paramDialogInterface = new v("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(75687);
            throw paramDialogInterface;
          }
          ((Activity)paramDialogInterface).finish();
          ae.d("MicroMsg.EditCropVideoPlugin", "set RESULT_VIDEO_FINISH");
          AppMethodBeat.o(75687);
          return;
        }
      }
      Object localObject = WeSeeProvider.xMy;
      paramDialogInterface = q.aPa(paramDialogInterface);
      p.g(paramDialogInterface, "TakePhotoUtil.parseWeSeeUri(videoPath)");
      WeSeeProvider.a.be(paramDialogInterface, System.currentTimeMillis());
      paramDialogInterface = f.yhx;
      paramDialogInterface = this.xSw.gsV.getContext();
      p.g(paramDialogInterface, "parent.context");
      f.gh(paramDialogInterface);
      paramDialogInterface = c.xWV;
      c.u("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(3));
      AppMethodBeat.o(75687);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(a parama, boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(75688);
      if (bool)
      {
        paramDialogInterface = c.xWV;
        c.u("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(2));
      }
      for (;;)
      {
        ae.i("MicroMsg.EditCropVideoPlugin", "dialog cancel");
        if (a.b(this.xSw) == null) {
          break label120;
        }
        paramDialogInterface = a.b(this.xSw);
        if (paramDialogInterface != null) {
          break;
        }
        paramDialogInterface = new v("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(75688);
        throw paramDialogInterface;
        paramDialogInterface = c.xWV;
        c.u("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(4));
      }
      if (((Dialog)paramDialogInterface).isShowing())
      {
        paramDialogInterface = a.b(this.xSw);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        ae.i("MicroMsg.EditCropVideoPlugin", "click no dismiss dialog");
      }
      label120:
      AppMethodBeat.o(75688);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a
 * JD-Core Version:    0.7.0.1
 */
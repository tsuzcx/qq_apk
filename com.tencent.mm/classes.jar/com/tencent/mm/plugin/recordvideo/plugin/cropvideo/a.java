package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
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
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropBtn", "Landroid/widget/ImageView;", "cropEnd", "", "cropRecyclerThumbSeekBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "cropStart", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "jumpHideAnimation", "", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "weseeArrowBtn", "weseeBtn", "weseeWrapper", "changeThumbBarPercent", "", "currentTime", "", "forceCropVideo", "isForce", "getSmaller", "a", "b", "getString", "", "resId", "name", "onBackPress", "onClick", "v", "Landroid/view/View;", "onDown", "left", "start", "end", "onMove", "onRecyclerChanged", "onUp", "release", "reset", "resetConfirmStyle", "bgStyleResId", "textColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setCaptureInfo", "setJumpHideAnimation", "jump", "setUIParams", "seekbarHeight", "bgResId", "setVisibility", "visibility", "showWeSeeBtn", "synCropInfo", "Companion", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, c.b, t
{
  public static final a.a xCA;
  ViewGroup gqv;
  private com.tencent.mm.ui.widget.a.d juf;
  public RecordConfigProvider sNI;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d sQE;
  private final ImageView xCr;
  public final EditVideoSeekBarView xCs;
  private final ViewGroup xCt;
  private final ImageView xCu;
  private final ImageView xCv;
  public com.tencent.mm.media.widget.camerarecordview.b.b xCw;
  public boolean xCx;
  private float xCy;
  public float xCz;
  
  static
  {
    AppMethodBeat.i(75702);
    xCA = new a.a((byte)0);
    AppMethodBeat.o(75702);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75701);
    this.gqv = paramViewGroup;
    this.sQE = paramd;
    paramViewGroup = this.gqv.findViewById(2131299289);
    p.g(paramViewGroup, "parent.findViewById(R.id.editor_crop_video)");
    this.xCr = ((ImageView)paramViewGroup);
    paramViewGroup = this.gqv.findViewById(2131299288);
    p.g(paramViewGroup, "parent.findViewById(R.id.editor_crop_bar)");
    this.xCs = ((EditVideoSeekBarView)paramViewGroup);
    this.xCt = ((ViewGroup)this.gqv.findViewById(2131307099));
    this.xCu = ((ImageView)this.gqv.findViewById(2131301209));
    this.xCv = ((ImageView)this.gqv.findViewById(2131301226));
    this.xCz = 1.0F;
    this.xCr.setImageDrawable(ao.k(this.gqv.getContext(), 2131690382, -1));
    this.xCr.setOnClickListener((View.OnClickListener)this);
    this.xCs.setCancelButtonClickListener((View.OnClickListener)this);
    this.xCs.setFinishButtonClickListener((View.OnClickListener)this);
    paramViewGroup = this.xCs.getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(75701);
      throw paramViewGroup;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramViewGroup;
    paramViewGroup.bottomMargin += ar.ej(this.gqv.getContext());
    this.xCs.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
    AppMethodBeat.o(75701);
  }
  
  private final void Z(float paramFloat1, float paramFloat2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(75697);
    Object localObject = this.xCw;
    int k;
    float f2;
    int i;
    if (localObject != null)
    {
      k = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).htQ - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).ddx;
      f2 = k;
      localObject = this.sNI;
      if (localObject == null) {
        p.gfZ();
      }
      i = ((RecordConfigProvider)localObject).xyt;
      localObject = this.xCw;
      if (localObject == null) {
        p.gfZ();
      }
      f2 = (paramFloat2 - paramFloat1) * f2 - hk(i + 250, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).htQ);
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
      this.sQE.a(d.c.xEQ, (Bundle)localObject);
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
    if (this.gqv.getContext() != null)
    {
      String str = this.gqv.getContext().getString(paramInt);
      p.g(str, "parent.context.getString(resId)");
      AppMethodBeat.o(75691);
      return str;
    }
    AppMethodBeat.o(75691);
    return "";
  }
  
  public static int hk(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public final void S(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75692);
    ad.d("MicroMsg.EditCropVideoPlugin", "onRecyclerChanged : " + paramFloat1 + ' ' + paramFloat2);
    this.xCy = paramFloat1;
    this.xCz = paramFloat2;
    Z(paramFloat1, paramFloat2);
    AppMethodBeat.o(75692);
  }
  
  public final void T(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75693);
    ad.d("MicroMsg.EditCropVideoPlugin", "onDown : " + paramFloat1 + ' ' + paramFloat2);
    d.b.a(this.sQE, d.c.xES);
    AppMethodBeat.o(75693);
  }
  
  public final void U(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75694);
    ad.d("MicroMsg.EditCropVideoPlugin", "onUp : " + paramFloat1 + ' ' + paramFloat2);
    this.xCy = paramFloat1;
    this.xCz = paramFloat2;
    Z(paramFloat1, paramFloat2);
    AppMethodBeat.o(75694);
  }
  
  public final void V(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75695);
    ad.d("MicroMsg.EditCropVideoPlugin", "onMove : " + paramFloat1 + ' ' + paramFloat2);
    AppMethodBeat.o(75695);
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(75698);
    ViewGroup localViewGroup = this.xCt;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
    if (this.xCs.getVisibility() == 0)
    {
      d.b.a(this.sQE, d.c.xEU);
      this.xCs.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new b(this));
      AppMethodBeat.o(75698);
      return true;
    }
    AppMethodBeat.o(75698);
    return false;
  }
  
  public final void ayX() {}
  
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
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
        this.xCs.vXu.reset();
        d.b.a(this.sQE, d.c.xEU);
        this.xCs.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new c(this));
        paramView = this.xCt;
        if (paramView != null)
        {
          paramView.setVisibility(8);
          continue;
          if (paramView.intValue() != 2131299265) {
            break label62;
          }
          Z(this.xCy, this.xCz);
          d.b.a(this.sQE, d.c.xEV);
          if (!this.xCx) {
            this.xCs.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new d(this));
          }
          paramView = this.xCt;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
          paramView = this.xCw;
          if (paramView != null)
          {
            int i = paramView.htQ;
            int j = paramView.ddx;
            paramView = c.xHa;
            c.u("KEY_VIDEO_CROP_DURATION_MS_INT", Integer.valueOf((int)((i - j) * (this.xCz - this.xCy))));
            continue;
            if (paramView.intValue() != 2131299289) {
              break label66;
            }
            pN(false);
            paramView = c.xHa;
            c.avN("KEY_CLICK_VIDEO_CROP_COUNT_INT");
          }
        }
      }
    }
    label178:
    label314:
    label341:
    paramView = f.xRE;
    paramView = this.gqv.getContext();
    p.g(paramView, "parent.context");
    boolean bool = f.ga(paramView);
    paramView = c.xHa;
    c.u("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(1));
    localObject = this.gqv.getContext();
    if (bool) {}
    for (paramView = getString(2131755769);; paramView = getString(2131755767))
    {
      this.juf = h.e((Context)localObject, paramView, "", getString(2131755835), getString(2131755691), (DialogInterface.OnClickListener)new a.e(this, bool), (DialogInterface.OnClickListener)new a.f(this, bool));
      break;
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200364);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200364);
  }
  
  public final void onResume() {}
  
  public final void pN(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(75689);
    this.xCs.setVisibility(0);
    ad.d("MicroMsg.EditCropVideoPlugin", "forceCropVideo isForce: ".concat(String.valueOf(paramBoolean)));
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = this.sNI;
      if ((localObject1 != null) && (((RecordConfigProvider)localObject1).scene == 2))
      {
        paramBoolean = TextUtils.equals((CharSequence)((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFz, "0"), (CharSequence)"1");
        boolean bool = aj.fkD().getBoolean("wesee_switch", false);
        ad.i("MicroMsg.EditCropVideoPlugin", "xSwitch: " + paramBoolean + ", commandSwitch:" + bool);
        if ((!paramBoolean) && (!bool)) {
          break label513;
        }
        localBundle.putBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", true);
        localObject1 = this.xCt;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setVisibility(0);
        }
        localObject1 = this.xCt;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)this);
        }
        localObject1 = this.xCu;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable(ao.k(this.gqv.getContext(), 2131690503, -1));
        }
        localObject1 = this.xCv;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable(ao.k(this.gqv.getContext(), 2131690349, -1));
        }
        localObject1 = this.xCt;
        if (localObject1 != null)
        {
          localObject1 = ((ViewGroup)localObject1).getContext();
          if (!al.aG((Context)localObject1)) {
            break label409;
          }
          localObject1 = this.xCt;
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
        ViewGroup localViewGroup = this.xCt;
        localObject1 = localObject2;
        if (localViewGroup != null) {
          localObject1 = localViewGroup.getContext();
        }
        localMarginLayoutParams.topMargin = (i + al.aF((Context)localObject1));
        localObject1 = this.xCt;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localMarginLayoutParams);
        }
        label409:
        localObject1 = WeSeeProvider.xwB;
        WeSeeProvider.a.delete();
        localObject1 = c.xHa;
        c.u("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(1));
        localObject1 = f.xRE;
        localObject1 = this.gqv.getContext();
        p.g(localObject1, "parent.context");
        if (!f.ga((Context)localObject1)) {
          break label531;
        }
        localObject1 = c.xHa;
        c.u("KEY_IS_INSTALL_WESEE", Integer.valueOf(1));
      }
    }
    for (;;)
    {
      localObject1 = c.xHa;
      c.u("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(2));
      this.sQE.a(d.c.xEO, localBundle);
      AppMethodBeat.o(75689);
      return;
      label513:
      localObject1 = c.xHa;
      c.u("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(2));
      break;
      label531:
      localObject1 = c.xHa;
      c.u("KEY_IS_INSTALL_WESEE", Integer.valueOf(2));
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(75700);
    this.xCs.release();
    if (this.juf != null)
    {
      Object localObject = this.juf;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(75700);
        throw ((Throwable)localObject);
      }
      if (((Dialog)localObject).isShowing())
      {
        localObject = this.juf;
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
    this.xCs.release();
    AppMethodBeat.o(75699);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75696);
    this.xCr.setVisibility(paramInt);
    AppMethodBeat.o(75696);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onBackPress$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75684);
      p.h(paramAnimator, "animation");
      a.a(this.xCB).setVisibility(8);
      a.a(this.xCB).setAlpha(1.0F);
      AppMethodBeat.o(75684);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75685);
      p.h(paramAnimator, "animation");
      a.a(this.xCB).setVisibility(8);
      a.a(this.xCB).setAlpha(1.0F);
      AppMethodBeat.o(75685);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75686);
      p.h(paramAnimator, "animation");
      a.a(this.xCB).setVisibility(8);
      a.a(this.xCB).setAlpha(1.0F);
      AppMethodBeat.o(75686);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a
 * JD-Core Version:    0.7.0.1
 */
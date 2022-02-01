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
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.e.i;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropBtn", "Landroid/widget/ImageView;", "cropEnd", "", "cropRecyclerThumbSeekBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "cropStart", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "entranceNum", "", "finderEnable", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "jumpHideAnimation", "longVideoTv", "Landroid/widget/TextView;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "phoenixDialog", "secondCutEnable", "sourceVideoPath", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "weseeArrowBtn", "weseeBtn", "weseeEnable", "weseeWrapper", "changeThumbBarPercent", "", "currentTime", "forceCropVideo", "isForce", "getSmaller", "a", "b", "getString", "resId", "name", "onBackPress", "onClick", "v", "Landroid/view/View;", "onClickFinder", "onClickSecondCut", "onClickWesee", "onDown", "left", "start", "end", "onMove", "onRecyclerChanged", "onUp", "release", "reset", "resetConfirmStyle", "bgStyleResId", "textColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setCaptureInfo", "captureInfo", "setJumpHideAnimation", "jump", "setUIParams", "seekbarHeight", "bgResId", "setVisibility", "visibility", "showBottomSheet", "showWeSeeBtn", "startLoadThumbBitmap", "synCropInfo", "Companion", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, c.b, com.tencent.mm.plugin.recordvideo.plugin.t
{
  public static final a.a BSG;
  private float BSA;
  private float BSB;
  private boolean BSC;
  private boolean BSD;
  private boolean BSE;
  private int BSF;
  private final ImageView BSr;
  public final EditVideoSeekBarView BSs;
  private final ViewGroup BSt;
  private final ImageView BSu;
  private final ImageView BSv;
  private final TextView BSw;
  public com.tencent.mm.media.widget.camerarecordview.b.b BSx;
  private com.tencent.mm.ui.widget.a.d BSy;
  public boolean BSz;
  private String iqd;
  private com.tencent.mm.ui.widget.a.d kvo;
  ViewGroup parent;
  public RecordConfigProvider wdm;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
  
  static
  {
    AppMethodBeat.i(75702);
    BSG = new a.a((byte)0);
    AppMethodBeat.o(75702);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75701);
    this.parent = paramViewGroup;
    this.wgr = paramd;
    paramViewGroup = this.parent.findViewById(2131299879);
    p.g(paramViewGroup, "parent.findViewById(R.id.editor_crop_video)");
    this.BSr = ((ImageView)paramViewGroup);
    paramViewGroup = this.parent.findViewById(2131299878);
    p.g(paramViewGroup, "parent.findViewById(R.id.editor_crop_bar)");
    this.BSs = ((EditVideoSeekBarView)paramViewGroup);
    this.BSt = ((ViewGroup)this.parent.findViewById(2131310624));
    this.BSu = ((ImageView)this.parent.findViewById(2131302889));
    this.BSv = ((ImageView)this.parent.findViewById(2131302914));
    this.BSw = ((TextView)this.parent.findViewById(2131309478));
    this.BSB = 1.0F;
    this.iqd = "";
    this.BSr.setImageDrawable(ar.m(this.parent.getContext(), 2131690526, -1));
    this.BSr.setOnClickListener((View.OnClickListener)this);
    this.BSs.setCancelButtonClickListener((View.OnClickListener)this);
    this.BSs.setFinishButtonClickListener((View.OnClickListener)this);
    paramViewGroup = this.BSs.getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(75701);
      throw paramViewGroup;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramViewGroup;
    paramViewGroup.bottomMargin += au.aD(this.parent.getContext());
    this.BSs.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
    AppMethodBeat.o(75701);
  }
  
  private final void ae(float paramFloat1, float paramFloat2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(75697);
    Object localObject = this.BSx;
    int k;
    float f2;
    int i;
    if (localObject != null)
    {
      k = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).iqg - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).dvv;
      f2 = k;
      localObject = this.wdm;
      if (localObject == null) {
        p.hyc();
      }
      i = ((RecordConfigProvider)localObject).BOv;
      localObject = this.BSx;
      if (localObject == null) {
        p.hyc();
      }
      f2 = (paramFloat2 - paramFloat1) * f2 - hW(i + 250, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).iqg);
      if (f2 >= 0.0F) {
        break label198;
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
      this.wgr.a(d.c.BVp, (Bundle)localObject);
      AppMethodBeat.o(75697);
      return;
      AppMethodBeat.o(75697);
      return;
      label198:
      f1 = f2;
    }
  }
  
  private void eKJ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(237362);
    Object localObject1 = this.BSt;
    if (localObject1 != null) {
      ((ViewGroup)localObject1).setVisibility(0);
    }
    localObject1 = this.BSt;
    if (localObject1 != null) {
      ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    localObject1 = this.BSu;
    if (localObject1 != null) {
      ((ImageView)localObject1).setImageDrawable(ar.m(this.parent.getContext(), 2131690713, -1));
    }
    localObject1 = this.BSv;
    if (localObject1 != null) {
      ((ImageView)localObject1).setImageDrawable(ar.m(this.parent.getContext(), 2131690481, -1));
    }
    localObject1 = this.BSt;
    if (localObject1 != null)
    {
      localObject1 = ((ViewGroup)localObject1).getContext();
      if (!ao.aQ((Context)localObject1)) {
        break label228;
      }
      localObject1 = this.BSt;
      if (localObject1 == null) {
        break label156;
      }
    }
    label156:
    for (localObject1 = ((ViewGroup)localObject1).getLayoutParams();; localObject1 = null)
    {
      if (localObject1 != null) {
        break label161;
      }
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(237362);
      throw ((Throwable)localObject1);
      localObject1 = null;
      break;
    }
    label161:
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject1;
    int i = localMarginLayoutParams.topMargin;
    ViewGroup localViewGroup = this.BSt;
    localObject1 = localObject2;
    if (localViewGroup != null) {
      localObject1 = localViewGroup.getContext();
    }
    localMarginLayoutParams.topMargin = (ao.aP((Context)localObject1) + i);
    localObject1 = this.BSt;
    if (localObject1 != null)
    {
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localMarginLayoutParams);
      AppMethodBeat.o(237362);
      return;
    }
    label228:
    AppMethodBeat.o(237362);
  }
  
  private final void eKK()
  {
    Object localObject2 = null;
    AppMethodBeat.i(237363);
    Object localObject1 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
    com.tencent.mm.plugin.recordvideo.d.g.VQ(3);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.g.BXY;
    com.tencent.mm.plugin.recordvideo.d.g.ax(3, 1L);
    Intent localIntent = new Intent();
    ((aj)com.tencent.mm.kernel.g.ah(aj.class)).fillContextIdToIntent(4, 5, 44, localIntent);
    aj localaj = (aj)com.tencent.mm.kernel.g.ah(aj.class);
    Context localContext = this.parent.getContext();
    localIntent.putExtra("key_finder_sns_post_type", 2);
    localIntent.putExtra("key_finder_post_router", 6);
    localIntent.putExtra("key_finder_post_from", 6);
    localObject1 = this.BSx;
    com.tencent.mm.media.widget.camerarecordview.b.b localb;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqd;
      if (localObject1 == null) {
        break label170;
      }
      localb = this.BSx;
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.iqd;
      }
    }
    for (;;)
    {
      localIntent.putExtra("key_finder_post_sns_video_path", (String)localObject1);
      localaj.enterFinderPostRouterUI(localContext, localIntent);
      AppMethodBeat.o(237363);
      return;
      localObject1 = null;
      break;
      label170:
      localb = this.BSx;
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.iqh;
      }
    }
  }
  
  private final void eKL()
  {
    AppMethodBeat.i(237364);
    Object localObject = i.Ciy;
    localObject = this.parent.getContext();
    p.g(localObject, "parent.context");
    final boolean bool = i.gQ((Context)localObject);
    localObject = c.BXI;
    c.x("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(1));
    Context localContext = this.parent.getContext();
    if (bool) {}
    for (localObject = getString(2131755847);; localObject = getString(2131755845))
    {
      this.kvo = h.c(localContext, (String)localObject, "", getString(2131755921), getString(2131755761), (DialogInterface.OnClickListener)new g(this, bool), (DialogInterface.OnClickListener)new h(this, bool));
      AppMethodBeat.o(237364);
      return;
    }
  }
  
  private final void eKM()
  {
    AppMethodBeat.i(237365);
    Object localObject = com.tencent.mm.plugin.recordvideo.e.a.ChV;
    localObject = this.parent.getContext();
    p.g(localObject, "parent.context");
    boolean bool = com.tencent.mm.plugin.recordvideo.e.a.G((Context)localObject, "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF");
    Context localContext = this.parent.getContext();
    if (bool) {}
    for (localObject = getString(2131755830);; localObject = getString(2131755829))
    {
      this.BSy = h.c(localContext, (String)localObject, "", getString(2131755921), getString(2131755761), (DialogInterface.OnClickListener)new a.e(this, bool), (DialogInterface.OnClickListener)new a.f(this));
      AppMethodBeat.o(237365);
      return;
    }
  }
  
  private final String getString(int paramInt)
  {
    AppMethodBeat.i(75691);
    if (this.parent.getContext() != null)
    {
      String str = this.parent.getContext().getString(paramInt);
      p.g(str, "parent.context.getString(resId)");
      AppMethodBeat.o(75691);
      return str;
    }
    AppMethodBeat.o(75691);
    return "";
  }
  
  private static int hW(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public final void W(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75692);
    Log.d("MicroMsg.EditCropVideoPlugin", "onRecyclerChanged : " + paramFloat1 + ' ' + paramFloat2);
    this.BSA = paramFloat1;
    this.BSB = paramFloat2;
    ae(paramFloat1, paramFloat2);
    AppMethodBeat.o(75692);
  }
  
  public final void X(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75693);
    Log.d("MicroMsg.EditCropVideoPlugin", "onDown : " + paramFloat1 + ' ' + paramFloat2);
    d.b.a(this.wgr, d.c.BVr);
    AppMethodBeat.o(75693);
  }
  
  public final void Y(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75694);
    Log.d("MicroMsg.EditCropVideoPlugin", "onUp : " + paramFloat1 + ' ' + paramFloat2);
    this.BSA = paramFloat1;
    this.BSB = paramFloat2;
    ae(paramFloat1, paramFloat2);
    AppMethodBeat.o(75694);
  }
  
  public final void Z(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75695);
    Log.d("MicroMsg.EditCropVideoPlugin", "onMove : " + paramFloat1 + ' ' + paramFloat2);
    AppMethodBeat.o(75695);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return "plugin_video_crop";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75698);
    ViewGroup localViewGroup = this.BSt;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
    if (this.BSs.getVisibility() == 0)
    {
      d.b.a(this.wgr, d.c.BVt);
      this.BSs.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new b(this));
      AppMethodBeat.o(75698);
      return true;
    }
    AppMethodBeat.o(75698);
    return false;
  }
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(75690);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (paramView != null)
    {
      localObject = Integer.valueOf(paramView.getId());
      if (localObject != null) {
        break label95;
      }
      label55:
      if (localObject != null) {
        break label175;
      }
      label59:
      if (localObject != null) {
        break label339;
      }
      label63:
      if (localObject != null) {
        break label366;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75690);
      return;
      localObject = null;
      break;
      label95:
      if (((Integer)localObject).intValue() != 2131299840) {
        break label55;
      }
      this.BSs.zDX.reset();
      d.b.a(this.wgr, d.c.BVt);
      this.BSs.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new c(this));
      paramView = this.BSt;
      if (paramView != null)
      {
        paramView.setVisibility(8);
        continue;
        label175:
        if (((Integer)localObject).intValue() != 2131299843) {
          break label59;
        }
        ae(this.BSA, this.BSB);
        d.b.a(this.wgr, d.c.BVu);
        if (!this.BSz) {
          this.BSs.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new d(this));
        }
        paramView = this.BSt;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = this.BSx;
        if (paramView != null)
        {
          int i = paramView.iqg - paramView.dvv;
          paramView = c.BXI;
          c.x("KEY_VIDEO_CROP_DURATION_MS_INT", Integer.valueOf((int)(i * (this.BSB - this.BSA))));
          paramView = com.tencent.mm.plugin.recordvideo.d.g.BXY;
          com.tencent.mm.plugin.recordvideo.d.g.Ic((i * this.BSA));
          paramView = com.tencent.mm.plugin.recordvideo.d.g.BXY;
          com.tencent.mm.plugin.recordvideo.d.g.Id((i * this.BSB));
          continue;
          label339:
          if (((Integer)localObject).intValue() != 2131299879) {
            break label63;
          }
          tg(false);
          paramView = c.BXI;
          c.aLu("KEY_CLICK_VIDEO_CROP_COUNT_INT");
          continue;
          label366:
          if (((Integer)localObject).intValue() == 2131310624)
          {
            if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(paramView.getContext()))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(75690);
              return;
            }
            if (this.BSF >= 2)
            {
              paramView = c.BXI;
              c.eKZ();
              paramView = new z.a();
              paramView.SYB = true;
              localObject = new e(this.parent.getContext(), 1, true);
              ((e)localObject).a((o.f)new a.i(this, (e)localObject));
              ((e)localObject).a((o.g)new j(this, paramView, (e)localObject));
              ((e)localObject).b((e.b)new k(paramView));
              ((e)localObject).dGm();
            }
            else if (this.BSC)
            {
              eKK();
            }
            else if (this.BSD)
            {
              eKL();
            }
            else if (this.BSE)
            {
              eKM();
            }
          }
        }
      }
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237366);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237366);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(75700);
    this.BSs.release();
    if (this.kvo != null)
    {
      Object localObject = this.kvo;
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(75700);
        throw ((Throwable)localObject);
      }
      if (((Dialog)localObject).isShowing())
      {
        localObject = this.kvo;
        if (localObject != null) {
          ((com.tencent.mm.ui.widget.a.d)localObject).dismiss();
        }
        Log.i("MicroMsg.EditCropVideoPlugin", "release dismiss dialog");
      }
    }
    AppMethodBeat.o(75700);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75699);
    this.iqd = "";
    this.BSs.release();
    AppMethodBeat.o(75699);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75696);
    this.BSr.setVisibility(paramInt);
    AppMethodBeat.o(75696);
  }
  
  public final void tg(boolean paramBoolean)
  {
    AppMethodBeat.i(75689);
    Object localObject2 = this.iqd;
    Object localObject1 = this.BSx;
    Object localObject3;
    int i;
    label135:
    label349:
    boolean bool1;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqd;
      if ((p.j(localObject2, localObject1) ^ true))
      {
        localObject1 = this.BSx;
        if (localObject1 != null)
        {
          this.iqd = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqd;
          localObject2 = this.BSs;
          localObject3 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqd;
          Object localObject4 = this.wdm;
          if (localObject4 == null) {
            p.hyc();
          }
          int j = hW(((RecordConfigProvider)localObject4).BOv, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqg);
          localObject4 = this.wdm;
          if (localObject4 == null) {
            p.hyc();
          }
          localObject4 = ((RecordConfigProvider)localObject4).BOm;
          if (localObject4 == null) {
            break label783;
          }
          i = ((VideoTransPara)localObject4).minDuration;
          p.h(localObject3, "path");
          if (!((EditVideoSeekBarView)localObject2).hasInit)
          {
            ((EditVideoSeekBarView)localObject2).hasInit = true;
            ((EditVideoSeekBarView)localObject2).zDX.aFp((String)localObject3);
            localObject3 = new VideoTransPara();
            ((VideoTransPara)localObject3).duration = (j / 1000);
            ((VideoTransPara)localObject3).minDuration = i;
            ((EditVideoSeekBarView)localObject2).zDX.setVideoTransPara((VideoTransPara)localObject3);
            ((EditVideoSeekBarView)localObject2).zDX.setOnPreparedListener((c.a)EditVideoSeekBarView.b.BSM);
          }
          this.BSs.setThumbBarSeekListener((c.b)this);
          localObject2 = this.wdm;
          if (localObject2 == null) {
            p.hyc();
          }
          this.BSB = (hW(((RecordConfigProvider)localObject2).BOv, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqg) * 1.0F / ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).iqg);
        }
      }
      this.BSs.setVisibility(0);
      Log.d("MicroMsg.EditCropVideoPlugin", "forceCropVideo isForce: ".concat(String.valueOf(paramBoolean)));
      localObject2 = new Bundle();
      if (paramBoolean)
      {
        localObject1 = this.wdm;
        if ((localObject1 != null) && (((RecordConfigProvider)localObject1).scene == 2))
        {
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sdU, 1) != 1) {
            break label788;
          }
          paramBoolean = true;
          boolean bool2 = ((aj)com.tencent.mm.kernel.g.ah(aj.class)).showPostEntry();
          boolean bool3 = TextUtils.equals((CharSequence)((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.ska, "0"), (CharSequence)"1");
          boolean bool4 = MMApplicationContext.getDefaultPreference().getBoolean("wesee_switch", false);
          localObject1 = com.tencent.mm.plugin.recordvideo.e.g.Ciw;
          this.BSE = com.tencent.mm.plugin.recordvideo.e.g.eMP();
          if ((!paramBoolean) || (!bool2)) {
            break label793;
          }
          bool1 = true;
          label437:
          this.BSC = bool1;
          if ((!bool3) && (!bool4)) {
            break label799;
          }
          bool1 = true;
          label456:
          this.BSD = bool1;
          Log.i("MicroMsg.EditCropVideoPlugin", "sns2FinderEnable:" + paramBoolean + ", showPostEntry:" + bool2 + ", showWeseeEntry:" + bool3 + ", weseeCommandSwitch:" + bool4);
          if (this.BSC) {
            this.BSF += 1;
          }
          if (this.BSD) {
            this.BSF += 1;
          }
          if (this.BSE) {
            this.BSF += 1;
          }
          if (this.BSF < 2) {
            break label805;
          }
          localObject1 = this.BSw;
          if (localObject1 != null)
          {
            localObject3 = this.parent.getContext();
            p.g(localObject3, "parent.context");
            ((TextView)localObject1).setText((CharSequence)((Context)localObject3).getResources().getString(2131758459));
          }
          localObject1 = this.BSu;
          if (localObject1 != null) {
            ((ImageView)localObject1).setVisibility(8);
          }
          eKJ();
          if (this.BSD)
          {
            ((Bundle)localObject2).putBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", true);
            localObject1 = WeSeeProvider.BME;
            WeSeeProvider.a.delete();
            localObject1 = c.BXI;
            c.x("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(1));
          }
          localObject1 = c.BXI;
          c.HY(3L);
          label696:
          localObject1 = i.Ciy;
          localObject1 = this.parent.getContext();
          p.g(localObject1, "parent.context");
          if (!i.gQ((Context)localObject1)) {
            break label1097;
          }
          localObject1 = c.BXI;
          c.x("KEY_IS_INSTALL_WESEE", Integer.valueOf(1));
        }
      }
    }
    for (;;)
    {
      localObject1 = c.BXI;
      c.x("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(2));
      this.wgr.a(d.c.BVn, (Bundle)localObject2);
      AppMethodBeat.o(75689);
      return;
      localObject1 = null;
      break;
      label783:
      i = 0;
      break label135;
      label788:
      paramBoolean = false;
      break label349;
      label793:
      bool1 = false;
      break label437;
      label799:
      bool1 = false;
      break label456;
      label805:
      if ((this.BSC) || (this.BSE))
      {
        localObject3 = this.BSw;
        if (localObject3 != null)
        {
          if (!this.BSC) {
            break label928;
          }
          localObject1 = this.parent.getContext();
          p.g(localObject1, "parent.context");
        }
        for (localObject1 = (CharSequence)((Context)localObject1).getResources().getString(2131758452);; localObject1 = (CharSequence)((Context)localObject1).getResources().getString(2131758464))
        {
          ((TextView)localObject3).setText((CharSequence)localObject1);
          localObject1 = this.BSu;
          if (localObject1 != null) {
            ((ImageView)localObject1).setVisibility(8);
          }
          eKJ();
          localObject1 = c.BXI;
          c.x("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(2));
          localObject1 = c.BXI;
          c.HY(3L);
          break;
          localObject1 = this.parent.getContext();
          p.g(localObject1, "parent.context");
        }
      }
      label928:
      if (this.BSD)
      {
        localObject1 = this.BSw;
        if (localObject1 != null)
        {
          localObject3 = this.parent.getContext();
          p.g(localObject3, "parent.context");
          ((TextView)localObject1).setText((CharSequence)((Context)localObject3).getResources().getString(2131758467));
        }
        localObject1 = this.BSu;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        ((Bundle)localObject2).putBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", true);
        eKJ();
        localObject1 = WeSeeProvider.BME;
        WeSeeProvider.a.delete();
        localObject1 = c.BXI;
        c.x("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(1));
        localObject1 = c.BXI;
        c.HY(2L);
        break label696;
      }
      localObject1 = c.BXI;
      c.HY(1L);
      break label696;
      label1097:
      localObject1 = c.BXI;
      c.x("KEY_IS_INSTALL_WESEE", Integer.valueOf(2));
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onBackPress$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75684);
      p.h(paramAnimator, "animation");
      a.a(this.BSH).setVisibility(8);
      a.a(this.BSH).setAlpha(1.0F);
      AppMethodBeat.o(75684);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75685);
      p.h(paramAnimator, "animation");
      a.a(this.BSH).setVisibility(8);
      a.a(this.BSH).setAlpha(1.0F);
      AppMethodBeat.o(75685);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75686);
      p.h(paramAnimator, "animation");
      a.a(this.BSH).setVisibility(8);
      a.a(this.BSH).setAlpha(1.0F);
      AppMethodBeat.o(75686);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(a parama, boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(237357);
      if (a.h(this.BSH) != null)
      {
        paramDialogInterface = a.h(this.BSH);
        if (paramDialogInterface == null)
        {
          paramDialogInterface = new kotlin.t("null cannot be cast to non-null type android.app.Dialog");
          AppMethodBeat.o(237357);
          throw paramDialogInterface;
        }
        if (((Dialog)paramDialogInterface).isShowing())
        {
          paramDialogInterface = a.h(this.BSH);
          if (paramDialogInterface != null) {
            paramDialogInterface.dismiss();
          }
          Log.i("MicroMsg.EditCropVideoPlugin", "click ok dismiss dialog");
        }
      }
      Log.i("MicroMsg.EditCropVideoPlugin", "dialog ok isInstallWeSee:" + bool);
      paramDialogInterface = a.i(this.BSH);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.iqd;
        if (paramDialogInterface == null) {
          break label289;
        }
        paramDialogInterface = a.i(this.BSH);
        if (paramDialogInterface == null) {
          break label284;
        }
        paramDialogInterface = paramDialogInterface.iqd;
      }
      for (;;)
      {
        if (bool)
        {
          localObject = com.tencent.mm.plugin.recordvideo.d.g.BXY;
          com.tencent.mm.plugin.recordvideo.d.g.VQ(2);
          localObject = com.tencent.mm.plugin.recordvideo.d.g.BXY;
          com.tencent.mm.plugin.recordvideo.d.g.ax(3, 1L);
          localObject = i.Ciy;
          localObject = this.BSH.parent.getContext();
          p.g(localObject, "parent.context");
          if (paramDialogInterface == null) {
            p.hyc();
          }
          p.h(localObject, "context");
          p.h(paramDialogInterface, "videoPath");
          String str = i.Io(cl.aWz());
          s.a((Context)localObject, new Intent(), str, paramDialogInterface);
          paramDialogInterface = c.BXI;
          c.x("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(1));
          paramDialogInterface = new Intent();
          localObject = this.BSH.parent.getContext();
          if (localObject == null)
          {
            paramDialogInterface = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(237357);
            throw paramDialogInterface;
            paramDialogInterface = null;
            break;
            label284:
            paramDialogInterface = null;
            continue;
            label289:
            paramDialogInterface = a.i(this.BSH);
            if (paramDialogInterface != null)
            {
              paramDialogInterface = paramDialogInterface.iqh;
              continue;
            }
            paramDialogInterface = null;
            continue;
          }
          ((Activity)localObject).setResult(-2, paramDialogInterface);
          paramDialogInterface = this.BSH.parent.getContext();
          if (paramDialogInterface == null)
          {
            paramDialogInterface = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(237357);
            throw paramDialogInterface;
          }
          ((Activity)paramDialogInterface).finish();
          Log.d("MicroMsg.EditCropVideoPlugin", "set RESULT_VIDEO_FINISH");
          AppMethodBeat.o(237357);
          return;
        }
      }
      Object localObject = WeSeeProvider.BME;
      paramDialogInterface = s.bfE(paramDialogInterface);
      p.g(paramDialogInterface, "TakePhotoUtil.parseWeSeeUri(videoPath)");
      WeSeeProvider.a.bg(paramDialogInterface, System.currentTimeMillis());
      paramDialogInterface = i.Ciy;
      paramDialogInterface = this.BSH.parent.getContext();
      p.g(paramDialogInterface, "parent.context");
      i.gR(paramDialogInterface);
      paramDialogInterface = c.BXI;
      c.x("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(3));
      AppMethodBeat.o(237357);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class h
    implements DialogInterface.OnClickListener
  {
    h(a parama, boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(237358);
      if (bool)
      {
        paramDialogInterface = c.BXI;
        c.x("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(2));
      }
      for (;;)
      {
        Log.i("MicroMsg.EditCropVideoPlugin", "dialog cancel");
        if (a.h(this.BSH) == null) {
          break label120;
        }
        paramDialogInterface = a.h(this.BSH);
        if (paramDialogInterface != null) {
          break;
        }
        paramDialogInterface = new kotlin.t("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(237358);
        throw paramDialogInterface;
        paramDialogInterface = c.BXI;
        c.x("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(4));
      }
      if (((Dialog)paramDialogInterface).isShowing())
      {
        paramDialogInterface = a.h(this.BSH);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        Log.i("MicroMsg.EditCropVideoPlugin", "click no dismiss dialog");
      }
      label120:
      AppMethodBeat.o(237358);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
  static final class j
    implements o.g
  {
    j(a parama, z.a parama1, e parame) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(237360);
      p.h(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        this.nkZ.bMo();
        AppMethodBeat.o(237360);
        return;
        paramView.SYB = false;
        a.e(this.BSH);
        paramMenuItem = c.BXI;
        c.HZ(1L);
        continue;
        paramView.SYB = false;
        a.f(this.BSH);
        paramMenuItem = c.BXI;
        c.HZ(2L);
        continue;
        paramView.SYB = false;
        a.g(this.BSH);
        paramMenuItem = c.BXI;
        c.HZ(4L);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class k
    implements e.b
  {
    k(z.a parama) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(237361);
      if (this.BSK.SYB)
      {
        c localc = c.BXI;
        c.HZ(3L);
      }
      AppMethodBeat.o(237361);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.model.cm;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.d.g;
import com.tencent.mm.plugin.recordvideo.e.i;
import com.tencent.mm.plugin.recordvideo.e.k;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Arrays;
import kotlin.g.b.aa.a;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropBtn", "Landroid/widget/ImageView;", "cropEnd", "", "cropRecyclerThumbSeekBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "cropStart", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "entranceNum", "", "finderEnable", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "jumpHideAnimation", "longVideoTv", "Landroid/widget/TextView;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "phoenixDialog", "secondCutEnable", "sourceVideoPath", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "weseeArrowBtn", "weseeBtn", "weseeEnable", "weseeWrapper", "changeThumbBarPercent", "", "currentTime", "forceCropVideo", "isForce", "getSmaller", "a", "b", "getString", "resId", "onBackPress", "onClick", "v", "Landroid/view/View;", "onClickFinder", "onClickSecondCut", "onClickWesee", "onDown", "left", "start", "end", "onMove", "onRecyclerChanged", "onUp", "release", "reset", "resetConfirmStyle", "bgStyleResId", "textColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setCaptureInfo", "captureInfo", "setJumpHideAnimation", "jump", "setUIParams", "seekbarHeight", "bgResId", "setVisibility", "visibility", "showBottomSheet", "showWeSeeBtn", "startLoadThumbBitmap", "synCropInfo", "Companion", "plugin-recordvideo_release"})
public final class a
  implements View.OnClickListener, c.b, com.tencent.mm.plugin.recordvideo.plugin.u
{
  public static final a HPv;
  private RecordConfigProvider ALV;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  private final ImageView HPg;
  public final EditVideoSeekBarView HPh;
  private final ViewGroup HPi;
  private final ImageView HPj;
  private final ImageView HPk;
  private final TextView HPl;
  private com.tencent.mm.media.widget.camerarecordview.b.b HPm;
  private com.tencent.mm.ui.widget.a.d HPn;
  public boolean HPo;
  private float HPp;
  private float HPq;
  private boolean HPr;
  private boolean HPs;
  private boolean HPt;
  private int HPu;
  private String lfj;
  private com.tencent.mm.ui.widget.a.d nnz;
  ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(75702);
    HPv = new a((byte)0);
    AppMethodBeat.o(75702);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75701);
    this.parent = paramViewGroup;
    this.APl = paramd;
    paramViewGroup = this.parent.findViewById(b.e.editor_crop_video);
    p.j(paramViewGroup, "parent.findViewById(R.id.editor_crop_video)");
    this.HPg = ((ImageView)paramViewGroup);
    paramViewGroup = this.parent.findViewById(b.e.editor_crop_bar);
    p.j(paramViewGroup, "parent.findViewById(R.id.editor_crop_bar)");
    this.HPh = ((EditVideoSeekBarView)paramViewGroup);
    this.HPi = ((ViewGroup)this.parent.findViewById(b.e.wrapper_editor_wesee));
    this.HPj = ((ImageView)this.parent.findViewById(b.e.iv_editor_wesee));
    this.HPk = ((ImageView)this.parent.findViewById(b.e.iv_wesee_arrow));
    this.HPl = ((TextView)this.parent.findViewById(b.e.tv_editor_wesee));
    this.HPq = 1.0F;
    this.lfj = "";
    this.HPg.setImageDrawable(au.o(this.parent.getContext(), b.g.icons_filled_crop, -1));
    this.HPg.setOnClickListener((View.OnClickListener)this);
    this.HPh.setCancelButtonClickListener((View.OnClickListener)this);
    this.HPh.setFinishButtonClickListener((View.OnClickListener)this);
    paramViewGroup = this.HPh.getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(75701);
      throw paramViewGroup;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramViewGroup;
    paramViewGroup.bottomMargin += ax.aB(this.parent.getContext());
    this.HPh.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
    AppMethodBeat.o(75701);
  }
  
  private final void ag(float paramFloat1, float paramFloat2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(75697);
    Object localObject = this.HPm;
    int k;
    float f2;
    int i;
    if (localObject != null)
    {
      k = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).endTime - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).fod;
      f2 = k;
      localObject = this.ALV;
      if (localObject == null) {
        p.iCn();
      }
      i = ((RecordConfigProvider)localObject).HLb;
      localObject = this.HPm;
      if (localObject == null) {
        p.iCn();
      }
      f2 = (paramFloat2 - paramFloat1) * f2 - ja(i + 250, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).endTime);
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
      this.APl.a(d.c.HSd, (Bundle)localObject);
      AppMethodBeat.o(75697);
      return;
      AppMethodBeat.o(75697);
      return;
      label198:
      f1 = f2;
    }
  }
  
  private void fxd()
  {
    Object localObject2 = null;
    AppMethodBeat.i(220260);
    Object localObject1 = this.HPi;
    if (localObject1 != null) {
      ((ViewGroup)localObject1).setVisibility(0);
    }
    localObject1 = this.HPi;
    if (localObject1 != null) {
      ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    localObject1 = this.HPj;
    if (localObject1 != null) {
      ((ImageView)localObject1).setImageDrawable(au.o(this.parent.getContext(), b.g.icons_filled_wesee, -1));
    }
    localObject1 = this.HPk;
    if (localObject1 != null) {
      ((ImageView)localObject1).setImageDrawable(au.o(this.parent.getContext(), b.g.icons_filled_arrow, -1));
    }
    localObject1 = this.HPi;
    if (localObject1 != null)
    {
      localObject1 = ((ViewGroup)localObject1).getContext();
      if (!ar.aN((Context)localObject1)) {
        break label228;
      }
      localObject1 = this.HPi;
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
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(220260);
      throw ((Throwable)localObject1);
      localObject1 = null;
      break;
    }
    label161:
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject1;
    int i = localMarginLayoutParams.topMargin;
    ViewGroup localViewGroup = this.HPi;
    localObject1 = localObject2;
    if (localViewGroup != null) {
      localObject1 = localViewGroup.getContext();
    }
    localMarginLayoutParams.topMargin = (ar.aM((Context)localObject1) + i);
    localObject1 = this.HPi;
    if (localObject1 != null)
    {
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localMarginLayoutParams);
      AppMethodBeat.o(220260);
      return;
    }
    label228:
    AppMethodBeat.o(220260);
  }
  
  private final void fxe()
  {
    Object localObject2 = null;
    AppMethodBeat.i(220309);
    Object localObject1 = g.HUM;
    g.acz(3);
    localObject1 = g.HUM;
    g.aJ(3, 1L);
    Intent localIntent = new Intent();
    ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(4, 5, 44, localIntent);
    ak localak = (ak)com.tencent.mm.kernel.h.ag(ak.class);
    Context localContext = this.parent.getContext();
    localIntent.putExtra("key_finder_sns_post_type", 2);
    localIntent.putExtra("key_finder_post_router", 6);
    localIntent.putExtra("key_finder_post_from", 6);
    localObject1 = this.HPm;
    com.tencent.mm.media.widget.camerarecordview.b.b localb;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfj;
      if (localObject1 == null) {
        break label170;
      }
      localb = this.HPm;
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.lfj;
      }
    }
    for (;;)
    {
      localIntent.putExtra("key_finder_post_sns_video_path", (String)localObject1);
      localak.enterFinderPostRouterUI(localContext, localIntent);
      AppMethodBeat.o(220309);
      return;
      localObject1 = null;
      break;
      label170:
      localb = this.HPm;
      localObject1 = localObject2;
      if (localb != null) {
        localObject1 = localb.lfm;
      }
    }
  }
  
  private final void fxf()
  {
    AppMethodBeat.i(220314);
    Object localObject = k.Ifq;
    localObject = this.parent.getContext();
    p.j(localObject, "parent.context");
    final boolean bool = k.hS((Context)localObject);
    localObject = c.HUw;
    c.w("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(1));
    Context localContext = this.parent.getContext();
    if (bool) {}
    for (localObject = getString(b.h.app_field_weishi_jump_tip_new);; localObject = getString(b.h.app_field_weishi_install_tip))
    {
      this.nnz = com.tencent.mm.ui.base.h.c(localContext, (String)localObject, "", getString(b.h.app_ok), getString(b.h.app_cancel), (DialogInterface.OnClickListener)new g(this, bool), (DialogInterface.OnClickListener)new h(this, bool));
      AppMethodBeat.o(220314);
      return;
    }
  }
  
  private final void fxg()
  {
    AppMethodBeat.i(220317);
    Object localObject = com.tencent.mm.plugin.recordvideo.e.a.IeL;
    localObject = this.parent.getContext();
    p.j(localObject, "parent.context");
    final boolean bool = com.tencent.mm.plugin.recordvideo.e.a.M((Context)localObject, "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF");
    Context localContext = this.parent.getContext();
    if (bool) {}
    for (localObject = getString(b.h.app_field_secondcut_jump_tip);; localObject = getString(b.h.app_field_secondcut_install_tip))
    {
      this.HPn = com.tencent.mm.ui.base.h.c(localContext, (String)localObject, "", getString(b.h.app_ok), getString(b.h.app_cancel), (DialogInterface.OnClickListener)new e(this, bool), (DialogInterface.OnClickListener)new f(this));
      AppMethodBeat.o(220317);
      return;
    }
  }
  
  private final String getString(int paramInt)
  {
    AppMethodBeat.i(75691);
    if (this.parent.getContext() != null)
    {
      String str = this.parent.getContext().getString(paramInt);
      p.j(str, "parent.context.getString(resId)");
      AppMethodBeat.o(75691);
      return str;
    }
    AppMethodBeat.o(75691);
    return "";
  }
  
  private static int ja(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public final void X(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75692);
    Log.d("MicroMsg.EditCropVideoPlugin", "onRecyclerChanged : " + paramFloat1 + ' ' + paramFloat2);
    this.HPp = paramFloat1;
    this.HPq = paramFloat2;
    ag(paramFloat1, paramFloat2);
    AppMethodBeat.o(75692);
  }
  
  public final void Y(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75693);
    Log.d("MicroMsg.EditCropVideoPlugin", "onDown : " + paramFloat1 + ' ' + paramFloat2);
    d.b.a(this.APl, d.c.HSf);
    AppMethodBeat.o(75693);
  }
  
  public final void Z(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75694);
    Log.d("MicroMsg.EditCropVideoPlugin", "onUp : " + paramFloat1 + ' ' + paramFloat2);
    this.HPp = paramFloat1;
    this.HPq = paramFloat2;
    ag(paramFloat1, paramFloat2);
    AppMethodBeat.o(75694);
  }
  
  public final void aa(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75695);
    Log.d("MicroMsg.EditCropVideoPlugin", "onMove : " + paramFloat1 + ' ' + paramFloat2);
    AppMethodBeat.o(75695);
  }
  
  public final void b(com.tencent.mm.media.widget.camerarecordview.b.b paramb, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(220256);
    p.k(paramb, "captureInfo");
    p.k(paramRecordConfigProvider, "configProvider");
    this.HPm = paramb;
    this.ALV = paramRecordConfigProvider;
    AppMethodBeat.o(220256);
  }
  
  public final void bbp() {}
  
  public final String name()
  {
    AppMethodBeat.i(220364);
    String str = getClass().getName();
    AppMethodBeat.o(220364);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75698);
    ViewGroup localViewGroup = this.HPi;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
    if (this.HPh.getVisibility() == 0)
    {
      d.b.a(this.APl, d.c.HSh);
      this.HPh.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new b(this));
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      localObject = Integer.valueOf(paramView.getId());
      i = b.e.edit_text_cancel;
      if (localObject != null) {
        break label111;
      }
      label59:
      i = b.e.edit_text_ok;
      if (localObject != null) {
        break label189;
      }
      label67:
      i = b.e.editor_crop_video;
      if (localObject != null) {
        break label351;
      }
      label75:
      i = b.e.wrapper_editor_wesee;
      if (localObject != null) {
        break label377;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75690);
      return;
      localObject = null;
      break;
      label111:
      if (((Integer)localObject).intValue() != i) {
        break label59;
      }
      this.HPh.FiW.reset();
      d.b.a(this.APl, d.c.HSh);
      this.HPh.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new c(this));
      paramView = this.HPi;
      if (paramView != null)
      {
        paramView.setVisibility(8);
        continue;
        label189:
        if (((Integer)localObject).intValue() != i) {
          break label67;
        }
        ag(this.HPp, this.HPq);
        d.b.a(this.APl, d.c.HSi);
        if (!this.HPo) {
          this.HPh.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new d(this));
        }
        paramView = this.HPi;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = this.HPm;
        if (paramView != null)
        {
          i = paramView.endTime - paramView.fod;
          paramView = c.HUw;
          c.w("KEY_VIDEO_CROP_DURATION_MS_INT", Integer.valueOf((int)(i * (this.HPq - this.HPp))));
          paramView = g.HUM;
          g.Pw((i * this.HPp));
          paramView = g.HUM;
          g.Px((i * this.HPq));
          continue;
          label351:
          if (((Integer)localObject).intValue() != i) {
            break label75;
          }
          wC(false);
          paramView = c.HUw;
          c.aVY("KEY_CLICK_VIDEO_CROP_COUNT_INT");
          continue;
          label377:
          if (((Integer)localObject).intValue() == i)
          {
            if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(paramView.getContext()))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(75690);
              return;
            }
            if (this.HPu >= 2)
            {
              paramView = c.HUw;
              c.fxs();
              paramView = new aa.a();
              paramView.aaBx = true;
              localObject = new e(this.parent.getContext(), 1, true);
              ((e)localObject).a((q.f)new i(this, (e)localObject));
              ((e)localObject).a((q.g)new j(this, paramView, (e)localObject));
              ((e)localObject).b((e.b)new k(paramView));
              ((e)localObject).eik();
            }
            else if (this.HPr)
            {
              fxe();
            }
            else if (this.HPs)
            {
              fxf();
            }
            else if (this.HPt)
            {
              fxg();
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
    AppMethodBeat.i(220372);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(220372);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(75700);
    this.HPh.release();
    if (this.nnz != null)
    {
      Object localObject = this.nnz;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(75700);
        throw ((Throwable)localObject);
      }
      if (((Dialog)localObject).isShowing())
      {
        localObject = this.nnz;
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
    this.lfj = "";
    this.HPh.release();
    AppMethodBeat.o(75699);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75696);
    this.HPg.setVisibility(paramInt);
    AppMethodBeat.o(75696);
  }
  
  public final void wC(boolean paramBoolean)
  {
    AppMethodBeat.i(75689);
    Object localObject1 = this.HPm;
    int i;
    Object localObject3;
    Object localObject4;
    if ((localObject1 != null) && ((p.h(this.lfj, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfj) ^ true)))
    {
      this.lfj = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfj;
      localObject2 = this.ALV;
      if (localObject2 != null)
      {
        if (((RecordConfigProvider)localObject2).HLc < 0) {
          break label859;
        }
        i = ja(((RecordConfigProvider)localObject2).HLc, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime);
        Log.i("MicroMsg.EditCropVideoPlugin", "duration:" + ja(((RecordConfigProvider)localObject2).HLb, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime) + " minDuration:" + i);
        localObject3 = this.HPh;
        localObject4 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).lfj;
        int j = ja(((RecordConfigProvider)localObject2).HLb, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime);
        i = (int)Math.ceil(i * 1.0D / 1000.0D);
        p.k(localObject4, "path");
        if (!((EditVideoSeekBarView)localObject3).hasInit)
        {
          ((EditVideoSeekBarView)localObject3).hasInit = true;
          ((EditVideoSeekBarView)localObject3).FiW.aPz((String)localObject4);
          localObject4 = new VideoTransPara();
          ((VideoTransPara)localObject4).duration = (j / 1000);
          ((VideoTransPara)localObject4).minDuration = i;
          ((EditVideoSeekBarView)localObject3).FiW.setVideoTransPara((VideoTransPara)localObject4);
          ((EditVideoSeekBarView)localObject3).FiW.setOnPreparedListener((c.a)EditVideoSeekBarView.b.HPA);
        }
        this.HPh.setThumbBarSeekListener((c.b)this);
        this.HPq = (ja(((RecordConfigProvider)localObject2).HLb, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime) * 1.0F / ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime);
      }
    }
    this.HPh.setVisibility(0);
    Log.d("MicroMsg.EditCropVideoPlugin", "forceCropVideo isForce: ".concat(String.valueOf(paramBoolean)));
    Object localObject2 = new Bundle();
    label361:
    boolean bool1;
    if (paramBoolean)
    {
      localObject1 = this.ALV;
      if ((localObject1 != null) && (((RecordConfigProvider)localObject1).scene == 2))
      {
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNo, 1) != 1) {
          break label883;
        }
        paramBoolean = true;
        boolean bool2 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).showPostEntry();
        boolean bool3 = TextUtils.equals((CharSequence)((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUu, "0"), (CharSequence)"1");
        boolean bool4 = MMApplicationContext.getDefaultPreference().getBoolean("wesee_switch", false);
        localObject1 = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
        this.HPt = com.tencent.mm.plugin.recordvideo.e.h.fzA();
        if ((!paramBoolean) || (!bool2)) {
          break label888;
        }
        bool1 = true;
        label449:
        this.HPr = bool1;
        if ((!bool3) && (!bool4)) {
          break label894;
        }
        bool1 = true;
        label468:
        this.HPs = bool1;
        Log.i("MicroMsg.EditCropVideoPlugin", "sns2FinderEnable:" + paramBoolean + ", showPostEntry:" + bool2 + ", showWeseeEntry:" + bool3 + ", weseeCommandSwitch:" + bool4);
        if (this.HPr) {
          this.HPu += 1;
        }
        if (this.HPs) {
          this.HPu += 1;
        }
        if (this.HPt) {
          this.HPu += 1;
        }
        if (this.HPu < 2) {
          break label907;
        }
        localObject1 = this.ALV;
        if (localObject1 == null) {
          break label900;
        }
        i = ((RecordConfigProvider)localObject1).HLb;
        label606:
        i /= 1000;
        localObject1 = this.HPl;
        if (localObject1 != null)
        {
          localObject3 = af.aaBG;
          localObject3 = this.parent.getContext();
          p.j(localObject3, "parent.context");
          localObject3 = ((Context)localObject3).getResources().getString(b.h.edit_post_long_content);
          p.j(localObject3, "parent.context.resources…g.edit_post_long_content)");
          localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
          p.j(localObject3, "java.lang.String.format(format, *args)");
          ((TextView)localObject1).setText((CharSequence)localObject3);
        }
        localObject1 = this.HPj;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(8);
        }
        fxd();
        if (this.HPs)
        {
          ((Bundle)localObject2).putBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", true);
          localObject1 = WeSeeProvider.HIQ;
          WeSeeProvider.a.frW();
          localObject1 = c.HUw;
          c.w("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(1));
        }
        localObject1 = c.HUw;
        c.Ps(3L);
        label778:
        localObject1 = k.Ifq;
        localObject1 = this.parent.getContext();
        p.j(localObject1, "parent.context");
        if (!k.hS((Context)localObject1)) {
          break label1361;
        }
        localObject1 = c.HUw;
        c.w("KEY_IS_INSTALL_WESEE", Integer.valueOf(1));
      }
    }
    for (;;)
    {
      localObject1 = c.HUw;
      c.w("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(2));
      this.APl.a(d.c.HSb, (Bundle)localObject2);
      AppMethodBeat.o(75689);
      return;
      label859:
      i = ja(((RecordConfigProvider)localObject2).mfk.minDuration * 1000, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime);
      break;
      label883:
      paramBoolean = false;
      break label361;
      label888:
      bool1 = false;
      break label449;
      label894:
      bool1 = false;
      break label468;
      label900:
      i = 10000;
      break label606;
      label907:
      if ((this.HPr) || (this.HPt))
      {
        localObject3 = this.HPl;
        if (localObject3 != null)
        {
          if (!this.HPr) {
            break label1084;
          }
          localObject1 = af.aaBG;
          localObject1 = this.parent.getContext();
          p.j(localObject1, "parent.context");
          localObject1 = ((Context)localObject1).getResources().getString(b.h.edit_finder_entry_content);
          p.j(localObject1, "parent.context.resources…dit_finder_entry_content)");
          localObject4 = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
          localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.plugin.recordvideo.e.h.fzF()) }, 1));
          p.j(localObject1, "java.lang.String.format(format, *args)");
        }
        for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)localObject1)
        {
          ((TextView)localObject3).setText((CharSequence)localObject1);
          localObject1 = this.HPj;
          if (localObject1 != null) {
            ((ImageView)localObject1).setVisibility(8);
          }
          fxd();
          localObject1 = c.HUw;
          c.w("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(2));
          localObject1 = c.HUw;
          c.Ps(3L);
          break;
          label1084:
          localObject1 = af.aaBG;
          localObject1 = this.parent.getContext();
          p.j(localObject1, "parent.context");
          localObject1 = ((Context)localObject1).getResources().getString(b.h.edit_secondcut_post_content);
          p.j(localObject1, "parent.context.resources…t_secondcut_post_content)");
          localObject4 = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
          localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.plugin.recordvideo.e.h.fzD()) }, 1));
          p.j(localObject1, "java.lang.String.format(format, *args)");
        }
      }
      if (this.HPs)
      {
        localObject1 = this.HPl;
        if (localObject1 != null)
        {
          localObject3 = af.aaBG;
          localObject3 = this.parent.getContext();
          p.j(localObject3, "parent.context");
          localObject3 = ((Context)localObject3).getResources().getString(b.h.edit_wesee_content);
          p.j(localObject3, "parent.context.resources…tring.edit_wesee_content)");
          localObject4 = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
          localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.plugin.recordvideo.e.h.fzE()) }, 1));
          p.j(localObject3, "java.lang.String.format(format, *args)");
          ((TextView)localObject1).setText((CharSequence)localObject3);
        }
        localObject1 = this.HPj;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        ((Bundle)localObject2).putBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", true);
        fxd();
        localObject1 = WeSeeProvider.HIQ;
        WeSeeProvider.a.frW();
        localObject1 = c.HUw;
        c.w("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(1));
        localObject1 = c.HUw;
        c.Ps(2L);
        break label778;
      }
      localObject1 = c.HUw;
      c.Ps(1L);
      break label778;
      label1361:
      localObject1 = c.HUw;
      c.w("KEY_IS_INSTALL_WESEE", Integer.valueOf(2));
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onBackPress$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75684);
      p.k(paramAnimator, "animation");
      a.a(this.HPw).setVisibility(8);
      a.a(this.HPw).setAlpha(1.0F);
      AppMethodBeat.o(75684);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75685);
      p.k(paramAnimator, "animation");
      a.a(this.HPw).setVisibility(8);
      a.a(this.HPw).setAlpha(1.0F);
      AppMethodBeat.o(75685);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75686);
      p.k(paramAnimator, "animation");
      a.a(this.HPw).setVisibility(8);
      a.a(this.HPw).setAlpha(1.0F);
      AppMethodBeat.o(75686);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(a parama, boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      Object localObject1 = null;
      int j = 0;
      AppMethodBeat.i(218306);
      if (a.j(this.HPw) != null)
      {
        paramDialogInterface = a.j(this.HPw);
        if (paramDialogInterface == null)
        {
          paramDialogInterface = new t("null cannot be cast to non-null type android.app.Dialog");
          AppMethodBeat.o(218306);
          throw paramDialogInterface;
        }
        if (((Dialog)paramDialogInterface).isShowing())
        {
          paramDialogInterface = a.j(this.HPw);
          if (paramDialogInterface != null) {
            paramDialogInterface.dismiss();
          }
          Log.i("MicroMsg.EditCropVideoPlugin", "click ok dismiss dialog");
        }
      }
      Log.i("MicroMsg.EditCropVideoPlugin", "dialog ok isInstall:" + bool);
      paramDialogInterface = a.i(this.HPw);
      label151:
      int k;
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.lfj;
        if (paramDialogInterface == null) {
          break label376;
        }
        localObject2 = a.i(this.HPw);
        paramDialogInterface = (DialogInterface)localObject1;
        if (localObject2 != null) {
          paramDialogInterface = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfj;
        }
        if (!bool) {
          break label475;
        }
        localObject1 = i.Ifo;
        if (paramDialogInterface == null) {
          p.iCn();
        }
        localObject1 = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
        k = com.tencent.mm.plugin.recordvideo.e.h.fzB();
        localObject1 = a.k(this.HPw);
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((RecordConfigProvider)localObject1).mfk;
        if (localObject1 == null) {
          break label402;
        }
        paramInt = ((VideoTransPara)localObject1).videoBitrate;
        label215:
        localObject1 = a.k(this.HPw);
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((RecordConfigProvider)localObject1).mfk;
        if (localObject1 == null) {
          break label407;
        }
      }
      label402:
      label407:
      for (int i = ((VideoTransPara)localObject1).width;; i = 0)
      {
        localObject1 = a.k(this.HPw);
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((RecordConfigProvider)localObject1).mfk;
        if (localObject1 != null) {
          j = ((VideoTransPara)localObject1).height;
        }
        paramDialogInterface = i.b("moments", paramDialogInterface, k, paramInt, i, j);
        localObject1 = i.Ifo;
        localObject1 = this.HPw.parent.getContext();
        p.j(localObject1, "parent.context");
        i.ax((Context)localObject1, paramDialogInterface);
        paramDialogInterface = new Intent();
        localObject1 = this.HPw.parent.getContext();
        if (localObject1 != null) {
          break label412;
        }
        paramDialogInterface = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(218306);
        throw paramDialogInterface;
        paramDialogInterface = null;
        break;
        label376:
        localObject2 = a.i(this.HPw);
        paramDialogInterface = (DialogInterface)localObject1;
        if (localObject2 == null) {
          break label151;
        }
        paramDialogInterface = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject2).lfm;
        break label151;
        paramInt = 0;
        break label215;
      }
      label412:
      ((Activity)localObject1).setResult(-2, paramDialogInterface);
      paramDialogInterface = this.HPw.parent.getContext();
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(218306);
        throw paramDialogInterface;
      }
      ((Activity)paramDialogInterface).finish();
      Log.d("MicroMsg.EditCropVideoPlugin", "set RESULT_VIDEO_FINISH");
      AppMethodBeat.o(218306);
      return;
      label475:
      paramDialogInterface = com.tencent.mm.plugin.recordvideo.e.a.IeL;
      paramDialogInterface = this.HPw.parent.getContext();
      p.j(paramDialogInterface, "parent.context");
      localObject1 = new StringBuilder();
      Object localObject2 = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
      com.tencent.mm.plugin.recordvideo.e.a.aK(paramDialogInterface, com.tencent.mm.plugin.recordvideo.e.h.fzC() + "1102");
      AppMethodBeat.o(218306);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    f(a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(221554);
      Log.i("MicroMsg.EditCropVideoPlugin", "dialog cancel");
      if (a.j(this.HPw) != null)
      {
        paramDialogInterface = a.j(this.HPw);
        if (paramDialogInterface == null)
        {
          paramDialogInterface = new t("null cannot be cast to non-null type android.app.Dialog");
          AppMethodBeat.o(221554);
          throw paramDialogInterface;
        }
        if (((Dialog)paramDialogInterface).isShowing())
        {
          paramDialogInterface = a.j(this.HPw);
          if (paramDialogInterface != null) {
            paramDialogInterface.dismiss();
          }
          Log.i("MicroMsg.EditCropVideoPlugin", "click no dismiss dialog");
        }
      }
      AppMethodBeat.o(221554);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(a parama, boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(216672);
      if (a.h(this.HPw) != null)
      {
        paramDialogInterface = a.h(this.HPw);
        if (paramDialogInterface == null)
        {
          paramDialogInterface = new t("null cannot be cast to non-null type android.app.Dialog");
          AppMethodBeat.o(216672);
          throw paramDialogInterface;
        }
        if (((Dialog)paramDialogInterface).isShowing())
        {
          paramDialogInterface = a.h(this.HPw);
          if (paramDialogInterface != null) {
            paramDialogInterface.dismiss();
          }
          Log.i("MicroMsg.EditCropVideoPlugin", "click ok dismiss dialog");
        }
      }
      Log.i("MicroMsg.EditCropVideoPlugin", "dialog ok isInstallWeSee:" + bool);
      paramDialogInterface = a.i(this.HPw);
      if (paramDialogInterface != null)
      {
        paramDialogInterface = paramDialogInterface.lfj;
        if (paramDialogInterface == null) {
          break label289;
        }
        paramDialogInterface = a.i(this.HPw);
        if (paramDialogInterface == null) {
          break label284;
        }
        paramDialogInterface = paramDialogInterface.lfj;
      }
      for (;;)
      {
        if (bool)
        {
          localObject = g.HUM;
          g.acz(2);
          localObject = g.HUM;
          g.aJ(3, 1L);
          localObject = k.Ifq;
          localObject = this.HPw.parent.getContext();
          p.j(localObject, "parent.context");
          if (paramDialogInterface == null) {
            p.iCn();
          }
          p.k(localObject, "context");
          p.k(paramDialogInterface, "videoPath");
          String str = k.PI(cm.bfD());
          com.tencent.mm.pluginsdk.ui.tools.u.a((Context)localObject, new Intent(), str, paramDialogInterface);
          paramDialogInterface = c.HUw;
          c.w("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(1));
          paramDialogInterface = new Intent();
          localObject = this.HPw.parent.getContext();
          if (localObject == null)
          {
            paramDialogInterface = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(216672);
            throw paramDialogInterface;
            paramDialogInterface = null;
            break;
            label284:
            paramDialogInterface = null;
            continue;
            label289:
            paramDialogInterface = a.i(this.HPw);
            if (paramDialogInterface != null)
            {
              paramDialogInterface = paramDialogInterface.lfm;
              continue;
            }
            paramDialogInterface = null;
            continue;
          }
          ((Activity)localObject).setResult(-2, paramDialogInterface);
          paramDialogInterface = this.HPw.parent.getContext();
          if (paramDialogInterface == null)
          {
            paramDialogInterface = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(216672);
            throw paramDialogInterface;
          }
          ((Activity)paramDialogInterface).finish();
          Log.d("MicroMsg.EditCropVideoPlugin", "set RESULT_VIDEO_FINISH");
          AppMethodBeat.o(216672);
          return;
        }
      }
      Object localObject = WeSeeProvider.HIQ;
      paramDialogInterface = com.tencent.mm.pluginsdk.ui.tools.u.brZ(paramDialogInterface);
      p.j(paramDialogInterface, "TakePhotoUtil.parseWeSeeUri(videoPath)");
      WeSeeProvider.a.bi(paramDialogInterface, System.currentTimeMillis());
      paramDialogInterface = k.Ifq;
      paramDialogInterface = this.HPw.parent.getContext();
      p.j(paramDialogInterface, "parent.context");
      k.hT(paramDialogInterface);
      paramDialogInterface = c.HUw;
      c.w("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(3));
      AppMethodBeat.o(216672);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
  static final class h
    implements DialogInterface.OnClickListener
  {
    h(a parama, boolean paramBoolean) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(217710);
      if (bool)
      {
        paramDialogInterface = c.HUw;
        c.w("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(2));
      }
      for (;;)
      {
        Log.i("MicroMsg.EditCropVideoPlugin", "dialog cancel");
        if (a.h(this.HPw) == null) {
          break label120;
        }
        paramDialogInterface = a.h(this.HPw);
        if (paramDialogInterface != null) {
          break;
        }
        paramDialogInterface = new t("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(217710);
        throw paramDialogInterface;
        paramDialogInterface = c.HUw;
        c.w("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(4));
      }
      if (((Dialog)paramDialogInterface).isShowing())
      {
        paramDialogInterface = a.h(this.HPw);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        Log.i("MicroMsg.EditCropVideoPlugin", "click no dismiss dialog");
      }
      label120:
      AppMethodBeat.o(217710);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class i
    implements q.f
  {
    i(a parama, e parame) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(221207);
      this.qmB.setFooterView(null);
      paramo.clear();
      Object localObject;
      String str;
      if (a.b(this.HPw))
      {
        localObject = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
        str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNz, "");
        Log.i("MicroMsg.SecondCutConfig", "PopupFinderWordingConfig: ".concat(String.valueOf(str)));
        localObject = str;
        if (!TextUtils.isEmpty((CharSequence)str))
        {
          p.j(str, "result");
          localObject = com.tencent.mm.plugin.recordvideo.e.h.aWv(str);
          Log.i("MicroMsg.SecondCutConfig", "PopupFinderWordingParse: ".concat(String.valueOf(localObject)));
        }
        p.j(localObject, "result");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = this.HPw.parent.getContext();
          p.j(localObject, "parent.context");
          localObject = ((Context)localObject).getResources().getString(b.h.edit_post_video_with_finder);
          paramo.d(0, (CharSequence)localObject);
        }
      }
      else
      {
        if (a.c(this.HPw))
        {
          localObject = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
          str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNA, "");
          Log.i("MicroMsg.SecondCutConfig", "PopupSecondCutWordingConfig: ".concat(String.valueOf(str)));
          localObject = str;
          if (!TextUtils.isEmpty((CharSequence)str))
          {
            p.j(str, "result");
            localObject = com.tencent.mm.plugin.recordvideo.e.h.aWv(str);
            Log.i("MicroMsg.SecondCutConfig", "PopupSecondCutWordingParse: ".concat(String.valueOf(localObject)));
          }
          p.j(localObject, "result");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label440;
          }
          localObject = this.HPw.parent.getContext();
          p.j(localObject, "parent.context");
          localObject = ((Context)localObject).getResources().getString(b.h.edit_post_video_with_secondcut);
          label283:
          paramo.d(2, (CharSequence)localObject);
        }
        if (a.d(this.HPw))
        {
          localObject = com.tencent.mm.plugin.recordvideo.e.h.Ifn;
          str = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNB, "");
          Log.i("MicroMsg.SecondCutConfig", "PopupWeSeeWordingConfig: ".concat(String.valueOf(str)));
          localObject = str;
          if (!TextUtils.isEmpty((CharSequence)str))
          {
            p.j(str, "result");
            localObject = com.tencent.mm.plugin.recordvideo.e.h.aWv(str);
            Log.i("MicroMsg.SecondCutConfig", "PopupWeSeeWordingParse: ".concat(String.valueOf(localObject)));
          }
          p.j(localObject, "result");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            break label443;
          }
          localObject = this.HPw.parent.getContext();
          p.j(localObject, "parent.context");
          localObject = ((Context)localObject).getResources().getString(b.h.edit_post_video_with_wesee);
        }
      }
      label440:
      label443:
      for (;;)
      {
        paramo.d(1, (CharSequence)localObject);
        AppMethodBeat.o(221207);
        return;
        break;
        break label283;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
  static final class j
    implements q.g
  {
    j(a parama, aa.a parama1, e parame) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(218173);
      p.k(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        this.qmB.bYF();
        AppMethodBeat.o(218173);
        return;
        paramView.aaBx = false;
        a.e(this.HPw);
        paramMenuItem = c.HUw;
        c.Pt(1L);
        continue;
        paramView.aaBx = false;
        a.f(this.HPw);
        paramMenuItem = c.HUw;
        c.Pt(2L);
        continue;
        paramView.aaBx = false;
        a.g(this.HPw);
        paramMenuItem = c.HUw;
        c.Pt(4L);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class k
    implements e.b
  {
    k(aa.a parama) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(219935);
      if (this.jEV.aaBx)
      {
        c localc = c.HUw;
        c.Pt(3L);
      }
      AppMethodBeat.o(219935);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a
 * JD-Core Version:    0.7.0.1
 */
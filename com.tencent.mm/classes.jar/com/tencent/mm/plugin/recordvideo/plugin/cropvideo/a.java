package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider.a;
import com.tencent.mm.plugin.recordvideo.f.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.plugin.recordvideo.util.l;
import com.tencent.mm.plugin.recordvideo.util.n;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.f;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.am;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/mmsight/segment/ISegmentSeekBar$OnSeekBarChangedListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "cropBtn", "Landroid/widget/ImageView;", "cropEnd", "", "cropRecyclerThumbSeekBar", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;", "cropStart", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "entranceNum", "", "finderEnable", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "jumpHideAnimation", "longVideoTv", "Landroid/widget/TextView;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "phoenixDialog", "secondCutEnable", "sourceVideoPath", "", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "weseeArrowBtn", "weseeBtn", "weseeEnable", "weseeWrapper", "changeThumbBarPercent", "", "currentTime", "forceCropVideo", "isForce", "getSmaller", "a", "b", "getString", "resId", "onBackPress", "onClick", "v", "Landroid/view/View;", "onClickFinder", "onClickSecondCut", "onClickWesee", "onDown", "left", "start", "end", "onMove", "onRecyclerChanged", "onUp", "release", "reset", "resetConfirmStyle", "bgStyleResId", "textColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "setCaptureInfo", "captureInfo", "setJumpHideAnimation", "jump", "setUIParams", "seekbarHeight", "bgResId", "setVisibility", "visibility", "showBottomSheet", "showWeSeeBtn", "startLoadThumbBitmap", "synCropInfo", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements View.OnClickListener, c.b, v
{
  public static final a.a NLO;
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private final ImageView NLP;
  public final EditVideoSeekBarView NLQ;
  private final ViewGroup NLR;
  private final ImageView NLS;
  private final ImageView NLT;
  private final TextView NLU;
  private com.tencent.mm.media.widget.camerarecordview.b.b NLV;
  private e NLW;
  public boolean NLX;
  private float NLY;
  private float NLZ;
  private boolean NMa;
  private boolean NMb;
  private boolean NMc;
  private int NMd;
  private String nJU;
  private RecordConfigProvider oaV;
  private ViewGroup parent;
  private e qkG;
  
  static
  {
    AppMethodBeat.i(75702);
    NLO = new a.a((byte)0);
    AppMethodBeat.o(75702);
  }
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75701);
    this.parent = paramViewGroup;
    this.GrC = parama;
    paramViewGroup = this.parent.findViewById(b.e.editor_crop_video);
    kotlin.g.b.s.s(paramViewGroup, "parent.findViewById(R.id.editor_crop_video)");
    this.NLP = ((ImageView)paramViewGroup);
    paramViewGroup = this.parent.findViewById(b.e.editor_crop_bar);
    kotlin.g.b.s.s(paramViewGroup, "parent.findViewById(R.id.editor_crop_bar)");
    this.NLQ = ((EditVideoSeekBarView)paramViewGroup);
    this.NLR = ((ViewGroup)this.parent.findViewById(b.e.wrapper_editor_wesee));
    this.NLS = ((ImageView)this.parent.findViewById(b.e.iv_editor_wesee));
    this.NLT = ((ImageView)this.parent.findViewById(b.e.iv_wesee_arrow));
    this.NLU = ((TextView)this.parent.findViewById(b.e.tv_editor_wesee));
    this.NLZ = 1.0F;
    this.nJU = "";
    this.NLP.setImageDrawable(bb.m(this.parent.getContext(), b.g.icons_filled_crop, -1));
    this.NLP.setOnClickListener((View.OnClickListener)this);
    this.NLQ.setCancelButtonClickListener((View.OnClickListener)this);
    this.NLQ.setFinishButtonClickListener((View.OnClickListener)this);
    paramViewGroup = this.NLQ.getLayoutParams();
    if (paramViewGroup == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(75701);
      throw paramViewGroup;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramViewGroup;
    paramViewGroup.bottomMargin += bf.bk(this.parent.getContext());
    this.NLQ.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
    AppMethodBeat.o(75701);
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(281071);
    kotlin.g.b.s.u(parama, "this$0");
    Log.i("MicroMsg.EditCropVideoPlugin", "dialog cancel");
    if (parama.NLW != null)
    {
      paramDialogInterface = parama.NLW;
      if (paramDialogInterface == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(281071);
        throw parama;
      }
      if (((Dialog)paramDialogInterface).isShowing())
      {
        parama = parama.NLW;
        if (parama != null) {
          parama.dismiss();
        }
        Log.i("MicroMsg.EditCropVideoPlugin", "click no dismiss dialog");
      }
    }
    AppMethodBeat.o(281071);
  }
  
  private static final void a(a parama, boolean paramBoolean, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(281055);
    kotlin.g.b.s.u(parama, "this$0");
    if (parama.qkG != null)
    {
      paramDialogInterface = parama.qkG;
      if (paramDialogInterface == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(281055);
        throw parama;
      }
      if (((Dialog)paramDialogInterface).isShowing())
      {
        paramDialogInterface = parama.qkG;
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        Log.i("MicroMsg.EditCropVideoPlugin", "click ok dismiss dialog");
      }
    }
    Log.i("MicroMsg.EditCropVideoPlugin", kotlin.g.b.s.X("dialog ok isInstallWeSee:", Boolean.valueOf(paramBoolean)));
    paramDialogInterface = parama.NLV;
    if (paramDialogInterface == null)
    {
      paramDialogInterface = null;
      if (paramDialogInterface == null) {
        break label281;
      }
      paramDialogInterface = parama.NLV;
      if (paramDialogInterface != null) {
        break label273;
      }
      paramDialogInterface = null;
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject = g.NRB;
        g.agP(2);
        localObject = g.NRB;
        g.aQ(3, 1L);
        localObject = n.ObK;
        localObject = parama.parent.getContext();
        kotlin.g.b.s.s(localObject, "parent.context");
        kotlin.g.b.s.checkNotNull(paramDialogInterface);
        kotlin.g.b.s.u(localObject, "context");
        kotlin.g.b.s.u(paramDialogInterface, "videoPath");
        String str = n.tI(com.tencent.mm.model.cn.bDv());
        t.a((Context)localObject, new Intent(), str, paramDialogInterface);
        paramDialogInterface = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(1));
        paramDialogInterface = new Intent();
        localObject = parama.parent.getContext();
        if (localObject == null)
        {
          parama = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(281055);
          throw parama;
          paramDialogInterface = paramDialogInterface.nJU;
          break;
          label273:
          paramDialogInterface = paramDialogInterface.nJU;
          continue;
          label281:
          paramDialogInterface = parama.NLV;
          if (paramDialogInterface == null)
          {
            paramDialogInterface = null;
            continue;
          }
          paramDialogInterface = paramDialogInterface.nJX;
          continue;
        }
        ((Activity)localObject).setResult(-2, paramDialogInterface);
        parama = parama.parent.getContext();
        if (parama == null)
        {
          parama = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(281055);
          throw parama;
        }
        ((Activity)parama).finish();
        Log.d("MicroMsg.EditCropVideoPlugin", "set RESULT_VIDEO_FINISH");
        AppMethodBeat.o(281055);
        return;
      }
    }
    Object localObject = WeSeeProvider.NFX;
    paramDialogInterface = t.brQ(paramDialogInterface);
    kotlin.g.b.s.s(paramDialogInterface, "parseWeSeeUri(videoPath)");
    WeSeeProvider.a.bt(paramDialogInterface, System.currentTimeMillis());
    paramDialogInterface = n.ObK;
    parama = parama.parent.getContext();
    kotlin.g.b.s.s(parama, "parent.context");
    n.js(parama);
    parama = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.I("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(3));
    AppMethodBeat.o(281055);
  }
  
  private static final void a(f paramf, a parama, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(281038);
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    kotlin.g.b.s.u(parama, "this$0");
    paramf.setFooterView(null);
    params.clear();
    String str;
    if (parama.NMa)
    {
      paramf = com.tencent.mm.plugin.recordvideo.util.k.ObH;
      str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zfy, "");
      Log.i("MicroMsg.SecondCutConfig", kotlin.g.b.s.X("PopupFinderWordingConfig: ", str));
      paramf = str;
      if (!TextUtils.isEmpty((CharSequence)str))
      {
        kotlin.g.b.s.s(str, "result");
        paramf = com.tencent.mm.plugin.recordvideo.util.k.aTJ(str);
        Log.i("MicroMsg.SecondCutConfig", kotlin.g.b.s.X("PopupFinderWordingParse: ", paramf));
      }
      kotlin.g.b.s.s(paramf, "result");
      if (TextUtils.isEmpty((CharSequence)paramf))
      {
        paramf = parama.parent.getContext().getResources().getString(b.h.edit_post_video_with_finder_2);
        params.c(0, (CharSequence)paramf);
      }
    }
    else
    {
      if (parama.NMc)
      {
        paramf = com.tencent.mm.plugin.recordvideo.util.k.ObH;
        str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zfz, "");
        Log.i("MicroMsg.SecondCutConfig", kotlin.g.b.s.X("PopupSecondCutWordingConfig: ", str));
        paramf = str;
        if (!TextUtils.isEmpty((CharSequence)str))
        {
          kotlin.g.b.s.s(str, "result");
          paramf = com.tencent.mm.plugin.recordvideo.util.k.aTJ(str);
          Log.i("MicroMsg.SecondCutConfig", kotlin.g.b.s.X("PopupSecondCutWordingParse: ", paramf));
        }
        kotlin.g.b.s.s(paramf, "result");
        if (!TextUtils.isEmpty((CharSequence)paramf)) {
          break label417;
        }
        paramf = parama.parent.getContext().getResources().getString(b.h.edit_post_video_with_secondcut);
        label271:
        params.c(2, (CharSequence)paramf);
      }
      if (parama.NMb)
      {
        paramf = com.tencent.mm.plugin.recordvideo.util.k.ObH;
        str = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zfA, "");
        Log.i("MicroMsg.SecondCutConfig", kotlin.g.b.s.X("PopupWeSeeWordingConfig: ", str));
        paramf = str;
        if (!TextUtils.isEmpty((CharSequence)str))
        {
          kotlin.g.b.s.s(str, "result");
          paramf = com.tencent.mm.plugin.recordvideo.util.k.aTJ(str);
          Log.i("MicroMsg.SecondCutConfig", kotlin.g.b.s.X("PopupWeSeeWordingParse: ", paramf));
        }
        kotlin.g.b.s.s(paramf, "result");
        if (!TextUtils.isEmpty((CharSequence)paramf)) {
          break label420;
        }
        paramf = parama.parent.getContext().getResources().getString(b.h.edit_post_video_with_wesee);
      }
    }
    label417:
    label420:
    for (;;)
    {
      params.c(1, (CharSequence)paramf);
      AppMethodBeat.o(281038);
      return;
      break;
      break label271;
    }
  }
  
  private static final void a(ah.a parama)
  {
    AppMethodBeat.i(281048);
    kotlin.g.b.s.u(parama, "$cancel");
    if (parama.aiwY)
    {
      parama = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.tt(3L);
    }
    AppMethodBeat.o(281048);
  }
  
  private static final void a(ah.a parama, a parama1, f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(281044);
    kotlin.g.b.s.u(parama, "$cancel");
    kotlin.g.b.s.u(parama1, "this$0");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    kotlin.g.b.s.u(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      paramf.cyW();
      AppMethodBeat.o(281044);
      return;
      parama.aiwY = false;
      parama1.gIP();
      parama = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.tt(1L);
      continue;
      parama.aiwY = false;
      parama1.gIQ();
      parama = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.tt(2L);
      continue;
      parama.aiwY = false;
      parama1.gIR();
      parama = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.tt(4L);
    }
  }
  
  private static final void a(boolean paramBoolean, a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(281059);
    kotlin.g.b.s.u(parama, "this$0");
    if (paramBoolean)
    {
      paramDialogInterface = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(2));
    }
    for (;;)
    {
      Log.i("MicroMsg.EditCropVideoPlugin", "dialog cancel");
      if (parama.qkG == null) {
        break label124;
      }
      paramDialogInterface = parama.qkG;
      if (paramDialogInterface != null) {
        break;
      }
      parama = new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
      AppMethodBeat.o(281059);
      throw parama;
      paramDialogInterface = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(4));
    }
    if (((Dialog)paramDialogInterface).isShowing())
    {
      parama = parama.qkG;
      if (parama != null) {
        parama.dismiss();
      }
      Log.i("MicroMsg.EditCropVideoPlugin", "click no dismiss dialog");
    }
    label124:
    AppMethodBeat.o(281059);
  }
  
  private final void aL(float paramFloat1, float paramFloat2)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(75697);
    Object localObject = this.NLV;
    int k;
    float f2;
    int i;
    if (localObject != null)
    {
      k = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).endTime - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).startTime;
      f2 = k;
      localObject = this.oaV;
      kotlin.g.b.s.checkNotNull(localObject);
      i = ((RecordConfigProvider)localObject).NHZ;
      localObject = this.NLV;
      kotlin.g.b.s.checkNotNull(localObject);
      f2 = (paramFloat2 - paramFloat1) * f2 - kH(i + 250, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).endTime);
      if (f2 >= 0.0F) {
        break label185;
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
      this.GrC.a(com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOJ, (Bundle)localObject);
      AppMethodBeat.o(75697);
      return;
      label185:
      f1 = f2;
    }
  }
  
  private static final void b(a parama, boolean paramBoolean, DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = null;
    int j = 0;
    AppMethodBeat.i(281067);
    kotlin.g.b.s.u(parama, "this$0");
    if (parama.NLW != null)
    {
      paramDialogInterface = parama.NLW;
      if (paramDialogInterface == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(281067);
        throw parama;
      }
      if (((Dialog)paramDialogInterface).isShowing())
      {
        paramDialogInterface = parama.NLW;
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        Log.i("MicroMsg.EditCropVideoPlugin", "click ok dismiss dialog");
      }
    }
    Log.i("MicroMsg.EditCropVideoPlugin", kotlin.g.b.s.X("dialog ok isInstall:", Boolean.valueOf(paramBoolean)));
    paramDialogInterface = parama.NLV;
    label129:
    int k;
    label177:
    int i;
    if (paramDialogInterface == null)
    {
      paramDialogInterface = null;
      if (paramDialogInterface == null) {
        break label326;
      }
      paramDialogInterface = parama.NLV;
      if (paramDialogInterface != null) {
        break label318;
      }
      paramDialogInterface = (DialogInterface)localObject;
      if (!paramBoolean) {
        break label443;
      }
      localObject = l.ObI;
      kotlin.g.b.s.checkNotNull(paramDialogInterface);
      localObject = com.tencent.mm.plugin.recordvideo.util.k.ObH;
      k = com.tencent.mm.plugin.recordvideo.util.k.gLn();
      localObject = parama.oaV;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((RecordConfigProvider)localObject).oXZ;
      if (localObject != null) {
        break label349;
      }
      paramInt = 0;
      localObject = parama.oaV;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((RecordConfigProvider)localObject).oXZ;
      if (localObject != null) {
        break label358;
      }
      i = 0;
      label203:
      localObject = parama.oaV;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((RecordConfigProvider)localObject).oXZ;
      if (localObject != null) {
        break label368;
      }
    }
    for (;;)
    {
      paramDialogInterface = l.b("moments", paramDialogInterface, k, paramInt, i, j);
      localObject = l.ObI;
      localObject = parama.parent.getContext();
      kotlin.g.b.s.s(localObject, "parent.context");
      l.aG((Context)localObject, paramDialogInterface);
      paramDialogInterface = new Intent();
      localObject = parama.parent.getContext();
      if (localObject != null) {
        break label378;
      }
      parama = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(281067);
      throw parama;
      paramDialogInterface = paramDialogInterface.nJU;
      break;
      label318:
      paramDialogInterface = paramDialogInterface.nJU;
      break label129;
      label326:
      com.tencent.mm.media.widget.camerarecordview.b.b localb = parama.NLV;
      paramDialogInterface = (DialogInterface)localObject;
      if (localb == null) {
        break label129;
      }
      paramDialogInterface = localb.nJX;
      break label129;
      label349:
      paramInt = ((VideoTransPara)localObject).videoBitrate;
      break label177;
      label358:
      i = ((VideoTransPara)localObject).width;
      break label203;
      label368:
      j = ((VideoTransPara)localObject).height;
    }
    label378:
    ((Activity)localObject).setResult(-2, paramDialogInterface);
    parama = parama.parent.getContext();
    if (parama == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(281067);
      throw parama;
    }
    ((Activity)parama).finish();
    Log.d("MicroMsg.EditCropVideoPlugin", "set RESULT_VIDEO_FINISH");
    AppMethodBeat.o(281067);
    return;
    label443:
    paramDialogInterface = com.tencent.mm.plugin.recordvideo.util.b.Obj;
    parama = parama.parent.getContext();
    kotlin.g.b.s.s(parama, "parent.context");
    paramDialogInterface = com.tencent.mm.plugin.recordvideo.util.k.ObH;
    com.tencent.mm.plugin.recordvideo.util.b.aL(parama, kotlin.g.b.s.X(com.tencent.mm.plugin.recordvideo.util.k.gLo(), "1102"));
    AppMethodBeat.o(281067);
  }
  
  private void gIO()
  {
    Object localObject2 = null;
    AppMethodBeat.i(280994);
    Object localObject1 = this.NLR;
    if (localObject1 != null) {
      ((ViewGroup)localObject1).setVisibility(0);
    }
    localObject1 = this.NLR;
    if (localObject1 != null) {
      ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)this);
    }
    localObject1 = this.NLS;
    if (localObject1 != null) {
      ((ImageView)localObject1).setImageDrawable(bb.m(this.parent.getContext(), b.g.icons_filled_wesee, -1));
    }
    localObject1 = this.NLT;
    if (localObject1 != null) {
      ((ImageView)localObject1).setImageDrawable(bb.m(this.parent.getContext(), b.g.icons_filled_arrow, -1));
    }
    localObject1 = this.NLR;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!aw.bx((Context)localObject1)) {
        break label213;
      }
      localObject1 = this.NLR;
      if (localObject1 != null) {
        break label153;
      }
    }
    label153:
    for (localObject1 = null;; localObject1 = ((ViewGroup)localObject1).getLayoutParams())
    {
      if (localObject1 != null) {
        break label161;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(280994);
      throw ((Throwable)localObject1);
      localObject1 = ((ViewGroup)localObject1).getContext();
      break;
    }
    label161:
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localObject1;
    int i = localMarginLayoutParams.topMargin;
    localObject1 = this.NLR;
    if (localObject1 == null) {}
    for (localObject1 = localObject2;; localObject1 = ((ViewGroup)localObject1).getContext())
    {
      localMarginLayoutParams.topMargin = (aw.bw((Context)localObject1) + i);
      localObject1 = this.NLR;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localMarginLayoutParams);
      }
      label213:
      AppMethodBeat.o(280994);
      return;
    }
  }
  
  private final void gIP()
  {
    Object localObject2 = null;
    AppMethodBeat.i(281000);
    Object localObject1 = g.NRB;
    g.agP(3);
    localObject1 = g.NRB;
    g.aQ(3, 1L);
    Intent localIntent = new Intent();
    ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(4, 5, 44, localIntent);
    com.tencent.mm.plugin.findersdk.a.cn localcn = (com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class);
    Context localContext = this.parent.getContext();
    localIntent.putExtra("key_finder_sns_post_type", 3);
    localIntent.putExtra("key_finder_post_router", 6);
    localIntent.putExtra("key_finder_post_from", 6);
    localIntent.putExtra("key_form_sns", true);
    localIntent.putExtra("KEY_POST_DIRECTLY_FROM_SNS", true);
    localObject1 = this.NLV;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label222;
      }
      localObject1 = this.NLV;
      if (localObject1 != null) {
        break label214;
      }
      localObject1 = localObject2;
      label153:
      localIntent.putExtra("key_finder_post_sns_video_path", (String)localObject1);
      localObject1 = this.NLV;
      if (localObject1 != null) {
        break label244;
      }
    }
    label214:
    label222:
    label244:
    for (int i = 0;; i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime)
    {
      localIntent.putExtra("key_finder_post_sns_video_duration_ms", i);
      localObject1 = ah.aiuX;
      localcn.enterFinderPostRouterUI(localContext, localIntent);
      AppMethodBeat.o(281000);
      return;
      localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU;
      break;
      localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU;
      break label153;
      com.tencent.mm.media.widget.camerarecordview.b.b localb = this.NLV;
      localObject1 = localObject2;
      if (localb == null) {
        break label153;
      }
      localObject1 = localb.nJX;
      break label153;
    }
  }
  
  private final void gIQ()
  {
    AppMethodBeat.i(281005);
    Object localObject = n.ObK;
    localObject = this.parent.getContext();
    kotlin.g.b.s.s(localObject, "parent.context");
    boolean bool = n.jr((Context)localObject);
    localObject = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.I("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(1));
    Context localContext = this.parent.getContext();
    if (bool) {}
    for (localObject = getString(b.h.app_field_weishi_jump_tip_new);; localObject = getString(b.h.app_field_weishi_install_tip))
    {
      this.qkG = com.tencent.mm.ui.base.k.b(localContext, (String)localObject, "", getString(b.h.app_ok), getString(b.h.app_cancel), new a..ExternalSyntheticLambda1(this, bool), new a..ExternalSyntheticLambda3(bool, this));
      AppMethodBeat.o(281005);
      return;
    }
  }
  
  private final void gIR()
  {
    AppMethodBeat.i(281010);
    Object localObject = com.tencent.mm.plugin.recordvideo.util.b.Obj;
    localObject = this.parent.getContext();
    kotlin.g.b.s.s(localObject, "parent.context");
    boolean bool = com.tencent.mm.plugin.recordvideo.util.b.D((Context)localObject, "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF");
    Context localContext = this.parent.getContext();
    if (bool) {}
    for (localObject = getString(b.h.app_field_secondcut_jump_tip);; localObject = getString(b.h.app_field_secondcut_install_tip))
    {
      this.NLW = com.tencent.mm.ui.base.k.b(localContext, (String)localObject, "", getString(b.h.app_ok), getString(b.h.app_cancel), new a..ExternalSyntheticLambda2(this, bool), new a..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(281010);
      return;
    }
  }
  
  private final String getString(int paramInt)
  {
    AppMethodBeat.i(75691);
    if (this.parent.getContext() != null)
    {
      String str = this.parent.getContext().getString(paramInt);
      kotlin.g.b.s.s(str, "parent.context.getString(resId)");
      AppMethodBeat.o(75691);
      return str;
    }
    AppMethodBeat.o(75691);
    return "";
  }
  
  private static int kH(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public final void Bb(boolean paramBoolean)
  {
    AppMethodBeat.i(75689);
    Object localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
    com.tencent.mm.plugin.recordvideo.f.c.agG(13);
    localObject1 = this.NLV;
    int i;
    if ((localObject1 != null) && (!kotlin.g.b.s.p(this.nJU, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU)))
    {
      this.nJU = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU;
      localObject2 = this.oaV;
      if (localObject2 != null)
      {
        if (((RecordConfigProvider)localObject2).NIa < 0) {
          break label771;
        }
        i = kH(((RecordConfigProvider)localObject2).NIa, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime);
        Log.i("MicroMsg.EditCropVideoPlugin", "duration:" + kH(((RecordConfigProvider)localObject2).NHZ, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime) + " minDuration:" + i);
        this.NLQ.aJ(((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).nJU, kH(((RecordConfigProvider)localObject2).NHZ, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime), (int)Math.ceil(i * 1.0D / 1000.0D));
        this.NLQ.setThumbBarSeekListener((c.b)this);
        this.NLZ = (kH(((RecordConfigProvider)localObject2).NHZ, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime) * 1.0F / ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime);
      }
    }
    this.NLQ.setVisibility(0);
    Log.d("MicroMsg.EditCropVideoPlugin", kotlin.g.b.s.X("forceCropVideo isForce: ", Boolean.valueOf(paramBoolean)));
    Object localObject2 = new Bundle();
    label263:
    label291:
    boolean bool1;
    label378:
    Object localObject3;
    if (paramBoolean)
    {
      localObject1 = this.oaV;
      if ((localObject1 == null) || (((RecordConfigProvider)localObject1).scene != 2)) {
        break label795;
      }
      i = 1;
      if (i != 0)
      {
        if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zfn, 1) != 1) {
          break label800;
        }
        paramBoolean = true;
        boolean bool2 = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).showPostEntry();
        boolean bool3 = TextUtils.equals((CharSequence)((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zmX, "0"), (CharSequence)"1");
        boolean bool4 = MMApplicationContext.getDefaultPreference().getBoolean("wesee_switch", false);
        localObject1 = com.tencent.mm.plugin.recordvideo.util.k.ObH;
        this.NMc = com.tencent.mm.plugin.recordvideo.util.k.gLm();
        if ((!paramBoolean) || (!bool2)) {
          break label805;
        }
        bool1 = true;
        this.NMa = bool1;
        if ((!bool3) && (!bool4)) {
          break label810;
        }
        bool1 = true;
        label395:
        this.NMb = bool1;
        Log.i("MicroMsg.EditCropVideoPlugin", "sns2FinderEnable:" + paramBoolean + ", showPostEntry:" + bool2 + ", showWeseeEntry:" + bool3 + ", weseeCommandSwitch:" + bool4);
        if (this.NMa) {
          this.NMd += 1;
        }
        if (this.NMb) {
          this.NMd += 1;
        }
        if (this.NMc) {
          this.NMd += 1;
        }
        if (this.NMd < 2) {
          break label824;
        }
        localObject1 = this.oaV;
        if (localObject1 != null) {
          break label815;
        }
        i = 10000;
        label530:
        i /= 1000;
        localObject1 = this.NLU;
        if (localObject1 != null)
        {
          localObject3 = am.aixg;
          localObject3 = this.parent.getContext().getResources().getString(b.h.edit_post_long_content);
          kotlin.g.b.s.s(localObject3, "parent.context.resources…g.edit_post_long_content)");
          localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
          kotlin.g.b.s.s(localObject3, "java.lang.String.format(format, *args)");
          ((TextView)localObject1).setText((CharSequence)localObject3);
        }
        localObject1 = this.NLS;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(8);
        }
        gIO();
        if (this.NMb)
        {
          ((Bundle)localObject2).putBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", true);
          localObject1 = WeSeeProvider.NFX;
          WeSeeProvider.a.gDE();
          localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.I("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(1));
        }
        localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.ts(3L);
        label690:
        localObject1 = n.ObK;
        localObject1 = this.parent.getContext();
        kotlin.g.b.s.s(localObject1, "parent.context");
        if (!n.jr((Context)localObject1)) {
          break label1188;
        }
        localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_IS_INSTALL_WESEE", Integer.valueOf(1));
      }
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_IS_CLICK_WESEE_BTN", Integer.valueOf(2));
      this.GrC.a(com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOH, (Bundle)localObject2);
      AppMethodBeat.o(75689);
      return;
      label771:
      i = kH(((RecordConfigProvider)localObject2).oXZ.minDuration * 1000, ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime);
      break;
      label795:
      i = 0;
      break label263;
      label800:
      paramBoolean = false;
      break label291;
      label805:
      bool1 = false;
      break label378;
      label810:
      bool1 = false;
      break label395;
      label815:
      i = ((RecordConfigProvider)localObject1).NHZ;
      break label530;
      label824:
      com.tencent.mm.plugin.recordvideo.util.k localk;
      if ((this.NMa) || (this.NMc))
      {
        localObject3 = this.NLU;
        if (localObject3 != null) {
          if (!this.NMa) {
            break label935;
          }
        }
        for (localObject1 = (CharSequence)this.parent.getContext().getResources().getString(b.h.edit_post_video_with_finder_2);; localObject1 = (CharSequence)localObject1)
        {
          ((TextView)localObject3).setText((CharSequence)localObject1);
          localObject1 = this.NLS;
          if (localObject1 != null) {
            ((ImageView)localObject1).setVisibility(8);
          }
          gIO();
          localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.I("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(2));
          localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.ts(3L);
          break;
          label935:
          localObject1 = am.aixg;
          localObject1 = this.parent.getContext().getResources().getString(b.h.edit_secondcut_post_content);
          kotlin.g.b.s.s(localObject1, "parent.context.resources…t_secondcut_post_content)");
          localk = com.tencent.mm.plugin.recordvideo.util.k.ObH;
          localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.plugin.recordvideo.util.k.gLp()) }, 1));
          kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
        }
      }
      if (this.NMb)
      {
        localObject1 = this.NLU;
        if (localObject1 != null)
        {
          localObject3 = am.aixg;
          localObject3 = this.parent.getContext().getResources().getString(b.h.edit_wesee_content);
          kotlin.g.b.s.s(localObject3, "parent.context.resources…tring.edit_wesee_content)");
          localk = com.tencent.mm.plugin.recordvideo.util.k.ObH;
          localObject3 = String.format((String)localObject3, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.plugin.recordvideo.util.k.gLq()) }, 1));
          kotlin.g.b.s.s(localObject3, "java.lang.String.format(format, *args)");
          ((TextView)localObject1).setText((CharSequence)localObject3);
        }
        localObject1 = this.NLS;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        ((Bundle)localObject2).putBoolean("EDIT_CROP_VIDEO_SHOW_WESEE_SWITCH_BOOLEAN", true);
        gIO();
        localObject1 = WeSeeProvider.NFX;
        WeSeeProvider.a.gDE();
        localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.I("KEY_IS_SHOW_WESEE_BTN", Integer.valueOf(1));
        localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.ts(2L);
        break label690;
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.ts(1L);
      break label690;
      label1188:
      localObject1 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
      com.tencent.mm.plugin.recordvideo.f.c.I("KEY_IS_INSTALL_WESEE", Integer.valueOf(2));
    }
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(281162);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(281162);
  }
  
  public final void aE(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75692);
    Log.d("MicroMsg.EditCropVideoPlugin", "onRecyclerChanged : " + paramFloat1 + ' ' + paramFloat2);
    this.NLY = paramFloat1;
    this.NLZ = paramFloat2;
    aL(paramFloat1, paramFloat2);
    AppMethodBeat.o(75692);
  }
  
  public final void aF(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(75695);
    Log.d("MicroMsg.EditCropVideoPlugin", "onMove : " + paramFloat1 + ' ' + paramFloat2);
    AppMethodBeat.o(75695);
  }
  
  public final void b(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(281148);
    Log.d("MicroMsg.EditCropVideoPlugin", "onDown : " + paramFloat1 + ' ' + paramFloat2);
    Object localObject = this.parent.getContext();
    if (paramBoolean) {}
    for (int i = b.h.aging_crop_video_click_bar_left;; i = b.h.aging_crop_video_click_bar_right)
    {
      localObject = com.tencent.mm.cd.a.bt((Context)localObject, i);
      this.NLQ.announceForAccessibility((CharSequence)localObject);
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOL);
      AppMethodBeat.o(281148);
      return;
    }
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(281168);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(281168);
  }
  
  public final void c(com.tencent.mm.media.widget.camerarecordview.b.b paramb, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(281121);
    kotlin.g.b.s.u(paramb, "captureInfo");
    kotlin.g.b.s.u(paramRecordConfigProvider, "configProvider");
    this.NLV = paramb;
    this.oaV = paramRecordConfigProvider;
    AppMethodBeat.o(281121);
  }
  
  public final void c(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(281153);
    Log.d("MicroMsg.EditCropVideoPlugin", "onUp : " + paramFloat1 + ' ' + paramFloat2);
    this.NLY = paramFloat1;
    this.NLZ = paramFloat2;
    aL(paramFloat1, paramFloat2);
    Object localObject1 = this.NLV;
    int i;
    if (localObject1 != null)
    {
      i = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).endTime - ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).startTime;
      localObject1 = am.aixg;
      if (!paramBoolean) {
        break label203;
      }
    }
    label203:
    for (paramFloat1 = i * paramFloat1 / 1000.0F;; paramFloat1 = i * paramFloat2 / 1000.0F)
    {
      localObject1 = String.format("%.2f", Arrays.copyOf(new Object[] { Float.valueOf(paramFloat1) }, 1));
      kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
      Object localObject2 = am.aixg;
      localObject2 = com.tencent.mm.cd.a.bt(this.parent.getContext(), b.h.aging_time_in_crop_video);
      kotlin.g.b.s.s(localObject2, "getString(parent.context…aging_time_in_crop_video)");
      localObject1 = String.format((String)localObject2, Arrays.copyOf(new Object[] { localObject1 }, 1));
      kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
      this.NLQ.announceForAccessibility((CharSequence)localObject1);
      AppMethodBeat.o(281153);
      return;
    }
  }
  
  public final String name()
  {
    AppMethodBeat.i(281164);
    String str = v.a.b(this);
    AppMethodBeat.o(281164);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(281166);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(281166);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75698);
    ViewGroup localViewGroup = this.NLR;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
    if (this.NLQ.getVisibility() == 0)
    {
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NON);
      this.NLQ.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new b(this));
      AppMethodBeat.o(75698);
      return true;
    }
    AppMethodBeat.o(75698);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75690);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      localObject = null;
      i = b.e.edit_text_cancel;
      if (localObject != null) {
        break label111;
      }
      label53:
      i = b.e.edit_text_ok;
      if (localObject != null) {
        break label189;
      }
      label61:
      i = b.e.editor_crop_video;
      if (localObject != null) {
        break label351;
      }
      label69:
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
      localObject = Integer.valueOf(paramView.getId());
      break;
      label111:
      if (((Integer)localObject).intValue() != i) {
        break label53;
      }
      this.NLQ.Leu.reset();
      com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NON);
      this.NLQ.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new c(this));
      paramView = this.NLR;
      if (paramView != null)
      {
        paramView.setVisibility(8);
        continue;
        label189:
        if (((Integer)localObject).intValue() != i) {
          break label61;
        }
        aL(this.NLY, this.NLZ);
        com.tencent.mm.plugin.recordvideo.plugin.parent.a.b.a(this.GrC, com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NOO);
        if (!this.NLX) {
          this.NLQ.animate().alpha(0.0F).setDuration(100L).setListener((Animator.AnimatorListener)new d(this));
        }
        paramView = this.NLR;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = this.NLV;
        if (paramView != null)
        {
          i = paramView.endTime - paramView.startTime;
          paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.I("KEY_VIDEO_CROP_DURATION_MS_INT", Integer.valueOf((int)(i * (this.NLZ - this.NLY))));
          paramView = g.NRB;
          g.tw((i * this.NLY));
          paramView = g.NRB;
          g.tx((i * this.NLZ));
          continue;
          label351:
          if (((Integer)localObject).intValue() != i) {
            break label69;
          }
          Bb(false);
          paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
          com.tencent.mm.plugin.recordvideo.f.c.aTg("KEY_CLICK_VIDEO_CROP_COUNT_INT");
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
            if (this.NMd >= 2)
            {
              paramView = com.tencent.mm.plugin.recordvideo.f.c.NRf;
              com.tencent.mm.plugin.recordvideo.f.c.gJh();
              paramView = new ah.a();
              paramView.aiwY = true;
              localObject = new f(this.parent.getContext(), 1, true);
              ((f)localObject).Vtg = new a..ExternalSyntheticLambda4((f)localObject, this);
              ((f)localObject).GAC = new a..ExternalSyntheticLambda5(paramView, this, (f)localObject);
              ((f)localObject).aeLi = new a..ExternalSyntheticLambda6(paramView);
              ((f)localObject).dDn();
            }
            else if (this.NMa)
            {
              gIP();
            }
            else if (this.NMb)
            {
              gIQ();
            }
            else if (this.NMc)
            {
              gIR();
            }
          }
        }
      }
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(281171);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(281171);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(281172);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(281172);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(281175);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(281175);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(281176);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(281176);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75700);
    this.NLQ.release();
    if (this.qkG != null)
    {
      Object localObject = this.qkG;
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(75700);
        throw ((Throwable)localObject);
      }
      if (((Dialog)localObject).isShowing())
      {
        localObject = this.qkG;
        if (localObject != null) {
          ((e)localObject).dismiss();
        }
        Log.i("MicroMsg.EditCropVideoPlugin", "release dismiss dialog");
      }
    }
    AppMethodBeat.o(75700);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75699);
    kotlin.g.b.s.u((v)this, "this");
    this.nJU = "";
    this.NLQ.release();
    AppMethodBeat.o(75699);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75696);
    this.NLP.setVisibility(paramInt);
    AppMethodBeat.o(75696);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onBackPress$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(a parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75684);
      kotlin.g.b.s.u(paramAnimator, "animation");
      a.a(this.NMe).setVisibility(8);
      a.a(this.NMe).setAlpha(1.0F);
      AppMethodBeat.o(75684);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(a parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75685);
      kotlin.g.b.s.u(paramAnimator, "animation");
      a.a(this.NMe).setVisibility(8);
      a.a(this.NMe).setAlpha(1.0F);
      AppMethodBeat.o(75685);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin$onClick$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(a parama) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(75686);
      kotlin.g.b.s.u(paramAnimator, "animation");
      a.a(this.NMe).setVisibility(8);
      a.a(this.NMe).setAlpha(1.0F);
      AppMethodBeat.o(75686);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a
 * JD-Core Version:    0.7.0.1
 */
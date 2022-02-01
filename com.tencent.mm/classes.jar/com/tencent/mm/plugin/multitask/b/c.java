package com.tencent.mm.plugin.multitask.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.multitask.animation.swipeahead.FloatMultiTaskIndicatorView;
import com.tencent.mm.plugin.multitask.c.e;
import com.tencent.mm.plugin.multitask.d.b;
import com.tencent.mm.plugin.multitask.e.b.a;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskFloatBallView;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "baseMultiTaskSwipeBackAnimWrapper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "getBaseMultiTaskSwipeBackAnimWrapper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "setBaseMultiTaskSwipeBackAnimWrapper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;)V", "canSwipeBackToMultiTask", "", "getCanSwipeBackToMultiTask", "()Z", "setCanSwipeBackToMultiTask", "(Z)V", "enterTransformationListener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "getEnterTransformationListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "setEnterTransformationListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;)V", "floatBallTransformationListener", "getFloatBallTransformationListener", "setFloatBallTransformationListener", "floatIndicatorController", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;", "getFloatIndicatorController", "()Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;", "setFloatIndicatorController", "(Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;)V", "homeSnapBlt", "Landroid/graphics/Bitmap;", "getHomeSnapBlt", "()Landroid/graphics/Bitmap;", "isFromMultiTaskItem", "<set-?>", "isFromTaskBar", "()Ljava/lang/Boolean;", "setFromTaskBar", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isVisiableButtom", "setVisiableButtom", "isVisiableTop", "setVisiableTop", "mIsLandScape", "getMIsLandScape", "setMIsLandScape", "multiTaskItemPos", "", "getMultiTaskItemPos", "()I", "setMultiTaskItemPos", "(I)V", "multiTaskSnapBlt", "getMultiTaskSnapBlt", "multiTaskUIManager", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;", "getMultiTaskUIManager", "()Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;", "setMultiTaskUIManager", "(Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;)V", "", "ori_position", "getOri_position", "()Ljava/lang/String;", "setOri_position", "(Ljava/lang/String;)V", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "position", "getPosition", "setPosition", "readEnded", "swipeAheadMultiTaskListener", "Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "getSwipeAheadMultiTaskListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "setSwipeAheadMultiTaskListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;)V", "swipeBackTransformationListener", "getSwipeBackTransformationListener", "setSwipeBackTransformationListener", "swipeBlt", "getSwipeBlt", "setSwipeBlt", "(Landroid/graphics/Bitmap;)V", "transformListener", "getTransformListener", "setTransformListener", "addOrUpdateCurrentHistoryTaskInfo", "", "beforeOnMenuEnterOrSwipebackToMultiTask", "onMenuFloatBallSelectCallback", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "canSwipeToMultiTask", "checkBitmap", "bitmap", "isLandScape", "createEnterTransformationListener", "createFloatBallTransformationListener", "createMultiTaskEnterAndBackAnimation", "createMultiTaskUIManager", "createSwipeAheadToMultiTaskListener", "createSwipeBackTransformationListener", "finishPage", "getHistoryBitmapOnClose", "initData", "initReportData", "onClose", "way", "ended", "onCreate", "multiTaskType", "multiTaskId", "onDestroy", "onMenuMultiTaskSelected", "enterMultiTask", "generateType", "onMultiTaskAnimDone", "forceUpdate", "needUpdateInfo", "needShowTip", "onMultiTaskPanelClicked", "onMultiTaskPanelDelete", "onMultiTaskPanelHide", "onMultiTaskPanelShow", "anim", "onOrientationChange", "orientation", "onSwipePageAddToMultiTask", "restoreCurrentBallWhenNonPassiveClose", "setMultiTaskCommonInfo", "commonData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "setSwipeToMultiTaskEnable", "enable", "setTransformationListener", "listener", "showHome", "Companion", "OnMenuMultiTaskSelectCallback", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  extends a
  implements com.tencent.mm.plugin.multitask.c.d
{
  public static final c.a LCL;
  public com.tencent.mm.plugin.multitask.a.a LBU;
  com.tencent.mm.plugin.multitask.c.c LCM;
  private com.tencent.mm.plugin.multitask.c.c LCN;
  private com.tencent.mm.plugin.multitask.c.c LCO;
  private e LCP;
  private com.tencent.mm.plugin.multitask.animation.swipeahead.b LCQ;
  private com.tencent.mm.plugin.multitask.animation.c.a.a LCR;
  com.tencent.mm.plugin.multitask.c.c LCS;
  private String LCT;
  private Boolean LCU;
  private Boolean LCV;
  public Boolean LCW;
  private int LCX;
  Bitmap LCY;
  boolean LCZ;
  com.tencent.mm.plugin.multitask.ui.d LDa;
  boolean LDb;
  private boolean LDc;
  private String qWi;
  
  static
  {
    AppMethodBeat.i(304005);
    LCL = new c.a((byte)0);
    AppMethodBeat.o(304005);
  }
  
  public c(byte paramByte)
  {
    this();
  }
  
  public c(com.tencent.mm.plugin.multitask.a.a parama)
  {
    this.LBU = parama;
    this.LCU = Boolean.FALSE;
    this.LCV = Boolean.FALSE;
    this.LCW = Boolean.FALSE;
    this.LCX = -1;
  }
  
  private static final void a(c paramc)
  {
    Object localObject2 = null;
    AppMethodBeat.i(303940);
    s.u(paramc, "this$0");
    Object localObject1;
    if (paramc.LBU != null)
    {
      localObject1 = paramc.LBU;
      if (localObject1 != null) {
        break label64;
      }
      localObject1 = null;
      if (localObject1 != null)
      {
        paramc = paramc.LBU;
        if (paramc != null) {
          break label74;
        }
      }
    }
    label64:
    label74:
    for (paramc = localObject2;; paramc = paramc.getContentView())
    {
      if (paramc != null) {
        paramc.setVisibility(0);
      }
      AppMethodBeat.o(303940);
      return;
      localObject1 = ((com.tencent.mm.plugin.multitask.a.a)localObject1).getContentView();
      break;
    }
  }
  
  private boolean cod()
  {
    AppMethodBeat.i(303893);
    Object localObject = this.LBU;
    byte[] arrayOfByte;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getIntent();
      if (localObject != null)
      {
        arrayOfByte = ((Intent)localObject).getByteArrayExtra("key_multi_task_common_info");
        if (arrayOfByte != null) {
          localObject = new aet();
        }
      }
    }
    try
    {
      ((aet)localObject).parseFrom(arrayOfByte);
      label52:
      b((aet)localObject);
      localObject = ((aet)localObject).ZmM;
      if ((localObject != null) && (!Util.isNullOrNil(((drt)localObject).qWi)) && (!Util.isNullOrNil(((drt)localObject).aaXo)))
      {
        AppMethodBeat.o(303893);
        return true;
      }
      AppMethodBeat.o(303893);
      return false;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  private final Bitmap f(Bitmap paramBitmap, boolean paramBoolean)
  {
    MultiTaskInfo localMultiTaskInfo = null;
    Object localObject = null;
    AppMethodBeat.i(303915);
    if (!cCb())
    {
      localMultiTaskInfo = this.LCE;
      if (localMultiTaskInfo == null) {}
      for (;;)
      {
        if (localObject != null) {
          ((drz)localObject).HKy = 0;
        }
        AppMethodBeat.o(303915);
        return paramBitmap;
        localObject = localMultiTaskInfo.gkh();
      }
    }
    if (paramBitmap != null)
    {
      if (paramBoolean)
      {
        localObject = this.LCE;
        if (localObject == null) {}
        for (localObject = null;; localObject = ((MultiTaskInfo)localObject).gkh())
        {
          if (localObject != null) {
            ((drz)localObject).HKy = 90;
          }
          localObject = this.LBU;
          if (localObject != null) {
            break;
          }
          AppMethodBeat.o(303915);
          return null;
        }
        paramBitmap = ((com.tencent.mm.plugin.multitask.a.a)localObject).ap(paramBitmap);
        AppMethodBeat.o(303915);
        return paramBitmap;
      }
      localObject = this.LCE;
      if (localObject != null) {
        break label154;
      }
    }
    label154:
    for (localObject = localMultiTaskInfo;; localObject = ((MultiTaskInfo)localObject).gkh())
    {
      if (localObject != null) {
        ((drz)localObject).HKy = 0;
      }
      AppMethodBeat.o(303915);
      return paramBitmap;
    }
  }
  
  private final void fHD()
  {
    AppMethodBeat.i(303929);
    Log.i("MicroMsg.PageMultiTaskHelper", "finishPage");
    Object localObject = this.LBU;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getActivity())
    {
      if ((localObject instanceof MMActivity)) {
        MMHandlerThread.postToMainThreadDelayed(new c..ExternalSyntheticLambda0(this), 200L);
      }
      localObject = this.LBU;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.a.a)localObject).a(false, (b)this);
      }
      AppMethodBeat.o(303929);
      return;
    }
  }
  
  private final Bitmap gkd()
  {
    AppMethodBeat.i(303899);
    if (this.LCY != null)
    {
      localObject = this.LCY;
      AppMethodBeat.o(303899);
      return localObject;
    }
    Object localObject = this.LBU;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap())
    {
      localObject = aq((Bitmap)localObject);
      AppMethodBeat.o(303899);
      return localObject;
    }
  }
  
  private final void gke()
  {
    com.tencent.mm.plugin.multitask.animation.c.a.a locala = null;
    AppMethodBeat.i(303908);
    Object localObject;
    if ((gjZ()) && (gjV()))
    {
      if ((!cBZ()) && (!cCc())) {
        break label300;
      }
      localObject = this.LBU;
      if (localObject == null) {}
      for (localObject = null; (localObject instanceof MMActivity); localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getActivity())
      {
        if (this.LCR == null)
        {
          this.LCR = ((com.tencent.mm.plugin.multitask.animation.c.a.a)new com.tencent.mm.plugin.multitask.animation.c.b.a());
          localObject = this.LBU;
          if (localObject != null)
          {
            locala = this.LCR;
            if (locala != null) {
              locala.a((com.tencent.mm.plugin.multitask.a.a)localObject, (b)this, this.LCN);
            }
          }
        }
        this.LDb = cBZ();
        AppMethodBeat.o(303908);
        return;
      }
      localObject = this.LBU;
      if (localObject == null) {
        localObject = locala;
      }
    }
    while ((localObject instanceof MMFragmentActivity))
    {
      if (this.LCR == null)
      {
        this.LCR = ((com.tencent.mm.plugin.multitask.animation.c.a.a)new com.tencent.mm.plugin.multitask.animation.c.c.a());
        localObject = this.LBU;
        if (localObject != null)
        {
          locala = this.LCR;
          if (locala != null) {
            locala.a((com.tencent.mm.plugin.multitask.a.a)localObject, (b)this, this.LCN);
          }
        }
      }
      this.LDb = cBZ();
      AppMethodBeat.o(303908);
      return;
      localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getActivity();
      continue;
      if ((cBZ()) && (this.LCQ == null))
      {
        localObject = this.LBU;
        if (localObject != null) {
          this.LCQ = new com.tencent.mm.plugin.multitask.animation.swipeahead.b((com.tencent.mm.plugin.multitask.a.a)localObject, this.LCP);
        }
        localObject = this.LCQ;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.animation.swipeahead.b)localObject).start();
        }
        localObject = this.LCQ;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.multitask.animation.swipeahead.b)localObject).LBW;
          if (localObject != null) {
            ((FloatMultiTaskIndicatorView)localObject).gjE();
          }
        }
      }
    }
    label300:
    AppMethodBeat.o(303908);
  }
  
  public void J(int paramInt, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(304061);
    super.J(paramInt, paramString);
    this.LCM = ((com.tencent.mm.plugin.multitask.c.c)new d(this));
    this.LCN = ((com.tencent.mm.plugin.multitask.c.c)new f(this));
    this.LCO = ((com.tencent.mm.plugin.multitask.c.c)new c(this));
    this.LCP = ((e)new e(this));
    paramString = new com.tencent.mm.plugin.multitask.ui.d();
    paramString.LDF = this.LBU;
    Object localObject1 = (com.tencent.mm.plugin.multitask.c.d)this;
    Object localObject3;
    if (paramString.cZa())
    {
      localObject3 = paramString.LDE;
      if ((localObject3 != null) && (((com.tencent.mm.plugin.multitask.ui.b)localObject3).LDv != null) && (localObject1 != null))
      {
        localObject3 = ((com.tencent.mm.plugin.multitask.ui.b)localObject3).LDv;
        if (localObject3 != null) {
          ((MultiTaskFloatBallView)localObject3).a((com.tencent.mm.plugin.multitask.c.d)localObject1);
        }
      }
    }
    localObject1 = ah.aiuX;
    this.LDa = paramString;
    cod();
    if ((eCI()) && (gjZ()))
    {
      paramString = this.LBU;
      if (paramString != null) {
        paramString.a((b)this);
      }
    }
    paramString = this.LBU;
    if (paramString != null) {
      paramString.ach(paramInt);
    }
    gke();
    paramString = this.LBU;
    if (paramString != null)
    {
      paramString = paramString.getActivity();
      if (paramString != null)
      {
        localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
        paramString = a.a.jC((Context)paramString);
        if (paramString != null) {
          break label379;
        }
        paramString = null;
        if (paramString != null)
        {
          localObject3 = this.LCG;
          if (localObject3 != null)
          {
            localObject1 = this.LCE;
            if (localObject1 != null) {
              break label394;
            }
            localObject1 = null;
            label275:
            ((dry)localObject3).itemType = ((Integer)localObject1).intValue();
          }
          localObject3 = this.LCG;
          if (localObject3 != null)
          {
            localObject1 = this.LCE;
            if (localObject1 != null) {
              break label405;
            }
            localObject1 = null;
            label306:
            ((dry)localObject3).aaXF = ((String)localObject1);
          }
          localObject1 = this.LCG;
          if (localObject1 != null) {
            ((dry)localObject1).zIO = paramString.zIO;
          }
          localObject1 = this.LCG;
          if (localObject1 != null) {
            break label413;
          }
        }
      }
    }
    label394:
    label405:
    label413:
    for (localObject1 = localObject2;; localObject1 = ((dry)localObject1).aaXG)
    {
      if (localObject1 != null) {
        ((dru)localObject1).aaXu = cn.bDw();
      }
      Log.i("MicroMsg.PageMultiTaskHelper", "secdata multitask scene enter contextId: %s", new Object[] { paramString.zIO });
      AppMethodBeat.o(304061);
      return;
      label379:
      paramString = (dry)paramString.c(5, dry.class);
      break;
      localObject1 = Integer.valueOf(((MultiTaskInfo)localObject1).field_type);
      break label275;
      localObject1 = ((MultiTaskInfo)localObject1).field_id;
      break label306;
    }
  }
  
  public void a(b paramb)
  {
    AppMethodBeat.i(304132);
    if (paramb != null) {
      paramb.proceed();
    }
    AppMethodBeat.o(304132);
  }
  
  public boolean af(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    com.tencent.mm.plugin.multitask.a.a locala = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    int k = 1;
    int j = 0;
    AppMethodBeat.i(304080);
    Log.i("MicroMsg.PageMultiTaskHelper", "onClose, way:%d, ended", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject5 = this.LDa;
    if (localObject5 != null)
    {
      localObject5 = ((com.tencent.mm.plugin.multitask.ui.d)localObject5).LDE;
      if (localObject5 != null)
      {
        localObject5 = ((com.tencent.mm.plugin.multitask.ui.b)localObject5).LDv;
        if (localObject5 != null)
        {
          localObject5 = ((MultiTaskFloatBallView)localObject5).LDy;
          if ((localObject5 == null) || ((!((com.tencent.mm.plugin.multitask.animation.b.b)localObject5).cXD()) && (!((com.tencent.mm.plugin.multitask.animation.b.b)localObject5).cXE()))) {}
        }
      }
      for (int i = 1; i != 0; i = 0)
      {
        Log.i("MicroMsg.PageMultiTaskHelper", "onClose, is Animation!");
        AppMethodBeat.o(304080);
        return true;
      }
    }
    this.LDc = paramBoolean;
    paramBoolean = gjV();
    if ((gjZ()) && (paramBoolean))
    {
      gke();
      Log.i("MicroMsg.PageMultiTaskHelper", "onClose, isSupportSwipeToMultiTask:" + cBZ() + ", isSupportExitToMultiTask:" + cCc());
      if ((this.LCR != null) && ((cBZ()) || (cCc())))
      {
        localObject3 = this.LCR;
        if (localObject3 != null) {
          ((com.tencent.mm.plugin.multitask.animation.c.a.a)localObject3).acj(paramInt);
        }
        if (!cCd())
        {
          if (!paramBoolean) {
            break label329;
          }
          locala = this.LBU;
          if (locala != null) {
            break label317;
          }
          label269:
          localObject1 = aq((Bitmap)localObject1);
        }
      }
      for (;;)
      {
        e((Bitmap)localObject1, this.LDc);
        AppMethodBeat.o(304080);
        return true;
        localObject3 = this.LCN;
        if (localObject3 == null) {
          break;
        }
        ((com.tencent.mm.plugin.multitask.c.c)localObject3).aco(0);
        break;
        label317:
        localObject1 = locala.getBitmap();
        break label269;
        label329:
        paramInt = j;
        if (!this.LDc)
        {
          paramInt = j;
          if (evu()) {
            paramInt = 1;
          }
        }
        if (paramInt != 0)
        {
          localObject1 = this.LBU;
          if (localObject1 == null) {}
          for (localObject1 = locala;; localObject1 = ((com.tencent.mm.plugin.multitask.a.a)localObject1).getBitmap())
          {
            localObject1 = aq((Bitmap)localObject1);
            break;
          }
        }
        localObject1 = localObject2;
      }
    }
    if (!cCd()) {
      if (paramBoolean)
      {
        localObject1 = gkd();
        ar((Bitmap)localObject1);
        e((Bitmap)localObject1, this.LDc);
      }
    }
    while (!paramBoolean)
    {
      AppMethodBeat.o(304080);
      return false;
      if ((!this.LDc) && (evu())) {}
      for (paramInt = k;; paramInt = 0)
      {
        localObject1 = localObject4;
        if (paramInt != 0) {
          localObject1 = gkd();
        }
        e((Bitmap)localObject1, this.LDc);
        break;
      }
    }
    localObject1 = this.LBU;
    if (localObject1 == null) {}
    for (localObject1 = localObject3;; localObject1 = ((com.tencent.mm.plugin.multitask.a.a)localObject1).getBitmap())
    {
      ar(aq((Bitmap)localObject1));
      break;
    }
  }
  
  public final Bitmap aq(Bitmap paramBitmap)
  {
    AppMethodBeat.i(304167);
    paramBitmap = f(paramBitmap, gjN());
    AppMethodBeat.o(304167);
    return paramBitmap;
  }
  
  public final void b(aet paramaet)
  {
    Object localObject2 = null;
    AppMethodBeat.i(304105);
    Object localObject1;
    label29:
    label42:
    label55:
    int i;
    label67:
    label81:
    label358:
    long l;
    if (paramaet == null)
    {
      localObject1 = null;
      this.qWi = ((String)localObject1);
      if (paramaet != null) {
        break label493;
      }
      localObject1 = null;
      this.LCT = ((String)localObject1);
      if (paramaet != null) {
        break label520;
      }
      localObject1 = null;
      this.LCU = ((Boolean)localObject1);
      if (paramaet != null) {
        break label550;
      }
      localObject1 = null;
      this.LCV = ((Boolean)localObject1);
      if (paramaet != null) {
        break label580;
      }
      i = -1;
      this.LCX = i;
      if (paramaet != null) {
        break label605;
      }
      localObject1 = Boolean.FALSE;
      this.LCW = ((Boolean)localObject1);
      a(paramaet);
      Log.i("MicroMsg.PageMultiTaskHelper", "commoninfo position: " + this.qWi + ",ori_position: " + this.LCT + ", itemPos:" + this.LCX + ", fromTaskBar:" + this.LCW);
      if (gjZ())
      {
        com.tencent.mm.ae.d.a(gjT(), (kotlin.g.a.a)new c.i(this));
        if (cCb())
        {
          localObject1 = this.LBU;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.plugin.multitask.a.a)localObject1).getActivity();
            if (localObject1 != null) {
              ((Activity)localObject1).setRequestedOrientation(1);
            }
          }
        }
      }
      if (paramaet == null)
      {
        localObject1 = this.LCG;
        if (localObject1 != null) {
          ((dry)localObject1).zIO = "";
        }
      }
      if (paramaet != null)
      {
        if (!Util.isNullOrNil(paramaet.zIO))
        {
          localObject1 = this.LCG;
          if (localObject1 != null) {
            ((dry)localObject1).zIO = paramaet.zIO;
          }
          dry localdry = this.LCG;
          if (localdry != null)
          {
            localObject1 = this.LCE;
            if (localObject1 != null) {
              break label617;
            }
            localObject1 = null;
            label302:
            localdry.itemType = ((Integer)localObject1).intValue();
          }
          localdry = this.LCG;
          if (localdry != null)
          {
            localObject1 = this.LCE;
            if (localObject1 != null) {
              break label630;
            }
            localObject1 = null;
            label337:
            localdry.aaXF = ((String)localObject1);
          }
          localObject1 = this.LCG;
          if (localObject1 != null) {
            break label640;
          }
          localObject1 = null;
          if (localObject1 != null) {
            ((dru)localObject1).aaXu = cn.bDw();
          }
          Log.i("MicroMsg.PageMultiTaskHelper", "secdata multitask scene enter contextId: %s", new Object[] { paramaet.zIO });
        }
        localObject1 = paramaet.ZmM;
        if (localObject1 != null)
        {
          l = System.currentTimeMillis();
          if ((l >= ((drt)localObject1).XgN) && (((drt)localObject1).XgN != 0L))
          {
            paramaet = this.LCG;
            if (paramaet != null) {
              break label650;
            }
          }
        }
      }
    }
    label520:
    label650:
    for (paramaet = localObject2;; paramaet = paramaet.aaXJ)
    {
      if (paramaet != null) {
        paramaet.aaXD = (l - ((drt)localObject1).XgN);
      }
      ((drt)localObject1).XgN = 0L;
      AppMethodBeat.o(304105);
      return;
      localObject1 = paramaet.ZmM;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((drt)localObject1).qWi;
      break;
      label493:
      localObject1 = paramaet.ZmM;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label29;
      }
      localObject1 = ((drt)localObject1).LCT;
      break label29;
      localObject1 = paramaet.ZmM;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label42;
      }
      localObject1 = Boolean.valueOf(((drt)localObject1).aaXr);
      break label42;
      label550:
      localObject1 = paramaet.ZmM;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label55;
      }
      localObject1 = Boolean.valueOf(((drt)localObject1).aaXs);
      break label55;
      label580:
      localObject1 = paramaet.ZmM;
      if (localObject1 == null)
      {
        i = -1;
        break label67;
      }
      i = ((drt)localObject1).aaXt;
      break label67;
      label605:
      localObject1 = Boolean.valueOf(paramaet.ZmN);
      break label81;
      label617:
      localObject1 = Integer.valueOf(((MultiTaskInfo)localObject1).field_type);
      break label302;
      label630:
      localObject1 = ((MultiTaskInfo)localObject1).field_id;
      break label337;
      localObject1 = ((dry)localObject1).aaXG;
      break label358;
    }
  }
  
  public void eCK()
  {
    AppMethodBeat.i(304157);
    Object localObject = this.LBU;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap())
    {
      as(aq((Bitmap)localObject));
      AppMethodBeat.o(304157);
      return;
    }
  }
  
  protected void eCL() {}
  
  public final String getPosition()
  {
    return this.qWi;
  }
  
  public final boolean gjN()
  {
    AppMethodBeat.i(304180);
    Object localObject = this.LBU;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getActivity();
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getResources();
        if (localObject != null)
        {
          localObject = ((Resources)localObject).getConfiguration();
          if ((localObject != null) && (((Configuration)localObject).orientation == 2))
          {
            AppMethodBeat.o(304180);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(304180);
    return false;
  }
  
  public final String gjP()
  {
    return this.LCT;
  }
  
  public final int gjQ()
  {
    return this.LCX;
  }
  
  public final boolean gjR()
  {
    return this.LDb;
  }
  
  public final void gjS()
  {
    AppMethodBeat.i(304114);
    Log.i("MicroMsg.PageMultiTaskHelper", "showHome");
    com.tencent.mm.kernel.b.a locala = com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.multitask.d.class);
    s.s(locala, "plugin(IPluginMultiTask::class.java)");
    d.b.a((com.tencent.mm.plugin.multitask.d)locala, 1);
    com.tencent.mm.ae.d.a(50L, (kotlin.g.a.a)new j(this));
    AppMethodBeat.o(304114);
  }
  
  public final Bitmap gjU()
  {
    com.tencent.mm.plugin.multitask.f.a locala = null;
    AppMethodBeat.i(304126);
    Object localObject1;
    if (MMApplicationContext.isMainProcess())
    {
      localObject1 = com.tencent.mm.plugin.multitask.h.LBd;
      localObject1 = com.tencent.mm.plugin.multitask.h.gjv();
      locala = com.tencent.mm.plugin.multitask.f.a.LIu;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.multitask.f.a.aNY((String)localObject1);
      AppMethodBeat.o(304126);
      return localObject1;
      localObject1 = com.tencent.mm.plugin.multitask.f.a.LIu;
      Object localObject2 = gjK();
      localObject1 = locala;
      if (localObject2 != null)
      {
        localObject2 = ((aet)localObject2).ZmM;
        localObject1 = locala;
        if (localObject2 != null) {
          localObject1 = ((drt)localObject2).aaXq;
        }
      }
    }
  }
  
  public final boolean gjZ()
  {
    String str = null;
    AppMethodBeat.i(304206);
    Object localObject;
    if (Util.isNullOrNil(this.qWi))
    {
      localObject = gjK();
      if (localObject != null) {
        break label52;
      }
    }
    while ((!Util.isNullOrNil(str)) || (!Util.isNullOrNil(this.LCT)))
    {
      AppMethodBeat.o(304206);
      return true;
      label52:
      localObject = ((aet)localObject).ZmM;
      if (localObject != null) {
        str = ((drt)localObject).aaXo;
      }
    }
    AppMethodBeat.o(304206);
    return false;
  }
  
  protected final com.tencent.mm.plugin.multitask.animation.swipeahead.b gkc()
  {
    return this.LCQ;
  }
  
  public void kd(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(304147);
    Object localObject1 = this.LCG;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((drs)localObject1).aaXm = 1L;
      }
      if (!gjZ()) {
        break label159;
      }
      if (!gjV()) {
        break label112;
      }
      Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, has info, type: %d", new Object[] { Integer.valueOf(1) });
      localObject1 = this.LCG;
      if (localObject1 != null) {
        break label104;
      }
    }
    label104:
    for (localObject1 = localObject2;; localObject1 = ((dry)localObject1).aaXH)
    {
      if (localObject1 != null) {
        ((drs)localObject1).status = 1L;
      }
      af(4, false);
      AppMethodBeat.o(304147);
      return;
      localObject1 = ((dry)localObject1).aaXH;
      break;
    }
    label112:
    if (paramBoolean)
    {
      localObject1 = this.LCM;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.multitask.c.c)localObject1).aco(0);
      }
      Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, has not info, type: %d", new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(304147);
      return;
      if (paramBoolean)
      {
        Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, enter multiTask, type: %d", new Object[] { Integer.valueOf(1) });
        a((b)new g(this));
        AppMethodBeat.o(304147);
        return;
      }
      Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, do nothing");
    }
    label159:
    AppMethodBeat.o(304147);
  }
  
  public final void onOrientationChange(int paramInt) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "", "proceed", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void proceed();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createEnterTransformationListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.multitask.c.c
  {
    c(c paramc) {}
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean, int paramInt) {}
    
    public final void aco(int paramInt)
    {
      AppMethodBeat.i(303871);
      Log.i("MicroMsg.PageMultiTaskHelper", s.X("enterTransformation animation cancel, way:", Integer.valueOf(paramInt)));
      this.LDd.LDb = true;
      Object localObject = this.LDd.LBU;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getContentView())
      {
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        AppMethodBeat.o(303871);
        return;
      }
    }
    
    public final void g(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(303876);
      Log.i("MicroMsg.PageMultiTaskHelper", s.X("enterTransformation animation end, way:", Integer.valueOf(paramInt)));
      this.LDd.LDb = true;
      paramBitmap = this.LDd.LBU;
      if (paramBitmap == null) {}
      for (paramBitmap = null;; paramBitmap = paramBitmap.getContentView())
      {
        if (paramBitmap != null) {
          paramBitmap.setVisibility(0);
        }
        AppMethodBeat.o(303876);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createFloatBallTransformationListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.plugin.multitask.c.c
  {
    d(c paramc) {}
    
    private static final void a(c paramc, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(303855);
      s.u(paramc, "this$0");
      com.tencent.mm.plugin.multitask.ui.d locald = paramc.LDa;
      if (locald != null) {
        if ((!s.p(paramc.LCW, Boolean.FALSE)) && (paramc.LCW != null)) {
          break label75;
        }
      }
      label75:
      for (boolean bool = true;; bool = false)
      {
        locald.e(bool, s.p(paramc.LCW, Boolean.TRUE), (AnimatorListenerAdapter)new a(paramc, paramBitmap));
        AppMethodBeat.o(303855);
        return;
      }
    }
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(303869);
      Log.i("MicroMsg.PageMultiTaskHelper", "transform to float ball animation start, isSwipeBack:" + paramBoolean + ", way:" + paramInt);
      Object localObject = this.LDd.LDa;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.c.b)localObject).a(this.LDd.LCE, null);
      }
      localObject = this.LDd.LCS;
      if (localObject != null) {
        com.tencent.mm.plugin.multitask.c.c.a.a((com.tencent.mm.plugin.multitask.c.c)localObject, paramBitmap, paramBoolean, 4);
      }
      this.LDd.LCZ = this.LDd.gjN();
      AppMethodBeat.o(303869);
    }
    
    public final void aco(int paramInt)
    {
      AppMethodBeat.i(303884);
      Log.i("MicroMsg.PageMultiTaskHelper", s.X("transform to float ball animation cancel, way:", Integer.valueOf(paramInt)));
      c localc1 = this.LDd;
      c localc2 = this.LDd;
      Object localObject = this.LDd.LBU;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap())
      {
        c.a(localc1, c.b(localc2, (Bitmap)localObject, this.LDd.gjN()), true);
        localObject = this.LDd.LDa;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.ui.d)localObject).e(false, false, null);
        }
        localObject = this.LDd.LBU;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.a.a)localObject).a(true, (b)this.LDd);
        }
        AppMethodBeat.o(303884);
        return;
      }
    }
    
    public final void g(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(303874);
      Log.i("MicroMsg.PageMultiTaskHelper", s.X("transform to float ball animation end ,way:", Integer.valueOf(paramInt)));
      MMHandlerThread.postToMainThreadDelayed(new c.d..ExternalSyntheticLambda0(this.LDd, paramBitmap), 150L);
      AppMethodBeat.o(303874);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createFloatBallTransformationListener$1$onAnimationEnd$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends AnimatorListenerAdapter
    {
      a(c paramc, Bitmap paramBitmap) {}
      
      public final void onAnimationCancel(Animator paramAnimator)
      {
        AppMethodBeat.i(303843);
        c.a(this.LDd, c.b(this.LDd, paramBitmap, this.LDd.LCZ), true, true, true);
        paramAnimator = this.LDd.LCS;
        if (paramAnimator != null) {
          paramAnimator.aco(0);
        }
        AppMethodBeat.o(303843);
      }
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(303840);
        s.u(paramAnimator, "animation");
        c.a(this.LDd, c.b(this.LDd, paramBitmap, this.LDd.LCZ), true, true, true);
        paramAnimator = this.LDd.LCS;
        if (paramAnimator != null) {
          com.tencent.mm.plugin.multitask.c.c.a.a(paramAnimator, paramBitmap);
        }
        AppMethodBeat.o(303840);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createSwipeAheadToMultiTaskListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "setFloatBallAlpha", "", "alpha", "", "swipePageToMultiTask", "", "lastPosXWhenSwipeReleased", "tryCapture", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements e
  {
    e(c paramc) {}
    
    public final int cG(float paramFloat)
    {
      long l = 2L;
      com.tencent.mm.plugin.multitask.a.a locala = null;
      AppMethodBeat.i(303856);
      if ((!this.LDd.gjZ()) || (!this.LDd.gjV()))
      {
        this.LDd.cCe();
        this.LDd.eCL();
        Object localObject = this.LDd.LCG;
        if (localObject == null)
        {
          localObject = null;
          if (localObject != null) {
            ((drs)localObject).aaXm = 2L;
          }
          localObject = this.LDd.LCG;
          if (localObject != null) {
            break label197;
          }
        }
        label197:
        for (localObject = locala;; localObject = ((dry)localObject).aaXH)
        {
          if (localObject != null)
          {
            if (this.LDd.gjV()) {
              l = 1L;
            }
            ((drs)localObject).status = l;
          }
          localObject = ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.multitask.d.class)).getMultiTaskFloatBallPosition();
          if (localObject != null)
          {
            locala = this.LDd.LBU;
            if (locala != null)
            {
              c localc = this.LDd;
              com.tencent.mm.plugin.multitask.animation.b.a locala1 = com.tencent.mm.plugin.multitask.animation.b.a.LBH;
              com.tencent.mm.plugin.multitask.animation.b.a.a(locala, (Point)localObject, localc.LCY, paramFloat, localc.LCM);
            }
          }
          AppMethodBeat.o(303856);
          return 3;
          localObject = ((dry)localObject).aaXH;
          break;
        }
      }
      AppMethodBeat.o(303856);
      return 1;
    }
    
    public final boolean gkf()
    {
      AppMethodBeat.i(303863);
      Object localObject = this.LDd.LBU;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.a.a)localObject).cBZ();
      }
      c localc = this.LDd;
      localObject = localc.LBU;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap())
      {
        localc.LCY = ((Bitmap)localObject);
        AppMethodBeat.o(303863);
        return false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createSwipeBackTransformationListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.plugin.multitask.c.c
  {
    f(c paramc) {}
    
    public final void a(final Bitmap paramBitmap, final boolean paramBoolean, final int paramInt)
    {
      AppMethodBeat.i(303873);
      Log.i("MicroMsg.PageMultiTaskHelper", "swipeBack start, isSwipeBack:" + paramBoolean + " ,way:" + paramInt);
      this.LDd.a((c.b)new a(this.LDd, paramBoolean, paramBitmap, paramInt));
      AppMethodBeat.o(303873);
    }
    
    public final void aco(int paramInt)
    {
      AppMethodBeat.i(303860);
      Log.i("MicroMsg.PageMultiTaskHelper", s.X("swipeBack animation cancel, way:", Integer.valueOf(paramInt)));
      Object localObject = com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.multitask.d.class);
      s.s(localObject, "plugin(IPluginMultiTask::class.java)");
      d.b.a((com.tencent.mm.plugin.multitask.d)localObject, 2);
      c localc = this.LDd;
      localObject = this.LDd.LBU;
      if (localObject == null)
      {
        localObject = null;
        localObject = c.b(localc, (Bitmap)localObject, this.LDd.gjN());
        localc = this.LDd;
        if (paramInt != 4) {
          break label169;
        }
      }
      label169:
      for (boolean bool = true;; bool = false)
      {
        c.a(localc, (Bitmap)localObject, bool);
        this.LDd.e((Bitmap)localObject, c.b(this.LDd));
        localObject = this.LDd.LBU;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.a.a)localObject).a(true, (b)this.LDd);
        }
        localObject = this.LDd.LBU;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.a.a)localObject).zD(true);
        }
        AppMethodBeat.o(303860);
        return;
        localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap();
        break;
      }
    }
    
    public final void g(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(303867);
      Log.i("MicroMsg.PageMultiTaskHelper", s.X("swipeBack animation end, way:", Integer.valueOf(paramInt)));
      Object localObject = com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.multitask.d.class);
      s.s(localObject, "plugin(IPluginMultiTask::class.java)");
      d.b.a((com.tencent.mm.plugin.multitask.d)localObject, 2);
      paramBitmap = c.b(this.LDd, paramBitmap, this.LDd.LCZ);
      this.LDd.e(paramBitmap, c.b(this.LDd));
      localObject = this.LDd;
      if (paramInt == 4) {}
      for (boolean bool = true;; bool = false)
      {
        c.a((c)localObject, paramBitmap, bool, false, false);
        paramBitmap = this.LDd.LBU;
        if (paramBitmap != null) {
          paramBitmap.zD(true);
        }
        AppMethodBeat.o(303867);
        return;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createSwipeBackTransformationListener$1$onAnimationStart$1", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "proceed", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements c.b
    {
      a(c paramc, boolean paramBoolean, Bitmap paramBitmap, int paramInt) {}
      
      private static final void b(c paramc, Bitmap paramBitmap)
      {
        AppMethodBeat.i(303837);
        s.u(paramc, "this$0");
        c.a(paramc, c.b(paramc, paramBitmap, paramc.gjN()), false);
        AppMethodBeat.o(303837);
      }
      
      public final void proceed()
      {
        AppMethodBeat.i(303847);
        this.LDd.cCe();
        this.LDd.LCZ = this.LDd.gjN();
        if (paramBoolean)
        {
          this.LDd.y(new c.f.a..ExternalSyntheticLambda0(this.LDd, paramBitmap));
          localObject1 = this.LDd.LCE;
          if (localObject1 == null) {}
          for (localObject1 = null;; localObject1 = ((MultiTaskInfo)localObject1).field_id)
          {
            Log.i("MicroMsg.PageMultiTaskHelper", s.X("auto hideUIC,id:", localObject1));
            localObject1 = (com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.multitask.d.class);
            localObject2 = g.LBa;
            ((com.tencent.mm.plugin.multitask.d)localObject1).sendMultiTaskEvent(0, g.gjs(), 1048576);
            localObject1 = this.LDd.LBU;
            if (localObject1 != null) {
              ((com.tencent.mm.plugin.multitask.a.a)localObject1).zD(false);
            }
            AppMethodBeat.o(303847);
            return;
          }
        }
        Object localObject1 = this.LDd;
        Object localObject2 = c.b(this.LDd, paramBitmap, this.LDd.gjN());
        if (paramInt == 4) {}
        for (boolean bool = true;; bool = false)
        {
          c.a((c)localObject1, (Bitmap)localObject2, bool);
          break;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$onMenuMultiTaskSelected$1", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "proceed", "", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements c.b
  {
    g(c paramc) {}
    
    public final void proceed()
    {
      AppMethodBeat.i(303866);
      if (!c.gjY())
      {
        AppMethodBeat.o(303866);
        return;
      }
      if (!this.LDd.gjM())
      {
        localObject = this.LDd.LCM;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.c.c)localObject).aco(0);
        }
        AppMethodBeat.o(303866);
        return;
      }
      Object localObject = ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.multitask.d.class)).getMultiTaskFloatBallPosition();
      if (localObject != null)
      {
        com.tencent.mm.plugin.multitask.a.a locala = this.LDd.LBU;
        if (locala != null)
        {
          c localc = this.LDd;
          com.tencent.mm.plugin.multitask.animation.b.a locala1 = com.tencent.mm.plugin.multitask.animation.b.a.LBH;
          com.tencent.mm.plugin.multitask.animation.b.a.a(locala, (Point)localObject, localc.LCM);
        }
      }
      AppMethodBeat.o(303866);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$onMultiTaskAnimDone$1", "Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$MultiTaskTipCallback;", "onTipCancel", "", "onTipHide", "onTipShow", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements b.a
  {
    h(c paramc) {}
    
    public final void gkg()
    {
      AppMethodBeat.i(303850);
      c.c(this.LDd);
      AppMethodBeat.o(303850);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.b.c
 * JD-Core Version:    0.7.0.1
 */
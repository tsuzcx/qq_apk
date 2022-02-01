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
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.multitask.animation.swipeahead.FloatMultiTaskIndicatorView;
import com.tencent.mm.plugin.multitask.c.e;
import com.tencent.mm.plugin.multitask.d.b;
import com.tencent.mm.plugin.multitask.e.b.a;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskFloatBallView;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.dak;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "baseMultiTaskSwipeBackAnimWrapper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "getBaseMultiTaskSwipeBackAnimWrapper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "setBaseMultiTaskSwipeBackAnimWrapper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;)V", "canSwipeBackToMultiTask", "", "getCanSwipeBackToMultiTask", "()Z", "setCanSwipeBackToMultiTask", "(Z)V", "enterTransformationListener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "getEnterTransformationListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "setEnterTransformationListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;)V", "floatBallTransformationListener", "getFloatBallTransformationListener", "setFloatBallTransformationListener", "floatIndicatorController", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;", "getFloatIndicatorController", "()Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;", "setFloatIndicatorController", "(Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;)V", "homeSnapBlt", "Landroid/graphics/Bitmap;", "getHomeSnapBlt", "()Landroid/graphics/Bitmap;", "isFromMultiTaskItem", "<set-?>", "isFromTaskBar", "()Ljava/lang/Boolean;", "setFromTaskBar", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isVisiableButtom", "setVisiableButtom", "isVisiableTop", "setVisiableTop", "mIsLandScape", "getMIsLandScape", "setMIsLandScape", "multiTaskItemPos", "", "getMultiTaskItemPos", "()I", "setMultiTaskItemPos", "(I)V", "multiTaskSnapBlt", "getMultiTaskSnapBlt", "multiTaskUIManager", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;", "getMultiTaskUIManager", "()Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;", "setMultiTaskUIManager", "(Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;)V", "", "ori_position", "getOri_position", "()Ljava/lang/String;", "setOri_position", "(Ljava/lang/String;)V", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "position", "getPosition", "setPosition", "readEnded", "swipeAheadMultiTaskListener", "Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "getSwipeAheadMultiTaskListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "setSwipeAheadMultiTaskListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;)V", "swipeBackTransformationListener", "getSwipeBackTransformationListener", "setSwipeBackTransformationListener", "swipeBlt", "getSwipeBlt", "setSwipeBlt", "(Landroid/graphics/Bitmap;)V", "transformListener", "getTransformListener", "setTransformListener", "addOrUpdateCurrentHistoryTaskInfo", "", "beforeOnMenuEnterOrSwipebackToMultiTask", "onMenuFloatBallSelectCallback", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "canSwipeToMultiTask", "checkBitmap", "bitmap", "isLandScape", "createEnterTransformationListener", "createFloatBallTransformationListener", "createMultiTaskEnterAndBackAnimation", "createMultiTaskUIManager", "createSwipeAheadToMultiTaskListener", "createSwipeBackTransformationListener", "finishPage", "getHistoryBitmapOnClose", "initData", "initReportData", "onClose", "way", "ended", "onCreate", "multiTaskType", "multiTaskId", "onDestroy", "onMenuMultiTaskSelected", "enterMultiTask", "generateType", "onMultiTaskAnimDone", "forceUpdate", "needUpdateInfo", "needShowTip", "onMultiTaskPanelClicked", "onMultiTaskPanelDelete", "onMultiTaskPanelHide", "onMultiTaskPanelShow", "anim", "onOrientationChange", "orientation", "onSwipePageAddToMultiTask", "restoreCurrentBallWhenNonPassiveClose", "setMultiTaskCommonInfo", "commonData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "setSwipeToMultiTaskEnable", "enable", "setTransformationListener", "listener", "showHome", "Companion", "OnMenuMultiTaskSelectCallback", "plugin-multitask_release"})
public class c
  extends a
  implements com.tencent.mm.plugin.multitask.c.d
{
  public static final c.a FHD;
  public com.tencent.mm.plugin.multitask.a.a FGb;
  com.tencent.mm.plugin.multitask.ui.d FHA;
  boolean FHB;
  private boolean FHC;
  com.tencent.mm.plugin.multitask.c.c FHm;
  private com.tencent.mm.plugin.multitask.c.c FHn;
  private com.tencent.mm.plugin.multitask.c.c FHo;
  private e FHp;
  private com.tencent.mm.plugin.multitask.animation.swipeahead.b FHq;
  private com.tencent.mm.plugin.multitask.animation.c.a.a FHr;
  com.tencent.mm.plugin.multitask.c.c FHs;
  private String FHt;
  private Boolean FHu;
  private Boolean FHv;
  public Boolean FHw;
  private int FHx;
  Bitmap FHy;
  boolean FHz;
  private String nWv;
  
  static
  {
    AppMethodBeat.i(248221);
    FHD = new c.a((byte)0);
    AppMethodBeat.o(248221);
  }
  
  public c(byte paramByte)
  {
    this();
  }
  
  public c(com.tencent.mm.plugin.multitask.a.a parama)
  {
    this.FGb = parama;
    this.FHu = Boolean.FALSE;
    this.FHv = Boolean.FALSE;
    this.FHw = Boolean.FALSE;
    this.FHx = -1;
  }
  
  private boolean bNO()
  {
    AppMethodBeat.i(248195);
    Object localObject = this.FGb;
    byte[] arrayOfByte;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getIntent();
      if (localObject != null)
      {
        arrayOfByte = ((Intent)localObject).getByteArrayExtra("key_multi_task_common_info");
        if (arrayOfByte != null) {
          localObject = new aco();
        }
      }
    }
    try
    {
      ((aco)localObject).parseFrom(arrayOfByte);
      label52:
      b((aco)localObject);
      localObject = ((aco)localObject).Soh;
      if ((localObject != null) && (!Util.isNullOrNil(((dal)localObject).nWv)) && (!Util.isNullOrNil(((dal)localObject).THF)))
      {
        AppMethodBeat.o(248195);
        return true;
      }
      AppMethodBeat.o(248195);
      return false;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  private final Bitmap e(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(248213);
    Object localObject;
    if (!cbI())
    {
      localObject = this.FHd;
      if (localObject != null)
      {
        localObject = ((MultiTaskInfo)localObject).fbc();
        if (localObject != null) {
          ((dar)localObject).BYk = 0;
        }
      }
      AppMethodBeat.o(248213);
      return paramBitmap;
    }
    if (paramBitmap != null)
    {
      if (paramBoolean)
      {
        localObject = this.FHd;
        if (localObject != null)
        {
          localObject = ((MultiTaskInfo)localObject).fbc();
          if (localObject != null) {
            ((dar)localObject).BYk = 90;
          }
        }
        localObject = this.FGb;
        if (localObject != null)
        {
          paramBitmap = ((com.tencent.mm.plugin.multitask.a.a)localObject).ad(paramBitmap);
          AppMethodBeat.o(248213);
          return paramBitmap;
        }
        AppMethodBeat.o(248213);
        return null;
      }
      localObject = this.FHd;
      if (localObject != null)
      {
        localObject = ((MultiTaskInfo)localObject).fbc();
        if (localObject != null) {
          ((dar)localObject).BYk = 0;
        }
      }
    }
    AppMethodBeat.o(248213);
    return paramBitmap;
  }
  
  private final void evQ()
  {
    AppMethodBeat.i(248216);
    Log.i("MicroMsg.PageMultiTaskHelper", "finishPage");
    Object localObject = this.FGb;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getActivity();; localObject = null)
    {
      if ((localObject instanceof MMActivity)) {
        MMHandlerThread.postToMainThreadDelayed((Runnable)new g(this), 200L);
      }
      localObject = this.FGb;
      if (localObject == null) {
        break;
      }
      ((com.tencent.mm.plugin.multitask.a.a)localObject).a(false, (b)this);
      AppMethodBeat.o(248216);
      return;
    }
    AppMethodBeat.o(248216);
  }
  
  private final Bitmap faY()
  {
    AppMethodBeat.i(248198);
    if (this.FHy != null)
    {
      localObject = this.FHy;
      AppMethodBeat.o(248198);
      return localObject;
    }
    Object localObject = this.FGb;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap();; localObject = null)
    {
      localObject = ae((Bitmap)localObject);
      AppMethodBeat.o(248198);
      return localObject;
    }
  }
  
  private final void faZ()
  {
    com.tencent.mm.plugin.multitask.animation.c.a.a locala = null;
    AppMethodBeat.i(248211);
    Object localObject;
    if ((faT()) && (faQ()))
    {
      if ((cbG()) || (cbJ()))
      {
        localObject = this.FGb;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getActivity(); (localObject instanceof MMActivity); localObject = null)
        {
          if (this.FHr == null)
          {
            this.FHr = ((com.tencent.mm.plugin.multitask.animation.c.a.a)new com.tencent.mm.plugin.multitask.animation.c.b.a());
            localObject = this.FGb;
            if (localObject != null)
            {
              locala = this.FHr;
              if (locala != null) {
                locala.a((com.tencent.mm.plugin.multitask.a.a)localObject, (b)this, this.FHn);
              }
            }
          }
          this.FHB = cbG();
          AppMethodBeat.o(248211);
          return;
        }
        com.tencent.mm.plugin.multitask.a.a locala1 = this.FGb;
        localObject = locala;
        if (locala1 != null) {
          localObject = locala1.getActivity();
        }
        if ((localObject instanceof MMFragmentActivity))
        {
          if (this.FHr == null)
          {
            this.FHr = ((com.tencent.mm.plugin.multitask.animation.c.a.a)new com.tencent.mm.plugin.multitask.animation.c.c.a());
            localObject = this.FGb;
            if (localObject != null)
            {
              locala = this.FHr;
              if (locala != null) {
                locala.a((com.tencent.mm.plugin.multitask.a.a)localObject, (b)this, this.FHn);
              }
            }
          }
          this.FHB = cbG();
        }
        AppMethodBeat.o(248211);
      }
    }
    else if ((cbG()) && (this.FHq == null))
    {
      localObject = this.FGb;
      if (localObject != null) {
        this.FHq = new com.tencent.mm.plugin.multitask.animation.swipeahead.b((com.tencent.mm.plugin.multitask.a.a)localObject, this.FHp);
      }
      localObject = this.FHq;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.swipeahead.b)localObject).start();
      }
      localObject = this.FHq;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitask.animation.swipeahead.b)localObject).FFZ;
        if (localObject != null)
        {
          ((FloatMultiTaskIndicatorView)localObject).faz();
          AppMethodBeat.o(248211);
          return;
        }
      }
    }
    AppMethodBeat.o(248211);
  }
  
  public void I(int paramInt, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(248192);
    super.I(paramInt, paramString);
    this.FHm = ((com.tencent.mm.plugin.multitask.c.c)new d(this));
    this.FHn = ((com.tencent.mm.plugin.multitask.c.c)new f(this));
    this.FHo = ((com.tencent.mm.plugin.multitask.c.c)new c(this));
    this.FHp = ((e)new e(this));
    paramString = new com.tencent.mm.plugin.multitask.ui.d();
    paramString.FIq = this.FGb;
    Object localObject1 = (com.tencent.mm.plugin.multitask.c.d)this;
    Object localObject3;
    if (paramString.cwq())
    {
      localObject3 = paramString.FIp;
      if ((localObject3 != null) && (((com.tencent.mm.plugin.multitask.ui.b)localObject3).FIb != null) && (localObject1 != null))
      {
        localObject3 = ((com.tencent.mm.plugin.multitask.ui.b)localObject3).FIb;
        if (localObject3 != null) {
          ((MultiTaskFloatBallView)localObject3).a((com.tencent.mm.plugin.multitask.c.d)localObject1);
        }
      }
    }
    this.FHA = paramString;
    bNO();
    if ((dJN()) && (faT()))
    {
      paramString = this.FGb;
      if (paramString != null) {
        paramString.a((b)this);
      }
    }
    paramString = this.FGb;
    if (paramString != null) {
      paramString.XU(paramInt);
    }
    faZ();
    paramString = this.FGb;
    if (paramString != null)
    {
      paramString = paramString.getActivity();
      if (paramString != null)
      {
        localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
        paramString = a.a.hU((Context)paramString);
        if (paramString != null)
        {
          paramString = (daq)paramString.c(5, daq.class);
          if (paramString != null)
          {
            localObject3 = this.FHf;
            if (localObject3 != null)
            {
              localObject1 = this.FHd;
              if (localObject1 == null) {
                break label407;
              }
            }
          }
        }
        label407:
        for (localObject1 = Integer.valueOf(((MultiTaskInfo)localObject1).field_type);; localObject1 = null)
        {
          ((daq)localObject3).fNO = ((Integer)localObject1).intValue();
          localObject3 = this.FHf;
          if (localObject3 != null)
          {
            MultiTaskInfo localMultiTaskInfo = this.FHd;
            localObject1 = localObject2;
            if (localMultiTaskInfo != null) {
              localObject1 = localMultiTaskInfo.field_id;
            }
            ((daq)localObject3).THW = ((String)localObject1);
          }
          localObject1 = this.FHf;
          if (localObject1 != null) {
            ((daq)localObject1).wmL = paramString.wmL;
          }
          localObject1 = this.FHf;
          if (localObject1 != null)
          {
            localObject1 = ((daq)localObject1).THX;
            if (localObject1 != null) {
              ((dam)localObject1).THL = cm.bfE();
            }
          }
          Log.i("MicroMsg.PageMultiTaskHelper", "secdata multitask scene enter contextId: %s", new Object[] { paramString.wmL });
          AppMethodBeat.o(248192);
          return;
          paramString = null;
          break;
        }
      }
    }
    AppMethodBeat.o(248192);
  }
  
  public boolean Q(int paramInt, boolean paramBoolean)
  {
    com.tencent.mm.plugin.multitask.a.a locala2 = null;
    com.tencent.mm.plugin.multitask.a.a locala1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int k = 1;
    int j = 0;
    AppMethodBeat.i(248197);
    Log.i("MicroMsg.PageMultiTaskHelper", "onClose, way:%d, ended", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject4 = this.FHA;
    if (localObject4 != null)
    {
      localObject4 = ((com.tencent.mm.plugin.multitask.ui.d)localObject4).FIp;
      int i;
      if (localObject4 != null)
      {
        localObject4 = ((com.tencent.mm.plugin.multitask.ui.b)localObject4).FIb;
        if (localObject4 != null)
        {
          localObject4 = ((MultiTaskFloatBallView)localObject4).FIe;
          if (localObject4 != null) {
            if ((((com.tencent.mm.plugin.multitask.animation.b.b)localObject4).cuT()) || (((com.tencent.mm.plugin.multitask.animation.b.b)localObject4).cuU())) {
              i = 1;
            }
          }
        }
      }
      while (i != 0)
      {
        Log.i("MicroMsg.PageMultiTaskHelper", "onClose, is Animation!");
        AppMethodBeat.o(248197);
        return true;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
      }
    }
    this.FHC = paramBoolean;
    paramBoolean = faQ();
    if ((faT()) && (paramBoolean))
    {
      faZ();
      Log.i("MicroMsg.PageMultiTaskHelper", "onClose, isSupportSwipeToMultiTask:" + cbG() + ", isSupportExitToMultiTask:" + cbJ());
      if ((this.FHr != null) && ((cbG()) || (cbJ())))
      {
        localObject2 = this.FHr;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.multitask.animation.c.a.a)localObject2).XW(paramInt);
        }
        if (!cbK())
        {
          if (!paramBoolean) {
            break label341;
          }
          locala1 = this.FGb;
          if (locala1 != null) {
            localObject1 = locala1.getBitmap();
          }
          localObject1 = ae((Bitmap)localObject1);
        }
      }
      for (;;)
      {
        d((Bitmap)localObject1, this.FHC);
        AppMethodBeat.o(248197);
        return true;
        localObject2 = this.FHn;
        if (localObject2 == null) {
          break;
        }
        ((com.tencent.mm.plugin.multitask.c.c)localObject2).Yb(0);
        break;
        label341:
        paramInt = j;
        if (!this.FHC)
        {
          paramInt = j;
          if (faV()) {
            paramInt = 1;
          }
        }
        if (paramInt != 0)
        {
          locala2 = this.FGb;
          localObject1 = locala1;
          if (locala2 != null) {
            localObject1 = locala2.getBitmap();
          }
          localObject1 = ae((Bitmap)localObject1);
        }
        else
        {
          localObject1 = locala2;
        }
      }
    }
    if (!cbK()) {
      if (paramBoolean)
      {
        localObject1 = faY();
        af((Bitmap)localObject1);
        d((Bitmap)localObject1, this.FHC);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(248197);
      return false;
      if ((!this.FHC) && (faV())) {}
      for (paramInt = k;; paramInt = 0)
      {
        localObject1 = localObject3;
        if (paramInt != 0) {
          localObject1 = faY();
        }
        d((Bitmap)localObject1, this.FHC);
        break;
      }
      if (paramBoolean)
      {
        locala1 = this.FGb;
        localObject1 = localObject2;
        if (locala1 != null) {
          localObject1 = locala1.getBitmap();
        }
        af(ae((Bitmap)localObject1));
      }
    }
  }
  
  public void a(b paramb)
  {
    AppMethodBeat.i(248204);
    if (paramb != null)
    {
      paramb.proceed();
      AppMethodBeat.o(248204);
      return;
    }
    AppMethodBeat.o(248204);
  }
  
  public final Bitmap ae(Bitmap paramBitmap)
  {
    AppMethodBeat.i(248212);
    paramBitmap = e(paramBitmap, faI());
    AppMethodBeat.o(248212);
    return paramBitmap;
  }
  
  public final void b(aco paramaco)
  {
    Object localObject2 = null;
    AppMethodBeat.i(248200);
    label59:
    label90:
    label121:
    int i;
    label148:
    boolean bool;
    label162:
    daq localdaq;
    if (paramaco != null)
    {
      localObject1 = paramaco.Soh;
      if (localObject1 != null)
      {
        localObject1 = ((dal)localObject1).nWv;
        this.nWv = ((String)localObject1);
        if (paramaco == null) {
          break label579;
        }
        localObject1 = paramaco.Soh;
        if (localObject1 == null) {
          break label579;
        }
        localObject1 = ((dal)localObject1).FHt;
        this.FHt = ((String)localObject1);
        if (paramaco == null) {
          break label585;
        }
        localObject1 = paramaco.Soh;
        if (localObject1 == null) {
          break label585;
        }
        localObject1 = Boolean.valueOf(((dal)localObject1).THI);
        this.FHu = ((Boolean)localObject1);
        if (paramaco == null) {
          break label591;
        }
        localObject1 = paramaco.Soh;
        if (localObject1 == null) {
          break label591;
        }
        localObject1 = Boolean.valueOf(((dal)localObject1).THJ);
        this.FHv = ((Boolean)localObject1);
        if (paramaco == null) {
          break label597;
        }
        localObject1 = paramaco.Soh;
        if (localObject1 == null) {
          break label597;
        }
        i = ((dal)localObject1).THK;
        this.FHx = i;
        if (paramaco == null) {
          break label602;
        }
        bool = paramaco.Soi;
        this.FHw = Boolean.valueOf(bool);
        a(paramaco);
        Log.i("MicroMsg.PageMultiTaskHelper", "commoninfo position: " + this.nWv + ",ori_position: " + this.FHt + ", itemPos:" + this.FHx + ", fromTaskBar:" + this.FHw);
        if (faT())
        {
          com.tencent.mm.ae.d.a(faO(), (kotlin.g.a.a)new j(this));
          if (cbI())
          {
            localObject1 = this.FGb;
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.plugin.multitask.a.a)localObject1).getActivity();
              if (localObject1 != null) {
                ((Activity)localObject1).setRequestedOrientation(1);
              }
            }
          }
        }
        if (paramaco == null)
        {
          localObject1 = this.FHf;
          if (localObject1 != null) {
            ((daq)localObject1).wmL = "";
          }
        }
        if (paramaco == null) {
          break label620;
        }
        if (!Util.isNullOrNil(paramaco.wmL))
        {
          localObject1 = this.FHf;
          if (localObject1 != null) {
            ((daq)localObject1).wmL = paramaco.wmL;
          }
          localdaq = this.FHf;
          if (localdaq != null)
          {
            localObject1 = this.FHd;
            if (localObject1 == null) {
              break label607;
            }
          }
        }
      }
    }
    label579:
    label585:
    label591:
    label597:
    label602:
    label607:
    for (Object localObject1 = Integer.valueOf(((MultiTaskInfo)localObject1).field_type);; localObject1 = null)
    {
      localdaq.fNO = ((Integer)localObject1).intValue();
      localdaq = this.FHf;
      if (localdaq != null)
      {
        MultiTaskInfo localMultiTaskInfo = this.FHd;
        localObject1 = localObject2;
        if (localMultiTaskInfo != null) {
          localObject1 = localMultiTaskInfo.field_id;
        }
        localdaq.THW = ((String)localObject1);
      }
      localObject1 = this.FHf;
      if (localObject1 != null)
      {
        localObject1 = ((daq)localObject1).THX;
        if (localObject1 != null) {
          ((dam)localObject1).THL = cm.bfE();
        }
      }
      Log.i("MicroMsg.PageMultiTaskHelper", "secdata multitask scene enter contextId: %s", new Object[] { paramaco.wmL });
      paramaco = paramaco.Soh;
      if (paramaco == null) {
        break label613;
      }
      long l = System.currentTimeMillis();
      if ((l >= paramaco.Qoz) && (paramaco.Qoz != 0L))
      {
        localObject1 = this.FHf;
        if (localObject1 != null)
        {
          localObject1 = ((daq)localObject1).TIa;
          if (localObject1 != null) {
            ((dap)localObject1).THU = (l - paramaco.Qoz);
          }
        }
        paramaco.Qoz = 0L;
      }
      AppMethodBeat.o(248200);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label59;
      localObject1 = null;
      break label90;
      localObject1 = null;
      break label121;
      i = -1;
      break label148;
      bool = false;
      break label162;
    }
    label613:
    AppMethodBeat.o(248200);
    return;
    label620:
    AppMethodBeat.o(248200);
  }
  
  public void dJO()
  {
    AppMethodBeat.i(248209);
    Object localObject = this.FGb;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap();; localObject = null)
    {
      ag(ae((Bitmap)localObject));
      AppMethodBeat.o(248209);
      return;
    }
  }
  
  protected void dJP() {}
  
  public final boolean faI()
  {
    AppMethodBeat.i(248215);
    Object localObject = this.FGb;
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
            AppMethodBeat.o(248215);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(248215);
    return false;
  }
  
  public final String faK()
  {
    return this.FHt;
  }
  
  public final int faL()
  {
    return this.FHx;
  }
  
  public final boolean faM()
  {
    return this.FHB;
  }
  
  public final void faN()
  {
    AppMethodBeat.i(248201);
    Log.i("MicroMsg.PageMultiTaskHelper", "showHome");
    d.b.a((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class), 1);
    com.tencent.mm.ae.d.a(50L, (kotlin.g.a.a)new k(this));
    AppMethodBeat.o(248201);
  }
  
  public final Bitmap faP()
  {
    AppMethodBeat.i(248203);
    Object localObject;
    if (MMApplicationContext.isMainProcess())
    {
      localObject = com.tencent.mm.plugin.multitask.h.FFb;
      localObject = com.tencent.mm.plugin.multitask.h.faq();
      com.tencent.mm.plugin.multitask.f.a locala = com.tencent.mm.plugin.multitask.f.a.FNz;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.multitask.f.a.aRg((String)localObject);
      AppMethodBeat.o(248203);
      return localObject;
      localObject = com.tencent.mm.plugin.multitask.f.a.FNz;
      localObject = faF();
      if (localObject != null)
      {
        localObject = ((aco)localObject).Soh;
        if (localObject != null)
        {
          localObject = ((dal)localObject).THH;
          continue;
        }
      }
      localObject = null;
    }
  }
  
  public final boolean faT()
  {
    AppMethodBeat.i(248217);
    if (Util.isNullOrNil(this.nWv))
    {
      localObject = faF();
      if (localObject == null) {
        break label64;
      }
      localObject = ((aco)localObject).Soh;
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = ((dal)localObject).THF; (!Util.isNullOrNil((String)localObject)) || (!Util.isNullOrNil(this.FHt)); localObject = null)
    {
      AppMethodBeat.o(248217);
      return true;
    }
    AppMethodBeat.o(248217);
    return false;
  }
  
  protected final com.tencent.mm.plugin.multitask.animation.swipeahead.b faX()
  {
    return this.FHq;
  }
  
  public final String getPosition()
  {
    return this.nWv;
  }
  
  public void iV(boolean paramBoolean)
  {
    AppMethodBeat.i(248207);
    Object localObject = this.FHf;
    if (localObject != null)
    {
      localObject = ((daq)localObject).THY;
      if (localObject != null) {
        ((dak)localObject).THD = 1L;
      }
    }
    if (faT())
    {
      if (faQ())
      {
        Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, has info, type: %d", new Object[] { Integer.valueOf(1) });
        localObject = this.FHf;
        if (localObject != null)
        {
          localObject = ((daq)localObject).THY;
          if (localObject != null) {
            ((dak)localObject).status = 1L;
          }
        }
        Q(4, false);
        AppMethodBeat.o(248207);
        return;
      }
      if (paramBoolean)
      {
        localObject = this.FHm;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.c.c)localObject).Yb(0);
        }
        Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, has not info, type: %d", new Object[] { Integer.valueOf(1) });
      }
      AppMethodBeat.o(248207);
      return;
    }
    if (paramBoolean)
    {
      Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, enter multiTask, type: %d", new Object[] { Integer.valueOf(1) });
      a((b)new h(this));
      AppMethodBeat.o(248207);
      return;
    }
    Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, do nothing");
    AppMethodBeat.o(248207);
  }
  
  public final void onOrientationChange(int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "", "proceed", "", "plugin-multitask_release"})
  public static abstract interface b
  {
    public abstract void proceed();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createEnterTransformationListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "plugin-multitask_release"})
  public static final class c
    implements com.tencent.mm.plugin.multitask.c.c
  {
    public final void Yb(int paramInt)
    {
      AppMethodBeat.i(248252);
      Log.i("MicroMsg.PageMultiTaskHelper", "enterTransformation animation cancel, way:".concat(String.valueOf(paramInt)));
      this.FHE.FHB = true;
      Object localObject = this.FHE.FGb;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getContentView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          AppMethodBeat.o(248252);
          return;
        }
      }
      AppMethodBeat.o(248252);
    }
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean, int paramInt) {}
    
    public final void h(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(248256);
      Log.i("MicroMsg.PageMultiTaskHelper", "enterTransformation animation end, way:".concat(String.valueOf(paramInt)));
      this.FHE.FHB = true;
      paramBitmap = this.FHE.FGb;
      if (paramBitmap != null)
      {
        paramBitmap = paramBitmap.getContentView();
        if (paramBitmap != null)
        {
          paramBitmap.setVisibility(0);
          AppMethodBeat.o(248256);
          return;
        }
      }
      AppMethodBeat.o(248256);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createFloatBallTransformationListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "plugin-multitask_release"})
  public static final class d
    implements com.tencent.mm.plugin.multitask.c.c
  {
    public final void Yb(int paramInt)
    {
      AppMethodBeat.i(247571);
      Log.i("MicroMsg.PageMultiTaskHelper", "transform to float ball animation cancel, way:".concat(String.valueOf(paramInt)));
      c localc1 = this.FHE;
      c localc2 = this.FHE;
      Object localObject = this.FHE.FGb;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap();; localObject = null)
      {
        c.b(localc1, c.a(localc2, (Bitmap)localObject, this.FHE.faI()), true);
        localObject = this.FHE.FHA;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.ui.d)localObject).e(false, false, null);
        }
        localObject = this.FHE.FGb;
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.plugin.multitask.a.a)localObject).a(true, (b)this.FHE);
        AppMethodBeat.o(247571);
        return;
      }
      AppMethodBeat.o(247571);
    }
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(247568);
      Log.i("MicroMsg.PageMultiTaskHelper", "transform to float ball animation start, isSwipeBack:" + paramBoolean + ", way:" + paramInt);
      Object localObject = this.FHE.FHA;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.c.b)localObject).a(this.FHE.FHd, null);
      }
      localObject = this.FHE.FHs;
      if (localObject != null) {
        com.tencent.mm.plugin.multitask.c.c.a.a((com.tencent.mm.plugin.multitask.c.c)localObject, paramBitmap, paramBoolean, 4);
      }
      this.FHE.FHz = this.FHE.faI();
      AppMethodBeat.o(247568);
    }
    
    public final void h(final Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(247569);
      Log.i("MicroMsg.PageMultiTaskHelper", "transform to float ball animation end ,way:".concat(String.valueOf(paramInt)));
      MMHandlerThread.postToMainThreadDelayed((Runnable)new a(this, paramBitmap), 150L);
      AppMethodBeat.o(247569);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.d paramd, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(248712);
        com.tencent.mm.plugin.multitask.ui.d locald = this.FHF.FHE.FHA;
        if (locald != null)
        {
          if ((p.h(this.FHF.FHE.FHw, Boolean.FALSE)) || (this.FHF.FHE.FHw == null)) {}
          for (boolean bool = true;; bool = false)
          {
            locald.e(bool, p.h(this.FHF.FHE.FHw, Boolean.TRUE), (AnimatorListenerAdapter)new AnimatorListenerAdapter()
            {
              public final void onAnimationCancel(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(247998);
                c.a(this.FHG.FHF.FHE, c.a(this.FHG.FHF.FHE, this.FHG.cLr, this.FHG.FHF.FHE.FHz), true, true, true);
                paramAnonymousAnimator = this.FHG.FHF.FHE.FHs;
                if (paramAnonymousAnimator != null)
                {
                  paramAnonymousAnimator.Yb(0);
                  AppMethodBeat.o(247998);
                  return;
                }
                AppMethodBeat.o(247998);
              }
              
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(247995);
                p.k(paramAnonymousAnimator, "animation");
                c.a(this.FHG.FHF.FHE, c.a(this.FHG.FHF.FHE, this.FHG.cLr, this.FHG.FHF.FHE.FHz), true, true, true);
                paramAnonymousAnimator = this.FHG.FHF.FHE.FHs;
                if (paramAnonymousAnimator != null)
                {
                  com.tencent.mm.plugin.multitask.c.c.a.a(paramAnonymousAnimator, this.FHG.cLr);
                  AppMethodBeat.o(247995);
                  return;
                }
                AppMethodBeat.o(247995);
              }
            });
            AppMethodBeat.o(248712);
            return;
          }
        }
        AppMethodBeat.o(248712);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createSwipeAheadToMultiTaskListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "setFloatBallAlpha", "", "alpha", "", "swipePageToMultiTask", "", "lastPosXWhenSwipeReleased", "tryCapture", "", "plugin-multitask_release"})
  public static final class e
    implements e
  {
    public final int bC(float paramFloat)
    {
      long l = 2L;
      AppMethodBeat.i(248802);
      if ((!this.FHE.faT()) || (!this.FHE.faQ()))
      {
        this.FHE.cbL();
        this.FHE.dJP();
        Object localObject1 = this.FHE.FHf;
        if (localObject1 != null)
        {
          localObject1 = ((daq)localObject1).THY;
          if (localObject1 != null) {
            ((dak)localObject1).THD = 2L;
          }
        }
        localObject1 = this.FHE.FHf;
        if (localObject1 != null)
        {
          localObject1 = ((daq)localObject1).THY;
          if (localObject1 != null)
          {
            if (this.FHE.faQ()) {
              l = 1L;
            }
            ((dak)localObject1).status = l;
          }
        }
        localObject1 = ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class)).getMultiTaskFloatBallPosition();
        if (localObject1 != null)
        {
          com.tencent.mm.plugin.multitask.a.a locala = this.FHE.FGb;
          if (locala != null)
          {
            Object localObject2 = com.tencent.mm.plugin.multitask.animation.b.a.FFL;
            localObject2 = this.FHE.FHy;
            com.tencent.mm.plugin.multitask.c.c localc = this.FHE.FHm;
            p.k(locala, "pageAdapter");
            com.tencent.mm.plugin.multitask.animation.b.a.a(locala, (Point)localObject1, (Bitmap)localObject2, false, paramFloat, localc);
          }
        }
        AppMethodBeat.o(248802);
        return 3;
      }
      AppMethodBeat.o(248802);
      return 1;
    }
    
    public final boolean fba()
    {
      AppMethodBeat.i(248803);
      Object localObject = this.FHE.FGb;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.a.a)localObject).cbG();
      }
      c localc = this.FHE;
      localObject = this.FHE.FGb;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap();; localObject = null)
      {
        localc.FHy = ((Bitmap)localObject);
        AppMethodBeat.o(248803);
        return false;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createSwipeBackTransformationListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "plugin-multitask_release"})
  public static final class f
    implements com.tencent.mm.plugin.multitask.c.c
  {
    public final void Yb(int paramInt)
    {
      AppMethodBeat.i(247791);
      Log.i("MicroMsg.PageMultiTaskHelper", "swipeBack animation cancel, way:".concat(String.valueOf(paramInt)));
      d.b.a((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class), 2);
      c localc = this.FHE;
      Object localObject = this.FHE.FGb;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap();
        localObject = c.a(localc, (Bitmap)localObject, this.FHE.faI());
        localc = this.FHE;
        if (paramInt != 4) {
          break label161;
        }
      }
      label161:
      for (boolean bool = true;; bool = false)
      {
        c.b(localc, (Bitmap)localObject, bool);
        this.FHE.d((Bitmap)localObject, c.a(this.FHE));
        localObject = this.FHE.FGb;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.a.a)localObject).a(true, (b)this.FHE);
        }
        localObject = this.FHE.FGb;
        if (localObject == null) {
          break label166;
        }
        ((com.tencent.mm.plugin.multitask.a.a)localObject).vl(true);
        AppMethodBeat.o(247791);
        return;
        localObject = null;
        break;
      }
      label166:
      AppMethodBeat.o(247791);
    }
    
    public final void a(final Bitmap paramBitmap, final boolean paramBoolean, final int paramInt)
    {
      AppMethodBeat.i(247794);
      Log.i("MicroMsg.PageMultiTaskHelper", "swipeBack start, isSwipeBack:" + paramBoolean + " ,way:" + paramInt);
      this.FHE.a((c.b)new a(this, paramBoolean, paramBitmap, paramInt));
      AppMethodBeat.o(247794);
    }
    
    public final void h(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(247792);
      Log.i("MicroMsg.PageMultiTaskHelper", "swipeBack animation end, way:".concat(String.valueOf(paramInt)));
      d.b.a((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class), 2);
      paramBitmap = c.a(this.FHE, paramBitmap, this.FHE.FHz);
      this.FHE.d(paramBitmap, c.a(this.FHE));
      c localc = this.FHE;
      if (paramInt == 4) {}
      for (boolean bool = true;; bool = false)
      {
        c.a(localc, paramBitmap, bool, false, false);
        paramBitmap = this.FHE.FGb;
        if (paramBitmap == null) {
          break;
        }
        paramBitmap.vl(true);
        AppMethodBeat.o(247792);
        return;
      }
      AppMethodBeat.o(247792);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createSwipeBackTransformationListener$1$onAnimationStart$1", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "proceed", "", "plugin-multitask_release"})
    public static final class a
      implements c.b
    {
      a(boolean paramBoolean, Bitmap paramBitmap, int paramInt) {}
      
      public final void proceed()
      {
        AppMethodBeat.i(248715);
        this.FHH.FHE.cbL();
        this.FHH.FHE.FHz = this.FHH.FHE.faI();
        if (paramBoolean)
        {
          this.FHH.FHE.u((Runnable)new a(this));
          localObject2 = new StringBuilder("auto hideUIC,id:");
          localObject1 = this.FHH.FHE.FHd;
          if (localObject1 != null) {}
          for (localObject1 = ((MultiTaskInfo)localObject1).field_id;; localObject1 = null)
          {
            Log.i("MicroMsg.PageMultiTaskHelper", (String)localObject1);
            localObject1 = (com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class);
            localObject2 = g.FEX;
            ((com.tencent.mm.plugin.multitask.d)localObject1).sendMultiTaskEvent(0, g.fan(), 1048576);
            localObject1 = this.FHH.FHE.FGb;
            if (localObject1 == null) {
              break;
            }
            ((com.tencent.mm.plugin.multitask.a.a)localObject1).vl(false);
            AppMethodBeat.o(248715);
            return;
          }
        }
        Object localObject1 = this.FHH.FHE;
        Object localObject2 = c.a(this.FHH.FHE, paramBitmap, this.FHH.FHE.faI());
        if (paramInt == 4) {}
        for (boolean bool = true;; bool = false)
        {
          c.b((c)localObject1, (Bitmap)localObject2, bool);
          break;
        }
        AppMethodBeat.o(248715);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(c.f.a parama) {}
        
        public final void run()
        {
          AppMethodBeat.i(248268);
          c.b(this.FHJ.FHH.FHE, c.a(this.FHJ.FHH.FHE, this.FHJ.cLr, this.FHJ.FHH.FHE.faI()), false);
          AppMethodBeat.o(248268);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(248793);
      if (this.FHE.FGb != null)
      {
        Object localObject = this.FHE.FGb;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getContentView(); localObject != null; localObject = null)
        {
          localObject = this.FHE.FGb;
          if (localObject == null) {
            break;
          }
          localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getContentView();
          if (localObject == null) {
            break;
          }
          ((View)localObject).setVisibility(0);
          AppMethodBeat.o(248793);
          return;
        }
      }
      AppMethodBeat.o(248793);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$onMenuMultiTaskSelected$1", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "proceed", "", "plugin-multitask_release"})
  public static final class h
    implements c.b
  {
    public final void proceed()
    {
      AppMethodBeat.i(248172);
      if (!this.FHE.faH())
      {
        localObject1 = this.FHE.FHm;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.multitask.c.c)localObject1).Yb(0);
          AppMethodBeat.o(248172);
          return;
        }
        AppMethodBeat.o(248172);
        return;
      }
      Object localObject1 = ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class)).getMultiTaskFloatBallPosition();
      if (localObject1 != null)
      {
        com.tencent.mm.plugin.multitask.a.a locala = this.FHE.FGb;
        if (locala != null)
        {
          Object localObject2 = com.tencent.mm.plugin.multitask.animation.b.a.FFL;
          localObject2 = this.FHE.FHm;
          p.k(locala, "pageAdapter");
          com.tencent.mm.plugin.multitask.animation.b.a.a(locala, (Point)localObject1, null, true, -1.0F, (com.tencent.mm.plugin.multitask.c.c)localObject2);
          AppMethodBeat.o(248172);
          return;
        }
      }
      AppMethodBeat.o(248172);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$onMultiTaskAnimDone$1", "Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$MultiTaskTipCallback;", "onTipCancel", "", "onTipHide", "onTipShow", "plugin-multitask_release"})
  public static final class i
    implements b.a
  {
    public final void fbb()
    {
      AppMethodBeat.i(249052);
      c.b(this.FHE);
      AppMethodBeat.o(249052);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<x>
  {
    k(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.b.c
 * JD-Core Version:    0.7.0.1
 */
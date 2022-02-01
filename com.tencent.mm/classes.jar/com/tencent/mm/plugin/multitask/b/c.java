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
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.multitask.animation.swipeahead.FloatMultiTaskIndicatorView;
import com.tencent.mm.plugin.multitask.c.e;
import com.tencent.mm.plugin.multitask.d.b;
import com.tencent.mm.plugin.multitask.e.b.a;
import com.tencent.mm.plugin.multitask.h;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskFloatBallView;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.ffq;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/AbsMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBViewListener;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "baseMultiTaskSwipeBackAnimWrapper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "getBaseMultiTaskSwipeBackAnimWrapper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;", "setBaseMultiTaskSwipeBackAnimWrapper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/BaseMultiTaskSwipeBackAnimWrapper;)V", "canSwipeBackToMultiTask", "", "getCanSwipeBackToMultiTask", "()Z", "setCanSwipeBackToMultiTask", "(Z)V", "enterTransformationListener", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "getEnterTransformationListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "setEnterTransformationListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;)V", "floatBallTransformationListener", "getFloatBallTransformationListener", "setFloatBallTransformationListener", "floatIndicatorController", "Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;", "getFloatIndicatorController", "()Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;", "setFloatIndicatorController", "(Lcom/tencent/mm/plugin/multitask/animation/swipeahead/FloatMultiTaskIndicatorController;)V", "homeSnapBlt", "Landroid/graphics/Bitmap;", "getHomeSnapBlt", "()Landroid/graphics/Bitmap;", "isFromMultiTaskItem", "<set-?>", "isFromTaskBar", "()Ljava/lang/Boolean;", "setFromTaskBar", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isVisiableButtom", "setVisiableButtom", "isVisiableTop", "setVisiableTop", "mIsLandScape", "getMIsLandScape", "setMIsLandScape", "multiTaskItemPos", "", "getMultiTaskItemPos", "()I", "setMultiTaskItemPos", "(I)V", "multiTaskSnapBlt", "getMultiTaskSnapBlt", "multiTaskUIManager", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;", "getMultiTaskUIManager", "()Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;", "setMultiTaskUIManager", "(Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIManager;)V", "", "ori_position", "getOri_position", "()Ljava/lang/String;", "setOri_position", "(Ljava/lang/String;)V", "getPageAdapter", "()Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "setPageAdapter", "position", "getPosition", "setPosition", "readEnded", "swipeAheadMultiTaskListener", "Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "getSwipeAheadMultiTaskListener", "()Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "setSwipeAheadMultiTaskListener", "(Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;)V", "swipeBackTransformationListener", "getSwipeBackTransformationListener", "setSwipeBackTransformationListener", "swipeBlt", "getSwipeBlt", "setSwipeBlt", "(Landroid/graphics/Bitmap;)V", "transformListener", "getTransformListener", "setTransformListener", "addOrUpdateCurrentHistoryTaskInfo", "", "beforeOnMenuEnterOrSwipebackToMultiTask", "onMenuFloatBallSelectCallback", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "canSwipeToMultiTask", "checkBitmap", "bitmap", "isLandScape", "createEnterTransformationListener", "createFloatBallTransformationListener", "createMultiTaskEnterAndBackAnimation", "createMultiTaskUIManager", "createSwipeAheadToMultiTaskListener", "createSwipeBackTransformationListener", "finishPage", "initData", "initReportData", "onClose", "way", "ended", "onCreate", "multiTaskType", "multiTaskId", "onDestroy", "onMenuMultiTaskSelected", "enterMultiTask", "generateType", "onMultiTaskAnimDone", "forceUpdate", "needUpdateInfo", "needShowTip", "onMultiTaskPanelClicked", "onMultiTaskPanelDelete", "onMultiTaskPanelHide", "onMultiTaskPanelShow", "anim", "onOrientationChange", "orientation", "onSwipePageAddToMultiTask", "restoreCurrentBallWhenNonPassiveClose", "setMultiTaskCommonInfo", "commonData", "Lcom/tencent/mm/protocal/protobuf/CommonMultiTaskData;", "setSwipeToMultiTaskEnable", "enable", "setTransformationListener", "listener", "showHome", "Companion", "OnMenuMultiTaskSelectCallback", "plugin-multitask_release"})
public class c
  extends a
  implements com.tencent.mm.plugin.multitask.c.d
{
  public static final c.a AbQ;
  public com.tencent.mm.plugin.multitask.a.a Aak;
  private com.tencent.mm.plugin.multitask.c.c AbA;
  private e AbB;
  protected com.tencent.mm.plugin.multitask.animation.swipeahead.b AbC;
  private com.tencent.mm.plugin.multitask.animation.c.a.b AbD;
  com.tencent.mm.plugin.multitask.c.c AbF;
  private String AbG;
  private Boolean AbH;
  private Boolean AbI;
  public Boolean AbJ;
  private int AbK;
  Bitmap AbL;
  boolean AbM;
  com.tencent.mm.plugin.multitask.ui.c AbN;
  boolean AbO;
  private boolean AbP;
  com.tencent.mm.plugin.multitask.c.c Aby;
  private com.tencent.mm.plugin.multitask.c.c Abz;
  private String lcm;
  
  static
  {
    AppMethodBeat.i(200615);
    AbQ = new c.a((byte)0);
    AppMethodBeat.o(200615);
  }
  
  public c(byte paramByte)
  {
    this();
  }
  
  public c(com.tencent.mm.plugin.multitask.a.a parama)
  {
    this.Aak = parama;
    this.AbH = Boolean.FALSE;
    this.AbI = Boolean.FALSE;
    this.AbJ = Boolean.FALSE;
    this.AbK = -1;
  }
  
  private boolean bCt()
  {
    AppMethodBeat.i(200601);
    Object localObject = this.Aak;
    byte[] arrayOfByte;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getIntent();
      if (localObject != null)
      {
        arrayOfByte = ((Intent)localObject).getByteArrayExtra("key_multi_task_common_info");
        if (arrayOfByte != null) {
          localObject = new ach();
        }
      }
    }
    try
    {
      ((ach)localObject).parseFrom(arrayOfByte);
      label52:
      a((ach)localObject);
      localObject = ((ach)localObject).LmQ;
      if ((localObject != null) && (!Util.isNullOrNil(((crq)localObject).lcm)) && (!Util.isNullOrNil(((crq)localObject).MwC)))
      {
        AppMethodBeat.o(200601);
        return true;
      }
      AppMethodBeat.o(200601);
      return false;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  private final Bitmap e(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(200611);
    Object localObject;
    if (!bPr())
    {
      localObject = this.Abp;
      if (localObject != null)
      {
        localObject = ((MultiTaskInfo)localObject).erh();
        if (localObject != null) {
          ((cru)localObject).xlQ = 0;
        }
      }
      AppMethodBeat.o(200611);
      return paramBitmap;
    }
    if (paramBitmap != null)
    {
      if (paramBoolean)
      {
        localObject = this.Abp;
        if (localObject != null)
        {
          localObject = ((MultiTaskInfo)localObject).erh();
          if (localObject != null) {
            ((cru)localObject).xlQ = 90;
          }
        }
        localObject = this.Aak;
        if (localObject != null)
        {
          paramBitmap = ((com.tencent.mm.plugin.multitask.a.a)localObject).ag(paramBitmap);
          AppMethodBeat.o(200611);
          return paramBitmap;
        }
        AppMethodBeat.o(200611);
        return null;
      }
      localObject = this.Abp;
      if (localObject != null)
      {
        localObject = ((MultiTaskInfo)localObject).erh();
        if (localObject != null) {
          ((cru)localObject).xlQ = 0;
        }
      }
    }
    AppMethodBeat.o(200611);
    return paramBitmap;
  }
  
  private final void erd()
  {
    com.tencent.mm.plugin.multitask.animation.c.a.b localb = null;
    AppMethodBeat.i(200609);
    Object localObject;
    if ((eqZ()) && (eqW()))
    {
      if ((bPp()) || (bPs()))
      {
        localObject = this.Aak;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getActivity(); (localObject instanceof MMActivity); localObject = null)
        {
          if (this.AbD == null)
          {
            this.AbD = ((com.tencent.mm.plugin.multitask.animation.c.a.b)new com.tencent.mm.plugin.multitask.animation.c.b.b());
            localObject = this.Aak;
            if (localObject != null)
            {
              localb = this.AbD;
              if (localb != null) {
                localb.a((com.tencent.mm.plugin.multitask.a.a)localObject, (b)this, this.Abz);
              }
            }
          }
          this.AbO = bPp();
          AppMethodBeat.o(200609);
          return;
        }
        com.tencent.mm.plugin.multitask.a.a locala = this.Aak;
        localObject = localb;
        if (locala != null) {
          localObject = locala.getActivity();
        }
        if ((localObject instanceof MMFragmentActivity))
        {
          if (this.AbD == null)
          {
            this.AbD = ((com.tencent.mm.plugin.multitask.animation.c.a.b)new com.tencent.mm.plugin.multitask.animation.c.c.b());
            localObject = this.Aak;
            if (localObject != null)
            {
              localb = this.AbD;
              if (localb != null) {
                localb.a((com.tencent.mm.plugin.multitask.a.a)localObject, (b)this, this.Abz);
              }
            }
          }
          this.AbO = bPp();
        }
        AppMethodBeat.o(200609);
      }
    }
    else if ((bPp()) && (this.AbC == null))
    {
      localObject = this.Aak;
      if (localObject != null) {
        this.AbC = new com.tencent.mm.plugin.multitask.animation.swipeahead.b((com.tencent.mm.plugin.multitask.a.a)localObject, this.AbB);
      }
      localObject = this.AbC;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.swipeahead.b)localObject).start();
      }
      localObject = this.AbC;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitask.animation.swipeahead.b)localObject).Aaj;
        if (localObject != null)
        {
          ((FloatMultiTaskIndicatorView)localObject).eqI();
          AppMethodBeat.o(200609);
          return;
        }
      }
    }
    AppMethodBeat.o(200609);
  }
  
  private final void ere()
  {
    AppMethodBeat.i(200613);
    Log.i("MicroMsg.PageMultiTaskHelper", "finishPage");
    Object localObject = this.Aak;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getActivity();; localObject = null)
    {
      if ((localObject instanceof MMActivity)) {
        MMHandlerThread.postToMainThreadDelayed((Runnable)new g(this), 200L);
      }
      localObject = this.Aak;
      if (localObject == null) {
        break;
      }
      ((com.tencent.mm.plugin.multitask.a.a)localObject).a(false, (b)this);
      AppMethodBeat.o(200613);
      return;
    }
    AppMethodBeat.o(200613);
  }
  
  public void G(int paramInt, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(200600);
    super.G(paramInt, paramString);
    this.Aby = ((com.tencent.mm.plugin.multitask.c.c)new d(this));
    this.Abz = ((com.tencent.mm.plugin.multitask.c.c)new f(this));
    this.AbA = ((com.tencent.mm.plugin.multitask.c.c)new c(this));
    this.AbB = ((e)new e(this));
    paramString = new com.tencent.mm.plugin.multitask.ui.c();
    paramString.AcA = this.Aak;
    Object localObject1 = (com.tencent.mm.plugin.multitask.c.d)this;
    Object localObject3;
    if (paramString.ciY())
    {
      localObject3 = paramString.Acz;
      if ((localObject3 != null) && (((com.tencent.mm.plugin.multitask.ui.b)localObject3).Acl != null) && (localObject1 != null))
      {
        localObject3 = ((com.tencent.mm.plugin.multitask.ui.b)localObject3).Acl;
        if (localObject3 != null) {
          ((MultiTaskFloatBallView)localObject3).a((com.tencent.mm.plugin.multitask.c.d)localObject1);
        }
      }
    }
    this.AbN = paramString;
    bCt();
    if ((dki()) && (eqZ()))
    {
      paramString = this.Aak;
      if (paramString != null) {
        paramString.a((b)this);
      }
    }
    paramString = this.Aak;
    if (paramString != null) {
      paramString.RE(paramInt);
    }
    erd();
    paramString = this.Aak;
    if (paramString != null)
    {
      paramString = paramString.getActivity();
      if (paramString != null)
      {
        localObject1 = SecDataUIC.CWq;
        paramString = SecDataUIC.a.gU((Context)paramString);
        if (paramString != null)
        {
          paramString = (crt)paramString.f(5, crt.class);
          if (paramString != null)
          {
            localObject3 = this.Abr;
            if (localObject3 != null)
            {
              localObject1 = this.Abp;
              if (localObject1 == null) {
                break label407;
              }
            }
          }
        }
        label407:
        for (localObject1 = Integer.valueOf(((MultiTaskInfo)localObject1).field_type);; localObject1 = null)
        {
          ((crt)localObject3).dUm = ((Integer)localObject1).intValue();
          localObject3 = this.Abr;
          if (localObject3 != null)
          {
            MultiTaskInfo localMultiTaskInfo = this.Abp;
            localObject1 = localObject2;
            if (localMultiTaskInfo != null) {
              localObject1 = localMultiTaskInfo.field_id;
            }
            ((crt)localObject3).MwM = ((String)localObject1);
          }
          localObject1 = this.Abr;
          if (localObject1 != null) {
            ((crt)localObject1).sGQ = paramString.sGQ;
          }
          localObject1 = this.Abr;
          if (localObject1 != null)
          {
            localObject1 = ((crt)localObject1).MwN;
            if (localObject1 != null) {
              ((crr)localObject1).MwI = cl.aWA();
            }
          }
          Log.i("MicroMsg.PageMultiTaskHelper", "secdata multitask scene enter contextId: %s", new Object[] { paramString.sGQ });
          AppMethodBeat.o(200600);
          return;
          paramString = null;
          break;
        }
      }
    }
    AppMethodBeat.o(200600);
  }
  
  public boolean O(int paramInt, boolean paramBoolean)
  {
    int k = 1;
    com.tencent.mm.plugin.multitask.a.a locala2 = null;
    com.tencent.mm.plugin.multitask.a.a locala1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    int j = 0;
    AppMethodBeat.i(200602);
    Log.i("MicroMsg.PageMultiTaskHelper", "onClose, way:%d, ended", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject6 = this.AbN;
    if (localObject6 != null)
    {
      localObject6 = ((com.tencent.mm.plugin.multitask.ui.c)localObject6).Acz;
      int i;
      if (localObject6 != null)
      {
        localObject6 = ((com.tencent.mm.plugin.multitask.ui.b)localObject6).Acl;
        if (localObject6 != null)
        {
          localObject6 = ((MultiTaskFloatBallView)localObject6).Aco;
          if (localObject6 != null) {
            if ((((com.tencent.mm.plugin.multitask.animation.b.b)localObject6).chI()) || (((com.tencent.mm.plugin.multitask.animation.b.b)localObject6).chJ())) {
              i = 1;
            }
          }
        }
      }
      while (i != 0)
      {
        Log.i("MicroMsg.PageMultiTaskHelper", "onClose, is Animation!");
        AppMethodBeat.o(200602);
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
    this.AbP = paramBoolean;
    paramBoolean = eqW();
    if ((eqZ()) && (paramBoolean))
    {
      erd();
      Log.i("MicroMsg.PageMultiTaskHelper", "onClose, isSupportSwipeToMultiTask:" + bPp() + ", isSupportExitToMultiTask:" + bPs());
      if ((this.AbD != null) && ((bPp()) || (bPs())))
      {
        localObject2 = this.AbD;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject2).RG(paramInt);
        }
        if (!bPt())
        {
          if (!paramBoolean) {
            break label347;
          }
          locala1 = this.Aak;
          if (locala1 != null) {
            localObject1 = locala1.getBitmap();
          }
          localObject1 = aj((Bitmap)localObject1);
        }
      }
      for (;;)
      {
        d((Bitmap)localObject1, this.AbP);
        AppMethodBeat.o(200602);
        return true;
        localObject2 = this.Abz;
        if (localObject2 == null) {
          break;
        }
        ((com.tencent.mm.plugin.multitask.c.c)localObject2).RL(0);
        break;
        label347:
        paramInt = j;
        if (!this.AbP)
        {
          paramInt = j;
          if (erb()) {
            paramInt = 1;
          }
        }
        if (paramInt != 0)
        {
          locala2 = this.Aak;
          localObject1 = locala1;
          if (locala2 != null) {
            localObject1 = locala2.getBitmap();
          }
          localObject1 = aj((Bitmap)localObject1);
        }
        else
        {
          localObject1 = locala2;
        }
      }
    }
    if (!bPt()) {
      if (paramBoolean)
      {
        locala1 = this.Aak;
        localObject1 = localObject3;
        if (locala1 != null) {
          localObject1 = locala1.getBitmap();
        }
        localObject1 = aj((Bitmap)localObject1);
        ah((Bitmap)localObject1);
        d((Bitmap)localObject1, this.AbP);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(200602);
      return false;
      if ((!this.AbP) && (erb())) {}
      for (paramInt = k;; paramInt = 0)
      {
        localObject1 = localObject5;
        if (paramInt != 0)
        {
          locala1 = this.Aak;
          localObject1 = localObject2;
          if (locala1 != null) {
            localObject1 = locala1.getBitmap();
          }
          localObject1 = aj((Bitmap)localObject1);
        }
        d((Bitmap)localObject1, this.AbP);
        break;
      }
      if (paramBoolean)
      {
        locala1 = this.Aak;
        localObject1 = localObject4;
        if (locala1 != null) {
          localObject1 = locala1.getBitmap();
        }
        ah(aj((Bitmap)localObject1));
      }
    }
  }
  
  public void a(b paramb)
  {
    AppMethodBeat.i(200606);
    if (paramb != null)
    {
      paramb.proceed();
      AppMethodBeat.o(200606);
      return;
    }
    AppMethodBeat.o(200606);
  }
  
  public final void a(ach paramach)
  {
    Object localObject2 = null;
    AppMethodBeat.i(200603);
    label59:
    label90:
    label121:
    int i;
    label148:
    boolean bool;
    label162:
    crt localcrt;
    if (paramach != null)
    {
      localObject1 = paramach.LmQ;
      if (localObject1 != null)
      {
        localObject1 = ((crq)localObject1).lcm;
        this.lcm = ((String)localObject1);
        if (paramach == null) {
          break label565;
        }
        localObject1 = paramach.LmQ;
        if (localObject1 == null) {
          break label565;
        }
        localObject1 = ((crq)localObject1).AbG;
        this.AbG = ((String)localObject1);
        if (paramach == null) {
          break label571;
        }
        localObject1 = paramach.LmQ;
        if (localObject1 == null) {
          break label571;
        }
        localObject1 = Boolean.valueOf(((crq)localObject1).MwF);
        this.AbH = ((Boolean)localObject1);
        if (paramach == null) {
          break label577;
        }
        localObject1 = paramach.LmQ;
        if (localObject1 == null) {
          break label577;
        }
        localObject1 = Boolean.valueOf(((crq)localObject1).MwG);
        this.AbI = ((Boolean)localObject1);
        if (paramach == null) {
          break label583;
        }
        localObject1 = paramach.LmQ;
        if (localObject1 == null) {
          break label583;
        }
        i = ((crq)localObject1).MwH;
        this.AbK = i;
        if (paramach == null) {
          break label588;
        }
        bool = paramach.LmR;
        this.AbJ = Boolean.valueOf(bool);
        this.Abq = paramach;
        Log.i("MicroMsg.PageMultiTaskHelper", "commoninfo position: " + this.lcm + ",ori_position: " + this.AbG + ", itemPos:" + this.AbK + ", fromTaskBar:" + this.AbJ);
        if (eqZ())
        {
          com.tencent.mm.ac.d.a(eqU(), (kotlin.g.a.a)new c.j(this));
          if (bPr())
          {
            localObject1 = this.Aak;
            if (localObject1 != null)
            {
              localObject1 = ((com.tencent.mm.plugin.multitask.a.a)localObject1).getActivity();
              if (localObject1 != null) {
                ((Activity)localObject1).setRequestedOrientation(1);
              }
            }
          }
        }
        if (paramach == null)
        {
          localObject1 = this.Abr;
          if (localObject1 != null) {
            ((crt)localObject1).sGQ = "";
          }
        }
        if (paramach == null) {
          break label613;
        }
        if (!Util.isNullOrNil(paramach.sGQ))
        {
          localObject1 = this.Abr;
          if (localObject1 != null) {
            ((crt)localObject1).sGQ = paramach.sGQ;
          }
          localcrt = this.Abr;
          if (localcrt != null)
          {
            localObject1 = this.Abp;
            if (localObject1 == null) {
              break label593;
            }
          }
        }
      }
    }
    label565:
    label571:
    label577:
    label583:
    label588:
    label593:
    for (Object localObject1 = Integer.valueOf(((MultiTaskInfo)localObject1).field_type);; localObject1 = null)
    {
      localcrt.dUm = ((Integer)localObject1).intValue();
      localcrt = this.Abr;
      if (localcrt != null)
      {
        MultiTaskInfo localMultiTaskInfo = this.Abp;
        localObject1 = localObject2;
        if (localMultiTaskInfo != null) {
          localObject1 = localMultiTaskInfo.field_id;
        }
        localcrt.MwM = ((String)localObject1);
      }
      localObject1 = this.Abr;
      if (localObject1 != null)
      {
        localObject1 = ((crt)localObject1).MwN;
        if (localObject1 != null) {
          ((crr)localObject1).MwI = cl.aWA();
        }
      }
      Log.i("MicroMsg.PageMultiTaskHelper", "secdata multitask scene enter contextId: %s", new Object[] { paramach.sGQ });
      paramach = paramach.LmQ;
      if (paramach == null) {
        break label606;
      }
      long l = System.currentTimeMillis();
      if (l < paramach.Jrc) {
        break label599;
      }
      localObject1 = this.Abr;
      if (localObject1 == null) {
        break label599;
      }
      localObject1 = ((crt)localObject1).Uub;
      if (localObject1 == null) {
        break label599;
      }
      ((ffq)localObject1).UtZ = (l - paramach.Jrc);
      AppMethodBeat.o(200603);
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
    label599:
    AppMethodBeat.o(200603);
    return;
    label606:
    AppMethodBeat.o(200603);
    return;
    label613:
    AppMethodBeat.o(200603);
  }
  
  public final Bitmap aj(Bitmap paramBitmap)
  {
    AppMethodBeat.i(200610);
    paramBitmap = e(paramBitmap, eqP());
    AppMethodBeat.o(200610);
    return paramBitmap;
  }
  
  public void dkj()
  {
    AppMethodBeat.i(200608);
    Object localObject = this.Aak;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap();; localObject = null)
    {
      ai(aj((Bitmap)localObject));
      AppMethodBeat.o(200608);
      return;
    }
  }
  
  protected void dkk() {}
  
  public final boolean eqP()
  {
    AppMethodBeat.i(200612);
    Object localObject = this.Aak;
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
            AppMethodBeat.o(200612);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(200612);
    return false;
  }
  
  public final String eqQ()
  {
    return this.AbG;
  }
  
  public final int eqR()
  {
    return this.AbK;
  }
  
  public final boolean eqS()
  {
    return this.AbO;
  }
  
  public final void eqT()
  {
    AppMethodBeat.i(200604);
    Log.i("MicroMsg.PageMultiTaskHelper", "showHome");
    d.b.a((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class), 1);
    com.tencent.mm.ac.d.a(50L, (kotlin.g.a.a)new k(this));
    AppMethodBeat.o(200604);
  }
  
  public final Bitmap eqV()
  {
    AppMethodBeat.i(200605);
    Object localObject;
    if (MMApplicationContext.isMainProcess())
    {
      localObject = h.zZn;
      localObject = h.eqA();
      com.tencent.mm.plugin.multitask.f.a locala = com.tencent.mm.plugin.multitask.f.a.AgJ;
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.multitask.f.a.aGR((String)localObject);
      AppMethodBeat.o(200605);
      return localObject;
      localObject = com.tencent.mm.plugin.multitask.f.a.AgJ;
      localObject = this.Abq;
      if (localObject != null)
      {
        localObject = ((ach)localObject).LmQ;
        if (localObject != null)
        {
          localObject = ((crq)localObject).MwE;
          continue;
        }
      }
      localObject = null;
    }
  }
  
  public final boolean eqZ()
  {
    AppMethodBeat.i(200614);
    if (Util.isNullOrNil(this.lcm))
    {
      localObject = this.Abq;
      if (localObject == null) {
        break label64;
      }
      localObject = ((ach)localObject).LmQ;
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (Object localObject = ((crq)localObject).MwC; (!Util.isNullOrNil((String)localObject)) || (!Util.isNullOrNil(this.AbG)); localObject = null)
    {
      AppMethodBeat.o(200614);
      return true;
    }
    AppMethodBeat.o(200614);
    return false;
  }
  
  public final String getPosition()
  {
    return this.lcm;
  }
  
  public void ib(boolean paramBoolean)
  {
    AppMethodBeat.i(200607);
    Object localObject = this.Abr;
    if (localObject != null)
    {
      localObject = ((crt)localObject).MwO;
      if (localObject != null) {
        ((crp)localObject).MwA = 1L;
      }
    }
    if (eqZ())
    {
      if (eqW())
      {
        Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, has info, type: %d", new Object[] { Integer.valueOf(1) });
        localObject = this.Abr;
        if (localObject != null)
        {
          localObject = ((crt)localObject).MwO;
          if (localObject != null) {
            ((crp)localObject).jii = 1L;
          }
        }
        O(4, false);
        AppMethodBeat.o(200607);
        return;
      }
      if (paramBoolean)
      {
        localObject = this.Aby;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.c.c)localObject).RL(0);
        }
        Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, has not info, type: %d", new Object[] { Integer.valueOf(1) });
      }
      AppMethodBeat.o(200607);
      return;
    }
    if (paramBoolean)
    {
      Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, enter multiTask, type: %d", new Object[] { Integer.valueOf(1) });
      a((b)new h(this));
      AppMethodBeat.o(200607);
      return;
    }
    Log.i("MicroMsg.PageMultiTaskHelper", "onMenuMultiTaskSelected, do nothing");
    AppMethodBeat.o(200607);
  }
  
  public final void onOrientationChange(int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "", "proceed", "", "plugin-multitask_release"})
  public static abstract interface b
  {
    public abstract void proceed();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createEnterTransformationListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "plugin-multitask_release"})
  public static final class c
    implements com.tencent.mm.plugin.multitask.c.c
  {
    public final void RL(int paramInt)
    {
      AppMethodBeat.i(200580);
      Log.i("MicroMsg.PageMultiTaskHelper", "enterTransformation animation cancel, way:".concat(String.valueOf(paramInt)));
      this.AbR.AbO = true;
      Object localObject = this.AbR.Aak;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getContentView();
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          AppMethodBeat.o(200580);
          return;
        }
      }
      AppMethodBeat.o(200580);
    }
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean, int paramInt) {}
    
    public final void g(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(200581);
      Log.i("MicroMsg.PageMultiTaskHelper", "enterTransformation animation end, way:".concat(String.valueOf(paramInt)));
      this.AbR.AbO = true;
      paramBitmap = this.AbR.Aak;
      if (paramBitmap != null)
      {
        paramBitmap = paramBitmap.getContentView();
        if (paramBitmap != null)
        {
          paramBitmap.setVisibility(0);
          AppMethodBeat.o(200581);
          return;
        }
      }
      AppMethodBeat.o(200581);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createFloatBallTransformationListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "plugin-multitask_release"})
  public static final class d
    implements com.tencent.mm.plugin.multitask.c.c
  {
    public final void RL(int paramInt)
    {
      AppMethodBeat.i(200587);
      Log.i("MicroMsg.PageMultiTaskHelper", "transform to float ball animation cancel, way:".concat(String.valueOf(paramInt)));
      c localc1 = this.AbR;
      c localc2 = this.AbR;
      Object localObject = this.AbR.Aak;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap();; localObject = null)
      {
        c.b(localc1, c.a(localc2, (Bitmap)localObject, this.AbR.eqP()), true);
        localObject = this.AbR.AbN;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.ui.c)localObject).e(false, false, null);
        }
        localObject = this.AbR.Aak;
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.plugin.multitask.a.a)localObject).a(true, (b)this.AbR);
        AppMethodBeat.o(200587);
        return;
      }
      AppMethodBeat.o(200587);
    }
    
    public final void a(Bitmap paramBitmap, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(200585);
      Log.i("MicroMsg.PageMultiTaskHelper", "transform to float ball animation start, isSwipeBack:" + paramBoolean + ", way:" + paramInt);
      Object localObject = this.AbR.AbN;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.c.b)localObject).a(this.AbR.Abp, null);
      }
      localObject = this.AbR.AbF;
      if (localObject != null) {
        com.tencent.mm.plugin.multitask.c.c.a.a((com.tencent.mm.plugin.multitask.c.c)localObject, paramBitmap, paramBoolean, 4);
      }
      this.AbR.AbM = this.AbR.eqP();
      AppMethodBeat.o(200585);
    }
    
    public final void g(final Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(200586);
      Log.i("MicroMsg.PageMultiTaskHelper", "transform to float ball animation end ,way:".concat(String.valueOf(paramInt)));
      MMHandlerThread.postToMainThreadDelayed((Runnable)new a(this, paramBitmap), 150L);
      AppMethodBeat.o(200586);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(c.d paramd, Bitmap paramBitmap) {}
      
      public final void run()
      {
        AppMethodBeat.i(200584);
        com.tencent.mm.plugin.multitask.ui.c localc = this.AbS.AbR.AbN;
        if (localc != null)
        {
          if ((p.j(this.AbS.AbR.AbJ, Boolean.FALSE)) || (this.AbS.AbR.AbJ == null)) {}
          for (boolean bool = true;; bool = false)
          {
            localc.e(bool, p.j(this.AbS.AbR.AbJ, Boolean.TRUE), (AnimatorListenerAdapter)new AnimatorListenerAdapter()
            {
              public final void onAnimationCancel(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(200583);
                c.a(this.AbT.AbS.AbR, c.a(this.AbT.AbS.AbR, this.AbT.cKG, this.AbT.AbS.AbR.AbM), true, true, true);
                paramAnonymousAnimator = this.AbT.AbS.AbR.AbF;
                if (paramAnonymousAnimator != null)
                {
                  paramAnonymousAnimator.RL(0);
                  AppMethodBeat.o(200583);
                  return;
                }
                AppMethodBeat.o(200583);
              }
              
              public final void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                AppMethodBeat.i(200582);
                p.h(paramAnonymousAnimator, "animation");
                c.a(this.AbT.AbS.AbR, c.a(this.AbT.AbS.AbR, this.AbT.cKG, this.AbT.AbS.AbR.AbM), true, true, true);
                paramAnonymousAnimator = this.AbT.AbS.AbR.AbF;
                if (paramAnonymousAnimator != null)
                {
                  com.tencent.mm.plugin.multitask.c.c.a.a(paramAnonymousAnimator, this.AbT.cKG);
                  AppMethodBeat.o(200582);
                  return;
                }
                AppMethodBeat.o(200582);
              }
            });
            AppMethodBeat.o(200584);
            return;
          }
        }
        AppMethodBeat.o(200584);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createSwipeAheadToMultiTaskListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnSwipeAheadToMultiTaskListener;", "setFloatBallAlpha", "", "alpha", "", "swipePageToMultiTask", "", "lastPosXWhenSwipeReleased", "tryCapture", "", "plugin-multitask_release"})
  public static final class e
    implements e
  {
    public final int bz(float paramFloat)
    {
      long l = 2L;
      AppMethodBeat.i(200588);
      if ((!this.AbR.eqZ()) || (!this.AbR.eqW()))
      {
        this.AbR.bPu();
        this.AbR.dkk();
        Object localObject1 = this.AbR.Abr;
        if (localObject1 != null)
        {
          localObject1 = ((crt)localObject1).MwO;
          if (localObject1 != null) {
            ((crp)localObject1).MwA = 2L;
          }
        }
        localObject1 = this.AbR.Abr;
        if (localObject1 != null)
        {
          localObject1 = ((crt)localObject1).MwO;
          if (localObject1 != null)
          {
            if (this.AbR.eqW()) {
              l = 1L;
            }
            ((crp)localObject1).jii = l;
          }
        }
        localObject1 = ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class)).getMultiTaskFloatBallPosition();
        if (localObject1 != null)
        {
          com.tencent.mm.plugin.multitask.a.a locala = this.AbR.Aak;
          if (locala != null)
          {
            Object localObject2 = com.tencent.mm.plugin.multitask.animation.b.a.zZV;
            localObject2 = this.AbR.AbL;
            com.tencent.mm.plugin.multitask.c.c localc = this.AbR.Aby;
            p.h(locala, "pageAdapter");
            com.tencent.mm.plugin.multitask.animation.b.a.a(locala, (Point)localObject1, (Bitmap)localObject2, false, paramFloat, localc);
          }
        }
        AppMethodBeat.o(200588);
        return 3;
      }
      AppMethodBeat.o(200588);
      return 1;
    }
    
    public final boolean erf()
    {
      AppMethodBeat.i(200589);
      Object localObject = this.AbR.Aak;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.a.a)localObject).bPp();
      }
      c localc = this.AbR;
      localObject = this.AbR.Aak;
      if (localObject != null) {}
      for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap();; localObject = null)
      {
        localc.AbL = ((Bitmap)localObject);
        AppMethodBeat.o(200589);
        return false;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createSwipeBackTransformationListener$1", "Lcom/tencent/mm/plugin/multitask/listener/OnMultiTaskFBTransformationListener;", "onAnimationCancel", "", "way", "", "onAnimationEnd", "bitmap", "Landroid/graphics/Bitmap;", "onAnimationStart", "isSwipeBack", "", "plugin-multitask_release"})
  public static final class f
    implements com.tencent.mm.plugin.multitask.c.c
  {
    public final void RL(int paramInt)
    {
      AppMethodBeat.i(200592);
      Log.i("MicroMsg.PageMultiTaskHelper", "swipeBack animation cancel, way:".concat(String.valueOf(paramInt)));
      d.b.a((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class), 2);
      c localc = this.AbR;
      Object localObject = this.AbR.Aak;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getBitmap();
        localObject = c.a(localc, (Bitmap)localObject, this.AbR.eqP());
        localc = this.AbR;
        if (paramInt != 4) {
          break label161;
        }
      }
      label161:
      for (boolean bool = true;; bool = false)
      {
        c.b(localc, (Bitmap)localObject, bool);
        this.AbR.d((Bitmap)localObject, c.a(this.AbR));
        localObject = this.AbR.Aak;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.a.a)localObject).a(true, (b)this.AbR);
        }
        localObject = this.AbR.Aak;
        if (localObject == null) {
          break label166;
        }
        ((com.tencent.mm.plugin.multitask.a.a)localObject).sj(true);
        AppMethodBeat.o(200592);
        return;
        localObject = null;
        break;
      }
      label166:
      AppMethodBeat.o(200592);
    }
    
    public final void a(final Bitmap paramBitmap, final boolean paramBoolean, final int paramInt)
    {
      AppMethodBeat.i(200594);
      Log.i("MicroMsg.PageMultiTaskHelper", "swipeBack start, isSwipeBack:" + paramBoolean + " ,way:" + paramInt);
      this.AbR.a((c.b)new a(this, paramBoolean, paramBitmap, paramInt));
      AppMethodBeat.o(200594);
    }
    
    public final void g(Bitmap paramBitmap, int paramInt)
    {
      AppMethodBeat.i(200593);
      Log.i("MicroMsg.PageMultiTaskHelper", "swipeBack animation end, way:".concat(String.valueOf(paramInt)));
      d.b.a((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class), 2);
      paramBitmap = c.a(this.AbR, paramBitmap, this.AbR.AbM);
      this.AbR.d(paramBitmap, c.a(this.AbR));
      c localc = this.AbR;
      if (paramInt == 4) {}
      for (boolean bool = true;; bool = false)
      {
        c.a(localc, paramBitmap, bool, false, false);
        paramBitmap = this.AbR.Aak;
        if (paramBitmap == null) {
          break;
        }
        paramBitmap.sj(true);
        AppMethodBeat.o(200593);
        return;
      }
      AppMethodBeat.o(200593);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$createSwipeBackTransformationListener$1$onAnimationStart$1", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "proceed", "", "plugin-multitask_release"})
    public static final class a
      implements c.b
    {
      a(boolean paramBoolean, Bitmap paramBitmap, int paramInt) {}
      
      public final void proceed()
      {
        AppMethodBeat.i(200591);
        this.AbU.AbR.bPu();
        this.AbU.AbR.AbM = this.AbU.AbR.eqP();
        if (paramBoolean)
        {
          this.AbU.AbR.v((Runnable)new a(this));
          localObject2 = new StringBuilder("auto hideUIC,id:");
          localObject1 = this.AbU.AbR.Abp;
          if (localObject1 != null) {}
          for (localObject1 = ((MultiTaskInfo)localObject1).field_id;; localObject1 = null)
          {
            Log.i("MicroMsg.PageMultiTaskHelper", (String)localObject1);
            localObject1 = (com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class);
            localObject2 = com.tencent.mm.plugin.multitask.g.zZj;
            ((com.tencent.mm.plugin.multitask.d)localObject1).sendMultiTaskEvent(0, com.tencent.mm.plugin.multitask.g.eqx(), 1048576);
            localObject1 = this.AbU.AbR.Aak;
            if (localObject1 == null) {
              break;
            }
            ((com.tencent.mm.plugin.multitask.a.a)localObject1).sj(false);
            AppMethodBeat.o(200591);
            return;
          }
        }
        Object localObject1 = this.AbU.AbR;
        Object localObject2 = c.a(this.AbU.AbR, paramBitmap, this.AbU.AbR.eqP());
        if (paramInt == 4) {}
        for (boolean bool = true;; bool = false)
        {
          c.b((c)localObject1, (Bitmap)localObject2, bool);
          break;
        }
        AppMethodBeat.o(200591);
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(c.f.a parama) {}
        
        public final void run()
        {
          AppMethodBeat.i(200590);
          c.b(this.AbW.AbU.AbR, c.a(this.AbW.AbU.AbR, this.AbW.cKG, this.AbW.AbU.AbR.eqP()), false);
          AppMethodBeat.o(200590);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(200595);
      if (this.AbR.Aak != null)
      {
        Object localObject = this.AbR.Aak;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getContentView(); localObject != null; localObject = null)
        {
          localObject = this.AbR.Aak;
          if (localObject == null) {
            break;
          }
          localObject = ((com.tencent.mm.plugin.multitask.a.a)localObject).getContentView();
          if (localObject == null) {
            break;
          }
          ((View)localObject).setVisibility(0);
          AppMethodBeat.o(200595);
          return;
        }
      }
      AppMethodBeat.o(200595);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$onMenuMultiTaskSelected$1", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$OnMenuMultiTaskSelectCallback;", "proceed", "", "plugin-multitask_release"})
  public static final class h
    implements c.b
  {
    public final void proceed()
    {
      AppMethodBeat.i(200596);
      if (!this.AbR.eqO())
      {
        localObject1 = this.AbR.Aby;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.multitask.c.c)localObject1).RL(0);
          AppMethodBeat.o(200596);
          return;
        }
        AppMethodBeat.o(200596);
        return;
      }
      Object localObject1 = ((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class)).getMultiTaskFloatBallPosition();
      if (localObject1 != null)
      {
        com.tencent.mm.plugin.multitask.a.a locala = this.AbR.Aak;
        if (locala != null)
        {
          Object localObject2 = com.tencent.mm.plugin.multitask.animation.b.a.zZV;
          localObject2 = this.AbR.Aby;
          p.h(locala, "pageAdapter");
          com.tencent.mm.plugin.multitask.animation.b.a.a(locala, (Point)localObject1, null, true, -1.0F, (com.tencent.mm.plugin.multitask.c.c)localObject2);
          AppMethodBeat.o(200596);
          return;
        }
      }
      AppMethodBeat.o(200596);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper$onMultiTaskAnimDone$1", "Lcom/tencent/mm/plugin/multitask/tips/MultiTaskTipsHelper$MultiTaskTipCallback;", "onTipCancel", "", "onTipHide", "onTipShow", "plugin-multitask_release"})
  public static final class i
    implements b.a
  {
    public final void erg()
    {
      AppMethodBeat.i(200597);
      c.b(this.AbR);
      AppMethodBeat.o(200597);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.b.c
 * JD-Core Version:    0.7.0.1
 */
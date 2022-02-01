package com.tencent.mm.plugin.multitask.ui.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.c;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import java.io.IOException;

public class a
  extends c
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public a(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public final boolean Of(int paramInt)
  {
    return paramInt == 1;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, dal paramdal, Object paramObject)
  {
    AppMethodBeat.i(196244);
    paramObject = new eo();
    try
    {
      paramObject.parseFrom(paramMultiTaskInfo.field_data);
      paramMultiTaskInfo = new ParcelableMultiTaskData();
      paramMultiTaskInfo.nBo = new aco();
      paramMultiTaskInfo.nBo.Soh = paramdal;
      if (paramView != null)
      {
        paramdal = com.tencent.mm.plugin.secdata.ui.a.JbV;
        if (a.a.hU(paramView.getContext()) != null)
        {
          paramdal = com.tencent.mm.plugin.secdata.ui.a.JbV;
          paramView = (daq)a.a.hU(paramView.getContext()).aef(5);
          if ((paramView instanceof daq)) {
            paramMultiTaskInfo.nBo.wmL = paramView.wmL;
          }
        }
      }
      paramView = new g();
      paramView.username = paramObject.username;
      paramView.appId = paramObject.appId;
      paramView.cBU = paramObject.cBU;
      Log.i("MicroMsg.AppBrandMultiTaskUIC", "onMultiTaskItemClick username:%s,appid:%s,versionType:%d", new Object[] { paramObject.username, paramObject.appId, Integer.valueOf(paramObject.cBU) });
      paramView.nBI = paramMultiTaskInfo;
      paramView.scene = 1187;
      ((r)h.ae(r.class)).a(this.xGq, paramView);
      AppMethodBeat.o(196244);
      return;
    }
    catch (IOException paramMultiTaskInfo)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandMultiTaskUIC", paramMultiTaskInfo, "onMultiTaskItemClick exception:%s", new Object[] { paramMultiTaskInfo.getMessage() });
      }
    }
  }
  
  public final void a(StorageObserverEvent<MultiTaskInfo> paramStorageObserverEvent) {}
  
  public final a.b dKp()
  {
    return a.b.FHX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a.a
 * JD-Core Version:    0.7.0.1
 */
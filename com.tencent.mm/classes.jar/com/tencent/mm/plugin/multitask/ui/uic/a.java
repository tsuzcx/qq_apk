package com.tencent.mm.plugin.multitask.ui.uic;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.multitask.ui.c;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.protocal.protobuf.fi;
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
  
  public final boolean Qs(int paramInt)
  {
    return paramInt == 1;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, drt paramdrt, Object paramObject)
  {
    AppMethodBeat.i(304305);
    paramObject = new fi();
    try
    {
      paramObject.parseFrom(paramMultiTaskInfo.field_data);
      paramMultiTaskInfo = new ParcelableMultiTaskData();
      paramMultiTaskInfo.qAD = new aet();
      paramMultiTaskInfo.qAD.ZmM = paramdrt;
      if (paramView != null)
      {
        paramdrt = com.tencent.mm.plugin.secdata.ui.a.PlI;
        if (a.a.jC(paramView.getContext()) != null)
        {
          paramdrt = com.tencent.mm.plugin.secdata.ui.a.PlI;
          paramView = (dry)a.a.jC(paramView.getContext()).aiK(5);
          if ((paramView instanceof dry)) {
            paramMultiTaskInfo.qAD.zIO = paramView.zIO;
          }
        }
      }
      paramView = new g();
      paramView.username = paramObject.username;
      paramView.appId = paramObject.appId;
      paramView.euz = paramObject.euz;
      Log.i("MicroMsg.AppBrandMultiTaskUIC", "onMultiTaskItemClick username:%s,appid:%s,versionType:%d", new Object[] { paramObject.username, paramObject.appId, Integer.valueOf(paramObject.euz) });
      paramView.qAW = paramMultiTaskInfo;
      paramView.scene = 1187;
      ((t)h.ax(t.class)).a(this.activity, paramView);
      AppMethodBeat.o(304305);
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
  
  public final a.b eDe()
  {
    return a.b.LDq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.a
 * JD-Core Version:    0.7.0.1
 */
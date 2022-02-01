package com.tencent.mm.plugin.multitask.ui.uic;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a.b;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.io.IOException;

public class AppBrandMultiTaskUIC
  extends MultiTaskUIComponent
{
  public AppBrandMultiTaskUIC(Fragment paramFragment)
  {
    super(paramFragment);
  }
  
  public AppBrandMultiTaskUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public final boolean Js(int paramInt)
  {
    return paramInt == 1;
  }
  
  public final void a(View paramView, MultiTaskInfo paramMultiTaskInfo, crq paramcrq, Object paramObject)
  {
    AppMethodBeat.i(236429);
    paramObject = new er();
    try
    {
      paramObject.parseFrom(paramMultiTaskInfo.field_data);
      paramMultiTaskInfo = new ParcelableMultiTaskData();
      paramMultiTaskInfo.kHu = new ach();
      paramMultiTaskInfo.kHu.LmQ = paramcrq;
      if (paramView != null)
      {
        paramcrq = SecDataUIC.CWq;
        if (SecDataUIC.a.gU(paramView.getContext()) != null)
        {
          paramcrq = SecDataUIC.CWq;
          paramView = (crt)SecDataUIC.a.gU(paramView.getContext()).Xh(5);
          if ((paramView instanceof crt)) {
            paramMultiTaskInfo.kHu.sGQ = paramView.sGQ;
          }
        }
      }
      paramView = new com.tencent.mm.plugin.appbrand.api.g();
      paramView.username = paramObject.username;
      paramView.appId = paramObject.appId;
      paramView.iOo = paramObject.iOo;
      Log.i("MicroMsg.AppBrandMultiTaskUIC", "onMultiTaskItemClick username:%s,appid:%s,versionType:%d", new Object[] { paramObject.username, paramObject.appId, Integer.valueOf(paramObject.iOo) });
      paramView.kHP = paramMultiTaskInfo;
      paramView.scene = 1187;
      ((r)com.tencent.mm.kernel.g.af(r.class)).a(this.tUQ, paramView);
      AppMethodBeat.o(236429);
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
  
  public final void a(MStorageEventData paramMStorageEventData) {}
  
  public final a.b dks()
  {
    return a.b.Ach;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.uic.AppBrandMultiTaskUIC
 * JD-Core Version:    0.7.0.1
 */
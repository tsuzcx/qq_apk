package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public final class m
  implements t
{
  private List<String> rTX = new ArrayList();
  public Vector<String> rUu = new Vector();
  private volatile boolean rUv = false;
  
  public m()
  {
    a.brq().a(1, this);
  }
  
  private void BE()
  {
    int i = 20;
    if (this.rUv)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
      return;
    }
    if (this.rUu.size() <= 0)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
      return;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.rUu.size());
    int j = this.rUu.size();
    if (j > 20) {}
    for (;;)
    {
      this.rUv = true;
      this.rTX.addAll(this.rUu.subList(0, i));
      y localy = new y(1, new af(this.rTX));
      g.DO().dJT.a(localy, 0);
      return;
      i = j;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, x paramx)
  {
    if (paramx.getType() != 1) {
      return;
    }
    this.rUv = false;
    paramString = ((af)paramx).rUM;
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + paramString.size());
    this.rUu.removeAll(this.rTX);
    this.rTX.clear();
    BE();
  }
  
  public final void addAll(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppSettingService", "addAll list is null");
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((!bk.bl(str)) && (!this.rUu.contains(str))) {
        this.rUu.add(str);
      }
    }
    BE();
  }
  
  public final void qh(String paramString)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppSettingService", "appId = " + paramString);
    if (bk.bl(paramString))
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppSettingService", "add appId is null");
      return;
    }
    if (!this.rUu.contains(paramString)) {
      this.rUu.add(paramString);
    }
    BE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.m
 * JD-Core Version:    0.7.0.1
 */
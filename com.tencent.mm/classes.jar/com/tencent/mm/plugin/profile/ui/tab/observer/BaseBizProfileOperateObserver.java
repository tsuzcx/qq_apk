package com.tencent.mm.plugin.profile.ui.tab.observer;

import com.tencent.mm.api.c;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class BaseBizProfileOperateObserver
  implements IBizProfileOperateObserver
{
  public c Bdk;
  public List<WxaAttributes.WxaEntryInfo> BeW;
  public aeq BeX;
  public String dhE;
  public List<c.a> dhu;
  public c.b dhv;
  public long enterTime;
  
  public boolean a(f paramf, as paramas)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.observer.BaseBizProfileOperateObserver
 * JD-Core Version:    0.7.0.1
 */
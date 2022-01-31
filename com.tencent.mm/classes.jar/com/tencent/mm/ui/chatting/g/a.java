package com.tencent.mm.ui.chatting.g;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class a
  extends com.tencent.mm.ax.a
{
  public String vyw;
  public long vyx = 0L;
  
  public a(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
  }
  
  protected final boolean Ib()
  {
    if (this.values == null)
    {
      y.e("MicroMsg.InvokeMessageNewXmlMsg", "[parseXml] values == null ");
      return false;
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.preContent")) {
      this.vyw = ((String)this.values.get(".sysmsg.invokeMessage.preContent"));
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
      this.vyx = bk.ZS((String)this.values.get(".sysmsg.invokeMessage.timestamp"));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.values.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith(".sysmsg.invokeMessage.text"))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.insert(0, (String)this.values.get(str));
        } else {
          localStringBuilder.append((String)this.values.get(str));
        }
      }
      else
      {
        if ((!str.startsWith(".sysmsg.invokeMessage.link.text")) || (bk.bl((String)this.values.get(str)))) {
          break label341;
        }
        str = (String)this.values.get(str);
        localStringBuilder.append(str);
        this.evA.add(str);
        i = str.length();
      }
    }
    label341:
    for (;;)
    {
      break;
      this.evB.addFirst(Integer.valueOf(localStringBuilder.length() - i));
      this.evC.add(Integer.valueOf(localStringBuilder.length()));
      this.evy = localStringBuilder.toString();
      if ((System.currentTimeMillis() - this.vyx >= 300000L) && (!bk.bl(this.vyw))) {
        e.post(new a.1(this), "[checkExpired]");
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.a
 * JD-Core Version:    0.7.0.1
 */
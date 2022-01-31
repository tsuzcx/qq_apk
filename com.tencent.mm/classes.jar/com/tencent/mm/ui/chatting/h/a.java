package com.tencent.mm.ui.chatting.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class a
  extends com.tencent.mm.ay.a
{
  public String zOS;
  public long zOT = 0L;
  
  public a(Map<String, String> paramMap, bi parambi)
  {
    super(paramMap, parambi);
  }
  
  public final boolean Zh()
  {
    AppMethodBeat.i(32503);
    if (this.values == null)
    {
      ab.e("MicroMsg.InvokeMessageNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(32503);
      return false;
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.preContent")) {
      this.zOS = ((String)this.values.get(".sysmsg.invokeMessage.preContent"));
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
      this.zOT = bo.apW((String)this.values.get(".sysmsg.invokeMessage.timestamp"));
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
        if ((!str.startsWith(".sysmsg.invokeMessage.link.text")) || (bo.isNullOrNil((String)this.values.get(str)))) {
          break label359;
        }
        str = (String)this.values.get(str);
        localStringBuilder.append(str);
        this.fLn.add(str);
        i = str.length();
      }
    }
    label359:
    for (;;)
    {
      break;
      this.fLo.addFirst(Integer.valueOf(localStringBuilder.length() - i));
      this.fLp.add(Integer.valueOf(localStringBuilder.length()));
      this.fLl = localStringBuilder.toString();
      if ((cb.abq() - this.zOT >= 300000L) && (!bo.isNullOrNil(this.zOS))) {
        d.post(new a.1(this), "[checkExpired]");
      }
      AppMethodBeat.o(32503);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.a
 * JD-Core Version:    0.7.0.1
 */
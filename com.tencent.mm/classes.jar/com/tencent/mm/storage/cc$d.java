package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class cc$d
{
  public boolean Apo = false;
  public String Njg;
  public String adkM = "";
  public String content = "";
  public String oSj = "";
  public String title = "";
  
  public static d byu(String paramString)
  {
    AppMethodBeat.i(43211);
    d locald = new d();
    paramString = XmlParser.parseXml(paramString, "msg", null);
    if (paramString != null) {}
    try
    {
      locald.title = ((String)paramString.get(".msg.pushmail.content.subject"));
      locald.content = ((String)paramString.get(".msg.pushmail.content.digest"));
      locald.oSj = ((String)paramString.get(".msg.pushmail.content.sender"));
      locald.adkM = ((String)paramString.get(".msg.pushmail.waplink"));
      locald.Apo = Util.nullAsNil((String)paramString.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
      locald.Njg = ((String)paramString.get(".msg.pushmail.mailid"));
      AppMethodBeat.o(43211);
      return locald;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { Util.stackTraceToString(paramString) });
      }
    }
  }
  
  public final String getSender()
  {
    return this.oSj;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.cc.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.h.c.eo;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class k
  extends i<g>
{
  public static final String[] dXp = { i.a(g.buS, "VoiceRemindInfo") };
  private static long eHS = 0L;
  e dXw;
  Map<String, c> pvY = new HashMap();
  
  public k(e parame)
  {
    super(parame, g.buS, "VoiceRemindInfo", eo.cqY);
    this.dXw = parame;
  }
  
  public static String nR(String paramString)
  {
    long l = System.currentTimeMillis();
    String str2 = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(l));
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.length() > 1) {
        str1 = str2 + com.tencent.mm.a.g.o(paramString.getBytes()).substring(0, 7);
      }
    }
    paramString = str1 + l % 10000L;
    paramString = new StringBuilder().append(paramString);
    l = eHS;
    eHS = 1L + l;
    return l;
  }
  
  public final boolean jJ(String paramString)
  {
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.dXw.delete("VoiceRemindInfo", "filename= ?", new String[] { paramString }) <= 0) {
        y.w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:" + paramString);
      }
      return true;
    }
  }
  
  public final void oy(String paramString)
  {
    c localc = (c)this.pvY.get(paramString);
    if (localc != null)
    {
      localc.SW();
      this.pvY.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.k
 * JD-Core Version:    0.7.0.1
 */
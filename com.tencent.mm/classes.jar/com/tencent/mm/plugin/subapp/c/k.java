package com.tencent.mm.plugin.subapp.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fe;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class k
  extends j<g>
{
  public static final String[] SQL_CREATE;
  private static long fXI;
  e db;
  private Map<String, c> sXE;
  
  static
  {
    AppMethodBeat.i(25323);
    SQL_CREATE = new String[] { j.getCreateSQLs(g.info, "VoiceRemindInfo") };
    fXI = 0L;
    AppMethodBeat.o(25323);
  }
  
  public k(e parame)
  {
    super(parame, g.info, "VoiceRemindInfo", fe.INDEX_CREATE);
    AppMethodBeat.i(25316);
    this.sXE = new HashMap();
    this.db = parame;
    AppMethodBeat.o(25316);
  }
  
  public static String ve(String paramString)
  {
    AppMethodBeat.i(25317);
    long l = System.currentTimeMillis();
    String str2 = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(l));
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.length() > 1) {
        str1 = str2 + com.tencent.mm.a.g.w(paramString.getBytes()).substring(0, 7);
      }
    }
    paramString = str1 + l % 10000L;
    paramString = new StringBuilder().append(paramString);
    l = fXI;
    fXI = 1L + l;
    paramString = l;
    AppMethodBeat.o(25317);
    return paramString;
  }
  
  public final boolean a(String paramString, g paramg)
  {
    AppMethodBeat.i(25322);
    boolean bool;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (paramg == null) {
        break label61;
      }
      bool = true;
      label25:
      Assert.assertTrue(bool);
      paramg = paramg.convertTo();
      if (paramg.size() > 0) {
        break label66;
      }
      ab.e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
    }
    label61:
    label66:
    while (this.db.update("VoiceRemindInfo", paramg, "filename= ?", new String[] { paramString }) <= 0)
    {
      AppMethodBeat.o(25322);
      return false;
      bool = false;
      break;
      bool = false;
      break label25;
    }
    doNotify();
    AppMethodBeat.o(25322);
    return true;
  }
  
  public final c adU(String paramString)
  {
    AppMethodBeat.i(25319);
    if (this.sXE.get(paramString) == null) {
      this.sXE.put(paramString, new c(paramString));
    }
    paramString = (c)this.sXE.get(paramString);
    AppMethodBeat.o(25319);
    return paramString;
  }
  
  public final g adV(String paramString)
  {
    AppMethodBeat.i(25321);
    Object localObject1 = null;
    Object localObject2 = "SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo WHERE filename= ?";
    localObject2 = this.db.a((String)localObject2, new String[] { paramString }, 2);
    paramString = localObject1;
    if (((Cursor)localObject2).moveToFirst())
    {
      paramString = new g();
      paramString.convertFrom((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(25321);
    return paramString;
  }
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(25318);
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.db.delete("VoiceRemindInfo", "filename= ?", new String[] { paramString }) <= 0) {
        ab.w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:".concat(String.valueOf(paramString)));
      }
      AppMethodBeat.o(25318);
      return true;
    }
  }
  
  public final void vL(String paramString)
  {
    AppMethodBeat.i(25320);
    c localc = (c)this.sXE.get(paramString);
    if (localc != null)
    {
      localc.amh();
      this.sXE.remove(paramString);
    }
    AppMethodBeat.o(25320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.k
 * JD-Core Version:    0.7.0.1
 */
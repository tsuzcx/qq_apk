package com.tencent.mm.plugin.subapp.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gf;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class k
  extends j<g>
{
  public static final String[] SQL_CREATE;
  private static long iaX;
  e db;
  private Map<String, c> zQF;
  
  static
  {
    AppMethodBeat.i(29002);
    SQL_CREATE = new String[] { j.getCreateSQLs(g.info, "VoiceRemindInfo") };
    iaX = 0L;
    AppMethodBeat.o(29002);
  }
  
  public k(e parame)
  {
    super(parame, g.info, "VoiceRemindInfo", gf.INDEX_CREATE);
    AppMethodBeat.i(28995);
    this.zQF = new HashMap();
    this.db = parame;
    AppMethodBeat.o(28995);
  }
  
  public static String DU(String paramString)
  {
    AppMethodBeat.i(28996);
    long l = System.currentTimeMillis();
    String str2 = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(l));
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.length() > 1) {
        str1 = str2 + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()).substring(0, 7);
      }
    }
    paramString = str1 + l % 10000L;
    paramString = new StringBuilder().append(paramString);
    l = iaX;
    iaX = 1L + l;
    paramString = l;
    AppMethodBeat.o(28996);
    return paramString;
  }
  
  public final void ED(String paramString)
  {
    AppMethodBeat.i(28999);
    c localc = (c)this.zQF.get(paramString);
    if (localc != null)
    {
      localc.aKd();
      this.zQF.remove(paramString);
    }
    AppMethodBeat.o(28999);
  }
  
  public final boolean a(String paramString, g paramg)
  {
    AppMethodBeat.i(29001);
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
      ac.e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
    }
    label61:
    label66:
    while (this.db.update("VoiceRemindInfo", paramg, "filename= ?", new String[] { paramString }) <= 0)
    {
      AppMethodBeat.o(29001);
      return false;
      bool = false;
      break;
      bool = false;
      break label25;
    }
    doNotify();
    AppMethodBeat.o(29001);
    return true;
  }
  
  public final c axw(String paramString)
  {
    AppMethodBeat.i(28998);
    if (this.zQF.get(paramString) == null) {
      this.zQF.put(paramString, new c(paramString));
    }
    paramString = (c)this.zQF.get(paramString);
    AppMethodBeat.o(28998);
    return paramString;
  }
  
  public final g axx(String paramString)
  {
    AppMethodBeat.i(29000);
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
    AppMethodBeat.o(29000);
    return paramString;
  }
  
  public final boolean zB(String paramString)
  {
    AppMethodBeat.i(28997);
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.db.delete("VoiceRemindInfo", "filename= ?", new String[] { paramString }) <= 0) {
        ac.w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:".concat(String.valueOf(paramString)));
      }
      AppMethodBeat.o(28997);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.subapp.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gq;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class k
  extends j<g>
{
  private static long BzE;
  public static final String[] SQL_CREATE;
  private Map<String, c> BzF;
  e db;
  
  static
  {
    AppMethodBeat.i(29002);
    SQL_CREATE = new String[] { j.getCreateSQLs(g.info, "VoiceRemindInfo") };
    BzE = 0L;
    AppMethodBeat.o(29002);
  }
  
  public k(e parame)
  {
    super(parame, g.info, "VoiceRemindInfo", gq.INDEX_CREATE);
    AppMethodBeat.i(28995);
    this.BzF = new HashMap();
    this.db = parame;
    AppMethodBeat.o(28995);
  }
  
  public static String HI(String paramString)
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
    l = BzE;
    BzE = 1L + l;
    paramString = l;
    AppMethodBeat.o(28996);
    return paramString;
  }
  
  public final boolean Dc(String paramString)
  {
    AppMethodBeat.i(28997);
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (this.db.delete("VoiceRemindInfo", "filename= ?", new String[] { paramString }) <= 0) {
        ae.w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:".concat(String.valueOf(paramString)));
      }
      AppMethodBeat.o(28997);
      return true;
    }
  }
  
  public final void Iu(String paramString)
  {
    AppMethodBeat.i(28999);
    c localc = (c)this.BzF.get(paramString);
    if (localc != null)
    {
      localc.aNK();
      this.BzF.remove(paramString);
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
      ae.e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
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
  
  public final c aDT(String paramString)
  {
    AppMethodBeat.i(28998);
    if (this.BzF.get(paramString) == null) {
      this.BzF.put(paramString, new c(paramString));
    }
    paramString = (c)this.BzF.get(paramString);
    AppMethodBeat.o(28998);
    return paramString;
  }
  
  public final g aDU(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.k
 * JD-Core Version:    0.7.0.1
 */
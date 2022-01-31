package com.tencent.mm.plugin.subapp.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.File;
import java.util.Map;
import junit.framework.Assert;

public final class h
{
  public static g PB(String paramString)
  {
    Object localObject2 = d.bLX();
    Object localObject1 = null;
    String str = "SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo WHERE filename= ?";
    localObject2 = ((k)localObject2).dXw.a(str, new String[] { paramString }, 2);
    paramString = localObject1;
    if (((Cursor)localObject2).moveToFirst())
    {
      paramString = new g();
      paramString.d((Cursor)localObject2);
    }
    ((Cursor)localObject2).close();
    return paramString;
  }
  
  public static c PC(String paramString)
  {
    k localk = d.bLX();
    paramString = bh(paramString, false);
    if (localk.pvY.get(paramString) == null) {
      localk.pvY.put(paramString, new c(paramString));
    }
    return (c)localk.pvY.get(paramString);
  }
  
  static boolean a(g paramg)
  {
    if (paramg == null) {}
    k localk;
    String str;
    label72:
    label77:
    do
    {
      do
      {
        return false;
      } while (paramg.bcw == -1);
      localk = d.bLX();
      str = paramg.field_filename;
      if (str.length() > 0)
      {
        bool = true;
        Assert.assertTrue(bool);
        if (paramg == null) {
          break label72;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        paramg = paramg.vf();
        if (paramg.size() > 0) {
          break label77;
        }
        y.e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
        return false;
        bool = false;
        break;
      }
    } while (localk.dXw.update("VoiceRemindInfo", paramg, "filename= ?", new String[] { str }) <= 0);
    localk.doNotify();
    return true;
  }
  
  public static String bh(String paramString, boolean paramBoolean)
  {
    au.Hx();
    String str = com.tencent.mm.sdk.platformtools.h.b(com.tencent.mm.model.c.FJ(), "recbiz_", paramString, ".rec", 2);
    if (bk.bl(str)) {
      paramString = null;
    }
    do
    {
      do
      {
        return paramString;
        paramString = str;
      } while (paramBoolean);
      paramString = str;
    } while (!new File(str).exists());
    return str;
  }
  
  public static boolean nX(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    g localg = PB(paramString);
    if (localg == null)
    {
      y.e("MicroMsg.VoiceRemindLogic", "Set error failed file:" + paramString);
      return false;
    }
    localg.field_status = 98;
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.bcw = 320;
    boolean bool = a(localg);
    y.d("MicroMsg.VoiceRemindLogic", "setError file:" + paramString + " msgid:" + localg.field_msglocalid + " old stat:" + localg.field_status);
    if ((localg.field_msglocalid == 0) || (bk.bl(localg.field_user)))
    {
      y.e("MicroMsg.VoiceRemindLogic", "setError failed msg id:" + localg.field_msglocalid + " user:" + localg.field_user);
      return bool;
    }
    au.Hx();
    paramString = com.tencent.mm.model.c.Fy().fd(localg.field_msglocalid);
    paramString.setMsgId(localg.field_msglocalid);
    paramString.setStatus(5);
    paramString.ec(localg.field_user);
    paramString.setContent(f.d(localg.field_human, -1L, true));
    au.Hx();
    com.tencent.mm.model.c.Fy().a(paramString.field_msgId, paramString);
    return bool;
  }
  
  public static boolean oC(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      g localg = PB(paramString);
      if (localg == null)
      {
        y.d("MicroMsg.VoiceRemindLogic", "cancel null record : " + paramString);
        return true;
      }
      y.d("MicroMsg.VoiceRemindLogic", "cancel record : " + paramString + " LocalId:" + localg.field_msglocalid);
      if (localg.field_msglocalid != 0)
      {
        au.Hx();
        com.tencent.mm.model.c.Fy().fe(localg.field_msglocalid);
      }
    } while (paramString == null);
    d.bLX().jJ(paramString);
    oy(paramString);
    return new File(bh(paramString, false)).delete();
  }
  
  static void oy(String paramString)
  {
    d.bLX().oy(bh(paramString, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.h
 * JD-Core Version:    0.7.0.1
 */
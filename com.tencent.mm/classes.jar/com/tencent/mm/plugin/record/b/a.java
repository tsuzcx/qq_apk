package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class a
{
  private static f BGq;
  
  private static String E(long paramLong, String paramString)
  {
    AppMethodBeat.i(9444);
    Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = k.b.HD(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(9444);
      return null;
    }
    String str = aB(com.tencent.mm.loader.j.b.aKM(), paramString.title, paramString.iwJ);
    if ((Util.isNullOrNil(paramString.dCK)) && (!Util.isNullOrNil(paramString.iwW))) {
      paramString.dCK = paramString.iwW.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.dCK, paramString.iwI, paramString.type, paramString.iwM);
    AppMethodBeat.o(9444);
    return paramString;
  }
  
  public static void HS(long paramLong)
  {
    AppMethodBeat.i(9439);
    com.tencent.mm.plugin.r.a.cgO().Mo(paramLong);
    c localc = new c();
    com.tencent.mm.plugin.r.a.cgO().get(paramLong, localc);
    if (localc.field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(9439);
      return;
    }
    ca localca = ((l)g.af(l.class)).eiy().Hb(localc.field_msgInfoId);
    if (localca.field_msgId != localc.field_msgInfoId)
    {
      AppMethodBeat.o(9439);
      return;
    }
    localca.setStatus(5);
    ((l)g.af(l.class)).eiy().a(localca.field_msgId, localca);
    AppMethodBeat.o(9439);
  }
  
  private static String a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9443);
    c localc = new c();
    localc.field_fileFullPath = paramString1;
    localc.field_appId = paramString2;
    localc.field_sdkVer = paramInt1;
    localc.field_mediaSvrId = paramString3;
    localc.field_totalLen = paramInt2;
    localc.field_status = 101L;
    localc.field_isUpload = false;
    localc.field_createTime = Util.nowMilliSecond();
    localc.field_lastModifyTime = Util.nowSecond();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    localc.field_type = paramInt3;
    Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.r.a.cgO().insert(localc)), Long.valueOf(localc.systemRowid), Long.valueOf(localc.field_totalLen), Long.valueOf(localc.field_type), Integer.valueOf(paramInt4), paramString1, Util.getStack() });
    AppMethodBeat.o(9443);
    return paramString3;
  }
  
  public static boolean a(ca paramca, c paramc)
  {
    AppMethodBeat.i(9440);
    if ((paramc == null) || (!s.YS(paramc.field_fileFullPath)))
    {
      AppMethodBeat.o(9440);
      return false;
    }
    if ((paramc.deQ()) || ((paramca.field_isSend == 1) && (paramc.field_isUpload)))
    {
      AppMethodBeat.o(9440);
      return true;
    }
    AppMethodBeat.o(9440);
    return false;
  }
  
  private static String aB(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(9442);
    Object localObject = new o(paramString1);
    if (!((o)localObject).exists()) {
      ((o)localObject).mkdirs();
    }
    if (Util.isNullOrNil(paramString2))
    {
      localObject = paramString1 + "da_" + Util.nowMilliSecond();
      paramString2 = (String)localObject;
      if (!Util.isNullOrNil(paramString3)) {
        paramString2 = (String)localObject + "." + paramString3;
      }
    }
    for (;;)
    {
      localObject = paramString2;
      try
      {
        if (!aa.z(new o(paramString2).heq().her()).equalsIgnoreCase(aa.z(new o(paramString1).her())))
        {
          localObject = paramString1 + "da_" + Util.nowMilliSecond();
          Log.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", new Object[] { localObject });
        }
        AppMethodBeat.o(9442);
        return localObject;
        localObject = paramString2;
        if (!Util.isNullOrNil(paramString3))
        {
          localObject = paramString2;
          if (!paramString2.endsWith(paramString3)) {
            localObject = paramString2 + "." + paramString3;
          }
        }
        String str = paramString1 + (String)localObject;
        paramString2 = str;
        if (!s.YS(str)) {
          continue;
        }
        for (;;)
        {
          paramString2 = str;
          if (i < 20)
          {
            if (!s.YS(paramString1 + i + "_" + (String)localObject)) {
              paramString2 = paramString1 + i + "_" + (String)localObject;
            }
          }
          else
          {
            if (i != 20) {
              break;
            }
            localObject = paramString1 + "da_" + Util.nowMilliSecond();
            paramString2 = (String)localObject;
            if (Util.isNullOrNil(paramString3)) {
              break;
            }
            paramString2 = (String)localObject + "." + paramString3;
            break;
          }
          i += 1;
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppMsgLogic", paramString2, "", new Object[0]);
          paramString1 = paramString1 + "da_" + Util.nowMilliSecond();
          localObject = paramString1;
          if (!Util.isNullOrNil(paramString3)) {
            localObject = paramString1 + "." + paramString3;
          }
        }
      }
    }
  }
  
  public static void aK(ca paramca)
  {
    AppMethodBeat.i(9441);
    Object localObject1 = k.b.HD(paramca.field_content);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { paramca.field_content });
      AppMethodBeat.o(9441);
      return;
    }
    if ((Util.isNullOrNil(((k.b)localObject1).dCK)) && (!Util.isNullOrNil(((k.b)localObject1).iwW)))
    {
      Log.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { paramca.field_content });
      ((k.b)localObject1).dCK = ((k.b)localObject1).iwW.hashCode();
    }
    String str5 = ((k.b)localObject1).dCK;
    if (!a(paramca, s(str5, paramca.field_msgId)))
    {
      if (paramca != null) {
        break label190;
      }
      i = 0;
      if (i != 0)
      {
        BGq = new f(paramca.field_msgId, str5, new j()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, q paramAnonymousq) {}
        });
        g.aAg().hqi.a(BGq, 0);
      }
    }
    AppMethodBeat.o(9441);
    return;
    label190:
    int j = 1;
    String str2 = null;
    String str3 = null;
    String str1 = null;
    String str4 = null;
    localObject1 = null;
    Object localObject2 = s(str5, paramca.field_msgId);
    Object localObject4 = k.b.HD(paramca.field_content);
    if (localObject4 != null)
    {
      str2 = Util.nullAsNil(((k.b)localObject4).title);
      str3 = Util.nullAsNil(((k.b)localObject4).iwJ).toLowerCase();
      str1 = Util.nullAsNil(((k.b)localObject4).filemd5);
      str4 = Util.nullAsNil(((k.b)localObject4).dRL);
      localObject1 = Util.nullAsNil(((k.b)localObject4).aesKey);
    }
    if (localObject2 == null)
    {
      E(paramca.field_msgId, paramca.field_content);
      localObject3 = s(str5, paramca.field_msgId);
      localObject2 = localObject3;
      i = j;
      if (localObject3 != null)
      {
        l1 = ((c)localObject3).systemRowid;
        l2 = ((c)localObject3).field_totalLen;
        localObject2 = ((c)localObject3).field_fileFullPath;
        l3 = ((c)localObject3).field_type;
        str6 = ((c)localObject3).field_mediaId;
        l4 = ((c)localObject3).field_msgInfoId;
        bool1 = ((c)localObject3).field_isUpload;
        if (((c)localObject3).field_signature != null) {
          break label532;
        }
      }
      label532:
      for (i = -1;; i = ((c)localObject3).field_signature.length())
      {
        Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject2, Long.valueOf(l3), str6, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        localObject2 = localObject3;
        i = j;
        if (localObject4 != null) {
          if (((k.b)localObject4).iwM == 0)
          {
            localObject2 = localObject3;
            i = j;
            if (((k.b)localObject4).iwI <= 26214400) {}
          }
          else
          {
            i = 0;
            localObject2 = localObject3;
          }
        }
        if (i == 0) {
          g.aAg().hqi.a(new d((c)localObject2, (String)localObject1, str1, str2, str3, str4), 0);
        }
        break;
      }
    }
    Object localObject3 = new o(((c)localObject2).field_fileFullPath);
    if ((((c)localObject2).field_status == 199L) && (!((o)localObject3).exists()))
    {
      Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      E(paramca.field_msgId, paramca.field_content);
    }
    long l1 = ((c)localObject2).systemRowid;
    long l2 = ((c)localObject2).field_totalLen;
    localObject4 = ((c)localObject2).field_fileFullPath;
    long l3 = ((c)localObject2).field_type;
    String str6 = ((c)localObject2).field_mediaId;
    long l4 = ((c)localObject2).field_msgInfoId;
    boolean bool1 = ((c)localObject2).field_isUpload;
    boolean bool2 = ((o)localObject3).exists();
    long l5 = ((c)localObject2).field_status;
    if (((c)localObject2).field_signature == null) {}
    for (int i = -1;; i = ((c)localObject2).field_signature.length())
    {
      Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject4, Long.valueOf(l3), str6, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(l5), Integer.valueOf(i) });
      i = j;
      break;
    }
  }
  
  public static c s(String paramString, long paramLong)
  {
    AppMethodBeat.i(9438);
    c localc2 = new c();
    c localc1;
    if (Util.isNullOrNil(paramString))
    {
      localc1 = null;
      paramString = localc1;
      if (localc1 == null) {
        paramString = com.tencent.mm.plugin.r.a.cgO().Mp(paramLong);
      }
      if (paramString == null) {
        break label329;
      }
      Log.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { paramString, Long.valueOf(paramString.systemRowid), Boolean.valueOf(paramString.field_isUpload), paramString.field_fileFullPath, Long.valueOf(paramString.field_totalLen), Long.valueOf(paramString.field_offset), paramString.field_mediaSvrId, paramString.field_mediaId, Long.valueOf(paramString.field_msgInfoId), Long.valueOf(paramString.field_type), Util.getStack() });
    }
    for (;;)
    {
      AppMethodBeat.o(9438);
      return paramString;
      Log.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", new Object[] { paramString });
      long l = Util.getLong(paramString, -1L);
      if (l != -1L)
      {
        com.tencent.mm.plugin.r.a.cgO().get(l, localc2);
        localc1 = localc2;
        if (localc2.systemRowid != l)
        {
          localc2 = com.tencent.mm.plugin.r.a.cgO().bdx(paramString);
          if (localc2 != null)
          {
            localc1 = localc2;
            if (localc2.field_mediaSvrId.equals(paramString)) {}
          }
          else
          {
            Log.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
            localc1 = null;
          }
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", new Object[] { paramString, Long.valueOf(l) });
        break;
        localc2 = com.tencent.mm.plugin.r.a.cgO().bdx(paramString);
        if (localc2 != null)
        {
          localc1 = localc2;
          if (localc2.field_mediaSvrId.equals(paramString)) {}
        }
        else
        {
          Log.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
          localc1 = null;
        }
      }
      label329:
      Log.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[] { Util.getStack() });
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.a
 * JD-Core Version:    0.7.0.1
 */
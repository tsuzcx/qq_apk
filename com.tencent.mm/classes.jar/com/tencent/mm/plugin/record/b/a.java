package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.j;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;

public final class a
{
  private static f HCv;
  
  private static String M(long paramLong, String paramString)
  {
    AppMethodBeat.i(9444);
    Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = k.b.OQ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(9444);
      return null;
    }
    String str = aw(b.aSO(), paramString.title, paramString.llY);
    if ((Util.isNullOrNil(paramString.fvr)) && (!Util.isNullOrNil(paramString.lml))) {
      paramString.fvr = paramString.lml.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.fvr, paramString.llX, paramString.type, paramString.lmb);
    AppMethodBeat.o(9444);
    return paramString;
  }
  
  public static void Pn(long paramLong)
  {
    AppMethodBeat.i(9439);
    com.tencent.mm.plugin.ab.a.ctZ().TQ(paramLong);
    com.tencent.mm.pluginsdk.model.app.c localc = new com.tencent.mm.pluginsdk.model.app.c();
    com.tencent.mm.plugin.ab.a.ctZ().get(paramLong, localc);
    if (localc.field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(9439);
      return;
    }
    ca localca = ((n)h.ae(n.class)).eSe().Oq(localc.field_msgInfoId);
    if (localca.field_msgId != localc.field_msgInfoId)
    {
      AppMethodBeat.o(9439);
      return;
    }
    if ((localca.getType() == 1090519089) && (localca.ilx == 1)) {
      localca.setFileStatus(3);
    }
    for (;;)
    {
      ((n)h.ae(n.class)).eSe().a(localca.field_msgId, localca);
      AppMethodBeat.o(9439);
      return;
      localca.setStatus(5);
    }
  }
  
  private static String a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9443);
    com.tencent.mm.pluginsdk.model.app.c localc = new com.tencent.mm.pluginsdk.model.app.c();
    localc.field_fileFullPath = paramString1;
    localc.field_appId = paramString2;
    localc.field_sdkVer = paramInt1;
    localc.field_mediaSvrId = paramString3;
    localc.field_totalLen = paramInt2;
    localc.field_status = 101L;
    localc.field_isUpload = false;
    localc.field_createTime = cm.bfC();
    localc.field_lastModifyTime = Util.nowSecond();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    localc.field_type = paramInt3;
    Log.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.ab.a.ctZ().insert(localc)), Long.valueOf(localc.systemRowid), Long.valueOf(localc.field_totalLen), Long.valueOf(localc.field_type), Integer.valueOf(paramInt4), paramString1, Util.getStack() });
    AppMethodBeat.o(9443);
    return paramString3;
  }
  
  public static boolean a(ca paramca, com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(9440);
    if ((paramc == null) || (!u.agG(paramc.field_fileFullPath)))
    {
      AppMethodBeat.o(9440);
      return false;
    }
    if ((paramc.evg()) || ((paramca.field_isSend == 1) && (paramc.field_isUpload)))
    {
      AppMethodBeat.o(9440);
      return true;
    }
    AppMethodBeat.o(9440);
    return false;
  }
  
  public static void aW(ca paramca)
  {
    AppMethodBeat.i(9441);
    Object localObject1 = k.b.OQ(paramca.field_content);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { paramca.field_content });
      AppMethodBeat.o(9441);
      return;
    }
    if ((Util.isNullOrNil(((k.b)localObject1).fvr)) && (!Util.isNullOrNil(((k.b)localObject1).lml)))
    {
      Log.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { paramca.field_content });
      ((k.b)localObject1).fvr = ((k.b)localObject1).lml.hashCode();
    }
    String str5 = ((k.b)localObject1).fvr;
    if (!a(paramca, p(str5, paramca.field_msgId)))
    {
      if (paramca != null) {
        break label190;
      }
      i = 0;
      if (i != 0)
      {
        HCv = new f(paramca.field_msgId, str5, new j()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, com.tencent.mm.an.q paramAnonymousq) {}
        });
        h.aHF().kcd.a(HCv, 0);
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
    Object localObject2 = p(str5, paramca.field_msgId);
    Object localObject4 = k.b.OQ(paramca.field_content);
    if (localObject4 != null)
    {
      str2 = Util.nullAsNil(((k.b)localObject4).title);
      str3 = Util.nullAsNil(((k.b)localObject4).llY).toLowerCase();
      str1 = Util.nullAsNil(((k.b)localObject4).filemd5);
      str4 = Util.nullAsNil(((k.b)localObject4).fLi);
      localObject1 = Util.nullAsNil(((k.b)localObject4).aesKey);
    }
    if (localObject2 == null)
    {
      M(paramca.field_msgId, paramca.field_content);
      localObject3 = p(str5, paramca.field_msgId);
      localObject2 = localObject3;
      i = j;
      if (localObject3 != null)
      {
        l1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).systemRowid;
        l2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_totalLen;
        localObject2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath;
        l3 = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_type;
        str6 = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_mediaId;
        l4 = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_msgInfoId;
        bool1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_isUpload;
        if (((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_signature != null) {
          break label532;
        }
      }
      label532:
      for (i = -1;; i = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_signature.length())
      {
        Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject2, Long.valueOf(l3), str6, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        localObject2 = localObject3;
        i = j;
        if (localObject4 != null) {
          if (((k.b)localObject4).lmb == 0)
          {
            localObject2 = localObject3;
            i = j;
            if (((k.b)localObject4).llX <= 26214400) {}
          }
          else
          {
            i = 0;
            localObject2 = localObject3;
          }
        }
        if (i == 0) {
          h.aHF().kcd.a(new d((com.tencent.mm.pluginsdk.model.app.c)localObject2, (String)localObject1, str1, str2, str3, str4), 0);
        }
        break;
      }
    }
    Object localObject3 = new com.tencent.mm.vfs.q(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
    if ((((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_status == 199L) && (!((com.tencent.mm.vfs.q)localObject3).ifE()))
    {
      Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      M(paramca.field_msgId, paramca.field_content);
    }
    long l1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).systemRowid;
    long l2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen;
    localObject4 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
    long l3 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_type;
    String str6 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaId;
    long l4 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_msgInfoId;
    boolean bool1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_isUpload;
    boolean bool2 = ((com.tencent.mm.vfs.q)localObject3).ifE();
    long l5 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_status;
    if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature == null) {}
    for (int i = -1;; i = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature.length())
    {
      Log.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject4, Long.valueOf(l3), str6, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(l5), Integer.valueOf(i) });
      i = j;
      break;
    }
  }
  
  private static String aw(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(9442);
    Object localObject = new com.tencent.mm.vfs.q(paramString1);
    if (!((com.tencent.mm.vfs.q)localObject).ifE()) {
      ((com.tencent.mm.vfs.q)localObject).ifL();
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
        if (!new com.tencent.mm.vfs.q(paramString2).ifB().bOF().equalsIgnoreCase(new com.tencent.mm.vfs.q(paramString1).bOF()))
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
        if (!u.agG(str)) {
          continue;
        }
        for (;;)
        {
          paramString2 = str;
          if (i < 20)
          {
            if (!u.agG(paramString1 + i + "_" + (String)localObject)) {
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
  
  public static com.tencent.mm.pluginsdk.model.app.c p(String paramString, long paramLong)
  {
    AppMethodBeat.i(9438);
    com.tencent.mm.pluginsdk.model.app.c localc2 = new com.tencent.mm.pluginsdk.model.app.c();
    com.tencent.mm.pluginsdk.model.app.c localc1;
    if (Util.isNullOrNil(paramString))
    {
      localc1 = null;
      paramString = localc1;
      if (localc1 == null) {
        paramString = com.tencent.mm.plugin.ab.a.ctZ().TR(paramLong);
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
        com.tencent.mm.plugin.ab.a.ctZ().get(l, localc2);
        localc1 = localc2;
        if (localc2.systemRowid != l)
        {
          localc2 = com.tencent.mm.plugin.ab.a.ctZ().bpR(paramString);
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
        localc2 = com.tencent.mm.plugin.ab.a.ctZ().bpR(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;

public final class a
{
  private static e uZW;
  
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
    localc.field_createTime = bt.eGO();
    localc.field_lastModifyTime = bt.aGK();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    localc.field_type = paramInt3;
    ad.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.s.a.bxS().insert(localc)), Long.valueOf(localc.systemRowid), Long.valueOf(localc.field_totalLen), Long.valueOf(localc.field_type), Integer.valueOf(paramInt4), paramString1, bt.eGN() });
    AppMethodBeat.o(9443);
    return paramString3;
  }
  
  public static boolean a(bl parambl, com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(9440);
    if ((paramc == null) || (!i.eK(paramc.field_fileFullPath)))
    {
      AppMethodBeat.o(9440);
      return false;
    }
    if ((paramc.cAX()) || ((parambl.field_isSend == 1) && (paramc.field_isUpload)))
    {
      AppMethodBeat.o(9440);
      return true;
    }
    AppMethodBeat.o(9440);
    return false;
  }
  
  private static String ai(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(9442);
    Object localObject = new com.tencent.mm.vfs.e(paramString1);
    if (!((com.tencent.mm.vfs.e)localObject).exists()) {
      ((com.tencent.mm.vfs.e)localObject).mkdirs();
    }
    if (bt.isNullOrNil(paramString2))
    {
      localObject = paramString1 + "da_" + bt.eGO();
      paramString2 = (String)localObject;
      if (!bt.isNullOrNil(paramString3)) {
        paramString2 = (String)localObject + "." + paramString3;
      }
    }
    for (;;)
    {
      localObject = paramString2;
      try
      {
        if (!com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(paramString2).fhT().fhU()).equalsIgnoreCase(com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(paramString1).fhU())))
        {
          localObject = paramString1 + "da_" + bt.eGO();
          ad.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", new Object[] { localObject });
        }
        AppMethodBeat.o(9442);
        return localObject;
        localObject = paramString2;
        if (!bt.isNullOrNil(paramString3))
        {
          localObject = paramString2;
          if (!paramString2.endsWith(paramString3)) {
            localObject = paramString2 + "." + paramString3;
          }
        }
        String str = paramString1 + (String)localObject;
        paramString2 = str;
        if (!i.eK(str)) {
          continue;
        }
        for (;;)
        {
          paramString2 = str;
          if (i < 20)
          {
            if (!i.eK(paramString1 + i + "_" + (String)localObject)) {
              paramString2 = paramString1 + i + "_" + (String)localObject;
            }
          }
          else
          {
            if (i != 20) {
              break;
            }
            localObject = paramString1 + "da_" + bt.eGO();
            paramString2 = (String)localObject;
            if (bt.isNullOrNil(paramString3)) {
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
          ad.printErrStackTrace("MicroMsg.AppMsgLogic", paramString2, "", new Object[0]);
          paramString1 = paramString1 + "da_" + bt.eGO();
          localObject = paramString1;
          if (!bt.isNullOrNil(paramString3)) {
            localObject = paramString1 + "." + paramString3;
          }
        }
      }
    }
  }
  
  public static void av(bl parambl)
  {
    AppMethodBeat.i(9441);
    Object localObject1 = k.b.rx(parambl.field_content);
    if (localObject1 == null)
    {
      ad.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { parambl.field_content });
      AppMethodBeat.o(9441);
      return;
    }
    if ((bt.isNullOrNil(((k.b)localObject1).dbA)) && (!bt.isNullOrNil(((k.b)localObject1).gHt)))
    {
      ad.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { parambl.field_content });
      ((k.b)localObject1).dbA = ((k.b)localObject1).gHt.hashCode();
    }
    String str5 = ((k.b)localObject1).dbA;
    if (!a(parambl, q(str5, parambl.field_msgId)))
    {
      if (parambl != null) {
        break label188;
      }
      i = 0;
      if (i != 0)
      {
        uZW = new e(parambl.field_msgId, str5, new com.tencent.mm.al.h()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn) {}
        });
        g.afA().gcy.a(uZW, 0);
      }
    }
    AppMethodBeat.o(9441);
    return;
    label188:
    int j = 1;
    String str2 = null;
    String str3 = null;
    String str1 = null;
    String str4 = null;
    localObject1 = null;
    Object localObject2 = q(str5, parambl.field_msgId);
    Object localObject4 = k.b.rx(parambl.field_content);
    if (localObject4 != null)
    {
      str2 = bt.nullAsNil(((k.b)localObject4).title);
      str3 = bt.nullAsNil(((k.b)localObject4).gHf).toLowerCase();
      str1 = bt.nullAsNil(((k.b)localObject4).filemd5);
      str4 = bt.nullAsNil(((k.b)localObject4).dpv);
      localObject1 = bt.nullAsNil(((k.b)localObject4).fMw);
    }
    if (localObject2 == null)
    {
      x(parambl.field_msgId, parambl.field_content);
      localObject3 = q(str5, parambl.field_msgId);
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
          break label541;
        }
        i = -1;
        label380:
        ad.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject2, Long.valueOf(l3), str6, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        localObject2 = localObject3;
        i = j;
        if (localObject4 != null) {
          if (((k.b)localObject4).gHi == 0)
          {
            localObject2 = localObject3;
            i = j;
            if (((k.b)localObject4).gHe <= 26214400) {}
          }
          else
          {
            if (bt.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_signature)) {
              break label553;
            }
          }
        }
      }
      label541:
      label553:
      for (i = 1;; i = 0)
      {
        localObject2 = localObject3;
        if (i == 0) {
          g.afA().gcy.a(new c((com.tencent.mm.pluginsdk.model.app.c)localObject2, (String)localObject1, str1, str2, str3, str4), 0);
        }
        break;
        i = ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_signature.length();
        break label380;
      }
    }
    Object localObject3 = new com.tencent.mm.vfs.e(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath);
    if ((((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_status == 199L) && (!((com.tencent.mm.vfs.e)localObject3).exists()))
    {
      ad.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      x(parambl.field_msgId, parambl.field_content);
    }
    long l1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).systemRowid;
    long l2 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_totalLen;
    localObject4 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
    long l3 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_type;
    String str6 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_mediaId;
    long l4 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_msgInfoId;
    boolean bool1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_isUpload;
    boolean bool2 = ((com.tencent.mm.vfs.e)localObject3).exists();
    long l5 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_status;
    if (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature == null) {}
    for (int i = -1;; i = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_signature.length())
    {
      ad.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject4, Long.valueOf(l3), str6, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(l5), Integer.valueOf(i) });
      i = j;
      break;
    }
  }
  
  public static com.tencent.mm.pluginsdk.model.app.c q(String paramString, long paramLong)
  {
    AppMethodBeat.i(9438);
    com.tencent.mm.pluginsdk.model.app.c localc2 = new com.tencent.mm.pluginsdk.model.app.c();
    com.tencent.mm.pluginsdk.model.app.c localc1;
    if (bt.isNullOrNil(paramString))
    {
      localc1 = null;
      paramString = localc1;
      if (localc1 == null) {
        paramString = com.tencent.mm.plugin.s.a.bxS().vj(paramLong);
      }
      if (paramString == null) {
        break label329;
      }
      ad.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { paramString, Long.valueOf(paramString.systemRowid), Boolean.valueOf(paramString.field_isUpload), paramString.field_fileFullPath, Long.valueOf(paramString.field_totalLen), Long.valueOf(paramString.field_offset), paramString.field_mediaSvrId, paramString.field_mediaId, Long.valueOf(paramString.field_msgInfoId), Long.valueOf(paramString.field_type), bt.eGN() });
    }
    for (;;)
    {
      AppMethodBeat.o(9438);
      return paramString;
      ad.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", new Object[] { paramString });
      long l = bt.getLong(paramString, -1L);
      if (l != -1L)
      {
        com.tencent.mm.plugin.s.a.bxS().get(l, localc2);
        localc1 = localc2;
        if (localc2.systemRowid != l)
        {
          localc2 = com.tencent.mm.plugin.s.a.bxS().aAL(paramString);
          if (localc2 != null)
          {
            localc1 = localc2;
            if (localc2.field_mediaSvrId.equals(paramString)) {}
          }
          else
          {
            ad.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
            localc1 = null;
          }
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", new Object[] { paramString, Long.valueOf(l) });
        break;
        localc2 = com.tencent.mm.plugin.s.a.bxS().aAL(paramString);
        if (localc2 != null)
        {
          localc1 = localc2;
          if (localc2.field_mediaSvrId.equals(paramString)) {}
        }
        else
        {
          ad.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
          localc1 = null;
        }
      }
      label329:
      ad.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[] { bt.eGN() });
    }
  }
  
  public static void rO(long paramLong)
  {
    AppMethodBeat.i(9439);
    com.tencent.mm.plugin.s.a.bxS().vi(paramLong);
    com.tencent.mm.pluginsdk.model.app.c localc = new com.tencent.mm.pluginsdk.model.app.c();
    com.tencent.mm.plugin.s.a.bxS().get(paramLong, localc);
    if (localc.field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(9439);
      return;
    }
    bl localbl = ((k)g.ab(k.class)).cOI().rm(localc.field_msgInfoId);
    if (localbl.field_msgId != localc.field_msgInfoId)
    {
      AppMethodBeat.o(9439);
      return;
    }
    localbl.setStatus(5);
    ((k)g.ab(k.class)).cOI().a(localbl.field_msgId, localbl);
    AppMethodBeat.o(9439);
  }
  
  private static String x(long paramLong, String paramString)
  {
    AppMethodBeat.i(9444);
    ad.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = k.b.rx(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(9444);
      return null;
    }
    String str = ai(com.tencent.mm.loader.j.b.aij(), paramString.title, paramString.gHf);
    if ((bt.isNullOrNil(paramString.dbA)) && (!bt.isNullOrNil(paramString.gHt))) {
      paramString.dbA = paramString.gHt.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.dbA, paramString.gHe, paramString.type, paramString.gHi);
    AppMethodBeat.o(9444);
    return paramString;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.a
 * JD-Core Version:    0.7.0.1
 */
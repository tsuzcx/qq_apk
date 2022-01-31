package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class a
{
  private static e pYd;
  
  private static String Z(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(135623);
    Object localObject = new com.tencent.mm.vfs.b(paramString1);
    if (!((com.tencent.mm.vfs.b)localObject).exists()) {
      ((com.tencent.mm.vfs.b)localObject).mkdirs();
    }
    if (bo.isNullOrNil(paramString2))
    {
      localObject = paramString1 + "da_" + bo.aoy();
      paramString2 = (String)localObject;
      if (!bo.isNullOrNil(paramString3)) {
        paramString2 = (String)localObject + "." + paramString3;
      }
    }
    for (;;)
    {
      localObject = paramString2;
      try
      {
        if (!com.tencent.mm.vfs.j.p(new com.tencent.mm.vfs.b(paramString2).dQI().dQJ()).equalsIgnoreCase(com.tencent.mm.vfs.j.p(new com.tencent.mm.vfs.b(paramString1).dQJ())))
        {
          localObject = paramString1 + "da_" + bo.aoy();
          ab.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", new Object[] { localObject });
        }
        AppMethodBeat.o(135623);
        return localObject;
        localObject = paramString2;
        if (!bo.isNullOrNil(paramString3))
        {
          localObject = paramString2;
          if (!paramString2.endsWith(paramString3)) {
            localObject = paramString2 + "." + paramString3;
          }
        }
        String str = paramString1 + (String)localObject;
        paramString2 = str;
        if (!com.tencent.mm.vfs.e.cN(str)) {
          continue;
        }
        for (;;)
        {
          paramString2 = str;
          if (i < 20)
          {
            if (!com.tencent.mm.vfs.e.cN(paramString1 + i + "_" + (String)localObject)) {
              paramString2 = paramString1 + i + "_" + (String)localObject;
            }
          }
          else
          {
            if (i != 20) {
              break;
            }
            localObject = paramString1 + "da_" + bo.aoy();
            paramString2 = (String)localObject;
            if (bo.isNullOrNil(paramString3)) {
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
          ab.printErrStackTrace("MicroMsg.AppMsgLogic", paramString2, "", new Object[0]);
          paramString1 = paramString1 + "da_" + bo.aoy();
          localObject = paramString1;
          if (!bo.isNullOrNil(paramString3)) {
            localObject = paramString1 + "." + paramString3;
          }
        }
      }
    }
  }
  
  private static String a(String paramString1, long paramLong, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(135624);
    com.tencent.mm.pluginsdk.model.app.b localb = new com.tencent.mm.pluginsdk.model.app.b();
    localb.field_fileFullPath = paramString1;
    localb.field_appId = paramString2;
    localb.field_sdkVer = paramInt1;
    localb.field_mediaSvrId = paramString3;
    localb.field_totalLen = paramInt2;
    localb.field_status = 101L;
    localb.field_isUpload = false;
    localb.field_createTime = bo.aoy();
    localb.field_lastModifyTime = bo.aox();
    localb.field_msgInfoId = paramLong;
    localb.field_netTimes = 0L;
    localb.field_type = paramInt3;
    ab.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.s.a.aUJ().insert(localb)), Long.valueOf(localb.systemRowid), Long.valueOf(localb.field_totalLen), Long.valueOf(localb.field_type), Integer.valueOf(paramInt4), paramString1, bo.dtY() });
    AppMethodBeat.o(135624);
    return paramString3;
  }
  
  public static boolean a(bi parambi, com.tencent.mm.pluginsdk.model.app.b paramb)
  {
    AppMethodBeat.i(135621);
    if ((paramb == null) || (!com.tencent.mm.vfs.e.cN(paramb.field_fileFullPath)))
    {
      AppMethodBeat.o(135621);
      return false;
    }
    if ((paramb.bEL()) || ((parambi.field_isSend == 1) && (paramb.field_isUpload)))
    {
      AppMethodBeat.o(135621);
      return true;
    }
    AppMethodBeat.o(135621);
    return false;
  }
  
  public static void af(bi parambi)
  {
    AppMethodBeat.i(135622);
    Object localObject1 = j.b.mY(parambi.field_content);
    if (localObject1 == null)
    {
      ab.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { parambi.field_content });
      AppMethodBeat.o(135622);
      return;
    }
    if ((bo.isNullOrNil(((j.b)localObject1).cmN)) && (!bo.isNullOrNil(((j.b)localObject1).fgL)))
    {
      ab.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { parambi.field_content });
      ((j.b)localObject1).cmN = ((j.b)localObject1).fgL.hashCode();
    }
    String str5 = ((j.b)localObject1).cmN;
    if (!a(parambi, q(str5, parambi.field_msgId)))
    {
      if (parambi != null) {
        break label185;
      }
      i = 0;
      if (i != 0)
      {
        pYd = new e(parambi.field_msgId, str5, new a.1());
        g.RK().eHt.a(pYd, 0);
      }
    }
    AppMethodBeat.o(135622);
    return;
    label185:
    int j = 1;
    String str2 = null;
    String str3 = null;
    String str1 = null;
    String str4 = null;
    localObject1 = null;
    Object localObject2 = q(str5, parambi.field_msgId);
    Object localObject4 = j.b.mY(parambi.field_content);
    if (localObject4 != null)
    {
      str2 = bo.nullAsNil(((j.b)localObject4).title);
      str3 = bo.nullAsNil(((j.b)localObject4).fgx).toLowerCase();
      str1 = bo.nullAsNil(((j.b)localObject4).filemd5);
      str4 = bo.nullAsNil(((j.b)localObject4).czp);
      localObject1 = bo.nullAsNil(((j.b)localObject4).ewj);
    }
    if (localObject2 == null)
    {
      s(parambi.field_msgId, parambi.field_content);
      localObject3 = q(str5, parambi.field_msgId);
      localObject2 = localObject3;
      i = j;
      if (localObject3 != null)
      {
        l1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).systemRowid;
        l2 = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_totalLen;
        localObject2 = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath;
        l3 = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_type;
        str6 = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_mediaId;
        l4 = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_msgInfoId;
        bool1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_isUpload;
        if (((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_signature != null) {
          break label538;
        }
        i = -1;
        label377:
        ab.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject2, Long.valueOf(l3), str6, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        localObject2 = localObject3;
        i = j;
        if (localObject4 != null) {
          if (((j.b)localObject4).fgA == 0)
          {
            localObject2 = localObject3;
            i = j;
            if (((j.b)localObject4).fgw <= 26214400) {}
          }
          else
          {
            if (bo.isNullOrNil(((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_signature)) {
              break label550;
            }
          }
        }
      }
      label538:
      label550:
      for (i = 1;; i = 0)
      {
        localObject2 = localObject3;
        if (i == 0) {
          g.RK().eHt.a(new c((com.tencent.mm.pluginsdk.model.app.b)localObject2, (String)localObject1, str1, str2, str3, str4), 0);
        }
        break;
        i = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_signature.length();
        break label377;
      }
    }
    Object localObject3 = new com.tencent.mm.vfs.b(((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath);
    if ((((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_status == 199L) && (!((com.tencent.mm.vfs.b)localObject3).exists()))
    {
      ab.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      s(parambi.field_msgId, parambi.field_content);
    }
    long l1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).systemRowid;
    long l2 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_totalLen;
    localObject4 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_fileFullPath;
    long l3 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_type;
    String str6 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_mediaId;
    long l4 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_msgInfoId;
    boolean bool1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_isUpload;
    boolean bool2 = ((com.tencent.mm.vfs.b)localObject3).exists();
    long l5 = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_status;
    if (((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_signature == null) {}
    for (int i = -1;; i = ((com.tencent.mm.pluginsdk.model.app.b)localObject2).field_signature.length())
    {
      ab.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject4, Long.valueOf(l3), str6, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(l5), Integer.valueOf(i) });
      i = j;
      break;
    }
  }
  
  public static void kX(long paramLong)
  {
    AppMethodBeat.i(135620);
    com.tencent.mm.plugin.s.a.aUJ().nv(paramLong);
    com.tencent.mm.pluginsdk.model.app.b localb = new com.tencent.mm.pluginsdk.model.app.b();
    com.tencent.mm.plugin.s.a.aUJ().get(paramLong, localb);
    if (localb.field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(135620);
      return;
    }
    bi localbi = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().kB(localb.field_msgInfoId);
    if (localbi.field_msgId != localb.field_msgInfoId)
    {
      AppMethodBeat.o(135620);
      return;
    }
    localbi.setStatus(5);
    ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().a(localbi.field_msgId, localbi);
    AppMethodBeat.o(135620);
  }
  
  public static com.tencent.mm.pluginsdk.model.app.b q(String paramString, long paramLong)
  {
    AppMethodBeat.i(135619);
    com.tencent.mm.pluginsdk.model.app.b localb2 = new com.tencent.mm.pluginsdk.model.app.b();
    com.tencent.mm.pluginsdk.model.app.b localb1;
    if (bo.isNullOrNil(paramString))
    {
      localb1 = null;
      paramString = localb1;
      if (localb1 == null) {
        paramString = com.tencent.mm.plugin.s.a.aUJ().nw(paramLong);
      }
      if (paramString == null) {
        break label329;
      }
      ab.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { paramString, Long.valueOf(paramString.systemRowid), Boolean.valueOf(paramString.field_isUpload), paramString.field_fileFullPath, Long.valueOf(paramString.field_totalLen), Long.valueOf(paramString.field_offset), paramString.field_mediaSvrId, paramString.field_mediaId, Long.valueOf(paramString.field_msgInfoId), Long.valueOf(paramString.field_type), bo.dtY() });
    }
    for (;;)
    {
      AppMethodBeat.o(135619);
      return paramString;
      ab.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", new Object[] { paramString });
      long l = bo.getLong(paramString, -1L);
      if (l != -1L)
      {
        com.tencent.mm.plugin.s.a.aUJ().get(l, localb2);
        localb1 = localb2;
        if (localb2.systemRowid != l)
        {
          localb2 = com.tencent.mm.plugin.s.a.aUJ().alo(paramString);
          if (localb2 != null)
          {
            localb1 = localb2;
            if (localb2.field_mediaSvrId.equals(paramString)) {}
          }
          else
          {
            ab.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
            localb1 = null;
          }
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", new Object[] { paramString, Long.valueOf(l) });
        break;
        localb2 = com.tencent.mm.plugin.s.a.aUJ().alo(paramString);
        if (localb2 != null)
        {
          localb1 = localb2;
          if (localb2.field_mediaSvrId.equals(paramString)) {}
        }
        else
        {
          ab.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
          localb1 = null;
        }
      }
      label329:
      ab.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[] { bo.dtY() });
    }
  }
  
  private static String s(long paramLong, String paramString)
  {
    AppMethodBeat.i(135625);
    ab.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = j.b.mY(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(135625);
      return null;
    }
    String str = Z(com.tencent.mm.compatible.util.e.esq, paramString.title, paramString.fgx);
    if ((bo.isNullOrNil(paramString.cmN)) && (!bo.isNullOrNil(paramString.fgL))) {
      paramString.cmN = paramString.fgL.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.cmN, paramString.fgw, paramString.type, paramString.fgA);
    AppMethodBeat.o(135625);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.a
 * JD-Core Version:    0.7.0.1
 */
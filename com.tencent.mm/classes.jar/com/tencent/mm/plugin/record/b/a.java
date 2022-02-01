package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;

public final class a
{
  private static f xGr;
  
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
    localc.field_createTime = bu.fpO();
    localc.field_lastModifyTime = bu.aRi();
    localc.field_msgInfoId = paramLong;
    localc.field_netTimes = 0L;
    localc.field_type = paramInt3;
    ae.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach ret[%b], rowid[%d], field_totalLen[%d], type[%d], isLargeFile[%d], destFile[%s], stack[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.s.a.bJV().insert(localc)), Long.valueOf(localc.systemRowid), Long.valueOf(localc.field_totalLen), Long.valueOf(localc.field_type), Integer.valueOf(paramInt4), paramString1, bu.fpN() });
    AppMethodBeat.o(9443);
    return paramString3;
  }
  
  public static boolean a(bv parambv, c paramc)
  {
    AppMethodBeat.i(9440);
    if ((paramc == null) || (!o.fB(paramc.field_fileFullPath)))
    {
      AppMethodBeat.o(9440);
      return false;
    }
    if ((paramc.cZe()) || ((parambv.field_isSend == 1) && (paramc.field_isUpload)))
    {
      AppMethodBeat.o(9440);
      return true;
    }
    AppMethodBeat.o(9440);
    return false;
  }
  
  private static String aq(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(9442);
    Object localObject = new k(paramString1);
    if (!((k)localObject).exists()) {
      ((k)localObject).mkdirs();
    }
    if (bu.isNullOrNil(paramString2))
    {
      localObject = paramString1 + "da_" + bu.fpO();
      paramString2 = (String)localObject;
      if (!bu.isNullOrNil(paramString3)) {
        paramString2 = (String)localObject + "." + paramString3;
      }
    }
    for (;;)
    {
      localObject = paramString2;
      try
      {
        if (!w.B(new k(paramString2).fTg().fTh()).equalsIgnoreCase(w.B(new k(paramString1).fTh())))
        {
          localObject = paramString1 + "da_" + bu.fpO();
          ae.w("MicroMsg.AppMsgLogic", "maybe DirTraversal attach. %s", new Object[] { localObject });
        }
        AppMethodBeat.o(9442);
        return localObject;
        localObject = paramString2;
        if (!bu.isNullOrNil(paramString3))
        {
          localObject = paramString2;
          if (!paramString2.endsWith(paramString3)) {
            localObject = paramString2 + "." + paramString3;
          }
        }
        String str = paramString1 + (String)localObject;
        paramString2 = str;
        if (!o.fB(str)) {
          continue;
        }
        for (;;)
        {
          paramString2 = str;
          if (i < 20)
          {
            if (!o.fB(paramString1 + i + "_" + (String)localObject)) {
              paramString2 = paramString1 + i + "_" + (String)localObject;
            }
          }
          else
          {
            if (i != 20) {
              break;
            }
            localObject = paramString1 + "da_" + bu.fpO();
            paramString2 = (String)localObject;
            if (bu.isNullOrNil(paramString3)) {
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
          ae.printErrStackTrace("MicroMsg.AppMsgLogic", paramString2, "", new Object[0]);
          paramString1 = paramString1 + "da_" + bu.fpO();
          localObject = paramString1;
          if (!bu.isNullOrNil(paramString3)) {
            localObject = paramString1 + "." + paramString3;
          }
        }
      }
    }
  }
  
  public static void az(bv parambv)
  {
    AppMethodBeat.i(9441);
    Object localObject1 = k.b.zb(parambv.field_content);
    if (localObject1 == null)
    {
      ae.e("MicroMsg.AppMsgLogic", "parse msgContent error, %s", new Object[] { parambv.field_content });
      AppMethodBeat.o(9441);
      return;
    }
    if ((bu.isNullOrNil(((k.b)localObject1).dlu)) && (!bu.isNullOrNil(((k.b)localObject1).hCR)))
    {
      ae.e("MicroMsg.AppMsgLogic", "msgContent format error, %s", new Object[] { parambv.field_content });
      ((k.b)localObject1).dlu = ((k.b)localObject1).hCR.hashCode();
    }
    String str5 = ((k.b)localObject1).dlu;
    if (!a(parambv, r(str5, parambv.field_msgId)))
    {
      if (parambv != null) {
        break label188;
      }
      i = 0;
      if (i != 0)
      {
        xGr = new f(parambv.field_msgId, str5, new com.tencent.mm.ak.g()
        {
          public final void a(int paramAnonymousInt1, int paramAnonymousInt2, n paramAnonymousn) {}
        });
        com.tencent.mm.kernel.g.ajQ().gDv.a(xGr, 0);
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
    Object localObject2 = r(str5, parambv.field_msgId);
    Object localObject4 = k.b.zb(parambv.field_content);
    if (localObject4 != null)
    {
      str2 = bu.nullAsNil(((k.b)localObject4).title);
      str3 = bu.nullAsNil(((k.b)localObject4).hCD).toLowerCase();
      str1 = bu.nullAsNil(((k.b)localObject4).filemd5);
      str4 = bu.nullAsNil(((k.b)localObject4).dzZ);
      localObject1 = bu.nullAsNil(((k.b)localObject4).gmb);
    }
    if (localObject2 == null)
    {
      z(parambv.field_msgId, parambv.field_content);
      localObject3 = r(str5, parambv.field_msgId);
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
          break label530;
        }
      }
      label530:
      for (i = -1;; i = ((c)localObject3).field_signature.length())
      {
        ae.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject2, Long.valueOf(l3), str6, Long.valueOf(l4), Boolean.valueOf(bool1), Integer.valueOf(i) });
        localObject2 = localObject3;
        i = j;
        if (localObject4 != null) {
          if (((k.b)localObject4).hCG == 0)
          {
            localObject2 = localObject3;
            i = j;
            if (((k.b)localObject4).hCC <= 26214400) {}
          }
          else
          {
            i = 0;
            localObject2 = localObject3;
          }
        }
        if (i == 0) {
          com.tencent.mm.kernel.g.ajQ().gDv.a(new d((c)localObject2, (String)localObject1, str1, str2, str3, str4), 0);
        }
        break;
      }
    }
    Object localObject3 = new k(((c)localObject2).field_fileFullPath);
    if ((((c)localObject2).field_status == 199L) && (!((k)localObject3).exists()))
    {
      ae.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist but file not!");
      z(parambv.field_msgId, parambv.field_content);
    }
    long l1 = ((c)localObject2).systemRowid;
    long l2 = ((c)localObject2).field_totalLen;
    localObject4 = ((c)localObject2).field_fileFullPath;
    long l3 = ((c)localObject2).field_type;
    String str6 = ((c)localObject2).field_mediaId;
    long l4 = ((c)localObject2).field_msgInfoId;
    boolean bool1 = ((c)localObject2).field_isUpload;
    boolean bool2 = ((k)localObject3).exists();
    long l5 = ((c)localObject2).field_status;
    if (((c)localObject2).field_signature == null) {}
    for (int i = -1;; i = ((c)localObject2).field_signature.length())
    {
      ae.i("MicroMsg.AppMsgLogic", "summerbig tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject4, Long.valueOf(l3), str6, Long.valueOf(l4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Long.valueOf(l5), Integer.valueOf(i) });
      i = j;
      break;
    }
  }
  
  public static c r(String paramString, long paramLong)
  {
    AppMethodBeat.i(9438);
    c localc2 = new c();
    c localc1;
    if (bu.isNullOrNil(paramString))
    {
      localc1 = null;
      paramString = localc1;
      if (localc1 == null) {
        paramString = com.tencent.mm.plugin.s.a.bJV().CZ(paramLong);
      }
      if (paramString == null) {
        break label329;
      }
      ae.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo info[%s], rowid[%d], isUpload[%b], fullpath[%s], totallen[%d], offset[%d], mediaSvrId[%s], mediaid[%s], msgid[%d], type[%d], stack[%s]", new Object[] { paramString, Long.valueOf(paramString.systemRowid), Boolean.valueOf(paramString.field_isUpload), paramString.field_fileFullPath, Long.valueOf(paramString.field_totalLen), Long.valueOf(paramString.field_offset), paramString.field_mediaSvrId, paramString.field_mediaId, Long.valueOf(paramString.field_msgInfoId), Long.valueOf(paramString.field_type), bu.fpN() });
    }
    for (;;)
    {
      AppMethodBeat.o(9438);
      return paramString;
      ae.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s", new Object[] { paramString });
      long l = bu.getLong(paramString, -1L);
      if (l != -1L)
      {
        com.tencent.mm.plugin.s.a.bJV().get(l, localc2);
        localc1 = localc2;
        if (localc2.systemRowid != l)
        {
          localc2 = com.tencent.mm.plugin.s.a.bJV().aMZ(paramString);
          if (localc2 != null)
          {
            localc1 = localc2;
            if (localc2.field_mediaSvrId.equals(paramString)) {}
          }
          else
          {
            ae.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 1");
            localc1 = null;
          }
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.AppMsgLogic", "getAppAttachInfoByAttachId %s id %s", new Object[] { paramString, Long.valueOf(l) });
        break;
        localc2 = com.tencent.mm.plugin.s.a.bJV().aMZ(paramString);
        if (localc2 != null)
        {
          localc1 = localc2;
          if (localc2.field_mediaSvrId.equals(paramString)) {}
        }
        else
        {
          ae.i("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfoByAttachId set appAttachInfo null 2");
          localc1 = null;
        }
      }
      label329:
      ae.w("MicroMsg.AppMsgLogic", "summerbig getAppAttachInfo is null stack[%s]", new Object[] { bu.fpN() });
    }
  }
  
  private static String z(long paramLong, String paramString)
  {
    AppMethodBeat.i(9444);
    ae.i("MicroMsg.AppMsgLogic", "summerbig initDownloadAttach msgLocalId[%d], msgXml[%s], downloadPath[%s]", new Object[] { Long.valueOf(paramLong), paramString, null });
    paramString = k.b.zb(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(9444);
      return null;
    }
    String str = aq(com.tencent.mm.loader.j.b.asm(), paramString.title, paramString.hCD);
    if ((bu.isNullOrNil(paramString.dlu)) && (!bu.isNullOrNil(paramString.hCR))) {
      paramString.dlu = paramString.hCR.hashCode();
    }
    paramString = a(str, paramLong, paramString.sdkVer, paramString.appId, paramString.dlu, paramString.hCC, paramString.type, paramString.hCG);
    AppMethodBeat.o(9444);
    return paramString;
  }
  
  public static void zc(long paramLong)
  {
    AppMethodBeat.i(9439);
    com.tencent.mm.plugin.s.a.bJV().CY(paramLong);
    c localc = new c();
    com.tencent.mm.plugin.s.a.bJV().get(paramLong, localc);
    if (localc.field_msgInfoId <= 0L)
    {
      AppMethodBeat.o(9439);
      return;
    }
    bv localbv = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(localc.field_msgInfoId);
    if (localbv.field_msgId != localc.field_msgInfoId)
    {
      AppMethodBeat.o(9439);
      return;
    }
    localbv.setStatus(5);
    ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().a(localbv.field_msgId, localbv);
    AppMethodBeat.o(9439);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.h.a.be;
import com.tencent.mm.pluginsdk.g.a.b.c;
import com.tencent.mm.pluginsdk.g.a.c.d;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$3
  implements d
{
  b$3(b paramb) {}
  
  public final void SD(String paramString)
  {
    q localq = q.a.clL();
    if (localq.gaO) {}
    for (boolean bool = localq.rXO.isDownloading(paramString);; bool = false)
    {
      if (!bool) {
        i.Wh(paramString);
      }
      return;
    }
  }
  
  public final void a(String paramString, m paramm)
  {
    y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = " + paramString);
    paramm = q.a.clL().Wl(paramString);
    if (paramm == null) {
      return;
    }
    j.s(paramm.field_reportId, 10L);
    j.s(paramm.field_reportId, 15L);
    if (((!paramm.field_fileCompress) || (paramm.field_fileEncrypt)) && (paramm.field_fileUpdated)) {
      if (paramm.field_maxRetryTimes <= paramm.field_retryTimes) {
        break label242;
      }
    }
    label242:
    for (paramString = j.a.rWT;; paramString = j.a.rWR)
    {
      j.a(paramm.field_resType, paramm.field_subType, paramm.field_url, bk.getInt(paramm.field_fileVersion, 0), paramString, true, bk.pm(paramm.field_groupId2).equals("NewXml"), false, paramm.field_sampleId);
      if ((paramm.field_fileCompress) || (paramm.field_fileEncrypt)) {
        break;
      }
      paramString = new be();
      paramString.bHu.filePath = paramm.field_filePath;
      paramString.bHu.bHx = paramm.field_fileUpdated;
      paramString.bHu.bHw = bk.getInt(paramm.field_fileVersion, 0);
      paramString.bHu.bHv = paramm.field_resType;
      paramString.bHu.brC = paramm.field_subType;
      com.tencent.mm.sdk.b.a.udP.a(paramString, q.a.clL().handler.getLooper());
      paramm.field_fileUpdated = false;
      q.a.clL().g(paramm);
      return;
    }
    y.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
    this.rWi.b(paramm);
  }
  
  public final String acb()
  {
    return "CheckResUpdate";
  }
  
  public final void b(String paramString, m paramm)
  {
    i.Wh(paramString);
    paramString = q.a.clL().Wl(paramString);
    if (paramString == null) {
      return;
    }
    int j = 1;
    int i = j;
    if (paramm != null)
    {
      i = j;
      if (paramm.rXE != null)
      {
        if (!(paramm.rXE instanceof com.tencent.mm.pluginsdk.g.a.b.a)) {
          break label126;
        }
        j.s(paramString.field_reportId, 7L);
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0) {
        j.s(paramString.field_reportId, 11L);
      }
      j.s(paramString.field_reportId, 44L);
      j.a(paramString.field_resType, paramString.field_subType, paramString.field_url, bk.getInt(paramString.field_fileVersion, 0), j.a.rWS, false, "NewXml".equalsIgnoreCase(paramString.field_groupId2), false, paramString.field_sampleId);
      return;
      label126:
      i = j;
      if ((paramm.rXE instanceof c))
      {
        j.s(paramString.field_reportId, 16L);
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.3
 * JD-Core Version:    0.7.0.1
 */
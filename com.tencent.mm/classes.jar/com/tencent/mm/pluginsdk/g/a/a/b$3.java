package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.pluginsdk.g.a.b.c;
import com.tencent.mm.pluginsdk.g.a.c.d;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class b$3
  implements d
{
  b$3(b paramb) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(79470);
    i.alI(paramString);
    paramString = q.a.dmz().alQ(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(79470);
      return;
    }
    int j = 1;
    int i = j;
    if (paramm != null)
    {
      i = j;
      if (paramm.vOv != null)
      {
        if (!(paramm.vOv instanceof com.tencent.mm.pluginsdk.g.a.b.a)) {
          break label141;
        }
        j.B(paramString.field_reportId, 7L);
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0) {
        j.B(paramString.field_reportId, 11L);
      }
      j.B(paramString.field_reportId, 44L);
      j.a(paramString.field_resType, paramString.field_subType, paramString.field_url, bo.getInt(paramString.field_fileVersion, 0), j.a.vNK, false, "NewXml".equalsIgnoreCase(paramString.field_groupId2), false, paramString.field_sampleId);
      AppMethodBeat.o(79470);
      return;
      label141:
      i = j;
      if ((paramm.vOv instanceof c))
      {
        j.B(paramString.field_reportId, 16L);
        i = 0;
      }
    }
  }
  
  public final void alE(String paramString)
  {
    AppMethodBeat.i(151622);
    ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = ".concat(String.valueOf(paramString)));
    s locals = q.a.dmz().alQ(paramString);
    if (locals == null)
    {
      AppMethodBeat.o(151622);
      return;
    }
    j.B(locals.field_reportId, 10L);
    j.B(locals.field_reportId, 15L);
    if (((!locals.field_fileCompress) || (locals.field_fileEncrypt)) && (locals.field_fileUpdated)) {
      if (locals.field_maxRetryTimes <= locals.field_retryTimes) {
        break label261;
      }
    }
    label261:
    for (paramString = j.a.vNL;; paramString = j.a.vNJ)
    {
      j.a(locals.field_resType, locals.field_subType, locals.field_url, bo.getInt(locals.field_fileVersion, 0), paramString, true, bo.nullAsNil(locals.field_groupId2).equals("NewXml"), false, locals.field_sampleId);
      if ((locals.field_fileCompress) || (locals.field_fileEncrypt)) {
        break;
      }
      paramString = new bg();
      paramString.coI.filePath = locals.field_filePath;
      paramString.coI.coM = locals.field_originalMd5;
      paramString.coI.coL = locals.field_fileUpdated;
      paramString.coI.coK = bo.getInt(locals.field_fileVersion, 0);
      paramString.coI.coJ = locals.field_resType;
      paramString.coI.subType = locals.field_subType;
      com.tencent.mm.sdk.b.a.ymk.a(paramString, q.a.dmz().handler.getLooper());
      locals.field_fileUpdated = false;
      q.a.dmz().h(locals);
      AppMethodBeat.o(151622);
      return;
    }
    ab.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
    this.vMZ.b(locals);
    AppMethodBeat.o(151622);
  }
  
  public final void alF(String paramString)
  {
    AppMethodBeat.i(79471);
    q localq = q.a.dmz();
    if (localq.hsO) {}
    for (boolean bool = localq.vOF.alM(paramString);; bool = false)
    {
      if (!bool) {
        i.alI(paramString);
      }
      AppMethodBeat.o(79471);
      return;
    }
  }
  
  public final String avS()
  {
    return "CheckResUpdate";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.b.3
 * JD-Core Version:    0.7.0.1
 */
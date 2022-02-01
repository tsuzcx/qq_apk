package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.qo;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.ae;
import com.tencent.mm.modelvideo.ae.a;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/report/VideoDownloadReporter;", "", "()V", "reportVideoDownload", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "fileName", "", "isRawVideo", "", "downloadSize", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d aeJp;
  
  static
  {
    AppMethodBeat.i(253984);
    aeJp = new d();
    AppMethodBeat.o(253984);
  }
  
  public static void a(cc paramcc, String paramString, boolean paramBoolean, long paramLong)
  {
    int j = 1;
    AppMethodBeat.i(253979);
    if (paramcc == null)
    {
      AppMethodBeat.o(253979);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(253979);
      return;
    }
    z localz = com.tencent.mm.modelvideo.ab.Qo(paramString);
    if (localz == null)
    {
      AppMethodBeat.o(253979);
      return;
    }
    paramString = ae.pbN;
    ae localae = ae.a.Qv(localz.bOu());
    qo localqo = new qo();
    long l;
    if (localae != null)
    {
      localqo.jti = localae.nVD;
      if (paramBoolean)
      {
        paramString = localae.pbQ;
        localqo.jth = localqo.F("FildID", paramString, true);
        if (!paramBoolean) {
          break label268;
        }
        l = localae.pbT;
        label119:
        localqo.iIE = l;
        if (!com.tencent.mm.platformtools.ab.isNullOrNil(localae.pbQ)) {
          break label279;
        }
        i = 0;
        label140:
        localqo.jtf = i;
      }
    }
    else
    {
      boolean bool = au.bwG(paramcc.field_talker);
      localqo.imN = localqo.F("ChatName", ((n)h.ax(n.class)).bzA().JE(paramcc.field_talker).aSV(), true);
      if (!bool) {
        break label285;
      }
      i = 1;
      label202:
      localqo.imM = i;
      if (bool) {
        localqo.jtj = v.getMembersCountByChatRoomName(paramcc.field_talker);
      }
      if (!paramBoolean) {
        break label291;
      }
    }
    label268:
    label279:
    label285:
    label291:
    for (int i = j;; i = 0)
    {
      localqo.jtg = i;
      localqo.jag = paramLong;
      localqo.bMH();
      AppMethodBeat.o(253979);
      return;
      paramString = localae.pbR;
      break;
      l = localz.osy;
      break label119;
      i = 1;
      break label140;
      i = 0;
      break label202;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.d
 * JD-Core Version:    0.7.0.1
 */
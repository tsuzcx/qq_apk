package com.tencent.mm.ui.conversation.fold;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.by;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xwalk.core.Log;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/conversation/fold/ConvBoxContactAssemblerImpl;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IContactSyncCallback;", "()V", "afterContactUpdate", "", "newContact", "Lcom/tencent/mm/storage/Contact;", "oldContact", "cmdMC", "Lcom/tencent/mm/protocal/protobuf/ModContact;", "cmdBuf", "", "isInit", "", "assemble", "beforeContactDel", "Lcom/tencent/mm/protocal/protobuf/DelContact;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements f
{
  public static final a.a afub;
  
  static
  {
    AppMethodBeat.i(256861);
    afub = new a.a((byte)0);
    AppMethodBeat.o(256861);
  }
  
  public final void a(au paramau, aid paramaid)
  {
    Object localObject = null;
    AppMethodBeat.i(256865);
    if (paramau == null)
    {
      paramaid = null;
      Log.i("MicroMsg.ConvBoxContactAssemblerImpl", s.X("del contact, talker: ", paramaid));
      if (paramau != null) {
        break label81;
      }
      paramau = localObject;
    }
    for (;;)
    {
      if (v.Iv(paramau))
      {
        if (((n)h.ax(n.class)).cJv() == 0)
        {
          bh.bCz();
          c.bzG().bxK("conversationboxservice");
          AppMethodBeat.o(256865);
          return;
          paramaid = paramau.field_username;
          break;
          label81:
          paramau = paramau.field_username;
          continue;
        }
        ((n)h.ax(n.class)).cJu();
      }
    }
    AppMethodBeat.o(256865);
  }
  
  public final void a(au paramau1, au paramau2, dph paramdph, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public final void b(au paramau1, au paramau2, dph paramdph, byte[] paramArrayOfByte, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.fold.a
 * JD-Core Version:    0.7.0.1
 */
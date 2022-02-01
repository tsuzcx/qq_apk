package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

final class FacingCreateChatRoomAllInOneUI$7
  implements Runnable
{
  FacingCreateChatRoomAllInOneUI$7(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(27628);
    if (FacingCreateChatRoomAllInOneUI.s(this.uIU) != null) {
      FacingCreateChatRoomAllInOneUI.s(this.uIU).clear();
    }
    if (FacingCreateChatRoomAllInOneUI.t(this.uIU) != null) {
      FacingCreateChatRoomAllInOneUI.t(this.uIU).clear();
    }
    Object localObject;
    if ((this.uIV != null) && (this.uIV.size() > 0))
    {
      j = this.uIV.size();
      i = 0;
      while (i < j)
      {
        localObject = (aft)this.uIV.get(i);
        if (!bt.isNullOrNil(((aft)localObject).DfI)) {
          FacingCreateChatRoomAllInOneUI.t(this.uIU).put(((aft)localObject).DfI, localObject);
        }
        i += 1;
      }
    }
    int j = FacingCreateChatRoomAllInOneUI.c(this.uIU).size();
    int i = 0;
    if (i < j)
    {
      localObject = (aft)FacingCreateChatRoomAllInOneUI.c(this.uIU).get(i);
      if (!FacingCreateChatRoomAllInOneUI.t(this.uIU).containsKey(((aft)localObject).DfI)) {
        ad.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[] { ((aft)localObject).DfI });
      }
      for (;;)
      {
        i += 1;
        break;
        FacingCreateChatRoomAllInOneUI.t(this.uIU).remove(((aft)localObject).DfI);
      }
    }
    if ((FacingCreateChatRoomAllInOneUI.t(this.uIU) != null) && (FacingCreateChatRoomAllInOneUI.t(this.uIU).size() > 0))
    {
      localObject = FacingCreateChatRoomAllInOneUI.t(this.uIU).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        aft localaft = (aft)((Map.Entry)((Iterator)localObject).next()).getValue();
        FacingCreateChatRoomAllInOneUI.s(this.uIU).add(localaft);
        ad.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[] { localaft.DfI });
      }
    }
    FacingCreateChatRoomAllInOneUI.c(this.uIU).addAll(FacingCreateChatRoomAllInOneUI.s(this.uIU));
    FacingCreateChatRoomAllInOneUI.u(this.uIU).sendEmptyMessage(10001);
    AppMethodBeat.o(27628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.7
 * JD-Core Version:    0.7.0.1
 */
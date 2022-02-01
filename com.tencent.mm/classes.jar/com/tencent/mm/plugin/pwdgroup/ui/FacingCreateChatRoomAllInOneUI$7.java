package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
    if (FacingCreateChatRoomAllInOneUI.s(this.xoM) != null) {
      FacingCreateChatRoomAllInOneUI.s(this.xoM).clear();
    }
    if (FacingCreateChatRoomAllInOneUI.t(this.xoM) != null) {
      FacingCreateChatRoomAllInOneUI.t(this.xoM).clear();
    }
    Object localObject;
    if ((this.xoN != null) && (this.xoN.size() > 0))
    {
      j = this.xoN.size();
      i = 0;
      while (i < j)
      {
        localObject = (ajs)this.xoN.get(i);
        if (!bu.isNullOrNil(((ajs)localObject).Gzj)) {
          FacingCreateChatRoomAllInOneUI.t(this.xoM).put(((ajs)localObject).Gzj, localObject);
        }
        i += 1;
      }
    }
    int j = FacingCreateChatRoomAllInOneUI.c(this.xoM).size();
    int i = 0;
    if (i < j)
    {
      localObject = (ajs)FacingCreateChatRoomAllInOneUI.c(this.xoM).get(i);
      if (!FacingCreateChatRoomAllInOneUI.t(this.xoM).containsKey(((ajs)localObject).Gzj)) {
        ae.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[] { ((ajs)localObject).Gzj });
      }
      for (;;)
      {
        i += 1;
        break;
        FacingCreateChatRoomAllInOneUI.t(this.xoM).remove(((ajs)localObject).Gzj);
      }
    }
    if ((FacingCreateChatRoomAllInOneUI.t(this.xoM) != null) && (FacingCreateChatRoomAllInOneUI.t(this.xoM).size() > 0))
    {
      localObject = FacingCreateChatRoomAllInOneUI.t(this.xoM).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ajs localajs = (ajs)((Map.Entry)((Iterator)localObject).next()).getValue();
        FacingCreateChatRoomAllInOneUI.s(this.xoM).add(localajs);
        ae.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[] { localajs.Gzj });
      }
    }
    FacingCreateChatRoomAllInOneUI.c(this.xoM).addAll(FacingCreateChatRoomAllInOneUI.s(this.xoM));
    FacingCreateChatRoomAllInOneUI.u(this.xoM).sendEmptyMessage(10001);
    AppMethodBeat.o(27628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.7
 * JD-Core Version:    0.7.0.1
 */
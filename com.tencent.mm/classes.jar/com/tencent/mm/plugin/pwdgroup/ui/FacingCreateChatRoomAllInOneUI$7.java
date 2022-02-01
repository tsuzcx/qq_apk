package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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
    if (FacingCreateChatRoomAllInOneUI.s(this.vRL) != null) {
      FacingCreateChatRoomAllInOneUI.s(this.vRL).clear();
    }
    if (FacingCreateChatRoomAllInOneUI.t(this.vRL) != null) {
      FacingCreateChatRoomAllInOneUI.t(this.vRL).clear();
    }
    Object localObject;
    if ((this.vRM != null) && (this.vRM.size() > 0))
    {
      j = this.vRM.size();
      i = 0;
      while (i < j)
      {
        localObject = (ags)this.vRM.get(i);
        if (!bs.isNullOrNil(((ags)localObject).EyO)) {
          FacingCreateChatRoomAllInOneUI.t(this.vRL).put(((ags)localObject).EyO, localObject);
        }
        i += 1;
      }
    }
    int j = FacingCreateChatRoomAllInOneUI.c(this.vRL).size();
    int i = 0;
    if (i < j)
    {
      localObject = (ags)FacingCreateChatRoomAllInOneUI.c(this.vRL).get(i);
      if (!FacingCreateChatRoomAllInOneUI.t(this.vRL).containsKey(((ags)localObject).EyO)) {
        ac.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[] { ((ags)localObject).EyO });
      }
      for (;;)
      {
        i += 1;
        break;
        FacingCreateChatRoomAllInOneUI.t(this.vRL).remove(((ags)localObject).EyO);
      }
    }
    if ((FacingCreateChatRoomAllInOneUI.t(this.vRL) != null) && (FacingCreateChatRoomAllInOneUI.t(this.vRL).size() > 0))
    {
      localObject = FacingCreateChatRoomAllInOneUI.t(this.vRL).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ags localags = (ags)((Map.Entry)((Iterator)localObject).next()).getValue();
        FacingCreateChatRoomAllInOneUI.s(this.vRL).add(localags);
        ac.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[] { localags.EyO });
      }
    }
    FacingCreateChatRoomAllInOneUI.c(this.vRL).addAll(FacingCreateChatRoomAllInOneUI.s(this.vRL));
    FacingCreateChatRoomAllInOneUI.u(this.vRL).sendEmptyMessage(10001);
    AppMethodBeat.o(27628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.7
 * JD-Core Version:    0.7.0.1
 */
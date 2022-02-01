package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

final class FacingCreateChatRoomAllInOneUI$8
  implements Runnable
{
  FacingCreateChatRoomAllInOneUI$8(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(284584);
    if (FacingCreateChatRoomAllInOneUI.s(this.Nhe) != null) {
      FacingCreateChatRoomAllInOneUI.s(this.Nhe).clear();
    }
    if (FacingCreateChatRoomAllInOneUI.t(this.Nhe) != null) {
      FacingCreateChatRoomAllInOneUI.t(this.Nhe).clear();
    }
    Object localObject;
    if ((this.Nhf != null) && (this.Nhf.size() > 0))
    {
      j = this.Nhf.size();
      i = 0;
      while (i < j)
      {
        localObject = (ara)this.Nhf.get(i);
        if (!Util.isNullOrNil(((ara)localObject).Zyp)) {
          FacingCreateChatRoomAllInOneUI.t(this.Nhe).put(((ara)localObject).Zyp, localObject);
        }
        i += 1;
      }
    }
    int j = FacingCreateChatRoomAllInOneUI.c(this.Nhe).size();
    int i = 0;
    if (i < j)
    {
      localObject = (ara)FacingCreateChatRoomAllInOneUI.c(this.Nhe).get(i);
      if (!FacingCreateChatRoomAllInOneUI.t(this.Nhe).containsKey(((ara)localObject).Zyp)) {
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[] { ((ara)localObject).Zyp });
      }
      for (;;)
      {
        i += 1;
        break;
        FacingCreateChatRoomAllInOneUI.t(this.Nhe).remove(((ara)localObject).Zyp);
      }
    }
    if ((FacingCreateChatRoomAllInOneUI.t(this.Nhe) != null) && (FacingCreateChatRoomAllInOneUI.t(this.Nhe).size() > 0))
    {
      localObject = FacingCreateChatRoomAllInOneUI.t(this.Nhe).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ara localara = (ara)((Map.Entry)((Iterator)localObject).next()).getValue();
        FacingCreateChatRoomAllInOneUI.s(this.Nhe).add(localara);
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[] { localara.Zyp });
      }
    }
    FacingCreateChatRoomAllInOneUI.c(this.Nhe).addAll(FacingCreateChatRoomAllInOneUI.s(this.Nhe));
    FacingCreateChatRoomAllInOneUI.u(this.Nhe).sendEmptyMessage(10001);
    AppMethodBeat.o(284584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.8
 * JD-Core Version:    0.7.0.1
 */
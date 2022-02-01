package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
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
    if (FacingCreateChatRoomAllInOneUI.s(this.Hjr) != null) {
      FacingCreateChatRoomAllInOneUI.s(this.Hjr).clear();
    }
    if (FacingCreateChatRoomAllInOneUI.t(this.Hjr) != null) {
      FacingCreateChatRoomAllInOneUI.t(this.Hjr).clear();
    }
    Object localObject;
    if ((this.Hjs != null) && (this.Hjs.size() > 0))
    {
      j = this.Hjs.size();
      i = 0;
      while (i < j)
      {
        localObject = (anh)this.Hjs.get(i);
        if (!Util.isNullOrNil(((anh)localObject).Sxx)) {
          FacingCreateChatRoomAllInOneUI.t(this.Hjr).put(((anh)localObject).Sxx, localObject);
        }
        i += 1;
      }
    }
    int j = FacingCreateChatRoomAllInOneUI.c(this.Hjr).size();
    int i = 0;
    if (i < j)
    {
      localObject = (anh)FacingCreateChatRoomAllInOneUI.c(this.Hjr).get(i);
      if (!FacingCreateChatRoomAllInOneUI.t(this.Hjr).containsKey(((anh)localObject).Sxx)) {
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[] { ((anh)localObject).Sxx });
      }
      for (;;)
      {
        i += 1;
        break;
        FacingCreateChatRoomAllInOneUI.t(this.Hjr).remove(((anh)localObject).Sxx);
      }
    }
    if ((FacingCreateChatRoomAllInOneUI.t(this.Hjr) != null) && (FacingCreateChatRoomAllInOneUI.t(this.Hjr).size() > 0))
    {
      localObject = FacingCreateChatRoomAllInOneUI.t(this.Hjr).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        anh localanh = (anh)((Map.Entry)((Iterator)localObject).next()).getValue();
        FacingCreateChatRoomAllInOneUI.s(this.Hjr).add(localanh);
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[] { localanh.Sxx });
      }
    }
    FacingCreateChatRoomAllInOneUI.c(this.Hjr).addAll(FacingCreateChatRoomAllInOneUI.s(this.Hjr));
    FacingCreateChatRoomAllInOneUI.u(this.Hjr).sendEmptyMessage(10001);
    AppMethodBeat.o(27628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.7
 * JD-Core Version:    0.7.0.1
 */
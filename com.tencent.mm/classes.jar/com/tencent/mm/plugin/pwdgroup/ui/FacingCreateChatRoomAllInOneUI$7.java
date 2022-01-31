package com.tencent.mm.plugin.pwdgroup.ui;

import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
    if (FacingCreateChatRoomAllInOneUI.q(this.nbo) != null) {
      FacingCreateChatRoomAllInOneUI.q(this.nbo).clear();
    }
    if (FacingCreateChatRoomAllInOneUI.r(this.nbo) != null) {
      FacingCreateChatRoomAllInOneUI.r(this.nbo).clear();
    }
    Object localObject;
    if ((this.nbp != null) && (this.nbp.size() > 0))
    {
      j = this.nbp.size();
      i = 0;
      while (i < j)
      {
        localObject = (xr)this.nbp.get(i);
        if (!bk.bl(((xr)localObject).sUr)) {
          FacingCreateChatRoomAllInOneUI.r(this.nbo).put(((xr)localObject).sUr, localObject);
        }
        i += 1;
      }
    }
    int j = FacingCreateChatRoomAllInOneUI.c(this.nbo).size();
    int i = 0;
    if (i < j)
    {
      localObject = (xr)FacingCreateChatRoomAllInOneUI.c(this.nbo).get(i);
      if (!FacingCreateChatRoomAllInOneUI.r(this.nbo).containsKey(((xr)localObject).sUr)) {
        y.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", new Object[] { ((xr)localObject).sUr });
      }
      for (;;)
      {
        i += 1;
        break;
        FacingCreateChatRoomAllInOneUI.r(this.nbo).remove(((xr)localObject).sUr);
      }
    }
    if ((FacingCreateChatRoomAllInOneUI.r(this.nbo) != null) && (FacingCreateChatRoomAllInOneUI.r(this.nbo).size() > 0))
    {
      localObject = FacingCreateChatRoomAllInOneUI.r(this.nbo).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        xr localxr = (xr)((Map.Entry)((Iterator)localObject).next()).getValue();
        FacingCreateChatRoomAllInOneUI.q(this.nbo).add(localxr);
        y.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", new Object[] { localxr.sUr });
      }
    }
    FacingCreateChatRoomAllInOneUI.c(this.nbo).addAll(FacingCreateChatRoomAllInOneUI.q(this.nbo));
    FacingCreateChatRoomAllInOneUI.s(this.nbo).sendEmptyMessage(10001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.7
 * JD-Core Version:    0.7.0.1
 */
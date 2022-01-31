package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ah.m;
import com.tencent.mm.as.d.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.HashSet;

final class j$6$3
  implements d.a
{
  j$6$3(j.6 param6, bi parambi, HashSet paramHashSet) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    y.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav download image taskcancel: msgID:%d", new Object[] { Long.valueOf(this.dUy.field_msgId) });
    this.vmk.remove(Long.valueOf(this.dUy.field_msgId));
    j.6.a(this.vpw, this.vmk);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    if ((paramInt3 == 0) && (paramInt4 == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav taskEnd image succed: %s, msgID:%d, errType: %s, errCode:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.dUy.field_msgId), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      this.vmk.remove(Long.valueOf(this.dUy.field_msgId));
      j.6.a(this.vpw, this.vmk);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.6.3
 * JD-Core Version:    0.7.0.1
 */
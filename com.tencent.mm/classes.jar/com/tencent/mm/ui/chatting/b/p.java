package com.tencent.mm.ui.chatting.b;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.k;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.b.b.y;
import com.tencent.mm.ui.x;

@com.tencent.mm.ui.chatting.b.a.a(cFA=m.class)
public class p
  extends a
  implements m
{
  private long[] vjF = null;
  private boolean vqc = false;
  private com.tencent.mm.ui.chatting.p vqd = null;
  
  public final boolean cEp()
  {
    return this.vqc;
  }
  
  public final void cyM()
  {
    this.vqc = this.byx.vtz.getBooleanExtra("expose_edit_mode", false).booleanValue();
    this.vjF = this.byx.vtz.getArguments().getLongArray("expose_selected_ids");
  }
  
  public final void cyN()
  {
    if ((this.vqc) && (this.vqd == null)) {
      this.vqd = new com.tencent.mm.ui.chatting.p(this.byx, this.vjF);
    }
  }
  
  public final void cyO()
  {
    super.cyO();
    if (this.vqd != null)
    {
      com.tencent.mm.ui.chatting.p localp = this.vqd;
      Object localObject = (g)localp.byx.ac(g.class);
      ((y)localp.byx.ac(y.class)).cFg();
      ((g)localObject).cDr();
      ((g)localObject).cDm();
      if (localp.vjF != null)
      {
        long[] arrayOfLong = localp.vjF;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          ((g)localObject).hQ(arrayOfLong[i]);
          i += 1;
        }
      }
      localObject = ((n)localp.byx.ac(n.class)).cEq();
      if (localObject != null) {
        ((ChatFooter)localObject).setVisibility(8);
      }
      localObject = ((n)localp.byx.ac(n.class)).cEr();
      if (localObject != null) {
        ((ChatFooterCustom)localObject).setVisibility(8);
      }
      ((k)localp.byx.ac(k.class)).cEn();
      localp.byx.XM();
      ((ai)localp.byx.ac(ai.class)).cFy();
      localp.byx.np(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.p
 * JD-Core Version:    0.7.0.1
 */
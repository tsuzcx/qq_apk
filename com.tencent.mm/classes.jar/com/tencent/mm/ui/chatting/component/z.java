package com.tencent.mm.ui.chatting.component;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.component.api.au;
import com.tencent.mm.ui.chatting.component.api.bf;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.s;
import com.tencent.mm.ui.chatting.component.api.v;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.r;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=v.class)
public class z
  extends a
  implements v
{
  private long[] aehD = null;
  private boolean aerW = false;
  private r aerX = null;
  
  public final void jjf()
  {
    AppMethodBeat.i(35297);
    this.aerW = this.hlc.aezO.getBooleanExtra("expose_edit_mode", false).booleanValue();
    this.aehD = this.hlc.aezO.getArguments().getLongArray("expose_selected_ids");
    AppMethodBeat.o(35297);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35298);
    if ((this.aerW) && (this.aerX == null)) {
      this.aerX = new r(this.hlc, this.aehD);
    }
    AppMethodBeat.o(35298);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35299);
    super.jjh();
    if (this.aerX != null)
    {
      r localr = this.aerX;
      Object localObject = (m)localr.hlc.cm(m.class);
      ((au)localr.hlc.cm(au.class)).jtv();
      ((m)localObject).jqs();
      ((m)localObject).jql();
      if (localr.aehD != null)
      {
        long[] arrayOfLong = localr.aehD;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          ((m)localObject).zK(arrayOfLong[i]);
          i += 1;
        }
      }
      localObject = ((x)localr.hlc.cm(x.class)).jsd();
      if (localObject != null) {
        ((ChatFooter)localObject).setVisibility(8);
      }
      localObject = ((x)localr.hlc.cm(x.class)).jse();
      if (localObject != null) {
        ((ChatFooterCustom)localObject).setVisibility(8);
      }
      ((s)localr.hlc.cm(s.class)).jrX();
      localr.hlc.hideVKB();
      ((bf)localr.hlc.cm(bf.class)).juu();
      localr.hlc.Mg(true);
    }
    AppMethodBeat.o(35299);
  }
  
  public final boolean jsc()
  {
    return this.aerW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.z
 * JD-Core Version:    0.7.0.1
 */
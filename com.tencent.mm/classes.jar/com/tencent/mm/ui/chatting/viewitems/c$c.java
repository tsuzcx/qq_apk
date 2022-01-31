package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.widget.textview.a.f;

public final class c$c
  implements View.OnLongClickListener
{
  private PopupWindow.OnDismissListener VG;
  private int jUm;
  private int jUn;
  private View.OnCreateContextMenuListener pUz;
  com.tencent.mm.ui.widget.c.a zCx;
  private c.c.a zRG;
  private View zRH;
  a.f zRm;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public c$c(c paramc, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(32795);
    this.VG = new c.c.3(this);
    this.zzP = parama;
    this.pUz = new c.c.1(this, paramc);
    this.zRG = new c.c.a(this);
    AppMethodBeat.o(32795);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(32796);
    ab.i("MicroMsg.ChattingItem", "onLongClick");
    if ((paramView.getTag(2131820681) instanceof int[]))
    {
      int[] arrayOfInt = (int[])paramView.getTag(2131820681);
      t(paramView, arrayOfInt[0], arrayOfInt[1]);
    }
    for (;;)
    {
      AppMethodBeat.o(32796);
      return true;
      if (((this.jUm == 0) && (this.jUn == 0)) || (!this.zRH.equals(paramView))) {
        paramView.setOnTouchListener(new c.c.2(this));
      } else {
        t(paramView, this.jUm, this.jUn);
      }
    }
  }
  
  final void t(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32797);
    az localaz = (az)paramView.getTag();
    if (localaz == null)
    {
      ab.w("MicroMsg.ChattingItem", "open menu but tag is null");
      AppMethodBeat.o(32797);
      return;
    }
    this.zRG.cmQ = localaz.cEE;
    if (this.zCx != null)
    {
      this.zCx.dGj();
      this.zCx = null;
    }
    this.zCx = new com.tencent.mm.ui.widget.c.a(this.zzP.zJz.getContext());
    Object localObject = paramView.getTag(2131820672);
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      if (!a.a.dDt().dDs()) {
        break label204;
      }
      this.zCx.AII = true;
    }
    for (this.zCx.AxS = this.VG;; this.zCx.AxS = null)
    {
      this.zCx.AIJ = true;
      if (((localaz instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localaz).kwo) && (this.zRm != null)) {
        this.zRm.dismiss();
      }
      this.zCx.a(paramView, this.pUz, this.zRG, paramInt1, paramInt2);
      AppMethodBeat.o(32797);
      return;
      label204:
      this.zCx.AII = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.c
 * JD-Core Version:    0.7.0.1
 */
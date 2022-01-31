package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class l
  extends a
{
  private WXRTEditText vDY;
  
  public l(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(27178);
    this.vDY = ((WXRTEditText)paramView.findViewById(2131826607));
    if ((paramk.vzL != 2) || (!this.vBM.vzM))
    {
      this.vDY.setKeyListener(null);
      this.vDY.setFocusable(false);
      this.vDY.setClickable(true);
    }
    this.vDY.vyV = this;
    this.vDY.setEditTextType(0);
    this.vBM.q(this.vDY);
    this.vDY.getViewTreeObserver().addOnGlobalLayoutListener(new l.1(this));
    AppMethodBeat.o(27178);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27179);
    this.vDY.setPosInDataList(paramInt1);
    paramc = (i)paramc;
    paramc.vxb = this.vDY;
    paramc.vwZ = null;
    paramc.vxa = null;
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.vDY.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.vDY.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.vDY.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.vDY.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((this.vBM.vzL != 2) || (!this.vBM.vzM))
    {
      this.vDY.setRichTextEditing(paramc.content);
      j.l(this.vDY);
    }
    for (;;)
    {
      ab.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + jM());
      AppMethodBeat.o(27179);
      return;
      al.d(new l.2(this, paramc));
    }
  }
  
  public final int djX()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.l
 * JD-Core Version:    0.7.0.1
 */
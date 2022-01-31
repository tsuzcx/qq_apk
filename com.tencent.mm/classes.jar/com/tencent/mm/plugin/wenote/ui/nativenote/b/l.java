package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class l
  extends a
{
  private WXRTEditText rNu;
  
  public l(View paramView, k paramk)
  {
    super(paramView, paramk);
    this.rNu = ((WXRTEditText)paramView.findViewById(R.h.rte_text));
    if ((paramk.rJg != 2) || (!this.rLi.rJh))
    {
      this.rNu.setKeyListener(null);
      this.rNu.setFocusable(false);
      this.rNu.setClickable(true);
    }
    this.rNu.rIp = this;
    this.rNu.setEditTextType(0);
    this.rLi.o(this.rNu);
    this.rNu.getViewTreeObserver().addOnGlobalLayoutListener(new l.1(this));
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.a.c paramc, int paramInt1, int paramInt2)
  {
    this.rNu.setPosInDataList(paramInt1);
    paramc = (i)paramc;
    paramc.rGs = this.rNu;
    paramc.rGq = null;
    paramc.rGr = null;
    Object localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(paramInt1 - 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.rNu.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.rNu.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.chX().Dq(paramInt1 + 1);
    if ((localObject != null) && (((com.tencent.mm.plugin.wenote.model.a.c)localObject).getType() == 1))
    {
      localObject = (LinearLayout.LayoutParams)this.rNu.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = 0;
      this.rNu.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if ((this.rLi.rJg != 2) || (!this.rLi.rJh))
    {
      this.rNu.setRichTextEditing(paramc.content);
      j.h(this.rNu);
    }
    for (;;)
    {
      y.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + ic());
      return;
      ai.d(new l.2(this, paramc));
    }
  }
  
  public final int cjv()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.l
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.ui.base.h;

final class b$1
  implements DialogInterface.OnClickListener
{
  b$1(b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    g.a(new b.1.1(this, h.b(this.noB.context, this.noB.context.getString(a.g.readerapp_delete_news_ing), false, null)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.b.1
 * JD-Core Version:    0.7.0.1
 */
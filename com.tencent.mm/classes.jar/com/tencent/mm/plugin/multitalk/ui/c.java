package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.u;
import java.util.LinkedList;

public final class c
  extends u
{
  private String chatroomName;
  private Cursor pKb;
  private String[] pKc;
  private String query;
  
  public c(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(114711);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((b)h.ax(b.class)).bzK().Jy(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.pKc = Util.listToStrings(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(114711);
  }
  
  public final void a(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(114712);
    Log.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    if ((!Util.isNullOrNil(this.query)) && (this.pKc != null)) {
      this.pKb = ((n)h.ax(n.class)).bzA().a(this.pKc, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    eo(paramString, true);
    AppMethodBeat.o(114712);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(114714);
    super.finish();
    if (this.pKb != null)
    {
      this.pKb.close();
      this.pKb = null;
    }
    AppMethodBeat.o(114714);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(114715);
    if (this.pKb == null)
    {
      AppMethodBeat.o(114715);
      return 0;
    }
    int i = this.pKb.getCount();
    AppMethodBeat.o(114715);
    return i;
  }
  
  public final a yk(int paramInt)
  {
    AppMethodBeat.i(114713);
    e locale = null;
    if (this.pKb.moveToPosition(paramInt))
    {
      au localau = new au();
      localau.convertFrom(this.pKb);
      locale = new e(paramInt);
      locale.contact = localau;
      locale.afey = gZe();
      locale.query = this.query;
    }
    AppMethodBeat.o(114713);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.c
 * JD-Core Version:    0.7.0.1
 */
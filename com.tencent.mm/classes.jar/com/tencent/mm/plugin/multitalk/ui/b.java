package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;

public final class b
  extends s
{
  private String chatroomName;
  private Cursor iYC;
  private String[] iYD;
  private String query;
  
  public b(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(114711);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)g.ab(c.class)).azP().BB(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.iYD = bu.hs(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(114711);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(114712);
    ae.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    if ((!bu.isNullOrNil(this.query)) && (this.iYD != null)) {
      this.iYC = ((l)g.ab(l.class)).azF().a(this.iYD, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    cX(paramString, true);
    AppMethodBeat.o(114712);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(114714);
    super.finish();
    if (this.iYC != null)
    {
      this.iYC.close();
      this.iYC = null;
    }
    AppMethodBeat.o(114714);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(114715);
    if (this.iYC == null)
    {
      AppMethodBeat.o(114715);
      return 0;
    }
    int i = this.iYC.getCount();
    AppMethodBeat.o(114715);
    return i;
  }
  
  public final a rk(int paramInt)
  {
    AppMethodBeat.i(114713);
    e locale = null;
    if (this.iYC.moveToPosition(paramInt))
    {
      an localan = new an();
      localan.convertFrom(this.iYC);
      locale = new e(paramInt);
      locale.contact = localan;
      locale.KJj = dUh();
      locale.query = this.query;
    }
    AppMethodBeat.o(114713);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.b
 * JD-Core Version:    0.7.0.1
 */
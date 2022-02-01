package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;

public final class b
  extends s
{
  private String chatroomName;
  private Cursor iVJ;
  private String[] iVK;
  private String query;
  
  public b(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(114711);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)g.ab(c.class)).azz().AR(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.iVK = bt.hi(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(114711);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(114712);
    ad.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    if ((!bt.isNullOrNil(this.query)) && (this.iVK != null)) {
      this.iVJ = ((l)g.ab(l.class)).azp().a(this.iVK, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    cT(paramString, true);
    AppMethodBeat.o(114712);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(114714);
    super.finish();
    if (this.iVJ != null)
    {
      this.iVJ.close();
      this.iVJ = null;
    }
    AppMethodBeat.o(114714);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(114715);
    if (this.iVJ == null)
    {
      AppMethodBeat.o(114715);
      return 0;
    }
    int i = this.iVJ.getCount();
    AppMethodBeat.o(114715);
    return i;
  }
  
  public final a rh(int paramInt)
  {
    AppMethodBeat.i(114713);
    e locale = null;
    if (this.iVJ.moveToPosition(paramInt))
    {
      am localam = new am();
      localam.convertFrom(this.iVJ);
      locale = new e(paramInt);
      locale.contact = localam;
      locale.KmP = dQK();
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
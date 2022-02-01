package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;

public final class b
  extends s
{
  private String chatroomName;
  private String[] iCA;
  private Cursor iCz;
  private String query;
  
  public b(MMBaseSelectContactUI paramMMBaseSelectContactUI, String paramString)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(114711);
    this.chatroomName = paramString;
    paramMMBaseSelectContactUI = ((c)g.ab(c.class)).awK().xR(this.chatroomName);
    if (paramMMBaseSelectContactUI != null) {
      this.iCA = bs.gX(paramMMBaseSelectContactUI);
    }
    AppMethodBeat.o(114711);
  }
  
  public final void b(String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(114712);
    ac.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", new Object[] { paramString });
    clearCache();
    this.query = paramString;
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    if ((!bs.isNullOrNil(this.query)) && (this.iCA != null)) {
      this.iCz = ((k)g.ab(k.class)).awB().a(this.iCA, "@all.chatroom", this.query, new LinkedList(), null);
    }
    notifyDataSetChanged();
    cO(paramString, true);
    AppMethodBeat.o(114712);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(114714);
    super.finish();
    if (this.iCz != null)
    {
      this.iCz.close();
      this.iCz = null;
    }
    AppMethodBeat.o(114714);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(114715);
    if (this.iCz == null)
    {
      AppMethodBeat.o(114715);
      return 0;
    }
    int i = this.iCz.getCount();
    AppMethodBeat.o(114715);
    return i;
  }
  
  public final a qH(int paramInt)
  {
    AppMethodBeat.i(114713);
    e locale = null;
    if (this.iCz.moveToPosition(paramInt))
    {
      ai localai = new ai();
      localai.convertFrom(this.iCz);
      locale = new e(paramInt);
      locale.contact = localai;
      locale.Iwh = dFi();
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
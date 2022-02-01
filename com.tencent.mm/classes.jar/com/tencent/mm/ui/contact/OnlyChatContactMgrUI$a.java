package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.h;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

final class OnlyChatContactMgrUI$a
  extends q
{
  HashMap<String, Integer> PTD;
  private SparseArray<String> PTE;
  List<String> PXY;
  private Cursor jWh;
  String query;
  
  public OnlyChatContactMgrUI$a(OnlyChatContactMgrUI paramOnlyChatContactMgrUI, n paramn)
  {
    super(paramn, null, true, false);
    AppMethodBeat.i(180061);
    this.PTD = new HashMap();
    this.PTE = new SparseArray();
    this.query = "";
    this.PXY = new LinkedList();
    and();
    AppMethodBeat.o(180061);
  }
  
  private static a dn(int paramInt, String paramString)
  {
    AppMethodBeat.i(180065);
    h localh = new h(paramInt);
    localh.header = paramString;
    AppMethodBeat.o(180065);
    return localh;
  }
  
  public final void and()
  {
    AppMethodBeat.i(180062);
    super.and();
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    this.PTD.clear();
    this.PTE.clear();
    g.aAi();
    this.jWh = ((l)g.af(l.class)).aSN().d(null, this.query, "@social.black.android", "", this.gzY);
    String[] arrayOfString = ab.a(null, "@social.black.android", "", this.query, this.gzY);
    int[] arrayOfInt = ab.a(null, "@social.black.android", "", this.gzY, this.query);
    if ((arrayOfString != null) && (arrayOfInt != null))
    {
      int i = 0;
      int k;
      for (int j = 1; i < arrayOfString.length; j = k)
      {
        k = j;
        if (i < arrayOfInt.length)
        {
          this.PTD.put(arrayOfString[i], Integer.valueOf(arrayOfInt[i] + j));
          this.PTE.put(arrayOfInt[i] + j, arrayOfString[i]);
          k = j + 1;
        }
        i += 1;
      }
    }
    Log.i("MicroMsg.OnlyChatContactMgrUI", "datacount:%d headerPosMap=%s", new Object[] { Integer.valueOf(this.jWh.getCount()), this.PTD.toString() });
    clearCache();
    notifyDataSetChanged();
    AppMethodBeat.o(180062);
  }
  
  public final int bnr(String paramString)
  {
    AppMethodBeat.i(180063);
    if (this.PTD != null)
    {
      if (this.PTD.containsKey(paramString))
      {
        int i = ((Integer)this.PTD.get(paramString)).intValue();
        int j = this.PWg.getContentLV().getHeaderViewsCount();
        AppMethodBeat.o(180063);
        return i + j;
      }
      AppMethodBeat.o(180063);
      return -1;
    }
    AppMethodBeat.o(180063);
    return -1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(180067);
    super.finish();
    Log.i("MicroMsg.OnlyChatContactMgrUI", "finish!");
    if (this.jWh != null)
    {
      this.jWh.close();
      this.jWh = null;
    }
    AppMethodBeat.o(180067);
  }
  
  public final int getContactCount()
  {
    AppMethodBeat.i(180068);
    if (this.jWh != null)
    {
      int i = this.jWh.getCount();
      AppMethodBeat.o(180068);
      return i;
    }
    AppMethodBeat.o(180068);
    return 0;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(180066);
    int j = this.jWh.getCount();
    if (this.PTE == null) {}
    for (int i = 0;; i = this.PTE.size())
    {
      AppMethodBeat.o(180066);
      return i + j + 1;
    }
  }
  
  protected final a va(int paramInt)
  {
    AppMethodBeat.i(180064);
    Object localObject;
    if (paramInt == 0)
    {
      localObject = dn(paramInt, this.PXS.getString(2131755211));
      AppMethodBeat.o(180064);
      return localObject;
    }
    if (this.PTE.indexOfKey(paramInt) >= 0)
    {
      localObject = dn(paramInt, (String)this.PTE.get(paramInt));
      AppMethodBeat.o(180064);
      return localObject;
    }
    int k = paramInt;
    int i = 1;
    int j;
    int m;
    do
    {
      j = i;
      if (i > this.PTE.size()) {
        break;
      }
      j = i;
      if (this.PTE.indexOfKey(k) >= 0) {
        j = i + 1;
      }
      m = k - 1;
      k = m;
      i = j;
    } while (m >= 0);
    i = paramInt - j;
    if (this.jWh.moveToPosition(i))
    {
      Log.d("MicroMsg.OnlyChatContactMgrUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      localObject = new as();
      ((as)localObject).convertFrom(this.jWh);
      e locale = new e(paramInt);
      locale.contact = ((as)localObject);
      if (ab.Eq(((ax)localObject).field_username))
      {
        locale.PWh = false;
        locale.PWi = false;
        locale.Qaa = false;
      }
      for (locale.Qap = true;; locale.Qap = false)
      {
        AppMethodBeat.o(180064);
        return locale;
        locale.PWh = eWh();
        locale.PWi = this.PWi;
      }
    }
    Log.i("MicroMsg.OnlyChatContactMgrUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(180064);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OnlyChatContactMgrUI.a
 * JD-Core Version:    0.7.0.1
 */
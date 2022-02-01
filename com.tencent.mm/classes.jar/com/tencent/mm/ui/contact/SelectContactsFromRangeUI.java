package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.s.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SelectContactsFromRangeUI
  extends MMBaseSelectContactUI
  implements f
{
  private String KiP;
  private int Kjz;
  private a Kqh;
  private b Kqi;
  private String[] Kqj;
  
  public final void Zd()
  {
    AppMethodBeat.i(194620);
    super.Zd();
    this.Kjz = getIntent().getIntExtra("list_type", 0);
    this.KiP = getIntent().getStringExtra("filter_type");
    this.Kqj = getIntent().getStringArrayExtra("already_select_contact");
    this.Kqh = new a(this, getIntent().getIntExtra("max_limit_num", 30));
    this.Kqh.KmP = true;
    this.Kqi = new b(this, this.Kqh);
    AppMethodBeat.o(194620);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(194625);
    if ((parama instanceof e))
    {
      boolean bool = a.a(this.Kqh).contains(((e)parama).username);
      AppMethodBeat.o(194625);
      return bool;
    }
    AppMethodBeat.o(194625);
    return false;
  }
  
  protected final boolean aRu()
  {
    return false;
  }
  
  protected final boolean aRv()
  {
    return true;
  }
  
  protected final String aRw()
  {
    AppMethodBeat.i(194622);
    String str = getString(2131755234);
    AppMethodBeat.o(194622);
    return str;
  }
  
  protected final q aRx()
  {
    return this.Kqh;
  }
  
  protected final o aRy()
  {
    return this.Kqi;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(194624);
    if ((parama instanceof e))
    {
      if ((this.Kjz != 16) && (parama.contact.adp()))
      {
        AppMethodBeat.o(194624);
        return true;
      }
      AppMethodBeat.o(194624);
      return false;
    }
    AppMethodBeat.o(194624);
    return false;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(194619);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(194606);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(194606);
        return false;
      }
    });
    String str = getString(2131755835);
    MenuItem.OnMenuItemClickListener local2 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(194607);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Contact", bt.m(SelectContactsFromRangeUI.a.a(SelectContactsFromRangeUI.a(SelectContactsFromRangeUI.this)), ","));
        SelectContactsFromRangeUI.this.setResult(-1, paramAnonymousMenuItem);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(194607);
        return true;
      }
    };
    if (this.Kjz == 16) {}
    for (paramBundle = s.b.JbT;; paramBundle = s.b.JbS)
    {
      addTextOptionMenu(1, str, local2, null, paramBundle);
      enableOptionMenu(1, false);
      g.ajD();
      g.ajB().gAO.a(681, this);
      AppMethodBeat.o(194619);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(194621);
    g.ajD();
    g.ajB().gAO.b(681, this);
    this.Kqh.finish();
    super.onDestroy();
    AppMethodBeat.o(194621);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(194626);
    ad.i("MicroMsg.SelectContactsFromRangeUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    AppMethodBeat.o(194626);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(194623);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      ad.i("MicroMsg.SelectContactsFromRangeUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(194623);
      return;
    }
    Object localObject = fId().aen(i);
    if ((localObject == null) || (!(localObject instanceof e)))
    {
      AppMethodBeat.o(194623);
      return;
    }
    if ((this.Kjz != 16) && (((a)localObject).contact.adp()))
    {
      AppMethodBeat.o(194623);
      return;
    }
    localObject = ((a)localObject).contact.field_username;
    ad.i("MicroMsg.SelectContactsFromRangeUI", "ClickUser=%s", new Object[] { localObject });
    a locala = this.Kqh;
    if (locala.KoD.contains(localObject))
    {
      locala.KoD.remove(localObject);
      locala.notifyDataSetChanged();
      label163:
      if (a.a(this.Kqh).size() <= 0) {
        break label353;
      }
      updateOptionMenuText(1, getString(2131755835) + "(" + a.a(this.Kqh).size() + ")");
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      if ((fId() instanceof b))
      {
        fIk();
        hideVKB();
      }
      this.vIo.aMx((String)localObject);
      AppMethodBeat.o(194623);
      return;
      if (locala.KoD.size() >= locala.sUI)
      {
        com.tencent.mm.ui.base.h.d(locala.Kqk.getContext(), locala.Kqk.getString(2131755503, new Object[] { Integer.valueOf(locala.sUI) }), "", new SelectContactsFromRangeUI.a.1(locala));
        break label163;
      }
      locala.KoD.add(localObject);
      break;
      label353:
      updateOptionMenuText(1, getString(2131755835));
      enableOptionMenu(1, false);
    }
  }
  
  final class a
    extends q
  {
    private HashMap<String, Integer> Kkm;
    private SparseArray<String> Kkn;
    List<String> KoD;
    private Cursor iVJ;
    private String query;
    int sUI;
    
    public a(n paramn, int paramInt)
    {
      super(null, true, false);
      AppMethodBeat.i(194608);
      this.Kkm = new HashMap();
      this.Kkn = new SparseArray();
      this.query = "";
      this.KoD = new LinkedList();
      this.sUI = paramInt;
      Zh();
      AppMethodBeat.o(194608);
    }
    
    public final void Zh()
    {
      AppMethodBeat.i(194610);
      super.Zh();
      if (this.iVJ != null)
      {
        this.iVJ.close();
        this.iVJ = null;
      }
      this.Kkm.clear();
      this.Kkn.clear();
      if ((("@all.contact.android".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this))) || ("@all.contact.without.chatroom.without.openim".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this)))) && ((SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this) == null) || (SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this).length == 0)))
      {
        AppMethodBeat.o(194610);
        return;
      }
      g.ajD();
      this.iVJ = ((l)g.ab(l.class)).azp().d(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), this.query, SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.fSL);
      String[] arrayOfString = w.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.query, this.fSL);
      int[] arrayOfInt = w.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.fSL, this.query);
      int j;
      if ((arrayOfString != null) && (arrayOfInt != null))
      {
        j = 0;
        int i = 0;
        if (j < arrayOfString.length)
        {
          if (j >= arrayOfInt.length) {
            break label295;
          }
          this.Kkm.put(arrayOfString[j], Integer.valueOf(arrayOfInt[j] + i));
          this.Kkn.put(arrayOfInt[j] + i, arrayOfString[j]);
          i += 1;
        }
      }
      label295:
      for (;;)
      {
        j += 1;
        break;
        clearCache();
        notifyDataSetChanged();
        AppMethodBeat.o(194610);
        return;
      }
    }
    
    public final int aWM(String paramString)
    {
      AppMethodBeat.i(194611);
      if (this.Kkm != null)
      {
        if (this.Kkm.containsKey(paramString))
        {
          int i = ((Integer)this.Kkm.get(paramString)).intValue();
          int j = this.KmO.getContentLV().getHeaderViewsCount();
          AppMethodBeat.o(194611);
          return i + j;
        }
        AppMethodBeat.o(194611);
        return -1;
      }
      AppMethodBeat.o(194611);
      return -1;
    }
    
    public final void akK(String paramString)
    {
      AppMethodBeat.i(194609);
      if (!this.query.equalsIgnoreCase(paramString)) {
        this.query = paramString;
      }
      Zh();
      AppMethodBeat.o(194609);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(194614);
      super.finish();
      ad.i("MicroMsg.SelectContactsFromRangeUI", "finish!");
      if (this.iVJ != null)
      {
        this.iVJ.close();
        this.iVJ = null;
      }
      AppMethodBeat.o(194614);
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(194613);
      if (this.iVJ == null)
      {
        AppMethodBeat.o(194613);
        return 0;
      }
      int j = this.iVJ.getCount();
      if (this.Kkn == null) {}
      for (;;)
      {
        AppMethodBeat.o(194613);
        return i + j;
        i = this.Kkn.size();
      }
    }
    
    protected final a rh(int paramInt)
    {
      AppMethodBeat.i(194612);
      Object localObject1;
      Object localObject2;
      if (this.Kkn.indexOfKey(paramInt) >= 0)
      {
        localObject1 = (String)this.Kkn.get(paramInt);
        localObject2 = new com.tencent.mm.ui.contact.a.h(paramInt);
        ((com.tencent.mm.ui.contact.a.h)localObject2).header = ((String)localObject1);
        AppMethodBeat.o(194612);
        return localObject2;
      }
      int i = 0;
      int k = paramInt;
      int j;
      int m;
      do
      {
        j = i;
        if (i > this.Kkn.size()) {
          break;
        }
        j = i;
        if (this.Kkn.indexOfKey(k) >= 0) {
          j = i + 1;
        }
        m = k - 1;
        i = j;
        k = m;
      } while (m >= 0);
      i = paramInt - j;
      if (this.iVJ.moveToPosition(i))
      {
        ad.d("MicroMsg.SelectContactsFromRangeUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject1 = new am();
        ((am)localObject1).convertFrom(this.iVJ);
        localObject2 = new e(paramInt);
        ((a)localObject2).contact = ((am)localObject1);
        if (w.vF(((aw)localObject1).field_username))
        {
          ((a)localObject2).KmP = false;
          ((a)localObject2).KmQ = false;
          ((a)localObject2).KqG = false;
        }
        for (((e)localObject2).KqV = true;; ((e)localObject2).KqV = false)
        {
          AppMethodBeat.o(194612);
          return localObject2;
          ((a)localObject2).KmP = dQK();
          ((a)localObject2).KmQ = this.KmQ;
        }
      }
      ad.i("MicroMsg.SelectContactsFromRangeUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(194612);
      return null;
    }
  }
  
  final class b
    extends o
  {
    private SelectContactsFromRangeUI.a Kqm;
    
    public b(n paramn, SelectContactsFromRangeUI.a parama)
    {
      super(false, 0);
      this.Kqm = parama;
    }
    
    public final void b(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(194615);
      this.Kqm.akK(paramString);
      if (this.KmN != null) {
        this.KmN.y(paramString, getCount(), true);
      }
      AppMethodBeat.o(194615);
    }
    
    public final void clearData()
    {
      AppMethodBeat.i(194616);
      this.Kqm.akK("");
      AppMethodBeat.o(194616);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(194618);
      int i = this.Kqm.getCount();
      AppMethodBeat.o(194618);
      return i;
    }
    
    protected final a rh(int paramInt)
    {
      AppMethodBeat.i(194617);
      a locala = this.Kqm.rh(paramInt);
      AppMethodBeat.o(194617);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactsFromRangeUI
 * JD-Core Version:    0.7.0.1
 */
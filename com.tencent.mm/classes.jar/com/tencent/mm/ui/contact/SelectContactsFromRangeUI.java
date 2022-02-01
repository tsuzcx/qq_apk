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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.s.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SelectContactsFromRangeUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.ak.g
{
  private int IsT;
  private String Isk;
  private a Izb;
  private b Izc;
  private String[] Izd;
  
  public final void WJ()
  {
    AppMethodBeat.i(196776);
    super.WJ();
    this.IsT = getIntent().getIntExtra("list_type", 0);
    this.Isk = getIntent().getStringExtra("filter_type");
    this.Izd = getIntent().getStringArrayExtra("already_select_contact");
    this.Izb = new a(this, getIntent().getIntExtra("max_limit_num", 30));
    this.Izb.Iwh = true;
    this.Izc = new b(this, this.Izb);
    AppMethodBeat.o(196776);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(196781);
    if ((parama instanceof e))
    {
      boolean bool = a.a(this.Izb).contains(((e)parama).username);
      AppMethodBeat.o(196781);
      return bool;
    }
    AppMethodBeat.o(196781);
    return false;
  }
  
  protected final boolean aOi()
  {
    return false;
  }
  
  protected final boolean aOj()
  {
    return true;
  }
  
  protected final String aOk()
  {
    AppMethodBeat.i(196778);
    String str = getString(2131755234);
    AppMethodBeat.o(196778);
    return str;
  }
  
  protected final q aOl()
  {
    return this.Izb;
  }
  
  protected final o aOm()
  {
    return this.Izc;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(196780);
    if ((parama instanceof e))
    {
      if ((this.IsT != 16) && (parama.contact.aaM()))
      {
        AppMethodBeat.o(196780);
        return true;
      }
      AppMethodBeat.o(196780);
      return false;
    }
    AppMethodBeat.o(196780);
    return false;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(196775);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196762);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(196762);
        return false;
      }
    });
    String str = getString(2131755835);
    MenuItem.OnMenuItemClickListener local2 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196763);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Contact", bs.n(SelectContactsFromRangeUI.a.a(SelectContactsFromRangeUI.a(SelectContactsFromRangeUI.this)), ","));
        SelectContactsFromRangeUI.this.setResult(-1, paramAnonymousMenuItem);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(196763);
        return true;
      }
    };
    if (this.IsT == 16) {}
    for (paramBundle = s.b.Hon;; paramBundle = s.b.Hom)
    {
      addTextOptionMenu(1, str, local2, null, paramBundle);
      enableOptionMenu(1, false);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(681, this);
      AppMethodBeat.o(196775);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(196777);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(681, this);
    this.Izb.finish();
    super.onDestroy();
    AppMethodBeat.o(196777);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(196782);
    ac.i("MicroMsg.SelectContactsFromRangeUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    AppMethodBeat.o(196782);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(196779);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      ac.i("MicroMsg.SelectContactsFromRangeUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(196779);
      return;
    }
    Object localObject = frq().abQ(i);
    if ((localObject == null) || (!(localObject instanceof e)))
    {
      AppMethodBeat.o(196779);
      return;
    }
    if ((this.IsT != 16) && (((a)localObject).contact.aaM()))
    {
      AppMethodBeat.o(196779);
      return;
    }
    localObject = ((a)localObject).contact.field_username;
    ac.i("MicroMsg.SelectContactsFromRangeUI", "ClickUser=%s", new Object[] { localObject });
    a locala = this.Izb;
    if (locala.IxV.contains(localObject))
    {
      locala.IxV.remove(localObject);
      locala.notifyDataSetChanged();
      label163:
      if (a.a(this.Izb).size() <= 0) {
        break label353;
      }
      updateOptionMenuText(1, getString(2131755835) + "(" + a.a(this.Izb).size() + ")");
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      if ((frq() instanceof b))
      {
        frx();
        hideVKB();
      }
      this.uFo.aGU((String)localObject);
      AppMethodBeat.o(196779);
      return;
      if (locala.IxV.size() >= locala.rXO)
      {
        com.tencent.mm.ui.base.h.d(locala.Ize.getContext(), locala.Ize.getString(2131755503, new Object[] { Integer.valueOf(locala.rXO) }), "", new SelectContactsFromRangeUI.a.1(locala));
        break label163;
      }
      locala.IxV.add(localObject);
      break;
      label353:
      updateOptionMenuText(1, getString(2131755835));
      enableOptionMenu(1, false);
    }
  }
  
  final class a
    extends q
  {
    private HashMap<String, Integer> ItG;
    private SparseArray<String> ItH;
    List<String> IxV;
    private Cursor iCz;
    private String query;
    int rXO;
    
    public a(n paramn, int paramInt)
    {
      super(null, true, false);
      AppMethodBeat.i(196764);
      this.ItG = new HashMap();
      this.ItH = new SparseArray();
      this.query = "";
      this.IxV = new LinkedList();
      this.rXO = paramInt;
      WN();
      AppMethodBeat.o(196764);
    }
    
    public final void WN()
    {
      AppMethodBeat.i(196766);
      super.WN();
      if (this.iCz != null)
      {
        this.iCz.close();
        this.iCz = null;
      }
      this.ItG.clear();
      this.ItH.clear();
      if ((("@all.contact.android".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this))) || ("@all.contact.without.chatroom.without.openim".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this)))) && ((SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this) == null) || (SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this).length == 0)))
      {
        AppMethodBeat.o(196766);
        return;
      }
      com.tencent.mm.kernel.g.agS();
      this.iCz = ((k)com.tencent.mm.kernel.g.ab(k.class)).awB().d(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), this.query, SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.fzw);
      String[] arrayOfString = w.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.query, this.fzw);
      int[] arrayOfInt = w.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.fzw, this.query);
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
          this.ItG.put(arrayOfString[j], Integer.valueOf(arrayOfInt[j] + i));
          this.ItH.put(arrayOfInt[j] + i, arrayOfString[j]);
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
        AppMethodBeat.o(196766);
        return;
      }
    }
    
    public final int aQR(String paramString)
    {
      AppMethodBeat.i(196767);
      if (this.ItG != null)
      {
        if (this.ItG.containsKey(paramString))
        {
          int i = ((Integer)this.ItG.get(paramString)).intValue();
          int j = this.Iwg.getContentLV().getHeaderViewsCount();
          AppMethodBeat.o(196767);
          return i + j;
        }
        AppMethodBeat.o(196767);
        return -1;
      }
      AppMethodBeat.o(196767);
      return -1;
    }
    
    public final void agm(String paramString)
    {
      AppMethodBeat.i(196765);
      if (!this.query.equalsIgnoreCase(paramString)) {
        this.query = paramString;
      }
      WN();
      AppMethodBeat.o(196765);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(196770);
      super.finish();
      ac.i("MicroMsg.SelectContactsFromRangeUI", "finish!");
      if (this.iCz != null)
      {
        this.iCz.close();
        this.iCz = null;
      }
      AppMethodBeat.o(196770);
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(196769);
      if (this.iCz == null)
      {
        AppMethodBeat.o(196769);
        return 0;
      }
      int j = this.iCz.getCount();
      if (this.ItH == null) {}
      for (;;)
      {
        AppMethodBeat.o(196769);
        return i + j;
        i = this.ItH.size();
      }
    }
    
    protected final a qH(int paramInt)
    {
      AppMethodBeat.i(196768);
      Object localObject1;
      Object localObject2;
      if (this.ItH.indexOfKey(paramInt) >= 0)
      {
        localObject1 = (String)this.ItH.get(paramInt);
        localObject2 = new com.tencent.mm.ui.contact.a.h(paramInt);
        ((com.tencent.mm.ui.contact.a.h)localObject2).header = ((String)localObject1);
        AppMethodBeat.o(196768);
        return localObject2;
      }
      int i = 0;
      int k = paramInt;
      int j;
      int m;
      do
      {
        j = i;
        if (i > this.ItH.size()) {
          break;
        }
        j = i;
        if (this.ItH.indexOfKey(k) >= 0) {
          j = i + 1;
        }
        m = k - 1;
        i = j;
        k = m;
      } while (m >= 0);
      i = paramInt - j;
      if (this.iCz.moveToPosition(i))
      {
        ac.d("MicroMsg.SelectContactsFromRangeUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject1 = new ai();
        ((ai)localObject1).convertFrom(this.iCz);
        localObject2 = new e(paramInt);
        ((a)localObject2).contact = ((ai)localObject1);
        if (w.sQ(((av)localObject1).field_username))
        {
          ((a)localObject2).Iwh = false;
          ((a)localObject2).Iwi = false;
          ((a)localObject2).IzA = false;
        }
        for (((e)localObject2).IzP = true;; ((e)localObject2).IzP = false)
        {
          AppMethodBeat.o(196768);
          return localObject2;
          ((a)localObject2).Iwh = dFi();
          ((a)localObject2).Iwi = this.Iwi;
        }
      }
      ac.i("MicroMsg.SelectContactsFromRangeUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(196768);
      return null;
    }
  }
  
  final class b
    extends o
  {
    private SelectContactsFromRangeUI.a Izg;
    
    public b(n paramn, SelectContactsFromRangeUI.a parama)
    {
      super(false, 0);
      this.Izg = parama;
    }
    
    public final void b(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(196771);
      this.Izg.agm(paramString);
      if (this.Iwf != null) {
        this.Iwf.y(paramString, getCount(), true);
      }
      AppMethodBeat.o(196771);
    }
    
    public final void clearData()
    {
      AppMethodBeat.i(196772);
      this.Izg.agm("");
      AppMethodBeat.o(196772);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(196774);
      int i = this.Izg.getCount();
      AppMethodBeat.o(196774);
      return i;
    }
    
    protected final a qH(int paramInt)
    {
      AppMethodBeat.i(196773);
      a locala = this.Izg.qH(paramInt);
      AppMethodBeat.o(196773);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactsFromRangeUI
 * JD-Core Version:    0.7.0.1
 */
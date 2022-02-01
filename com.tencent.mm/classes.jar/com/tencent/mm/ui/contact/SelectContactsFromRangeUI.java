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
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.t.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SelectContactsFromRangeUI
  extends MMBaseSelectContactUI
  implements i
{
  private int PSP;
  private String PSf;
  private a PZB;
  private b PZC;
  private String[] PZD;
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(234086);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.SelectContactsFromRangeUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(234086);
      return;
    }
    paramView = gUP().anH(i);
    if ((paramView == null) || (!(paramView instanceof e)))
    {
      AppMethodBeat.o(234086);
      return;
    }
    if ((this.PSP != 16) && (paramView.contact.arD()))
    {
      AppMethodBeat.o(234086);
      return;
    }
    paramView = paramView.contact.field_username;
    Log.i("MicroMsg.SelectContactsFromRangeUI", "ClickUser=%s", new Object[] { paramView });
    a locala = this.PZB;
    if (locala.PXY.contains(paramView))
    {
      locala.PXY.remove(paramView);
      locala.notifyDataSetChanged();
      label161:
      if (a.a(this.PZB).size() <= 0) {
        break label347;
      }
      updateOptionMenuText(1, getString(2131755921) + "(" + a.a(this.PZB).size() + ")");
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      if ((gUP() instanceof b))
      {
        gUW();
        hideVKB();
      }
      this.zoy.bev(paramView);
      AppMethodBeat.o(234086);
      return;
      if (locala.PXY.size() >= locala.wnd)
      {
        com.tencent.mm.ui.base.h.d(locala.PZE.getContext(), locala.PZE.getString(2131755207, new Object[] { Integer.valueOf(locala.wnd) }), "", new SelectContactsFromRangeUI.a.1(locala));
        break label161;
      }
      locala.PXY.add(paramView);
      break;
      label347:
      updateOptionMenuText(1, getString(2131755921));
      enableOptionMenu(1, false);
    }
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(234088);
    if ((parama instanceof e))
    {
      boolean bool = a.a(this.PZB).contains(((e)parama).username);
      AppMethodBeat.o(234088);
      return bool;
    }
    AppMethodBeat.o(234088);
    return false;
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(234083);
    super.amZ();
    this.PSP = getIntent().getIntExtra("list_type", 0);
    this.PSf = getIntent().getStringExtra("filter_type");
    this.PZD = getIntent().getStringArrayExtra("already_select_contact");
    this.PZB = new a(this, getIntent().getIntExtra("max_limit_num", 30));
    this.PZB.PWh = true;
    this.PZC = new b(this, this.PZB);
    AppMethodBeat.o(234083);
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(234087);
    if ((parama instanceof e))
    {
      if ((this.PSP != 16) && (parama.contact.arD()))
      {
        AppMethodBeat.o(234087);
        return true;
      }
      AppMethodBeat.o(234087);
      return false;
    }
    AppMethodBeat.o(234087);
    return false;
  }
  
  protected final boolean bmA()
  {
    return true;
  }
  
  protected final String bmB()
  {
    AppMethodBeat.i(234085);
    String str = getString(2131755268);
    AppMethodBeat.o(234085);
    return str;
  }
  
  protected final q bmC()
  {
    return this.PZB;
  }
  
  protected final o bmD()
  {
    return this.PZC;
  }
  
  protected final boolean bmz()
  {
    return false;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(234082);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(234069);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(234069);
        return false;
      }
    });
    String str = getString(2131755921);
    MenuItem.OnMenuItemClickListener local2 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(234070);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Contact", Util.listToString(SelectContactsFromRangeUI.a.a(SelectContactsFromRangeUI.a(SelectContactsFromRangeUI.this)), ","));
        SelectContactsFromRangeUI.this.setResult(-1, paramAnonymousMenuItem);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(234070);
        return true;
      }
    };
    if (this.PSP == 16) {}
    for (paramBundle = t.b.OGV;; paramBundle = t.b.OGU)
    {
      addTextOptionMenu(1, str, local2, null, paramBundle);
      enableOptionMenu(1, false);
      g.aAi();
      g.aAg().hqi.a(681, this);
      AppMethodBeat.o(234082);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(234084);
    g.aAi();
    g.aAg().hqi.b(681, this);
    this.PZB.finish();
    super.onDestroy();
    AppMethodBeat.o(234084);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(234089);
    Log.i("MicroMsg.SelectContactsFromRangeUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramq.getType());
    AppMethodBeat.o(234089);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends q
  {
    private HashMap<String, Integer> PTD;
    private SparseArray<String> PTE;
    List<String> PXY;
    private Cursor jWh;
    private String query;
    int wnd;
    
    public a(n paramn, int paramInt)
    {
      super(null, true, false);
      AppMethodBeat.i(234071);
      this.PTD = new HashMap();
      this.PTE = new SparseArray();
      this.query = "";
      this.PXY = new LinkedList();
      this.wnd = paramInt;
      and();
      AppMethodBeat.o(234071);
    }
    
    public final void and()
    {
      AppMethodBeat.i(234073);
      super.and();
      if (this.jWh != null)
      {
        this.jWh.close();
        this.jWh = null;
      }
      this.PTD.clear();
      this.PTE.clear();
      if ((("@all.contact.android".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this))) || ("@all.contact.without.chatroom.without.openim".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this)))) && ((SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this) == null) || (SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this).length == 0)))
      {
        AppMethodBeat.o(234073);
        return;
      }
      g.aAi();
      this.jWh = ((l)g.af(l.class)).aSN().d(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), this.query, SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.gzY);
      String[] arrayOfString = ab.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.query, this.gzY);
      int[] arrayOfInt = ab.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.gzY, this.query);
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
          this.PTD.put(arrayOfString[j], Integer.valueOf(arrayOfInt[j] + i));
          this.PTE.put(arrayOfInt[j] + i, arrayOfString[j]);
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
        AppMethodBeat.o(234073);
        return;
      }
    }
    
    public final void ayM(String paramString)
    {
      AppMethodBeat.i(234072);
      if (!this.query.equalsIgnoreCase(paramString)) {
        this.query = paramString;
      }
      and();
      AppMethodBeat.o(234072);
    }
    
    public final int bnr(String paramString)
    {
      AppMethodBeat.i(234074);
      if (this.PTD != null)
      {
        if (this.PTD.containsKey(paramString))
        {
          int i = ((Integer)this.PTD.get(paramString)).intValue();
          int j = this.PWg.getContentLV().getHeaderViewsCount();
          AppMethodBeat.o(234074);
          return i + j;
        }
        AppMethodBeat.o(234074);
        return -1;
      }
      AppMethodBeat.o(234074);
      return -1;
    }
    
    public final void finish()
    {
      AppMethodBeat.i(234077);
      super.finish();
      Log.i("MicroMsg.SelectContactsFromRangeUI", "finish!");
      if (this.jWh != null)
      {
        this.jWh.close();
        this.jWh = null;
      }
      AppMethodBeat.o(234077);
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(234076);
      if (this.jWh == null)
      {
        AppMethodBeat.o(234076);
        return 0;
      }
      int j = this.jWh.getCount();
      if (this.PTE == null) {}
      for (;;)
      {
        AppMethodBeat.o(234076);
        return i + j;
        i = this.PTE.size();
      }
    }
    
    protected final a va(int paramInt)
    {
      AppMethodBeat.i(234075);
      Object localObject1;
      Object localObject2;
      if (this.PTE.indexOfKey(paramInt) >= 0)
      {
        localObject1 = (String)this.PTE.get(paramInt);
        localObject2 = new com.tencent.mm.ui.contact.a.h(paramInt);
        ((com.tencent.mm.ui.contact.a.h)localObject2).header = ((String)localObject1);
        AppMethodBeat.o(234075);
        return localObject2;
      }
      int i = 0;
      int k = paramInt;
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
        i = j;
        k = m;
      } while (m >= 0);
      i = paramInt - j;
      if (this.jWh.moveToPosition(i))
      {
        Log.d("MicroMsg.SelectContactsFromRangeUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject1 = new as();
        ((as)localObject1).convertFrom(this.jWh);
        localObject2 = new e(paramInt);
        ((a)localObject2).contact = ((as)localObject1);
        if (ab.Eq(((ax)localObject1).field_username))
        {
          ((a)localObject2).PWh = false;
          ((a)localObject2).PWi = false;
          ((a)localObject2).Qaa = false;
        }
        for (((e)localObject2).Qap = true;; ((e)localObject2).Qap = false)
        {
          AppMethodBeat.o(234075);
          return localObject2;
          ((a)localObject2).PWh = eWh();
          ((a)localObject2).PWi = this.PWi;
        }
      }
      Log.i("MicroMsg.SelectContactsFromRangeUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(234075);
      return null;
    }
  }
  
  final class b
    extends o
  {
    private SelectContactsFromRangeUI.a PZG;
    
    public b(n paramn, SelectContactsFromRangeUI.a parama)
    {
      super(false, 0);
      this.PZG = parama;
    }
    
    public final void b(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(234078);
      this.PZG.ayM(paramString);
      if (this.PWf != null) {
        this.PWf.B(paramString, getCount(), true);
      }
      AppMethodBeat.o(234078);
    }
    
    public final void clearData()
    {
      AppMethodBeat.i(234079);
      this.PZG.ayM("");
      AppMethodBeat.o(234079);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(234081);
      int i = this.PZG.getCount();
      AppMethodBeat.o(234081);
      return i;
    }
    
    protected final a va(int paramInt)
    {
      AppMethodBeat.i(234080);
      a locala = this.PZG.va(paramInt);
      AppMethodBeat.o(234080);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactsFromRangeUI
 * JD-Core Version:    0.7.0.1
 */
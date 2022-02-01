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
import com.tencent.mm.ak.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private int KFT;
  private String KFj;
  private a KMB;
  private b KMC;
  private String[] KMD;
  
  public final void Zm()
  {
    AppMethodBeat.i(188021);
    super.Zm();
    this.KFT = getIntent().getIntExtra("list_type", 0);
    this.KFj = getIntent().getStringExtra("filter_type");
    this.KMD = getIntent().getStringArrayExtra("already_select_contact");
    this.KMB = new a(this, getIntent().getIntExtra("max_limit_num", 30));
    this.KMB.KJj = true;
    this.KMC = new b(this, this.KMB);
    AppMethodBeat.o(188021);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(188026);
    if ((parama instanceof e))
    {
      boolean bool = a.a(this.KMB).contains(((e)parama).username);
      AppMethodBeat.o(188026);
      return bool;
    }
    AppMethodBeat.o(188026);
    return false;
  }
  
  protected final boolean aRT()
  {
    return false;
  }
  
  protected final boolean aRU()
  {
    return true;
  }
  
  protected final String aRV()
  {
    AppMethodBeat.i(188023);
    String str = getString(2131755234);
    AppMethodBeat.o(188023);
    return str;
  }
  
  protected final q aRW()
  {
    return this.KMB;
  }
  
  protected final o aRX()
  {
    return this.KMC;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(188025);
    if ((parama instanceof e))
    {
      if ((this.KFT != 16) && (parama.contact.adA()))
      {
        AppMethodBeat.o(188025);
        return true;
      }
      AppMethodBeat.o(188025);
      return false;
    }
    AppMethodBeat.o(188025);
    return false;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(188020);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(188007);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(188007);
        return false;
      }
    });
    String str = getString(2131755835);
    MenuItem.OnMenuItemClickListener local2 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(188008);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Contact", bu.m(SelectContactsFromRangeUI.a.a(SelectContactsFromRangeUI.a(SelectContactsFromRangeUI.this)), ","));
        SelectContactsFromRangeUI.this.setResult(-1, paramAnonymousMenuItem);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(188008);
        return true;
      }
    };
    if (this.KFT == 16) {}
    for (paramBundle = s.b.JwB;; paramBundle = s.b.JwA)
    {
      addTextOptionMenu(1, str, local2, null, paramBundle);
      enableOptionMenu(1, false);
      g.ajS();
      g.ajQ().gDv.a(681, this);
      AppMethodBeat.o(188020);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(188022);
    g.ajS();
    g.ajQ().gDv.b(681, this);
    this.KMB.finish();
    super.onDestroy();
    AppMethodBeat.o(188022);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(188027);
    ae.i("MicroMsg.SelectContactsFromRangeUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    AppMethodBeat.o(188027);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(188024);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      ae.i("MicroMsg.SelectContactsFromRangeUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(188024);
      return;
    }
    Object localObject = fMv().aeW(i);
    if ((localObject == null) || (!(localObject instanceof e)))
    {
      AppMethodBeat.o(188024);
      return;
    }
    if ((this.KFT != 16) && (((a)localObject).contact.adA()))
    {
      AppMethodBeat.o(188024);
      return;
    }
    localObject = ((a)localObject).contact.field_username;
    ae.i("MicroMsg.SelectContactsFromRangeUI", "ClickUser=%s", new Object[] { localObject });
    a locala = this.KMB;
    if (locala.KKX.contains(localObject))
    {
      locala.KKX.remove(localObject);
      locala.notifyDataSetChanged();
      label163:
      if (a.a(this.KMB).size() <= 0) {
        break label353;
      }
      updateOptionMenuText(1, getString(2131755835) + "(" + a.a(this.KMB).size() + ")");
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      if ((fMv() instanceof b))
      {
        fMC();
        hideVKB();
      }
      this.vUs.aNT((String)localObject);
      AppMethodBeat.o(188024);
      return;
      if (locala.KKX.size() >= locala.tfW)
      {
        com.tencent.mm.ui.base.h.d(locala.KME.getContext(), locala.KME.getString(2131755503, new Object[] { Integer.valueOf(locala.tfW) }), "", new SelectContactsFromRangeUI.a.1(locala));
        break label163;
      }
      locala.KKX.add(localObject);
      break;
      label353:
      updateOptionMenuText(1, getString(2131755835));
      enableOptionMenu(1, false);
    }
  }
  
  final class a
    extends q
  {
    private HashMap<String, Integer> KGG;
    private SparseArray<String> KGH;
    List<String> KKX;
    private Cursor iYC;
    private String query;
    int tfW;
    
    public a(n paramn, int paramInt)
    {
      super(null, true, false);
      AppMethodBeat.i(188009);
      this.KGG = new HashMap();
      this.KGH = new SparseArray();
      this.query = "";
      this.KKX = new LinkedList();
      this.tfW = paramInt;
      Zq();
      AppMethodBeat.o(188009);
    }
    
    public final void Zq()
    {
      AppMethodBeat.i(188011);
      super.Zq();
      if (this.iYC != null)
      {
        this.iYC.close();
        this.iYC = null;
      }
      this.KGG.clear();
      this.KGH.clear();
      if ((("@all.contact.android".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this))) || ("@all.contact.without.chatroom.without.openim".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this)))) && ((SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this) == null) || (SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this).length == 0)))
      {
        AppMethodBeat.o(188011);
        return;
      }
      g.ajS();
      this.iYC = ((l)g.ab(l.class)).azF().d(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), this.query, SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.fUR);
      String[] arrayOfString = x.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.query, this.fUR);
      int[] arrayOfInt = x.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.fUR, this.query);
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
          this.KGG.put(arrayOfString[j], Integer.valueOf(arrayOfInt[j] + i));
          this.KGH.put(arrayOfInt[j] + i, arrayOfString[j]);
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
        AppMethodBeat.o(188011);
        return;
      }
    }
    
    public final int aYn(String paramString)
    {
      AppMethodBeat.i(188012);
      if (this.KGG != null)
      {
        if (this.KGG.containsKey(paramString))
        {
          int i = ((Integer)this.KGG.get(paramString)).intValue();
          int j = this.KJi.getContentLV().getHeaderViewsCount();
          AppMethodBeat.o(188012);
          return i + j;
        }
        AppMethodBeat.o(188012);
        return -1;
      }
      AppMethodBeat.o(188012);
      return -1;
    }
    
    public final void alI(String paramString)
    {
      AppMethodBeat.i(188010);
      if (!this.query.equalsIgnoreCase(paramString)) {
        this.query = paramString;
      }
      Zq();
      AppMethodBeat.o(188010);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(188015);
      super.finish();
      ae.i("MicroMsg.SelectContactsFromRangeUI", "finish!");
      if (this.iYC != null)
      {
        this.iYC.close();
        this.iYC = null;
      }
      AppMethodBeat.o(188015);
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(188014);
      if (this.iYC == null)
      {
        AppMethodBeat.o(188014);
        return 0;
      }
      int j = this.iYC.getCount();
      if (this.KGH == null) {}
      for (;;)
      {
        AppMethodBeat.o(188014);
        return i + j;
        i = this.KGH.size();
      }
    }
    
    protected final a rk(int paramInt)
    {
      AppMethodBeat.i(188013);
      Object localObject1;
      Object localObject2;
      if (this.KGH.indexOfKey(paramInt) >= 0)
      {
        localObject1 = (String)this.KGH.get(paramInt);
        localObject2 = new com.tencent.mm.ui.contact.a.h(paramInt);
        ((com.tencent.mm.ui.contact.a.h)localObject2).header = ((String)localObject1);
        AppMethodBeat.o(188013);
        return localObject2;
      }
      int i = 0;
      int k = paramInt;
      int j;
      int m;
      do
      {
        j = i;
        if (i > this.KGH.size()) {
          break;
        }
        j = i;
        if (this.KGH.indexOfKey(k) >= 0) {
          j = i + 1;
        }
        m = k - 1;
        i = j;
        k = m;
      } while (m >= 0);
      i = paramInt - j;
      if (this.iYC.moveToPosition(i))
      {
        ae.d("MicroMsg.SelectContactsFromRangeUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject1 = new an();
        ((an)localObject1).convertFrom(this.iYC);
        localObject2 = new e(paramInt);
        ((a)localObject2).contact = ((an)localObject1);
        if (x.wb(((aw)localObject1).field_username))
        {
          ((a)localObject2).KJj = false;
          ((a)localObject2).KJk = false;
          ((a)localObject2).KNa = false;
        }
        for (((e)localObject2).KNp = true;; ((e)localObject2).KNp = false)
        {
          AppMethodBeat.o(188013);
          return localObject2;
          ((a)localObject2).KJj = dUh();
          ((a)localObject2).KJk = this.KJk;
        }
      }
      ae.i("MicroMsg.SelectContactsFromRangeUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(188013);
      return null;
    }
  }
  
  final class b
    extends o
  {
    private SelectContactsFromRangeUI.a KMG;
    
    public b(n paramn, SelectContactsFromRangeUI.a parama)
    {
      super(false, 0);
      this.KMG = parama;
    }
    
    public final void b(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(188016);
      this.KMG.alI(paramString);
      if (this.KJh != null) {
        this.KJh.y(paramString, getCount(), true);
      }
      AppMethodBeat.o(188016);
    }
    
    public final void clearData()
    {
      AppMethodBeat.i(188017);
      this.KMG.alI("");
      AppMethodBeat.o(188017);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(188019);
      int i = this.KMG.getCount();
      AppMethodBeat.o(188019);
      return i;
    }
    
    protected final a rk(int paramInt)
    {
      AppMethodBeat.i(188018);
      a locala = this.KMG.rk(paramInt);
      AppMethodBeat.o(188018);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactsFromRangeUI
 * JD-Core Version:    0.7.0.1
 */
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
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.y.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SelectContactsFromRangeUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.am.h
{
  private String afau;
  private int afbe;
  private b afiA;
  private String[] afiB;
  private a afiz;
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(252811);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.SelectContactsFromRangeUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(252811);
      return;
    }
    paramAdapterView = jyE().aDt(i);
    if ((paramAdapterView == null) || (!(paramAdapterView instanceof f)))
    {
      AppMethodBeat.o(252811);
      return;
    }
    if ((this.afbe != 16) && (paramAdapterView.contact.aSN()))
    {
      AppMethodBeat.o(252811);
      return;
    }
    paramAdapterView = paramAdapterView.contact.field_username;
    Log.i("MicroMsg.SelectContactsFromRangeUI", "ClickUser=%s", new Object[] { paramAdapterView });
    this.afiz.bCa(paramAdapterView);
    if (a.a(this.afiz).size() > 0)
    {
      updateOptionMenuText(1, getString(R.l.app_ok) + "(" + a.a(this.afiz).size() + ")");
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      if ((jyE() instanceof b))
      {
        iKA();
        hideVKB();
      }
      this.KOt.bqG(paramAdapterView);
      AppMethodBeat.o(252811);
      return;
      updateOptionMenuText(1, getString(R.l.app_ok));
      enableOptionMenu(1, false);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(252825);
    if ((parama instanceof f))
    {
      boolean bool = a.a(this.afiz).contains(((f)parama).username);
      AppMethodBeat.o(252825);
      return bool;
    }
    AppMethodBeat.o(252825);
    return false;
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(252784);
    super.aNi();
    this.afbe = getIntent().getIntExtra("list_type", 0);
    this.afau = getIntent().getStringExtra("filter_type");
    this.afiB = getIntent().getStringArrayExtra("already_select_contact");
    this.afiz = new a(this, getIntent().getIntExtra("max_limit_num", 30));
    this.afiz.afey = true;
    this.afiA = new b(this, this.afiz);
    AppMethodBeat.o(252784);
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(252821);
    if (paramInt == 1)
    {
      this.afiz.bCa(paramString);
      if (a.a(this.afiz).size() <= 0) {
        break label113;
      }
      updateOptionMenuText(1, getString(R.l.app_ok) + "(" + a.a(this.afiz).size() + ")");
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      if ((jyE() instanceof b))
      {
        iKA();
        hideVKB();
      }
      AppMethodBeat.o(252821);
      return;
      label113:
      updateOptionMenuText(1, getString(R.l.app_ok));
      enableOptionMenu(1, false);
    }
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(252817);
    if ((parama instanceof f))
    {
      if ((this.afbe != 16) && (parama.contact.aSN()))
      {
        AppMethodBeat.o(252817);
        return true;
      }
      AppMethodBeat.o(252817);
      return false;
    }
    AppMethodBeat.o(252817);
    return false;
  }
  
  protected final r bVA()
  {
    return this.afiz;
  }
  
  protected final p bVB()
  {
    return this.afiA;
  }
  
  protected final boolean bVx()
  {
    return false;
  }
  
  protected final boolean bVy()
  {
    return true;
  }
  
  protected final String bVz()
  {
    AppMethodBeat.i(252798);
    String str = getString(R.l.address_title_select_contact);
    AppMethodBeat.o(252798);
    return str;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252779);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(252836);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(252836);
        return false;
      }
    });
    String str = getString(R.l.app_ok);
    MenuItem.OnMenuItemClickListener local2 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(252828);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Contact", Util.listToString(SelectContactsFromRangeUI.a.a(SelectContactsFromRangeUI.a(SelectContactsFromRangeUI.this)), ","));
        SelectContactsFromRangeUI.this.setResult(-1, paramAnonymousMenuItem);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(252828);
        return true;
      }
    };
    if (this.afbe == 16) {}
    for (paramBundle = y.b.adEK;; paramBundle = y.b.adEJ)
    {
      addTextOptionMenu(1, str, local2, null, paramBundle);
      enableOptionMenu(1, false);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(681, this);
      AppMethodBeat.o(252779);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(252789);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(681, this);
    this.afiz.finish();
    super.onDestroy();
    AppMethodBeat.o(252789);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(252826);
    Log.i("MicroMsg.SelectContactsFromRangeUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramp.getType());
    AppMethodBeat.o(252826);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends r
  {
    private int GzH;
    private HashMap<String, Integer> JUK;
    private SparseArray<String> JUL;
    private List<String> JXy;
    private Cursor pKb;
    private String query;
    
    public a(o paramo, int paramInt)
    {
      super(com.tencent.mm.pluginsdk.platformtools.a.iIW(), true, false);
      AppMethodBeat.i(252877);
      this.JUK = new HashMap();
      this.JUL = new SparseArray();
      this.query = "";
      this.JXy = new LinkedList();
      this.GzH = paramInt;
      aNm();
      AppMethodBeat.o(252877);
    }
    
    public final void aEJ(String paramString)
    {
      AppMethodBeat.i(252885);
      if (!this.query.equalsIgnoreCase(paramString)) {
        this.query = paramString;
      }
      aNm();
      AppMethodBeat.o(252885);
    }
    
    public final int aJM(String paramString)
    {
      AppMethodBeat.i(252908);
      if (this.JUK != null)
      {
        if (this.JUK.containsKey(paramString))
        {
          int i = ((Integer)this.JUK.get(paramString)).intValue();
          int j = this.afex.getContentLV().getHeaderViewsCount();
          AppMethodBeat.o(252908);
          return i + j;
        }
        AppMethodBeat.o(252908);
        return -1;
      }
      AppMethodBeat.o(252908);
      return -1;
    }
    
    public final void aNm()
    {
      AppMethodBeat.i(252902);
      super.aNm();
      if (this.pKb != null)
      {
        this.pKb.close();
        this.pKb = null;
      }
      this.JUK.clear();
      this.JUL.clear();
      if ((("@all.contact.android".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this))) || ("@all.contact.without.chatroom.without.openim".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this)))) && ((SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this) == null) || (SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this).length == 0)))
      {
        AppMethodBeat.o(252902);
        return;
      }
      com.tencent.mm.kernel.h.baF();
      this.pKb = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), this.query, SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", cVa());
      String[] arrayOfString = ab.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.query, cVa());
      int[] arrayOfInt = ab.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", cVa(), this.query);
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
          this.JUK.put(arrayOfString[j], Integer.valueOf(arrayOfInt[j] + i));
          this.JUL.put(arrayOfInt[j] + i, arrayOfString[j]);
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
        AppMethodBeat.o(252902);
        return;
      }
    }
    
    public final void bCa(String paramString)
    {
      AppMethodBeat.i(252892);
      if (this.JXy.contains(paramString)) {
        this.JXy.remove(paramString);
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(252892);
        return;
        if (this.JXy.size() >= this.GzH)
        {
          k.d(SelectContactsFromRangeUI.this.getContext(), SelectContactsFromRangeUI.this.getString(R.l.gqi, new Object[] { Integer.valueOf(this.GzH) }), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(252892);
          return;
        }
        this.JXy.add(paramString);
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(252923);
      super.finish();
      Log.i("MicroMsg.SelectContactsFromRangeUI", "finish!");
      if (this.pKb != null)
      {
        this.pKb.close();
        this.pKb = null;
      }
      AppMethodBeat.o(252923);
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(252920);
      if (this.pKb == null)
      {
        AppMethodBeat.o(252920);
        return 0;
      }
      int j = this.pKb.getCount();
      if (this.JUL == null) {}
      for (;;)
      {
        AppMethodBeat.o(252920);
        return i + j;
        i = this.JUL.size();
      }
    }
    
    protected final com.tencent.mm.ui.contact.a.a yk(int paramInt)
    {
      AppMethodBeat.i(252917);
      Object localObject1;
      Object localObject2;
      if (this.JUL.indexOfKey(paramInt) >= 0)
      {
        localObject1 = (String)this.JUL.get(paramInt);
        localObject2 = new j(paramInt);
        ((j)localObject2).header = ((String)localObject1);
        AppMethodBeat.o(252917);
        return localObject2;
      }
      int i = 0;
      int k = paramInt;
      int j;
      int m;
      do
      {
        j = i;
        if (i > this.JUL.size()) {
          break;
        }
        j = i;
        if (this.JUL.indexOfKey(k) >= 0) {
          j = i + 1;
        }
        m = k - 1;
        i = j;
        k = m;
      } while (m >= 0);
      i = paramInt - j;
      if (this.pKb.moveToPosition(i))
      {
        Log.d("MicroMsg.SelectContactsFromRangeUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject1 = new au();
        ((au)localObject1).convertFrom(this.pKb);
        localObject2 = new f(paramInt);
        ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((au)localObject1);
        if (au.bwE(((az)localObject1).field_username))
        {
          ((com.tencent.mm.ui.contact.a.a)localObject2).afey = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).afez = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).afjA = false;
        }
        for (((f)localObject2).afjT = true;; ((f)localObject2).afjT = false)
        {
          AppMethodBeat.o(252917);
          return localObject2;
          ((com.tencent.mm.ui.contact.a.a)localObject2).afey = gZe();
          ((com.tencent.mm.ui.contact.a.a)localObject2).afez = jyD();
        }
      }
      Log.i("MicroMsg.SelectContactsFromRangeUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(252917);
      return null;
    }
  }
  
  final class b
    extends p
  {
    private SelectContactsFromRangeUI.a afiE;
    
    public b(o paramo, SelectContactsFromRangeUI.a parama)
    {
      super(false, 0);
      this.afiE = parama;
    }
    
    public final void a(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(252878);
      this.afiE.aEJ(paramString);
      if (this.afew != null) {
        this.afew.h(paramString, getCount(), true);
      }
      AppMethodBeat.o(252878);
    }
    
    public final void clearData()
    {
      AppMethodBeat.i(252881);
      this.afiE.aEJ("");
      AppMethodBeat.o(252881);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(252890);
      int i = this.afiE.getCount();
      AppMethodBeat.o(252890);
      return i;
    }
    
    protected final com.tencent.mm.ui.contact.a.a yk(int paramInt)
    {
      AppMethodBeat.i(252886);
      com.tencent.mm.ui.contact.a.a locala = this.afiE.yk(paramInt);
      AppMethodBeat.o(252886);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactsFromRangeUI
 * JD-Core Version:    0.7.0.1
 */
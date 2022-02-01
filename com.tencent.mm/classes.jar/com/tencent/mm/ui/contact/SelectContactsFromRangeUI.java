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
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.w.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SelectContactsFromRangeUI
  extends MMBaseSelectContactUI
  implements i
{
  private String XoS;
  private int XpC;
  private String[] XwA;
  private a Xwy;
  private b Xwz;
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(287438);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.SelectContactsFromRangeUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(287438);
      return;
    }
    paramView = hUP().awM(i);
    if ((paramView == null) || (!(paramView instanceof f)))
    {
      AppMethodBeat.o(287438);
      return;
    }
    if ((this.XpC != 16) && (paramView.contact.ayk()))
    {
      AppMethodBeat.o(287438);
      return;
    }
    paramView = paramView.contact.field_username;
    Log.i("MicroMsg.SelectContactsFromRangeUI", "ClickUser=%s", new Object[] { paramView });
    this.Xwy.bAh(paramView);
    if (a.a(this.Xwy).size() > 0)
    {
      updateOptionMenuText(1, getString(R.l.app_ok) + "(" + a.a(this.Xwy).size() + ")");
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      if ((hUP() instanceof b))
      {
        hUZ();
        hideVKB();
      }
      this.ETP.bqR(paramView);
      AppMethodBeat.o(287438);
      return;
      updateOptionMenuText(1, getString(R.l.app_ok));
      enableOptionMenu(1, false);
    }
  }
  
  public final void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(287440);
    if (paramInt == 1)
    {
      this.Xwy.bAh(paramString);
      if (a.a(this.Xwy).size() <= 0) {
        break label113;
      }
      updateOptionMenuText(1, getString(R.l.app_ok) + "(" + a.a(this.Xwy).size() + ")");
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      if ((hUP() instanceof b))
      {
        hUZ();
        hideVKB();
      }
      AppMethodBeat.o(287440);
      return;
      label113:
      updateOptionMenuText(1, getString(R.l.app_ok));
      enableOptionMenu(1, false);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(287441);
    if ((parama instanceof f))
    {
      boolean bool = a.a(this.Xwy).contains(((f)parama).username);
      AppMethodBeat.o(287441);
      return bool;
    }
    AppMethodBeat.o(287441);
    return false;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(287434);
    super.ata();
    this.XpC = getIntent().getIntExtra("list_type", 0);
    this.XoS = getIntent().getStringExtra("filter_type");
    this.XwA = getIntent().getStringArrayExtra("already_select_contact");
    this.Xwy = new a(this, getIntent().getIntExtra("max_limit_num", 30));
    this.Xwy.XsX = true;
    this.Xwz = new b(this, this.Xwy);
    AppMethodBeat.o(287434);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(287439);
    if ((parama instanceof f))
    {
      if ((this.XpC != 16) && (parama.contact.ayk()))
      {
        AppMethodBeat.o(287439);
        return true;
      }
      AppMethodBeat.o(287439);
      return false;
    }
    AppMethodBeat.o(287439);
    return false;
  }
  
  protected final boolean bwH()
  {
    return false;
  }
  
  protected final boolean bwI()
  {
    return true;
  }
  
  protected final String bwJ()
  {
    AppMethodBeat.i(287436);
    String str = getString(R.l.address_title_select_contact);
    AppMethodBeat.o(287436);
    return str;
  }
  
  protected final r bwK()
  {
    return this.Xwy;
  }
  
  protected final p bwL()
  {
    return this.Xwz;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287432);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(268571);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(268571);
        return false;
      }
    });
    String str = getString(R.l.app_ok);
    MenuItem.OnMenuItemClickListener local2 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(292389);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Contact", Util.listToString(SelectContactsFromRangeUI.a.a(SelectContactsFromRangeUI.a(SelectContactsFromRangeUI.this)), ","));
        SelectContactsFromRangeUI.this.setResult(-1, paramAnonymousMenuItem);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(292389);
        return true;
      }
    };
    if (this.XpC == 16) {}
    for (paramBundle = w.b.Wap;; paramBundle = w.b.Wao)
    {
      addTextOptionMenu(1, str, local2, null, paramBundle);
      enableOptionMenu(1, false);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(681, this);
      AppMethodBeat.o(287432);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(287435);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(681, this);
    this.Xwy.finish();
    super.onDestroy();
    AppMethodBeat.o(287435);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(287442);
    Log.i("MicroMsg.SelectContactsFromRangeUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramq.getType());
    AppMethodBeat.o(287442);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends r
  {
    private int AYg;
    private List<String> Eec;
    private HashMap<String, Integer> Xqo;
    private SparseArray<String> Xqp;
    private Cursor mNt;
    private String query;
    
    public a(o paramo, int paramInt)
    {
      super(com.tencent.mm.pluginsdk.j.a.hhV(), true, false);
      AppMethodBeat.i(291977);
      this.Xqo = new HashMap();
      this.Xqp = new SparseArray();
      this.query = "";
      this.Eec = new LinkedList();
      this.AYg = paramInt;
      ate();
      AppMethodBeat.o(291977);
    }
    
    public final void aIi(String paramString)
    {
      AppMethodBeat.i(291978);
      if (!this.query.equalsIgnoreCase(paramString)) {
        this.query = paramString;
      }
      ate();
      AppMethodBeat.o(291978);
    }
    
    public final void ate()
    {
      AppMethodBeat.i(291981);
      super.ate();
      if (this.mNt != null)
      {
        this.mNt.close();
        this.mNt = null;
      }
      this.Xqo.clear();
      this.Xqp.clear();
      if ((("@all.contact.android".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this))) || ("@all.contact.without.chatroom.without.openim".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this)))) && ((SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this) == null) || (SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this).length == 0)))
      {
        AppMethodBeat.o(291981);
        return;
      }
      com.tencent.mm.kernel.h.aHH();
      this.mNt = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().d(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), this.query, SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", csq());
      String[] arrayOfString = ab.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.query, csq());
      int[] arrayOfInt = ab.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", csq(), this.query);
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
          this.Xqo.put(arrayOfString[j], Integer.valueOf(arrayOfInt[j] + i));
          this.Xqp.put(arrayOfInt[j] + i, arrayOfString[j]);
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
        AppMethodBeat.o(291981);
        return;
      }
    }
    
    public final void bAh(String paramString)
    {
      AppMethodBeat.i(291979);
      if (this.Eec.contains(paramString)) {
        this.Eec.remove(paramString);
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(291979);
        return;
        if (this.Eec.size() >= this.AYg)
        {
          com.tencent.mm.ui.base.h.d(SelectContactsFromRangeUI.this.getContext(), SelectContactsFromRangeUI.this.getString(R.l.enh, new Object[] { Integer.valueOf(this.AYg) }), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          AppMethodBeat.o(291979);
          return;
        }
        this.Eec.add(paramString);
      }
    }
    
    public final int bzR(String paramString)
    {
      AppMethodBeat.i(291982);
      if (this.Xqo != null)
      {
        if (this.Xqo.containsKey(paramString))
        {
          int i = ((Integer)this.Xqo.get(paramString)).intValue();
          int j = this.XsW.getContentLV().getHeaderViewsCount();
          AppMethodBeat.o(291982);
          return i + j;
        }
        AppMethodBeat.o(291982);
        return -1;
      }
      AppMethodBeat.o(291982);
      return -1;
    }
    
    public final void finish()
    {
      AppMethodBeat.i(291986);
      super.finish();
      Log.i("MicroMsg.SelectContactsFromRangeUI", "finish!");
      if (this.mNt != null)
      {
        this.mNt.close();
        this.mNt = null;
      }
      AppMethodBeat.o(291986);
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(291984);
      if (this.mNt == null)
      {
        AppMethodBeat.o(291984);
        return 0;
      }
      int j = this.mNt.getCount();
      if (this.Xqp == null) {}
      for (;;)
      {
        AppMethodBeat.o(291984);
        return i + j;
        i = this.Xqp.size();
      }
    }
    
    protected final com.tencent.mm.ui.contact.a.a ye(int paramInt)
    {
      AppMethodBeat.i(291983);
      Object localObject1;
      Object localObject2;
      if (this.Xqp.indexOfKey(paramInt) >= 0)
      {
        localObject1 = (String)this.Xqp.get(paramInt);
        localObject2 = new j(paramInt);
        ((j)localObject2).header = ((String)localObject1);
        AppMethodBeat.o(291983);
        return localObject2;
      }
      int i = 0;
      int k = paramInt;
      int j;
      int m;
      do
      {
        j = i;
        if (i > this.Xqp.size()) {
          break;
        }
        j = i;
        if (this.Xqp.indexOfKey(k) >= 0) {
          j = i + 1;
        }
        m = k - 1;
        i = j;
        k = m;
      } while (m >= 0);
      i = paramInt - j;
      if (this.mNt.moveToPosition(i))
      {
        Log.d("MicroMsg.SelectContactsFromRangeUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject1 = new as();
        ((as)localObject1).convertFrom(this.mNt);
        localObject2 = new f(paramInt);
        ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((as)localObject1);
        if (ab.Lj(((ax)localObject1).field_username))
        {
          ((com.tencent.mm.ui.contact.a.a)localObject2).XsX = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).XsY = false;
          ((com.tencent.mm.ui.contact.a.a)localObject2).Xxs = false;
        }
        for (((f)localObject2).XxM = true;; ((f)localObject2).XxM = false)
        {
          AppMethodBeat.o(291983);
          return localObject2;
          ((com.tencent.mm.ui.contact.a.a)localObject2).XsX = fJk();
          ((com.tencent.mm.ui.contact.a.a)localObject2).XsY = hUO();
        }
      }
      Log.i("MicroMsg.SelectContactsFromRangeUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(291983);
      return null;
    }
  }
  
  final class b
    extends p
  {
    private SelectContactsFromRangeUI.a XwD;
    
    public b(o paramo, SelectContactsFromRangeUI.a parama)
    {
      super(false, 0);
      this.XwD = parama;
    }
    
    public final void a(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(292110);
      this.XwD.aIi(paramString);
      if (this.XsV != null) {
        this.XsV.g(paramString, getCount(), true);
      }
      AppMethodBeat.o(292110);
    }
    
    public final void clearData()
    {
      AppMethodBeat.i(292111);
      this.XwD.aIi("");
      AppMethodBeat.o(292111);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(292113);
      int i = this.XwD.getCount();
      AppMethodBeat.o(292113);
      return i;
    }
    
    protected final com.tencent.mm.ui.contact.a.a ye(int paramInt)
    {
      AppMethodBeat.i(292112);
      com.tencent.mm.ui.contact.a.a locala = this.XwD.ye(paramInt);
      AppMethodBeat.o(292112);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactsFromRangeUI
 * JD-Core Version:    0.7.0.1
 */
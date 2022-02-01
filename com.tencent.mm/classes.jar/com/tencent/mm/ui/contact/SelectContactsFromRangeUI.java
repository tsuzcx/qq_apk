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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.r.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SelectContactsFromRangeUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.al.g
{
  private String GRX;
  private int GSH;
  private a GYL;
  private b GYM;
  private String[] GYN;
  
  public final void VL()
  {
    AppMethodBeat.i(191690);
    super.VL();
    this.GSH = getIntent().getIntExtra("list_type", 0);
    this.GRX = getIntent().getStringExtra("filter_type");
    this.GYN = getIntent().getStringArrayExtra("already_select_contact");
    this.GYL = new a(this, getIntent().getIntExtra("max_limit_num", 30));
    this.GYL.GVT = true;
    this.GYM = new b(this, this.GYL);
    AppMethodBeat.o(191690);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(191695);
    if ((parama instanceof e))
    {
      boolean bool = a.a(this.GYL).contains(((e)parama).username);
      AppMethodBeat.o(191695);
      return bool;
    }
    AppMethodBeat.o(191695);
    return false;
  }
  
  protected final boolean aHt()
  {
    return false;
  }
  
  protected final boolean aHu()
  {
    return true;
  }
  
  protected final String aHv()
  {
    AppMethodBeat.i(191692);
    String str = getString(2131755234);
    AppMethodBeat.o(191692);
    return str;
  }
  
  protected final q aHw()
  {
    return this.GYL;
  }
  
  protected final o aHx()
  {
    return this.GYM;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(191694);
    if ((parama instanceof e))
    {
      if ((this.GSH != 16) && (parama.contact.ZR()))
      {
        AppMethodBeat.o(191694);
        return true;
      }
      AppMethodBeat.o(191694);
      return false;
    }
    AppMethodBeat.o(191694);
    return false;
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(191689);
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(191676);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(191676);
        return false;
      }
    });
    String str = getString(2131755835);
    MenuItem.OnMenuItemClickListener local2 = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(191677);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Contact", bt.n(SelectContactsFromRangeUI.a.a(SelectContactsFromRangeUI.a(SelectContactsFromRangeUI.this)), ","));
        SelectContactsFromRangeUI.this.setResult(-1, paramAnonymousMenuItem);
        SelectContactsFromRangeUI.this.finish();
        AppMethodBeat.o(191677);
        return true;
      }
    };
    if (this.GSH == 16) {}
    for (paramBundle = r.b.FOC;; paramBundle = r.b.FOB)
    {
      addTextOptionMenu(1, str, local2, null, paramBundle);
      enableOptionMenu(1, false);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(681, this);
      AppMethodBeat.o(191689);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(191691);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(681, this);
    this.GYL.finish();
    super.onDestroy();
    AppMethodBeat.o(191691);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(191696);
    ad.i("MicroMsg.SelectContactsFromRangeUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " " + paramn.getType());
    AppMethodBeat.o(191696);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pT(int paramInt)
  {
    AppMethodBeat.i(191693);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      ad.i("MicroMsg.SelectContactsFromRangeUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(191693);
      return;
    }
    Object localObject = fbz().ZC(i);
    if ((localObject == null) || (!(localObject instanceof e)))
    {
      AppMethodBeat.o(191693);
      return;
    }
    if ((this.GSH != 16) && (((a)localObject).contact.ZR()))
    {
      AppMethodBeat.o(191693);
      return;
    }
    localObject = ((a)localObject).contact.field_username;
    ad.i("MicroMsg.SelectContactsFromRangeUI", "ClickUser=%s", new Object[] { localObject });
    a locala = this.GYL;
    if (locala.GXH.contains(localObject))
    {
      locala.GXH.remove(localObject);
      locala.notifyDataSetChanged();
      label163:
      if (a.a(this.GYL).size() <= 0) {
        break label353;
      }
      updateOptionMenuText(1, getString(2131755835) + "(" + a.a(this.GYL).size() + ")");
      enableOptionMenu(1, true);
    }
    for (;;)
    {
      if ((fbz() instanceof b))
      {
        fbG();
        hideVKB();
      }
      this.twW.aBC((String)localObject);
      AppMethodBeat.o(191693);
      return;
      if (locala.GXH.size() >= locala.qXm)
      {
        com.tencent.mm.ui.base.h.d(locala.GYO.getContext(), locala.GYO.getString(2131755503, new Object[] { Integer.valueOf(locala.qXm) }), "", new SelectContactsFromRangeUI.a.1(locala));
        break label163;
      }
      locala.GXH.add(localObject);
      break;
      label353:
      updateOptionMenuText(1, getString(2131755835));
      enableOptionMenu(1, false);
    }
  }
  
  final class a
    extends q
  {
    private HashMap<String, Integer> GTv;
    private SparseArray<String> GTw;
    List<String> GXH;
    private Cursor icq;
    int qXm;
    private String query;
    
    public a(n paramn, int paramInt)
    {
      super(null, true, false);
      AppMethodBeat.i(191678);
      this.GTv = new HashMap();
      this.GTw = new SparseArray();
      this.query = "";
      this.GXH = new LinkedList();
      this.qXm = paramInt;
      VP();
      AppMethodBeat.o(191678);
    }
    
    public final void VP()
    {
      AppMethodBeat.i(191680);
      super.VP();
      if (this.icq != null)
      {
        this.icq.close();
        this.icq = null;
      }
      this.GTv.clear();
      this.GTw.clear();
      if ((("@all.contact.android".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this))) || ("@all.contact.without.chatroom.without.openim".equals(SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this)))) && ((SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this) == null) || (SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this).length == 0)))
      {
        AppMethodBeat.o(191680);
        return;
      }
      com.tencent.mm.kernel.g.afC();
      this.icq = ((k)com.tencent.mm.kernel.g.ab(k.class)).apM().d(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), this.query, SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.fvP);
      String[] arrayOfString = w.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.query, this.fvP);
      int[] arrayOfInt = w.a(SelectContactsFromRangeUI.c(SelectContactsFromRangeUI.this), SelectContactsFromRangeUI.b(SelectContactsFromRangeUI.this), "", this.fvP, this.query);
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
          this.GTv.put(arrayOfString[j], Integer.valueOf(arrayOfInt[j] + i));
          this.GTw.put(arrayOfInt[j] + i, arrayOfString[j]);
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
        AppMethodBeat.o(191680);
        return;
      }
    }
    
    public final int aLn(String paramString)
    {
      AppMethodBeat.i(191681);
      if (this.GTv != null)
      {
        if (this.GTv.containsKey(paramString))
        {
          int i = ((Integer)this.GTv.get(paramString)).intValue();
          int j = this.GVS.getContentLV().getHeaderViewsCount();
          AppMethodBeat.o(191681);
          return i + j;
        }
        AppMethodBeat.o(191681);
        return -1;
      }
      AppMethodBeat.o(191681);
      return -1;
    }
    
    public final void abu(String paramString)
    {
      AppMethodBeat.i(191679);
      if (!this.query.equalsIgnoreCase(paramString)) {
        this.query = paramString;
      }
      VP();
      AppMethodBeat.o(191679);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(191684);
      super.finish();
      ad.i("MicroMsg.SelectContactsFromRangeUI", "finish!");
      if (this.icq != null)
      {
        this.icq.close();
        this.icq = null;
      }
      AppMethodBeat.o(191684);
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(191683);
      if (this.icq == null)
      {
        AppMethodBeat.o(191683);
        return 0;
      }
      int j = this.icq.getCount();
      if (this.GTw == null) {}
      for (;;)
      {
        AppMethodBeat.o(191683);
        return i + j;
        i = this.GTw.size();
      }
    }
    
    protected final a pU(int paramInt)
    {
      AppMethodBeat.i(191682);
      Object localObject1;
      Object localObject2;
      if (this.GTw.indexOfKey(paramInt) >= 0)
      {
        localObject1 = (String)this.GTw.get(paramInt);
        localObject2 = new com.tencent.mm.ui.contact.a.h(paramInt);
        ((com.tencent.mm.ui.contact.a.h)localObject2).header = ((String)localObject1);
        AppMethodBeat.o(191682);
        return localObject2;
      }
      int i = 0;
      int k = paramInt;
      int j;
      int m;
      do
      {
        j = i;
        if (i > this.GTw.size()) {
          break;
        }
        j = i;
        if (this.GTw.indexOfKey(k) >= 0) {
          j = i + 1;
        }
        m = k - 1;
        i = j;
        k = m;
      } while (m >= 0);
      i = paramInt - j;
      if (this.icq.moveToPosition(i))
      {
        ad.d("MicroMsg.SelectContactsFromRangeUI", "create contact item position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        localObject1 = new af();
        ((af)localObject1).convertFrom(this.icq);
        localObject2 = new e(paramInt);
        ((a)localObject2).contact = ((af)localObject1);
        if (w.pF(((au)localObject1).field_username))
        {
          ((a)localObject2).GVT = false;
          ((a)localObject2).GVU = false;
          ((a)localObject2).GZk = false;
        }
        for (((e)localObject2).GZx = true;; ((e)localObject2).GZx = false)
        {
          AppMethodBeat.o(191682);
          return localObject2;
          ((a)localObject2).GVT = dqZ();
          ((a)localObject2).GVU = this.GVU;
        }
      }
      ad.i("MicroMsg.SelectContactsFromRangeUI", "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(191682);
      return null;
    }
  }
  
  final class b
    extends o
  {
    private SelectContactsFromRangeUI.a GYQ;
    
    public b(n paramn, SelectContactsFromRangeUI.a parama)
    {
      super(false, 0);
      this.GYQ = parama;
    }
    
    public final void b(String paramString, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(191685);
      this.GYQ.abu(paramString);
      if (this.GVR != null) {
        this.GVR.y(paramString, getCount(), true);
      }
      AppMethodBeat.o(191685);
    }
    
    public final void clearData()
    {
      AppMethodBeat.i(191686);
      this.GYQ.abu("");
      AppMethodBeat.o(191686);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(191688);
      int i = this.GYQ.getCount();
      AppMethodBeat.o(191688);
      return i;
    }
    
    protected final a pU(int paramInt)
    {
      AppMethodBeat.i(191687);
      a locala = this.GYQ.pU(paramInt);
      AppMethodBeat.o(191687);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactsFromRangeUI
 * JD-Core Version:    0.7.0.1
 */
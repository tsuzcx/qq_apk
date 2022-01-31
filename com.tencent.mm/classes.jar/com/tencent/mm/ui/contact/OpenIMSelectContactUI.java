package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.m.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.k;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class OpenIMSelectContactUI
  extends MMBaseSelectContactUI
{
  private int Aau;
  private HashSet<String> AeB;
  private HashSet<String> AeC;
  private int AeD;
  private boolean AeE;
  private SelectContactUI.a AeF;
  private String cwc;
  private List<String> ejc;
  private HashSet<String> gpQ;
  private String title;
  
  public OpenIMSelectContactUI()
  {
    AppMethodBeat.i(33825);
    this.AeE = true;
    this.AeF = new SelectContactUI.a();
    AppMethodBeat.o(33825);
  }
  
  private void Km()
  {
    AppMethodBeat.i(33832);
    if ((t.hI(this.AeD, 64)) && (this.gpQ.size() > 0))
    {
      updateOptionMenuText(1, getString(2131296890) + "(" + this.gpQ.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((t.hI(this.AeD, 262144)) && (this.gpQ.size() < i))
      {
        enableOptionMenu(1, false);
        AppMethodBeat.o(33832);
        return;
      }
      enableOptionMenu(1, true);
      AppMethodBeat.o(33832);
      return;
    }
    updateOptionMenuText(1, getString(2131296890));
    enableOptionMenu(1, false);
    AppMethodBeat.o(33832);
  }
  
  private void ama(String paramString)
  {
    AppMethodBeat.i(33833);
    if (this.oCs == null)
    {
      AppMethodBeat.o(33833);
      return;
    }
    this.oCs.ama(paramString);
    AppMethodBeat.o(33833);
  }
  
  private boolean u(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(33834);
    ab.i("OpenIMSelectContactUI", "handleSelect %s, cancel %s", new Object[] { paramList1, paramList2 });
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Contact", bo.d(paramList1, ","));
    localIntent.putExtra("Cancel_Select_Contact", bo.d(paramList2, ","));
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(33834);
    return true;
  }
  
  protected final void Kc()
  {
    AppMethodBeat.i(33827);
    super.Kc();
    this.cwc = getIntent().getStringExtra("openim_appid");
    this.title = getIntent().getStringExtra("titile");
    this.Aau = getIntent().getIntExtra("list_type", -1);
    this.AeD = getIntent().getIntExtra("list_attr", t.AdS);
    this.ejc = new ArrayList();
    this.gpQ = new HashSet();
    this.AeC = new HashSet();
    this.AeB = new HashSet();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bo.isNullOrNil((String)localObject)) {
      this.AeB.addAll(bo.P(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!bo.isNullOrNil((String)localObject))
    {
      this.gpQ.addAll(bo.P(((String)localObject).split(",")));
      this.AeC.addAll(this.gpQ);
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!bo.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(bo.P(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(t.dMg());
    ((HashSet)localObject).addAll(t.dMh());
    this.ejc.addAll((Collection)localObject);
    AppMethodBeat.o(33827);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(33836);
    boolean bool;
    if ((parama.Adl) && (parama.contact != null))
    {
      bool = this.gpQ.contains(parama.contact.field_username);
      AppMethodBeat.o(33836);
      return bool;
    }
    if ((parama.Adm) && (parama.contact != null))
    {
      bool = this.gpQ.contains(parama.contact.field_username);
      AppMethodBeat.o(33836);
      return bool;
    }
    if ((parama instanceof k))
    {
      bool = this.gpQ.isEmpty();
      AppMethodBeat.o(33836);
      return bool;
    }
    AppMethodBeat.o(33836);
    return false;
  }
  
  protected final boolean apa()
  {
    return false;
  }
  
  protected final boolean apb()
  {
    return false;
  }
  
  protected final String apc()
  {
    AppMethodBeat.i(33828);
    if (bo.isNullOrNil(this.title)) {
      this.title = ((b)com.tencent.mm.kernel.g.E(b.class)).a(this.cwc, "openim_acct_type_title", b.a.gfD);
    }
    String str = this.title;
    AppMethodBeat.o(33828);
    return str;
  }
  
  protected final p apd()
  {
    AppMethodBeat.i(33829);
    boolean bool = t.hI(this.AeD, 64);
    x localx = new x(this.cwc, this, this.ejc, bool);
    AppMethodBeat.o(33829);
    return localx;
  }
  
  protected final n ape()
  {
    AppMethodBeat.i(33830);
    r localr = new r(this, this.ejc, t.hI(this.AeD, 64), this.scene);
    AppMethodBeat.o(33830);
    return localr;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(33837);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.AeB.contains(parama.contact.field_username);
      AppMethodBeat.o(33837);
      return bool;
    }
    AppMethodBeat.o(33837);
    return false;
  }
  
  public final boolean dMe()
  {
    return false;
  }
  
  public final void mL(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(33831);
    int j = paramInt - getContentLV().getHeaderViewsCount();
    if (j < 0)
    {
      ab.i("OpenIMSelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
      AppMethodBeat.o(33831);
      return;
    }
    Object localObject = dLW().Qt(j);
    if (localObject == null)
    {
      AppMethodBeat.o(33831);
      return;
    }
    if (((a)localObject).contact == null)
    {
      AppMethodBeat.o(33831);
      return;
    }
    if (((a)localObject).contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(33831);
      return;
    }
    localObject = ((a)localObject).contact.field_username;
    ab.i("OpenIMSelectContactUI", "ClickUser=%s", new Object[] { localObject });
    if (t.hI(this.AeD, 64))
    {
      if ((t.hI(this.AeD, 131072)) && (this.gpQ.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.AeB.contains(localObject))
        {
          dMc();
          if (this.gpQ.contains(localObject))
          {
            ama((String)localObject);
            this.gpQ.remove(localObject);
          }
        }
        else
        {
          Km();
          if ((this.AeE) && ((this.Aau == 1) || (this.Aau == 0))) {
            if (this.AeB == null) {
              break label468;
            }
          }
        }
      }
      label468:
      for (paramInt = this.AeB.size();; paramInt = 0)
      {
        if (this.gpQ != null) {
          i = this.gpQ.size();
        }
        j = bo.apV(com.tencent.mm.m.g.Nq().getValue("ChatRoomInviteStartCount"));
        this.AeF.e(this, paramInt + i, j);
        dLX().notifyDataSetChanged();
        AppMethodBeat.o(33831);
        return;
        String str = getIntent().getStringExtra("too_many_member_tip_string");
        localObject = str;
        if (bo.isNullOrNil(str)) {
          localObject = getString(2131303050, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        h.a(getContext(), (String)localObject, getString(2131297056), new OpenIMSelectContactUI.2(this));
        break;
        if (this.AeB.contains(localObject)) {
          break;
        }
        dMc();
        ama((String)localObject);
        if (this.gpQ.contains(localObject))
        {
          this.gpQ.remove(localObject);
          break;
        }
        this.gpQ.add(localObject);
        break;
      }
    }
    u(bo.P(new String[] { localObject }), new ArrayList(0));
    AppMethodBeat.o(33831);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33826);
    super.onCreate(paramBundle);
    if (t.hI(this.AeD, 64)) {
      addTextOptionMenu(1, getString(2131297018), new OpenIMSelectContactUI.1(this), null, q.b.zby);
    }
    Km();
    paramBundle = this.gpQ.iterator();
    while (paramBundle.hasNext()) {
      ama((String)paramBundle.next());
    }
    AppMethodBeat.o(33826);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wK(String paramString)
  {
    AppMethodBeat.i(33835);
    this.gpQ.remove(paramString);
    dLW().notifyDataSetChanged();
    Km();
    AppMethodBeat.o(33835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMSelectContactUI
 * JD-Core Version:    0.7.0.1
 */
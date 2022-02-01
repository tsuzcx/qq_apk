package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.n.e;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.a.k;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class OpenIMSelectContactUI
  extends MMBaseSelectContactUI
{
  private int KFT;
  private HashSet<String> KLl;
  private HashSet<String> KLm;
  private int KLn;
  private boolean KLo;
  private SelectContactUI.a KLp;
  private String dwb;
  private List<String> fUR;
  private HashSet<String> iYq;
  private String title;
  
  public OpenIMSelectContactUI()
  {
    AppMethodBeat.i(37946);
    this.KLo = true;
    this.KLp = new SelectContactUI.a();
    AppMethodBeat.o(37946);
  }
  
  private boolean H(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(37955);
    ae.i("OpenIMSelectContactUI", "handleSelect %s, cancel %s", new Object[] { paramList1, paramList2 });
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Contact", bu.m(paramList1, ","));
    localIntent.putExtra("Cancel_Select_Contact", bu.m(paramList2, ","));
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(37955);
    return true;
  }
  
  private void Zv()
  {
    AppMethodBeat.i(37953);
    if ((u.hasAttr(this.KLn, 64)) && (this.iYq.size() > 0))
    {
      updateOptionMenuText(1, getString(2131755693) + "(" + this.iYq.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((u.hasAttr(this.KLn, 262144)) && (this.iYq.size() < i))
      {
        enableOptionMenu(1, false);
        AppMethodBeat.o(37953);
        return;
      }
      enableOptionMenu(1, true);
      AppMethodBeat.o(37953);
      return;
    }
    updateOptionMenuText(1, getString(2131755693));
    enableOptionMenu(1, false);
    AppMethodBeat.o(37953);
  }
  
  private void aNT(String paramString)
  {
    AppMethodBeat.i(37954);
    if (this.vUs == null)
    {
      AppMethodBeat.o(37954);
      return;
    }
    this.vUs.aNT(paramString);
    AppMethodBeat.o(37954);
  }
  
  public final void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(37956);
    if (paramInt == 1)
    {
      this.iYq.remove(paramString);
      fMv().notifyDataSetChanged();
      Zv();
    }
    AppMethodBeat.o(37956);
  }
  
  protected final void Zm()
  {
    AppMethodBeat.i(37948);
    super.Zm();
    this.dwb = getIntent().getStringExtra("openim_appid");
    this.title = getIntent().getStringExtra("titile");
    this.KFT = getIntent().getIntExtra("list_type", -1);
    this.KLn = getIntent().getIntExtra("list_attr", u.KJQ);
    this.fUR = new ArrayList();
    this.iYq = new HashSet();
    this.KLm = new HashSet();
    this.KLl = new HashSet();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bu.isNullOrNil((String)localObject)) {
      this.KLl.addAll(bu.U(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!bu.isNullOrNil((String)localObject))
    {
      this.iYq.addAll(bu.U(((String)localObject).split(",")));
      this.KLm.addAll(this.iYq);
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!bu.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(bu.U(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(u.fMH());
    ((HashSet)localObject).addAll(u.fMI());
    this.fUR.addAll((Collection)localObject);
    AppMethodBeat.o(37948);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(37957);
    boolean bool;
    if ((parama.KJj) && (parama.contact != null))
    {
      bool = this.iYq.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama.KJk) && (parama.contact != null))
    {
      bool = this.iYq.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama instanceof k))
    {
      bool = this.iYq.isEmpty();
      AppMethodBeat.o(37957);
      return bool;
    }
    AppMethodBeat.o(37957);
    return false;
  }
  
  protected final boolean aRT()
  {
    return false;
  }
  
  protected final boolean aRU()
  {
    return false;
  }
  
  protected final String aRV()
  {
    AppMethodBeat.i(37949);
    if (bu.isNullOrNil(this.title)) {
      this.title = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).a(this.dwb, "openim_acct_type_title", a.a.iKm);
    }
    String str = this.title;
    AppMethodBeat.o(37949);
    return str;
  }
  
  protected final q aRW()
  {
    AppMethodBeat.i(37950);
    boolean bool = u.hasAttr(this.KLn, 64);
    aa localaa = new aa(this.dwb, this, this.fUR, bool);
    AppMethodBeat.o(37950);
    return localaa;
  }
  
  protected final o aRX()
  {
    AppMethodBeat.i(37951);
    s locals = new s(this, this.fUR, u.hasAttr(this.KLn, 64), this.scene);
    AppMethodBeat.o(37951);
    return locals;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(37958);
    if ((parama.KJj) && (parama.contact != null))
    {
      boolean bool = this.KLl.contains(parama.contact.field_username);
      AppMethodBeat.o(37958);
      return bool;
    }
    AppMethodBeat.o(37958);
    return false;
  }
  
  public final boolean fME()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37947);
    super.onCreate(paramBundle);
    if (u.hasAttr(this.KLn, 64)) {
      addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37945);
          paramAnonymousMenuItem = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, u.hasAttr(OpenIMSelectContactUI.a(OpenIMSelectContactUI.this), 8192));
          paramAnonymousMenuItem.remove(v.aAC());
          ArrayList localArrayList = new ArrayList(OpenIMSelectContactUI.b(OpenIMSelectContactUI.this));
          localArrayList.removeAll(paramAnonymousMenuItem);
          boolean bool = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, paramAnonymousMenuItem, localArrayList);
          AppMethodBeat.o(37945);
          return bool;
        }
      }, null, s.b.JwA);
    }
    Zv();
    paramBundle = this.iYq.iterator();
    while (paramBundle.hasNext()) {
      aNT((String)paramBundle.next());
    }
    AppMethodBeat.o(37947);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rj(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(37952);
    int j = paramInt - getContentLV().getHeaderViewsCount();
    if (j < 0)
    {
      ae.i("OpenIMSelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
      AppMethodBeat.o(37952);
      return;
    }
    Object localObject = fMv().aeW(j);
    if (localObject == null)
    {
      AppMethodBeat.o(37952);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact == null)
    {
      AppMethodBeat.o(37952);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject).contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(37952);
      return;
    }
    localObject = ((com.tencent.mm.ui.contact.a.a)localObject).contact.field_username;
    ae.i("OpenIMSelectContactUI", "ClickUser=%s", new Object[] { localObject });
    if (u.hasAttr(this.KLn, 64))
    {
      if ((u.hasAttr(this.KLn, 131072)) && (this.iYq.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.KLl.contains(localObject))
        {
          fMC();
          if (this.iYq.contains(localObject))
          {
            aNT((String)localObject);
            this.iYq.remove(localObject);
          }
        }
        else
        {
          Zv();
          if ((this.KLo) && ((this.KFT == 1) || (this.KFT == 0))) {
            if (this.KLl == null) {
              break label464;
            }
          }
        }
      }
      label464:
      for (paramInt = this.KLl.size();; paramInt = 0)
      {
        if (this.iYq != null) {
          i = this.iYq.size();
        }
        j = bu.aSB(com.tencent.mm.n.g.acL().getValue("ChatRoomInviteStartCount"));
        this.KLp.e(this, paramInt + i, j);
        fMw().notifyDataSetChanged();
        AppMethodBeat.o(37952);
        return;
        String str = getIntent().getStringExtra("too_many_member_tip_string");
        localObject = str;
        if (bu.isNullOrNil(str)) {
          localObject = getString(2131762994, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        h.d(getContext(), (String)localObject, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        break;
        if (this.KLl.contains(localObject)) {
          break;
        }
        fMC();
        aNT((String)localObject);
        if (this.iYq.contains(localObject))
        {
          this.iYq.remove(localObject);
          break;
        }
        this.iYq.add(localObject);
        break;
      }
    }
    H(bu.U(new String[] { localObject }), new ArrayList(0));
    AppMethodBeat.o(37952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMSelectContactUI
 * JD-Core Version:    0.7.0.1
 */
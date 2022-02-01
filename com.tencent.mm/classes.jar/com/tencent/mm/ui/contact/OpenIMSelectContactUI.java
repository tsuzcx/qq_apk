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
import com.tencent.mm.g.c.av;
import com.tencent.mm.m.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.a.a;
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
  private int IsT;
  private HashSet<String> Iyj;
  private HashSet<String> Iyk;
  private int Iyl;
  private boolean Iym;
  private SelectContactUI.a Iyn;
  private String djj;
  private List<String> fzw;
  private HashSet<String> iCn;
  private String title;
  
  public OpenIMSelectContactUI()
  {
    AppMethodBeat.i(37946);
    this.Iym = true;
    this.Iyn = new SelectContactUI.a();
    AppMethodBeat.o(37946);
  }
  
  private boolean G(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(37955);
    ac.i("OpenIMSelectContactUI", "handleSelect %s, cancel %s", new Object[] { paramList1, paramList2 });
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Contact", bs.n(paramList1, ","));
    localIntent.putExtra("Cancel_Select_Contact", bs.n(paramList2, ","));
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(37955);
    return true;
  }
  
  private void WT()
  {
    AppMethodBeat.i(37953);
    if ((u.hasAttr(this.Iyl, 64)) && (this.iCn.size() > 0))
    {
      updateOptionMenuText(1, getString(2131755693) + "(" + this.iCn.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((u.hasAttr(this.Iyl, 262144)) && (this.iCn.size() < i))
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
  
  private void aGU(String paramString)
  {
    AppMethodBeat.i(37954);
    if (this.uFo == null)
    {
      AppMethodBeat.o(37954);
      return;
    }
    this.uFo.aGU(paramString);
    AppMethodBeat.o(37954);
  }
  
  public final void O(int paramInt, String paramString)
  {
    AppMethodBeat.i(37956);
    if (paramInt == 1)
    {
      this.iCn.remove(paramString);
      frq().notifyDataSetChanged();
      WT();
    }
    AppMethodBeat.o(37956);
  }
  
  protected final void WJ()
  {
    AppMethodBeat.i(37948);
    super.WJ();
    this.djj = getIntent().getStringExtra("openim_appid");
    this.title = getIntent().getStringExtra("titile");
    this.IsT = getIntent().getIntExtra("list_type", -1);
    this.Iyl = getIntent().getIntExtra("list_attr", u.IwO);
    this.fzw = new ArrayList();
    this.iCn = new HashSet();
    this.Iyk = new HashSet();
    this.Iyj = new HashSet();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bs.isNullOrNil((String)localObject)) {
      this.Iyj.addAll(bs.S(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!bs.isNullOrNil((String)localObject))
    {
      this.iCn.addAll(bs.S(((String)localObject).split(",")));
      this.Iyk.addAll(this.iCn);
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!bs.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(bs.S(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(u.frC());
    ((HashSet)localObject).addAll(u.frD());
    this.fzw.addAll((Collection)localObject);
    AppMethodBeat.o(37948);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(37957);
    boolean bool;
    if ((parama.Iwh) && (parama.contact != null))
    {
      bool = this.iCn.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama.Iwi) && (parama.contact != null))
    {
      bool = this.iCn.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama instanceof k))
    {
      bool = this.iCn.isEmpty();
      AppMethodBeat.o(37957);
      return bool;
    }
    AppMethodBeat.o(37957);
    return false;
  }
  
  protected final boolean aOi()
  {
    return false;
  }
  
  protected final boolean aOj()
  {
    return false;
  }
  
  protected final String aOk()
  {
    AppMethodBeat.i(37949);
    if (bs.isNullOrNil(this.title)) {
      this.title = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(this.djj, "openim_acct_type_title", b.a.inW);
    }
    String str = this.title;
    AppMethodBeat.o(37949);
    return str;
  }
  
  protected final q aOl()
  {
    AppMethodBeat.i(37950);
    boolean bool = u.hasAttr(this.Iyl, 64);
    aa localaa = new aa(this.djj, this, this.fzw, bool);
    AppMethodBeat.o(37950);
    return localaa;
  }
  
  protected final o aOm()
  {
    AppMethodBeat.i(37951);
    s locals = new s(this, this.fzw, u.hasAttr(this.Iyl, 64), this.scene);
    AppMethodBeat.o(37951);
    return locals;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(37958);
    if ((parama.Iwh) && (parama.contact != null))
    {
      boolean bool = this.Iyj.contains(parama.contact.field_username);
      AppMethodBeat.o(37958);
      return bool;
    }
    AppMethodBeat.o(37958);
    return false;
  }
  
  public final boolean frz()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37947);
    super.onCreate(paramBundle);
    if (u.hasAttr(this.Iyl, 64)) {
      addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37945);
          paramAnonymousMenuItem = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, u.hasAttr(OpenIMSelectContactUI.a(OpenIMSelectContactUI.this), 8192));
          paramAnonymousMenuItem.remove(com.tencent.mm.model.u.axw());
          ArrayList localArrayList = new ArrayList(OpenIMSelectContactUI.b(OpenIMSelectContactUI.this));
          localArrayList.removeAll(paramAnonymousMenuItem);
          boolean bool = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, paramAnonymousMenuItem, localArrayList);
          AppMethodBeat.o(37945);
          return bool;
        }
      }, null, s.b.Hom);
    }
    WT();
    paramBundle = this.iCn.iterator();
    while (paramBundle.hasNext()) {
      aGU((String)paramBundle.next());
    }
    AppMethodBeat.o(37947);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qG(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(37952);
    int j = paramInt - getContentLV().getHeaderViewsCount();
    if (j < 0)
    {
      ac.i("OpenIMSelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
      AppMethodBeat.o(37952);
      return;
    }
    Object localObject = frq().abQ(j);
    if (localObject == null)
    {
      AppMethodBeat.o(37952);
      return;
    }
    if (((a)localObject).contact == null)
    {
      AppMethodBeat.o(37952);
      return;
    }
    if (((a)localObject).contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(37952);
      return;
    }
    localObject = ((a)localObject).contact.field_username;
    ac.i("OpenIMSelectContactUI", "ClickUser=%s", new Object[] { localObject });
    if (u.hasAttr(this.Iyl, 64))
    {
      if ((u.hasAttr(this.Iyl, 131072)) && (this.iCn.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.Iyj.contains(localObject))
        {
          frx();
          if (this.iCn.contains(localObject))
          {
            aGU((String)localObject);
            this.iCn.remove(localObject);
          }
        }
        else
        {
          WT();
          if ((this.Iym) && ((this.IsT == 1) || (this.IsT == 0))) {
            if (this.Iyj == null) {
              break label464;
            }
          }
        }
      }
      label464:
      for (paramInt = this.Iyj.size();; paramInt = 0)
      {
        if (this.iCn != null) {
          i = this.iCn.size();
        }
        j = bs.aLy(com.tencent.mm.m.g.ZY().getValue("ChatRoomInviteStartCount"));
        this.Iyn.e(this, paramInt + i, j);
        frr().notifyDataSetChanged();
        AppMethodBeat.o(37952);
        return;
        String str = getIntent().getStringExtra("too_many_member_tip_string");
        localObject = str;
        if (bs.isNullOrNil(str)) {
          localObject = getString(2131762994, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        h.d(getContext(), (String)localObject, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        break;
        if (this.Iyj.contains(localObject)) {
          break;
        }
        frx();
        aGU((String)localObject);
        if (this.iCn.contains(localObject))
        {
          this.iCn.remove(localObject);
          break;
        }
        this.iCn.add(localObject);
        break;
      }
    }
    G(bs.S(new String[] { localObject }), new ArrayList(0));
    AppMethodBeat.o(37952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMSelectContactUI
 * JD-Core Version:    0.7.0.1
 */
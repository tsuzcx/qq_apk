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
import com.tencent.mm.g.c.au;
import com.tencent.mm.m.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.k;
import com.tencent.mm.ui.r.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class OpenIMSelectContactUI
  extends MMBaseSelectContactUI
{
  private int GSH;
  private HashSet<String> GXT;
  private HashSet<String> GXU;
  private int GXV;
  private boolean GXW;
  private SelectContactUI.a GXX;
  private String dlB;
  private List<String> fvP;
  private HashSet<String> icg;
  private String title;
  
  public OpenIMSelectContactUI()
  {
    AppMethodBeat.i(37946);
    this.GXW = true;
    this.GXX = new SelectContactUI.a();
    AppMethodBeat.o(37946);
  }
  
  private boolean G(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(37955);
    ad.i("OpenIMSelectContactUI", "handleSelect %s, cancel %s", new Object[] { paramList1, paramList2 });
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Contact", bt.n(paramList1, ","));
    localIntent.putExtra("Cancel_Select_Contact", bt.n(paramList2, ","));
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(37955);
    return true;
  }
  
  private void VV()
  {
    AppMethodBeat.i(37953);
    if ((u.hasAttr(this.GXV, 64)) && (this.icg.size() > 0))
    {
      updateOptionMenuText(1, getString(2131755693) + "(" + this.icg.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((u.hasAttr(this.GXV, 262144)) && (this.icg.size() < i))
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
  
  private void aBC(String paramString)
  {
    AppMethodBeat.i(37954);
    if (this.twW == null)
    {
      AppMethodBeat.o(37954);
      return;
    }
    this.twW.aBC(paramString);
    AppMethodBeat.o(37954);
  }
  
  public final void N(int paramInt, String paramString)
  {
    AppMethodBeat.i(37956);
    if (paramInt == 1)
    {
      this.icg.remove(paramString);
      fbz().notifyDataSetChanged();
      VV();
    }
    AppMethodBeat.o(37956);
  }
  
  protected final void VL()
  {
    AppMethodBeat.i(37948);
    super.VL();
    this.dlB = getIntent().getStringExtra("openim_appid");
    this.title = getIntent().getStringExtra("titile");
    this.GSH = getIntent().getIntExtra("list_type", -1);
    this.GXV = getIntent().getIntExtra("list_attr", u.GWA);
    this.fvP = new ArrayList();
    this.icg = new HashSet();
    this.GXU = new HashSet();
    this.GXT = new HashSet();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bt.isNullOrNil((String)localObject)) {
      this.GXT.addAll(bt.S(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!bt.isNullOrNil((String)localObject))
    {
      this.icg.addAll(bt.S(((String)localObject).split(",")));
      this.GXU.addAll(this.icg);
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!bt.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(bt.S(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(u.fbL());
    ((HashSet)localObject).addAll(u.fbM());
    this.fvP.addAll((Collection)localObject);
    AppMethodBeat.o(37948);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(37957);
    boolean bool;
    if ((parama.GVT) && (parama.contact != null))
    {
      bool = this.icg.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama.GVU) && (parama.contact != null))
    {
      bool = this.icg.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama instanceof k))
    {
      bool = this.icg.isEmpty();
      AppMethodBeat.o(37957);
      return bool;
    }
    AppMethodBeat.o(37957);
    return false;
  }
  
  protected final boolean aHt()
  {
    return false;
  }
  
  protected final boolean aHu()
  {
    return false;
  }
  
  protected final String aHv()
  {
    AppMethodBeat.i(37949);
    if (bt.isNullOrNil(this.title)) {
      this.title = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(this.dlB, "openim_acct_type_title", b.a.hNA);
    }
    String str = this.title;
    AppMethodBeat.o(37949);
    return str;
  }
  
  protected final q aHw()
  {
    AppMethodBeat.i(37950);
    boolean bool = u.hasAttr(this.GXV, 64);
    aa localaa = new aa(this.dlB, this, this.fvP, bool);
    AppMethodBeat.o(37950);
    return localaa;
  }
  
  protected final o aHx()
  {
    AppMethodBeat.i(37951);
    s locals = new s(this, this.fvP, u.hasAttr(this.GXV, 64), this.scene);
    AppMethodBeat.o(37951);
    return locals;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(37958);
    if ((parama.GVT) && (parama.contact != null))
    {
      boolean bool = this.GXT.contains(parama.contact.field_username);
      AppMethodBeat.o(37958);
      return bool;
    }
    AppMethodBeat.o(37958);
    return false;
  }
  
  public final boolean fbI()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37947);
    super.onCreate(paramBundle);
    if (u.hasAttr(this.GXV, 64)) {
      addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37945);
          paramAnonymousMenuItem = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, u.hasAttr(OpenIMSelectContactUI.a(OpenIMSelectContactUI.this), 8192));
          paramAnonymousMenuItem.remove(com.tencent.mm.model.u.aqG());
          ArrayList localArrayList = new ArrayList(OpenIMSelectContactUI.b(OpenIMSelectContactUI.this));
          localArrayList.removeAll(paramAnonymousMenuItem);
          boolean bool = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, paramAnonymousMenuItem, localArrayList);
          AppMethodBeat.o(37945);
          return bool;
        }
      }, null, r.b.FOB);
    }
    VV();
    paramBundle = this.icg.iterator();
    while (paramBundle.hasNext()) {
      aBC((String)paramBundle.next());
    }
    AppMethodBeat.o(37947);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void pT(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(37952);
    int j = paramInt - getContentLV().getHeaderViewsCount();
    if (j < 0)
    {
      ad.i("OpenIMSelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
      AppMethodBeat.o(37952);
      return;
    }
    Object localObject = fbz().ZC(j);
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
    ad.i("OpenIMSelectContactUI", "ClickUser=%s", new Object[] { localObject });
    if (u.hasAttr(this.GXV, 64))
    {
      if ((u.hasAttr(this.GXV, 131072)) && (this.icg.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.GXT.contains(localObject))
        {
          fbG();
          if (this.icg.contains(localObject))
          {
            aBC((String)localObject);
            this.icg.remove(localObject);
          }
        }
        else
        {
          VV();
          if ((this.GXW) && ((this.GSH == 1) || (this.GSH == 0))) {
            if (this.GXT == null) {
              break label464;
            }
          }
        }
      }
      label464:
      for (paramInt = this.GXT.size();; paramInt = 0)
      {
        if (this.icg != null) {
          i = this.icg.size();
        }
        j = bt.aGh(com.tencent.mm.m.g.Zd().getValue("ChatRoomInviteStartCount"));
        this.GXX.e(this, paramInt + i, j);
        fbA().notifyDataSetChanged();
        AppMethodBeat.o(37952);
        return;
        String str = getIntent().getStringExtra("too_many_member_tip_string");
        localObject = str;
        if (bt.isNullOrNil(str)) {
          localObject = getString(2131762994, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        h.d(getContext(), (String)localObject, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        break;
        if (this.GXT.contains(localObject)) {
          break;
        }
        fbG();
        aBC((String)localObject);
        if (this.icg.contains(localObject))
        {
          this.icg.remove(localObject);
          break;
        }
        this.icg.add(localObject);
        break;
      }
    }
    G(bt.S(new String[] { localObject }), new ArrayList(0));
    AppMethodBeat.o(37952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMSelectContactUI
 * JD-Core Version:    0.7.0.1
 */
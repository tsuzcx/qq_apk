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
import com.tencent.mm.n.e;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private int Kjz;
  private HashSet<String> KoR;
  private HashSet<String> KoS;
  private int KoT;
  private boolean KoU;
  private SelectContactUI.a KoV;
  private String duW;
  private List<String> fSL;
  private HashSet<String> iVx;
  private String title;
  
  public OpenIMSelectContactUI()
  {
    AppMethodBeat.i(37946);
    this.KoU = true;
    this.KoV = new SelectContactUI.a();
    AppMethodBeat.o(37946);
  }
  
  private boolean I(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(37955);
    ad.i("OpenIMSelectContactUI", "handleSelect %s, cancel %s", new Object[] { paramList1, paramList2 });
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Contact", bt.m(paramList1, ","));
    localIntent.putExtra("Cancel_Select_Contact", bt.m(paramList2, ","));
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(37955);
    return true;
  }
  
  private void Zm()
  {
    AppMethodBeat.i(37953);
    if ((u.hasAttr(this.KoT, 64)) && (this.iVx.size() > 0))
    {
      updateOptionMenuText(1, getString(2131755693) + "(" + this.iVx.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((u.hasAttr(this.KoT, 262144)) && (this.iVx.size() < i))
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
  
  private void aMx(String paramString)
  {
    AppMethodBeat.i(37954);
    if (this.vIo == null)
    {
      AppMethodBeat.o(37954);
      return;
    }
    this.vIo.aMx(paramString);
    AppMethodBeat.o(37954);
  }
  
  public final void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(37956);
    if (paramInt == 1)
    {
      this.iVx.remove(paramString);
      fId().notifyDataSetChanged();
      Zm();
    }
    AppMethodBeat.o(37956);
  }
  
  protected final void Zd()
  {
    AppMethodBeat.i(37948);
    super.Zd();
    this.duW = getIntent().getStringExtra("openim_appid");
    this.title = getIntent().getStringExtra("titile");
    this.Kjz = getIntent().getIntExtra("list_type", -1);
    this.KoT = getIntent().getIntExtra("list_attr", u.Knw);
    this.fSL = new ArrayList();
    this.iVx = new HashSet();
    this.KoS = new HashSet();
    this.KoR = new HashSet();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bt.isNullOrNil((String)localObject)) {
      this.KoR.addAll(bt.U(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!bt.isNullOrNil((String)localObject))
    {
      this.iVx.addAll(bt.U(((String)localObject).split(",")));
      this.KoS.addAll(this.iVx);
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!bt.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(bt.U(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(u.fIp());
    ((HashSet)localObject).addAll(u.fIq());
    this.fSL.addAll((Collection)localObject);
    AppMethodBeat.o(37948);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(37957);
    boolean bool;
    if ((parama.KmP) && (parama.contact != null))
    {
      bool = this.iVx.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama.KmQ) && (parama.contact != null))
    {
      bool = this.iVx.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama instanceof k))
    {
      bool = this.iVx.isEmpty();
      AppMethodBeat.o(37957);
      return bool;
    }
    AppMethodBeat.o(37957);
    return false;
  }
  
  protected final boolean aRu()
  {
    return false;
  }
  
  protected final boolean aRv()
  {
    return false;
  }
  
  protected final String aRw()
  {
    AppMethodBeat.i(37949);
    if (bt.isNullOrNil(this.title)) {
      this.title = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(this.duW, "openim_acct_type_title", b.a.iHt);
    }
    String str = this.title;
    AppMethodBeat.o(37949);
    return str;
  }
  
  protected final q aRx()
  {
    AppMethodBeat.i(37950);
    boolean bool = u.hasAttr(this.KoT, 64);
    aa localaa = new aa(this.duW, this, this.fSL, bool);
    AppMethodBeat.o(37950);
    return localaa;
  }
  
  protected final o aRy()
  {
    AppMethodBeat.i(37951);
    s locals = new s(this, this.fSL, u.hasAttr(this.KoT, 64), this.scene);
    AppMethodBeat.o(37951);
    return locals;
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(37958);
    if ((parama.KmP) && (parama.contact != null))
    {
      boolean bool = this.KoR.contains(parama.contact.field_username);
      AppMethodBeat.o(37958);
      return bool;
    }
    AppMethodBeat.o(37958);
    return false;
  }
  
  public final boolean fIm()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37947);
    super.onCreate(paramBundle);
    if (u.hasAttr(this.KoT, 64)) {
      addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37945);
          paramAnonymousMenuItem = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, u.hasAttr(OpenIMSelectContactUI.a(OpenIMSelectContactUI.this), 8192));
          paramAnonymousMenuItem.remove(com.tencent.mm.model.u.aAm());
          ArrayList localArrayList = new ArrayList(OpenIMSelectContactUI.b(OpenIMSelectContactUI.this));
          localArrayList.removeAll(paramAnonymousMenuItem);
          boolean bool = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, paramAnonymousMenuItem, localArrayList);
          AppMethodBeat.o(37945);
          return bool;
        }
      }, null, s.b.JbS);
    }
    Zm();
    paramBundle = this.iVx.iterator();
    while (paramBundle.hasNext()) {
      aMx((String)paramBundle.next());
    }
    AppMethodBeat.o(37947);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rg(int paramInt)
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
    Object localObject = fId().aen(j);
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
    if (u.hasAttr(this.KoT, 64))
    {
      if ((u.hasAttr(this.KoT, 131072)) && (this.iVx.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.KoR.contains(localObject))
        {
          fIk();
          if (this.iVx.contains(localObject))
          {
            aMx((String)localObject);
            this.iVx.remove(localObject);
          }
        }
        else
        {
          Zm();
          if ((this.KoU) && ((this.Kjz == 1) || (this.Kjz == 0))) {
            if (this.KoR == null) {
              break label464;
            }
          }
        }
      }
      label464:
      for (paramInt = this.KoR.size();; paramInt = 0)
      {
        if (this.iVx != null) {
          i = this.iVx.size();
        }
        j = bt.aRe(com.tencent.mm.n.g.acA().getValue("ChatRoomInviteStartCount"));
        this.KoV.e(this, paramInt + i, j);
        fIe().notifyDataSetChanged();
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
        if (this.KoR.contains(localObject)) {
          break;
        }
        fIk();
        aMx((String)localObject);
        if (this.iVx.contains(localObject))
        {
          this.iVx.remove(localObject);
          break;
        }
        this.iVx.add(localObject);
        break;
      }
    }
    I(bt.U(new String[] { localObject }), new ArrayList(0));
    AppMethodBeat.o(37952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMSelectContactUI
 * JD-Core Version:    0.7.0.1
 */
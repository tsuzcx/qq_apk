package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.n.f;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.a.k;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class OpenIMSelectContactUI
  extends MMBaseSelectContactUI
{
  private int PSP;
  private HashSet<String> PYm;
  private HashSet<String> PYn;
  private int PYo;
  private boolean PYp;
  private SelectContactUI.a PYq;
  private String dNI;
  private List<String> gzY;
  private HashSet<String> jVV;
  private String title;
  
  public OpenIMSelectContactUI()
  {
    AppMethodBeat.i(37946);
    this.PYp = true;
    this.PYq = new SelectContactUI.a();
    AppMethodBeat.o(37946);
  }
  
  private boolean D(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(37955);
    Log.i("OpenIMSelectContactUI", "handleSelect %s, cancel %s", new Object[] { paramList1, paramList2 });
    Intent localIntent = new Intent();
    localIntent.putExtra("Select_Contact", Util.listToString(paramList1, ","));
    localIntent.putExtra("Cancel_Select_Contact", Util.listToString(paramList2, ","));
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(37955);
    return true;
  }
  
  private void ani()
  {
    AppMethodBeat.i(37953);
    if ((u.hasAttr(this.PYo, 64)) && (this.jVV.size() > 0))
    {
      updateOptionMenuText(1, getString(2131755763) + "(" + this.jVV.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((u.hasAttr(this.PYo, 262144)) && (this.jVV.size() < i))
      {
        enableOptionMenu(1, false);
        AppMethodBeat.o(37953);
        return;
      }
      enableOptionMenu(1, true);
      AppMethodBeat.o(37953);
      return;
    }
    updateOptionMenuText(1, getString(2131755763));
    enableOptionMenu(1, false);
    AppMethodBeat.o(37953);
  }
  
  private void bev(String paramString)
  {
    AppMethodBeat.i(37954);
    if (this.zoy == null)
    {
      AppMethodBeat.o(37954);
      return;
    }
    this.zoy.bev(paramString);
    AppMethodBeat.o(37954);
  }
  
  public final void M(View paramView, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(234016);
    int j = paramInt - getContentLV().getHeaderViewsCount();
    if (j < 0)
    {
      Log.i("OpenIMSelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
      AppMethodBeat.o(234016);
      return;
    }
    paramView = gUP().anH(j);
    if (paramView == null)
    {
      AppMethodBeat.o(234016);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(234016);
      return;
    }
    if (paramView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(234016);
      return;
    }
    paramView = paramView.contact.field_username;
    Log.i("OpenIMSelectContactUI", "ClickUser=%s", new Object[] { paramView });
    if (u.hasAttr(this.PYo, 64))
    {
      if ((u.hasAttr(this.PYo, 131072)) && (this.jVV.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.PYm.contains(paramView))
        {
          gUW();
          if (this.jVV.contains(paramView))
          {
            bev(paramView);
            this.jVV.remove(paramView);
          }
        }
        else
        {
          ani();
          if ((this.PYp) && ((this.PSP == 1) || (this.PSP == 0))) {
            if (this.PYm == null) {
              break label444;
            }
          }
        }
      }
      label444:
      for (paramInt = this.PYm.size();; paramInt = 0)
      {
        if (this.jVV != null) {
          i = this.jVV.size();
        }
        j = Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("ChatRoomInviteStartCount"));
        this.PYq.e(this, paramInt + i, j);
        gUQ().notifyDataSetChanged();
        AppMethodBeat.o(234016);
        return;
        String str = getIntent().getStringExtra("too_many_member_tip_string");
        paramView = str;
        if (Util.isNullOrNil(str)) {
          paramView = getString(2131765131, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        com.tencent.mm.ui.base.h.d(getContext(), paramView, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        break;
        if (this.PYm.contains(paramView)) {
          break;
        }
        gUW();
        bev(paramView);
        if (this.jVV.contains(paramView))
        {
          this.jVV.remove(paramView);
          break;
        }
        this.jVV.add(paramView);
        break;
      }
    }
    D(Util.stringsToList(new String[] { paramView }), new ArrayList(0));
    AppMethodBeat.o(234016);
  }
  
  public final void T(int paramInt, String paramString)
  {
    AppMethodBeat.i(37956);
    if (paramInt == 1)
    {
      this.jVV.remove(paramString);
      gUP().notifyDataSetChanged();
      ani();
    }
    AppMethodBeat.o(37956);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(37957);
    boolean bool;
    if ((parama.PWh) && (parama.contact != null))
    {
      bool = this.jVV.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama.PWi) && (parama.contact != null))
    {
      bool = this.jVV.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama instanceof k))
    {
      bool = this.jVV.isEmpty();
      AppMethodBeat.o(37957);
      return bool;
    }
    AppMethodBeat.o(37957);
    return false;
  }
  
  protected final void amZ()
  {
    AppMethodBeat.i(37948);
    super.amZ();
    this.dNI = getIntent().getStringExtra("openim_appid");
    this.title = getIntent().getStringExtra("titile");
    this.PSP = getIntent().getIntExtra("list_type", -1);
    this.PYo = getIntent().getIntExtra("list_attr", u.PWR);
    this.gzY = new ArrayList();
    this.jVV = new HashSet();
    this.PYn = new HashSet();
    this.PYm = new HashSet();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil((String)localObject)) {
      this.PYm.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil((String)localObject))
    {
      this.jVV.addAll(Util.stringsToList(((String)localObject).split(",")));
      this.PYn.addAll(this.jVV);
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!Util.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(Util.stringsToList(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(u.gVb());
    ((HashSet)localObject).addAll(u.gVc());
    this.gzY.addAll((Collection)localObject);
    AppMethodBeat.o(37948);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(37958);
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.PYm.contains(parama.contact.field_username);
      AppMethodBeat.o(37958);
      return bool;
    }
    AppMethodBeat.o(37958);
    return false;
  }
  
  protected final boolean bmA()
  {
    return false;
  }
  
  protected final String bmB()
  {
    AppMethodBeat.i(37949);
    if (Util.isNullOrNil(this.title)) {
      this.title = ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).a(this.dNI, "openim_acct_type_title", a.a.jGS);
    }
    String str = this.title;
    AppMethodBeat.o(37949);
    return str;
  }
  
  protected final q bmC()
  {
    AppMethodBeat.i(37950);
    boolean bool = u.hasAttr(this.PYo, 64);
    aa localaa = new aa(this.dNI, this, this.gzY, bool);
    AppMethodBeat.o(37950);
    return localaa;
  }
  
  protected final o bmD()
  {
    AppMethodBeat.i(37951);
    s locals = new s(this, this.gzY, u.hasAttr(this.PYo, 64), this.scene);
    AppMethodBeat.o(37951);
    return locals;
  }
  
  protected final boolean bmz()
  {
    return false;
  }
  
  public final boolean gUY()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37947);
    super.onCreate(paramBundle);
    if (u.hasAttr(this.PYo, 64)) {
      addTextOptionMenu(1, getString(2131755921), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37945);
          paramAnonymousMenuItem = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, u.hasAttr(OpenIMSelectContactUI.a(OpenIMSelectContactUI.this), 8192));
          paramAnonymousMenuItem.remove(z.aTY());
          ArrayList localArrayList = new ArrayList(OpenIMSelectContactUI.b(OpenIMSelectContactUI.this));
          localArrayList.removeAll(paramAnonymousMenuItem);
          boolean bool = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, paramAnonymousMenuItem, localArrayList);
          AppMethodBeat.o(37945);
          return bool;
        }
      }, null, t.b.OGU);
    }
    ani();
    paramBundle = this.jVV.iterator();
    while (paramBundle.hasNext()) {
      bev((String)paramBundle.next());
    }
    AppMethodBeat.o(37947);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMSelectContactUI
 * JD-Core Version:    0.7.0.1
 */
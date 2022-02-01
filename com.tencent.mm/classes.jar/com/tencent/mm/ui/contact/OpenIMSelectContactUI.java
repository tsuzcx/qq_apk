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
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.z;
import com.tencent.mm.n.f;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.a.m;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class OpenIMSelectContactUI
  extends MMBaseSelectContactUI
{
  private int XpC;
  private HashSet<String> Xve;
  private HashSet<String> Xvf;
  private int Xvg;
  private boolean Xvh;
  private SelectContactUI.a Xvi;
  private String appid;
  private List<String> jkb;
  private HashSet<String> mNi;
  private String title;
  
  public OpenIMSelectContactUI()
  {
    AppMethodBeat.i(37946);
    this.Xvh = true;
    this.Xvi = new SelectContactUI.a();
    AppMethodBeat.o(37946);
  }
  
  private boolean J(List<String> paramList1, List<String> paramList2)
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
  
  private void atk()
  {
    AppMethodBeat.i(37953);
    if ((w.hasAttr(this.Xvg, 64)) && (this.mNi.size() > 0))
    {
      updateOptionMenuText(1, getString(R.l.app_choose) + "(" + this.mNi.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((w.hasAttr(this.Xvg, 262144)) && (this.mNi.size() < i))
      {
        enableOptionMenu(1, false);
        AppMethodBeat.o(37953);
        return;
      }
      enableOptionMenu(1, true);
      AppMethodBeat.o(37953);
      return;
    }
    updateOptionMenuText(1, getString(R.l.app_choose));
    enableOptionMenu(1, false);
    AppMethodBeat.o(37953);
  }
  
  private void bqR(String paramString)
  {
    AppMethodBeat.i(37954);
    if (this.ETP == null)
    {
      AppMethodBeat.o(37954);
      return;
    }
    this.ETP.bqR(paramString);
    AppMethodBeat.o(37954);
  }
  
  public final void N(View paramView, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(285491);
    int j = paramInt - getContentLV().getHeaderViewsCount();
    if (j < 0)
    {
      Log.i("OpenIMSelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
      AppMethodBeat.o(285491);
      return;
    }
    paramView = hUP().awM(j);
    if (paramView == null)
    {
      AppMethodBeat.o(285491);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(285491);
      return;
    }
    if (paramView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(285491);
      return;
    }
    paramView = paramView.contact.field_username;
    Log.i("OpenIMSelectContactUI", "ClickUser=%s", new Object[] { paramView });
    if (w.hasAttr(this.Xvg, 64))
    {
      if ((w.hasAttr(this.Xvg, 131072)) && (this.mNi.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.Xve.contains(paramView))
        {
          hUZ();
          if (this.mNi.contains(paramView))
          {
            bqR(paramView);
            this.mNi.remove(paramView);
          }
        }
        else
        {
          atk();
          if ((this.Xvh) && ((this.XpC == 1) || (this.XpC == 0))) {
            if (this.Xve == null) {
              break label444;
            }
          }
        }
      }
      label444:
      for (paramInt = this.Xve.size();; paramInt = 0)
      {
        if (this.mNi != null) {
          i = this.mNi.size();
        }
        j = Util.safeParseInt(com.tencent.mm.n.h.axc().getValue("ChatRoomInviteStartCount"));
        this.Xvi.e(this, paramInt + i, j);
        hUQ().notifyDataSetChanged();
        AppMethodBeat.o(285491);
        return;
        String str = getIntent().getStringExtra("too_many_member_tip_string");
        paramView = str;
        if (Util.isNullOrNil(str)) {
          paramView = getString(R.l.eRS, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        com.tencent.mm.ui.base.h.d(getContext(), paramView, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        break;
        if (this.Xve.contains(paramView)) {
          break;
        }
        hUZ();
        bqR(paramView);
        if (this.mNi.contains(paramView))
        {
          this.mNi.remove(paramView);
          break;
        }
        this.mNi.add(paramView);
        break;
      }
    }
    J(Util.stringsToList(new String[] { paramView }), new ArrayList(0));
    AppMethodBeat.o(285491);
  }
  
  public final void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(37956);
    if (paramInt == 1)
    {
      this.mNi.remove(paramString);
      hUP().notifyDataSetChanged();
      atk();
    }
    AppMethodBeat.o(37956);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(37957);
    boolean bool;
    if ((parama.XsX) && (parama.contact != null))
    {
      bool = this.mNi.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama.XsY) && (parama.contact != null))
    {
      bool = this.mNi.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama instanceof m))
    {
      bool = this.mNi.isEmpty();
      AppMethodBeat.o(37957);
      return bool;
    }
    AppMethodBeat.o(37957);
    return false;
  }
  
  protected final void ata()
  {
    AppMethodBeat.i(37948);
    super.ata();
    this.appid = getIntent().getStringExtra("openim_appid");
    this.title = getIntent().getStringExtra("titile");
    this.XpC = getIntent().getIntExtra("list_type", -1);
    this.Xvg = getIntent().getIntExtra("list_attr", w.XtJ);
    this.jkb = new ArrayList();
    this.mNi = new HashSet();
    this.Xvf = new HashSet();
    this.Xve = new HashSet();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil((String)localObject)) {
      this.Xve.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil((String)localObject))
    {
      this.mNi.addAll(Util.stringsToList(((String)localObject).split(",")));
      this.Xvf.addAll(this.mNi);
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!Util.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(Util.stringsToList(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(w.hVh());
    ((HashSet)localObject).addAll(w.hVi());
    this.jkb.addAll((Collection)localObject);
    AppMethodBeat.o(37948);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(37958);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.Xve.contains(parama.contact.field_username);
      AppMethodBeat.o(37958);
      return bool;
    }
    AppMethodBeat.o(37958);
    return false;
  }
  
  protected final boolean bwH()
  {
    return false;
  }
  
  protected final boolean bwI()
  {
    return false;
  }
  
  protected final String bwJ()
  {
    AppMethodBeat.i(37949);
    if (Util.isNullOrNil(this.title)) {
      this.title = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).a(this.appid, "openim_acct_type_title", a.a.mxX);
    }
    String str = this.title;
    AppMethodBeat.o(37949);
    return str;
  }
  
  protected final r bwK()
  {
    AppMethodBeat.i(37950);
    boolean bool = w.hasAttr(this.Xvg, 64);
    ac localac = new ac(this.appid, this, this.jkb, bool);
    AppMethodBeat.o(37950);
    return localac;
  }
  
  protected final p bwL()
  {
    AppMethodBeat.i(37951);
    u localu = new u(this, this.jkb, w.hasAttr(this.Xvg, 64), this.scene);
    AppMethodBeat.o(37951);
    return localu;
  }
  
  public final boolean hVc()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37947);
    super.onCreate(paramBundle);
    if (w.hasAttr(this.Xvg, 64)) {
      addTextOptionMenu(1, getString(R.l.app_ok), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37945);
          paramAnonymousMenuItem = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, w.hasAttr(OpenIMSelectContactUI.a(OpenIMSelectContactUI.this), 8192));
          paramAnonymousMenuItem.remove(z.bcZ());
          ArrayList localArrayList = new ArrayList(OpenIMSelectContactUI.b(OpenIMSelectContactUI.this));
          localArrayList.removeAll(paramAnonymousMenuItem);
          boolean bool = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, paramAnonymousMenuItem, localArrayList);
          AppMethodBeat.o(37945);
          return bool;
        }
      }, null, w.b.Wao);
    }
    atk();
    paramBundle = this.mNi.iterator();
    while (paramBundle.hasNext()) {
      bqR((String)paramBundle.next());
    }
    AppMethodBeat.o(37947);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMSelectContactUI
 * JD-Core Version:    0.7.0.1
 */
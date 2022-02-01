package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.k.f;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.n;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class OpenIMSelectContactUI
  extends MMBaseSelectContactUI
{
  private int afbe;
  private HashSet<String> afhc;
  private HashSet<String> afhd;
  private int afhe;
  private boolean afhf;
  private SelectContactUI.a afhg;
  private String appid;
  private List<String> lMF;
  private HashSet<String> pJQ;
  private String title;
  
  public OpenIMSelectContactUI()
  {
    AppMethodBeat.i(37946);
    this.afhf = true;
    this.afhg = new SelectContactUI.a();
    AppMethodBeat.o(37946);
  }
  
  private boolean W(List<String> paramList1, List<String> paramList2)
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
  
  private void aNr()
  {
    AppMethodBeat.i(37953);
    if ((w.hasAttr(this.afhe, 64)) && (this.pJQ.size() > 0))
    {
      updateOptionMenuText(1, getString(R.l.app_choose) + "(" + this.pJQ.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((w.hasAttr(this.afhe, 262144)) && (this.pJQ.size() < i))
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
  
  private void bqG(String paramString)
  {
    AppMethodBeat.i(37954);
    if (this.KOt == null)
    {
      AppMethodBeat.o(37954);
      return;
    }
    this.KOt.bqG(paramString);
    AppMethodBeat.o(37954);
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(253126);
    int j = paramInt - getContentLV().getHeaderViewsCount();
    if (j < 0)
    {
      Log.i("OpenIMSelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
      AppMethodBeat.o(253126);
      return;
    }
    paramAdapterView = jyE().aDt(j);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(253126);
      return;
    }
    if (paramAdapterView.contact == null)
    {
      AppMethodBeat.o(253126);
      return;
    }
    if (paramAdapterView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(253126);
      return;
    }
    paramAdapterView = paramAdapterView.contact.field_username;
    Log.i("OpenIMSelectContactUI", "ClickUser=%s", new Object[] { paramAdapterView });
    if (w.hasAttr(this.afhe, 64))
    {
      if ((w.hasAttr(this.afhe, 131072)) && (this.pJQ.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.afhc.contains(paramAdapterView))
        {
          iKA();
          if (this.pJQ.contains(paramAdapterView))
          {
            bqG(paramAdapterView);
            this.pJQ.remove(paramAdapterView);
          }
        }
        else
        {
          aNr();
          if ((this.afhf) && ((this.afbe == 1) || (this.afbe == 0))) {
            if (this.afhc == null) {
              break label444;
            }
          }
        }
      }
      label444:
      for (paramInt = this.afhc.size();; paramInt = 0)
      {
        if (this.pJQ != null) {
          i = this.pJQ.size();
        }
        j = Util.safeParseInt(i.aRC().getValue("ChatRoomInviteStartCount"));
        this.afhg.f(this, paramInt + i, j);
        jyF().notifyDataSetChanged();
        AppMethodBeat.o(253126);
        return;
        paramView = getIntent().getStringExtra("too_many_member_tip_string");
        paramAdapterView = paramView;
        if (Util.isNullOrNil(paramView)) {
          paramAdapterView = getString(R.l.gUz, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        k.d(getContext(), paramAdapterView, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        break;
        if (this.afhc.contains(paramAdapterView)) {
          break;
        }
        iKA();
        bqG(paramAdapterView);
        if (this.pJQ.contains(paramAdapterView))
        {
          this.pJQ.remove(paramAdapterView);
          break;
        }
        this.pJQ.add(paramAdapterView);
        break;
      }
    }
    W(Util.stringsToList(new String[] { paramAdapterView }), new ArrayList(0));
    AppMethodBeat.o(253126);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(37957);
    boolean bool;
    if ((parama.afey) && (parama.contact != null))
    {
      bool = this.pJQ.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama.afez) && (parama.contact != null))
    {
      bool = this.pJQ.contains(parama.contact.field_username);
      AppMethodBeat.o(37957);
      return bool;
    }
    if ((parama instanceof n))
    {
      bool = this.pJQ.isEmpty();
      AppMethodBeat.o(37957);
      return bool;
    }
    AppMethodBeat.o(37957);
    return false;
  }
  
  protected final void aNi()
  {
    AppMethodBeat.i(37948);
    super.aNi();
    this.appid = getIntent().getStringExtra("openim_appid");
    this.title = getIntent().getStringExtra("titile");
    this.afbe = getIntent().getIntExtra("list_type", -1);
    this.afhe = getIntent().getIntExtra("list_attr", w.affn);
    this.lMF = new ArrayList();
    this.pJQ = new HashSet();
    this.afhd = new HashSet();
    this.afhc = new HashSet();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil((String)localObject)) {
      this.afhc.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil((String)localObject))
    {
      this.pJQ.addAll(Util.stringsToList(((String)localObject).split(",")));
      this.afhd.addAll(this.pJQ);
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!Util.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(Util.stringsToList(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(w.jyV());
    ((HashSet)localObject).addAll(w.jyW());
    this.lMF.addAll((Collection)localObject);
    AppMethodBeat.o(37948);
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(37956);
    if (paramInt == 1)
    {
      this.pJQ.remove(paramString);
      jyE().notifyDataSetChanged();
      aNr();
    }
    AppMethodBeat.o(37956);
  }
  
  public final boolean b(a parama)
  {
    AppMethodBeat.i(37958);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.afhc.contains(parama.contact.field_username);
      AppMethodBeat.o(37958);
      return bool;
    }
    AppMethodBeat.o(37958);
    return false;
  }
  
  protected final r bVA()
  {
    AppMethodBeat.i(37950);
    boolean bool = w.hasAttr(this.afhe, 64);
    ad localad = new ad(this.appid, this, this.lMF, bool);
    AppMethodBeat.o(37950);
    return localad;
  }
  
  protected final p bVB()
  {
    AppMethodBeat.i(37951);
    u localu = new u(this, this.lMF, w.hasAttr(this.afhe, 64), this.scene);
    AppMethodBeat.o(37951);
    return localu;
  }
  
  protected final boolean bVx()
  {
    return false;
  }
  
  protected final boolean bVy()
  {
    return false;
  }
  
  protected final String bVz()
  {
    AppMethodBeat.i(37949);
    if (Util.isNullOrNil(this.title)) {
      this.title = ((e)h.ax(e.class)).a(this.appid, "openim_acct_type_title", e.a.prb);
    }
    String str = this.title;
    AppMethodBeat.o(37949);
    return str;
  }
  
  public final boolean jyP()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37947);
    super.onCreate(paramBundle);
    if (w.hasAttr(this.afhe, 64)) {
      addTextOptionMenu(1, getString(R.l.app_ok), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37945);
          paramAnonymousMenuItem = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, w.hasAttr(OpenIMSelectContactUI.a(OpenIMSelectContactUI.this), 8192));
          paramAnonymousMenuItem.remove(z.bAM());
          ArrayList localArrayList = new ArrayList(OpenIMSelectContactUI.b(OpenIMSelectContactUI.this));
          localArrayList.removeAll(paramAnonymousMenuItem);
          boolean bool = OpenIMSelectContactUI.a(OpenIMSelectContactUI.this, paramAnonymousMenuItem, localArrayList);
          AppMethodBeat.o(37945);
          return bool;
        }
      }, null, y.b.adEJ);
    }
    aNr();
    paramBundle = this.pJQ.iterator();
    while (paramBundle.hasNext()) {
      bqG((String)paramBundle.next());
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
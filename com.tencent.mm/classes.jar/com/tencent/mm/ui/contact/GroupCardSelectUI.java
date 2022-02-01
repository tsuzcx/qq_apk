package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI
  extends MMActivity
{
  private m KmA;
  private HashMap<String, Long> KmB;
  private List<String> Kmq = null;
  private boolean Kmr = false;
  private boolean Kms = true;
  private boolean Kmt;
  private boolean Kmu;
  private boolean Kmv;
  private ArrayList<String> Kmw;
  private int Kmx;
  private int Kmy;
  private ListView Kmz;
  private TextView emptyTipTv;
  private List<am> fPS;
  
  private void Zm()
  {
    AppMethodBeat.i(37861);
    StringBuilder localStringBuilder;
    if (this.Kmr)
    {
      localStringBuilder = new StringBuilder().append(getString(2131755835));
      if (this.Kmq.size() <= 0) {
        break label85;
      }
    }
    label85:
    for (String str = String.format("(%s)", new Object[] { Integer.valueOf(this.Kmq.size()) });; str = "")
    {
      updateOptionMenuText(1, str);
      AppMethodBeat.o(37861);
      return;
    }
  }
  
  private void a(int paramInt, am paramam, long paramLong)
  {
    AppMethodBeat.i(37860);
    int i = 0;
    while ((i < paramInt) && (paramLong <= ((Long)this.KmB.get(((am)this.fPS.get(i)).field_username)).longValue())) {
      i += 1;
    }
    this.fPS.add(i, paramam);
    AppMethodBeat.o(37860);
  }
  
  private boolean c(am paramam)
  {
    AppMethodBeat.i(194544);
    if (this.Kmx == 2147483647)
    {
      AppMethodBeat.o(194544);
      return true;
    }
    if (paramam == null)
    {
      AppMethodBeat.o(194544);
      return false;
    }
    ab localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(paramam.field_username);
    if (localab == null)
    {
      ad.e("MicroMsg.GroupCardSelectUI", "isValidByMaxNum %s member is null", new Object[] { paramam.field_username });
      AppMethodBeat.o(194544);
      return false;
    }
    if (localab.field_memberCount < this.Kmx)
    {
      AppMethodBeat.o(194544);
      return true;
    }
    AppMethodBeat.o(194544);
    return false;
  }
  
  private void fIa()
  {
    AppMethodBeat.i(37859);
    ba.aBQ();
    this.KmB = com.tencent.mm.model.c.azv().fqM();
    this.fPS = new LinkedList();
    List localList = w.aBi();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(37859);
      return;
    }
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      am localam = (am)localIterator.next();
      if ((!w.zm(localam.field_username)) && ((this.Kmw == null) || (!this.Kmw.contains(localam.field_username))))
      {
        ab localab;
        if (!this.KmB.containsKey(localam.field_username))
        {
          if (!com.tencent.mm.o.b.lM(localam.field_type)) {
            break label397;
          }
          if (this.Kmu)
          {
            localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(localam.field_username);
            if (localab == null) {
              ad.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { bt.bI(localam.field_username, "") });
            } else if ((localab.Az(u.aAm())) && (c(localam))) {
              this.fPS.add(localam);
            }
          }
          else
          {
            if (!c(localam)) {
              break label397;
            }
            this.fPS.add(localam);
          }
        }
        else if (this.Kmu)
        {
          localab = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz().AN(localam.field_username);
          if (localab == null) {
            ad.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { bt.bI(localam.field_username, "") });
          } else {
            if (!localab.Az(u.aAm())) {
              break;
            }
          }
        }
        else if (c(localam))
        {
          a(i, localam, ((Long)this.KmB.get(localam.field_username)).longValue());
          i += 1;
        }
      }
    }
    label397:
    for (;;)
    {
      break;
      localList.clear();
      AppMethodBeat.o(37859);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131494421;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37858);
    this.Kmz = ((ListView)findViewById(2131300626));
    this.KmA = new m(this, this.fPS, this.Kmq, this.Kmr);
    this.Kmz.setAdapter(this.KmA);
    this.Kmz.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37851);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        int i = paramAnonymousInt;
        if (GroupCardSelectUI.a(GroupCardSelectUI.this))
        {
          i = GroupCardSelectUI.b(GroupCardSelectUI.this).getHeaderViewsCount();
          if (paramAnonymousInt == 0)
          {
            GroupCardSelectUI.c(GroupCardSelectUI.this);
            a.a(this, "com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(37851);
            return;
          }
          i = paramAnonymousInt - i;
        }
        paramAnonymousAdapterView = (am)GroupCardSelectUI.d(GroupCardSelectUI.this).getItem(i);
        if (paramAnonymousAdapterView == null)
        {
          ad.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
          a.a(this, "com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(37851);
          return;
        }
        GroupCardSelectUI.a(GroupCardSelectUI.this, paramAnonymousAdapterView);
        GroupCardSelectUI.e(GroupCardSelectUI.this);
        a.a(this, "com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(37851);
      }
    });
    this.emptyTipTv = ((TextView)findViewById(2131300622));
    ListView localListView;
    View localView;
    TextView localTextView;
    if (this.KmA.getCount() <= 0)
    {
      this.emptyTipTv.setVisibility(0);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37852);
          GroupCardSelectUI.this.finish();
          AppMethodBeat.o(37852);
          return true;
        }
      });
      if (this.Kmv)
      {
        localListView = this.Kmz;
        localView = z.jO(this).inflate(2131496466, null);
        ((TextView)localView.findViewById(2131298778)).setText(2131766520);
        localTextView = (TextView)localView.findViewById(2131308404);
        if (this.KmA.getCount() > 0) {
          break label205;
        }
        localTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      localListView.addHeaderView(localView);
      AppMethodBeat.o(37858);
      return;
      this.emptyTipTv.setVisibility(8);
      break;
      label205:
      localTextView.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37854);
    super.onCreate(paramBundle);
    this.Kms = getIntent().getBooleanExtra("group_select_type", true);
    this.Kmt = getIntent().getBooleanExtra("group_select_need_result", false);
    this.Kmu = getIntent().getBooleanExtra("group_select_only_need_self_owner", false);
    this.Kmw = getIntent().getStringArrayListExtra("group_select_block_chatroom");
    this.Kmv = getIntent().getBooleanExtra("group_select_only_need_self_owner", false);
    this.Kmx = getIntent().getIntExtra("group_select_chatroom_max_num", 2147483647);
    if ((this.Kmu) && (!this.Kmv))
    {
      setMMTitle(getString(2131755949));
      this.Kmr = getIntent().getBooleanExtra("group_multi_select", false);
      if (this.Kmr)
      {
        paramBundle = getIntent().getStringExtra("already_select_contact");
        if (!bt.isNullOrNil(paramBundle)) {
          break label262;
        }
      }
    }
    label262:
    for (this.Kmq = new LinkedList();; this.Kmq = af.j(paramBundle.split(",")))
    {
      this.Kmy = getIntent().getIntExtra("max_limit_num", 0);
      fIa();
      initView();
      if (this.Kmr)
      {
        addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(37853);
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Conv_User", bt.m(GroupCardSelectUI.f(GroupCardSelectUI.this), ","));
            GroupCardSelectUI.this.setResult(-1, paramAnonymousMenuItem);
            GroupCardSelectUI.this.finish();
            AppMethodBeat.o(37853);
            return true;
          }
        }, null, s.b.JbS);
        enableOptionMenu(1, true);
        Zm();
      }
      AppMethodBeat.o(37854);
      return;
      setMMTitle(getString(2131755225));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37855);
    super.onDestroy();
    AppMethodBeat.o(37855);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37857);
    super.onPause();
    AppMethodBeat.o(37857);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37856);
    super.onResume();
    AppMethodBeat.o(37856);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    TextView KmE;
    ImageView jdF;
    TextView uXJ;
    CheckBox wNt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.GroupCardSelectUI
 * JD-Core Version:    0.7.0.1
 */
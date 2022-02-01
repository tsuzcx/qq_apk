package com.tencent.mm.ui.contact;

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
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.c;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI
  extends MMActivity
{
  private List<String> afdZ = null;
  private boolean afea = false;
  private boolean afeb = true;
  private boolean afec;
  private boolean afed;
  private boolean afee;
  private ArrayList<String> afef;
  private int afeg;
  private int afeh;
  private ListView afei;
  private n afej;
  private HashMap<String, Long> afek;
  private TextView emptyTipTv;
  private List<au> lDu;
  
  private void a(int paramInt, au paramau, long paramLong)
  {
    AppMethodBeat.i(37860);
    int i = 0;
    while ((i < paramInt) && (paramLong <= ((Long)this.afek.get(((au)this.lDu.get(i)).field_username)).longValue())) {
      i += 1;
    }
    this.lDu.add(i, paramau);
    AppMethodBeat.o(37860);
  }
  
  private void aNr()
  {
    AppMethodBeat.i(37861);
    StringBuilder localStringBuilder;
    if (this.afea)
    {
      localStringBuilder = new StringBuilder().append(getString(R.l.app_ok));
      if (this.afdZ.size() <= 0) {
        break label89;
      }
    }
    label89:
    for (String str = String.format("(%s)", new Object[] { Integer.valueOf(this.afdZ.size()) });; str = "")
    {
      updateOptionMenuText(1, str);
      AppMethodBeat.o(37861);
      return;
    }
  }
  
  private boolean c(au paramau)
  {
    AppMethodBeat.i(253064);
    if (this.afeg == 2147483647)
    {
      AppMethodBeat.o(253064);
      return true;
    }
    if (paramau == null)
    {
      AppMethodBeat.o(253064);
      return false;
    }
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramau.field_username);
    if (localaj == null)
    {
      Log.e("MicroMsg.GroupCardSelectUI", "isValidByMaxNum %s member is null", new Object[] { paramau.field_username });
      AppMethodBeat.o(253064);
      return false;
    }
    if (localaj.field_memberCount < this.afeg)
    {
      AppMethodBeat.o(253064);
      return true;
    }
    AppMethodBeat.o(253064);
    return false;
  }
  
  private void jyA()
  {
    AppMethodBeat.i(37859);
    bh.bCz();
    this.afek = c.bzG().jaL();
    this.lDu = new LinkedList();
    List localList = com.tencent.mm.model.ab.bBP();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(37859);
      return;
    }
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      au localau = (au)localIterator.next();
      if ((this.afef == null) || (!this.afef.contains(localau.field_username)))
      {
        aj localaj;
        if (!this.afek.containsKey(localau.field_username))
        {
          if (!d.rs(localau.field_type)) {
            break label390;
          }
          if (this.afed)
          {
            localaj = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(localau.field_username);
            if (localaj == null) {
              Log.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { Util.nullAs(localau.field_username, "") });
            } else if ((localaj.Jf(z.bAM())) && (c(localau))) {
              this.lDu.add(localau);
            }
          }
          else
          {
            if (!c(localau)) {
              break label390;
            }
            this.lDu.add(localau);
          }
        }
        else if (this.afed)
        {
          localaj = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(localau.field_username);
          if (localaj == null) {
            Log.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { Util.nullAs(localau.field_username, "") });
          } else {
            if (!localaj.Jf(z.bAM())) {
              break;
            }
          }
        }
        else if (c(localau))
        {
          a(i, localau, ((Long)this.afek.get(localau.field_username)).longValue());
          i += 1;
        }
      }
    }
    label390:
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
    return R.i.gkr;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37858);
    this.afei = ((ListView)findViewById(R.h.fJr));
    this.afej = new n(this, this.lDu, this.afdZ, this.afea);
    this.afei.setAdapter(this.afej);
    this.afei.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37851);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
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
        paramAnonymousAdapterView = (au)GroupCardSelectUI.d(GroupCardSelectUI.this).getItem(i);
        if (paramAnonymousAdapterView == null)
        {
          Log.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
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
    this.emptyTipTv = ((TextView)findViewById(R.h.fJn));
    ListView localListView;
    View localView;
    TextView localTextView;
    if (this.afej.getCount() <= 0)
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
      if (this.afee)
      {
        localListView = this.afei;
        localView = af.mU(this).inflate(R.i.gkt, null);
        ((TextView)localView.findViewById(R.h.content_tv)).setText(R.l.gwm);
        localTextView = (TextView)localView.findViewById(R.h.fUM);
        if (this.afej.getCount() > 0) {
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
    this.afeb = getIntent().getBooleanExtra("group_select_type", true);
    this.afec = getIntent().getBooleanExtra("group_select_need_result", false);
    this.afed = getIntent().getBooleanExtra("group_select_only_need_self_owner", false);
    this.afef = getIntent().getStringArrayListExtra("group_select_block_chatroom");
    this.afee = getIntent().getBooleanExtra("group_select_show_create_new_group", false);
    this.afeg = getIntent().getIntExtra("group_select_chatroom_max_num", 2147483647);
    if ((this.afed) && (!this.afee))
    {
      setMMTitle(getString(R.l.gqP));
      this.afea = getIntent().getBooleanExtra("group_multi_select", false);
      if (this.afea)
      {
        paramBundle = getIntent().getStringExtra("already_select_contact");
        if (!Util.isNullOrNil(paramBundle)) {
          break label263;
        }
      }
    }
    label263:
    for (this.afdZ = new LinkedList();; this.afdZ = com.tencent.mm.platformtools.ab.j(paramBundle.split(",")))
    {
      this.afeh = getIntent().getIntExtra("max_limit_num", 0);
      jyA();
      initView();
      if (this.afea)
      {
        addTextOptionMenu(1, getString(R.l.app_ok), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(37853);
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Conv_User", Util.listToString(GroupCardSelectUI.f(GroupCardSelectUI.this), ","));
            GroupCardSelectUI.this.setResult(-1, paramAnonymousMenuItem);
            GroupCardSelectUI.this.finish();
            AppMethodBeat.o(37853);
            return true;
          }
        }, null, y.b.adEJ);
        enableOptionMenu(1, true);
        aNr();
      }
      AppMethodBeat.o(37854);
      return;
      setMMTitle(getString(R.l.gqO));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.GroupCardSelectUI
 * JD-Core Version:    0.7.0.1
 */
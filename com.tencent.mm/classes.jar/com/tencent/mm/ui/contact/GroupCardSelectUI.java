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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.c.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.br;
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
  private List<String> KIK = null;
  private boolean KIL = false;
  private boolean KIM = true;
  private boolean KIN;
  private boolean KIO;
  private boolean KIP;
  private ArrayList<String> KIQ;
  private int KIR;
  private int KIS;
  private ListView KIT;
  private m KIU;
  private HashMap<String, Long> KIV;
  private TextView emptyTipTv;
  private List<an> fRY;
  
  private void Zv()
  {
    AppMethodBeat.i(37861);
    StringBuilder localStringBuilder;
    if (this.KIL)
    {
      localStringBuilder = new StringBuilder().append(getString(2131755835));
      if (this.KIK.size() <= 0) {
        break label85;
      }
    }
    label85:
    for (String str = String.format("(%s)", new Object[] { Integer.valueOf(this.KIK.size()) });; str = "")
    {
      updateOptionMenuText(1, str);
      AppMethodBeat.o(37861);
      return;
    }
  }
  
  private void a(int paramInt, an paraman, long paramLong)
  {
    AppMethodBeat.i(37860);
    int i = 0;
    while ((i < paramInt) && (paramLong <= ((Long)this.KIV.get(((an)this.fRY.get(i)).field_username)).longValue())) {
      i += 1;
    }
    this.fRY.add(i, paraman);
    AppMethodBeat.o(37860);
  }
  
  private boolean c(an paraman)
  {
    AppMethodBeat.i(187945);
    if (this.KIR == 2147483647)
    {
      AppMethodBeat.o(187945);
      return true;
    }
    if (paraman == null)
    {
      AppMethodBeat.o(187945);
      return false;
    }
    ac localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(paraman.field_username);
    if (localac == null)
    {
      ae.e("MicroMsg.GroupCardSelectUI", "isValidByMaxNum %s member is null", new Object[] { paraman.field_username });
      AppMethodBeat.o(187945);
      return false;
    }
    if (localac.field_memberCount < this.KIR)
    {
      AppMethodBeat.o(187945);
      return true;
    }
    AppMethodBeat.o(187945);
    return false;
  }
  
  private void fMs()
  {
    AppMethodBeat.i(37859);
    bc.aCg();
    this.KIV = com.tencent.mm.model.c.azL().fuM();
    this.fRY = new LinkedList();
    List localList = x.aBy();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(37859);
      return;
    }
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      an localan = (an)localIterator.next();
      if ((!x.zW(localan.field_username)) && ((this.KIQ == null) || (!this.KIQ.contains(localan.field_username))))
      {
        ac localac;
        if (!this.KIV.containsKey(localan.field_username))
        {
          if (!com.tencent.mm.contact.c.lO(localan.field_type)) {
            break label397;
          }
          if (this.KIO)
          {
            localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(localan.field_username);
            if (localac == null) {
              ae.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { bu.bI(localan.field_username, "") });
            } else if ((localac.Bj(v.aAC())) && (c(localan))) {
              this.fRY.add(localan);
            }
          }
          else
          {
            if (!c(localan)) {
              break label397;
            }
            this.fRY.add(localan);
          }
        }
        else if (this.KIO)
        {
          localac = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(localan.field_username);
          if (localac == null) {
            ae.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { bu.bI(localan.field_username, "") });
          } else {
            if (!localac.Bj(v.aAC())) {
              break;
            }
          }
        }
        else if (c(localan))
        {
          a(i, localan, ((Long)this.KIV.get(localan.field_username)).longValue());
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
    this.KIT = ((ListView)findViewById(2131300626));
    this.KIU = new m(this, this.fRY, this.KIK, this.KIL);
    this.KIT.setAdapter(this.KIU);
    this.KIT.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37851);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        a.b("com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
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
        paramAnonymousAdapterView = (an)GroupCardSelectUI.d(GroupCardSelectUI.this).getItem(i);
        if (paramAnonymousAdapterView == null)
        {
          ae.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
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
    if (this.KIU.getCount() <= 0)
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
      if (this.KIP)
      {
        localListView = this.KIT;
        localView = z.jV(this).inflate(2131496466, null);
        ((TextView)localView.findViewById(2131298778)).setText(2131766520);
        localTextView = (TextView)localView.findViewById(2131308404);
        if (this.KIU.getCount() > 0) {
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
    this.KIM = getIntent().getBooleanExtra("group_select_type", true);
    this.KIN = getIntent().getBooleanExtra("group_select_need_result", false);
    this.KIO = getIntent().getBooleanExtra("group_select_only_need_self_owner", false);
    this.KIQ = getIntent().getStringArrayListExtra("group_select_block_chatroom");
    this.KIP = getIntent().getBooleanExtra("group_select_only_need_self_owner", false);
    this.KIR = getIntent().getIntExtra("group_select_chatroom_max_num", 2147483647);
    if ((this.KIO) && (!this.KIP))
    {
      setMMTitle(getString(2131755949));
      this.KIL = getIntent().getBooleanExtra("group_multi_select", false);
      if (this.KIL)
      {
        paramBundle = getIntent().getStringExtra("already_select_contact");
        if (!bu.isNullOrNil(paramBundle)) {
          break label262;
        }
      }
    }
    label262:
    for (this.KIK = new LinkedList();; this.KIK = af.j(paramBundle.split(",")))
    {
      this.KIS = getIntent().getIntExtra("max_limit_num", 0);
      fMs();
      initView();
      if (this.KIL)
      {
        addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(37853);
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Conv_User", bu.m(GroupCardSelectUI.f(GroupCardSelectUI.this), ","));
            GroupCardSelectUI.this.setResult(-1, paramAnonymousMenuItem);
            GroupCardSelectUI.this.finish();
            AppMethodBeat.o(37853);
            return true;
          }
        }, null, s.b.JwA);
        enableOptionMenu(1, true);
        Zv();
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
    TextView KIY;
    ImageView jgy;
    TextView vjx;
    CheckBox xdh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.GroupCardSelectUI
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI
  extends MMActivity
{
  private List<String> PVI = null;
  private boolean PVJ = false;
  private boolean PVK = true;
  private boolean PVL;
  private boolean PVM;
  private boolean PVN;
  private ArrayList<String> PVO;
  private int PVP;
  private int PVQ;
  private ListView PVR;
  private m PVS;
  private HashMap<String, Long> PVT;
  private TextView emptyTipTv;
  private List<as> gxh;
  
  private void a(int paramInt, as paramas, long paramLong)
  {
    AppMethodBeat.i(37860);
    int i = 0;
    while ((i < paramInt) && (paramLong <= ((Long)this.PVT.get(((as)this.gxh.get(i)).field_username)).longValue())) {
      i += 1;
    }
    this.gxh.add(i, paramas);
    AppMethodBeat.o(37860);
  }
  
  private void ani()
  {
    AppMethodBeat.i(37861);
    StringBuilder localStringBuilder;
    if (this.PVJ)
    {
      localStringBuilder = new StringBuilder().append(getString(2131755921));
      if (this.PVI.size() <= 0) {
        break label89;
      }
    }
    label89:
    for (String str = String.format("(%s)", new Object[] { Integer.valueOf(this.PVI.size()) });; str = "")
    {
      updateOptionMenuText(1, str);
      AppMethodBeat.o(37861);
      return;
    }
  }
  
  private boolean c(as paramas)
  {
    AppMethodBeat.i(234003);
    if (this.PVP == 2147483647)
    {
      AppMethodBeat.o(234003);
      return true;
    }
    if (paramas == null)
    {
      AppMethodBeat.o(234003);
      return false;
    }
    ah localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(paramas.field_username);
    if (localah == null)
    {
      Log.e("MicroMsg.GroupCardSelectUI", "isValidByMaxNum %s member is null", new Object[] { paramas.field_username });
      AppMethodBeat.o(234003);
      return false;
    }
    if (localah.field_memberCount < this.PVP)
    {
      AppMethodBeat.o(234003);
      return true;
    }
    AppMethodBeat.o(234003);
    return false;
  }
  
  private void gUM()
  {
    AppMethodBeat.i(37859);
    bg.aVF();
    this.PVT = com.tencent.mm.model.c.aST().gCt();
    this.gxh = new LinkedList();
    List localList = ab.aUV();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(37859);
      return;
    }
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      as localas = (as)localIterator.next();
      if ((!ab.Iz(localas.field_username)) && ((this.PVO == null) || (!this.PVO.contains(localas.field_username))))
      {
        ah localah;
        if (!this.PVT.containsKey(localas.field_username))
        {
          if (!com.tencent.mm.contact.c.oR(localas.field_type)) {
            break label397;
          }
          if (this.PVM)
          {
            localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(localas.field_username);
            if (localah == null) {
              Log.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { Util.nullAs(localas.field_username, "") });
            } else if ((localah.JO(z.aTY())) && (c(localas))) {
              this.gxh.add(localas);
            }
          }
          else
          {
            if (!c(localas)) {
              break label397;
            }
            this.gxh.add(localas);
          }
        }
        else if (this.PVM)
        {
          localah = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(localas.field_username);
          if (localah == null) {
            Log.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { Util.nullAs(localas.field_username, "") });
          } else {
            if (!localah.JO(z.aTY())) {
              break;
            }
          }
        }
        else if (c(localas))
        {
          a(i, localas, ((Long)this.PVT.get(localas.field_username)).longValue());
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
    return 2131494994;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37858);
    this.PVR = ((ListView)findViewById(2131302181));
    this.PVS = new m(this, this.gxh, this.PVI, this.PVJ);
    this.PVR.setAdapter(this.PVS);
    this.PVR.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37851);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/ui/contact/GroupCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
        paramAnonymousAdapterView = (as)GroupCardSelectUI.d(GroupCardSelectUI.this).getItem(i);
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
    this.emptyTipTv = ((TextView)findViewById(2131302177));
    ListView localListView;
    View localView;
    TextView localTextView;
    if (this.PVS.getCount() <= 0)
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
      if (this.PVN)
      {
        localListView = this.PVR;
        localView = aa.jQ(this).inflate(2131494997, null);
        ((TextView)localView.findViewById(2131299223)).setText(2131757232);
        localTextView = (TextView)localView.findViewById(2131306841);
        if (this.PVS.getCount() > 0) {
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
    this.PVK = getIntent().getBooleanExtra("group_select_type", true);
    this.PVL = getIntent().getBooleanExtra("group_select_need_result", false);
    this.PVM = getIntent().getBooleanExtra("group_select_only_need_self_owner", false);
    this.PVO = getIntent().getStringArrayListExtra("group_select_block_chatroom");
    this.PVN = getIntent().getBooleanExtra("group_select_show_create_new_group", false);
    this.PVP = getIntent().getIntExtra("group_select_chatroom_max_num", 2147483647);
    if ((this.PVM) && (!this.PVN))
    {
      setMMTitle(getString(2131755259));
      this.PVJ = getIntent().getBooleanExtra("group_multi_select", false);
      if (this.PVJ)
      {
        paramBundle = getIntent().getStringExtra("already_select_contact");
        if (!Util.isNullOrNil(paramBundle)) {
          break label263;
        }
      }
    }
    label263:
    for (this.PVI = new LinkedList();; this.PVI = af.k(paramBundle.split(",")))
    {
      this.PVQ = getIntent().getIntExtra("max_limit_num", 0);
      gUM();
      initView();
      if (this.PVJ)
      {
        addTextOptionMenu(1, getString(2131755921), new MenuItem.OnMenuItemClickListener()
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
        }, null, t.b.OGU);
        enableOptionMenu(1, true);
        ani();
      }
      AppMethodBeat.o(37854);
      return;
      setMMTitle(getString(2131755258));
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
    CheckBox BaJ;
    TextView PVW;
    ImageView keC;
    TextView yDA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.GroupCardSelectUI
 * JD-Core Version:    0.7.0.1
 */
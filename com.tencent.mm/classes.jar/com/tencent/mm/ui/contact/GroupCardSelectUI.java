package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.n.b;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI
  extends MMActivity
{
  private List<String> IvK = null;
  private boolean IvL = false;
  private boolean IvM = true;
  private boolean IvN;
  private boolean IvO;
  private ArrayList<String> IvP;
  private int IvQ;
  private int IvR;
  private ListView IvS;
  private m IvT;
  private HashMap<String, Long> IvU;
  private TextView emptyTipTv;
  private List<ai> fwF;
  
  private void WT()
  {
    AppMethodBeat.i(37861);
    StringBuilder localStringBuilder;
    if (this.IvL)
    {
      localStringBuilder = new StringBuilder().append(getString(2131755835));
      if (this.IvK.size() <= 0) {
        break label85;
      }
    }
    label85:
    for (String str = String.format("(%s)", new Object[] { Integer.valueOf(this.IvK.size()) });; str = "")
    {
      updateOptionMenuText(1, str);
      AppMethodBeat.o(37861);
      return;
    }
  }
  
  private void a(int paramInt, ai paramai, long paramLong)
  {
    AppMethodBeat.i(37860);
    int i = 0;
    while ((i < paramInt) && (paramLong <= ((Long)this.IvU.get(((ai)this.fwF.get(i)).field_username)).longValue())) {
      i += 1;
    }
    this.fwF.add(i, paramai);
    AppMethodBeat.o(37860);
  }
  
  private boolean c(ai paramai)
  {
    AppMethodBeat.i(196751);
    if (this.IvQ == 2147483647)
    {
      AppMethodBeat.o(196751);
      return true;
    }
    if (paramai == null)
    {
      AppMethodBeat.o(196751);
      return false;
    }
    x localx = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(paramai.field_username);
    if (localx == null)
    {
      ac.e("MicroMsg.GroupCardSelectUI", "isValidByMaxNum %s member is null", new Object[] { paramai.field_username });
      AppMethodBeat.o(196751);
      return false;
    }
    if (localx.field_memberCount < this.IvQ)
    {
      AppMethodBeat.o(196751);
      return true;
    }
    AppMethodBeat.o(196751);
    return false;
  }
  
  private void frn()
  {
    AppMethodBeat.i(37859);
    az.ayM();
    this.IvU = com.tencent.mm.model.c.awG().faJ();
    this.fwF = new LinkedList();
    List localList = w.ayi();
    if (localList.size() == 0)
    {
      AppMethodBeat.o(37859);
      return;
    }
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ai localai = (ai)localIterator.next();
      if ((!w.wr(localai.field_username)) && ((this.IvP == null) || (!this.IvP.contains(localai.field_username))))
      {
        x localx;
        if (!this.IvU.containsKey(localai.field_username))
        {
          if (!b.ln(localai.field_type)) {
            break label399;
          }
          if (this.IvO)
          {
            localx = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(localai.field_username);
            if (localx == null) {
              ac.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { bs.bG(localai.field_username, "") });
            } else if ((localx.xB(u.axw())) && (c(localai))) {
              this.fwF.add(localai);
            }
          }
          else
          {
            if (!c(localai)) {
              break label399;
            }
            this.fwF.add(localai);
          }
        }
        else if (this.IvO)
        {
          localx = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(localai.field_username);
          if (localx == null) {
            ac.e("MicroMsg.GroupCardSelectUI", "%s member is null", new Object[] { bs.bG(localai.field_username, "") });
          } else {
            if (!localx.xB(u.axw())) {
              break;
            }
          }
        }
        else if (c(localai))
        {
          a(i, localai, ((Long)this.IvU.get(localai.field_username)).longValue());
          i += 1;
        }
      }
    }
    label399:
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
    this.IvS = ((ListView)findViewById(2131300626));
    this.IvT = new m(this, this.fwF, this.IvK, this.IvL);
    this.IvS.setAdapter(this.IvT);
    this.IvS.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37851);
        paramAnonymousAdapterView = (ai)GroupCardSelectUI.a(GroupCardSelectUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ac.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
          AppMethodBeat.o(37851);
          return;
        }
        GroupCardSelectUI.a(GroupCardSelectUI.this, paramAnonymousAdapterView);
        GroupCardSelectUI.b(GroupCardSelectUI.this);
        AppMethodBeat.o(37851);
      }
    });
    this.emptyTipTv = ((TextView)findViewById(2131300622));
    if (this.IvT.getCount() <= 0) {
      this.emptyTipTv.setVisibility(0);
    }
    for (;;)
    {
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
      AppMethodBeat.o(37858);
      return;
      this.emptyTipTv.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37854);
    super.onCreate(paramBundle);
    this.IvM = getIntent().getBooleanExtra("group_select_type", true);
    this.IvN = getIntent().getBooleanExtra("group_select_need_result", false);
    this.IvO = getIntent().getBooleanExtra("group_select_only_need_self_owner", false);
    this.IvP = getIntent().getStringArrayListExtra("group_select_block_chatroom");
    this.IvQ = getIntent().getIntExtra("group_select_chatroom_max_num", 2147483647);
    if (this.IvO)
    {
      setMMTitle(getString(2131755949));
      this.IvL = getIntent().getBooleanExtra("group_multi_select", false);
      if (this.IvL)
      {
        paramBundle = getIntent().getStringExtra("already_select_contact");
        if (!bs.isNullOrNil(paramBundle)) {
          break label240;
        }
      }
    }
    label240:
    for (this.IvK = new LinkedList();; this.IvK = ae.j(paramBundle.split(",")))
    {
      this.IvR = getIntent().getIntExtra("max_limit_num", 0);
      frn();
      initView();
      if (this.IvL)
      {
        addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(37853);
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("Select_Conv_User", bs.n(GroupCardSelectUI.c(GroupCardSelectUI.this), ","));
            GroupCardSelectUI.this.setResult(-1, paramAnonymousMenuItem);
            GroupCardSelectUI.this.finish();
            AppMethodBeat.o(37853);
            return true;
          }
        }, null, s.b.Hom);
        enableOptionMenu(1, true);
        WT();
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
    TextView IvW;
    ImageView iKw;
    TextView tVh;
    CheckBox vGm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.GroupCardSelectUI
 * JD-Core Version:    0.7.0.1
 */
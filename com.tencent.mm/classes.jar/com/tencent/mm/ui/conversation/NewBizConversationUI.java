package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import java.util.Map;

public class NewBizConversationUI
  extends MMActivity
{
  private ListView Ahc;
  private String Ahe;
  private NewBizConversationUI.a AlA;
  private final int AlB;
  private int cnU;
  private ak conversation;
  private int cpt;
  private TextView emptyTipTv;
  private String fuO;
  private boolean isDeleteCancel;
  private int jUm;
  private int jUn;
  private com.tencent.mm.ui.widget.c.a jVd;
  private long jWX;
  private n.d jWw;
  private com.tencent.mm.sdk.b.c jXg;
  private String talker;
  private p tipDialog;
  
  public NewBizConversationUI()
  {
    AppMethodBeat.i(34558);
    this.cpt = 1;
    this.talker = "";
    this.jWX = 0L;
    this.jUm = 0;
    this.jUn = 0;
    this.AlB = 1;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.jWw = new NewBizConversationUI.9(this);
    this.jXg = new NewBizConversationUI.10(this);
    AppMethodBeat.o(34558);
  }
  
  public int getLayoutId()
  {
    return 2130971000;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34560);
    setActionbarColor(-1052684);
    setMMTitle(this.Ahe);
    setMMTitleColor(-16777216);
    setBackBtn(new NewBizConversationUI.12(this), 2131230737);
    setTitleBarDoubleClickListener(new NewBizConversationUI.13(this));
    this.Ahc = ((ListView)findViewById(2131823736));
    this.emptyTipTv = ((TextView)findViewById(2131821852));
    this.emptyTipTv.setText(2131299293);
    this.AlA = new NewBizConversationUI.a(this, this.fuO, new NewBizConversationUI.15(this));
    this.AlA.setGetViewPositionCallback(new NewBizConversationUI.16(this));
    this.AlA.setPerformItemClickListener(new NewBizConversationUI.17(this));
    this.Ahc.setAdapter(this.AlA);
    this.jVd = new com.tencent.mm.ui.widget.c.a(this);
    this.Ahc.setOnItemClickListener(new NewBizConversationUI.18(this));
    this.Ahc.setOnTouchListener(new NewBizConversationUI.2(this));
    this.Ahc.setOnItemLongClickListener(new NewBizConversationUI.3(this));
    this.AlA.setGetViewPositionCallback(new NewBizConversationUI.4(this));
    this.AlA.setPerformItemClickListener(new NewBizConversationUI.5(this));
    this.AlA.a(new NewBizConversationUI.6(this));
    AppMethodBeat.o(34560);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34565);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(34565);
      return;
    }
    AppMethodBeat.o(34565);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34559);
    super.onCreate(paramBundle);
    if (!aw.RG())
    {
      ab.e("MicroMsg.NewBizConversationUI", "onCreate acc not ready!!!");
      finish();
      AppMethodBeat.o(34559);
      return;
    }
    this.cnU = getIntent().getIntExtra("biz_time_line_line_session_id", 0);
    this.cpt = getIntent().getIntExtra("biz_enter_source", 1);
    this.fuO = "officialaccounts";
    h.qsU.e(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.cnU), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.cpt), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    this.Ahe = getIntent().getStringExtra("enterprise_biz_display_name");
    if (bo.isNullOrNil(this.Ahe)) {
      this.Ahe = getString(2131297675);
    }
    initView();
    paramBundle = com.tencent.mm.model.c.c.abU().me("100045");
    if ((paramBundle.isValid()) && ("1".equals(paramBundle.dvN().get("isOpenSearch")))) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.NewBizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        addIconOptionMenu(1, 2131304318, 2131230741, new NewBizConversationUI.1(this));
      }
      addIconOptionMenu(0, getString(2131297718), 2131230740, new NewBizConversationUI.11(this));
      aw.aaz();
      com.tencent.mm.model.c.YF().a(this.AlA);
      this.jWX = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.ymk.c(this.jXg);
      AppMethodBeat.o(34559);
      return;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(34566);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    aw.aaz();
    ad localad = com.tencent.mm.model.c.YA().arw(this.talker);
    if (localad == null)
    {
      ab.e("MicroMsg.NewBizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(34566);
      return;
    }
    String str = localad.Of();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (bo.isNullOrNil(localad.field_nickname)) {
        paramView = getString(2131298302);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(j.b(this, paramView));
    if (com.tencent.mm.n.a.je(localad.field_type))
    {
      if (!localad.Oa()) {
        break label205;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131297674);
    }
    for (;;)
    {
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131301402);
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131301410);
      AppMethodBeat.o(34566);
      return;
      label205:
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131297673);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34561);
    aw.RO().ac(new NewBizConversationUI.14(this));
    com.tencent.mm.sdk.b.a.ymk.d(this.jXg);
    if (aw.RG())
    {
      aw.aaz();
      com.tencent.mm.model.c.YF().b(this.AlA);
    }
    if (this.AlA != null) {
      this.AlA.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(34561);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34563);
    ab.i("MicroMsg.NewBizConversationUI", "on pause");
    if (this.AlA != null) {
      this.AlA.onPause();
    }
    super.onPause();
    AppMethodBeat.o(34563);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34562);
    ab.v("MicroMsg.NewBizConversationUI", "on resume");
    if (this.AlA != null) {
      this.AlA.onResume();
    }
    super.onResume();
    AppMethodBeat.o(34562);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI
 * JD-Core Version:    0.7.0.1
 */
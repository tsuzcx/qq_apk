package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class NearbySayHiListUI
  extends MMActivity
  implements f
{
  private int eeH;
  private ListView gvV;
  private View gyT;
  private n.d jSn;
  private int limit;
  private c pcJ;
  private bg pdK;
  private NearbySayHiListUI.a pdL;
  private int pdM;
  private int pdN;
  private boolean pdO;
  private long pdP;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public NearbySayHiListUI()
  {
    AppMethodBeat.i(55513);
    this.pdK = null;
    this.limit = 0;
    this.pdM = 0;
    this.pdN = 0;
    this.eeH = 0;
    this.tipDialog = null;
    this.jSn = new NearbySayHiListUI.3(this);
    AppMethodBeat.o(55513);
  }
  
  public int getLayoutId()
  {
    return 2130969979;
  }
  
  public void initView()
  {
    AppMethodBeat.i(55519);
    this.gvV = ((ListView)findViewById(2131825413));
    if (!com.tencent.mm.bo.a.dkM())
    {
      localObject = getLayoutInflater().inflate(2130970596, null);
      ((View)localObject).setOnClickListener(new NearbySayHiListUI.1(this, (View)localObject));
      if ((this.pdM > 0) && (this.limit < this.pdM)) {
        this.gvV.addFooterView((View)localObject);
      }
    }
    addTextOptionMenu(0, getString(2131296891), new NearbySayHiListUI.5(this));
    if (this.pdM == 0)
    {
      localObject = (TextView)findViewById(2131821852);
      ((TextView)localObject).setText(2131302880);
      ((TextView)localObject).setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.pdO) && (this.eeH != 0) && (this.pdN >= this.eeH) && (bo.hl(this)))
    {
      this.gyT = new CleanLocationHeaderView(this);
      this.gyT.setOnClickListener(new NearbySayHiListUI.6(this));
      this.gvV.addHeaderView(this.gyT);
    }
    this.pdL = new NearbySayHiListUI.a(this, this, this.pdK, this.limit);
    this.pdL.setGetViewPositionCallback(new NearbySayHiListUI.7(this));
    this.pdL.setPerformItemClickListener(new NearbySayHiListUI.8(this));
    this.pdL.a(new NearbySayHiListUI.9(this));
    this.gvV.setAdapter(this.pdL);
    Object localObject = new l(this);
    this.gvV.setOnItemLongClickListener(new NearbySayHiListUI.10(this, (l)localObject));
    this.gvV.setOnItemClickListener(new NearbySayHiListUI.11(this));
    setBackBtn(new NearbySayHiListUI.12(this));
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(55494);
        BackwardSupportUtil.c.a(NearbySayHiListUI.d(NearbySayHiListUI.this));
        AppMethodBeat.o(55494);
      }
    });
    AppMethodBeat.o(55519);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(55521);
    setResult(0);
    super.onBackPressed();
    AppMethodBeat.o(55521);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55514);
    super.onCreate(paramBundle);
    this.eeH = bo.apV(com.tencent.mm.m.g.Nq().getValue("ThresholdToCleanLocation"));
    this.pdO = getIntent().getBooleanExtra("show_clear_header", false);
    com.tencent.mm.kernel.g.RJ().QQ();
    this.pdK = ((bg)((j)com.tencent.mm.kernel.g.E(j.class)).bPN());
    setMMTitle(2131302877);
    this.pdN = this.pdK.bbZ();
    this.pdM = this.pdK.getCount();
    int i;
    if (com.tencent.mm.bo.a.dkM()) {
      i = this.pdM;
    }
    for (;;)
    {
      this.limit = i;
      paramBundle = this.pdK;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      AppMethodBeat.o(55514);
      return;
      if (this.pdN == 0) {
        i = 8;
      } else {
        i = this.pdN;
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(55520);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (bf)this.pdL.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      ab.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + paramView.position);
      AppMethodBeat.o(55520);
      return;
    }
    paramContextMenu.add(0, 0, 0, 2131296901);
    this.pdP = paramContextMenuInfo.field_svrid;
    AppMethodBeat.o(55520);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55516);
    this.pdL.bKb();
    super.onDestroy();
    AppMethodBeat.o(55516);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(55518);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(55518);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(55517);
    com.tencent.mm.kernel.g.Rc().b(148, this);
    super.onPause();
    AppMethodBeat.o(55517);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(55515);
    super.onResume();
    if (this.pdM != this.pdK.getCount())
    {
      this.pdM = this.pdK.getCount();
      if (this.pdM == 0)
      {
        TextView localTextView = (TextView)findViewById(2131821852);
        localTextView.setText(2131302880);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.pdL.Ku();
    }
    this.pdL.notifyDataSetChanged();
    com.tencent.mm.kernel.g.Rc().a(148, this);
    AppMethodBeat.o(55515);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(55522);
    ab.i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (((c)paramm).Ac() == 2)
      {
        h.a(getContext(), getString(2131301751), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(55496);
            NearbySayHiListUI.this.setResult(-1);
            NearbySayHiListUI.this.finish();
            AppMethodBeat.o(55496);
          }
        });
        this.pcJ = null;
        AppMethodBeat.o(55522);
      }
    }
    else {
      ab.w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
    }
    AppMethodBeat.o(55522);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI
 * JD-Core Version:    0.7.0.1
 */
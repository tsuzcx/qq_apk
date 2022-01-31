package com.tencent.mm.plugin.nearby.ui;

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
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.plugin.nearby.b.d;
import com.tencent.mm.plugin.nearby.b.e;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

public class NearbySayHiListUI
  extends MMActivity
  implements f
{
  private int dng = 0;
  private ListView fem;
  private View fhl;
  private n.d hZq = new NearbySayHiListUI.3(this);
  private int limit = 0;
  private c mCP;
  private bg mDI = null;
  private NearbySayHiListUI.a mDJ;
  private int mDK = 0;
  private int mDL = 0;
  private boolean mDM;
  private long mDN;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  protected final int getLayoutId()
  {
    return b.e.lbs_say_hi_list;
  }
  
  protected final void initView()
  {
    this.fem = ((ListView)findViewById(b.d.say_hi_lv));
    if (!com.tencent.mm.bp.a.cki())
    {
      localObject = getLayoutInflater().inflate(b.e.say_hi_list_footer, null);
      ((View)localObject).setOnClickListener(new NearbySayHiListUI.1(this, (View)localObject));
      if ((this.mDK > 0) && (this.limit < this.mDK)) {
        this.fem.addFooterView((View)localObject);
      }
    }
    addTextOptionMenu(0, getString(b.h.app_clear), new NearbySayHiListUI.5(this));
    if (this.mDK == 0)
    {
      localObject = (TextView)findViewById(b.d.empty_msg_tip_tv);
      ((TextView)localObject).setText(b.h.say_hi_non);
      ((TextView)localObject).setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.mDM) && (this.dng != 0) && (this.mDL >= this.dng) && (bk.fV(this)))
    {
      this.fhl = new CleanLocationHeaderView(this);
      this.fhl.setOnClickListener(new NearbySayHiListUI.6(this));
      this.fem.addHeaderView(this.fhl);
    }
    this.mDJ = new NearbySayHiListUI.a(this, this, this.mDI, this.limit);
    this.mDJ.setGetViewPositionCallback(new NearbySayHiListUI.7(this));
    this.mDJ.setPerformItemClickListener(new NearbySayHiListUI.8(this));
    this.mDJ.a(new NearbySayHiListUI.9(this));
    this.fem.setAdapter(this.mDJ);
    Object localObject = new com.tencent.mm.ui.tools.j(this);
    this.fem.setOnItemLongClickListener(new NearbySayHiListUI.10(this, (com.tencent.mm.ui.tools.j)localObject));
    this.fem.setOnItemClickListener(new NearbySayHiListUI.11(this));
    setBackBtn(new NearbySayHiListUI.12(this));
    new NearbySayHiListUI.2(this);
  }
  
  public void onBackPressed()
  {
    setResult(0);
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.dng = bk.ZR(com.tencent.mm.m.g.AA().getValue("ThresholdToCleanLocation"));
    this.mDM = getIntent().getBooleanExtra("show_clear_header", false);
    com.tencent.mm.kernel.g.DN().CX();
    this.mDI = ((bg)((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhL());
    setMMTitle(b.h.say_hi_list_lbs_title);
    this.mDL = this.mDI.aAo();
    this.mDK = this.mDI.getCount();
    int i;
    if (com.tencent.mm.bp.a.cki()) {
      i = this.mDK;
    }
    for (;;)
    {
      this.limit = i;
      paramBundle = this.mDI;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.dXw.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      return;
      if (this.mDL == 0) {
        i = 8;
      } else {
        i = this.mDL;
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (bf)this.mDJ.getItem(paramView.position);
    if (paramContextMenuInfo == null)
    {
      y.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + paramView.position);
      return;
    }
    paramContextMenu.add(0, 0, 0, b.h.app_delete);
    this.mDN = paramContextMenuInfo.field_svrid;
  }
  
  public void onDestroy()
  {
    this.mDJ.bcS();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    com.tencent.mm.kernel.g.Dk().b(148, this);
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.mDK != this.mDI.getCount())
    {
      this.mDK = this.mDI.getCount();
      if (this.mDK == 0)
      {
        TextView localTextView = (TextView)findViewById(b.d.empty_msg_tip_tv);
        localTextView.setText(b.h.say_hi_non);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.mDJ.yc();
    }
    this.mDJ.notifyDataSetChanged();
    com.tencent.mm.kernel.g.Dk().a(148, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (((c)paramm).rN() == 2)
      {
        h.a(this.mController.uMN, getString(b.h.nearby_friend_clear_location_ok), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            NearbySayHiListUI.this.setResult(-1);
            NearbySayHiListUI.this.finish();
          }
        });
        this.mCP = null;
      }
      return;
    }
    y.w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI
 * JD-Core Version:    0.7.0.1
 */
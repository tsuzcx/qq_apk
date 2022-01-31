package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.n;
import java.util.ArrayList;
import java.util.List;

public class MailAddrListUI
  extends MMActivity
{
  private TextView fiv = null;
  private com.tencent.mm.plugin.qqmail.b.p nem = null;
  private com.tencent.mm.ui.base.p nhU = null;
  private TextView nhV = null;
  private ListView nhW;
  private MailAddrListUI.a nhX;
  private List<o> nhY;
  private p.a nhZ = new MailAddrListUI.1(this);
  
  protected final int getLayoutId()
  {
    return b.g.qqmail_addrlist;
  }
  
  protected final void initView()
  {
    this.nhW = ((ListView)findViewById(b.f.qqmail_addrlist_lv));
    this.fiv = ((TextView)findViewById(b.f.empty_tip_tv));
    this.nhV = ((TextView)findViewById(b.f.nofind_tip_tv));
    this.nhX = new MailAddrListUI.a(this, this);
    Object localObject = new n((byte)0);
    ((n)localObject).weq = new MailAddrListUI.2(this);
    a((n)localObject);
    this.nhW.setAdapter(this.nhX);
    this.nhW.setOnItemClickListener(new MailAddrListUI.3(this));
    this.nhW.setOnScrollListener(new MailAddrListUI.4(this));
    this.nhY = this.nem.Li(null);
    this.nhX.notifyDataSetChanged();
    setBackBtn(new MailAddrListUI.5(this));
    new MailAddrListUI.6(this);
    addTextOptionMenu(0, getString(b.j.plugin_qqmail_addrlist_choose), new MailAddrListUI.7(this));
    if (!this.nhY.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(bool);
      localObject = this.mController.uMN;
      getString(b.j.app_tip);
      this.nhU = h.b((Context)localObject, getString(b.j.plugin_qqmail_addressui_sync_dlg), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(b.j.plugin_qqmail_addrlist_title);
    this.nhY = new ArrayList();
    this.nem = ac.btF().nem;
    initView();
    this.nem.a(this.nhZ);
    this.nem.btu();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.nem.b(this.nhZ);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.nhX.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI
 * JD-Core Version:    0.7.0.1
 */
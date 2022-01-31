package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.qqmail.b.f;
import com.tencent.mm.plugin.qqmail.b.g;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.plugin.qqmail.b.v.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CompressPreviewUI
  extends MMActivity
{
  private ProgressBar hJa;
  private TextView kDb;
  private String nds = null;
  private String neg = null;
  private String nfJ;
  private long ngY = 0L;
  private List<CompressPreviewUI.a> ngZ = new ArrayList();
  private c ngi = new c(this);
  private String nha;
  private ListView nhb;
  private CompressPreviewUI.b nhc;
  private v.a nhd = new CompressPreviewUI.5(this);
  
  private void Lp(String paramString)
  {
    y.i("MicroMsg.CompressPreviewUI", "curPath=" + paramString);
    this.hJa.setVisibility(8);
    this.kDb.setVisibility(8);
    this.nhb.setVisibility(0);
    CompressPreviewUI.a locala1 = Lq(paramString);
    ArrayList localArrayList = new ArrayList();
    if (locala1 != null) {
      localArrayList.add(locala1);
    }
    int i = 0;
    while (i < this.ngZ.size())
    {
      CompressPreviewUI.a locala2 = (CompressPreviewUI.a)this.ngZ.get(i);
      if (((paramString.endsWith(locala2.nhg)) && (locala2.nhg.length() > 0)) || (locala2.nhg.equals(paramString))) {
        localArrayList.add(locala2);
      }
      i += 1;
    }
    paramString = this.nhc;
    paramString.nhh = locala1;
    paramString.nhi = localArrayList;
    this.nhc.notifyDataSetChanged();
    this.nhb.setSelection(0);
  }
  
  private CompressPreviewUI.a Lq(String paramString)
  {
    Iterator localIterator = this.ngZ.iterator();
    while (localIterator.hasNext())
    {
      CompressPreviewUI.a locala = (CompressPreviewUI.a)localIterator.next();
      if (locala.id.equals(paramString)) {
        return locala;
      }
    }
    return null;
  }
  
  private void btX()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.nds);
    localHashMap.put("attachid", this.neg);
    localHashMap.put("fun", "list");
    v localv = ac.btF();
    v.a locala = this.nhd;
    localv.a("/cgi-bin/viewcompress", localHashMap, new v.c(), locala);
  }
  
  protected final int getLayoutId()
  {
    return b.g.mail_compress_preview_ui;
  }
  
  protected final void initView()
  {
    this.nhb = ((ListView)findViewById(b.f.compress_preview_lv));
    this.kDb = ((TextView)findViewById(b.f.compress_preview_info_tv));
    this.hJa = ((ProgressBar)findViewById(b.f.compress_preview_loading_pb));
    if ((this.nds == null) || (this.neg == null))
    {
      this.hJa.setVisibility(8);
      this.kDb.setText(b.j.mail_compress_preview_err_hint);
      return;
    }
    this.nhc = new CompressPreviewUI.b(this, (byte)0);
    this.nhb.setAdapter(this.nhc);
    this.nhb.setOnItemClickListener(new CompressPreviewUI.1(this));
    setBackBtn(new CompressPreviewUI.2(this));
    new CompressPreviewUI.3(this);
    addTextOptionMenu(0, getString(b.j.app_download), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuItem = new Intent(CompressPreviewUI.this, AttachDownloadPage.class);
        paramAnonymousMenuItem.putExtra("attach_name", CompressPreviewUI.e(CompressPreviewUI.this));
        paramAnonymousMenuItem.putExtra("mail_id", CompressPreviewUI.b(CompressPreviewUI.this));
        paramAnonymousMenuItem.putExtra("attach_id", CompressPreviewUI.f(CompressPreviewUI.this));
        paramAnonymousMenuItem.putExtra("total_size", CompressPreviewUI.g(CompressPreviewUI.this));
        paramAnonymousMenuItem.putExtra("is_preview", 0);
        paramAnonymousMenuItem.putExtra("is_compress", true);
        CompressPreviewUI.this.startActivity(paramAnonymousMenuItem);
        return true;
      }
    });
    btX();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.nds = getIntent().getStringExtra("mail_id");
    this.neg = getIntent().getStringExtra("attach_id");
    this.ngY = getIntent().getLongExtra("attach_size", 0L);
    this.nfJ = getIntent().getStringExtra("attach_name");
    initView();
    setMMTitle(this.nfJ);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.ngi.release();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.nhc.btZ() != null))
    {
      Lp(this.nhc.btZ());
      return true;
    }
    if (paramKeyEvent == null)
    {
      finish();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI
 * JD-Core Version:    0.7.0.1
 */
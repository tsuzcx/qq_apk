package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CompressPreviewUI
  extends MMActivity
{
  private ProgressBar jCA;
  private TextView mYX;
  private String pIJ;
  private String pJw;
  private String pKY;
  private c pLx;
  private long pMm;
  private List<CompressPreviewUI.a> pMn;
  private String pMo;
  private ListView pMp;
  private CompressPreviewUI.b pMq;
  private v.a pMr;
  
  public CompressPreviewUI()
  {
    AppMethodBeat.i(68251);
    this.pIJ = null;
    this.pJw = null;
    this.pMm = 0L;
    this.pLx = new c(this);
    this.pMn = new ArrayList();
    this.pMr = new CompressPreviewUI.5(this);
    AppMethodBeat.o(68251);
  }
  
  private CompressPreviewUI.a XA(String paramString)
  {
    AppMethodBeat.i(68257);
    Iterator localIterator = this.pMn.iterator();
    while (localIterator.hasNext())
    {
      CompressPreviewUI.a locala = (CompressPreviewUI.a)localIterator.next();
      if (locala.id.equals(paramString))
      {
        AppMethodBeat.o(68257);
        return locala;
      }
    }
    AppMethodBeat.o(68257);
    return null;
  }
  
  private void Xz(String paramString)
  {
    AppMethodBeat.i(68256);
    ab.i("MicroMsg.CompressPreviewUI", "curPath=".concat(String.valueOf(paramString)));
    this.jCA.setVisibility(8);
    this.mYX.setVisibility(8);
    this.pMp.setVisibility(0);
    CompressPreviewUI.a locala1 = XA(paramString);
    ArrayList localArrayList = new ArrayList();
    if (locala1 != null) {
      localArrayList.add(locala1);
    }
    int i = 0;
    while (i < this.pMn.size())
    {
      CompressPreviewUI.a locala2 = (CompressPreviewUI.a)this.pMn.get(i);
      if (((paramString.endsWith(locala2.pMu)) && (locala2.pMu.length() > 0)) || (locala2.pMu.equals(paramString))) {
        localArrayList.add(locala2);
      }
      i += 1;
    }
    this.pMq.a(locala1, localArrayList);
    this.pMq.notifyDataSetChanged();
    this.pMp.setSelection(0);
    AppMethodBeat.o(68256);
  }
  
  private void cej()
  {
    AppMethodBeat.i(68258);
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.pIJ);
    localHashMap.put("attachid", this.pJw);
    localHashMap.put("fun", "list");
    ac.cdQ().a("/cgi-bin/viewcompress", localHashMap, this.pMr);
    AppMethodBeat.o(68258);
  }
  
  public int getLayoutId()
  {
    return 2130970062;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68253);
    this.pMp = ((ListView)findViewById(2131825866));
    this.mYX = ((TextView)findViewById(2131825867));
    this.jCA = ((ProgressBar)findViewById(2131825868));
    if ((this.pIJ == null) || (this.pJw == null))
    {
      this.jCA.setVisibility(8);
      this.mYX.setText(2131301387);
      AppMethodBeat.o(68253);
      return;
    }
    this.pMq = new CompressPreviewUI.b(this, (byte)0);
    this.pMp.setAdapter(this.pMq);
    this.pMp.setOnItemClickListener(new CompressPreviewUI.1(this));
    setBackBtn(new CompressPreviewUI.2(this));
    setToTop(new CompressPreviewUI.3(this));
    addTextOptionMenu(0, getString(2131296907), new CompressPreviewUI.4(this));
    cej();
    AppMethodBeat.o(68253);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68252);
    super.onCreate(paramBundle);
    this.pIJ = getIntent().getStringExtra("mail_id");
    this.pJw = getIntent().getStringExtra("attach_id");
    this.pMm = getIntent().getLongExtra("attach_size", 0L);
    this.pKY = getIntent().getStringExtra("attach_name");
    initView();
    setMMTitle(this.pKY);
    AppMethodBeat.o(68252);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68254);
    super.onDestroy();
    this.pLx.release();
    AppMethodBeat.o(68254);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68255);
    if ((paramInt == 4) && (this.pMq.cel() != null))
    {
      Xz(this.pMq.cel());
      AppMethodBeat.o(68255);
      return true;
    }
    if (paramKeyEvent == null)
    {
      finish();
      AppMethodBeat.o(68255);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(68255);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI
 * JD-Core Version:    0.7.0.1
 */
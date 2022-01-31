package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.hx;
import com.tencent.mm.h.a.hx.b;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class SnsLabelContactListUI
  extends MMActivity
{
  private ListView lBK;
  private bto ojd;
  private SnsLabelContactListUI.a vNP;
  private ArrayList<String> vNQ = new ArrayList();
  private int vNR;
  private String vNS;
  private SnsLabelContactListUI.b vNT;
  
  private void cHS()
  {
    Iterator localIterator;
    if (this.ojd.ttI == 3)
    {
      this.vNS = getString(R.l.sns_label_can_not_see);
      localIterator = this.ojd.tKj.iterator();
      while (localIterator.hasNext()) {
        this.vNQ.add(((bml)localIterator.next()).tFO);
      }
    }
    if (this.ojd.ttI == 5)
    {
      this.vNS = getString(R.l.sns_label_can_see);
      localIterator = this.ojd.tsx.iterator();
      while (localIterator.hasNext()) {
        this.vNQ.add(((bml)localIterator.next()).tFO);
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.address;
  }
  
  protected final void initView()
  {
    setMMTitle(this.vNS);
    findViewById(R.h.loading_tips_area).setVisibility(8);
    this.lBK = ((ListView)findViewById(R.h.address_contactlist));
    ((TextView)findViewById(R.h.empty_blacklist_tip_tv)).setVisibility(8);
    findViewById(R.h.address_scrollbar).setVisibility(8);
    this.lBK.setBackgroundColor(getResources().getColor(R.e.white));
    ((View)this.lBK.getParent()).setBackgroundColor(getResources().getColor(R.e.white));
    setBackBtn(new SnsLabelContactListUI.1(this));
    showOptionMenu(false);
    if ((this.vNQ != null) && (this.vNQ.size() != 0))
    {
      this.vNP = new SnsLabelContactListUI.a(this, this.vNQ);
      this.lBK.setAdapter(this.vNP);
      this.lBK.setVisibility(0);
      this.lBK.setOnItemClickListener(new SnsLabelContactListUI.2(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.vNT = new SnsLabelContactListUI.b(this, (byte)0);
    a.udP.c(this.vNT);
    this.vNR = getIntent().getIntExtra("sns_label_sns_info", -1);
    if (this.vNR == -1) {
      finish();
    }
    do
    {
      return;
      paramBundle = new hx();
      paramBundle.bPV.bLK = this.vNR;
      a.udP.m(paramBundle);
      this.ojd = paramBundle.bPW.bPX;
    } while ((this.ojd == null) || (((this.ojd.ttI != 3) || (this.ojd.tKj == null) || (this.ojd.tKj.size() <= 0)) && ((this.ojd.ttI != 5) || (this.ojd.tsx == null) || (this.ojd.tsx.size() <= 0))));
    cHS();
    initView();
  }
  
  protected void onDestroy()
  {
    a.udP.d(this.vNT);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.vNP != null) {
      this.vNP.notifyDataSetChanged();
    }
  }
  
  private static final class c
  {
    TextView drB;
    MaskLayout dsk;
    TextView lvb;
    TextView vNZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsLabelContactListUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.g.a.ib.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class SnsLabelContactListUI
  extends MMActivity
{
  private String AfA;
  private SnsLabelContactListUI.b AfB;
  private SnsLabelContactListUI.a Afx;
  private ArrayList<String> Afy;
  private int Afz;
  private ListView nYW;
  private SnsObject qXo;
  
  public SnsLabelContactListUI()
  {
    AppMethodBeat.i(33948);
    this.Afy = new ArrayList();
    AppMethodBeat.o(33948);
  }
  
  private void dMm()
  {
    AppMethodBeat.i(33950);
    Iterator localIterator;
    if (this.qXo.ExtFlag == 3)
    {
      this.AfA = getString(2131303842);
      localIterator = this.qXo.BlackList.iterator();
      while (localIterator.hasNext()) {
        this.Afy.add(((bwc)localIterator.next()).xJE);
      }
      AppMethodBeat.o(33950);
      return;
    }
    if (this.qXo.ExtFlag == 5)
    {
      this.AfA = getString(2131303843);
      localIterator = this.qXo.GroupUser.iterator();
      while (localIterator.hasNext()) {
        this.Afy.add(((bwc)localIterator.next()).xJE);
      }
    }
    AppMethodBeat.o(33950);
  }
  
  public int getLayoutId()
  {
    return 2130968639;
  }
  
  public void initView()
  {
    AppMethodBeat.i(33951);
    setMMTitle(this.AfA);
    findViewById(2131828467).setVisibility(8);
    this.nYW = ((ListView)findViewById(2131821074));
    ((TextView)findViewById(2131821076)).setVisibility(8);
    findViewById(2131821077).setVisibility(8);
    this.nYW.setBackgroundColor(getResources().getColor(2131690709));
    ((View)this.nYW.getParent()).setBackgroundColor(getResources().getColor(2131690709));
    setBackBtn(new SnsLabelContactListUI.1(this));
    showOptionMenu(false);
    if ((this.Afy != null) && (this.Afy.size() != 0))
    {
      this.Afx = new SnsLabelContactListUI.a(this, this.Afy);
      this.nYW.setAdapter(this.Afx);
      this.nYW.setVisibility(0);
      this.nYW.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(33939);
          paramAnonymousView = new Intent();
          paramAnonymousAdapterView = (com.tencent.mm.n.a)SnsLabelContactListUI.a(SnsLabelContactListUI.this).getItem(paramAnonymousInt);
          h localh = com.tencent.mm.plugin.sns.b.n.raV;
          if (localh == null)
          {
            SnsLabelContactListUI.this.finish();
            AppMethodBeat.o(33939);
            return;
          }
          paramAnonymousView = localh.e(paramAnonymousView, paramAnonymousAdapterView.field_username);
          if (paramAnonymousView == null)
          {
            SnsLabelContactListUI.this.finish();
            AppMethodBeat.o(33939);
            return;
          }
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView.field_username);
          WorkerProfile.BW().bZM.c(paramAnonymousView, SnsLabelContactListUI.this);
          AppMethodBeat.o(33939);
        }
      });
    }
    AppMethodBeat.o(33951);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33949);
    super.onCreate(paramBundle);
    this.AfB = new SnsLabelContactListUI.b(this, (byte)0);
    com.tencent.mm.sdk.b.a.ymk.c(this.AfB);
    this.Afz = getIntent().getIntExtra("sns_label_sns_info", -1);
    if (this.Afz == -1)
    {
      finish();
      AppMethodBeat.o(33949);
      return;
    }
    paramBundle = new ib();
    paramBundle.cxo.cte = this.Afz;
    com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
    this.qXo = paramBundle.cxp.cxq;
    if ((this.qXo != null) && (((this.qXo.ExtFlag == 3) && (this.qXo.BlackList != null) && (this.qXo.BlackList.size() > 0)) || ((this.qXo.ExtFlag == 5) && (this.qXo.GroupUser != null) && (this.qXo.GroupUser.size() > 0))))
    {
      dMm();
      initView();
    }
    AppMethodBeat.o(33949);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33953);
    com.tencent.mm.sdk.b.a.ymk.d(this.AfB);
    super.onDestroy();
    AppMethodBeat.o(33953);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33952);
    super.onResume();
    if (this.Afx != null) {
      this.Afx.notifyDataSetChanged();
    }
    AppMethodBeat.o(33952);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsLabelContactListUI
 * JD-Core Version:    0.7.0.1
 */
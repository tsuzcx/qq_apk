package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.a.l;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class BizChatSearchUI
  extends MMActivity
  implements b.a, BizChatSearchListView.a
{
  b jTZ;
  String jUE;
  private AbsListView.OnScrollListener nvS;
  private int scene;
  private String ztC;
  private BizChatSearchUI.c ztD;
  private BizChatSearchListView ztE;
  private TextView ztF;
  private BizChatSearchUI.a ztG;
  
  public BizChatSearchUI()
  {
    AppMethodBeat.i(30159);
    this.nvS = new AbsListView.OnScrollListener()
    {
      boolean jTN = false;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          this.jTN = true;
          return;
        }
        this.jTN = false;
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(30135);
        if ((paramAnonymousInt == 0) && (this.jTN) && (BizChatSearchUI.a(BizChatSearchUI.this).ztV))
        {
          paramAnonymousAbsListView = BizChatSearchUI.a(BizChatSearchUI.this);
          if ((paramAnonymousAbsListView.dEZ()) && (!paramAnonymousAbsListView.ztX))
          {
            paramAnonymousAbsListView.ztX = true;
            l locall = new l(paramAnonymousAbsListView.jUE, paramAnonymousAbsListView.ejd, paramAnonymousAbsListView.zub);
            aw.Rc().a(locall, 0);
            paramAnonymousAbsListView.dFd();
          }
        }
        AppMethodBeat.o(30135);
      }
    };
    AppMethodBeat.o(30159);
  }
  
  private void OY(int paramInt)
  {
    AppMethodBeat.i(30173);
    if (this.ztD != null) {
      this.ztD.sb(paramInt);
    }
    AppMethodBeat.o(30173);
  }
  
  public final void a(BizChatSearchUI.a parama)
  {
    AppMethodBeat.i(30163);
    if (BizChatSearchUI.a.c(parama))
    {
      if (bo.isNullOrNil(BizChatSearchUI.a.d(parama)))
      {
        this.ztF.setVisibility(8);
        this.ztE.setVisibility(8);
        AppMethodBeat.o(30163);
        return;
      }
      if (parama.getCount() <= 0)
      {
        this.ztF.setVisibility(0);
        this.ztE.setVisibility(8);
        AppMethodBeat.o(30163);
        return;
      }
      this.ztF.setVisibility(8);
      this.ztE.setVisibility(0);
      AppMethodBeat.o(30163);
      return;
    }
    if (bo.isNullOrNil(BizChatSearchUI.a.d(parama)))
    {
      this.ztF.setVisibility(0);
      this.ztF.setText("");
      this.ztE.setVisibility(8);
    }
    while (BizChatSearchUI.a.b(parama)) {
      if (parama.ztX)
      {
        OY(1);
        AppMethodBeat.o(30163);
        return;
        if ((BizChatSearchUI.a.b(parama)) && (parama.ztW))
        {
          this.ztF.setVisibility(0);
          this.ztF.setText(2131297758);
          this.ztE.setVisibility(8);
        }
        else if ((BizChatSearchUI.a.b(parama)) && (parama.zua))
        {
          this.ztF.setVisibility(0);
          this.ztF.setText(2131297759);
          this.ztE.setVisibility(8);
        }
        else if (parama.getCount() <= 0)
        {
          this.ztF.setVisibility(0);
          this.ztF.setText(f.a(getString(2131302982), getString(2131302981), d.b(BizChatSearchUI.a.d(parama), BizChatSearchUI.a.d(parama))).mSp);
          this.ztE.setVisibility(8);
        }
        else
        {
          this.ztF.setVisibility(8);
          this.ztE.setVisibility(0);
        }
      }
      else
      {
        if (parama.ztV)
        {
          OY(2);
          AppMethodBeat.o(30163);
          return;
        }
        OY(0);
      }
    }
    AppMethodBeat.o(30163);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final boolean aWA()
  {
    AppMethodBeat.i(30172);
    hideVKB();
    AppMethodBeat.o(30172);
    return false;
  }
  
  public final void anc()
  {
    AppMethodBeat.i(30167);
    hideVKB();
    AppMethodBeat.o(30167);
  }
  
  public final void apN()
  {
    AppMethodBeat.i(30164);
    finish();
    AppMethodBeat.o(30164);
  }
  
  public final void apO() {}
  
  public final void apP() {}
  
  public final void apQ() {}
  
  public int getLayoutId()
  {
    return 2130969435;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30161);
    if (bo.isNullOrNil(this.jUE))
    {
      this.jUE = getIntent().getStringExtra("enterprise_biz_name");
      this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
      this.ztC = getIntent().getStringExtra("biz_chat_search_text");
      if (bo.isNullOrNil(this.jUE)) {
        finish();
      }
    }
    this.ztE = ((BizChatSearchListView)findViewById(2131823737));
    this.ztF = ((TextView)findViewById(2131820918));
    this.ztG = new BizChatSearchUI.a(getContext(), this.jUE, this.scene);
    if (BizChatSearchUI.a.b(this.ztG))
    {
      this.ztD = new BizChatSearchUI.c((byte)0);
      BizChatSearchListView localBizChatSearchListView = this.ztE;
      BizChatSearchUI.c localc = this.ztD;
      View localView = View.inflate(getContext(), 2130969988, null);
      localc.jTP = localView.findViewById(2131825426);
      localc.jTQ = localView.findViewById(2131822313);
      localc.jTR = localView.findViewById(2131825427);
      localc.jTP.setVisibility(8);
      localc.jTQ.setVisibility(8);
      localc.jTR.setVisibility(8);
      localBizChatSearchListView.addFooterView(localView);
      OY(0);
    }
    this.ztE.setAdapter(this.ztG);
    this.ztE.setOnItemClickListener(new BizChatSearchUI.2(this));
    this.ztE.setOnTouchListener(this);
    if (BizChatSearchUI.a.b(this.ztG)) {
      this.ztE.setOnScrollListener(this.nvS);
    }
    this.jTZ = new b();
    this.jTZ.ru(BizChatSearchUI.a.c(this.ztG));
    this.jTZ.a(this);
    this.jTZ.gcJ = false;
    AppMethodBeat.o(30161);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30160);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(30160);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(30170);
    this.jTZ.a(this, paramMenu);
    AppMethodBeat.o(30170);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30169);
    super.onDestroy();
    AppMethodBeat.o(30169);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30168);
    super.onPause();
    this.jTZ.cancel();
    this.jTZ.clearFocus();
    AppMethodBeat.o(30168);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(30171);
    this.jTZ.a(this, paramMenu);
    AppMethodBeat.o(30171);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final boolean wR(String paramString)
  {
    AppMethodBeat.i(30166);
    hideVKB();
    AppMethodBeat.o(30166);
    return true;
  }
  
  public final void wS(String paramString)
  {
    BizChatSearchUI.a locala = null;
    AppMethodBeat.i(30165);
    if ((bo.isNullOrNil(paramString)) && (this.ztC != null))
    {
      paramString = this.ztC;
      this.ztC = null;
      if (!paramString.equals("")) {
        this.jTZ.setSearchContent(paramString);
      }
      b localb = this.jTZ;
      if (BizChatSearchUI.a.c(this.ztG)) {
        paramString = getContext().getResources().getString(2131297760);
      }
      for (;;)
      {
        localb.setHint(paramString);
        this.jTZ.clearFocus();
        AppMethodBeat.o(30165);
        return;
        if (BizChatSearchUI.a.b(this.ztG))
        {
          paramString = getContext().getResources().getString(2131297764);
        }
        else
        {
          paramString = locala;
          if (BizChatSearchUI.a.e(this.ztG)) {
            paramString = getContext().getResources().getString(2131297757);
          }
        }
      }
    }
    locala = this.ztG;
    locala.ejd = paramString;
    if (bo.isNullOrNil(paramString))
    {
      locala.clearData();
      locala.ztW = false;
      locala.zua = false;
      locala.qN(true);
      AppMethodBeat.o(30165);
      return;
    }
    if (locala.dEZ())
    {
      locala.ztW = true;
      locala.zua = false;
      locala.dFd();
      locala.cm(paramString, false);
      locala.atF(paramString);
      AppMethodBeat.o(30165);
      return;
    }
    locala.cm(paramString, true);
    if ((locala.ztK) && (locala.ztW)) {
      locala.atF(paramString);
    }
    AppMethodBeat.o(30165);
  }
  
  static final class f
  {
    public View contentView;
    public ImageView egq;
    public TextView gpL;
    public TextView gpM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import java.io.IOException;

public class SnsSingleTextViewUI
  extends MMActivity
{
  private String ctV;
  private n.d jWw;
  private ClipboardManager mAZ;
  private TextView rWb;
  private String rWc;
  private String rWd;
  private int rWe;
  private byte[] rWf;
  private cds rWg;
  private boolean rWh;
  private SnsTranslateResultView rWi;
  private c rWj;
  private c rWk;
  private c rWl;
  protected int requestType;
  private n rjt;
  private String text;
  
  public SnsSingleTextViewUI()
  {
    AppMethodBeat.i(39306);
    this.requestType = 0;
    this.rWc = null;
    this.rWd = null;
    this.rWf = null;
    this.rWg = null;
    this.rWh = false;
    this.rWj = new SnsSingleTextViewUI.1(this);
    this.rWk = new SnsSingleTextViewUI.2(this);
    this.rWl = new SnsSingleTextViewUI.3(this);
    this.jWw = new SnsSingleTextViewUI.5(this);
    AppMethodBeat.o(39306);
  }
  
  private boolean cvP()
  {
    boolean bool2 = false;
    AppMethodBeat.i(39310);
    boolean bool1;
    if (this.rWg == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(39310);
      return bool1;
      if (this.rWg.xNY == 0)
      {
        bool1 = bool2;
        if (this.rWg.xOa == 0L) {}
      }
      else
      {
        bool1 = bool2;
        if (!bo.isNullOrNil(this.rWg.ntu)) {
          bool1 = true;
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130970866;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39307);
    super.onCreate(paramBundle);
    this.mAZ = ((ClipboardManager)ah.getContext().getSystemService("clipboard"));
    setMMTitle(2131303776);
    setBackBtn(new SnsSingleTextViewUI.4(this));
    this.text = getIntent().getStringExtra("sns_text_show");
    this.ctV = bo.bf(getIntent().getStringExtra("sns_local_id"), "");
    this.rWf = getIntent().getByteArrayExtra("sns_comment_buf");
    if ((this.rWf != null) && (this.rWf.length > 0)) {
      this.rWg = new cds();
    }
    for (;;)
    {
      try
      {
        this.rWg.parseFrom(this.rWf);
        paramBundle = new StringBuilder();
        if (this.rWg.xNY == 0) {
          continue;
        }
        l = this.rWg.xNY;
        this.rWc = l;
      }
      catch (IOException paramBundle)
      {
        long l;
        ab.printErrStackTrace("MicroMsg.SnsSingleTextViewUI", paramBundle, "initCommentInfo error.", new Object[0]);
        continue;
        this.rWd = aq.gm(this.rjt.getSnsId(), this.rWc);
        this.rWe = 2;
        continue;
      }
      this.rjt = ag.cpf().abv(this.ctV);
      if (bo.isNullOrNil(this.text)) {
        this.text = "";
      }
      this.rWb = ((TextView)findViewById(2131828086));
      this.rWb.setText(this.text, TextView.BufferType.SPANNABLE);
      j.k(this.rWb, 2);
      this.rWb.setOnTouchListener(new m());
      new l(this).a(this.rWb, this, this.jWw);
      this.rWi = ((SnsTranslateResultView)findViewById(2131827943));
      this.rWi.setResultTextSize(this.rWb.getTextSize());
      if (this.rjt != null)
      {
        if (cvP()) {
          continue;
        }
        this.rWd = this.rjt.getSnsId();
        this.rWe = 1;
        if (aq.dn(this.rWd, 8))
        {
          paramBundle = aq.aaD(this.rWd);
          if ((paramBundle != null) && (paramBundle.fon))
          {
            this.rWi.setVisibility(0);
            this.rWi.a(null, this.rWe, paramBundle.result, paramBundle.fwM, false);
            this.rWh = true;
          }
        }
      }
      a.ymk.c(this.rWj);
      a.ymk.c(this.rWk);
      a.ymk.c(this.rWl);
      AppMethodBeat.o(39307);
      return;
      l = this.rWg.xOa;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(39309);
    if ((paramView instanceof TextView))
    {
      paramContextMenu.add(0, 0, 0, getString(2131296895));
      if ((d.ahR("favorite")) && (!cvP())) {
        paramContextMenu.add(0, 1, 0, getString(2131299680));
      }
      paramContextMenu.add(0, 6, 1, getString(2131296928));
      if (!this.rWh)
      {
        if (!cvP()) {}
        for (;;)
        {
          aq.a(paramContextMenu, bool1);
          AppMethodBeat.o(39309);
          return;
          bool1 = false;
        }
      }
      if (cvP()) {
        break label144;
      }
    }
    label144:
    for (bool1 = bool2;; bool1 = false)
    {
      aq.b(paramContextMenu, bool1);
      AppMethodBeat.o(39309);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39308);
    super.onDestroy();
    a.ymk.d(this.rWj);
    a.ymk.d(this.rWk);
    a.ymk.d(this.rWl);
    AppMethodBeat.o(39308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI
 * JD-Core Version:    0.7.0.1
 */
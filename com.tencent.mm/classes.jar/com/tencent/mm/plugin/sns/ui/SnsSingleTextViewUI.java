package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;

public class SnsSingleTextViewUI
  extends MMActivity
{
  private String bMB;
  private n.d ifj = new SnsSingleTextViewUI.5(this);
  private ClipboardManager kgn;
  private n ouA;
  private TextView pdt;
  private boolean pdu = false;
  private SnsTranslateResultView pdv;
  private c pdw = new SnsSingleTextViewUI.1(this);
  private c pdx = new SnsSingleTextViewUI.2(this);
  private c pdy = new SnsSingleTextViewUI.3(this);
  protected int requestType = 0;
  private String text;
  
  protected final int getLayoutId()
  {
    return i.g.sns_single_textviewui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.kgn = ((ClipboardManager)getSystemService("clipboard"));
    setMMTitle(i.j.sns_all_text);
    setBackBtn(new SnsSingleTextViewUI.4(this));
    this.text = getIntent().getStringExtra("sns_text_show");
    this.bMB = bk.aM(getIntent().getStringExtra("sns_local_id"), "");
    this.ouA = af.bDF().OB(this.bMB);
    if (bk.bl(this.text)) {
      this.text = "";
    }
    this.pdt = ((TextView)findViewById(i.f.sns_text_tv));
    this.pdt.setText(this.text, TextView.BufferType.SPANNABLE);
    com.tencent.mm.pluginsdk.ui.d.j.h(this.pdt, 2);
    this.pdt.setOnTouchListener(new m());
    new com.tencent.mm.ui.tools.j(this).a(this.pdt, this, this.ifj);
    this.pdv = ((SnsTranslateResultView)findViewById(i.f.sns_translate_result_view));
    this.pdv.setResultTextSize(this.pdt.getTextSize());
    if ((this.ouA != null) && (ap.cr(this.ouA.bGk(), 8)))
    {
      paramBundle = ap.NJ(this.ouA.bGk());
      if ((paramBundle != null) && (paramBundle.dYj))
      {
        this.pdv.setVisibility(0);
        this.pdv.a(null, 1, paramBundle.result, paramBundle.egI, false);
        this.pdu = true;
      }
    }
    a.udP.c(this.pdw);
    a.udP.c(this.pdx);
    a.udP.c(this.pdy);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if ((paramView instanceof TextView))
    {
      paramContextMenu.add(0, 0, 0, getString(i.j.app_copy));
      if (d.SP("favorite")) {
        paramContextMenu.add(0, 1, 0, getString(i.j.favorite));
      }
      paramContextMenu.add(0, 6, 1, getString(i.j.app_expose));
      if (!this.pdu) {
        ap.a(paramContextMenu, true);
      }
    }
    else
    {
      return;
    }
    ap.b(paramContextMenu, true);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    a.udP.d(this.pdw);
    a.udP.d(this.pdx);
    a.udP.d(this.pdy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI
 * JD-Core Version:    0.7.0.1
 */
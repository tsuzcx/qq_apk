package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.textview.a.a;

@com.tencent.mm.ui.base.a(3)
public class TextPreviewUI
  extends MMActivity
  implements f
{
  private bi bWO;
  private int bottom = 0;
  private TextView lh = null;
  private Animation ogr;
  private Animation ogs;
  private int qQ;
  private boolean shi = false;
  private CharSequence text = null;
  private TextView vkr = null;
  private com.tencent.mm.ui.widget.textview.a vna;
  private com.tencent.mm.ui.widget.b.a vnb;
  private CharSequence vnc;
  private View vnd;
  private View vne;
  private View vnf;
  private CustomScrollView vng;
  private final int vnh = 0;
  private final int vni = 1;
  private final int vnj = 2;
  private boolean vnk = false;
  private ToolsBar vnl;
  private View vnm;
  
  private void aQ(bi parambi)
  {
    com.tencent.mm.ui.chatting.view.b localb = new com.tencent.mm.ui.chatting.view.b(this.mController.uMN);
    localb.vAD = new TextPreviewUI.4(this, localb, parambi);
    localb.show();
  }
  
  protected final int getLayoutId()
  {
    return R.i.chatting_item_full_screen;
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    if (d.gF(19)) {
      getWindow().setFlags(67109888, 67109888);
    }
    this.vnd = findViewById(R.h.text_screen);
    this.text = getIntent().getCharSequenceExtra("key_chat_text");
    long l = getIntent().getLongExtra("Chat_Msg_Id", 0L);
    au.Hx();
    this.bWO = c.Fy().fd(l);
    this.lh = ((TextView)findViewById(R.h.full_screen_text));
    this.vkr = ((TextView)findViewById(R.h.full_screen_text_span));
    Object localObject1 = this.text;
    Object localObject2 = this.vkr;
    paramBundle = (Bundle)localObject1;
    if ((localObject1 instanceof SpannableString))
    {
      ((TextView)localObject2).setText(((SpannableString)localObject1).toString());
      j.h((TextView)localObject2, 1);
      paramBundle = ((TextView)localObject2).getText();
    }
    this.text = paramBundle;
    paramBundle = this.lh;
    localObject1 = com.tencent.mm.cd.g.csM();
    localObject2 = this.mController.uMN;
    paramBundle.setText(((com.tencent.mm.cd.g)localObject1).a(this.text, this.lh.getTextSize()));
    this.vne = findViewById(R.h.know_more_btn_container);
    this.vnf = this.vne.findViewById(R.h.jump_tip_btn);
    this.vng = ((CustomScrollView)findViewById(R.h.full_screen_scroll_container));
    this.lh.getViewTreeObserver().addOnPreDrawListener(new TextPreviewUI.1(this));
    this.ogs = AnimationUtils.loadAnimation(this.mController.uMN, R.a.push_up_in);
    this.ogr = AnimationUtils.loadAnimation(this.mController.uMN, R.a.push_down_out);
    this.vnb = new com.tencent.mm.ui.widget.b.a(this.mController.uMN, this.lh);
    this.vnb.woh = true;
    this.vnb.wog = new TextPreviewUI.8(this);
    this.vnb.phI = new TextPreviewUI.9(this);
    if ((this.vna == null) && (bk.bl(bf.n(this.bWO))))
    {
      paramBundle = new a.a(this.lh, this.vnb);
      paramBundle.wss = R.e.selected_blue;
      paramBundle.wsA = 18;
      paramBundle.wst = R.e.cursor_handle_color;
      this.vna = new com.tencent.mm.ui.widget.textview.a(paramBundle);
      this.vna.wsn = new TextPreviewUI.10(this);
    }
    this.vnd.setOnClickListener(new TextPreviewUI.11(this));
    this.lh.setOnClickListener(new TextPreviewUI.12(this));
    if (!bk.bl(bf.n(this.bWO)))
    {
      this.vne.setVisibility(0);
      this.vnf.setOnClickListener(new TextPreviewUI.13(this));
    }
    for (;;)
    {
      setBackBtn(new TextPreviewUI.14(this));
      this.vng.setOnTouchListener(new TextPreviewUI.15(this));
      this.vng.setOnScrollChangeListener(new TextPreviewUI.2(this));
      au.Dk().a(525, this);
      return;
      if (!bf.k(this.bWO))
      {
        paramBundle = (ViewStub)findViewById(R.h.viewstub_text_more_btn);
        if (paramBundle != null) {
          this.vnm = paramBundle.inflate();
        }
        this.vnl = ((ToolsBar)findViewById(R.h.tools_bar));
        this.vnl.setVisibility(0);
        if (this.vnl != null)
        {
          this.vnl.c(0, new TextPreviewUI.5(this));
          this.vnl.c(1, new TextPreviewUI.6(this));
          this.vnl.c(2, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              TextPreviewUI.b(TextPreviewUI.this, TextPreviewUI.d(TextPreviewUI.this));
            }
          });
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(525, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((this.vna != null) && (!this.vna.cbz)) {
      this.vna.cKK();
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramm.getType())
      {
      }
    }
    while (paramm.getType() != 525)
    {
      return;
      y.i("MicroMsg.TextPreviewUI", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(this.mController.uMN, this.mController.uMN.getResources().getString(R.l.has_remind_tip), "", null);
      return;
    }
    y.e("MicroMsg.TextPreviewUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), bk.pm(paramString) });
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    paramm = paramString;
    if (bk.bl(paramString)) {
      paramm = getResources().getString(R.l.remind_err_desc);
    }
    com.tencent.mm.ui.base.h.b(localAppCompatActivity, paramm, this.mController.uMN.getResources().getString(R.l.remind_err_title), true);
    com.tencent.mm.plugin.report.service.h.nFQ.a(795L, 4L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI
 * JD-Core Version:    0.7.0.1
 */
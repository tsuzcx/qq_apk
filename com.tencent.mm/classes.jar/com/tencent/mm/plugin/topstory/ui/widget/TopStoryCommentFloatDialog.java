package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.mk;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.plugin.topstory.ui.c.a;
import com.tencent.mm.plugin.topstory.ui.c.c;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.c.e;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.protocal.protobuf.fnv;
import com.tencent.mm.protocal.protobuf.fnw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public class TopStoryCommentFloatDialog
  extends RelativeLayout
  implements com.tencent.mm.am.h, com.tencent.mm.ui.tools.h
{
  TextView DYL;
  long RDZ;
  TextView TKV;
  SnsEditText TKX;
  a TQA;
  private View.OnClickListener TQB;
  f TQq;
  View TQy;
  boolean TQz;
  MMActivity activity;
  public com.tencent.mm.ui.tools.i lKz;
  TextView noi;
  w tipDialog;
  
  public TopStoryCommentFloatDialog(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126657);
    this.tipDialog = null;
    this.TQz = false;
    this.RDZ = 0L;
    this.TQB = new TopStoryCommentFloatDialog.8(this);
    init();
    AppMethodBeat.o(126657);
  }
  
  public TopStoryCommentFloatDialog(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126658);
    this.tipDialog = null;
    this.TQz = false;
    this.RDZ = 0L;
    this.TQB = new TopStoryCommentFloatDialog.8(this);
    init();
    AppMethodBeat.o(126658);
  }
  
  protected static boolean efl()
  {
    AppMethodBeat.i(126670);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA())
    {
      i = com.tencent.mm.kernel.h.aZW().bFQ();
      if ((i == 4) || (i == 6))
      {
        AppMethodBeat.o(126670);
        return true;
      }
      AppMethodBeat.o(126670);
      return false;
    }
    if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {}
    for (int i = 6; i == 6; i = 0)
    {
      AppMethodBeat.o(126670);
      return true;
    }
    AppMethodBeat.o(126670);
    return false;
  }
  
  private void hNp()
  {
    AppMethodBeat.i(126667);
    int j = this.TKX.getText().toString().length();
    if (j < 180)
    {
      this.noi.setVisibility(8);
      this.TKV.setVisibility(8);
      AppMethodBeat.o(126667);
      return;
    }
    this.noi.setVisibility(0);
    this.TKV.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(c.a.top_story_cmt_count_normal);; i = getResources().getColor(c.a.red))
    {
      this.noi.setText(String.valueOf(j));
      this.noi.setTextColor(i);
      AppMethodBeat.o(126667);
      return;
    }
  }
  
  private void hPb()
  {
    AppMethodBeat.i(126668);
    int i = this.TKX.getText().toString().length();
    int j = this.TKX.getText().toString().trim().length();
    if ((i > 200) || (i <= 0) || (j <= 0))
    {
      this.DYL.setBackgroundResource(c.c.top_story_ok_btn_disable_bg);
      AppMethodBeat.o(126668);
      return;
    }
    this.DYL.setBackgroundResource(c.c.top_story_ok_btn_bg);
    AppMethodBeat.o(126668);
  }
  
  private void init()
  {
    AppMethodBeat.i(126659);
    inflate(getContext(), c.e.top_story_float_comment_edit_layout, this);
    this.TQy = findViewById(c.d.comment_dialog);
    this.TKX = ((SnsEditText)findViewById(c.d.comment_tv));
    this.noi = ((TextView)findViewById(c.d.cmt_count));
    this.TKV = ((TextView)findViewById(c.d.cmt_count_total));
    AppMethodBeat.o(126659);
  }
  
  public final void a(f paramf, a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126661);
    this.TQz = true;
    this.TQq = paramf;
    setVisibility(0);
    this.TKX.requestFocus();
    this.activity.showVKB();
    this.TQA = parama;
    paramf = paramf.hMU();
    paramf = "action=14&channelId=" + paramInt1 + "&mpScene=0&kykScene=" + paramf.IJG + "&kykSubScene=0&itemType=" + paramInt2 + "&searchId=" + paramf.aayf + "&docId=" + paramf.abgw + "&byPass=" + paramf.abuT;
    com.tencent.mm.plugin.report.service.h.OAn.b(17080, new Object[] { Integer.valueOf(7), Integer.valueOf(2), paramf });
    AppMethodBeat.o(126661);
  }
  
  public final void hPa()
  {
    AppMethodBeat.i(126663);
    this.TKX.setText("");
    setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.TQy.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    this.TQy.setLayoutParams(localLayoutParams);
    this.activity.hideVKB();
    this.TQz = false;
    if (this.TQA != null) {
      this.TQA.onDismiss();
    }
    AppMethodBeat.o(126663);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(126662);
    if (this.TKX.getText().toString().length() > 0)
    {
      k.a(this.activity, c.g.top_story_post_comment_giveup, 0, c.g.app_yes, c.g.app_no, true, new TopStoryCommentFloatDialog.6(this), new TopStoryCommentFloatDialog.7(this), c.a.brand_text_color);
      AppMethodBeat.o(126662);
      return;
    }
    hPa();
    AppMethodBeat.o(126662);
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126666);
    Log.i("MicroMsg.TopStoryCommentFloatDialog", "onKeyboardHeightChanged in pixels: ".concat(String.valueOf(paramInt)));
    TopStoryCommentFloatDialog.5 local5;
    if (this.TQz)
    {
      this.TQy.setVisibility(0);
      if (((RelativeLayout.LayoutParams)this.TQy.getLayoutParams()).bottomMargin != paramInt)
      {
        local5 = new TopStoryCommentFloatDialog.5(this, paramInt);
        if (paramInt == 0) {
          break label103;
        }
        local5.setDuration(200L);
      }
    }
    for (;;)
    {
      this.TQy.startAnimation(local5);
      this.TKX.requestFocus();
      setVisibility(0);
      AppMethodBeat.o(126666);
      return;
      label103:
      local5.setDuration(300L);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(126664);
    this.lKz.afIL = null;
    com.tencent.mm.kernel.h.aZW().b(2906, this);
    AppMethodBeat.o(126664);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(126665);
    this.lKz.afIL = this;
    com.tencent.mm.kernel.h.aZW().a(2906, this);
    AppMethodBeat.o(126665);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(126669);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    f localf;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label268;
      }
      hPa();
      if (this.TQA != null) {
        this.TQA.hOS();
      }
      if ((paramp instanceof f))
      {
        localf = (f)paramp;
        paramp = new com.tencent.mm.ad.i();
      }
    }
    for (;;)
    {
      try
      {
        paramString = (fnv)c.b.b(localf.rr.otB);
        if (paramString == null) {
          continue;
        }
        paramString = paramString.nUB;
        paramp.m("content", paramString);
        paramp.m("id", localf.hMT().abNQ);
        paramString = (fnv)c.b.b(localf.rr.otB);
        if (paramString == null) {
          continue;
        }
        paramString = paramString.abgw;
        paramp.m("docId", paramString);
        paramp.m("opType", "REPLY_ARTICLE_BY_ME");
        paramString = new mk();
        paramString.hOA.hOB = paramp.toString();
        paramString.hOA.hOC = "";
        paramString.publish();
      }
      catch (g paramString)
      {
        Log.e("MicroMsg.TopStoryCommentFloatDialog", "notify tl failed");
        continue;
      }
      aa.makeText(this.activity, c.g.top_story_post_comment_succ, 0).show();
      AppMethodBeat.o(126669);
      return;
      paramInt1 = 0;
      break;
      paramString = "";
      continue;
      paramString = "";
    }
    label268:
    k.c(this.activity, this.activity.getString(c.g.app_err_system_busy_tip), "", true);
    AppMethodBeat.o(126669);
  }
  
  public final void u(final MMActivity paramMMActivity)
  {
    AppMethodBeat.i(126660);
    this.activity = paramMMActivity;
    this.lKz = new com.tencent.mm.ui.tools.i(paramMMActivity);
    setOnClickListener(this.TQB);
    findViewById(c.d.cancel_comment).setOnClickListener(new TopStoryCommentFloatDialog.1(this));
    this.DYL = ((TextView)findViewById(c.d.post_comment));
    this.DYL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126651);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        if (System.currentTimeMillis() - TopStoryCommentFloatDialog.this.RDZ < 500L)
        {
          a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126651);
          return;
        }
        TopStoryCommentFloatDialog.this.RDZ = System.currentTimeMillis();
        paramAnonymousView = TopStoryCommentFloatDialog.this.TKX.getText().toString();
        if (paramAnonymousView.length() > 200)
        {
          a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126651);
          return;
        }
        if ((paramAnonymousView.length() <= 0) || (paramAnonymousView.trim().length() <= 0))
        {
          a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126651);
          return;
        }
        if (!TopStoryCommentFloatDialog.efl())
        {
          k.c(paramMMActivity, paramMMActivity.getString(c.g.fmt_iap_err), "", true);
          a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126651);
          return;
        }
        TopStoryCommentFloatDialog.this.tipDialog = k.a(paramMMActivity, paramMMActivity.getString(c.g.app_sending), false, null);
        localObject = new f(TopStoryCommentFloatDialog.this.TQq);
        ((fnv)c.b.b(((f)localObject).rr.otB)).nUB = paramAnonymousView;
        com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126651);
      }
    });
    hNp();
    hPb();
    this.TKX.addTextChangedListener(new TopStoryCommentFloatDialog.3(this));
    post(new TopStoryCommentFloatDialog.4(this));
    AppMethodBeat.o(126660);
  }
  
  public static abstract interface a
  {
    public abstract void hOS();
    
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog
 * JD-Core Version:    0.7.0.1
 */
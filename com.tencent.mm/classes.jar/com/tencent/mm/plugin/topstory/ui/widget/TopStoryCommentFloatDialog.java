package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.le;
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
import com.tencent.mm.protocal.protobuf.esm;
import com.tencent.mm.protocal.protobuf.esn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;

public class TopStoryCommentFloatDialog
  extends RelativeLayout
  implements com.tencent.mm.an.i, com.tencent.mm.ui.tools.h
{
  long LdQ;
  TextView MYn;
  SnsEditText MYp;
  f NdD;
  View NdL;
  boolean NdM;
  a NdN;
  private View.OnClickListener NdO;
  MMActivity activity;
  public com.tencent.mm.ui.tools.i jij;
  TextView kMp;
  s tipDialog;
  TextView zcq;
  
  public TopStoryCommentFloatDialog(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126657);
    this.tipDialog = null;
    this.NdM = false;
    this.LdQ = 0L;
    this.NdO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126656);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (TopStoryCommentFloatDialog.this.getVisibility() == 0) {
          TopStoryCommentFloatDialog.this.hide();
        }
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126656);
      }
    };
    init();
    AppMethodBeat.o(126657);
  }
  
  public TopStoryCommentFloatDialog(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126658);
    this.tipDialog = null;
    this.NdM = false;
    this.LdQ = 0L;
    this.NdO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126656);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (TopStoryCommentFloatDialog.this.getVisibility() == 0) {
          TopStoryCommentFloatDialog.this.hide();
        }
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126656);
      }
    };
    init();
    AppMethodBeat.o(126658);
  }
  
  protected static boolean dvr()
  {
    AppMethodBeat.i(126670);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).aIE())
    {
      i = com.tencent.mm.kernel.h.aGY().bih();
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
  
  private void gqs()
  {
    AppMethodBeat.i(126667);
    int j = this.MYp.getText().toString().length();
    if (j < 180)
    {
      this.kMp.setVisibility(8);
      this.MYn.setVisibility(8);
      AppMethodBeat.o(126667);
      return;
    }
    this.kMp.setVisibility(0);
    this.MYn.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(c.a.top_story_cmt_count_normal);; i = getResources().getColor(c.a.red))
    {
      this.kMp.setText(String.valueOf(j));
      this.kMp.setTextColor(i);
      AppMethodBeat.o(126667);
      return;
    }
  }
  
  private void gsa()
  {
    AppMethodBeat.i(126668);
    int i = this.MYp.getText().toString().length();
    int j = this.MYp.getText().toString().trim().length();
    if ((i > 200) || (i <= 0) || (j <= 0))
    {
      this.zcq.setBackgroundResource(c.c.top_story_ok_btn_disable_bg);
      AppMethodBeat.o(126668);
      return;
    }
    this.zcq.setBackgroundResource(c.c.top_story_ok_btn_bg);
    AppMethodBeat.o(126668);
  }
  
  private void init()
  {
    AppMethodBeat.i(126659);
    inflate(getContext(), c.e.top_story_float_comment_edit_layout, this);
    this.NdL = findViewById(c.d.comment_dialog);
    this.MYp = ((SnsEditText)findViewById(c.d.comment_tv));
    this.kMp = ((TextView)findViewById(c.d.cmt_count));
    this.MYn = ((TextView)findViewById(c.d.cmt_count_total));
    AppMethodBeat.o(126659);
  }
  
  public final void A(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126666);
    Log.i("MicroMsg.TopStoryCommentFloatDialog", "onKeyboardHeightChanged in pixels: ".concat(String.valueOf(paramInt)));
    Animation local5;
    if (this.NdM)
    {
      this.NdL.setVisibility(0);
      if (((RelativeLayout.LayoutParams)this.NdL.getLayoutParams()).bottomMargin != paramInt)
      {
        local5 = new Animation()
        {
          protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            AppMethodBeat.i(126654);
            paramAnonymousTransformation = (RelativeLayout.LayoutParams)TopStoryCommentFloatDialog.this.NdL.getLayoutParams();
            paramAnonymousTransformation.bottomMargin = ((int)(paramInt * paramAnonymousFloat));
            TopStoryCommentFloatDialog.this.NdL.setLayoutParams(paramAnonymousTransformation);
            AppMethodBeat.o(126654);
          }
        };
        if (paramInt == 0) {
          break label99;
        }
        local5.setDuration(200L);
      }
    }
    for (;;)
    {
      this.NdL.startAnimation(local5);
      this.MYp.requestFocus();
      setVisibility(0);
      AppMethodBeat.o(126666);
      return;
      label99:
      local5.setDuration(300L);
    }
  }
  
  public final void a(f paramf, a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126661);
    this.NdM = true;
    this.NdD = paramf;
    setVisibility(0);
    this.MYp.requestFocus();
    this.activity.showVKB();
    this.NdN = parama;
    paramf = paramf.gpY();
    paramf = "action=14&channelId=" + paramInt1 + "&mpScene=0&kykScene=" + paramf.CPw + "&kykSubScene=0&itemType=" + paramInt2 + "&searchId=" + paramf.Tky + "&docId=" + paramf.TPZ + "&byPass=" + paramf.Udz;
    com.tencent.mm.plugin.report.service.h.IzE.a(17080, new Object[] { Integer.valueOf(7), Integer.valueOf(2), paramf });
    AppMethodBeat.o(126661);
  }
  
  public final void grZ()
  {
    AppMethodBeat.i(126663);
    this.MYp.setText("");
    setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.NdL.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    this.NdL.setLayoutParams(localLayoutParams);
    this.activity.hideVKB();
    this.NdM = false;
    if (this.NdN != null) {
      this.NdN.onDismiss();
    }
    AppMethodBeat.o(126663);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(126662);
    if (this.MYp.getText().toString().length() > 0)
    {
      com.tencent.mm.ui.base.h.a(this.activity, c.g.top_story_post_comment_giveup, 0, c.g.app_yes, c.g.app_no, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(126655);
          TopStoryCommentFloatDialog.this.grZ();
          AppMethodBeat.o(126655);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, c.a.brand_text_color);
      AppMethodBeat.o(126662);
      return;
    }
    grZ();
    AppMethodBeat.o(126662);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(126664);
    this.jij.XSx = null;
    com.tencent.mm.kernel.h.aGY().b(2906, this);
    AppMethodBeat.o(126664);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(126665);
    this.jij.XSx = this;
    com.tencent.mm.kernel.h.aGY().a(2906, this);
    AppMethodBeat.o(126665);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
        break label270;
      }
      grZ();
      if (this.NdN != null) {
        this.NdN.grR();
      }
      if ((paramq instanceof f))
      {
        localf = (f)paramq;
        paramq = new com.tencent.mm.ad.i();
      }
    }
    for (;;)
    {
      try
      {
        paramString = (esm)d.b.b(localf.rr.lBR);
        if (paramString == null) {
          continue;
        }
        paramString = paramString.lpy;
        paramq.g("content", paramString);
        paramq.g("id", localf.gpX().Uun);
        paramString = (esm)d.b.b(localf.rr.lBR);
        if (paramString == null) {
          continue;
        }
        paramString = paramString.TPZ;
        paramq.g("docId", paramString);
        paramq.g("opType", "REPLY_ARTICLE_BY_ME");
        paramString = new le();
        paramString.fIS.fIT = paramq.toString();
        paramString.fIS.fIU = "";
        EventCenter.instance.publish(paramString);
      }
      catch (g paramString)
      {
        Log.e("MicroMsg.TopStoryCommentFloatDialog", "notify tl failed");
        continue;
      }
      w.makeText(this.activity, c.g.top_story_post_comment_succ, 0).show();
      AppMethodBeat.o(126669);
      return;
      paramInt1 = 0;
      break;
      paramString = "";
      continue;
      paramString = "";
    }
    label270:
    com.tencent.mm.ui.base.h.c(this.activity, this.activity.getString(c.g.app_err_system_busy_tip), "", true);
    AppMethodBeat.o(126669);
  }
  
  public final void p(final MMActivity paramMMActivity)
  {
    AppMethodBeat.i(126660);
    this.activity = paramMMActivity;
    this.jij = new com.tencent.mm.ui.tools.i(paramMMActivity);
    setOnClickListener(this.NdO);
    findViewById(c.d.cancel_comment).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126650);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        TopStoryCommentFloatDialog.this.hide();
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126650);
      }
    });
    this.zcq = ((TextView)findViewById(c.d.post_comment));
    this.zcq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126651);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        if (System.currentTimeMillis() - TopStoryCommentFloatDialog.this.LdQ < 500L)
        {
          a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126651);
          return;
        }
        TopStoryCommentFloatDialog.this.LdQ = System.currentTimeMillis();
        paramAnonymousView = TopStoryCommentFloatDialog.this.MYp.getText().toString();
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
        if (!TopStoryCommentFloatDialog.dvr())
        {
          com.tencent.mm.ui.base.h.c(paramMMActivity, paramMMActivity.getString(c.g.fmt_iap_err), "", true);
          a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126651);
          return;
        }
        TopStoryCommentFloatDialog.this.tipDialog = com.tencent.mm.ui.base.h.a(paramMMActivity, paramMMActivity.getString(c.g.app_sending), false, null);
        localObject = new f(TopStoryCommentFloatDialog.this.NdD);
        ((esm)d.b.b(((f)localObject).rr.lBR)).lpy = paramAnonymousView;
        com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126651);
      }
    });
    gqs();
    gsa();
    this.MYp.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(126652);
        TopStoryCommentFloatDialog.a(TopStoryCommentFloatDialog.this);
        TopStoryCommentFloatDialog.b(TopStoryCommentFloatDialog.this);
        AppMethodBeat.o(126652);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(126653);
        TopStoryCommentFloatDialog.this.jij.start();
        AppMethodBeat.o(126653);
      }
    });
    AppMethodBeat.o(126660);
  }
  
  public static abstract interface a
  {
    public abstract void grR();
    
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog
 * JD-Core Version:    0.7.0.1
 */
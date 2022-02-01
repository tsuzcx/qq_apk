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
import com.tencent.mm.ac.i;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.protocal.protobuf.dnr;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;

public class TopStoryCommentFloatDialog
  extends RelativeLayout
  implements com.tencent.mm.al.f, com.tencent.mm.ui.tools.g
{
  long Apa;
  TextView Btw;
  SnsEditText Btz;
  com.tencent.mm.plugin.topstory.a.c.f ByM;
  View ByU;
  boolean ByV;
  a ByW;
  TextView ByX;
  private View.OnClickListener ByY;
  MMActivity activity;
  public com.tencent.mm.ui.tools.h fQT;
  TextView hch;
  p tipDialog;
  
  public TopStoryCommentFloatDialog(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126657);
    this.tipDialog = null;
    this.ByV = false;
    this.Apa = 0L;
    this.ByY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126656);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (TopStoryCommentFloatDialog.this.getVisibility() == 0) {
          TopStoryCommentFloatDialog.this.hide();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    this.ByV = false;
    this.Apa = 0L;
    this.ByY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126656);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (TopStoryCommentFloatDialog.this.getVisibility() == 0) {
          TopStoryCommentFloatDialog.this.hide();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126656);
      }
    };
    init();
    AppMethodBeat.o(126658);
  }
  
  protected static boolean cUk()
  {
    AppMethodBeat.i(126670);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).akw())
    {
      i = com.tencent.mm.kernel.g.aiU().aEN();
      if ((i == 4) || (i == 6))
      {
        AppMethodBeat.o(126670);
        return true;
      }
      AppMethodBeat.o(126670);
      return false;
    }
    if (ay.isConnected(aj.getContext())) {}
    for (int i = 6; i == 6; i = 0)
    {
      AppMethodBeat.o(126670);
      return true;
    }
    AppMethodBeat.o(126670);
    return false;
  }
  
  private void epr()
  {
    AppMethodBeat.i(126667);
    int j = this.Btz.getText().toString().length();
    if (j < 180)
    {
      this.hch.setVisibility(8);
      this.Btw.setVisibility(8);
      AppMethodBeat.o(126667);
      return;
    }
    this.hch.setVisibility(0);
    this.Btw.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(2131101042);; i = getResources().getColor(2131100798))
    {
      this.hch.setText(String.valueOf(j));
      this.hch.setTextColor(i);
      AppMethodBeat.o(126667);
      return;
    }
  }
  
  private void eqZ()
  {
    AppMethodBeat.i(126668);
    int i = this.Btz.getText().toString().length();
    int j = this.Btz.getText().toString().trim().length();
    if ((i > 200) || (i <= 0) || (j <= 0))
    {
      this.ByX.setBackgroundResource(2131234414);
      AppMethodBeat.o(126668);
      return;
    }
    this.ByX.setBackgroundResource(2131234413);
    AppMethodBeat.o(126668);
  }
  
  private void init()
  {
    AppMethodBeat.i(126659);
    inflate(getContext(), 2131495774, this);
    this.ByU = findViewById(2131298512);
    this.Btz = ((SnsEditText)findViewById(2131298540));
    this.hch = ((TextView)findViewById(2131298381));
    this.Btw = ((TextView)findViewById(2131298382));
    AppMethodBeat.o(126659);
  }
  
  public final void a(com.tencent.mm.plugin.topstory.a.c.f paramf, a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126661);
    this.ByV = true;
    this.ByM = paramf;
    setVisibility(0);
    this.Btz.requestFocus();
    this.activity.showVKB();
    this.ByW = parama;
    paramf = paramf.eoY();
    paramf = "action=14&channelId=" + paramInt1 + "&mpScene=0&kykScene=" + paramf.Scene + "&kykSubScene=0&itemType=" + paramInt2 + "&searchId=" + paramf.GRx + "&docId=" + paramf.HbR + "&byPass=" + paramf.HmJ;
    com.tencent.mm.plugin.report.service.g.yhR.f(17080, new Object[] { Integer.valueOf(7), Integer.valueOf(2), paramf });
    AppMethodBeat.o(126661);
  }
  
  public final void eqY()
  {
    AppMethodBeat.i(126663);
    this.Btz.setText("");
    setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ByU.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    this.ByU.setLayoutParams(localLayoutParams);
    this.activity.hideVKB();
    this.ByV = false;
    if (this.ByW != null) {
      this.ByW.onDismiss();
    }
    AppMethodBeat.o(126663);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(126662);
    if (this.Btz.getText().toString().length() > 0)
    {
      com.tencent.mm.ui.base.h.a(this.activity, 2131764486, 0, 2131755939, 2131755831, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(126655);
          TopStoryCommentFloatDialog.this.eqY();
          AppMethodBeat.o(126655);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, 2131100035);
      AppMethodBeat.o(126662);
      return;
    }
    eqY();
    AppMethodBeat.o(126662);
  }
  
  public final void o(final MMActivity paramMMActivity)
  {
    AppMethodBeat.i(126660);
    this.activity = paramMMActivity;
    this.fQT = new com.tencent.mm.ui.tools.h(paramMMActivity);
    setOnClickListener(this.ByY);
    findViewById(2131297692).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126650);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        TopStoryCommentFloatDialog.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126650);
      }
    });
    this.ByX = ((TextView)findViewById(2131303360));
    this.ByX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126651);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (System.currentTimeMillis() - TopStoryCommentFloatDialog.this.Apa < 500L)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126651);
          return;
        }
        TopStoryCommentFloatDialog.this.Apa = System.currentTimeMillis();
        paramAnonymousView = TopStoryCommentFloatDialog.this.Btz.getText().toString();
        if (paramAnonymousView.length() > 200)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126651);
          return;
        }
        if ((paramAnonymousView.length() <= 0) || (paramAnonymousView.trim().length() <= 0))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126651);
          return;
        }
        if (!TopStoryCommentFloatDialog.cUk())
        {
          com.tencent.mm.ui.base.h.c(paramMMActivity, paramMMActivity.getString(2131759511), "", true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126651);
          return;
        }
        TopStoryCommentFloatDialog.this.tipDialog = com.tencent.mm.ui.base.h.b(paramMMActivity, paramMMActivity.getString(2131755886), false, null);
        localObject = new com.tencent.mm.plugin.topstory.a.c.f(TopStoryCommentFloatDialog.this.ByM);
        ((dnr)((com.tencent.mm.plugin.topstory.a.c.f)localObject).rr.hNK.hNQ).hDa = paramAnonymousView;
        com.tencent.mm.kernel.g.aiU().a((n)localObject, 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126651);
      }
    });
    epr();
    eqZ();
    this.Btz.addTextChangedListener(new TextWatcher()
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
        TopStoryCommentFloatDialog.this.fQT.start();
        AppMethodBeat.o(126653);
      }
    });
    AppMethodBeat.o(126660);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(126664);
    this.fQT.KIP = null;
    com.tencent.mm.kernel.g.aiU().b(2906, this);
    AppMethodBeat.o(126664);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(126665);
    this.fQT.KIP = this;
    com.tencent.mm.kernel.g.aiU().a(2906, this);
    AppMethodBeat.o(126665);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(126669);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    com.tencent.mm.plugin.topstory.a.c.f localf;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label271;
      }
      eqY();
      if (this.ByW != null) {
        this.ByW.eqO();
      }
      if ((paramn instanceof com.tencent.mm.plugin.topstory.a.c.f))
      {
        localf = (com.tencent.mm.plugin.topstory.a.c.f)paramn;
        paramn = new i();
      }
    }
    for (;;)
    {
      try
      {
        paramString = (dnr)localf.rr.hNK.hNQ;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.hDa;
        paramn.h("content", paramString);
        paramn.h("id", localf.eoX().HBK);
        paramString = (dnr)localf.rr.hNK.hNQ;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.HbR;
        paramn.h("docId", paramString);
        paramn.h("opType", "REPLY_ARTICLE_BY_ME");
        paramString = new jx();
        paramString.dwR.dwS = paramn.toString();
        paramString.dwR.dwT = "";
        com.tencent.mm.sdk.b.a.IbL.l(paramString);
      }
      catch (com.tencent.mm.ac.g paramString)
      {
        ad.e("MicroMsg.TopStoryCommentFloatDialog", "notify tl failed");
        continue;
      }
      t.makeText(this.activity, 2131764488, 0).show();
      AppMethodBeat.o(126669);
      return;
      paramInt1 = 0;
      break;
      paramString = "";
      continue;
      paramString = "";
    }
    label271:
    com.tencent.mm.ui.base.h.c(this.activity, this.activity.getString(2131755733), "", true);
    AppMethodBeat.o(126669);
  }
  
  public final void u(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126666);
    ad.i("MicroMsg.TopStoryCommentFloatDialog", "onKeyboardHeightChanged in pixels: ".concat(String.valueOf(paramInt)));
    Animation local5;
    if (this.ByV)
    {
      this.ByU.setVisibility(0);
      if (((RelativeLayout.LayoutParams)this.ByU.getLayoutParams()).bottomMargin != paramInt)
      {
        local5 = new Animation()
        {
          protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            AppMethodBeat.i(126654);
            paramAnonymousTransformation = (RelativeLayout.LayoutParams)TopStoryCommentFloatDialog.this.ByU.getLayoutParams();
            paramAnonymousTransformation.bottomMargin = ((int)(paramInt * paramAnonymousFloat));
            TopStoryCommentFloatDialog.this.ByU.setLayoutParams(paramAnonymousTransformation);
            AppMethodBeat.o(126654);
          }
        };
        if (paramInt == 0) {
          break label103;
        }
        local5.setDuration(200L);
      }
    }
    for (;;)
    {
      this.ByU.startAnimation(local5);
      this.Btz.requestFocus();
      setVisibility(0);
      AppMethodBeat.o(126666);
      return;
      label103:
      local5.setDuration(300L);
    }
  }
  
  public static abstract interface a
  {
    public abstract void eqO();
    
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog
 * JD-Core Version:    0.7.0.1
 */
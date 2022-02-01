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
import com.tencent.mm.ab.i;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jp;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;

public class TopStoryCommentFloatDialog
  extends RelativeLayout
  implements com.tencent.mm.ak.g, com.tencent.mm.ui.tools.g
{
  TextView AbL;
  SnsEditText AbO;
  f Aha;
  View Ahi;
  boolean Ahj;
  a Ahk;
  TextView Ahl;
  private View.OnClickListener Ahm;
  MMActivity activity;
  public com.tencent.mm.ui.tools.h fxG;
  TextView gIx;
  p tipDialog;
  long yXp;
  
  public TopStoryCommentFloatDialog(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126657);
    this.tipDialog = null;
    this.Ahj = false;
    this.yXp = 0L;
    this.Ahm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126656);
        if (TopStoryCommentFloatDialog.this.getVisibility() == 0) {
          TopStoryCommentFloatDialog.this.hide();
        }
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
    this.Ahj = false;
    this.yXp = 0L;
    this.Ahm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126656);
        if (TopStoryCommentFloatDialog.this.getVisibility() == 0) {
          TopStoryCommentFloatDialog.this.hide();
        }
        AppMethodBeat.o(126656);
      }
    };
    init();
    AppMethodBeat.o(126658);
  }
  
  protected static boolean cLR()
  {
    AppMethodBeat.i(126670);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ahL())
    {
      i = com.tencent.mm.kernel.g.agi().aBK();
      if ((i == 4) || (i == 6))
      {
        AppMethodBeat.o(126670);
        return true;
      }
      AppMethodBeat.o(126670);
      return false;
    }
    if (ax.isConnected(ai.getContext())) {}
    for (int i = 6; i == 6; i = 0)
    {
      AppMethodBeat.o(126670);
      return true;
    }
    AppMethodBeat.o(126670);
    return false;
  }
  
  private void ecZ()
  {
    AppMethodBeat.i(126667);
    int j = this.AbO.getText().toString().length();
    if (j < 180)
    {
      this.gIx.setVisibility(8);
      this.AbL.setVisibility(8);
      AppMethodBeat.o(126667);
      return;
    }
    this.gIx.setVisibility(0);
    this.AbL.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(2131101042);; i = getResources().getColor(2131100798))
    {
      this.gIx.setText(String.valueOf(j));
      this.gIx.setTextColor(i);
      AppMethodBeat.o(126667);
      return;
    }
  }
  
  private void eeI()
  {
    AppMethodBeat.i(126668);
    int i = this.AbO.getText().toString().length();
    int j = this.AbO.getText().toString().trim().length();
    if ((i > 200) || (i <= 0) || (j <= 0))
    {
      this.Ahl.setBackgroundResource(2131234414);
      AppMethodBeat.o(126668);
      return;
    }
    this.Ahl.setBackgroundResource(2131234413);
    AppMethodBeat.o(126668);
  }
  
  private void init()
  {
    AppMethodBeat.i(126659);
    inflate(getContext(), 2131495774, this);
    this.Ahi = findViewById(2131298512);
    this.AbO = ((SnsEditText)findViewById(2131298540));
    this.gIx = ((TextView)findViewById(2131298381));
    this.AbL = ((TextView)findViewById(2131298382));
    AppMethodBeat.o(126659);
  }
  
  public final void a(f paramf, a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126661);
    this.Ahj = true;
    this.Aha = paramf;
    setVisibility(0);
    this.AbO.requestFocus();
    this.activity.showVKB();
    this.Ahk = parama;
    paramf = paramf.ecH();
    paramf = "action=14&channelId=" + paramInt1 + "&mpScene=0&kykScene=" + paramf.Scene + "&kykSubScene=0&itemType=" + paramInt2 + "&searchId=" + paramf.FhW + "&docId=" + paramf.FrN + "&byPass=" + paramf.FCu;
    com.tencent.mm.plugin.report.service.h.wUl.f(17080, new Object[] { Integer.valueOf(7), Integer.valueOf(2), paramf });
    AppMethodBeat.o(126661);
  }
  
  public final void eeH()
  {
    AppMethodBeat.i(126663);
    this.AbO.setText("");
    setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Ahi.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    this.Ahi.setLayoutParams(localLayoutParams);
    this.activity.hideVKB();
    this.Ahj = false;
    if (this.Ahk != null) {
      this.Ahk.onDismiss();
    }
    AppMethodBeat.o(126663);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(126662);
    if (this.AbO.getText().toString().length() > 0)
    {
      com.tencent.mm.ui.base.h.a(this.activity, 2131764486, 0, 2131755939, 2131755831, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(126655);
          TopStoryCommentFloatDialog.this.eeH();
          AppMethodBeat.o(126655);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, 2131100035);
      AppMethodBeat.o(126662);
      return;
    }
    eeH();
    AppMethodBeat.o(126662);
  }
  
  public final void m(final MMActivity paramMMActivity)
  {
    AppMethodBeat.i(126660);
    this.activity = paramMMActivity;
    this.fxG = new com.tencent.mm.ui.tools.h(paramMMActivity);
    setOnClickListener(this.Ahm);
    findViewById(2131297692).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126650);
        TopStoryCommentFloatDialog.this.hide();
        AppMethodBeat.o(126650);
      }
    });
    this.Ahl = ((TextView)findViewById(2131303360));
    this.Ahl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126651);
        if (System.currentTimeMillis() - TopStoryCommentFloatDialog.this.yXp < 500L)
        {
          AppMethodBeat.o(126651);
          return;
        }
        TopStoryCommentFloatDialog.this.yXp = System.currentTimeMillis();
        paramAnonymousView = TopStoryCommentFloatDialog.this.AbO.getText().toString();
        if (paramAnonymousView.length() > 200)
        {
          AppMethodBeat.o(126651);
          return;
        }
        if ((paramAnonymousView.length() <= 0) || (paramAnonymousView.trim().length() <= 0))
        {
          AppMethodBeat.o(126651);
          return;
        }
        if (!TopStoryCommentFloatDialog.cLR())
        {
          com.tencent.mm.ui.base.h.c(paramMMActivity, paramMMActivity.getString(2131759511), "", true);
          AppMethodBeat.o(126651);
          return;
        }
        TopStoryCommentFloatDialog.this.tipDialog = com.tencent.mm.ui.base.h.b(paramMMActivity, paramMMActivity.getString(2131755886), false, null);
        f localf = new f(TopStoryCommentFloatDialog.this.Aha);
        ((dic)localf.rr.hvr.hvw).hkR = paramAnonymousView;
        com.tencent.mm.kernel.g.agi().a(localf, 0);
        AppMethodBeat.o(126651);
      }
    });
    ecZ();
    eeI();
    this.AbO.addTextChangedListener(new TextWatcher()
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
        TopStoryCommentFloatDialog.this.fxG.start();
        AppMethodBeat.o(126653);
      }
    });
    AppMethodBeat.o(126660);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(126664);
    this.fxG.IRL = null;
    com.tencent.mm.kernel.g.agi().b(2906, this);
    AppMethodBeat.o(126664);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(126665);
    this.fxG.IRL = this;
    com.tencent.mm.kernel.g.agi().a(2906, this);
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
    f localf;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label271;
      }
      eeH();
      if (this.Ahk != null) {
        this.Ahk.eex();
      }
      if ((paramn instanceof f))
      {
        localf = (f)paramn;
        paramn = new i();
      }
    }
    for (;;)
    {
      try
      {
        paramString = (dic)localf.rr.hvr.hvw;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.hkR;
        paramn.i("content", paramString);
        paramn.i("id", localf.ecG().FRe);
        paramString = (dic)localf.rr.hvr.hvw;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.FrN;
        paramn.i("docId", paramString);
        paramn.i("opType", "REPLY_ARTICLE_BY_ME");
        paramString = new jp();
        paramString.dle.dlf = paramn.toString();
        paramString.dle.dlg = "";
        a.GpY.l(paramString);
      }
      catch (com.tencent.mm.ab.g paramString)
      {
        ac.e("MicroMsg.TopStoryCommentFloatDialog", "notify tl failed");
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
    ac.i("MicroMsg.TopStoryCommentFloatDialog", "onKeyboardHeightChanged in pixels: ".concat(String.valueOf(paramInt)));
    Animation local5;
    if (this.Ahj)
    {
      this.Ahi.setVisibility(0);
      if (((RelativeLayout.LayoutParams)this.Ahi.getLayoutParams()).bottomMargin != paramInt)
      {
        local5 = new Animation()
        {
          protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            AppMethodBeat.i(126654);
            paramAnonymousTransformation = (RelativeLayout.LayoutParams)TopStoryCommentFloatDialog.this.Ahi.getLayoutParams();
            paramAnonymousTransformation.bottomMargin = ((int)(paramInt * paramAnonymousFloat));
            TopStoryCommentFloatDialog.this.Ahi.setLayoutParams(paramAnonymousTransformation);
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
      this.Ahi.startAnimation(local5);
      this.AbO.requestFocus();
      setVisibility(0);
      AppMethodBeat.o(126666);
      return;
      label103:
      local5.setDuration(300L);
    }
  }
  
  public static abstract interface a
  {
    public abstract void eex();
    
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog
 * JD-Core Version:    0.7.0.1
 */
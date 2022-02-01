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
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.protocal.protobuf.eik;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;

public class TopStoryCommentFloatDialog
  extends RelativeLayout
  implements com.tencent.mm.ak.i, com.tencent.mm.ui.tools.g
{
  long EPV;
  TextView GlA;
  SnsEditText GlD;
  f GqS;
  View Gra;
  boolean Grb;
  a Grc;
  private View.OnClickListener Grd;
  MMActivity activity;
  public com.tencent.mm.ui.tools.h gyh;
  TextView hXK;
  com.tencent.mm.ui.base.q tipDialog;
  TextView uCE;
  
  public TopStoryCommentFloatDialog(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126657);
    this.tipDialog = null;
    this.Grb = false;
    this.EPV = 0L;
    this.Grd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126656);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    this.Grb = false;
    this.EPV = 0L;
    this.Grd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126656);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
  
  protected static boolean dzA()
  {
    AppMethodBeat.i(126670);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).aBb())
    {
      i = com.tencent.mm.kernel.g.azz().aYS();
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
  
  private void fyv()
  {
    AppMethodBeat.i(126667);
    int j = this.GlD.getText().toString().length();
    if (j < 180)
    {
      this.hXK.setVisibility(8);
      this.GlA.setVisibility(8);
      AppMethodBeat.o(126667);
      return;
    }
    this.hXK.setVisibility(0);
    this.GlA.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(2131101275);; i = getResources().getColor(2131100994))
    {
      this.hXK.setText(String.valueOf(j));
      this.hXK.setTextColor(i);
      AppMethodBeat.o(126667);
      return;
    }
  }
  
  private void fzZ()
  {
    AppMethodBeat.i(126668);
    int i = this.GlD.getText().toString().length();
    int j = this.GlD.getText().toString().trim().length();
    if ((i > 200) || (i <= 0) || (j <= 0))
    {
      this.uCE.setBackgroundResource(2131235339);
      AppMethodBeat.o(126668);
      return;
    }
    this.uCE.setBackgroundResource(2131235338);
    AppMethodBeat.o(126668);
  }
  
  private void init()
  {
    AppMethodBeat.i(126659);
    inflate(getContext(), 2131496732, this);
    this.Gra = findViewById(2131298938);
    this.GlD = ((SnsEditText)findViewById(2131298970));
    this.hXK = ((TextView)findViewById(2131298790));
    this.GlA = ((TextView)findViewById(2131298791));
    AppMethodBeat.o(126659);
  }
  
  public final void a(f paramf, a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126661);
    this.Grb = true;
    this.GqS = paramf;
    setVisibility(0);
    this.GlD.requestFocus();
    this.activity.showVKB();
    this.Grc = parama;
    paramf = paramf.fyd();
    paramf = "action=14&channelId=" + paramInt1 + "&mpScene=0&kykScene=" + paramf.Scene + "&kykSubScene=0&itemType=" + paramInt2 + "&searchId=" + paramf.Mbb + "&docId=" + paramf.MEq + "&byPass=" + paramf.MRt;
    com.tencent.mm.plugin.report.service.h.CyF.a(17080, new Object[] { Integer.valueOf(7), Integer.valueOf(2), paramf });
    AppMethodBeat.o(126661);
  }
  
  public final void fzY()
  {
    AppMethodBeat.i(126663);
    this.GlD.setText("");
    setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Gra.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    this.Gra.setLayoutParams(localLayoutParams);
    this.activity.hideVKB();
    this.Grb = false;
    if (this.Grc != null) {
      this.Grc.onDismiss();
    }
    AppMethodBeat.o(126663);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(126662);
    if (this.GlD.getText().toString().length() > 0)
    {
      com.tencent.mm.ui.base.h.a(this.activity, 2131766830, 0, 2131756033, 2131755917, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(126655);
          TopStoryCommentFloatDialog.this.fzY();
          AppMethodBeat.o(126655);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, 2131100063);
      AppMethodBeat.o(126662);
      return;
    }
    fzY();
    AppMethodBeat.o(126662);
  }
  
  public final void o(final MMActivity paramMMActivity)
  {
    AppMethodBeat.i(126660);
    this.activity = paramMMActivity;
    this.gyh = new com.tencent.mm.ui.tools.h(paramMMActivity);
    setOnClickListener(this.Grd);
    findViewById(2131297965).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126650);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        TopStoryCommentFloatDialog.this.hide();
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126650);
      }
    });
    this.uCE = ((TextView)findViewById(2131306057));
    this.uCE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126651);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if (System.currentTimeMillis() - TopStoryCommentFloatDialog.this.EPV < 500L)
        {
          a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126651);
          return;
        }
        TopStoryCommentFloatDialog.this.EPV = System.currentTimeMillis();
        paramAnonymousView = TopStoryCommentFloatDialog.this.GlD.getText().toString();
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
        if (!TopStoryCommentFloatDialog.dzA())
        {
          com.tencent.mm.ui.base.h.c(paramMMActivity, paramMMActivity.getString(2131760826), "", true);
          a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(126651);
          return;
        }
        TopStoryCommentFloatDialog.this.tipDialog = com.tencent.mm.ui.base.h.a(paramMMActivity, paramMMActivity.getString(2131755978), false, null);
        localObject = new f(TopStoryCommentFloatDialog.this.GqS);
        ((eik)((f)localObject).rr.iLK.iLR).iAc = paramAnonymousView;
        com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject, 0);
        a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryCommentFloatDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(126651);
      }
    });
    fyv();
    fzZ();
    this.GlD.addTextChangedListener(new TextWatcher()
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
        TopStoryCommentFloatDialog.this.gyh.start();
        AppMethodBeat.o(126653);
      }
    });
    AppMethodBeat.o(126660);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(126664);
    this.gyh.Quk = null;
    com.tencent.mm.kernel.g.azz().b(2906, this);
    AppMethodBeat.o(126664);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(126665);
    this.gyh.Quk = this;
    com.tencent.mm.kernel.g.azz().a(2906, this);
    AppMethodBeat.o(126665);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
      fzY();
      if (this.Grc != null) {
        this.Grc.fzQ();
      }
      if ((paramq instanceof f))
      {
        localf = (f)paramq;
        paramq = new com.tencent.mm.ab.i();
      }
    }
    for (;;)
    {
      try
      {
        paramString = (eik)localf.rr.iLK.iLR;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.iAc;
        paramq.h("content", paramString);
        paramq.h("id", localf.fyc().NhH);
        paramString = (eik)localf.rr.iLK.iLR;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.MEq;
        paramq.h("docId", paramString);
        paramq.h("opType", "REPLY_ARTICLE_BY_ME");
        paramString = new kn();
        paramString.dPD.dPE = paramq.toString();
        paramString.dPD.dPF = "";
        EventCenter.instance.publish(paramString);
      }
      catch (com.tencent.mm.ab.g paramString)
      {
        Log.e("MicroMsg.TopStoryCommentFloatDialog", "notify tl failed");
        continue;
      }
      u.makeText(this.activity, 2131766832, 0).show();
      AppMethodBeat.o(126669);
      return;
      paramInt1 = 0;
      break;
      paramString = "";
      continue;
      paramString = "";
    }
    label271:
    com.tencent.mm.ui.base.h.c(this.activity, this.activity.getString(2131755804), "", true);
    AppMethodBeat.o(126669);
  }
  
  public final void y(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126666);
    Log.i("MicroMsg.TopStoryCommentFloatDialog", "onKeyboardHeightChanged in pixels: ".concat(String.valueOf(paramInt)));
    Animation local5;
    if (this.Grb)
    {
      this.Gra.setVisibility(0);
      if (((RelativeLayout.LayoutParams)this.Gra.getLayoutParams()).bottomMargin != paramInt)
      {
        local5 = new Animation()
        {
          protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            AppMethodBeat.i(126654);
            paramAnonymousTransformation = (RelativeLayout.LayoutParams)TopStoryCommentFloatDialog.this.Gra.getLayoutParams();
            paramAnonymousTransformation.bottomMargin = ((int)(paramInt * paramAnonymousFloat));
            TopStoryCommentFloatDialog.this.Gra.setLayoutParams(paramAnonymousTransformation);
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
      this.Gra.startAnimation(local5);
      this.GlD.requestFocus();
      setVisibility(0);
      AppMethodBeat.o(126666);
      return;
      label103:
      local5.setDuration(300L);
    }
  }
  
  public static abstract interface a
  {
    public abstract void fzQ();
    
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog
 * JD-Core Version:    0.7.0.1
 */
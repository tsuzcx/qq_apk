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
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.kernel.d;
import com.tencent.mm.plugin.sns.ui.SnsEditText;
import com.tencent.mm.plugin.topstory.a.c.f;
import com.tencent.mm.protocal.protobuf.dcp;
import com.tencent.mm.protocal.protobuf.dcq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;

public class TopStoryCommentFloatDialog
  extends RelativeLayout
  implements com.tencent.mm.al.g, com.tencent.mm.ui.tools.g
{
  MMActivity activity;
  public com.tencent.mm.ui.tools.h ftZ;
  TextView sIt;
  p tipDialog;
  long xKA;
  TextView yNU;
  SnsEditText yNX;
  f yTl;
  View yTt;
  boolean yTu;
  a yTv;
  TextView yTw;
  private View.OnClickListener yTx;
  
  public TopStoryCommentFloatDialog(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126657);
    this.tipDialog = null;
    this.yTu = false;
    this.xKA = 0L;
    this.yTx = new View.OnClickListener()
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
    this.yTu = false;
    this.xKA = 0L;
    this.yTx = new View.OnClickListener()
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
  
  protected static boolean cyF()
  {
    AppMethodBeat.i(126670);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).agu())
    {
      i = com.tencent.mm.kernel.g.aeS().auR();
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
  
  private void dOz()
  {
    AppMethodBeat.i(126667);
    int j = this.yNX.getText().toString().length();
    if (j < 180)
    {
      this.sIt.setVisibility(8);
      this.yNU.setVisibility(8);
      AppMethodBeat.o(126667);
      return;
    }
    this.sIt.setVisibility(0);
    this.yNU.setVisibility(0);
    if (j <= 200) {}
    for (int i = getResources().getColor(2131101042);; i = getResources().getColor(2131100798))
    {
      this.sIt.setText(String.valueOf(j));
      this.sIt.setTextColor(i);
      AppMethodBeat.o(126667);
      return;
    }
  }
  
  private void dQj()
  {
    AppMethodBeat.i(126668);
    int i = this.yNX.getText().toString().length();
    int j = this.yNX.getText().toString().trim().length();
    if ((i > 200) || (i <= 0) || (j <= 0))
    {
      this.yTw.setBackgroundResource(2131234414);
      AppMethodBeat.o(126668);
      return;
    }
    this.yTw.setBackgroundResource(2131234413);
    AppMethodBeat.o(126668);
  }
  
  private void init()
  {
    AppMethodBeat.i(126659);
    inflate(getContext(), 2131495774, this);
    this.yTt = findViewById(2131298512);
    this.yNX = ((SnsEditText)findViewById(2131298540));
    this.sIt = ((TextView)findViewById(2131298381));
    this.yNU = ((TextView)findViewById(2131298382));
    AppMethodBeat.o(126659);
  }
  
  public final void a(f paramf, a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126661);
    this.yTu = true;
    this.yTl = paramf;
    setVisibility(0);
    this.yNX.requestFocus();
    this.activity.showVKB();
    this.yTv = parama;
    paramf = paramf.dOg();
    paramf = "action=14&channelId=" + paramInt1 + "&mpScene=0&kykScene=" + paramf.Scene + "&kykSubScene=0&itemType=" + paramInt2 + "&searchId=" + paramf.DLH + "&docId=" + paramf.DUZ + "&byPass=" + paramf.Efu;
    com.tencent.mm.plugin.report.service.h.vKh.f(17080, new Object[] { Integer.valueOf(7), Integer.valueOf(2), paramf });
    AppMethodBeat.o(126661);
  }
  
  public final void dQi()
  {
    AppMethodBeat.i(126663);
    this.yNX.setText("");
    setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.yTt.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    this.yTt.setLayoutParams(localLayoutParams);
    this.activity.hideVKB();
    this.yTu = false;
    if (this.yTv != null) {
      this.yTv.onDismiss();
    }
    AppMethodBeat.o(126663);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(126662);
    if (this.yNX.getText().toString().length() > 0)
    {
      com.tencent.mm.ui.base.h.a(this.activity, 2131764486, 0, 2131755939, 2131755831, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(126655);
          TopStoryCommentFloatDialog.this.dQi();
          AppMethodBeat.o(126655);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, 2131100035);
      AppMethodBeat.o(126662);
      return;
    }
    dQi();
    AppMethodBeat.o(126662);
  }
  
  public final void m(final MMActivity paramMMActivity)
  {
    AppMethodBeat.i(126660);
    this.activity = paramMMActivity;
    this.ftZ = new com.tencent.mm.ui.tools.h(paramMMActivity);
    setOnClickListener(this.yTx);
    findViewById(2131297692).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126650);
        TopStoryCommentFloatDialog.this.hide();
        AppMethodBeat.o(126650);
      }
    });
    this.yTw = ((TextView)findViewById(2131303360));
    this.yTw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(126651);
        if (System.currentTimeMillis() - TopStoryCommentFloatDialog.this.xKA < 500L)
        {
          AppMethodBeat.o(126651);
          return;
        }
        TopStoryCommentFloatDialog.this.xKA = System.currentTimeMillis();
        paramAnonymousView = TopStoryCommentFloatDialog.this.yNX.getText().toString();
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
        if (!TopStoryCommentFloatDialog.cyF())
        {
          com.tencent.mm.ui.base.h.c(paramMMActivity, paramMMActivity.getString(2131759511), "", true);
          AppMethodBeat.o(126651);
          return;
        }
        TopStoryCommentFloatDialog.this.tipDialog = com.tencent.mm.ui.base.h.b(paramMMActivity, paramMMActivity.getString(2131755886), false, null);
        f localf = new f(TopStoryCommentFloatDialog.this.yTl);
        ((dcp)localf.rr.gUS.gUX).gKr = paramAnonymousView;
        com.tencent.mm.kernel.g.aeS().a(localf, 0);
        AppMethodBeat.o(126651);
      }
    });
    dOz();
    dQj();
    this.yNX.addTextChangedListener(new TextWatcher()
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
        TopStoryCommentFloatDialog.this.ftZ.start();
        AppMethodBeat.o(126653);
      }
    });
    AppMethodBeat.o(126660);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(126664);
    this.ftZ.Hro = null;
    com.tencent.mm.kernel.g.aeS().b(2906, this);
    AppMethodBeat.o(126664);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(126665);
    this.ftZ.Hro = this;
    com.tencent.mm.kernel.g.aeS().a(2906, this);
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
      dQi();
      if (this.yTv != null) {
        this.yTv.dPY();
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
        paramString = (dcp)localf.rr.gUS.gUX;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.gKr;
        paramn.j("content", paramString);
        paramn.j("id", localf.dOf().Eud);
        paramString = (dcp)localf.rr.gUS.gUX;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.DUZ;
        paramn.j("docId", paramString);
        paramn.j("opType", "REPLY_ARTICLE_BY_ME");
        paramString = new ji();
        paramString.dnw.dnx = paramn.toString();
        paramString.dnw.dny = "";
        a.ESL.l(paramString);
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
    if (this.yTu)
    {
      this.yTt.setVisibility(0);
      if (((RelativeLayout.LayoutParams)this.yTt.getLayoutParams()).bottomMargin != paramInt)
      {
        local5 = new Animation()
        {
          protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            AppMethodBeat.i(126654);
            paramAnonymousTransformation = (RelativeLayout.LayoutParams)TopStoryCommentFloatDialog.this.yTt.getLayoutParams();
            paramAnonymousTransformation.bottomMargin = ((int)(paramInt * paramAnonymousFloat));
            TopStoryCommentFloatDialog.this.yTt.setLayoutParams(paramAnonymousTransformation);
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
      this.yTt.startAnimation(local5);
      this.yNX.requestFocus();
      setVisibility(0);
      AppMethodBeat.o(126666);
      return;
      label103:
      local5.setDuration(300L);
    }
  }
  
  public static abstract interface a
  {
    public abstract void dPY();
    
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.TopStoryCommentFloatDialog
 * JD-Core Version:    0.7.0.1
 */
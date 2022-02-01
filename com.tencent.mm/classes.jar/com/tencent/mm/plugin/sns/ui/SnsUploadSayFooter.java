package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputConnection;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.b;
import com.tencent.mm.ui.y;

public class SnsUploadSayFooter
  extends InputPanelLinearLayout
{
  ChatFooterPanel fSY;
  private MMActivity imP;
  private ImageButton tqu;
  private MMEditText xEy;
  private boolean xKh;
  private boolean xKi;
  private int xyi;
  private int xyj;
  private int xyk;
  
  public SnsUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99554);
    this.xEy = null;
    this.xyi = -1;
    this.xyj = -1;
    this.xyk = 0;
    this.xKh = true;
    this.xKi = false;
    this.imP = ((MMActivity)paramContext);
    this.tqu = ((ImageButton)((ViewGroup)y.js(this.imP).inflate(2131495619, this)).findViewById(2131296558));
    this.tqu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99549);
        SnsUploadSayFooter.b(SnsUploadSayFooter.this);
        AppMethodBeat.o(99549);
      }
    });
    if (e.Cgj == null)
    {
      this.fSY = new d(this.imP);
      AppMethodBeat.o(99554);
      return;
    }
    this.fSY = e.Cgj.es(getContext());
    this.fSY.setEntranceScene(ChatFooterPanel.vei);
    this.fSY.setVisibility(8);
    paramContext = (LinearLayout)findViewById(2131304239);
    paramContext.setOnClickListener(null);
    this.xyk = z.in(getContext());
    paramContext.addView(this.fSY, -1, this.xyk);
    this.fSY.exn();
    dBf();
    this.fSY.onResume();
    this.fSY.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(99551);
        try
        {
          SnsUploadSayFooter.c(SnsUploadSayFooter.this).aMd(paramAnonymousString);
          AppMethodBeat.o(99551);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(99551);
        }
      }
      
      public final void btF()
      {
        AppMethodBeat.i(99550);
        SnsUploadSayFooter.c(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        SnsUploadSayFooter.c(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(99550);
      }
      
      public final void cqY() {}
      
      public final void lf(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(99554);
  }
  
  private void btD()
  {
    AppMethodBeat.i(99560);
    this.xKi = false;
    this.fSY.onPause();
    if (z.ip(getContext()))
    {
      getInputPanelHelper().aI(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99552);
          SnsUploadSayFooter.d(SnsUploadSayFooter.this).setVisibility(8);
          AppMethodBeat.o(99552);
        }
      });
      AppMethodBeat.o(99560);
      return;
    }
    this.fSY.setVisibility(8);
    AppMethodBeat.o(99560);
  }
  
  private void dBf()
  {
    AppMethodBeat.i(99562);
    int i = z.in(getContext());
    this.fSY.setPortHeightPx(i);
    ViewGroup.LayoutParams localLayoutParams = this.fSY.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = i;
    }
    AppMethodBeat.o(99562);
  }
  
  public final void dCJ()
  {
    AppMethodBeat.i(99555);
    setVisibility(0);
    if (this.tqu != null) {
      this.tqu.setImageResource(2131234155);
    }
    AppMethodBeat.o(99555);
  }
  
  public final boolean dCK()
  {
    AppMethodBeat.i(99557);
    if (this.fSY.getVisibility() == 0)
    {
      AppMethodBeat.o(99557);
      return true;
    }
    AppMethodBeat.o(99557);
    return false;
  }
  
  public final void dCL()
  {
    AppMethodBeat.i(99558);
    btD();
    setVisibility(4);
    AppMethodBeat.o(99558);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(99561);
    ad.i("MicroMsg.SnsUploadSayFooter", "onInputPanelChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    super.g(paramBoolean, paramInt);
    if ((this.xyk != paramInt) && (paramInt != 0))
    {
      this.xyk = paramInt;
      i.A(getContext(), paramInt);
      dBf();
    }
    if (paramBoolean)
    {
      dCJ();
      AppMethodBeat.o(99561);
      return;
    }
    if (!this.xKi) {
      setVisibility(4);
    }
    AppMethodBeat.o(99561);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99559);
    super.onConfigurationChanged(paramConfiguration);
    if (this.fSY != null) {
      dBf();
    }
    AppMethodBeat.o(99559);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(99563);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.xyi < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.xyi)
    {
      this.xyi = paramInt1;
      this.xyj = paramInt4;
      AppMethodBeat.o(99563);
      return;
    }
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(99556);
    this.xEy = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99548);
        if (SnsUploadSayFooter.this.getVisibility() == 8) {
          SnsUploadSayFooter.this.setVisibility(0);
        }
        if (SnsUploadSayFooter.this.dCK()) {
          SnsUploadSayFooter.a(SnsUploadSayFooter.this);
        }
        AppMethodBeat.o(99548);
      }
    });
    paramMMEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return false;
      }
    });
    AppMethodBeat.o(99556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter
 * JD-Core Version:    0.7.0.1
 */
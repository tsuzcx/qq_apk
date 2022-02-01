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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.z;

public class SnsUploadSayFooter
  extends InputPanelLinearLayout
{
  private boolean AFU;
  private boolean AFV;
  private int AtG;
  private int AtH;
  private int AtI;
  private MMEditText AzX;
  private MMActivity fNT;
  ChatFooterPanel qdo;
  private ImageButton vNs;
  
  public SnsUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99554);
    this.AzX = null;
    this.AtG = -1;
    this.AtH = -1;
    this.AtI = 0;
    this.AFU = true;
    this.AFV = false;
    this.fNT = ((MMActivity)paramContext);
    this.vNs = ((ImageButton)((ViewGroup)z.jV(this.fNT).inflate(2131495619, this)).findViewById(2131296558));
    this.vNs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99549);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        SnsUploadSayFooter.b(SnsUploadSayFooter.this);
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99549);
      }
    });
    if (e.Fwh == null)
    {
      this.qdo = new d(this.fNT);
      AppMethodBeat.o(99554);
      return;
    }
    this.qdo = e.Fwh.eE(getContext());
    this.qdo.setEntranceScene(ChatFooterPanel.xKI);
    this.qdo.setVisibility(8);
    paramContext = (LinearLayout)findViewById(2131304239);
    paramContext.setOnClickListener(null);
    this.AtI = aa.iN(getContext());
    paramContext.addView(this.qdo, -1, this.AtI);
    this.qdo.fft();
    efA();
    this.qdo.onResume();
    this.qdo.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void apc()
      {
        AppMethodBeat.i(99550);
        SnsUploadSayFooter.c(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        SnsUploadSayFooter.c(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(99550);
      }
      
      public final void apd() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(99551);
        try
        {
          SnsUploadSayFooter.c(SnsUploadSayFooter.this).aZf(paramAnonymousString);
          AppMethodBeat.o(99551);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ae.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(99551);
        }
      }
      
      public final void dW(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(99554);
  }
  
  private void bFx()
  {
    AppMethodBeat.i(99560);
    this.AFV = false;
    this.qdo.onPause();
    if (aa.iP(getContext()))
    {
      getInputPanelHelper().aH(new Runnable()
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
    this.qdo.setVisibility(8);
    AppMethodBeat.o(99560);
  }
  
  private void efA()
  {
    AppMethodBeat.i(99562);
    int i = aa.iN(getContext());
    this.qdo.setPortHeightPx(i);
    ViewGroup.LayoutParams localLayoutParams = this.qdo.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = i;
    }
    AppMethodBeat.o(99562);
  }
  
  public final void ehf()
  {
    AppMethodBeat.i(99555);
    setVisibility(0);
    if (this.vNs != null) {
      this.vNs.setImageResource(2131234155);
    }
    AppMethodBeat.o(99555);
  }
  
  public final boolean ehg()
  {
    AppMethodBeat.i(99557);
    if (this.qdo.getVisibility() == 0)
    {
      AppMethodBeat.o(99557);
      return true;
    }
    AppMethodBeat.o(99557);
    return false;
  }
  
  public final void ehh()
  {
    AppMethodBeat.i(99558);
    bFx();
    setVisibility(4);
    AppMethodBeat.o(99558);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(99561);
    ae.i("MicroMsg.SnsUploadSayFooter", "onInputPanelChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    super.g(paramBoolean, paramInt);
    if ((this.AtI != paramInt) && (paramInt != 0))
    {
      this.AtI = paramInt;
      i.A(getContext(), paramInt);
      efA();
    }
    if (paramBoolean)
    {
      ehf();
      AppMethodBeat.o(99561);
      return;
    }
    if (!this.AFV) {
      setVisibility(4);
    }
    AppMethodBeat.o(99561);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99559);
    super.onConfigurationChanged(paramConfiguration);
    if (this.qdo != null) {
      efA();
    }
    AppMethodBeat.o(99559);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(99563);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.AtG < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.AtG)
    {
      this.AtG = paramInt1;
      this.AtH = paramInt4;
      AppMethodBeat.o(99563);
      return;
    }
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(99556);
    this.AzX = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99548);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (SnsUploadSayFooter.this.getVisibility() == 8) {
          SnsUploadSayFooter.this.setVisibility(0);
        }
        if (SnsUploadSayFooter.this.ehg()) {
          SnsUploadSayFooter.a(SnsUploadSayFooter.this);
        }
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
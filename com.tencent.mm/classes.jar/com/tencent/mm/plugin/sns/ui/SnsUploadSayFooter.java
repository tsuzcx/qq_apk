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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsUploadSayFooter
  extends InputPanelLinearLayout
{
  private int Act;
  private int Acu;
  private int Acv;
  private MMEditText AiM;
  private boolean AoH;
  private boolean AoI;
  private MMActivity fLP;
  ChatFooterPanel pWJ;
  private ImageButton vBo;
  
  public SnsUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99554);
    this.AiM = null;
    this.Act = -1;
    this.Acu = -1;
    this.Acv = 0;
    this.AoH = true;
    this.AoI = false;
    this.fLP = ((MMActivity)paramContext);
    this.vBo = ((ImageButton)((ViewGroup)com.tencent.mm.ui.z.jO(this.fLP).inflate(2131495619, this)).findViewById(2131296558));
    this.vBo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99549);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        SnsUploadSayFooter.b(SnsUploadSayFooter.this);
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(99549);
      }
    });
    if (e.FdJ == null)
    {
      this.pWJ = new d(this.fLP);
      AppMethodBeat.o(99554);
      return;
    }
    this.pWJ = e.FdJ.eA(getContext());
    this.pWJ.setEntranceScene(ChatFooterPanel.xuL);
    this.pWJ.setVisibility(8);
    paramContext = (LinearLayout)findViewById(2131304239);
    paramContext.setOnClickListener(null);
    this.Acv = com.tencent.mm.sdk.platformtools.z.iI(getContext());
    paramContext.addView(this.pWJ, -1, this.Acv);
    this.pWJ.fbF();
    ebT();
    this.pWJ.onResume();
    this.pWJ.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aoO()
      {
        AppMethodBeat.i(99550);
        SnsUploadSayFooter.c(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        SnsUploadSayFooter.c(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(99550);
      }
      
      public final void aoP() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(99551);
        try
        {
          SnsUploadSayFooter.c(SnsUploadSayFooter.this).aXD(paramAnonymousString);
          AppMethodBeat.o(99551);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(99551);
        }
      }
      
      public final void dU(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(99554);
  }
  
  private void bEF()
  {
    AppMethodBeat.i(99560);
    this.AoI = false;
    this.pWJ.onPause();
    if (com.tencent.mm.sdk.platformtools.z.iK(getContext()))
    {
      getInputPanelHelper().aK(new Runnable()
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
    this.pWJ.setVisibility(8);
    AppMethodBeat.o(99560);
  }
  
  private void ebT()
  {
    AppMethodBeat.i(99562);
    int i = com.tencent.mm.sdk.platformtools.z.iI(getContext());
    this.pWJ.setPortHeightPx(i);
    ViewGroup.LayoutParams localLayoutParams = this.pWJ.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = i;
    }
    AppMethodBeat.o(99562);
  }
  
  public final void edA()
  {
    AppMethodBeat.i(99558);
    bEF();
    setVisibility(4);
    AppMethodBeat.o(99558);
  }
  
  public final void edy()
  {
    AppMethodBeat.i(99555);
    setVisibility(0);
    if (this.vBo != null) {
      this.vBo.setImageResource(2131234155);
    }
    AppMethodBeat.o(99555);
  }
  
  public final boolean edz()
  {
    AppMethodBeat.i(99557);
    if (this.pWJ.getVisibility() == 0)
    {
      AppMethodBeat.o(99557);
      return true;
    }
    AppMethodBeat.o(99557);
    return false;
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(99561);
    ad.i("MicroMsg.SnsUploadSayFooter", "onInputPanelChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    super.g(paramBoolean, paramInt);
    if ((this.Acv != paramInt) && (paramInt != 0))
    {
      this.Acv = paramInt;
      i.A(getContext(), paramInt);
      ebT();
    }
    if (paramBoolean)
    {
      edy();
      AppMethodBeat.o(99561);
      return;
    }
    if (!this.AoI) {
      setVisibility(4);
    }
    AppMethodBeat.o(99561);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99559);
    super.onConfigurationChanged(paramConfiguration);
    if (this.pWJ != null) {
      ebT();
    }
    AppMethodBeat.o(99559);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(99563);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Act < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.Act)
    {
      this.Act = paramInt1;
      this.Acu = paramInt4;
      AppMethodBeat.o(99563);
      return;
    }
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(99556);
    this.AiM = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99548);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (SnsUploadSayFooter.this.getVisibility() == 8) {
          SnsUploadSayFooter.this.setVisibility(0);
        }
        if (SnsUploadSayFooter.this.edz()) {
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
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.cedit.api.c;
import com.tencent.mm.ui.widget.cedit.api.c.a;

public class SnsUploadSayFooter
  extends InputPanelLinearLayout
{
  private int ECP;
  private int ECQ;
  private c EPA;
  private boolean EPB;
  private boolean EPC;
  private MMActivity gte;
  private int moe;
  ChatFooterPanel rum;
  private ImageButton ziQ;
  
  public SnsUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99554);
    this.EPA = null;
    this.ECP = -1;
    this.ECQ = -1;
    this.moe = 0;
    this.EPB = true;
    this.EPC = false;
    this.gte = ((MMActivity)paramContext);
    this.ziQ = ((ImageButton)((ViewGroup)aa.jQ(this.gte).inflate(2131496518, this)).findViewById(2131296635));
    this.ziQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203760);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SnsUploadSayFooter.a(SnsUploadSayFooter.this);
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203760);
      }
    });
    if (e.Knc == null)
    {
      this.rum = new d(this.gte);
      AppMethodBeat.o(99554);
      return;
    }
    this.rum = e.Knc.eZ(getContext());
    this.rum.setEntranceScene(ChatFooterPanel.BKM);
    this.rum.setVisibility(8);
    paramContext = (LinearLayout)findViewById(2131307157);
    paramContext.setOnClickListener(null);
    this.moe = KeyBoardUtil.getValidPanelHeight(getContext());
    paramContext.addView(this.rum, -1, this.moe);
    this.rum.goD();
    fhZ();
    this.rum.onResume();
    this.rum.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aHC()
      {
        AppMethodBeat.i(203761);
        SnsUploadSayFooter.b(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        SnsUploadSayFooter.b(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(203761);
      }
      
      public final void aHD() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(203762);
        try
        {
          SnsUploadSayFooter.b(SnsUploadSayFooter.this).bol(paramAnonymousString);
          AppMethodBeat.o(203762);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(203762);
        }
      }
      
      public final void eP(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(99554);
  }
  
  private void cbM()
  {
    AppMethodBeat.i(99560);
    this.EPC = false;
    this.rum.onPause();
    if (KeyBoardUtil.isPortOrientation(getContext()))
    {
      getInputPanelHelper().aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203763);
          SnsUploadSayFooter.c(SnsUploadSayFooter.this).setVisibility(8);
          AppMethodBeat.o(203763);
        }
      });
      AppMethodBeat.o(99560);
      return;
    }
    this.rum.setVisibility(8);
    AppMethodBeat.o(99560);
  }
  
  private void fhZ()
  {
    AppMethodBeat.i(99562);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    this.rum.setPortHeightPx(i);
    ViewGroup.LayoutParams localLayoutParams = this.rum.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = i;
    }
    AppMethodBeat.o(99562);
  }
  
  public final void f(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(99561);
    Log.i("MicroMsg.SnsUploadSayFooter", "onInputPanelChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    super.f(paramBoolean, paramInt);
    if ((this.moe != paramInt) && (paramInt != 0))
    {
      this.moe = paramInt;
      i.C(getContext(), paramInt);
      fhZ();
    }
    if (paramBoolean)
    {
      fjH();
      AppMethodBeat.o(99561);
      return;
    }
    if (!this.EPC) {
      setVisibility(4);
    }
    AppMethodBeat.o(99561);
  }
  
  public final void fjH()
  {
    AppMethodBeat.i(99555);
    setVisibility(0);
    if (this.ziQ != null) {
      this.ziQ.setImageResource(2131235024);
    }
    AppMethodBeat.o(99555);
  }
  
  public final boolean fjI()
  {
    AppMethodBeat.i(99557);
    if (this.rum.getVisibility() == 0)
    {
      AppMethodBeat.o(99557);
      return true;
    }
    AppMethodBeat.o(99557);
    return false;
  }
  
  public final void fjJ()
  {
    AppMethodBeat.i(99558);
    cbM();
    setVisibility(4);
    AppMethodBeat.o(99558);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99559);
    super.onConfigurationChanged(paramConfiguration);
    if (this.rum != null) {
      fhZ();
    }
    AppMethodBeat.o(99559);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(99563);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.ECP < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.ECP)
    {
      this.ECP = paramInt1;
      this.ECQ = paramInt4;
      AppMethodBeat.o(99563);
      return;
    }
  }
  
  public void setMMEditText(c paramc)
  {
    AppMethodBeat.i(203764);
    this.EPA = paramc;
    paramc.a(new c.a()
    {
      public final boolean ZY(int paramAnonymousInt)
      {
        return false;
      }
    });
    AppMethodBeat.o(203764);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter
 * JD-Core Version:    0.7.0.1
 */
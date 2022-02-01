package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputConnection;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.cedit.api.c.a;

public class SnsUploadSayFooter
  extends InputPanelLinearLayout
{
  private ImageButton KIF;
  private com.tencent.mm.ui.widget.cedit.api.c RDE;
  private boolean RDF;
  private MMActivity lzt;
  ChatFooterPanel moD;
  private int moG;
  private int moH;
  private int moI;
  private boolean moJ;
  
  public SnsUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99554);
    this.RDE = null;
    this.moG = -1;
    this.moH = -1;
    this.moI = 0;
    this.moJ = true;
    this.RDF = false;
    this.lzt = ((MMActivity)paramContext);
    this.KIF = ((ImageButton)((ViewGroup)af.mU(this.lzt).inflate(b.g.sns_upload_say_footer, this)).findViewById(b.f.album_comment_mode_iv));
    this.KIF.setOnClickListener(new SnsUploadSayFooter.2(this));
    if (e.Ykf == null)
    {
      this.moD = new d(this.lzt);
      AppMethodBeat.o(99554);
      return;
    }
    this.moD = e.Ykf.fZ(getContext());
    this.moD.setEntranceScene(ChatFooterPanel.NEu);
    this.moD.setVisibility(8);
    paramContext = (LinearLayout)findViewById(b.f.root);
    paramContext.setOnClickListener(null);
    this.moI = KeyBoardUtil.getValidPanelHeight(getContext());
    paramContext.addView(this.moD, -1, this.moI);
    this.moD.iKh();
    aWK();
    this.moD.onResume();
    this.moD.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aWL() {}
      
      public final void aWM()
      {
        AppMethodBeat.i(307910);
        SnsUploadSayFooter.b(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        SnsUploadSayFooter.b(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(307910);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(307912);
        try
        {
          SnsUploadSayFooter.b(SnsUploadSayFooter.this).bDt(paramAnonymousString);
          AppMethodBeat.o(307912);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(307912);
        }
      }
      
      public final void fp(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(99554);
  }
  
  private void aWJ()
  {
    AppMethodBeat.i(99560);
    this.RDF = false;
    this.moD.onPause();
    if (KeyBoardUtil.isPortOrientation(getContext()))
    {
      getInputPanelHelper().be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(307907);
          SnsUploadSayFooter.c(SnsUploadSayFooter.this).setVisibility(8);
          AppMethodBeat.o(307907);
        }
      });
      AppMethodBeat.o(99560);
      return;
    }
    this.moD.setVisibility(8);
    AppMethodBeat.o(99560);
  }
  
  private void aWK()
  {
    AppMethodBeat.i(99562);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    this.moD.setPortHeightPx(i);
    ViewGroup.LayoutParams localLayoutParams = this.moD.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = i;
    }
    AppMethodBeat.o(99562);
  }
  
  public final void aWF()
  {
    AppMethodBeat.i(99555);
    setVisibility(0);
    if (this.KIF != null) {
      this.KIF.setImageResource(b.e.sns_upload_biaoqing_btn);
    }
    AppMethodBeat.o(99555);
  }
  
  public final void aWI()
  {
    AppMethodBeat.i(99558);
    aWJ();
    setVisibility(4);
    AppMethodBeat.o(99558);
  }
  
  public final boolean hqp()
  {
    AppMethodBeat.i(99557);
    if (this.moD.getVisibility() == 0)
    {
      AppMethodBeat.o(99557);
      return true;
    }
    AppMethodBeat.o(99557);
    return false;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99559);
    super.onConfigurationChanged(paramConfiguration);
    if (this.moD != null) {
      aWK();
    }
    AppMethodBeat.o(99559);
  }
  
  public void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(99561);
    Log.i("MicroMsg.SnsUploadSayFooter", "onInputPanelChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    super.onInputPanelChange(paramBoolean, paramInt);
    if ((this.moI != paramInt) && (paramInt != 0))
    {
      this.moI = paramInt;
      j.H(getContext(), paramInt);
      aWK();
    }
    if (paramBoolean)
    {
      aWF();
      AppMethodBeat.o(99561);
      return;
    }
    if (!this.RDF) {
      setVisibility(4);
    }
    AppMethodBeat.o(99561);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(99563);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.moG < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.moG)
    {
      this.moG = paramInt1;
      this.moH = paramInt4;
      AppMethodBeat.o(99563);
      return;
    }
  }
  
  public void setMMEditText(com.tencent.mm.ui.widget.cedit.api.c paramc)
  {
    AppMethodBeat.i(307702);
    this.RDE = paramc;
    paramc.a(new c.a()
    {
      public final boolean rR(int paramAnonymousInt)
      {
        return false;
      }
    });
    AppMethodBeat.o(307702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter
 * JD-Core Version:    0.7.0.1
 */
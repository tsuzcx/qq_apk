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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.cedit.api.c.a;

public class SnsUploadSayFooter
  extends InputPanelLinearLayout
{
  private ImageButton EOg;
  private com.tencent.mm.ui.widget.cedit.api.c Ldv;
  private boolean Ldw;
  private MMActivity iXq;
  ChatFooterPanel jPN;
  private int jPQ;
  private int jPR;
  private int jPS;
  private boolean jPT;
  
  public SnsUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99554);
    this.Ldv = null;
    this.jPQ = -1;
    this.jPR = -1;
    this.jPS = 0;
    this.jPT = true;
    this.Ldw = false;
    this.iXq = ((MMActivity)paramContext);
    this.EOg = ((ImageButton)((ViewGroup)ad.kS(this.iXq).inflate(i.g.sns_upload_say_footer, this)).findViewById(i.f.album_comment_mode_iv));
    this.EOg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(247275);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        SnsUploadSayFooter.a(SnsUploadSayFooter.this);
        a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadSayFooter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(247275);
      }
    });
    if (e.RnO == null)
    {
      this.jPN = new d(this.iXq);
      AppMethodBeat.o(99554);
      return;
    }
    this.jPN = e.RnO.fd(getContext());
    this.jPN.setEntranceScene(ChatFooterPanel.HGX);
    this.jPN.setVisibility(8);
    paramContext = (LinearLayout)findViewById(i.f.root);
    paramContext.setOnClickListener(null);
    this.jPS = KeyBoardUtil.getValidPanelHeight(getContext());
    paramContext.addView(this.jPN, -1, this.jPS);
    this.jPN.hjp();
    aDM();
    this.jPN.onResume();
    this.jPN.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aDN() {}
      
      public final void aDO()
      {
        AppMethodBeat.i(266975);
        SnsUploadSayFooter.b(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        SnsUploadSayFooter.b(SnsUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(266975);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(266976);
        try
        {
          SnsUploadSayFooter.b(SnsUploadSayFooter.this).bBa(paramAnonymousString);
          AppMethodBeat.o(266976);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(266976);
        }
      }
      
      public final void eE(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(99554);
  }
  
  private void aDL()
  {
    AppMethodBeat.i(99560);
    this.Ldw = false;
    this.jPN.onPause();
    if (KeyBoardUtil.isPortOrientation(getContext()))
    {
      getInputPanelHelper().aW(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(197108);
          SnsUploadSayFooter.c(SnsUploadSayFooter.this).setVisibility(8);
          AppMethodBeat.o(197108);
        }
      });
      AppMethodBeat.o(99560);
      return;
    }
    this.jPN.setVisibility(8);
    AppMethodBeat.o(99560);
  }
  
  private void aDM()
  {
    AppMethodBeat.i(99562);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    this.jPN.setPortHeightPx(i);
    ViewGroup.LayoutParams localLayoutParams = this.jPN.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = i;
    }
    AppMethodBeat.o(99562);
  }
  
  public final void aDG()
  {
    AppMethodBeat.i(99555);
    setVisibility(0);
    if (this.EOg != null) {
      this.EOg.setImageResource(i.e.sns_upload_biaoqing_btn);
    }
    AppMethodBeat.o(99555);
  }
  
  public final void aDK()
  {
    AppMethodBeat.i(99558);
    aDL();
    setVisibility(4);
    AppMethodBeat.o(99558);
  }
  
  public final boolean fXU()
  {
    AppMethodBeat.i(99557);
    if (this.jPN.getVisibility() == 0)
    {
      AppMethodBeat.o(99557);
      return true;
    }
    AppMethodBeat.o(99557);
    return false;
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(99561);
    Log.i("MicroMsg.SnsUploadSayFooter", "onInputPanelChange: %s, %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    super.h(paramBoolean, paramInt);
    if ((this.jPS != paramInt) && (paramInt != 0))
    {
      this.jPS = paramInt;
      i.E(getContext(), paramInt);
      aDM();
    }
    if (paramBoolean)
    {
      aDG();
      AppMethodBeat.o(99561);
      return;
    }
    if (!this.Ldw) {
      setVisibility(4);
    }
    AppMethodBeat.o(99561);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99559);
    super.onConfigurationChanged(paramConfiguration);
    if (this.jPN != null) {
      aDM();
    }
    AppMethodBeat.o(99559);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(99563);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jPQ < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.jPQ)
    {
      this.jPQ = paramInt1;
      this.jPR = paramInt4;
      AppMethodBeat.o(99563);
      return;
    }
  }
  
  public void setMMEditText(com.tencent.mm.ui.widget.cedit.api.c paramc)
  {
    AppMethodBeat.i(267393);
    this.Ldv = paramc;
    paramc.a(new c.a()
    {
      public final boolean rQ(int paramAnonymousInt)
      {
        return false;
      }
    });
    AppMethodBeat.o(267393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadSayFooter
 * JD-Core Version:    0.7.0.1
 */
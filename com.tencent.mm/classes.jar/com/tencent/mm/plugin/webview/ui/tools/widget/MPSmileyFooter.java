package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputConnection;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.webview.c.b;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class MPSmileyFooter
  extends InputPanelLinearLayout
{
  private WeImageView Gol;
  private MMEditText KXu = null;
  private LinearLayout Qxn;
  private LinearLayout Qxo;
  private int Qxp = 0;
  private boolean Qxq = false;
  private MMActivity activity;
  private Context context;
  private ChatFooterPanel jPN;
  private int jPQ = -1;
  private int jPR = -1;
  private int jPS = 0;
  private boolean jPT = true;
  
  public MPSmileyFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  private void aDL()
  {
    AppMethodBeat.i(82259);
    this.jPN.onPause();
    this.jPN.setVisibility(8);
    AppMethodBeat.o(82259);
  }
  
  private void aDM()
  {
    AppMethodBeat.i(82261);
    ViewGroup.LayoutParams localLayoutParams = this.Qxn.getLayoutParams();
    localLayoutParams.height = (this.jPS + this.Qxp);
    this.Qxn.setLayoutParams(localLayoutParams);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    this.jPN.setPortHeightPx(i);
    localLayoutParams = this.jPN.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = i;
    }
    AppMethodBeat.o(82261);
  }
  
  private int aoW(int paramInt)
  {
    AppMethodBeat.i(82250);
    TypedValue localTypedValue = new TypedValue();
    this.context.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    paramInt = localTypedValue.resourceId;
    AppMethodBeat.o(82250);
    return paramInt;
  }
  
  private MMActivity getActivity()
  {
    AppMethodBeat.i(82249);
    if (this.activity == null) {
      if (!(this.context instanceof MMActivity)) {
        break label45;
      }
    }
    Object localObject;
    for (this.activity = ((MMActivity)this.context);; this.activity = ((MMActivity)localObject))
    {
      localObject = this.activity;
      AppMethodBeat.o(82249);
      return localObject;
      label45:
      for (localObject = this.context; (!(localObject instanceof MMActivity)) && ((localObject instanceof ContextWrapper)); localObject = ((ContextWrapper)localObject).getBaseContext()) {}
    }
  }
  
  public final void Af(boolean paramBoolean)
  {
    AppMethodBeat.i(82257);
    this.Gol = ((WeImageView)((ViewGroup)com.tencent.mm.ui.ad.kS(this.context).inflate(c.g.mp_smiley_footer, this)).findViewById(c.f.album_comment_mode_iv));
    this.Gol.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82246);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        MPSmileyFooter.b(MPSmileyFooter.this);
        a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82246);
      }
    });
    this.jPN = com.tencent.mm.api.ad.m(this.context, paramBoolean);
    if (this.jPN == null)
    {
      this.jPN = new d(this.context);
      AppMethodBeat.o(82257);
      return;
    }
    this.jPN.setEntranceScene(ChatFooterPanel.HGX);
    this.jPN.setVisibility(8);
    this.Qxn = ((LinearLayout)findViewById(c.f.smiley_root));
    this.Qxo = ((LinearLayout)findViewById(c.f.mode_root));
    this.Qxn.setOnClickListener(null);
    this.jPS = KeyBoardUtil.getValidPanelHeight(getContext());
    this.Qxn.addView(this.jPN, -1, this.jPS);
    this.jPN.hjp();
    this.jPN.onResume();
    aDM();
    this.jPN.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aDN() {}
      
      public final void aDO()
      {
        AppMethodBeat.i(82247);
        MPSmileyFooter.c(MPSmileyFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        MPSmileyFooter.c(MPSmileyFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(82247);
      }
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(82248);
        try
        {
          MPSmileyFooter.c(MPSmileyFooter.this).bBa(paramAnonymousString);
          AppMethodBeat.o(82248);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(82248);
        }
      }
      
      public final void eE(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(82257);
  }
  
  public final void aDG()
  {
    AppMethodBeat.i(82251);
    setVisibility(0);
    if (this.Gol != null) {
      this.Gol.setImageResource(aoW(c.b.comment_panel_smiley_icon));
    }
    AppMethodBeat.o(82251);
  }
  
  public final void aDH()
  {
    AppMethodBeat.i(82252);
    if (fXU())
    {
      AppMethodBeat.o(82252);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(82252);
  }
  
  public final void aDK()
  {
    AppMethodBeat.i(82256);
    aDL();
    setVisibility(8);
    AppMethodBeat.o(82256);
  }
  
  public final boolean fXU()
  {
    AppMethodBeat.i(82255);
    if (this.jPN.getVisibility() == 0)
    {
      AppMethodBeat.o(82255);
      return true;
    }
    AppMethodBeat.o(82255);
    return false;
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(82260);
    super.h(paramBoolean, paramInt);
    if ((this.jPS != paramInt) && (paramInt != 0))
    {
      this.jPS = paramInt;
      i.E(getContext(), paramInt);
      aDM();
    }
    AppMethodBeat.o(82260);
  }
  
  public final boolean hbX()
  {
    AppMethodBeat.i(82254);
    if ((fXU()) || (getVisibility() == 0))
    {
      AppMethodBeat.o(82254);
      return true;
    }
    AppMethodBeat.o(82254);
    return false;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82258);
    super.onConfigurationChanged(paramConfiguration);
    if (this.jPN != null) {
      aDM();
    }
    AppMethodBeat.o(82258);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82263);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jPQ < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.jPQ)
    {
      this.jPQ = paramInt1;
      this.jPR = paramInt4;
      AppMethodBeat.o(82263);
      return;
    }
  }
  
  public void setExtraAddHeight(int paramInt)
  {
    this.Qxp = paramInt;
  }
  
  public void setFobbidenWhenLandscape(boolean paramBoolean)
  {
    this.Qxq = paramBoolean;
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(82253);
    this.KXu = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82245);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (MPSmileyFooter.this.getVisibility() == 8) {
          MPSmileyFooter.this.setVisibility(0);
        }
        if (MPSmileyFooter.this.fXU()) {
          MPSmileyFooter.a(MPSmileyFooter.this);
        }
        a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82245);
      }
    });
    paramMMEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return false;
      }
    });
    AppMethodBeat.o(82253);
  }
  
  public void setSmileHeight(int paramInt)
  {
    AppMethodBeat.i(82264);
    ViewGroup.LayoutParams localLayoutParams = this.Qxn.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.Qxn.setLayoutParams(localLayoutParams);
    paramInt = KeyBoardUtil.getValidPanelHeight(getContext());
    this.jPN.setPortHeightPx(paramInt);
    localLayoutParams = this.jPN.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = paramInt;
    }
    AppMethodBeat.o(82264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.api.ad;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class MPSmileyFooter
  extends InputPanelLinearLayout
{
  private WeImageView AxC;
  private int ECP = -1;
  private int ECQ = -1;
  private MMEditText EJt = null;
  private boolean EPB = true;
  private LinearLayout Jzc;
  private LinearLayout Jzd;
  private int Jze = 0;
  private boolean Jzf = false;
  private MMActivity activity;
  private Context context;
  private int moe = 0;
  public ChatFooterPanel rum;
  
  public MPSmileyFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  private int ahf(int paramInt)
  {
    AppMethodBeat.i(82250);
    TypedValue localTypedValue = new TypedValue();
    this.context.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    paramInt = localTypedValue.resourceId;
    AppMethodBeat.o(82250);
    return paramInt;
  }
  
  private void cbM()
  {
    AppMethodBeat.i(82259);
    this.rum.onPause();
    this.rum.setVisibility(8);
    AppMethodBeat.o(82259);
  }
  
  private void fhZ()
  {
    AppMethodBeat.i(82261);
    ViewGroup.LayoutParams localLayoutParams = this.Jzc.getLayoutParams();
    localLayoutParams.height = (this.moe + this.Jze);
    this.Jzc.setLayoutParams(localLayoutParams);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    this.rum.setPortHeightPx(i);
    localLayoutParams = this.rum.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = i;
    }
    AppMethodBeat.o(82261);
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
  
  public final void f(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(82260);
    super.f(paramBoolean, paramInt);
    if ((this.moe != paramInt) && (paramInt != 0))
    {
      this.moe = paramInt;
      i.C(getContext(), paramInt);
      fhZ();
    }
    AppMethodBeat.o(82260);
  }
  
  public final void fjH()
  {
    AppMethodBeat.i(82251);
    setVisibility(0);
    if (this.AxC != null) {
      this.AxC.setImageResource(ahf(2130968864));
    }
    AppMethodBeat.o(82251);
  }
  
  public final boolean fjI()
  {
    AppMethodBeat.i(82255);
    if (this.rum.getVisibility() == 0)
    {
      AppMethodBeat.o(82255);
      return true;
    }
    AppMethodBeat.o(82255);
    return false;
  }
  
  public final void fjJ()
  {
    AppMethodBeat.i(82256);
    cbM();
    setVisibility(8);
    AppMethodBeat.o(82256);
  }
  
  public final void giv()
  {
    AppMethodBeat.i(82252);
    if (fjI())
    {
      AppMethodBeat.o(82252);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(82252);
  }
  
  public final boolean giw()
  {
    AppMethodBeat.i(82254);
    if ((fjI()) || (getVisibility() == 0))
    {
      AppMethodBeat.o(82254);
      return true;
    }
    AppMethodBeat.o(82254);
    return false;
  }
  
  public final void init(boolean paramBoolean)
  {
    AppMethodBeat.i(82257);
    this.AxC = ((WeImageView)((ViewGroup)aa.jQ(this.context).inflate(2131495694, this)).findViewById(2131296635));
    this.AxC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82246);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        MPSmileyFooter.b(MPSmileyFooter.this);
        a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82246);
      }
    });
    this.rum = ad.l(this.context, paramBoolean);
    if (this.rum == null)
    {
      this.rum = new d(this.context);
      AppMethodBeat.o(82257);
      return;
    }
    this.rum.setEntranceScene(ChatFooterPanel.BKM);
    this.rum.setVisibility(8);
    this.Jzc = ((LinearLayout)findViewById(2131307961));
    this.Jzd = ((LinearLayout)findViewById(2131304825));
    this.Jzc.setOnClickListener(null);
    this.moe = KeyBoardUtil.getValidPanelHeight(getContext());
    this.Jzc.addView(this.rum, -1, this.moe);
    this.rum.goD();
    this.rum.onResume();
    fhZ();
    this.rum.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aHC()
      {
        AppMethodBeat.i(82247);
        MPSmileyFooter.c(MPSmileyFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        MPSmileyFooter.c(MPSmileyFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(82247);
      }
      
      public final void aHD() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(82248);
        try
        {
          MPSmileyFooter.c(MPSmileyFooter.this).bol(paramAnonymousString);
          AppMethodBeat.o(82248);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(82248);
        }
      }
      
      public final void eP(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(82257);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82258);
    super.onConfigurationChanged(paramConfiguration);
    if (this.rum != null) {
      fhZ();
    }
    AppMethodBeat.o(82258);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82263);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.ECP < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.ECP)
    {
      this.ECP = paramInt1;
      this.ECQ = paramInt4;
      AppMethodBeat.o(82263);
      return;
    }
  }
  
  public void setExtraAddHeight(int paramInt)
  {
    this.Jze = paramInt;
  }
  
  public void setFobbidenWhenLandscape(boolean paramBoolean)
  {
    this.Jzf = paramBoolean;
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(82253);
    this.EJt = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82245);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (MPSmileyFooter.this.getVisibility() == 8) {
          MPSmileyFooter.this.setVisibility(0);
        }
        if (MPSmileyFooter.this.fjI()) {
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
    ViewGroup.LayoutParams localLayoutParams = this.Jzc.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.Jzc.setLayoutParams(localLayoutParams);
    paramInt = KeyBoardUtil.getValidPanelHeight(getContext());
    this.rum.setPortHeightPx(paramInt);
    localLayoutParams = this.rum.getLayoutParams();
    if (localLayoutParams != null) {
      localLayoutParams.height = paramInt;
    }
    AppMethodBeat.o(82264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MPSmileyFooter
 * JD-Core Version:    0.7.0.1
 */
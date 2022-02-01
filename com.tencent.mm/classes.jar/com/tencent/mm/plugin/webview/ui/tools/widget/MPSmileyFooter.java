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
import com.tencent.mm.api.aa;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;

public class MPSmileyFooter
  extends InputPanelLinearLayout
{
  private WeImageView BuM;
  private LinearLayout BuN;
  private LinearLayout BuO;
  private int BuP = 0;
  private boolean BuQ = false;
  private MMActivity activity;
  private Context context;
  public ChatFooterPanel fSY;
  private MMEditText xEy = null;
  private boolean xKh = true;
  private int xyi = -1;
  private int xyj = -1;
  private int xyk = 0;
  
  public MPSmileyFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  private int TP(int paramInt)
  {
    AppMethodBeat.i(82250);
    TypedValue localTypedValue = new TypedValue();
    this.context.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    paramInt = localTypedValue.resourceId;
    AppMethodBeat.o(82250);
    return paramInt;
  }
  
  private void btD()
  {
    AppMethodBeat.i(82259);
    this.fSY.onPause();
    this.fSY.setVisibility(8);
    AppMethodBeat.o(82259);
  }
  
  private void dBf()
  {
    AppMethodBeat.i(82261);
    ViewGroup.LayoutParams localLayoutParams = this.BuN.getLayoutParams();
    localLayoutParams.height = (this.xyk + this.BuP);
    this.BuN.setLayoutParams(localLayoutParams);
    int i = z.in(getContext());
    this.fSY.setPortHeightPx(i);
    localLayoutParams = this.fSY.getLayoutParams();
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
  
  public final void dCJ()
  {
    AppMethodBeat.i(82251);
    setVisibility(0);
    if (this.BuM != null) {
      this.BuM.setImageResource(TP(2130968849));
    }
    AppMethodBeat.o(82251);
  }
  
  public final boolean dCK()
  {
    AppMethodBeat.i(82255);
    if (this.fSY.getVisibility() == 0)
    {
      AppMethodBeat.o(82255);
      return true;
    }
    AppMethodBeat.o(82255);
    return false;
  }
  
  public final void dCL()
  {
    AppMethodBeat.i(82256);
    btD();
    setVisibility(8);
    AppMethodBeat.o(82256);
  }
  
  public final void eri()
  {
    AppMethodBeat.i(82252);
    if (dCK())
    {
      AppMethodBeat.o(82252);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(82252);
  }
  
  public final boolean erj()
  {
    AppMethodBeat.i(82254);
    if ((dCK()) || (getVisibility() == 0))
    {
      AppMethodBeat.o(82254);
      return true;
    }
    AppMethodBeat.o(82254);
    return false;
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(82260);
    super.g(paramBoolean, paramInt);
    if ((this.xyk != paramInt) && (paramInt != 0))
    {
      this.xyk = paramInt;
      i.A(getContext(), paramInt);
      dBf();
    }
    AppMethodBeat.o(82260);
  }
  
  public final void init(boolean paramBoolean)
  {
    AppMethodBeat.i(82257);
    this.BuM = ((WeImageView)((ViewGroup)y.js(this.context).inflate(2131494951, this)).findViewById(2131296558));
    this.BuM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82246);
        MPSmileyFooter.b(MPSmileyFooter.this);
        AppMethodBeat.o(82246);
      }
    });
    this.fSY = aa.k(this.context, paramBoolean);
    if (this.fSY == null)
    {
      this.fSY = new d(this.context);
      AppMethodBeat.o(82257);
      return;
    }
    this.fSY.setEntranceScene(ChatFooterPanel.vei);
    this.fSY.setVisibility(8);
    this.BuN = ((LinearLayout)findViewById(2131304875));
    this.BuO = ((LinearLayout)findViewById(2131302426));
    this.BuN.setOnClickListener(null);
    this.xyk = z.in(getContext());
    this.BuN.addView(this.fSY, -1, this.xyk);
    this.fSY.exn();
    this.fSY.onResume();
    dBf();
    this.fSY.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(82248);
        try
        {
          MPSmileyFooter.c(MPSmileyFooter.this).aMd(paramAnonymousString);
          AppMethodBeat.o(82248);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(82248);
        }
      }
      
      public final void btF()
      {
        AppMethodBeat.i(82247);
        MPSmileyFooter.c(MPSmileyFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        MPSmileyFooter.c(MPSmileyFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(82247);
      }
      
      public final void cqY() {}
      
      public final void lf(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(82257);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82258);
    super.onConfigurationChanged(paramConfiguration);
    if (this.fSY != null) {
      dBf();
    }
    AppMethodBeat.o(82258);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82263);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.xyi < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.xyi)
    {
      this.xyi = paramInt1;
      this.xyj = paramInt4;
      AppMethodBeat.o(82263);
      return;
    }
  }
  
  public void setExtraAddHeight(int paramInt)
  {
    this.BuP = paramInt;
  }
  
  public void setFobbidenWhenLandscape(boolean paramBoolean)
  {
    this.BuQ = paramBoolean;
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(82253);
    this.xEy = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82245);
        if (MPSmileyFooter.this.getVisibility() == 8) {
          MPSmileyFooter.this.setVisibility(0);
        }
        if (MPSmileyFooter.this.dCK()) {
          MPSmileyFooter.a(MPSmileyFooter.this);
        }
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
    ViewGroup.LayoutParams localLayoutParams = this.BuN.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.BuN.setLayoutParams(localLayoutParams);
    paramInt = z.in(getContext());
    this.fSY.setPortHeightPx(paramInt);
    localLayoutParams = this.fSY.getLayoutParams();
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
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
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.z;

public class MPSmileyFooter
  extends InputPanelLinearLayout
{
  private boolean AFU = true;
  private int AtG = -1;
  private int AtH = -1;
  private int AtI = 0;
  private MMEditText AzX = null;
  private WeImageView EJl;
  private LinearLayout EJm;
  private LinearLayout EJn;
  private int EJo = 0;
  private boolean EJp = false;
  private MMActivity activity;
  private Context context;
  public ChatFooterPanel qdo;
  
  public MPSmileyFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  private int Yu(int paramInt)
  {
    AppMethodBeat.i(82250);
    TypedValue localTypedValue = new TypedValue();
    this.context.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    paramInt = localTypedValue.resourceId;
    AppMethodBeat.o(82250);
    return paramInt;
  }
  
  private void bFx()
  {
    AppMethodBeat.i(82259);
    this.qdo.onPause();
    this.qdo.setVisibility(8);
    AppMethodBeat.o(82259);
  }
  
  private void efA()
  {
    AppMethodBeat.i(82261);
    ViewGroup.LayoutParams localLayoutParams = this.EJm.getLayoutParams();
    localLayoutParams.height = (this.AtI + this.EJo);
    this.EJm.setLayoutParams(localLayoutParams);
    int i = com.tencent.mm.sdk.platformtools.aa.iN(getContext());
    this.qdo.setPortHeightPx(i);
    localLayoutParams = this.qdo.getLayoutParams();
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
  
  public final void eZp()
  {
    AppMethodBeat.i(82252);
    if (ehg())
    {
      AppMethodBeat.o(82252);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(82252);
  }
  
  public final boolean eZq()
  {
    AppMethodBeat.i(82254);
    if ((ehg()) || (getVisibility() == 0))
    {
      AppMethodBeat.o(82254);
      return true;
    }
    AppMethodBeat.o(82254);
    return false;
  }
  
  public final void ehf()
  {
    AppMethodBeat.i(82251);
    setVisibility(0);
    if (this.EJl != null) {
      this.EJl.setImageResource(Yu(2130968849));
    }
    AppMethodBeat.o(82251);
  }
  
  public final boolean ehg()
  {
    AppMethodBeat.i(82255);
    if (this.qdo.getVisibility() == 0)
    {
      AppMethodBeat.o(82255);
      return true;
    }
    AppMethodBeat.o(82255);
    return false;
  }
  
  public final void ehh()
  {
    AppMethodBeat.i(82256);
    bFx();
    setVisibility(8);
    AppMethodBeat.o(82256);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(82260);
    super.g(paramBoolean, paramInt);
    if ((this.AtI != paramInt) && (paramInt != 0))
    {
      this.AtI = paramInt;
      i.A(getContext(), paramInt);
      efA();
    }
    AppMethodBeat.o(82260);
  }
  
  public final void init(boolean paramBoolean)
  {
    AppMethodBeat.i(82257);
    this.EJl = ((WeImageView)((ViewGroup)z.jV(this.context).inflate(2131494951, this)).findViewById(2131296558));
    this.EJl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82246);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        MPSmileyFooter.b(MPSmileyFooter.this);
        a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82246);
      }
    });
    this.qdo = com.tencent.mm.api.aa.k(this.context, paramBoolean);
    if (this.qdo == null)
    {
      this.qdo = new d(this.context);
      AppMethodBeat.o(82257);
      return;
    }
    this.qdo.setEntranceScene(ChatFooterPanel.xKI);
    this.qdo.setVisibility(8);
    this.EJm = ((LinearLayout)findViewById(2131304875));
    this.EJn = ((LinearLayout)findViewById(2131302426));
    this.EJm.setOnClickListener(null);
    this.AtI = com.tencent.mm.sdk.platformtools.aa.iN(getContext());
    this.EJm.addView(this.qdo, -1, this.AtI);
    this.qdo.fft();
    this.qdo.onResume();
    efA();
    this.qdo.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void apc()
      {
        AppMethodBeat.i(82247);
        MPSmileyFooter.c(MPSmileyFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        MPSmileyFooter.c(MPSmileyFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(82247);
      }
      
      public final void apd() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(82248);
        try
        {
          MPSmileyFooter.c(MPSmileyFooter.this).aZf(paramAnonymousString);
          AppMethodBeat.o(82248);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ae.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(82248);
        }
      }
      
      public final void dW(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(82257);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82258);
    super.onConfigurationChanged(paramConfiguration);
    if (this.qdo != null) {
      efA();
    }
    AppMethodBeat.o(82258);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82263);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.AtG < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.AtG)
    {
      this.AtG = paramInt1;
      this.AtH = paramInt4;
      AppMethodBeat.o(82263);
      return;
    }
  }
  
  public void setExtraAddHeight(int paramInt)
  {
    this.EJo = paramInt;
  }
  
  public void setFobbidenWhenLandscape(boolean paramBoolean)
  {
    this.EJp = paramBoolean;
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(82253);
    this.AzX = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82245);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (MPSmileyFooter.this.getVisibility() == 8) {
          MPSmileyFooter.this.setVisibility(0);
        }
        if (MPSmileyFooter.this.ehg()) {
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
    ViewGroup.LayoutParams localLayoutParams = this.EJm.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.EJm.setLayoutParams(localLayoutParams);
    paramInt = com.tencent.mm.sdk.platformtools.aa.iN(getContext());
    this.qdo.setPortHeightPx(paramInt);
    localLayoutParams = this.qdo.getLayoutParams();
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
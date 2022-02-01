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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class MPSmileyFooter
  extends InputPanelLinearLayout
{
  private int Act = -1;
  private int Acu = -1;
  private int Acv = 0;
  private MMEditText AiM = null;
  private boolean AoH = true;
  private WeImageView EqV;
  private LinearLayout EqW;
  private LinearLayout EqX;
  private int EqY = 0;
  private boolean EqZ = false;
  private MMActivity activity;
  private Context context;
  public ChatFooterPanel pWJ;
  
  public MPSmileyFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  private int XO(int paramInt)
  {
    AppMethodBeat.i(82250);
    TypedValue localTypedValue = new TypedValue();
    this.context.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    paramInt = localTypedValue.resourceId;
    AppMethodBeat.o(82250);
    return paramInt;
  }
  
  private void bEF()
  {
    AppMethodBeat.i(82259);
    this.pWJ.onPause();
    this.pWJ.setVisibility(8);
    AppMethodBeat.o(82259);
  }
  
  private void ebT()
  {
    AppMethodBeat.i(82261);
    ViewGroup.LayoutParams localLayoutParams = this.EqW.getLayoutParams();
    localLayoutParams.height = (this.Acv + this.EqY);
    this.EqW.setLayoutParams(localLayoutParams);
    int i = com.tencent.mm.sdk.platformtools.z.iI(getContext());
    this.pWJ.setPortHeightPx(i);
    localLayoutParams = this.pWJ.getLayoutParams();
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
  
  public final void eVC()
  {
    AppMethodBeat.i(82252);
    if (edz())
    {
      AppMethodBeat.o(82252);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(82252);
  }
  
  public final boolean eVD()
  {
    AppMethodBeat.i(82254);
    if ((edz()) || (getVisibility() == 0))
    {
      AppMethodBeat.o(82254);
      return true;
    }
    AppMethodBeat.o(82254);
    return false;
  }
  
  public final void edA()
  {
    AppMethodBeat.i(82256);
    bEF();
    setVisibility(8);
    AppMethodBeat.o(82256);
  }
  
  public final void edy()
  {
    AppMethodBeat.i(82251);
    setVisibility(0);
    if (this.EqV != null) {
      this.EqV.setImageResource(XO(2130968849));
    }
    AppMethodBeat.o(82251);
  }
  
  public final boolean edz()
  {
    AppMethodBeat.i(82255);
    if (this.pWJ.getVisibility() == 0)
    {
      AppMethodBeat.o(82255);
      return true;
    }
    AppMethodBeat.o(82255);
    return false;
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(82260);
    super.g(paramBoolean, paramInt);
    if ((this.Acv != paramInt) && (paramInt != 0))
    {
      this.Acv = paramInt;
      i.A(getContext(), paramInt);
      ebT();
    }
    AppMethodBeat.o(82260);
  }
  
  public final void init(boolean paramBoolean)
  {
    AppMethodBeat.i(82257);
    this.EqV = ((WeImageView)((ViewGroup)com.tencent.mm.ui.z.jO(this.context).inflate(2131494951, this)).findViewById(2131296558));
    this.EqV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82246);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        MPSmileyFooter.b(MPSmileyFooter.this);
        a.a(this, "com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(82246);
      }
    });
    this.pWJ = aa.k(this.context, paramBoolean);
    if (this.pWJ == null)
    {
      this.pWJ = new d(this.context);
      AppMethodBeat.o(82257);
      return;
    }
    this.pWJ.setEntranceScene(ChatFooterPanel.xuL);
    this.pWJ.setVisibility(8);
    this.EqW = ((LinearLayout)findViewById(2131304875));
    this.EqX = ((LinearLayout)findViewById(2131302426));
    this.EqW.setOnClickListener(null);
    this.Acv = com.tencent.mm.sdk.platformtools.z.iI(getContext());
    this.EqW.addView(this.pWJ, -1, this.Acv);
    this.pWJ.fbF();
    this.pWJ.onResume();
    ebT();
    this.pWJ.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aoO()
      {
        AppMethodBeat.i(82247);
        MPSmileyFooter.c(MPSmileyFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        MPSmileyFooter.c(MPSmileyFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(82247);
      }
      
      public final void aoP() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(82248);
        try
        {
          MPSmileyFooter.c(MPSmileyFooter.this).aXD(paramAnonymousString);
          AppMethodBeat.o(82248);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.printErrStackTrace("MicroMsg.SnsUploadSayFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(82248);
        }
      }
      
      public final void dU(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(82257);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(82258);
    super.onConfigurationChanged(paramConfiguration);
    if (this.pWJ != null) {
      ebT();
    }
    AppMethodBeat.o(82258);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82263);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.Act < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.Act)
    {
      this.Act = paramInt1;
      this.Acu = paramInt4;
      AppMethodBeat.o(82263);
      return;
    }
  }
  
  public void setExtraAddHeight(int paramInt)
  {
    this.EqY = paramInt;
  }
  
  public void setFobbidenWhenLandscape(boolean paramBoolean)
  {
    this.EqZ = paramBoolean;
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(82253);
    this.AiM = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(82245);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/webview/ui/tools/widget/MPSmileyFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (MPSmileyFooter.this.getVisibility() == 8) {
          MPSmileyFooter.this.setVisibility(0);
        }
        if (MPSmileyFooter.this.edz()) {
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
    ViewGroup.LayoutParams localLayoutParams = this.EqW.getLayoutParams();
    localLayoutParams.height = paramInt;
    this.EqW.setLayoutParams(localLayoutParams);
    paramInt = com.tencent.mm.sdk.platformtools.z.iI(getContext());
    this.pWJ.setPortHeightPx(paramInt);
    localLayoutParams = this.pWJ.getLayoutParams();
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
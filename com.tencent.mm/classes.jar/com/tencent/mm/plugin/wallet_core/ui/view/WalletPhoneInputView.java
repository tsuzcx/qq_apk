package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WalletPhoneInputView
  extends LinearLayout
{
  private WalletFormView Inn;
  public WalletFormView Ino;
  private TenpaySecureEditText Inp;
  private TextView Inq;
  private Map<String, b.a> Inr;
  private String Ins;
  private String Int;
  private boolean Inu;
  public String Inv;
  private int mMode;
  
  public WalletPhoneInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71521);
    this.mMode = 0;
    this.Ins = "";
    this.Int = "";
    this.Inu = true;
    init(paramContext);
    d(paramContext, paramAttributeSet, -1);
    AppMethodBeat.o(71521);
  }
  
  public WalletPhoneInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71522);
    this.mMode = 0;
    this.Ins = "";
    this.Int = "";
    this.Inu = true;
    init(paramContext);
    d(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(71522);
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(71524);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletPhoneInputViewAttrs, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(0, 0);
    if (paramInt != 0)
    {
      String str = paramContext.getString(paramInt);
      this.Ino.setHint(str);
    }
    paramInt = paramAttributeSet.getResourceId(1, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getString(paramInt);
      this.Ino.setTitleText(paramContext);
    }
    AppMethodBeat.o(71524);
  }
  
  private void fTR()
  {
    AppMethodBeat.i(71527);
    this.Inn.setText(this.Ins);
    this.Inp.setText(this.Int);
    AppMethodBeat.o(71527);
  }
  
  private void fTS()
  {
    AppMethodBeat.i(71528);
    b.a locala = (b.a)this.Inr.get("86");
    this.Int = locala.jbY;
    this.Ins = locala.jbZ;
    fTR();
    AppMethodBeat.o(71528);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(71523);
    inflate(paramContext, 2131496992, this);
    this.Inn = ((WalletFormView)findViewById(2131305875));
    this.Ino = ((WalletFormView)findViewById(2131305887));
    this.Inq = ((TextView)findViewById(2131306000));
    this.Inn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71515);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.d("MicroMsg.WalletPhoneInputView", "click area");
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(WalletPhoneInputView.this.getContext(), "com.tencent.mm.ui.tools.CountryCodeUI");
        ((MMActivity)WalletPhoneInputView.this.getContext()).startActivityForResult(paramAnonymousView, 65521);
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71515);
      }
    });
    this.Inp = ((TenpaySecureEditText)this.Ino.findViewById(2131306096));
    if ((getContext() instanceof MMActivity))
    {
      this.Ino.setOnInfoIvClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(71516);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          WalletPhoneInputView.a(WalletPhoneInputView.this, WalletPhoneInputView.a(WalletPhoneInputView.this));
          a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletPhoneInputView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71516);
        }
      });
      this.Ino.setLogicDelegate(new com.tencent.mm.wallet_core.ui.formview.a.b()
      {
        public final boolean a(WalletFormView paramAnonymousWalletFormView)
        {
          AppMethodBeat.i(71517);
          if (WalletPhoneInputView.this.fTT())
          {
            boolean bool = paramAnonymousWalletFormView.isPhoneNum();
            AppMethodBeat.o(71517);
            return bool;
          }
          if ((!Util.isNullOrNil(WalletPhoneInputView.b(WalletPhoneInputView.this))) && (!Util.isNullOrNil(WalletPhoneInputView.c(WalletPhoneInputView.this))) && (!Util.isNullOrNil(WalletPhoneInputView.d(WalletPhoneInputView.this).getText())))
          {
            AppMethodBeat.o(71517);
            return true;
          }
          AppMethodBeat.o(71517);
          return false;
        }
        
        public final boolean a(WalletFormView paramAnonymousWalletFormView, String paramAnonymousString)
        {
          return false;
        }
        
        public final boolean b(WalletFormView paramAnonymousWalletFormView, String paramAnonymousString)
        {
          return false;
        }
        
        public final String c(WalletFormView paramAnonymousWalletFormView, String paramAnonymousString)
        {
          return null;
        }
        
        public final boolean eIg()
        {
          return false;
        }
      });
    }
    getContext();
    paramContext = com.tencent.mm.aw.b.Pf(getContext().getString(2131758198));
    this.Inr = new HashMap();
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      b.a locala = (b.a)paramContext.next();
      this.Inr.put(locala.jbY, locala);
    }
    AppMethodBeat.o(71523);
  }
  
  public final boolean fTT()
  {
    return this.mMode == 0;
  }
  
  public final void fTU()
  {
    AppMethodBeat.i(71529);
    this.mMode = 0;
    fTS();
    this.Inn.setVisibility(8);
    this.Inp.setVisibility(8);
    this.Inq.setVisibility(8);
    AppMethodBeat.o(71529);
  }
  
  public final void fTV()
  {
    AppMethodBeat.i(71530);
    this.mMode = 1;
    fTS();
    this.Inn.setVisibility(0);
    this.Inp.setVisibility(0);
    this.Inq.setVisibility(0);
    this.Inp.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(71519);
        if (Util.isNullOrNil(paramAnonymousEditable.toString()))
        {
          WalletPhoneInputView.e(WalletPhoneInputView.this).setText("");
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100904);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100904));
          AppMethodBeat.o(71519);
          return;
        }
        if (!WalletPhoneInputView.g(WalletPhoneInputView.this))
        {
          Log.i("MicroMsg.WalletPhoneInputView", "manual pick don't search");
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100904);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100904));
          WalletPhoneInputView.h(WalletPhoneInputView.this);
          AppMethodBeat.o(71519);
          return;
        }
        b.a locala = (b.a)WalletPhoneInputView.i(WalletPhoneInputView.this).get(paramAnonymousEditable.toString());
        Log.d("MicroMsg.WalletPhoneInputView", "cCode: %s, s: %s", new Object[] { locala, paramAnonymousEditable.toString() });
        if (locala != null)
        {
          WalletPhoneInputView.b(WalletPhoneInputView.this, locala.jbY);
          WalletPhoneInputView.c(WalletPhoneInputView.this, locala.jbZ);
          WalletPhoneInputView.e(WalletPhoneInputView.this).setText(locala.jbZ);
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100904);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100904));
        }
        for (;;)
        {
          WalletPhoneInputView.d(WalletPhoneInputView.this).getInputValidChangeListener().onInputValidChange(WalletPhoneInputView.d(WalletPhoneInputView.this).bql());
          AppMethodBeat.o(71519);
          return;
          WalletPhoneInputView.b(WalletPhoneInputView.this, "");
          WalletPhoneInputView.c(WalletPhoneInputView.this, "");
          WalletPhoneInputView.e(WalletPhoneInputView.this).setText(WalletPhoneInputView.this.getContext().getString(2131768189));
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.Inp.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(71520);
        if (!paramAnonymousBoolean)
        {
          if ((b.a)WalletPhoneInputView.i(WalletPhoneInputView.this).get(WalletPhoneInputView.f(WalletPhoneInputView.this).getText().toString()) == null)
          {
            WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100996);
            WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100996));
            AppMethodBeat.o(71520);
            return;
          }
          WalletPhoneInputView.e(WalletPhoneInputView.this).setContentTextColorRes(2131100904);
          WalletPhoneInputView.f(WalletPhoneInputView.this).setTextColor(WalletPhoneInputView.this.getResources().getColor(2131100904));
        }
        AppMethodBeat.o(71520);
      }
    });
    AppMethodBeat.o(71530);
  }
  
  public final boolean g(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(71526);
    if (paramInt1 == 65521)
    {
      if (paramInt2 == 100)
      {
        String str = paramIntent.getStringExtra("country_name");
        paramIntent = paramIntent.getStringExtra("couttry_code");
        Log.i("MicroMsg.WalletPhoneInputView", "countryName: %s, countryCode: %s", new Object[] { this.Ins, this.Int });
        if ((Util.isNullOrNil(str)) || (Util.isNullOrNil(paramIntent)))
        {
          Log.i("MicroMsg.WalletPhoneInputView", "cancel pick");
          AppMethodBeat.o(71526);
          return true;
        }
        this.Ins = str;
        this.Int = paramIntent;
        this.Inu = false;
        fTR();
        this.Inp.clearFocus();
      }
      AppMethodBeat.o(71526);
      return true;
    }
    AppMethodBeat.o(71526);
    return false;
  }
  
  public String getCountryCode()
  {
    AppMethodBeat.i(71525);
    if (fTT())
    {
      AppMethodBeat.o(71525);
      return "86";
    }
    String str = this.Inp.getText().toString();
    AppMethodBeat.o(71525);
    return str;
  }
  
  public WalletFormView getPhoneNumberEt()
  {
    return this.Ino;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.MMEditText.c;

public class MMFormMobileInputView
  extends LinearLayout
{
  private EditText OQd;
  private EditText OQe;
  private String OQf;
  private String OQg;
  private final int OQh;
  private a OQi;
  private Context mContext;
  private int nBG;
  private int[] nBK;
  
  public MMFormMobileInputView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  @TargetApi(11)
  public MMFormMobileInputView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141915);
    this.mContext = null;
    this.nBG = -1;
    this.OQf = "";
    this.OQg = "";
    this.OQh = 13;
    this.OQi = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.nBG = paramAttributeSet.getResourceId(1, -1);
    paramAttributeSet.recycle();
    aa.jQ(paramContext).inflate(2131495528, this);
    this.mContext = paramContext;
    AppMethodBeat.o(141915);
  }
  
  private void gx(View paramView)
  {
    AppMethodBeat.i(141918);
    this.nBK = new int[] { paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom() };
    AppMethodBeat.o(141918);
  }
  
  private void gy(View paramView)
  {
    AppMethodBeat.i(141919);
    if (this.nBK != null) {
      paramView.setPadding(this.nBK[0], this.nBK[1], this.nBK[2], this.nBK[3]);
    }
    AppMethodBeat.o(141919);
  }
  
  public final void Bv(boolean paramBoolean)
  {
    AppMethodBeat.i(141917);
    gx(this.OQd);
    if (paramBoolean)
    {
      this.OQd.setBackgroundResource(2131233162);
      gy(this.OQd);
      gx(this.OQe);
      if (!paramBoolean) {
        break label81;
      }
      this.OQe.setBackgroundResource(2131233162);
    }
    for (;;)
    {
      gy(this.OQe);
      AppMethodBeat.o(141917);
      return;
      this.OQd.setBackgroundResource(2131233163);
      break;
      label81:
      this.OQe.setBackgroundResource(2131233163);
    }
  }
  
  public String getCountryCode()
  {
    AppMethodBeat.i(141924);
    if (this.OQd != null)
    {
      String str = this.OQd.getText().toString().trim();
      AppMethodBeat.o(141924);
      return str;
    }
    AppMethodBeat.o(141924);
    return "";
  }
  
  public EditText getCountryCodeEditText()
  {
    return this.OQd;
  }
  
  public String getMobileNumber()
  {
    AppMethodBeat.i(141923);
    if (this.OQe != null)
    {
      String str = PhoneFormater.pureNumber(this.OQe.getText().toString());
      AppMethodBeat.o(141923);
      return str;
    }
    AppMethodBeat.o(141923);
    return "";
  }
  
  public EditText getMobileNumberEditText()
  {
    return this.OQe;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(141916);
    this.OQd = ((EditText)findViewById(2131299266));
    this.OQe = ((EditText)findViewById(2131304759));
    if ((this.OQd == null) || (this.OQe == null))
    {
      Log.w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", new Object[] { this.OQd, this.OQe });
      if ((this.OQd != null) && (this.OQe != null))
      {
        if ((!this.OQd.hasFocus()) && (!this.OQe.hasFocus())) {
          break label213;
        }
        Bv(true);
      }
    }
    for (;;)
    {
      View.OnFocusChangeListener local1 = new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(141911);
          if ((paramAnonymousView == MMFormMobileInputView.a(MMFormMobileInputView.this)) || (paramAnonymousView == MMFormMobileInputView.b(MMFormMobileInputView.this))) {
            MMFormMobileInputView.this.Bv(paramAnonymousBoolean);
          }
          AppMethodBeat.o(141911);
        }
      };
      this.OQd.setOnFocusChangeListener(local1);
      this.OQe.setOnFocusChangeListener(local1);
      this.OQe.addTextChangedListener(new MMEditText.c(this.OQe, null, 20));
      this.OQe.addTextChangedListener(new TextWatcher()
      {
        private PhoneFormater kqv;
        
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(141913);
          int i = MMFormMobileInputView.b(MMFormMobileInputView.this).getSelectionEnd();
          paramAnonymousEditable = MMFormMobileInputView.b(MMFormMobileInputView.this).getText().toString();
          String str1 = MMFormMobileInputView.b(MMFormMobileInputView.this).getText().toString().substring(0, i);
          if ((paramAnonymousEditable != null) && (!paramAnonymousEditable.equals(MMFormMobileInputView.c(MMFormMobileInputView.this))))
          {
            String str2 = MMFormMobileInputView.a(MMFormMobileInputView.this).getText().toString();
            MMFormMobileInputView.a(MMFormMobileInputView.this, this.kqv.formatNumber(str2.replace("+", ""), paramAnonymousEditable));
            MMFormMobileInputView.b(MMFormMobileInputView.this, this.kqv.formatNumber(str2.replace("+", ""), str1));
            if (paramAnonymousEditable.equals(MMFormMobileInputView.c(MMFormMobileInputView.this)))
            {
              AppMethodBeat.o(141913);
              return;
            }
            MMFormMobileInputView.b(MMFormMobileInputView.this).setText(MMFormMobileInputView.c(MMFormMobileInputView.this));
            int j = MMFormMobileInputView.b(MMFormMobileInputView.this).getText().toString().length();
            if (str1 == null) {
              break label354;
            }
            try
            {
              MMFormMobileInputView.b(MMFormMobileInputView.this, this.kqv.formatNumber(str2.replace("+", ""), str1));
              if ((paramAnonymousEditable.length() > 13) && (i <= j)) {
                break label330;
              }
              if ((i <= j) && (MMFormMobileInputView.d(MMFormMobileInputView.this).toString().length() <= j)) {
                break label301;
              }
              MMFormMobileInputView.b(MMFormMobileInputView.this).setSelection(j - Math.abs(paramAnonymousEditable.length() - i));
              AppMethodBeat.o(141913);
              return;
            }
            catch (Exception paramAnonymousEditable)
            {
              Log.printErrStackTrace("MicroMsg.MMFormMobileInputView", paramAnonymousEditable, "", new Object[0]);
            }
          }
          else
          {
            AppMethodBeat.o(141913);
            return;
          }
          label301:
          MMFormMobileInputView.b(MMFormMobileInputView.this).setSelection(MMFormMobileInputView.d(MMFormMobileInputView.this).toString().length());
          AppMethodBeat.o(141913);
          return;
          label330:
          MMFormMobileInputView.b(MMFormMobileInputView.this).setSelection(str1.toString().length());
          AppMethodBeat.o(141913);
          return;
          label354:
          MMFormMobileInputView.b(MMFormMobileInputView.this).setSelection(0);
          AppMethodBeat.o(141913);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.OQd.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(141914);
          paramAnonymousEditable = MMFormMobileInputView.a(MMFormMobileInputView.this).getText().toString();
          if (Util.isNullOrNil(paramAnonymousEditable))
          {
            MMFormMobileInputView.a(MMFormMobileInputView.this).setText("+");
            MMFormMobileInputView.a(MMFormMobileInputView.this).setSelection(MMFormMobileInputView.a(MMFormMobileInputView.this).getText().toString().length());
          }
          do
          {
            do
            {
              for (;;)
              {
                if (MMFormMobileInputView.e(MMFormMobileInputView.this) != null) {
                  MMFormMobileInputView.e(MMFormMobileInputView.this);
                }
                AppMethodBeat.o(141914);
                return;
                if (paramAnonymousEditable.contains("+")) {
                  break;
                }
                paramAnonymousEditable = "+".concat(String.valueOf(paramAnonymousEditable));
                MMFormMobileInputView.a(MMFormMobileInputView.this).setText(paramAnonymousEditable);
                MMFormMobileInputView.a(MMFormMobileInputView.this).setSelection(MMFormMobileInputView.a(MMFormMobileInputView.this).getText().toString().length());
              }
            } while (paramAnonymousEditable.length() <= 1);
            paramAnonymousEditable = paramAnonymousEditable.substring(1);
          } while (paramAnonymousEditable.length() <= 4);
          MMFormMobileInputView.a(MMFormMobileInputView.this).setText(paramAnonymousEditable.substring(0, 4));
          AppMethodBeat.o(141914);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      AppMethodBeat.o(141916);
      return;
      if (this.nBG == -1) {
        break;
      }
      this.OQe.setHint(this.nBG);
      break;
      label213:
      Bv(false);
    }
  }
  
  public void setCountryCode(String paramString)
  {
    AppMethodBeat.i(141920);
    if (this.OQd != null)
    {
      this.OQd.setText(paramString);
      AppMethodBeat.o(141920);
      return;
    }
    Log.e("MicroMsg.MMFormMobileInputView", "countryCodeET is null!");
    AppMethodBeat.o(141920);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(141921);
    if (this.OQe != null)
    {
      this.OQe.setHint(paramString);
      AppMethodBeat.o(141921);
      return;
    }
    Log.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
    AppMethodBeat.o(141921);
  }
  
  public void setMobileNumber(String paramString)
  {
    AppMethodBeat.i(141922);
    if (this.OQe != null)
    {
      this.OQe.setText(paramString);
      AppMethodBeat.o(141922);
      return;
    }
    Log.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
    AppMethodBeat.o(141922);
  }
  
  public void setOnCountryCodeChangedListener(a parama)
  {
    this.OQi = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormMobileInputView
 * JD-Core Version:    0.7.0.1
 */
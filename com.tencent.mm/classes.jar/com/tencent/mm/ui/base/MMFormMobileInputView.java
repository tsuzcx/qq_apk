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
import com.tencent.mm.af.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.ui.z;

public class MMFormMobileInputView
  extends LinearLayout
{
  private String JkA;
  private final int JkB;
  private a JkC;
  private EditText Jkx;
  private EditText Jky;
  private String Jkz;
  private Context mContext;
  private int mlX;
  private int[] mmb;
  
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
    this.mlX = -1;
    this.Jkz = "";
    this.JkA = "";
    this.JkB = 13;
    this.JkC = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.mlX = paramAttributeSet.getResourceId(1, -1);
    paramAttributeSet.recycle();
    z.jO(paramContext).inflate(2131494794, this);
    this.mContext = paramContext;
    AppMethodBeat.o(141915);
  }
  
  private void gg(View paramView)
  {
    AppMethodBeat.i(141918);
    this.mmb = new int[] { paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom() };
    AppMethodBeat.o(141918);
  }
  
  private void gh(View paramView)
  {
    AppMethodBeat.i(141919);
    if (this.mmb != null) {
      paramView.setPadding(this.mmb[0], this.mmb[1], this.mmb[2], this.mmb[3]);
    }
    AppMethodBeat.o(141919);
  }
  
  public String getCountryCode()
  {
    AppMethodBeat.i(141924);
    if (this.Jkx != null)
    {
      String str = this.Jkx.getText().toString().trim();
      AppMethodBeat.o(141924);
      return str;
    }
    AppMethodBeat.o(141924);
    return "";
  }
  
  public EditText getCountryCodeEditText()
  {
    return this.Jkx;
  }
  
  public String getMobileNumber()
  {
    AppMethodBeat.i(141923);
    if (this.Jky != null)
    {
      String str = ba.aQI(this.Jky.getText().toString());
      AppMethodBeat.o(141923);
      return str;
    }
    AppMethodBeat.o(141923);
    return "";
  }
  
  public EditText getMobileNumberEditText()
  {
    return this.Jky;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(141916);
    this.Jkx = ((EditText)findViewById(2131298803));
    this.Jky = ((EditText)findViewById(2131302362));
    if ((this.Jkx == null) || (this.Jky == null))
    {
      ad.w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", new Object[] { this.Jkx, this.Jky });
      if ((this.Jkx != null) && (this.Jky != null))
      {
        if ((!this.Jkx.hasFocus()) && (!this.Jky.hasFocus())) {
          break label213;
        }
        xz(true);
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
            MMFormMobileInputView.this.xz(paramAnonymousBoolean);
          }
          AppMethodBeat.o(141911);
        }
      };
      this.Jkx.setOnFocusChangeListener(local1);
      this.Jky.setOnFocusChangeListener(local1);
      this.Jky.addTextChangedListener(new MMEditText.c(this.Jky, null, 20));
      this.Jky.addTextChangedListener(new TextWatcher()
      {
        private ba jpn;
        
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(141913);
          int i = MMFormMobileInputView.b(MMFormMobileInputView.this).getSelectionEnd();
          paramAnonymousEditable = MMFormMobileInputView.b(MMFormMobileInputView.this).getText().toString();
          String str1 = MMFormMobileInputView.b(MMFormMobileInputView.this).getText().toString().substring(0, i);
          if ((paramAnonymousEditable != null) && (!paramAnonymousEditable.equals(MMFormMobileInputView.c(MMFormMobileInputView.this))))
          {
            String str2 = MMFormMobileInputView.a(MMFormMobileInputView.this).getText().toString();
            MMFormMobileInputView.a(MMFormMobileInputView.this, ba.formatNumber(str2.replace("+", ""), paramAnonymousEditable));
            MMFormMobileInputView.b(MMFormMobileInputView.this, ba.formatNumber(str2.replace("+", ""), str1));
            if (paramAnonymousEditable.equals(MMFormMobileInputView.c(MMFormMobileInputView.this)))
            {
              AppMethodBeat.o(141913);
              return;
            }
            MMFormMobileInputView.b(MMFormMobileInputView.this).setText(MMFormMobileInputView.c(MMFormMobileInputView.this));
            int j = MMFormMobileInputView.b(MMFormMobileInputView.this).getText().toString().length();
            if (str1 == null) {
              break label342;
            }
            try
            {
              MMFormMobileInputView.b(MMFormMobileInputView.this, ba.formatNumber(str2.replace("+", ""), str1));
              if ((paramAnonymousEditable.length() > 13) && (i <= j)) {
                break label318;
              }
              if ((i <= j) && (MMFormMobileInputView.d(MMFormMobileInputView.this).toString().length() <= j)) {
                break label289;
              }
              MMFormMobileInputView.b(MMFormMobileInputView.this).setSelection(j - Math.abs(paramAnonymousEditable.length() - i));
              AppMethodBeat.o(141913);
              return;
            }
            catch (Exception paramAnonymousEditable)
            {
              ad.printErrStackTrace("MicroMsg.MMFormMobileInputView", paramAnonymousEditable, "", new Object[0]);
            }
          }
          else
          {
            AppMethodBeat.o(141913);
            return;
          }
          label289:
          MMFormMobileInputView.b(MMFormMobileInputView.this).setSelection(MMFormMobileInputView.d(MMFormMobileInputView.this).toString().length());
          AppMethodBeat.o(141913);
          return;
          label318:
          MMFormMobileInputView.b(MMFormMobileInputView.this).setSelection(str1.toString().length());
          AppMethodBeat.o(141913);
          return;
          label342:
          MMFormMobileInputView.b(MMFormMobileInputView.this).setSelection(0);
          AppMethodBeat.o(141913);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      this.Jkx.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(141914);
          paramAnonymousEditable = MMFormMobileInputView.a(MMFormMobileInputView.this).getText().toString();
          if (bt.isNullOrNil(paramAnonymousEditable))
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
      if (this.mlX == -1) {
        break;
      }
      this.Jky.setHint(this.mlX);
      break;
      label213:
      xz(false);
    }
  }
  
  public void setCountryCode(String paramString)
  {
    AppMethodBeat.i(141920);
    if (this.Jkx != null)
    {
      this.Jkx.setText(paramString);
      AppMethodBeat.o(141920);
      return;
    }
    ad.e("MicroMsg.MMFormMobileInputView", "countryCodeET is null!");
    AppMethodBeat.o(141920);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(141921);
    if (this.Jky != null)
    {
      this.Jky.setHint(paramString);
      AppMethodBeat.o(141921);
      return;
    }
    ad.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
    AppMethodBeat.o(141921);
  }
  
  public void setMobileNumber(String paramString)
  {
    AppMethodBeat.i(141922);
    if (this.Jky != null)
    {
      this.Jky.setText(paramString);
      AppMethodBeat.o(141922);
      return;
    }
    ad.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
    AppMethodBeat.o(141922);
  }
  
  public void setOnCountryCodeChangedListener(a parama)
  {
    this.JkC = parama;
  }
  
  public final void xz(boolean paramBoolean)
  {
    AppMethodBeat.i(141917);
    gg(this.Jkx);
    if (paramBoolean)
    {
      this.Jkx.setBackgroundResource(2131232723);
      gh(this.Jkx);
      gg(this.Jky);
      if (!paramBoolean) {
        break label81;
      }
      this.Jky.setBackgroundResource(2131232723);
    }
    for (;;)
    {
      gh(this.Jky);
      AppMethodBeat.o(141917);
      return;
      this.Jkx.setBackgroundResource(2131232724);
      break;
      label81:
      this.Jky.setBackgroundResource(2131232724);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormMobileInputView
 * JD-Core Version:    0.7.0.1
 */
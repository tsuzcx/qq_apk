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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.ui.z;

public class MMFormMobileInputView
  extends LinearLayout
{
  private EditText JFl;
  private EditText JFm;
  private String JFn;
  private String JFo;
  private final int JFp;
  private a JFq;
  private Context mContext;
  private int mqU;
  private int[] mqY;
  
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
    this.mqU = -1;
    this.JFn = "";
    this.JFo = "";
    this.JFp = 13;
    this.JFq = null;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FormItemView, paramInt, 0);
    this.mqU = paramAttributeSet.getResourceId(1, -1);
    paramAttributeSet.recycle();
    z.jV(paramContext).inflate(2131494794, this);
    this.mContext = paramContext;
    AppMethodBeat.o(141915);
  }
  
  private void gf(View paramView)
  {
    AppMethodBeat.i(141918);
    this.mqY = new int[] { paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom() };
    AppMethodBeat.o(141918);
  }
  
  private void gg(View paramView)
  {
    AppMethodBeat.i(141919);
    if (this.mqY != null) {
      paramView.setPadding(this.mqY[0], this.mqY[1], this.mqY[2], this.mqY[3]);
    }
    AppMethodBeat.o(141919);
  }
  
  public String getCountryCode()
  {
    AppMethodBeat.i(141924);
    if (this.JFl != null)
    {
      String str = this.JFl.getText().toString().trim();
      AppMethodBeat.o(141924);
      return str;
    }
    AppMethodBeat.o(141924);
    return "";
  }
  
  public EditText getCountryCodeEditText()
  {
    return this.JFl;
  }
  
  public String getMobileNumber()
  {
    AppMethodBeat.i(141923);
    if (this.JFm != null)
    {
      String str = bb.aSf(this.JFm.getText().toString());
      AppMethodBeat.o(141923);
      return str;
    }
    AppMethodBeat.o(141923);
    return "";
  }
  
  public EditText getMobileNumberEditText()
  {
    return this.JFm;
  }
  
  public void onFinishInflate()
  {
    AppMethodBeat.i(141916);
    this.JFl = ((EditText)findViewById(2131298803));
    this.JFm = ((EditText)findViewById(2131302362));
    if ((this.JFl == null) || (this.JFm == null))
    {
      ae.w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", new Object[] { this.JFl, this.JFm });
      if ((this.JFl != null) && (this.JFm != null))
      {
        if ((!this.JFl.hasFocus()) && (!this.JFm.hasFocus())) {
          break label213;
        }
        xH(true);
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
            MMFormMobileInputView.this.xH(paramAnonymousBoolean);
          }
          AppMethodBeat.o(141911);
        }
      };
      this.JFl.setOnFocusChangeListener(local1);
      this.JFm.setOnFocusChangeListener(local1);
      this.JFm.addTextChangedListener(new MMEditText.c(this.JFm, null, 20));
      this.JFm.addTextChangedListener(new TextWatcher()
      {
        private bb jsg;
        
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(141913);
          int i = MMFormMobileInputView.b(MMFormMobileInputView.this).getSelectionEnd();
          paramAnonymousEditable = MMFormMobileInputView.b(MMFormMobileInputView.this).getText().toString();
          String str1 = MMFormMobileInputView.b(MMFormMobileInputView.this).getText().toString().substring(0, i);
          if ((paramAnonymousEditable != null) && (!paramAnonymousEditable.equals(MMFormMobileInputView.c(MMFormMobileInputView.this))))
          {
            String str2 = MMFormMobileInputView.a(MMFormMobileInputView.this).getText().toString();
            MMFormMobileInputView.a(MMFormMobileInputView.this, bb.formatNumber(str2.replace("+", ""), paramAnonymousEditable));
            MMFormMobileInputView.b(MMFormMobileInputView.this, bb.formatNumber(str2.replace("+", ""), str1));
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
              MMFormMobileInputView.b(MMFormMobileInputView.this, bb.formatNumber(str2.replace("+", ""), str1));
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
              ae.printErrStackTrace("MicroMsg.MMFormMobileInputView", paramAnonymousEditable, "", new Object[0]);
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
      this.JFl.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          AppMethodBeat.i(141914);
          paramAnonymousEditable = MMFormMobileInputView.a(MMFormMobileInputView.this).getText().toString();
          if (bu.isNullOrNil(paramAnonymousEditable))
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
      if (this.mqU == -1) {
        break;
      }
      this.JFm.setHint(this.mqU);
      break;
      label213:
      xH(false);
    }
  }
  
  public void setCountryCode(String paramString)
  {
    AppMethodBeat.i(141920);
    if (this.JFl != null)
    {
      this.JFl.setText(paramString);
      AppMethodBeat.o(141920);
      return;
    }
    ae.e("MicroMsg.MMFormMobileInputView", "countryCodeET is null!");
    AppMethodBeat.o(141920);
  }
  
  public void setHint(String paramString)
  {
    AppMethodBeat.i(141921);
    if (this.JFm != null)
    {
      this.JFm.setHint(paramString);
      AppMethodBeat.o(141921);
      return;
    }
    ae.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
    AppMethodBeat.o(141921);
  }
  
  public void setMobileNumber(String paramString)
  {
    AppMethodBeat.i(141922);
    if (this.JFm != null)
    {
      this.JFm.setText(paramString);
      AppMethodBeat.o(141922);
      return;
    }
    ae.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
    AppMethodBeat.o(141922);
  }
  
  public void setOnCountryCodeChangedListener(a parama)
  {
    this.JFq = parama;
  }
  
  public final void xH(boolean paramBoolean)
  {
    AppMethodBeat.i(141917);
    gf(this.JFl);
    if (paramBoolean)
    {
      this.JFl.setBackgroundResource(2131232723);
      gg(this.JFl);
      gf(this.JFm);
      if (!paramBoolean) {
        break label81;
      }
      this.JFm.setBackgroundResource(2131232723);
    }
    for (;;)
    {
      gg(this.JFm);
      AppMethodBeat.o(141917);
      return;
      this.JFl.setBackgroundResource(2131232724);
      break;
      label81:
      this.JFm.setBackgroundResource(2131232724);
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFormMobileInputView
 * JD-Core Version:    0.7.0.1
 */
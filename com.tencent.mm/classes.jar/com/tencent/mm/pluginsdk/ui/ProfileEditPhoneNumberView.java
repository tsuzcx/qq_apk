package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView
  extends ProfileItemView
  implements MMPhoneNumberEditText.a
{
  public String vRr;
  public String vRs;
  public String[] vRt;
  private LinearLayout vRu;
  private boolean vRv = false;
  public ProfileEditPhoneNumberView.a vRw;
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cc(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(27520);
    MMPhoneNumberEditText localMMPhoneNumberEditText = (MMPhoneNumberEditText)LayoutInflater.from(getContext()).inflate(2130970463, null);
    localMMPhoneNumberEditText.setHint(ah.getResources().getString(2131296421));
    if (paramBoolean) {
      localMMPhoneNumberEditText.dna();
    }
    localMMPhoneNumberEditText.setCallback(this);
    localMMPhoneNumberEditText.setText(paramString);
    localMMPhoneNumberEditText.setSelection(localMMPhoneNumberEditText.getText().length());
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(a.fromDPToPix(getContext(), 16), a.fromDPToPix(getContext(), 0), 0, 0);
    this.vRu.addView(localMMPhoneNumberEditText, paramString);
    AppMethodBeat.o(27520);
  }
  
  private void dnk()
  {
    AppMethodBeat.i(27515);
    if (this.vRw != null) {
      this.vRw.onChange();
    }
    AppMethodBeat.o(27515);
  }
  
  private void h(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(27521);
    this.vRu.removeView(paramMMPhoneNumberEditText);
    this.vRu.getChildAt(this.vRu.getChildCount() - 1).requestFocus();
    AppMethodBeat.o(27521);
  }
  
  public final boolean S(ad paramad)
  {
    this.lpe = paramad;
    return true;
  }
  
  public final boolean ccG()
  {
    AppMethodBeat.i(27513);
    int j;
    if (!bo.isNullOrNil(this.vRr))
    {
      cc(this.vRr, true);
      j = 1;
    }
    for (int i = 1;; i = 0)
    {
      int k = i;
      if (!bo.isNullOrNil(this.vRs))
      {
        this.vRt = this.vRs.split(",");
        for (;;)
        {
          k = i;
          if (i >= this.vRt.length + j) {
            break;
          }
          cc(this.vRt[(i - j)].trim(), false);
          i += 1;
        }
      }
      if (k < 5) {
        cc(null, false);
      }
      for (this.vRv = false;; this.vRv = true)
      {
        AppMethodBeat.o(27513);
        return false;
      }
      j = 0;
    }
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(27511);
    int i = 1;
    while (i < this.vRu.getChildCount())
    {
      this.vRu.getChildAt(i).clearFocus();
      i += 1;
    }
    AppMethodBeat.o(27511);
  }
  
  public final void dne()
  {
    AppMethodBeat.i(27518);
    if (this.vRu.getChildCount() < 5) {
      cc(null, false);
    }
    for (;;)
    {
      dnk();
      AppMethodBeat.o(27518);
      return;
      this.vRv = true;
    }
  }
  
  public final void dnf()
  {
    AppMethodBeat.i(27517);
    dnk();
    AppMethodBeat.o(27517);
  }
  
  public final void f(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(27516);
    if (paramMMPhoneNumberEditText.vQX)
    {
      h.a(getContext(), 2131300648, 0, 2131300647, 2131300646, new ProfileEditPhoneNumberView.1(this, paramMMPhoneNumberEditText), null);
      AppMethodBeat.o(27516);
      return;
    }
    h(paramMMPhoneNumberEditText);
    if (this.vRv)
    {
      cc(null, false);
      this.vRv = false;
    }
    dnk();
    AppMethodBeat.o(27516);
  }
  
  public final void g(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(27519);
    if (this.vRu.getChildCount() - 1 == 1)
    {
      AppMethodBeat.o(27519);
      return;
    }
    h(paramMMPhoneNumberEditText);
    if (this.vRv) {
      cc(null, false);
    }
    this.vRv = false;
    dnk();
    AppMethodBeat.o(27519);
  }
  
  public int getLayout()
  {
    return 2130970464;
  }
  
  public ArrayList<String> getPhoneNumberList()
  {
    AppMethodBeat.i(27514);
    int j = this.vRu.getChildCount();
    if (j == 0)
    {
      AppMethodBeat.o(27514);
      return null;
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      String str = ((MMPhoneNumberEditText)this.vRu.getChildAt(i)).getText().toString();
      if ((!bo.isNullOrNil(str)) && (!str.trim().equals(""))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if ((!bo.isNullOrNil(this.vRr)) && (localArrayList.size() > 0)) {
      localArrayList.remove(0);
    }
    AppMethodBeat.o(27514);
    return localArrayList;
  }
  
  public final void init()
  {
    AppMethodBeat.i(27510);
    this.vRu = ((LinearLayout)findViewById(2131826849));
    AppMethodBeat.o(27510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView
 * JD-Core Version:    0.7.0.1
 */
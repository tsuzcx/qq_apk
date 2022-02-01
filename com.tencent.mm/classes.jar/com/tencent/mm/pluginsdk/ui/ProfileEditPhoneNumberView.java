package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView
  extends ProfileItemView
  implements MMPhoneNumberEditText.a
{
  public String KcI;
  public String KcJ;
  public String[] KcK;
  private LinearLayout KcL;
  private boolean KcM = false;
  public a KcN;
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31222);
    MMPhoneNumberEditText localMMPhoneNumberEditText = (MMPhoneNumberEditText)LayoutInflater.from(getContext()).inflate(2131495979, null);
    localMMPhoneNumberEditText.setHint(MMApplicationContext.getResources().getString(2131755167));
    if (paramBoolean) {
      localMMPhoneNumberEditText.goK();
    }
    localMMPhoneNumberEditText.setCallback(this);
    localMMPhoneNumberEditText.setText(paramString);
    localMMPhoneNumberEditText.setSelection(localMMPhoneNumberEditText.getText().length());
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(com.tencent.mm.cb.a.fromDPToPix(getContext(), 16), com.tencent.mm.cb.a.fromDPToPix(getContext(), 0), 0, 0);
    this.KcL.addView(localMMPhoneNumberEditText, paramString);
    AppMethodBeat.o(31222);
  }
  
  private void goU()
  {
    AppMethodBeat.i(31217);
    if (this.KcN != null) {
      this.KcN.onChange();
    }
    AppMethodBeat.o(31217);
  }
  
  private void h(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31223);
    this.KcL.removeView(paramMMPhoneNumberEditText);
    this.KcL.getChildAt(this.KcL.getChildCount() - 1).requestFocus();
    AppMethodBeat.o(31223);
  }
  
  public final boolean aj(as paramas)
  {
    this.rjX = paramas;
    return true;
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(31214);
    int i = 1;
    while (i < this.KcL.getChildCount())
    {
      this.KcL.getChildAt(i).clearFocus();
      i += 1;
    }
    AppMethodBeat.o(31214);
  }
  
  public final boolean eEV()
  {
    AppMethodBeat.i(31215);
    int j;
    if (!Util.isNullOrNil(this.KcI))
    {
      cZ(this.KcI, true);
      j = 1;
    }
    for (int i = 1;; i = 0)
    {
      int k = i;
      if (!Util.isNullOrNil(this.KcJ))
      {
        this.KcK = com.tencent.mm.contact.a.a(this.rjX, this.KcJ);
        k = i;
        if (this.KcK != null) {
          for (;;)
          {
            k = i;
            if (i >= this.KcK.length + j) {
              break;
            }
            cZ(this.KcK[(i - j)].trim(), false);
            i += 1;
          }
        }
      }
      if (k < 5) {
        cZ(null, false);
      }
      for (this.KcM = false;; this.KcM = true)
      {
        AppMethodBeat.o(31215);
        return false;
      }
      j = 0;
    }
  }
  
  public final void f(final MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31218);
    if (paramMMPhoneNumberEditText.Kcq)
    {
      h.a(getContext(), 2131761631, 0, 2131761630, 2131761629, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(31212);
          ProfileEditPhoneNumberView.this.KcI = "";
          ProfileEditPhoneNumberView.this.KcN.goV();
          ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this, paramMMPhoneNumberEditText);
          if (!ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this)) {
            ProfileEditPhoneNumberView.b(ProfileEditPhoneNumberView.this);
          }
          AppMethodBeat.o(31212);
        }
      }, null);
      AppMethodBeat.o(31218);
      return;
    }
    h(paramMMPhoneNumberEditText);
    if (this.KcM)
    {
      cZ(null, false);
      this.KcM = false;
    }
    goU();
    AppMethodBeat.o(31218);
  }
  
  public final void g(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31221);
    if (this.KcL.getChildCount() - 1 == 1)
    {
      AppMethodBeat.o(31221);
      return;
    }
    h(paramMMPhoneNumberEditText);
    if (this.KcM) {
      cZ(null, false);
    }
    this.KcM = false;
    goU();
    AppMethodBeat.o(31221);
  }
  
  public int getLayout()
  {
    return 2131495980;
  }
  
  public ArrayList<String> getPhoneNumberList()
  {
    AppMethodBeat.i(31216);
    int j = this.KcL.getChildCount();
    if (j == 0)
    {
      AppMethodBeat.o(31216);
      return null;
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      String str = ((MMPhoneNumberEditText)this.KcL.getChildAt(i)).getText().toString();
      if ((!Util.isNullOrNil(str)) && (!str.trim().equals(""))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if ((!Util.isNullOrNil(this.KcI)) && (localArrayList.size() > 0)) {
      localArrayList.remove(0);
    }
    AppMethodBeat.o(31216);
    return localArrayList;
  }
  
  public final void goO()
  {
    AppMethodBeat.i(31220);
    if (this.KcL.getChildCount() < 5) {
      cZ(null, false);
    }
    for (;;)
    {
      goU();
      AppMethodBeat.o(31220);
      return;
      this.KcM = true;
    }
  }
  
  public final void goP()
  {
    AppMethodBeat.i(31219);
    goU();
    AppMethodBeat.o(31219);
  }
  
  public final void init()
  {
    AppMethodBeat.i(31213);
    this.KcL = ((LinearLayout)findViewById(2131304326));
    AppMethodBeat.o(31213);
  }
  
  public static abstract interface a
  {
    public abstract void goV();
    
    public abstract void onChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView
 * JD-Core Version:    0.7.0.1
 */
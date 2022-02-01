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
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView
  extends ProfileItemView
  implements MMPhoneNumberEditText.a
{
  public String Dop;
  public String Doq;
  public String[] Dor;
  private LinearLayout Dos;
  private boolean Dot = false;
  public a Dou;
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cv(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31222);
    MMPhoneNumberEditText localMMPhoneNumberEditText = (MMPhoneNumberEditText)LayoutInflater.from(getContext()).inflate(2131495136, null);
    localMMPhoneNumberEditText.setHint(com.tencent.mm.sdk.platformtools.ai.getResources().getString(2131755149));
    if (paramBoolean) {
      localMMPhoneNumberEditText.eMO();
    }
    localMMPhoneNumberEditText.setCallback(this);
    localMMPhoneNumberEditText.setText(paramString);
    localMMPhoneNumberEditText.setSelection(localMMPhoneNumberEditText.getText().length());
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(com.tencent.mm.cc.a.fromDPToPix(getContext(), 16), com.tencent.mm.cc.a.fromDPToPix(getContext(), 0), 0, 0);
    this.Dos.addView(localMMPhoneNumberEditText, paramString);
    AppMethodBeat.o(31222);
  }
  
  private void eMY()
  {
    AppMethodBeat.i(31217);
    if (this.Dou != null) {
      this.Dou.onChange();
    }
    AppMethodBeat.o(31217);
  }
  
  private void h(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31223);
    this.Dos.removeView(paramMMPhoneNumberEditText);
    this.Dos.getChildAt(this.Dos.getChildCount() - 1).requestFocus();
    AppMethodBeat.o(31223);
  }
  
  public final boolean aa(com.tencent.mm.storage.ai paramai)
  {
    this.piT = paramai;
    return true;
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(31214);
    int i = 1;
    while (i < this.Dos.getChildCount())
    {
      this.Dos.getChildAt(i).clearFocus();
      i += 1;
    }
    AppMethodBeat.o(31214);
  }
  
  public final boolean dqG()
  {
    AppMethodBeat.i(31215);
    int j;
    if (!bs.isNullOrNil(this.Dop))
    {
      cv(this.Dop, true);
      j = 1;
    }
    for (int i = 1;; i = 0)
    {
      int k = i;
      if (!bs.isNullOrNil(this.Doq))
      {
        this.Dor = com.tencent.mm.n.a.a(this.piT, this.Doq);
        k = i;
        if (this.Dor != null) {
          for (;;)
          {
            k = i;
            if (i >= this.Dor.length + j) {
              break;
            }
            cv(this.Dor[(i - j)].trim(), false);
            i += 1;
          }
        }
      }
      if (k < 5) {
        cv(null, false);
      }
      for (this.Dot = false;; this.Dot = true)
      {
        AppMethodBeat.o(31215);
        return false;
      }
      j = 0;
    }
  }
  
  public final void eMS()
  {
    AppMethodBeat.i(31220);
    if (this.Dos.getChildCount() < 5) {
      cv(null, false);
    }
    for (;;)
    {
      eMY();
      AppMethodBeat.o(31220);
      return;
      this.Dot = true;
    }
  }
  
  public final void eMT()
  {
    AppMethodBeat.i(31219);
    eMY();
    AppMethodBeat.o(31219);
  }
  
  public final void f(final MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31218);
    if (paramMMPhoneNumberEditText.DnW)
    {
      h.b(getContext(), 2131760245, 0, 2131760244, 2131760243, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(31212);
          ProfileEditPhoneNumberView.this.Dop = "";
          ProfileEditPhoneNumberView.this.Dou.eMZ();
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
    if (this.Dot)
    {
      cv(null, false);
      this.Dot = false;
    }
    eMY();
    AppMethodBeat.o(31218);
  }
  
  public final void g(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    AppMethodBeat.i(31221);
    if (this.Dos.getChildCount() - 1 == 1)
    {
      AppMethodBeat.o(31221);
      return;
    }
    h(paramMMPhoneNumberEditText);
    if (this.Dot) {
      cv(null, false);
    }
    this.Dot = false;
    eMY();
    AppMethodBeat.o(31221);
  }
  
  public int getLayout()
  {
    return 2131495137;
  }
  
  public ArrayList<String> getPhoneNumberList()
  {
    AppMethodBeat.i(31216);
    int j = this.Dos.getChildCount();
    if (j == 0)
    {
      AppMethodBeat.o(31216);
      return null;
    }
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      String str = ((MMPhoneNumberEditText)this.Dos.getChildAt(i)).getText().toString();
      if ((!bs.isNullOrNil(str)) && (!str.trim().equals(""))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if ((!bs.isNullOrNil(this.Dop)) && (localArrayList.size() > 0)) {
      localArrayList.remove(0);
    }
    AppMethodBeat.o(31216);
    return localArrayList;
  }
  
  public final void init()
  {
    AppMethodBeat.i(31213);
    this.Dos = ((LinearLayout)findViewById(2131301989));
    AppMethodBeat.o(31213);
  }
  
  public static abstract interface a
  {
    public abstract void eMZ();
    
    public abstract void onChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView
  extends ProfileItemView
  implements MMPhoneNumberEditText.a
{
  public String saA;
  public String saB;
  public String[] saC;
  private LinearLayout saD;
  private boolean saE = false;
  public ProfileEditPhoneNumberView.a saF;
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void bA(String paramString, boolean paramBoolean)
  {
    MMPhoneNumberEditText localMMPhoneNumberEditText = (MMPhoneNumberEditText)LayoutInflater.from(getContext()).inflate(R.i.profile_edit_phone_number_item, null);
    localMMPhoneNumberEditText.setHint(ae.getResources().getString(R.l.add_phone_number));
    if (paramBoolean)
    {
      localMMPhoneNumberEditText.sah = true;
      localMMPhoneNumberEditText.saf = localMMPhoneNumberEditText.getResources().getDrawable(R.k.info_icon);
      localMMPhoneNumberEditText.saf.setBounds(0, 0, localMMPhoneNumberEditText.saf.getIntrinsicWidth(), localMMPhoneNumberEditText.saf.getIntrinsicHeight());
      localMMPhoneNumberEditText.setFocusable(false);
      localMMPhoneNumberEditText.cmm();
    }
    localMMPhoneNumberEditText.setCallback(this);
    localMMPhoneNumberEditText.setText(paramString);
    localMMPhoneNumberEditText.setSelection(localMMPhoneNumberEditText.getText().length());
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(0, a.fromDPToPix(getContext(), 12), 0, 0);
    this.saD.addView(localMMPhoneNumberEditText, paramString);
  }
  
  private void cmu()
  {
    if (this.saF != null) {
      this.saF.axs();
    }
  }
  
  private void h(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    this.saD.removeView(paramMMPhoneNumberEditText);
    this.saD.getChildAt(this.saD.getChildCount() - 1).requestFocus();
  }
  
  public final boolean P(ad paramad)
  {
    this.jgl = paramad;
    return true;
  }
  
  public final boolean bsP()
  {
    int j;
    if (!bk.bl(this.saA))
    {
      bA(this.saA, true);
      j = 1;
    }
    for (int i = 1;; i = 0)
    {
      int k = i;
      if (!bk.bl(this.saB))
      {
        this.saC = this.saB.split(",");
        for (;;)
        {
          k = i;
          if (i >= this.saC.length + j) {
            break;
          }
          bA(this.saC[(i - j)].trim(), false);
          i += 1;
        }
      }
      if (k < 5)
      {
        bA(null, false);
        this.saE = false;
        return false;
      }
      this.saE = true;
      return false;
      j = 0;
    }
  }
  
  public void clearFocus()
  {
    int i = 1;
    while (i < this.saD.getChildCount())
    {
      this.saD.getChildAt(i).clearFocus();
      i += 1;
    }
  }
  
  public final void cmo()
  {
    if (this.saD.getChildCount() - 1 < 5) {
      bA(null, false);
    }
    for (;;)
    {
      cmu();
      return;
      this.saE = true;
    }
  }
  
  public final void cmp()
  {
    cmu();
  }
  
  public final void f(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    if (paramMMPhoneNumberEditText.sah)
    {
      h.a(getContext(), R.l.hide_md5_match_phone_number_tip, 0, R.l.hide_md5_match_phone_number_hide, R.l.hide_md5_match_phone_number_cancel, new ProfileEditPhoneNumberView.1(this, paramMMPhoneNumberEditText), null);
      return;
    }
    h(paramMMPhoneNumberEditText);
    if (this.saE)
    {
      bA(null, false);
      this.saE = false;
    }
    cmu();
  }
  
  public final void g(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    if (this.saD.getChildCount() - 1 == 1) {
      return;
    }
    h(paramMMPhoneNumberEditText);
    if (this.saE) {
      bA(null, false);
    }
    this.saE = false;
    cmu();
  }
  
  public int getLayout()
  {
    return R.i.profile_edit_phone_number_layout;
  }
  
  public ArrayList<String> getPhoneNumberList()
  {
    int j = this.saD.getChildCount();
    if (j == 1) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(j - 1);
    int i = 1;
    while (i < j)
    {
      String str = ((MMPhoneNumberEditText)this.saD.getChildAt(i)).getText().toString();
      if (!bk.bl(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if (!bk.bl(this.saA)) {
      localArrayList.remove(0);
    }
    return localArrayList;
  }
  
  public final void init()
  {
    this.saD = ((LinearLayout)findViewById(R.h.main_layout));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView
 * JD-Core Version:    0.7.0.1
 */
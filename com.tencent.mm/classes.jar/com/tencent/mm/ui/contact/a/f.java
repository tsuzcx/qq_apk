package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.selectcontact.a.h;

public final class f
  extends a
{
  private CharSequence kDf;
  private a.b vOD = new f.b(this);
  a.a vOE = new f.a(this);
  
  public f(int paramInt)
  {
    super(5, paramInt);
  }
  
  protected final a.a VA()
  {
    return this.vOE;
  }
  
  public final a.b Vz()
  {
    return this.vOD;
  }
  
  public final void bW(Context paramContext)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String[] arrayOfString = this.kwi.kwI;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new ForegroundColorSpan(b.b.kzY), 0, str.length(), 33);
      localSpannableStringBuilder.append(localSpannableString);
      localSpannableStringBuilder.append("、");
      i += 1;
    }
    this.kDf = TextUtils.concat(new CharSequence[] { paramContext.getString(a.h.select_contact_create_desc_prefix), localSpannableStringBuilder.subSequence(0, localSpannableStringBuilder.length() - 1), paramContext.getString(a.h.select_contact_create_desc_prefix) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.f
 * JD-Core Version:    0.7.0.1
 */
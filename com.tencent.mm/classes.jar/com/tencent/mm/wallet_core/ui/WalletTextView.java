package com.tencent.mm.wallet_core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Selection;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.f.a;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"AppCompatCustomView"})
public class WalletTextView
  extends TextView
{
  private static final String TAG = "MicroMsg." + new StringBuilder("weiVtxeTtellaW").reverse().toString();
  private String mPrefix;
  private Object ugH = "";
  private Object wCB = "";
  private int wCC;
  
  public WalletTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.WalletTextViewAttrs, paramInt, 0);
    this.wCC = paramContext.getInteger(a.k.WalletTextViewAttrs_walletTypeFace, 4);
    this.mPrefix = paramContext.getString(a.k.WalletTextViewAttrs_walletPrefix);
    paramContext.recycle();
    cNs();
  }
  
  private void cNs()
  {
    String str = e.Ja(this.wCC);
    setTypeface(Typeface.createFromAsset(getContext().getAssets(), str));
  }
  
  public int getSelectionEnd()
  {
    return Selection.getSelectionEnd((CharSequence)this.ugH);
  }
  
  public int getSelectionStart()
  {
    return Selection.getSelectionStart((CharSequence)this.ugH);
  }
  
  @Deprecated
  public CharSequence getText()
  {
    int i = 1;
    Object localObject = a.cMS();
    if (com.tencent.mm.plugin.normsg.a.b.mGK.bu(this)) {
      if (!((a)localObject).wBj.containsKey(this)) {
        break label41;
      }
    }
    for (i = 0; i != 0; i = 0)
    {
      return (CharSequence)this.ugH;
      label41:
      ((a)localObject).wBj.put(this, Boolean.valueOf(true));
      f.nEG.a(715L, 0L, 1L, false);
      if (((com.tencent.mm.wallet_core.f.b.cMV()) || (h.zK())) && (com.tencent.mm.wallet_core.f.b.cMT())) {
        d.nQr.wZ(-2147483648);
      }
    }
    y.printErrStackTrace(TAG, new Throwable(), "check point 0.", new Object[0]);
    if ((com.tencent.mm.wallet_core.f.b.cMV()) || (h.zK()))
    {
      if (com.tencent.mm.wallet_core.f.b.cMU()) {}
      for (localObject = this.wCB;; localObject = this.ugH) {
        return (CharSequence)localObject;
      }
    }
    return (CharSequence)this.ugH;
  }
  
  public void setPrefix(String paramString)
  {
    this.mPrefix = paramString;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.ugH = paramCharSequence;
    Object localObject = paramCharSequence.toString();
    if ((localObject == null) || (((String)localObject).length() == 0)) {}
    StringBuilder localStringBuilder;
    String str;
    for (localObject = "";; localObject = ((String)localObject).replaceAll(str, localStringBuilder.toString()))
    {
      this.wCB = localObject;
      localObject = paramCharSequence;
      if (!bk.bl(this.mPrefix)) {
        localObject = this.mPrefix + paramCharSequence;
      }
      if ((this.wCC != 4) && (!bk.L((CharSequence)localObject)) && (Pattern.compile(".*?[a-zA-Z]+.*?").matcher((CharSequence)localObject).matches()))
      {
        y.i(TAG, "force use std font");
        this.wCC = 4;
        cNs();
      }
      super.setText((CharSequence)localObject, paramBufferType);
      return;
      localStringBuilder = new StringBuilder(7);
      int i = 0;
      while (i < 7)
      {
        localStringBuilder.append((char)(int)(6222620280936476253L >> (6 - i) * 8 & 0xFF));
        i += 1;
      }
      str = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
    }
  }
  
  public void setTypeface(int paramInt)
  {
    this.wCC = paramInt;
    String str = e.Ja(paramInt);
    setTypeface(Typeface.createFromAsset(getContext().getAssets(), str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletTextView
 * JD-Core Version:    0.7.0.1
 */
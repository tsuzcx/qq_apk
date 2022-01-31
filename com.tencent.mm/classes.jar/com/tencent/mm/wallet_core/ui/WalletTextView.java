package com.tencent.mm.wallet_core.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Selection;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.f.a;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"AppCompatCustomView"})
public class WalletTextView
  extends TextView
{
  private static final String TAG;
  private Object AYN;
  private int AYO;
  private String mPrefix;
  private Object yoD;
  
  static
  {
    AppMethodBeat.i(49352);
    TAG = "MicroMsg." + new StringBuilder("weiVtxeTtellaW").reverse().toString();
    AppMethodBeat.o(49352);
  }
  
  public WalletTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49345);
    this.yoD = "";
    this.AYN = "";
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletTextViewAttrs, paramInt, 0);
    this.AYO = paramContext.getInteger(0, 4);
    this.mPrefix = paramContext.getString(1);
    paramContext.recycle();
    dSW();
    AppMethodBeat.o(49345);
  }
  
  private void dSW()
  {
    AppMethodBeat.i(49347);
    String str = e.RV(this.AYO);
    setTypeface(Typeface.createFromAsset(getContext().getAssets(), str));
    AppMethodBeat.o(49347);
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(49351);
    int i = Selection.getSelectionEnd((CharSequence)this.yoD);
    AppMethodBeat.o(49351);
    return i;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(49350);
    int i = Selection.getSelectionStart((CharSequence)this.yoD);
    AppMethodBeat.o(49350);
    return i;
  }
  
  @Deprecated
  public CharSequence getText()
  {
    AppMethodBeat.i(49349);
    Object localObject = a.dSG();
    int i;
    if (com.tencent.mm.plugin.normsg.a.b.pgQ.bY(this)) {
      if (((a)localObject).AXH.containsKey(this)) {
        i = 0;
      }
    }
    while (i != 0)
    {
      localObject = (CharSequence)this.yoD;
      AppMethodBeat.o(49349);
      return localObject;
      ((a)localObject).AXH.put(this, Boolean.TRUE);
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(715L, 0L, 1L, false);
      if (((com.tencent.mm.wallet_core.f.b.dSJ()) || (h.Mn())) && (com.tencent.mm.wallet_core.f.b.dSH())) {
        d.qEo.CU(-2147483648);
      }
      i = 0;
      continue;
      i = 1;
    }
    ab.printErrStackTrace(TAG, new Throwable(), "check point 0.", new Object[0]);
    if ((com.tencent.mm.wallet_core.f.b.dSJ()) || (h.Mn()))
    {
      if (com.tencent.mm.wallet_core.f.b.dSI()) {}
      for (localObject = this.AYN;; localObject = this.yoD)
      {
        localObject = (CharSequence)localObject;
        AppMethodBeat.o(49349);
        return localObject;
      }
    }
    localObject = (CharSequence)this.yoD;
    AppMethodBeat.o(49349);
    return localObject;
  }
  
  public void setPrefix(String paramString)
  {
    this.mPrefix = paramString;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(49346);
    this.yoD = paramCharSequence;
    Object localObject = paramCharSequence.toString();
    if ((localObject == null) || (((String)localObject).length() == 0)) {}
    StringBuilder localStringBuilder;
    String str;
    for (localObject = "";; localObject = ((String)localObject).replaceAll(str, localStringBuilder.toString()))
    {
      this.AYN = localObject;
      localObject = paramCharSequence;
      if (!bo.isNullOrNil(this.mPrefix)) {
        localObject = this.mPrefix + paramCharSequence;
      }
      if ((this.AYO != 4) && (!bo.aa((CharSequence)localObject)) && (Pattern.compile(".*?[a-zA-Z]+.*?").matcher((CharSequence)localObject).matches()))
      {
        ab.i(TAG, "force use std font");
        this.AYO = 4;
        dSW();
      }
      super.setText((CharSequence)localObject, paramBufferType);
      AppMethodBeat.o(49346);
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
    AppMethodBeat.i(49348);
    this.AYO = paramInt;
    String str = e.RV(paramInt);
    setTypeface(Typeface.createFromAsset(getContext().getAssets(), str));
    AppMethodBeat.o(49348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletTextView
 * JD-Core Version:    0.7.0.1
 */
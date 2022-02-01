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
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.f.a;
import com.tencent.mm.wallet_core.f.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"AppCompatCustomView"})
public class WalletTextView
  extends TextView
{
  private static final String TAG;
  private Object EVp;
  private Object IfA;
  private int IfB;
  private String mPrefix;
  
  static
  {
    AppMethodBeat.i(73077);
    TAG = "MicroMsg." + new StringBuilder("weiVtxeTtellaW").reverse().toString();
    AppMethodBeat.o(73077);
  }
  
  public WalletTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73071);
    this.EVp = "";
    this.IfA = "";
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WalletTextViewAttrs, paramInt, 0);
    this.IfB = paramContext.getInteger(1, 4);
    this.mPrefix = paramContext.getString(0);
    paramContext.recycle();
    paramContext = e.abw(this.IfB);
    try
    {
      setTypeface(Typeface.createFromAsset(getContext().getAssets(), paramContext));
      AppMethodBeat.o(73071);
      return;
    }
    catch (Exception paramContext)
    {
      ad.e(TAG, "updateWalletTypeface() Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      AppMethodBeat.o(73071);
    }
  }
  
  public int getSelectionEnd()
  {
    AppMethodBeat.i(73076);
    int i = Selection.getSelectionEnd((CharSequence)this.EVp);
    AppMethodBeat.o(73076);
    return i;
  }
  
  public int getSelectionStart()
  {
    AppMethodBeat.i(73075);
    int i = Selection.getSelectionStart((CharSequence)this.EVp);
    AppMethodBeat.o(73075);
    return i;
  }
  
  @Deprecated
  public CharSequence getText()
  {
    AppMethodBeat.i(73074);
    if (a.fkn().el(this))
    {
      localObject = (CharSequence)this.EVp;
      AppMethodBeat.o(73074);
      return localObject;
    }
    ad.printErrStackTrace(TAG, new Throwable(), "check point 0.", new Object[0]);
    if ((b.fkq()) || (g.XL()))
    {
      if (b.fkp()) {}
      for (localObject = this.IfA;; localObject = this.EVp)
      {
        localObject = (CharSequence)localObject;
        AppMethodBeat.o(73074);
        return localObject;
      }
    }
    Object localObject = (CharSequence)this.EVp;
    AppMethodBeat.o(73074);
    return localObject;
  }
  
  public void setPrefix(String paramString)
  {
    this.mPrefix = paramString;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(73072);
    this.EVp = paramCharSequence;
    Object localObject = paramCharSequence.toString();
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      localObject = "";
      this.IfA = localObject;
      if (bt.isNullOrNil(this.mPrefix)) {
        break label237;
      }
      paramCharSequence = this.mPrefix + paramCharSequence;
    }
    label237:
    for (;;)
    {
      localObject = paramCharSequence;
      if (this.IfB < 4)
      {
        localObject = paramCharSequence;
        if (!bt.ai(paramCharSequence))
        {
          localObject = paramCharSequence;
          if (Pattern.compile(".*?[a-zA-Z]+.*?").matcher(paramCharSequence).matches())
          {
            ad.i(TAG, "force use std font");
            localObject = paramCharSequence;
            if ((paramCharSequence instanceof String)) {
              localObject = ((String)paramCharSequence).toLowerCase();
            }
          }
        }
      }
      super.setText((CharSequence)localObject, paramBufferType);
      AppMethodBeat.o(73072);
      return;
      StringBuilder localStringBuilder = new StringBuilder(7);
      int i = 0;
      while (i < 7)
      {
        localStringBuilder.append((char)(int)(6222620280936476253L >> (6 - i) * 8 & 0xFF));
        i += 1;
      }
      String str = localStringBuilder.toString();
      localStringBuilder.delete(0, localStringBuilder.length());
      localObject = ((String)localObject).replaceAll(str, localStringBuilder.toString());
      break;
    }
  }
  
  public void setTypeface(int paramInt)
  {
    AppMethodBeat.i(73073);
    this.IfB = paramInt;
    String str = e.abw(paramInt);
    try
    {
      setTypeface(Typeface.createFromAsset(getContext().getAssets(), str));
      AppMethodBeat.o(73073);
      return;
    }
    catch (Exception localException)
    {
      ad.e(TAG, "setTypeface() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(73073);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletTextView
 * JD-Core Version:    0.7.0.1
 */
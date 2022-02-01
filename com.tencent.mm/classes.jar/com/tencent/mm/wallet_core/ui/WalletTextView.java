package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.e.a;
import com.tencent.mm.wallet_core.e.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WalletTextView
  extends TextView
{
  private static final String TAG;
  private Object agVo;
  private int agVp;
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
    this.agVo = "";
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.WalletTextViewAttrs, paramInt, 0);
    this.agVp = paramContext.getInteger(a.k.WalletTextViewAttrs_walletTypeFace, 4);
    this.mPrefix = paramContext.getString(a.k.WalletTextViewAttrs_walletPrefix);
    paramContext.recycle();
    paramContext = i.aGy(this.agVp);
    try
    {
      setTypeface(Typeface.createFromAsset(getContext().getAssets(), paramContext));
      AppMethodBeat.o(73071);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e(TAG, "updateWalletTypeface() Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      AppMethodBeat.o(73071);
    }
  }
  
  @Deprecated
  public CharSequence getText()
  {
    AppMethodBeat.i(73074);
    if (a.jPd().gY(this))
    {
      localObject = super.getText();
      AppMethodBeat.o(73074);
      return localObject;
    }
    Log.printErrStackTrace(TAG, new Throwable(), "check point 0.", new Object[0]);
    if ((b.jPg()) || (g.isMIUI()))
    {
      if (b.jPf()) {}
      for (localObject = this.agVo;; localObject = super.getText())
      {
        localObject = (CharSequence)localObject;
        AppMethodBeat.o(73074);
        return localObject;
      }
    }
    Object localObject = super.getText();
    AppMethodBeat.o(73074);
    return localObject;
  }
  
  public final CharSequence jPy()
  {
    AppMethodBeat.i(369591);
    CharSequence localCharSequence = super.getText();
    AppMethodBeat.o(369591);
    return localCharSequence;
  }
  
  public void setPrefix(String paramString)
  {
    this.mPrefix = paramString;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(73072);
    Object localObject = paramCharSequence.toString();
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      localObject = "";
      this.agVo = localObject;
      if ((Util.isNullOrNil(this.mPrefix)) || (paramCharSequence.toString().startsWith(this.mPrefix))) {
        break label248;
      }
      paramCharSequence = this.mPrefix + paramCharSequence;
    }
    label248:
    for (;;)
    {
      localObject = paramCharSequence;
      if (this.agVp < 4)
      {
        localObject = paramCharSequence;
        if (!Util.isNullOrNil(paramCharSequence))
        {
          localObject = paramCharSequence;
          if (Pattern.compile(".*?[a-zA-Z]+.*?").matcher(paramCharSequence).matches())
          {
            Log.i(TAG, "force use std font");
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
    this.agVp = paramInt;
    String str = i.aGy(paramInt);
    try
    {
      setTypeface(Typeface.createFromAsset(getContext().getAssets(), str));
      AppMethodBeat.o(73073);
      return;
    }
    catch (Exception localException)
    {
      Log.e(TAG, "setTypeface() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(73073);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletTextView
 * JD-Core Version:    0.7.0.1
 */
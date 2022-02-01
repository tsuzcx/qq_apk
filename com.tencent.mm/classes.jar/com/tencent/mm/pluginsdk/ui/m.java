package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Collection;
import java.util.Set;

public final class m
{
  private static LruCache<String, Integer> KdG;
  private SpannableString KdA;
  private SpannableStringBuilder KdB;
  private CharacterStyle KdC;
  private int KdD;
  private int KdE;
  public int KdF;
  private StringBuilder Kdy;
  private SpannableStringBuilder Kdz;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(31280);
    KdG = new LruCache(50);
    AppMethodBeat.o(31280);
  }
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(31274);
    this.Kdz = new SpannableStringBuilder();
    this.KdB = new SpannableStringBuilder();
    this.KdC = new ForegroundColorSpan(-5066062);
    this.KdF = 3;
    this.mContext = paramContext;
    AppMethodBeat.o(31274);
  }
  
  public final void a(MMEditText paramMMEditText, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31275);
    if (paramMMEditText == null)
    {
      AppMethodBeat.o(31275);
      return;
    }
    if (this.Kdy == null)
    {
      paramMMEditText = new IllegalStateException("You should saveHistory before setText");
      AppMethodBeat.o(31275);
      throw paramMMEditText;
    }
    int k = this.KdD + paramString.length();
    this.Kdz.clear();
    this.KdB.clear();
    SpannableStringBuilder localSpannableStringBuilder2;
    if (paramBoolean)
    {
      this.KdA = com.tencent.mm.ce.g.gxZ().a(this.mContext, this.Kdy.subSequence(0, this.KdD), paramMMEditText.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder1 = this.Kdz.append(this.KdA);
      localSpannableStringBuilder2 = this.KdB;
      if ((localSpannableStringBuilder2 == null) || (paramString == null) || (paramString.length() == 0)) {
        localSpannableStringBuilder1.append(localSpannableStringBuilder2).append(this.Kdy.subSequence(this.KdE, this.Kdy.length()));
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", new Object[] { Integer.valueOf(this.KdD), Integer.valueOf(this.KdE), Integer.valueOf(k), Integer.valueOf(this.Kdz.length()), paramString, this.Kdz });
      paramMMEditText.setText(this.Kdz);
      if (k > this.Kdz.length()) {
        break label372;
      }
      if (k != 0) {
        break label366;
      }
      paramMMEditText.setSelection(this.Kdz.length());
      AppMethodBeat.o(31275);
      return;
      int j;
      if (paramString.length() < this.KdF) {
        j = paramString.length();
      }
      for (int i = 0;; i = j - this.KdF)
      {
        localSpannableStringBuilder2.append(paramString).setSpan(this.KdC, i, j, 33);
        break;
        j = paramString.length();
      }
      this.KdA = com.tencent.mm.ce.g.gxZ().a(this.mContext, paramString, paramMMEditText.getTextSize());
      this.Kdz.append(this.KdA);
    }
    label366:
    paramMMEditText.setSelection(k);
    label372:
    AppMethodBeat.o(31275);
  }
  
  public final int beA(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31278);
        if (KdG.size() == 0)
        {
          Object localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OgI, "");
          try
          {
            localObject = ((String)localObject).split(";");
            int j = localObject.length;
            i = 0;
            if (i < j)
            {
              String[] arrayOfString = localObject[i].split(":");
              if (arrayOfString.length == 2) {
                KdG.put(arrayOfString[0], Integer.valueOf(j.cL(arrayOfString[1])));
              }
              i += 1;
              continue;
            }
            if (!KdG.check(paramString)) {
              continue;
            }
          }
          catch (Error localError) {}
        }
        else
        {
          i = ((Integer)KdG.get(paramString)).intValue();
          AppMethodBeat.o(31278);
          return i;
        }
      }
      finally {}
      AppMethodBeat.o(31278);
      int i = 0;
    }
  }
  
  public final void d(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(31276);
    if (paramMMEditText == null)
    {
      AppMethodBeat.o(31276);
      return;
    }
    this.KdF = 0;
    this.KdA = com.tencent.mm.ce.g.gxZ().a(this.mContext, paramMMEditText.getText().toString(), paramMMEditText.getTextSize());
    Log.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", new Object[] { this.KdA });
    paramMMEditText.setText(this.KdA);
    paramMMEditText.setSelection(this.KdA.length());
    AppMethodBeat.o(31276);
  }
  
  public final void e(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(31277);
    if (paramMMEditText == null)
    {
      AppMethodBeat.o(31277);
      return;
    }
    this.KdD = paramMMEditText.getSelectionStart();
    this.KdE = paramMMEditText.getSelectionEnd();
    this.Kdy = new StringBuilder(paramMMEditText.getText());
    Log.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", new Object[] { Integer.valueOf(this.KdD), Integer.valueOf(this.KdE), this.Kdy });
    if (paramMMEditText.getText().toString().equalsIgnoreCase("")) {
      this.Kdz.clear();
    }
    if (this.KdD < 0) {
      this.KdD = 0;
    }
    if (this.KdE < 0) {
      this.KdE = 0;
    }
    AppMethodBeat.o(31277);
  }
  
  public final void gH(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(31279);
      KdG.put(paramString, Integer.valueOf(paramInt));
      paramString = new StringBuilder();
      Object[] arrayOfObject1 = KdG.keySet().toArray();
      Object[] arrayOfObject2 = KdG.values().toArray();
      paramInt = 0;
      while (paramInt < arrayOfObject1.length)
      {
        paramString.append(arrayOfObject1[paramInt]).append(":").append(arrayOfObject2[paramInt]).append(";");
        paramInt += 1;
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OgI, paramString.toString());
      AppMethodBeat.o(31279);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.m
 * JD-Core Version:    0.7.0.1
 */
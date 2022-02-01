package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

public final class m
{
  private static ag<String, Integer> EUt;
  private StringBuilder EUl;
  private SpannableStringBuilder EUm;
  private SpannableString EUn;
  private SpannableStringBuilder EUo;
  private CharacterStyle EUp;
  private int EUq;
  private int EUr;
  public int EUs;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(31280);
    EUt = new ag(50);
    AppMethodBeat.o(31280);
  }
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(31274);
    this.EUm = new SpannableStringBuilder();
    this.EUo = new SpannableStringBuilder();
    this.EUp = new ForegroundColorSpan(-5066062);
    this.EUs = 3;
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
    if (this.EUl == null)
    {
      paramMMEditText = new IllegalStateException("You should saveHistory before setText");
      AppMethodBeat.o(31275);
      throw paramMMEditText;
    }
    int k = this.EUq + paramString.length();
    this.EUm.clear();
    this.EUo.clear();
    SpannableStringBuilder localSpannableStringBuilder2;
    if (paramBoolean)
    {
      this.EUn = com.tencent.mm.cf.g.fng().b(this.EUl.subSequence(0, this.EUq), paramMMEditText.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder1 = this.EUm.append(this.EUn);
      localSpannableStringBuilder2 = this.EUo;
      if ((localSpannableStringBuilder2 == null) || (paramString == null) || (paramString.length() == 0)) {
        localSpannableStringBuilder1.append(localSpannableStringBuilder2).append(this.EUl.subSequence(this.EUr, this.EUl.length()));
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", new Object[] { Integer.valueOf(this.EUq), Integer.valueOf(this.EUr), Integer.valueOf(k), Integer.valueOf(this.EUm.length()), paramString, this.EUm });
      paramMMEditText.setText(this.EUm);
      if (k > this.EUm.length()) {
        break label364;
      }
      if (k != 0) {
        break label358;
      }
      paramMMEditText.setSelection(this.EUm.length());
      AppMethodBeat.o(31275);
      return;
      int j;
      if (paramString.length() < this.EUs) {
        j = paramString.length();
      }
      for (int i = 0;; i = j - this.EUs)
      {
        localSpannableStringBuilder2.append(paramString).setSpan(this.EUp, i, j, 33);
        break;
        j = paramString.length();
      }
      this.EUn = com.tencent.mm.cf.g.fng().b(paramString, paramMMEditText.getTextSize());
      this.EUm.append(this.EUn);
    }
    label358:
    paramMMEditText.setSelection(k);
    label364:
    AppMethodBeat.o(31275);
  }
  
  public final int aMC(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31278);
        if (EUt.size() == 0)
        {
          Object localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IDL, "");
          try
          {
            localObject = ((String)localObject).split(";");
            int j = localObject.length;
            i = 0;
            if (i < j)
            {
              String[] arrayOfString = localObject[i].split(":");
              if (arrayOfString.length == 2) {
                EUt.put(arrayOfString[0], Integer.valueOf(j.eZ(arrayOfString[1])));
              }
              i += 1;
              continue;
            }
            if (!EUt.aM(paramString)) {
              continue;
            }
          }
          catch (Error localError) {}
        }
        else
        {
          i = ((Integer)EUt.get(paramString)).intValue();
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
    this.EUs = 0;
    this.EUn = com.tencent.mm.cf.g.fng().b(paramMMEditText.getText().toString(), paramMMEditText.getTextSize());
    ad.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", new Object[] { this.EUn });
    paramMMEditText.setText(this.EUn);
    paramMMEditText.setSelection(this.EUn.length());
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
    this.EUq = paramMMEditText.getSelectionStart();
    this.EUr = paramMMEditText.getSelectionEnd();
    this.EUl = new StringBuilder(paramMMEditText.getText());
    ad.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", new Object[] { Integer.valueOf(this.EUq), Integer.valueOf(this.EUr), this.EUl });
    if (paramMMEditText.getText().toString().equalsIgnoreCase("")) {
      this.EUm.clear();
    }
    if (this.EUq < 0) {
      this.EUq = 0;
    }
    if (this.EUr < 0) {
      this.EUr = 0;
    }
    AppMethodBeat.o(31277);
  }
  
  public final void ga(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(31279);
      EUt.put(paramString, Integer.valueOf(paramInt));
      paramString = new StringBuilder();
      Object[] arrayOfObject1 = EUt.map.keySet().toArray();
      Object[] arrayOfObject2 = EUt.map.values().toArray();
      paramInt = 0;
      while (paramInt < arrayOfObject1.length)
      {
        paramString.append(arrayOfObject1[paramInt]).append(":").append(arrayOfObject2[paramInt]).append(";");
        paramInt += 1;
      }
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDL, paramString.toString());
      AppMethodBeat.o(31279);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.m
 * JD-Core Version:    0.7.0.1
 */
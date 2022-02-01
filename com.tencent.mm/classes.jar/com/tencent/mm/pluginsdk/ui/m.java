package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

public final class m
{
  private static ah<String, Integer> FmO;
  private StringBuilder FmG;
  private SpannableStringBuilder FmH;
  private SpannableString FmI;
  private SpannableStringBuilder FmJ;
  private CharacterStyle FmK;
  private int FmL;
  private int FmM;
  public int FmN;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(31280);
    FmO = new ah(50);
    AppMethodBeat.o(31280);
  }
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(31274);
    this.FmH = new SpannableStringBuilder();
    this.FmJ = new SpannableStringBuilder();
    this.FmK = new ForegroundColorSpan(-5066062);
    this.FmN = 3;
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
    if (this.FmG == null)
    {
      paramMMEditText = new IllegalStateException("You should saveHistory before setText");
      AppMethodBeat.o(31275);
      throw paramMMEditText;
    }
    int k = this.FmL + paramString.length();
    this.FmH.clear();
    this.FmJ.clear();
    SpannableStringBuilder localSpannableStringBuilder2;
    if (paramBoolean)
    {
      this.FmI = com.tencent.mm.ce.g.fqZ().b(this.FmG.subSequence(0, this.FmL), paramMMEditText.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder1 = this.FmH.append(this.FmI);
      localSpannableStringBuilder2 = this.FmJ;
      if ((localSpannableStringBuilder2 == null) || (paramString == null) || (paramString.length() == 0)) {
        localSpannableStringBuilder1.append(localSpannableStringBuilder2).append(this.FmG.subSequence(this.FmM, this.FmG.length()));
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", new Object[] { Integer.valueOf(this.FmL), Integer.valueOf(this.FmM), Integer.valueOf(k), Integer.valueOf(this.FmH.length()), paramString, this.FmH });
      paramMMEditText.setText(this.FmH);
      if (k > this.FmH.length()) {
        break label364;
      }
      if (k != 0) {
        break label358;
      }
      paramMMEditText.setSelection(this.FmH.length());
      AppMethodBeat.o(31275);
      return;
      int j;
      if (paramString.length() < this.FmN) {
        j = paramString.length();
      }
      for (int i = 0;; i = j - this.FmN)
      {
        localSpannableStringBuilder2.append(paramString).setSpan(this.FmK, i, j, 33);
        break;
        j = paramString.length();
      }
      this.FmI = com.tencent.mm.ce.g.fqZ().b(paramString, paramMMEditText.getTextSize());
      this.FmH.append(this.FmI);
    }
    label358:
    paramMMEditText.setSelection(k);
    label364:
    AppMethodBeat.o(31275);
  }
  
  public final int aNY(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31278);
        if (FmO.size() == 0)
        {
          Object localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYl, "");
          try
          {
            localObject = ((String)localObject).split(";");
            int j = localObject.length;
            i = 0;
            if (i < j)
            {
              String[] arrayOfString = localObject[i].split(":");
              if (arrayOfString.length == 2) {
                FmO.put(arrayOfString[0], Integer.valueOf(j.fe(arrayOfString[1])));
              }
              i += 1;
              continue;
            }
            if (!FmO.aM(paramString)) {
              continue;
            }
          }
          catch (Error localError) {}
        }
        else
        {
          i = ((Integer)FmO.get(paramString)).intValue();
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
    this.FmN = 0;
    this.FmI = com.tencent.mm.ce.g.fqZ().b(paramMMEditText.getText().toString(), paramMMEditText.getTextSize());
    ae.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", new Object[] { this.FmI });
    paramMMEditText.setText(this.FmI);
    paramMMEditText.setSelection(this.FmI.length());
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
    this.FmL = paramMMEditText.getSelectionStart();
    this.FmM = paramMMEditText.getSelectionEnd();
    this.FmG = new StringBuilder(paramMMEditText.getText());
    ae.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", new Object[] { Integer.valueOf(this.FmL), Integer.valueOf(this.FmM), this.FmG });
    if (paramMMEditText.getText().toString().equalsIgnoreCase("")) {
      this.FmH.clear();
    }
    if (this.FmL < 0) {
      this.FmL = 0;
    }
    if (this.FmM < 0) {
      this.FmM = 0;
    }
    AppMethodBeat.o(31277);
  }
  
  public final void gj(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(31279);
      FmO.put(paramString, Integer.valueOf(paramInt));
      paramString = new StringBuilder();
      Object[] arrayOfObject1 = FmO.map.keySet().toArray();
      Object[] arrayOfObject2 = FmO.map.values().toArray();
      paramInt = 0;
      while (paramInt < arrayOfObject1.length)
      {
        paramString.append(arrayOfObject1[paramInt]).append(":").append(arrayOfObject2[paramInt]).append(";");
        paramInt += 1;
      }
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYl, paramString.toString());
      AppMethodBeat.o(31279);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.m
 * JD-Core Version:    0.7.0.1
 */
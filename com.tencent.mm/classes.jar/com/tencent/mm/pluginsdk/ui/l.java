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
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

public final class l
{
  private static ag<String, Integer> BWY;
  private StringBuilder BWQ;
  private SpannableStringBuilder BWR;
  private SpannableString BWS;
  private SpannableStringBuilder BWT;
  private CharacterStyle BWU;
  private int BWV;
  private int BWW;
  public int BWX;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(31280);
    BWY = new ag(50);
    AppMethodBeat.o(31280);
  }
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(31274);
    this.BWR = new SpannableStringBuilder();
    this.BWT = new SpannableStringBuilder();
    this.BWU = new ForegroundColorSpan(-5066062);
    this.BWX = 3;
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
    if (this.BWQ == null)
    {
      paramMMEditText = new IllegalStateException("You should saveHistory before setText");
      AppMethodBeat.o(31275);
      throw paramMMEditText;
    }
    int k = this.BWV + paramString.length();
    this.BWR.clear();
    this.BWT.clear();
    SpannableStringBuilder localSpannableStringBuilder2;
    if (paramBoolean)
    {
      this.BWS = com.tencent.mm.cg.g.eIa().b(this.BWQ.subSequence(0, this.BWV), paramMMEditText.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder1 = this.BWR.append(this.BWS);
      localSpannableStringBuilder2 = this.BWT;
      if ((localSpannableStringBuilder2 == null) || (paramString == null) || (paramString.length() == 0)) {
        localSpannableStringBuilder1.append(localSpannableStringBuilder2).append(this.BWQ.subSequence(this.BWW, this.BWQ.length()));
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", new Object[] { Integer.valueOf(this.BWV), Integer.valueOf(this.BWW), Integer.valueOf(k), Integer.valueOf(this.BWR.length()), paramString, this.BWR });
      paramMMEditText.setText(this.BWR);
      if (k > this.BWR.length()) {
        break label364;
      }
      if (k != 0) {
        break label358;
      }
      paramMMEditText.setSelection(this.BWR.length());
      AppMethodBeat.o(31275);
      return;
      int j;
      if (paramString.length() < this.BWX) {
        j = paramString.length();
      }
      for (int i = 0;; i = j - this.BWX)
      {
        localSpannableStringBuilder2.append(paramString).setSpan(this.BWU, i, j, 33);
        break;
        j = paramString.length();
      }
      this.BWS = com.tencent.mm.cg.g.eIa().b(paramString, paramMMEditText.getTextSize());
      this.BWR.append(this.BWS);
    }
    label358:
    paramMMEditText.setSelection(k);
    label364:
    AppMethodBeat.o(31275);
  }
  
  public final int aBH(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31278);
        if (BWY.size() == 0)
        {
          Object localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Ftn, "");
          try
          {
            localObject = ((String)localObject).split(";");
            int j = localObject.length;
            i = 0;
            if (i < j)
            {
              String[] arrayOfString = localObject[i].split(":");
              if (arrayOfString.length == 2) {
                BWY.put(arrayOfString[0], Integer.valueOf(j.ep(arrayOfString[1])));
              }
              i += 1;
              continue;
            }
            if (!BWY.aN(paramString)) {
              continue;
            }
          }
          catch (Error localError) {}
        }
        else
        {
          i = ((Integer)BWY.get(paramString)).intValue();
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
    this.BWX = 0;
    this.BWS = com.tencent.mm.cg.g.eIa().b(paramMMEditText.getText().toString(), paramMMEditText.getTextSize());
    ad.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", new Object[] { this.BWS });
    paramMMEditText.setText(this.BWS);
    paramMMEditText.setSelection(this.BWS.length());
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
    this.BWV = paramMMEditText.getSelectionStart();
    this.BWW = paramMMEditText.getSelectionEnd();
    this.BWQ = new StringBuilder(paramMMEditText.getText());
    ad.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", new Object[] { Integer.valueOf(this.BWV), Integer.valueOf(this.BWW), this.BWQ });
    if (paramMMEditText.getText().toString().equalsIgnoreCase("")) {
      this.BWR.clear();
    }
    if (this.BWV < 0) {
      this.BWV = 0;
    }
    if (this.BWW < 0) {
      this.BWW = 0;
    }
    AppMethodBeat.o(31277);
  }
  
  public final void fy(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(31279);
      BWY.put(paramString, Integer.valueOf(paramInt));
      paramString = new StringBuilder();
      Object[] arrayOfObject1 = BWY.map.keySet().toArray();
      Object[] arrayOfObject2 = BWY.map.values().toArray();
      paramInt = 0;
      while (paramInt < arrayOfObject1.length)
      {
        paramString.append(arrayOfObject1[paramInt]).append(":").append(arrayOfObject2[paramInt]).append(";");
        paramInt += 1;
      }
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Ftn, paramString.toString());
      AppMethodBeat.o(31279);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.l
 * JD-Core Version:    0.7.0.1
 */
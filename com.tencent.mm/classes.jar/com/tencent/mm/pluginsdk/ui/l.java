package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

public final class l
{
  private static af<String, Integer> Dpp;
  private StringBuilder Dph;
  private SpannableStringBuilder Dpi;
  private SpannableString Dpj;
  private SpannableStringBuilder Dpk;
  private CharacterStyle Dpl;
  private int Dpm;
  private int Dpn;
  public int Dpo;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(31280);
    Dpp = new af(50);
    AppMethodBeat.o(31280);
  }
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(31274);
    this.Dpi = new SpannableStringBuilder();
    this.Dpk = new SpannableStringBuilder();
    this.Dpl = new ForegroundColorSpan(-5066062);
    this.Dpo = 3;
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
    if (this.Dph == null)
    {
      paramMMEditText = new IllegalStateException("You should saveHistory before setText");
      AppMethodBeat.o(31275);
      throw paramMMEditText;
    }
    int k = this.Dpm + paramString.length();
    this.Dpi.clear();
    this.Dpk.clear();
    SpannableStringBuilder localSpannableStringBuilder2;
    if (paramBoolean)
    {
      this.Dpj = com.tencent.mm.cf.g.eXw().b(this.Dph.subSequence(0, this.Dpm), paramMMEditText.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder1 = this.Dpi.append(this.Dpj);
      localSpannableStringBuilder2 = this.Dpk;
      if ((localSpannableStringBuilder2 == null) || (paramString == null) || (paramString.length() == 0)) {
        localSpannableStringBuilder1.append(localSpannableStringBuilder2).append(this.Dph.subSequence(this.Dpn, this.Dph.length()));
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", new Object[] { Integer.valueOf(this.Dpm), Integer.valueOf(this.Dpn), Integer.valueOf(k), Integer.valueOf(this.Dpi.length()), paramString, this.Dpi });
      paramMMEditText.setText(this.Dpi);
      if (k > this.Dpi.length()) {
        break label364;
      }
      if (k != 0) {
        break label358;
      }
      paramMMEditText.setSelection(this.Dpi.length());
      AppMethodBeat.o(31275);
      return;
      int j;
      if (paramString.length() < this.Dpo) {
        j = paramString.length();
      }
      for (int i = 0;; i = j - this.Dpo)
      {
        localSpannableStringBuilder2.append(paramString).setSpan(this.Dpl, i, j, 33);
        break;
        j = paramString.length();
      }
      this.Dpj = com.tencent.mm.cf.g.eXw().b(paramString, paramMMEditText.getTextSize());
      this.Dpi.append(this.Dpj);
    }
    label358:
    paramMMEditText.setSelection(k);
    label364:
    AppMethodBeat.o(31275);
  }
  
  public final int aGZ(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31278);
        if (Dpp.size() == 0)
        {
          Object localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRh, "");
          try
          {
            localObject = ((String)localObject).split(";");
            int j = localObject.length;
            i = 0;
            if (i < j)
            {
              String[] arrayOfString = localObject[i].split(":");
              if (arrayOfString.length == 2) {
                Dpp.put(arrayOfString[0], Integer.valueOf(j.ee(arrayOfString[1])));
              }
              i += 1;
              continue;
            }
            if (!Dpp.aK(paramString)) {
              continue;
            }
          }
          catch (Error localError) {}
        }
        else
        {
          i = ((Integer)Dpp.get(paramString)).intValue();
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
    this.Dpo = 0;
    this.Dpj = com.tencent.mm.cf.g.eXw().b(paramMMEditText.getText().toString(), paramMMEditText.getTextSize());
    ac.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", new Object[] { this.Dpj });
    paramMMEditText.setText(this.Dpj);
    paramMMEditText.setSelection(this.Dpj.length());
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
    this.Dpm = paramMMEditText.getSelectionStart();
    this.Dpn = paramMMEditText.getSelectionEnd();
    this.Dph = new StringBuilder(paramMMEditText.getText());
    ac.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", new Object[] { Integer.valueOf(this.Dpm), Integer.valueOf(this.Dpn), this.Dph });
    if (paramMMEditText.getText().toString().equalsIgnoreCase("")) {
      this.Dpi.clear();
    }
    if (this.Dpm < 0) {
      this.Dpm = 0;
    }
    if (this.Dpn < 0) {
      this.Dpn = 0;
    }
    AppMethodBeat.o(31277);
  }
  
  public final void fD(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(31279);
      Dpp.put(paramString, Integer.valueOf(paramInt));
      paramString = new StringBuilder();
      Object[] arrayOfObject1 = Dpp.map.keySet().toArray();
      Object[] arrayOfObject2 = Dpp.map.values().toArray();
      paramInt = 0;
      while (paramInt < arrayOfObject1.length)
      {
        paramString.append(arrayOfObject1[paramInt]).append(":").append(arrayOfObject2[paramInt]).append(";");
        paramInt += 1;
      }
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRh, paramString.toString());
      AppMethodBeat.o(31279);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.l
 * JD-Core Version:    0.7.0.1
 */
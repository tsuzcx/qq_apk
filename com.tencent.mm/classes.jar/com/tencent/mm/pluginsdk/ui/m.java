package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.j;
import com.tencent.mm.kernel.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Collection;
import java.util.Set;

public final class m
{
  private static LruCache<String, Integer> Ren;
  private StringBuilder Ref;
  private SpannableStringBuilder Reg;
  private SpannableString Reh;
  private SpannableStringBuilder Rei;
  private CharacterStyle Rej;
  private int Rek;
  private int Rel;
  public int Rem;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(31280);
    Ren = new LruCache(50);
    AppMethodBeat.o(31280);
  }
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(31274);
    this.Reg = new SpannableStringBuilder();
    this.Rei = new SpannableStringBuilder();
    this.Rej = new ForegroundColorSpan(-5066062);
    this.Rem = 3;
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
    if (this.Ref == null)
    {
      paramMMEditText = new IllegalStateException("You should saveHistory before setText");
      AppMethodBeat.o(31275);
      throw paramMMEditText;
    }
    int k = this.Rek + paramString.length();
    this.Reg.clear();
    this.Rei.clear();
    SpannableStringBuilder localSpannableStringBuilder2;
    if (paramBoolean)
    {
      this.Reh = com.tencent.mm.cl.h.htZ().a(this.mContext, this.Ref.subSequence(0, this.Rek), paramMMEditText.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder1 = this.Reg.append(this.Reh);
      localSpannableStringBuilder2 = this.Rei;
      if ((localSpannableStringBuilder2 == null) || (paramString == null) || (paramString.length() == 0)) {
        localSpannableStringBuilder1.append(localSpannableStringBuilder2).append(this.Ref.subSequence(this.Rel, this.Ref.length()));
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", new Object[] { Integer.valueOf(this.Rek), Integer.valueOf(this.Rel), Integer.valueOf(k), Integer.valueOf(this.Reg.length()), paramString, this.Reg });
      paramMMEditText.setText(this.Reg);
      if (k > this.Reg.length()) {
        break label372;
      }
      if (k != 0) {
        break label366;
      }
      paramMMEditText.setSelection(this.Reg.length());
      AppMethodBeat.o(31275);
      return;
      int j;
      if (paramString.length() < this.Rem) {
        j = paramString.length();
      }
      for (int i = 0;; i = j - this.Rem)
      {
        localSpannableStringBuilder2.append(paramString).setSpan(this.Rej, i, j, 33);
        break;
        j = paramString.length();
      }
      this.Reh = com.tencent.mm.cl.h.htZ().a(this.mContext, paramString, paramMMEditText.getTextSize());
      this.Reg.append(this.Reh);
    }
    label366:
    paramMMEditText.setSelection(k);
    label372:
    AppMethodBeat.o(31275);
  }
  
  public final int bqW(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31278);
        if (Ren.size() == 0)
        {
          Object localObject = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VuY, "");
          try
          {
            localObject = ((String)localObject).split(";");
            int j = localObject.length;
            i = 0;
            if (i < j)
            {
              String[] arrayOfString = localObject[i].split(":");
              if (arrayOfString.length == 2) {
                Ren.put(arrayOfString[0], Integer.valueOf(j.df(arrayOfString[1])));
              }
              i += 1;
              continue;
            }
            if (!Ren.check(paramString)) {
              continue;
            }
          }
          catch (Error localError) {}
        }
        else
        {
          i = ((Integer)Ren.get(paramString)).intValue();
          AppMethodBeat.o(31278);
          return i;
        }
      }
      finally {}
      AppMethodBeat.o(31278);
      int i = 0;
    }
  }
  
  public final void e(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(31276);
    if (paramMMEditText == null)
    {
      AppMethodBeat.o(31276);
      return;
    }
    this.Rem = 0;
    this.Reh = com.tencent.mm.cl.h.htZ().a(this.mContext, paramMMEditText.getText().toString(), paramMMEditText.getTextSize());
    Log.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", new Object[] { this.Reh });
    paramMMEditText.setText(this.Reh);
    paramMMEditText.setSelection(this.Reh.length());
    AppMethodBeat.o(31276);
  }
  
  public final void f(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(31277);
    if (paramMMEditText == null)
    {
      AppMethodBeat.o(31277);
      return;
    }
    this.Rek = paramMMEditText.getSelectionStart();
    this.Rel = paramMMEditText.getSelectionEnd();
    this.Ref = new StringBuilder(paramMMEditText.getText());
    Log.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", new Object[] { Integer.valueOf(this.Rek), Integer.valueOf(this.Rel), this.Ref });
    if (paramMMEditText.getText().toString().equalsIgnoreCase("")) {
      this.Reg.clear();
    }
    if (this.Rek < 0) {
      this.Rek = 0;
    }
    if (this.Rel < 0) {
      this.Rel = 0;
    }
    AppMethodBeat.o(31277);
  }
  
  public final void hq(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(31279);
      Ren.put(paramString, Integer.valueOf(paramInt));
      paramString = new StringBuilder();
      Object[] arrayOfObject1 = Ren.keySet().toArray();
      Object[] arrayOfObject2 = Ren.values().toArray();
      paramInt = 0;
      while (paramInt < arrayOfObject1.length)
      {
        paramString.append(arrayOfObject1[paramInt]).append(":").append(arrayOfObject2[paramInt]).append(";");
        paramInt += 1;
      }
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuY, paramString.toString());
      AppMethodBeat.o(31279);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.m
 * JD-Core Version:    0.7.0.1
 */
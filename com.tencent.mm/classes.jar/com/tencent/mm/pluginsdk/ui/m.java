package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.u;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Collection;
import java.util.Set;

public final class m
{
  private static LruCache<String, Integer> Yas;
  private StringBuilder Yak;
  private SpannableStringBuilder Yal;
  private SpannableString Yam;
  private SpannableStringBuilder Yan;
  private CharacterStyle Yao;
  private int Yap;
  private int Yaq;
  public int Yar;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(31280);
    Yas = new LruCache(50);
    AppMethodBeat.o(31280);
  }
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(31274);
    this.Yal = new SpannableStringBuilder();
    this.Yan = new SpannableStringBuilder();
    this.Yao = new ForegroundColorSpan(-5066062);
    this.Yar = 3;
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
    if (this.Yak == null)
    {
      paramMMEditText = new IllegalStateException("You should saveHistory before setText");
      AppMethodBeat.o(31275);
      throw paramMMEditText;
    }
    int k = this.Yap + paramString.length();
    this.Yal.clear();
    this.Yan.clear();
    SpannableStringBuilder localSpannableStringBuilder2;
    if (paramBoolean)
    {
      this.Yam = u.iVt().a(this.mContext, this.Yak.subSequence(0, this.Yap), paramMMEditText.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder1 = this.Yal.append(this.Yam);
      localSpannableStringBuilder2 = this.Yan;
      if ((localSpannableStringBuilder2 == null) || (paramString == null) || (paramString.length() == 0)) {
        localSpannableStringBuilder1.append(localSpannableStringBuilder2).append(this.Yak.subSequence(this.Yaq, this.Yak.length()));
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", new Object[] { Integer.valueOf(this.Yap), Integer.valueOf(this.Yaq), Integer.valueOf(k), Integer.valueOf(this.Yal.length()), paramString, this.Yal });
      paramMMEditText.setText(this.Yal);
      if (k > this.Yal.length()) {
        break label372;
      }
      if (k != 0) {
        break label366;
      }
      paramMMEditText.setSelection(this.Yal.length());
      AppMethodBeat.o(31275);
      return;
      int j;
      if (paramString.length() < this.Yar) {
        j = paramString.length();
      }
      for (int i = 0;; i = j - this.Yar)
      {
        localSpannableStringBuilder2.append(paramString).setSpan(this.Yao, i, j, 33);
        break;
        j = paramString.length();
      }
      this.Yam = u.iVt().a(this.mContext, paramString, paramMMEditText.getTextSize());
      this.Yal.append(this.Yam);
    }
    label366:
    paramMMEditText.setSelection(k);
    label372:
    AppMethodBeat.o(31275);
  }
  
  public final int bqL(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(31278);
        if (Yas.size() == 0)
        {
          Object localObject = (String)h.baE().ban().get(at.a.acWH, "");
          try
          {
            localObject = ((String)localObject).split(";");
            int j = localObject.length;
            i = 0;
            if (i < j)
            {
              String[] arrayOfString = localObject[i].split(":");
              if (arrayOfString.length == 2) {
                Yas.put(arrayOfString[0], Integer.valueOf(Util.getInt(arrayOfString[1], 0)));
              }
              i += 1;
              continue;
            }
            if (!Yas.check(paramString)) {
              continue;
            }
          }
          catch (Error localError) {}
        }
        else
        {
          i = ((Integer)Yas.get(paramString)).intValue();
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
    this.Yar = 0;
    this.Yam = u.iVt().a(this.mContext, paramMMEditText.getText().toString(), paramMMEditText.getTextSize());
    Log.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", new Object[] { this.Yam });
    paramMMEditText.setText(this.Yam);
    paramMMEditText.setSelection(this.Yam.length());
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
    this.Yap = paramMMEditText.getSelectionStart();
    this.Yaq = paramMMEditText.getSelectionEnd();
    this.Yak = new StringBuilder(paramMMEditText.getText());
    Log.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", new Object[] { Integer.valueOf(this.Yap), Integer.valueOf(this.Yaq), this.Yak });
    if (paramMMEditText.getText().toString().equalsIgnoreCase("")) {
      this.Yal.clear();
    }
    if (this.Yap < 0) {
      this.Yap = 0;
    }
    if (this.Yaq < 0) {
      this.Yaq = 0;
    }
    AppMethodBeat.o(31277);
  }
  
  public final void iy(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(31279);
      Yas.put(paramString, Integer.valueOf(paramInt));
      paramString = new StringBuilder();
      Object[] arrayOfObject1 = Yas.keySet().toArray();
      Object[] arrayOfObject2 = Yas.values().toArray();
      paramInt = 0;
      while (paramInt < arrayOfObject1.length)
      {
        paramString.append(arrayOfObject1[paramInt]).append(":").append(arrayOfObject2[paramInt]).append(";");
        paramInt += 1;
      }
      h.baE().ban().set(at.a.acWH, paramString.toString());
      AppMethodBeat.o(31279);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.m
 * JD-Core Version:    0.7.0.1
 */
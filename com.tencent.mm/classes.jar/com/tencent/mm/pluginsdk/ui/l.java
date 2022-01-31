package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

public final class l
{
  private static ae<String, Integer> vSu;
  private Context mContext;
  private StringBuilder vSm;
  private SpannableStringBuilder vSn;
  private SpannableString vSo;
  private SpannableStringBuilder vSp;
  private CharacterStyle vSq;
  private int vSr;
  private int vSs;
  public int vSt;
  
  static
  {
    AppMethodBeat.i(27578);
    vSu = new ae(50);
    AppMethodBeat.o(27578);
  }
  
  public l(Context paramContext)
  {
    AppMethodBeat.i(27572);
    this.vSn = new SpannableStringBuilder();
    this.vSp = new SpannableStringBuilder();
    this.vSq = new ForegroundColorSpan(-5066062);
    this.vSt = 3;
    this.mContext = paramContext;
    AppMethodBeat.o(27572);
  }
  
  public final void a(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(27574);
    if (paramMMEditText == null)
    {
      AppMethodBeat.o(27574);
      return;
    }
    this.vSt = 0;
    this.vSo = com.tencent.mm.cd.g.dvk().b(paramMMEditText.getText().toString(), paramMMEditText.getTextSize());
    ab.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", new Object[] { this.vSo });
    paramMMEditText.setText(this.vSo);
    paramMMEditText.setSelection(this.vSo.length());
    AppMethodBeat.o(27574);
  }
  
  public final void a(MMEditText paramMMEditText, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(27573);
    if (paramMMEditText == null)
    {
      AppMethodBeat.o(27573);
      return;
    }
    if (this.vSm == null)
    {
      paramMMEditText = new IllegalStateException("You should saveHistory before setText");
      AppMethodBeat.o(27573);
      throw paramMMEditText;
    }
    int k = this.vSr + paramString.length();
    this.vSn.clear();
    this.vSp.clear();
    SpannableStringBuilder localSpannableStringBuilder2;
    if (paramBoolean)
    {
      this.vSo = com.tencent.mm.cd.g.dvk().b(this.vSm.subSequence(0, this.vSr), paramMMEditText.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder1 = this.vSn.append(this.vSo);
      localSpannableStringBuilder2 = this.vSp;
      if ((localSpannableStringBuilder2 == null) || (paramString == null) || (paramString.length() == 0)) {
        localSpannableStringBuilder1.append(localSpannableStringBuilder2).append(this.vSm.subSequence(this.vSs, this.vSm.length()));
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", new Object[] { Integer.valueOf(this.vSr), Integer.valueOf(this.vSs), Integer.valueOf(k), Integer.valueOf(this.vSn.length()), paramString, this.vSn });
      paramMMEditText.setText(this.vSn);
      if (k > this.vSn.length()) {
        break label364;
      }
      if (k != 0) {
        break label358;
      }
      paramMMEditText.setSelection(this.vSn.length());
      AppMethodBeat.o(27573);
      return;
      int j;
      if (paramString.length() < this.vSt) {
        j = paramString.length();
      }
      for (int i = 0;; i = j - this.vSt)
      {
        localSpannableStringBuilder2.append(paramString).setSpan(this.vSq, i, j, 33);
        break;
        j = paramString.length();
      }
      this.vSo = com.tencent.mm.cd.g.dvk().b(paramString, paramMMEditText.getTextSize());
      this.vSn.append(this.vSo);
    }
    label358:
    paramMMEditText.setSelection(k);
    label364:
    AppMethodBeat.o(27573);
  }
  
  public final int ame(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(27576);
        if (vSu.size() == 0)
        {
          Object localObject = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKc, "");
          try
          {
            localObject = ((String)localObject).split(";");
            int j = localObject.length;
            i = 0;
            if (i < j)
            {
              String[] arrayOfString = localObject[i].split(":");
              if (arrayOfString.length == 2) {
                vSu.put(arrayOfString[0], Integer.valueOf(j.getInt(arrayOfString[1], 0)));
              }
              i += 1;
              continue;
            }
            if (!vSu.Z(paramString)) {
              continue;
            }
          }
          catch (Error localError) {}
        }
        else
        {
          i = ((Integer)vSu.get(paramString)).intValue();
          AppMethodBeat.o(27576);
          return i;
        }
      }
      finally {}
      AppMethodBeat.o(27576);
      int i = 0;
    }
  }
  
  public final void b(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(27575);
    if (paramMMEditText == null)
    {
      AppMethodBeat.o(27575);
      return;
    }
    this.vSr = paramMMEditText.getSelectionStart();
    this.vSs = paramMMEditText.getSelectionEnd();
    this.vSm = new StringBuilder(paramMMEditText.getText());
    ab.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", new Object[] { Integer.valueOf(this.vSr), Integer.valueOf(this.vSs), this.vSm });
    if (paramMMEditText.getText().toString().equalsIgnoreCase("")) {
      this.vSn.clear();
    }
    AppMethodBeat.o(27575);
  }
  
  public final void ep(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(27577);
      vSu.put(paramString, Integer.valueOf(paramInt));
      paramString = new StringBuilder();
      Object[] arrayOfObject1 = vSu.map.keySet().toArray();
      Object[] arrayOfObject2 = vSu.map.values().toArray();
      paramInt = 0;
      while (paramInt < arrayOfObject1.length)
      {
        paramString.append(arrayOfObject1[paramInt]).append(":").append(arrayOfObject2[paramInt]).append(";");
        paramInt += 1;
      }
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKc, paramString.toString());
      AppMethodBeat.o(27577);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.l
 * JD-Core Version:    0.7.0.1
 */
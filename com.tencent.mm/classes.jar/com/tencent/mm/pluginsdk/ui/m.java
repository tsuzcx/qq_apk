package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.c.j;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

public final class m
{
  private static ab<String, Integer> sbn = new ab(50);
  private Context mContext;
  private StringBuilder sbf;
  private SpannableStringBuilder sbg = new SpannableStringBuilder();
  private SpannableString sbh;
  private SpannableStringBuilder sbi = new SpannableStringBuilder();
  private CharacterStyle sbj = new ForegroundColorSpan(-5066062);
  private int sbk;
  private int sbl;
  public int sbm = 3;
  
  public m(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final int Wy(String paramString)
  {
    for (;;)
    {
      try
      {
        if (sbn.size() == 0)
        {
          Object localObject = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzo, "");
          try
          {
            localObject = ((String)localObject).split(";");
            int j = localObject.length;
            i = 0;
            if (i < j)
            {
              String[] arrayOfString = localObject[i].split(":");
              if (arrayOfString.length == 2) {
                sbn.put(arrayOfString[0], Integer.valueOf(j.getInt(arrayOfString[1], 0)));
              }
              i += 1;
              continue;
            }
            if (!sbn.aC(paramString)) {
              continue;
            }
          }
          catch (Error localError) {}
        }
        else
        {
          i = ((Integer)sbn.get(paramString)).intValue();
          return i;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public final void a(MMEditText paramMMEditText)
  {
    if (paramMMEditText == null) {
      return;
    }
    this.sbm = 0;
    this.sbh = com.tencent.mm.cd.g.csM().a(paramMMEditText.getText().toString(), paramMMEditText.getTextSize());
    y.d("MicroMsg.VoiceInputHelper", "setFinalText emojiSpannableString = %s", new Object[] { this.sbh });
    paramMMEditText.setText(this.sbh);
    paramMMEditText.setSelection(this.sbh.length());
  }
  
  public final void a(MMEditText paramMMEditText, String paramString, boolean paramBoolean)
  {
    if (paramMMEditText == null) {
      return;
    }
    if (this.sbf == null) {
      throw new IllegalStateException("You should saveHistory before setText");
    }
    int k = this.sbk + paramString.length();
    this.sbg.clear();
    this.sbi.clear();
    SpannableStringBuilder localSpannableStringBuilder2;
    if (paramBoolean)
    {
      this.sbh = com.tencent.mm.cd.g.csM().a(this.sbf.subSequence(0, this.sbk), paramMMEditText.getTextSize());
      SpannableStringBuilder localSpannableStringBuilder1 = this.sbg.append(this.sbh);
      localSpannableStringBuilder2 = this.sbi;
      if ((localSpannableStringBuilder2 == null) || (paramString == null) || (paramString.length() == 0)) {
        localSpannableStringBuilder1.append(localSpannableStringBuilder2).append(this.sbf.subSequence(this.sbl, this.sbf.length()));
      }
    }
    for (;;)
    {
      y.d("MicroMsg.VoiceInputHelper", "setText historySelectStart = %s, historySelectEnd = %s, cursor = %s, length = %s, text = %s, spannableStringBuilder = %s", new Object[] { Integer.valueOf(this.sbk), Integer.valueOf(this.sbl), Integer.valueOf(k), Integer.valueOf(this.sbg.length()), paramString, this.sbg });
      paramMMEditText.setText(this.sbg);
      if (k > this.sbg.length()) {
        break;
      }
      if (k != 0) {
        break label332;
      }
      paramMMEditText.setSelection(this.sbg.length());
      return;
      int i;
      if (paramString.length() < this.sbm) {
        i = paramString.length();
      }
      for (int j = 0;; j = i - this.sbm)
      {
        localSpannableStringBuilder2.append(paramString).setSpan(this.sbj, j, i, 33);
        break;
        i = paramString.length();
      }
      this.sbh = com.tencent.mm.cd.g.csM().a(paramString, paramMMEditText.getTextSize());
      this.sbg.append(this.sbh);
    }
    label332:
    paramMMEditText.setSelection(k);
  }
  
  public final void b(MMEditText paramMMEditText)
  {
    if (paramMMEditText == null) {}
    do
    {
      return;
      this.sbk = paramMMEditText.getSelectionStart();
      this.sbl = paramMMEditText.getSelectionEnd();
      this.sbf = new StringBuilder(paramMMEditText.getText());
      y.d("MicroMsg.VoiceInputHelper", "saveHistory historySelectStart = %s, historySelectEnd = %s, historyStringBuilder = %s", new Object[] { Integer.valueOf(this.sbk), Integer.valueOf(this.sbl), this.sbf });
    } while (!paramMMEditText.getText().toString().equalsIgnoreCase(""));
    this.sbg.clear();
  }
  
  public final void dk(String paramString, int paramInt)
  {
    try
    {
      sbn.put(paramString, Integer.valueOf(paramInt));
      paramString = new StringBuilder();
      Object[] arrayOfObject1 = sbn.map.keySet().toArray();
      Object[] arrayOfObject2 = sbn.map.values().toArray();
      paramInt = 0;
      while (paramInt < arrayOfObject1.length)
      {
        paramString.append(arrayOfObject1[paramInt]).append(":").append(arrayOfObject2[paramInt]).append(";");
        paramInt += 1;
      }
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uzo, paramString.toString());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.m
 * JD-Core Version:    0.7.0.1
 */
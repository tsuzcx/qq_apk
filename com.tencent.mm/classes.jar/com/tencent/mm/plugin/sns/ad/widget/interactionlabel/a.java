package com.tencent.mm.plugin.sns.ad.widget.interactionlabel;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Map;

public class a
{
  public String Qgm;
  public ArrayList<String> Qgn;
  public String title;
  public int type;
  
  public a()
  {
    AppMethodBeat.i(310224);
    this.Qgn = new ArrayList();
    AppMethodBeat.o(310224);
  }
  
  public static a ac(Map<String, String> paramMap, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(310237);
    String str1 = (String)paramMap.get(paramString + ".title");
    if (TextUtils.isEmpty(str1))
    {
      AppMethodBeat.o(310237);
      return null;
    }
    a locala = new a();
    locala.title = str1;
    locala.type = Util.safeParseInt((String)paramMap.get(paramString + ".interactionType"));
    str1 = Util.nullAsNil((String)paramMap.get(paramString + ".themeColor"));
    String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".themeColorAlpha"));
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      str1 = String.format("#%02x%s", new Object[] { Integer.valueOf((int)(Util.safeParseDouble(str2) * 255.0D)), str1.substring(1) });
    }
    for (;;)
    {
      locala.Qgm = str1;
      str1 = paramString + ".rollingLabels.item";
      if (i != 0) {}
      for (paramString = str1 + i;; paramString = str1)
      {
        paramString = Util.nullAsNil((String)paramMap.get(paramString));
        if (!TextUtils.isEmpty(paramString))
        {
          locala.Qgn.add(paramString);
          i += 1;
          break;
        }
        AppMethodBeat.o(310237);
        return locala;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.interactionlabel.a
 * JD-Core Version:    0.7.0.1
 */
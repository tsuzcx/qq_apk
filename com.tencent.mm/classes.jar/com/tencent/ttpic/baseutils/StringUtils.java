package com.tencent.ttpic.baseutils;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringUtils
{
  public static String removeEmoji(String paramString)
  {
    AppMethodBeat.i(49793);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(49793);
      return "";
    }
    paramString = paramString.replaceAll("\\[em\\].*?\\[/em\\]", "");
    AppMethodBeat.o(49793);
    return paramString;
  }
  
  public static String removeNoisyChar(String paramString)
  {
    AppMethodBeat.i(49792);
    paramString = paramString.replaceAll("[/~!@#$%^&*\\(\\)_+\\{\\}:<>?\\[\\],./;'`\\-=\\|／～！＠＃＄％＾＆＊（）＿＋｛｝：＜＞？［］，。．／；＇`－＝｜、]+", "");
    AppMethodBeat.o(49792);
    return paramString;
  }
  
  public static String removeUTF8Emoji(String paramString)
  {
    AppMethodBeat.i(49794);
    Object localObject = new HashSet();
    int i = 0;
    while (i < paramString.length())
    {
      int j = Character.getType(paramString.charAt(i));
      if ((j == 19) || (j == 28)) {
        ((Set)localObject).add(Character.valueOf(paramString.charAt(i)));
      }
      i += 1;
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString = paramString.replace(String.valueOf((Character)((Iterator)localObject).next()), "");
    }
    AppMethodBeat.o(49794);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.StringUtils
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class ADXml$n
{
  public String rDm;
  public int type;
  
  public static n an(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(306623);
    int i = 0;
    for (;;)
    {
      if (i == 0) {}
      for (String str1 = paramString;; str1 = paramString + i)
      {
        String str2 = (String)paramMap.get(str1 + ".type");
        if (TextUtils.isEmpty(str2)) {
          break label149;
        }
        int j = Util.safeParseInt(str2);
        if (j != 136) {
          break;
        }
        paramString = new n();
        paramString.type = j;
        paramString.rDm = ((String)paramMap.get(str1 + ".webViewUrl"));
        AppMethodBeat.o(306623);
        return paramString;
      }
      i += 1;
    }
    label149:
    AppMethodBeat.o(306623);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.ADXml.n
 * JD-Core Version:    0.7.0.1
 */
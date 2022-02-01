package com.tencent.mm.plugin.sns.storage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public final class b$n
{
  public String kzz;
  public int type;
  
  public static n x(Map<String, String> paramMap, String paramString)
  {
    AppMethodBeat.i(219376);
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
        int j = bu.aSB(str2);
        if (j != 136) {
          break;
        }
        paramString = new n();
        paramString.type = j;
        paramString.kzz = ((String)paramMap.get(str1 + ".webViewUrl"));
        AppMethodBeat.o(219376);
        return paramString;
      }
      i += 1;
    }
    label149:
    AppMethodBeat.o(219376);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.b.n
 * JD-Core Version:    0.7.0.1
 */
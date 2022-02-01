package com.tencent.mm.sdk.platformtools;

import android.text.TextUtils;
import androidx.a.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class WeChatBrands$Wordings
{
  private static final char SYMBOL_LINEFEED = '\n';
  private static final char SYMBOL_SEPARATOR = ' ';
  private static final WeChatBrands.PlaceHolderHandler handler;
  private static boolean sEnableAutoSeparate;
  
  static
  {
    AppMethodBeat.i(243488);
    handler = new WeChatBrands.PlaceHolderHandler();
    sEnableAutoSeparate = false;
    handler.attachJoiner(new a()
    {
      public String apply(List paramAnonymousList)
      {
        AppMethodBeat.i(243401);
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        Object localObject1 = null;
        String str;
        if (i < paramAnonymousList.size())
        {
          Object localObject2 = paramAnonymousList.get(i);
          str = localObject2.toString();
          if (TextUtils.isEmpty(str)) {
            break label185;
          }
          if (((localObject2 instanceof WeChatBrands.PlaceHolderHandler.PlaceHolderSpan)) && (WeChatBrands.Wordings.sEnableAutoSeparate) && (!((WeChatBrands.PlaceHolderHandler.PlaceHolderSpan)localObject2).mIsDomainReplace))
          {
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (WeChatBrands.Wordings.access$200((String)localObject1, str))) {
              localStringBuilder.append(' ');
            }
            localStringBuilder.append(str);
            if ((i < paramAnonymousList.size() - 1) && (WeChatBrands.Wordings.access$200(str, paramAnonymousList.get(i + 1).toString()))) {
              localStringBuilder.append(' ');
            }
            localObject1 = null;
          }
        }
        label185:
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append(str);
          localObject1 = str;
          continue;
          paramAnonymousList = localStringBuilder.toString();
          AppMethodBeat.o(243401);
          return paramAnonymousList;
        }
      }
    });
    AppMethodBeat.o(243488);
  }
  
  private static boolean isAlphabet(char paramChar)
  {
    return ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }
  
  private static boolean isChineseMarks(char paramChar)
  {
    return (paramChar == 65292) || (paramChar == '。') || (paramChar == 65281) || (paramChar == 65311) || (paramChar == 65306) || (paramChar == 65307) || (paramChar == '、') || (paramChar == '「') || (paramChar == '」');
  }
  
  private static boolean isEnMarks(char paramChar)
  {
    return (paramChar == '.') || (paramChar == ',') || (paramChar == '?') || (paramChar == '!') || (paramChar == ';') || (paramChar == ':');
  }
  
  private static boolean isLeftLinefeed(String paramString)
  {
    AppMethodBeat.i(243442);
    if ((paramString.charAt(paramString.length() - 1) == 'n') && (paramString.length() > 1) && (paramString.charAt(paramString.length() - 2) == '\\'))
    {
      AppMethodBeat.o(243442);
      return true;
    }
    AppMethodBeat.o(243442);
    return false;
  }
  
  private static boolean isLeftXmlFormat(String paramString)
  {
    AppMethodBeat.i(243450);
    if ((paramString.charAt(paramString.length() - 1) == 's') && (paramString.length() > 1) && (paramString.charAt(paramString.length() - 2) == '%'))
    {
      AppMethodBeat.o(243450);
      return true;
    }
    AppMethodBeat.o(243450);
    return false;
  }
  
  private static boolean notSeparateChar(char paramChar)
  {
    return (paramChar == '-') || (paramChar == '/') || (paramChar == '\\');
  }
  
  private static boolean shouldSeparate(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243435);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(243435);
      return false;
    }
    char c1 = paramString1.charAt(paramString1.length() - 1);
    char c2 = paramString2.charAt(0);
    if ((c1 == ' ') || (c2 == ' ') || (c1 == '\n') || (c2 == '\n'))
    {
      AppMethodBeat.o(243435);
      return false;
    }
    if ((isChineseMarks(c1)) || (isChineseMarks(c2)))
    {
      AppMethodBeat.o(243435);
      return false;
    }
    if ((notSeparateChar(c1)) || (notSeparateChar(c2)))
    {
      AppMethodBeat.o(243435);
      return false;
    }
    if (isEnMarks(c2))
    {
      AppMethodBeat.o(243435);
      return false;
    }
    if (isEnMarks(c1))
    {
      AppMethodBeat.o(243435);
      return true;
    }
    if ((isAlphabet(c1)) || (Character.isDigit(c1)))
    {
      if (isLeftLinefeed(paramString1))
      {
        AppMethodBeat.o(243435);
        return false;
      }
      if ((isLeftXmlFormat(paramString1)) && (!isAlphabet(c2)))
      {
        AppMethodBeat.o(243435);
        return false;
      }
      AppMethodBeat.o(243435);
      return true;
    }
    if ((isAlphabet(c2)) || (Character.isDigit(c2)))
    {
      AppMethodBeat.o(243435);
      return true;
    }
    AppMethodBeat.o(243435);
    return false;
  }
  
  public static String translate(String paramString)
  {
    AppMethodBeat.i(243430);
    paramString = handler.replace(paramString);
    AppMethodBeat.o(243430);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatBrands.Wordings
 * JD-Core Version:    0.7.0.1
 */
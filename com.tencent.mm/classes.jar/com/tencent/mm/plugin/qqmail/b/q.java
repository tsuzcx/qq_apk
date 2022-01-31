package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q
{
  String czp;
  String pIO;
  private String[] pJq;
  private String[] pJr;
  private String[] pJs;
  String pJt;
  q.a[] pJu;
  q.a[] pJv;
  
  public q(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2)
  {
    AppMethodBeat.i(67973);
    this.czp = null;
    this.pJq = null;
    this.pJr = null;
    this.pJs = null;
    this.pIO = null;
    this.pJt = null;
    this.pJu = null;
    this.pJv = null;
    if (!bo.isNullOrNil(paramString1)) {
      this.czp = paramString1;
    }
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
    {
      this.pJq = paramArrayOfString1;
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0)) {
        break label134;
      }
      this.pJr = paramArrayOfString2;
      label89:
      if ((paramArrayOfString3 == null) || (paramArrayOfString3.length <= 0)) {
        break label142;
      }
    }
    label134:
    label142:
    for (this.pJs = paramArrayOfString3;; this.pJs = null)
    {
      if (bo.isNullOrNil(paramString2)) {
        break label150;
      }
      this.pIO = paramString2;
      AppMethodBeat.o(67973);
      return;
      this.pJq = null;
      break;
      this.pJr = null;
      break label89;
    }
    label150:
    this.pIO = null;
    AppMethodBeat.o(67973);
  }
  
  public static String Xu(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(67977);
    int k = "abEdf4&^^*sxcSD$%&1sdfz@!~AZcT4s322dA%^&&*$##C$%__SDy4d_(*%".length();
    paramString = paramString + "d$3^&xRw%&*_(";
    try
    {
      paramString = g.w(paramString.getBytes());
      arrayOfChar = new char[paramString.length() * 2];
      int i = 0;
      int j = 0;
      while (i < paramString.length())
      {
        int m = j + 1;
        arrayOfChar[j] = paramString.charAt(i);
        int n = paramString.charAt(i);
        j = m + 1;
        int i1 = paramString.charAt(i);
        arrayOfChar[m] = ((char)("abEdf4&^^*sxcSD$%&1sdfz@!~AZcT4s322dA%^&&*$##C$%__SDy4d_(*%".charAt(n % k) + i1));
        i += 1;
      }
    }
    catch (Exception paramString)
    {
      char[] arrayOfChar;
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MailContentFormatter", paramString, "", new Object[0]);
        ab.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + paramString.getLocalizedMessage());
        paramString = null;
      }
      paramString = new String(arrayOfChar);
    }
    try
    {
      paramString = g.w(paramString.getBytes("ISO-8859-1"));
      AppMethodBeat.o(67977);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MailContentFormatter", paramString, "", new Object[0]);
        ab.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + paramString.getLocalizedMessage());
        paramString = localObject;
      }
    }
  }
  
  final String cdF()
  {
    AppMethodBeat.i(67974);
    if (this.pJq != null)
    {
      Object localObject1 = new StringBuilder("");
      ((StringBuilder)localObject1).append("To: ");
      Object localObject2 = this.pJq;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        ((StringBuilder)localObject1).append("\"");
        ((StringBuilder)localObject1).append("=?utf-8?B?");
        ((StringBuilder)localObject1).append(Base64.encodeToString(str.getBytes(), 2));
        ((StringBuilder)localObject1).append("?=");
        ((StringBuilder)localObject1).append("\"");
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append("<");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(">");
        ((StringBuilder)localObject1).append(" ,");
        i += 1;
      }
      localObject2 = ((StringBuilder)localObject1).toString();
      i = ((String)localObject2).lastIndexOf(" ,");
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = ((String)localObject2).substring(0, i);
      }
      AppMethodBeat.o(67974);
      return localObject1;
    }
    AppMethodBeat.o(67974);
    return null;
  }
  
  final String cdG()
  {
    AppMethodBeat.i(67975);
    if (this.pJr != null)
    {
      Object localObject1 = new StringBuilder("");
      ((StringBuilder)localObject1).append("Cc: ");
      Object localObject2 = this.pJr;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        ((StringBuilder)localObject1).append("\"");
        ((StringBuilder)localObject1).append("=?utf-8?B?");
        ((StringBuilder)localObject1).append(Base64.encodeToString(str.getBytes(), 2));
        ((StringBuilder)localObject1).append("?=");
        ((StringBuilder)localObject1).append("\"");
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append("<");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(">");
        ((StringBuilder)localObject1).append(" ,");
        i += 1;
      }
      localObject2 = ((StringBuilder)localObject1).toString();
      i = ((String)localObject2).lastIndexOf(" ,");
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = ((String)localObject2).substring(0, i);
      }
      AppMethodBeat.o(67975);
      return localObject1;
    }
    AppMethodBeat.o(67975);
    return null;
  }
  
  final String cdH()
  {
    AppMethodBeat.i(67976);
    if (this.pJs != null)
    {
      Object localObject1 = new StringBuilder("");
      ((StringBuilder)localObject1).append("Bcc: ");
      Object localObject2 = this.pJr;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        ((StringBuilder)localObject1).append("\"");
        ((StringBuilder)localObject1).append("=?utf-8?B?");
        ((StringBuilder)localObject1).append(Base64.encodeToString(str.getBytes(), 2));
        ((StringBuilder)localObject1).append("?=");
        ((StringBuilder)localObject1).append("\"");
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append("<");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(">");
        ((StringBuilder)localObject1).append(" ,");
        i += 1;
      }
      localObject2 = ((StringBuilder)localObject1).toString();
      i = ((String)localObject2).lastIndexOf(" ,");
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = ((String)localObject2).substring(0, i);
      }
      AppMethodBeat.o(67976);
      return localObject1;
    }
    AppMethodBeat.o(67976);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.q
 * JD-Core Version:    0.7.0.1
 */
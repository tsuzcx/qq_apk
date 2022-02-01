package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class r
{
  String dpv;
  private String[] uLJ;
  private String[] uLK;
  private String[] uLL;
  String uLM;
  a[] uLN;
  a[] uLO;
  String uLh;
  
  public r(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2)
  {
    AppMethodBeat.i(122707);
    this.dpv = null;
    this.uLJ = null;
    this.uLK = null;
    this.uLL = null;
    this.uLh = null;
    this.uLM = null;
    this.uLN = null;
    this.uLO = null;
    if (!bt.isNullOrNil(paramString1)) {
      this.dpv = paramString1;
    }
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
    {
      this.uLJ = paramArrayOfString1;
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0)) {
        break label134;
      }
      this.uLK = paramArrayOfString2;
      label89:
      if ((paramArrayOfString3 == null) || (paramArrayOfString3.length <= 0)) {
        break label142;
      }
    }
    label134:
    label142:
    for (this.uLL = paramArrayOfString3;; this.uLL = null)
    {
      if (bt.isNullOrNil(paramString2)) {
        break label150;
      }
      this.uLh = paramString2;
      AppMethodBeat.o(122707);
      return;
      this.uLJ = null;
      break;
      this.uLK = null;
      break label89;
    }
    label150:
    this.uLh = null;
    AppMethodBeat.o(122707);
  }
  
  public static String akX(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(122711);
    int k = "abEdf4&^^*sxcSD$%&1sdfz@!~AZcT4s322dA%^&&*$##C$%__SDy4d_(*%".length();
    paramString = paramString + "d$3^&xRw%&*_(";
    try
    {
      paramString = g.getMessageDigest(paramString.getBytes());
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
        ad.printErrStackTrace("MicroMsg.MailContentFormatter", paramString, "", new Object[0]);
        ad.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + paramString.getLocalizedMessage());
        paramString = null;
      }
      paramString = new String(arrayOfChar);
    }
    try
    {
      paramString = g.getMessageDigest(paramString.getBytes("ISO-8859-1"));
      AppMethodBeat.o(122711);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.MailContentFormatter", paramString, "", new Object[0]);
        ad.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + paramString.getLocalizedMessage());
        paramString = localObject;
      }
    }
  }
  
  final String ddX()
  {
    AppMethodBeat.i(122708);
    if (this.uLJ != null)
    {
      Object localObject1 = new StringBuilder("");
      ((StringBuilder)localObject1).append("To: ");
      Object localObject2 = this.uLJ;
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
      AppMethodBeat.o(122708);
      return localObject1;
    }
    AppMethodBeat.o(122708);
    return null;
  }
  
  final String ddY()
  {
    AppMethodBeat.i(122709);
    if (this.uLK != null)
    {
      Object localObject1 = new StringBuilder("");
      ((StringBuilder)localObject1).append("Cc: ");
      Object localObject2 = this.uLK;
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
      AppMethodBeat.o(122709);
      return localObject1;
    }
    AppMethodBeat.o(122709);
    return null;
  }
  
  final String ddZ()
  {
    AppMethodBeat.i(122710);
    if (this.uLL != null)
    {
      Object localObject1 = new StringBuilder("");
      ((StringBuilder)localObject1).append("Bcc: ");
      Object localObject2 = this.uLK;
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
      AppMethodBeat.o(122710);
      return localObject1;
    }
    AppMethodBeat.o(122710);
    return null;
  }
  
  public static final class a
  {
    String fileName;
    int fileSize;
    String name;
    String uLP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.r
 * JD-Core Version:    0.7.0.1
 */
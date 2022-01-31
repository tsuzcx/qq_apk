package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class q
{
  String bRO = null;
  String ndx = null;
  private String[] nea = null;
  private String[] neb = null;
  private String[] nec = null;
  String ned = null;
  a[] nee = null;
  a[] nef = null;
  
  public q(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2)
  {
    if (!bk.bl(paramString1)) {
      this.bRO = paramString1;
    }
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
    {
      this.nea = paramArrayOfString1;
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0)) {
        break label124;
      }
      this.neb = paramArrayOfString2;
      label84:
      if ((paramArrayOfString3 == null) || (paramArrayOfString3.length <= 0)) {
        break label132;
      }
    }
    label132:
    for (this.nec = paramArrayOfString3;; this.nec = null)
    {
      if (bk.bl(paramString2)) {
        break label140;
      }
      this.ndx = paramString2;
      return;
      this.nea = null;
      break;
      label124:
      this.neb = null;
      break label84;
    }
    label140:
    this.ndx = null;
  }
  
  public static String Lk(String paramString)
  {
    int k = "abEdf4&^^*sxcSD$%&1sdfz@!~AZcT4s322dA%^&&*$##C$%__SDy4d_(*%".length();
    paramString = paramString + "d$3^&xRw%&*_(";
    try
    {
      paramString = g.o(paramString.getBytes());
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
        y.printErrStackTrace("MicroMsg.MailContentFormatter", paramString, "", new Object[0]);
        y.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + paramString.getLocalizedMessage());
        paramString = null;
      }
      paramString = new String(arrayOfChar);
      try
      {
        paramString = g.o(paramString.getBytes("ISO-8859-1"));
        return paramString;
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.MailContentFormatter", paramString, "", new Object[0]);
        y.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + paramString.getLocalizedMessage());
      }
    }
    return null;
  }
  
  final String btv()
  {
    if (this.nea != null)
    {
      Object localObject1 = new StringBuilder("");
      ((StringBuilder)localObject1).append("To: ");
      Object localObject2 = this.nea;
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
      return localObject1;
    }
    return null;
  }
  
  final String btw()
  {
    if (this.neb != null)
    {
      Object localObject1 = new StringBuilder("");
      ((StringBuilder)localObject1).append("Cc: ");
      Object localObject2 = this.neb;
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
      return localObject1;
    }
    return null;
  }
  
  final String btx()
  {
    if (this.nec != null)
    {
      Object localObject1 = new StringBuilder("");
      ((StringBuilder)localObject1).append("Bcc: ");
      Object localObject2 = this.neb;
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
      return localObject1;
    }
    return null;
  }
  
  public static final class a
  {
    String fileName;
    int fileSize;
    String name;
    String neg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.q
 * JD-Core Version:    0.7.0.1
 */
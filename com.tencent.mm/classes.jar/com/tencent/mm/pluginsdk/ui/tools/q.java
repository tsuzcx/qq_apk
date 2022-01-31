package com.tencent.mm.pluginsdk.ui.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class q
{
  static Pattern sAddressPattern = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_-][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
  String mAuthInfo;
  String mHost;
  String mPath;
  int mPort;
  String mScheme;
  
  public q(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.mScheme = "";
    this.mHost = "";
    this.mPort = -1;
    this.mPath = "/";
    this.mAuthInfo = "";
    paramString = sAddressPattern.matcher(paramString);
    String str;
    if (paramString.matches())
    {
      str = paramString.group(1);
      if (str != null) {
        this.mScheme = str.toLowerCase();
      }
      str = paramString.group(2);
      if (str != null) {
        this.mAuthInfo = str;
      }
      str = paramString.group(3);
      if (str != null) {
        this.mHost = str;
      }
      str = paramString.group(4);
      if ((str == null) || (str.length() <= 0)) {}
    }
    for (;;)
    {
      try
      {
        this.mPort = Integer.parseInt(str);
        paramString = paramString.group(5);
        if ((paramString != null) && (paramString.length() > 0))
        {
          if (paramString.charAt(0) == '/') {
            this.mPath = paramString;
          }
        }
        else
        {
          if ((this.mPort != 443) || (!this.mScheme.equals(""))) {
            break label256;
          }
          this.mScheme = "https";
          if (this.mScheme.equals("")) {
            this.mScheme = "http";
          }
          return;
        }
      }
      catch (NumberFormatException paramString)
      {
        throw new Exception("Bad port");
      }
      this.mPath = ("/" + paramString);
      continue;
      throw new Exception("Bad address");
      label256:
      if (this.mPort == -1) {
        if (this.mScheme.equals("https")) {
          this.mPort = 443;
        } else {
          this.mPort = 80;
        }
      }
    }
  }
  
  public final String toString()
  {
    String str2 = "";
    String str1;
    if ((this.mPort == 443) || (!this.mScheme.equals("https")))
    {
      str1 = str2;
      if (this.mPort != 80)
      {
        str1 = str2;
        if (!this.mScheme.equals("http")) {}
      }
    }
    else
    {
      str1 = ":" + Integer.toString(this.mPort);
    }
    str2 = "";
    if (this.mAuthInfo.length() > 0) {
      str2 = this.mAuthInfo + "@";
    }
    return this.mScheme + "://" + str2 + this.mHost + str1 + this.mPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.q
 * JD-Core Version:    0.7.0.1
 */
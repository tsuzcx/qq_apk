package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class CharsetMatch
  implements Comparable<CharsetMatch>
{
  private String fCharsetName;
  private int fConfidence;
  private InputStream fInputStream = null;
  private String fLang;
  private byte[] fRawInput = null;
  private int fRawLength;
  
  CharsetMatch(CharsetDetector paramCharsetDetector, CharsetRecognizer paramCharsetRecognizer, int paramInt)
  {
    this.fConfidence = paramInt;
    if (paramCharsetDetector.fInputStream == null)
    {
      this.fRawInput = paramCharsetDetector.fRawInput;
      this.fRawLength = paramCharsetDetector.fRawLength;
    }
    this.fInputStream = paramCharsetDetector.fInputStream;
    this.fCharsetName = paramCharsetRecognizer.getName();
    this.fLang = paramCharsetRecognizer.getLanguage();
  }
  
  CharsetMatch(CharsetDetector paramCharsetDetector, CharsetRecognizer paramCharsetRecognizer, int paramInt, String paramString1, String paramString2)
  {
    this.fConfidence = paramInt;
    if (paramCharsetDetector.fInputStream == null)
    {
      this.fRawInput = paramCharsetDetector.fRawInput;
      this.fRawLength = paramCharsetDetector.fRawLength;
    }
    this.fInputStream = paramCharsetDetector.fInputStream;
    this.fCharsetName = paramString1;
    this.fLang = paramString2;
  }
  
  public int compareTo(CharsetMatch paramCharsetMatch)
  {
    int i = 0;
    if (this.fConfidence > paramCharsetMatch.fConfidence) {
      i = 1;
    }
    while (this.fConfidence >= paramCharsetMatch.fConfidence) {
      return i;
    }
    return -1;
  }
  
  public int getConfidence()
  {
    return this.fConfidence;
  }
  
  public String getLanguage()
  {
    return this.fLang;
  }
  
  public String getName()
  {
    return this.fCharsetName;
  }
  
  public Reader getReader()
  {
    Object localObject = this.fInputStream;
    if (localObject == null) {
      localObject = new ByteArrayInputStream(this.fRawInput, 0, this.fRawLength);
    }
    for (;;)
    {
      try
      {
        ((InputStream)localObject).reset();
        localObject = new InputStreamReader((InputStream)localObject, getName());
        return localObject;
      }
      catch (IOException localIOException)
      {
        return null;
      }
    }
  }
  
  public String getString()
  {
    return getString(-1);
  }
  
  public String getString(int paramInt)
  {
    Object localObject1;
    if (this.fInputStream != null)
    {
      localObject1 = new StringBuilder();
      localObject2 = new char[1024];
      Reader localReader = getReader();
      int i = paramInt;
      if (paramInt < 0) {
        i = 2147483647;
      }
      for (;;)
      {
        paramInt = localReader.read((char[])localObject2, 0, Math.min(i, 1024));
        if (paramInt < 0) {
          break;
        }
        ((StringBuilder)localObject1).append((char[])localObject2, 0, paramInt);
        i -= paramInt;
      }
      localReader.close();
      return ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = getName();
    if (((String)localObject2).indexOf("_rtl") < 0) {}
    for (paramInt = ((String)localObject2).indexOf("_ltr");; paramInt = ((String)localObject2).indexOf("_rtl"))
    {
      localObject1 = localObject2;
      if (paramInt > 0) {
        localObject1 = ((String)localObject2).substring(0, paramInt);
      }
      return new String(this.fRawInput, (String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetMatch
 * JD-Core Version:    0.7.0.1
 */
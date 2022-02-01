package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private InputStream fInputStream;
  private String fLang;
  private byte[] fRawInput;
  private int fRawLength;
  
  CharsetMatch(CharsetDetector paramCharsetDetector, CharsetRecognizer paramCharsetRecognizer, int paramInt)
  {
    AppMethodBeat.i(76635);
    this.fRawInput = null;
    this.fInputStream = null;
    this.fConfidence = paramInt;
    if (paramCharsetDetector.fInputStream == null)
    {
      this.fRawInput = paramCharsetDetector.fRawInput;
      this.fRawLength = paramCharsetDetector.fRawLength;
    }
    this.fInputStream = paramCharsetDetector.fInputStream;
    this.fCharsetName = paramCharsetRecognizer.getName();
    this.fLang = paramCharsetRecognizer.getLanguage();
    AppMethodBeat.o(76635);
  }
  
  CharsetMatch(CharsetDetector paramCharsetDetector, CharsetRecognizer paramCharsetRecognizer, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(76636);
    this.fRawInput = null;
    this.fInputStream = null;
    this.fConfidence = paramInt;
    if (paramCharsetDetector.fInputStream == null)
    {
      this.fRawInput = paramCharsetDetector.fRawInput;
      this.fRawLength = paramCharsetDetector.fRawLength;
    }
    this.fInputStream = paramCharsetDetector.fInputStream;
    this.fCharsetName = paramString1;
    this.fLang = paramString2;
    AppMethodBeat.o(76636);
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
    AppMethodBeat.i(76632);
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
        AppMethodBeat.o(76632);
        return localObject;
      }
      catch (IOException localIOException)
      {
        AppMethodBeat.o(76632);
        return null;
      }
    }
  }
  
  public String getString()
  {
    AppMethodBeat.i(76633);
    String str = getString(-1);
    AppMethodBeat.o(76633);
    return str;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(76634);
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
      localObject1 = ((StringBuilder)localObject1).toString();
      AppMethodBeat.o(76634);
      return localObject1;
    }
    Object localObject2 = getName();
    if (((String)localObject2).indexOf("_rtl") < 0) {}
    for (paramInt = ((String)localObject2).indexOf("_ltr");; paramInt = ((String)localObject2).indexOf("_rtl"))
    {
      localObject1 = localObject2;
      if (paramInt > 0) {
        localObject1 = ((String)localObject2).substring(0, paramInt);
      }
      localObject1 = new String(this.fRawInput, (String)localObject1);
      AppMethodBeat.o(76634);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetMatch
 * JD-Core Version:    0.7.0.1
 */
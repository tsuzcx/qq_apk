package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CharsetDetector
{
  private static final List<CharsetDetector.CSRecognizerInfo> ALL_CS_RECOGNIZERS;
  private static final int kBufSize = 8000;
  short[] fByteStats;
  boolean fC1Bytes;
  String fDeclaredEncoding;
  private boolean[] fEnabledRecognizers;
  byte[] fInputBytes;
  int fInputLen;
  InputStream fInputStream;
  byte[] fRawInput;
  int fRawLength;
  private boolean fStripTags;
  
  static
  {
    AppMethodBeat.i(104757);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_UTF8(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_16_BE(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_16_LE(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_32_BE(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_Unicode.CharsetRecog_UTF_32_LE(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_sjis(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022JP(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022CN(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_2022.CharsetRecog_2022KR(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_gb_18030(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_jp(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_euc.CharsetRecog_euc_kr(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_mbcs.CharsetRecog_big5(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_1(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_2(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_5_ru(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_6_ar(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_7_el(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_8_I_he(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_8_he(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_windows_1251(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_windows_1256(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_KOI8_R(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_8859_9_tr(), true));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM424_he_rtl(), false));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM424_he_ltr(), false));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM420_ar_rtl(), false));
    localArrayList.add(new CharsetDetector.CSRecognizerInfo(new CharsetRecog_sbcs.CharsetRecog_IBM420_ar_ltr(), false));
    ALL_CS_RECOGNIZERS = Collections.unmodifiableList(localArrayList);
    AppMethodBeat.o(104757);
  }
  
  public CharsetDetector()
  {
    AppMethodBeat.i(104747);
    this.fInputBytes = new byte[8000];
    this.fByteStats = new short[256];
    this.fC1Bytes = false;
    this.fStripTags = false;
    AppMethodBeat.o(104747);
  }
  
  private void MungeInput()
  {
    AppMethodBeat.i(104754);
    int j;
    int k;
    if (this.fStripTags)
    {
      int i3 = 0;
      j = 0;
      k = 0;
      int m = 0;
      int i5;
      for (int i2 = 0; (i3 < this.fRawLength) && (i2 < this.fInputBytes.length); i2 = i5)
      {
        int i = this.fRawInput[i3];
        int i1 = j;
        int i4 = k;
        int n = m;
        if (i == 60)
        {
          i1 = j;
          if (m != 0) {
            i1 = j + 1;
          }
          i4 = k + 1;
          n = 1;
        }
        i5 = i2;
        if (n == 0)
        {
          this.fInputBytes[i2] = i;
          i5 = i2 + 1;
        }
        m = n;
        if (i == 62) {
          m = 0;
        }
        i3 += 1;
        j = i1;
        k = i4;
      }
      this.fInputLen = i2;
    }
    for (;;)
    {
      if ((k < 5) || (k / 5 < j) || ((this.fInputLen < 100) && (this.fRawLength > 600)))
      {
        k = this.fRawLength;
        j = k;
        if (k > 8000) {
          j = 8000;
        }
        k = 0;
        while (k < j)
        {
          this.fInputBytes[k] = this.fRawInput[k];
          k += 1;
        }
        this.fInputLen = k;
      }
      Arrays.fill(this.fByteStats, (short)0);
      j = 0;
      while (j < this.fInputLen)
      {
        k = this.fInputBytes[j] & 0xFF;
        short[] arrayOfShort = this.fByteStats;
        arrayOfShort[k] = ((short)(arrayOfShort[k] + 1));
        j += 1;
      }
      this.fC1Bytes = false;
      j = 128;
      while (j <= 159)
      {
        if (this.fByteStats[j] != 0)
        {
          this.fC1Bytes = true;
          AppMethodBeat.o(104754);
          return;
        }
        j += 1;
      }
      AppMethodBeat.o(104754);
      return;
      j = 0;
      k = 0;
    }
  }
  
  public static String[] getAllDetectableCharsets()
  {
    AppMethodBeat.i(104753);
    String[] arrayOfString = new String[ALL_CS_RECOGNIZERS.size()];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = ((CharsetDetector.CSRecognizerInfo)ALL_CS_RECOGNIZERS.get(i)).recognizer.getName();
      i += 1;
    }
    AppMethodBeat.o(104753);
    return arrayOfString;
  }
  
  public CharsetMatch detect()
  {
    AppMethodBeat.i(104749);
    Object localObject = detectAll();
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(104749);
      return null;
    }
    localObject = localObject[0];
    AppMethodBeat.o(104749);
    return localObject;
  }
  
  public CharsetMatch[] detectAll()
  {
    AppMethodBeat.i(104750);
    Object localObject1 = new ArrayList();
    MungeInput();
    int i = 0;
    if (i < ALL_CS_RECOGNIZERS.size())
    {
      Object localObject2 = (CharsetDetector.CSRecognizerInfo)ALL_CS_RECOGNIZERS.get(i);
      if (this.fEnabledRecognizers != null) {}
      boolean bool;
      for (int j = this.fEnabledRecognizers[i];; bool = ((CharsetDetector.CSRecognizerInfo)localObject2).isDefaultEnabled)
      {
        if (j != 0)
        {
          localObject2 = ((CharsetDetector.CSRecognizerInfo)localObject2).recognizer.match(this);
          if (localObject2 != null) {
            ((ArrayList)localObject1).add(localObject2);
          }
        }
        i += 1;
        break;
      }
    }
    Collections.sort((List)localObject1);
    Collections.reverse((List)localObject1);
    localObject1 = (CharsetMatch[])((ArrayList)localObject1).toArray(new CharsetMatch[((ArrayList)localObject1).size()]);
    AppMethodBeat.o(104750);
    return localObject1;
  }
  
  public boolean enableInputFilter(boolean paramBoolean)
  {
    boolean bool = this.fStripTags;
    this.fStripTags = paramBoolean;
    return bool;
  }
  
  @Deprecated
  public String[] getDetectableCharsets()
  {
    AppMethodBeat.i(104755);
    Object localObject = new ArrayList(ALL_CS_RECOGNIZERS.size());
    int i = 0;
    if (i < ALL_CS_RECOGNIZERS.size())
    {
      CharsetDetector.CSRecognizerInfo localCSRecognizerInfo = (CharsetDetector.CSRecognizerInfo)ALL_CS_RECOGNIZERS.get(i);
      if (this.fEnabledRecognizers == null) {}
      int j;
      for (boolean bool = localCSRecognizerInfo.isDefaultEnabled;; j = this.fEnabledRecognizers[i])
      {
        if (bool) {
          ((List)localObject).add(localCSRecognizerInfo.recognizer.getName());
        }
        i += 1;
        break;
      }
    }
    localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
    AppMethodBeat.o(104755);
    return localObject;
  }
  
  public Reader getReader(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(104751);
    this.fDeclaredEncoding = paramString;
    try
    {
      setText(paramInputStream);
      paramInputStream = detect();
      if (paramInputStream == null)
      {
        AppMethodBeat.o(104751);
        return null;
      }
      paramInputStream = paramInputStream.getReader();
      AppMethodBeat.o(104751);
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      AppMethodBeat.o(104751);
    }
    return null;
  }
  
  public String getString(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(104752);
    this.fDeclaredEncoding = paramString;
    try
    {
      setText(paramArrayOfByte);
      paramArrayOfByte = detect();
      if (paramArrayOfByte == null)
      {
        AppMethodBeat.o(104752);
        return null;
      }
      paramArrayOfByte = paramArrayOfByte.getString(-1);
      AppMethodBeat.o(104752);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      AppMethodBeat.o(104752);
    }
    return null;
  }
  
  public boolean inputFilterEnabled()
  {
    return this.fStripTags;
  }
  
  public CharsetDetector setDeclaredEncoding(String paramString)
  {
    this.fDeclaredEncoding = paramString;
    return this;
  }
  
  @Deprecated
  public CharsetDetector setDetectableCharset(String paramString, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(104756);
    int i = 0;
    int j;
    if (i < ALL_CS_RECOGNIZERS.size())
    {
      CharsetDetector.CSRecognizerInfo localCSRecognizerInfo = (CharsetDetector.CSRecognizerInfo)ALL_CS_RECOGNIZERS.get(i);
      if (localCSRecognizerInfo.recognizer.getName().equals(paramString)) {
        if (localCSRecognizerInfo.isDefaultEnabled == paramBoolean) {
          j = 1;
        }
      }
    }
    for (;;)
    {
      if (i < 0)
      {
        paramString = new IllegalArgumentException("Invalid encoding: \"" + paramString + "\"");
        AppMethodBeat.o(104756);
        throw paramString;
        j = 0;
        continue;
        i += 1;
        break;
      }
      if ((this.fEnabledRecognizers == null) && (j == 0))
      {
        this.fEnabledRecognizers = new boolean[ALL_CS_RECOGNIZERS.size()];
        j = k;
        while (j < ALL_CS_RECOGNIZERS.size())
        {
          this.fEnabledRecognizers[j] = ((CharsetDetector.CSRecognizerInfo)ALL_CS_RECOGNIZERS.get(j)).isDefaultEnabled;
          j += 1;
        }
      }
      if (this.fEnabledRecognizers != null) {
        this.fEnabledRecognizers[i] = paramBoolean;
      }
      AppMethodBeat.o(104756);
      return this;
      j = 0;
      i = -1;
    }
  }
  
  public CharsetDetector setText(InputStream paramInputStream)
  {
    int i = 8000;
    AppMethodBeat.i(104748);
    this.fInputStream = paramInputStream;
    this.fInputStream.mark(8000);
    this.fRawInput = new byte[8000];
    this.fRawLength = 0;
    while (i > 0)
    {
      int j = this.fInputStream.read(this.fRawInput, this.fRawLength, i);
      if (j <= 0) {
        break;
      }
      this.fRawLength += j;
      i -= j;
    }
    this.fInputStream.reset();
    AppMethodBeat.o(104748);
    return this;
  }
  
  public CharsetDetector setText(byte[] paramArrayOfByte)
  {
    this.fRawInput = paramArrayOfByte;
    this.fRawLength = paramArrayOfByte.length;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetDetector
 * JD-Core Version:    0.7.0.1
 */
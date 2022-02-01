package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class JpegTools
{
  public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
  public static final int ORIENTATION_FLIP_VERTICAL = 4;
  public static final int ORIENTATION_NORMAL = 1;
  public static final int ORIENTATION_ROTATE_180 = 3;
  public static final int ORIENTATION_ROTATE_270 = 8;
  public static final int ORIENTATION_ROTATE_90 = 6;
  public static final int ORIENTATION_TRANSPOSE = 5;
  public static final int ORIENTATION_TRANSVERSE = 7;
  public static final int ORIENTATION_UNDEFINED = 0;
  public static final String TAG = "MicroMsg.JpegTools";
  private boolean bigOrder;
  private MBuf buf;
  private int ordivalue;
  
  public JpegTools(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(230321);
    this.buf = null;
    this.ordivalue = -1;
    this.bigOrder = true;
    this.buf = new MBuf();
    this.buf.setBuffer(paramArrayOfByte);
    AppMethodBeat.o(230321);
  }
  
  public static String byte2HexString(byte paramByte)
  {
    AppMethodBeat.i(230323);
    String str2 = Integer.toHexString(paramByte & 0xFF);
    String str1 = str2;
    if (str2.length() == 1) {
      str1 = "0".concat(String.valueOf(str2));
    }
    str1 = "" + str1.toUpperCase();
    AppMethodBeat.o(230323);
    return str1;
  }
  
  private String byteOrder()
  {
    AppMethodBeat.i(230317);
    int i = this.buf.getBuffer().get();
    int j = this.buf.getBuffer().get();
    if (((char)i == 'M') && ((char)j == 'M'))
    {
      AppMethodBeat.o(230317);
      return "MM";
    }
    if (((char)i == 'I') && ((char)j == 'I'))
    {
      AppMethodBeat.o(230317);
      return "II";
    }
    AppMethodBeat.o(230317);
    return "";
  }
  
  private boolean checkExifTag()
  {
    AppMethodBeat.i(230314);
    int i = this.buf.getBuffer().get();
    int j = this.buf.getBuffer().get();
    int k = this.buf.getBuffer().get();
    int m = this.buf.getBuffer().get();
    if (((char)i + (char)j + (char)k + (char)m).equals("Exif"))
    {
      AppMethodBeat.o(230314);
      return true;
    }
    AppMethodBeat.o(230314);
    return false;
  }
  
  private boolean checkIsJpeg()
  {
    AppMethodBeat.i(230313);
    byte b1 = this.buf.getBuffer().get();
    byte b2 = this.buf.getBuffer().get();
    if ((byte2HexString(b1).equals("FF")) && (byte2HexString(b2).equals("D8")))
    {
      AppMethodBeat.o(230313);
      return true;
    }
    AppMethodBeat.o(230313);
    return false;
  }
  
  private boolean checkTiffTag(boolean paramBoolean)
  {
    AppMethodBeat.i(230318);
    byte b1 = this.buf.getBuffer().get();
    byte b2 = this.buf.getBuffer().get();
    if ((paramBoolean) && (byte2HexString(b1).equals("00")) && (byte2HexString(b2).equals("2A")))
    {
      AppMethodBeat.o(230318);
      return true;
    }
    if ((byte2HexString(b1).equals("2A")) && (byte2HexString(b2).equals("00")))
    {
      AppMethodBeat.o(230318);
      return true;
    }
    Log.w("MicroMsg.JpegTools", "checkTiffTag: " + byte2HexString(b1) + " " + byte2HexString(b2));
    AppMethodBeat.o(230318);
    return false;
  }
  
  private void dropByte(int paramInt)
  {
    AppMethodBeat.i(230316);
    int i = this.buf.getBuffer().position();
    this.buf.getBuffer().position(i + paramInt);
    AppMethodBeat.o(230316);
  }
  
  private int findAppTag()
  {
    AppMethodBeat.i(230315);
    int i = 0;
    byte b1 = this.buf.getBuffer().get();
    byte b2 = this.buf.getBuffer().get();
    this.buf.getBuffer().get();
    int j = this.buf.getBuffer().get();
    if (!byte2HexString(b1).equals("FF")) {
      i = -1;
    }
    for (;;)
    {
      AppMethodBeat.o(230315);
      return i;
      if ((byte2HexString(b1).equals("FF")) && (byte2HexString(b2).equals("E1")))
      {
        i = (j & 0xFF) - 2;
      }
      else if ((byte2HexString(b1).equals("FF")) && (byte2HexString(b2).equals("D9")))
      {
        i = -1;
      }
      else
      {
        int k = this.buf.getOffset();
        this.buf.getBuffer().position(k + j - 2);
        j = i + 1;
        i = j;
        if (j <= 100) {
          break;
        }
        Log.e("MicroMsg.JpegTools", "error while!");
        i = -1;
      }
    }
  }
  
  private int getOffset()
  {
    AppMethodBeat.i(230319);
    dropByte(4);
    AppMethodBeat.o(230319);
    return 0;
  }
  
  private int getOrei(boolean paramBoolean)
  {
    AppMethodBeat.i(230320);
    int i = this.buf.getBuffer().get();
    int j = this.buf.getBuffer().get();
    dropByte(2);
    if (paramBoolean)
    {
      AppMethodBeat.o(230320);
      return j & 0xFF;
    }
    AppMethodBeat.o(230320);
    return i & 0xFF;
  }
  
  public int getOreiValue()
  {
    if (this.ordivalue != -1) {}
    switch (this.ordivalue)
    {
    case 2: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      return -1;
    case 6: 
      return 90;
    case 3: 
      return 180;
    case 8: 
      return 270;
    }
    return 0;
  }
  
  public int parserJpeg()
  {
    AppMethodBeat.i(230322);
    for (;;)
    {
      int m;
      int k;
      try
      {
        if (!checkIsJpeg())
        {
          Log.w("MicroMsg.JpegTools", "this is not jpeg or no exif data!!!");
          AppMethodBeat.o(230322);
          return -1;
        }
        if (findAppTag() < 0)
        {
          Log.w("MicroMsg.JpegTools", "datalen is error ");
          AppMethodBeat.o(230322);
          return -1;
        }
        if (!checkExifTag())
        {
          Log.w("MicroMsg.JpegTools", "checkExifTag is error");
          AppMethodBeat.o(230322);
          return -1;
        }
        dropByte(2);
        String str = byteOrder();
        if ((!str.equals("MM")) && (!str.equals("II")))
        {
          Log.w("MicroMsg.JpegTools", "byteOrder  is error ".concat(String.valueOf(str)));
          AppMethodBeat.o(230322);
          return -1;
        }
        this.bigOrder = str.equals("MM");
        if (!checkTiffTag(this.bigOrder))
        {
          Log.w("MicroMsg.JpegTools", "checkTiffTag  is error ");
          AppMethodBeat.o(230322);
          return -1;
        }
        getOffset();
        j = this.buf.getBuffer().get();
        i = this.buf.getBuffer().get();
        j &= 0xFF;
        if (!this.bigOrder) {
          break label420;
        }
        j = i & 0xFF;
      }
      catch (Exception localException)
      {
        int j;
        int i;
        byte b1;
        byte b2;
        Log.e("MicroMsg.JpegTools", "parser jpeg error");
        AppMethodBeat.o(230322);
        return -1;
      }
      if ((m < j) && (m < 255))
      {
        b1 = this.buf.getBuffer().get();
        b2 = this.buf.getBuffer().get();
        if ((this.bigOrder) && (byte2HexString(b1).equals("01")) && (byte2HexString(b2).equals("12")))
        {
          i = 1;
          dropByte(2);
          dropByte(4);
          if (i == 0) {
            continue;
          }
          this.ordivalue = getOrei(this.bigOrder);
        }
      }
      else
      {
        Log.d("MicroMsg.JpegTools", "orei " + this.ordivalue);
        i = getOreiValue();
        AppMethodBeat.o(230322);
        return i;
      }
      i = k;
      if (!this.bigOrder)
      {
        i = k;
        if (byte2HexString(b1).equals("12"))
        {
          i = k;
          if (byte2HexString(b2).equals("01"))
          {
            i = 1;
            continue;
            dropByte(4);
            m += 1;
            k = i;
            continue;
            label420:
            m = 0;
            k = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.JpegTools
 * JD-Core Version:    0.7.0.1
 */
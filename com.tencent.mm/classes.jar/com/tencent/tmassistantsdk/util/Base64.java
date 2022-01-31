package com.tencent.tmassistantsdk.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public class Base64
{
  public static final int CRLF = 4;
  public static final int DEFAULT = 0;
  public static final int NO_CLOSE = 16;
  public static final int NO_PADDING = 1;
  public static final int NO_WRAP = 2;
  public static final int URL_SAFE = 8;
  
  static
  {
    AppMethodBeat.i(76223);
    if (!Base64.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(76223);
      return;
    }
  }
  
  public static byte[] decode(String paramString, int paramInt)
  {
    AppMethodBeat.i(76217);
    paramString = decode(paramString.getBytes(), paramInt);
    AppMethodBeat.o(76217);
    return paramString;
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(76218);
    paramArrayOfByte = decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
    AppMethodBeat.o(76218);
    return paramArrayOfByte;
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76219);
    Base64.Decoder localDecoder = new Base64.Decoder(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localDecoder.process(paramArrayOfByte, paramInt1, paramInt2, true))
    {
      paramArrayOfByte = new IllegalArgumentException("bad base-64");
      AppMethodBeat.o(76219);
      throw paramArrayOfByte;
    }
    if (localDecoder.op == localDecoder.output.length)
    {
      paramArrayOfByte = localDecoder.output;
      AppMethodBeat.o(76219);
      return paramArrayOfByte;
    }
    paramArrayOfByte = new byte[localDecoder.op];
    System.arraycopy(localDecoder.output, 0, paramArrayOfByte, 0, localDecoder.op);
    AppMethodBeat.o(76219);
    return paramArrayOfByte;
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(76221);
    paramArrayOfByte = encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
    AppMethodBeat.o(76221);
    return paramArrayOfByte;
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76222);
    Base64.Encoder localEncoder = new Base64.Encoder(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    int j;
    if (localEncoder.do_padding)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localEncoder.do_newline)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localEncoder.do_cr) {
            break label198;
          }
        }
      }
    }
    label198:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localEncoder.output = new byte[i];
      localEncoder.process(paramArrayOfByte, paramInt1, paramInt2, true);
      if (($assertionsDisabled) || (localEncoder.op == i)) {
        break label204;
      }
      paramArrayOfByte = new AssertionError();
      AppMethodBeat.o(76222);
      throw paramArrayOfByte;
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      case 0: 
      default: 
        paramInt3 = i;
        break;
      case 1: 
        paramInt3 = i + 2;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      }
    }
    label204:
    paramArrayOfByte = localEncoder.output;
    AppMethodBeat.o(76222);
    return paramArrayOfByte;
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(76220);
    try
    {
      paramArrayOfByte = new String(encode(paramArrayOfByte, paramInt), "US-ASCII");
      AppMethodBeat.o(76220);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte = new AssertionError(paramArrayOfByte);
      AppMethodBeat.o(76220);
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.Base64
 * JD-Core Version:    0.7.0.1
 */
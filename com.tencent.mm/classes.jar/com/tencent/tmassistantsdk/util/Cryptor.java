package com.tencent.tmassistantsdk.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class Cryptor
{
  protected int contextStart;
  protected int crypt;
  protected boolean header;
  protected byte[] key;
  protected byte[] out;
  protected int padding;
  protected byte[] plain;
  protected int pos;
  protected int preCrypt;
  protected byte[] prePlain;
  protected Random random;
  
  public Cryptor()
  {
    AppMethodBeat.i(102470);
    this.header = true;
    this.random = new Random();
    AppMethodBeat.o(102470);
  }
  
  private byte[] decipher(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102477);
    paramArrayOfByte = decipher(paramArrayOfByte, 0);
    AppMethodBeat.o(102477);
    return paramArrayOfByte;
  }
  
  private byte[] decipher(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(102476);
    int i = 16;
    for (;;)
    {
      long l3;
      long l2;
      long l4;
      long l5;
      long l6;
      long l7;
      long l1;
      try
      {
        l3 = getUnsignedInt(paramArrayOfByte, paramInt, 4);
        l2 = getUnsignedInt(paramArrayOfByte, paramInt + 4, 4);
        l4 = getUnsignedInt(this.key, 0, 4);
        l5 = getUnsignedInt(this.key, 4, 4);
        l6 = getUnsignedInt(this.key, 8, 4);
        l7 = getUnsignedInt(this.key, 12, 4);
        l1 = 3816266640L;
        paramInt = i;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        AppMethodBeat.o(102476);
        return null;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l3);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      AppMethodBeat.o(102476);
      return paramArrayOfByte;
      while (paramInt > 0)
      {
        l2 = l2 - ((l3 << 4) + l6 ^ l3 + l1 ^ (l3 >>> 5) + l7) & 0xFFFFFFFF;
        l3 = l3 - ((l2 << 4) + l4 ^ l2 + l1 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l1 = l1 - 2654435769L & 0xFFFFFFFF;
        paramInt -= 1;
      }
    }
  }
  
  private boolean decrypt8Bytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(102479);
    for (this.pos = 0; this.pos < 8; this.pos += 1)
    {
      if (this.contextStart + this.pos >= paramInt2)
      {
        AppMethodBeat.o(102479);
        return true;
      }
      byte[] arrayOfByte = this.prePlain;
      int i = this.pos;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte[(this.crypt + paramInt1 + this.pos)]));
    }
    this.prePlain = decipher(this.prePlain);
    if (this.prePlain == null)
    {
      AppMethodBeat.o(102479);
      return false;
    }
    this.contextStart += 8;
    this.crypt += 8;
    this.pos = 0;
    AppMethodBeat.o(102479);
    return true;
  }
  
  private byte[] encipher(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(102475);
    int i = 16;
    for (;;)
    {
      long l3;
      long l2;
      long l4;
      long l5;
      long l6;
      long l7;
      long l1;
      try
      {
        l3 = getUnsignedInt(paramArrayOfByte, 0, 4);
        l2 = getUnsignedInt(paramArrayOfByte, 4, 4);
        l4 = getUnsignedInt(this.key, 0, 4);
        l5 = getUnsignedInt(this.key, 4, 4);
        l6 = getUnsignedInt(this.key, 8, 4);
        l7 = getUnsignedInt(this.key, 12, 4);
        l1 = 0L;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        AppMethodBeat.o(102475);
        return null;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l3);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      AppMethodBeat.o(102475);
      return paramArrayOfByte;
      while (i > 0)
      {
        l1 = l1 + 2654435769L & 0xFFFFFFFF;
        l3 = l3 + ((l2 << 4) + l4 ^ l2 + l1 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l2 = l2 + ((l3 << 4) + l6 ^ l3 + l1 ^ (l3 >>> 5) + l7) & 0xFFFFFFFF;
        i -= 1;
      }
    }
  }
  
  private void encrypt8Bytes()
  {
    AppMethodBeat.i(102478);
    this.pos = 0;
    byte[] arrayOfByte;
    int i;
    if (this.pos < 8)
    {
      if (this.header)
      {
        arrayOfByte = this.plain;
        i = this.pos;
        arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ this.prePlain[this.pos]));
      }
      for (;;)
      {
        this.pos += 1;
        break;
        arrayOfByte = this.plain;
        i = this.pos;
        arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ this.out[(this.preCrypt + this.pos)]));
      }
    }
    System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
    for (this.pos = 0; this.pos < 8; this.pos += 1)
    {
      arrayOfByte = this.out;
      i = this.crypt + this.pos;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ this.prePlain[this.pos]));
    }
    System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
    this.preCrypt = this.crypt;
    this.crypt += 8;
    this.pos = 0;
    this.header = false;
    AppMethodBeat.o(102478);
  }
  
  private static long getUnsignedInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = 0L;
    if (paramInt2 > 8) {
      paramInt2 = paramInt1 + 8;
    }
    while (paramInt1 < paramInt2)
    {
      l = l << 8 | paramArrayOfByte[paramInt1] & 0xFF;
      paramInt1 += 1;
      continue;
      paramInt2 = paramInt1 + paramInt2;
    }
    return l >>> 32 | 0xFFFFFFFF & l;
  }
  
  private int rand()
  {
    AppMethodBeat.i(102480);
    int i = this.random.nextInt();
    AppMethodBeat.o(102480);
    return i;
  }
  
  public byte[] decrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(102472);
    this.preCrypt = 0;
    this.crypt = 0;
    this.key = paramArrayOfByte2;
    paramArrayOfByte2 = new byte[paramInt1 + 8];
    if ((paramInt2 % 8 != 0) || (paramInt2 < 16))
    {
      AppMethodBeat.o(102472);
      return null;
    }
    this.prePlain = decipher(paramArrayOfByte1, paramInt1);
    this.pos = (this.prePlain[0] & 0x7);
    int j = paramInt2 - this.pos - 10;
    if (j < 0)
    {
      AppMethodBeat.o(102472);
      return null;
    }
    int i = paramInt1;
    while (i < paramArrayOfByte2.length)
    {
      paramArrayOfByte2[i] = 0;
      i += 1;
    }
    this.out = new byte[j];
    this.preCrypt = 0;
    this.crypt = 8;
    this.contextStart = 8;
    this.pos += 1;
    this.padding = 1;
    for (;;)
    {
      if (this.padding <= 2)
      {
        if (this.pos < 8)
        {
          this.pos += 1;
          this.padding += 1;
        }
        if (this.pos != 8) {
          continue;
        }
        if (!decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2))
        {
          AppMethodBeat.o(102472);
          return null;
        }
      }
      else
      {
        i = 0;
        if (j != 0)
        {
          if (this.pos >= 8) {
            break label470;
          }
          this.out[i] = ((byte)(paramArrayOfByte2[(this.preCrypt + paramInt1 + this.pos)] ^ this.prePlain[this.pos]));
          i += 1;
          this.pos += 1;
          j -= 1;
        }
        label470:
        for (;;)
        {
          if (this.pos == 8)
          {
            this.preCrypt = (this.crypt - 8);
            if (!decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2))
            {
              AppMethodBeat.o(102472);
              return null;
              for (this.padding = 1; this.padding < 8; this.padding += 1)
              {
                if (this.pos < 8)
                {
                  if ((paramArrayOfByte2[(this.preCrypt + paramInt1 + this.pos)] ^ this.prePlain[this.pos]) != 0)
                  {
                    AppMethodBeat.o(102472);
                    return null;
                  }
                  this.pos += 1;
                }
                if (this.pos == 8)
                {
                  this.preCrypt = this.crypt;
                  if (!decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2))
                  {
                    AppMethodBeat.o(102472);
                    return null;
                  }
                  paramArrayOfByte2 = paramArrayOfByte1;
                }
              }
              paramArrayOfByte1 = this.out;
              AppMethodBeat.o(102472);
              return paramArrayOfByte1;
            }
            paramArrayOfByte2 = paramArrayOfByte1;
            break;
          }
          break;
        }
      }
      paramArrayOfByte2 = paramArrayOfByte1;
    }
  }
  
  public byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(102471);
    paramArrayOfByte1 = decrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
    AppMethodBeat.o(102471);
    return paramArrayOfByte1;
  }
  
  public byte[] encrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(102474);
    this.plain = new byte[8];
    this.prePlain = new byte[8];
    this.pos = 1;
    this.padding = 0;
    this.preCrypt = 0;
    this.crypt = 0;
    this.key = paramArrayOfByte2;
    this.header = true;
    this.pos = ((paramInt2 + 10) % 8);
    if (this.pos != 0) {
      this.pos = (8 - this.pos);
    }
    this.out = new byte[this.pos + paramInt2 + 10];
    this.plain[0] = ((byte)(rand() & 0xF8 | this.pos));
    int i = 1;
    while (i <= this.pos)
    {
      this.plain[i] = ((byte)(rand() & 0xFF));
      i += 1;
    }
    this.pos += 1;
    i = 0;
    while (i < 8)
    {
      this.prePlain[i] = 0;
      i += 1;
    }
    this.padding = 1;
    while (this.padding <= 2)
    {
      if (this.pos < 8)
      {
        paramArrayOfByte2 = this.plain;
        i = this.pos;
        this.pos = (i + 1);
        paramArrayOfByte2[i] = ((byte)(rand() & 0xFF));
        this.padding += 1;
      }
      if (this.pos == 8) {
        encrypt8Bytes();
      }
    }
    if (paramInt2 > 0)
    {
      if (this.pos >= 8) {
        break label426;
      }
      paramArrayOfByte2 = this.plain;
      int j = this.pos;
      this.pos = (j + 1);
      i = paramInt1 + 1;
      paramArrayOfByte2[j] = paramArrayOfByte1[paramInt1];
      paramInt2 -= 1;
      paramInt1 = i;
    }
    label426:
    for (;;)
    {
      if (this.pos == 8)
      {
        encrypt8Bytes();
        break;
        this.padding = 1;
        while (this.padding <= 7)
        {
          if (this.pos < 8)
          {
            paramArrayOfByte1 = this.plain;
            paramInt1 = this.pos;
            this.pos = (paramInt1 + 1);
            paramArrayOfByte1[paramInt1] = 0;
            this.padding += 1;
          }
          if (this.pos == 8) {
            encrypt8Bytes();
          }
        }
        paramArrayOfByte1 = this.out;
        AppMethodBeat.o(102474);
        return paramArrayOfByte1;
      }
      break;
    }
  }
  
  public byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(102473);
    paramArrayOfByte1 = encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
    AppMethodBeat.o(102473);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.Cryptor
 * JD-Core Version:    0.7.0.1
 */
package oicq.wlogin_sdk.tools;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

final class a
{
  int contextStart;
  int crypt;
  boolean header = true;
  byte[] key;
  byte[] out;
  int padding;
  byte[] plain;
  int pos;
  int preCrypt;
  byte[] prePlain;
  Random random = new Random();
  
  private byte[] encipher(byte[] paramArrayOfByte)
  {
    int i = 16;
    try
    {
      long l2 = y(paramArrayOfByte, 0);
      long l1 = y(paramArrayOfByte, 4);
      long l4 = y(this.key, 0);
      long l5 = y(this.key, 4);
      long l6 = y(this.key, 8);
      long l7 = y(this.key, 12);
      long l3 = 0L;
      for (;;)
      {
        if (i <= 0)
        {
          paramArrayOfByte = new ByteArrayOutputStream(8);
          DataOutputStream localDataOutputStream = new DataOutputStream(paramArrayOfByte);
          localDataOutputStream.writeInt((int)l2);
          localDataOutputStream.writeInt((int)l1);
          localDataOutputStream.close();
          paramArrayOfByte = paramArrayOfByte.toByteArray();
          return paramArrayOfByte;
        }
        l3 = l3 + 2654435769L & 0xFFFFFFFF;
        l2 = l2 + ((l1 << 4) + l4 ^ l1 + l3 ^ (l1 >>> 5) + l5) & 0xFFFFFFFF;
        l1 = l1 + ((l2 << 4) + l6 ^ l2 + l3 ^ (l2 >>> 5) + l7) & 0xFFFFFFFF;
        i -= 1;
      }
      return null;
    }
    catch (IOException paramArrayOfByte) {}
  }
  
  private static long y(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = paramInt;
    for (;;)
    {
      if (i >= paramInt + 4) {
        return l >>> 32 | 0xFFFFFFFF & l;
      }
      l = l << 8 | paramArrayOfByte[i] & 0xFF;
      i += 1;
    }
  }
  
  final boolean D(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    for (this.pos = 0;; this.pos += 1)
    {
      boolean bool1;
      if (this.pos >= 8)
      {
        this.prePlain = R(this.prePlain);
        if (this.prePlain != null) {
          break;
        }
        bool1 = false;
      }
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.contextStart + this.pos >= paramInt);
      byte[] arrayOfByte = this.prePlain;
      int i = this.pos;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte[(this.crypt + 0 + this.pos)]));
    }
    this.contextStart += 8;
    this.crypt += 8;
    this.pos = 0;
    return true;
  }
  
  final byte[] R(byte[] paramArrayOfByte)
  {
    int i = 16;
    try
    {
      long l1 = y(paramArrayOfByte, 0);
      long l3 = y(paramArrayOfByte, 4);
      long l4 = y(this.key, 0);
      long l5 = y(this.key, 4);
      long l6 = y(this.key, 8);
      long l7 = y(this.key, 12);
      long l2 = 3816266640L;
      for (;;)
      {
        if (i <= 0)
        {
          paramArrayOfByte = new ByteArrayOutputStream(8);
          DataOutputStream localDataOutputStream = new DataOutputStream(paramArrayOfByte);
          localDataOutputStream.writeInt((int)l1);
          localDataOutputStream.writeInt((int)l3);
          localDataOutputStream.close();
          paramArrayOfByte = paramArrayOfByte.toByteArray();
          return paramArrayOfByte;
        }
        l3 = l3 - ((l1 << 4) + l6 ^ l1 + l2 ^ (l1 >>> 5) + l7) & 0xFFFFFFFF;
        l1 = l1 - ((l3 << 4) + l4 ^ l3 + l2 ^ (l3 >>> 5) + l5) & 0xFFFFFFFF;
        l2 = l2 - 2654435769L & 0xFFFFFFFF;
        i -= 1;
      }
      return null;
    }
    catch (IOException paramArrayOfByte) {}
  }
  
  final void encrypt8Bytes()
  {
    this.pos = 0;
    if (this.pos >= 8) {
      System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
    }
    for (this.pos = 0;; this.pos += 1)
    {
      if (this.pos >= 8)
      {
        System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
        this.preCrypt = this.crypt;
        this.crypt += 8;
        this.pos = 0;
        this.header = false;
        return;
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
      byte[] arrayOfByte = this.out;
      int i = this.crypt + this.pos;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ this.prePlain[this.pos]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.a
 * JD-Core Version:    0.7.0.1
 */
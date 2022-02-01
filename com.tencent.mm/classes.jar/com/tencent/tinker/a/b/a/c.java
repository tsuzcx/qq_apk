package com.tencent.tinker.a.b.a;

import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;
import com.tencent.tinker.a.c.b;

public final class c
  extends e
{
  private final b MBj = new b();
  private int MBk = 0;
  
  public c()
  {
    super(null);
  }
  
  private void aix(int paramInt)
  {
    if (paramInt != this.MBk) {
      this.MBj.append(paramInt, this.MBk);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    aix(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException("unexpected opcode: " + a.aiB(paramInt2));
    case -1: 
    case 0: 
    case 14: 
      this.MBk += 1;
      return;
    case 40: 
      paramInt1 = paramInt5 - this.MBk;
      if (paramInt1 != (byte)paramInt1)
      {
        if (paramInt1 != (short)paramInt1)
        {
          this.MBk += 3;
          return;
        }
        this.MBk += 2;
        return;
      }
      this.MBk += 1;
      return;
    case 41: 
      paramInt1 = paramInt5 - this.MBk;
      if (paramInt1 != (short)paramInt1)
      {
        this.MBk += 3;
        return;
      }
      this.MBk += 2;
      return;
    case 42: 
      this.MBk += 3;
      return;
    }
    this.MBk += 3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6)
  {
    aix(paramInt1);
    switch (paramInt2)
    {
    case 14: 
    case 32: 
    case 33: 
    case 35: 
    case 37: 
    case 40: 
    case 41: 
    case 42: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 71: 
    case 72: 
    case 73: 
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    case 80: 
    case 81: 
    case 82: 
    case 83: 
    case 84: 
    case 85: 
    case 86: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    case 91: 
    case 92: 
    case 93: 
    case 94: 
    case 95: 
    default: 
      throw new IllegalStateException("unexpected opcode: " + a.aiB(paramInt2));
    case 26: 
      if (paramInt3 > 65535)
      {
        this.MBk += 3;
        return;
      }
      this.MBk += 2;
      return;
    case 27: 
      this.MBk += 3;
      return;
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 29: 
    case 30: 
    case 39: 
      this.MBk += 1;
      return;
    case 19: 
    case 21: 
    case 22: 
    case 25: 
    case 28: 
    case 31: 
    case 34: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 96: 
    case 97: 
    case 98: 
    case 99: 
    case 100: 
    case 101: 
    case 102: 
    case 103: 
    case 104: 
    case 105: 
    case 106: 
    case 107: 
    case 108: 
    case 109: 
      this.MBk += 2;
      return;
    case 20: 
    case 23: 
    case 36: 
    case 38: 
    case 43: 
    case 44: 
    case 110: 
    case 111: 
    case 112: 
    case 113: 
    case 114: 
      this.MBk += 3;
      return;
    }
    this.MBk += 5;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7)
  {
    aix(paramInt1);
    switch (paramInt2)
    {
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 34: 
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 68: 
    case 69: 
    case 70: 
    case 71: 
    case 72: 
    case 73: 
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    case 80: 
    case 81: 
    case 96: 
    case 97: 
    case 98: 
    case 99: 
    case 100: 
    case 101: 
    case 102: 
    case 103: 
    case 104: 
    case 105: 
    case 106: 
    case 107: 
    case 108: 
    case 109: 
    case 115: 
    case 116: 
    case 117: 
    case 118: 
    case 119: 
    case 120: 
    case 121: 
    case 122: 
    case 144: 
    case 145: 
    case 146: 
    case 147: 
    case 148: 
    case 149: 
    case 150: 
    case 151: 
    case 152: 
    case 153: 
    case 154: 
    case 155: 
    case 156: 
    case 157: 
    case 158: 
    case 159: 
    case 160: 
    case 161: 
    case 162: 
    case 163: 
    case 164: 
    case 165: 
    case 166: 
    case 167: 
    case 168: 
    case 169: 
    case 170: 
    case 171: 
    case 172: 
    case 173: 
    case 174: 
    case 175: 
    default: 
      throw new IllegalStateException("unexpected opcode: " + a.aiB(paramInt2));
    case 1: 
    case 4: 
    case 7: 
    case 33: 
    case 123: 
    case 124: 
    case 125: 
    case 126: 
    case 127: 
    case 128: 
    case 129: 
    case 130: 
    case 131: 
    case 132: 
    case 133: 
    case 134: 
    case 135: 
    case 136: 
    case 137: 
    case 138: 
    case 139: 
    case 140: 
    case 141: 
    case 142: 
    case 143: 
    case 176: 
    case 177: 
    case 178: 
    case 179: 
    case 180: 
    case 181: 
    case 182: 
    case 183: 
    case 184: 
    case 185: 
    case 186: 
    case 187: 
    case 188: 
    case 189: 
    case 190: 
    case 191: 
    case 192: 
    case 193: 
    case 194: 
    case 195: 
    case 196: 
    case 197: 
    case 198: 
    case 199: 
    case 200: 
    case 201: 
    case 202: 
    case 203: 
    case 204: 
    case 205: 
    case 206: 
    case 207: 
      this.MBk += 1;
      return;
    case 2: 
    case 5: 
    case 8: 
      this.MBk += 2;
      return;
    case 32: 
    case 35: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 82: 
    case 83: 
    case 84: 
    case 85: 
    case 86: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    case 91: 
    case 92: 
    case 93: 
    case 94: 
    case 95: 
    case 208: 
    case 209: 
    case 210: 
    case 211: 
    case 212: 
    case 213: 
    case 214: 
    case 215: 
    case 216: 
    case 217: 
    case 218: 
    case 219: 
    case 220: 
    case 221: 
    case 222: 
    case 223: 
    case 224: 
    case 225: 
    case 226: 
      this.MBk += 2;
      return;
    }
    this.MBk += 3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, int paramInt8)
  {
    aix(paramInt1);
    switch (paramInt2)
    {
    case 37: 
    case 38: 
    case 39: 
    case 40: 
    case 41: 
    case 42: 
    case 43: 
    case 44: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
    case 62: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 67: 
    case 82: 
    case 83: 
    case 84: 
    case 85: 
    case 86: 
    case 87: 
    case 88: 
    case 89: 
    case 90: 
    case 91: 
    case 92: 
    case 93: 
    case 94: 
    case 95: 
    case 96: 
    case 97: 
    case 98: 
    case 99: 
    case 100: 
    case 101: 
    case 102: 
    case 103: 
    case 104: 
    case 105: 
    case 106: 
    case 107: 
    case 108: 
    case 109: 
    case 115: 
    case 116: 
    case 117: 
    case 118: 
    case 119: 
    case 120: 
    case 121: 
    case 122: 
    case 123: 
    case 124: 
    case 125: 
    case 126: 
    case 127: 
    case 128: 
    case 129: 
    case 130: 
    case 131: 
    case 132: 
    case 133: 
    case 134: 
    case 135: 
    case 136: 
    case 137: 
    case 138: 
    case 139: 
    case 140: 
    case 141: 
    case 142: 
    case 143: 
    default: 
      throw new IllegalStateException("unexpected opcode: " + a.aiB(paramInt2));
    case 45: 
    case 46: 
    case 47: 
    case 48: 
    case 49: 
    case 68: 
    case 69: 
    case 70: 
    case 71: 
    case 72: 
    case 73: 
    case 74: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
    case 80: 
    case 81: 
    case 144: 
    case 145: 
    case 146: 
    case 147: 
    case 148: 
    case 149: 
    case 150: 
    case 151: 
    case 152: 
    case 153: 
    case 154: 
    case 155: 
    case 156: 
    case 157: 
    case 158: 
    case 159: 
    case 160: 
    case 161: 
    case 162: 
    case 163: 
    case 164: 
    case 165: 
    case 166: 
    case 167: 
    case 168: 
    case 169: 
    case 170: 
    case 171: 
    case 172: 
    case 173: 
    case 174: 
    case 175: 
      this.MBk += 2;
      return;
    }
    this.MBk += 3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    aix(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException("unexpected opcode: " + a.aiB(paramInt2));
    }
    this.MBk += 3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    aix(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException("unexpected opcode: " + a.aiB(paramInt2));
    }
    this.MBk += 3;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    aix(paramInt1);
    this.MBk += 4;
    this.MBk += paramArrayOfInt.length * 2;
  }
  
  public final void a(int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4)
  {
    aix(paramInt1);
    this.MBk += 4;
    switch (paramInt4)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new j("bogus element_width: " + a.aiA(paramInt4));
    case 1: 
      paramInt1 = ((byte[])paramObject).length;
      this.MBk = ((paramInt1 & 0x1) + (paramInt1 >> 1) + this.MBk);
      return;
    case 2: 
      this.MBk += ((short[])paramObject).length * 1;
      return;
    case 4: 
      this.MBk += ((int[])paramObject).length * 2;
      return;
    }
    this.MBk += ((long[])paramObject).length * 4;
  }
  
  public final void a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    aix(paramInt1);
    this.MBk += 2;
    this.MBk += paramArrayOfInt1.length * 2;
    this.MBk += paramArrayOfInt2.length * 2;
  }
  
  public final int aiy(int paramInt)
  {
    int i = this.MBj.indexOfKey(paramInt);
    if (i < 0) {
      return paramInt;
    }
    return this.MBj.MBt[i];
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7)
  {
    aix(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException("unexpected opcode: " + a.aiB(paramInt2));
    }
    this.MBk += 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */
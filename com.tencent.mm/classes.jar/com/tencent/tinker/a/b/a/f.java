package com.tencent.tinker.a.b.a;

import com.tencent.tinker.a.a.j;

public final class f
  extends e
{
  private final h ahPc;
  private final c ahPd;
  private final boolean ahPe;
  
  public f(h paramh, c paramc)
  {
    super(null);
    this.ahPc = paramh;
    this.ahPd = paramc;
    this.ahPe = true;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    paramInt1 = paramInt5;
    if (this.ahPe) {
      paramInt1 = this.ahPd.aIy(paramInt5);
    }
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.aIB(paramInt2));
    case -1: 
    case 0: 
    case 14: 
      s1 = (short)paramInt2;
      this.ahPc.g(s1);
      return;
    case 40: 
      if (this.ahPe)
      {
        paramInt1 -= this.ahPc.bGj;
        if (paramInt1 != (byte)paramInt1)
        {
          if (paramInt1 != (short)paramInt1)
          {
            this.ahPc.a((short)42, (short)paramInt1, (short)(paramInt1 >> 16));
            return;
          }
          s1 = (short)paramInt1;
          this.ahPc.d((short)41, s1);
          return;
        }
        this.ahPc.g(b.pU(paramInt2, paramInt1 & 0xFF));
        return;
      }
      paramInt1 -= this.ahPc.bGj;
      if (paramInt1 != (byte)paramInt1) {
        throw new j("Target out of range: " + com.tencent.tinker.a.b.b.a.aID(paramInt1) + ", perhaps you need to enable force jumbo mode.");
      }
      this.ahPc.g(b.pU(paramInt2, paramInt1 & 0xFF));
      return;
    case 41: 
      if (this.ahPe)
      {
        paramInt1 -= this.ahPc.bGj;
        if (paramInt1 != (short)paramInt1)
        {
          this.ahPc.a((short)42, (short)paramInt1, (short)(paramInt1 >> 16));
          return;
        }
        s1 = (short)paramInt1;
        s2 = (short)paramInt2;
        this.ahPc.d(s2, s1);
        return;
      }
      s1 = b.pW(paramInt1, this.ahPc.bGj);
      short s2 = (short)paramInt2;
      this.ahPc.d(s2, s1);
      return;
    case 42: 
      paramInt1 -= this.ahPc.bGj;
      s1 = (short)paramInt2;
      this.ahPc.a(s1, (short)paramInt1, (short)(paramInt1 >> 16));
      return;
    }
    short s1 = (short)paramInt3;
    this.ahPc.a(b.pU(paramInt2, b.pV(0, 0)), s1, b.al(0, 0, 0, 0));
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6)
  {
    paramInt1 = paramInt5;
    if (this.ahPe) {
      paramInt1 = this.ahPd.aIy(paramInt5);
    }
    h localh;
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
      throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.aIB(paramInt2));
    case 18: 
      paramInt1 = (short)paramInt2;
      localh = this.ahPc;
      if ((paramLong < -8L) || (paramLong > 7L)) {
        throw new j("Literal out of range: " + com.tencent.tinker.a.b.b.a.Bl(paramLong));
      }
      localh.g(b.pU(paramInt1, b.pV(paramInt6, (int)paramLong & 0xF)));
      return;
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 15: 
    case 16: 
    case 17: 
    case 29: 
    case 30: 
    case 39: 
      this.ahPc.g(b.pU(paramInt2, paramInt6));
      return;
    case 56: 
    case 57: 
    case 58: 
    case 59: 
    case 60: 
    case 61: 
      s1 = b.pW(paramInt1, this.ahPc.bGj);
      this.ahPc.d(b.pU(paramInt2, paramInt6), s1);
      return;
    case 19: 
    case 22: 
      this.ahPc.d(b.pU(paramInt2, paramInt6), b.Bk(paramLong));
      return;
    case 21: 
    case 25: 
      if (paramInt2 == 21) {}
      for (paramInt1 = 16;; paramInt1 = 48)
      {
        s1 = (short)(int)(paramLong >> paramInt1);
        this.ahPc.d(b.pU(paramInt2, paramInt6), s1);
        return;
      }
    case 26: 
      if (this.ahPe)
      {
        if (paramInt3 > 65535)
        {
          this.ahPc.a(b.pU(27, paramInt6), (short)paramInt3, (short)(paramInt3 >> 16));
          return;
        }
        s1 = (short)paramInt3;
        this.ahPc.d(b.pU(paramInt2, paramInt6), s1);
        return;
      }
      if (paramInt3 > 65535) {
        throw new j("string index out of bound: " + com.tencent.tinker.a.b.b.a.aIz(paramInt3) + ", perhaps you need to enable force jumbo mode.");
      }
      s1 = (short)paramInt3;
      this.ahPc.d(b.pU(paramInt2, paramInt6), s1);
      return;
    case 28: 
    case 31: 
    case 34: 
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
      s1 = (short)paramInt3;
      this.ahPc.d(b.pU(paramInt2, paramInt6), s1);
      return;
    case 20: 
    case 23: 
      if (paramLong != (int)paramLong) {
        throw new j("Literal out of range: " + com.tencent.tinker.a.b.b.a.Bl(paramLong));
      }
      paramInt1 = (int)paramLong;
      this.ahPc.a(b.pU(paramInt2, paramInt6), (short)paramInt1, (short)(paramInt1 >> 16));
      return;
    case 38: 
    case 43: 
    case 44: 
      switch (paramInt2)
      {
      }
      for (;;)
      {
        paramInt1 -= this.ahPc.bGj;
        this.ahPc.a(b.pU(paramInt2, paramInt6), (short)paramInt1, (short)(paramInt1 >> 16));
        return;
        localh = this.ahPc;
        localh.pT(paramInt1, localh.bGj);
      }
    case 27: 
      this.ahPc.a(b.pU(paramInt2, paramInt6), (short)paramInt3, (short)(paramInt3 >> 16));
      return;
    case 24: 
      localh = this.ahPc;
      s1 = b.pU(paramInt2, paramInt6);
      short s2 = (short)(int)paramLong;
      short s3 = (short)(int)(paramLong >> 16);
      short s4 = (short)(int)(paramLong >> 32);
      short s5 = (short)(int)(paramLong >> 48);
      localh.g(s1);
      localh.g(s2);
      localh.g(s3);
      localh.g(s4);
      localh.g(s5);
      return;
    }
    short s1 = (short)paramInt3;
    this.ahPc.a(b.pU(paramInt2, b.pV(0, 1)), s1, b.al(paramInt6, 0, 0, 0));
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7)
  {
    paramInt1 = paramInt5;
    if (this.ahPe) {
      paramInt1 = this.ahPd.aIy(paramInt5);
    }
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
      throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.aIB(paramInt2));
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
      paramInt1 = (short)paramInt2;
      this.ahPc.g(b.pU(paramInt1, b.pV(paramInt6, paramInt7)));
      return;
    case 2: 
    case 5: 
    case 8: 
      this.ahPc.d(b.pU(paramInt2, paramInt6), b.aIv(paramInt7));
      return;
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
      h localh = this.ahPc;
      s = b.pU(paramInt2, paramInt6);
      if (paramLong != (byte)(int)paramLong) {
        throw new j("Literal out of range: " + com.tencent.tinker.a.b.b.a.Bl(paramLong));
      }
      localh.d(s, b.pU(paramInt7, (int)paramLong & 0xFF));
      return;
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
      s = b.pW(paramInt1, this.ahPc.bGj);
      this.ahPc.d(b.pU(paramInt2, b.pV(paramInt6, paramInt7)), s);
      return;
    case 208: 
    case 209: 
    case 210: 
    case 211: 
    case 212: 
    case 213: 
    case 214: 
    case 215: 
      this.ahPc.d(b.pU(paramInt2, b.pV(paramInt6, paramInt7)), b.Bk(paramLong));
      return;
    case 32: 
    case 35: 
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
      s = (short)paramInt3;
      this.ahPc.d(b.pU(paramInt2, b.pV(paramInt6, paramInt7)), s);
      return;
    case 3: 
    case 6: 
    case 9: 
      s = (short)paramInt2;
      this.ahPc.a(s, b.aIu(paramInt6), b.aIv(paramInt7));
      return;
    }
    short s = (short)paramInt3;
    this.ahPc.a(b.pU(paramInt2, b.pV(0, 2)), s, b.al(paramInt6, paramInt7, 0, 0));
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, int paramInt8)
  {
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
      throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.aIB(paramInt2));
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
      this.ahPc.d(b.pU(paramInt2, paramInt6), b.pU(paramInt7, paramInt8));
      return;
    }
    short s = (short)paramInt3;
    this.ahPc.a(b.pU(paramInt2, b.pV(0, 3)), s, b.al(paramInt6, paramInt7, paramInt8, 0));
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.aIB(paramInt2));
    }
    short s = (short)paramInt3;
    this.ahPc.a(b.pU(paramInt2, b.pV(0, 4)), s, b.al(paramInt6, paramInt7, paramInt8, paramInt9));
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.aIB(paramInt2));
    }
    short s = (short)paramInt3;
    this.ahPc.a(b.pU(paramInt2, b.pV(paramInt10, 5)), s, b.al(paramInt6, paramInt7, paramInt8, paramInt9));
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    int i = 0;
    paramInt1 = 0;
    int j = this.ahPc.kbY();
    short s = (short)paramInt2;
    this.ahPc.g(s);
    this.ahPc.g(b.aIs(paramArrayOfInt.length));
    this.ahPc.aX(paramInt3);
    if (this.ahPe)
    {
      paramInt2 = paramArrayOfInt.length;
      while (paramInt1 < paramInt2)
      {
        paramInt3 = paramArrayOfInt[paramInt1];
        paramInt3 = this.ahPd.aIy(paramInt3);
        this.ahPc.aX(paramInt3 - j);
        paramInt1 += 1;
      }
    }
    paramInt2 = paramArrayOfInt.length;
    paramInt1 = i;
    while (paramInt1 < paramInt2)
    {
      paramInt3 = paramArrayOfInt[paramInt1];
      this.ahPc.aX(paramInt3 - j);
      paramInt1 += 1;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4)
  {
    int i = 0;
    int j = 0;
    paramInt1 = 0;
    short s = (short)paramInt2;
    this.ahPc.g(s);
    s = (short)paramInt4;
    this.ahPc.g(s);
    this.ahPc.aX(paramInt3);
    h localh;
    switch (paramInt4)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new j("bogus element_width: " + com.tencent.tinker.a.b.b.a.aIA(paramInt4));
    case 1: 
      localh = this.ahPc;
      paramObject = (byte[])paramObject;
      paramInt4 = paramObject.length;
      paramInt3 = 0;
      paramInt2 = 1;
      paramInt1 = 0;
      if (paramInt3 < paramInt4)
      {
        i = paramObject[paramInt3];
        if (paramInt2 != 0) {
          paramInt1 = i & 0xFF;
        }
        for (paramInt2 = 0;; paramInt2 = 1)
        {
          paramInt3 += 1;
          break;
          paramInt1 |= i << 8;
          localh.g((short)paramInt1);
        }
      }
      if (paramInt2 == 0) {
        localh.g((short)paramInt1);
      }
      break;
    }
    for (;;)
    {
      return;
      localh = this.ahPc;
      paramObject = (short[])paramObject;
      paramInt2 = paramObject.length;
      while (paramInt1 < paramInt2)
      {
        localh.g(paramObject[paramInt1]);
        paramInt1 += 1;
      }
      continue;
      localh = this.ahPc;
      paramObject = (int[])paramObject;
      paramInt2 = paramObject.length;
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        localh.aX(paramObject[paramInt1]);
        paramInt1 += 1;
      }
      continue;
      localh = this.ahPc;
      paramObject = (long[])paramObject;
      paramInt2 = paramObject.length;
      paramInt1 = j;
      while (paramInt1 < paramInt2)
      {
        long l = paramObject[paramInt1];
        localh.g((short)(int)l);
        localh.g((short)(int)(l >> 16));
        localh.g((short)(int)(l >> 32));
        localh.g((short)(int)(l >> 48));
        paramInt1 += 1;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int j = 0;
    int i = 0;
    int k = this.ahPc.kbY();
    short s = (short)paramInt2;
    this.ahPc.g(s);
    this.ahPc.g(b.aIs(paramArrayOfInt2.length));
    paramInt2 = paramArrayOfInt1.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      int m = paramArrayOfInt1[paramInt1];
      this.ahPc.aX(m);
      paramInt1 += 1;
    }
    if (this.ahPe)
    {
      paramInt2 = paramArrayOfInt2.length;
      paramInt1 = i;
      while (paramInt1 < paramInt2)
      {
        i = paramArrayOfInt2[paramInt1];
        i = this.ahPd.aIy(i);
        this.ahPc.aX(i - k);
        paramInt1 += 1;
      }
    }
    paramInt2 = paramArrayOfInt2.length;
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      i = paramArrayOfInt2[paramInt1];
      this.ahPc.aX(i - k);
      paramInt1 += 1;
    }
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6, int paramInt7)
  {
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.aIB(paramInt2));
    }
    short s = (short)paramInt3;
    this.ahPc.a(b.pU(paramInt2, paramInt7), s, b.aIu(paramInt6));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.f
 * JD-Core Version:    0.7.0.1
 */
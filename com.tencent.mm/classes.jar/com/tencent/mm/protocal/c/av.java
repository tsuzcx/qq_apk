package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class av
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public String kSC;
  public int pyo;
  public String sud;
  public String sue;
  public String suf;
  public at sug;
  public String suh;
  public da sui;
  public dm suj;
  public dl suk;
  public dl sul;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.hQR);
      if (this.kSC != null) {
        paramVarArgs.d(2, this.kSC);
      }
      paramVarArgs.gB(3, this.pyo);
      if (this.sud != null) {
        paramVarArgs.d(4, this.sud);
      }
      if (this.sue != null) {
        paramVarArgs.d(5, this.sue);
      }
      if (this.suf != null) {
        paramVarArgs.d(6, this.suf);
      }
      if (this.sug != null)
      {
        paramVarArgs.gD(7, this.sug.btq());
        this.sug.a(paramVarArgs);
      }
      if (this.suh != null) {
        paramVarArgs.d(8, this.suh);
      }
      if (this.sui != null)
      {
        paramVarArgs.gD(9, this.sui.btq());
        this.sui.a(paramVarArgs);
      }
      if (this.suj != null)
      {
        paramVarArgs.gD(10, this.suj.btq());
        this.suj.a(paramVarArgs);
      }
      if (this.suk != null)
      {
        paramVarArgs.gD(11, this.suk.btq());
        this.suk.a(paramVarArgs);
      }
      if (this.sul != null)
      {
        paramVarArgs.gD(12, this.sul.btq());
        this.sul.a(paramVarArgs);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.hQR) + 0;
      paramInt = i;
      if (this.kSC != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kSC);
      }
      i = paramInt + d.a.a.a.gy(3, this.pyo);
      paramInt = i;
      if (this.sud != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sud);
      }
      i = paramInt;
      if (this.sue != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sue);
      }
      paramInt = i;
      if (this.suf != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.suf);
      }
      i = paramInt;
      if (this.sug != null) {
        i = paramInt + d.a.a.a.gA(7, this.sug.btq());
      }
      paramInt = i;
      if (this.suh != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.suh);
      }
      i = paramInt;
      if (this.sui != null) {
        i = paramInt + d.a.a.a.gA(9, this.sui.btq());
      }
      paramInt = i;
      if (this.suj != null) {
        paramInt = i + d.a.a.a.gA(10, this.suj.btq());
      }
      i = paramInt;
      if (this.suk != null) {
        i = paramInt + d.a.a.a.gA(11, this.suk.btq());
      }
      paramInt = i;
    } while (this.sul == null);
    return i + d.a.a.a.gA(12, this.sul.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      av localav = (av)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localav.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localav.kSC = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localav.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localav.sud = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        localav.sue = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 6: 
        localav.suf = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new at();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((at)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localav.sug = ((at)localObject1);
          paramInt += 1;
        }
        return 0;
      case 8: 
        localav.suh = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 9: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new da();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((da)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localav.sui = ((da)localObject1);
          paramInt += 1;
        }
        return 0;
      case 10: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dm();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dm)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localav.suj = ((dm)localObject1);
          paramInt += 1;
        }
        return 0;
      case 11: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dl();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localav.suk = ((dl)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dl();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localav.sul = ((dl)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.av
 * JD-Core Version:    0.7.0.1
 */
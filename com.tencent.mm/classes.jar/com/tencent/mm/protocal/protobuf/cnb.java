package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnb
  extends com.tencent.mm.bw.a
{
  public String GVf;
  public int Hzc;
  public LinkedList<btd> Hzd;
  public int Hze;
  public String Hzf;
  public String Hzg;
  public int Hzh;
  public String Hzi;
  public int Hzj;
  public LinkedList<aff> Hzk;
  public String Name;
  public String PriceType;
  public int Scene;
  public String ThumbUrl;
  public int nID;
  public int nJA;
  
  public cnb()
  {
    AppMethodBeat.i(91633);
    this.Hzd = new LinkedList();
    this.Hzk = new LinkedList();
    AppMethodBeat.o(91633);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91634);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hzc);
      paramVarArgs.e(2, 8, this.Hzd);
      paramVarArgs.aS(3, this.nID);
      paramVarArgs.aS(4, this.Hze);
      if (this.PriceType != null) {
        paramVarArgs.d(5, this.PriceType);
      }
      if (this.GVf != null) {
        paramVarArgs.d(6, this.GVf);
      }
      if (this.Hzf != null) {
        paramVarArgs.d(7, this.Hzf);
      }
      if (this.Hzg != null) {
        paramVarArgs.d(8, this.Hzg);
      }
      paramVarArgs.aS(9, this.nJA);
      if (this.Name != null) {
        paramVarArgs.d(10, this.Name);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(11, this.ThumbUrl);
      }
      paramVarArgs.aS(12, this.Hzh);
      paramVarArgs.aS(13, this.Scene);
      if (this.Hzi != null) {
        paramVarArgs.d(14, this.Hzi);
      }
      paramVarArgs.aS(15, this.Hzj);
      paramVarArgs.e(16, 8, this.Hzk);
      AppMethodBeat.o(91634);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Hzc) + 0 + f.a.a.a.c(2, 8, this.Hzd) + f.a.a.b.b.a.bz(3, this.nID) + f.a.a.b.b.a.bz(4, this.Hze);
      paramInt = i;
      if (this.PriceType != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.PriceType);
      }
      i = paramInt;
      if (this.GVf != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GVf);
      }
      paramInt = i;
      if (this.Hzf != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hzf);
      }
      i = paramInt;
      if (this.Hzg != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Hzg);
      }
      i += f.a.a.b.b.a.bz(9, this.nJA);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Name);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.ThumbUrl);
      }
      i = i + f.a.a.b.b.a.bz(12, this.Hzh) + f.a.a.b.b.a.bz(13, this.Scene);
      paramInt = i;
      if (this.Hzi != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Hzi);
      }
      i = f.a.a.b.b.a.bz(15, this.Hzj);
      int j = f.a.a.a.c(16, 8, this.Hzk);
      AppMethodBeat.o(91634);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hzd.clear();
      this.Hzk.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cnb localcnb = (cnb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91634);
        return -1;
      case 1: 
        localcnb.Hzc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91634);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnb.Hzd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91634);
        return 0;
      case 3: 
        localcnb.nID = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91634);
        return 0;
      case 4: 
        localcnb.Hze = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91634);
        return 0;
      case 5: 
        localcnb.PriceType = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 6: 
        localcnb.GVf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 7: 
        localcnb.Hzf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 8: 
        localcnb.Hzg = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 9: 
        localcnb.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91634);
        return 0;
      case 10: 
        localcnb.Name = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 11: 
        localcnb.ThumbUrl = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 12: 
        localcnb.Hzh = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91634);
        return 0;
      case 13: 
        localcnb.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91634);
        return 0;
      case 14: 
        localcnb.Hzi = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91634);
        return 0;
      case 15: 
        localcnb.Hzj = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91634);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aff();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aff)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcnb.Hzk.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91634);
      return 0;
    }
    AppMethodBeat.o(91634);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnb
 * JD-Core Version:    0.7.0.1
 */
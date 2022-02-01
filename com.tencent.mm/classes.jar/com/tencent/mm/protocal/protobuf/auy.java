package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auy
  extends com.tencent.mm.bx.a
{
  public LinkedList<byf> BGy;
  public long FDe;
  public long FDf;
  public boolean FDh;
  public dau Gtd;
  public long Gte;
  public long Gtf;
  public long Gtg;
  public long Gth;
  public long Gti;
  public long uin;
  
  public auy()
  {
    AppMethodBeat.i(110895);
    this.BGy = new LinkedList();
    this.Gte = 10L;
    this.Gtf = 0L;
    this.FDh = false;
    this.Gtg = 0L;
    this.Gth = 0L;
    this.Gti = 0L;
    AppMethodBeat.o(110895);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110896);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FDe);
      paramVarArgs.aY(2, this.uin);
      paramVarArgs.aY(3, this.FDf);
      paramVarArgs.e(4, 8, this.BGy);
      if (this.Gtd != null)
      {
        paramVarArgs.lC(5, this.Gtd.computeSize());
        this.Gtd.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.Gte);
      paramVarArgs.aY(7, this.Gtf);
      paramVarArgs.bt(8, this.FDh);
      paramVarArgs.aY(9, this.Gtg);
      paramVarArgs.aY(10, this.Gth);
      paramVarArgs.aY(11, this.Gti);
      AppMethodBeat.o(110896);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FDe) + 0 + f.a.a.b.b.a.p(2, this.uin) + f.a.a.b.b.a.p(3, this.FDf) + f.a.a.a.c(4, 8, this.BGy);
      paramInt = i;
      if (this.Gtd != null) {
        paramInt = i + f.a.a.a.lB(5, this.Gtd.computeSize());
      }
      i = f.a.a.b.b.a.p(6, this.Gte);
      int j = f.a.a.b.b.a.p(7, this.Gtf);
      int k = f.a.a.b.b.a.alV(8);
      int m = f.a.a.b.b.a.p(9, this.Gtg);
      int n = f.a.a.b.b.a.p(10, this.Gth);
      int i1 = f.a.a.b.b.a.p(11, this.Gti);
      AppMethodBeat.o(110896);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.BGy.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(110896);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      auy localauy = (auy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110896);
        return -1;
      case 1: 
        localauy.FDe = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110896);
        return 0;
      case 2: 
        localauy.uin = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110896);
        return 0;
      case 3: 
        localauy.FDf = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110896);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localauy.BGy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dau();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dau)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localauy.Gtd = ((dau)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 6: 
        localauy.Gte = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110896);
        return 0;
      case 7: 
        localauy.Gtf = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110896);
        return 0;
      case 8: 
        localauy.FDh = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(110896);
        return 0;
      case 9: 
        localauy.Gtg = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110896);
        return 0;
      case 10: 
        localauy.Gth = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110896);
        return 0;
      }
      localauy.Gti = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(110896);
      return 0;
    }
    AppMethodBeat.o(110896);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auy
 * JD-Core Version:    0.7.0.1
 */
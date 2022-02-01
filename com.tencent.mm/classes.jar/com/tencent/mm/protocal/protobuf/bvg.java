package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvg
  extends com.tencent.mm.bx.a
{
  public long GPA;
  public long GPB;
  public long GPC;
  public LinkedList<bvd> GPD;
  public int GPx;
  public LinkedList<bvf> GPy;
  public int GPz;
  public String clientId;
  public long gpV;
  public int hfV;
  public int postStage;
  public long whI;
  
  public bvg()
  {
    AppMethodBeat.i(169081);
    this.GPy = new LinkedList();
    this.GPD = new LinkedList();
    AppMethodBeat.o(169081);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169082);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.clientId != null) {
        paramVarArgs.d(1, this.clientId);
      }
      paramVarArgs.aS(2, this.hfV);
      paramVarArgs.aS(3, this.GPx);
      paramVarArgs.e(4, 8, this.GPy);
      paramVarArgs.aS(5, this.GPz);
      paramVarArgs.aS(6, this.postStage);
      paramVarArgs.aY(7, this.GPA);
      paramVarArgs.aY(8, this.whI);
      paramVarArgs.aY(9, this.GPB);
      paramVarArgs.aY(10, this.gpV);
      paramVarArgs.aY(11, this.GPC);
      paramVarArgs.e(12, 8, this.GPD);
      AppMethodBeat.o(169082);
      return 0;
    }
    if (paramInt == 1) {
      if (this.clientId == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.b.b.a.e(1, this.clientId) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.hfV);
      int j = f.a.a.b.b.a.bz(3, this.GPx);
      int k = f.a.a.a.c(4, 8, this.GPy);
      int m = f.a.a.b.b.a.bz(5, this.GPz);
      int n = f.a.a.b.b.a.bz(6, this.postStage);
      int i1 = f.a.a.b.b.a.p(7, this.GPA);
      int i2 = f.a.a.b.b.a.p(8, this.whI);
      int i3 = f.a.a.b.b.a.p(9, this.GPB);
      int i4 = f.a.a.b.b.a.p(10, this.gpV);
      int i5 = f.a.a.b.b.a.p(11, this.GPC);
      int i6 = f.a.a.a.c(12, 8, this.GPD);
      AppMethodBeat.o(169082);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GPy.clear();
        this.GPD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169082);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvg localbvg = (bvg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169082);
          return -1;
        case 1: 
          localbvg.clientId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169082);
          return 0;
        case 2: 
          localbvg.hfV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169082);
          return 0;
        case 3: 
          localbvg.GPx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169082);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvg.GPy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169082);
          return 0;
        case 5: 
          localbvg.GPz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169082);
          return 0;
        case 6: 
          localbvg.postStage = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169082);
          return 0;
        case 7: 
          localbvg.GPA = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169082);
          return 0;
        case 8: 
          localbvg.whI = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169082);
          return 0;
        case 9: 
          localbvg.GPB = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169082);
          return 0;
        case 10: 
          localbvg.gpV = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169082);
          return 0;
        case 11: 
          localbvg.GPC = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169082);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbvg.GPD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169082);
        return 0;
      }
      AppMethodBeat.o(169082);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvg
 * JD-Core Version:    0.7.0.1
 */
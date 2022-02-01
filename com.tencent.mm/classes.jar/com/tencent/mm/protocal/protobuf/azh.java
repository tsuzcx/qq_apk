package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azh
  extends com.tencent.mm.bx.a
  implements deo
{
  public int FYj;
  public int FYk;
  public int FYl;
  public LinkedList<dkg> FYm;
  public LinkedList<dkg> FYn;
  public LinkedList<dkg> FYo;
  public int FYp;
  public int FYq;
  public int FYr;
  public bny FYs;
  public int GwC;
  public int GwD;
  public int GwE;
  public LinkedList<dkg> GwF;
  public LinkedList<dkg> GwG;
  public LinkedList<dkg> GwH;
  public int Ret;
  
  public azh()
  {
    AppMethodBeat.i(143974);
    this.FYm = new LinkedList();
    this.FYn = new LinkedList();
    this.FYo = new LinkedList();
    this.GwF = new LinkedList();
    this.GwG = new LinkedList();
    this.GwH = new LinkedList();
    AppMethodBeat.o(143974);
  }
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143975);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      paramVarArgs.aS(2, this.FYj);
      paramVarArgs.aS(3, this.FYk);
      paramVarArgs.aS(4, this.FYl);
      paramVarArgs.e(5, 8, this.FYm);
      paramVarArgs.e(6, 8, this.FYn);
      paramVarArgs.e(7, 8, this.FYo);
      paramVarArgs.aS(8, this.FYp);
      paramVarArgs.aS(9, this.FYq);
      paramVarArgs.aS(10, this.FYr);
      paramVarArgs.aS(11, this.GwC);
      paramVarArgs.aS(12, this.GwD);
      paramVarArgs.aS(13, this.GwE);
      paramVarArgs.e(14, 8, this.GwF);
      paramVarArgs.e(15, 8, this.GwG);
      paramVarArgs.e(16, 8, this.GwH);
      if (this.FYs != null)
      {
        paramVarArgs.lC(17, this.FYs.computeSize());
        this.FYs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0 + f.a.a.b.b.a.bz(2, this.FYj) + f.a.a.b.b.a.bz(3, this.FYk) + f.a.a.b.b.a.bz(4, this.FYl) + f.a.a.a.c(5, 8, this.FYm) + f.a.a.a.c(6, 8, this.FYn) + f.a.a.a.c(7, 8, this.FYo) + f.a.a.b.b.a.bz(8, this.FYp) + f.a.a.b.b.a.bz(9, this.FYq) + f.a.a.b.b.a.bz(10, this.FYr) + f.a.a.b.b.a.bz(11, this.GwC) + f.a.a.b.b.a.bz(12, this.GwD) + f.a.a.b.b.a.bz(13, this.GwE) + f.a.a.a.c(14, 8, this.GwF) + f.a.a.a.c(15, 8, this.GwG) + f.a.a.a.c(16, 8, this.GwH);
      paramInt = i;
      if (this.FYs != null) {
        paramInt = i + f.a.a.a.lB(17, this.FYs.computeSize());
      }
      AppMethodBeat.o(143975);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FYm.clear();
      this.FYn.clear();
      this.FYo.clear();
      this.GwF.clear();
      this.GwG.clear();
      this.GwH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      azh localazh = (azh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143975);
        return -1;
      case 1: 
        localazh.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 2: 
        localazh.FYj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 3: 
        localazh.FYk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 4: 
        localazh.FYl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazh.FYm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazh.FYn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazh.FYo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 8: 
        localazh.FYp = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 9: 
        localazh.FYq = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 10: 
        localazh.FYr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 11: 
        localazh.GwC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 12: 
        localazh.GwD = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 13: 
        localazh.GwE = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143975);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazh.GwF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazh.GwG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazh.GwH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bny();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bny)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localazh.FYs = ((bny)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    AppMethodBeat.o(143975);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azh
 * JD-Core Version:    0.7.0.1
 */
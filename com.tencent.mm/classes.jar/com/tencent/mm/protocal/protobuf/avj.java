package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avj
  extends com.tencent.mm.bw.a
  implements czb
{
  public LinkedList<det> ENA;
  public LinkedList<det> ENB;
  public LinkedList<det> ENC;
  public int ENx;
  public int ENy;
  public int ENz;
  public int EqZ;
  public int Era;
  public int Erb;
  public LinkedList<det> Erc;
  public LinkedList<det> Erd;
  public LinkedList<det> Ere;
  public int Erf;
  public int Erg;
  public int Erh;
  public bjq Eri;
  public int Ret;
  
  public avj()
  {
    AppMethodBeat.i(143974);
    this.Erc = new LinkedList();
    this.Erd = new LinkedList();
    this.Ere = new LinkedList();
    this.ENA = new LinkedList();
    this.ENB = new LinkedList();
    this.ENC = new LinkedList();
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
      paramVarArgs.aR(1, this.Ret);
      paramVarArgs.aR(2, this.EqZ);
      paramVarArgs.aR(3, this.Era);
      paramVarArgs.aR(4, this.Erb);
      paramVarArgs.e(5, 8, this.Erc);
      paramVarArgs.e(6, 8, this.Erd);
      paramVarArgs.e(7, 8, this.Ere);
      paramVarArgs.aR(8, this.Erf);
      paramVarArgs.aR(9, this.Erg);
      paramVarArgs.aR(10, this.Erh);
      paramVarArgs.aR(11, this.ENx);
      paramVarArgs.aR(12, this.ENy);
      paramVarArgs.aR(13, this.ENz);
      paramVarArgs.e(14, 8, this.ENA);
      paramVarArgs.e(15, 8, this.ENB);
      paramVarArgs.e(16, 8, this.ENC);
      if (this.Eri != null)
      {
        paramVarArgs.ln(17, this.Eri.computeSize());
        this.Eri.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Ret) + 0 + f.a.a.b.b.a.bx(2, this.EqZ) + f.a.a.b.b.a.bx(3, this.Era) + f.a.a.b.b.a.bx(4, this.Erb) + f.a.a.a.c(5, 8, this.Erc) + f.a.a.a.c(6, 8, this.Erd) + f.a.a.a.c(7, 8, this.Ere) + f.a.a.b.b.a.bx(8, this.Erf) + f.a.a.b.b.a.bx(9, this.Erg) + f.a.a.b.b.a.bx(10, this.Erh) + f.a.a.b.b.a.bx(11, this.ENx) + f.a.a.b.b.a.bx(12, this.ENy) + f.a.a.b.b.a.bx(13, this.ENz) + f.a.a.a.c(14, 8, this.ENA) + f.a.a.a.c(15, 8, this.ENB) + f.a.a.a.c(16, 8, this.ENC);
      paramInt = i;
      if (this.Eri != null) {
        paramInt = i + f.a.a.a.lm(17, this.Eri.computeSize());
      }
      AppMethodBeat.o(143975);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Erc.clear();
      this.Erd.clear();
      this.Ere.clear();
      this.ENA.clear();
      this.ENB.clear();
      this.ENC.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      avj localavj = (avj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143975);
        return -1;
      case 1: 
        localavj.Ret = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143975);
        return 0;
      case 2: 
        localavj.EqZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143975);
        return 0;
      case 3: 
        localavj.Era = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143975);
        return 0;
      case 4: 
        localavj.Erb = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143975);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new det();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((det)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavj.Erc.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new det();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((det)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavj.Erd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new det();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((det)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavj.Ere.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 8: 
        localavj.Erf = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143975);
        return 0;
      case 9: 
        localavj.Erg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143975);
        return 0;
      case 10: 
        localavj.Erh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143975);
        return 0;
      case 11: 
        localavj.ENx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143975);
        return 0;
      case 12: 
        localavj.ENy = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143975);
        return 0;
      case 13: 
        localavj.ENz = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143975);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new det();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((det)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavj.ENA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new det();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((det)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavj.ENB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new det();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((det)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavj.ENC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bjq();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bjq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localavj.Eri = ((bjq)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    AppMethodBeat.o(143975);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avj
 * JD-Core Version:    0.7.0.1
 */
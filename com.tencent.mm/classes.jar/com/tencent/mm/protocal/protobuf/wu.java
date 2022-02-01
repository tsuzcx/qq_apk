package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wu
  extends com.tencent.mm.bw.a
  implements czb
{
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
  
  public wu()
  {
    AppMethodBeat.i(143969);
    this.Erc = new LinkedList();
    this.Erd = new LinkedList();
    this.Ere = new LinkedList();
    AppMethodBeat.o(143969);
  }
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143970);
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
      if (this.Eri != null)
      {
        paramVarArgs.ln(11, this.Eri.computeSize());
        this.Eri.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Ret) + 0 + f.a.a.b.b.a.bx(2, this.EqZ) + f.a.a.b.b.a.bx(3, this.Era) + f.a.a.b.b.a.bx(4, this.Erb) + f.a.a.a.c(5, 8, this.Erc) + f.a.a.a.c(6, 8, this.Erd) + f.a.a.a.c(7, 8, this.Ere) + f.a.a.b.b.a.bx(8, this.Erf) + f.a.a.b.b.a.bx(9, this.Erg) + f.a.a.b.b.a.bx(10, this.Erh);
      paramInt = i;
      if (this.Eri != null) {
        paramInt = i + f.a.a.a.lm(11, this.Eri.computeSize());
      }
      AppMethodBeat.o(143970);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Erc.clear();
      this.Erd.clear();
      this.Ere.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      wu localwu = (wu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143970);
        return -1;
      case 1: 
        localwu.Ret = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143970);
        return 0;
      case 2: 
        localwu.EqZ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143970);
        return 0;
      case 3: 
        localwu.Era = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143970);
        return 0;
      case 4: 
        localwu.Erb = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143970);
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
          localwu.Erc.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
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
          localwu.Erd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
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
          localwu.Ere.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 8: 
        localwu.Erf = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143970);
        return 0;
      case 9: 
        localwu.Erg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143970);
        return 0;
      case 10: 
        localwu.Erh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143970);
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
        localwu.Eri = ((bjq)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    AppMethodBeat.o(143970);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wu
 * JD-Core Version:    0.7.0.1
 */
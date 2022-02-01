package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwh
  extends com.tencent.mm.bw.a
{
  public LinkedList<bwi> Hji;
  public LinkedList<bwi> Hjj;
  public bwi Hjk;
  public int Hjl;
  public long dCd;
  public String key;
  public int uNe;
  
  public bwh()
  {
    AppMethodBeat.i(213430);
    this.Hji = new LinkedList();
    this.Hjj = new LinkedList();
    AppMethodBeat.o(213430);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213431);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Hji);
      paramVarArgs.e(2, 8, this.Hjj);
      if (this.Hjk != null)
      {
        paramVarArgs.lJ(3, this.Hjk.computeSize());
        this.Hjk.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.uNe);
      paramVarArgs.aS(5, this.Hjl);
      paramVarArgs.aZ(6, this.dCd);
      if (this.key != null) {
        paramVarArgs.d(7, this.key);
      }
      AppMethodBeat.o(213431);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Hji) + 0 + f.a.a.a.c(2, 8, this.Hjj);
      paramInt = i;
      if (this.Hjk != null) {
        paramInt = i + f.a.a.a.lI(3, this.Hjk.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.uNe) + f.a.a.b.b.a.bz(5, this.Hjl) + f.a.a.b.b.a.p(6, this.dCd);
      paramInt = i;
      if (this.key != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.key);
      }
      AppMethodBeat.o(213431);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hji.clear();
      this.Hjj.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(213431);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bwh localbwh = (bwh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(213431);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbwh.Hji.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(213431);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbwh.Hjj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(213431);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbwh.Hjk = ((bwi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(213431);
        return 0;
      case 4: 
        localbwh.uNe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(213431);
        return 0;
      case 5: 
        localbwh.Hjl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(213431);
        return 0;
      case 6: 
        localbwh.dCd = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(213431);
        return 0;
      }
      localbwh.key = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(213431);
      return 0;
    }
    AppMethodBeat.o(213431);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwh
 * JD-Core Version:    0.7.0.1
 */
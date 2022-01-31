package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ava
  extends com.tencent.mm.bv.a
{
  public long xki;
  public long xkj;
  public LinkedList<bki> xkk;
  public int xkl;
  public LinkedList<bke> xkm;
  public int xkn;
  public int xko;
  public long xkp;
  
  public ava()
  {
    AppMethodBeat.i(152445);
    this.xki = 0L;
    this.xkj = 0L;
    this.xkk = new LinkedList();
    this.xkl = -1;
    this.xkm = new LinkedList();
    this.xkn = -1;
    this.xko = -1;
    this.xkp = 0L;
    AppMethodBeat.o(152445);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152446);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.xki);
      paramVarArgs.am(2, this.xkj);
      paramVarArgs.e(3, 8, this.xkk);
      paramVarArgs.aO(4, this.xkl);
      paramVarArgs.e(5, 8, this.xkm);
      paramVarArgs.aO(6, this.xkn);
      paramVarArgs.aO(7, this.xko);
      paramVarArgs.am(8, this.xkp);
      AppMethodBeat.o(152446);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.xki);
      i = e.a.a.b.b.a.p(2, this.xkj);
      int j = e.a.a.a.c(3, 8, this.xkk);
      int k = e.a.a.b.b.a.bl(4, this.xkl);
      int m = e.a.a.a.c(5, 8, this.xkm);
      int n = e.a.a.b.b.a.bl(6, this.xkn);
      int i1 = e.a.a.b.b.a.bl(7, this.xko);
      int i2 = e.a.a.b.b.a.p(8, this.xkp);
      AppMethodBeat.o(152446);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xkk.clear();
      this.xkm.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(152446);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ava localava = (ava)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152446);
        return -1;
      case 1: 
        localava.xki = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(152446);
        return 0;
      case 2: 
        localava.xkj = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(152446);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bki();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bki)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localava.xkk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152446);
        return 0;
      case 4: 
        localava.xkl = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(152446);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bke();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bke)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localava.xkm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152446);
        return 0;
      case 6: 
        localava.xkn = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(152446);
        return 0;
      case 7: 
        localava.xko = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(152446);
        return 0;
      }
      localava.xkp = ((e.a.a.a.a)localObject1).CLY.sm();
      AppMethodBeat.o(152446);
      return 0;
    }
    AppMethodBeat.o(152446);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ava
 * JD-Core Version:    0.7.0.1
 */
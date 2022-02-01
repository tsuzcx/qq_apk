package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dov
  extends com.tencent.mm.bw.a
{
  public int Fvs;
  public int HVI;
  public String HVJ;
  public int HVK;
  public int HVL;
  public LinkedList<dpa> HVM;
  public boolean HVN;
  public boolean dnq;
  
  public dov()
  {
    AppMethodBeat.i(153003);
    this.HVM = new LinkedList();
    AppMethodBeat.o(153003);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153004);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HVI);
      if (this.HVJ != null) {
        paramVarArgs.d(2, this.HVJ);
      }
      paramVarArgs.aS(3, this.Fvs);
      paramVarArgs.aS(4, this.HVK);
      paramVarArgs.aS(5, this.HVL);
      paramVarArgs.e(6, 8, this.HVM);
      paramVarArgs.bC(7, this.HVN);
      paramVarArgs.bC(8, this.dnq);
      AppMethodBeat.o(153004);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HVI) + 0;
      paramInt = i;
      if (this.HVJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HVJ);
      }
      i = f.a.a.b.b.a.bz(3, this.Fvs);
      int j = f.a.a.b.b.a.bz(4, this.HVK);
      int k = f.a.a.b.b.a.bz(5, this.HVL);
      int m = f.a.a.a.c(6, 8, this.HVM);
      int n = f.a.a.b.b.a.amF(7);
      int i1 = f.a.a.b.b.a.amF(8);
      AppMethodBeat.o(153004);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HVM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(153004);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dov localdov = (dov)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153004);
        return -1;
      case 1: 
        localdov.HVI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153004);
        return 0;
      case 2: 
        localdov.HVJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(153004);
        return 0;
      case 3: 
        localdov.Fvs = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153004);
        return 0;
      case 4: 
        localdov.HVK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153004);
        return 0;
      case 5: 
        localdov.HVL = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153004);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dpa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdov.HVM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153004);
        return 0;
      case 7: 
        localdov.HVN = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(153004);
        return 0;
      }
      localdov.dnq = ((f.a.a.a.a)localObject1).OmT.gvY();
      AppMethodBeat.o(153004);
      return 0;
    }
    AppMethodBeat.o(153004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dov
 * JD-Core Version:    0.7.0.1
 */
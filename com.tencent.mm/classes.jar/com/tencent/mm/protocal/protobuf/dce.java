package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dce
  extends com.tencent.mm.bw.a
{
  public String GLI;
  public long GLJ;
  public boolean HKF;
  public LinkedList<bou> HKG;
  public String dAa;
  public int index;
  public boolean sDg;
  
  public dce()
  {
    AppMethodBeat.i(177411);
    this.index = -1;
    this.HKF = false;
    this.dAa = "";
    this.GLJ = -1L;
    this.GLI = "";
    this.HKG = new LinkedList();
    this.sDg = false;
    AppMethodBeat.o(177411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.index);
      paramVarArgs.bC(2, this.HKF);
      if (this.dAa != null) {
        paramVarArgs.d(3, this.dAa);
      }
      paramVarArgs.aZ(4, this.GLJ);
      if (this.GLI != null) {
        paramVarArgs.d(5, this.GLI);
      }
      paramVarArgs.e(6, 8, this.HKG);
      paramVarArgs.bC(7, this.sDg);
      AppMethodBeat.o(177412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.index) + 0 + f.a.a.b.b.a.amF(2);
      paramInt = i;
      if (this.dAa != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dAa);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.GLJ);
      paramInt = i;
      if (this.GLI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GLI);
      }
      i = f.a.a.a.c(6, 8, this.HKG);
      int j = f.a.a.b.b.a.amF(7);
      AppMethodBeat.o(177412);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HKG.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(177412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dce localdce = (dce)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(177412);
        return -1;
      case 1: 
        localdce.index = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(177412);
        return 0;
      case 2: 
        localdce.HKF = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(177412);
        return 0;
      case 3: 
        localdce.dAa = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 4: 
        localdce.GLJ = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(177412);
        return 0;
      case 5: 
        localdce.GLI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bou();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bou)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdce.HKG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(177412);
        return 0;
      }
      localdce.sDg = ((f.a.a.a.a)localObject1).OmT.gvY();
      AppMethodBeat.o(177412);
      return 0;
    }
    AppMethodBeat.o(177412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dce
 * JD-Core Version:    0.7.0.1
 */
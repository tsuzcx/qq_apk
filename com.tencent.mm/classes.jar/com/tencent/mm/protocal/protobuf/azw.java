package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class azw
  extends com.tencent.mm.bw.a
{
  public int GQc;
  public int GQd;
  public int GQe;
  public int GqC;
  public int GqD;
  public int GqE;
  public b GqG;
  public bop GqH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143973);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GqC);
      paramVarArgs.aS(2, this.GqD);
      paramVarArgs.aS(3, this.GqE);
      if (this.GqG != null) {
        paramVarArgs.c(4, this.GqG);
      }
      paramVarArgs.aS(5, this.GQc);
      paramVarArgs.aS(6, this.GQd);
      paramVarArgs.aS(7, this.GQe);
      if (this.GqH != null)
      {
        paramVarArgs.lJ(8, this.GqH.computeSize());
        this.GqH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GqC) + 0 + f.a.a.b.b.a.bz(2, this.GqD) + f.a.a.b.b.a.bz(3, this.GqE);
      paramInt = i;
      if (this.GqG != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GqG);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GQc) + f.a.a.b.b.a.bz(6, this.GQd) + f.a.a.b.b.a.bz(7, this.GQe);
      paramInt = i;
      if (this.GqH != null) {
        paramInt = i + f.a.a.a.lI(8, this.GqH.computeSize());
      }
      AppMethodBeat.o(143973);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      azw localazw = (azw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143973);
        return -1;
      case 1: 
        localazw.GqC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143973);
        return 0;
      case 2: 
        localazw.GqD = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143973);
        return 0;
      case 3: 
        localazw.GqE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143973);
        return 0;
      case 4: 
        localazw.GqG = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(143973);
        return 0;
      case 5: 
        localazw.GQc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143973);
        return 0;
      case 6: 
        localazw.GQd = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143973);
        return 0;
      case 7: 
        localazw.GQe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143973);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bop();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bop)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localazw.GqH = ((bop)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    AppMethodBeat.o(143973);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azw
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class azg
  extends com.tencent.mm.bx.a
{
  public int FYd;
  public int FYe;
  public int FYf;
  public b FYh;
  public bnx FYi;
  public int GwC;
  public int GwD;
  public int GwE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143973);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FYd);
      paramVarArgs.aS(2, this.FYe);
      paramVarArgs.aS(3, this.FYf);
      if (this.FYh != null) {
        paramVarArgs.c(4, this.FYh);
      }
      paramVarArgs.aS(5, this.GwC);
      paramVarArgs.aS(6, this.GwD);
      paramVarArgs.aS(7, this.GwE);
      if (this.FYi != null)
      {
        paramVarArgs.lC(8, this.FYi.computeSize());
        this.FYi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FYd) + 0 + f.a.a.b.b.a.bz(2, this.FYe) + f.a.a.b.b.a.bz(3, this.FYf);
      paramInt = i;
      if (this.FYh != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.FYh);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GwC) + f.a.a.b.b.a.bz(6, this.GwD) + f.a.a.b.b.a.bz(7, this.GwE);
      paramInt = i;
      if (this.FYi != null) {
        paramInt = i + f.a.a.a.lB(8, this.FYi.computeSize());
      }
      AppMethodBeat.o(143973);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      azg localazg = (azg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143973);
        return -1;
      case 1: 
        localazg.FYd = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143973);
        return 0;
      case 2: 
        localazg.FYe = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143973);
        return 0;
      case 3: 
        localazg.FYf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143973);
        return 0;
      case 4: 
        localazg.FYh = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(143973);
        return 0;
      case 5: 
        localazg.GwC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143973);
        return 0;
      case 6: 
        localazg.GwD = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143973);
        return 0;
      case 7: 
        localazg.GwE = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143973);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bnx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bnx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localazg.FYi = ((bnx)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azg
 * JD-Core Version:    0.7.0.1
 */
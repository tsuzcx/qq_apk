package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gd
  extends com.tencent.mm.bx.a
{
  public int Fyi;
  public int Fyj;
  public int Fyq;
  public ge Fyr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32120);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Fyi);
      paramVarArgs.aS(2, this.Fyj);
      paramVarArgs.aS(3, this.Fyq);
      if (this.Fyr != null)
      {
        paramVarArgs.lC(4, this.Fyr.computeSize());
        this.Fyr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Fyi) + 0 + f.a.a.b.b.a.bz(2, this.Fyj) + f.a.a.b.b.a.bz(3, this.Fyq);
      paramInt = i;
      if (this.Fyr != null) {
        paramInt = i + f.a.a.a.lB(4, this.Fyr.computeSize());
      }
      AppMethodBeat.o(32120);
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
      AppMethodBeat.o(32120);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      gd localgd = (gd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32120);
        return -1;
      case 1: 
        localgd.Fyi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32120);
        return 0;
      case 2: 
        localgd.Fyj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32120);
        return 0;
      case 3: 
        localgd.Fyq = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32120);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ge();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ge)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localgd.Fyr = ((ge)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    AppMethodBeat.o(32120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gd
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmx
  extends com.tencent.mm.bw.a
{
  public String FUn;
  public boolean HyX;
  public dfk HyY;
  public dfk HyZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91632);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.HyX);
      if (this.HyY != null)
      {
        paramVarArgs.lJ(2, this.HyY.computeSize());
        this.HyY.writeFields(paramVarArgs);
      }
      if (this.HyZ != null)
      {
        paramVarArgs.lJ(3, this.HyZ.computeSize());
        this.HyZ.writeFields(paramVarArgs);
      }
      if (this.FUn != null) {
        paramVarArgs.d(4, this.FUn);
      }
      AppMethodBeat.o(91632);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.amF(1) + 0;
      paramInt = i;
      if (this.HyY != null) {
        paramInt = i + f.a.a.a.lI(2, this.HyY.computeSize());
      }
      i = paramInt;
      if (this.HyZ != null) {
        i = paramInt + f.a.a.a.lI(3, this.HyZ.computeSize());
      }
      paramInt = i;
      if (this.FUn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FUn);
      }
      AppMethodBeat.o(91632);
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
      AppMethodBeat.o(91632);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cmx localcmx = (cmx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91632);
        return -1;
      case 1: 
        localcmx.HyX = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(91632);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmx.HyY = ((dfk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91632);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmx.HyZ = ((dfk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91632);
        return 0;
      }
      localcmx.FUn = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(91632);
      return 0;
    }
    AppMethodBeat.o(91632);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmx
 * JD-Core Version:    0.7.0.1
 */
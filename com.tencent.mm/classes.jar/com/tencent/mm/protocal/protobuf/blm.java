package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blm
  extends com.tencent.mm.bx.a
{
  public int DJo = 0;
  public bsy DJp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DJo);
      if (this.DJp != null)
      {
        paramVarArgs.kX(2, this.DJp.computeSize());
        this.DJp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195471);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DJo) + 0;
      paramInt = i;
      if (this.DJp != null) {
        paramInt = i + f.a.a.a.kW(2, this.DJp.computeSize());
      }
      AppMethodBeat.o(195471);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(195471);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      blm localblm = (blm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(195471);
        return -1;
      case 1: 
        localblm.DJo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(195471);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bsy();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bsy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localblm.DJp = ((bsy)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(195471);
      return 0;
    }
    AppMethodBeat.o(195471);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blm
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cox
  extends com.tencent.mm.bx.a
{
  public aq aavP;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32256);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.scene);
      if (this.aavP != null)
      {
        paramVarArgs.qD(2, this.aavP.computeSize());
        this.aavP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32256);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.scene) + 0;
      paramInt = i;
      if (this.aavP != null) {
        paramInt = i + i.a.a.a.qC(2, this.aavP.computeSize());
      }
      AppMethodBeat.o(32256);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32256);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cox localcox = (cox)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32256);
        return -1;
      case 1: 
        localcox.scene = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32256);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        aq localaq = new aq();
        if ((localObject != null) && (localObject.length > 0)) {
          localaq.parseFrom((byte[])localObject);
        }
        localcox.aavP = localaq;
        paramInt += 1;
      }
      AppMethodBeat.o(32256);
      return 0;
    }
    AppMethodBeat.o(32256);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cox
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eir
  extends com.tencent.mm.bx.a
{
  public long abnB;
  public long abnC;
  public efh abnD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258639);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.abnB);
      paramVarArgs.bv(2, this.abnC);
      if (this.abnD != null)
      {
        paramVarArgs.qD(3, this.abnD.computeSize());
        this.abnD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258639);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.abnB) + 0 + i.a.a.b.b.a.q(2, this.abnC);
      paramInt = i;
      if (this.abnD != null) {
        paramInt = i + i.a.a.a.qC(3, this.abnD.computeSize());
      }
      AppMethodBeat.o(258639);
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
      AppMethodBeat.o(258639);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      eir localeir = (eir)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258639);
        return -1;
      case 1: 
        localeir.abnB = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258639);
        return 0;
      case 2: 
        localeir.abnC = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258639);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        efh localefh = new efh();
        if ((localObject != null) && (localObject.length > 0)) {
          localefh.parseFrom((byte[])localObject);
        }
        localeir.abnD = localefh;
        paramInt += 1;
      }
      AppMethodBeat.o(258639);
      return 0;
    }
    AppMethodBeat.o(258639);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eir
 * JD-Core Version:    0.7.0.1
 */
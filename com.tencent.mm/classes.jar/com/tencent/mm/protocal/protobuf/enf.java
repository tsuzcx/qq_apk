package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class enf
  extends com.tencent.mm.bx.a
{
  public long aaxM;
  public acz aaxN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50102);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaxM);
      if (this.aaxN != null)
      {
        paramVarArgs.qD(2, this.aaxN.computeSize());
        this.aaxN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(50102);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.aaxM) + 0;
      paramInt = i;
      if (this.aaxN != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaxN.computeSize());
      }
      AppMethodBeat.o(50102);
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
      AppMethodBeat.o(50102);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      enf localenf = (enf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(50102);
        return -1;
      case 1: 
        localenf.aaxM = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(50102);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        acz localacz = new acz();
        if ((localObject != null) && (localObject.length > 0)) {
          localacz.parseFrom((byte[])localObject);
        }
        localenf.aaxN = localacz;
        paramInt += 1;
      }
      AppMethodBeat.o(50102);
      return 0;
    }
    AppMethodBeat.o(50102);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enf
 * JD-Core Version:    0.7.0.1
 */
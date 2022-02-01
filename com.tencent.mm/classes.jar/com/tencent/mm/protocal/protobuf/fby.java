package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fby
  extends com.tencent.mm.bx.a
{
  public int DnR;
  public etj abBz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259322);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.DnR);
      if (this.abBz != null)
      {
        paramVarArgs.qD(2, this.abBz.computeSize());
        this.abBz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259322);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.DnR) + 0;
      paramInt = i;
      if (this.abBz != null) {
        paramInt = i + i.a.a.a.qC(2, this.abBz.computeSize());
      }
      AppMethodBeat.o(259322);
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
      AppMethodBeat.o(259322);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fby localfby = (fby)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259322);
        return -1;
      case 1: 
        localfby.DnR = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259322);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        etj localetj = new etj();
        if ((localObject != null) && (localObject.length > 0)) {
          localetj.parseFrom((byte[])localObject);
        }
        localfby.abBz = localetj;
        paramInt += 1;
      }
      AppMethodBeat.o(259322);
      return 0;
    }
    AppMethodBeat.o(259322);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fby
 * JD-Core Version:    0.7.0.1
 */
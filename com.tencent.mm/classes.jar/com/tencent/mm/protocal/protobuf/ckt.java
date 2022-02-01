package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ckt
  extends com.tencent.mm.bx.a
{
  public cyx YNl;
  public int aasS;
  public int aasT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82410);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YNl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Device");
        AppMethodBeat.o(82410);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.aasS);
      paramVarArgs.bS(2, this.aasT);
      if (this.YNl != null)
      {
        paramVarArgs.qD(3, this.YNl.computeSize());
        this.YNl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aasS) + 0 + i.a.a.b.b.a.cJ(2, this.aasT);
      paramInt = i;
      if (this.YNl != null) {
        paramInt = i + i.a.a.a.qC(3, this.YNl.computeSize());
      }
      AppMethodBeat.o(82410);
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
      if (this.YNl == null)
      {
        paramVarArgs = new b("Not all required fields were included: Device");
        AppMethodBeat.o(82410);
        throw paramVarArgs;
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ckt localckt = (ckt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82410);
        return -1;
      case 1: 
        localckt.aasS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(82410);
        return 0;
      case 2: 
        localckt.aasT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(82410);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        cyx localcyx = new cyx();
        if ((localObject != null) && (localObject.length > 0)) {
          localcyx.parseFrom((byte[])localObject);
        }
        localckt.YNl = localcyx;
        paramInt += 1;
      }
      AppMethodBeat.o(82410);
      return 0;
    }
    AppMethodBeat.o(82410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckt
 * JD-Core Version:    0.7.0.1
 */
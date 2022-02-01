package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class geb
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public int acbJ;
  public gef acbK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260035);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.acbJ);
      if (this.IGU != null) {
        paramVarArgs.g(2, this.IGU);
      }
      if (this.acbK != null)
      {
        paramVarArgs.qD(3, this.acbK.computeSize());
        this.acbK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260035);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.acbJ) + 0;
      paramInt = i;
      if (this.IGU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGU);
      }
      i = paramInt;
      if (this.acbK != null) {
        i = paramInt + i.a.a.a.qC(3, this.acbK.computeSize());
      }
      AppMethodBeat.o(260035);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260035);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      geb localgeb = (geb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260035);
        return -1;
      case 1: 
        localgeb.acbJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260035);
        return 0;
      case 2: 
        localgeb.IGU = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(260035);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        gef localgef = new gef();
        if ((localObject != null) && (localObject.length > 0)) {
          localgef.parseFrom((byte[])localObject);
        }
        localgeb.acbK = localgef;
        paramInt += 1;
      }
      AppMethodBeat.o(260035);
      return 0;
    }
    AppMethodBeat.o(260035);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.geb
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gbh
  extends com.tencent.mm.bx.a
{
  public gol YLa;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115909);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YLa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115909);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.vhJ);
      if (this.YLa != null)
      {
        paramVarArgs.qD(2, this.YLa.computeSize());
        this.YLa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115909);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0;
      paramInt = i;
      if (this.YLa != null) {
        paramInt = i + i.a.a.a.qC(2, this.YLa.computeSize());
      }
      AppMethodBeat.o(115909);
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
      if (this.YLa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115909);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115909);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gbh localgbh = (gbh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115909);
        return -1;
      case 1: 
        localgbh.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115909);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        gol localgol = new gol();
        if ((localObject != null) && (localObject.length > 0)) {
          localgol.dg((byte[])localObject);
        }
        localgbh.YLa = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(115909);
      return 0;
    }
    AppMethodBeat.o(115909);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbh
 * JD-Core Version:    0.7.0.1
 */
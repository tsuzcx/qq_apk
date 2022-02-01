package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apw
  extends com.tencent.mm.cd.a
{
  public blj SDl;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198300);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.SDl != null)
      {
        paramVarArgs.oE(2, this.SDl.computeSize());
        this.SDl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(198300);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.SDl != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDl.computeSize());
      }
      AppMethodBeat.o(198300);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(198300);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      apw localapw = (apw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(198300);
        return -1;
      case 1: 
        localapw.type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(198300);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        blj localblj = new blj();
        if ((localObject != null) && (localObject.length > 0)) {
          localblj.parseFrom((byte[])localObject);
        }
        localapw.SDl = localblj;
        paramInt += 1;
      }
      AppMethodBeat.o(198300);
      return 0;
    }
    AppMethodBeat.o(198300);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apw
 * JD-Core Version:    0.7.0.1
 */
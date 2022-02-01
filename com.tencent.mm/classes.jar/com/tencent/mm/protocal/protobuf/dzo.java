package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzo
  extends com.tencent.mm.cd.a
{
  public int UeZ;
  public LinkedList<dzn> Ufa;
  
  public dzo()
  {
    AppMethodBeat.i(259089);
    this.Ufa = new LinkedList();
    AppMethodBeat.o(259089);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259091);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UeZ);
      paramVarArgs.e(2, 8, this.Ufa);
      AppMethodBeat.o(259091);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.UeZ);
      i = g.a.a.a.c(2, 8, this.Ufa);
      AppMethodBeat.o(259091);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ufa.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(259091);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dzo localdzo = (dzo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259091);
        return -1;
      case 1: 
        localdzo.UeZ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(259091);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dzn localdzn = new dzn();
        if ((localObject != null) && (localObject.length > 0)) {
          localdzn.parseFrom((byte[])localObject);
        }
        localdzo.Ufa.add(localdzn);
        paramInt += 1;
      }
      AppMethodBeat.o(259091);
      return 0;
    }
    AppMethodBeat.o(259091);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzo
 * JD-Core Version:    0.7.0.1
 */
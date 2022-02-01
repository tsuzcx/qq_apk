package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ah
  extends com.tencent.mm.bx.a
{
  public int YAO;
  public LinkedList<fdn> YAP;
  
  public ah()
  {
    AppMethodBeat.i(125686);
    this.YAP = new LinkedList();
    AppMethodBeat.o(125686);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125687);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YAO);
      paramVarArgs.e(2, 8, this.YAP);
      AppMethodBeat.o(125687);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YAO);
      i = i.a.a.a.c(2, 8, this.YAP);
      AppMethodBeat.o(125687);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YAP.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125687);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ah localah = (ah)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125687);
        return -1;
      case 1: 
        localah.YAO = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125687);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fdn localfdn = new fdn();
        if ((localObject != null) && (localObject.length > 0)) {
          localfdn.parseFrom((byte[])localObject);
        }
        localah.YAP.add(localfdn);
        paramInt += 1;
      }
      AppMethodBeat.o(125687);
      return 0;
    }
    AppMethodBeat.o(125687);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ah
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class djd
  extends com.tencent.mm.bx.a
{
  public int YGJ;
  public LinkedList<zi> YGK;
  
  public djd()
  {
    AppMethodBeat.i(260017);
    this.YGK = new LinkedList();
    AppMethodBeat.o(260017);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260021);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YGJ);
      paramVarArgs.e(2, 8, this.YGK);
      AppMethodBeat.o(260021);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YGJ);
      i = i.a.a.a.c(2, 8, this.YGK);
      AppMethodBeat.o(260021);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YGK.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260021);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      djd localdjd = (djd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260021);
        return -1;
      case 1: 
        localdjd.YGJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260021);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        zi localzi = new zi();
        if ((localObject != null) && (localObject.length > 0)) {
          localzi.parseFrom((byte[])localObject);
        }
        localdjd.YGK.add(localzi);
        paramInt += 1;
      }
      AppMethodBeat.o(260021);
      return 0;
    }
    AppMethodBeat.o(260021);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djd
 * JD-Core Version:    0.7.0.1
 */
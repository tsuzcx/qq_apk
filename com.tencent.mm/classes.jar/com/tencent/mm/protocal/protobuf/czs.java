package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czs
  extends com.tencent.mm.bx.a
{
  public LinkedList<czr> aaFi;
  public int cZV;
  
  public czs()
  {
    AppMethodBeat.i(122508);
    this.aaFi = new LinkedList();
    this.cZV = -1;
    AppMethodBeat.o(122508);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122509);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aaFi);
      paramVarArgs.bS(2, this.cZV);
      AppMethodBeat.o(122509);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.aaFi);
      i = i.a.a.b.b.a.cJ(2, this.cZV);
      AppMethodBeat.o(122509);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaFi.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(122509);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      czs localczs = (czs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122509);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          czr localczr = new czr();
          if ((localObject != null) && (localObject.length > 0)) {
            localczr.parseFrom((byte[])localObject);
          }
          localczs.aaFi.add(localczr);
          paramInt += 1;
        }
        AppMethodBeat.o(122509);
        return 0;
      }
      localczs.cZV = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(122509);
      return 0;
    }
    AppMethodBeat.o(122509);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czs
 * JD-Core Version:    0.7.0.1
 */
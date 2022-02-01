package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ze
  extends com.tencent.mm.bx.a
{
  public LinkedList<dl> PmC;
  public String ZhJ;
  
  public ze()
  {
    AppMethodBeat.i(257957);
    this.PmC = new LinkedList();
    AppMethodBeat.o(257957);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257960);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.PmC);
      if (this.ZhJ != null) {
        paramVarArgs.g(2, this.ZhJ);
      }
      AppMethodBeat.o(257960);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.PmC) + 0;
      paramInt = i;
      if (this.ZhJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZhJ);
      }
      AppMethodBeat.o(257960);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.PmC.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257960);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ze localze = (ze)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257960);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dl localdl = new dl();
          if ((localObject != null) && (localObject.length > 0)) {
            localdl.parseFrom((byte[])localObject);
          }
          localze.PmC.add(localdl);
          paramInt += 1;
        }
        AppMethodBeat.o(257960);
        return 0;
      }
      localze.ZhJ = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(257960);
      return 0;
    }
    AppMethodBeat.o(257960);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ze
 * JD-Core Version:    0.7.0.1
 */
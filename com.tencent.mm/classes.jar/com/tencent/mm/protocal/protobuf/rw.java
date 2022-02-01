package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rw
  extends com.tencent.mm.bx.a
{
  public String YWI;
  public LinkedList<eje> YWJ;
  
  public rw()
  {
    AppMethodBeat.i(257501);
    this.YWJ = new LinkedList();
    AppMethodBeat.o(257501);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257507);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YWI != null) {
        paramVarArgs.g(1, this.YWI);
      }
      paramVarArgs.e(2, 8, this.YWJ);
      AppMethodBeat.o(257507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YWI == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.YWI) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.YWJ);
      AppMethodBeat.o(257507);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YWJ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257507);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        rw localrw = (rw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257507);
          return -1;
        case 1: 
          localrw.YWI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257507);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eje localeje = new eje();
          if ((localObject != null) && (localObject.length > 0)) {
            localeje.parseFrom((byte[])localObject);
          }
          localrw.YWJ.add(localeje);
          paramInt += 1;
        }
        AppMethodBeat.o(257507);
        return 0;
      }
      AppMethodBeat.o(257507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rw
 * JD-Core Version:    0.7.0.1
 */
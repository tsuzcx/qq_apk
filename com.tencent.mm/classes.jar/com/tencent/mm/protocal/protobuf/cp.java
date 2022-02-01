package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cp
  extends com.tencent.mm.bx.a
{
  public dfn YEV;
  public LinkedList<dfo> YEW;
  
  public cp()
  {
    AppMethodBeat.i(116325);
    this.YEW = new LinkedList();
    AppMethodBeat.o(116325);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116326);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YEV == null)
      {
        paramVarArgs = new b("Not all required fields were included: LogHead");
        AppMethodBeat.o(116326);
        throw paramVarArgs;
      }
      if (this.YEV != null)
      {
        paramVarArgs.qD(1, this.YEV.computeSize());
        this.YEV.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YEW);
      AppMethodBeat.o(116326);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YEV == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = i.a.a.a.qC(1, this.YEV.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.YEW);
      AppMethodBeat.o(116326);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YEW.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YEV == null)
        {
          paramVarArgs = new b("Not all required fields were included: LogHead");
          AppMethodBeat.o(116326);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116326);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cp localcp = (cp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116326);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfn)localObject2).parseFrom((byte[])localObject1);
            }
            localcp.YEV = ((dfn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116326);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dfo)localObject2).parseFrom((byte[])localObject1);
          }
          localcp.YEW.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(116326);
        return 0;
      }
      AppMethodBeat.o(116326);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cp
 * JD-Core Version:    0.7.0.1
 */
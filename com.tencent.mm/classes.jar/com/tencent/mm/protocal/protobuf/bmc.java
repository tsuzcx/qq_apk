package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmc
  extends com.tencent.mm.cd.a
{
  public LinkedList<aib> EyF;
  public String title;
  
  public bmc()
  {
    AppMethodBeat.i(212871);
    this.EyF = new LinkedList();
    AppMethodBeat.o(212871);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212873);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      paramVarArgs.e(2, 8, this.EyF);
      AppMethodBeat.o(212873);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.title) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.EyF);
      AppMethodBeat.o(212873);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EyF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(212873);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bmc localbmc = (bmc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212873);
          return -1;
        case 1: 
          localbmc.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(212873);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aib localaib = new aib();
          if ((localObject != null) && (localObject.length > 0)) {
            localaib.parseFrom((byte[])localObject);
          }
          localbmc.EyF.add(localaib);
          paramInt += 1;
        }
        AppMethodBeat.o(212873);
        return 0;
      }
      AppMethodBeat.o(212873);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmc
 * JD-Core Version:    0.7.0.1
 */
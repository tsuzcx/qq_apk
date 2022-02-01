package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class as
  extends com.tencent.mm.bx.a
{
  public String TpV;
  public LinkedList<ao> TpW;
  
  public as()
  {
    AppMethodBeat.i(289931);
    this.TpW = new LinkedList();
    AppMethodBeat.o(289931);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289942);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.TpV != null) {
        paramVarArgs.g(1, this.TpV);
      }
      paramVarArgs.e(2, 8, this.TpW);
      AppMethodBeat.o(289942);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TpV == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.TpV) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.TpW);
      AppMethodBeat.o(289942);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TpW.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289942);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        as localas = (as)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(289942);
          return -1;
        case 1: 
          localas.TpV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289942);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ao localao = new ao();
          if ((localObject != null) && (localObject.length > 0)) {
            localao.parseFrom((byte[])localObject);
          }
          localas.TpW.add(localao);
          paramInt += 1;
        }
        AppMethodBeat.o(289942);
        return 0;
      }
      AppMethodBeat.o(289942);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.as
 * JD-Core Version:    0.7.0.1
 */
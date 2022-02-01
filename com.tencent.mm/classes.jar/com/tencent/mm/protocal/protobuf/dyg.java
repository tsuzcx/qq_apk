package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyg
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> EHU;
  public String key;
  
  public dyg()
  {
    AppMethodBeat.i(198791);
    this.EHU = new LinkedList();
    AppMethodBeat.o(198791);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198792);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(198792);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      paramVarArgs.e(2, 1, this.EHU);
      AppMethodBeat.o(198792);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.EHU);
      AppMethodBeat.o(198792);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EHU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(198792);
          throw paramVarArgs;
        }
        AppMethodBeat.o(198792);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dyg localdyg = (dyg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(198792);
          return -1;
        case 1: 
          localdyg.key = locala.LVo.readString();
          AppMethodBeat.o(198792);
          return 0;
        }
        localdyg.EHU.add(locala.LVo.readString());
        AppMethodBeat.o(198792);
        return 0;
      }
      AppMethodBeat.o(198792);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyg
 * JD-Core Version:    0.7.0.1
 */
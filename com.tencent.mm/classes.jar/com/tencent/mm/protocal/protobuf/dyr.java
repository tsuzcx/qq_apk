package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class dyr
  extends com.tencent.mm.bw.a
{
  public String GeU;
  public LinkedList<String> GeV;
  
  public dyr()
  {
    AppMethodBeat.i(189320);
    this.GeV = new LinkedList();
    AppMethodBeat.o(189320);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189321);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GeU != null) {
        paramVarArgs.d(1, this.GeU);
      }
      paramVarArgs.e(2, 1, this.GeV);
      AppMethodBeat.o(189321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GeU == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.GeU) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.GeV);
      AppMethodBeat.o(189321);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GeV.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(189321);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dyr localdyr = (dyr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(189321);
          return -1;
        case 1: 
          localdyr.GeU = locala.LVo.readString();
          AppMethodBeat.o(189321);
          return 0;
        }
        localdyr.GeV.add(locala.LVo.readString());
        AppMethodBeat.o(189321);
        return 0;
      }
      AppMethodBeat.o(189321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyr
 * JD-Core Version:    0.7.0.1
 */
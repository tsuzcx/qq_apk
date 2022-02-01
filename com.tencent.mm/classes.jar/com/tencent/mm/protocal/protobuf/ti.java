package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ti
  extends com.tencent.mm.bw.a
{
  public String LbV;
  public LinkedList<String> LbW;
  
  public ti()
  {
    AppMethodBeat.i(72427);
    this.LbW = new LinkedList();
    AppMethodBeat.o(72427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72428);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LbV != null) {
        paramVarArgs.e(1, this.LbV);
      }
      paramVarArgs.e(2, 1, this.LbW);
      AppMethodBeat.o(72428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LbV == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.LbV) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.LbW);
      AppMethodBeat.o(72428);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LbW.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72428);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ti localti = (ti)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72428);
          return -1;
        case 1: 
          localti.LbV = locala.UbS.readString();
          AppMethodBeat.o(72428);
          return 0;
        }
        localti.LbW.add(locala.UbS.readString());
        AppMethodBeat.o(72428);
        return 0;
      }
      AppMethodBeat.o(72428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ti
 * JD-Core Version:    0.7.0.1
 */
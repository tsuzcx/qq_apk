package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbp
  extends com.tencent.mm.bw.a
{
  public int LKV;
  public LinkedList<String> LKW;
  public String path;
  
  public bbp()
  {
    AppMethodBeat.i(209657);
    this.LKW = new LinkedList();
    AppMethodBeat.o(209657);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209658);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.path != null) {
        paramVarArgs.e(1, this.path);
      }
      paramVarArgs.aM(2, this.LKV);
      paramVarArgs.e(3, 1, this.LKW);
      AppMethodBeat.o(209658);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.path) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LKV);
      int j = g.a.a.a.c(3, 1, this.LKW);
      AppMethodBeat.o(209658);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LKW.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209658);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bbp localbbp = (bbp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209658);
          return -1;
        case 1: 
          localbbp.path = locala.UbS.readString();
          AppMethodBeat.o(209658);
          return 0;
        case 2: 
          localbbp.LKV = locala.UbS.zi();
          AppMethodBeat.o(209658);
          return 0;
        }
        localbbp.LKW.add(locala.UbS.readString());
        AppMethodBeat.o(209658);
        return 0;
      }
      AppMethodBeat.o(209658);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbp
 * JD-Core Version:    0.7.0.1
 */
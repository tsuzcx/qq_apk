package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eku
  extends com.tencent.mm.bw.a
{
  public int LGr;
  public LinkedList<String> LGs;
  public String path;
  
  public eku()
  {
    AppMethodBeat.i(224430);
    this.LGs = new LinkedList();
    AppMethodBeat.o(224430);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(224431);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.path != null) {
        paramVarArgs.d(1, this.path);
      }
      paramVarArgs.aS(2, this.LGr);
      paramVarArgs.e(3, 1, this.LGs);
      AppMethodBeat.o(224431);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.path) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.LGr);
      int j = f.a.a.a.c(3, 1, this.LGs);
      AppMethodBeat.o(224431);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LGs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(224431);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eku localeku = (eku)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(224431);
          return -1;
        case 1: 
          localeku.path = locala.OmT.readString();
          AppMethodBeat.o(224431);
          return 0;
        case 2: 
          localeku.LGr = locala.OmT.zc();
          AppMethodBeat.o(224431);
          return 0;
        }
        localeku.LGs.add(locala.OmT.readString());
        AppMethodBeat.o(224431);
        return 0;
      }
      AppMethodBeat.o(224431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eku
 * JD-Core Version:    0.7.0.1
 */
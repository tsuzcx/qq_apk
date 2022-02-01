package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class efx
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> GKl;
  public String key;
  
  public efx()
  {
    AppMethodBeat.i(208565);
    this.GKl = new LinkedList();
    AppMethodBeat.o(208565);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208566);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(208566);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      paramVarArgs.e(2, 1, this.GKl);
      AppMethodBeat.o(208566);
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
      int i = f.a.a.a.c(2, 1, this.GKl);
      AppMethodBeat.o(208566);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GKl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(208566);
          throw paramVarArgs;
        }
        AppMethodBeat.o(208566);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        efx localefx = (efx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(208566);
          return -1;
        case 1: 
          localefx.key = locala.OmT.readString();
          AppMethodBeat.o(208566);
          return 0;
        }
        localefx.GKl.add(locala.OmT.readString());
        AppMethodBeat.o(208566);
        return 0;
      }
      AppMethodBeat.o(208566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efx
 * JD-Core Version:    0.7.0.1
 */
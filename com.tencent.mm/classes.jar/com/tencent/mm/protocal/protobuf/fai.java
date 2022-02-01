package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fai
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> LOe;
  public String key;
  
  public fai()
  {
    AppMethodBeat.i(224548);
    this.LOe = new LinkedList();
    AppMethodBeat.o(224548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(224549);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(224549);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.e(1, this.key);
      }
      paramVarArgs.e(2, 1, this.LOe);
      AppMethodBeat.o(224549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = g.a.a.b.b.a.f(1, this.key) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.LOe);
      AppMethodBeat.o(224549);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LOe.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(224549);
          throw paramVarArgs;
        }
        AppMethodBeat.o(224549);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fai localfai = (fai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(224549);
          return -1;
        case 1: 
          localfai.key = locala.UbS.readString();
          AppMethodBeat.o(224549);
          return 0;
        }
        localfai.LOe.add(locala.UbS.readString());
        AppMethodBeat.o(224549);
        return 0;
      }
      AppMethodBeat.o(224549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fai
 * JD-Core Version:    0.7.0.1
 */
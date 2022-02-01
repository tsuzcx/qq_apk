package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cx
  extends com.tencent.mm.bx.a
{
  public String dvs;
  public LinkedList<String> uxr;
  
  public cx()
  {
    AppMethodBeat.i(186963);
    this.uxr = new LinkedList();
    AppMethodBeat.o(186963);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvs != null) {
        paramVarArgs.d(1, this.dvs);
      }
      paramVarArgs.e(2, 1, this.uxr);
      AppMethodBeat.o(186964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dvs == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.dvs) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.uxr);
      AppMethodBeat.o(186964);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uxr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(186964);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cx localcx = (cx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(186964);
          return -1;
        case 1: 
          localcx.dvs = locala.NPN.readString();
          AppMethodBeat.o(186964);
          return 0;
        }
        localcx.uxr.add(locala.NPN.readString());
        AppMethodBeat.o(186964);
        return 0;
      }
      AppMethodBeat.o(186964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cx
 * JD-Core Version:    0.7.0.1
 */
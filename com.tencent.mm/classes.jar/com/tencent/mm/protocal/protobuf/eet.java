package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class eet
  extends com.tencent.mm.bx.a
{
  public String HQa;
  public LinkedList<String> HQb;
  
  public eet()
  {
    AppMethodBeat.i(208997);
    this.HQb = new LinkedList();
    AppMethodBeat.o(208997);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208998);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HQa != null) {
        paramVarArgs.d(1, this.HQa);
      }
      paramVarArgs.e(2, 1, this.HQb);
      AppMethodBeat.o(208998);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HQa == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.HQa) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 1, this.HQb);
      AppMethodBeat.o(208998);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HQb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(208998);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eet localeet = (eet)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(208998);
          return -1;
        case 1: 
          localeet.HQa = locala.NPN.readString();
          AppMethodBeat.o(208998);
          return 0;
        }
        localeet.HQb.add(locala.NPN.readString());
        AppMethodBeat.o(208998);
        return 0;
      }
      AppMethodBeat.o(208998);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eet
 * JD-Core Version:    0.7.0.1
 */
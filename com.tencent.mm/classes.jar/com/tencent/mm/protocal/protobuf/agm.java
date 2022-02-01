package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agm
  extends com.tencent.mm.bx.a
{
  public String ZpI;
  public LinkedList<vt> nUC;
  
  public agm()
  {
    AppMethodBeat.i(259576);
    this.nUC = new LinkedList();
    AppMethodBeat.o(259576);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259578);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZpI != null) {
        paramVarArgs.g(1, this.ZpI);
      }
      paramVarArgs.e(2, 8, this.nUC);
      AppMethodBeat.o(259578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZpI == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZpI) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.nUC);
      AppMethodBeat.o(259578);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259578);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        agm localagm = (agm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259578);
          return -1;
        case 1: 
          localagm.ZpI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259578);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          vt localvt = new vt();
          if ((localObject != null) && (localObject.length > 0)) {
            localvt.parseFrom((byte[])localObject);
          }
          localagm.nUC.add(localvt);
          paramInt += 1;
        }
        AppMethodBeat.o(259578);
        return 0;
      }
      AppMethodBeat.o(259578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agm
 * JD-Core Version:    0.7.0.1
 */
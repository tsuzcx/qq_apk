package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class od
  extends com.tencent.mm.bx.a
{
  public String CLG;
  public LinkedList<cdt> CLH;
  
  public od()
  {
    AppMethodBeat.i(195462);
    this.CLH = new LinkedList();
    AppMethodBeat.o(195462);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195463);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CLG != null) {
        paramVarArgs.d(1, this.CLG);
      }
      paramVarArgs.e(2, 8, this.CLH);
      AppMethodBeat.o(195463);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLG == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.CLG) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.CLH);
      AppMethodBeat.o(195463);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CLH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(195463);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        od localod = (od)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195463);
          return -1;
        case 1: 
          localod.CLG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(195463);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cdt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localod.CLH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195463);
        return 0;
      }
      AppMethodBeat.o(195463);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.od
 * JD-Core Version:    0.7.0.1
 */
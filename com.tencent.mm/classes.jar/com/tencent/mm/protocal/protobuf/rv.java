package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class rv
  extends com.tencent.mm.bx.a
{
  public LinkedList<dii> CSE;
  public b CSF;
  public b CSG;
  
  public rv()
  {
    AppMethodBeat.i(117854);
    this.CSE = new LinkedList();
    AppMethodBeat.o(117854);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117855);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.CSE);
      if (this.CSF != null) {
        paramVarArgs.c(2, this.CSF);
      }
      if (this.CSG != null) {
        paramVarArgs.c(3, this.CSG);
      }
      AppMethodBeat.o(117855);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.CSE) + 0;
      paramInt = i;
      if (this.CSF != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.CSF);
      }
      i = paramInt;
      if (this.CSG != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.CSG);
      }
      AppMethodBeat.o(117855);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CSE.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117855);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      rv localrv = (rv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117855);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dii();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dii)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrv.CSE.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117855);
        return 0;
      case 2: 
        localrv.CSF = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(117855);
        return 0;
      }
      localrv.CSG = ((f.a.a.a.a)localObject1).KhF.fMu();
      AppMethodBeat.o(117855);
      return 0;
    }
    AppMethodBeat.o(117855);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rv
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class sf
  extends com.tencent.mm.bw.a
{
  public LinkedList<dnx> Elp;
  public b Elq;
  public b Elr;
  
  public sf()
  {
    AppMethodBeat.i(117854);
    this.Elp = new LinkedList();
    AppMethodBeat.o(117854);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117855);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Elp);
      if (this.Elq != null) {
        paramVarArgs.c(2, this.Elq);
      }
      if (this.Elr != null) {
        paramVarArgs.c(3, this.Elr);
      }
      AppMethodBeat.o(117855);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Elp) + 0;
      paramInt = i;
      if (this.Elq != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Elq);
      }
      i = paramInt;
      if (this.Elr != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.Elr);
      }
      AppMethodBeat.o(117855);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Elp.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117855);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      sf localsf = (sf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117855);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dnx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsf.Elp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117855);
        return 0;
      case 2: 
        localsf.Elq = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(117855);
        return 0;
      }
      localsf.Elr = ((f.a.a.a.a)localObject1).LVo.gfk();
      AppMethodBeat.o(117855);
      return 0;
    }
    AppMethodBeat.o(117855);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sf
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ok
  extends com.tencent.mm.bw.a
{
  public String Eej;
  public LinkedList<ciw> Eek;
  
  public ok()
  {
    AppMethodBeat.i(194007);
    this.Eek = new LinkedList();
    AppMethodBeat.o(194007);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194008);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eej != null) {
        paramVarArgs.d(1, this.Eej);
      }
      paramVarArgs.e(2, 8, this.Eek);
      AppMethodBeat.o(194008);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eej == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.Eej) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Eek);
      AppMethodBeat.o(194008);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Eek.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194008);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ok localok = (ok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194008);
          return -1;
        case 1: 
          localok.Eej = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194008);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ciw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ciw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localok.Eek.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194008);
        return 0;
      }
      AppMethodBeat.o(194008);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ok
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtz
  extends com.tencent.mm.bw.a
{
  public LinkedList<dtv> GbQ;
  public String Gby;
  
  public dtz()
  {
    AppMethodBeat.i(147803);
    this.GbQ = new LinkedList();
    AppMethodBeat.o(147803);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147804);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gby != null) {
        paramVarArgs.d(1, this.Gby);
      }
      paramVarArgs.e(2, 8, this.GbQ);
      AppMethodBeat.o(147804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gby == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gby) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.GbQ);
      AppMethodBeat.o(147804);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GbQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147804);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtz localdtz = (dtz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147804);
          return -1;
        case 1: 
          localdtz.Gby = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(147804);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dtv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdtz.GbQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(147804);
        return 0;
      }
      AppMethodBeat.o(147804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtz
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anb
  extends com.tencent.mm.bx.a
{
  public long Doc;
  public LinkedList<bgd> Dod;
  public String name;
  public long startTime;
  
  public anb()
  {
    AppMethodBeat.i(122499);
    this.startTime = -1L;
    this.Doc = 0L;
    this.Dod = new LinkedList();
    AppMethodBeat.o(122499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122500);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      paramVarArgs.aG(2, this.startTime);
      paramVarArgs.aG(3, this.Doc);
      paramVarArgs.e(4, 8, this.Dod);
      AppMethodBeat.o(122500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = f.a.a.b.b.a.e(1, this.name) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.startTime);
      int j = f.a.a.b.b.a.q(3, this.Doc);
      int k = f.a.a.a.c(4, 8, this.Dod);
      AppMethodBeat.o(122500);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dod.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        anb localanb = (anb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122500);
          return -1;
        case 1: 
          localanb.name = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122500);
          return 0;
        case 2: 
          localanb.startTime = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122500);
          return 0;
        case 3: 
          localanb.Doc = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(122500);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bgd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localanb.Dod.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122500);
        return 0;
      }
      AppMethodBeat.o(122500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anb
 * JD-Core Version:    0.7.0.1
 */
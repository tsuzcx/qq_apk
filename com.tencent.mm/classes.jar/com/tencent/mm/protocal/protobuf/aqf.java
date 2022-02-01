package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqf
  extends com.tencent.mm.bw.a
{
  public long EJc;
  public LinkedList<bjv> EJd;
  public String name;
  public long startTime;
  
  public aqf()
  {
    AppMethodBeat.i(122499);
    this.startTime = -1L;
    this.EJc = 0L;
    this.EJd = new LinkedList();
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
      paramVarArgs.aO(2, this.startTime);
      paramVarArgs.aO(3, this.EJc);
      paramVarArgs.e(4, 8, this.EJd);
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
      int i = f.a.a.b.b.a.p(2, this.startTime);
      int j = f.a.a.b.b.a.p(3, this.EJc);
      int k = f.a.a.a.c(4, 8, this.EJd);
      AppMethodBeat.o(122500);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EJd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqf localaqf = (aqf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122500);
          return -1;
        case 1: 
          localaqf.name = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122500);
          return 0;
        case 2: 
          localaqf.startTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122500);
          return 0;
        case 3: 
          localaqf.EJc = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122500);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bjv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaqf.EJd.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqf
 * JD-Core Version:    0.7.0.1
 */
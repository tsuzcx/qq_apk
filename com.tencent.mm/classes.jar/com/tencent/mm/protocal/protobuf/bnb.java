package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnb
  extends com.tencent.mm.cd.a
{
  public long SXT;
  public LinkedList<cjq> SXU;
  public LinkedList<fbo> SXV;
  public String name;
  public long startTime;
  
  public bnb()
  {
    AppMethodBeat.i(122499);
    this.startTime = -1L;
    this.SXT = 0L;
    this.SXU = new LinkedList();
    this.SXV = new LinkedList();
    AppMethodBeat.o(122499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122500);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.f(1, this.name);
      }
      paramVarArgs.bm(2, this.startTime);
      paramVarArgs.bm(3, this.SXT);
      paramVarArgs.e(4, 8, this.SXU);
      paramVarArgs.e(5, 8, this.SXV);
      AppMethodBeat.o(122500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = g.a.a.b.b.a.g(1, this.name) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.startTime);
      int j = g.a.a.b.b.a.p(3, this.SXT);
      int k = g.a.a.a.c(4, 8, this.SXU);
      int m = g.a.a.a.c(5, 8, this.SXV);
      AppMethodBeat.o(122500);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SXU.clear();
        this.SXV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bnb localbnb = (bnb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122500);
          return -1;
        case 1: 
          localbnb.name = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(122500);
          return 0;
        case 2: 
          localbnb.startTime = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(122500);
          return 0;
        case 3: 
          localbnb.SXT = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(122500);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cjq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cjq)localObject2).parseFrom((byte[])localObject1);
            }
            localbnb.SXU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122500);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fbo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fbo)localObject2).parseFrom((byte[])localObject1);
          }
          localbnb.SXV.add(localObject2);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnb
 * JD-Core Version:    0.7.0.1
 */
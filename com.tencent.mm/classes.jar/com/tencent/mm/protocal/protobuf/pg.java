package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pg
  extends com.tencent.mm.cd.a
{
  public int RIs;
  public LinkedList<pf> RVd;
  public long RXN;
  public String fwr;
  
  public pg()
  {
    AppMethodBeat.i(206313);
    this.RVd = new LinkedList();
    AppMethodBeat.o(206313);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206314);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RIs);
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      paramVarArgs.e(3, 8, this.RVd);
      paramVarArgs.bm(4, this.RXN);
      AppMethodBeat.o(206314);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.RIs) + 0;
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = g.a.a.a.c(3, 8, this.RVd);
      int j = g.a.a.b.b.a.p(4, this.RXN);
      AppMethodBeat.o(206314);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RVd.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(206314);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      pg localpg = (pg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(206314);
        return -1;
      case 1: 
        localpg.RIs = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(206314);
        return 0;
      case 2: 
        localpg.fwr = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(206314);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          pf localpf = new pf();
          if ((localObject != null) && (localObject.length > 0)) {
            localpf.parseFrom((byte[])localObject);
          }
          localpg.RVd.add(localpf);
          paramInt += 1;
        }
        AppMethodBeat.o(206314);
        return 0;
      }
      localpg.RXN = ((g.a.a.a.a)localObject).abFh.AN();
      AppMethodBeat.o(206314);
      return 0;
    }
    AppMethodBeat.o(206314);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pg
 * JD-Core Version:    0.7.0.1
 */
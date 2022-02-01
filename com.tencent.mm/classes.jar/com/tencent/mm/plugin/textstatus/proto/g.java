package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.cd.a
{
  public int ChC;
  public long MFg;
  public String MFh;
  public LinkedList<h> MFi;
  public long aZE;
  public String description;
  public int update_time;
  
  public g()
  {
    AppMethodBeat.i(243687);
    this.MFi = new LinkedList();
    AppMethodBeat.o(243687);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243688);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.MFg);
      if (this.MFh != null) {
        paramVarArgs.f(2, this.MFh);
      }
      paramVarArgs.bm(3, this.aZE);
      paramVarArgs.aY(4, this.ChC);
      paramVarArgs.aY(5, this.update_time);
      if (this.description != null) {
        paramVarArgs.f(6, this.description);
      }
      paramVarArgs.e(7, 8, this.MFi);
      AppMethodBeat.o(243688);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.MFg) + 0;
      paramInt = i;
      if (this.MFh != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.MFh);
      }
      i = paramInt + g.a.a.b.b.a.p(3, this.aZE) + g.a.a.b.b.a.bM(4, this.ChC) + g.a.a.b.b.a.bM(5, this.update_time);
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.description);
      }
      i = g.a.a.a.c(7, 8, this.MFi);
      AppMethodBeat.o(243688);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.MFi.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(243688);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(243688);
        return -1;
      case 1: 
        localg.MFg = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(243688);
        return 0;
      case 2: 
        localg.MFh = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(243688);
        return 0;
      case 3: 
        localg.aZE = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(243688);
        return 0;
      case 4: 
        localg.ChC = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(243688);
        return 0;
      case 5: 
        localg.update_time = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(243688);
        return 0;
      case 6: 
        localg.description = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(243688);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        h localh = new h();
        if ((localObject != null) && (localObject.length > 0)) {
          localh.parseFrom((byte[])localObject);
        }
        localg.MFi.add(localh);
        paramInt += 1;
      }
      AppMethodBeat.o(243688);
      return 0;
    }
    AppMethodBeat.o(243688);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.g
 * JD-Core Version:    0.7.0.1
 */
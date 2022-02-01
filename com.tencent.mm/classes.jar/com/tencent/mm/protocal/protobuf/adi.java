package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adi
  extends com.tencent.mm.cd.a
{
  public LinkedList<adh> RIQ;
  public long SoQ;
  public long SoR;
  public int SpL;
  public int SpM;
  
  public adi()
  {
    AppMethodBeat.i(90962);
    this.RIQ = new LinkedList();
    AppMethodBeat.o(90962);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90963);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SoQ);
      paramVarArgs.bm(2, this.SoR);
      paramVarArgs.e(3, 8, this.RIQ);
      paramVarArgs.aY(4, this.SpL);
      paramVarArgs.aY(5, this.SpM);
      AppMethodBeat.o(90963);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.SoQ);
      i = g.a.a.b.b.a.p(2, this.SoR);
      int j = g.a.a.a.c(3, 8, this.RIQ);
      int k = g.a.a.b.b.a.bM(4, this.SpL);
      int m = g.a.a.b.b.a.bM(5, this.SpM);
      AppMethodBeat.o(90963);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RIQ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(90963);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      adi localadi = (adi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90963);
        return -1;
      case 1: 
        localadi.SoQ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(90963);
        return 0;
      case 2: 
        localadi.SoR = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(90963);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          adh localadh = new adh();
          if ((localObject != null) && (localObject.length > 0)) {
            localadh.parseFrom((byte[])localObject);
          }
          localadi.RIQ.add(localadh);
          paramInt += 1;
        }
        AppMethodBeat.o(90963);
        return 0;
      case 4: 
        localadi.SpL = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(90963);
        return 0;
      }
      localadi.SpM = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(90963);
      return 0;
    }
    AppMethodBeat.o(90963);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adi
 * JD-Core Version:    0.7.0.1
 */
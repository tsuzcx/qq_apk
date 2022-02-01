package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acz
  extends com.tencent.mm.cd.a
{
  public LinkedList<acy> RIQ;
  public long SoQ;
  public long SoR;
  
  public acz()
  {
    AppMethodBeat.i(184493);
    this.RIQ = new LinkedList();
    AppMethodBeat.o(184493);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184494);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SoQ);
      paramVarArgs.bm(2, this.SoR);
      paramVarArgs.e(3, 8, this.RIQ);
      AppMethodBeat.o(184494);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.SoQ);
      i = g.a.a.b.b.a.p(2, this.SoR);
      int j = g.a.a.a.c(3, 8, this.RIQ);
      AppMethodBeat.o(184494);
      return paramInt + 0 + i + j;
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
      AppMethodBeat.o(184494);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      acz localacz = (acz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184494);
        return -1;
      case 1: 
        localacz.SoQ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(184494);
        return 0;
      case 2: 
        localacz.SoR = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(184494);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        acy localacy = new acy();
        if ((localObject != null) && (localObject.length > 0)) {
          localacy.parseFrom((byte[])localObject);
        }
        localacz.RIQ.add(localacy);
        paramInt += 1;
      }
      AppMethodBeat.o(184494);
      return 0;
    }
    AppMethodBeat.o(184494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acz
 * JD-Core Version:    0.7.0.1
 */
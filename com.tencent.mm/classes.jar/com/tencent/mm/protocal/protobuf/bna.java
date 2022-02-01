package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bna
  extends com.tencent.mm.cd.a
{
  public LinkedList<efg> SXR;
  public bnb SXS;
  
  public bna()
  {
    AppMethodBeat.i(122497);
    this.SXR = new LinkedList();
    AppMethodBeat.o(122497);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122498);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.SXR);
      if (this.SXS != null)
      {
        paramVarArgs.oE(2, this.SXS.computeSize());
        this.SXS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122498);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.SXR) + 0;
      paramInt = i;
      if (this.SXS != null) {
        paramInt = i + g.a.a.a.oD(2, this.SXS.computeSize());
      }
      AppMethodBeat.o(122498);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SXR.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(122498);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bna localbna = (bna)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122498);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new efg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((efg)localObject2).parseFrom((byte[])localObject1);
          }
          localbna.SXR.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122498);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bnb();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bnb)localObject2).parseFrom((byte[])localObject1);
        }
        localbna.SXS = ((bnb)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(122498);
      return 0;
    }
    AppMethodBeat.o(122498);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bna
 * JD-Core Version:    0.7.0.1
 */
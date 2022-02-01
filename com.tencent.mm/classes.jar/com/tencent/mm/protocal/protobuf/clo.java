package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clo
  extends com.tencent.mm.cd.a
{
  public cli Ttb;
  public LinkedList<cll> Ttc;
  
  public clo()
  {
    AppMethodBeat.i(215168);
    this.Ttc = new LinkedList();
    AppMethodBeat.o(215168);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215170);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Ttc);
      if (this.Ttb != null)
      {
        paramVarArgs.oE(2, this.Ttb.computeSize());
        this.Ttb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(215170);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Ttc) + 0;
      paramInt = i;
      if (this.Ttb != null) {
        paramInt = i + g.a.a.a.oD(2, this.Ttb.computeSize());
      }
      AppMethodBeat.o(215170);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ttc.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(215170);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      clo localclo = (clo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(215170);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cll();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cll)localObject2).parseFrom((byte[])localObject1);
          }
          localclo.Ttc.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(215170);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new cli();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((cli)localObject2).parseFrom((byte[])localObject1);
        }
        localclo.Ttb = ((cli)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(215170);
      return 0;
    }
    AppMethodBeat.o(215170);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clo
 * JD-Core Version:    0.7.0.1
 */
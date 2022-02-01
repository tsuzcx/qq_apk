package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aft
  extends com.tencent.mm.cd.a
{
  public long HlH;
  public eaf SrH;
  public int SrK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43091);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SrH == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43091);
        throw paramVarArgs;
      }
      if (this.SrH != null)
      {
        paramVarArgs.oE(1, this.SrH.computeSize());
        this.SrH.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.SrK);
      paramVarArgs.bm(3, this.HlH);
      AppMethodBeat.o(43091);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SrH == null) {
        break label428;
      }
    }
    label428:
    for (paramInt = g.a.a.a.oD(1, this.SrH.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.SrK);
      int j = g.a.a.b.b.a.p(3, this.HlH);
      AppMethodBeat.o(43091);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SrH == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43091);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43091);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        aft localaft = (aft)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43091);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eaf localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localaft.SrH = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(43091);
          return 0;
        case 2: 
          localaft.SrK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(43091);
          return 0;
        }
        localaft.HlH = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(43091);
        return 0;
      }
      AppMethodBeat.o(43091);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aft
 * JD-Core Version:    0.7.0.1
 */
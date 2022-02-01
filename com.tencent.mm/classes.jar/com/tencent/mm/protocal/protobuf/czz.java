package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czz
  extends com.tencent.mm.cd.a
{
  public esj SXr;
  public boolean TqW;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122518);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SXr != null)
      {
        paramVarArgs.oE(1, this.SXr.computeSize());
        this.SXr.writeFields(paramVarArgs);
      }
      paramVarArgs.co(2, this.TqW);
      paramVarArgs.bm(3, this.timestamp);
      AppMethodBeat.o(122518);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SXr == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = g.a.a.a.oD(1, this.SXr.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.p(3, this.timestamp);
      AppMethodBeat.o(122518);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122518);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        czz localczz = (czz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122518);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            esj localesj = new esj();
            if ((localObject != null) && (localObject.length > 0)) {
              localesj.parseFrom((byte[])localObject);
            }
            localczz.SXr = localesj;
            paramInt += 1;
          }
          AppMethodBeat.o(122518);
          return 0;
        case 2: 
          localczz.TqW = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(122518);
          return 0;
        }
        localczz.timestamp = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(122518);
        return 0;
      }
      AppMethodBeat.o(122518);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czz
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fgp
  extends com.tencent.mm.cd.a
{
  public int UGJ;
  public int UGK;
  public ffj UGw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147817);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UGw == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147817);
        throw paramVarArgs;
      }
      if (this.UGw != null)
      {
        paramVarArgs.oE(1, this.UGw.computeSize());
        this.UGw.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.UGJ);
      paramVarArgs.aY(3, this.UGK);
      AppMethodBeat.o(147817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UGw == null) {
        break label428;
      }
    }
    label428:
    for (paramInt = g.a.a.a.oD(1, this.UGw.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.UGJ);
      int j = g.a.a.b.b.a.bM(3, this.UGK);
      AppMethodBeat.o(147817);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UGw == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147817);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fgp localfgp = (fgp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147817);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ffj localffj = new ffj();
            if ((localObject != null) && (localObject.length > 0)) {
              localffj.parseFrom((byte[])localObject);
            }
            localfgp.UGw = localffj;
            paramInt += 1;
          }
          AppMethodBeat.o(147817);
          return 0;
        case 2: 
          localfgp.UGJ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(147817);
          return 0;
        }
        localfgp.UGK = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(147817);
        return 0;
      }
      AppMethodBeat.o(147817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgp
 * JD-Core Version:    0.7.0.1
 */
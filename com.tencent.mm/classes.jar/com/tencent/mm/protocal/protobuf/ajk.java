package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajk
  extends com.tencent.mm.cd.a
{
  public fmk StQ;
  public String StR;
  public long begin_time;
  public long duration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110893);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.StQ != null)
      {
        paramVarArgs.oE(1, this.StQ.computeSize());
        this.StQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.begin_time);
      paramVarArgs.bm(3, this.duration);
      if (this.StR != null) {
        paramVarArgs.f(4, this.StR);
      }
      AppMethodBeat.o(110893);
      return 0;
    }
    if (paramInt == 1) {
      if (this.StQ == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = g.a.a.a.oD(1, this.StQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.begin_time) + g.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.StR != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.StR);
      }
      AppMethodBeat.o(110893);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(110893);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ajk localajk = (ajk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110893);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fmk localfmk = new fmk();
            if ((localObject != null) && (localObject.length > 0)) {
              localfmk.parseFrom((byte[])localObject);
            }
            localajk.StQ = localfmk;
            paramInt += 1;
          }
          AppMethodBeat.o(110893);
          return 0;
        case 2: 
          localajk.begin_time = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(110893);
          return 0;
        case 3: 
          localajk.duration = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(110893);
          return 0;
        }
        localajk.StR = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(110893);
        return 0;
      }
      AppMethodBeat.o(110893);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajk
 * JD-Core Version:    0.7.0.1
 */
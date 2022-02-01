package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fmk
  extends com.tencent.mm.cd.a
{
  public dmq ULf;
  public dmq ULg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110919);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ULf != null)
      {
        paramVarArgs.oE(1, this.ULf.computeSize());
        this.ULf.writeFields(paramVarArgs);
      }
      if (this.ULg != null)
      {
        paramVarArgs.oE(2, this.ULg.computeSize());
        this.ULg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ULf == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.a.oD(1, this.ULf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ULg != null) {
        i = paramInt + g.a.a.a.oD(2, this.ULg.computeSize());
      }
      AppMethodBeat.o(110919);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(110919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fmk localfmk = (fmk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        dmq localdmq;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110919);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdmq = new dmq();
            if ((localObject != null) && (localObject.length > 0)) {
              localdmq.parseFrom((byte[])localObject);
            }
            localfmk.ULf = localdmq;
            paramInt += 1;
          }
          AppMethodBeat.o(110919);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdmq = new dmq();
          if ((localObject != null) && (localObject.length > 0)) {
            localdmq.parseFrom((byte[])localObject);
          }
          localfmk.ULg = localdmq;
          paramInt += 1;
        }
        AppMethodBeat.o(110919);
        return 0;
      }
      AppMethodBeat.o(110919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmk
 * JD-Core Version:    0.7.0.1
 */
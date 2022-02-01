package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkt
  extends com.tencent.mm.cd.a
{
  public String SVK;
  public bkr fGc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198489);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fGc != null)
      {
        paramVarArgs.oE(1, this.fGc.computeSize());
        this.fGc.writeFields(paramVarArgs);
      }
      if (this.SVK != null) {
        paramVarArgs.f(2, this.SVK);
      }
      AppMethodBeat.o(198489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fGc == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.a.oD(1, this.fGc.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SVK != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SVK);
      }
      AppMethodBeat.o(198489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bkt localbkt = (bkt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198489);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bkr localbkr = new bkr();
            if ((localObject != null) && (localObject.length > 0)) {
              localbkr.parseFrom((byte[])localObject);
            }
            localbkt.fGc = localbkr;
            paramInt += 1;
          }
          AppMethodBeat.o(198489);
          return 0;
        }
        localbkt.SVK = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(198489);
        return 0;
      }
      AppMethodBeat.o(198489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkt
 * JD-Core Version:    0.7.0.1
 */
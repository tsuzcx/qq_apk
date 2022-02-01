package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chj
  extends com.tencent.mm.cd.a
{
  public bab ToL;
  public int ToM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230051);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ToL != null)
      {
        paramVarArgs.oE(1, this.ToL.computeSize());
        this.ToL.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.ToM);
      AppMethodBeat.o(230051);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ToL == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = g.a.a.a.oD(1, this.ToL.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.ToM);
      AppMethodBeat.o(230051);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230051);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        chj localchj = (chj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230051);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bab localbab = new bab();
            if ((localObject != null) && (localObject.length > 0)) {
              localbab.parseFrom((byte[])localObject);
            }
            localchj.ToL = localbab;
            paramInt += 1;
          }
          AppMethodBeat.o(230051);
          return 0;
        }
        localchj.ToM = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(230051);
        return 0;
      }
      AppMethodBeat.o(230051);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chj
 * JD-Core Version:    0.7.0.1
 */
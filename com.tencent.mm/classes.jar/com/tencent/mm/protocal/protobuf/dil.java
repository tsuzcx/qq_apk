package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dil
  extends com.tencent.mm.cd.a
{
  public cqh TwK;
  public aam TwL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117884);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TwK != null)
      {
        paramVarArgs.oE(1, this.TwK.computeSize());
        this.TwK.writeFields(paramVarArgs);
      }
      if (this.TwL != null)
      {
        paramVarArgs.oE(2, this.TwL.computeSize());
        this.TwL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TwK == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.a.oD(1, this.TwK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TwL != null) {
        i = paramInt + g.a.a.a.oD(2, this.TwL.computeSize());
      }
      AppMethodBeat.o(117884);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117884);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dil localdil = (dil)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117884);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cqh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cqh)localObject2).parseFrom((byte[])localObject1);
            }
            localdil.TwK = ((cqh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117884);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aam();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aam)localObject2).parseFrom((byte[])localObject1);
          }
          localdil.TwL = ((aam)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117884);
        return 0;
      }
      AppMethodBeat.o(117884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dil
 * JD-Core Version:    0.7.0.1
 */
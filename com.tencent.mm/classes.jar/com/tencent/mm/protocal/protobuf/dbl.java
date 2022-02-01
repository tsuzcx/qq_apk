package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbl
  extends com.tencent.mm.cd.a
{
  public dbj TIN;
  public bds TIn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230034);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TIN != null)
      {
        paramVarArgs.oE(1, this.TIN.computeSize());
        this.TIN.writeFields(paramVarArgs);
      }
      if (this.TIn != null)
      {
        paramVarArgs.oE(2, this.TIn.computeSize());
        this.TIn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(230034);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TIN == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.a.oD(1, this.TIN.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TIn != null) {
        i = paramInt + g.a.a.a.oD(2, this.TIn.computeSize());
      }
      AppMethodBeat.o(230034);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230034);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dbl localdbl = (dbl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230034);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbj)localObject2).parseFrom((byte[])localObject1);
            }
            localdbl.TIN = ((dbj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230034);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bds();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bds)localObject2).parseFrom((byte[])localObject1);
          }
          localdbl.TIn = ((bds)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(230034);
        return 0;
      }
      AppMethodBeat.o(230034);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbl
 * JD-Core Version:    0.7.0.1
 */
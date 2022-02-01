package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnu
  extends com.tencent.mm.cd.a
{
  public ezl SYO;
  public bnt SYP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230067);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SYO != null)
      {
        paramVarArgs.oE(1, this.SYO.computeSize());
        this.SYO.writeFields(paramVarArgs);
      }
      if (this.SYP != null)
      {
        paramVarArgs.oE(2, this.SYP.computeSize());
        this.SYP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(230067);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SYO == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.a.oD(1, this.SYO.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SYP != null) {
        i = paramInt + g.a.a.a.oD(2, this.SYP.computeSize());
      }
      AppMethodBeat.o(230067);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230067);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bnu localbnu = (bnu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230067);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ezl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ezl)localObject2).parseFrom((byte[])localObject1);
            }
            localbnu.SYO = ((ezl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230067);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bnt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bnt)localObject2).parseFrom((byte[])localObject1);
          }
          localbnu.SYP = ((bnt)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(230067);
        return 0;
      }
      AppMethodBeat.o(230067);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnu
 * JD-Core Version:    0.7.0.1
 */
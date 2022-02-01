package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bx.a
{
  public aa aciQ;
  public z aciX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259707);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aciX != null)
      {
        paramVarArgs.qD(1, this.aciX.computeSize());
        this.aciX.writeFields(paramVarArgs);
      }
      if (this.aciQ != null)
      {
        paramVarArgs.qD(2, this.aciQ.computeSize());
        this.aciQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aciX == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.aciX.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aciQ != null) {
        i = paramInt + i.a.a.a.qC(2, this.aciQ.computeSize());
      }
      AppMethodBeat.o(259707);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259707);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new z();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((z)localObject2).parseFrom((byte[])localObject1);
            }
            locali.aciX = ((z)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259707);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aa();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aa)localObject2).parseFrom((byte[])localObject1);
          }
          locali.aciQ = ((aa)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259707);
        return 0;
      }
      AppMethodBeat.o(259707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.i
 * JD-Core Version:    0.7.0.1
 */
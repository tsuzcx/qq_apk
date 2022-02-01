package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class im
  extends com.tencent.mm.bx.a
{
  public gol YKi;
  public all YKj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133149);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YKi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesEncryptKey");
        AppMethodBeat.o(133149);
        throw paramVarArgs;
      }
      if (this.YKi != null)
      {
        paramVarArgs.qD(2, this.YKi.computeSize());
        this.YKi.writeFields(paramVarArgs);
      }
      if (this.YKj != null)
      {
        paramVarArgs.qD(3, this.YKj.computeSize());
        this.YKj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133149);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YKi == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.a.qC(2, this.YKi.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YKj != null) {
        i = paramInt + i.a.a.a.qC(3, this.YKj.computeSize());
      }
      AppMethodBeat.o(133149);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YKi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesEncryptKey");
          AppMethodBeat.o(133149);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133149);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        im localim = (im)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133149);
          return -1;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localim.YKi = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133149);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new all();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((all)localObject2).parseFrom((byte[])localObject1);
          }
          localim.YKj = ((all)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133149);
        return 0;
      }
      AppMethodBeat.o(133149);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.im
 * JD-Core Version:    0.7.0.1
 */
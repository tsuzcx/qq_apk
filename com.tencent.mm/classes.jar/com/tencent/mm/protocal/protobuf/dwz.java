package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dwz
  extends erp
{
  public cad abcP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258421);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abcP == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgInfo");
        AppMethodBeat.o(258421);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abcP != null)
      {
        paramVarArgs.qD(2, this.abcP.computeSize());
        this.abcP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abcP != null) {
        i = paramInt + i.a.a.a.qC(2, this.abcP.computeSize());
      }
      AppMethodBeat.o(258421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abcP == null)
        {
          paramVarArgs = new b("Not all required fields were included: MsgInfo");
          AppMethodBeat.o(258421);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dwz localdwz = (dwz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258421);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localdwz.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258421);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cad();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cad)localObject2).parseFrom((byte[])localObject1);
          }
          localdwz.abcP = ((cad)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258421);
        return 0;
      }
      AppMethodBeat.o(258421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwz
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fyw
  extends erp
{
  public String abWb;
  public fyy abWs;
  public b abWx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257486);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abWb != null) {
        paramVarArgs.g(2, this.abWb);
      }
      if (this.abWx != null) {
        paramVarArgs.d(3, this.abWx);
      }
      if (this.abWs != null)
      {
        paramVarArgs.qD(4, this.abWs.computeSize());
        this.abWs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label538;
      }
    }
    label538:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abWb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abWb);
      }
      i = paramInt;
      if (this.abWx != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.abWx);
      }
      paramInt = i;
      if (this.abWs != null) {
        paramInt = i + i.a.a.a.qC(4, this.abWs.computeSize());
      }
      AppMethodBeat.o(257486);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257486);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fyw localfyw = (fyw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257486);
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
            localfyw.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257486);
          return 0;
        case 2: 
          localfyw.abWb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257486);
          return 0;
        case 3: 
          localfyw.abWx = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257486);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fyy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fyy)localObject2).parseFrom((byte[])localObject1);
          }
          localfyw.abWs = ((fyy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257486);
        return 0;
      }
      AppMethodBeat.o(257486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fyw
 * JD-Core Version:    0.7.0.1
 */
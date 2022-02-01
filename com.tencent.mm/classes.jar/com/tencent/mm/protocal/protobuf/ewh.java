package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ewh
  extends erp
{
  public boolean ZqT;
  public b aazX;
  public String hAB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74666);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hAB != null) {
        paramVarArgs.g(2, this.hAB);
      }
      if (this.aazX != null) {
        paramVarArgs.d(3, this.aazX);
      }
      paramVarArgs.di(4, this.ZqT);
      AppMethodBeat.o(74666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label448;
      }
    }
    label448:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAB != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAB);
      }
      i = paramInt;
      if (this.aazX != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.aazX);
      }
      paramInt = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(74666);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(74666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ewh localewh = (ewh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74666);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localewh.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(74666);
          return 0;
        case 2: 
          localewh.hAB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(74666);
          return 0;
        case 3: 
          localewh.aazX = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(74666);
          return 0;
        }
        localewh.ZqT = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(74666);
        return 0;
      }
      AppMethodBeat.o(74666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewh
 * JD-Core Version:    0.7.0.1
 */
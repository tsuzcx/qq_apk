package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cul
  extends erp
{
  public boolean ZqT;
  public b aazX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74661);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aazX != null) {
        paramVarArgs.d(2, this.aazX);
      }
      paramVarArgs.di(3, this.ZqT);
      AppMethodBeat.o(74661);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aazX != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.aazX);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(74661);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(74661);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cul localcul = (cul)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74661);
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
            localcul.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(74661);
          return 0;
        case 2: 
          localcul.aazX = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(74661);
          return 0;
        }
        localcul.ZqT = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(74661);
        return 0;
      }
      AppMethodBeat.o(74661);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cul
 * JD-Core Version:    0.7.0.1
 */
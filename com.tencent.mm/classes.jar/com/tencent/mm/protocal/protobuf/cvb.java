package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cvb
  extends com.tencent.mm.cd.a
{
  public cvc TCK;
  public cva TCL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133177);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TCK == null)
      {
        paramVarArgs = new b("Not all required fields were included: RsaReqData");
        AppMethodBeat.o(133177);
        throw paramVarArgs;
      }
      if (this.TCL == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesReqData");
        AppMethodBeat.o(133177);
        throw paramVarArgs;
      }
      if (this.TCK != null)
      {
        paramVarArgs.oE(1, this.TCK.computeSize());
        this.TCK.writeFields(paramVarArgs);
      }
      if (this.TCL != null)
      {
        paramVarArgs.oE(2, this.TCL.computeSize());
        this.TCL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133177);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TCK == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = g.a.a.a.oD(1, this.TCK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TCL != null) {
        i = paramInt + g.a.a.a.oD(2, this.TCL.computeSize());
      }
      AppMethodBeat.o(133177);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TCK == null)
        {
          paramVarArgs = new b("Not all required fields were included: RsaReqData");
          AppMethodBeat.o(133177);
          throw paramVarArgs;
        }
        if (this.TCL == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesReqData");
          AppMethodBeat.o(133177);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133177);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cvb localcvb = (cvb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133177);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cvc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cvc)localObject2).parseFrom((byte[])localObject1);
            }
            localcvb.TCK = ((cvc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133177);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cva();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cva)localObject2).parseFrom((byte[])localObject1);
          }
          localcvb.TCL = ((cva)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133177);
        return 0;
      }
      AppMethodBeat.o(133177);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvb
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awm
  extends cvp
{
  public int Gva;
  public com.tencent.mm.bx.b oAr;
  public String ozQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114001);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114001);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ozQ != null) {
        paramVarArgs.d(2, this.ozQ);
      }
      paramVarArgs.aS(3, this.Gva);
      if (this.oAr != null) {
        paramVarArgs.c(4, this.oAr);
      }
      AppMethodBeat.o(114001);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ozQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ozQ);
      }
      i += f.a.a.b.b.a.bz(3, this.Gva);
      paramInt = i;
      if (this.oAr != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.oAr);
      }
      AppMethodBeat.o(114001);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114001);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114001);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awm localawm = (awm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114001);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114001);
          return 0;
        case 2: 
          localawm.ozQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114001);
          return 0;
        case 3: 
          localawm.Gva = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114001);
          return 0;
        }
        localawm.oAr = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(114001);
        return 0;
      }
      AppMethodBeat.o(114001);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awm
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bzg
  extends cld
{
  public int DVS;
  public int oXv;
  public String oXw;
  public String rZo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91586);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91586);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.oXv);
      if (this.oXw != null) {
        paramVarArgs.d(3, this.oXw);
      }
      if (this.rZo != null) {
        paramVarArgs.d(4, this.rZo);
      }
      paramVarArgs.aR(5, this.DVS);
      AppMethodBeat.o(91586);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.oXv);
      paramInt = i;
      if (this.oXw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oXw);
      }
      i = paramInt;
      if (this.rZo != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.rZo);
      }
      paramInt = f.a.a.b.b.a.bA(5, this.DVS);
      AppMethodBeat.o(91586);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91586);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91586);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzg localbzg = (bzg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91586);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91586);
          return 0;
        case 2: 
          localbzg.oXv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91586);
          return 0;
        case 3: 
          localbzg.oXw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91586);
          return 0;
        case 4: 
          localbzg.rZo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91586);
          return 0;
        }
        localbzg.DVS = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91586);
        return 0;
      }
      AppMethodBeat.o(91586);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzg
 * JD-Core Version:    0.7.0.1
 */
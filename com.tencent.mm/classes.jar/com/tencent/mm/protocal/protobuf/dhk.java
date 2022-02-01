package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhk
  extends cld
{
  public String CVv;
  public String CVw;
  public String ExC;
  public int uKQ;
  public int uKR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152718);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152718);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.uKQ);
      paramVarArgs.aR(3, this.uKR);
      if (this.ExC != null) {
        paramVarArgs.d(4, this.ExC);
      }
      if (this.CVv != null) {
        paramVarArgs.d(5, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(6, this.CVw);
      }
      AppMethodBeat.o(152718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.uKQ) + f.a.a.b.b.a.bA(3, this.uKR);
      paramInt = i;
      if (this.ExC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ExC);
      }
      i = paramInt;
      if (this.CVv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CVv);
      }
      paramInt = i;
      if (this.CVw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CVw);
      }
      AppMethodBeat.o(152718);
      return paramInt;
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
          AppMethodBeat.o(152718);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152718);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhk localdhk = (dhk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152718);
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
            localdhk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152718);
          return 0;
        case 2: 
          localdhk.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152718);
          return 0;
        case 3: 
          localdhk.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152718);
          return 0;
        case 4: 
          localdhk.ExC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152718);
          return 0;
        case 5: 
          localdhk.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152718);
          return 0;
        }
        localdhk.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152718);
        return 0;
      }
      AppMethodBeat.o(152718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhk
 * JD-Core Version:    0.7.0.1
 */
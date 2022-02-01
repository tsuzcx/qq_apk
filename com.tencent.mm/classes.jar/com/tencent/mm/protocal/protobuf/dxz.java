package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dxz
  extends cld
{
  public boolean LwD;
  public String LwE;
  public eas Lxa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(202491);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Lxa != null)
      {
        paramVarArgs.kX(2, this.Lxa.computeSize());
        this.Lxa.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(3, this.LwD);
      if (this.LwE != null) {
        paramVarArgs.d(4, this.LwE);
      }
      AppMethodBeat.o(202491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lxa != null) {
        i = paramInt + f.a.a.a.kW(2, this.Lxa.computeSize());
      }
      i += f.a.a.b.b.a.fY(3) + 1;
      paramInt = i;
      if (this.LwE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.LwE);
      }
      AppMethodBeat.o(202491);
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
          AppMethodBeat.o(202491);
          throw paramVarArgs;
        }
        AppMethodBeat.o(202491);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxz localdxz = (dxz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202491);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(202491);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eas();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eas)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxz.Lxa = ((eas)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(202491);
          return 0;
        case 3: 
          localdxz.LwD = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(202491);
          return 0;
        }
        localdxz.LwE = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(202491);
        return 0;
      }
      AppMethodBeat.o(202491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxz
 * JD-Core Version:    0.7.0.1
 */
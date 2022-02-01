package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cld;
import f.a.a.b;
import java.util.LinkedList;

public final class ai
  extends cld
{
  public String gKn;
  public int uKQ;
  public int uKR;
  public String uKY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122800);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(122800);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.uKR);
      if (this.uKY != null) {
        paramVarArgs.d(3, this.uKY);
      }
      paramVarArgs.aR(4, this.uKQ);
      if (this.gKn != null) {
        paramVarArgs.d(5, this.gKn);
      }
      AppMethodBeat.o(122800);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.uKR);
      paramInt = i;
      if (this.uKY != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.uKY);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.uKQ);
      paramInt = i;
      if (this.gKn != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gKn);
      }
      AppMethodBeat.o(122800);
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
          AppMethodBeat.o(122800);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122800);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122800);
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
            localai.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122800);
          return 0;
        case 2: 
          localai.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122800);
          return 0;
        case 3: 
          localai.uKY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(122800);
          return 0;
        case 4: 
          localai.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(122800);
          return 0;
        }
        localai.gKn = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(122800);
        return 0;
      }
      AppMethodBeat.o(122800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ai
 * JD-Core Version:    0.7.0.1
 */
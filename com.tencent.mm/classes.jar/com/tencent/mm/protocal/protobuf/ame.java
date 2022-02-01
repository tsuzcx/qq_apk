package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ame
  extends cld
{
  public int Dnm;
  public String Dnn;
  public String Dno;
  public int Dnp;
  public String Dnq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91467);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91467);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Dnm);
      if (this.Dnn != null) {
        paramVarArgs.d(3, this.Dnn);
      }
      if (this.Dno != null) {
        paramVarArgs.d(4, this.Dno);
      }
      paramVarArgs.aR(5, this.Dnp);
      if (this.Dnq != null) {
        paramVarArgs.d(6, this.Dnq);
      }
      AppMethodBeat.o(91467);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Dnm);
      paramInt = i;
      if (this.Dnn != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Dnn);
      }
      i = paramInt;
      if (this.Dno != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Dno);
      }
      i += f.a.a.b.b.a.bA(5, this.Dnp);
      paramInt = i;
      if (this.Dnq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Dnq);
      }
      AppMethodBeat.o(91467);
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
          AppMethodBeat.o(91467);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91467);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ame localame = (ame)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91467);
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
            localame.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91467);
          return 0;
        case 2: 
          localame.Dnm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91467);
          return 0;
        case 3: 
          localame.Dnn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91467);
          return 0;
        case 4: 
          localame.Dno = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91467);
          return 0;
        case 5: 
          localame.Dnp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91467);
          return 0;
        }
        localame.Dnq = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91467);
        return 0;
      }
      AppMethodBeat.o(91467);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ame
 * JD-Core Version:    0.7.0.1
 */
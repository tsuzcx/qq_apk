package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avn
  extends cld
{
  public int Dnm;
  public String Dnn;
  public String Dno;
  public int Dnp;
  public String Dnq;
  public String DuR;
  public String DuS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91490);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91490);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DuR != null) {
        paramVarArgs.d(2, this.DuR);
      }
      paramVarArgs.aR(3, this.Dnm);
      if (this.Dnn != null) {
        paramVarArgs.d(4, this.Dnn);
      }
      if (this.Dno != null) {
        paramVarArgs.d(5, this.Dno);
      }
      paramVarArgs.aR(6, this.Dnp);
      if (this.Dnq != null) {
        paramVarArgs.d(7, this.Dnq);
      }
      if (this.DuS != null) {
        paramVarArgs.d(8, this.DuS);
      }
      AppMethodBeat.o(91490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DuR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DuR);
      }
      i += f.a.a.b.b.a.bA(3, this.Dnm);
      paramInt = i;
      if (this.Dnn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dnn);
      }
      i = paramInt;
      if (this.Dno != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Dno);
      }
      i += f.a.a.b.b.a.bA(6, this.Dnp);
      paramInt = i;
      if (this.Dnq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Dnq);
      }
      i = paramInt;
      if (this.DuS != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DuS);
      }
      AppMethodBeat.o(91490);
      return i;
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
          AppMethodBeat.o(91490);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avn localavn = (avn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91490);
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
            localavn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91490);
          return 0;
        case 2: 
          localavn.DuR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 3: 
          localavn.Dnm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91490);
          return 0;
        case 4: 
          localavn.Dnn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 5: 
          localavn.Dno = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 6: 
          localavn.Dnp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91490);
          return 0;
        case 7: 
          localavn.Dnq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91490);
          return 0;
        }
        localavn.DuS = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91490);
        return 0;
      }
      AppMethodBeat.o(91490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avn
 * JD-Core Version:    0.7.0.1
 */
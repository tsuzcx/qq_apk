package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ace
  extends cld
{
  public String hnC;
  public String hnF;
  public String mAQ;
  public int uKQ;
  public int uKR;
  public int uKS;
  public SKBuiltinBuffer_t uKT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9591);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(9591);
        throw paramVarArgs;
      }
      if (this.uKT == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(9591);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      if (this.hnF != null) {
        paramVarArgs.d(3, this.hnF);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(4, this.mAQ);
      }
      paramVarArgs.aR(5, this.uKQ);
      paramVarArgs.aR(6, this.uKR);
      paramVarArgs.aR(7, this.uKS);
      if (this.uKT != null)
      {
        paramVarArgs.kX(8, this.uKT.computeSize());
        this.uKT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(9591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label892;
      }
    }
    label892:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt;
      if (this.hnF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hnF);
      }
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mAQ);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.uKQ) + f.a.a.b.b.a.bA(6, this.uKR) + f.a.a.b.b.a.bA(7, this.uKS);
      paramInt = i;
      if (this.uKT != null) {
        paramInt = i + f.a.a.a.kW(8, this.uKT.computeSize());
      }
      AppMethodBeat.o(9591);
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
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        if (this.uKT == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ace localace = (ace)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9591);
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
            localace.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9591);
          return 0;
        case 2: 
          localace.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 3: 
          localace.hnF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 4: 
          localace.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 5: 
          localace.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(9591);
          return 0;
        case 6: 
          localace.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(9591);
          return 0;
        case 7: 
          localace.uKS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(9591);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localace.uKT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      AppMethodBeat.o(9591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ace
 * JD-Core Version:    0.7.0.1
 */
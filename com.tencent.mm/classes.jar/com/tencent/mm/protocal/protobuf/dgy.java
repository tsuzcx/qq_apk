package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dgy
  extends cld
{
  public int CreateTime;
  public String Exi;
  public String hnC;
  public String hnF;
  public String mAQ;
  public int uKQ;
  public int uKR;
  public int uKS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32485);
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
      if (this.Exi != null) {
        paramVarArgs.d(4, this.Exi);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(5, this.mAQ);
      }
      paramVarArgs.aR(6, this.uKQ);
      paramVarArgs.aR(7, this.uKR);
      paramVarArgs.aR(8, this.uKS);
      paramVarArgs.aR(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label805;
      }
    }
    label805:
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
      if (this.Exi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Exi);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mAQ);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.uKQ);
      int j = f.a.a.b.b.a.bA(7, this.uKR);
      int k = f.a.a.b.b.a.bA(8, this.uKS);
      int m = f.a.a.b.b.a.bA(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return i + paramInt + j + k + m;
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
          AppMethodBeat.o(32485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgy localdgy = (dgy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32485);
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
            localdgy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32485);
          return 0;
        case 2: 
          localdgy.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 3: 
          localdgy.hnF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 4: 
          localdgy.Exi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 5: 
          localdgy.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 6: 
          localdgy.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32485);
          return 0;
        case 7: 
          localdgy.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32485);
          return 0;
        case 8: 
          localdgy.uKS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32485);
          return 0;
        }
        localdgy.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32485);
        return 0;
      }
      AppMethodBeat.o(32485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgy
 * JD-Core Version:    0.7.0.1
 */
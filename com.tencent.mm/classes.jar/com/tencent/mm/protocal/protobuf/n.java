package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class n
  extends cld
{
  public int dcG = 268513600;
  public int iap;
  public int iaq;
  public int iar;
  public long ias;
  public long iat;
  public String iau;
  public String iav;
  public String nTK = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91325);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91325);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dcG);
      if (this.nTK != null) {
        paramVarArgs.d(3, this.nTK);
      }
      paramVarArgs.aR(4, this.iap);
      paramVarArgs.aR(5, this.iaq);
      paramVarArgs.aR(6, this.iar);
      paramVarArgs.aG(7, this.ias);
      paramVarArgs.aG(8, this.iat);
      if (this.iau != null) {
        paramVarArgs.d(9, this.iau);
      }
      if (this.iav != null) {
        paramVarArgs.d(10, this.iav);
      }
      AppMethodBeat.o(91325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label806;
      }
    }
    label806:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dcG);
      paramInt = i;
      if (this.nTK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nTK);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.iap) + f.a.a.b.b.a.bA(5, this.iaq) + f.a.a.b.b.a.bA(6, this.iar) + f.a.a.b.b.a.q(7, this.ias) + f.a.a.b.b.a.q(8, this.iat);
      paramInt = i;
      if (this.iau != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iau);
      }
      i = paramInt;
      if (this.iav != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.iav);
      }
      AppMethodBeat.o(91325);
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
          AppMethodBeat.o(91325);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91325);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91325);
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
            localn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91325);
          return 0;
        case 2: 
          localn.dcG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91325);
          return 0;
        case 3: 
          localn.nTK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91325);
          return 0;
        case 4: 
          localn.iap = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91325);
          return 0;
        case 5: 
          localn.iaq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91325);
          return 0;
        case 6: 
          localn.iar = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91325);
          return 0;
        case 7: 
          localn.ias = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91325);
          return 0;
        case 8: 
          localn.iat = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91325);
          return 0;
        case 9: 
          localn.iau = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91325);
          return 0;
        }
        localn.iav = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91325);
        return 0;
      }
      AppMethodBeat.o(91325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.n
 * JD-Core Version:    0.7.0.1
 */
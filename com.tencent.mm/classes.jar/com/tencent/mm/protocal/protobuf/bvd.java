package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bvd
  extends cld
{
  public String CFt;
  public caz CFv;
  public String DSj;
  public boolean DSk;
  public boolean DSl;
  public int ntx;
  public String nty;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72529);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72529);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      if (this.DSj != null) {
        paramVarArgs.d(4, this.DSj);
      }
      if (this.CFt != null) {
        paramVarArgs.d(7, this.CFt);
      }
      if (this.CFv != null)
      {
        paramVarArgs.kX(8, this.CFv.computeSize());
        this.CFv.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(9, this.DSk);
      paramVarArgs.bg(10, this.DSl);
      AppMethodBeat.o(72529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label838;
      }
    }
    label838:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.DSj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DSj);
      }
      paramInt = i;
      if (this.CFt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CFt);
      }
      i = paramInt;
      if (this.CFv != null) {
        i = paramInt + f.a.a.a.kW(8, this.CFv.computeSize());
      }
      paramInt = f.a.a.b.b.a.fY(9);
      int j = f.a.a.b.b.a.fY(10);
      AppMethodBeat.o(72529);
      return i + (paramInt + 1) + (j + 1);
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
          AppMethodBeat.o(72529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvd localbvd = (bvd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(72529);
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
            localbvd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 2: 
          localbvd.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72529);
          return 0;
        case 3: 
          localbvd.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 4: 
          localbvd.DSj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 7: 
          localbvd.CFt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((caz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvd.CFv = ((caz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 9: 
          localbvd.DSk = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(72529);
          return 0;
        }
        localbvd.DSl = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(72529);
        return 0;
      }
      AppMethodBeat.o(72529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvd
 * JD-Core Version:    0.7.0.1
 */
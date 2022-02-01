package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bvf
  extends cld
{
  public String CFu;
  public caz CFv;
  public bwq CFw;
  public String DSj;
  public String DSq;
  public bhs DSr;
  public int ntx;
  public String nty;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72531);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72531);
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
      if (this.CFu != null) {
        paramVarArgs.d(5, this.CFu);
      }
      if (this.DSq != null) {
        paramVarArgs.d(6, this.DSq);
      }
      if (this.CFv != null)
      {
        paramVarArgs.kX(7, this.CFv.computeSize());
        this.CFv.writeFields(paramVarArgs);
      }
      if (this.CFw != null)
      {
        paramVarArgs.kX(8, this.CFw.computeSize());
        this.CFw.writeFields(paramVarArgs);
      }
      if (this.DSr != null)
      {
        paramVarArgs.kX(9, this.DSr.computeSize());
        this.DSr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
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
      if (this.CFu != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CFu);
      }
      i = paramInt;
      if (this.DSq != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DSq);
      }
      paramInt = i;
      if (this.CFv != null) {
        paramInt = i + f.a.a.a.kW(7, this.CFv.computeSize());
      }
      i = paramInt;
      if (this.CFw != null) {
        i = paramInt + f.a.a.a.kW(8, this.CFw.computeSize());
      }
      paramInt = i;
      if (this.DSr != null) {
        paramInt = i + f.a.a.a.kW(9, this.DSr.computeSize());
      }
      AppMethodBeat.o(72531);
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
          AppMethodBeat.o(72531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvf localbvf = (bvf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72531);
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
            localbvf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 2: 
          localbvf.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72531);
          return 0;
        case 3: 
          localbvf.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 4: 
          localbvf.DSj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 5: 
          localbvf.CFu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 6: 
          localbvf.DSq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((caz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvf.CFv = ((caz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvf.CFw = ((bwq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bhs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bhs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbvf.DSr = ((bhs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      AppMethodBeat.o(72531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvf
 * JD-Core Version:    0.7.0.1
 */
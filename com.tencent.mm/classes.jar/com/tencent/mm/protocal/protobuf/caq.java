package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class caq
  extends cld
{
  public LinkedList<car> DXb;
  public ih DXc;
  public int DXd;
  public int ntx;
  public String nty;
  public long zEq;
  public String zEr;
  public String zEt;
  public String zEu;
  
  public caq()
  {
    AppMethodBeat.i(91616);
    this.DXb = new LinkedList();
    AppMethodBeat.o(91616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91617);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91617);
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
      paramVarArgs.e(4, 8, this.DXb);
      paramVarArgs.aG(5, this.zEq);
      if (this.zEr != null) {
        paramVarArgs.d(6, this.zEr);
      }
      if (this.DXc != null)
      {
        paramVarArgs.kX(7, this.DXc.computeSize());
        this.DXc.writeFields(paramVarArgs);
      }
      if (this.zEt != null) {
        paramVarArgs.d(8, this.zEt);
      }
      if (this.zEu != null) {
        paramVarArgs.d(9, this.zEu);
      }
      paramVarArgs.aR(10, this.DXd);
      AppMethodBeat.o(91617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1034;
      }
    }
    label1034:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.DXb) + f.a.a.b.b.a.q(5, this.zEq);
      paramInt = i;
      if (this.zEr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.zEr);
      }
      i = paramInt;
      if (this.DXc != null) {
        i = paramInt + f.a.a.a.kW(7, this.DXc.computeSize());
      }
      paramInt = i;
      if (this.zEt != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.zEt);
      }
      i = paramInt;
      if (this.zEu != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.zEu);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.DXd);
      AppMethodBeat.o(91617);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DXb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        caq localcaq = (caq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91617);
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
            localcaq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 2: 
          localcaq.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91617);
          return 0;
        case 3: 
          localcaq.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new car();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((car)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaq.DXb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 5: 
          localcaq.zEq = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(91617);
          return 0;
        case 6: 
          localcaq.zEr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ih();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ih)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcaq.DXc = ((ih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 8: 
          localcaq.zEt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 9: 
          localcaq.zEu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91617);
          return 0;
        }
        localcaq.DXd = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91617);
        return 0;
      }
      AppMethodBeat.o(91617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caq
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cef
  extends cld
{
  public String Ean;
  public String Eao;
  public qc Eap;
  public String Eaq;
  public String Ear;
  public ddk Eas;
  public String dca;
  public String gGR;
  public int ntx;
  public String nty;
  public String uns;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72556);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72556);
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
      if (this.Ean != null) {
        paramVarArgs.d(4, this.Ean);
      }
      if (this.gGR != null) {
        paramVarArgs.d(5, this.gGR);
      }
      if (this.Eao != null) {
        paramVarArgs.d(6, this.Eao);
      }
      if (this.Eap != null)
      {
        paramVarArgs.kX(7, this.Eap.computeSize());
        this.Eap.writeFields(paramVarArgs);
      }
      if (this.Eaq != null) {
        paramVarArgs.d(8, this.Eaq);
      }
      if (this.uns != null) {
        paramVarArgs.d(9, this.uns);
      }
      if (this.dca != null) {
        paramVarArgs.d(10, this.dca);
      }
      if (this.Ear != null) {
        paramVarArgs.d(11, this.Ear);
      }
      if (this.Eas != null)
      {
        paramVarArgs.kX(12, this.Eas.computeSize());
        this.Eas.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.Ean != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Ean);
      }
      paramInt = i;
      if (this.gGR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gGR);
      }
      i = paramInt;
      if (this.Eao != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Eao);
      }
      paramInt = i;
      if (this.Eap != null) {
        paramInt = i + f.a.a.a.kW(7, this.Eap.computeSize());
      }
      i = paramInt;
      if (this.Eaq != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Eaq);
      }
      paramInt = i;
      if (this.uns != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.uns);
      }
      i = paramInt;
      if (this.dca != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.dca);
      }
      paramInt = i;
      if (this.Ear != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Ear);
      }
      i = paramInt;
      if (this.Eas != null) {
        i = paramInt + f.a.a.a.kW(12, this.Eas.computeSize());
      }
      AppMethodBeat.o(72556);
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
          AppMethodBeat.o(72556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cef localcef = (cef)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72556);
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
            localcef.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 2: 
          localcef.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72556);
          return 0;
        case 3: 
          localcef.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 4: 
          localcef.Ean = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 5: 
          localcef.gGR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 6: 
          localcef.Eao = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcef.Eap = ((qc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 8: 
          localcef.Eaq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 9: 
          localcef.uns = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 10: 
          localcef.dca = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 11: 
          localcef.Ear = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72556);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ddk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ddk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcef.Eas = ((ddk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      AppMethodBeat.o(72556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cef
 * JD-Core Version:    0.7.0.1
 */
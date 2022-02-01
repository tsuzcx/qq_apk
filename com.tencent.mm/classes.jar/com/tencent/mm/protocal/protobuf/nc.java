package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class nc
  extends dpc
{
  public int KND;
  public int KRL;
  public String KRM;
  public long KRi;
  public int KRs;
  public String KRv;
  public GoodsObject KRw;
  public String dNQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212230);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(212230);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KRs);
      if (this.dNQ != null) {
        paramVarArgs.e(7, this.dNQ);
      }
      if (this.KRv != null) {
        paramVarArgs.e(8, this.KRv);
      }
      if (this.KRw != null)
      {
        paramVarArgs.ni(9, this.KRw.computeSize());
        this.KRw.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(11, this.KRi);
      paramVarArgs.aM(14, this.KRL);
      paramVarArgs.aM(15, this.KND);
      if (this.KRM != null) {
        paramVarArgs.e(21, this.KRM);
      }
      AppMethodBeat.o(212230);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KRs);
      paramInt = i;
      if (this.dNQ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.dNQ);
      }
      i = paramInt;
      if (this.KRv != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.KRv);
      }
      paramInt = i;
      if (this.KRw != null) {
        paramInt = i + g.a.a.a.nh(9, this.KRw.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.r(11, this.KRi) + g.a.a.b.b.a.bu(14, this.KRL) + g.a.a.b.b.a.bu(15, this.KND);
      paramInt = i;
      if (this.KRM != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.KRM);
      }
      AppMethodBeat.o(212230);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(212230);
          throw paramVarArgs;
        }
        AppMethodBeat.o(212230);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        nc localnc = (nc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 10: 
        case 12: 
        case 13: 
        case 16: 
        case 17: 
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(212230);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localnc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212230);
          return 0;
        case 2: 
          localnc.KRs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212230);
          return 0;
        case 7: 
          localnc.dNQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212230);
          return 0;
        case 8: 
          localnc.KRv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212230);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new GoodsObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((GoodsObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localnc.KRw = ((GoodsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212230);
          return 0;
        case 11: 
          localnc.KRi = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(212230);
          return 0;
        case 14: 
          localnc.KRL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212230);
          return 0;
        case 15: 
          localnc.KND = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212230);
          return 0;
        }
        localnc.KRM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212230);
        return 0;
      }
      AppMethodBeat.o(212230);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nc
 * JD-Core Version:    0.7.0.1
 */
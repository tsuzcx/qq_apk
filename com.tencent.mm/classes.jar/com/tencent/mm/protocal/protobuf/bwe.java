package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bwe
  extends dpc
{
  public boolean Mca = false;
  public int Mcb;
  public int Mcc;
  public aib Mcd;
  public aib Mce;
  public String Mcf;
  public String iwv;
  public String iww;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200206);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(200206);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(2, this.Mca);
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      if (this.iwv != null) {
        paramVarArgs.e(4, this.iwv);
      }
      if (this.iww != null) {
        paramVarArgs.e(5, this.iww);
      }
      if (this.url != null) {
        paramVarArgs.e(6, this.url);
      }
      paramVarArgs.aM(7, this.Mcb);
      paramVarArgs.aM(8, this.Mcc);
      if (this.Mcd != null)
      {
        paramVarArgs.ni(9, this.Mcd.computeSize());
        this.Mcd.writeFields(paramVarArgs);
      }
      if (this.Mce != null)
      {
        paramVarArgs.ni(10, this.Mce.computeSize());
        this.Mce.writeFields(paramVarArgs);
      }
      if (this.Mcf != null) {
        paramVarArgs.e(11, this.Mcf);
      }
      AppMethodBeat.o(200206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1106;
      }
    }
    label1106:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 1);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.title);
      }
      i = paramInt;
      if (this.iwv != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.iwv);
      }
      paramInt = i;
      if (this.iww != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.iww);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.url);
      }
      i = i + g.a.a.b.b.a.bu(7, this.Mcb) + g.a.a.b.b.a.bu(8, this.Mcc);
      paramInt = i;
      if (this.Mcd != null) {
        paramInt = i + g.a.a.a.nh(9, this.Mcd.computeSize());
      }
      i = paramInt;
      if (this.Mce != null) {
        i = paramInt + g.a.a.a.nh(10, this.Mce.computeSize());
      }
      paramInt = i;
      if (this.Mcf != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Mcf);
      }
      AppMethodBeat.o(200206);
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
          AppMethodBeat.o(200206);
          throw paramVarArgs;
        }
        AppMethodBeat.o(200206);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwe localbwe = (bwe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200206);
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
            localbwe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200206);
          return 0;
        case 2: 
          localbwe.Mca = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(200206);
          return 0;
        case 3: 
          localbwe.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200206);
          return 0;
        case 4: 
          localbwe.iwv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200206);
          return 0;
        case 5: 
          localbwe.iww = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200206);
          return 0;
        case 6: 
          localbwe.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(200206);
          return 0;
        case 7: 
          localbwe.Mcb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(200206);
          return 0;
        case 8: 
          localbwe.Mcc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(200206);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aib();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aib)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbwe.Mcd = ((aib)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200206);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aib();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aib)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbwe.Mce = ((aib)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200206);
          return 0;
        }
        localbwe.Mcf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(200206);
        return 0;
      }
      AppMethodBeat.o(200206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwe
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dor
  extends dpc
{
  public String Cju;
  public String Cjv;
  public String KZa;
  public dx MRU;
  public int dDN;
  public String qwn;
  public String wFL;
  public String ynT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72582);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72582);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      if (this.wFL != null) {
        paramVarArgs.e(4, this.wFL);
      }
      if (this.KZa != null) {
        paramVarArgs.e(5, this.KZa);
      }
      if (this.Cju != null) {
        paramVarArgs.e(6, this.Cju);
      }
      if (this.Cjv != null) {
        paramVarArgs.e(7, this.Cjv);
      }
      if (this.ynT != null) {
        paramVarArgs.e(8, this.ynT);
      }
      if (this.MRU != null)
      {
        paramVarArgs.ni(9, this.MRU.computeSize());
        this.MRU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72582);
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
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt;
      if (this.wFL != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.wFL);
      }
      paramInt = i;
      if (this.KZa != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KZa);
      }
      i = paramInt;
      if (this.Cju != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Cju);
      }
      paramInt = i;
      if (this.Cjv != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Cjv);
      }
      i = paramInt;
      if (this.ynT != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.ynT);
      }
      paramInt = i;
      if (this.MRU != null) {
        paramInt = i + g.a.a.a.nh(9, this.MRU.computeSize());
      }
      AppMethodBeat.o(72582);
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
          AppMethodBeat.o(72582);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dor localdor = (dor)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72582);
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
            localdor.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72582);
          return 0;
        case 2: 
          localdor.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72582);
          return 0;
        case 3: 
          localdor.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 4: 
          localdor.wFL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 5: 
          localdor.KZa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 6: 
          localdor.Cju = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 7: 
          localdor.Cjv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 8: 
          localdor.ynT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72582);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdor.MRU = ((dx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      AppMethodBeat.o(72582);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dor
 * JD-Core Version:    0.7.0.1
 */
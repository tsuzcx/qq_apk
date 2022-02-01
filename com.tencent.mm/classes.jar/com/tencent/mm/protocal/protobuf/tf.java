package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class tf
  extends dpc
{
  public long Brn;
  public int CreateTime;
  public String KHq;
  public String KMl;
  public String LbJ;
  public int LbO;
  public String Lby;
  public String xNG;
  public String xNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152512);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152512);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Lby != null) {
        paramVarArgs.e(3, this.Lby);
      }
      if (this.xNH != null) {
        paramVarArgs.e(4, this.xNH);
      }
      if (this.xNG != null) {
        paramVarArgs.e(5, this.xNG);
      }
      paramVarArgs.aM(9, this.CreateTime);
      paramVarArgs.bb(10, this.Brn);
      if (this.LbJ != null) {
        paramVarArgs.e(11, this.LbJ);
      }
      if (this.KMl != null) {
        paramVarArgs.e(12, this.KMl);
      }
      if (this.KHq != null) {
        paramVarArgs.e(13, this.KHq);
      }
      paramVarArgs.aM(14, this.LbO);
      AppMethodBeat.o(152512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lby != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Lby);
      }
      i = paramInt;
      if (this.xNH != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.xNH);
      }
      paramInt = i;
      if (this.xNG != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.xNG);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.CreateTime) + g.a.a.b.b.a.r(10, this.Brn);
      paramInt = i;
      if (this.LbJ != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.LbJ);
      }
      i = paramInt;
      if (this.KMl != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.KMl);
      }
      paramInt = i;
      if (this.KHq != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.KHq);
      }
      i = g.a.a.b.b.a.bu(14, this.LbO);
      AppMethodBeat.o(152512);
      return paramInt + i;
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
          AppMethodBeat.o(152512);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152512);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        tf localtf = (tf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152512);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localtf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152512);
          return 0;
        case 3: 
          localtf.Lby = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 4: 
          localtf.xNH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 5: 
          localtf.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 9: 
          localtf.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152512);
          return 0;
        case 10: 
          localtf.Brn = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(152512);
          return 0;
        case 11: 
          localtf.LbJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 12: 
          localtf.KMl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152512);
          return 0;
        case 13: 
          localtf.KHq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152512);
          return 0;
        }
        localtf.LbO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152512);
        return 0;
      }
      AppMethodBeat.o(152512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tf
 * JD-Core Version:    0.7.0.1
 */
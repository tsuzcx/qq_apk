package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cuv
  extends dpc
{
  public String HtE;
  public String HtF;
  public String HtG;
  public int HtH;
  public String HtI;
  public String HuS;
  public cki MAb;
  public String MAc;
  public amh MAd;
  public String MAe;
  public ckj efB;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91559);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91559);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      if (this.MAb != null)
      {
        paramVarArgs.ni(4, this.MAb.computeSize());
        this.MAb.writeFields(paramVarArgs);
      }
      if (this.HtE != null) {
        paramVarArgs.e(5, this.HtE);
      }
      if (this.HtF != null) {
        paramVarArgs.e(6, this.HtF);
      }
      if (this.HtG != null) {
        paramVarArgs.e(7, this.HtG);
      }
      paramVarArgs.aM(8, this.HtH);
      if (this.HtI != null) {
        paramVarArgs.e(9, this.HtI);
      }
      if (this.MAc != null) {
        paramVarArgs.e(10, this.MAc);
      }
      if (this.MAd != null)
      {
        paramVarArgs.ni(11, this.MAd.computeSize());
        this.MAd.writeFields(paramVarArgs);
      }
      if (this.MAe != null) {
        paramVarArgs.e(12, this.MAe);
      }
      if (this.efB != null)
      {
        paramVarArgs.ni(99, this.efB.computeSize());
        this.efB.writeFields(paramVarArgs);
      }
      if (this.HuS != null) {
        paramVarArgs.e(100, this.HuS);
      }
      AppMethodBeat.o(91559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1458;
      }
    }
    label1458:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.MAb != null) {
        i = paramInt + g.a.a.a.nh(4, this.MAb.computeSize());
      }
      paramInt = i;
      if (this.HtE != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.HtE);
      }
      i = paramInt;
      if (this.HtF != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.HtF);
      }
      paramInt = i;
      if (this.HtG != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.HtG);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.HtH);
      paramInt = i;
      if (this.HtI != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.HtI);
      }
      i = paramInt;
      if (this.MAc != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.MAc);
      }
      paramInt = i;
      if (this.MAd != null) {
        paramInt = i + g.a.a.a.nh(11, this.MAd.computeSize());
      }
      i = paramInt;
      if (this.MAe != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.MAe);
      }
      paramInt = i;
      if (this.efB != null) {
        paramInt = i + g.a.a.a.nh(99, this.efB.computeSize());
      }
      i = paramInt;
      if (this.HuS != null) {
        i = paramInt + g.a.a.b.b.a.f(100, this.HuS);
      }
      AppMethodBeat.o(91559);
      return i;
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
          AppMethodBeat.o(91559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91559);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cuv localcuv = (cuv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91559);
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
            localcuv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 2: 
          localcuv.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91559);
          return 0;
        case 3: 
          localcuv.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cki();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cki)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcuv.MAb = ((cki)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 5: 
          localcuv.HtE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 6: 
          localcuv.HtF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 7: 
          localcuv.HtG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 8: 
          localcuv.HtH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91559);
          return 0;
        case 9: 
          localcuv.HtI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 10: 
          localcuv.MAc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcuv.MAd = ((amh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 12: 
          localcuv.MAe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 99: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcuv.efB = ((ckj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        }
        localcuv.HuS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91559);
        return 0;
      }
      AppMethodBeat.o(91559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuv
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dhl
  extends dpc
{
  public String HuS;
  public String MIm;
  public String MIn;
  public ay MLL;
  public ehj MLM;
  public ddf MLN;
  public String MLO;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72565);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72565);
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
      if (this.MIm != null) {
        paramVarArgs.e(4, this.MIm);
      }
      if (this.MIn != null) {
        paramVarArgs.e(5, this.MIn);
      }
      if (this.MLL != null)
      {
        paramVarArgs.ni(6, this.MLL.computeSize());
        this.MLL.writeFields(paramVarArgs);
      }
      if (this.MLM != null)
      {
        paramVarArgs.ni(7, this.MLM.computeSize());
        this.MLM.writeFields(paramVarArgs);
      }
      if (this.MLN != null)
      {
        paramVarArgs.ni(8, this.MLN.computeSize());
        this.MLN.writeFields(paramVarArgs);
      }
      if (this.MLO != null) {
        paramVarArgs.e(9, this.MLO);
      }
      if (this.HuS != null) {
        paramVarArgs.e(100, this.HuS);
      }
      AppMethodBeat.o(72565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1210;
      }
    }
    label1210:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.MIm != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MIm);
      }
      paramInt = i;
      if (this.MIn != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MIn);
      }
      i = paramInt;
      if (this.MLL != null) {
        i = paramInt + g.a.a.a.nh(6, this.MLL.computeSize());
      }
      paramInt = i;
      if (this.MLM != null) {
        paramInt = i + g.a.a.a.nh(7, this.MLM.computeSize());
      }
      i = paramInt;
      if (this.MLN != null) {
        i = paramInt + g.a.a.a.nh(8, this.MLN.computeSize());
      }
      paramInt = i;
      if (this.MLO != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MLO);
      }
      i = paramInt;
      if (this.HuS != null) {
        i = paramInt + g.a.a.b.b.a.f(100, this.HuS);
      }
      AppMethodBeat.o(72565);
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
          AppMethodBeat.o(72565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72565);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhl localdhl = (dhl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72565);
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
            localdhl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 2: 
          localdhl.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72565);
          return 0;
        case 3: 
          localdhl.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 4: 
          localdhl.MIm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 5: 
          localdhl.MIn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ay();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ay)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhl.MLL = ((ay)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhl.MLM = ((ehj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhl.MLN = ((ddf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 9: 
          localdhl.MLO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72565);
          return 0;
        }
        localdhl.HuS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72565);
        return 0;
      }
      AppMethodBeat.o(72565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhl
 * JD-Core Version:    0.7.0.1
 */
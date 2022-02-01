package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ekq
  extends dpc
{
  public String KJw;
  public String MFi;
  public String MOB;
  public int MeU;
  public String NjQ;
  public String NjR;
  public dxw NjS;
  public String NjT;
  public com.tencent.mm.bw.b NjU;
  public int dIZ;
  public String dJa;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152714);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152714);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dIZ);
      if (this.dJa != null) {
        paramVarArgs.e(3, this.dJa);
      }
      if (this.NjQ != null) {
        paramVarArgs.e(4, this.NjQ);
      }
      if (this.NjR != null) {
        paramVarArgs.e(5, this.NjR);
      }
      if (this.NjS != null)
      {
        paramVarArgs.ni(6, this.NjS.computeSize());
        this.NjS.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.version);
      if (this.NjT != null) {
        paramVarArgs.e(8, this.NjT);
      }
      paramVarArgs.aM(9, this.MeU);
      if (this.MFi != null) {
        paramVarArgs.e(10, this.MFi);
      }
      if (this.MOB != null) {
        paramVarArgs.e(11, this.MOB);
      }
      if (this.KJw != null) {
        paramVarArgs.e(12, this.KJw);
      }
      if (this.NjU != null) {
        paramVarArgs.c(13, this.NjU);
      }
      AppMethodBeat.o(152714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1142;
      }
    }
    label1142:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dIZ);
      paramInt = i;
      if (this.dJa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dJa);
      }
      i = paramInt;
      if (this.NjQ != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.NjQ);
      }
      paramInt = i;
      if (this.NjR != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.NjR);
      }
      i = paramInt;
      if (this.NjS != null) {
        i = paramInt + g.a.a.a.nh(6, this.NjS.computeSize());
      }
      i += g.a.a.b.b.a.bu(7, this.version);
      paramInt = i;
      if (this.NjT != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.NjT);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.MeU);
      paramInt = i;
      if (this.MFi != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MFi);
      }
      i = paramInt;
      if (this.MOB != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.MOB);
      }
      paramInt = i;
      if (this.KJw != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KJw);
      }
      i = paramInt;
      if (this.NjU != null) {
        i = paramInt + g.a.a.b.b.a.b(13, this.NjU);
      }
      AppMethodBeat.o(152714);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152714);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ekq localekq = (ekq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152714);
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
            localekq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        case 2: 
          localekq.dIZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152714);
          return 0;
        case 3: 
          localekq.dJa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 4: 
          localekq.NjQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 5: 
          localekq.NjR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localekq.NjS = ((dxw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        case 7: 
          localekq.version = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152714);
          return 0;
        case 8: 
          localekq.NjT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 9: 
          localekq.MeU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152714);
          return 0;
        case 10: 
          localekq.MFi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 11: 
          localekq.MOB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 12: 
          localekq.KJw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152714);
          return 0;
        }
        localekq.NjU = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(152714);
        return 0;
      }
      AppMethodBeat.o(152714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekq
 * JD-Core Version:    0.7.0.1
 */
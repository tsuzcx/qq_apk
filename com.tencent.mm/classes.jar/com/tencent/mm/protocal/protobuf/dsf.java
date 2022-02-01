package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dsf
  extends dpc
{
  public String KOX;
  public cpl KOY;
  public cat KPD;
  public cau KPE;
  public int MUK;
  public dv MUL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32422);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.KOY == null)
      {
        paramVarArgs = new b("Not all required fields were included: Contact");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.KPD == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.KPE == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
        AppMethodBeat.o(32422);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KOY != null)
      {
        paramVarArgs.ni(2, this.KOY.computeSize());
        this.KOY.writeFields(paramVarArgs);
      }
      if (this.KPD != null)
      {
        paramVarArgs.ni(3, this.KPD.computeSize());
        this.KPD.writeFields(paramVarArgs);
      }
      if (this.KPE != null)
      {
        paramVarArgs.ni(4, this.KPE.computeSize());
        this.KPE.writeFields(paramVarArgs);
      }
      if (this.KOX != null) {
        paramVarArgs.e(5, this.KOX);
      }
      paramVarArgs.aM(6, this.MUK);
      if (this.MUL != null)
      {
        paramVarArgs.ni(7, this.MUL.computeSize());
        this.MUL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1247;
      }
    }
    label1247:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KOY != null) {
        paramInt = i + g.a.a.a.nh(2, this.KOY.computeSize());
      }
      i = paramInt;
      if (this.KPD != null) {
        i = paramInt + g.a.a.a.nh(3, this.KPD.computeSize());
      }
      paramInt = i;
      if (this.KPE != null) {
        paramInt = i + g.a.a.a.nh(4, this.KPE.computeSize());
      }
      i = paramInt;
      if (this.KOX != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KOX);
      }
      i += g.a.a.b.b.a.bu(6, this.MUK);
      paramInt = i;
      if (this.MUL != null) {
        paramInt = i + g.a.a.a.nh(7, this.MUL.computeSize());
      }
      AppMethodBeat.o(32422);
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
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.KOY == null)
        {
          paramVarArgs = new b("Not all required fields were included: Contact");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.KPD == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        if (this.KPE == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDeviceAttr");
          AppMethodBeat.o(32422);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dsf localdsf = (dsf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32422);
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
            localdsf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdsf.KOY = ((cpl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cat();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cat)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdsf.KPD = ((cat)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cau();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cau)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdsf.KPE = ((cau)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32422);
          return 0;
        case 5: 
          localdsf.KOX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32422);
          return 0;
        case 6: 
          localdsf.MUK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32422);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdsf.MUL = ((dv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32422);
        return 0;
      }
      AppMethodBeat.o(32422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsf
 * JD-Core Version:    0.7.0.1
 */
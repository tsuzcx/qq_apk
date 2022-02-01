package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqb
  extends dpc
{
  public int KTQ;
  public awn LBR;
  public int LBS;
  public bbf LBT;
  public FinderObject LBU;
  public LinkedList<axk> LBV;
  public axk LBW;
  public LinkedList<avh> LBX;
  public awt live_notice_info;
  
  public aqb()
  {
    AppMethodBeat.i(209367);
    this.LBV = new LinkedList();
    this.LBX = new LinkedList();
    AppMethodBeat.o(209367);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209368);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LBR != null)
      {
        paramVarArgs.ni(2, this.LBR.computeSize());
        this.LBR.writeFields(paramVarArgs);
      }
      if (this.live_notice_info != null)
      {
        paramVarArgs.ni(3, this.live_notice_info.computeSize());
        this.live_notice_info.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.KTQ);
      paramVarArgs.aM(5, this.LBS);
      if (this.LBT != null)
      {
        paramVarArgs.ni(6, this.LBT.computeSize());
        this.LBT.writeFields(paramVarArgs);
      }
      if (this.LBU != null)
      {
        paramVarArgs.ni(7, this.LBU.computeSize());
        this.LBU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.LBV);
      if (this.LBW != null)
      {
        paramVarArgs.ni(9, this.LBW.computeSize());
        this.LBW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.LBX);
      AppMethodBeat.o(209368);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1458;
      }
    }
    label1458:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LBR != null) {
        paramInt = i + g.a.a.a.nh(2, this.LBR.computeSize());
      }
      i = paramInt;
      if (this.live_notice_info != null) {
        i = paramInt + g.a.a.a.nh(3, this.live_notice_info.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(4, this.KTQ) + g.a.a.b.b.a.bu(5, this.LBS);
      paramInt = i;
      if (this.LBT != null) {
        paramInt = i + g.a.a.a.nh(6, this.LBT.computeSize());
      }
      i = paramInt;
      if (this.LBU != null) {
        i = paramInt + g.a.a.a.nh(7, this.LBU.computeSize());
      }
      i += g.a.a.a.c(8, 8, this.LBV);
      paramInt = i;
      if (this.LBW != null) {
        paramInt = i + g.a.a.a.nh(9, this.LBW.computeSize());
      }
      i = g.a.a.a.c(10, 8, this.LBX);
      AppMethodBeat.o(209368);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LBV.clear();
        this.LBX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209368);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqb localaqb = (aqb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209368);
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
            localaqb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209368);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqb.LBR = ((awn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209368);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqb.live_notice_info = ((awt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209368);
          return 0;
        case 4: 
          localaqb.KTQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209368);
          return 0;
        case 5: 
          localaqb.LBS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209368);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bbf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bbf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqb.LBT = ((bbf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209368);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqb.LBU = ((FinderObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209368);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqb.LBV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209368);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqb.LBW = ((axk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209368);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaqb.LBX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209368);
        return 0;
      }
      AppMethodBeat.o(209368);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqb
 * JD-Core Version:    0.7.0.1
 */
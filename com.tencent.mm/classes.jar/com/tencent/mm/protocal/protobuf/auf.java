package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class auf
  extends dpc
{
  public LinkedList<axl> LDJ;
  public avn LDQ;
  public b LDx;
  public awn LES;
  public axo LET;
  public aug LEU;
  public LinkedList<aus> LEV;
  public int LEW;
  public int LEX;
  public long LEY;
  public String LEZ;
  public cjb hIv;
  public awe liveInfo;
  public axg uEm;
  
  public auf()
  {
    AppMethodBeat.i(209469);
    this.LDJ = new LinkedList();
    this.LEV = new LinkedList();
    AppMethodBeat.o(209469);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209470);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LDx != null) {
        paramVarArgs.c(2, this.LDx);
      }
      if (this.hIv != null)
      {
        paramVarArgs.ni(3, this.hIv.computeSize());
        this.hIv.writeFields(paramVarArgs);
      }
      if (this.liveInfo != null)
      {
        paramVarArgs.ni(4, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      if (this.LES != null)
      {
        paramVarArgs.ni(5, this.LES.computeSize());
        this.LES.writeFields(paramVarArgs);
      }
      if (this.LET != null)
      {
        paramVarArgs.ni(6, this.LET.computeSize());
        this.LET.writeFields(paramVarArgs);
      }
      if (this.uEm != null)
      {
        paramVarArgs.ni(7, this.uEm.computeSize());
        this.uEm.writeFields(paramVarArgs);
      }
      if (this.LDQ != null)
      {
        paramVarArgs.ni(8, this.LDQ.computeSize());
        this.LDQ.writeFields(paramVarArgs);
      }
      if (this.LEU != null)
      {
        paramVarArgs.ni(9, this.LEU.computeSize());
        this.LEU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.LDJ);
      paramVarArgs.e(11, 8, this.LEV);
      paramVarArgs.aM(12, this.LEW);
      paramVarArgs.aM(13, this.LEX);
      paramVarArgs.bb(14, this.LEY);
      if (this.LEZ != null) {
        paramVarArgs.e(15, this.LEZ);
      }
      AppMethodBeat.o(209470);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1934;
      }
    }
    label1934:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LDx != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.LDx);
      }
      i = paramInt;
      if (this.hIv != null) {
        i = paramInt + g.a.a.a.nh(3, this.hIv.computeSize());
      }
      paramInt = i;
      if (this.liveInfo != null) {
        paramInt = i + g.a.a.a.nh(4, this.liveInfo.computeSize());
      }
      i = paramInt;
      if (this.LES != null) {
        i = paramInt + g.a.a.a.nh(5, this.LES.computeSize());
      }
      paramInt = i;
      if (this.LET != null) {
        paramInt = i + g.a.a.a.nh(6, this.LET.computeSize());
      }
      i = paramInt;
      if (this.uEm != null) {
        i = paramInt + g.a.a.a.nh(7, this.uEm.computeSize());
      }
      paramInt = i;
      if (this.LDQ != null) {
        paramInt = i + g.a.a.a.nh(8, this.LDQ.computeSize());
      }
      i = paramInt;
      if (this.LEU != null) {
        i = paramInt + g.a.a.a.nh(9, this.LEU.computeSize());
      }
      i = i + g.a.a.a.c(10, 8, this.LDJ) + g.a.a.a.c(11, 8, this.LEV) + g.a.a.b.b.a.bu(12, this.LEW) + g.a.a.b.b.a.bu(13, this.LEX) + g.a.a.b.b.a.r(14, this.LEY);
      paramInt = i;
      if (this.LEZ != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.LEZ);
      }
      AppMethodBeat.o(209470);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LDJ.clear();
        this.LEV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209470);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        auf localauf = (auf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209470);
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
            localauf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209470);
          return 0;
        case 2: 
          localauf.LDx = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209470);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauf.hIv = ((cjb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209470);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauf.liveInfo = ((awe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209470);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauf.LES = ((awn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209470);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauf.LET = ((axo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209470);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauf.uEm = ((axg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209470);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauf.LDQ = ((avn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209470);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aug();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aug)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauf.LEU = ((aug)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209470);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauf.LDJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209470);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aus();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aus)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localauf.LEV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209470);
          return 0;
        case 12: 
          localauf.LEW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209470);
          return 0;
        case 13: 
          localauf.LEX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209470);
          return 0;
        case 14: 
          localauf.LEY = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209470);
          return 0;
        }
        localauf.LEZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209470);
        return 0;
      }
      AppMethodBeat.o(209470);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auf
 * JD-Core Version:    0.7.0.1
 */
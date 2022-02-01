package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ass
  extends dpc
{
  public LinkedList<awq> FoQ;
  public awn LBR;
  public int LDA;
  public int LDB;
  public int LDC;
  public int LDD;
  public int LDE;
  public int LDF;
  public awu LDG;
  public int LDH;
  public LinkedList<aut> LDI;
  public LinkedList<axl> LDJ;
  public avi LDK;
  public b LDx;
  public LinkedList<FinderContact> LDz;
  public awe liveInfo;
  
  public ass()
  {
    AppMethodBeat.i(209422);
    this.LDz = new LinkedList();
    this.FoQ = new LinkedList();
    this.LDI = new LinkedList();
    this.LDJ = new LinkedList();
    AppMethodBeat.o(209422);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209423);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.LDz);
      paramVarArgs.e(3, 8, this.FoQ);
      if (this.liveInfo != null)
      {
        paramVarArgs.ni(4, this.liveInfo.computeSize());
        this.liveInfo.writeFields(paramVarArgs);
      }
      if (this.LDx != null) {
        paramVarArgs.c(5, this.LDx);
      }
      paramVarArgs.aM(6, this.LDA);
      paramVarArgs.aM(7, this.LDB);
      paramVarArgs.aM(8, this.LDC);
      if (this.LBR != null)
      {
        paramVarArgs.ni(9, this.LBR.computeSize());
        this.LBR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(10, this.LDD);
      paramVarArgs.aM(11, this.LDE);
      paramVarArgs.aM(12, this.LDF);
      if (this.LDG != null)
      {
        paramVarArgs.ni(13, this.LDG.computeSize());
        this.LDG.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(14, this.LDH);
      paramVarArgs.e(15, 8, this.LDI);
      paramVarArgs.e(16, 8, this.LDJ);
      if (this.LDK != null)
      {
        paramVarArgs.ni(17, this.LDK.computeSize());
        this.LDK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209423);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1862;
      }
    }
    label1862:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.LDz) + g.a.a.a.c(3, 8, this.FoQ);
      paramInt = i;
      if (this.liveInfo != null) {
        paramInt = i + g.a.a.a.nh(4, this.liveInfo.computeSize());
      }
      i = paramInt;
      if (this.LDx != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.LDx);
      }
      i = i + g.a.a.b.b.a.bu(6, this.LDA) + g.a.a.b.b.a.bu(7, this.LDB) + g.a.a.b.b.a.bu(8, this.LDC);
      paramInt = i;
      if (this.LBR != null) {
        paramInt = i + g.a.a.a.nh(9, this.LBR.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.LDD) + g.a.a.b.b.a.bu(11, this.LDE) + g.a.a.b.b.a.bu(12, this.LDF);
      paramInt = i;
      if (this.LDG != null) {
        paramInt = i + g.a.a.a.nh(13, this.LDG.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.LDH) + g.a.a.a.c(15, 8, this.LDI) + g.a.a.a.c(16, 8, this.LDJ);
      paramInt = i;
      if (this.LDK != null) {
        paramInt = i + g.a.a.a.nh(17, this.LDK.computeSize());
      }
      AppMethodBeat.o(209423);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LDz.clear();
        this.FoQ.clear();
        this.LDI.clear();
        this.LDJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209423);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ass localass = (ass)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209423);
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
            localass.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209423);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localass.LDz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209423);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localass.FoQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209423);
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
            localass.liveInfo = ((awe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209423);
          return 0;
        case 5: 
          localass.LDx = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209423);
          return 0;
        case 6: 
          localass.LDA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209423);
          return 0;
        case 7: 
          localass.LDB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209423);
          return 0;
        case 8: 
          localass.LDC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209423);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localass.LBR = ((awn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209423);
          return 0;
        case 10: 
          localass.LDD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209423);
          return 0;
        case 11: 
          localass.LDE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209423);
          return 0;
        case 12: 
          localass.LDF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209423);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localass.LDG = ((awu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209423);
          return 0;
        case 14: 
          localass.LDH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209423);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aut();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aut)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localass.LDI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209423);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localass.LDJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209423);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localass.LDK = ((avi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209423);
        return 0;
      }
      AppMethodBeat.o(209423);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ass
 * JD-Core Version:    0.7.0.1
 */
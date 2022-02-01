package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public class bcz
  extends dop
{
  public apc LAv;
  public LinkedList<ecq> LEw;
  public String LFm;
  public LinkedList<cmm> LIs;
  public LinkedList<bdv> LMA;
  public int LMB;
  public String LMC;
  public avk LMD;
  public int LMw;
  public long LMx;
  public String LMy;
  public long LMz;
  public int dLS;
  public float dTj;
  public String finderUsername;
  public b lastBuffer;
  public float latitude;
  public int pullType;
  public String sessionId;
  public b tVe;
  public b tabTipsByPassInfo;
  public aov uli;
  
  public bcz()
  {
    AppMethodBeat.i(184211);
    this.LIs = new LinkedList();
    this.LEw = new LinkedList();
    this.LMA = new LinkedList();
    AppMethodBeat.o(184211);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169056);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      if (this.finderUsername != null) {
        paramVarArgs.e(4, this.finderUsername);
      }
      paramVarArgs.aM(5, this.pullType);
      if (this.uli != null)
      {
        paramVarArgs.ni(6, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      paramVarArgs.E(7, this.dTj);
      paramVarArgs.E(8, this.latitude);
      if (this.sessionId != null) {
        paramVarArgs.e(9, this.sessionId);
      }
      if (this.LAv != null)
      {
        paramVarArgs.ni(10, this.LAv.computeSize());
        this.LAv.writeFields(paramVarArgs);
      }
      paramVarArgs.e(11, 8, this.LIs);
      paramVarArgs.aM(12, this.LMw);
      paramVarArgs.aM(13, this.dLS);
      paramVarArgs.bb(14, this.LMx);
      if (this.LMy != null) {
        paramVarArgs.e(15, this.LMy);
      }
      paramVarArgs.e(16, 8, this.LEw);
      paramVarArgs.bb(17, this.LMz);
      paramVarArgs.e(18, 8, this.LMA);
      if (this.tVe != null) {
        paramVarArgs.c(19, this.tVe);
      }
      paramVarArgs.aM(20, this.LMB);
      if (this.LMC != null) {
        paramVarArgs.e(21, this.LMC);
      }
      if (this.tabTipsByPassInfo != null) {
        paramVarArgs.c(22, this.tabTipsByPassInfo);
      }
      if (this.LMD != null)
      {
        paramVarArgs.ni(23, this.LMD.computeSize());
        this.LMD.writeFields(paramVarArgs);
      }
      if (this.LFm != null) {
        paramVarArgs.e(24, this.LFm);
      }
      AppMethodBeat.o(169056);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2056;
      }
    }
    label2056:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.finderUsername);
      }
      i += g.a.a.b.b.a.bu(5, this.pullType);
      paramInt = i;
      if (this.uli != null) {
        paramInt = i + g.a.a.a.nh(6, this.uli.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.fS(7) + 4) + (g.a.a.b.b.a.fS(8) + 4);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.sessionId);
      }
      i = paramInt;
      if (this.LAv != null) {
        i = paramInt + g.a.a.a.nh(10, this.LAv.computeSize());
      }
      i = i + g.a.a.a.c(11, 8, this.LIs) + g.a.a.b.b.a.bu(12, this.LMw) + g.a.a.b.b.a.bu(13, this.dLS) + g.a.a.b.b.a.r(14, this.LMx);
      paramInt = i;
      if (this.LMy != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.LMy);
      }
      i = paramInt + g.a.a.a.c(16, 8, this.LEw) + g.a.a.b.b.a.r(17, this.LMz) + g.a.a.a.c(18, 8, this.LMA);
      paramInt = i;
      if (this.tVe != null) {
        paramInt = i + g.a.a.b.b.a.b(19, this.tVe);
      }
      i = paramInt + g.a.a.b.b.a.bu(20, this.LMB);
      paramInt = i;
      if (this.LMC != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.LMC);
      }
      i = paramInt;
      if (this.tabTipsByPassInfo != null) {
        i = paramInt + g.a.a.b.b.a.b(22, this.tabTipsByPassInfo);
      }
      paramInt = i;
      if (this.LMD != null) {
        paramInt = i + g.a.a.a.nh(23, this.LMD.computeSize());
      }
      i = paramInt;
      if (this.LFm != null) {
        i = paramInt + g.a.a.b.b.a.f(24, this.LFm);
      }
      AppMethodBeat.o(169056);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LIs.clear();
        this.LEw.clear();
        this.LMA.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169056);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bcz localbcz = (bcz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(169056);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcz.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 3: 
          localbcz.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(169056);
          return 0;
        case 4: 
          localbcz.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 5: 
          localbcz.pullType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169056);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcz.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 7: 
          localbcz.dTj = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(169056);
          return 0;
        case 8: 
          localbcz.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(169056);
          return 0;
        case 9: 
          localbcz.sessionId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcz.LAv = ((apc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcz.LIs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 12: 
          localbcz.LMw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169056);
          return 0;
        case 13: 
          localbcz.dLS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169056);
          return 0;
        case 14: 
          localbcz.LMx = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169056);
          return 0;
        case 15: 
          localbcz.LMy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcz.LEw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 17: 
          localbcz.LMz = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169056);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcz.LMA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        case 19: 
          localbcz.tVe = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(169056);
          return 0;
        case 20: 
          localbcz.LMB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169056);
          return 0;
        case 21: 
          localbcz.LMC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169056);
          return 0;
        case 22: 
          localbcz.tabTipsByPassInfo = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(169056);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcz.LMD = ((avk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169056);
          return 0;
        }
        localbcz.LFm = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169056);
        return 0;
      }
      AppMethodBeat.o(169056);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcz
 * JD-Core Version:    0.7.0.1
 */
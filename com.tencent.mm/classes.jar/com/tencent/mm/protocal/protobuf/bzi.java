package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzi
  extends com.tencent.mm.bw.a
{
  public LinkedList<cxn> GroupUser;
  public int HmG;
  public int HmH;
  public LinkedList<bwe> HmI;
  public LinkedList<did> HmJ;
  public int HmK;
  public long HmL;
  public int HmM;
  public LinkedList<Long> HmN;
  public int HmO;
  public int HmP;
  public String HmQ;
  public int HmR;
  public dhd HmS;
  public LinkedList<dhj> HmT;
  public String HmU;
  public long HmV;
  public String HmW;
  public boolean HmX;
  public dgd HmY;
  public cgs HmZ;
  public int Hml;
  public String dIz;
  public int dPd;
  public String hFO;
  public int hiJ;
  public String sessionId;
  public String token;
  public String xrf;
  
  public bzi()
  {
    AppMethodBeat.i(125744);
    this.HmI = new LinkedList();
    this.HmJ = new LinkedList();
    this.HmN = new LinkedList();
    this.GroupUser = new LinkedList();
    this.HmT = new LinkedList();
    AppMethodBeat.o(125744);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125745);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HmG);
      paramVarArgs.aS(2, this.HmH);
      paramVarArgs.aS(3, this.Hml);
      if (this.hFO != null) {
        paramVarArgs.d(4, this.hFO);
      }
      paramVarArgs.e(5, 8, this.HmI);
      paramVarArgs.e(6, 8, this.HmJ);
      paramVarArgs.aS(7, this.HmK);
      paramVarArgs.aS(8, this.hiJ);
      paramVarArgs.aZ(9, this.HmL);
      paramVarArgs.aS(10, this.HmM);
      paramVarArgs.e(11, 3, this.HmN);
      paramVarArgs.aS(12, this.HmO);
      paramVarArgs.aS(13, this.HmP);
      if (this.token != null) {
        paramVarArgs.d(14, this.token);
      }
      if (this.HmQ != null) {
        paramVarArgs.d(15, this.HmQ);
      }
      paramVarArgs.aS(16, this.HmR);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.HmS != null)
      {
        paramVarArgs.lJ(18, this.HmS.computeSize());
        this.HmS.writeFields(paramVarArgs);
      }
      if (this.dIz != null) {
        paramVarArgs.d(19, this.dIz);
      }
      paramVarArgs.e(20, 8, this.HmT);
      if (this.sessionId != null) {
        paramVarArgs.d(21, this.sessionId);
      }
      if (this.HmU != null) {
        paramVarArgs.d(22, this.HmU);
      }
      if (this.xrf != null) {
        paramVarArgs.d(23, this.xrf);
      }
      paramVarArgs.aS(24, this.dPd);
      paramVarArgs.aZ(25, this.HmV);
      if (this.HmW != null) {
        paramVarArgs.d(26, this.HmW);
      }
      paramVarArgs.bC(27, this.HmX);
      if (this.HmY != null)
      {
        paramVarArgs.lJ(28, this.HmY.computeSize());
        this.HmY.writeFields(paramVarArgs);
      }
      if (this.HmZ != null)
      {
        paramVarArgs.lJ(29, this.HmZ.computeSize());
        this.HmZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HmG) + 0 + f.a.a.b.b.a.bz(2, this.HmH) + f.a.a.b.b.a.bz(3, this.Hml);
      paramInt = i;
      if (this.hFO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hFO);
      }
      i = paramInt + f.a.a.a.c(5, 8, this.HmI) + f.a.a.a.c(6, 8, this.HmJ) + f.a.a.b.b.a.bz(7, this.HmK) + f.a.a.b.b.a.bz(8, this.hiJ) + f.a.a.b.b.a.p(9, this.HmL) + f.a.a.b.b.a.bz(10, this.HmM) + f.a.a.a.c(11, 3, this.HmN) + f.a.a.b.b.a.bz(12, this.HmO) + f.a.a.b.b.a.bz(13, this.HmP);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.token);
      }
      i = paramInt;
      if (this.HmQ != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.HmQ);
      }
      i = i + f.a.a.b.b.a.bz(16, this.HmR) + f.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.HmS != null) {
        paramInt = i + f.a.a.a.lI(18, this.HmS.computeSize());
      }
      i = paramInt;
      if (this.dIz != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.dIz);
      }
      i += f.a.a.a.c(20, 8, this.HmT);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.sessionId);
      }
      i = paramInt;
      if (this.HmU != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.HmU);
      }
      paramInt = i;
      if (this.xrf != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.xrf);
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.dPd) + f.a.a.b.b.a.p(25, this.HmV);
      paramInt = i;
      if (this.HmW != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.HmW);
      }
      i = paramInt + f.a.a.b.b.a.amF(27);
      paramInt = i;
      if (this.HmY != null) {
        paramInt = i + f.a.a.a.lI(28, this.HmY.computeSize());
      }
      i = paramInt;
      if (this.HmZ != null) {
        i = paramInt + f.a.a.a.lI(29, this.HmZ.computeSize());
      }
      AppMethodBeat.o(125745);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HmI.clear();
      this.HmJ.clear();
      this.HmN.clear();
      this.GroupUser.clear();
      this.HmT.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bzi localbzi = (bzi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125745);
        return -1;
      case 1: 
        localbzi.HmG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 2: 
        localbzi.HmH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 3: 
        localbzi.Hml = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 4: 
        localbzi.hFO = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzi.HmI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new did();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((did)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzi.HmJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 7: 
        localbzi.HmK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 8: 
        localbzi.hiJ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 9: 
        localbzi.HmL = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(125745);
        return 0;
      case 10: 
        localbzi.HmM = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 11: 
        localbzi.HmN.add(Long.valueOf(((f.a.a.a.a)localObject1).OmT.zd()));
        AppMethodBeat.o(125745);
        return 0;
      case 12: 
        localbzi.HmO = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 13: 
        localbzi.HmP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 14: 
        localbzi.token = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 15: 
        localbzi.HmQ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 16: 
        localbzi.HmR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzi.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzi.HmS = ((dhd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 19: 
        localbzi.dIz = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzi.HmT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 21: 
        localbzi.sessionId = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 22: 
        localbzi.HmU = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 23: 
        localbzi.xrf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 24: 
        localbzi.dPd = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 25: 
        localbzi.HmV = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(125745);
        return 0;
      case 26: 
        localbzi.HmW = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 27: 
        localbzi.HmX = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(125745);
        return 0;
      case 28: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzi.HmY = ((dgd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cgs();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cgs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbzi.HmZ = ((cgs)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    AppMethodBeat.o(125745);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzi
 * JD-Core Version:    0.7.0.1
 */
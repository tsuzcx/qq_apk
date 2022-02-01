package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpj
  extends com.tencent.mm.bx.a
{
  public int DMS;
  public LinkedList<cvq> DNA;
  public String DNB;
  public long DNC;
  public String DND;
  public boolean DNE;
  public cuk DNF;
  public bwn DNG;
  public int DNn;
  public int DNo;
  public LinkedList<bmh> DNp;
  public LinkedList<cwk> DNq;
  public int DNr;
  public long DNs;
  public int DNt;
  public LinkedList<Long> DNu;
  public int DNv;
  public int DNw;
  public String DNx;
  public int DNy;
  public cvk DNz;
  public String Ddo;
  public LinkedList<cmf> GroupUser;
  public int dDO;
  public String dxF;
  public String gKn;
  public int gll;
  public String sessionId;
  public String token;
  
  public bpj()
  {
    AppMethodBeat.i(125744);
    this.DNp = new LinkedList();
    this.DNq = new LinkedList();
    this.DNu = new LinkedList();
    this.GroupUser = new LinkedList();
    this.DNA = new LinkedList();
    AppMethodBeat.o(125744);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125745);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DNn);
      paramVarArgs.aR(2, this.DNo);
      paramVarArgs.aR(3, this.DMS);
      if (this.gKn != null) {
        paramVarArgs.d(4, this.gKn);
      }
      paramVarArgs.e(5, 8, this.DNp);
      paramVarArgs.e(6, 8, this.DNq);
      paramVarArgs.aR(7, this.DNr);
      paramVarArgs.aR(8, this.gll);
      paramVarArgs.aG(9, this.DNs);
      paramVarArgs.aR(10, this.DNt);
      paramVarArgs.e(11, 3, this.DNu);
      paramVarArgs.aR(12, this.DNv);
      paramVarArgs.aR(13, this.DNw);
      if (this.token != null) {
        paramVarArgs.d(14, this.token);
      }
      if (this.DNx != null) {
        paramVarArgs.d(15, this.DNx);
      }
      paramVarArgs.aR(16, this.DNy);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.DNz != null)
      {
        paramVarArgs.kX(18, this.DNz.computeSize());
        this.DNz.writeFields(paramVarArgs);
      }
      if (this.dxF != null) {
        paramVarArgs.d(19, this.dxF);
      }
      paramVarArgs.e(20, 8, this.DNA);
      if (this.sessionId != null) {
        paramVarArgs.d(21, this.sessionId);
      }
      if (this.DNB != null) {
        paramVarArgs.d(22, this.DNB);
      }
      if (this.Ddo != null) {
        paramVarArgs.d(23, this.Ddo);
      }
      paramVarArgs.aR(24, this.dDO);
      paramVarArgs.aG(25, this.DNC);
      if (this.DND != null) {
        paramVarArgs.d(26, this.DND);
      }
      paramVarArgs.bg(27, this.DNE);
      if (this.DNF != null)
      {
        paramVarArgs.kX(28, this.DNF.computeSize());
        this.DNF.writeFields(paramVarArgs);
      }
      if (this.DNG != null)
      {
        paramVarArgs.kX(29, this.DNG.computeSize());
        this.DNG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DNn) + 0 + f.a.a.b.b.a.bA(2, this.DNo) + f.a.a.b.b.a.bA(3, this.DMS);
      paramInt = i;
      if (this.gKn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gKn);
      }
      i = paramInt + f.a.a.a.c(5, 8, this.DNp) + f.a.a.a.c(6, 8, this.DNq) + f.a.a.b.b.a.bA(7, this.DNr) + f.a.a.b.b.a.bA(8, this.gll) + f.a.a.b.b.a.q(9, this.DNs) + f.a.a.b.b.a.bA(10, this.DNt) + f.a.a.a.c(11, 3, this.DNu) + f.a.a.b.b.a.bA(12, this.DNv) + f.a.a.b.b.a.bA(13, this.DNw);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.token);
      }
      i = paramInt;
      if (this.DNx != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.DNx);
      }
      i = i + f.a.a.b.b.a.bA(16, this.DNy) + f.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.DNz != null) {
        paramInt = i + f.a.a.a.kW(18, this.DNz.computeSize());
      }
      i = paramInt;
      if (this.dxF != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.dxF);
      }
      i += f.a.a.a.c(20, 8, this.DNA);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.sessionId);
      }
      i = paramInt;
      if (this.DNB != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.DNB);
      }
      paramInt = i;
      if (this.Ddo != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.Ddo);
      }
      i = paramInt + f.a.a.b.b.a.bA(24, this.dDO) + f.a.a.b.b.a.q(25, this.DNC);
      paramInt = i;
      if (this.DND != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.DND);
      }
      i = paramInt + (f.a.a.b.b.a.fY(27) + 1);
      paramInt = i;
      if (this.DNF != null) {
        paramInt = i + f.a.a.a.kW(28, this.DNF.computeSize());
      }
      i = paramInt;
      if (this.DNG != null) {
        i = paramInt + f.a.a.a.kW(29, this.DNG.computeSize());
      }
      AppMethodBeat.o(125745);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DNp.clear();
      this.DNq.clear();
      this.DNu.clear();
      this.GroupUser.clear();
      this.DNA.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bpj localbpj = (bpj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125745);
        return -1;
      case 1: 
        localbpj.DNn = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125745);
        return 0;
      case 2: 
        localbpj.DNo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125745);
        return 0;
      case 3: 
        localbpj.DMS = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125745);
        return 0;
      case 4: 
        localbpj.gKn = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpj.DNp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpj.DNq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 7: 
        localbpj.DNr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125745);
        return 0;
      case 8: 
        localbpj.gll = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125745);
        return 0;
      case 9: 
        localbpj.DNs = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(125745);
        return 0;
      case 10: 
        localbpj.DNt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125745);
        return 0;
      case 11: 
        localbpj.DNu.add(Long.valueOf(((f.a.a.a.a)localObject1).KhF.xT()));
        AppMethodBeat.o(125745);
        return 0;
      case 12: 
        localbpj.DNv = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125745);
        return 0;
      case 13: 
        localbpj.DNw = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125745);
        return 0;
      case 14: 
        localbpj.token = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 15: 
        localbpj.DNx = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 16: 
        localbpj.DNy = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125745);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpj.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpj.DNz = ((cvk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 19: 
        localbpj.dxF = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpj.DNA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 21: 
        localbpj.sessionId = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 22: 
        localbpj.DNB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 23: 
        localbpj.Ddo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 24: 
        localbpj.dDO = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125745);
        return 0;
      case 25: 
        localbpj.DNC = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(125745);
        return 0;
      case 26: 
        localbpj.DND = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 27: 
        localbpj.DNE = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(125745);
        return 0;
      case 28: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cuk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cuk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpj.DNF = ((cuk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bwn();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bwn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbpj.DNG = ((bwn)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpj
 * JD-Core Version:    0.7.0.1
 */
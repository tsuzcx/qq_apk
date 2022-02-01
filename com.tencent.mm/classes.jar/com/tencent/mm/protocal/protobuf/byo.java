package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byo
  extends com.tencent.mm.bx.a
{
  public int GSK;
  public int GTf;
  public int GTg;
  public LinkedList<bvk> GTh;
  public LinkedList<dhj> GTi;
  public int GTj;
  public long GTk;
  public int GTl;
  public LinkedList<Long> GTm;
  public int GTn;
  public int GTo;
  public String GTp;
  public int GTq;
  public dgj GTr;
  public LinkedList<dgp> GTs;
  public String GTt;
  public long GTu;
  public String GTv;
  public boolean GTw;
  public dfj GTx;
  public cfy GTy;
  public LinkedList<cwt> GroupUser;
  public String dHu;
  public int dNN;
  public String hCW;
  public int hfV;
  public String sessionId;
  public String token;
  public String xbo;
  
  public byo()
  {
    AppMethodBeat.i(125744);
    this.GTh = new LinkedList();
    this.GTi = new LinkedList();
    this.GTm = new LinkedList();
    this.GroupUser = new LinkedList();
    this.GTs = new LinkedList();
    AppMethodBeat.o(125744);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125745);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GTf);
      paramVarArgs.aS(2, this.GTg);
      paramVarArgs.aS(3, this.GSK);
      if (this.hCW != null) {
        paramVarArgs.d(4, this.hCW);
      }
      paramVarArgs.e(5, 8, this.GTh);
      paramVarArgs.e(6, 8, this.GTi);
      paramVarArgs.aS(7, this.GTj);
      paramVarArgs.aS(8, this.hfV);
      paramVarArgs.aY(9, this.GTk);
      paramVarArgs.aS(10, this.GTl);
      paramVarArgs.e(11, 3, this.GTm);
      paramVarArgs.aS(12, this.GTn);
      paramVarArgs.aS(13, this.GTo);
      if (this.token != null) {
        paramVarArgs.d(14, this.token);
      }
      if (this.GTp != null) {
        paramVarArgs.d(15, this.GTp);
      }
      paramVarArgs.aS(16, this.GTq);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.GTr != null)
      {
        paramVarArgs.lC(18, this.GTr.computeSize());
        this.GTr.writeFields(paramVarArgs);
      }
      if (this.dHu != null) {
        paramVarArgs.d(19, this.dHu);
      }
      paramVarArgs.e(20, 8, this.GTs);
      if (this.sessionId != null) {
        paramVarArgs.d(21, this.sessionId);
      }
      if (this.GTt != null) {
        paramVarArgs.d(22, this.GTt);
      }
      if (this.xbo != null) {
        paramVarArgs.d(23, this.xbo);
      }
      paramVarArgs.aS(24, this.dNN);
      paramVarArgs.aY(25, this.GTu);
      if (this.GTv != null) {
        paramVarArgs.d(26, this.GTv);
      }
      paramVarArgs.bt(27, this.GTw);
      if (this.GTx != null)
      {
        paramVarArgs.lC(28, this.GTx.computeSize());
        this.GTx.writeFields(paramVarArgs);
      }
      if (this.GTy != null)
      {
        paramVarArgs.lC(29, this.GTy.computeSize());
        this.GTy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GTf) + 0 + f.a.a.b.b.a.bz(2, this.GTg) + f.a.a.b.b.a.bz(3, this.GSK);
      paramInt = i;
      if (this.hCW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hCW);
      }
      i = paramInt + f.a.a.a.c(5, 8, this.GTh) + f.a.a.a.c(6, 8, this.GTi) + f.a.a.b.b.a.bz(7, this.GTj) + f.a.a.b.b.a.bz(8, this.hfV) + f.a.a.b.b.a.p(9, this.GTk) + f.a.a.b.b.a.bz(10, this.GTl) + f.a.a.a.c(11, 3, this.GTm) + f.a.a.b.b.a.bz(12, this.GTn) + f.a.a.b.b.a.bz(13, this.GTo);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.token);
      }
      i = paramInt;
      if (this.GTp != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.GTp);
      }
      i = i + f.a.a.b.b.a.bz(16, this.GTq) + f.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.GTr != null) {
        paramInt = i + f.a.a.a.lB(18, this.GTr.computeSize());
      }
      i = paramInt;
      if (this.dHu != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.dHu);
      }
      i += f.a.a.a.c(20, 8, this.GTs);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.sessionId);
      }
      i = paramInt;
      if (this.GTt != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.GTt);
      }
      paramInt = i;
      if (this.xbo != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.xbo);
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.dNN) + f.a.a.b.b.a.p(25, this.GTu);
      paramInt = i;
      if (this.GTv != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.GTv);
      }
      i = paramInt + f.a.a.b.b.a.alV(27);
      paramInt = i;
      if (this.GTx != null) {
        paramInt = i + f.a.a.a.lB(28, this.GTx.computeSize());
      }
      i = paramInt;
      if (this.GTy != null) {
        i = paramInt + f.a.a.a.lB(29, this.GTy.computeSize());
      }
      AppMethodBeat.o(125745);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GTh.clear();
      this.GTi.clear();
      this.GTm.clear();
      this.GroupUser.clear();
      this.GTs.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125745);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      byo localbyo = (byo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125745);
        return -1;
      case 1: 
        localbyo.GTf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 2: 
        localbyo.GTg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 3: 
        localbyo.GSK = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 4: 
        localbyo.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyo.GTh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dhj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dhj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyo.GTi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 7: 
        localbyo.GTj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 8: 
        localbyo.hfV = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 9: 
        localbyo.GTk = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(125745);
        return 0;
      case 10: 
        localbyo.GTl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 11: 
        localbyo.GTm.add(Long.valueOf(((f.a.a.a.a)localObject1).NPN.zd()));
        AppMethodBeat.o(125745);
        return 0;
      case 12: 
        localbyo.GTn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 13: 
        localbyo.GTo = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 14: 
        localbyo.token = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 15: 
        localbyo.GTp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 16: 
        localbyo.GTq = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyo.GroupUser.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyo.GTr = ((dgj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 19: 
        localbyo.dHu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dgp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dgp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyo.GTs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      case 21: 
        localbyo.sessionId = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 22: 
        localbyo.GTt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 23: 
        localbyo.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 24: 
        localbyo.dNN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125745);
        return 0;
      case 25: 
        localbyo.GTu = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(125745);
        return 0;
      case 26: 
        localbyo.GTv = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(125745);
        return 0;
      case 27: 
        localbyo.GTw = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(125745);
        return 0;
      case 28: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyo.GTx = ((dfj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125745);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cfy();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cfy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbyo.GTy = ((cfy)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byo
 * JD-Core Version:    0.7.0.1
 */
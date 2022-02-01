package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sr
  extends com.tencent.mm.bx.a
{
  public String FPA;
  public aaf FPB;
  public String FPC;
  public aaf FPD;
  public boolean FPE;
  public boolean FPF;
  public int FPi;
  public int FPj;
  public LinkedList<ua> FPk;
  public LinkedList<ua> FPl;
  public LinkedList<ua> FPm;
  public LinkedList<String> FPn;
  public int FPo;
  public int FPp;
  public LinkedList<aaf> FPq;
  public long FPr;
  public int FPs;
  public String FPt;
  public aaf FPu;
  public LinkedList<bc> FPv;
  public aaf FPw;
  public aaf FPx;
  public aaf FPy;
  public aem FPz;
  public String code;
  public int status;
  
  public sr()
  {
    AppMethodBeat.i(113948);
    this.FPk = new LinkedList();
    this.FPl = new LinkedList();
    this.FPm = new LinkedList();
    this.FPn = new LinkedList();
    this.FPq = new LinkedList();
    this.FPv = new LinkedList();
    AppMethodBeat.o(113948);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113949);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.status);
      paramVarArgs.aS(2, this.FPi);
      paramVarArgs.aS(3, this.FPj);
      paramVarArgs.e(4, 8, this.FPk);
      paramVarArgs.e(5, 8, this.FPl);
      paramVarArgs.e(6, 8, this.FPm);
      paramVarArgs.e(7, 1, this.FPn);
      paramVarArgs.aS(8, this.FPo);
      if (this.code != null) {
        paramVarArgs.d(9, this.code);
      }
      paramVarArgs.aS(10, this.FPp);
      paramVarArgs.e(11, 8, this.FPq);
      paramVarArgs.aY(12, this.FPr);
      paramVarArgs.aS(13, this.FPs);
      if (this.FPt != null) {
        paramVarArgs.d(14, this.FPt);
      }
      if (this.FPu != null)
      {
        paramVarArgs.lC(15, this.FPu.computeSize());
        this.FPu.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.FPv);
      if (this.FPw != null)
      {
        paramVarArgs.lC(17, this.FPw.computeSize());
        this.FPw.writeFields(paramVarArgs);
      }
      if (this.FPx != null)
      {
        paramVarArgs.lC(18, this.FPx.computeSize());
        this.FPx.writeFields(paramVarArgs);
      }
      if (this.FPy != null)
      {
        paramVarArgs.lC(19, this.FPy.computeSize());
        this.FPy.writeFields(paramVarArgs);
      }
      if (this.FPz != null)
      {
        paramVarArgs.lC(20, this.FPz.computeSize());
        this.FPz.writeFields(paramVarArgs);
      }
      if (this.FPA != null) {
        paramVarArgs.d(21, this.FPA);
      }
      if (this.FPB != null)
      {
        paramVarArgs.lC(22, this.FPB.computeSize());
        this.FPB.writeFields(paramVarArgs);
      }
      if (this.FPC != null) {
        paramVarArgs.d(23, this.FPC);
      }
      if (this.FPD != null)
      {
        paramVarArgs.lC(24, this.FPD.computeSize());
        this.FPD.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(25, this.FPE);
      paramVarArgs.bt(26, this.FPF);
      AppMethodBeat.o(113949);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.status) + 0 + f.a.a.b.b.a.bz(2, this.FPi) + f.a.a.b.b.a.bz(3, this.FPj) + f.a.a.a.c(4, 8, this.FPk) + f.a.a.a.c(5, 8, this.FPl) + f.a.a.a.c(6, 8, this.FPm) + f.a.a.a.c(7, 1, this.FPn) + f.a.a.b.b.a.bz(8, this.FPo);
      paramInt = i;
      if (this.code != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.code);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.FPp) + f.a.a.a.c(11, 8, this.FPq) + f.a.a.b.b.a.p(12, this.FPr) + f.a.a.b.b.a.bz(13, this.FPs);
      paramInt = i;
      if (this.FPt != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FPt);
      }
      i = paramInt;
      if (this.FPu != null) {
        i = paramInt + f.a.a.a.lB(15, this.FPu.computeSize());
      }
      i += f.a.a.a.c(16, 8, this.FPv);
      paramInt = i;
      if (this.FPw != null) {
        paramInt = i + f.a.a.a.lB(17, this.FPw.computeSize());
      }
      i = paramInt;
      if (this.FPx != null) {
        i = paramInt + f.a.a.a.lB(18, this.FPx.computeSize());
      }
      paramInt = i;
      if (this.FPy != null) {
        paramInt = i + f.a.a.a.lB(19, this.FPy.computeSize());
      }
      i = paramInt;
      if (this.FPz != null) {
        i = paramInt + f.a.a.a.lB(20, this.FPz.computeSize());
      }
      paramInt = i;
      if (this.FPA != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FPA);
      }
      i = paramInt;
      if (this.FPB != null) {
        i = paramInt + f.a.a.a.lB(22, this.FPB.computeSize());
      }
      paramInt = i;
      if (this.FPC != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.FPC);
      }
      i = paramInt;
      if (this.FPD != null) {
        i = paramInt + f.a.a.a.lB(24, this.FPD.computeSize());
      }
      paramInt = f.a.a.b.b.a.alV(25);
      int j = f.a.a.b.b.a.alV(26);
      AppMethodBeat.o(113949);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FPk.clear();
      this.FPl.clear();
      this.FPm.clear();
      this.FPn.clear();
      this.FPq.clear();
      this.FPv.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(113949);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      sr localsr = (sr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113949);
        return -1;
      case 1: 
        localsr.status = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(113949);
        return 0;
      case 2: 
        localsr.FPi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(113949);
        return 0;
      case 3: 
        localsr.FPj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(113949);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ua();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ua)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsr.FPk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ua();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ua)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsr.FPl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ua();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ua)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsr.FPm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 7: 
        localsr.FPn.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(113949);
        return 0;
      case 8: 
        localsr.FPo = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(113949);
        return 0;
      case 9: 
        localsr.code = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 10: 
        localsr.FPp = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(113949);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsr.FPq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 12: 
        localsr.FPr = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(113949);
        return 0;
      case 13: 
        localsr.FPs = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(113949);
        return 0;
      case 14: 
        localsr.FPt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsr.FPu = ((aaf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsr.FPv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsr.FPw = ((aaf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsr.FPx = ((aaf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 19: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsr.FPy = ((aaf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aem();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aem)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsr.FPz = ((aem)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 21: 
        localsr.FPA = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsr.FPB = ((aaf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 23: 
        localsr.FPC = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aaf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsr.FPD = ((aaf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 25: 
        localsr.FPE = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(113949);
        return 0;
      }
      localsr.FPF = ((f.a.a.a.a)localObject1).NPN.grw();
      AppMethodBeat.o(113949);
      return 0;
    }
    AppMethodBeat.o(113949);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sr
 * JD-Core Version:    0.7.0.1
 */
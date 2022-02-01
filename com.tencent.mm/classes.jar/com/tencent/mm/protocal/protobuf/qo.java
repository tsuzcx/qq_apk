package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qo
  extends com.tencent.mm.bx.a
{
  public LinkedList<ba> CPA;
  public xo CPB;
  public xo CPC;
  public xo CPD;
  public abn CPE;
  public String CPF;
  public xo CPG;
  public String CPH;
  public xo CPI;
  public boolean CPJ;
  public boolean CPK;
  public int CPn;
  public int CPo;
  public LinkedList<rw> CPp;
  public LinkedList<rw> CPq;
  public LinkedList<rw> CPr;
  public LinkedList<String> CPs;
  public int CPt;
  public int CPu;
  public LinkedList<xo> CPv;
  public long CPw;
  public int CPx;
  public String CPy;
  public xo CPz;
  public String code;
  public int status;
  
  public qo()
  {
    AppMethodBeat.i(113948);
    this.CPp = new LinkedList();
    this.CPq = new LinkedList();
    this.CPr = new LinkedList();
    this.CPs = new LinkedList();
    this.CPv = new LinkedList();
    this.CPA = new LinkedList();
    AppMethodBeat.o(113948);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113949);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.status);
      paramVarArgs.aR(2, this.CPn);
      paramVarArgs.aR(3, this.CPo);
      paramVarArgs.e(4, 8, this.CPp);
      paramVarArgs.e(5, 8, this.CPq);
      paramVarArgs.e(6, 8, this.CPr);
      paramVarArgs.e(7, 1, this.CPs);
      paramVarArgs.aR(8, this.CPt);
      if (this.code != null) {
        paramVarArgs.d(9, this.code);
      }
      paramVarArgs.aR(10, this.CPu);
      paramVarArgs.e(11, 8, this.CPv);
      paramVarArgs.aG(12, this.CPw);
      paramVarArgs.aR(13, this.CPx);
      if (this.CPy != null) {
        paramVarArgs.d(14, this.CPy);
      }
      if (this.CPz != null)
      {
        paramVarArgs.kX(15, this.CPz.computeSize());
        this.CPz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.CPA);
      if (this.CPB != null)
      {
        paramVarArgs.kX(17, this.CPB.computeSize());
        this.CPB.writeFields(paramVarArgs);
      }
      if (this.CPC != null)
      {
        paramVarArgs.kX(18, this.CPC.computeSize());
        this.CPC.writeFields(paramVarArgs);
      }
      if (this.CPD != null)
      {
        paramVarArgs.kX(19, this.CPD.computeSize());
        this.CPD.writeFields(paramVarArgs);
      }
      if (this.CPE != null)
      {
        paramVarArgs.kX(20, this.CPE.computeSize());
        this.CPE.writeFields(paramVarArgs);
      }
      if (this.CPF != null) {
        paramVarArgs.d(21, this.CPF);
      }
      if (this.CPG != null)
      {
        paramVarArgs.kX(22, this.CPG.computeSize());
        this.CPG.writeFields(paramVarArgs);
      }
      if (this.CPH != null) {
        paramVarArgs.d(23, this.CPH);
      }
      if (this.CPI != null)
      {
        paramVarArgs.kX(24, this.CPI.computeSize());
        this.CPI.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(25, this.CPJ);
      paramVarArgs.bg(26, this.CPK);
      AppMethodBeat.o(113949);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.status) + 0 + f.a.a.b.b.a.bA(2, this.CPn) + f.a.a.b.b.a.bA(3, this.CPo) + f.a.a.a.c(4, 8, this.CPp) + f.a.a.a.c(5, 8, this.CPq) + f.a.a.a.c(6, 8, this.CPr) + f.a.a.a.c(7, 1, this.CPs) + f.a.a.b.b.a.bA(8, this.CPt);
      paramInt = i;
      if (this.code != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.code);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.CPu) + f.a.a.a.c(11, 8, this.CPv) + f.a.a.b.b.a.q(12, this.CPw) + f.a.a.b.b.a.bA(13, this.CPx);
      paramInt = i;
      if (this.CPy != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.CPy);
      }
      i = paramInt;
      if (this.CPz != null) {
        i = paramInt + f.a.a.a.kW(15, this.CPz.computeSize());
      }
      i += f.a.a.a.c(16, 8, this.CPA);
      paramInt = i;
      if (this.CPB != null) {
        paramInt = i + f.a.a.a.kW(17, this.CPB.computeSize());
      }
      i = paramInt;
      if (this.CPC != null) {
        i = paramInt + f.a.a.a.kW(18, this.CPC.computeSize());
      }
      paramInt = i;
      if (this.CPD != null) {
        paramInt = i + f.a.a.a.kW(19, this.CPD.computeSize());
      }
      i = paramInt;
      if (this.CPE != null) {
        i = paramInt + f.a.a.a.kW(20, this.CPE.computeSize());
      }
      paramInt = i;
      if (this.CPF != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.CPF);
      }
      i = paramInt;
      if (this.CPG != null) {
        i = paramInt + f.a.a.a.kW(22, this.CPG.computeSize());
      }
      paramInt = i;
      if (this.CPH != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.CPH);
      }
      i = paramInt;
      if (this.CPI != null) {
        i = paramInt + f.a.a.a.kW(24, this.CPI.computeSize());
      }
      paramInt = f.a.a.b.b.a.fY(25);
      int j = f.a.a.b.b.a.fY(26);
      AppMethodBeat.o(113949);
      return i + (paramInt + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CPp.clear();
      this.CPq.clear();
      this.CPr.clear();
      this.CPs.clear();
      this.CPv.clear();
      this.CPA.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(113949);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      qo localqo = (qo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113949);
        return -1;
      case 1: 
        localqo.status = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(113949);
        return 0;
      case 2: 
        localqo.CPn = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(113949);
        return 0;
      case 3: 
        localqo.CPo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(113949);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqo.CPp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqo.CPq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqo.CPr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 7: 
        localqo.CPs.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(113949);
        return 0;
      case 8: 
        localqo.CPt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(113949);
        return 0;
      case 9: 
        localqo.code = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 10: 
        localqo.CPu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(113949);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqo.CPv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 12: 
        localqo.CPw = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(113949);
        return 0;
      case 13: 
        localqo.CPx = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(113949);
        return 0;
      case 14: 
        localqo.CPy = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqo.CPz = ((xo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ba();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqo.CPA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqo.CPB = ((xo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqo.CPC = ((xo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 19: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqo.CPD = ((xo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqo.CPE = ((abn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 21: 
        localqo.CPF = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqo.CPG = ((xo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 23: 
        localqo.CPH = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqo.CPI = ((xo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 25: 
        localqo.CPJ = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(113949);
        return 0;
      }
      localqo.CPK = ((f.a.a.a.a)localObject1).KhF.fHu();
      AppMethodBeat.o(113949);
      return 0;
    }
    AppMethodBeat.o(113949);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qo
 * JD-Core Version:    0.7.0.1
 */
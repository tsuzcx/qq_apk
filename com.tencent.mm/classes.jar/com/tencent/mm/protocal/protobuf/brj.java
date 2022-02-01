package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brj
  extends com.tencent.mm.bx.a
{
  public int CuF;
  public int CuI;
  public cmf DFJ;
  public int DIV;
  public String DIW;
  public String DIX;
  public String DIY;
  public int DIZ;
  public abx DOM;
  public int DOp;
  public int DPa;
  public int DPg;
  public com.tencent.mm.bx.b DPh;
  public int DPj;
  public cmf DPk;
  public cmf DPl;
  public int DPm;
  public int DPn;
  public int DPo;
  public int DPp;
  public int DPq;
  public bej DPr;
  public int DPs;
  public String DPt;
  public cmf Dby;
  public long Dfl;
  public String Dfm;
  public int ijM;
  public String ijN;
  public String ijO;
  public String ijP;
  public int ijQ;
  public String ijR;
  public int ijS;
  public int ijT;
  public String ijU;
  public String ijV;
  public int mBi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43112);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dby == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.DFJ == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.DPk == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.DPl == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.DPj);
      if (this.Dby != null)
      {
        paramVarArgs.kX(2, this.Dby.computeSize());
        this.Dby.writeFields(paramVarArgs);
      }
      if (this.DFJ != null)
      {
        paramVarArgs.kX(3, this.DFJ.computeSize());
        this.DFJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.CuF);
      if (this.DPk != null)
      {
        paramVarArgs.kX(5, this.DPk.computeSize());
        this.DPk.writeFields(paramVarArgs);
      }
      if (this.DPl != null)
      {
        paramVarArgs.kX(6, this.DPl.computeSize());
        this.DPl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.mBi);
      paramVarArgs.aR(8, this.DPg);
      if (this.DPh != null) {
        paramVarArgs.c(9, this.DPh);
      }
      paramVarArgs.aR(10, this.ijM);
      if (this.ijN != null) {
        paramVarArgs.d(11, this.ijN);
      }
      if (this.ijO != null) {
        paramVarArgs.d(12, this.ijO);
      }
      if (this.ijP != null) {
        paramVarArgs.d(13, this.ijP);
      }
      paramVarArgs.aR(14, this.ijQ);
      if (this.DOM != null)
      {
        paramVarArgs.kX(15, this.DOM.computeSize());
        this.DOM.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(16, this.CuI);
      paramVarArgs.aR(17, this.DIV);
      if (this.DIW != null) {
        paramVarArgs.d(18, this.DIW);
      }
      paramVarArgs.aR(19, this.DPm);
      paramVarArgs.aR(20, this.DPn);
      paramVarArgs.aR(21, this.DOp);
      paramVarArgs.aR(22, this.DPo);
      paramVarArgs.aR(23, this.DPp);
      if (this.DIX != null) {
        paramVarArgs.d(24, this.DIX);
      }
      paramVarArgs.aR(25, this.DPq);
      if (this.DPr != null)
      {
        paramVarArgs.kX(26, this.DPr.computeSize());
        this.DPr.writeFields(paramVarArgs);
      }
      if (this.ijR != null) {
        paramVarArgs.d(27, this.ijR);
      }
      if (this.DIY != null) {
        paramVarArgs.d(28, this.DIY);
      }
      paramVarArgs.aR(29, this.DIZ);
      paramVarArgs.aR(30, this.DPs);
      paramVarArgs.aG(31, this.Dfl);
      if (this.Dfm != null) {
        paramVarArgs.d(32, this.Dfm);
      }
      paramVarArgs.aR(33, this.ijT);
      paramVarArgs.aR(34, this.ijS);
      if (this.ijU != null) {
        paramVarArgs.d(35, this.ijU);
      }
      paramVarArgs.aR(36, this.DPa);
      if (this.DPt != null) {
        paramVarArgs.d(37, this.DPt);
      }
      if (this.ijV != null) {
        paramVarArgs.d(38, this.ijV);
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DPj) + 0;
      paramInt = i;
      if (this.Dby != null) {
        paramInt = i + f.a.a.a.kW(2, this.Dby.computeSize());
      }
      i = paramInt;
      if (this.DFJ != null) {
        i = paramInt + f.a.a.a.kW(3, this.DFJ.computeSize());
      }
      i += f.a.a.b.b.a.bA(4, this.CuF);
      paramInt = i;
      if (this.DPk != null) {
        paramInt = i + f.a.a.a.kW(5, this.DPk.computeSize());
      }
      i = paramInt;
      if (this.DPl != null) {
        i = paramInt + f.a.a.a.kW(6, this.DPl.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(7, this.mBi) + f.a.a.b.b.a.bA(8, this.DPg);
      paramInt = i;
      if (this.DPh != null) {
        paramInt = i + f.a.a.b.b.a.b(9, this.DPh);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.ijM);
      paramInt = i;
      if (this.ijN != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.ijN);
      }
      i = paramInt;
      if (this.ijO != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.ijO);
      }
      paramInt = i;
      if (this.ijP != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.ijP);
      }
      i = paramInt + f.a.a.b.b.a.bA(14, this.ijQ);
      paramInt = i;
      if (this.DOM != null) {
        paramInt = i + f.a.a.a.kW(15, this.DOM.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(16, this.CuI) + f.a.a.b.b.a.bA(17, this.DIV);
      paramInt = i;
      if (this.DIW != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.DIW);
      }
      i = paramInt + f.a.a.b.b.a.bA(19, this.DPm) + f.a.a.b.b.a.bA(20, this.DPn) + f.a.a.b.b.a.bA(21, this.DOp) + f.a.a.b.b.a.bA(22, this.DPo) + f.a.a.b.b.a.bA(23, this.DPp);
      paramInt = i;
      if (this.DIX != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.DIX);
      }
      i = paramInt + f.a.a.b.b.a.bA(25, this.DPq);
      paramInt = i;
      if (this.DPr != null) {
        paramInt = i + f.a.a.a.kW(26, this.DPr.computeSize());
      }
      i = paramInt;
      if (this.ijR != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.ijR);
      }
      paramInt = i;
      if (this.DIY != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.DIY);
      }
      i = paramInt + f.a.a.b.b.a.bA(29, this.DIZ) + f.a.a.b.b.a.bA(30, this.DPs) + f.a.a.b.b.a.q(31, this.Dfl);
      paramInt = i;
      if (this.Dfm != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.Dfm);
      }
      i = paramInt + f.a.a.b.b.a.bA(33, this.ijT) + f.a.a.b.b.a.bA(34, this.ijS);
      paramInt = i;
      if (this.ijU != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.ijU);
      }
      i = paramInt + f.a.a.b.b.a.bA(36, this.DPa);
      paramInt = i;
      if (this.DPt != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.DPt);
      }
      i = paramInt;
      if (this.ijV != null) {
        i = paramInt + f.a.a.b.b.a.e(38, this.ijV);
      }
      AppMethodBeat.o(43112);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Dby == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.DFJ == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.DPk == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.DPl == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      brj localbrj = (brj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43112);
        return -1;
      case 1: 
        localbrj.DPj = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrj.Dby = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrj.DFJ = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 4: 
        localbrj.CuF = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrj.DPk = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrj.DPl = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 7: 
        localbrj.mBi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 8: 
        localbrj.DPg = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 9: 
        localbrj.DPh = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(43112);
        return 0;
      case 10: 
        localbrj.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 11: 
        localbrj.ijN = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 12: 
        localbrj.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 13: 
        localbrj.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 14: 
        localbrj.ijQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrj.DOM = ((abx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 16: 
        localbrj.CuI = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 17: 
        localbrj.DIV = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 18: 
        localbrj.DIW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 19: 
        localbrj.DPm = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 20: 
        localbrj.DPn = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 21: 
        localbrj.DOp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 22: 
        localbrj.DPo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 23: 
        localbrj.DPp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 24: 
        localbrj.DIX = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 25: 
        localbrj.DPq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 26: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bej();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bej)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrj.DPr = ((bej)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 27: 
        localbrj.ijR = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 28: 
        localbrj.DIY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 29: 
        localbrj.DIZ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 30: 
        localbrj.DPs = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 31: 
        localbrj.Dfl = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(43112);
        return 0;
      case 32: 
        localbrj.Dfm = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 33: 
        localbrj.ijT = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 34: 
        localbrj.ijS = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 35: 
        localbrj.ijU = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 36: 
        localbrj.DPa = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43112);
        return 0;
      case 37: 
        localbrj.DPt = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(43112);
        return 0;
      }
      localbrj.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(43112);
      return 0;
    }
    AppMethodBeat.o(43112);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brj
 * JD-Core Version:    0.7.0.1
 */
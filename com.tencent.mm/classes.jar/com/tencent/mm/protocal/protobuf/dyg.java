package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyg
  extends com.tencent.mm.bx.a
{
  public dym HJd;
  public dym HJe;
  public ctc HKR;
  public aev HKS;
  public int HKY;
  public dwt HKZ;
  public LinkedList<dyh> HLA;
  public bem HLB;
  public dwt HLa;
  public int HLb;
  public int HLc;
  public int HLd;
  public int HLe;
  public SKBuiltinBuffer_t HLf;
  public int HLg;
  public dwt HLh;
  public int HLi;
  public int HLj;
  public int HLk;
  public int HLl;
  public int HLm;
  public int HLn;
  public SKBuiltinBuffer_t HLo;
  public SKBuiltinBuffer_t HLp;
  public int HLq;
  public SKBuiltinBuffer_t HLr;
  public int HLs;
  public int HLt;
  public int HLu;
  public brl HLv;
  public SKBuiltinBuffer_t HLw;
  public int HLx;
  public String HLy;
  public int HLz;
  public int uLO;
  
  public dyg()
  {
    AppMethodBeat.i(115899);
    this.HLA = new LinkedList();
    AppMethodBeat.o(115899);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115900);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HJd == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.HJe == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.HJd != null)
      {
        paramVarArgs.lC(1, this.HJd.computeSize());
        this.HJd.writeFields(paramVarArgs);
      }
      if (this.HJe != null)
      {
        paramVarArgs.lC(2, this.HJe.computeSize());
        this.HJe.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HKY);
      if (this.HKZ != null)
      {
        paramVarArgs.lC(4, this.HKZ.computeSize());
        this.HKZ.writeFields(paramVarArgs);
      }
      if (this.HLa != null)
      {
        paramVarArgs.lC(5, this.HLa.computeSize());
        this.HLa.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.HLb);
      paramVarArgs.aS(7, this.HLc);
      paramVarArgs.aS(8, this.HLd);
      paramVarArgs.aS(9, this.HLe);
      if (this.HLf != null)
      {
        paramVarArgs.lC(10, this.HLf.computeSize());
        this.HLf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.HLg);
      if (this.HLh != null)
      {
        paramVarArgs.lC(12, this.HLh.computeSize());
        this.HLh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.HLi);
      paramVarArgs.aS(14, this.HLj);
      paramVarArgs.aS(15, this.HLk);
      paramVarArgs.aS(16, this.HLl);
      paramVarArgs.aS(17, this.HLm);
      paramVarArgs.aS(18, this.uLO);
      paramVarArgs.aS(19, this.HLn);
      if (this.HLo != null)
      {
        paramVarArgs.lC(20, this.HLo.computeSize());
        this.HLo.writeFields(paramVarArgs);
      }
      if (this.HLp != null)
      {
        paramVarArgs.lC(21, this.HLp.computeSize());
        this.HLp.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(22, this.HLq);
      if (this.HLr != null)
      {
        paramVarArgs.lC(23, this.HLr.computeSize());
        this.HLr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(24, this.HLs);
      paramVarArgs.aS(25, this.HLt);
      paramVarArgs.aS(26, this.HLu);
      if (this.HLv != null)
      {
        paramVarArgs.lC(27, this.HLv.computeSize());
        this.HLv.writeFields(paramVarArgs);
      }
      if (this.HLw != null)
      {
        paramVarArgs.lC(28, this.HLw.computeSize());
        this.HLw.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(29, this.HLx);
      if (this.HLy != null) {
        paramVarArgs.d(30, this.HLy);
      }
      paramVarArgs.aS(31, this.HLz);
      paramVarArgs.e(32, 8, this.HLA);
      if (this.HKR != null)
      {
        paramVarArgs.lC(33, this.HKR.computeSize());
        this.HKR.writeFields(paramVarArgs);
      }
      if (this.HKS != null)
      {
        paramVarArgs.lC(34, this.HKS.computeSize());
        this.HKS.writeFields(paramVarArgs);
      }
      if (this.HLB != null)
      {
        paramVarArgs.lC(35, this.HLB.computeSize());
        this.HLB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115900);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HJd == null) {
        break label3482;
      }
    }
    label3482:
    for (paramInt = f.a.a.a.lB(1, this.HJd.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HJe != null) {
        i = paramInt + f.a.a.a.lB(2, this.HJe.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.HKY);
      paramInt = i;
      if (this.HKZ != null) {
        paramInt = i + f.a.a.a.lB(4, this.HKZ.computeSize());
      }
      i = paramInt;
      if (this.HLa != null) {
        i = paramInt + f.a.a.a.lB(5, this.HLa.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(6, this.HLb) + f.a.a.b.b.a.bz(7, this.HLc) + f.a.a.b.b.a.bz(8, this.HLd) + f.a.a.b.b.a.bz(9, this.HLe);
      paramInt = i;
      if (this.HLf != null) {
        paramInt = i + f.a.a.a.lB(10, this.HLf.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.HLg);
      paramInt = i;
      if (this.HLh != null) {
        paramInt = i + f.a.a.a.lB(12, this.HLh.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.HLi) + f.a.a.b.b.a.bz(14, this.HLj) + f.a.a.b.b.a.bz(15, this.HLk) + f.a.a.b.b.a.bz(16, this.HLl) + f.a.a.b.b.a.bz(17, this.HLm) + f.a.a.b.b.a.bz(18, this.uLO) + f.a.a.b.b.a.bz(19, this.HLn);
      paramInt = i;
      if (this.HLo != null) {
        paramInt = i + f.a.a.a.lB(20, this.HLo.computeSize());
      }
      i = paramInt;
      if (this.HLp != null) {
        i = paramInt + f.a.a.a.lB(21, this.HLp.computeSize());
      }
      i += f.a.a.b.b.a.bz(22, this.HLq);
      paramInt = i;
      if (this.HLr != null) {
        paramInt = i + f.a.a.a.lB(23, this.HLr.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.HLs) + f.a.a.b.b.a.bz(25, this.HLt) + f.a.a.b.b.a.bz(26, this.HLu);
      paramInt = i;
      if (this.HLv != null) {
        paramInt = i + f.a.a.a.lB(27, this.HLv.computeSize());
      }
      i = paramInt;
      if (this.HLw != null) {
        i = paramInt + f.a.a.a.lB(28, this.HLw.computeSize());
      }
      i += f.a.a.b.b.a.bz(29, this.HLx);
      paramInt = i;
      if (this.HLy != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.HLy);
      }
      i = paramInt + f.a.a.b.b.a.bz(31, this.HLz) + f.a.a.a.c(32, 8, this.HLA);
      paramInt = i;
      if (this.HKR != null) {
        paramInt = i + f.a.a.a.lB(33, this.HKR.computeSize());
      }
      i = paramInt;
      if (this.HKS != null) {
        i = paramInt + f.a.a.a.lB(34, this.HKS.computeSize());
      }
      paramInt = i;
      if (this.HLB != null) {
        paramInt = i + f.a.a.a.lB(35, this.HLB.computeSize());
      }
      AppMethodBeat.o(115900);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HLA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HJd == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115900);
          throw paramVarArgs;
        }
        if (this.HJe == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(115900);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115900);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyg localdyg = (dyg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115900);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dym();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dym)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HJd = ((dym)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dym();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dym)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HJe = ((dym)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 3: 
          localdyg.HKY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HKZ = ((dwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HLa = ((dwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 6: 
          localdyg.HLb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 7: 
          localdyg.HLc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 8: 
          localdyg.HLd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 9: 
          localdyg.HLe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HLf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 11: 
          localdyg.HLg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HLh = ((dwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 13: 
          localdyg.HLi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 14: 
          localdyg.HLj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 15: 
          localdyg.HLk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 16: 
          localdyg.HLl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 17: 
          localdyg.HLm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 18: 
          localdyg.uLO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 19: 
          localdyg.HLn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HLo = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HLp = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 22: 
          localdyg.HLq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HLr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 24: 
          localdyg.HLs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 25: 
          localdyg.HLt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 26: 
          localdyg.HLu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HLv = ((brl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HLw = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 29: 
          localdyg.HLx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 30: 
          localdyg.HLy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(115900);
          return 0;
        case 31: 
          localdyg.HLz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115900);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HLA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HKR = ((ctc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aev();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aev)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyg.HKS = ((aev)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bem();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bem)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyg.HLB = ((bem)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115900);
        return 0;
      }
      AppMethodBeat.o(115900);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyg
 * JD-Core Version:    0.7.0.1
 */
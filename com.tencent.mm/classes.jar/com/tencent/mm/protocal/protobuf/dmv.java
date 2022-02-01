package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmv
  extends com.tencent.mm.bx.a
{
  public dnb EAU;
  public dnb EAV;
  public cis ECI;
  public abv ECJ;
  public int ECP;
  public dli ECQ;
  public dli ECR;
  public int ECS;
  public int ECT;
  public int ECU;
  public int ECV;
  public SKBuiltinBuffer_t ECW;
  public int ECX;
  public dli ECY;
  public int ECZ;
  public int EDa;
  public int EDb;
  public int EDc;
  public int EDd;
  public int EDe;
  public SKBuiltinBuffer_t EDf;
  public SKBuiltinBuffer_t EDg;
  public int EDh;
  public SKBuiltinBuffer_t EDi;
  public int EDj;
  public int EDk;
  public int EDl;
  public bjj EDm;
  public SKBuiltinBuffer_t EDn;
  public int EDo;
  public String EDp;
  public int EDq;
  public LinkedList<dmw> EDr;
  public awq EDs;
  public int sBt;
  
  public dmv()
  {
    AppMethodBeat.i(115899);
    this.EDr = new LinkedList();
    AppMethodBeat.o(115899);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115900);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EAU == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.EAV == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.EAU != null)
      {
        paramVarArgs.kX(1, this.EAU.computeSize());
        this.EAU.writeFields(paramVarArgs);
      }
      if (this.EAV != null)
      {
        paramVarArgs.kX(2, this.EAV.computeSize());
        this.EAV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.ECP);
      if (this.ECQ != null)
      {
        paramVarArgs.kX(4, this.ECQ.computeSize());
        this.ECQ.writeFields(paramVarArgs);
      }
      if (this.ECR != null)
      {
        paramVarArgs.kX(5, this.ECR.computeSize());
        this.ECR.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.ECS);
      paramVarArgs.aR(7, this.ECT);
      paramVarArgs.aR(8, this.ECU);
      paramVarArgs.aR(9, this.ECV);
      if (this.ECW != null)
      {
        paramVarArgs.kX(10, this.ECW.computeSize());
        this.ECW.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.ECX);
      if (this.ECY != null)
      {
        paramVarArgs.kX(12, this.ECY.computeSize());
        this.ECY.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(13, this.ECZ);
      paramVarArgs.aR(14, this.EDa);
      paramVarArgs.aR(15, this.EDb);
      paramVarArgs.aR(16, this.EDc);
      paramVarArgs.aR(17, this.EDd);
      paramVarArgs.aR(18, this.sBt);
      paramVarArgs.aR(19, this.EDe);
      if (this.EDf != null)
      {
        paramVarArgs.kX(20, this.EDf.computeSize());
        this.EDf.writeFields(paramVarArgs);
      }
      if (this.EDg != null)
      {
        paramVarArgs.kX(21, this.EDg.computeSize());
        this.EDg.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(22, this.EDh);
      if (this.EDi != null)
      {
        paramVarArgs.kX(23, this.EDi.computeSize());
        this.EDi.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(24, this.EDj);
      paramVarArgs.aR(25, this.EDk);
      paramVarArgs.aR(26, this.EDl);
      if (this.EDm != null)
      {
        paramVarArgs.kX(27, this.EDm.computeSize());
        this.EDm.writeFields(paramVarArgs);
      }
      if (this.EDn != null)
      {
        paramVarArgs.kX(28, this.EDn.computeSize());
        this.EDn.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(29, this.EDo);
      if (this.EDp != null) {
        paramVarArgs.d(30, this.EDp);
      }
      paramVarArgs.aR(31, this.EDq);
      paramVarArgs.e(32, 8, this.EDr);
      if (this.ECI != null)
      {
        paramVarArgs.kX(33, this.ECI.computeSize());
        this.ECI.writeFields(paramVarArgs);
      }
      if (this.ECJ != null)
      {
        paramVarArgs.kX(34, this.ECJ.computeSize());
        this.ECJ.writeFields(paramVarArgs);
      }
      if (this.EDs != null)
      {
        paramVarArgs.kX(35, this.EDs.computeSize());
        this.EDs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115900);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EAU == null) {
        break label3482;
      }
    }
    label3482:
    for (paramInt = f.a.a.a.kW(1, this.EAU.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EAV != null) {
        i = paramInt + f.a.a.a.kW(2, this.EAV.computeSize());
      }
      i += f.a.a.b.b.a.bA(3, this.ECP);
      paramInt = i;
      if (this.ECQ != null) {
        paramInt = i + f.a.a.a.kW(4, this.ECQ.computeSize());
      }
      i = paramInt;
      if (this.ECR != null) {
        i = paramInt + f.a.a.a.kW(5, this.ECR.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(6, this.ECS) + f.a.a.b.b.a.bA(7, this.ECT) + f.a.a.b.b.a.bA(8, this.ECU) + f.a.a.b.b.a.bA(9, this.ECV);
      paramInt = i;
      if (this.ECW != null) {
        paramInt = i + f.a.a.a.kW(10, this.ECW.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.ECX);
      paramInt = i;
      if (this.ECY != null) {
        paramInt = i + f.a.a.a.kW(12, this.ECY.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(13, this.ECZ) + f.a.a.b.b.a.bA(14, this.EDa) + f.a.a.b.b.a.bA(15, this.EDb) + f.a.a.b.b.a.bA(16, this.EDc) + f.a.a.b.b.a.bA(17, this.EDd) + f.a.a.b.b.a.bA(18, this.sBt) + f.a.a.b.b.a.bA(19, this.EDe);
      paramInt = i;
      if (this.EDf != null) {
        paramInt = i + f.a.a.a.kW(20, this.EDf.computeSize());
      }
      i = paramInt;
      if (this.EDg != null) {
        i = paramInt + f.a.a.a.kW(21, this.EDg.computeSize());
      }
      i += f.a.a.b.b.a.bA(22, this.EDh);
      paramInt = i;
      if (this.EDi != null) {
        paramInt = i + f.a.a.a.kW(23, this.EDi.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(24, this.EDj) + f.a.a.b.b.a.bA(25, this.EDk) + f.a.a.b.b.a.bA(26, this.EDl);
      paramInt = i;
      if (this.EDm != null) {
        paramInt = i + f.a.a.a.kW(27, this.EDm.computeSize());
      }
      i = paramInt;
      if (this.EDn != null) {
        i = paramInt + f.a.a.a.kW(28, this.EDn.computeSize());
      }
      i += f.a.a.b.b.a.bA(29, this.EDo);
      paramInt = i;
      if (this.EDp != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.EDp);
      }
      i = paramInt + f.a.a.b.b.a.bA(31, this.EDq) + f.a.a.a.c(32, 8, this.EDr);
      paramInt = i;
      if (this.ECI != null) {
        paramInt = i + f.a.a.a.kW(33, this.ECI.computeSize());
      }
      i = paramInt;
      if (this.ECJ != null) {
        i = paramInt + f.a.a.a.kW(34, this.ECJ.computeSize());
      }
      paramInt = i;
      if (this.EDs != null) {
        paramInt = i + f.a.a.a.kW(35, this.EDs.computeSize());
      }
      AppMethodBeat.o(115900);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EDr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EAU == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115900);
          throw paramVarArgs;
        }
        if (this.EAV == null)
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
        dmv localdmv = (dmv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115900);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.EAU = ((dnb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.EAV = ((dnb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 3: 
          localdmv.ECP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dli();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dli)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.ECQ = ((dli)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dli();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dli)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.ECR = ((dli)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 6: 
          localdmv.ECS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 7: 
          localdmv.ECT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 8: 
          localdmv.ECU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 9: 
          localdmv.ECV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.ECW = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 11: 
          localdmv.ECX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dli();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dli)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.ECY = ((dli)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 13: 
          localdmv.ECZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 14: 
          localdmv.EDa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 15: 
          localdmv.EDb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 16: 
          localdmv.EDc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 17: 
          localdmv.EDd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 18: 
          localdmv.sBt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 19: 
          localdmv.EDe = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.EDf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.EDg = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 22: 
          localdmv.EDh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.EDi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 24: 
          localdmv.EDj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 25: 
          localdmv.EDk = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 26: 
          localdmv.EDl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.EDm = ((bjj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.EDn = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 29: 
          localdmv.EDo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 30: 
          localdmv.EDp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(115900);
          return 0;
        case 31: 
          localdmv.EDq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115900);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.EDr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cis();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cis)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.ECI = ((cis)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmv.ECJ = ((abv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((awq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdmv.EDs = ((awq)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmv
 * JD-Core Version:    0.7.0.1
 */
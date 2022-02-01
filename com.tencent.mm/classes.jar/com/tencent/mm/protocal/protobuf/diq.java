package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class diq
  extends com.tencent.mm.bx.a
{
  public String CFy;
  public cmi CGl;
  public String CVv;
  public String CVw;
  public int CuL;
  public blv CxP;
  public cwh DJb;
  public String DOu;
  public String DOv;
  public int DZw;
  public int DpU;
  public String EyG;
  public String EyH;
  public int EyI;
  public int EyJ;
  public int EyK;
  public String EyL;
  public int EyM;
  public cmf EyN;
  public int EyO;
  public String EyP;
  public String EyQ;
  public String EyR;
  public String EyS;
  public String EyT;
  public byo EyU;
  public String EyV;
  public int EyW;
  public long EyX;
  public String EyY;
  public cze EyZ;
  public long Eza;
  public int Ezb;
  public String evN;
  public String ijW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134260);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DJb == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
        AppMethodBeat.o(134260);
        throw paramVarArgs;
      }
      if (this.DJb != null)
      {
        paramVarArgs.kX(1, this.DJb.computeSize());
        this.DJb.writeFields(paramVarArgs);
      }
      if (this.ijW != null) {
        paramVarArgs.d(2, this.ijW);
      }
      if (this.EyG != null) {
        paramVarArgs.d(3, this.EyG);
      }
      if (this.EyH != null) {
        paramVarArgs.d(4, this.EyH);
      }
      paramVarArgs.aR(5, this.EyI);
      paramVarArgs.aR(6, this.EyJ);
      paramVarArgs.aR(7, this.EyK);
      if (this.EyL != null) {
        paramVarArgs.d(8, this.EyL);
      }
      if (this.CVv != null) {
        paramVarArgs.d(9, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(10, this.CVw);
      }
      paramVarArgs.aR(11, this.EyM);
      if (this.EyN != null)
      {
        paramVarArgs.kX(12, this.EyN.computeSize());
        this.EyN.writeFields(paramVarArgs);
      }
      if (this.CGl != null)
      {
        paramVarArgs.kX(13, this.CGl.computeSize());
        this.CGl.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.CuL);
      paramVarArgs.aR(15, this.EyO);
      if (this.CFy != null) {
        paramVarArgs.d(16, this.CFy);
      }
      if (this.DOu != null) {
        paramVarArgs.d(17, this.DOu);
      }
      if (this.DOv != null) {
        paramVarArgs.d(18, this.DOv);
      }
      if (this.EyP != null) {
        paramVarArgs.d(19, this.EyP);
      }
      if (this.EyQ != null) {
        paramVarArgs.d(20, this.EyQ);
      }
      if (this.EyR != null) {
        paramVarArgs.d(21, this.EyR);
      }
      if (this.EyS != null) {
        paramVarArgs.d(22, this.EyS);
      }
      if (this.CxP != null)
      {
        paramVarArgs.kX(23, this.CxP.computeSize());
        this.CxP.writeFields(paramVarArgs);
      }
      if (this.EyT != null) {
        paramVarArgs.d(24, this.EyT);
      }
      if (this.EyU != null)
      {
        paramVarArgs.kX(25, this.EyU.computeSize());
        this.EyU.writeFields(paramVarArgs);
      }
      if (this.EyV != null) {
        paramVarArgs.d(26, this.EyV);
      }
      paramVarArgs.aR(27, this.EyW);
      if (this.evN != null) {
        paramVarArgs.d(28, this.evN);
      }
      paramVarArgs.aR(29, this.DpU);
      paramVarArgs.aG(30, this.EyX);
      if (this.EyY != null) {
        paramVarArgs.d(31, this.EyY);
      }
      paramVarArgs.aR(32, this.DZw);
      if (this.EyZ != null)
      {
        paramVarArgs.kX(33, this.EyZ.computeSize());
        this.EyZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(34, this.Eza);
      paramVarArgs.aR(35, this.Ezb);
      AppMethodBeat.o(134260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DJb == null) {
        break label2730;
      }
    }
    label2730:
    for (int i = f.a.a.a.kW(1, this.DJb.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ijW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ijW);
      }
      i = paramInt;
      if (this.EyG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EyG);
      }
      paramInt = i;
      if (this.EyH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EyH);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.EyI) + f.a.a.b.b.a.bA(6, this.EyJ) + f.a.a.b.b.a.bA(7, this.EyK);
      paramInt = i;
      if (this.EyL != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EyL);
      }
      i = paramInt;
      if (this.CVv != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CVv);
      }
      paramInt = i;
      if (this.CVw != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CVw);
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.EyM);
      paramInt = i;
      if (this.EyN != null) {
        paramInt = i + f.a.a.a.kW(12, this.EyN.computeSize());
      }
      i = paramInt;
      if (this.CGl != null) {
        i = paramInt + f.a.a.a.kW(13, this.CGl.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(14, this.CuL) + f.a.a.b.b.a.bA(15, this.EyO);
      paramInt = i;
      if (this.CFy != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.CFy);
      }
      i = paramInt;
      if (this.DOu != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.DOu);
      }
      paramInt = i;
      if (this.DOv != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.DOv);
      }
      i = paramInt;
      if (this.EyP != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.EyP);
      }
      paramInt = i;
      if (this.EyQ != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.EyQ);
      }
      i = paramInt;
      if (this.EyR != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.EyR);
      }
      paramInt = i;
      if (this.EyS != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.EyS);
      }
      i = paramInt;
      if (this.CxP != null) {
        i = paramInt + f.a.a.a.kW(23, this.CxP.computeSize());
      }
      paramInt = i;
      if (this.EyT != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.EyT);
      }
      i = paramInt;
      if (this.EyU != null) {
        i = paramInt + f.a.a.a.kW(25, this.EyU.computeSize());
      }
      paramInt = i;
      if (this.EyV != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.EyV);
      }
      i = paramInt + f.a.a.b.b.a.bA(27, this.EyW);
      paramInt = i;
      if (this.evN != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.evN);
      }
      i = paramInt + f.a.a.b.b.a.bA(29, this.DpU) + f.a.a.b.b.a.q(30, this.EyX);
      paramInt = i;
      if (this.EyY != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.EyY);
      }
      i = paramInt + f.a.a.b.b.a.bA(32, this.DZw);
      paramInt = i;
      if (this.EyZ != null) {
        paramInt = i + f.a.a.a.kW(33, this.EyZ.computeSize());
      }
      i = f.a.a.b.b.a.q(34, this.Eza);
      int j = f.a.a.b.b.a.bA(35, this.Ezb);
      AppMethodBeat.o(134260);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DJb == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
          AppMethodBeat.o(134260);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        diq localdiq = (diq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134260);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdiq.DJb = ((cwh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 2: 
          localdiq.ijW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 3: 
          localdiq.EyG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 4: 
          localdiq.EyH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 5: 
          localdiq.EyI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134260);
          return 0;
        case 6: 
          localdiq.EyJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134260);
          return 0;
        case 7: 
          localdiq.EyK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134260);
          return 0;
        case 8: 
          localdiq.EyL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 9: 
          localdiq.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 10: 
          localdiq.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 11: 
          localdiq.EyM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134260);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdiq.EyN = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdiq.CGl = ((cmi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 14: 
          localdiq.CuL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134260);
          return 0;
        case 15: 
          localdiq.EyO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134260);
          return 0;
        case 16: 
          localdiq.CFy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 17: 
          localdiq.DOu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 18: 
          localdiq.DOv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 19: 
          localdiq.EyP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 20: 
          localdiq.EyQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 21: 
          localdiq.EyR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 22: 
          localdiq.EyS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdiq.CxP = ((blv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 24: 
          localdiq.EyT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdiq.EyU = ((byo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 26: 
          localdiq.EyV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 27: 
          localdiq.EyW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134260);
          return 0;
        case 28: 
          localdiq.evN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 29: 
          localdiq.DpU = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134260);
          return 0;
        case 30: 
          localdiq.EyX = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(134260);
          return 0;
        case 31: 
          localdiq.EyY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 32: 
          localdiq.DZw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(134260);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cze();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cze)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdiq.EyZ = ((cze)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 34: 
          localdiq.Eza = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(134260);
          return 0;
        }
        localdiq.Ezb = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(134260);
        return 0;
      }
      AppMethodBeat.o(134260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diq
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bom
  extends com.tencent.mm.bw.a
{
  public int FZW;
  public long GWP;
  public String Gta;
  public String HbA;
  public bon HbB;
  public String HbC;
  public int HbD;
  public int HbE;
  public long HbF;
  public String HbG;
  public String HbH;
  public int HbI;
  public String HbJ;
  public String HbK;
  public String HbL;
  public String HbM;
  public String HbN;
  public int HbO;
  public String HbP;
  public int cPu;
  public int hCs;
  public int subType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91520);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HbA != null) {
        paramVarArgs.d(1, this.HbA);
      }
      paramVarArgs.aS(2, this.subType);
      if (this.Gta != null) {
        paramVarArgs.d(3, this.Gta);
      }
      if (this.HbB != null)
      {
        paramVarArgs.lJ(4, this.HbB.computeSize());
        this.HbB.writeFields(paramVarArgs);
      }
      if (this.HbC != null) {
        paramVarArgs.d(5, this.HbC);
      }
      paramVarArgs.aS(6, this.HbD);
      paramVarArgs.aS(7, this.HbE);
      paramVarArgs.aZ(8, this.HbF);
      paramVarArgs.aS(9, this.hCs);
      paramVarArgs.aS(10, this.FZW);
      if (this.HbG != null) {
        paramVarArgs.d(11, this.HbG);
      }
      if (this.HbH != null) {
        paramVarArgs.d(12, this.HbH);
      }
      paramVarArgs.aS(13, this.HbI);
      if (this.HbJ != null) {
        paramVarArgs.d(14, this.HbJ);
      }
      if (this.HbK != null) {
        paramVarArgs.d(15, this.HbK);
      }
      if (this.HbL != null) {
        paramVarArgs.d(16, this.HbL);
      }
      if (this.HbM != null) {
        paramVarArgs.d(17, this.HbM);
      }
      if (this.HbN != null) {
        paramVarArgs.d(18, this.HbN);
      }
      paramVarArgs.aS(19, this.HbO);
      paramVarArgs.aZ(20, this.GWP);
      paramVarArgs.aS(21, this.cPu);
      if (this.HbP != null) {
        paramVarArgs.d(22, this.HbP);
      }
      AppMethodBeat.o(91520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HbA == null) {
        break label1434;
      }
    }
    label1434:
    for (paramInt = f.a.a.b.b.a.e(1, this.HbA) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.subType);
      paramInt = i;
      if (this.Gta != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gta);
      }
      i = paramInt;
      if (this.HbB != null) {
        i = paramInt + f.a.a.a.lI(4, this.HbB.computeSize());
      }
      paramInt = i;
      if (this.HbC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HbC);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HbD) + f.a.a.b.b.a.bz(7, this.HbE) + f.a.a.b.b.a.p(8, this.HbF) + f.a.a.b.b.a.bz(9, this.hCs) + f.a.a.b.b.a.bz(10, this.FZW);
      paramInt = i;
      if (this.HbG != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HbG);
      }
      i = paramInt;
      if (this.HbH != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HbH);
      }
      i += f.a.a.b.b.a.bz(13, this.HbI);
      paramInt = i;
      if (this.HbJ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.HbJ);
      }
      i = paramInt;
      if (this.HbK != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.HbK);
      }
      paramInt = i;
      if (this.HbL != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.HbL);
      }
      i = paramInt;
      if (this.HbM != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.HbM);
      }
      paramInt = i;
      if (this.HbN != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.HbN);
      }
      i = paramInt + f.a.a.b.b.a.bz(19, this.HbO) + f.a.a.b.b.a.p(20, this.GWP) + f.a.a.b.b.a.bz(21, this.cPu);
      paramInt = i;
      if (this.HbP != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.HbP);
      }
      AppMethodBeat.o(91520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bom localbom = (bom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91520);
          return -1;
        case 1: 
          localbom.HbA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 2: 
          localbom.subType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 3: 
          localbom.Gta = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bon();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bon)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbom.HbB = ((bon)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91520);
          return 0;
        case 5: 
          localbom.HbC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 6: 
          localbom.HbD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 7: 
          localbom.HbE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 8: 
          localbom.HbF = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91520);
          return 0;
        case 9: 
          localbom.hCs = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 10: 
          localbom.FZW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 11: 
          localbom.HbG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 12: 
          localbom.HbH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 13: 
          localbom.HbI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 14: 
          localbom.HbJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 15: 
          localbom.HbK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 16: 
          localbom.HbL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 17: 
          localbom.HbM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 18: 
          localbom.HbN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 19: 
          localbom.HbO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 20: 
          localbom.GWP = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91520);
          return 0;
        case 21: 
          localbom.cPu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91520);
          return 0;
        }
        localbom.HbP = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91520);
        return 0;
      }
      AppMethodBeat.o(91520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bom
 * JD-Core Version:    0.7.0.1
 */
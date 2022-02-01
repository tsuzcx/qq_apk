package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fkc
  extends com.tencent.mm.bx.a
{
  public String YRs;
  public LinkedList<dfz> YYq;
  public String aaQP;
  public int abKA;
  public String abKB;
  public String abKC;
  public int abKD;
  public int abKE;
  public int abKF;
  public String abKG;
  public int abKH;
  public int abKI;
  public int abKJ;
  public int abKu;
  public int abKv;
  public int abKw;
  public int abKx;
  public int abKy;
  public int abKz;
  public String hAP;
  
  public fkc()
  {
    AppMethodBeat.i(152702);
    this.YYq = new LinkedList();
    AppMethodBeat.o(152702);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152703);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaQP != null) {
        paramVarArgs.g(1, this.aaQP);
      }
      paramVarArgs.bS(2, this.abKu);
      paramVarArgs.bS(3, this.abKv);
      paramVarArgs.bS(4, this.abKw);
      paramVarArgs.bS(5, this.abKx);
      if (this.hAP != null) {
        paramVarArgs.g(6, this.hAP);
      }
      paramVarArgs.e(7, 8, this.YYq);
      paramVarArgs.bS(8, this.abKy);
      if (this.YRs != null) {
        paramVarArgs.g(9, this.YRs);
      }
      paramVarArgs.bS(10, this.abKz);
      paramVarArgs.bS(11, this.abKA);
      if (this.abKB != null) {
        paramVarArgs.g(12, this.abKB);
      }
      if (this.abKC != null) {
        paramVarArgs.g(13, this.abKC);
      }
      paramVarArgs.bS(14, this.abKD);
      paramVarArgs.bS(16, this.abKE);
      paramVarArgs.bS(17, this.abKF);
      if (this.abKG != null) {
        paramVarArgs.g(18, this.abKG);
      }
      paramVarArgs.bS(19, this.abKH);
      paramVarArgs.bS(20, this.abKI);
      paramVarArgs.bS(21, this.abKJ);
      AppMethodBeat.o(152703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaQP == null) {
        break label1228;
      }
    }
    label1228:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaQP) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abKu) + i.a.a.b.b.a.cJ(3, this.abKv) + i.a.a.b.b.a.cJ(4, this.abKw) + i.a.a.b.b.a.cJ(5, this.abKx);
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hAP);
      }
      i = paramInt + i.a.a.a.c(7, 8, this.YYq) + i.a.a.b.b.a.cJ(8, this.abKy);
      paramInt = i;
      if (this.YRs != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YRs);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.abKz) + i.a.a.b.b.a.cJ(11, this.abKA);
      paramInt = i;
      if (this.abKB != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abKB);
      }
      i = paramInt;
      if (this.abKC != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.abKC);
      }
      i = i + i.a.a.b.b.a.cJ(14, this.abKD) + i.a.a.b.b.a.cJ(16, this.abKE) + i.a.a.b.b.a.cJ(17, this.abKF);
      paramInt = i;
      if (this.abKG != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.abKG);
      }
      i = i.a.a.b.b.a.cJ(19, this.abKH);
      int j = i.a.a.b.b.a.cJ(20, this.abKI);
      int k = i.a.a.b.b.a.cJ(21, this.abKJ);
      AppMethodBeat.o(152703);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YYq.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fkc localfkc = (fkc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        default: 
          AppMethodBeat.o(152703);
          return -1;
        case 1: 
          localfkc.aaQP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 2: 
          localfkc.abKu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152703);
          return 0;
        case 3: 
          localfkc.abKv = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152703);
          return 0;
        case 4: 
          localfkc.abKw = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152703);
          return 0;
        case 5: 
          localfkc.abKx = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152703);
          return 0;
        case 6: 
          localfkc.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dfz localdfz = new dfz();
            if ((localObject != null) && (localObject.length > 0)) {
              localdfz.parseFrom((byte[])localObject);
            }
            localfkc.YYq.add(localdfz);
            paramInt += 1;
          }
          AppMethodBeat.o(152703);
          return 0;
        case 8: 
          localfkc.abKy = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152703);
          return 0;
        case 9: 
          localfkc.YRs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 10: 
          localfkc.abKz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152703);
          return 0;
        case 11: 
          localfkc.abKA = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152703);
          return 0;
        case 12: 
          localfkc.abKB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 13: 
          localfkc.abKC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 14: 
          localfkc.abKD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152703);
          return 0;
        case 16: 
          localfkc.abKE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152703);
          return 0;
        case 17: 
          localfkc.abKF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152703);
          return 0;
        case 18: 
          localfkc.abKG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 19: 
          localfkc.abKH = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152703);
          return 0;
        case 20: 
          localfkc.abKI = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152703);
          return 0;
        }
        localfkc.abKJ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152703);
        return 0;
      }
      AppMethodBeat.o(152703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkc
 * JD-Core Version:    0.7.0.1
 */
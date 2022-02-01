package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ih
  extends com.tencent.mm.bx.a
{
  public String CUE;
  public String CUG;
  public String CUJ;
  public String CUK;
  public String FAU;
  public String FAV;
  public String FAW;
  public String FAX;
  public String FAY;
  public String FAZ;
  public String FBa;
  public String FBb;
  public String FBc;
  public long FBd;
  public int FBe;
  public String FBf;
  public String FBg;
  public String FBh;
  public String FBi;
  public ii FBj;
  public cmo FBk;
  public String dzn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91351);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FAU != null) {
        paramVarArgs.d(1, this.FAU);
      }
      if (this.FAV != null) {
        paramVarArgs.d(2, this.FAV);
      }
      if (this.FAW != null) {
        paramVarArgs.d(3, this.FAW);
      }
      if (this.FAX != null) {
        paramVarArgs.d(4, this.FAX);
      }
      if (this.FAY != null) {
        paramVarArgs.d(5, this.FAY);
      }
      if (this.FAZ != null) {
        paramVarArgs.d(6, this.FAZ);
      }
      if (this.FBa != null) {
        paramVarArgs.d(7, this.FBa);
      }
      if (this.FBb != null) {
        paramVarArgs.d(8, this.FBb);
      }
      if (this.dzn != null) {
        paramVarArgs.d(9, this.dzn);
      }
      if (this.FBc != null) {
        paramVarArgs.d(10, this.FBc);
      }
      if (this.CUG != null) {
        paramVarArgs.d(11, this.CUG);
      }
      if (this.CUK != null) {
        paramVarArgs.d(12, this.CUK);
      }
      if (this.CUJ != null) {
        paramVarArgs.d(13, this.CUJ);
      }
      paramVarArgs.aY(14, this.FBd);
      paramVarArgs.aS(15, this.FBe);
      if (this.FBf != null) {
        paramVarArgs.d(16, this.FBf);
      }
      if (this.FBg != null) {
        paramVarArgs.d(17, this.FBg);
      }
      if (this.FBh != null) {
        paramVarArgs.d(18, this.FBh);
      }
      if (this.CUE != null) {
        paramVarArgs.d(19, this.CUE);
      }
      if (this.FBi != null) {
        paramVarArgs.d(20, this.FBi);
      }
      if (this.FBj != null)
      {
        paramVarArgs.lC(21, this.FBj.computeSize());
        this.FBj.writeFields(paramVarArgs);
      }
      if (this.FBk != null)
      {
        paramVarArgs.lC(23, this.FBk.computeSize());
        this.FBk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91351);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FAU == null) {
        break label1670;
      }
    }
    label1670:
    for (int i = f.a.a.b.b.a.e(1, this.FAU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FAV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FAV);
      }
      i = paramInt;
      if (this.FAW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FAW);
      }
      paramInt = i;
      if (this.FAX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FAX);
      }
      i = paramInt;
      if (this.FAY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FAY);
      }
      paramInt = i;
      if (this.FAZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FAZ);
      }
      i = paramInt;
      if (this.FBa != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FBa);
      }
      paramInt = i;
      if (this.FBb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FBb);
      }
      i = paramInt;
      if (this.dzn != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.dzn);
      }
      paramInt = i;
      if (this.FBc != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FBc);
      }
      i = paramInt;
      if (this.CUG != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.CUG);
      }
      paramInt = i;
      if (this.CUK != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CUK);
      }
      i = paramInt;
      if (this.CUJ != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.CUJ);
      }
      i = i + f.a.a.b.b.a.p(14, this.FBd) + f.a.a.b.b.a.bz(15, this.FBe);
      paramInt = i;
      if (this.FBf != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FBf);
      }
      i = paramInt;
      if (this.FBg != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.FBg);
      }
      paramInt = i;
      if (this.FBh != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FBh);
      }
      i = paramInt;
      if (this.CUE != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.CUE);
      }
      paramInt = i;
      if (this.FBi != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.FBi);
      }
      i = paramInt;
      if (this.FBj != null) {
        i = paramInt + f.a.a.a.lB(21, this.FBj.computeSize());
      }
      paramInt = i;
      if (this.FBk != null) {
        paramInt = i + f.a.a.a.lB(23, this.FBk.computeSize());
      }
      AppMethodBeat.o(91351);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91351);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ih localih = (ih)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 22: 
        default: 
          AppMethodBeat.o(91351);
          return -1;
        case 1: 
          localih.FAU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 2: 
          localih.FAV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 3: 
          localih.FAW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 4: 
          localih.FAX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 5: 
          localih.FAY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 6: 
          localih.FAZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 7: 
          localih.FBa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 8: 
          localih.FBb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 9: 
          localih.dzn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 10: 
          localih.FBc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 11: 
          localih.CUG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 12: 
          localih.CUK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 13: 
          localih.CUJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 14: 
          localih.FBd = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91351);
          return 0;
        case 15: 
          localih.FBe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91351);
          return 0;
        case 16: 
          localih.FBf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 17: 
          localih.FBg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 18: 
          localih.FBh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 19: 
          localih.CUE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 20: 
          localih.FBi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ii();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ii)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localih.FBj = ((ii)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91351);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localih.FBk = ((cmo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91351);
        return 0;
      }
      AppMethodBeat.o(91351);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ih
 * JD-Core Version:    0.7.0.1
 */
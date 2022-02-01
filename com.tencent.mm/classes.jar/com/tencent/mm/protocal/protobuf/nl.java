package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class nl
  extends com.tencent.mm.bx.a
{
  public int FHA;
  public int FHB;
  public long FHC;
  public long FHD;
  public boolean FHE;
  public int FHF;
  public boolean FHG;
  public iv FHH;
  public boolean FHI;
  public vt FHJ;
  public LinkedList<eaw> FHK;
  public boolean FHL;
  public LinkedList<String> FHM;
  public String FHN;
  public String FHO;
  public String FHb;
  public int FHm;
  public int FHy;
  public int FHz;
  
  public nl()
  {
    AppMethodBeat.i(207223);
    this.FHK = new LinkedList();
    this.FHM = new LinkedList();
    AppMethodBeat.o(207223);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FHb == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124426);
        throw paramVarArgs;
      }
      if (this.FHb != null) {
        paramVarArgs.d(1, this.FHb);
      }
      paramVarArgs.aS(2, this.FHy);
      paramVarArgs.aS(3, this.FHz);
      paramVarArgs.aS(4, this.FHA);
      paramVarArgs.aS(5, this.FHB);
      paramVarArgs.aY(6, this.FHC);
      paramVarArgs.aY(7, this.FHD);
      paramVarArgs.aS(8, this.FHm);
      paramVarArgs.bt(9, this.FHE);
      paramVarArgs.aS(10, this.FHF);
      paramVarArgs.bt(11, this.FHG);
      if (this.FHH != null)
      {
        paramVarArgs.lC(12, this.FHH.computeSize());
        this.FHH.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(13, this.FHI);
      if (this.FHJ != null)
      {
        paramVarArgs.lC(14, this.FHJ.computeSize());
        this.FHJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.FHK);
      paramVarArgs.bt(16, this.FHL);
      paramVarArgs.e(17, 1, this.FHM);
      if (this.FHN != null) {
        paramVarArgs.d(18, this.FHN);
      }
      if (this.FHO != null) {
        paramVarArgs.d(19, this.FHO);
      }
      AppMethodBeat.o(124426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FHb == null) {
        break label1410;
      }
    }
    label1410:
    for (paramInt = f.a.a.b.b.a.e(1, this.FHb) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FHy) + f.a.a.b.b.a.bz(3, this.FHz) + f.a.a.b.b.a.bz(4, this.FHA) + f.a.a.b.b.a.bz(5, this.FHB) + f.a.a.b.b.a.p(6, this.FHC) + f.a.a.b.b.a.p(7, this.FHD) + f.a.a.b.b.a.bz(8, this.FHm) + f.a.a.b.b.a.alV(9) + f.a.a.b.b.a.bz(10, this.FHF) + f.a.a.b.b.a.alV(11);
      paramInt = i;
      if (this.FHH != null) {
        paramInt = i + f.a.a.a.lB(12, this.FHH.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.alV(13);
      paramInt = i;
      if (this.FHJ != null) {
        paramInt = i + f.a.a.a.lB(14, this.FHJ.computeSize());
      }
      i = paramInt + f.a.a.a.c(15, 8, this.FHK) + f.a.a.b.b.a.alV(16) + f.a.a.a.c(17, 1, this.FHM);
      paramInt = i;
      if (this.FHN != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FHN);
      }
      i = paramInt;
      if (this.FHO != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.FHO);
      }
      AppMethodBeat.o(124426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FHK.clear();
        this.FHM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FHb == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nl localnl = (nl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124426);
          return -1;
        case 1: 
          localnl.FHb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124426);
          return 0;
        case 2: 
          localnl.FHy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124426);
          return 0;
        case 3: 
          localnl.FHz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124426);
          return 0;
        case 4: 
          localnl.FHA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124426);
          return 0;
        case 5: 
          localnl.FHB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124426);
          return 0;
        case 6: 
          localnl.FHC = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124426);
          return 0;
        case 7: 
          localnl.FHD = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124426);
          return 0;
        case 8: 
          localnl.FHm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124426);
          return 0;
        case 9: 
          localnl.FHE = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(124426);
          return 0;
        case 10: 
          localnl.FHF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124426);
          return 0;
        case 11: 
          localnl.FHG = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(124426);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnl.FHH = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 13: 
          localnl.FHI = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(124426);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnl.FHJ = ((vt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eaw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eaw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnl.FHK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 16: 
          localnl.FHL = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(124426);
          return 0;
        case 17: 
          localnl.FHM.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(124426);
          return 0;
        case 18: 
          localnl.FHN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124426);
          return 0;
        }
        localnl.FHO = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(124426);
        return 0;
      }
      AppMethodBeat.o(124426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nl
 * JD-Core Version:    0.7.0.1
 */
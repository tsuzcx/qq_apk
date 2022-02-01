package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cql
  extends com.tencent.mm.bx.a
{
  public String FFL;
  public String Ftq;
  public String Ftr;
  public String Fts;
  public String Ftt;
  public String Ftu;
  public String Ftv;
  public eiu Ftw;
  public int GWa;
  public String Gtx;
  public String HiS;
  public int HiT;
  public LinkedList<cwt> HiU;
  public String HiV;
  public String HiW;
  public String HiX;
  public String HiY;
  public String HiZ;
  public String Hja;
  public String Hjb;
  public int Hjc;
  public String gsT;
  public String ufY;
  public int ufl;
  public String uiR;
  
  public cql()
  {
    AppMethodBeat.i(152664);
    this.HiU = new LinkedList();
    AppMethodBeat.o(152664);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152665);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gsT != null) {
        paramVarArgs.d(1, this.gsT);
      }
      if (this.uiR != null) {
        paramVarArgs.d(2, this.uiR);
      }
      if (this.Fts != null) {
        paramVarArgs.d(3, this.Fts);
      }
      if (this.Gtx != null) {
        paramVarArgs.d(4, this.Gtx);
      }
      if (this.Ftr != null) {
        paramVarArgs.d(5, this.Ftr);
      }
      if (this.Ftq != null) {
        paramVarArgs.d(6, this.Ftq);
      }
      if (this.HiS != null) {
        paramVarArgs.d(7, this.HiS);
      }
      paramVarArgs.aS(8, this.HiT);
      paramVarArgs.e(9, 8, this.HiU);
      if (this.Ftt != null) {
        paramVarArgs.d(10, this.Ftt);
      }
      if (this.HiV != null) {
        paramVarArgs.d(11, this.HiV);
      }
      if (this.HiW != null) {
        paramVarArgs.d(12, this.HiW);
      }
      paramVarArgs.aS(13, this.GWa);
      if (this.FFL != null) {
        paramVarArgs.d(14, this.FFL);
      }
      if (this.ufY != null) {
        paramVarArgs.d(15, this.ufY);
      }
      if (this.Ftu != null) {
        paramVarArgs.d(16, this.Ftu);
      }
      if (this.HiX != null) {
        paramVarArgs.d(17, this.HiX);
      }
      if (this.HiY != null) {
        paramVarArgs.d(18, this.HiY);
      }
      if (this.Ftv != null) {
        paramVarArgs.d(19, this.Ftv);
      }
      if (this.HiZ != null) {
        paramVarArgs.d(20, this.HiZ);
      }
      if (this.Hja != null) {
        paramVarArgs.d(21, this.Hja);
      }
      if (this.Ftw != null)
      {
        paramVarArgs.lC(22, this.Ftw.computeSize());
        this.Ftw.writeFields(paramVarArgs);
      }
      if (this.Hjb != null) {
        paramVarArgs.d(23, this.Hjb);
      }
      paramVarArgs.aS(24, this.Hjc);
      paramVarArgs.aS(25, this.ufl);
      AppMethodBeat.o(152665);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gsT == null) {
        break label1806;
      }
    }
    label1806:
    for (int i = f.a.a.b.b.a.e(1, this.gsT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uiR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uiR);
      }
      i = paramInt;
      if (this.Fts != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fts);
      }
      paramInt = i;
      if (this.Gtx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gtx);
      }
      i = paramInt;
      if (this.Ftr != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ftr);
      }
      paramInt = i;
      if (this.Ftq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ftq);
      }
      i = paramInt;
      if (this.HiS != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HiS);
      }
      i = i + f.a.a.b.b.a.bz(8, this.HiT) + f.a.a.a.c(9, 8, this.HiU);
      paramInt = i;
      if (this.Ftt != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Ftt);
      }
      i = paramInt;
      if (this.HiV != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.HiV);
      }
      paramInt = i;
      if (this.HiW != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HiW);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.GWa);
      paramInt = i;
      if (this.FFL != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FFL);
      }
      i = paramInt;
      if (this.ufY != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.ufY);
      }
      paramInt = i;
      if (this.Ftu != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Ftu);
      }
      i = paramInt;
      if (this.HiX != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.HiX);
      }
      paramInt = i;
      if (this.HiY != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.HiY);
      }
      i = paramInt;
      if (this.Ftv != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.Ftv);
      }
      paramInt = i;
      if (this.HiZ != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.HiZ);
      }
      i = paramInt;
      if (this.Hja != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.Hja);
      }
      paramInt = i;
      if (this.Ftw != null) {
        paramInt = i + f.a.a.a.lB(22, this.Ftw.computeSize());
      }
      i = paramInt;
      if (this.Hjb != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.Hjb);
      }
      paramInt = f.a.a.b.b.a.bz(24, this.Hjc);
      int j = f.a.a.b.b.a.bz(25, this.ufl);
      AppMethodBeat.o(152665);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HiU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cql localcql = (cql)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152665);
          return -1;
        case 1: 
          localcql.gsT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 2: 
          localcql.uiR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 3: 
          localcql.Fts = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 4: 
          localcql.Gtx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 5: 
          localcql.Ftr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 6: 
          localcql.Ftq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 7: 
          localcql.HiS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 8: 
          localcql.HiT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152665);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcql.HiU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 10: 
          localcql.Ftt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 11: 
          localcql.HiV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 12: 
          localcql.HiW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 13: 
          localcql.GWa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152665);
          return 0;
        case 14: 
          localcql.FFL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 15: 
          localcql.ufY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 16: 
          localcql.Ftu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 17: 
          localcql.HiX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 18: 
          localcql.HiY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 19: 
          localcql.Ftv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 20: 
          localcql.HiZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 21: 
          localcql.Hja = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcql.Ftw = ((eiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 23: 
          localcql.Hjb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 24: 
          localcql.Hjc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152665);
          return 0;
        }
        localcql.ufl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152665);
        return 0;
      }
      AppMethodBeat.o(152665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cql
 * JD-Core Version:    0.7.0.1
 */
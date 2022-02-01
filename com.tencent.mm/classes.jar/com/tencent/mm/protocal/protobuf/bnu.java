package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnu
  extends com.tencent.mm.bx.a
{
  public int FHA;
  public long GDp;
  public String GHY;
  public bnv GHZ;
  public String GIa;
  public int GIb;
  public int GIc;
  public long GId;
  public String GIe;
  public String GIf;
  public int GIg;
  public String GIh;
  public String GIi;
  public String GIj;
  public String GIk;
  public String GIl;
  public int GIm;
  public String GIn;
  public String Gat;
  public int cOK;
  public int hzE;
  public int subType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91520);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GHY != null) {
        paramVarArgs.d(1, this.GHY);
      }
      paramVarArgs.aS(2, this.subType);
      if (this.Gat != null) {
        paramVarArgs.d(3, this.Gat);
      }
      if (this.GHZ != null)
      {
        paramVarArgs.lC(4, this.GHZ.computeSize());
        this.GHZ.writeFields(paramVarArgs);
      }
      if (this.GIa != null) {
        paramVarArgs.d(5, this.GIa);
      }
      paramVarArgs.aS(6, this.GIb);
      paramVarArgs.aS(7, this.GIc);
      paramVarArgs.aY(8, this.GId);
      paramVarArgs.aS(9, this.hzE);
      paramVarArgs.aS(10, this.FHA);
      if (this.GIe != null) {
        paramVarArgs.d(11, this.GIe);
      }
      if (this.GIf != null) {
        paramVarArgs.d(12, this.GIf);
      }
      paramVarArgs.aS(13, this.GIg);
      if (this.GIh != null) {
        paramVarArgs.d(14, this.GIh);
      }
      if (this.GIi != null) {
        paramVarArgs.d(15, this.GIi);
      }
      if (this.GIj != null) {
        paramVarArgs.d(16, this.GIj);
      }
      if (this.GIk != null) {
        paramVarArgs.d(17, this.GIk);
      }
      if (this.GIl != null) {
        paramVarArgs.d(18, this.GIl);
      }
      paramVarArgs.aS(19, this.GIm);
      paramVarArgs.aY(20, this.GDp);
      paramVarArgs.aS(21, this.cOK);
      if (this.GIn != null) {
        paramVarArgs.d(22, this.GIn);
      }
      AppMethodBeat.o(91520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GHY == null) {
        break label1434;
      }
    }
    label1434:
    for (paramInt = f.a.a.b.b.a.e(1, this.GHY) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.subType);
      paramInt = i;
      if (this.Gat != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gat);
      }
      i = paramInt;
      if (this.GHZ != null) {
        i = paramInt + f.a.a.a.lB(4, this.GHZ.computeSize());
      }
      paramInt = i;
      if (this.GIa != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GIa);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GIb) + f.a.a.b.b.a.bz(7, this.GIc) + f.a.a.b.b.a.p(8, this.GId) + f.a.a.b.b.a.bz(9, this.hzE) + f.a.a.b.b.a.bz(10, this.FHA);
      paramInt = i;
      if (this.GIe != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GIe);
      }
      i = paramInt;
      if (this.GIf != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GIf);
      }
      i += f.a.a.b.b.a.bz(13, this.GIg);
      paramInt = i;
      if (this.GIh != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.GIh);
      }
      i = paramInt;
      if (this.GIi != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.GIi);
      }
      paramInt = i;
      if (this.GIj != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GIj);
      }
      i = paramInt;
      if (this.GIk != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.GIk);
      }
      paramInt = i;
      if (this.GIl != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.GIl);
      }
      i = paramInt + f.a.a.b.b.a.bz(19, this.GIm) + f.a.a.b.b.a.p(20, this.GDp) + f.a.a.b.b.a.bz(21, this.cOK);
      paramInt = i;
      if (this.GIn != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.GIn);
      }
      AppMethodBeat.o(91520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnu localbnu = (bnu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91520);
          return -1;
        case 1: 
          localbnu.GHY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 2: 
          localbnu.subType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 3: 
          localbnu.Gat = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bnv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbnu.GHZ = ((bnv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91520);
          return 0;
        case 5: 
          localbnu.GIa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 6: 
          localbnu.GIb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 7: 
          localbnu.GIc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 8: 
          localbnu.GId = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91520);
          return 0;
        case 9: 
          localbnu.hzE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 10: 
          localbnu.FHA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 11: 
          localbnu.GIe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 12: 
          localbnu.GIf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 13: 
          localbnu.GIg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 14: 
          localbnu.GIh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 15: 
          localbnu.GIi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 16: 
          localbnu.GIj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 17: 
          localbnu.GIk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 18: 
          localbnu.GIl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 19: 
          localbnu.GIm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91520);
          return 0;
        case 20: 
          localbnu.GDp = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91520);
          return 0;
        case 21: 
          localbnu.cOK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91520);
          return 0;
        }
        localbnu.GIn = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91520);
        return 0;
      }
      AppMethodBeat.o(91520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnu
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class iu
  extends com.tencent.mm.bw.a
{
  public String HVD;
  public String HVF;
  public String HVI;
  public String HVJ;
  public String KMY;
  public String KMZ;
  public String KNa;
  public String KNb;
  public String KNc;
  public String KNd;
  public String KNe;
  public String KNf;
  public String KNg;
  public long KNh;
  public int KNi;
  public String KNj;
  public String KNk;
  public String KNl;
  public String KNm;
  public iv KNn;
  public dfc KNo;
  public String dSf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91351);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KMY != null) {
        paramVarArgs.e(1, this.KMY);
      }
      if (this.KMZ != null) {
        paramVarArgs.e(2, this.KMZ);
      }
      if (this.KNa != null) {
        paramVarArgs.e(3, this.KNa);
      }
      if (this.KNb != null) {
        paramVarArgs.e(4, this.KNb);
      }
      if (this.KNc != null) {
        paramVarArgs.e(5, this.KNc);
      }
      if (this.KNd != null) {
        paramVarArgs.e(6, this.KNd);
      }
      if (this.KNe != null) {
        paramVarArgs.e(7, this.KNe);
      }
      if (this.KNf != null) {
        paramVarArgs.e(8, this.KNf);
      }
      if (this.dSf != null) {
        paramVarArgs.e(9, this.dSf);
      }
      if (this.KNg != null) {
        paramVarArgs.e(10, this.KNg);
      }
      if (this.HVF != null) {
        paramVarArgs.e(11, this.HVF);
      }
      if (this.HVJ != null) {
        paramVarArgs.e(12, this.HVJ);
      }
      if (this.HVI != null) {
        paramVarArgs.e(13, this.HVI);
      }
      paramVarArgs.bb(14, this.KNh);
      paramVarArgs.aM(15, this.KNi);
      if (this.KNj != null) {
        paramVarArgs.e(16, this.KNj);
      }
      if (this.KNk != null) {
        paramVarArgs.e(17, this.KNk);
      }
      if (this.KNl != null) {
        paramVarArgs.e(18, this.KNl);
      }
      if (this.HVD != null) {
        paramVarArgs.e(19, this.HVD);
      }
      if (this.KNm != null) {
        paramVarArgs.e(20, this.KNm);
      }
      if (this.KNn != null)
      {
        paramVarArgs.ni(21, this.KNn.computeSize());
        this.KNn.writeFields(paramVarArgs);
      }
      if (this.KNo != null)
      {
        paramVarArgs.ni(23, this.KNo.computeSize());
        this.KNo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91351);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KMY == null) {
        break label1670;
      }
    }
    label1670:
    for (int i = g.a.a.b.b.a.f(1, this.KMY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KMZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KMZ);
      }
      i = paramInt;
      if (this.KNa != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KNa);
      }
      paramInt = i;
      if (this.KNb != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KNb);
      }
      i = paramInt;
      if (this.KNc != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KNc);
      }
      paramInt = i;
      if (this.KNd != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KNd);
      }
      i = paramInt;
      if (this.KNe != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KNe);
      }
      paramInt = i;
      if (this.KNf != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KNf);
      }
      i = paramInt;
      if (this.dSf != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.dSf);
      }
      paramInt = i;
      if (this.KNg != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KNg);
      }
      i = paramInt;
      if (this.HVF != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.HVF);
      }
      paramInt = i;
      if (this.HVJ != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.HVJ);
      }
      i = paramInt;
      if (this.HVI != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.HVI);
      }
      i = i + g.a.a.b.b.a.r(14, this.KNh) + g.a.a.b.b.a.bu(15, this.KNi);
      paramInt = i;
      if (this.KNj != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.KNj);
      }
      i = paramInt;
      if (this.KNk != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.KNk);
      }
      paramInt = i;
      if (this.KNl != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.KNl);
      }
      i = paramInt;
      if (this.HVD != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.HVD);
      }
      paramInt = i;
      if (this.KNm != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.KNm);
      }
      i = paramInt;
      if (this.KNn != null) {
        i = paramInt + g.a.a.a.nh(21, this.KNn.computeSize());
      }
      paramInt = i;
      if (this.KNo != null) {
        paramInt = i + g.a.a.a.nh(23, this.KNo.computeSize());
      }
      AppMethodBeat.o(91351);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91351);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        iu localiu = (iu)paramVarArgs[1];
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
          localiu.KMY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 2: 
          localiu.KMZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 3: 
          localiu.KNa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 4: 
          localiu.KNb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 5: 
          localiu.KNc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 6: 
          localiu.KNd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 7: 
          localiu.KNe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 8: 
          localiu.KNf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 9: 
          localiu.dSf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 10: 
          localiu.KNg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 11: 
          localiu.HVF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 12: 
          localiu.HVJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 13: 
          localiu.HVI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 14: 
          localiu.KNh = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91351);
          return 0;
        case 15: 
          localiu.KNi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91351);
          return 0;
        case 16: 
          localiu.KNj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 17: 
          localiu.KNk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 18: 
          localiu.KNl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 19: 
          localiu.HVD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 20: 
          localiu.KNm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91351);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localiu.KNn = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91351);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localiu.KNo = ((dfc)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iu
 * JD-Core Version:    0.7.0.1
 */
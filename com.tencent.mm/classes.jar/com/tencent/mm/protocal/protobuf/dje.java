package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dje
  extends com.tencent.mm.bw.a
{
  public String KFq;
  public String KFr;
  public String KFs;
  public String KFt;
  public String KFu;
  public String KFv;
  public ffi KFw;
  public String KRY;
  public String LRb;
  public String MNg;
  public int MNh;
  public LinkedList<dqi> MNi;
  public String MNj;
  public String MNk;
  public String MNl;
  public String MNm;
  public String MNn;
  public String MNo;
  public String MNp;
  public int MNq;
  public int Myh;
  public String hik;
  public int xIN;
  public String xJM;
  public String xMq;
  
  public dje()
  {
    AppMethodBeat.i(152664);
    this.MNi = new LinkedList();
    AppMethodBeat.o(152664);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152665);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.hik != null) {
        paramVarArgs.e(1, this.hik);
      }
      if (this.xMq != null) {
        paramVarArgs.e(2, this.xMq);
      }
      if (this.KFs != null) {
        paramVarArgs.e(3, this.KFs);
      }
      if (this.LRb != null) {
        paramVarArgs.e(4, this.LRb);
      }
      if (this.KFr != null) {
        paramVarArgs.e(5, this.KFr);
      }
      if (this.KFq != null) {
        paramVarArgs.e(6, this.KFq);
      }
      if (this.MNg != null) {
        paramVarArgs.e(7, this.MNg);
      }
      paramVarArgs.aM(8, this.MNh);
      paramVarArgs.e(9, 8, this.MNi);
      if (this.KFt != null) {
        paramVarArgs.e(10, this.KFt);
      }
      if (this.MNj != null) {
        paramVarArgs.e(11, this.MNj);
      }
      if (this.MNk != null) {
        paramVarArgs.e(12, this.MNk);
      }
      paramVarArgs.aM(13, this.Myh);
      if (this.KRY != null) {
        paramVarArgs.e(14, this.KRY);
      }
      if (this.xJM != null) {
        paramVarArgs.e(15, this.xJM);
      }
      if (this.KFu != null) {
        paramVarArgs.e(16, this.KFu);
      }
      if (this.MNl != null) {
        paramVarArgs.e(17, this.MNl);
      }
      if (this.MNm != null) {
        paramVarArgs.e(18, this.MNm);
      }
      if (this.KFv != null) {
        paramVarArgs.e(19, this.KFv);
      }
      if (this.MNn != null) {
        paramVarArgs.e(20, this.MNn);
      }
      if (this.MNo != null) {
        paramVarArgs.e(21, this.MNo);
      }
      if (this.KFw != null)
      {
        paramVarArgs.ni(22, this.KFw.computeSize());
        this.KFw.writeFields(paramVarArgs);
      }
      if (this.MNp != null) {
        paramVarArgs.e(23, this.MNp);
      }
      paramVarArgs.aM(24, this.MNq);
      paramVarArgs.aM(25, this.xIN);
      AppMethodBeat.o(152665);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hik == null) {
        break label1806;
      }
    }
    label1806:
    for (int i = g.a.a.b.b.a.f(1, this.hik) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xMq != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xMq);
      }
      i = paramInt;
      if (this.KFs != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KFs);
      }
      paramInt = i;
      if (this.LRb != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LRb);
      }
      i = paramInt;
      if (this.KFr != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KFr);
      }
      paramInt = i;
      if (this.KFq != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KFq);
      }
      i = paramInt;
      if (this.MNg != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MNg);
      }
      i = i + g.a.a.b.b.a.bu(8, this.MNh) + g.a.a.a.c(9, 8, this.MNi);
      paramInt = i;
      if (this.KFt != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KFt);
      }
      i = paramInt;
      if (this.MNj != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.MNj);
      }
      paramInt = i;
      if (this.MNk != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MNk);
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.Myh);
      paramInt = i;
      if (this.KRY != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.KRY);
      }
      i = paramInt;
      if (this.xJM != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.xJM);
      }
      paramInt = i;
      if (this.KFu != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.KFu);
      }
      i = paramInt;
      if (this.MNl != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.MNl);
      }
      paramInt = i;
      if (this.MNm != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.MNm);
      }
      i = paramInt;
      if (this.KFv != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.KFv);
      }
      paramInt = i;
      if (this.MNn != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.MNn);
      }
      i = paramInt;
      if (this.MNo != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.MNo);
      }
      paramInt = i;
      if (this.KFw != null) {
        paramInt = i + g.a.a.a.nh(22, this.KFw.computeSize());
      }
      i = paramInt;
      if (this.MNp != null) {
        i = paramInt + g.a.a.b.b.a.f(23, this.MNp);
      }
      paramInt = g.a.a.b.b.a.bu(24, this.MNq);
      int j = g.a.a.b.b.a.bu(25, this.xIN);
      AppMethodBeat.o(152665);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MNi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dje localdje = (dje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152665);
          return -1;
        case 1: 
          localdje.hik = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 2: 
          localdje.xMq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 3: 
          localdje.KFs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 4: 
          localdje.LRb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 5: 
          localdje.KFr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 6: 
          localdje.KFq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 7: 
          localdje.MNg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 8: 
          localdje.MNh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152665);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdje.MNi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 10: 
          localdje.KFt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 11: 
          localdje.MNj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 12: 
          localdje.MNk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 13: 
          localdje.Myh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152665);
          return 0;
        case 14: 
          localdje.KRY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 15: 
          localdje.xJM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 16: 
          localdje.KFu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 17: 
          localdje.MNl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 18: 
          localdje.MNm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 19: 
          localdje.KFv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 20: 
          localdje.MNn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 21: 
          localdje.MNo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ffi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ffi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdje.KFw = ((ffi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 23: 
          localdje.MNp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 24: 
          localdje.MNq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152665);
          return 0;
        }
        localdje.xIN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152665);
        return 0;
      }
      AppMethodBeat.o(152665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dje
 * JD-Core Version:    0.7.0.1
 */
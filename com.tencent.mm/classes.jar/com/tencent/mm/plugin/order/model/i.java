package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String uuo;
  public String wSZ;
  public double wTa;
  public String wTb;
  public String wTc;
  public int wTd;
  public String wTe;
  public int wTf;
  public int wTg;
  public String wTh;
  public String wTi;
  public String wTj;
  public String wTk;
  public String wTl;
  public int wTm;
  public LinkedList<k> wTn;
  public String wTo;
  public String wTp;
  public double wTq;
  public String wTr;
  
  public i()
  {
    AppMethodBeat.i(91261);
    this.wTn = new LinkedList();
    AppMethodBeat.o(91261);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wSZ != null) {
        paramVarArgs.d(1, this.wSZ);
      }
      paramVarArgs.e(2, this.wTa);
      if (this.wTb != null) {
        paramVarArgs.d(3, this.wTb);
      }
      paramVarArgs.aS(4, this.CreateTime);
      if (this.wTc != null) {
        paramVarArgs.d(5, this.wTc);
      }
      paramVarArgs.aS(6, this.wTd);
      if (this.wTe != null) {
        paramVarArgs.d(7, this.wTe);
      }
      paramVarArgs.aS(8, this.wTf);
      paramVarArgs.aS(9, this.wTg);
      if (this.wTh != null) {
        paramVarArgs.d(10, this.wTh);
      }
      if (this.uuo != null) {
        paramVarArgs.d(11, this.uuo);
      }
      if (this.wTi != null) {
        paramVarArgs.d(12, this.wTi);
      }
      if (this.wTj != null) {
        paramVarArgs.d(13, this.wTj);
      }
      if (this.wTk != null) {
        paramVarArgs.d(14, this.wTk);
      }
      if (this.wTl != null) {
        paramVarArgs.d(15, this.wTl);
      }
      paramVarArgs.aS(16, this.wTm);
      paramVarArgs.e(17, 8, this.wTn);
      if (this.wTo != null) {
        paramVarArgs.d(18, this.wTo);
      }
      if (this.wTp != null) {
        paramVarArgs.d(19, this.wTp);
      }
      paramVarArgs.e(20, this.wTq);
      if (this.wTr != null) {
        paramVarArgs.d(21, this.wTr);
      }
      AppMethodBeat.o(91262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wSZ == null) {
        break label1412;
      }
    }
    label1412:
    for (paramInt = f.a.a.b.b.a.e(1, this.wSZ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.amD(2);
      paramInt = i;
      if (this.wTb != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.wTb);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.CreateTime);
      paramInt = i;
      if (this.wTc != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wTc);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.wTd);
      paramInt = i;
      if (this.wTe != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.wTe);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.wTf) + f.a.a.b.b.a.bz(9, this.wTg);
      paramInt = i;
      if (this.wTh != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.wTh);
      }
      i = paramInt;
      if (this.uuo != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.uuo);
      }
      paramInt = i;
      if (this.wTi != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.wTi);
      }
      i = paramInt;
      if (this.wTj != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.wTj);
      }
      paramInt = i;
      if (this.wTk != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.wTk);
      }
      i = paramInt;
      if (this.wTl != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.wTl);
      }
      i = i + f.a.a.b.b.a.bz(16, this.wTm) + f.a.a.a.c(17, 8, this.wTn);
      paramInt = i;
      if (this.wTo != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.wTo);
      }
      i = paramInt;
      if (this.wTp != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.wTp);
      }
      i += f.a.a.b.b.a.amD(20);
      paramInt = i;
      if (this.wTr != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.wTr);
      }
      AppMethodBeat.o(91262);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wTn.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91262);
          return -1;
        case 1: 
          locali.wSZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 2: 
          locali.wTa = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(91262);
          return 0;
        case 3: 
          locali.wTb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 4: 
          locali.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91262);
          return 0;
        case 5: 
          locali.wTc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 6: 
          locali.wTd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91262);
          return 0;
        case 7: 
          locali.wTe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 8: 
          locali.wTf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91262);
          return 0;
        case 9: 
          locali.wTg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91262);
          return 0;
        case 10: 
          locali.wTh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 11: 
          locali.uuo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 12: 
          locali.wTi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 13: 
          locali.wTj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 14: 
          locali.wTk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 15: 
          locali.wTl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 16: 
          locali.wTm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91262);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locali.wTn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91262);
          return 0;
        case 18: 
          locali.wTo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 19: 
          locali.wTp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91262);
          return 0;
        case 20: 
          locali.wTq = Double.longBitsToDouble(((f.a.a.a.a)localObject1).OmT.gwc());
          AppMethodBeat.o(91262);
          return 0;
        }
        locali.wTr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91262);
        return 0;
      }
      AppMethodBeat.o(91262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.order.model.i
 * JD-Core Version:    0.7.0.1
 */
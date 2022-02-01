package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cki
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int HwR;
  public String uuo;
  public String wSZ;
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
  public LinkedList<dfh> wTn;
  
  public cki()
  {
    AppMethodBeat.i(91596);
    this.wTn = new LinkedList();
    AppMethodBeat.o(91596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91597);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wSZ != null) {
        paramVarArgs.d(1, this.wSZ);
      }
      paramVarArgs.aS(2, this.HwR);
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
      AppMethodBeat.o(91597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wSZ == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.b.b.a.e(1, this.wSZ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HwR);
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
      paramInt = f.a.a.b.b.a.bz(16, this.wTm);
      int j = f.a.a.a.c(17, 8, this.wTn);
      AppMethodBeat.o(91597);
      return i + paramInt + j;
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
        AppMethodBeat.o(91597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cki localcki = (cki)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91597);
          return -1;
        case 1: 
          localcki.wSZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 2: 
          localcki.HwR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91597);
          return 0;
        case 3: 
          localcki.wTb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 4: 
          localcki.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91597);
          return 0;
        case 5: 
          localcki.wTc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 6: 
          localcki.wTd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91597);
          return 0;
        case 7: 
          localcki.wTe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 8: 
          localcki.wTf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91597);
          return 0;
        case 9: 
          localcki.wTg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91597);
          return 0;
        case 10: 
          localcki.wTh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 11: 
          localcki.uuo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 12: 
          localcki.wTi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 13: 
          localcki.wTj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 14: 
          localcki.wTk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 15: 
          localcki.wTl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 16: 
          localcki.wTm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91597);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dfh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcki.wTn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91597);
        return 0;
      }
      AppMethodBeat.o(91597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cki
 * JD-Core Version:    0.7.0.1
 */
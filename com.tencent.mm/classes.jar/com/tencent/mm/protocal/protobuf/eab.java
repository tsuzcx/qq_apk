package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eab
  extends cvw
{
  public int Gxq;
  public long Gxr;
  public int HzI;
  public int Idr;
  public LinkedList<ccp> Ids;
  public int IfP;
  public int IfQ;
  public LinkedList<eae> IfR;
  public int IfS;
  public int IfT;
  public int IfU;
  
  public eab()
  {
    AppMethodBeat.i(115905);
    this.IfR = new LinkedList();
    this.Ids = new LinkedList();
    AppMethodBeat.o(115905);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115906);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aZ(3, this.Gxr);
      paramVarArgs.aS(4, this.HzI);
      paramVarArgs.aS(5, this.IfP);
      paramVarArgs.aS(6, this.IfQ);
      paramVarArgs.e(7, 8, this.IfR);
      paramVarArgs.aS(8, this.IfS);
      paramVarArgs.aS(9, this.Idr);
      paramVarArgs.e(10, 8, this.Ids);
      paramVarArgs.aS(11, this.IfT);
      paramVarArgs.aS(12, this.IfU);
      AppMethodBeat.o(115906);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1022;
      }
    }
    label1022:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Gxq);
      int j = f.a.a.b.b.a.p(3, this.Gxr);
      int k = f.a.a.b.b.a.bz(4, this.HzI);
      int m = f.a.a.b.b.a.bz(5, this.IfP);
      int n = f.a.a.b.b.a.bz(6, this.IfQ);
      int i1 = f.a.a.a.c(7, 8, this.IfR);
      int i2 = f.a.a.b.b.a.bz(8, this.IfS);
      int i3 = f.a.a.b.b.a.bz(9, this.Idr);
      int i4 = f.a.a.a.c(10, 8, this.Ids);
      int i5 = f.a.a.b.b.a.bz(11, this.IfT);
      int i6 = f.a.a.b.b.a.bz(12, this.IfU);
      AppMethodBeat.o(115906);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IfR.clear();
        this.Ids.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(115906);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eab localeab = (eab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115906);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeab.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 2: 
          localeab.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115906);
          return 0;
        case 3: 
          localeab.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115906);
          return 0;
        case 4: 
          localeab.HzI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115906);
          return 0;
        case 5: 
          localeab.IfP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115906);
          return 0;
        case 6: 
          localeab.IfQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115906);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eae();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eae)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeab.IfR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 8: 
          localeab.IfS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115906);
          return 0;
        case 9: 
          localeab.Idr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115906);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeab.Ids.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 11: 
          localeab.IfT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115906);
          return 0;
        }
        localeab.IfU = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115906);
        return 0;
      }
      AppMethodBeat.o(115906);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eab
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyk
  extends cvc
{
  public int GeI;
  public long GeJ;
  public int HJj;
  public LinkedList<cbv> HJk;
  public int HLH;
  public int HLI;
  public LinkedList<dyn> HLJ;
  public int HLK;
  public int HLL;
  public int HLM;
  public int Hgi;
  
  public dyk()
  {
    AppMethodBeat.i(115905);
    this.HLJ = new LinkedList();
    this.HJk = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aY(3, this.GeJ);
      paramVarArgs.aS(4, this.Hgi);
      paramVarArgs.aS(5, this.HLH);
      paramVarArgs.aS(6, this.HLI);
      paramVarArgs.e(7, 8, this.HLJ);
      paramVarArgs.aS(8, this.HLK);
      paramVarArgs.aS(9, this.HJj);
      paramVarArgs.e(10, 8, this.HJk);
      paramVarArgs.aS(11, this.HLL);
      paramVarArgs.aS(12, this.HLM);
      AppMethodBeat.o(115906);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1022;
      }
    }
    label1022:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GeI);
      int j = f.a.a.b.b.a.p(3, this.GeJ);
      int k = f.a.a.b.b.a.bz(4, this.Hgi);
      int m = f.a.a.b.b.a.bz(5, this.HLH);
      int n = f.a.a.b.b.a.bz(6, this.HLI);
      int i1 = f.a.a.a.c(7, 8, this.HLJ);
      int i2 = f.a.a.b.b.a.bz(8, this.HLK);
      int i3 = f.a.a.b.b.a.bz(9, this.HJj);
      int i4 = f.a.a.a.c(10, 8, this.HJk);
      int i5 = f.a.a.b.b.a.bz(11, this.HLL);
      int i6 = f.a.a.b.b.a.bz(12, this.HLM);
      AppMethodBeat.o(115906);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HLJ.clear();
        this.HJk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(115906);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyk localdyk = (dyk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115906);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 2: 
          localdyk.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115906);
          return 0;
        case 3: 
          localdyk.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115906);
          return 0;
        case 4: 
          localdyk.Hgi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115906);
          return 0;
        case 5: 
          localdyk.HLH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115906);
          return 0;
        case 6: 
          localdyk.HLI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115906);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyk.HLJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 8: 
          localdyk.HLK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115906);
          return 0;
        case 9: 
          localdyk.HJj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115906);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyk.HJk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115906);
          return 0;
        case 11: 
          localdyk.HLL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115906);
          return 0;
        }
        localdyk.HLM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115906);
        return 0;
      }
      AppMethodBeat.o(115906);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyk
 * JD-Core Version:    0.7.0.1
 */
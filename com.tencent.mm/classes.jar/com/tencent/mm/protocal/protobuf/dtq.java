package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtq
  extends cvw
{
  public int FSQ;
  public String FWe;
  public int HZk;
  public int HZl;
  public LinkedList<bww> HZm;
  public LinkedList<bzz> HhU;
  public String nIJ;
  
  public dtq()
  {
    AppMethodBeat.i(155474);
    this.HhU = new LinkedList();
    this.HZm = new LinkedList();
    AppMethodBeat.o(155474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      paramVarArgs.aS(3, this.FSQ);
      if (this.FWe != null) {
        paramVarArgs.d(4, this.FWe);
      }
      paramVarArgs.aS(5, this.HZk);
      paramVarArgs.e(6, 8, this.HhU);
      paramVarArgs.aS(7, this.HZl);
      paramVarArgs.e(8, 8, this.HZm);
      AppMethodBeat.o(155475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i += f.a.a.b.b.a.bz(3, this.FSQ);
      paramInt = i;
      if (this.FWe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FWe);
      }
      i = f.a.a.b.b.a.bz(5, this.HZk);
      int j = f.a.a.a.c(6, 8, this.HhU);
      int k = f.a.a.b.b.a.bz(7, this.HZl);
      int m = f.a.a.a.c(8, 8, this.HZm);
      AppMethodBeat.o(155475);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HhU.clear();
        this.HZm.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtq localdtq = (dtq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155475);
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
            localdtq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155475);
          return 0;
        case 2: 
          localdtq.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155475);
          return 0;
        case 3: 
          localdtq.FSQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155475);
          return 0;
        case 4: 
          localdtq.FWe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(155475);
          return 0;
        case 5: 
          localdtq.HZk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155475);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdtq.HhU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155475);
          return 0;
        case 7: 
          localdtq.HZl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155475);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bww();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bww)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdtq.HZm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155475);
        return 0;
      }
      AppMethodBeat.o(155475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtq
 * JD-Core Version:    0.7.0.1
 */
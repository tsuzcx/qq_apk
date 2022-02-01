package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkq
  extends cvw
{
  public LinkedList<cxn> FNk;
  public int GQn;
  public int Scene;
  public String gvv;
  
  public bkq()
  {
    AppMethodBeat.i(32274);
    this.FNk = new LinkedList();
    AppMethodBeat.o(32274);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32275);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gvv != null) {
        paramVarArgs.d(2, this.gvv);
      }
      paramVarArgs.aS(3, this.GQn);
      paramVarArgs.e(4, 8, this.FNk);
      paramVarArgs.aS(5, this.Scene);
      AppMethodBeat.o(32275);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gvv != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.gvv);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GQn);
      int j = f.a.a.a.c(4, 8, this.FNk);
      int k = f.a.a.b.b.a.bz(5, this.Scene);
      AppMethodBeat.o(32275);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FNk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32275);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bkq localbkq = (bkq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32275);
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
            localbkq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32275);
          return 0;
        case 2: 
          localbkq.gvv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32275);
          return 0;
        case 3: 
          localbkq.GQn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32275);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkq.FNk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32275);
          return 0;
        }
        localbkq.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32275);
        return 0;
      }
      AppMethodBeat.o(32275);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkq
 * JD-Core Version:    0.7.0.1
 */
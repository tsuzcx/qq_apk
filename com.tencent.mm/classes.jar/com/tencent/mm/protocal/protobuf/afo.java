package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afo
  extends cvw
{
  public int GvW;
  public int GvX;
  public int xri;
  public long xrk;
  public int xsB;
  public int xsC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127170);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xri);
      paramVarArgs.aS(3, this.xsB);
      paramVarArgs.aS(4, this.xsC);
      paramVarArgs.aS(5, this.GvW);
      paramVarArgs.aS(6, this.GvX);
      paramVarArgs.aZ(7, this.xrk);
      AppMethodBeat.o(127170);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.xri);
      int j = f.a.a.b.b.a.bz(3, this.xsB);
      int k = f.a.a.b.b.a.bz(4, this.xsC);
      int m = f.a.a.b.b.a.bz(5, this.GvW);
      int n = f.a.a.b.b.a.bz(6, this.GvX);
      int i1 = f.a.a.b.b.a.p(7, this.xrk);
      AppMethodBeat.o(127170);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127170);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afo localafo = (afo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127170);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127170);
          return 0;
        case 2: 
          localafo.xri = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127170);
          return 0;
        case 3: 
          localafo.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127170);
          return 0;
        case 4: 
          localafo.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127170);
          return 0;
        case 5: 
          localafo.GvW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127170);
          return 0;
        case 6: 
          localafo.GvX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127170);
          return 0;
        }
        localafo.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(127170);
        return 0;
      }
      AppMethodBeat.o(127170);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afo
 * JD-Core Version:    0.7.0.1
 */
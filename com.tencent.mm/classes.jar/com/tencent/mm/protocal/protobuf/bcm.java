package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcm
  extends cvw
{
  public int GSh;
  public int GSi;
  public String GSj;
  public int GSk;
  public String nIJ;
  public int xsB;
  public int xsC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152570);
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
      paramVarArgs.aS(3, this.GSh);
      paramVarArgs.aS(4, this.GSi);
      if (this.GSj != null) {
        paramVarArgs.d(5, this.GSj);
      }
      paramVarArgs.aS(6, this.xsB);
      paramVarArgs.aS(7, this.xsC);
      paramVarArgs.aS(8, this.GSk);
      AppMethodBeat.o(152570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GSh) + f.a.a.b.b.a.bz(4, this.GSi);
      paramInt = i;
      if (this.GSj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GSj);
      }
      i = f.a.a.b.b.a.bz(6, this.xsB);
      int j = f.a.a.b.b.a.bz(7, this.xsC);
      int k = f.a.a.b.b.a.bz(8, this.GSk);
      AppMethodBeat.o(152570);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcm localbcm = (bcm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152570);
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
            localbcm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152570);
          return 0;
        case 2: 
          localbcm.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 3: 
          localbcm.GSh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152570);
          return 0;
        case 4: 
          localbcm.GSi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152570);
          return 0;
        case 5: 
          localbcm.GSj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 6: 
          localbcm.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152570);
          return 0;
        case 7: 
          localbcm.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152570);
          return 0;
        }
        localbcm.GSk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152570);
        return 0;
      }
      AppMethodBeat.o(152570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcm
 * JD-Core Version:    0.7.0.1
 */
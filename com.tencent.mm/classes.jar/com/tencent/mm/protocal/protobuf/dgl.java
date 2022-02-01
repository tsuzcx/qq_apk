package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgl
  extends cvw
{
  public String HNG;
  public int HNH;
  public int nJA;
  public int xsB;
  public int xsC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125782);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xsC);
      paramVarArgs.aS(3, this.xsB);
      if (this.HNG != null) {
        paramVarArgs.d(4, this.HNG);
      }
      paramVarArgs.aS(5, this.nJA);
      paramVarArgs.aS(6, this.HNH);
      AppMethodBeat.o(125782);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xsC) + f.a.a.b.b.a.bz(3, this.xsB);
      paramInt = i;
      if (this.HNG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HNG);
      }
      i = f.a.a.b.b.a.bz(5, this.nJA);
      int j = f.a.a.b.b.a.bz(6, this.HNH);
      AppMethodBeat.o(125782);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125782);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgl localdgl = (dgl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125782);
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
            localdgl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125782);
          return 0;
        case 2: 
          localdgl.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125782);
          return 0;
        case 3: 
          localdgl.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125782);
          return 0;
        case 4: 
          localdgl.HNG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125782);
          return 0;
        case 5: 
          localdgl.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125782);
          return 0;
        }
        localdgl.HNH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125782);
        return 0;
      }
      AppMethodBeat.o(125782);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgl
 * JD-Core Version:    0.7.0.1
 */
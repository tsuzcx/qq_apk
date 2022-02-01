package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvb
  extends cvw
{
  public int GeQ;
  public int HhS;
  public int nID;
  public LinkedList<bnf> nIE;
  
  public bvb()
  {
    AppMethodBeat.i(155429);
    this.nIE = new LinkedList();
    AppMethodBeat.o(155429);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155430);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nID);
      paramVarArgs.e(3, 8, this.nIE);
      paramVarArgs.aS(4, this.GeQ);
      paramVarArgs.aS(5, this.HhS);
      AppMethodBeat.o(155430);
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
      int i = f.a.a.b.b.a.bz(2, this.nID);
      int j = f.a.a.a.c(3, 8, this.nIE);
      int k = f.a.a.b.b.a.bz(4, this.GeQ);
      int m = f.a.a.b.b.a.bz(5, this.HhS);
      AppMethodBeat.o(155430);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nIE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvb localbvb = (bvb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155430);
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
            localbvb.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155430);
          return 0;
        case 2: 
          localbvb.nID = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155430);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvb.nIE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155430);
          return 0;
        case 4: 
          localbvb.GeQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(155430);
          return 0;
        }
        localbvb.HhS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(155430);
        return 0;
      }
      AppMethodBeat.o(155430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvb
 * JD-Core Version:    0.7.0.1
 */
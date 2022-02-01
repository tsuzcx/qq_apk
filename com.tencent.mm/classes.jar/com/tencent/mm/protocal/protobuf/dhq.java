package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhq
  extends cvw
{
  public long HOG;
  public int OpCode;
  public int Scene;
  public int nID;
  public LinkedList<cxn> nIE;
  public String uum;
  
  public dhq()
  {
    AppMethodBeat.i(125821);
    this.nIE = new LinkedList();
    AppMethodBeat.o(125821);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125822);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      paramVarArgs.aZ(3, this.HOG);
      if (this.uum != null) {
        paramVarArgs.d(4, this.uum);
      }
      paramVarArgs.aS(5, this.nID);
      paramVarArgs.e(6, 8, this.nIE);
      paramVarArgs.aS(7, this.Scene);
      AppMethodBeat.o(125822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode) + f.a.a.b.b.a.p(3, this.HOG);
      paramInt = i;
      if (this.uum != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uum);
      }
      i = f.a.a.b.b.a.bz(5, this.nID);
      int j = f.a.a.a.c(6, 8, this.nIE);
      int k = f.a.a.b.b.a.bz(7, this.Scene);
      AppMethodBeat.o(125822);
      return paramInt + i + j + k;
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
        AppMethodBeat.o(125822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhq localdhq = (dhq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125822);
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
            localdhq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        case 2: 
          localdhq.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125822);
          return 0;
        case 3: 
          localdhq.HOG = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125822);
          return 0;
        case 4: 
          localdhq.uum = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125822);
          return 0;
        case 5: 
          localdhq.nID = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125822);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhq.nIE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        }
        localdhq.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125822);
        return 0;
      }
      AppMethodBeat.o(125822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhq
 * JD-Core Version:    0.7.0.1
 */
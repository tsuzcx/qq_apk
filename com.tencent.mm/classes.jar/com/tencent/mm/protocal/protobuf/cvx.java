package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvx
  extends ckq
{
  public long Enw;
  public int OpCode;
  public int Scene;
  public int mAK;
  public LinkedList<cmf> mAL;
  public String scP;
  
  public cvx()
  {
    AppMethodBeat.i(125821);
    this.mAL = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      paramVarArgs.aG(3, this.Enw);
      if (this.scP != null) {
        paramVarArgs.d(4, this.scP);
      }
      paramVarArgs.aR(5, this.mAK);
      paramVarArgs.e(6, 8, this.mAL);
      paramVarArgs.aR(7, this.Scene);
      AppMethodBeat.o(125822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.OpCode) + f.a.a.b.b.a.q(3, this.Enw);
      paramInt = i;
      if (this.scP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.scP);
      }
      i = f.a.a.b.b.a.bA(5, this.mAK);
      int j = f.a.a.a.c(6, 8, this.mAL);
      int k = f.a.a.b.b.a.bA(7, this.Scene);
      AppMethodBeat.o(125822);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mAL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvx localcvx = (cvx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125822);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvx.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        case 2: 
          localcvx.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125822);
          return 0;
        case 3: 
          localcvx.Enw = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125822);
          return 0;
        case 4: 
          localcvx.scP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125822);
          return 0;
        case 5: 
          localcvx.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125822);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvx.mAL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        }
        localcvx.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125822);
        return 0;
      }
      AppMethodBeat.o(125822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvx
 * JD-Core Version:    0.7.0.1
 */
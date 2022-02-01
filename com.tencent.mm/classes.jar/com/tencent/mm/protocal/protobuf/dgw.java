package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgw
  extends cvc
{
  public long Hvd;
  public int OpCode;
  public int Scene;
  public int nDi;
  public LinkedList<cwt> nDj;
  public String uiP;
  
  public dgw()
  {
    AppMethodBeat.i(125821);
    this.nDj = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      paramVarArgs.aY(3, this.Hvd);
      if (this.uiP != null) {
        paramVarArgs.d(4, this.uiP);
      }
      paramVarArgs.aS(5, this.nDi);
      paramVarArgs.e(6, 8, this.nDj);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode) + f.a.a.b.b.a.p(3, this.Hvd);
      paramInt = i;
      if (this.uiP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uiP);
      }
      i = f.a.a.b.b.a.bz(5, this.nDi);
      int j = f.a.a.a.c(6, 8, this.nDj);
      int k = f.a.a.b.b.a.bz(7, this.Scene);
      AppMethodBeat.o(125822);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nDj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgw localdgw = (dgw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125822);
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
            localdgw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        case 2: 
          localdgw.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125822);
          return 0;
        case 3: 
          localdgw.Hvd = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125822);
          return 0;
        case 4: 
          localdgw.uiP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125822);
          return 0;
        case 5: 
          localdgw.nDi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125822);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgw.nDj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125822);
          return 0;
        }
        localdgw.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125822);
        return 0;
      }
      AppMethodBeat.o(125822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgw
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class act
  extends cvc
{
  public String FuL;
  public LinkedList<add> FuN;
  public int Scene;
  public int fLb;
  
  public act()
  {
    AppMethodBeat.i(101801);
    this.FuN = new LinkedList();
    AppMethodBeat.o(101801);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101802);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.fLb);
      paramVarArgs.e(3, 8, this.FuN);
      if (this.FuL != null) {
        paramVarArgs.d(4, this.FuL);
      }
      paramVarArgs.aS(5, this.Scene);
      AppMethodBeat.o(101802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.fLb) + f.a.a.a.c(3, 8, this.FuN);
      paramInt = i;
      if (this.FuL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FuL);
      }
      i = f.a.a.b.b.a.bz(5, this.Scene);
      AppMethodBeat.o(101802);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FuN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(101802);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        act localact = (act)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101802);
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
            localact.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101802);
          return 0;
        case 2: 
          localact.fLb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101802);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new add();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((add)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localact.FuN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101802);
          return 0;
        case 4: 
          localact.FuL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101802);
          return 0;
        }
        localact.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(101802);
        return 0;
      }
      AppMethodBeat.o(101802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.act
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zu
  extends ckq
{
  public String Cxb;
  public LinkedList<aae> Cxd;
  public int Scene;
  public int fpb;
  
  public zu()
  {
    AppMethodBeat.i(101801);
    this.Cxd = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.fpb);
      paramVarArgs.e(3, 8, this.Cxd);
      if (this.Cxb != null) {
        paramVarArgs.d(4, this.Cxb);
      }
      paramVarArgs.aR(5, this.Scene);
      AppMethodBeat.o(101802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.fpb) + f.a.a.a.c(3, 8, this.Cxd);
      paramInt = i;
      if (this.Cxb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Cxb);
      }
      i = f.a.a.b.b.a.bA(5, this.Scene);
      AppMethodBeat.o(101802);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Cxd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(101802);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        zu localzu = (zu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101802);
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
            localzu.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101802);
          return 0;
        case 2: 
          localzu.fpb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101802);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aae();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aae)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localzu.Cxd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101802);
          return 0;
        case 4: 
          localzu.Cxb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101802);
          return 0;
        }
        localzu.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(101802);
        return 0;
      }
      AppMethodBeat.o(101802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zu
 * JD-Core Version:    0.7.0.1
 */
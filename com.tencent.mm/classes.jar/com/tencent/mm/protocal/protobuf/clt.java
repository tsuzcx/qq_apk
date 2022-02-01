package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clt
  extends ckq
{
  public String Cxb;
  public int EgW;
  public clz EgX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Cxb != null) {
        paramVarArgs.d(2, this.Cxb);
      }
      paramVarArgs.aR(3, this.EgW);
      if (this.EgX != null)
      {
        paramVarArgs.kX(4, this.EgX.computeSize());
        this.EgX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(181506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Cxb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Cxb);
      }
      i += f.a.a.b.b.a.bA(3, this.EgW);
      paramInt = i;
      if (this.EgX != null) {
        paramInt = i + f.a.a.a.kW(4, this.EgX.computeSize());
      }
      AppMethodBeat.o(181506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(181506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        clt localclt = (clt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181506);
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
            localclt.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(181506);
          return 0;
        case 2: 
          localclt.Cxb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(181506);
          return 0;
        case 3: 
          localclt.EgW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(181506);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((clz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclt.EgX = ((clz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(181506);
        return 0;
      }
      AppMethodBeat.o(181506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clt
 * JD-Core Version:    0.7.0.1
 */
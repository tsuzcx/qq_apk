package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ou
  extends ckq
{
  public String CME;
  public int CMW;
  public int CMX;
  public long CMY;
  public dh CMn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91376);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CMn != null)
      {
        paramVarArgs.kX(2, this.CMn.computeSize());
        this.CMn.writeFields(paramVarArgs);
      }
      if (this.CME != null) {
        paramVarArgs.d(3, this.CME);
      }
      paramVarArgs.aR(4, this.CMW);
      paramVarArgs.aR(5, this.CMX);
      paramVarArgs.aG(6, this.CMY);
      AppMethodBeat.o(91376);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMn != null) {
        paramInt = i + f.a.a.a.kW(2, this.CMn.computeSize());
      }
      i = paramInt;
      if (this.CME != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CME);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.CMW);
      int j = f.a.a.b.b.a.bA(5, this.CMX);
      int k = f.a.a.b.b.a.q(6, this.CMY);
      AppMethodBeat.o(91376);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91376);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ou localou = (ou)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91376);
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
            localou.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91376);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localou.CMn = ((dh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91376);
          return 0;
        case 3: 
          localou.CME = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91376);
          return 0;
        case 4: 
          localou.CMW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91376);
          return 0;
        case 5: 
          localou.CMX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91376);
          return 0;
        }
        localou.CMY = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(91376);
        return 0;
      }
      AppMethodBeat.o(91376);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ou
 * JD-Core Version:    0.7.0.1
 */
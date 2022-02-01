package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjz
  extends ckq
{
  public String DHX;
  public LinkedList<String> DIa;
  public LinkedList<Integer> DIb;
  
  public bjz()
  {
    AppMethodBeat.i(124524);
    this.DIa = new LinkedList();
    this.DIb = new LinkedList();
    AppMethodBeat.o(124524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124525);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DHX != null) {
        paramVarArgs.d(2, this.DHX);
      }
      paramVarArgs.e(3, 1, this.DIa);
      paramVarArgs.e(4, 2, this.DIb);
      AppMethodBeat.o(124525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label493;
      }
    }
    label493:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DHX != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DHX);
      }
      paramInt = f.a.a.a.c(3, 1, this.DIa);
      int j = f.a.a.a.c(4, 2, this.DIb);
      AppMethodBeat.o(124525);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DIa.clear();
        this.DIb.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjz localbjz = (bjz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124525);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124525);
          return 0;
        case 2: 
          localbjz.DHX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124525);
          return 0;
        case 3: 
          localbjz.DIa.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(124525);
          return 0;
        }
        localbjz.DIb.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
        AppMethodBeat.o(124525);
        return 0;
      }
      AppMethodBeat.o(124525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjz
 * JD-Core Version:    0.7.0.1
 */
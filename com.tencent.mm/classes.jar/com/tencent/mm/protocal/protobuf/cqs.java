package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqs
  extends cvc
{
  public String Hjr;
  public String duW;
  public int paX;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32403);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.paX);
      if (this.Hjr != null) {
        paramVarArgs.d(3, this.Hjr);
      }
      if (this.duW != null) {
        paramVarArgs.d(4, this.duW);
      }
      paramVarArgs.aS(5, this.scene);
      AppMethodBeat.o(32403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label529;
      }
    }
    label529:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.paX);
      paramInt = i;
      if (this.Hjr != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Hjr);
      }
      i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.duW);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.scene);
      AppMethodBeat.o(32403);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqs localcqs = (cqs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32403);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32403);
          return 0;
        case 2: 
          localcqs.paX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32403);
          return 0;
        case 3: 
          localcqs.Hjr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32403);
          return 0;
        case 4: 
          localcqs.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32403);
          return 0;
        }
        localcqs.scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32403);
        return 0;
      }
      AppMethodBeat.o(32403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqs
 * JD-Core Version:    0.7.0.1
 */
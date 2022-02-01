package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dck
  extends cvc
{
  public String appId;
  public String dpf;
  public int tqF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32436);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appId != null) {
        paramVarArgs.d(2, this.appId);
      }
      paramVarArgs.aS(3, this.tqF);
      if (this.dpf != null) {
        paramVarArgs.d(4, this.dpf);
      }
      AppMethodBeat.o(32436);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appId != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.appId);
      }
      i += f.a.a.b.b.a.bz(3, this.tqF);
      paramInt = i;
      if (this.dpf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dpf);
      }
      AppMethodBeat.o(32436);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32436);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dck localdck = (dck)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32436);
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
            localdck.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32436);
          return 0;
        case 2: 
          localdck.appId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32436);
          return 0;
        case 3: 
          localdck.tqF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32436);
          return 0;
        }
        localdck.dpf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32436);
        return 0;
      }
      AppMethodBeat.o(32436);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dck
 * JD-Core Version:    0.7.0.1
 */
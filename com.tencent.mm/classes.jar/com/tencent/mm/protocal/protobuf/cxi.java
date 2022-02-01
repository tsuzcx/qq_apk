package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cxi
  extends cvc
{
  public cld HoR;
  public float HoS;
  public float HoT;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152679);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HoR == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPos");
        AppMethodBeat.o(152679);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HoR != null)
      {
        paramVarArgs.lC(2, this.HoR.computeSize());
        this.HoR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Scene);
      paramVarArgs.z(4, this.HoS);
      paramVarArgs.z(5, this.HoT);
      AppMethodBeat.o(152679);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label648;
      }
    }
    label648:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HoR != null) {
        i = paramInt + f.a.a.a.lB(2, this.HoR.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Scene);
      int j = f.a.a.b.b.a.alU(4);
      int k = f.a.a.b.b.a.alU(5);
      AppMethodBeat.o(152679);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HoR == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserPos");
          AppMethodBeat.o(152679);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152679);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxi localcxi = (cxi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152679);
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
            localcxi.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152679);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cld();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cld)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxi.HoR = ((cld)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152679);
          return 0;
        case 3: 
          localcxi.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152679);
          return 0;
        case 4: 
          localcxi.HoS = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(152679);
          return 0;
        }
        localcxi.HoT = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
        AppMethodBeat.o(152679);
        return 0;
      }
      AppMethodBeat.o(152679);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxi
 * JD-Core Version:    0.7.0.1
 */
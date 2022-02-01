package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tm
  extends cvc
{
  public float dAp;
  public String dHX;
  public float dyz;
  public String oxM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113970);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oxM != null) {
        paramVarArgs.d(2, this.oxM);
      }
      paramVarArgs.z(3, this.dAp);
      paramVarArgs.z(4, this.dyz);
      if (this.dHX != null) {
        paramVarArgs.d(5, this.dHX);
      }
      AppMethodBeat.o(113970);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oxM != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oxM);
      }
      i = i + f.a.a.b.b.a.alU(3) + f.a.a.b.b.a.alU(4);
      paramInt = i;
      if (this.dHX != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dHX);
      }
      AppMethodBeat.o(113970);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113970);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tm localtm = (tm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113970);
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
            localtm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113970);
          return 0;
        case 2: 
          localtm.oxM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113970);
          return 0;
        case 3: 
          localtm.dAp = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(113970);
          return 0;
        case 4: 
          localtm.dyz = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(113970);
          return 0;
        }
        localtm.dHX = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(113970);
        return 0;
      }
      AppMethodBeat.o(113970);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tm
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bii
  extends cvc
{
  public String code;
  public String dHX;
  public String oxM;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114034);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dHX != null) {
        paramVarArgs.d(2, this.dHX);
      }
      paramVarArgs.aS(3, this.scene);
      if (this.oxM != null) {
        paramVarArgs.d(4, this.oxM);
      }
      if (this.code != null) {
        paramVarArgs.d(5, this.code);
      }
      AppMethodBeat.o(114034);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dHX != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dHX);
      }
      i += f.a.a.b.b.a.bz(3, this.scene);
      paramInt = i;
      if (this.oxM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oxM);
      }
      i = paramInt;
      if (this.code != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.code);
      }
      AppMethodBeat.o(114034);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114034);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bii localbii = (bii)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114034);
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
            localbii.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114034);
          return 0;
        case 2: 
          localbii.dHX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114034);
          return 0;
        case 3: 
          localbii.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114034);
          return 0;
        case 4: 
          localbii.oxM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114034);
          return 0;
        }
        localbii.code = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(114034);
        return 0;
      }
      AppMethodBeat.o(114034);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bii
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qg
  extends cvc
{
  public String FLF;
  public int FLX;
  public int FLY;
  public long FLZ;
  public dk FLo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91376);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FLo != null)
      {
        paramVarArgs.lC(2, this.FLo.computeSize());
        this.FLo.writeFields(paramVarArgs);
      }
      if (this.FLF != null) {
        paramVarArgs.d(3, this.FLF);
      }
      paramVarArgs.aS(4, this.FLX);
      paramVarArgs.aS(5, this.FLY);
      paramVarArgs.aY(6, this.FLZ);
      AppMethodBeat.o(91376);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FLo != null) {
        paramInt = i + f.a.a.a.lB(2, this.FLo.computeSize());
      }
      i = paramInt;
      if (this.FLF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FLF);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.FLX);
      int j = f.a.a.b.b.a.bz(5, this.FLY);
      int k = f.a.a.b.b.a.p(6, this.FLZ);
      AppMethodBeat.o(91376);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91376);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qg localqg = (qg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91376);
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
            localqg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91376);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localqg.FLo = ((dk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91376);
          return 0;
        case 3: 
          localqg.FLF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91376);
          return 0;
        case 4: 
          localqg.FLX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91376);
          return 0;
        case 5: 
          localqg.FLY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91376);
          return 0;
        }
        localqg.FLZ = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(91376);
        return 0;
      }
      AppMethodBeat.o(91376);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qg
 * JD-Core Version:    0.7.0.1
 */
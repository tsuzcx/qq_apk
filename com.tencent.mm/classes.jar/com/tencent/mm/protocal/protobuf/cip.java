package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cip
  extends cvc
{
  public bb FPa;
  public int Hcw;
  public String wDG;
  public String wDo;
  public int wDv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91575);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hcw);
      if (this.wDo != null) {
        paramVarArgs.d(3, this.wDo);
      }
      paramVarArgs.aS(4, this.wDv);
      if (this.wDG != null) {
        paramVarArgs.d(5, this.wDG);
      }
      if (this.FPa != null)
      {
        paramVarArgs.lC(6, this.FPa.computeSize());
        this.FPa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91575);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hcw);
      paramInt = i;
      if (this.wDo != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.wDo);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.wDv);
      paramInt = i;
      if (this.wDG != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wDG);
      }
      i = paramInt;
      if (this.FPa != null) {
        i = paramInt + f.a.a.a.lB(6, this.FPa.computeSize());
      }
      AppMethodBeat.o(91575);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91575);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cip localcip = (cip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91575);
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
            localcip.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91575);
          return 0;
        case 2: 
          localcip.Hcw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91575);
          return 0;
        case 3: 
          localcip.wDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91575);
          return 0;
        case 4: 
          localcip.wDv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91575);
          return 0;
        case 5: 
          localcip.wDG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91575);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcip.FPa = ((bb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91575);
        return 0;
      }
      AppMethodBeat.o(91575);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cip
 * JD-Core Version:    0.7.0.1
 */
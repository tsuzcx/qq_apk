package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class oh
  extends cvc
{
  public long FCu;
  public String FGE;
  public int FJA;
  public int FJB;
  public b FJx;
  public int FJz;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124443);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FGE != null) {
        paramVarArgs.d(2, this.FGE);
      }
      paramVarArgs.aS(3, this.FJz);
      if (this.FJx != null) {
        paramVarArgs.c(4, this.FJx);
      }
      paramVarArgs.aS(5, this.FJA);
      paramVarArgs.aY(6, this.FCu);
      paramVarArgs.aS(7, this.FJB);
      paramVarArgs.aS(8, this.Scene);
      AppMethodBeat.o(124443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FGE != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FGE);
      }
      i += f.a.a.b.b.a.bz(3, this.FJz);
      paramInt = i;
      if (this.FJx != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.FJx);
      }
      i = f.a.a.b.b.a.bz(5, this.FJA);
      int j = f.a.a.b.b.a.p(6, this.FCu);
      int k = f.a.a.b.b.a.bz(7, this.FJB);
      int m = f.a.a.b.b.a.bz(8, this.Scene);
      AppMethodBeat.o(124443);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        oh localoh = (oh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124443);
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
            localoh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124443);
          return 0;
        case 2: 
          localoh.FGE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124443);
          return 0;
        case 3: 
          localoh.FJz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124443);
          return 0;
        case 4: 
          localoh.FJx = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(124443);
          return 0;
        case 5: 
          localoh.FJA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124443);
          return 0;
        case 6: 
          localoh.FCu = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(124443);
          return 0;
        case 7: 
          localoh.FJB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124443);
          return 0;
        }
        localoh.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(124443);
        return 0;
      }
      AppMethodBeat.o(124443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oh
 * JD-Core Version:    0.7.0.1
 */
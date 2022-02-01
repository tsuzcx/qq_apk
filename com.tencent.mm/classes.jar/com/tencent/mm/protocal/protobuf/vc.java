package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class vc
  extends cvc
{
  public b FTX;
  public String FUA;
  public int FUB;
  public int FUz;
  public String url;
  public int vls;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209398);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FUz);
      paramVarArgs.aS(3, this.vls);
      if (this.FUA != null) {
        paramVarArgs.d(4, this.FUA);
      }
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.aS(6, this.FUB);
      if (this.FTX != null) {
        paramVarArgs.c(7, this.FTX);
      }
      AppMethodBeat.o(209398);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FUz) + f.a.a.b.b.a.bz(3, this.vls);
      paramInt = i;
      if (this.FUA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FUA);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.url);
      }
      i += f.a.a.b.b.a.bz(6, this.FUB);
      paramInt = i;
      if (this.FTX != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.FTX);
      }
      AppMethodBeat.o(209398);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209398);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vc localvc = (vc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209398);
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
            localvc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209398);
          return 0;
        case 2: 
          localvc.FUz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209398);
          return 0;
        case 3: 
          localvc.vls = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209398);
          return 0;
        case 4: 
          localvc.FUA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209398);
          return 0;
        case 5: 
          localvc.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209398);
          return 0;
        case 6: 
          localvc.FUB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209398);
          return 0;
        }
        localvc.FTX = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(209398);
        return 0;
      }
      AppMethodBeat.o(209398);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vc
 * JD-Core Version:    0.7.0.1
 */
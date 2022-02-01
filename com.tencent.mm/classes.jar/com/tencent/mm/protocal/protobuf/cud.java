package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cud
  extends cvc
{
  public float HlZ;
  public b Hma;
  public boolean Hmb;
  public boolean Hmc;
  public float dAp;
  public String dHX;
  public float dyz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114064);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.z(2, this.dAp);
      paramVarArgs.z(3, this.dyz);
      paramVarArgs.z(4, this.HlZ);
      if (this.Hma != null) {
        paramVarArgs.c(5, this.Hma);
      }
      if (this.dHX != null) {
        paramVarArgs.d(6, this.dHX);
      }
      paramVarArgs.bt(7, this.Hmb);
      paramVarArgs.bt(8, this.Hmc);
      AppMethodBeat.o(114064);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label643;
      }
    }
    label643:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alU(2) + f.a.a.b.b.a.alU(3) + f.a.a.b.b.a.alU(4);
      paramInt = i;
      if (this.Hma != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.Hma);
      }
      i = paramInt;
      if (this.dHX != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dHX);
      }
      paramInt = f.a.a.b.b.a.alV(7);
      int j = f.a.a.b.b.a.alV(8);
      AppMethodBeat.o(114064);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114064);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cud localcud = (cud)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114064);
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
            localcud.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114064);
          return 0;
        case 2: 
          localcud.dAp = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(114064);
          return 0;
        case 3: 
          localcud.dyz = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(114064);
          return 0;
        case 4: 
          localcud.HlZ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(114064);
          return 0;
        case 5: 
          localcud.Hma = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(114064);
          return 0;
        case 6: 
          localcud.dHX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114064);
          return 0;
        case 7: 
          localcud.Hmb = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(114064);
          return 0;
        }
        localcud.Hmc = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(114064);
        return 0;
      }
      AppMethodBeat.o(114064);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cud
 * JD-Core Version:    0.7.0.1
 */
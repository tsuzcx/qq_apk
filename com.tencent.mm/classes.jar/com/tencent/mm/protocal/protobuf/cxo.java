package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cxo
  extends com.tencent.mm.bx.a
{
  public b HoX;
  public b HoY;
  public b HoZ;
  public b Hpa;
  public cxp Hpb;
  public int kzJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190980);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.kzJ);
      if (this.HoX != null) {
        paramVarArgs.c(2, this.HoX);
      }
      if (this.HoY != null) {
        paramVarArgs.c(3, this.HoY);
      }
      if (this.HoZ != null) {
        paramVarArgs.c(4, this.HoZ);
      }
      if (this.Hpa != null) {
        paramVarArgs.c(5, this.Hpa);
      }
      if (this.Hpb != null)
      {
        paramVarArgs.lC(6, this.Hpb.computeSize());
        this.Hpb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(190980);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.kzJ) + 0;
      paramInt = i;
      if (this.HoX != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.HoX);
      }
      i = paramInt;
      if (this.HoY != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.HoY);
      }
      paramInt = i;
      if (this.HoZ != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.HoZ);
      }
      i = paramInt;
      if (this.Hpa != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.Hpa);
      }
      paramInt = i;
      if (this.Hpb != null) {
        paramInt = i + f.a.a.a.lB(6, this.Hpb.computeSize());
      }
      AppMethodBeat.o(190980);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(190980);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cxo localcxo = (cxo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(190980);
        return -1;
      case 1: 
        localcxo.kzJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(190980);
        return 0;
      case 2: 
        localcxo.HoX = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(190980);
        return 0;
      case 3: 
        localcxo.HoY = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(190980);
        return 0;
      case 4: 
        localcxo.HoZ = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(190980);
        return 0;
      case 5: 
        localcxo.Hpa = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(190980);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cxp();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cxp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcxo.Hpb = ((cxp)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(190980);
      return 0;
    }
    AppMethodBeat.o(190980);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxo
 * JD-Core Version:    0.7.0.1
 */
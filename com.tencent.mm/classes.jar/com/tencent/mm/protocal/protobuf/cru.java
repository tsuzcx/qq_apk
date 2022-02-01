package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cru
  extends com.tencent.mm.bx.a
{
  public agb Hkl;
  public String Hkm;
  public String Hkn;
  public int Hko;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104830);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hkl != null)
      {
        paramVarArgs.lC(1, this.Hkl.computeSize());
        this.Hkl.writeFields(paramVarArgs);
      }
      if (this.Hkm != null) {
        paramVarArgs.d(2, this.Hkm);
      }
      paramVarArgs.aS(3, this.type);
      if (this.Hkn != null) {
        paramVarArgs.d(4, this.Hkn);
      }
      paramVarArgs.aS(5, this.Hko);
      AppMethodBeat.o(104830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hkl == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.lB(1, this.Hkl.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hkm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hkm);
      }
      i += f.a.a.b.b.a.bz(3, this.type);
      paramInt = i;
      if (this.Hkn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hkn);
      }
      i = f.a.a.b.b.a.bz(5, this.Hko);
      AppMethodBeat.o(104830);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cru localcru = (cru)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104830);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((agb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcru.Hkl = ((agb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104830);
          return 0;
        case 2: 
          localcru.Hkm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104830);
          return 0;
        case 3: 
          localcru.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104830);
          return 0;
        case 4: 
          localcru.Hkn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104830);
          return 0;
        }
        localcru.Hko = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(104830);
        return 0;
      }
      AppMethodBeat.o(104830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cru
 * JD-Core Version:    0.7.0.1
 */
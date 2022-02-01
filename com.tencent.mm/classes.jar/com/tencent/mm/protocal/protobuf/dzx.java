package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzx
  extends com.tencent.mm.bx.a
{
  public dzt HMY;
  public dzj HMZ;
  public String HNa;
  public String HNb;
  public String HNc;
  public int HNd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMY != null)
      {
        paramVarArgs.lC(1, this.HMY.computeSize());
        this.HMY.writeFields(paramVarArgs);
      }
      if (this.HMZ != null)
      {
        paramVarArgs.lC(2, this.HMZ.computeSize());
        this.HMZ.writeFields(paramVarArgs);
      }
      if (this.HNa != null) {
        paramVarArgs.d(3, this.HNa);
      }
      if (this.HNb != null) {
        paramVarArgs.d(4, this.HNb);
      }
      if (this.HNc != null) {
        paramVarArgs.d(5, this.HNc);
      }
      paramVarArgs.aS(6, this.HNd);
      AppMethodBeat.o(147809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMY == null) {
        break label690;
      }
    }
    label690:
    for (int i = f.a.a.a.lB(1, this.HMY.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HMZ != null) {
        paramInt = i + f.a.a.a.lB(2, this.HMZ.computeSize());
      }
      i = paramInt;
      if (this.HNa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HNa);
      }
      paramInt = i;
      if (this.HNb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HNb);
      }
      i = paramInt;
      if (this.HNc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HNc);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.HNd);
      AppMethodBeat.o(147809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(147809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzx localdzx = (dzx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147809);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.HMY = ((dzt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzx.HMZ = ((dzj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 3: 
          localdzx.HNa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 4: 
          localdzx.HNb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 5: 
          localdzx.HNc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(147809);
          return 0;
        }
        localdzx.HNd = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(147809);
        return 0;
      }
      AppMethodBeat.o(147809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzx
 * JD-Core Version:    0.7.0.1
 */
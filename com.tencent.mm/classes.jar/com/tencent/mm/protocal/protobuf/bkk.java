package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkk
  extends com.tencent.mm.bv.a
{
  public String xyX;
  public String xyY;
  public String xyZ;
  public int xza;
  public String xzb;
  public ou xzc;
  public String xzd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89116);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xyX != null) {
        paramVarArgs.e(1, this.xyX);
      }
      if (this.xyY != null) {
        paramVarArgs.e(2, this.xyY);
      }
      if (this.xyZ != null) {
        paramVarArgs.e(3, this.xyZ);
      }
      paramVarArgs.aO(4, this.xza);
      if (this.xzb != null) {
        paramVarArgs.e(5, this.xzb);
      }
      if (this.xzc != null)
      {
        paramVarArgs.iQ(6, this.xzc.computeSize());
        this.xzc.writeFields(paramVarArgs);
      }
      if (this.xzd != null) {
        paramVarArgs.e(7, this.xzd);
      }
      AppMethodBeat.o(89116);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xyX == null) {
        break label658;
      }
    }
    label658:
    for (int i = e.a.a.b.b.a.f(1, this.xyX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xyY != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xyY);
      }
      i = paramInt;
      if (this.xyZ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xyZ);
      }
      i += e.a.a.b.b.a.bl(4, this.xza);
      paramInt = i;
      if (this.xzb != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xzb);
      }
      i = paramInt;
      if (this.xzc != null) {
        i = paramInt + e.a.a.a.iP(6, this.xzc.computeSize());
      }
      paramInt = i;
      if (this.xzd != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xzd);
      }
      AppMethodBeat.o(89116);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89116);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bkk localbkk = (bkk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89116);
          return -1;
        case 1: 
          localbkk.xyX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89116);
          return 0;
        case 2: 
          localbkk.xyY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89116);
          return 0;
        case 3: 
          localbkk.xyZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89116);
          return 0;
        case 4: 
          localbkk.xza = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89116);
          return 0;
        case 5: 
          localbkk.xzb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89116);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ou();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ou)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbkk.xzc = ((ou)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89116);
          return 0;
        }
        localbkk.xzd = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(89116);
        return 0;
      }
      AppMethodBeat.o(89116);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkk
 * JD-Core Version:    0.7.0.1
 */
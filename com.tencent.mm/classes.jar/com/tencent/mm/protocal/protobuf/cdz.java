package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdz
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b FCe;
  public int GXW;
  public String GXX;
  public SKBuiltinBuffer_t GXY;
  public int GXZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32359);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GXY == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.GXW);
      if (this.FCe != null) {
        paramVarArgs.c(2, this.FCe);
      }
      if (this.GXX != null) {
        paramVarArgs.d(3, this.GXX);
      }
      if (this.GXY != null)
      {
        paramVarArgs.lC(4, this.GXY.computeSize());
        this.GXY.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.GXZ);
      AppMethodBeat.o(32359);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GXW) + 0;
      paramInt = i;
      if (this.FCe != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FCe);
      }
      i = paramInt;
      if (this.GXX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GXX);
      }
      paramInt = i;
      if (this.GXY != null) {
        paramInt = i + f.a.a.a.lB(4, this.GXY.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.GXZ);
      AppMethodBeat.o(32359);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.GXY == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32359);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cdz localcdz = (cdz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32359);
        return -1;
      case 1: 
        localcdz.GXW = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32359);
        return 0;
      case 2: 
        localcdz.FCe = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(32359);
        return 0;
      case 3: 
        localcdz.GXX = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32359);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdz.GXY = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32359);
        return 0;
      }
      localcdz.GXZ = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(32359);
      return 0;
    }
    AppMethodBeat.o(32359);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdz
 * JD-Core Version:    0.7.0.1
 */
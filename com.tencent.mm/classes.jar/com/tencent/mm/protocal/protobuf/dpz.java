package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpz
  extends com.tencent.mm.bx.a
{
  public String GWr;
  public SKBuiltinBuffer_t Gub;
  public int HEc;
  public String HEf;
  public int HEg;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HEc);
      if (this.HEf != null) {
        paramVarArgs.d(2, this.HEf);
      }
      paramVarArgs.aS(3, this.Ret);
      if (this.GWr != null) {
        paramVarArgs.d(4, this.GWr);
      }
      if (this.Gub != null)
      {
        paramVarArgs.lC(5, this.Gub.computeSize());
        this.Gub.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.HEg);
      AppMethodBeat.o(152716);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HEc) + 0;
      paramInt = i;
      if (this.HEf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HEf);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.Ret);
      paramInt = i;
      if (this.GWr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GWr);
      }
      i = paramInt;
      if (this.Gub != null) {
        i = paramInt + f.a.a.a.lB(5, this.Gub.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(6, this.HEg);
      AppMethodBeat.o(152716);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(152716);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dpz localdpz = (dpz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152716);
        return -1;
      case 1: 
        localdpz.HEc = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152716);
        return 0;
      case 2: 
        localdpz.HEf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 3: 
        localdpz.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152716);
        return 0;
      case 4: 
        localdpz.GWr = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152716);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdpz.Gub = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152716);
        return 0;
      }
      localdpz.HEg = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(152716);
      return 0;
    }
    AppMethodBeat.o(152716);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpz
 * JD-Core Version:    0.7.0.1
 */
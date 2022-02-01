package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class efs
  extends com.tencent.mm.bx.a
{
  public String GDw;
  public SKBuiltinBuffer_t GDz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133209);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GDz == null)
      {
        paramVarArgs = new b("Not all required fields were included: VerifyBuff");
        AppMethodBeat.o(133209);
        throw paramVarArgs;
      }
      if (this.GDw != null) {
        paramVarArgs.d(1, this.GDw);
      }
      if (this.GDz != null)
      {
        paramVarArgs.lC(2, this.GDz.computeSize());
        this.GDz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GDw == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.GDw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GDz != null) {
        i = paramInt + f.a.a.a.lB(2, this.GDz.computeSize());
      }
      AppMethodBeat.o(133209);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GDz == null)
        {
          paramVarArgs = new b("Not all required fields were included: VerifyBuff");
          AppMethodBeat.o(133209);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133209);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        efs localefs = (efs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133209);
          return -1;
        case 1: 
          localefs.GDw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133209);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localefs.GDz = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133209);
        return 0;
      }
      AppMethodBeat.o(133209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efs
 * JD-Core Version:    0.7.0.1
 */
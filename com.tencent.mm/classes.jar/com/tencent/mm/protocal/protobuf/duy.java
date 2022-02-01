package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class duy
  extends com.tencent.mm.bw.a
{
  public String DYT;
  public String DYU;
  public SKBuiltinBuffer_t DYX;
  public String GcE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133206);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DYX == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133206);
        throw paramVarArgs;
      }
      if (this.DYT != null) {
        paramVarArgs.d(1, this.DYT);
      }
      if (this.DYU != null) {
        paramVarArgs.d(2, this.DYU);
      }
      if (this.GcE != null) {
        paramVarArgs.d(3, this.GcE);
      }
      if (this.DYX != null)
      {
        paramVarArgs.ln(4, this.DYX.computeSize());
        this.DYX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DYT == null) {
        break label538;
      }
    }
    label538:
    for (int i = f.a.a.b.b.a.e(1, this.DYT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DYU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DYU);
      }
      i = paramInt;
      if (this.GcE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GcE);
      }
      paramInt = i;
      if (this.DYX != null) {
        paramInt = i + f.a.a.a.lm(4, this.DYX.computeSize());
      }
      AppMethodBeat.o(133206);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DYX == null)
        {
          paramVarArgs = new b("Not all required fields were included: KSid");
          AppMethodBeat.o(133206);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133206);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        duy localduy = (duy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133206);
          return -1;
        case 1: 
          localduy.DYT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 2: 
          localduy.DYU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 3: 
          localduy.GcE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(133206);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localduy.DYX = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133206);
        return 0;
      }
      AppMethodBeat.o(133206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duy
 * JD-Core Version:    0.7.0.1
 */
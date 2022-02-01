package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class eas
  extends com.tencent.mm.bx.a
{
  public String FEp;
  public String FEq;
  public SKBuiltinBuffer_t FEt;
  public String HNB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133206);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FEt == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133206);
        throw paramVarArgs;
      }
      if (this.FEp != null) {
        paramVarArgs.d(1, this.FEp);
      }
      if (this.FEq != null) {
        paramVarArgs.d(2, this.FEq);
      }
      if (this.HNB != null) {
        paramVarArgs.d(3, this.HNB);
      }
      if (this.FEt != null)
      {
        paramVarArgs.lC(4, this.FEt.computeSize());
        this.FEt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FEp == null) {
        break label538;
      }
    }
    label538:
    for (int i = f.a.a.b.b.a.e(1, this.FEp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FEq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FEq);
      }
      i = paramInt;
      if (this.HNB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HNB);
      }
      paramInt = i;
      if (this.FEt != null) {
        paramInt = i + f.a.a.a.lB(4, this.FEt.computeSize());
      }
      AppMethodBeat.o(133206);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FEt == null)
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
        eas localeas = (eas)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133206);
          return -1;
        case 1: 
          localeas.FEp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 2: 
          localeas.FEq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 3: 
          localeas.HNB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(133206);
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
          localeas.FEt = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eas
 * JD-Core Version:    0.7.0.1
 */
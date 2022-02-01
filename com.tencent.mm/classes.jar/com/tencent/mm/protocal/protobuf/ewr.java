package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ewr
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t KQA;
  public String KQw;
  public String KQx;
  public String Num;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133206);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KQA == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133206);
        throw paramVarArgs;
      }
      if (this.KQw != null) {
        paramVarArgs.e(1, this.KQw);
      }
      if (this.KQx != null) {
        paramVarArgs.e(2, this.KQx);
      }
      if (this.Num != null) {
        paramVarArgs.e(3, this.Num);
      }
      if (this.KQA != null)
      {
        paramVarArgs.ni(4, this.KQA.computeSize());
        this.KQA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KQw == null) {
        break label538;
      }
    }
    label538:
    for (int i = g.a.a.b.b.a.f(1, this.KQw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KQx);
      }
      i = paramInt;
      if (this.Num != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Num);
      }
      paramInt = i;
      if (this.KQA != null) {
        paramInt = i + g.a.a.a.nh(4, this.KQA.computeSize());
      }
      AppMethodBeat.o(133206);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KQA == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ewr localewr = (ewr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133206);
          return -1;
        case 1: 
          localewr.KQw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 2: 
          localewr.KQx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 3: 
          localewr.Num = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133206);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localewr.KQA = ((SKBuiltinBuffer_t)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewr
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ews
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t KHp;
  public SKBuiltinBuffer_t KQA;
  public String KQw;
  public String Num;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133207);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KQA == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133207);
        throw paramVarArgs;
      }
      if (this.KHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133207);
        throw paramVarArgs;
      }
      if (this.Num != null) {
        paramVarArgs.e(1, this.Num);
      }
      if (this.KQA != null)
      {
        paramVarArgs.ni(2, this.KQA.computeSize());
        this.KQA.writeFields(paramVarArgs);
      }
      if (this.KQw != null) {
        paramVarArgs.e(3, this.KQw);
      }
      if (this.KHp != null)
      {
        paramVarArgs.ni(4, this.KHp.computeSize());
        this.KHp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Num == null) {
        break label682;
      }
    }
    label682:
    for (int i = g.a.a.b.b.a.f(1, this.Num) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KQA != null) {
        paramInt = i + g.a.a.a.nh(2, this.KQA.computeSize());
      }
      i = paramInt;
      if (this.KQw != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KQw);
      }
      paramInt = i;
      if (this.KHp != null) {
        paramInt = i + g.a.a.a.nh(4, this.KHp.computeSize());
      }
      AppMethodBeat.o(133207);
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
          AppMethodBeat.o(133207);
          throw paramVarArgs;
        }
        if (this.KHp == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(133207);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ews localews = (ews)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133207);
          return -1;
        case 1: 
          localews.Num = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133207);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localews.KQA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133207);
          return 0;
        case 3: 
          localews.KQw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133207);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localews.KHp = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133207);
        return 0;
      }
      AppMethodBeat.o(133207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ews
 * JD-Core Version:    0.7.0.1
 */
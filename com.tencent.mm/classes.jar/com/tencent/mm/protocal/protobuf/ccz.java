package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ccz
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t KHp;
  public dqi MiP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152612);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152612);
        throw paramVarArgs;
      }
      if (this.MiP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(152612);
        throw paramVarArgs;
      }
      if (this.KHp != null)
      {
        paramVarArgs.ni(1, this.KHp.computeSize());
        this.KHp.writeFields(paramVarArgs);
      }
      if (this.MiP != null)
      {
        paramVarArgs.ni(2, this.MiP.computeSize());
        this.MiP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KHp == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.a.nh(1, this.KHp.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MiP != null) {
        i = paramInt + g.a.a.a.nh(2, this.MiP.computeSize());
      }
      AppMethodBeat.o(152612);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KHp == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(152612);
          throw paramVarArgs;
        }
        if (this.MiP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(152612);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152612);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ccz localccz = (ccz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152612);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localccz.KHp = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152612);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localccz.MiP = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152612);
        return 0;
      }
      AppMethodBeat.o(152612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccz
 * JD-Core Version:    0.7.0.1
 */
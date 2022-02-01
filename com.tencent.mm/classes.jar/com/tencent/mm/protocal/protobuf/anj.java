package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class anj
  extends com.tencent.mm.bw.a
  implements dyp
{
  public int KZh;
  public SKBuiltinBuffer_t Lev;
  public abo Ley;
  public int Ret;
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127483);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ley == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      if (this.Lev == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Ret);
      if (this.Ley != null)
      {
        paramVarArgs.ni(2, this.Ley.computeSize());
        this.Ley.writeFields(paramVarArgs);
      }
      if (this.Lev != null)
      {
        paramVarArgs.ni(3, this.Lev.computeSize());
        this.Lev.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(4, this.KZh);
      AppMethodBeat.o(127483);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Ret) + 0;
      paramInt = i;
      if (this.Ley != null) {
        paramInt = i + g.a.a.a.nh(2, this.Ley.computeSize());
      }
      i = paramInt;
      if (this.Lev != null) {
        i = paramInt + g.a.a.a.nh(3, this.Lev.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(4, this.KZh);
      AppMethodBeat.o(127483);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Ley == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      if (this.Lev == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127483);
        throw paramVarArgs;
      }
      AppMethodBeat.o(127483);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      anj localanj = (anj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127483);
        return -1;
      case 1: 
        localanj.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(127483);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localanj.Ley = ((abo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127483);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localanj.Lev = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127483);
        return 0;
      }
      localanj.KZh = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(127483);
      return 0;
    }
    AppMethodBeat.o(127483);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anj
 * JD-Core Version:    0.7.0.1
 */
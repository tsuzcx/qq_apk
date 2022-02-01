package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cts
  extends com.tencent.mm.bw.a
{
  public int KZh;
  public SKBuiltinBuffer_t Lev;
  public abo Ley;
  public int Mzb;
  public int Mzc;
  public int Ret;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133187);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ley == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      if (this.Lev == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Ret);
      if (this.Ley != null)
      {
        paramVarArgs.ni(2, this.Ley.computeSize());
        this.Ley.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.KZh);
      if (this.Lev != null)
      {
        paramVarArgs.ni(4, this.Lev.computeSize());
        this.Lev.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.oTW);
      paramVarArgs.aM(6, this.Mzb);
      paramVarArgs.aM(7, this.Mzc);
      AppMethodBeat.o(133187);
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
      i = paramInt + g.a.a.b.b.a.bu(3, this.KZh);
      paramInt = i;
      if (this.Lev != null) {
        paramInt = i + g.a.a.a.nh(4, this.Lev.computeSize());
      }
      i = g.a.a.b.b.a.bu(5, this.oTW);
      int j = g.a.a.b.b.a.bu(6, this.Mzb);
      int k = g.a.a.b.b.a.bu(7, this.Mzc);
      AppMethodBeat.o(133187);
      return paramInt + i + j + k;
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
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      if (this.Lev == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133187);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cts localcts = (cts)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133187);
        return -1;
      case 1: 
        localcts.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133187);
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
          localcts.Ley = ((abo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133187);
        return 0;
      case 3: 
        localcts.KZh = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133187);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcts.Lev = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133187);
        return 0;
      case 5: 
        localcts.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133187);
        return 0;
      case 6: 
        localcts.Mzb = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(133187);
        return 0;
      }
      localcts.Mzc = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(133187);
      return 0;
    }
    AppMethodBeat.o(133187);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cts
 * JD-Core Version:    0.7.0.1
 */
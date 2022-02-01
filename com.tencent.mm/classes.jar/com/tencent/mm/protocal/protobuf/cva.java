package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cva
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b KOi;
  public int KOj;
  public int MAt;
  public String MAu;
  public SKBuiltinBuffer_t MAv;
  public int MAw;
  public int MAx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32359);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MAv == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.MAt);
      if (this.KOi != null) {
        paramVarArgs.c(2, this.KOi);
      }
      if (this.MAu != null) {
        paramVarArgs.e(3, this.MAu);
      }
      if (this.MAv != null)
      {
        paramVarArgs.ni(4, this.MAv.computeSize());
        this.MAv.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.MAw);
      paramVarArgs.aM(6, this.MAx);
      paramVarArgs.aM(7, this.KOj);
      AppMethodBeat.o(32359);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.MAt) + 0;
      paramInt = i;
      if (this.KOi != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.KOi);
      }
      i = paramInt;
      if (this.MAu != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MAu);
      }
      paramInt = i;
      if (this.MAv != null) {
        paramInt = i + g.a.a.a.nh(4, this.MAv.computeSize());
      }
      i = g.a.a.b.b.a.bu(5, this.MAw);
      int j = g.a.a.b.b.a.bu(6, this.MAx);
      int k = g.a.a.b.b.a.bu(7, this.KOj);
      AppMethodBeat.o(32359);
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
      if (this.MAv == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ClientKey");
        AppMethodBeat.o(32359);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32359);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cva localcva = (cva)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32359);
        return -1;
      case 1: 
        localcva.MAt = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32359);
        return 0;
      case 2: 
        localcva.KOi = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(32359);
        return 0;
      case 3: 
        localcva.MAu = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32359);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcva.MAv = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32359);
        return 0;
      case 5: 
        localcva.MAw = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32359);
        return 0;
      case 6: 
        localcva.MAx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32359);
        return 0;
      }
      localcva.KOj = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(32359);
      return 0;
    }
    AppMethodBeat.o(32359);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cva
 * JD-Core Version:    0.7.0.1
 */
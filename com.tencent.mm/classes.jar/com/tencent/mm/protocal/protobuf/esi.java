package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class esi
  extends com.tencent.mm.bw.a
{
  public int BsG;
  public int Npx;
  public int Npy;
  public SKBuiltinBuffer_t Npz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32499);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Npz == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32499);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.BsG);
      paramVarArgs.aM(2, this.Npx);
      paramVarArgs.aM(3, this.Npy);
      if (this.Npz != null)
      {
        paramVarArgs.ni(4, this.Npz.computeSize());
        this.Npz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.BsG) + 0 + g.a.a.b.b.a.bu(2, this.Npx) + g.a.a.b.b.a.bu(3, this.Npy);
      paramInt = i;
      if (this.Npz != null) {
        paramInt = i + g.a.a.a.nh(4, this.Npz.computeSize());
      }
      AppMethodBeat.o(32499);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.Npz == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32499);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      esi localesi = (esi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32499);
        return -1;
      case 1: 
        localesi.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32499);
        return 0;
      case 2: 
        localesi.Npx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32499);
        return 0;
      case 3: 
        localesi.Npy = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32499);
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
        localesi.Npz = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32499);
      return 0;
    }
    AppMethodBeat.o(32499);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esi
 * JD-Core Version:    0.7.0.1
 */
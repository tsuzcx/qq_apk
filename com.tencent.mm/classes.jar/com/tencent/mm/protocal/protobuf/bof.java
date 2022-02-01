package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bof
  extends com.tencent.mm.bw.a
{
  public String Bri;
  public cat KOZ;
  public int LWr;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82415);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ret);
      if (this.KOZ != null)
      {
        paramVarArgs.ni(2, this.KOZ.computeSize());
        this.KOZ.writeFields(paramVarArgs);
      }
      if (this.Bri != null) {
        paramVarArgs.e(3, this.Bri);
      }
      paramVarArgs.aM(4, this.LWr);
      AppMethodBeat.o(82415);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Ret) + 0;
      paramInt = i;
      if (this.KOZ != null) {
        paramInt = i + g.a.a.a.nh(2, this.KOZ.computeSize());
      }
      i = paramInt;
      if (this.Bri != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Bri);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.LWr);
      AppMethodBeat.o(82415);
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
      AppMethodBeat.o(82415);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bof localbof = (bof)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82415);
        return -1;
      case 1: 
        localbof.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(82415);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cat();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cat)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbof.KOZ = ((cat)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(82415);
        return 0;
      case 3: 
        localbof.Bri = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(82415);
        return 0;
      }
      localbof.LWr = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(82415);
      return 0;
    }
    AppMethodBeat.o(82415);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bof
 * JD-Core Version:    0.7.0.1
 */
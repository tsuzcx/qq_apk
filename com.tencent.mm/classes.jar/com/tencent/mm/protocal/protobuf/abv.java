package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abv
  extends com.tencent.mm.bw.a
{
  public String KJM;
  public String Lmx;
  public abr Lmy;
  public String dPI;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117861);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.timestamp);
      if (this.Lmx != null) {
        paramVarArgs.e(2, this.Lmx);
      }
      if (this.KJM != null) {
        paramVarArgs.e(3, this.KJM);
      }
      if (this.dPI != null) {
        paramVarArgs.e(4, this.dPI);
      }
      if (this.Lmy != null)
      {
        paramVarArgs.ni(5, this.Lmy.computeSize());
        this.Lmy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.timestamp) + 0;
      paramInt = i;
      if (this.Lmx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Lmx);
      }
      i = paramInt;
      if (this.KJM != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KJM);
      }
      paramInt = i;
      if (this.dPI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dPI);
      }
      i = paramInt;
      if (this.Lmy != null) {
        i = paramInt + g.a.a.a.nh(5, this.Lmy.computeSize());
      }
      AppMethodBeat.o(117861);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      abv localabv = (abv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117861);
        return -1;
      case 1: 
        localabv.timestamp = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(117861);
        return 0;
      case 2: 
        localabv.Lmx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117861);
        return 0;
      case 3: 
        localabv.KJM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117861);
        return 0;
      case 4: 
        localabv.dPI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117861);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new abr();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((abr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localabv.Lmy = ((abr)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117861);
      return 0;
    }
    AppMethodBeat.o(117861);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abv
 * JD-Core Version:    0.7.0.1
 */
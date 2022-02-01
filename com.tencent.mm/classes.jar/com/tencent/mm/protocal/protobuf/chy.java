package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chy
  extends com.tencent.mm.bx.a
{
  public dbp Dah;
  public String DuV;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91664);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.DuV != null) {
        paramVarArgs.d(2, this.DuV);
      }
      if (this.Dah != null)
      {
        paramVarArgs.kX(3, this.Dah.computeSize());
        this.Dah.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.DuV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DuV);
      }
      i = paramInt;
      if (this.Dah != null) {
        i = paramInt + f.a.a.a.kW(3, this.Dah.computeSize());
      }
      AppMethodBeat.o(91664);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      chy localchy = (chy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91664);
        return -1;
      case 1: 
        localchy.type = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91664);
        return 0;
      case 2: 
        localchy.DuV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91664);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dbp();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localchy.Dah = ((dbp)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    AppMethodBeat.o(91664);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chy
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ecu
  extends com.tencent.mm.bw.a
{
  public int IhV;
  public ecy IhW;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197210);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.IhV);
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.IhW != null)
      {
        paramVarArgs.lJ(3, this.IhW.computeSize());
        this.IhW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(197210);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.IhV) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.IhW != null) {
        i = paramInt + f.a.a.a.lI(3, this.IhW.computeSize());
      }
      AppMethodBeat.o(197210);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(197210);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ecu localecu = (ecu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(197210);
        return -1;
      case 1: 
        localecu.IhV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(197210);
        return 0;
      case 2: 
        localecu.Name = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(197210);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ecy();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ecy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localecu.IhW = ((ecy)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(197210);
      return 0;
    }
    AppMethodBeat.o(197210);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecu
 * JD-Core Version:    0.7.0.1
 */
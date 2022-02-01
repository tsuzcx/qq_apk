package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class csz
  extends com.tencent.mm.bw.a
{
  public String GSV;
  public dnl Gtc;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91664);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.GSV != null) {
        paramVarArgs.d(2, this.GSV);
      }
      if (this.Gtc != null)
      {
        paramVarArgs.lJ(3, this.Gtc.computeSize());
        this.Gtc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.GSV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GSV);
      }
      i = paramInt;
      if (this.Gtc != null) {
        i = paramInt + f.a.a.a.lI(3, this.Gtc.computeSize());
      }
      AppMethodBeat.o(91664);
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
      AppMethodBeat.o(91664);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      csz localcsz = (csz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91664);
        return -1;
      case 1: 
        localcsz.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91664);
        return 0;
      case 2: 
        localcsz.GSV = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91664);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dnl();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcsz.Gtc = ((dnl)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    AppMethodBeat.o(91664);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csz
 * JD-Core Version:    0.7.0.1
 */
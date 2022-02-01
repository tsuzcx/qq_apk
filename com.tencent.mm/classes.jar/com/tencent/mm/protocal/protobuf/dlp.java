package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlp
  extends com.tencent.mm.bw.a
{
  public String LXh;
  public ehf Lov;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91664);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.LXh != null) {
        paramVarArgs.e(2, this.LXh);
      }
      if (this.Lov != null)
      {
        paramVarArgs.ni(3, this.Lov.computeSize());
        this.Lov.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.LXh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LXh);
      }
      i = paramInt;
      if (this.Lov != null) {
        i = paramInt + g.a.a.a.nh(3, this.Lov.computeSize());
      }
      AppMethodBeat.o(91664);
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
      AppMethodBeat.o(91664);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dlp localdlp = (dlp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91664);
        return -1;
      case 1: 
        localdlp.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91664);
        return 0;
      case 2: 
        localdlp.LXh = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91664);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ehf();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ehf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localdlp.Lov = ((ehf)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    AppMethodBeat.o(91664);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlp
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gx
  extends com.tencent.mm.bx.a
{
  public gy YIA;
  public int YIr;
  public int YIs;
  public int YIz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32120);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YIr);
      paramVarArgs.bS(2, this.YIs);
      paramVarArgs.bS(3, this.YIz);
      if (this.YIA != null)
      {
        paramVarArgs.qD(4, this.YIA.computeSize());
        this.YIA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YIr) + 0 + i.a.a.b.b.a.cJ(2, this.YIs) + i.a.a.b.b.a.cJ(3, this.YIz);
      paramInt = i;
      if (this.YIA != null) {
        paramInt = i + i.a.a.a.qC(4, this.YIA.computeSize());
      }
      AppMethodBeat.o(32120);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gx localgx = (gx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32120);
        return -1;
      case 1: 
        localgx.YIr = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32120);
        return 0;
      case 2: 
        localgx.YIs = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32120);
        return 0;
      case 3: 
        localgx.YIz = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32120);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        gy localgy = new gy();
        if ((localObject != null) && (localObject.length > 0)) {
          localgy.parseFrom((byte[])localObject);
        }
        localgx.YIA = localgy;
        paramInt += 1;
      }
      AppMethodBeat.o(32120);
      return 0;
    }
    AppMethodBeat.o(32120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gx
 * JD-Core Version:    0.7.0.1
 */
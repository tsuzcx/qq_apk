package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfx
  extends com.tencent.mm.bx.a
{
  public String EVK;
  public xb ZPH;
  public int ZPI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258298);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZPH != null)
      {
        paramVarArgs.qD(1, this.ZPH.computeSize());
        this.ZPH.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZPI);
      if (this.EVK != null) {
        paramVarArgs.g(3, this.EVK);
      }
      AppMethodBeat.o(258298);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZPH == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.a.qC(1, this.ZPH.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZPI);
      paramInt = i;
      if (this.EVK != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.EVK);
      }
      AppMethodBeat.o(258298);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258298);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bfx localbfx = (bfx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258298);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            xb localxb = new xb();
            if ((localObject != null) && (localObject.length > 0)) {
              localxb.parseFrom((byte[])localObject);
            }
            localbfx.ZPH = localxb;
            paramInt += 1;
          }
          AppMethodBeat.o(258298);
          return 0;
        case 2: 
          localbfx.ZPI = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258298);
          return 0;
        }
        localbfx.EVK = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258298);
        return 0;
      }
      AppMethodBeat.o(258298);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfx
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byx
  extends com.tencent.mm.bx.a
{
  public dne ZXx;
  public String aahV;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257768);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.id);
      if (this.ZXx != null)
      {
        paramVarArgs.qD(2, this.ZXx.computeSize());
        this.ZXx.writeFields(paramVarArgs);
      }
      if (this.aahV != null) {
        paramVarArgs.g(3, this.aahV);
      }
      AppMethodBeat.o(257768);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.id) + 0;
      paramInt = i;
      if (this.ZXx != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZXx.computeSize());
      }
      i = paramInt;
      if (this.aahV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aahV);
      }
      AppMethodBeat.o(257768);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257768);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      byx localbyx = (byx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257768);
        return -1;
      case 1: 
        localbyx.id = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(257768);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dne localdne = new dne();
          if ((localObject != null) && (localObject.length > 0)) {
            localdne.parseFrom((byte[])localObject);
          }
          localbyx.ZXx = localdne;
          paramInt += 1;
        }
        AppMethodBeat.o(257768);
        return 0;
      }
      localbyx.aahV = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(257768);
      return 0;
    }
    AppMethodBeat.o(257768);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byx
 * JD-Core Version:    0.7.0.1
 */
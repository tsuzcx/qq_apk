package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bes
  extends com.tencent.mm.bx.a
{
  public bsr ZPb;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258607);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.g(1, this.content);
      }
      if (this.ZPb != null)
      {
        paramVarArgs.qD(2, this.ZPb.computeSize());
        this.ZPb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZPb != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZPb.computeSize());
      }
      AppMethodBeat.o(258607);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bes localbes = (bes)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258607);
          return -1;
        case 1: 
          localbes.content = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258607);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bsr localbsr = new bsr();
          if ((localObject != null) && (localObject.length > 0)) {
            localbsr.parseFrom((byte[])localObject);
          }
          localbes.ZPb = localbsr;
          paramInt += 1;
        }
        AppMethodBeat.o(258607);
        return 0;
      }
      AppMethodBeat.o(258607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bes
 * JD-Core Version:    0.7.0.1
 */
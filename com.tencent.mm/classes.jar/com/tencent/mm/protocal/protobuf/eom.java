package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class eom
  extends com.tencent.mm.bx.a
{
  public awq YGb;
  public b ZEQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259565);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGb != null)
      {
        paramVarArgs.qD(1, this.YGb.computeSize());
        this.YGb.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(2, this.ZEQ);
      }
      AppMethodBeat.o(259565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGb == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.YGb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.ZEQ);
      }
      AppMethodBeat.o(259565);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259565);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eom localeom = (eom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259565);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            awq localawq = new awq();
            if ((localObject != null) && (localObject.length > 0)) {
              localawq.parseFrom((byte[])localObject);
            }
            localeom.YGb = localawq;
            paramInt += 1;
          }
          AppMethodBeat.o(259565);
          return 0;
        }
        localeom.ZEQ = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(259565);
        return 0;
      }
      AppMethodBeat.o(259565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eom
 * JD-Core Version:    0.7.0.1
 */
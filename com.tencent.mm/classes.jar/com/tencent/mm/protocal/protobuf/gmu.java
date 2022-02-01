package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gmu
  extends com.tencent.mm.bx.a
{
  public gmn achK;
  public String acid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153343);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.achK != null)
      {
        paramVarArgs.qD(1, this.achK.computeSize());
        this.achK.writeFields(paramVarArgs);
      }
      if (this.acid != null) {
        paramVarArgs.g(2, this.acid);
      }
      AppMethodBeat.o(153343);
      return 0;
    }
    if (paramInt == 1) {
      if (this.achK == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.achK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.acid);
      }
      AppMethodBeat.o(153343);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153343);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gmu localgmu = (gmu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153343);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gmn localgmn = new gmn();
            if ((localObject != null) && (localObject.length > 0)) {
              localgmn.parseFrom((byte[])localObject);
            }
            localgmu.achK = localgmn;
            paramInt += 1;
          }
          AppMethodBeat.o(153343);
          return 0;
        }
        localgmu.acid = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(153343);
        return 0;
      }
      AppMethodBeat.o(153343);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmu
 * JD-Core Version:    0.7.0.1
 */
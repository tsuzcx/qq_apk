package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnb
  extends com.tencent.mm.bx.a
{
  public bnn ZVO;
  public String ZVP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258824);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZVO != null)
      {
        paramVarArgs.qD(1, this.ZVO.computeSize());
        this.ZVO.writeFields(paramVarArgs);
      }
      if (this.ZVP != null) {
        paramVarArgs.g(2, this.ZVP);
      }
      AppMethodBeat.o(258824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZVO == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.ZVO.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZVP != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZVP);
      }
      AppMethodBeat.o(258824);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bnb localbnb = (bnb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258824);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bnn localbnn = new bnn();
            if ((localObject != null) && (localObject.length > 0)) {
              localbnn.parseFrom((byte[])localObject);
            }
            localbnb.ZVO = localbnn;
            paramInt += 1;
          }
          AppMethodBeat.o(258824);
          return 0;
        }
        localbnb.ZVP = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258824);
        return 0;
      }
      AppMethodBeat.o(258824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnb
 * JD-Core Version:    0.7.0.1
 */
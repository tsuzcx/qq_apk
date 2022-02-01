package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fvj
  extends com.tencent.mm.bx.a
{
  public String Username;
  public efn abTG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56263);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abTG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Position");
        AppMethodBeat.o(56263);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.g(1, this.Username);
      }
      if (this.abTG != null)
      {
        paramVarArgs.qD(2, this.abTG.computeSize());
        this.abTG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56263);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = i.a.a.b.b.a.h(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abTG != null) {
        i = paramInt + i.a.a.a.qC(2, this.abTG.computeSize());
      }
      AppMethodBeat.o(56263);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abTG == null)
        {
          paramVarArgs = new b("Not all required fields were included: Position");
          AppMethodBeat.o(56263);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56263);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fvj localfvj = (fvj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56263);
          return -1;
        case 1: 
          localfvj.Username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(56263);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          efn localefn = new efn();
          if ((localObject != null) && (localObject.length > 0)) {
            localefn.parseFrom((byte[])localObject);
          }
          localfvj.abTG = localefn;
          paramInt += 1;
        }
        AppMethodBeat.o(56263);
        return 0;
      }
      AppMethodBeat.o(56263);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvj
 * JD-Core Version:    0.7.0.1
 */
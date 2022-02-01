package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ehm
  extends com.tencent.mm.bx.a
{
  public LinkedList<dfj> abmI;
  public String id;
  
  public ehm()
  {
    AppMethodBeat.i(258940);
    this.abmI = new LinkedList();
    AppMethodBeat.o(258940);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258947);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id == null)
      {
        paramVarArgs = new b("Not all required fields were included: id");
        AppMethodBeat.o(258947);
        throw paramVarArgs;
      }
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      paramVarArgs.e(2, 8, this.abmI);
      AppMethodBeat.o(258947);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = i.a.a.b.b.a.h(1, this.id) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.abmI);
      AppMethodBeat.o(258947);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abmI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.id == null)
        {
          paramVarArgs = new b("Not all required fields were included: id");
          AppMethodBeat.o(258947);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258947);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ehm localehm = (ehm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258947);
          return -1;
        case 1: 
          localehm.id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258947);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dfj localdfj = new dfj();
          if ((localObject != null) && (localObject.length > 0)) {
            localdfj.parseFrom((byte[])localObject);
          }
          localehm.abmI.add(localdfj);
          paramInt += 1;
        }
        AppMethodBeat.o(258947);
        return 0;
      }
      AppMethodBeat.o(258947);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehm
 * JD-Core Version:    0.7.0.1
 */
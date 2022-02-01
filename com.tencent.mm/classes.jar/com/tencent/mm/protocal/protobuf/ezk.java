package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ezk
  extends com.tencent.mm.bx.a
{
  public LinkedList<eag> YVe;
  public String hJW;
  
  public ezk()
  {
    AppMethodBeat.i(122544);
    this.YVe = new LinkedList();
    AppMethodBeat.o(122544);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122545);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hJW != null) {
        paramVarArgs.g(1, this.hJW);
      }
      paramVarArgs.e(2, 8, this.YVe);
      AppMethodBeat.o(122545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hJW == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.hJW) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.YVe);
      AppMethodBeat.o(122545);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YVe.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ezk localezk = (ezk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122545);
          return -1;
        case 1: 
          localezk.hJW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122545);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eag localeag = new eag();
          if ((localObject != null) && (localObject.length > 0)) {
            localeag.parseFrom((byte[])localObject);
          }
          localezk.YVe.add(localeag);
          paramInt += 1;
        }
        AppMethodBeat.o(122545);
        return 0;
      }
      AppMethodBeat.o(122545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezk
 * JD-Core Version:    0.7.0.1
 */
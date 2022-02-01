package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rm
  extends com.tencent.mm.bx.a
{
  public LinkedList<rl> YWw;
  public String hAP;
  
  public rm()
  {
    AppMethodBeat.i(257580);
    this.YWw = new LinkedList();
    AppMethodBeat.o(257580);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257586);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      paramVarArgs.e(2, 8, this.YWw);
      AppMethodBeat.o(257586);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.hAP) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.YWw);
      AppMethodBeat.o(257586);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YWw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257586);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        rm localrm = (rm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257586);
          return -1;
        case 1: 
          localrm.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257586);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          rl localrl = new rl();
          if ((localObject != null) && (localObject.length > 0)) {
            localrl.parseFrom((byte[])localObject);
          }
          localrm.YWw.add(localrl);
          paramInt += 1;
        }
        AppMethodBeat.o(257586);
        return 0;
      }
      AppMethodBeat.o(257586);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rm
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fij
  extends com.tencent.mm.bx.a
{
  public LinkedList<fis> Zpr;
  public String hAP;
  
  public fij()
  {
    AppMethodBeat.i(118442);
    this.Zpr = new LinkedList();
    AppMethodBeat.o(118442);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118443);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      paramVarArgs.e(2, 8, this.Zpr);
      AppMethodBeat.o(118443);
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
      int i = i.a.a.a.c(2, 8, this.Zpr);
      AppMethodBeat.o(118443);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zpr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(118443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fij localfij = (fij)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118443);
          return -1;
        case 1: 
          localfij.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(118443);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fis localfis = new fis();
          if ((localObject != null) && (localObject.length > 0)) {
            localfis.parseFrom((byte[])localObject);
          }
          localfij.Zpr.add(localfis);
          paramInt += 1;
        }
        AppMethodBeat.o(118443);
        return 0;
      }
      AppMethodBeat.o(118443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fij
 * JD-Core Version:    0.7.0.1
 */
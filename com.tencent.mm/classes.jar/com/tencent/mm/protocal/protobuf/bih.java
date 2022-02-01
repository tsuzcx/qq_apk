package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bih
  extends com.tencent.mm.cd.a
{
  public LinkedList<bkg> SSJ;
  public String SSp;
  
  public bih()
  {
    AppMethodBeat.i(198318);
    this.SSJ = new LinkedList();
    AppMethodBeat.o(198318);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198323);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SSp != null) {
        paramVarArgs.f(1, this.SSp);
      }
      paramVarArgs.e(2, 8, this.SSJ);
      AppMethodBeat.o(198323);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SSp == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.SSp) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.SSJ);
      AppMethodBeat.o(198323);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SSJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198323);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bih localbih = (bih)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198323);
          return -1;
        case 1: 
          localbih.SSp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(198323);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bkg localbkg = new bkg();
          if ((localObject != null) && (localObject.length > 0)) {
            localbkg.parseFrom((byte[])localObject);
          }
          localbih.SSJ.add(localbkg);
          paramInt += 1;
        }
        AppMethodBeat.o(198323);
        return 0;
      }
      AppMethodBeat.o(198323);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bih
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class af
  extends com.tencent.mm.cd.a
{
  public String MFH;
  public LinkedList<ab> MFI;
  
  public af()
  {
    AppMethodBeat.i(243846);
    this.MFI = new LinkedList();
    AppMethodBeat.o(243846);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243847);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MFH != null) {
        paramVarArgs.f(1, this.MFH);
      }
      paramVarArgs.e(2, 8, this.MFI);
      AppMethodBeat.o(243847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MFH == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.MFH) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.MFI);
      AppMethodBeat.o(243847);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MFI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243847);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        af localaf = (af)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(243847);
          return -1;
        case 1: 
          localaf.MFH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243847);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ab localab = new ab();
          if ((localObject != null) && (localObject.length > 0)) {
            localab.parseFrom((byte[])localObject);
          }
          localaf.MFI.add(localab);
          paramInt += 1;
        }
        AppMethodBeat.o(243847);
        return 0;
      }
      AppMethodBeat.o(243847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.af
 * JD-Core Version:    0.7.0.1
 */
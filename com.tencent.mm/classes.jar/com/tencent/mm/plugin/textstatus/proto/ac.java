package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends com.tencent.mm.cd.a
{
  public int CKC;
  public String MFB;
  public LinkedList<ad> pSC;
  
  public ac()
  {
    AppMethodBeat.i(243805);
    this.pSC = new LinkedList();
    AppMethodBeat.o(243805);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243806);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MFB != null) {
        paramVarArgs.f(1, this.MFB);
      }
      paramVarArgs.aY(2, this.CKC);
      paramVarArgs.e(3, 8, this.pSC);
      AppMethodBeat.o(243806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MFB == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = g.a.a.b.b.a.g(1, this.MFB) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.CKC);
      int j = g.a.a.a.c(3, 8, this.pSC);
      AppMethodBeat.o(243806);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.pSC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243806);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ac localac = (ac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(243806);
          return -1;
        case 1: 
          localac.MFB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(243806);
          return 0;
        case 2: 
          localac.CKC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(243806);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ad localad = new ad();
          if ((localObject != null) && (localObject.length > 0)) {
            localad.parseFrom((byte[])localObject);
          }
          localac.pSC.add(localad);
          paramInt += 1;
        }
        AppMethodBeat.o(243806);
        return 0;
      }
      AppMethodBeat.o(243806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ac
 * JD-Core Version:    0.7.0.1
 */
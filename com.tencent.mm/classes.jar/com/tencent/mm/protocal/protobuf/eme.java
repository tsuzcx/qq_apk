package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eme
  extends com.tencent.mm.cd.a
{
  public int UoH;
  public int UoI;
  public int UoJ;
  public int Uob;
  public fdb Uoc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115855);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uoc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Addr");
        AppMethodBeat.o(115855);
        throw paramVarArgs;
      }
      if (this.Uoc != null)
      {
        paramVarArgs.oE(1, this.Uoc.computeSize());
        this.Uoc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Uob);
      paramVarArgs.aY(3, this.UoH);
      paramVarArgs.aY(4, this.UoI);
      paramVarArgs.aY(5, this.UoJ);
      AppMethodBeat.o(115855);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Uoc == null) {
        break label520;
      }
    }
    label520:
    for (paramInt = g.a.a.a.oD(1, this.Uoc.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.Uob);
      int j = g.a.a.b.b.a.bM(3, this.UoH);
      int k = g.a.a.b.b.a.bM(4, this.UoI);
      int m = g.a.a.b.b.a.bM(5, this.UoJ);
      AppMethodBeat.o(115855);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Uoc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Addr");
          AppMethodBeat.o(115855);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115855);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eme localeme = (eme)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115855);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fdb localfdb = new fdb();
            if ((localObject != null) && (localObject.length > 0)) {
              localfdb.parseFrom((byte[])localObject);
            }
            localeme.Uoc = localfdb;
            paramInt += 1;
          }
          AppMethodBeat.o(115855);
          return 0;
        case 2: 
          localeme.Uob = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115855);
          return 0;
        case 3: 
          localeme.UoH = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115855);
          return 0;
        case 4: 
          localeme.UoI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(115855);
          return 0;
        }
        localeme.UoJ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(115855);
        return 0;
      }
      AppMethodBeat.o(115855);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eme
 * JD-Core Version:    0.7.0.1
 */
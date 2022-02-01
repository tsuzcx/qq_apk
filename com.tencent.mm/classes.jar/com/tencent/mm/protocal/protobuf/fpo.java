package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpo
  extends com.tencent.mm.cd.a
{
  public LinkedList<Integer> UAz;
  public fpn UNq;
  public LinkedList<Integer> UNr;
  public int UNs;
  public int UNt;
  
  public fpo()
  {
    AppMethodBeat.i(153338);
    this.UNr = new LinkedList();
    this.UAz = new LinkedList();
    AppMethodBeat.o(153338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153339);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UNq != null)
      {
        paramVarArgs.oE(1, this.UNq.computeSize());
        this.UNq.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.UNr);
      paramVarArgs.e(3, 2, this.UAz);
      paramVarArgs.aY(4, this.UNs);
      paramVarArgs.aY(5, this.UNt);
      AppMethodBeat.o(153339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UNq == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = g.a.a.a.oD(1, this.UNq.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 2, this.UNr);
      int j = g.a.a.a.c(3, 2, this.UAz);
      int k = g.a.a.b.b.a.bM(4, this.UNs);
      int m = g.a.a.b.b.a.bM(5, this.UNt);
      AppMethodBeat.o(153339);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UNr.clear();
        this.UAz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fpo localfpo = (fpo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153339);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fpn localfpn = new fpn();
            if ((localObject != null) && (localObject.length > 0)) {
              localfpn.parseFrom((byte[])localObject);
            }
            localfpo.UNq = localfpn;
            paramInt += 1;
          }
          AppMethodBeat.o(153339);
          return 0;
        case 2: 
          localfpo.UNr.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
          AppMethodBeat.o(153339);
          return 0;
        case 3: 
          localfpo.UAz.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
          AppMethodBeat.o(153339);
          return 0;
        case 4: 
          localfpo.UNs = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(153339);
          return 0;
        }
        localfpo.UNt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153339);
        return 0;
      }
      AppMethodBeat.o(153339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpo
 * JD-Core Version:    0.7.0.1
 */
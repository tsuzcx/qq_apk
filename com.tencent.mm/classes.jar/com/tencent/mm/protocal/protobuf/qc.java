package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qc
  extends com.tencent.mm.cd.a
{
  public LinkedList<qb> RYw;
  public String fwr;
  
  public qc()
  {
    AppMethodBeat.i(206438);
    this.RYw = new LinkedList();
    AppMethodBeat.o(206438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206439);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      paramVarArgs.e(2, 8, this.RYw);
      AppMethodBeat.o(206439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.fwr) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.RYw);
      AppMethodBeat.o(206439);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RYw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        qc localqc = (qc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206439);
          return -1;
        case 1: 
          localqc.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(206439);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          qb localqb = new qb();
          if ((localObject != null) && (localObject.length > 0)) {
            localqb.parseFrom((byte[])localObject);
          }
          localqc.RYw.add(localqb);
          paramInt += 1;
        }
        AppMethodBeat.o(206439);
        return 0;
      }
      AppMethodBeat.o(206439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qc
 * JD-Core Version:    0.7.0.1
 */
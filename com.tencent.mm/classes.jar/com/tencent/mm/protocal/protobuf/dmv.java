package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmv
  extends com.tencent.mm.cd.a
{
  public String TUa;
  public String TUb;
  public LinkedList<erp> TUc;
  
  public dmv()
  {
    AppMethodBeat.i(72550);
    this.TUc = new LinkedList();
    AppMethodBeat.o(72550);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72551);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TUa != null) {
        paramVarArgs.f(1, this.TUa);
      }
      if (this.TUb != null) {
        paramVarArgs.f(2, this.TUb);
      }
      paramVarArgs.e(3, 8, this.TUc);
      AppMethodBeat.o(72551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TUa == null) {
        break label396;
      }
    }
    label396:
    for (paramInt = g.a.a.b.b.a.g(1, this.TUa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TUb != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TUb);
      }
      paramInt = g.a.a.a.c(3, 8, this.TUc);
      AppMethodBeat.o(72551);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TUc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dmv localdmv = (dmv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72551);
          return -1;
        case 1: 
          localdmv.TUa = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72551);
          return 0;
        case 2: 
          localdmv.TUb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72551);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          erp localerp = new erp();
          if ((localObject != null) && (localObject.length > 0)) {
            localerp.parseFrom((byte[])localObject);
          }
          localdmv.TUc.add(localerp);
          paramInt += 1;
        }
        AppMethodBeat.o(72551);
        return 0;
      }
      AppMethodBeat.o(72551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmv
 * JD-Core Version:    0.7.0.1
 */
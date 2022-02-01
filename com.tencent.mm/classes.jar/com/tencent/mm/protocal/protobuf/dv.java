package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dv
  extends com.tencent.mm.cd.a
{
  public String RJl;
  public LinkedList<emw> RJm;
  public String title;
  
  public dv()
  {
    AppMethodBeat.i(32112);
    this.RJm = new LinkedList();
    AppMethodBeat.o(32112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32113);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RJl != null) {
        paramVarArgs.f(1, this.RJl);
      }
      paramVarArgs.e(2, 8, this.RJm);
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      AppMethodBeat.o(32113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RJl == null) {
        break label405;
      }
    }
    label405:
    for (paramInt = g.a.a.b.b.a.g(1, this.RJl) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.RJm);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.title);
      }
      AppMethodBeat.o(32113);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RJm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dv localdv = (dv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32113);
          return -1;
        case 1: 
          localdv.RJl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32113);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            emw localemw = new emw();
            if ((localObject != null) && (localObject.length > 0)) {
              localemw.parseFrom((byte[])localObject);
            }
            localdv.RJm.add(localemw);
            paramInt += 1;
          }
          AppMethodBeat.o(32113);
          return 0;
        }
        localdv.title = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32113);
        return 0;
      }
      AppMethodBeat.o(32113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dv
 * JD-Core Version:    0.7.0.1
 */
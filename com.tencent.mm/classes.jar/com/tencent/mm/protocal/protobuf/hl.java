package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hl
  extends com.tencent.mm.cd.a
{
  public LinkedList<hk> RMF;
  public String desc;
  public String title;
  
  public hl()
  {
    AppMethodBeat.i(123550);
    this.RMF = new LinkedList();
    AppMethodBeat.o(123550);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123551);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.f(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.RMF);
      AppMethodBeat.o(123551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label396;
      }
    }
    label396:
    for (paramInt = g.a.a.b.b.a.g(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.desc);
      }
      paramInt = g.a.a.a.c(3, 8, this.RMF);
      AppMethodBeat.o(123551);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RMF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        hl localhl = (hl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123551);
          return -1;
        case 1: 
          localhl.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123551);
          return 0;
        case 2: 
          localhl.desc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(123551);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          hk localhk = new hk();
          if ((localObject != null) && (localObject.length > 0)) {
            localhk.parseFrom((byte[])localObject);
          }
          localhl.RMF.add(localhk);
          paramInt += 1;
        }
        AppMethodBeat.o(123551);
        return 0;
      }
      AppMethodBeat.o(123551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hl
 * JD-Core Version:    0.7.0.1
 */
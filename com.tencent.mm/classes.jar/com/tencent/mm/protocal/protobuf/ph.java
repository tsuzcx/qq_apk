package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ph
  extends com.tencent.mm.cd.a
{
  public LinkedList<ok> RVd;
  public int RVf;
  public String RVg;
  public long RXN;
  public String RXO;
  
  public ph()
  {
    AppMethodBeat.i(205929);
    this.RVd = new LinkedList();
    AppMethodBeat.o(205929);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205930);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.RXN);
      paramVarArgs.e(2, 8, this.RVd);
      paramVarArgs.aY(3, this.RVf);
      if (this.RVg != null) {
        paramVarArgs.f(4, this.RVg);
      }
      if (this.RXO != null) {
        paramVarArgs.f(5, this.RXO);
      }
      AppMethodBeat.o(205930);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.RXN) + 0 + g.a.a.a.c(2, 8, this.RVd) + g.a.a.b.b.a.bM(3, this.RVf);
      paramInt = i;
      if (this.RVg != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RVg);
      }
      i = paramInt;
      if (this.RXO != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RXO);
      }
      AppMethodBeat.o(205930);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RVd.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(205930);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      ph localph = (ph)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(205930);
        return -1;
      case 1: 
        localph.RXN = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(205930);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ok localok = new ok();
          if ((localObject != null) && (localObject.length > 0)) {
            localok.parseFrom((byte[])localObject);
          }
          localph.RVd.add(localok);
          paramInt += 1;
        }
        AppMethodBeat.o(205930);
        return 0;
      case 3: 
        localph.RVf = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(205930);
        return 0;
      case 4: 
        localph.RVg = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(205930);
        return 0;
      }
      localph.RXO = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(205930);
      return 0;
    }
    AppMethodBeat.o(205930);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ph
 * JD-Core Version:    0.7.0.1
 */
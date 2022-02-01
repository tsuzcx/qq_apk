package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efk
  extends com.tencent.mm.cd.a
{
  public boolean Aaj;
  public String SYa;
  public long SYb;
  public boolean UiJ;
  public LinkedList<cjp> UiK;
  public String fLj;
  public int index;
  
  public efk()
  {
    AppMethodBeat.i(177411);
    this.index = -1;
    this.UiJ = false;
    this.fLj = "";
    this.SYb = -1L;
    this.SYa = "";
    this.UiK = new LinkedList();
    this.Aaj = false;
    AppMethodBeat.o(177411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.index);
      paramVarArgs.co(2, this.UiJ);
      if (this.fLj != null) {
        paramVarArgs.f(3, this.fLj);
      }
      paramVarArgs.bm(4, this.SYb);
      if (this.SYa != null) {
        paramVarArgs.f(5, this.SYa);
      }
      paramVarArgs.e(6, 8, this.UiK);
      paramVarArgs.co(7, this.Aaj);
      AppMethodBeat.o(177412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.index) + 0 + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.fLj != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fLj);
      }
      i = paramInt + g.a.a.b.b.a.p(4, this.SYb);
      paramInt = i;
      if (this.SYa != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SYa);
      }
      i = g.a.a.a.c(6, 8, this.UiK);
      int j = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(177412);
      return paramInt + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UiK.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(177412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      efk localefk = (efk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(177412);
        return -1;
      case 1: 
        localefk.index = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(177412);
        return 0;
      case 2: 
        localefk.UiJ = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(177412);
        return 0;
      case 3: 
        localefk.fLj = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 4: 
        localefk.SYb = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(177412);
        return 0;
      case 5: 
        localefk.SYa = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cjp localcjp = new cjp();
          if ((localObject != null) && (localObject.length > 0)) {
            localcjp.parseFrom((byte[])localObject);
          }
          localefk.UiK.add(localcjp);
          paramInt += 1;
        }
        AppMethodBeat.o(177412);
        return 0;
      }
      localefk.Aaj = ((g.a.a.a.a)localObject).abFh.AB();
      AppMethodBeat.o(177412);
      return 0;
    }
    AppMethodBeat.o(177412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efk
 * JD-Core Version:    0.7.0.1
 */
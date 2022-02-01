package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fjm
  extends com.tencent.mm.cd.a
{
  public long RNj;
  public long UIH;
  public String UII;
  public LinkedList<fjn> UIJ;
  
  public fjm()
  {
    AppMethodBeat.i(32534);
    this.UIJ = new LinkedList();
    AppMethodBeat.o(32534);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32535);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UII == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(32535);
        throw paramVarArgs;
      }
      paramVarArgs.bm(1, this.UIH);
      paramVarArgs.bm(2, this.RNj);
      if (this.UII != null) {
        paramVarArgs.f(3, this.UII);
      }
      paramVarArgs.e(4, 8, this.UIJ);
      AppMethodBeat.o(32535);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.UIH) + 0 + g.a.a.b.b.a.p(2, this.RNj);
      paramInt = i;
      if (this.UII != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UII);
      }
      i = g.a.a.a.c(4, 8, this.UIJ);
      AppMethodBeat.o(32535);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UIJ.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.UII == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(32535);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32535);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      fjm localfjm = (fjm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32535);
        return -1;
      case 1: 
        localfjm.UIH = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(32535);
        return 0;
      case 2: 
        localfjm.RNj = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(32535);
        return 0;
      case 3: 
        localfjm.UII = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32535);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fjn localfjn = new fjn();
        if ((localObject != null) && (localObject.length > 0)) {
          localfjn.parseFrom((byte[])localObject);
        }
        localfjm.UIJ.add(localfjn);
        paramInt += 1;
      }
      AppMethodBeat.o(32535);
      return 0;
    }
    AppMethodBeat.o(32535);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjm
 * JD-Core Version:    0.7.0.1
 */
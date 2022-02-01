package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qv
  extends com.tencent.mm.cd.a
{
  public LinkedList<aot> RZg;
  public LinkedList<aos> RZh;
  public String RZi;
  public String RZj;
  public String RZk;
  
  public qv()
  {
    AppMethodBeat.i(91368);
    this.RZg = new LinkedList();
    this.RZh = new LinkedList();
    AppMethodBeat.o(91368);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91369);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.RZg);
      paramVarArgs.e(2, 8, this.RZh);
      if (this.RZi != null) {
        paramVarArgs.f(3, this.RZi);
      }
      if (this.RZj != null) {
        paramVarArgs.f(4, this.RZj);
      }
      if (this.RZk != null) {
        paramVarArgs.f(5, this.RZk);
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.RZg) + 0 + g.a.a.a.c(2, 8, this.RZh);
      paramInt = i;
      if (this.RZi != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RZi);
      }
      i = paramInt;
      if (this.RZj != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RZj);
      }
      paramInt = i;
      if (this.RZk != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RZk);
      }
      AppMethodBeat.o(91369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RZg.clear();
      this.RZh.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      qv localqv = (qv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91369);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aot();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aot)localObject2).parseFrom((byte[])localObject1);
          }
          localqv.RZg.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aos();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aos)localObject2).parseFrom((byte[])localObject1);
          }
          localqv.RZh.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 3: 
        localqv.RZi = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91369);
        return 0;
      case 4: 
        localqv.RZj = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91369);
        return 0;
      }
      localqv.RZk = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(91369);
      return 0;
    }
    AppMethodBeat.o(91369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qv
 * JD-Core Version:    0.7.0.1
 */
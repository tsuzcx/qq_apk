package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.cd.a
{
  public LinkedList<a> RDg;
  public int id;
  public String msg;
  public String title;
  
  public b()
  {
    AppMethodBeat.i(123717);
    this.RDg = new LinkedList();
    AppMethodBeat.o(123717);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123718);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.id);
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      if (this.msg != null) {
        paramVarArgs.f(3, this.msg);
      }
      paramVarArgs.e(4, 8, this.RDg);
      AppMethodBeat.o(123718);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.id) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.title);
      }
      i = paramInt;
      if (this.msg != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.msg);
      }
      paramInt = g.a.a.a.c(4, 8, this.RDg);
      AppMethodBeat.o(123718);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RDg.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(123718);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123718);
        return -1;
      case 1: 
        localb.id = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(123718);
        return 0;
      case 2: 
        localb.title = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(123718);
        return 0;
      case 3: 
        localb.msg = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(123718);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        a locala = new a();
        if ((localObject != null) && (localObject.length > 0)) {
          locala.parseFrom((byte[])localObject);
        }
        localb.RDg.add(locala);
        paramInt += 1;
      }
      AppMethodBeat.o(123718);
      return 0;
    }
    AppMethodBeat.o(123718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.b
 * JD-Core Version:    0.7.0.1
 */
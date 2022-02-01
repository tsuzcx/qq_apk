package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class asz
  extends com.tencent.mm.cd.a
{
  public LinkedList<FinderObject> SGi;
  public int jlf;
  public String username;
  public int xBI;
  
  public asz()
  {
    AppMethodBeat.i(209796);
    this.SGi = new LinkedList();
    AppMethodBeat.o(209796);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209799);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.xBI);
      paramVarArgs.e(2, 8, this.SGi);
      if (this.username != null) {
        paramVarArgs.f(3, this.username);
      }
      paramVarArgs.aY(4, this.jlf);
      AppMethodBeat.o(209799);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.xBI) + 0 + g.a.a.a.c(2, 8, this.SGi);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.username);
      }
      i = g.a.a.b.b.a.bM(4, this.jlf);
      AppMethodBeat.o(209799);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SGi.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(209799);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      asz localasz = (asz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209799);
        return -1;
      case 1: 
        localasz.xBI = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(209799);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          FinderObject localFinderObject = new FinderObject();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderObject.parseFrom((byte[])localObject);
          }
          localasz.SGi.add(localFinderObject);
          paramInt += 1;
        }
        AppMethodBeat.o(209799);
        return 0;
      case 3: 
        localasz.username = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(209799);
        return 0;
      }
      localasz.jlf = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(209799);
      return 0;
    }
    AppMethodBeat.o(209799);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asz
 * JD-Core Version:    0.7.0.1
 */
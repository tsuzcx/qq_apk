package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class atl
  extends com.tencent.mm.cd.a
{
  public b SDH;
  public FinderObject SGo;
  public int scene;
  public int tab_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201062);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.tab_type);
      paramVarArgs.aY(2, this.scene);
      if (this.SDH != null) {
        paramVarArgs.c(3, this.SDH);
      }
      if (this.SGo != null)
      {
        paramVarArgs.oE(4, this.SGo.computeSize());
        this.SGo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(201062);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.tab_type) + 0 + g.a.a.b.b.a.bM(2, this.scene);
      paramInt = i;
      if (this.SDH != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.SDH);
      }
      i = paramInt;
      if (this.SGo != null) {
        i = paramInt + g.a.a.a.oD(4, this.SGo.computeSize());
      }
      AppMethodBeat.o(201062);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(201062);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      atl localatl = (atl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(201062);
        return -1;
      case 1: 
        localatl.tab_type = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(201062);
        return 0;
      case 2: 
        localatl.scene = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(201062);
        return 0;
      case 3: 
        localatl.SDH = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(201062);
        return 0;
      }
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
        localatl.SGo = localFinderObject;
        paramInt += 1;
      }
      AppMethodBeat.o(201062);
      return 0;
    }
    AppMethodBeat.o(201062);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atl
 * JD-Core Version:    0.7.0.1
 */
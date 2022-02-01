package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class dog
  extends com.tencent.mm.cd.a
{
  public FinderObject Gbc;
  public b TVy;
  public String id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229133);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.f(1, this.id);
      }
      paramVarArgs.aY(2, this.type);
      if (this.Gbc != null)
      {
        paramVarArgs.oE(3, this.Gbc.computeSize());
        this.Gbc.writeFields(paramVarArgs);
      }
      if (this.TVy != null) {
        paramVarArgs.c(4, this.TVy);
      }
      AppMethodBeat.o(229133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = g.a.a.b.b.a.g(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type);
      paramInt = i;
      if (this.Gbc != null) {
        paramInt = i + g.a.a.a.oD(3, this.Gbc.computeSize());
      }
      i = paramInt;
      if (this.TVy != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.TVy);
      }
      AppMethodBeat.o(229133);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229133);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dog localdog = (dog)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229133);
          return -1;
        case 1: 
          localdog.id = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(229133);
          return 0;
        case 2: 
          localdog.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(229133);
          return 0;
        case 3: 
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
            localdog.Gbc = localFinderObject;
            paramInt += 1;
          }
          AppMethodBeat.o(229133);
          return 0;
        }
        localdog.TVy = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(229133);
        return 0;
      }
      AppMethodBeat.o(229133);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dog
 * JD-Core Version:    0.7.0.1
 */
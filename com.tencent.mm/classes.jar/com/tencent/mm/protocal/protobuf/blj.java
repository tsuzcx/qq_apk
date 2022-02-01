package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blj
  extends com.tencent.mm.cd.a
{
  public cvy SPm;
  public String SWw;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197271);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.id);
      if (this.SPm != null)
      {
        paramVarArgs.oE(2, this.SPm.computeSize());
        this.SPm.writeFields(paramVarArgs);
      }
      if (this.SWw != null) {
        paramVarArgs.f(3, this.SWw);
      }
      AppMethodBeat.o(197271);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.id) + 0;
      paramInt = i;
      if (this.SPm != null) {
        paramInt = i + g.a.a.a.oD(2, this.SPm.computeSize());
      }
      i = paramInt;
      if (this.SWw != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SWw);
      }
      AppMethodBeat.o(197271);
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
      AppMethodBeat.o(197271);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      blj localblj = (blj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(197271);
        return -1;
      case 1: 
        localblj.id = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(197271);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cvy localcvy = new cvy();
          if ((localObject != null) && (localObject.length > 0)) {
            localcvy.parseFrom((byte[])localObject);
          }
          localblj.SPm = localcvy;
          paramInt += 1;
        }
        AppMethodBeat.o(197271);
        return 0;
      }
      localblj.SWw = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(197271);
      return 0;
    }
    AppMethodBeat.o(197271);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blj
 * JD-Core Version:    0.7.0.1
 */
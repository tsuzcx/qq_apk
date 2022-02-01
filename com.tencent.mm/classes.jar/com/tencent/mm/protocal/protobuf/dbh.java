package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbh
  extends com.tencent.mm.cd.a
{
  public dbk TIF;
  public dbi TIG;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(234576);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.TIF != null)
      {
        paramVarArgs.oE(2, this.TIF.computeSize());
        this.TIF.writeFields(paramVarArgs);
      }
      if (this.TIG != null)
      {
        paramVarArgs.oE(101, this.TIG.computeSize());
        this.TIG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(234576);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.TIF != null) {
        paramInt = i + g.a.a.a.oD(2, this.TIF.computeSize());
      }
      i = paramInt;
      if (this.TIG != null) {
        i = paramInt + g.a.a.a.oD(101, this.TIG.computeSize());
      }
      AppMethodBeat.o(234576);
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
      AppMethodBeat.o(234576);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dbh localdbh = (dbh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(234576);
        return -1;
      case 1: 
        localdbh.type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(234576);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dbk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dbk)localObject2).parseFrom((byte[])localObject1);
          }
          localdbh.TIF = ((dbk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(234576);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dbi();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dbi)localObject2).parseFrom((byte[])localObject1);
        }
        localdbh.TIG = ((dbi)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(234576);
      return 0;
    }
    AppMethodBeat.o(234576);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbh
 * JD-Core Version:    0.7.0.1
 */
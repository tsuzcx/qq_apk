package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mw
  extends com.tencent.mm.bx.a
{
  public boolean FGM;
  public LinkedList<my> Fys;
  public String Title;
  
  public mw()
  {
    AppMethodBeat.i(124411);
    this.Fys = new LinkedList();
    AppMethodBeat.o(124411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.Fys);
      paramVarArgs.bt(3, this.FGM);
      AppMethodBeat.o(124412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Fys);
      int j = f.a.a.b.b.a.alV(3);
      AppMethodBeat.o(124412);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fys.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mw localmw = (mw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124412);
          return -1;
        case 1: 
          localmw.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124412);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new my();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((my)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmw.Fys.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124412);
          return 0;
        }
        localmw.FGM = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(124412);
        return 0;
      }
      AppMethodBeat.o(124412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mw
 * JD-Core Version:    0.7.0.1
 */
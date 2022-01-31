package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class km
  extends com.tencent.mm.bv.a
{
  public String Title;
  public LinkedList<ko> wrp;
  public boolean wxT;
  
  public km()
  {
    AppMethodBeat.i(151366);
    this.wrp = new LinkedList();
    AppMethodBeat.o(151366);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151367);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.wrp);
      paramVarArgs.aS(3, this.wxT);
      AppMethodBeat.o(151367);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = e.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 8, this.wrp);
      int j = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(151367);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wrp.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151367);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        km localkm = (km)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151367);
          return -1;
        case 1: 
          localkm.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151367);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ko();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ko)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localkm.wrp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151367);
          return 0;
        }
        localkm.wxT = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(151367);
        return 0;
      }
      AppMethodBeat.o(151367);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.km
 * JD-Core Version:    0.7.0.1
 */
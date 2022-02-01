package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ere
  extends com.tencent.mm.bw.a
{
  public LinkedList<cyk> MWl;
  public String NoL;
  public String NoR;
  public String aPi;
  public int action;
  public int type;
  public String viewId;
  
  public ere()
  {
    AppMethodBeat.i(220729);
    this.MWl = new LinkedList();
    AppMethodBeat.o(220729);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220730);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.viewId != null) {
        paramVarArgs.e(1, this.viewId);
      }
      paramVarArgs.aM(2, this.type);
      if (this.aPi != null) {
        paramVarArgs.e(3, this.aPi);
      }
      paramVarArgs.aM(4, this.action);
      paramVarArgs.e(5, 8, this.MWl);
      if (this.NoL != null) {
        paramVarArgs.e(6, this.NoL);
      }
      if (this.NoR != null) {
        paramVarArgs.e(7, this.NoR);
      }
      AppMethodBeat.o(220730);
      return 0;
    }
    if (paramInt == 1) {
      if (this.viewId == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = g.a.a.b.b.a.f(1, this.viewId) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.type);
      paramInt = i;
      if (this.aPi != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.aPi);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.action) + g.a.a.a.c(5, 8, this.MWl);
      paramInt = i;
      if (this.NoL != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.NoL);
      }
      i = paramInt;
      if (this.NoR != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.NoR);
      }
      AppMethodBeat.o(220730);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MWl.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(220730);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ere localere = (ere)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220730);
          return -1;
        case 1: 
          localere.viewId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220730);
          return 0;
        case 2: 
          localere.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220730);
          return 0;
        case 3: 
          localere.aPi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220730);
          return 0;
        case 4: 
          localere.action = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220730);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cyk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localere.MWl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220730);
          return 0;
        case 6: 
          localere.NoL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220730);
          return 0;
        }
        localere.NoR = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(220730);
        return 0;
      }
      AppMethodBeat.o(220730);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ere
 * JD-Core Version:    0.7.0.1
 */
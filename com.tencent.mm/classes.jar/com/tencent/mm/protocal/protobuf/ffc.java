package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ffc
  extends com.tencent.mm.bw.a
{
  public String NAt;
  public String NAu;
  public LinkedList<cxp> NAv;
  public String NAw;
  public int NAx;
  public String Title;
  
  public ffc()
  {
    AppMethodBeat.i(50125);
    this.NAv = new LinkedList();
    AppMethodBeat.o(50125);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50126);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NAt != null) {
        paramVarArgs.e(1, this.NAt);
      }
      if (this.NAu != null) {
        paramVarArgs.e(2, this.NAu);
      }
      paramVarArgs.e(3, 8, this.NAv);
      if (this.NAw != null) {
        paramVarArgs.e(4, this.NAw);
      }
      paramVarArgs.aM(5, this.NAx);
      if (this.Title != null) {
        paramVarArgs.e(6, this.Title);
      }
      AppMethodBeat.o(50126);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NAt == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = g.a.a.b.b.a.f(1, this.NAt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NAu != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.NAu);
      }
      i += g.a.a.a.c(3, 8, this.NAv);
      paramInt = i;
      if (this.NAw != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NAw);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.NAx);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Title);
      }
      AppMethodBeat.o(50126);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NAv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(50126);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ffc localffc = (ffc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50126);
          return -1;
        case 1: 
          localffc.NAt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 2: 
          localffc.NAu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cxp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localffc.NAv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50126);
          return 0;
        case 4: 
          localffc.NAw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 5: 
          localffc.NAx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(50126);
          return 0;
        }
        localffc.Title = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(50126);
        return 0;
      }
      AppMethodBeat.o(50126);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffc
 * JD-Core Version:    0.7.0.1
 */
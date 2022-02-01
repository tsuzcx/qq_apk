package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dls
  extends com.tencent.mm.bw.a
{
  public String MPm;
  public dlt MaT;
  public String content;
  public String iwt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168758);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.e(1, this.content);
      }
      if (this.iwt != null) {
        paramVarArgs.e(2, this.iwt);
      }
      if (this.MPm != null) {
        paramVarArgs.e(3, this.MPm);
      }
      if (this.MaT != null)
      {
        paramVarArgs.ni(4, this.MaT.computeSize());
        this.MaT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label490;
      }
    }
    label490:
    for (int i = g.a.a.b.b.a.f(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iwt != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.iwt);
      }
      i = paramInt;
      if (this.MPm != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MPm);
      }
      paramInt = i;
      if (this.MaT != null) {
        paramInt = i + g.a.a.a.nh(4, this.MaT.computeSize());
      }
      AppMethodBeat.o(168758);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dls localdls = (dls)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168758);
          return -1;
        case 1: 
          localdls.content = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168758);
          return 0;
        case 2: 
          localdls.iwt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168758);
          return 0;
        case 3: 
          localdls.MPm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168758);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dlt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdls.MaT = ((dlt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168758);
        return 0;
      }
      AppMethodBeat.o(168758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dls
 * JD-Core Version:    0.7.0.1
 */
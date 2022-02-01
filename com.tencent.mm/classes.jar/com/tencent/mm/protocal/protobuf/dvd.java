package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvd
  extends com.tencent.mm.bw.a
{
  public String MWb;
  public LinkedList<dvc> MWj;
  public String dMl;
  public String sGF;
  
  public dvd()
  {
    AppMethodBeat.i(122532);
    this.MWj = new LinkedList();
    AppMethodBeat.o(122532);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122533);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sGF != null) {
        paramVarArgs.e(1, this.sGF);
      }
      if (this.MWb != null) {
        paramVarArgs.e(2, this.MWb);
      }
      if (this.dMl != null) {
        paramVarArgs.e(3, this.dMl);
      }
      paramVarArgs.e(4, 8, this.MWj);
      AppMethodBeat.o(122533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sGF == null) {
        break label478;
      }
    }
    label478:
    for (int i = g.a.a.b.b.a.f(1, this.sGF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MWb != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MWb);
      }
      i = paramInt;
      if (this.dMl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dMl);
      }
      paramInt = g.a.a.a.c(4, 8, this.MWj);
      AppMethodBeat.o(122533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MWj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvd localdvd = (dvd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122533);
          return -1;
        case 1: 
          localdvd.sGF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 2: 
          localdvd.MWb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122533);
          return 0;
        case 3: 
          localdvd.dMl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122533);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dvc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdvd.MWj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122533);
        return 0;
      }
      AppMethodBeat.o(122533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvd
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public class l
  extends com.tencent.mm.bw.a
{
  public int AZz;
  public String Bab;
  public int Bac;
  public LinkedList<e> Bad;
  public String url;
  
  public l()
  {
    AppMethodBeat.i(91278);
    this.Bad = new LinkedList();
    AppMethodBeat.o(91278);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91279);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Bab == null)
      {
        paramVarArgs = new b("Not all required fields were included: id_info");
        AppMethodBeat.o(91279);
        throw paramVarArgs;
      }
      if (this.Bab != null) {
        paramVarArgs.e(1, this.Bab);
      }
      paramVarArgs.aM(2, this.Bac);
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      paramVarArgs.e(4, 8, this.Bad);
      paramVarArgs.aM(5, this.AZz);
      AppMethodBeat.o(91279);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Bab == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = g.a.a.b.b.a.f(1, this.Bab) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Bac);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.url);
      }
      i = g.a.a.a.c(4, 8, this.Bad);
      int j = g.a.a.b.b.a.bu(5, this.AZz);
      AppMethodBeat.o(91279);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Bad.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Bab == null)
        {
          paramVarArgs = new b("Not all required fields were included: id_info");
          AppMethodBeat.o(91279);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91279);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91279);
          return -1;
        case 1: 
          locall.Bab = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91279);
          return 0;
        case 2: 
          locall.Bac = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91279);
          return 0;
        case 3: 
          locall.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91279);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locall.Bad.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91279);
          return 0;
        }
        locall.AZz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91279);
        return 0;
      }
      AppMethodBeat.o(91279);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.l
 * JD-Core Version:    0.7.0.1
 */
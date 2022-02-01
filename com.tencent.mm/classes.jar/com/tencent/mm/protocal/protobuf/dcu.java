package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcu
  extends com.tencent.mm.bw.a
{
  public String MHf;
  public LinkedList<dcv> MIa;
  public String Mgh;
  public String Name;
  public String URL;
  public int oTz;
  
  public dcu()
  {
    AppMethodBeat.i(209798);
    this.MIa = new LinkedList();
    AppMethodBeat.o(209798);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209799);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.Mgh != null) {
        paramVarArgs.e(2, this.Mgh);
      }
      if (this.URL != null) {
        paramVarArgs.e(3, this.URL);
      }
      paramVarArgs.aM(4, this.oTz);
      if (this.MHf != null) {
        paramVarArgs.e(5, this.MHf);
      }
      paramVarArgs.e(6, 8, this.MIa);
      AppMethodBeat.o(209799);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label582;
      }
    }
    label582:
    for (int i = g.a.a.b.b.a.f(1, this.Name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mgh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mgh);
      }
      i = paramInt;
      if (this.URL != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.URL);
      }
      i += g.a.a.b.b.a.bu(4, this.oTz);
      paramInt = i;
      if (this.MHf != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MHf);
      }
      i = g.a.a.a.c(6, 8, this.MIa);
      AppMethodBeat.o(209799);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MIa.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209799);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dcu localdcu = (dcu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209799);
          return -1;
        case 1: 
          localdcu.Name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209799);
          return 0;
        case 2: 
          localdcu.Mgh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209799);
          return 0;
        case 3: 
          localdcu.URL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209799);
          return 0;
        case 4: 
          localdcu.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209799);
          return 0;
        case 5: 
          localdcu.MHf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209799);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dcv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdcu.MIa.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209799);
        return 0;
      }
      AppMethodBeat.o(209799);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcu
 * JD-Core Version:    0.7.0.1
 */
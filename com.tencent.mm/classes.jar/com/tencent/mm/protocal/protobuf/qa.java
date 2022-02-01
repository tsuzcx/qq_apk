package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qa
  extends com.tencent.mm.bw.a
{
  public String HWM;
  public LinkedList<qa> KWT;
  public int iOt;
  public int id;
  public String key;
  public String name;
  public int type;
  public String value;
  
  public qa()
  {
    AppMethodBeat.i(124457);
    this.KWT = new LinkedList();
    AppMethodBeat.o(124457);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124458);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.id);
      paramVarArgs.aM(2, this.type);
      if (this.name != null) {
        paramVarArgs.e(3, this.name);
      }
      if (this.key != null) {
        paramVarArgs.e(4, this.key);
      }
      if (this.value != null) {
        paramVarArgs.e(5, this.value);
      }
      paramVarArgs.e(6, 8, this.KWT);
      paramVarArgs.aM(7, this.iOt);
      if (this.HWM != null) {
        paramVarArgs.e(8, this.HWM);
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.id) + 0 + g.a.a.b.b.a.bu(2, this.type);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.name);
      }
      i = paramInt;
      if (this.key != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.key);
      }
      paramInt = i;
      if (this.value != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.value);
      }
      i = paramInt + g.a.a.a.c(6, 8, this.KWT) + g.a.a.b.b.a.bu(7, this.iOt);
      paramInt = i;
      if (this.HWM != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.HWM);
      }
      AppMethodBeat.o(124458);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KWT.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(124458);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      qa localqa = (qa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124458);
        return -1;
      case 1: 
        localqa.id = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124458);
        return 0;
      case 2: 
        localqa.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124458);
        return 0;
      case 3: 
        localqa.name = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 4: 
        localqa.key = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 5: 
        localqa.value = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124458);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qa();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((qa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localqa.KWT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124458);
        return 0;
      case 7: 
        localqa.iOt = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124458);
        return 0;
      }
      localqa.HWM = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(124458);
      return 0;
    }
    AppMethodBeat.o(124458);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qa
 * JD-Core Version:    0.7.0.1
 */
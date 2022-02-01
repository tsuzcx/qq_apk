package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anz
  extends com.tencent.mm.bw.a
{
  public int HZA;
  public String LzE;
  public String LzF;
  public aoa field_area_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.HZA);
      if (this.field_area_info != null)
      {
        paramVarArgs.ni(2, this.field_area_info.computeSize());
        this.field_area_info.writeFields(paramVarArgs);
      }
      if (this.LzE != null) {
        paramVarArgs.e(3, this.LzE);
      }
      if (this.LzF != null) {
        paramVarArgs.e(4, this.LzF);
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.HZA) + 0;
      paramInt = i;
      if (this.field_area_info != null) {
        paramInt = i + g.a.a.a.nh(2, this.field_area_info.computeSize());
      }
      i = paramInt;
      if (this.LzE != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LzE);
      }
      paramInt = i;
      if (this.LzF != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LzF);
      }
      AppMethodBeat.o(72475);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      anz localanz = (anz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72475);
        return -1;
      case 1: 
        localanz.HZA = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(72475);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aoa();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aoa)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localanz.field_area_info = ((aoa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72475);
        return 0;
      case 3: 
        localanz.LzE = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72475);
        return 0;
      }
      localanz.LzF = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(72475);
      return 0;
    }
    AppMethodBeat.o(72475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anz
 * JD-Core Version:    0.7.0.1
 */
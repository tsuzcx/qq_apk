package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahl
  extends com.tencent.mm.bx.a
{
  public int AfU;
  public String Dkc;
  public String Dkd;
  public ahm field_area_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.AfU);
      if (this.field_area_info != null)
      {
        paramVarArgs.kX(2, this.field_area_info.computeSize());
        this.field_area_info.writeFields(paramVarArgs);
      }
      if (this.Dkc != null) {
        paramVarArgs.d(3, this.Dkc);
      }
      if (this.Dkd != null) {
        paramVarArgs.d(4, this.Dkd);
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.AfU) + 0;
      paramInt = i;
      if (this.field_area_info != null) {
        paramInt = i + f.a.a.a.kW(2, this.field_area_info.computeSize());
      }
      i = paramInt;
      if (this.Dkc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Dkc);
      }
      paramInt = i;
      if (this.Dkd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dkd);
      }
      AppMethodBeat.o(72475);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ahl localahl = (ahl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72475);
        return -1;
      case 1: 
        localahl.AfU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(72475);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ahm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahl.field_area_info = ((ahm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72475);
        return 0;
      case 3: 
        localahl.Dkc = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72475);
        return 0;
      }
      localahl.Dkd = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(72475);
      return 0;
    }
    AppMethodBeat.o(72475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahl
 * JD-Core Version:    0.7.0.1
 */
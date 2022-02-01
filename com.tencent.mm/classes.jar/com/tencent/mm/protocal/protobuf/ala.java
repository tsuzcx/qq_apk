package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ala
  extends com.tencent.mm.bx.a
{
  public int CYH;
  public String GkS;
  public String GkT;
  public alb field_area_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.CYH);
      if (this.field_area_info != null)
      {
        paramVarArgs.lC(2, this.field_area_info.computeSize());
        this.field_area_info.writeFields(paramVarArgs);
      }
      if (this.GkS != null) {
        paramVarArgs.d(3, this.GkS);
      }
      if (this.GkT != null) {
        paramVarArgs.d(4, this.GkT);
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.CYH) + 0;
      paramInt = i;
      if (this.field_area_info != null) {
        paramInt = i + f.a.a.a.lB(2, this.field_area_info.computeSize());
      }
      i = paramInt;
      if (this.GkS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GkS);
      }
      paramInt = i;
      if (this.GkT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GkT);
      }
      AppMethodBeat.o(72475);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(72475);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ala localala = (ala)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72475);
        return -1;
      case 1: 
        localala.CYH = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(72475);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((alb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localala.field_area_info = ((alb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72475);
        return 0;
      case 3: 
        localala.GkS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72475);
        return 0;
      }
      localala.GkT = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(72475);
      return 0;
    }
    AppMethodBeat.o(72475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ala
 * JD-Core Version:    0.7.0.1
 */
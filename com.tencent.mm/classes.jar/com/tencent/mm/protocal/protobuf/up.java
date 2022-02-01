package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class up
  extends com.tencent.mm.bw.a
{
  public int LdV;
  public String LdW;
  public String LdX;
  public String LdY;
  public int LdZ;
  public String Lea;
  public un Leb;
  public String Lec;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113967);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LdV);
      if (this.LdW != null) {
        paramVarArgs.e(2, this.LdW);
      }
      if (this.LdX != null) {
        paramVarArgs.e(3, this.LdX);
      }
      if (this.LdY != null) {
        paramVarArgs.e(4, this.LdY);
      }
      paramVarArgs.aM(5, this.LdZ);
      if (this.Lea != null) {
        paramVarArgs.e(6, this.Lea);
      }
      if (this.Leb != null)
      {
        paramVarArgs.ni(7, this.Leb.computeSize());
        this.Leb.writeFields(paramVarArgs);
      }
      if (this.Lec != null) {
        paramVarArgs.e(8, this.Lec);
      }
      AppMethodBeat.o(113967);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LdV) + 0;
      paramInt = i;
      if (this.LdW != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LdW);
      }
      i = paramInt;
      if (this.LdX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LdX);
      }
      paramInt = i;
      if (this.LdY != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LdY);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.LdZ);
      paramInt = i;
      if (this.Lea != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lea);
      }
      i = paramInt;
      if (this.Leb != null) {
        i = paramInt + g.a.a.a.nh(7, this.Leb.computeSize());
      }
      paramInt = i;
      if (this.Lec != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Lec);
      }
      AppMethodBeat.o(113967);
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
      AppMethodBeat.o(113967);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      up localup = (up)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113967);
        return -1;
      case 1: 
        localup.LdV = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(113967);
        return 0;
      case 2: 
        localup.LdW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 3: 
        localup.LdX = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 4: 
        localup.LdY = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 5: 
        localup.LdZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(113967);
        return 0;
      case 6: 
        localup.Lea = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new un();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localup.Leb = ((un)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113967);
        return 0;
      }
      localup.Lec = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(113967);
      return 0;
    }
    AppMethodBeat.o(113967);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.up
 * JD-Core Version:    0.7.0.1
 */
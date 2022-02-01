package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dny
  extends com.tencent.mm.bx.a
{
  public int FcU;
  public int HBV;
  public String HBW;
  public int HBX;
  public int HBY;
  public LinkedList<dod> HBZ;
  public boolean HCa;
  public boolean dmo;
  
  public dny()
  {
    AppMethodBeat.i(153003);
    this.HBZ = new LinkedList();
    AppMethodBeat.o(153003);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153004);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HBV);
      if (this.HBW != null) {
        paramVarArgs.d(2, this.HBW);
      }
      paramVarArgs.aS(3, this.FcU);
      paramVarArgs.aS(4, this.HBX);
      paramVarArgs.aS(5, this.HBY);
      paramVarArgs.e(6, 8, this.HBZ);
      paramVarArgs.bt(7, this.HCa);
      paramVarArgs.bt(8, this.dmo);
      AppMethodBeat.o(153004);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HBV) + 0;
      paramInt = i;
      if (this.HBW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HBW);
      }
      i = f.a.a.b.b.a.bz(3, this.FcU);
      int j = f.a.a.b.b.a.bz(4, this.HBX);
      int k = f.a.a.b.b.a.bz(5, this.HBY);
      int m = f.a.a.a.c(6, 8, this.HBZ);
      int n = f.a.a.b.b.a.alV(7);
      int i1 = f.a.a.b.b.a.alV(8);
      AppMethodBeat.o(153004);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HBZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(153004);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dny localdny = (dny)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153004);
        return -1;
      case 1: 
        localdny.HBV = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153004);
        return 0;
      case 2: 
        localdny.HBW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(153004);
        return 0;
      case 3: 
        localdny.FcU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153004);
        return 0;
      case 4: 
        localdny.HBX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153004);
        return 0;
      case 5: 
        localdny.HBY = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(153004);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dod();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdny.HBZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153004);
        return 0;
      case 7: 
        localdny.HCa = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(153004);
        return 0;
      }
      localdny.dmo = ((f.a.a.a.a)localObject1).NPN.grw();
      AppMethodBeat.o(153004);
      return 0;
    }
    AppMethodBeat.o(153004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dny
 * JD-Core Version:    0.7.0.1
 */
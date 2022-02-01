package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmy
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> HBk;
  public int HBl;
  public LinkedList<ccx> HfM;
  public String HfN;
  public String duW;
  public String dxD;
  public int version;
  
  public dmy()
  {
    AppMethodBeat.i(176151);
    this.HBk = new LinkedList();
    this.HfM = new LinkedList();
    AppMethodBeat.o(176151);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176152);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.HBk);
      paramVarArgs.e(2, 8, this.HfM);
      if (this.dxD != null) {
        paramVarArgs.d(3, this.dxD);
      }
      paramVarArgs.aS(4, this.HBl);
      if (this.HfN != null) {
        paramVarArgs.d(5, this.HfN);
      }
      if (this.duW != null) {
        paramVarArgs.d(6, this.duW);
      }
      paramVarArgs.aS(7, this.version);
      AppMethodBeat.o(176152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 1, this.HBk) + 0 + f.a.a.a.c(2, 8, this.HfM);
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dxD);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HBl);
      paramInt = i;
      if (this.HfN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HfN);
      }
      i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.duW);
      }
      paramInt = f.a.a.b.b.a.bz(7, this.version);
      AppMethodBeat.o(176152);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HBk.clear();
      this.HfM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(176152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dmy localdmy = (dmy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176152);
        return -1;
      case 1: 
        localdmy.HBk.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(176152);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ccx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdmy.HfM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176152);
        return 0;
      case 3: 
        localdmy.dxD = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 4: 
        localdmy.HBl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(176152);
        return 0;
      case 5: 
        localdmy.HfN = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 6: 
        localdmy.duW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(176152);
        return 0;
      }
      localdmy.version = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(176152);
      return 0;
    }
    AppMethodBeat.o(176152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmy
 * JD-Core Version:    0.7.0.1
 */
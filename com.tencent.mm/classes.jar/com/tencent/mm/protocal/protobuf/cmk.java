package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmk
  extends com.tencent.mm.bx.a
{
  public boolean GAI;
  public int GXe;
  public LinkedList<ccx> HfM;
  public String HfN;
  public String dxD;
  public String ozD;
  
  public cmk()
  {
    AppMethodBeat.i(176148);
    this.HfM = new LinkedList();
    AppMethodBeat.o(176148);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176149);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.HfM);
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      if (this.HfN != null) {
        paramVarArgs.d(3, this.HfN);
      }
      if (this.ozD != null) {
        paramVarArgs.d(4, this.ozD);
      }
      paramVarArgs.bt(5, this.GAI);
      paramVarArgs.aS(6, this.GXe);
      AppMethodBeat.o(176149);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.HfM) + 0;
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxD);
      }
      i = paramInt;
      if (this.HfN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HfN);
      }
      paramInt = i;
      if (this.ozD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ozD);
      }
      i = f.a.a.b.b.a.alV(5);
      int j = f.a.a.b.b.a.bz(6, this.GXe);
      AppMethodBeat.o(176149);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HfM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(176149);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cmk localcmk = (cmk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176149);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ccx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcmk.HfM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176149);
        return 0;
      case 2: 
        localcmk.dxD = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 3: 
        localcmk.HfN = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 4: 
        localcmk.ozD = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 5: 
        localcmk.GAI = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(176149);
        return 0;
      }
      localcmk.GXe = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(176149);
      return 0;
    }
    AppMethodBeat.o(176149);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmk
 * JD-Core Version:    0.7.0.1
 */
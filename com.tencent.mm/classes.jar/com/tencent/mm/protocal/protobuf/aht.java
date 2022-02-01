package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aht
  extends com.tencent.mm.bx.a
{
  public int Dko;
  public b Lxj;
  public int Lxk;
  public dxo Lxl;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168937);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dko);
      paramVarArgs.aR(2, this.scene);
      if (this.Lxj != null) {
        paramVarArgs.c(3, this.Lxj);
      }
      paramVarArgs.aR(4, this.Lxk);
      if (this.Lxl != null)
      {
        paramVarArgs.kX(5, this.Lxl.computeSize());
        this.Lxl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168937);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Dko) + 0 + f.a.a.b.b.a.bA(2, this.scene);
      paramInt = i;
      if (this.Lxj != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Lxj);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Lxk);
      paramInt = i;
      if (this.Lxl != null) {
        paramInt = i + f.a.a.a.kW(5, this.Lxl.computeSize());
      }
      AppMethodBeat.o(168937);
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
      AppMethodBeat.o(168937);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aht localaht = (aht)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168937);
        return -1;
      case 1: 
        localaht.Dko = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168937);
        return 0;
      case 2: 
        localaht.scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168937);
        return 0;
      case 3: 
        localaht.Lxj = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(168937);
        return 0;
      case 4: 
        localaht.Lxk = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(168937);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dxo();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dxo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaht.Lxl = ((dxo)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(168937);
      return 0;
    }
    AppMethodBeat.o(168937);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aht
 * JD-Core Version:    0.7.0.1
 */
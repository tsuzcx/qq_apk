package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ee
  extends com.tencent.mm.bx.a
{
  public int FoM;
  public String value;
  public boolean yhD;
  public boolean yhE;
  public boolean yhl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50078);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FoM);
      if (this.value != null) {
        paramVarArgs.d(2, this.value);
      }
      paramVarArgs.bt(3, this.yhD);
      paramVarArgs.bt(4, this.yhl);
      paramVarArgs.bt(5, this.yhE);
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FoM) + 0;
      paramInt = i;
      if (this.value != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.value);
      }
      i = f.a.a.b.b.a.alV(3);
      int j = f.a.a.b.b.a.alV(4);
      int k = f.a.a.b.b.a.alV(5);
      AppMethodBeat.o(50078);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ee localee = (ee)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50078);
        return -1;
      case 1: 
        localee.FoM = locala.NPN.zc();
        AppMethodBeat.o(50078);
        return 0;
      case 2: 
        localee.value = locala.NPN.readString();
        AppMethodBeat.o(50078);
        return 0;
      case 3: 
        localee.yhD = locala.NPN.grw();
        AppMethodBeat.o(50078);
        return 0;
      case 4: 
        localee.yhl = locala.NPN.grw();
        AppMethodBeat.o(50078);
        return 0;
      }
      localee.yhE = locala.NPN.grw();
      AppMethodBeat.o(50078);
      return 0;
    }
    AppMethodBeat.o(50078);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ee
 * JD-Core Version:    0.7.0.1
 */
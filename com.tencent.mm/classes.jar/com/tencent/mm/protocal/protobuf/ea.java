package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ea
  extends com.tencent.mm.bw.a
{
  public int DJF;
  public String value;
  public boolean wTB;
  public boolean wTX;
  public boolean wTY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50078);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DJF);
      if (this.value != null) {
        paramVarArgs.d(2, this.value);
      }
      paramVarArgs.bl(3, this.wTX);
      paramVarArgs.bl(4, this.wTB);
      paramVarArgs.bl(5, this.wTY);
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.DJF) + 0;
      paramInt = i;
      if (this.value != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.value);
      }
      i = f.a.a.b.b.a.fK(3);
      int j = f.a.a.b.b.a.fK(4);
      int k = f.a.a.b.b.a.fK(5);
      AppMethodBeat.o(50078);
      return paramInt + (i + 1) + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ea localea = (ea)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50078);
        return -1;
      case 1: 
        localea.DJF = locala.LVo.xF();
        AppMethodBeat.o(50078);
        return 0;
      case 2: 
        localea.value = locala.LVo.readString();
        AppMethodBeat.o(50078);
        return 0;
      case 3: 
        localea.wTX = locala.LVo.fZX();
        AppMethodBeat.o(50078);
        return 0;
      case 4: 
        localea.wTB = locala.LVo.fZX();
        AppMethodBeat.o(50078);
        return 0;
      }
      localea.wTY = locala.LVo.fZX();
      AppMethodBeat.o(50078);
      return 0;
    }
    AppMethodBeat.o(50078);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ea
 * JD-Core Version:    0.7.0.1
 */
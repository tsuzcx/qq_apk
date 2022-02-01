package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mg
  extends com.tencent.mm.bw.a
{
  public int EaY;
  public int EaZ;
  public int Eba;
  public String Ebb;
  public String Ebc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EaY);
      paramVarArgs.aR(2, this.EaZ);
      paramVarArgs.aR(3, this.Eba);
      if (this.Ebb != null) {
        paramVarArgs.d(4, this.Ebb);
      }
      if (this.Ebc != null) {
        paramVarArgs.d(5, this.Ebc);
      }
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.EaY) + 0 + f.a.a.b.b.a.bx(2, this.EaZ) + f.a.a.b.b.a.bx(3, this.Eba);
      paramInt = i;
      if (this.Ebb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ebb);
      }
      i = paramInt;
      if (this.Ebc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ebc);
      }
      AppMethodBeat.o(124410);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124410);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      mg localmg = (mg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124410);
        return -1;
      case 1: 
        localmg.EaY = locala.LVo.xF();
        AppMethodBeat.o(124410);
        return 0;
      case 2: 
        localmg.EaZ = locala.LVo.xF();
        AppMethodBeat.o(124410);
        return 0;
      case 3: 
        localmg.Eba = locala.LVo.xF();
        AppMethodBeat.o(124410);
        return 0;
      case 4: 
        localmg.Ebb = locala.LVo.readString();
        AppMethodBeat.o(124410);
        return 0;
      }
      localmg.Ebc = locala.LVo.readString();
      AppMethodBeat.o(124410);
      return 0;
    }
    AppMethodBeat.o(124410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mg
 * JD-Core Version:    0.7.0.1
 */
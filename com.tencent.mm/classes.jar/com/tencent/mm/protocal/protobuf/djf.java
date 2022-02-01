package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djf
  extends com.tencent.mm.bx.a
{
  public int HxZ;
  public String Hya;
  public String Hyb;
  public String Hyc;
  public String Hyd;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168761);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HxZ);
      if (this.Hya != null) {
        paramVarArgs.d(2, this.Hya);
      }
      if (this.Hyb != null) {
        paramVarArgs.d(3, this.Hyb);
      }
      paramVarArgs.aS(4, this.height);
      paramVarArgs.aS(5, this.width);
      if (this.Hyc != null) {
        paramVarArgs.d(6, this.Hyc);
      }
      if (this.Hyd != null) {
        paramVarArgs.d(7, this.Hyd);
      }
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HxZ) + 0;
      paramInt = i;
      if (this.Hya != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hya);
      }
      i = paramInt;
      if (this.Hyb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hyb);
      }
      i = i + f.a.a.b.b.a.bz(4, this.height) + f.a.a.b.b.a.bz(5, this.width);
      paramInt = i;
      if (this.Hyc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hyc);
      }
      i = paramInt;
      if (this.Hyd != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Hyd);
      }
      AppMethodBeat.o(168761);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      djf localdjf = (djf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168761);
        return -1;
      case 1: 
        localdjf.HxZ = locala.NPN.zc();
        AppMethodBeat.o(168761);
        return 0;
      case 2: 
        localdjf.Hya = locala.NPN.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 3: 
        localdjf.Hyb = locala.NPN.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 4: 
        localdjf.height = locala.NPN.zc();
        AppMethodBeat.o(168761);
        return 0;
      case 5: 
        localdjf.width = locala.NPN.zc();
        AppMethodBeat.o(168761);
        return 0;
      case 6: 
        localdjf.Hyc = locala.NPN.readString();
        AppMethodBeat.o(168761);
        return 0;
      }
      localdjf.Hyd = locala.NPN.readString();
      AppMethodBeat.o(168761);
      return 0;
    }
    AppMethodBeat.o(168761);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djf
 * JD-Core Version:    0.7.0.1
 */
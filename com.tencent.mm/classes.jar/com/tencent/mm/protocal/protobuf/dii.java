package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dii
  extends com.tencent.mm.bx.a
{
  public String Fml;
  public String Hxd;
  public int Hxe;
  public int dnh;
  public String zMp;
  public int zvv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125845);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.zvv);
      if (this.Hxd != null) {
        paramVarArgs.d(2, this.Hxd);
      }
      if (this.Fml != null) {
        paramVarArgs.d(3, this.Fml);
      }
      paramVarArgs.aS(4, this.dnh);
      if (this.zMp != null) {
        paramVarArgs.d(5, this.zMp);
      }
      paramVarArgs.aS(6, this.Hxe);
      AppMethodBeat.o(125845);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.zvv) + 0;
      paramInt = i;
      if (this.Hxd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hxd);
      }
      i = paramInt;
      if (this.Fml != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fml);
      }
      i += f.a.a.b.b.a.bz(4, this.dnh);
      paramInt = i;
      if (this.zMp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.zMp);
      }
      i = f.a.a.b.b.a.bz(6, this.Hxe);
      AppMethodBeat.o(125845);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125845);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dii localdii = (dii)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125845);
        return -1;
      case 1: 
        localdii.zvv = locala.NPN.zc();
        AppMethodBeat.o(125845);
        return 0;
      case 2: 
        localdii.Hxd = locala.NPN.readString();
        AppMethodBeat.o(125845);
        return 0;
      case 3: 
        localdii.Fml = locala.NPN.readString();
        AppMethodBeat.o(125845);
        return 0;
      case 4: 
        localdii.dnh = locala.NPN.zc();
        AppMethodBeat.o(125845);
        return 0;
      case 5: 
        localdii.zMp = locala.NPN.readString();
        AppMethodBeat.o(125845);
        return 0;
      }
      localdii.Hxe = locala.NPN.zc();
      AppMethodBeat.o(125845);
      return 0;
    }
    AppMethodBeat.o(125845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dii
 * JD-Core Version:    0.7.0.1
 */
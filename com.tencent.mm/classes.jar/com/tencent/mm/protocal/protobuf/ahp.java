package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahp
  extends com.tencent.mm.bx.a
{
  public int GeZ;
  public int Gfa;
  public int Gfb;
  public String Gfc;
  public int Gfd;
  public String Gfe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122488);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GeZ);
      paramVarArgs.aS(2, this.Gfa);
      paramVarArgs.aS(3, this.Gfb);
      if (this.Gfc != null) {
        paramVarArgs.d(4, this.Gfc);
      }
      paramVarArgs.aS(5, this.Gfd);
      if (this.Gfe != null) {
        paramVarArgs.d(6, this.Gfe);
      }
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GeZ) + 0 + f.a.a.b.b.a.bz(2, this.Gfa) + f.a.a.b.b.a.bz(3, this.Gfb);
      paramInt = i;
      if (this.Gfc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gfc);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Gfd);
      paramInt = i;
      if (this.Gfe != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gfe);
      }
      AppMethodBeat.o(122488);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(122488);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahp localahp = (ahp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122488);
        return -1;
      case 1: 
        localahp.GeZ = locala.NPN.zc();
        AppMethodBeat.o(122488);
        return 0;
      case 2: 
        localahp.Gfa = locala.NPN.zc();
        AppMethodBeat.o(122488);
        return 0;
      case 3: 
        localahp.Gfb = locala.NPN.zc();
        AppMethodBeat.o(122488);
        return 0;
      case 4: 
        localahp.Gfc = locala.NPN.readString();
        AppMethodBeat.o(122488);
        return 0;
      case 5: 
        localahp.Gfd = locala.NPN.zc();
        AppMethodBeat.o(122488);
        return 0;
      }
      localahp.Gfe = locala.NPN.readString();
      AppMethodBeat.o(122488);
      return 0;
    }
    AppMethodBeat.o(122488);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahp
 * JD-Core Version:    0.7.0.1
 */
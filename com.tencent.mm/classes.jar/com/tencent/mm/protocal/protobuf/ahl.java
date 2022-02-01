package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahl
  extends com.tencent.mm.bx.a
{
  public int GeZ;
  public int Gfa;
  public int Gfb;
  public String Gfc;
  public int Gfd;
  public String Gfe;
  public int Gff;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210590);
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
      paramVarArgs.aS(7, this.Gff);
      AppMethodBeat.o(210590);
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
      i = f.a.a.b.b.a.bz(7, this.Gff);
      AppMethodBeat.o(210590);
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
      AppMethodBeat.o(210590);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahl localahl = (ahl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(210590);
        return -1;
      case 1: 
        localahl.GeZ = locala.NPN.zc();
        AppMethodBeat.o(210590);
        return 0;
      case 2: 
        localahl.Gfa = locala.NPN.zc();
        AppMethodBeat.o(210590);
        return 0;
      case 3: 
        localahl.Gfb = locala.NPN.zc();
        AppMethodBeat.o(210590);
        return 0;
      case 4: 
        localahl.Gfc = locala.NPN.readString();
        AppMethodBeat.o(210590);
        return 0;
      case 5: 
        localahl.Gfd = locala.NPN.zc();
        AppMethodBeat.o(210590);
        return 0;
      case 6: 
        localahl.Gfe = locala.NPN.readString();
        AppMethodBeat.o(210590);
        return 0;
      }
      localahl.Gff = locala.NPN.zc();
      AppMethodBeat.o(210590);
      return 0;
    }
    AppMethodBeat.o(210590);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahl
 * JD-Core Version:    0.7.0.1
 */
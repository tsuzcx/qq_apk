package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clt
  extends com.tencent.mm.bw.a
{
  public String KZj;
  public String MaZ;
  public long Mre;
  public long Mrf;
  public int oUv;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117876);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.scene);
      if (this.MaZ != null) {
        paramVarArgs.e(2, this.MaZ);
      }
      paramVarArgs.bb(3, this.Mre);
      paramVarArgs.bb(4, this.Mrf);
      if (this.KZj != null) {
        paramVarArgs.e(5, this.KZj);
      }
      paramVarArgs.aM(6, this.oUv);
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.scene) + 0;
      paramInt = i;
      if (this.MaZ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MaZ);
      }
      i = paramInt + g.a.a.b.b.a.r(3, this.Mre) + g.a.a.b.b.a.r(4, this.Mrf);
      paramInt = i;
      if (this.KZj != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KZj);
      }
      i = g.a.a.b.b.a.bu(6, this.oUv);
      AppMethodBeat.o(117876);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      clt localclt = (clt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117876);
        return -1;
      case 1: 
        localclt.scene = locala.UbS.zi();
        AppMethodBeat.o(117876);
        return 0;
      case 2: 
        localclt.MaZ = locala.UbS.readString();
        AppMethodBeat.o(117876);
        return 0;
      case 3: 
        localclt.Mre = locala.UbS.zl();
        AppMethodBeat.o(117876);
        return 0;
      case 4: 
        localclt.Mrf = locala.UbS.zl();
        AppMethodBeat.o(117876);
        return 0;
      case 5: 
        localclt.KZj = locala.UbS.readString();
        AppMethodBeat.o(117876);
        return 0;
      }
      localclt.oUv = locala.UbS.zi();
      AppMethodBeat.o(117876);
      return 0;
    }
    AppMethodBeat.o(117876);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clt
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czg
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b Gdx;
  public int HpW;
  public int HpX;
  public int HpY;
  public int HpZ;
  public int Hqa;
  public int Hqb;
  public int Hqc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gdx == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.HpW);
      paramVarArgs.aS(2, this.HpX);
      paramVarArgs.aS(3, this.HpY);
      paramVarArgs.aS(4, this.HpZ);
      paramVarArgs.aS(5, this.Hqa);
      paramVarArgs.aS(6, this.Hqb);
      paramVarArgs.aS(7, this.Hqc);
      if (this.Gdx != null) {
        paramVarArgs.c(8, this.Gdx);
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HpW) + 0 + f.a.a.b.b.a.bz(2, this.HpX) + f.a.a.b.b.a.bz(3, this.HpY) + f.a.a.b.b.a.bz(4, this.HpZ) + f.a.a.b.b.a.bz(5, this.Hqa) + f.a.a.b.b.a.bz(6, this.Hqb) + f.a.a.b.b.a.bz(7, this.Hqc);
      paramInt = i;
      if (this.Gdx != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.Gdx);
      }
      AppMethodBeat.o(32425);
      return paramInt;
    }
    f.a.a.a.a locala;
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      locala = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(locala); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(locala)) {
        if (!super.populateBuilderWithField(locala, this, paramInt)) {
          locala.gxE();
        }
      }
      if (paramVarArgs == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 3)
    {
      locala = (f.a.a.a.a)paramVarArgs[0];
      czg localczg = (czg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32425);
        return -1;
      case 1: 
        localczg.HpW = locala.NPN.zc();
        AppMethodBeat.o(32425);
        return 0;
      case 2: 
        localczg.HpX = locala.NPN.zc();
        AppMethodBeat.o(32425);
        return 0;
      case 3: 
        localczg.HpY = locala.NPN.zc();
        AppMethodBeat.o(32425);
        return 0;
      case 4: 
        localczg.HpZ = locala.NPN.zc();
        AppMethodBeat.o(32425);
        return 0;
      case 5: 
        localczg.Hqa = locala.NPN.zc();
        AppMethodBeat.o(32425);
        return 0;
      case 6: 
        localczg.Hqb = locala.NPN.zc();
        AppMethodBeat.o(32425);
        return 0;
      case 7: 
        localczg.Hqc = locala.NPN.zc();
        AppMethodBeat.o(32425);
        return 0;
      }
      localczg.Gdx = locala.NPN.gxI();
      AppMethodBeat.o(32425);
      return 0;
    }
    AppMethodBeat.o(32425);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czg
 * JD-Core Version:    0.7.0.1
 */
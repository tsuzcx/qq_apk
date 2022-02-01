package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akf
  extends com.tencent.mm.bx.a
{
  public int dJI;
  public int index;
  public int ooi;
  public String query;
  public String rsG;
  public int scene;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.scene);
      paramVarArgs.aS(2, this.ooi);
      paramVarArgs.aS(3, this.index);
      if (this.sessionId != null) {
        paramVarArgs.d(4, this.sessionId);
      }
      if (this.query != null) {
        paramVarArgs.d(5, this.query);
      }
      if (this.rsG != null) {
        paramVarArgs.d(6, this.rsG);
      }
      paramVarArgs.aS(7, this.dJI);
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.scene) + 0 + f.a.a.b.b.a.bz(2, this.ooi) + f.a.a.b.b.a.bz(3, this.index);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sessionId);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.query);
      }
      paramInt = i;
      if (this.rsG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.rsG);
      }
      i = f.a.a.b.b.a.bz(7, this.dJI);
      AppMethodBeat.o(127475);
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
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      akf localakf = (akf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127475);
        return -1;
      case 1: 
        localakf.scene = locala.NPN.zc();
        AppMethodBeat.o(127475);
        return 0;
      case 2: 
        localakf.ooi = locala.NPN.zc();
        AppMethodBeat.o(127475);
        return 0;
      case 3: 
        localakf.index = locala.NPN.zc();
        AppMethodBeat.o(127475);
        return 0;
      case 4: 
        localakf.sessionId = locala.NPN.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 5: 
        localakf.query = locala.NPN.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 6: 
        localakf.rsG = locala.NPN.readString();
        AppMethodBeat.o(127475);
        return 0;
      }
      localakf.dJI = locala.NPN.zc();
      AppMethodBeat.o(127475);
      return 0;
    }
    AppMethodBeat.o(127475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akf
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acl
  extends com.tencent.mm.bv.a
{
  public int jJS;
  public int woD;
  public int woE;
  public int woF;
  public int woG;
  public String woJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51401);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.woD);
      paramVarArgs.aO(2, this.jJS);
      if (this.woJ != null) {
        paramVarArgs.e(3, this.woJ);
      }
      paramVarArgs.aO(4, this.woE);
      paramVarArgs.aO(5, this.woF);
      paramVarArgs.aO(6, this.woG);
      AppMethodBeat.o(51401);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.woD) + 0 + e.a.a.b.b.a.bl(2, this.jJS);
      paramInt = i;
      if (this.woJ != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.woJ);
      }
      i = e.a.a.b.b.a.bl(4, this.woE);
      int j = e.a.a.b.b.a.bl(5, this.woF);
      int k = e.a.a.b.b.a.bl(6, this.woG);
      AppMethodBeat.o(51401);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(51401);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      acl localacl = (acl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(51401);
        return -1;
      case 1: 
        localacl.woD = locala.CLY.sl();
        AppMethodBeat.o(51401);
        return 0;
      case 2: 
        localacl.jJS = locala.CLY.sl();
        AppMethodBeat.o(51401);
        return 0;
      case 3: 
        localacl.woJ = locala.CLY.readString();
        AppMethodBeat.o(51401);
        return 0;
      case 4: 
        localacl.woE = locala.CLY.sl();
        AppMethodBeat.o(51401);
        return 0;
      case 5: 
        localacl.woF = locala.CLY.sl();
        AppMethodBeat.o(51401);
        return 0;
      }
      localacl.woG = locala.CLY.sl();
      AppMethodBeat.o(51401);
      return 0;
    }
    AppMethodBeat.o(51401);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acl
 * JD-Core Version:    0.7.0.1
 */
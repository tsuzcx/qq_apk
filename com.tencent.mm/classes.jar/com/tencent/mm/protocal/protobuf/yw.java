package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yw
  extends com.tencent.mm.bw.a
{
  public int EsZ;
  public int Eta;
  public String Etb;
  public String dbo;
  public String dbp;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32169);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.version);
      paramVarArgs.aR(2, this.EsZ);
      paramVarArgs.aR(3, this.Eta);
      if (this.dbp != null) {
        paramVarArgs.d(4, this.dbp);
      }
      if (this.Etb != null) {
        paramVarArgs.d(5, this.Etb);
      }
      if (this.dbo != null) {
        paramVarArgs.d(6, this.dbo);
      }
      AppMethodBeat.o(32169);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.version) + 0 + f.a.a.b.b.a.bx(2, this.EsZ) + f.a.a.b.b.a.bx(3, this.Eta);
      paramInt = i;
      if (this.dbp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dbp);
      }
      i = paramInt;
      if (this.Etb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Etb);
      }
      paramInt = i;
      if (this.dbo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dbo);
      }
      AppMethodBeat.o(32169);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32169);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      yw localyw = (yw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32169);
        return -1;
      case 1: 
        localyw.version = locala.LVo.xF();
        AppMethodBeat.o(32169);
        return 0;
      case 2: 
        localyw.EsZ = locala.LVo.xF();
        AppMethodBeat.o(32169);
        return 0;
      case 3: 
        localyw.Eta = locala.LVo.xF();
        AppMethodBeat.o(32169);
        return 0;
      case 4: 
        localyw.dbp = locala.LVo.readString();
        AppMethodBeat.o(32169);
        return 0;
      case 5: 
        localyw.Etb = locala.LVo.readString();
        AppMethodBeat.o(32169);
        return 0;
      }
      localyw.dbo = locala.LVo.readString();
      AppMethodBeat.o(32169);
      return 0;
    }
    AppMethodBeat.o(32169);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yw
 * JD-Core Version:    0.7.0.1
 */
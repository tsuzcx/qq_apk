package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbc
  extends com.tencent.mm.bw.a
{
  public float FKm;
  public float FKn;
  public float FKo;
  public float FKp;
  public int FKq;
  public long FKr;
  public long FKs;
  public float bOt;
  public int yAZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125812);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.FKm);
      paramVarArgs.x(2, this.FKn);
      paramVarArgs.x(3, this.FKo);
      paramVarArgs.x(4, this.FKp);
      paramVarArgs.aR(5, this.FKq);
      paramVarArgs.aO(6, this.FKr);
      paramVarArgs.aO(7, this.FKs);
      paramVarArgs.x(8, this.bOt);
      paramVarArgs.aR(9, this.yAZ);
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.bx(5, this.FKq);
      int n = f.a.a.b.b.a.p(6, this.FKr);
      int i1 = f.a.a.b.b.a.p(7, this.FKs);
      int i2 = f.a.a.b.b.a.fK(8);
      int i3 = f.a.a.b.b.a.bx(9, this.yAZ);
      AppMethodBeat.o(125812);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + m + n + i1 + (i2 + 4) + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dbc localdbc = (dbc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125812);
        return -1;
      case 1: 
        localdbc.FKm = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125812);
        return 0;
      case 2: 
        localdbc.FKn = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125812);
        return 0;
      case 3: 
        localdbc.FKo = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125812);
        return 0;
      case 4: 
        localdbc.FKp = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125812);
        return 0;
      case 5: 
        localdbc.FKq = locala.LVo.xF();
        AppMethodBeat.o(125812);
        return 0;
      case 6: 
        localdbc.FKr = locala.LVo.xG();
        AppMethodBeat.o(125812);
        return 0;
      case 7: 
        localdbc.FKs = locala.LVo.xG();
        AppMethodBeat.o(125812);
        return 0;
      case 8: 
        localdbc.bOt = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(125812);
        return 0;
      }
      localdbc.yAZ = locala.LVo.xF();
      AppMethodBeat.o(125812);
      return 0;
    }
    AppMethodBeat.o(125812);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbc
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhj
  extends com.tencent.mm.bw.a
{
  public int Ajv;
  public float HOA;
  public int HOB;
  public long HOC;
  public long HOD;
  public float HOx;
  public float HOy;
  public float HOz;
  public float bYG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125812);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.y(1, this.HOx);
      paramVarArgs.y(2, this.HOy);
      paramVarArgs.y(3, this.HOz);
      paramVarArgs.y(4, this.HOA);
      paramVarArgs.aS(5, this.HOB);
      paramVarArgs.aZ(6, this.HOC);
      paramVarArgs.aZ(7, this.HOD);
      paramVarArgs.y(8, this.bYG);
      paramVarArgs.aS(9, this.Ajv);
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amE(1);
      int i = f.a.a.b.b.a.amE(2);
      int j = f.a.a.b.b.a.amE(3);
      int k = f.a.a.b.b.a.amE(4);
      int m = f.a.a.b.b.a.bz(5, this.HOB);
      int n = f.a.a.b.b.a.p(6, this.HOC);
      int i1 = f.a.a.b.b.a.p(7, this.HOD);
      int i2 = f.a.a.b.b.a.amE(8);
      int i3 = f.a.a.b.b.a.bz(9, this.Ajv);
      AppMethodBeat.o(125812);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dhj localdhj = (dhj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125812);
        return -1;
      case 1: 
        localdhj.HOx = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125812);
        return 0;
      case 2: 
        localdhj.HOy = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125812);
        return 0;
      case 3: 
        localdhj.HOz = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125812);
        return 0;
      case 4: 
        localdhj.HOA = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125812);
        return 0;
      case 5: 
        localdhj.HOB = locala.OmT.zc();
        AppMethodBeat.o(125812);
        return 0;
      case 6: 
        localdhj.HOC = locala.OmT.zd();
        AppMethodBeat.o(125812);
        return 0;
      case 7: 
        localdhj.HOD = locala.OmT.zd();
        AppMethodBeat.o(125812);
        return 0;
      case 8: 
        localdhj.bYG = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125812);
        return 0;
      }
      localdhj.Ajv = locala.OmT.zc();
      AppMethodBeat.o(125812);
      return 0;
    }
    AppMethodBeat.o(125812);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhj
 * JD-Core Version:    0.7.0.1
 */
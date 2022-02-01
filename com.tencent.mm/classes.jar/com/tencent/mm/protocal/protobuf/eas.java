package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eas
  extends com.tencent.mm.bw.a
{
  public int Esd;
  public float Nai;
  public float Naj;
  public float Nak;
  public float Nal;
  public int Nam;
  public long Nan;
  public long Nao;
  public float cjn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125812);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.E(1, this.Nai);
      paramVarArgs.E(2, this.Naj);
      paramVarArgs.E(3, this.Nak);
      paramVarArgs.E(4, this.Nal);
      paramVarArgs.aM(5, this.Nam);
      paramVarArgs.bb(6, this.Nan);
      paramVarArgs.bb(7, this.Nao);
      paramVarArgs.E(8, this.cjn);
      paramVarArgs.aM(9, this.Esd);
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.bu(5, this.Nam);
      int n = g.a.a.b.b.a.r(6, this.Nan);
      int i1 = g.a.a.b.b.a.r(7, this.Nao);
      int i2 = g.a.a.b.b.a.fS(8);
      int i3 = g.a.a.b.b.a.bu(9, this.Esd);
      AppMethodBeat.o(125812);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + m + n + i1 + (i2 + 4) + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eas localeas = (eas)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125812);
        return -1;
      case 1: 
        localeas.Nai = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(125812);
        return 0;
      case 2: 
        localeas.Naj = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(125812);
        return 0;
      case 3: 
        localeas.Nak = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(125812);
        return 0;
      case 4: 
        localeas.Nal = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(125812);
        return 0;
      case 5: 
        localeas.Nam = locala.UbS.zi();
        AppMethodBeat.o(125812);
        return 0;
      case 6: 
        localeas.Nan = locala.UbS.zl();
        AppMethodBeat.o(125812);
        return 0;
      case 7: 
        localeas.Nao = locala.UbS.zl();
        AppMethodBeat.o(125812);
        return 0;
      case 8: 
        localeas.cjn = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(125812);
        return 0;
      }
      localeas.Esd = locala.UbS.zi();
      AppMethodBeat.o(125812);
      return 0;
    }
    AppMethodBeat.o(125812);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eas
 * JD-Core Version:    0.7.0.1
 */
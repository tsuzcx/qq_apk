package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eba
  extends com.tencent.mm.bw.a
{
  public float FMK;
  public String GsH;
  public String IgI;
  public String IgJ;
  public String IgK;
  public int IgL;
  public float IgM;
  public String IgN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147791);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IgI != null) {
        paramVarArgs.d(1, this.IgI);
      }
      if (this.GsH != null) {
        paramVarArgs.d(2, this.GsH);
      }
      if (this.IgJ != null) {
        paramVarArgs.d(3, this.IgJ);
      }
      if (this.IgK != null) {
        paramVarArgs.d(4, this.IgK);
      }
      paramVarArgs.aS(5, this.IgL);
      paramVarArgs.y(6, this.FMK);
      paramVarArgs.y(7, this.IgM);
      if (this.IgN != null) {
        paramVarArgs.d(8, this.IgN);
      }
      AppMethodBeat.o(147791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IgI == null) {
        break label588;
      }
    }
    label588:
    for (int i = f.a.a.b.b.a.e(1, this.IgI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GsH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GsH);
      }
      i = paramInt;
      if (this.IgJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IgJ);
      }
      paramInt = i;
      if (this.IgK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IgK);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.IgL) + f.a.a.b.b.a.amE(6) + f.a.a.b.b.a.amE(7);
      paramInt = i;
      if (this.IgN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.IgN);
      }
      AppMethodBeat.o(147791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147791);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eba localeba = (eba)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147791);
          return -1;
        case 1: 
          localeba.IgI = locala.OmT.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 2: 
          localeba.GsH = locala.OmT.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 3: 
          localeba.IgJ = locala.OmT.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 4: 
          localeba.IgK = locala.OmT.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 5: 
          localeba.IgL = locala.OmT.zc();
          AppMethodBeat.o(147791);
          return 0;
        case 6: 
          localeba.FMK = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(147791);
          return 0;
        case 7: 
          localeba.IgM = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(147791);
          return 0;
        }
        localeba.IgN = locala.OmT.readString();
        AppMethodBeat.o(147791);
        return 0;
      }
      AppMethodBeat.o(147791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eba
 * JD-Core Version:    0.7.0.1
 */
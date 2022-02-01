package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clp
  extends com.tencent.mm.bw.a
{
  public float GgZ;
  public float Gha;
  public String Hdi;
  public String HxI;
  public String HxJ;
  public long HxK;
  public String jfX;
  public String jge;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117892);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HxI != null) {
        paramVarArgs.d(1, this.HxI);
      }
      if (this.jge != null) {
        paramVarArgs.d(2, this.jge);
      }
      if (this.jfX != null) {
        paramVarArgs.d(3, this.jfX);
      }
      if (this.Hdi != null) {
        paramVarArgs.d(4, this.Hdi);
      }
      paramVarArgs.y(5, this.Gha);
      paramVarArgs.y(6, this.GgZ);
      if (this.HxJ != null) {
        paramVarArgs.d(7, this.HxJ);
      }
      paramVarArgs.aZ(8, this.HxK);
      AppMethodBeat.o(117892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HxI == null) {
        break label588;
      }
    }
    label588:
    for (int i = f.a.a.b.b.a.e(1, this.HxI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jge != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jge);
      }
      i = paramInt;
      if (this.jfX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jfX);
      }
      paramInt = i;
      if (this.Hdi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hdi);
      }
      i = paramInt + f.a.a.b.b.a.amE(5) + f.a.a.b.b.a.amE(6);
      paramInt = i;
      if (this.HxJ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HxJ);
      }
      i = f.a.a.b.b.a.p(8, this.HxK);
      AppMethodBeat.o(117892);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117892);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        clp localclp = (clp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117892);
          return -1;
        case 1: 
          localclp.HxI = locala.OmT.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 2: 
          localclp.jge = locala.OmT.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 3: 
          localclp.jfX = locala.OmT.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 4: 
          localclp.Hdi = locala.OmT.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 5: 
          localclp.Gha = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(117892);
          return 0;
        case 6: 
          localclp.GgZ = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(117892);
          return 0;
        case 7: 
          localclp.HxJ = locala.OmT.readString();
          AppMethodBeat.o(117892);
          return 0;
        }
        localclp.HxK = locala.OmT.zd();
        AppMethodBeat.o(117892);
        return 0;
      }
      AppMethodBeat.o(117892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clp
 * JD-Core Version:    0.7.0.1
 */
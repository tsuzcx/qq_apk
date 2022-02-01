package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class di
  extends com.tencent.mm.bw.a
{
  public String FNZ;
  public String FOa;
  public String jfW;
  public String jfX;
  public String jge;
  public String nIJ;
  public String urL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91348);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.jge != null) {
        paramVarArgs.d(1, this.jge);
      }
      if (this.jfW != null) {
        paramVarArgs.d(2, this.jfW);
      }
      if (this.jfX != null) {
        paramVarArgs.d(3, this.jfX);
      }
      if (this.urL != null) {
        paramVarArgs.d(4, this.urL);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(5, this.nIJ);
      }
      if (this.FNZ != null) {
        paramVarArgs.d(6, this.FNZ);
      }
      if (this.FOa != null) {
        paramVarArgs.d(7, this.FOa);
      }
      AppMethodBeat.o(91348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jge == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.jge) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jfW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.jfW);
      }
      i = paramInt;
      if (this.jfX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jfX);
      }
      paramInt = i;
      if (this.urL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.urL);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nIJ);
      }
      paramInt = i;
      if (this.FNZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNZ);
      }
      i = paramInt;
      if (this.FOa != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FOa);
      }
      AppMethodBeat.o(91348);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91348);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        di localdi = (di)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91348);
          return -1;
        case 1: 
          localdi.jge = locala.OmT.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 2: 
          localdi.jfW = locala.OmT.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 3: 
          localdi.jfX = locala.OmT.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 4: 
          localdi.urL = locala.OmT.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 5: 
          localdi.nIJ = locala.OmT.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 6: 
          localdi.FNZ = locala.OmT.readString();
          AppMethodBeat.o(91348);
          return 0;
        }
        localdi.FOa = locala.OmT.readString();
        AppMethodBeat.o(91348);
        return 0;
      }
      AppMethodBeat.o(91348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.di
 * JD-Core Version:    0.7.0.1
 */
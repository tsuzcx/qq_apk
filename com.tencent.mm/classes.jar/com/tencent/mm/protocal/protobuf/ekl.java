package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ekl
  extends com.tencent.mm.bw.a
{
  public int Inx;
  public String Iny;
  public String ucL;
  public String uvR;
  public String uvT;
  public String uvU;
  public int uvV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152730);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Inx);
      if (this.ucL != null) {
        paramVarArgs.d(2, this.ucL);
      }
      if (this.uvR != null) {
        paramVarArgs.d(3, this.uvR);
      }
      if (this.Iny != null) {
        paramVarArgs.d(4, this.Iny);
      }
      if (this.uvT != null) {
        paramVarArgs.d(5, this.uvT);
      }
      if (this.uvU != null) {
        paramVarArgs.d(6, this.uvU);
      }
      paramVarArgs.aS(7, this.uvV);
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Inx) + 0;
      paramInt = i;
      if (this.ucL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ucL);
      }
      i = paramInt;
      if (this.uvR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvR);
      }
      paramInt = i;
      if (this.Iny != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Iny);
      }
      i = paramInt;
      if (this.uvT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.uvT);
      }
      paramInt = i;
      if (this.uvU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uvU);
      }
      i = f.a.a.b.b.a.bz(7, this.uvV);
      AppMethodBeat.o(152730);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ekl localekl = (ekl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152730);
        return -1;
      case 1: 
        localekl.Inx = locala.OmT.zc();
        AppMethodBeat.o(152730);
        return 0;
      case 2: 
        localekl.ucL = locala.OmT.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 3: 
        localekl.uvR = locala.OmT.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 4: 
        localekl.Iny = locala.OmT.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 5: 
        localekl.uvT = locala.OmT.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 6: 
        localekl.uvU = locala.OmT.readString();
        AppMethodBeat.o(152730);
        return 0;
      }
      localekl.uvV = locala.OmT.zc();
      AppMethodBeat.o(152730);
      return 0;
    }
    AppMethodBeat.o(152730);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekl
 * JD-Core Version:    0.7.0.1
 */
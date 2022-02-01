package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vb
  extends com.tencent.mm.bx.a
{
  public String CWU;
  public String CWV;
  public String CWW;
  public String CWX;
  public String CWY;
  public String CWZ;
  public int Scene;
  public int mBH;
  public String sul;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127628);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Scene);
      paramVarArgs.aR(2, this.mBH);
      if (this.CWU != null) {
        paramVarArgs.d(3, this.CWU);
      }
      if (this.CWV != null) {
        paramVarArgs.d(4, this.CWV);
      }
      if (this.sul != null) {
        paramVarArgs.d(5, this.sul);
      }
      if (this.CWW != null) {
        paramVarArgs.d(6, this.CWW);
      }
      if (this.CWX != null) {
        paramVarArgs.d(7, this.CWX);
      }
      if (this.CWY != null) {
        paramVarArgs.d(8, this.CWY);
      }
      if (this.CWZ != null) {
        paramVarArgs.d(9, this.CWZ);
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Scene) + 0 + f.a.a.b.b.a.bA(2, this.mBH);
      paramInt = i;
      if (this.CWU != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CWU);
      }
      i = paramInt;
      if (this.CWV != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CWV);
      }
      paramInt = i;
      if (this.sul != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sul);
      }
      i = paramInt;
      if (this.CWW != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CWW);
      }
      paramInt = i;
      if (this.CWX != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CWX);
      }
      i = paramInt;
      if (this.CWY != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CWY);
      }
      paramInt = i;
      if (this.CWZ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CWZ);
      }
      AppMethodBeat.o(127628);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      vb localvb = (vb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127628);
        return -1;
      case 1: 
        localvb.Scene = locala.KhF.xS();
        AppMethodBeat.o(127628);
        return 0;
      case 2: 
        localvb.mBH = locala.KhF.xS();
        AppMethodBeat.o(127628);
        return 0;
      case 3: 
        localvb.CWU = locala.KhF.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 4: 
        localvb.CWV = locala.KhF.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 5: 
        localvb.sul = locala.KhF.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 6: 
        localvb.CWW = locala.KhF.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 7: 
        localvb.CWX = locala.KhF.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 8: 
        localvb.CWY = locala.KhF.readString();
        AppMethodBeat.o(127628);
        return 0;
      }
      localvb.CWZ = locala.KhF.readString();
      AppMethodBeat.o(127628);
      return 0;
    }
    AppMethodBeat.o(127628);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vb
 * JD-Core Version:    0.7.0.1
 */
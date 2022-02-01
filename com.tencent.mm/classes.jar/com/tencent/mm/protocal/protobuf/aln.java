package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class aln
  extends com.tencent.mm.bx.a
{
  public int DmL;
  public int LyB;
  public b LyC;
  public int count;
  public String odo;
  public String path;
  public int rXs;
  public String title;
  public String uOH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184212);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.rXs);
      paramVarArgs.aR(2, this.count);
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.odo != null) {
        paramVarArgs.d(4, this.odo);
      }
      paramVarArgs.aR(5, this.DmL);
      if (this.path != null) {
        paramVarArgs.d(6, this.path);
      }
      if (this.uOH != null) {
        paramVarArgs.d(7, this.uOH);
      }
      paramVarArgs.aR(8, this.LyB);
      if (this.LyC != null) {
        paramVarArgs.c(9, this.LyC);
      }
      AppMethodBeat.o(184212);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.rXs) + 0 + f.a.a.b.b.a.bA(2, this.count);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.title);
      }
      i = paramInt;
      if (this.odo != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.odo);
      }
      i += f.a.a.b.b.a.bA(5, this.DmL);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.path);
      }
      i = paramInt;
      if (this.uOH != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.uOH);
      }
      i += f.a.a.b.b.a.bA(8, this.LyB);
      paramInt = i;
      if (this.LyC != null) {
        paramInt = i + f.a.a.b.b.a.b(9, this.LyC);
      }
      AppMethodBeat.o(184212);
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
      AppMethodBeat.o(184212);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aln localaln = (aln)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184212);
        return -1;
      case 1: 
        localaln.rXs = locala.KhF.xS();
        AppMethodBeat.o(184212);
        return 0;
      case 2: 
        localaln.count = locala.KhF.xS();
        AppMethodBeat.o(184212);
        return 0;
      case 3: 
        localaln.title = locala.KhF.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 4: 
        localaln.odo = locala.KhF.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 5: 
        localaln.DmL = locala.KhF.xS();
        AppMethodBeat.o(184212);
        return 0;
      case 6: 
        localaln.path = locala.KhF.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 7: 
        localaln.uOH = locala.KhF.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 8: 
        localaln.LyB = locala.KhF.xS();
        AppMethodBeat.o(184212);
        return 0;
      }
      localaln.LyC = locala.KhF.fMu();
      AppMethodBeat.o(184212);
      return 0;
    }
    AppMethodBeat.o(184212);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aln
 * JD-Core Version:    0.7.0.1
 */
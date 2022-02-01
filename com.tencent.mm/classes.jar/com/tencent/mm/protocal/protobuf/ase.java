package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ase
  extends com.tencent.mm.bx.a
{
  public int Gqr;
  public int Gqs;
  public b Gqt;
  public int count;
  public String path;
  public String pkr;
  public String title;
  public int uda;
  public String xfl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184212);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uda);
      paramVarArgs.aS(2, this.count);
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.pkr != null) {
        paramVarArgs.d(4, this.pkr);
      }
      paramVarArgs.aS(5, this.Gqr);
      if (this.path != null) {
        paramVarArgs.d(6, this.path);
      }
      if (this.xfl != null) {
        paramVarArgs.d(7, this.xfl);
      }
      paramVarArgs.aS(8, this.Gqs);
      if (this.Gqt != null) {
        paramVarArgs.c(9, this.Gqt);
      }
      AppMethodBeat.o(184212);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uda) + 0 + f.a.a.b.b.a.bz(2, this.count);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.title);
      }
      i = paramInt;
      if (this.pkr != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.pkr);
      }
      i += f.a.a.b.b.a.bz(5, this.Gqr);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.path);
      }
      i = paramInt;
      if (this.xfl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.xfl);
      }
      i += f.a.a.b.b.a.bz(8, this.Gqs);
      paramInt = i;
      if (this.Gqt != null) {
        paramInt = i + f.a.a.b.b.a.b(9, this.Gqt);
      }
      AppMethodBeat.o(184212);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(184212);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ase localase = (ase)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184212);
        return -1;
      case 1: 
        localase.uda = locala.NPN.zc();
        AppMethodBeat.o(184212);
        return 0;
      case 2: 
        localase.count = locala.NPN.zc();
        AppMethodBeat.o(184212);
        return 0;
      case 3: 
        localase.title = locala.NPN.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 4: 
        localase.pkr = locala.NPN.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 5: 
        localase.Gqr = locala.NPN.zc();
        AppMethodBeat.o(184212);
        return 0;
      case 6: 
        localase.path = locala.NPN.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 7: 
        localase.xfl = locala.NPN.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 8: 
        localase.Gqs = locala.NPN.zc();
        AppMethodBeat.o(184212);
        return 0;
      }
      localase.Gqt = locala.NPN.gxI();
      AppMethodBeat.o(184212);
      return 0;
    }
    AppMethodBeat.o(184212);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ase
 * JD-Core Version:    0.7.0.1
 */
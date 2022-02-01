package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ama
  extends com.tencent.mm.cd.a
{
  public int SvY;
  public String SvZ;
  public String Swa;
  public String Swm;
  public String Swn;
  public int Swo;
  public int Swp;
  public String Swq;
  public String Swr;
  public String Sws;
  public String Swt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32206);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SvY);
      if (this.SvZ != null) {
        paramVarArgs.f(2, this.SvZ);
      }
      if (this.Swm != null) {
        paramVarArgs.f(3, this.Swm);
      }
      if (this.Swn != null) {
        paramVarArgs.f(4, this.Swn);
      }
      paramVarArgs.aY(5, this.Swo);
      paramVarArgs.aY(6, this.Swp);
      if (this.Swq != null) {
        paramVarArgs.f(7, this.Swq);
      }
      if (this.Swa != null) {
        paramVarArgs.f(8, this.Swa);
      }
      if (this.Swr != null) {
        paramVarArgs.f(9, this.Swr);
      }
      if (this.Sws != null) {
        paramVarArgs.f(10, this.Sws);
      }
      if (this.Swt != null) {
        paramVarArgs.f(11, this.Swt);
      }
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SvY) + 0;
      paramInt = i;
      if (this.SvZ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SvZ);
      }
      i = paramInt;
      if (this.Swm != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Swm);
      }
      paramInt = i;
      if (this.Swn != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Swn);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Swo) + g.a.a.b.b.a.bM(6, this.Swp);
      paramInt = i;
      if (this.Swq != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Swq);
      }
      i = paramInt;
      if (this.Swa != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.Swa);
      }
      paramInt = i;
      if (this.Swr != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Swr);
      }
      i = paramInt;
      if (this.Sws != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Sws);
      }
      paramInt = i;
      if (this.Swt != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Swt);
      }
      AppMethodBeat.o(32206);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ama localama = (ama)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32206);
        return -1;
      case 1: 
        localama.SvY = locala.abFh.AK();
        AppMethodBeat.o(32206);
        return 0;
      case 2: 
        localama.SvZ = locala.abFh.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 3: 
        localama.Swm = locala.abFh.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 4: 
        localama.Swn = locala.abFh.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 5: 
        localama.Swo = locala.abFh.AK();
        AppMethodBeat.o(32206);
        return 0;
      case 6: 
        localama.Swp = locala.abFh.AK();
        AppMethodBeat.o(32206);
        return 0;
      case 7: 
        localama.Swq = locala.abFh.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 8: 
        localama.Swa = locala.abFh.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 9: 
        localama.Swr = locala.abFh.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 10: 
        localama.Sws = locala.abFh.readString();
        AppMethodBeat.o(32206);
        return 0;
      }
      localama.Swt = locala.abFh.readString();
      AppMethodBeat.o(32206);
      return 0;
    }
    AppMethodBeat.o(32206);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ama
 * JD-Core Version:    0.7.0.1
 */
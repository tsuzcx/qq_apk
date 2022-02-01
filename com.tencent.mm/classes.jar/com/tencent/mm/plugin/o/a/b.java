package com.tencent.mm.plugin.o.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.cd.a
{
  public int DNR;
  public String DNS;
  public String DNT;
  public String DNU;
  public String DNV;
  public String DNW;
  public String DNX;
  public String DNY;
  public String DNZ;
  public String DOa;
  public String hDf;
  public String title;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(25280);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.DNR);
      if (this.type != null) {
        paramVarArgs.f(2, this.type);
      }
      if (this.title != null) {
        paramVarArgs.f(3, this.title);
      }
      if (this.DNS != null) {
        paramVarArgs.f(4, this.DNS);
      }
      if (this.DNT != null) {
        paramVarArgs.f(5, this.DNT);
      }
      if (this.DNU != null) {
        paramVarArgs.f(6, this.DNU);
      }
      if (this.DNV != null) {
        paramVarArgs.f(7, this.DNV);
      }
      if (this.DNW != null) {
        paramVarArgs.f(8, this.DNW);
      }
      if (this.DNX != null) {
        paramVarArgs.f(9, this.DNX);
      }
      if (this.DNY != null) {
        paramVarArgs.f(10, this.DNY);
      }
      if (this.hDf != null) {
        paramVarArgs.f(11, this.hDf);
      }
      if (this.DNZ != null) {
        paramVarArgs.f(12, this.DNZ);
      }
      if (this.DOa != null) {
        paramVarArgs.f(13, this.DOa);
      }
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.DNR) + 0;
      paramInt = i;
      if (this.type != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.type);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.title);
      }
      paramInt = i;
      if (this.DNS != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.DNS);
      }
      i = paramInt;
      if (this.DNT != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.DNT);
      }
      paramInt = i;
      if (this.DNU != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.DNU);
      }
      i = paramInt;
      if (this.DNV != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.DNV);
      }
      paramInt = i;
      if (this.DNW != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.DNW);
      }
      i = paramInt;
      if (this.DNX != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.DNX);
      }
      paramInt = i;
      if (this.DNY != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.DNY);
      }
      i = paramInt;
      if (this.hDf != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.hDf);
      }
      paramInt = i;
      if (this.DNZ != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.DNZ);
      }
      i = paramInt;
      if (this.DOa != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.DOa);
      }
      AppMethodBeat.o(25280);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(25280);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(25280);
        return -1;
      case 1: 
        localb.DNR = locala.abFh.AK();
        AppMethodBeat.o(25280);
        return 0;
      case 2: 
        localb.type = locala.abFh.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 3: 
        localb.title = locala.abFh.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 4: 
        localb.DNS = locala.abFh.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 5: 
        localb.DNT = locala.abFh.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 6: 
        localb.DNU = locala.abFh.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 7: 
        localb.DNV = locala.abFh.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 8: 
        localb.DNW = locala.abFh.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 9: 
        localb.DNX = locala.abFh.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 10: 
        localb.DNY = locala.abFh.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 11: 
        localb.hDf = locala.abFh.readString();
        AppMethodBeat.o(25280);
        return 0;
      case 12: 
        localb.DNZ = locala.abFh.readString();
        AppMethodBeat.o(25280);
        return 0;
      }
      localb.DOa = locala.abFh.readString();
      AppMethodBeat.o(25280);
      return 0;
    }
    AppMethodBeat.o(25280);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.o.a.b
 * JD-Core Version:    0.7.0.1
 */
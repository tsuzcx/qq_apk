package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebs
  extends com.tencent.mm.cd.a
{
  public String AttachedText;
  public String AttachedTextColor;
  public String LensId;
  public String TdZ;
  public String UgD;
  public int UgE;
  public String UgF;
  public String UgG;
  public String UgH;
  public int UgI;
  public int UgJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211903);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UgD != null) {
        paramVarArgs.f(1, this.UgD);
      }
      paramVarArgs.aY(2, this.UgE);
      if (this.UgF != null) {
        paramVarArgs.f(3, this.UgF);
      }
      if (this.UgG != null) {
        paramVarArgs.f(4, this.UgG);
      }
      if (this.UgH != null) {
        paramVarArgs.f(5, this.UgH);
      }
      if (this.TdZ != null) {
        paramVarArgs.f(6, this.TdZ);
      }
      if (this.AttachedText != null) {
        paramVarArgs.f(7, this.AttachedText);
      }
      if (this.AttachedTextColor != null) {
        paramVarArgs.f(8, this.AttachedTextColor);
      }
      if (this.LensId != null) {
        paramVarArgs.f(9, this.LensId);
      }
      paramVarArgs.aY(10, this.UgI);
      paramVarArgs.aY(11, this.UgJ);
      AppMethodBeat.o(211903);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UgD == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = g.a.a.b.b.a.g(1, this.UgD) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.UgE);
      paramInt = i;
      if (this.UgF != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UgF);
      }
      i = paramInt;
      if (this.UgG != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.UgG);
      }
      paramInt = i;
      if (this.UgH != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UgH);
      }
      i = paramInt;
      if (this.TdZ != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TdZ);
      }
      paramInt = i;
      if (this.AttachedText != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.AttachedText);
      }
      i = paramInt;
      if (this.AttachedTextColor != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.AttachedTextColor);
      }
      paramInt = i;
      if (this.LensId != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.LensId);
      }
      i = g.a.a.b.b.a.bM(10, this.UgI);
      int j = g.a.a.b.b.a.bM(11, this.UgJ);
      AppMethodBeat.o(211903);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(211903);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ebs localebs = (ebs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(211903);
          return -1;
        case 1: 
          localebs.UgD = locala.abFh.readString();
          AppMethodBeat.o(211903);
          return 0;
        case 2: 
          localebs.UgE = locala.abFh.AK();
          AppMethodBeat.o(211903);
          return 0;
        case 3: 
          localebs.UgF = locala.abFh.readString();
          AppMethodBeat.o(211903);
          return 0;
        case 4: 
          localebs.UgG = locala.abFh.readString();
          AppMethodBeat.o(211903);
          return 0;
        case 5: 
          localebs.UgH = locala.abFh.readString();
          AppMethodBeat.o(211903);
          return 0;
        case 6: 
          localebs.TdZ = locala.abFh.readString();
          AppMethodBeat.o(211903);
          return 0;
        case 7: 
          localebs.AttachedText = locala.abFh.readString();
          AppMethodBeat.o(211903);
          return 0;
        case 8: 
          localebs.AttachedTextColor = locala.abFh.readString();
          AppMethodBeat.o(211903);
          return 0;
        case 9: 
          localebs.LensId = locala.abFh.readString();
          AppMethodBeat.o(211903);
          return 0;
        case 10: 
          localebs.UgI = locala.abFh.AK();
          AppMethodBeat.o(211903);
          return 0;
        }
        localebs.UgJ = locala.abFh.AK();
        AppMethodBeat.o(211903);
        return 0;
      }
      AppMethodBeat.o(211903);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebs
 * JD-Core Version:    0.7.0.1
 */
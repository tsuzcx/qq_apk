package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkn
  extends com.tencent.mm.bw.a
{
  public String EpP;
  public String Faj;
  public String Fak;
  public String Fal;
  public String Fam;
  public int Fan;
  public String Fao;
  public String Title;
  public String Url;
  public int ndI;
  public String tkL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32327);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Faj != null) {
        paramVarArgs.d(2, this.Faj);
      }
      paramVarArgs.aR(3, this.ndI);
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      if (this.Fak != null) {
        paramVarArgs.d(5, this.Fak);
      }
      if (this.EpP != null) {
        paramVarArgs.d(6, this.EpP);
      }
      if (this.Fal != null) {
        paramVarArgs.d(7, this.Fal);
      }
      if (this.tkL != null) {
        paramVarArgs.d(8, this.tkL);
      }
      if (this.Fam != null) {
        paramVarArgs.d(9, this.Fam);
      }
      paramVarArgs.aR(10, this.Fan);
      if (this.Fao != null) {
        paramVarArgs.d(11, this.Fao);
      }
      AppMethodBeat.o(32327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label811;
      }
    }
    label811:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Faj != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Faj);
      }
      i += f.a.a.b.b.a.bx(3, this.ndI);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Url);
      }
      i = paramInt;
      if (this.Fak != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fak);
      }
      paramInt = i;
      if (this.EpP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EpP);
      }
      i = paramInt;
      if (this.Fal != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Fal);
      }
      paramInt = i;
      if (this.tkL != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.tkL);
      }
      i = paramInt;
      if (this.Fam != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Fam);
      }
      i += f.a.a.b.b.a.bx(10, this.Fan);
      paramInt = i;
      if (this.Fao != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Fao);
      }
      AppMethodBeat.o(32327);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32327);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bkn localbkn = (bkn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32327);
          return -1;
        case 1: 
          localbkn.Title = locala.LVo.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 2: 
          localbkn.Faj = locala.LVo.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 3: 
          localbkn.ndI = locala.LVo.xF();
          AppMethodBeat.o(32327);
          return 0;
        case 4: 
          localbkn.Url = locala.LVo.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 5: 
          localbkn.Fak = locala.LVo.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 6: 
          localbkn.EpP = locala.LVo.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 7: 
          localbkn.Fal = locala.LVo.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 8: 
          localbkn.tkL = locala.LVo.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 9: 
          localbkn.Fam = locala.LVo.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 10: 
          localbkn.Fan = locala.LVo.xF();
          AppMethodBeat.o(32327);
          return 0;
        }
        localbkn.Fao = locala.LVo.readString();
        AppMethodBeat.o(32327);
        return 0;
      }
      AppMethodBeat.o(32327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkn
 * JD-Core Version:    0.7.0.1
 */
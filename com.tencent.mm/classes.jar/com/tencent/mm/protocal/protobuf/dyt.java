package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dyt
  extends com.tencent.mm.bw.a
{
  public String MYh;
  public String MYi;
  public String MYj;
  public int MYk;
  public String MYl;
  public String MYm;
  public String MYn;
  public int MYo;
  public int MYp;
  public int MYq;
  public int MYr;
  public int MYs;
  public int Scene;
  public String Title;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117927);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MYh == null)
      {
        paramVarArgs = new b("Not all required fields were included: PickedWord");
        AppMethodBeat.o(117927);
        throw paramVarArgs;
      }
      if (this.MYh != null) {
        paramVarArgs.e(1, this.MYh);
      }
      if (this.MYi != null) {
        paramVarArgs.e(2, this.MYi);
      }
      if (this.MYj != null) {
        paramVarArgs.e(3, this.MYj);
      }
      paramVarArgs.aM(4, this.Scene);
      paramVarArgs.aM(5, this.MYk);
      if (this.Url != null) {
        paramVarArgs.e(6, this.Url);
      }
      if (this.Title != null) {
        paramVarArgs.e(7, this.Title);
      }
      if (this.MYl != null) {
        paramVarArgs.e(8, this.MYl);
      }
      if (this.MYm != null) {
        paramVarArgs.e(9, this.MYm);
      }
      if (this.MYn != null) {
        paramVarArgs.e(10, this.MYn);
      }
      paramVarArgs.aM(11, this.MYo);
      paramVarArgs.aM(12, this.MYp);
      paramVarArgs.aM(13, this.MYq);
      paramVarArgs.aM(14, this.MYr);
      paramVarArgs.aM(15, this.MYs);
      AppMethodBeat.o(117927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MYh == null) {
        break label1018;
      }
    }
    label1018:
    for (int i = g.a.a.b.b.a.f(1, this.MYh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MYi != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MYi);
      }
      i = paramInt;
      if (this.MYj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MYj);
      }
      i = i + g.a.a.b.b.a.bu(4, this.Scene) + g.a.a.b.b.a.bu(5, this.MYk);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Url);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Title);
      }
      paramInt = i;
      if (this.MYl != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MYl);
      }
      i = paramInt;
      if (this.MYm != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.MYm);
      }
      paramInt = i;
      if (this.MYn != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MYn);
      }
      i = g.a.a.b.b.a.bu(11, this.MYo);
      int j = g.a.a.b.b.a.bu(12, this.MYp);
      int k = g.a.a.b.b.a.bu(13, this.MYq);
      int m = g.a.a.b.b.a.bu(14, this.MYr);
      int n = g.a.a.b.b.a.bu(15, this.MYs);
      AppMethodBeat.o(117927);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MYh == null)
        {
          paramVarArgs = new b("Not all required fields were included: PickedWord");
          AppMethodBeat.o(117927);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117927);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dyt localdyt = (dyt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117927);
          return -1;
        case 1: 
          localdyt.MYh = locala.UbS.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 2: 
          localdyt.MYi = locala.UbS.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 3: 
          localdyt.MYj = locala.UbS.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 4: 
          localdyt.Scene = locala.UbS.zi();
          AppMethodBeat.o(117927);
          return 0;
        case 5: 
          localdyt.MYk = locala.UbS.zi();
          AppMethodBeat.o(117927);
          return 0;
        case 6: 
          localdyt.Url = locala.UbS.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 7: 
          localdyt.Title = locala.UbS.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 8: 
          localdyt.MYl = locala.UbS.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 9: 
          localdyt.MYm = locala.UbS.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 10: 
          localdyt.MYn = locala.UbS.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 11: 
          localdyt.MYo = locala.UbS.zi();
          AppMethodBeat.o(117927);
          return 0;
        case 12: 
          localdyt.MYp = locala.UbS.zi();
          AppMethodBeat.o(117927);
          return 0;
        case 13: 
          localdyt.MYq = locala.UbS.zi();
          AppMethodBeat.o(117927);
          return 0;
        case 14: 
          localdyt.MYr = locala.UbS.zi();
          AppMethodBeat.o(117927);
          return 0;
        }
        localdyt.MYs = locala.UbS.zi();
        AppMethodBeat.o(117927);
        return 0;
      }
      AppMethodBeat.o(117927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyt
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cty
  extends com.tencent.mm.bw.a
{
  public String KUC;
  public String KUD;
  public String KZQ;
  public String Mzi;
  public int Mzj;
  public String Mzk;
  public int Mzl;
  public int duration;
  public int height;
  public String iAq;
  public String title;
  public String vid;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176147);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mzi != null) {
        paramVarArgs.e(1, this.Mzi);
      }
      paramVarArgs.aM(2, this.duration);
      if (this.KUC != null) {
        paramVarArgs.e(3, this.KUC);
      }
      if (this.KUD != null) {
        paramVarArgs.e(4, this.KUD);
      }
      if (this.title != null) {
        paramVarArgs.e(5, this.title);
      }
      if (this.iAq != null) {
        paramVarArgs.e(6, this.iAq);
      }
      paramVarArgs.aM(7, this.Mzj);
      paramVarArgs.aM(8, this.width);
      paramVarArgs.aM(9, this.height);
      if (this.KZQ != null) {
        paramVarArgs.e(10, this.KZQ);
      }
      if (this.vid != null) {
        paramVarArgs.e(11, this.vid);
      }
      if (this.Mzk != null) {
        paramVarArgs.e(12, this.Mzk);
      }
      paramVarArgs.aM(13, this.Mzl);
      AppMethodBeat.o(176147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mzi == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = g.a.a.b.b.a.f(1, this.Mzi) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.duration);
      paramInt = i;
      if (this.KUC != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KUC);
      }
      i = paramInt;
      if (this.KUD != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KUD);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.title);
      }
      i = paramInt;
      if (this.iAq != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.iAq);
      }
      i = i + g.a.a.b.b.a.bu(7, this.Mzj) + g.a.a.b.b.a.bu(8, this.width) + g.a.a.b.b.a.bu(9, this.height);
      paramInt = i;
      if (this.KZQ != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KZQ);
      }
      i = paramInt;
      if (this.vid != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.vid);
      }
      paramInt = i;
      if (this.Mzk != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.Mzk);
      }
      i = g.a.a.b.b.a.bu(13, this.Mzl);
      AppMethodBeat.o(176147);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(176147);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cty localcty = (cty)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176147);
          return -1;
        case 1: 
          localcty.Mzi = locala.UbS.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 2: 
          localcty.duration = locala.UbS.zi();
          AppMethodBeat.o(176147);
          return 0;
        case 3: 
          localcty.KUC = locala.UbS.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 4: 
          localcty.KUD = locala.UbS.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 5: 
          localcty.title = locala.UbS.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 6: 
          localcty.iAq = locala.UbS.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 7: 
          localcty.Mzj = locala.UbS.zi();
          AppMethodBeat.o(176147);
          return 0;
        case 8: 
          localcty.width = locala.UbS.zi();
          AppMethodBeat.o(176147);
          return 0;
        case 9: 
          localcty.height = locala.UbS.zi();
          AppMethodBeat.o(176147);
          return 0;
        case 10: 
          localcty.KZQ = locala.UbS.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 11: 
          localcty.vid = locala.UbS.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 12: 
          localcty.Mzk = locala.UbS.readString();
          AppMethodBeat.o(176147);
          return 0;
        }
        localcty.Mzl = locala.UbS.zi();
        AppMethodBeat.o(176147);
        return 0;
      }
      AppMethodBeat.o(176147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cty
 * JD-Core Version:    0.7.0.1
 */
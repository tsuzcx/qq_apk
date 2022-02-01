package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cch
  extends com.tencent.mm.bw.a
{
  public String Lkl;
  public String Mim;
  public String Min;
  public String Mio;
  public String Mip;
  public int Miq;
  public String Mir;
  public String Title;
  public String Url;
  public int oUv;
  public String xMq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32327);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Mim != null) {
        paramVarArgs.e(2, this.Mim);
      }
      paramVarArgs.aM(3, this.oUv);
      if (this.Url != null) {
        paramVarArgs.e(4, this.Url);
      }
      if (this.Min != null) {
        paramVarArgs.e(5, this.Min);
      }
      if (this.Lkl != null) {
        paramVarArgs.e(6, this.Lkl);
      }
      if (this.Mio != null) {
        paramVarArgs.e(7, this.Mio);
      }
      if (this.xMq != null) {
        paramVarArgs.e(8, this.xMq);
      }
      if (this.Mip != null) {
        paramVarArgs.e(9, this.Mip);
      }
      paramVarArgs.aM(10, this.Miq);
      if (this.Mir != null) {
        paramVarArgs.e(11, this.Mir);
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
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Mim != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Mim);
      }
      i += g.a.a.b.b.a.bu(3, this.oUv);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Url);
      }
      i = paramInt;
      if (this.Min != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Min);
      }
      paramInt = i;
      if (this.Lkl != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lkl);
      }
      i = paramInt;
      if (this.Mio != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Mio);
      }
      paramInt = i;
      if (this.xMq != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.xMq);
      }
      i = paramInt;
      if (this.Mip != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Mip);
      }
      i += g.a.a.b.b.a.bu(10, this.Miq);
      paramInt = i;
      if (this.Mir != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Mir);
      }
      AppMethodBeat.o(32327);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32327);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cch localcch = (cch)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32327);
          return -1;
        case 1: 
          localcch.Title = locala.UbS.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 2: 
          localcch.Mim = locala.UbS.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 3: 
          localcch.oUv = locala.UbS.zi();
          AppMethodBeat.o(32327);
          return 0;
        case 4: 
          localcch.Url = locala.UbS.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 5: 
          localcch.Min = locala.UbS.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 6: 
          localcch.Lkl = locala.UbS.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 7: 
          localcch.Mio = locala.UbS.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 8: 
          localcch.xMq = locala.UbS.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 9: 
          localcch.Mip = locala.UbS.readString();
          AppMethodBeat.o(32327);
          return 0;
        case 10: 
          localcch.Miq = locala.UbS.zi();
          AppMethodBeat.o(32327);
          return 0;
        }
        localcch.Mir = locala.UbS.readString();
        AppMethodBeat.o(32327);
        return 0;
      }
      AppMethodBeat.o(32327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cch
 * JD-Core Version:    0.7.0.1
 */
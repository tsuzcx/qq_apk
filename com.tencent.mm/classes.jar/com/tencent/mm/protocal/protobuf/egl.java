package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egl
  extends com.tencent.mm.bw.a
{
  public long KMc;
  public long KMf;
  public int Ngu;
  public String Ngv;
  public int Ngw;
  public int Ngx;
  public int Ngy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(223892);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.KMf);
      paramVarArgs.aM(2, this.Ngu);
      if (this.Ngv != null) {
        paramVarArgs.e(3, this.Ngv);
      }
      paramVarArgs.bb(4, this.KMc);
      paramVarArgs.aM(5, this.Ngw);
      paramVarArgs.aM(6, this.Ngx);
      paramVarArgs.aM(7, this.Ngy);
      AppMethodBeat.o(223892);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.KMf) + 0 + g.a.a.b.b.a.bu(2, this.Ngu);
      paramInt = i;
      if (this.Ngv != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Ngv);
      }
      i = g.a.a.b.b.a.r(4, this.KMc);
      int j = g.a.a.b.b.a.bu(5, this.Ngw);
      int k = g.a.a.b.b.a.bu(6, this.Ngx);
      int m = g.a.a.b.b.a.bu(7, this.Ngy);
      AppMethodBeat.o(223892);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(223892);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      egl localegl = (egl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(223892);
        return -1;
      case 1: 
        localegl.KMf = locala.UbS.zl();
        AppMethodBeat.o(223892);
        return 0;
      case 2: 
        localegl.Ngu = locala.UbS.zi();
        AppMethodBeat.o(223892);
        return 0;
      case 3: 
        localegl.Ngv = locala.UbS.readString();
        AppMethodBeat.o(223892);
        return 0;
      case 4: 
        localegl.KMc = locala.UbS.zl();
        AppMethodBeat.o(223892);
        return 0;
      case 5: 
        localegl.Ngw = locala.UbS.zi();
        AppMethodBeat.o(223892);
        return 0;
      case 6: 
        localegl.Ngx = locala.UbS.zi();
        AppMethodBeat.o(223892);
        return 0;
      }
      localegl.Ngy = locala.UbS.zi();
      AppMethodBeat.o(223892);
      return 0;
    }
    AppMethodBeat.o(223892);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egl
 * JD-Core Version:    0.7.0.1
 */
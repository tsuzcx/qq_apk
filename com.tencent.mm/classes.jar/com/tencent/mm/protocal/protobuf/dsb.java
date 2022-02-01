package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsb
  extends com.tencent.mm.bw.a
{
  public int Height;
  public int MUI;
  public String ThumbUrl;
  public String Url;
  public int Width;
  public int xuT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187883);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.xuT);
      if (this.Url != null) {
        paramVarArgs.e(2, this.Url);
      }
      paramVarArgs.aM(3, this.Width);
      paramVarArgs.aM(4, this.Height);
      if (this.ThumbUrl != null) {
        paramVarArgs.e(5, this.ThumbUrl);
      }
      paramVarArgs.aM(6, this.MUI);
      AppMethodBeat.o(187883);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.xuT) + 0;
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Url);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.Width) + g.a.a.b.b.a.bu(4, this.Height);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.ThumbUrl);
      }
      i = g.a.a.b.b.a.bu(6, this.MUI);
      AppMethodBeat.o(187883);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(187883);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dsb localdsb = (dsb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(187883);
        return -1;
      case 1: 
        localdsb.xuT = locala.UbS.zi();
        AppMethodBeat.o(187883);
        return 0;
      case 2: 
        localdsb.Url = locala.UbS.readString();
        AppMethodBeat.o(187883);
        return 0;
      case 3: 
        localdsb.Width = locala.UbS.zi();
        AppMethodBeat.o(187883);
        return 0;
      case 4: 
        localdsb.Height = locala.UbS.zi();
        AppMethodBeat.o(187883);
        return 0;
      case 5: 
        localdsb.ThumbUrl = locala.UbS.readString();
        AppMethodBeat.o(187883);
        return 0;
      }
      localdsb.MUI = locala.UbS.zi();
      AppMethodBeat.o(187883);
      return 0;
    }
    AppMethodBeat.o(187883);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsb
 * JD-Core Version:    0.7.0.1
 */
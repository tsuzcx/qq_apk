package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebx
  extends com.tencent.mm.cd.a
{
  public int Crm;
  public int Height;
  public String ThumbUrl;
  public int UgS;
  public String Url;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211896);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Crm);
      if (this.Url != null) {
        paramVarArgs.f(2, this.Url);
      }
      paramVarArgs.aY(3, this.Width);
      paramVarArgs.aY(4, this.Height);
      if (this.ThumbUrl != null) {
        paramVarArgs.f(5, this.ThumbUrl);
      }
      paramVarArgs.aY(6, this.UgS);
      AppMethodBeat.o(211896);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Crm) + 0;
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Url);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.Width) + g.a.a.b.b.a.bM(4, this.Height);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ThumbUrl);
      }
      i = g.a.a.b.b.a.bM(6, this.UgS);
      AppMethodBeat.o(211896);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(211896);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ebx localebx = (ebx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(211896);
        return -1;
      case 1: 
        localebx.Crm = locala.abFh.AK();
        AppMethodBeat.o(211896);
        return 0;
      case 2: 
        localebx.Url = locala.abFh.readString();
        AppMethodBeat.o(211896);
        return 0;
      case 3: 
        localebx.Width = locala.abFh.AK();
        AppMethodBeat.o(211896);
        return 0;
      case 4: 
        localebx.Height = locala.abFh.AK();
        AppMethodBeat.o(211896);
        return 0;
      case 5: 
        localebx.ThumbUrl = locala.abFh.readString();
        AppMethodBeat.o(211896);
        return 0;
      }
      localebx.UgS = locala.abFh.AK();
      AppMethodBeat.o(211896);
      return 0;
    }
    AppMethodBeat.o(211896);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebx
 * JD-Core Version:    0.7.0.1
 */
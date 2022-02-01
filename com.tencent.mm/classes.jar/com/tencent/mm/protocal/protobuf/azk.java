package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azk
  extends com.tencent.mm.bw.a
{
  public String LJh;
  public String LJi;
  public String albumName;
  public String artist;
  public String name;
  public String wWb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209612);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wWb != null) {
        paramVarArgs.e(1, this.wWb);
      }
      if (this.LJh != null) {
        paramVarArgs.e(2, this.LJh);
      }
      if (this.name != null) {
        paramVarArgs.e(3, this.name);
      }
      if (this.artist != null) {
        paramVarArgs.e(4, this.artist);
      }
      if (this.albumName != null) {
        paramVarArgs.e(5, this.albumName);
      }
      if (this.LJi != null) {
        paramVarArgs.e(6, this.LJi);
      }
      AppMethodBeat.o(209612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wWb == null) {
        break label518;
      }
    }
    label518:
    for (int i = g.a.a.b.b.a.f(1, this.wWb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LJh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LJh);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.name);
      }
      paramInt = i;
      if (this.artist != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.artist);
      }
      i = paramInt;
      if (this.albumName != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.albumName);
      }
      paramInt = i;
      if (this.LJi != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LJi);
      }
      AppMethodBeat.o(209612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209612);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        azk localazk = (azk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209612);
          return -1;
        case 1: 
          localazk.wWb = locala.UbS.readString();
          AppMethodBeat.o(209612);
          return 0;
        case 2: 
          localazk.LJh = locala.UbS.readString();
          AppMethodBeat.o(209612);
          return 0;
        case 3: 
          localazk.name = locala.UbS.readString();
          AppMethodBeat.o(209612);
          return 0;
        case 4: 
          localazk.artist = locala.UbS.readString();
          AppMethodBeat.o(209612);
          return 0;
        case 5: 
          localazk.albumName = locala.UbS.readString();
          AppMethodBeat.o(209612);
          return 0;
        }
        localazk.LJi = locala.UbS.readString();
        AppMethodBeat.o(209612);
        return 0;
      }
      AppMethodBeat.o(209612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azk
 * JD-Core Version:    0.7.0.1
 */
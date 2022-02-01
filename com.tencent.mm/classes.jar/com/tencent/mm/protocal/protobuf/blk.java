package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class blk
  extends com.tencent.mm.bx.a
{
  public String Kru;
  public String Vyi;
  public int ZUB;
  public int ZUC;
  public String icon_url;
  public String wording;
  public int wuj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259304);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Vyi != null) {
        paramVarArgs.g(1, this.Vyi);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(2, this.icon_url);
      }
      if (this.wording != null) {
        paramVarArgs.g(3, this.wording);
      }
      paramVarArgs.bS(4, this.wuj);
      if (this.Kru != null) {
        paramVarArgs.g(5, this.Kru);
      }
      paramVarArgs.bS(6, this.ZUB);
      paramVarArgs.bS(7, this.ZUC);
      AppMethodBeat.o(259304);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Vyi == null) {
        break label530;
      }
    }
    label530:
    for (int i = i.a.a.b.b.a.h(1, this.Vyi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.icon_url);
      }
      i = paramInt;
      if (this.wording != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.wording);
      }
      i += i.a.a.b.b.a.cJ(4, this.wuj);
      paramInt = i;
      if (this.Kru != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Kru);
      }
      i = i.a.a.b.b.a.cJ(6, this.ZUB);
      int j = i.a.a.b.b.a.cJ(7, this.ZUC);
      AppMethodBeat.o(259304);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259304);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        blk localblk = (blk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259304);
          return -1;
        case 1: 
          localblk.Vyi = locala.ajGk.readString();
          AppMethodBeat.o(259304);
          return 0;
        case 2: 
          localblk.icon_url = locala.ajGk.readString();
          AppMethodBeat.o(259304);
          return 0;
        case 3: 
          localblk.wording = locala.ajGk.readString();
          AppMethodBeat.o(259304);
          return 0;
        case 4: 
          localblk.wuj = locala.ajGk.aar();
          AppMethodBeat.o(259304);
          return 0;
        case 5: 
          localblk.Kru = locala.ajGk.readString();
          AppMethodBeat.o(259304);
          return 0;
        case 6: 
          localblk.ZUB = locala.ajGk.aar();
          AppMethodBeat.o(259304);
          return 0;
        }
        localblk.ZUC = locala.ajGk.aar();
        AppMethodBeat.o(259304);
        return 0;
      }
      AppMethodBeat.o(259304);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blk
 * JD-Core Version:    0.7.0.1
 */
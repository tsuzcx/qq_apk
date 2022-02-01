package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gby
  extends com.tencent.mm.bx.a
{
  public String acah;
  public String acai;
  public LinkedList<String> acaj;
  public int acak;
  
  public gby()
  {
    AppMethodBeat.i(147784);
    this.acaj = new LinkedList();
    AppMethodBeat.o(147784);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147785);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acah != null) {
        paramVarArgs.g(1, this.acah);
      }
      if (this.acai != null) {
        paramVarArgs.g(2, this.acai);
      }
      paramVarArgs.e(3, 1, this.acaj);
      paramVarArgs.bS(4, this.acak);
      AppMethodBeat.o(147785);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acah == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = i.a.a.b.b.a.h(1, this.acah) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acai != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.acai);
      }
      paramInt = i.a.a.a.c(3, 1, this.acaj);
      int j = i.a.a.b.b.a.cJ(4, this.acak);
      AppMethodBeat.o(147785);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.acaj.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147785);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gby localgby = (gby)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147785);
          return -1;
        case 1: 
          localgby.acah = locala.ajGk.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 2: 
          localgby.acai = locala.ajGk.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 3: 
          localgby.acaj.add(locala.ajGk.readString());
          AppMethodBeat.o(147785);
          return 0;
        }
        localgby.acak = locala.ajGk.aar();
        AppMethodBeat.o(147785);
        return 0;
      }
      AppMethodBeat.o(147785);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gby
 * JD-Core Version:    0.7.0.1
 */
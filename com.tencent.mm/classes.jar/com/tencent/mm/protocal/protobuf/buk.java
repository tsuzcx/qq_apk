package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buk
  extends com.tencent.mm.bx.a
{
  public int aacb;
  public LinkedList<String> aacc;
  public String path;
  
  public buk()
  {
    AppMethodBeat.i(259189);
    this.aacc = new LinkedList();
    AppMethodBeat.o(259189);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259191);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.path != null) {
        paramVarArgs.g(1, this.path);
      }
      paramVarArgs.bS(2, this.aacb);
      paramVarArgs.e(3, 1, this.aacc);
      AppMethodBeat.o(259191);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = i.a.a.b.b.a.h(1, this.path) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aacb);
      int j = i.a.a.a.c(3, 1, this.aacc);
      AppMethodBeat.o(259191);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aacc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259191);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        buk localbuk = (buk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259191);
          return -1;
        case 1: 
          localbuk.path = locala.ajGk.readString();
          AppMethodBeat.o(259191);
          return 0;
        case 2: 
          localbuk.aacb = locala.ajGk.aar();
          AppMethodBeat.o(259191);
          return 0;
        }
        localbuk.aacc.add(locala.ajGk.readString());
        AppMethodBeat.o(259191);
        return 0;
      }
      AppMethodBeat.o(259191);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buk
 * JD-Core Version:    0.7.0.1
 */
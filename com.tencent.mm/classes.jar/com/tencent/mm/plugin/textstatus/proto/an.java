package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class an
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public String ToK;
  public int TpF;
  public int TpG;
  public String TpK;
  public String ext_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290001);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ToK != null) {
        paramVarArgs.g(1, this.ToK);
      }
      if (this.TpK != null) {
        paramVarArgs.g(2, this.TpK);
      }
      if (this.ext_info != null) {
        paramVarArgs.g(3, this.ext_info);
      }
      paramVarArgs.bS(4, this.TpF);
      paramVarArgs.bS(5, this.HTK);
      paramVarArgs.bS(6, this.TpG);
      AppMethodBeat.o(290001);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ToK == null) {
        break label470;
      }
    }
    label470:
    for (int i = i.a.a.b.b.a.h(1, this.ToK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TpK != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.TpK);
      }
      i = paramInt;
      if (this.ext_info != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ext_info);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.TpF);
      int j = i.a.a.b.b.a.cJ(5, this.HTK);
      int k = i.a.a.b.b.a.cJ(6, this.TpG);
      AppMethodBeat.o(290001);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(290001);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        an localan = (an)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(290001);
          return -1;
        case 1: 
          localan.ToK = locala.ajGk.readString();
          AppMethodBeat.o(290001);
          return 0;
        case 2: 
          localan.TpK = locala.ajGk.readString();
          AppMethodBeat.o(290001);
          return 0;
        case 3: 
          localan.ext_info = locala.ajGk.readString();
          AppMethodBeat.o(290001);
          return 0;
        case 4: 
          localan.TpF = locala.ajGk.aar();
          AppMethodBeat.o(290001);
          return 0;
        case 5: 
          localan.HTK = locala.ajGk.aar();
          AppMethodBeat.o(290001);
          return 0;
        }
        localan.TpG = locala.ajGk.aar();
        AppMethodBeat.o(290001);
        return 0;
      }
      AppMethodBeat.o(290001);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.an
 * JD-Core Version:    0.7.0.1
 */
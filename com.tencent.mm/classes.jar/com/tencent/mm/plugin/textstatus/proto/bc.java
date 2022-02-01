package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bc
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public String Tqe;
  public long Tqf;
  public String nickname;
  public int type;
  public String xkY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289952);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.g(1, this.nickname);
      }
      if (this.xkY != null) {
        paramVarArgs.g(2, this.xkY);
      }
      if (this.Tqe != null) {
        paramVarArgs.g(3, this.Tqe);
      }
      paramVarArgs.bS(4, this.type);
      paramVarArgs.bS(5, this.HTK);
      paramVarArgs.bv(6, this.Tqf);
      AppMethodBeat.o(289952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label470;
      }
    }
    label470:
    for (int i = i.a.a.b.b.a.h(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xkY != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.xkY);
      }
      i = paramInt;
      if (this.Tqe != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Tqe);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.type);
      int j = i.a.a.b.b.a.cJ(5, this.HTK);
      int k = i.a.a.b.b.a.q(6, this.Tqf);
      AppMethodBeat.o(289952);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289952);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bc localbc = (bc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(289952);
          return -1;
        case 1: 
          localbc.nickname = locala.ajGk.readString();
          AppMethodBeat.o(289952);
          return 0;
        case 2: 
          localbc.xkY = locala.ajGk.readString();
          AppMethodBeat.o(289952);
          return 0;
        case 3: 
          localbc.Tqe = locala.ajGk.readString();
          AppMethodBeat.o(289952);
          return 0;
        case 4: 
          localbc.type = locala.ajGk.aar();
          AppMethodBeat.o(289952);
          return 0;
        case 5: 
          localbc.HTK = locala.ajGk.aar();
          AppMethodBeat.o(289952);
          return 0;
        }
        localbc.Tqf = locala.ajGk.aaw();
        AppMethodBeat.o(289952);
        return 0;
      }
      AppMethodBeat.o(289952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.bc
 * JD-Core Version:    0.7.0.1
 */
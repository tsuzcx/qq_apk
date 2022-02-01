package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvz
  extends com.tencent.mm.bx.a
{
  public String Njp;
  public String UserName;
  public int YWY;
  public String hQa;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184131);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.Njp != null) {
        paramVarArgs.g(2, this.Njp);
      }
      paramVarArgs.bS(3, this.YWY);
      if (this.vhX != null) {
        paramVarArgs.g(4, this.vhX);
      }
      if (this.hQa != null) {
        paramVarArgs.g(5, this.hQa);
      }
      AppMethodBeat.o(184131);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Njp != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Njp);
      }
      i += i.a.a.b.b.a.cJ(3, this.YWY);
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.vhX);
      }
      i = paramInt;
      if (this.hQa != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hQa);
      }
      AppMethodBeat.o(184131);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(184131);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dvz localdvz = (dvz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(184131);
          return -1;
        case 1: 
          localdvz.UserName = locala.ajGk.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 2: 
          localdvz.Njp = locala.ajGk.readString();
          AppMethodBeat.o(184131);
          return 0;
        case 3: 
          localdvz.YWY = locala.ajGk.aar();
          AppMethodBeat.o(184131);
          return 0;
        case 4: 
          localdvz.vhX = locala.ajGk.readString();
          AppMethodBeat.o(184131);
          return 0;
        }
        localdvz.hQa = locala.ajGk.readString();
        AppMethodBeat.o(184131);
        return 0;
      }
      AppMethodBeat.o(184131);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvz
 * JD-Core Version:    0.7.0.1
 */
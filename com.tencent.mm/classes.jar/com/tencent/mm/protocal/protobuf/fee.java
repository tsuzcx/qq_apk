package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fee
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String qGB;
  public String title;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153331);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.qGB != null) {
        paramVarArgs.e(1, this.qGB);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      if (this.username != null) {
        paramVarArgs.e(4, this.username);
      }
      AppMethodBeat.o(153331);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qGB == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.qGB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.desc);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.username);
      }
      AppMethodBeat.o(153331);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153331);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fee localfee = (fee)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153331);
          return -1;
        case 1: 
          localfee.qGB = locala.UbS.readString();
          AppMethodBeat.o(153331);
          return 0;
        case 2: 
          localfee.title = locala.UbS.readString();
          AppMethodBeat.o(153331);
          return 0;
        case 3: 
          localfee.desc = locala.UbS.readString();
          AppMethodBeat.o(153331);
          return 0;
        }
        localfee.username = locala.UbS.readString();
        AppMethodBeat.o(153331);
        return 0;
      }
      AppMethodBeat.o(153331);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fee
 * JD-Core Version:    0.7.0.1
 */
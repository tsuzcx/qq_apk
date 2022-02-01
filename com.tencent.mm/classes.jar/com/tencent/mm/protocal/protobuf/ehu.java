package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehu
  extends com.tencent.mm.bx.a
{
  public String desc;
  public String pkr;
  public String title;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153331);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pkr != null) {
        paramVarArgs.d(1, this.pkr);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      AppMethodBeat.o(153331);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pkr == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.pkr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.desc);
      }
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.username);
      }
      AppMethodBeat.o(153331);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153331);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ehu localehu = (ehu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153331);
          return -1;
        case 1: 
          localehu.pkr = locala.NPN.readString();
          AppMethodBeat.o(153331);
          return 0;
        case 2: 
          localehu.title = locala.NPN.readString();
          AppMethodBeat.o(153331);
          return 0;
        case 3: 
          localehu.desc = locala.NPN.readString();
          AppMethodBeat.o(153331);
          return 0;
        }
        localehu.username = locala.NPN.readString();
        AppMethodBeat.o(153331);
        return 0;
      }
      AppMethodBeat.o(153331);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehu
 * JD-Core Version:    0.7.0.1
 */
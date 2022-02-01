package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aun
  extends com.tencent.mm.bx.a
{
  public String kXu;
  public String odo;
  public String path;
  public String title;
  public int type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123579);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.odo != null) {
        paramVarArgs.d(1, this.odo);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aR(3, this.type);
      if (this.kXu != null) {
        paramVarArgs.d(4, this.kXu);
      }
      if (this.username != null) {
        paramVarArgs.d(5, this.username);
      }
      if (this.path != null) {
        paramVarArgs.d(6, this.path);
      }
      AppMethodBeat.o(123579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.odo == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.odo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      i += f.a.a.b.b.a.bA(3, this.type);
      paramInt = i;
      if (this.kXu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.kXu);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.username);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.path);
      }
      AppMethodBeat.o(123579);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123579);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aun localaun = (aun)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123579);
          return -1;
        case 1: 
          localaun.odo = locala.KhF.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 2: 
          localaun.title = locala.KhF.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 3: 
          localaun.type = locala.KhF.xS();
          AppMethodBeat.o(123579);
          return 0;
        case 4: 
          localaun.kXu = locala.KhF.readString();
          AppMethodBeat.o(123579);
          return 0;
        case 5: 
          localaun.username = locala.KhF.readString();
          AppMethodBeat.o(123579);
          return 0;
        }
        localaun.path = locala.KhF.readString();
        AppMethodBeat.o(123579);
        return 0;
      }
      AppMethodBeat.o(123579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aun
 * JD-Core Version:    0.7.0.1
 */
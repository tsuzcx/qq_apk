package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ak
  extends com.tencent.mm.bx.a
{
  public String code;
  public String fileid;
  public String key;
  public String name;
  public int size;
  public String type;
  public String xcP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215225);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fileid != null) {
        paramVarArgs.d(1, this.fileid);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      paramVarArgs.aS(3, this.size);
      if (this.type != null) {
        paramVarArgs.d(4, this.type);
      }
      if (this.xcP != null) {
        paramVarArgs.d(5, this.xcP);
      }
      if (this.key != null) {
        paramVarArgs.d(6, this.key);
      }
      if (this.code != null) {
        paramVarArgs.d(7, this.code);
      }
      AppMethodBeat.o(215225);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileid == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.b.b.a.e(1, this.fileid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.name);
      }
      i += f.a.a.b.b.a.bz(3, this.size);
      paramInt = i;
      if (this.type != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.type);
      }
      i = paramInt;
      if (this.xcP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.xcP);
      }
      paramInt = i;
      if (this.key != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.key);
      }
      i = paramInt;
      if (this.code != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.code);
      }
      AppMethodBeat.o(215225);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(215225);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(215225);
          return -1;
        case 1: 
          localak.fileid = locala.NPN.readString();
          AppMethodBeat.o(215225);
          return 0;
        case 2: 
          localak.name = locala.NPN.readString();
          AppMethodBeat.o(215225);
          return 0;
        case 3: 
          localak.size = locala.NPN.zc();
          AppMethodBeat.o(215225);
          return 0;
        case 4: 
          localak.type = locala.NPN.readString();
          AppMethodBeat.o(215225);
          return 0;
        case 5: 
          localak.xcP = locala.NPN.readString();
          AppMethodBeat.o(215225);
          return 0;
        case 6: 
          localak.key = locala.NPN.readString();
          AppMethodBeat.o(215225);
          return 0;
        }
        localak.code = locala.NPN.readString();
        AppMethodBeat.o(215225);
        return 0;
      }
      AppMethodBeat.o(215225);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ak
 * JD-Core Version:    0.7.0.1
 */
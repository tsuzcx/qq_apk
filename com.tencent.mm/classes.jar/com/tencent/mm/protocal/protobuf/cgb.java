package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgb
  extends com.tencent.mm.bx.a
{
  public String Gdh;
  public String desc;
  public String detail;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72534);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.Gdh != null) {
        paramVarArgs.d(3, this.Gdh);
      }
      if (this.detail != null) {
        paramVarArgs.d(4, this.detail);
      }
      AppMethodBeat.o(72534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.Gdh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gdh);
      }
      paramInt = i;
      if (this.detail != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.detail);
      }
      AppMethodBeat.o(72534);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72534);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cgb localcgb = (cgb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72534);
          return -1;
        case 1: 
          localcgb.title = locala.NPN.readString();
          AppMethodBeat.o(72534);
          return 0;
        case 2: 
          localcgb.desc = locala.NPN.readString();
          AppMethodBeat.o(72534);
          return 0;
        case 3: 
          localcgb.Gdh = locala.NPN.readString();
          AppMethodBeat.o(72534);
          return 0;
        }
        localcgb.detail = locala.NPN.readString();
        AppMethodBeat.o(72534);
        return 0;
      }
      AppMethodBeat.o(72534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgb
 * JD-Core Version:    0.7.0.1
 */
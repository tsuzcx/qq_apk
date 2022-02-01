package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbg
  extends com.tencent.mm.bw.a
{
  public String HIh;
  public String desc;
  public String ivw;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72498);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.ivw != null) {
        paramVarArgs.e(3, this.ivw);
      }
      if (this.HIh != null) {
        paramVarArgs.e(4, this.HIh);
      }
      AppMethodBeat.o(72498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.ivw != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ivw);
      }
      paramInt = i;
      if (this.HIh != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.HIh);
      }
      AppMethodBeat.o(72498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72498);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cbg localcbg = (cbg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72498);
          return -1;
        case 1: 
          localcbg.title = locala.UbS.readString();
          AppMethodBeat.o(72498);
          return 0;
        case 2: 
          localcbg.desc = locala.UbS.readString();
          AppMethodBeat.o(72498);
          return 0;
        case 3: 
          localcbg.ivw = locala.UbS.readString();
          AppMethodBeat.o(72498);
          return 0;
        }
        localcbg.HIh = locala.UbS.readString();
        AppMethodBeat.o(72498);
        return 0;
      }
      AppMethodBeat.o(72498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eb
  extends com.tencent.mm.bw.a
{
  public String DQK;
  public String DQL;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50079);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content == null)
      {
        paramVarArgs = new b("Not all required fields were included: content");
        AppMethodBeat.o(50079);
        throw paramVarArgs;
      }
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.DQK != null) {
        paramVarArgs.d(2, this.DQK);
      }
      if (this.DQL != null) {
        paramVarArgs.d(3, this.DQL);
      }
      AppMethodBeat.o(50079);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label382;
      }
    }
    label382:
    for (int i = f.a.a.b.b.a.e(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DQK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DQK);
      }
      i = paramInt;
      if (this.DQL != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DQL);
      }
      AppMethodBeat.o(50079);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.content == null)
        {
          paramVarArgs = new b("Not all required fields were included: content");
          AppMethodBeat.o(50079);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50079);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eb localeb = (eb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50079);
          return -1;
        case 1: 
          localeb.content = locala.LVo.readString();
          AppMethodBeat.o(50079);
          return 0;
        case 2: 
          localeb.DQK = locala.LVo.readString();
          AppMethodBeat.o(50079);
          return 0;
        }
        localeb.DQL = locala.LVo.readString();
        AppMethodBeat.o(50079);
        return 0;
      }
      AppMethodBeat.o(50079);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eb
 * JD-Core Version:    0.7.0.1
 */
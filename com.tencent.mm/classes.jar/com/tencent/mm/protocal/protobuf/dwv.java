package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dwv
  extends com.tencent.mm.bw.a
{
  public long DUK;
  public String FDc;
  public String Title;
  public String hkR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32533);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32533);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(32533);
        throw paramVarArgs;
      }
      if (this.hkR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32533);
        throw paramVarArgs;
      }
      if (this.FDc != null) {
        paramVarArgs.d(1, this.FDc);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.hkR != null) {
        paramVarArgs.d(3, this.hkR);
      }
      paramVarArgs.aO(4, this.DUK);
      AppMethodBeat.o(32533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDc == null) {
        break label540;
      }
    }
    label540:
    for (int i = f.a.a.b.b.a.e(1, this.FDc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.hkR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hkR);
      }
      paramInt = f.a.a.b.b.a.p(4, this.DUK);
      AppMethodBeat.o(32533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FDc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32533);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(32533);
          throw paramVarArgs;
        }
        if (this.hkR == null)
        {
          paramVarArgs = new b("Not all required fields were included: Content");
          AppMethodBeat.o(32533);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32533);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dwv localdwv = (dwv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32533);
          return -1;
        case 1: 
          localdwv.FDc = locala.LVo.readString();
          AppMethodBeat.o(32533);
          return 0;
        case 2: 
          localdwv.Title = locala.LVo.readString();
          AppMethodBeat.o(32533);
          return 0;
        case 3: 
          localdwv.hkR = locala.LVo.readString();
          AppMethodBeat.o(32533);
          return 0;
        }
        localdwv.DUK = locala.LVo.xG();
        AppMethodBeat.o(32533);
        return 0;
      }
      AppMethodBeat.o(32533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwv
 * JD-Core Version:    0.7.0.1
 */
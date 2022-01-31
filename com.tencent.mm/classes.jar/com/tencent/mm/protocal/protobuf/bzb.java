package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bzb
  extends com.tencent.mm.bv.a
{
  public String gfL;
  public String wpd;
  public String xLf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80184);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.gfL == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(80184);
        throw paramVarArgs;
      }
      if (this.xLf == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_content");
        AppMethodBeat.o(80184);
        throw paramVarArgs;
      }
      if (this.wpd == null)
      {
        paramVarArgs = new b("Not all required fields were included: antispam_ticket");
        AppMethodBeat.o(80184);
        throw paramVarArgs;
      }
      if (this.gfL != null) {
        paramVarArgs.e(1, this.gfL);
      }
      if (this.xLf != null) {
        paramVarArgs.e(2, this.xLf);
      }
      if (this.wpd != null) {
        paramVarArgs.e(3, this.wpd);
      }
      AppMethodBeat.o(80184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.gfL == null) {
        break label478;
      }
    }
    label478:
    for (int i = e.a.a.b.b.a.f(1, this.gfL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xLf != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xLf);
      }
      i = paramInt;
      if (this.wpd != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wpd);
      }
      AppMethodBeat.o(80184);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.gfL == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(80184);
          throw paramVarArgs;
        }
        if (this.xLf == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_content");
          AppMethodBeat.o(80184);
          throw paramVarArgs;
        }
        if (this.wpd == null)
        {
          paramVarArgs = new b("Not all required fields were included: antispam_ticket");
          AppMethodBeat.o(80184);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80184);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bzb localbzb = (bzb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(80184);
          return -1;
        case 1: 
          localbzb.gfL = locala.CLY.readString();
          AppMethodBeat.o(80184);
          return 0;
        case 2: 
          localbzb.xLf = locala.CLY.readString();
          AppMethodBeat.o(80184);
          return 0;
        }
        localbzb.wpd = locala.CLY.readString();
        AppMethodBeat.o(80184);
        return 0;
      }
      AppMethodBeat.o(80184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzb
 * JD-Core Version:    0.7.0.1
 */
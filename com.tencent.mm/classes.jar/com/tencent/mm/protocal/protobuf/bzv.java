package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzv
  extends com.tencent.mm.bw.a
{
  public String KPA;
  public String LRO;
  public String Mft;
  public String Mfu;
  public int Ret;
  public String UserName;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155421);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KPA != null) {
        paramVarArgs.e(1, this.KPA);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.Mft != null) {
        paramVarArgs.e(3, this.Mft);
      }
      if (this.Mfu != null) {
        paramVarArgs.e(4, this.Mfu);
      }
      paramVarArgs.aM(5, this.Ret);
      if (this.oUJ != null) {
        paramVarArgs.e(6, this.oUJ);
      }
      if (this.LRO != null) {
        paramVarArgs.e(7, this.LRO);
      }
      AppMethodBeat.o(155421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KPA == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.f(1, this.KPA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.Mft != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mft);
      }
      paramInt = i;
      if (this.Mfu != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mfu);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Ret);
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.oUJ);
      }
      i = paramInt;
      if (this.LRO != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LRO);
      }
      AppMethodBeat.o(155421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(155421);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bzv localbzv = (bzv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155421);
          return -1;
        case 1: 
          localbzv.KPA = locala.UbS.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 2: 
          localbzv.UserName = locala.UbS.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 3: 
          localbzv.Mft = locala.UbS.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 4: 
          localbzv.Mfu = locala.UbS.readString();
          AppMethodBeat.o(155421);
          return 0;
        case 5: 
          localbzv.Ret = locala.UbS.zi();
          AppMethodBeat.o(155421);
          return 0;
        case 6: 
          localbzv.oUJ = locala.UbS.readString();
          AppMethodBeat.o(155421);
          return 0;
        }
        localbzv.LRO = locala.UbS.readString();
        AppMethodBeat.o(155421);
        return 0;
      }
      AppMethodBeat.o(155421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzv
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dza
  extends com.tencent.mm.bw.a
{
  public int Gfl;
  public int Gfm;
  public String Md5;
  public String sVp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110860);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(110860);
        throw paramVarArgs;
      }
      if (this.sVp == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadUrl");
        AppMethodBeat.o(110860);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.sVp != null) {
        paramVarArgs.d(2, this.sVp);
      }
      paramVarArgs.aR(3, this.Gfl);
      paramVarArgs.aR(4, this.Gfm);
      AppMethodBeat.o(110860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.b.b.a.e(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sVp != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.sVp);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Gfl);
      int j = f.a.a.b.b.a.bx(4, this.Gfm);
      AppMethodBeat.o(110860);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(110860);
          throw paramVarArgs;
        }
        if (this.sVp == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadUrl");
          AppMethodBeat.o(110860);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110860);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dza localdza = (dza)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110860);
          return -1;
        case 1: 
          localdza.Md5 = locala.LVo.readString();
          AppMethodBeat.o(110860);
          return 0;
        case 2: 
          localdza.sVp = locala.LVo.readString();
          AppMethodBeat.o(110860);
          return 0;
        case 3: 
          localdza.Gfl = locala.LVo.xF();
          AppMethodBeat.o(110860);
          return 0;
        }
        localdza.Gfm = locala.LVo.xF();
        AppMethodBeat.o(110860);
        return 0;
      }
      AppMethodBeat.o(110860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dza
 * JD-Core Version:    0.7.0.1
 */
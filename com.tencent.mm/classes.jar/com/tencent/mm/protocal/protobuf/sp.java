package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class sp
  extends com.tencent.mm.bw.a
{
  public String appId;
  public int dQv;
  public String md5;
  public String path;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213855);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.d(1, this.appId);
      }
      if (this.path != null) {
        paramVarArgs.d(2, this.path);
      }
      paramVarArgs.aS(3, this.version);
      paramVarArgs.aS(4, this.dQv);
      if (this.md5 != null) {
        paramVarArgs.d(5, this.md5);
      }
      AppMethodBeat.o(213855);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.appId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.path);
      }
      i = i + f.a.a.b.b.a.bz(3, this.version) + f.a.a.b.b.a.bz(4, this.dQv);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.md5);
      }
      AppMethodBeat.o(213855);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(213855);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        sp localsp = (sp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(213855);
          return -1;
        case 1: 
          localsp.appId = locala.OmT.readString();
          AppMethodBeat.o(213855);
          return 0;
        case 2: 
          localsp.path = locala.OmT.readString();
          AppMethodBeat.o(213855);
          return 0;
        case 3: 
          localsp.version = locala.OmT.zc();
          AppMethodBeat.o(213855);
          return 0;
        case 4: 
          localsp.dQv = locala.OmT.zc();
          AppMethodBeat.o(213855);
          return 0;
        }
        localsp.md5 = locala.OmT.readString();
        AppMethodBeat.o(213855);
        return 0;
      }
      AppMethodBeat.o(213855);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sp
 * JD-Core Version:    0.7.0.1
 */
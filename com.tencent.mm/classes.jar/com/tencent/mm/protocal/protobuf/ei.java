package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ei
  extends com.tencent.mm.bw.a
{
  public int FOD;
  public String dwb;
  public String iaa;
  public String mwg;
  public String mwk;
  public int position;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50080);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.iaa != null) {
        paramVarArgs.d(2, this.iaa);
      }
      if (this.mwg != null) {
        paramVarArgs.d(3, this.mwg);
      }
      if (this.dwb != null) {
        paramVarArgs.d(4, this.dwb);
      }
      if (this.mwk != null) {
        paramVarArgs.d(5, this.mwk);
      }
      paramVarArgs.aS(6, this.position);
      paramVarArgs.aS(7, this.FOD);
      AppMethodBeat.o(50080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iaa != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iaa);
      }
      i = paramInt;
      if (this.mwg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mwg);
      }
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dwb);
      }
      i = paramInt;
      if (this.mwk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mwk);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.position);
      int j = f.a.a.b.b.a.bz(7, this.FOD);
      AppMethodBeat.o(50080);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(50080);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ei localei = (ei)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50080);
          return -1;
        case 1: 
          localei.username = locala.OmT.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 2: 
          localei.iaa = locala.OmT.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 3: 
          localei.mwg = locala.OmT.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 4: 
          localei.dwb = locala.OmT.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 5: 
          localei.mwk = locala.OmT.readString();
          AppMethodBeat.o(50080);
          return 0;
        case 6: 
          localei.position = locala.OmT.zc();
          AppMethodBeat.o(50080);
          return 0;
        }
        localei.FOD = locala.OmT.zc();
        AppMethodBeat.o(50080);
        return 0;
      }
      AppMethodBeat.o(50080);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ei
 * JD-Core Version:    0.7.0.1
 */
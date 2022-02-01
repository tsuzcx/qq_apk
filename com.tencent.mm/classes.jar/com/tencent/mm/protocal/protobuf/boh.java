package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boh
  extends com.tencent.mm.bx.a
{
  public String aeskey;
  public int fNA;
  public int fNB;
  public String fileid;
  public String filemd5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(219263);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fileid != null) {
        paramVarArgs.d(1, this.fileid);
      }
      if (this.aeskey != null) {
        paramVarArgs.d(2, this.aeskey);
      }
      if (this.filemd5 != null) {
        paramVarArgs.d(3, this.filemd5);
      }
      paramVarArgs.aS(4, this.fNA);
      paramVarArgs.aS(5, this.fNB);
      AppMethodBeat.o(219263);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileid == null) {
        break label426;
      }
    }
    label426:
    for (int i = f.a.a.b.b.a.e(1, this.fileid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aeskey != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.aeskey);
      }
      i = paramInt;
      if (this.filemd5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.filemd5);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.fNA);
      int j = f.a.a.b.b.a.bz(5, this.fNB);
      AppMethodBeat.o(219263);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(219263);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        boh localboh = (boh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(219263);
          return -1;
        case 1: 
          localboh.fileid = locala.NPN.readString();
          AppMethodBeat.o(219263);
          return 0;
        case 2: 
          localboh.aeskey = locala.NPN.readString();
          AppMethodBeat.o(219263);
          return 0;
        case 3: 
          localboh.filemd5 = locala.NPN.readString();
          AppMethodBeat.o(219263);
          return 0;
        case 4: 
          localboh.fNA = locala.NPN.zc();
          AppMethodBeat.o(219263);
          return 0;
        }
        localboh.fNB = locala.NPN.zc();
        AppMethodBeat.o(219263);
        return 0;
      }
      AppMethodBeat.o(219263);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boh
 * JD-Core Version:    0.7.0.1
 */
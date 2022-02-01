package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbr
  extends com.tencent.mm.bw.a
{
  public String aeskey;
  public String fileid;
  public String filemd5;
  public int guR;
  public int guS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194544);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fileid != null) {
        paramVarArgs.e(1, this.fileid);
      }
      if (this.aeskey != null) {
        paramVarArgs.e(2, this.aeskey);
      }
      if (this.filemd5 != null) {
        paramVarArgs.e(3, this.filemd5);
      }
      paramVarArgs.aM(4, this.guR);
      paramVarArgs.aM(5, this.guS);
      AppMethodBeat.o(194544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fileid == null) {
        break label426;
      }
    }
    label426:
    for (int i = g.a.a.b.b.a.f(1, this.fileid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aeskey != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.aeskey);
      }
      i = paramInt;
      if (this.filemd5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.filemd5);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.guR);
      int j = g.a.a.b.b.a.bu(5, this.guS);
      AppMethodBeat.o(194544);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(194544);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cbr localcbr = (cbr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194544);
          return -1;
        case 1: 
          localcbr.fileid = locala.UbS.readString();
          AppMethodBeat.o(194544);
          return 0;
        case 2: 
          localcbr.aeskey = locala.UbS.readString();
          AppMethodBeat.o(194544);
          return 0;
        case 3: 
          localcbr.filemd5 = locala.UbS.readString();
          AppMethodBeat.o(194544);
          return 0;
        case 4: 
          localcbr.guR = locala.UbS.zi();
          AppMethodBeat.o(194544);
          return 0;
        }
        localcbr.guS = locala.UbS.zi();
        AppMethodBeat.o(194544);
        return 0;
      }
      AppMethodBeat.o(194544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbr
 * JD-Core Version:    0.7.0.1
 */
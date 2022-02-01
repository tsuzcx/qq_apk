package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwp
  extends com.tencent.mm.bw.a
{
  public String EUn;
  public String EWr;
  public String EWs;
  public String dlt;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123628);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EUn != null) {
        paramVarArgs.d(1, this.EUn);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.dlt != null) {
        paramVarArgs.d(3, this.dlt);
      }
      if (this.EWr != null) {
        paramVarArgs.d(4, this.EWr);
      }
      if (this.EWs != null) {
        paramVarArgs.d(5, this.EWs);
      }
      AppMethodBeat.o(123628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EUn == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.EUn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.dlt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlt);
      }
      paramInt = i;
      if (this.EWr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EWr);
      }
      i = paramInt;
      if (this.EWs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EWs);
      }
      AppMethodBeat.o(123628);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123628);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bwp localbwp = (bwp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123628);
          return -1;
        case 1: 
          localbwp.EUn = locala.LVo.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 2: 
          localbwp.url = locala.LVo.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 3: 
          localbwp.dlt = locala.LVo.readString();
          AppMethodBeat.o(123628);
          return 0;
        case 4: 
          localbwp.EWr = locala.LVo.readString();
          AppMethodBeat.o(123628);
          return 0;
        }
        localbwp.EWs = locala.LVo.readString();
        AppMethodBeat.o(123628);
        return 0;
      }
      AppMethodBeat.o(123628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwp
 * JD-Core Version:    0.7.0.1
 */
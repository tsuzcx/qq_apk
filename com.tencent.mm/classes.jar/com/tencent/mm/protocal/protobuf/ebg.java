package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebg
  extends com.tencent.mm.bw.a
{
  public String EWr;
  public String EWs;
  public String GgR;
  public String dlt;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123707);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GgR != null) {
        paramVarArgs.d(1, this.GgR);
      }
      paramVarArgs.aR(2, this.version);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.dlt != null) {
        paramVarArgs.d(4, this.dlt);
      }
      if (this.EWr != null) {
        paramVarArgs.d(5, this.EWr);
      }
      if (this.EWs != null) {
        paramVarArgs.d(6, this.EWs);
      }
      AppMethodBeat.o(123707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GgR == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.GgR) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt;
      if (this.dlt != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dlt);
      }
      paramInt = i;
      if (this.EWr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EWr);
      }
      i = paramInt;
      if (this.EWs != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EWs);
      }
      AppMethodBeat.o(123707);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123707);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebg localebg = (ebg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123707);
          return -1;
        case 1: 
          localebg.GgR = locala.LVo.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 2: 
          localebg.version = locala.LVo.xF();
          AppMethodBeat.o(123707);
          return 0;
        case 3: 
          localebg.url = locala.LVo.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 4: 
          localebg.dlt = locala.LVo.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 5: 
          localebg.EWr = locala.LVo.readString();
          AppMethodBeat.o(123707);
          return 0;
        }
        localebg.EWs = locala.LVo.readString();
        AppMethodBeat.o(123707);
        return 0;
      }
      AppMethodBeat.o(123707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebg
 * JD-Core Version:    0.7.0.1
 */
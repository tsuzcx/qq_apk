package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class hc
  extends com.tencent.mm.bw.a
{
  public String dlQ;
  public String oQo;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlQ != null) {
        paramVarArgs.d(1, this.dlQ);
      }
      if (this.oQo != null) {
        paramVarArgs.d(2, this.oQo);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      AppMethodBeat.o(123552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlQ == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.dlQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oQo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oQo);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      AppMethodBeat.o(123552);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123552);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        hc localhc = (hc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123552);
          return -1;
        case 1: 
          localhc.dlQ = locala.LVo.readString();
          AppMethodBeat.o(123552);
          return 0;
        case 2: 
          localhc.oQo = locala.LVo.readString();
          AppMethodBeat.o(123552);
          return 0;
        }
        localhc.title = locala.LVo.readString();
        AppMethodBeat.o(123552);
        return 0;
      }
      AppMethodBeat.o(123552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hc
 * JD-Core Version:    0.7.0.1
 */
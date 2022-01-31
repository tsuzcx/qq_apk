package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kd
  extends com.tencent.mm.bv.a
{
  public long kfs;
  public int kft;
  public String url;
  public String wqR;
  public long wqU;
  public long wxd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11695);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wqR != null) {
        paramVarArgs.e(1, this.wqR);
      }
      paramVarArgs.am(2, this.kfs);
      paramVarArgs.am(3, this.wqU);
      paramVarArgs.am(4, this.wxd);
      paramVarArgs.aO(5, this.kft);
      if (this.url != null) {
        paramVarArgs.e(6, this.url);
      }
      AppMethodBeat.o(11695);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wqR == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = e.a.a.b.b.a.f(1, this.wqR) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.kfs) + e.a.a.b.b.a.p(3, this.wqU) + e.a.a.b.b.a.p(4, this.wxd) + e.a.a.b.b.a.bl(5, this.kft);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.url);
      }
      AppMethodBeat.o(11695);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11695);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        kd localkd = (kd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11695);
          return -1;
        case 1: 
          localkd.wqR = locala.CLY.readString();
          AppMethodBeat.o(11695);
          return 0;
        case 2: 
          localkd.kfs = locala.CLY.sm();
          AppMethodBeat.o(11695);
          return 0;
        case 3: 
          localkd.wqU = locala.CLY.sm();
          AppMethodBeat.o(11695);
          return 0;
        case 4: 
          localkd.wxd = locala.CLY.sm();
          AppMethodBeat.o(11695);
          return 0;
        case 5: 
          localkd.kft = locala.CLY.sl();
          AppMethodBeat.o(11695);
          return 0;
        }
        localkd.url = locala.CLY.readString();
        AppMethodBeat.o(11695);
        return 0;
      }
      AppMethodBeat.o(11695);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kd
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class io
  extends com.tencent.mm.bw.a
{
  public String DWr;
  public String DWs;
  public String DWt;
  public String DWu;
  public String DWv;
  public String nWj;
  public String oGN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124392);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DWr != null) {
        paramVarArgs.d(1, this.DWr);
      }
      if (this.DWs != null) {
        paramVarArgs.d(2, this.DWs);
      }
      if (this.DWt != null) {
        paramVarArgs.d(3, this.DWt);
      }
      if (this.oGN != null) {
        paramVarArgs.d(4, this.oGN);
      }
      if (this.nWj != null) {
        paramVarArgs.d(5, this.nWj);
      }
      if (this.DWu != null) {
        paramVarArgs.d(6, this.DWu);
      }
      if (this.DWv != null) {
        paramVarArgs.d(7, this.DWv);
      }
      AppMethodBeat.o(124392);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DWr == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.DWr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DWs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DWs);
      }
      i = paramInt;
      if (this.DWt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DWt);
      }
      paramInt = i;
      if (this.oGN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oGN);
      }
      i = paramInt;
      if (this.nWj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nWj);
      }
      paramInt = i;
      if (this.DWu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DWu);
      }
      i = paramInt;
      if (this.DWv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DWv);
      }
      AppMethodBeat.o(124392);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124392);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        io localio = (io)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124392);
          return -1;
        case 1: 
          localio.DWr = locala.LVo.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 2: 
          localio.DWs = locala.LVo.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 3: 
          localio.DWt = locala.LVo.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 4: 
          localio.oGN = locala.LVo.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 5: 
          localio.nWj = locala.LVo.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 6: 
          localio.DWu = locala.LVo.readString();
          AppMethodBeat.o(124392);
          return 0;
        }
        localio.DWv = locala.LVo.readString();
        AppMethodBeat.o(124392);
        return 0;
      }
      AppMethodBeat.o(124392);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.io
 * JD-Core Version:    0.7.0.1
 */
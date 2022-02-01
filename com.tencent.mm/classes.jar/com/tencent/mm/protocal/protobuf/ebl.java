package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebl
  extends com.tencent.mm.bw.a
{
  public String DPF;
  public String DPS;
  public int Eae;
  public int GgV;
  public String Username;
  public String tlT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.tlT != null) {
        paramVarArgs.d(2, this.tlT);
      }
      paramVarArgs.aR(3, this.Eae);
      if (this.DPF != null) {
        paramVarArgs.d(4, this.DPF);
      }
      paramVarArgs.aR(5, this.GgV);
      if (this.DPS != null) {
        paramVarArgs.d(6, this.DPS);
      }
      AppMethodBeat.o(117959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label486;
      }
    }
    label486:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tlT != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.tlT);
      }
      i += f.a.a.b.b.a.bx(3, this.Eae);
      paramInt = i;
      if (this.DPF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DPF);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.GgV);
      paramInt = i;
      if (this.DPS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DPS);
      }
      AppMethodBeat.o(117959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117959);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebl localebl = (ebl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117959);
          return -1;
        case 1: 
          localebl.Username = locala.LVo.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 2: 
          localebl.tlT = locala.LVo.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 3: 
          localebl.Eae = locala.LVo.xF();
          AppMethodBeat.o(117959);
          return 0;
        case 4: 
          localebl.DPF = locala.LVo.readString();
          AppMethodBeat.o(117959);
          return 0;
        case 5: 
          localebl.GgV = locala.LVo.xF();
          AppMethodBeat.o(117959);
          return 0;
        }
        localebl.DPS = locala.LVo.readString();
        AppMethodBeat.o(117959);
        return 0;
      }
      AppMethodBeat.o(117959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bb
  extends com.tencent.mm.bw.a
{
  public String DNA;
  public String DNB;
  public String DNC;
  public String DND;
  public String DNE;
  public long DNz;
  public String exV;
  public String exW;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91341);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.exV != null) {
        paramVarArgs.d(1, this.exV);
      }
      if (this.exW != null) {
        paramVarArgs.d(2, this.exW);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      paramVarArgs.aO(5, this.DNz);
      if (this.DNA != null) {
        paramVarArgs.d(6, this.DNA);
      }
      if (this.DNB != null) {
        paramVarArgs.d(7, this.DNB);
      }
      if (this.DNC != null) {
        paramVarArgs.d(8, this.DNC);
      }
      if (this.DND != null) {
        paramVarArgs.d(9, this.DND);
      }
      if (this.DNE != null) {
        paramVarArgs.d(10, this.DNE);
      }
      AppMethodBeat.o(91341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.exV == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = f.a.a.b.b.a.e(1, this.exV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.exW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.exW);
      }
      i = i + (f.a.a.b.b.a.fK(3) + 8) + (f.a.a.b.b.a.fK(4) + 8) + f.a.a.b.b.a.p(5, this.DNz);
      paramInt = i;
      if (this.DNA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DNA);
      }
      i = paramInt;
      if (this.DNB != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DNB);
      }
      paramInt = i;
      if (this.DNC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DNC);
      }
      i = paramInt;
      if (this.DND != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DND);
      }
      paramInt = i;
      if (this.DNE != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DNE);
      }
      AppMethodBeat.o(91341);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91341);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bb localbb = (bb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91341);
          return -1;
        case 1: 
          localbb.exV = locala.LVo.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 2: 
          localbb.exW = locala.LVo.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 3: 
          localbb.latitude = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(91341);
          return 0;
        case 4: 
          localbb.longitude = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(91341);
          return 0;
        case 5: 
          localbb.DNz = locala.LVo.xG();
          AppMethodBeat.o(91341);
          return 0;
        case 6: 
          localbb.DNA = locala.LVo.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 7: 
          localbb.DNB = locala.LVo.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 8: 
          localbb.DNC = locala.LVo.readString();
          AppMethodBeat.o(91341);
          return 0;
        case 9: 
          localbb.DND = locala.LVo.readString();
          AppMethodBeat.o(91341);
          return 0;
        }
        localbb.DNE = locala.LVo.readString();
        AppMethodBeat.o(91341);
        return 0;
      }
      AppMethodBeat.o(91341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bb
 * JD-Core Version:    0.7.0.1
 */
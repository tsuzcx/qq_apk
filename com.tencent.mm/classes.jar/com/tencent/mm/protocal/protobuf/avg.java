package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class avg
  extends com.tencent.mm.bv.a
{
  public int iFL;
  public String kWy;
  public int kmb;
  public String knv;
  public String oiG;
  public String qgx;
  public int state;
  public String wks;
  public int wyt;
  public String xcf;
  public long xkB;
  public String xkD;
  public int xkF;
  public int xkG;
  public String xkH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48872);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xcf != null) {
        paramVarArgs.e(1, this.xcf);
      }
      if (this.wks != null) {
        paramVarArgs.e(2, this.wks);
      }
      paramVarArgs.am(3, this.xkB);
      paramVarArgs.aO(4, this.state);
      paramVarArgs.aO(5, this.wyt);
      paramVarArgs.aO(6, this.kmb);
      paramVarArgs.aO(7, this.xkF);
      paramVarArgs.aO(8, this.xkG);
      if (this.xkH != null) {
        paramVarArgs.e(9, this.xkH);
      }
      if (this.knv != null) {
        paramVarArgs.e(10, this.knv);
      }
      if (this.oiG != null) {
        paramVarArgs.e(11, this.oiG);
      }
      if (this.kWy != null) {
        paramVarArgs.e(12, this.kWy);
      }
      if (this.qgx != null) {
        paramVarArgs.e(13, this.qgx);
      }
      if (this.xkD != null) {
        paramVarArgs.e(14, this.xkD);
      }
      paramVarArgs.aO(15, this.iFL);
      AppMethodBeat.o(48872);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xcf == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = e.a.a.b.b.a.f(1, this.xcf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wks != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wks);
      }
      i = i + e.a.a.b.b.a.p(3, this.xkB) + e.a.a.b.b.a.bl(4, this.state) + e.a.a.b.b.a.bl(5, this.wyt) + e.a.a.b.b.a.bl(6, this.kmb) + e.a.a.b.b.a.bl(7, this.xkF) + e.a.a.b.b.a.bl(8, this.xkG);
      paramInt = i;
      if (this.xkH != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xkH);
      }
      i = paramInt;
      if (this.knv != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.knv);
      }
      paramInt = i;
      if (this.oiG != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.oiG);
      }
      i = paramInt;
      if (this.kWy != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.kWy);
      }
      paramInt = i;
      if (this.qgx != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.qgx);
      }
      i = paramInt;
      if (this.xkD != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.xkD);
      }
      paramInt = e.a.a.b.b.a.bl(15, this.iFL);
      AppMethodBeat.o(48872);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48872);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        avg localavg = (avg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48872);
          return -1;
        case 1: 
          localavg.xcf = locala.CLY.readString();
          AppMethodBeat.o(48872);
          return 0;
        case 2: 
          localavg.wks = locala.CLY.readString();
          AppMethodBeat.o(48872);
          return 0;
        case 3: 
          localavg.xkB = locala.CLY.sm();
          AppMethodBeat.o(48872);
          return 0;
        case 4: 
          localavg.state = locala.CLY.sl();
          AppMethodBeat.o(48872);
          return 0;
        case 5: 
          localavg.wyt = locala.CLY.sl();
          AppMethodBeat.o(48872);
          return 0;
        case 6: 
          localavg.kmb = locala.CLY.sl();
          AppMethodBeat.o(48872);
          return 0;
        case 7: 
          localavg.xkF = locala.CLY.sl();
          AppMethodBeat.o(48872);
          return 0;
        case 8: 
          localavg.xkG = locala.CLY.sl();
          AppMethodBeat.o(48872);
          return 0;
        case 9: 
          localavg.xkH = locala.CLY.readString();
          AppMethodBeat.o(48872);
          return 0;
        case 10: 
          localavg.knv = locala.CLY.readString();
          AppMethodBeat.o(48872);
          return 0;
        case 11: 
          localavg.oiG = locala.CLY.readString();
          AppMethodBeat.o(48872);
          return 0;
        case 12: 
          localavg.kWy = locala.CLY.readString();
          AppMethodBeat.o(48872);
          return 0;
        case 13: 
          localavg.qgx = locala.CLY.readString();
          AppMethodBeat.o(48872);
          return 0;
        case 14: 
          localavg.xkD = locala.CLY.readString();
          AppMethodBeat.o(48872);
          return 0;
        }
        localavg.iFL = locala.CLY.sl();
        AppMethodBeat.o(48872);
        return 0;
      }
      AppMethodBeat.o(48872);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avg
 * JD-Core Version:    0.7.0.1
 */
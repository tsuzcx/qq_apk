package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbu
  extends com.tencent.mm.bv.a
{
  public String cHn;
  public String cHo;
  public String kml;
  public String wlF;
  public String wlG;
  public int wlH;
  public String wqH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89140);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cHn != null) {
        paramVarArgs.e(1, this.cHn);
      }
      if (this.kml != null) {
        paramVarArgs.e(2, this.kml);
      }
      if (this.cHo != null) {
        paramVarArgs.e(3, this.cHo);
      }
      if (this.wlF != null) {
        paramVarArgs.e(4, this.wlF);
      }
      if (this.wlG != null) {
        paramVarArgs.e(5, this.wlG);
      }
      paramVarArgs.aO(6, this.wlH);
      if (this.wqH != null) {
        paramVarArgs.e(7, this.wqH);
      }
      AppMethodBeat.o(89140);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cHn == null) {
        break label562;
      }
    }
    label562:
    for (int i = e.a.a.b.b.a.f(1, this.cHn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kml != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.kml);
      }
      i = paramInt;
      if (this.cHo != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cHo);
      }
      paramInt = i;
      if (this.wlF != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wlF);
      }
      i = paramInt;
      if (this.wlG != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wlG);
      }
      i += e.a.a.b.b.a.bl(6, this.wlH);
      paramInt = i;
      if (this.wqH != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wqH);
      }
      AppMethodBeat.o(89140);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89140);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cbu localcbu = (cbu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(89140);
          return -1;
        case 1: 
          localcbu.cHn = locala.CLY.readString();
          AppMethodBeat.o(89140);
          return 0;
        case 2: 
          localcbu.kml = locala.CLY.readString();
          AppMethodBeat.o(89140);
          return 0;
        case 3: 
          localcbu.cHo = locala.CLY.readString();
          AppMethodBeat.o(89140);
          return 0;
        case 4: 
          localcbu.wlF = locala.CLY.readString();
          AppMethodBeat.o(89140);
          return 0;
        case 5: 
          localcbu.wlG = locala.CLY.readString();
          AppMethodBeat.o(89140);
          return 0;
        case 6: 
          localcbu.wlH = locala.CLY.sl();
          AppMethodBeat.o(89140);
          return 0;
        }
        localcbu.wqH = locala.CLY.readString();
        AppMethodBeat.o(89140);
        return 0;
      }
      AppMethodBeat.o(89140);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbu
 * JD-Core Version:    0.7.0.1
 */
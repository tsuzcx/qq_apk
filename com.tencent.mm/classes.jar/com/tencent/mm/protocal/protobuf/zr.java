package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class zr
  extends com.tencent.mm.bv.a
{
  public String wQD;
  public String wQE;
  public String wQF;
  public String wQG;
  public String wQH;
  public int wQI;
  public int wQJ;
  public String wQK;
  public int woE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62544);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wQD == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegWord");
        AppMethodBeat.o(62544);
        throw paramVarArgs;
      }
      if (this.wQE == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegPicUrl");
        AppMethodBeat.o(62544);
        throw paramVarArgs;
      }
      if (this.wQF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
        AppMethodBeat.o(62544);
        throw paramVarArgs;
      }
      if (this.wQD != null) {
        paramVarArgs.e(1, this.wQD);
      }
      if (this.wQE != null) {
        paramVarArgs.e(2, this.wQE);
      }
      if (this.wQF != null) {
        paramVarArgs.e(3, this.wQF);
      }
      if (this.wQG != null) {
        paramVarArgs.e(4, this.wQG);
      }
      if (this.wQH != null) {
        paramVarArgs.e(5, this.wQH);
      }
      paramVarArgs.aO(6, this.wQI);
      paramVarArgs.aO(7, this.wQJ);
      if (this.wQK != null) {
        paramVarArgs.e(8, this.wQK);
      }
      paramVarArgs.aO(9, this.woE);
      AppMethodBeat.o(62544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wQD == null) {
        break label798;
      }
    }
    label798:
    for (int i = e.a.a.b.b.a.f(1, this.wQD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wQE != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wQE);
      }
      i = paramInt;
      if (this.wQF != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wQF);
      }
      paramInt = i;
      if (this.wQG != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wQG);
      }
      i = paramInt;
      if (this.wQH != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wQH);
      }
      i = i + e.a.a.b.b.a.bl(6, this.wQI) + e.a.a.b.b.a.bl(7, this.wQJ);
      paramInt = i;
      if (this.wQK != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wQK);
      }
      i = e.a.a.b.b.a.bl(9, this.woE);
      AppMethodBeat.o(62544);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wQD == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegWord");
          AppMethodBeat.o(62544);
          throw paramVarArgs;
        }
        if (this.wQE == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegPicUrl");
          AppMethodBeat.o(62544);
          throw paramVarArgs;
        }
        if (this.wQF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
          AppMethodBeat.o(62544);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62544);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        zr localzr = (zr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62544);
          return -1;
        case 1: 
          localzr.wQD = locala.CLY.readString();
          AppMethodBeat.o(62544);
          return 0;
        case 2: 
          localzr.wQE = locala.CLY.readString();
          AppMethodBeat.o(62544);
          return 0;
        case 3: 
          localzr.wQF = locala.CLY.readString();
          AppMethodBeat.o(62544);
          return 0;
        case 4: 
          localzr.wQG = locala.CLY.readString();
          AppMethodBeat.o(62544);
          return 0;
        case 5: 
          localzr.wQH = locala.CLY.readString();
          AppMethodBeat.o(62544);
          return 0;
        case 6: 
          localzr.wQI = locala.CLY.sl();
          AppMethodBeat.o(62544);
          return 0;
        case 7: 
          localzr.wQJ = locala.CLY.sl();
          AppMethodBeat.o(62544);
          return 0;
        case 8: 
          localzr.wQK = locala.CLY.readString();
          AppMethodBeat.o(62544);
          return 0;
        }
        localzr.woE = locala.CLY.sl();
        AppMethodBeat.o(62544);
        return 0;
      }
      AppMethodBeat.o(62544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zr
 * JD-Core Version:    0.7.0.1
 */
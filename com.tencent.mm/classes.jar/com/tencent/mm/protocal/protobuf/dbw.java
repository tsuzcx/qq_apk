package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbw
  extends com.tencent.mm.bv.a
{
  public String nuA;
  public int nuB;
  public String nux;
  public String nuz;
  public String wxa;
  public int yic;
  public String yid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80213);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.yic);
      if (this.wxa != null) {
        paramVarArgs.e(2, this.wxa);
      }
      if (this.nux != null) {
        paramVarArgs.e(3, this.nux);
      }
      if (this.yid != null) {
        paramVarArgs.e(4, this.yid);
      }
      if (this.nuz != null) {
        paramVarArgs.e(5, this.nuz);
      }
      if (this.nuA != null) {
        paramVarArgs.e(6, this.nuA);
      }
      paramVarArgs.aO(7, this.nuB);
      AppMethodBeat.o(80213);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.yic) + 0;
      paramInt = i;
      if (this.wxa != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wxa);
      }
      i = paramInt;
      if (this.nux != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nux);
      }
      paramInt = i;
      if (this.yid != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.yid);
      }
      i = paramInt;
      if (this.nuz != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nuz);
      }
      paramInt = i;
      if (this.nuA != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.nuA);
      }
      i = e.a.a.b.b.a.bl(7, this.nuB);
      AppMethodBeat.o(80213);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(80213);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dbw localdbw = (dbw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(80213);
        return -1;
      case 1: 
        localdbw.yic = locala.CLY.sl();
        AppMethodBeat.o(80213);
        return 0;
      case 2: 
        localdbw.wxa = locala.CLY.readString();
        AppMethodBeat.o(80213);
        return 0;
      case 3: 
        localdbw.nux = locala.CLY.readString();
        AppMethodBeat.o(80213);
        return 0;
      case 4: 
        localdbw.yid = locala.CLY.readString();
        AppMethodBeat.o(80213);
        return 0;
      case 5: 
        localdbw.nuz = locala.CLY.readString();
        AppMethodBeat.o(80213);
        return 0;
      case 6: 
        localdbw.nuA = locala.CLY.readString();
        AppMethodBeat.o(80213);
        return 0;
      }
      localdbw.nuB = locala.CLY.sl();
      AppMethodBeat.o(80213);
      return 0;
    }
    AppMethodBeat.o(80213);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbw
 * JD-Core Version:    0.7.0.1
 */
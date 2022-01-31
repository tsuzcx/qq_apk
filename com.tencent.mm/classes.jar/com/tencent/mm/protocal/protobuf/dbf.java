package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbf
  extends com.tencent.mm.bv.a
{
  public String session_id;
  public String ygb;
  public int yhq;
  public int yhr;
  public String yhs;
  public int yht;
  public boolean yhu = false;
  public boolean yhv = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124389);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.yhq);
      paramVarArgs.aO(2, this.yhr);
      if (this.session_id != null) {
        paramVarArgs.e(3, this.session_id);
      }
      if (this.yhs != null) {
        paramVarArgs.e(4, this.yhs);
      }
      if (this.ygb != null) {
        paramVarArgs.e(5, this.ygb);
      }
      paramVarArgs.aO(6, this.yht);
      paramVarArgs.aS(7, this.yhu);
      paramVarArgs.aS(8, this.yhv);
      AppMethodBeat.o(124389);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.yhq) + 0 + e.a.a.b.b.a.bl(2, this.yhr);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.session_id);
      }
      i = paramInt;
      if (this.yhs != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.yhs);
      }
      paramInt = i;
      if (this.ygb != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.ygb);
      }
      i = e.a.a.b.b.a.bl(6, this.yht);
      int j = e.a.a.b.b.a.eW(7);
      int k = e.a.a.b.b.a.eW(8);
      AppMethodBeat.o(124389);
      return paramInt + i + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(124389);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dbf localdbf = (dbf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124389);
        return -1;
      case 1: 
        localdbf.yhq = locala.CLY.sl();
        AppMethodBeat.o(124389);
        return 0;
      case 2: 
        localdbf.yhr = locala.CLY.sl();
        AppMethodBeat.o(124389);
        return 0;
      case 3: 
        localdbf.session_id = locala.CLY.readString();
        AppMethodBeat.o(124389);
        return 0;
      case 4: 
        localdbf.yhs = locala.CLY.readString();
        AppMethodBeat.o(124389);
        return 0;
      case 5: 
        localdbf.ygb = locala.CLY.readString();
        AppMethodBeat.o(124389);
        return 0;
      case 6: 
        localdbf.yht = locala.CLY.sl();
        AppMethodBeat.o(124389);
        return 0;
      case 7: 
        localdbf.yhu = locala.CLY.emu();
        AppMethodBeat.o(124389);
        return 0;
      }
      localdbf.yhv = locala.CLY.emu();
      AppMethodBeat.o(124389);
      return 0;
    }
    AppMethodBeat.o(124389);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbf
 * JD-Core Version:    0.7.0.1
 */
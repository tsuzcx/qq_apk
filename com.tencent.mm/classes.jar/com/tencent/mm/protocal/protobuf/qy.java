package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qy
  extends com.tencent.mm.bv.a
{
  public int kWr;
  public String kWs;
  public String kWx;
  public String kWy;
  public String kXk;
  public int wJd;
  public String wJe;
  public int wJf;
  public String wJg;
  public int wJh;
  public String wJi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94513);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wJd);
      if (this.kXk != null) {
        paramVarArgs.e(2, this.kXk);
      }
      if (this.wJe != null) {
        paramVarArgs.e(3, this.wJe);
      }
      if (this.kWx != null) {
        paramVarArgs.e(4, this.kWx);
      }
      paramVarArgs.aO(5, this.wJf);
      if (this.wJg != null) {
        paramVarArgs.e(6, this.wJg);
      }
      paramVarArgs.aO(7, this.wJh);
      if (this.kWy != null) {
        paramVarArgs.e(8, this.kWy);
      }
      if (this.wJi != null) {
        paramVarArgs.e(9, this.wJi);
      }
      paramVarArgs.aO(10, this.kWr);
      if (this.kWs != null) {
        paramVarArgs.e(11, this.kWs);
      }
      AppMethodBeat.o(94513);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wJd) + 0;
      paramInt = i;
      if (this.kXk != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.kXk);
      }
      i = paramInt;
      if (this.wJe != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wJe);
      }
      paramInt = i;
      if (this.kWx != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kWx);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wJf);
      paramInt = i;
      if (this.wJg != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wJg);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.wJh);
      paramInt = i;
      if (this.kWy != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.kWy);
      }
      i = paramInt;
      if (this.wJi != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wJi);
      }
      i += e.a.a.b.b.a.bl(10, this.kWr);
      paramInt = i;
      if (this.kWs != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.kWs);
      }
      AppMethodBeat.o(94513);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94513);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      qy localqy = (qy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94513);
        return -1;
      case 1: 
        localqy.wJd = locala.CLY.sl();
        AppMethodBeat.o(94513);
        return 0;
      case 2: 
        localqy.kXk = locala.CLY.readString();
        AppMethodBeat.o(94513);
        return 0;
      case 3: 
        localqy.wJe = locala.CLY.readString();
        AppMethodBeat.o(94513);
        return 0;
      case 4: 
        localqy.kWx = locala.CLY.readString();
        AppMethodBeat.o(94513);
        return 0;
      case 5: 
        localqy.wJf = locala.CLY.sl();
        AppMethodBeat.o(94513);
        return 0;
      case 6: 
        localqy.wJg = locala.CLY.readString();
        AppMethodBeat.o(94513);
        return 0;
      case 7: 
        localqy.wJh = locala.CLY.sl();
        AppMethodBeat.o(94513);
        return 0;
      case 8: 
        localqy.kWy = locala.CLY.readString();
        AppMethodBeat.o(94513);
        return 0;
      case 9: 
        localqy.wJi = locala.CLY.readString();
        AppMethodBeat.o(94513);
        return 0;
      case 10: 
        localqy.kWr = locala.CLY.sl();
        AppMethodBeat.o(94513);
        return 0;
      }
      localqy.kWs = locala.CLY.readString();
      AppMethodBeat.o(94513);
      return 0;
    }
    AppMethodBeat.o(94513);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qy
 * JD-Core Version:    0.7.0.1
 */
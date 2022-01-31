package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bda
  extends com.tencent.mm.bv.a
{
  public String cyA;
  public int type;
  public String url;
  public String xtb;
  public String xtc;
  public String xtd;
  public int xte;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56853);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cyA == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(56853);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.type);
      if (this.cyA != null) {
        paramVarArgs.e(2, this.cyA);
      }
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      if (this.xtb != null) {
        paramVarArgs.e(4, this.xtb);
      }
      if (this.xtc != null) {
        paramVarArgs.e(5, this.xtc);
      }
      if (this.xtd != null) {
        paramVarArgs.e(6, this.xtd);
      }
      paramVarArgs.aO(7, this.xte);
      AppMethodBeat.o(56853);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.cyA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cyA);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.url);
      }
      paramInt = i;
      if (this.xtb != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xtb);
      }
      i = paramInt;
      if (this.xtc != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xtc);
      }
      paramInt = i;
      if (this.xtd != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xtd);
      }
      i = e.a.a.b.b.a.bl(7, this.xte);
      AppMethodBeat.o(56853);
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
      if (this.cyA == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(56853);
        throw paramVarArgs;
      }
      AppMethodBeat.o(56853);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bda localbda = (bda)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56853);
        return -1;
      case 1: 
        localbda.type = locala.CLY.sl();
        AppMethodBeat.o(56853);
        return 0;
      case 2: 
        localbda.cyA = locala.CLY.readString();
        AppMethodBeat.o(56853);
        return 0;
      case 3: 
        localbda.url = locala.CLY.readString();
        AppMethodBeat.o(56853);
        return 0;
      case 4: 
        localbda.xtb = locala.CLY.readString();
        AppMethodBeat.o(56853);
        return 0;
      case 5: 
        localbda.xtc = locala.CLY.readString();
        AppMethodBeat.o(56853);
        return 0;
      case 6: 
        localbda.xtd = locala.CLY.readString();
        AppMethodBeat.o(56853);
        return 0;
      }
      localbda.xte = locala.CLY.sl();
      AppMethodBeat.o(56853);
      return 0;
    }
    AppMethodBeat.o(56853);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bda
 * JD-Core Version:    0.7.0.1
 */
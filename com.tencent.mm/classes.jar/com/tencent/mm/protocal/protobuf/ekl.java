package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ekl
  extends com.tencent.mm.bw.a
{
  public String CiX;
  public String Cjt;
  public String Cju;
  public String Cjv;
  public String Cjw;
  public String dDj;
  public String ynT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72612);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Cjt != null) {
        paramVarArgs.e(1, this.Cjt);
      }
      if (this.Cju != null) {
        paramVarArgs.e(2, this.Cju);
      }
      if (this.CiX != null) {
        paramVarArgs.e(3, this.CiX);
      }
      if (this.ynT != null) {
        paramVarArgs.e(4, this.ynT);
      }
      if (this.dDj != null) {
        paramVarArgs.e(5, this.dDj);
      }
      if (this.Cjv != null) {
        paramVarArgs.e(6, this.Cjv);
      }
      if (this.Cjw != null) {
        paramVarArgs.e(7, this.Cjw);
      }
      AppMethodBeat.o(72612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Cjt == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.f(1, this.Cjt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Cju != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Cju);
      }
      i = paramInt;
      if (this.CiX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.CiX);
      }
      paramInt = i;
      if (this.ynT != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.ynT);
      }
      i = paramInt;
      if (this.dDj != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dDj);
      }
      paramInt = i;
      if (this.Cjv != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Cjv);
      }
      i = paramInt;
      if (this.Cjw != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Cjw);
      }
      AppMethodBeat.o(72612);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72612);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ekl localekl = (ekl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72612);
          return -1;
        case 1: 
          localekl.Cjt = locala.UbS.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 2: 
          localekl.Cju = locala.UbS.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 3: 
          localekl.CiX = locala.UbS.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 4: 
          localekl.ynT = locala.UbS.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 5: 
          localekl.dDj = locala.UbS.readString();
          AppMethodBeat.o(72612);
          return 0;
        case 6: 
          localekl.Cjv = locala.UbS.readString();
          AppMethodBeat.o(72612);
          return 0;
        }
        localekl.Cjw = locala.UbS.readString();
        AppMethodBeat.o(72612);
        return 0;
      }
      AppMethodBeat.o(72612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ard
  extends com.tencent.mm.cd.a
{
  public int SEg;
  public int SEh;
  public int SEi;
  public String city;
  public String country;
  public String province;
  public int sex;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168946);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.f(1, this.country);
      }
      if (this.province != null) {
        paramVarArgs.f(2, this.province);
      }
      if (this.city != null) {
        paramVarArgs.f(3, this.city);
      }
      paramVarArgs.aY(4, this.sex);
      paramVarArgs.aY(5, this.SEg);
      paramVarArgs.aY(6, this.SEh);
      paramVarArgs.aY(7, this.SEi);
      AppMethodBeat.o(168946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.country == null) {
        break label522;
      }
    }
    label522:
    for (int i = g.a.a.b.b.a.g(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.province != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.province);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.city);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.sex);
      int j = g.a.a.b.b.a.bM(5, this.SEg);
      int k = g.a.a.b.b.a.bM(6, this.SEh);
      int m = g.a.a.b.b.a.bM(7, this.SEi);
      AppMethodBeat.o(168946);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168946);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ard localard = (ard)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168946);
          return -1;
        case 1: 
          localard.country = locala.abFh.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 2: 
          localard.province = locala.abFh.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 3: 
          localard.city = locala.abFh.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 4: 
          localard.sex = locala.abFh.AK();
          AppMethodBeat.o(168946);
          return 0;
        case 5: 
          localard.SEg = locala.abFh.AK();
          AppMethodBeat.o(168946);
          return 0;
        case 6: 
          localard.SEh = locala.abFh.AK();
          AppMethodBeat.o(168946);
          return 0;
        }
        localard.SEi = locala.abFh.AK();
        AppMethodBeat.o(168946);
        return 0;
      }
      AppMethodBeat.o(168946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ard
 * JD-Core Version:    0.7.0.1
 */
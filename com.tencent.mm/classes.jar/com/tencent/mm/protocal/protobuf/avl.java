package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class avl
  extends com.tencent.mm.bx.a
{
  public int ZFD;
  public int ZFE;
  public int ZFF;
  public String city;
  public String country;
  public String province;
  public int sex;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168946);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.country != null) {
        paramVarArgs.g(1, this.country);
      }
      if (this.province != null) {
        paramVarArgs.g(2, this.province);
      }
      if (this.city != null) {
        paramVarArgs.g(3, this.city);
      }
      paramVarArgs.bS(4, this.sex);
      paramVarArgs.bS(5, this.ZFD);
      paramVarArgs.bS(6, this.ZFE);
      paramVarArgs.bS(7, this.ZFF);
      AppMethodBeat.o(168946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.country == null) {
        break label518;
      }
    }
    label518:
    for (int i = i.a.a.b.b.a.h(1, this.country) + 0;; i = 0)
    {
      paramInt = i;
      if (this.province != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.province);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.city);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.sex);
      int j = i.a.a.b.b.a.cJ(5, this.ZFD);
      int k = i.a.a.b.b.a.cJ(6, this.ZFE);
      int m = i.a.a.b.b.a.cJ(7, this.ZFF);
      AppMethodBeat.o(168946);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168946);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        avl localavl = (avl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(168946);
          return -1;
        case 1: 
          localavl.country = locala.ajGk.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 2: 
          localavl.province = locala.ajGk.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 3: 
          localavl.city = locala.ajGk.readString();
          AppMethodBeat.o(168946);
          return 0;
        case 4: 
          localavl.sex = locala.ajGk.aar();
          AppMethodBeat.o(168946);
          return 0;
        case 5: 
          localavl.ZFD = locala.ajGk.aar();
          AppMethodBeat.o(168946);
          return 0;
        case 6: 
          localavl.ZFE = locala.ajGk.aar();
          AppMethodBeat.o(168946);
          return 0;
        }
        localavl.ZFF = locala.ajGk.aar();
        AppMethodBeat.o(168946);
        return 0;
      }
      AppMethodBeat.o(168946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avl
 * JD-Core Version:    0.7.0.1
 */
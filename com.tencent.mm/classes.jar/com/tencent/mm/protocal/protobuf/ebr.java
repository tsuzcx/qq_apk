package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebr
  extends com.tencent.mm.bx.a
{
  public int YMD;
  public String abhh;
  public String abhi;
  public String abhj;
  public String abhk;
  public String abhl;
  public String abhm;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91577);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abhh != null) {
        paramVarArgs.g(1, this.abhh);
      }
      paramVarArgs.bS(2, this.vhk);
      if (this.abhi != null) {
        paramVarArgs.g(3, this.abhi);
      }
      if (this.abhj != null) {
        paramVarArgs.g(4, this.abhj);
      }
      if (this.abhk != null) {
        paramVarArgs.g(5, this.abhk);
      }
      paramVarArgs.bS(6, this.YMD);
      if (this.abhl != null) {
        paramVarArgs.g(7, this.abhl);
      }
      if (this.abhm != null) {
        paramVarArgs.g(8, this.abhm);
      }
      AppMethodBeat.o(91577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abhh == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = i.a.a.b.b.a.h(1, this.abhh) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhk);
      paramInt = i;
      if (this.abhi != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abhi);
      }
      i = paramInt;
      if (this.abhj != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abhj);
      }
      paramInt = i;
      if (this.abhk != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abhk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.YMD);
      paramInt = i;
      if (this.abhl != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abhl);
      }
      i = paramInt;
      if (this.abhm != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abhm);
      }
      AppMethodBeat.o(91577);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91577);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ebr localebr = (ebr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91577);
          return -1;
        case 1: 
          localebr.abhh = locala.ajGk.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 2: 
          localebr.vhk = locala.ajGk.aar();
          AppMethodBeat.o(91577);
          return 0;
        case 3: 
          localebr.abhi = locala.ajGk.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 4: 
          localebr.abhj = locala.ajGk.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 5: 
          localebr.abhk = locala.ajGk.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 6: 
          localebr.YMD = locala.ajGk.aar();
          AppMethodBeat.o(91577);
          return 0;
        case 7: 
          localebr.abhl = locala.ajGk.readString();
          AppMethodBeat.o(91577);
          return 0;
        }
        localebr.abhm = locala.ajGk.readString();
        AppMethodBeat.o(91577);
        return 0;
      }
      AppMethodBeat.o(91577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebr
 * JD-Core Version:    0.7.0.1
 */
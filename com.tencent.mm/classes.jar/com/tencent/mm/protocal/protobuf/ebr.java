package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebr
  extends com.tencent.mm.bx.a
{
  public String GRx;
  public String HOh;
  public String HOi;
  public String HOj;
  public String HOk;
  public String HOl;
  public String HbR;
  public int Scene;
  public int jbV;
  public String wDN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121110);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HOh != null) {
        paramVarArgs.d(1, this.HOh);
      }
      if (this.HOi != null) {
        paramVarArgs.d(2, this.HOi);
      }
      if (this.GRx != null) {
        paramVarArgs.d(3, this.GRx);
      }
      if (this.HbR != null) {
        paramVarArgs.d(4, this.HbR);
      }
      paramVarArgs.aS(5, this.jbV);
      if (this.wDN != null) {
        paramVarArgs.d(6, this.wDN);
      }
      if (this.HOj != null) {
        paramVarArgs.d(7, this.HOj);
      }
      if (this.HOk != null) {
        paramVarArgs.d(8, this.HOk);
      }
      paramVarArgs.aS(9, this.Scene);
      if (this.HOl != null) {
        paramVarArgs.d(19, this.HOl);
      }
      AppMethodBeat.o(121110);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HOh == null) {
        break label770;
      }
    }
    label770:
    for (int i = f.a.a.b.b.a.e(1, this.HOh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HOi != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HOi);
      }
      i = paramInt;
      if (this.GRx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GRx);
      }
      paramInt = i;
      if (this.HbR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HbR);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.jbV);
      paramInt = i;
      if (this.wDN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.wDN);
      }
      i = paramInt;
      if (this.HOj != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HOj);
      }
      paramInt = i;
      if (this.HOk != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HOk);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.Scene);
      paramInt = i;
      if (this.HOl != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.HOl);
      }
      AppMethodBeat.o(121110);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(121110);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebr localebr = (ebr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(121110);
          return -1;
        case 1: 
          localebr.HOh = locala.NPN.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 2: 
          localebr.HOi = locala.NPN.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 3: 
          localebr.GRx = locala.NPN.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 4: 
          localebr.HbR = locala.NPN.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 5: 
          localebr.jbV = locala.NPN.zc();
          AppMethodBeat.o(121110);
          return 0;
        case 6: 
          localebr.wDN = locala.NPN.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 7: 
          localebr.HOj = locala.NPN.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 8: 
          localebr.HOk = locala.NPN.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 9: 
          localebr.Scene = locala.NPN.zc();
          AppMethodBeat.o(121110);
          return 0;
        }
        localebr.HOl = locala.NPN.readString();
        AppMethodBeat.o(121110);
        return 0;
      }
      AppMethodBeat.o(121110);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebr
 * JD-Core Version:    0.7.0.1
 */
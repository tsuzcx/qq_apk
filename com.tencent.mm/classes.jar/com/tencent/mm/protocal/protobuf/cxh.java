package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cxh
  extends com.tencent.mm.bw.a
{
  public String HHM;
  public String HHN;
  public b HHO;
  public long HHP;
  public String HHQ;
  public String HHR;
  public String HHS;
  public String Title;
  public String Username;
  public int qlc;
  public String uuA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181512);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HHN != null) {
        paramVarArgs.d(1, this.HHN);
      }
      if (this.Username != null) {
        paramVarArgs.d(2, this.Username);
      }
      if (this.uuA != null) {
        paramVarArgs.d(3, this.uuA);
      }
      paramVarArgs.aS(4, this.qlc);
      if (this.HHO != null) {
        paramVarArgs.c(5, this.HHO);
      }
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      if (this.HHM != null) {
        paramVarArgs.d(7, this.HHM);
      }
      paramVarArgs.aZ(8, this.HHP);
      if (this.HHQ != null) {
        paramVarArgs.d(9, this.HHQ);
      }
      if (this.HHR != null) {
        paramVarArgs.d(10, this.HHR);
      }
      if (this.HHS != null) {
        paramVarArgs.d(11, this.HHS);
      }
      AppMethodBeat.o(181512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HHN == null) {
        break label794;
      }
    }
    label794:
    for (int i = f.a.a.b.b.a.e(1, this.HHN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Username);
      }
      i = paramInt;
      if (this.uuA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uuA);
      }
      i += f.a.a.b.b.a.bz(4, this.qlc);
      paramInt = i;
      if (this.HHO != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.HHO);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Title);
      }
      paramInt = i;
      if (this.HHM != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HHM);
      }
      i = paramInt + f.a.a.b.b.a.p(8, this.HHP);
      paramInt = i;
      if (this.HHQ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HHQ);
      }
      i = paramInt;
      if (this.HHR != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.HHR);
      }
      paramInt = i;
      if (this.HHS != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HHS);
      }
      AppMethodBeat.o(181512);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(181512);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cxh localcxh = (cxh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181512);
          return -1;
        case 1: 
          localcxh.HHN = locala.OmT.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 2: 
          localcxh.Username = locala.OmT.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 3: 
          localcxh.uuA = locala.OmT.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 4: 
          localcxh.qlc = locala.OmT.zc();
          AppMethodBeat.o(181512);
          return 0;
        case 5: 
          localcxh.HHO = locala.OmT.gCk();
          AppMethodBeat.o(181512);
          return 0;
        case 6: 
          localcxh.Title = locala.OmT.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 7: 
          localcxh.HHM = locala.OmT.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 8: 
          localcxh.HHP = locala.OmT.zd();
          AppMethodBeat.o(181512);
          return 0;
        case 9: 
          localcxh.HHQ = locala.OmT.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 10: 
          localcxh.HHR = locala.OmT.readString();
          AppMethodBeat.o(181512);
          return 0;
        }
        localcxh.HHS = locala.OmT.readString();
        AppMethodBeat.o(181512);
        return 0;
      }
      AppMethodBeat.o(181512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxh
 * JD-Core Version:    0.7.0.1
 */
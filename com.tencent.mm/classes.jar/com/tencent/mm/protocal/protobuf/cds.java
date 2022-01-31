package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cds
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public int DeleteFlag;
  public int IsNotRichText;
  public String Nickname;
  public String Username;
  public int jKs;
  public int niK;
  public String ntu;
  public int xNX;
  public int xNY;
  public long xNZ;
  public long xOa;
  public int xOc;
  public String xOr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94570);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.e(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.e(2, this.Nickname);
      }
      paramVarArgs.aO(3, this.niK);
      paramVarArgs.aO(4, this.jKs);
      if (this.ntu != null) {
        paramVarArgs.e(5, this.ntu);
      }
      paramVarArgs.aO(6, this.CreateTime);
      paramVarArgs.aO(7, this.xNY);
      paramVarArgs.aO(8, this.xNX);
      if (this.xOr != null) {
        paramVarArgs.e(9, this.xOr);
      }
      paramVarArgs.aO(10, this.IsNotRichText);
      paramVarArgs.am(11, this.xNZ);
      paramVarArgs.am(12, this.xOa);
      paramVarArgs.aO(13, this.DeleteFlag);
      paramVarArgs.aO(14, this.xOc);
      AppMethodBeat.o(94570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = e.a.a.b.b.a.f(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.Nickname);
      }
      i = i + e.a.a.b.b.a.bl(3, this.niK) + e.a.a.b.b.a.bl(4, this.jKs);
      paramInt = i;
      if (this.ntu != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.ntu);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.CreateTime) + e.a.a.b.b.a.bl(7, this.xNY) + e.a.a.b.b.a.bl(8, this.xNX);
      paramInt = i;
      if (this.xOr != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xOr);
      }
      i = e.a.a.b.b.a.bl(10, this.IsNotRichText);
      int j = e.a.a.b.b.a.p(11, this.xNZ);
      int k = e.a.a.b.b.a.p(12, this.xOa);
      int m = e.a.a.b.b.a.bl(13, this.DeleteFlag);
      int n = e.a.a.b.b.a.bl(14, this.xOc);
      AppMethodBeat.o(94570);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94570);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cds localcds = (cds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94570);
          return -1;
        case 1: 
          localcds.Username = locala.CLY.readString();
          AppMethodBeat.o(94570);
          return 0;
        case 2: 
          localcds.Nickname = locala.CLY.readString();
          AppMethodBeat.o(94570);
          return 0;
        case 3: 
          localcds.niK = locala.CLY.sl();
          AppMethodBeat.o(94570);
          return 0;
        case 4: 
          localcds.jKs = locala.CLY.sl();
          AppMethodBeat.o(94570);
          return 0;
        case 5: 
          localcds.ntu = locala.CLY.readString();
          AppMethodBeat.o(94570);
          return 0;
        case 6: 
          localcds.CreateTime = locala.CLY.sl();
          AppMethodBeat.o(94570);
          return 0;
        case 7: 
          localcds.xNY = locala.CLY.sl();
          AppMethodBeat.o(94570);
          return 0;
        case 8: 
          localcds.xNX = locala.CLY.sl();
          AppMethodBeat.o(94570);
          return 0;
        case 9: 
          localcds.xOr = locala.CLY.readString();
          AppMethodBeat.o(94570);
          return 0;
        case 10: 
          localcds.IsNotRichText = locala.CLY.sl();
          AppMethodBeat.o(94570);
          return 0;
        case 11: 
          localcds.xNZ = locala.CLY.sm();
          AppMethodBeat.o(94570);
          return 0;
        case 12: 
          localcds.xOa = locala.CLY.sm();
          AppMethodBeat.o(94570);
          return 0;
        case 13: 
          localcds.DeleteFlag = locala.CLY.sl();
          AppMethodBeat.o(94570);
          return 0;
        }
        localcds.xOc = locala.CLY.sl();
        AppMethodBeat.o(94570);
        return 0;
      }
      AppMethodBeat.o(94570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cds
 * JD-Core Version:    0.7.0.1
 */
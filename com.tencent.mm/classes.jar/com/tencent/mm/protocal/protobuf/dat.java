package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dat
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public String Md5;
  public String Url;
  public int aaFZ;
  public String aeskey;
  public String crp;
  public String fileid;
  public int vhE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32329);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.crp != null) {
        paramVarArgs.g(1, this.crp);
      }
      paramVarArgs.bS(2, this.vhE);
      if (this.Md5 != null) {
        paramVarArgs.g(3, this.Md5);
      }
      if (this.Url != null) {
        paramVarArgs.g(4, this.Url);
      }
      if (this.IGU != null) {
        paramVarArgs.g(5, this.IGU);
      }
      if (this.fileid != null) {
        paramVarArgs.g(6, this.fileid);
      }
      if (this.aeskey != null) {
        paramVarArgs.g(7, this.aeskey);
      }
      paramVarArgs.bS(8, this.aaFZ);
      AppMethodBeat.o(32329);
      return 0;
    }
    if (paramInt == 1) {
      if (this.crp == null) {
        break label620;
      }
    }
    label620:
    for (paramInt = i.a.a.b.b.a.h(1, this.crp) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhE);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Md5);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Url);
      }
      paramInt = i;
      if (this.IGU != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.IGU);
      }
      i = paramInt;
      if (this.fileid != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.fileid);
      }
      paramInt = i;
      if (this.aeskey != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aeskey);
      }
      i = i.a.a.b.b.a.cJ(8, this.aaFZ);
      AppMethodBeat.o(32329);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32329);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dat localdat = (dat)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32329);
          return -1;
        case 1: 
          localdat.crp = locala.ajGk.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 2: 
          localdat.vhE = locala.ajGk.aar();
          AppMethodBeat.o(32329);
          return 0;
        case 3: 
          localdat.Md5 = locala.ajGk.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 4: 
          localdat.Url = locala.ajGk.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 5: 
          localdat.IGU = locala.ajGk.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 6: 
          localdat.fileid = locala.ajGk.readString();
          AppMethodBeat.o(32329);
          return 0;
        case 7: 
          localdat.aeskey = locala.ajGk.readString();
          AppMethodBeat.o(32329);
          return 0;
        }
        localdat.aaFZ = locala.ajGk.aar();
        AppMethodBeat.o(32329);
        return 0;
      }
      AppMethodBeat.o(32329);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dat
 * JD-Core Version:    0.7.0.1
 */
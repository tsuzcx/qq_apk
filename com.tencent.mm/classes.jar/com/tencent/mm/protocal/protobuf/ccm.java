package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccm
  extends com.tencent.mm.bw.a
{
  public boolean EOr;
  public boolean EOs;
  public String EUn;
  public int EUq;
  public int EWm;
  public String djj;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123633);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djj != null) {
        paramVarArgs.d(1, this.djj);
      }
      if (this.EUn != null) {
        paramVarArgs.d(2, this.EUn);
      }
      paramVarArgs.aR(3, this.EUq);
      paramVarArgs.aR(4, this.version);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(6, this.md5);
      }
      paramVarArgs.bl(20, this.EOr);
      paramVarArgs.bl(21, this.EOs);
      paramVarArgs.aR(22, this.EWm);
      AppMethodBeat.o(123633);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djj == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.b.b.a.e(1, this.djj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EUn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EUn);
      }
      i = i + f.a.a.b.b.a.bx(3, this.EUq) + f.a.a.b.b.a.bx(4, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.md5);
      }
      paramInt = f.a.a.b.b.a.fK(20);
      int j = f.a.a.b.b.a.fK(21);
      int k = f.a.a.b.b.a.bx(22, this.EWm);
      AppMethodBeat.o(123633);
      return i + (paramInt + 1) + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123633);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccm localccm = (ccm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123633);
          return -1;
        case 1: 
          localccm.djj = locala.LVo.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 2: 
          localccm.EUn = locala.LVo.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 3: 
          localccm.EUq = locala.LVo.xF();
          AppMethodBeat.o(123633);
          return 0;
        case 4: 
          localccm.version = locala.LVo.xF();
          AppMethodBeat.o(123633);
          return 0;
        case 5: 
          localccm.url = locala.LVo.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 6: 
          localccm.md5 = locala.LVo.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 20: 
          localccm.EOr = locala.LVo.fZX();
          AppMethodBeat.o(123633);
          return 0;
        case 21: 
          localccm.EOs = locala.LVo.fZX();
          AppMethodBeat.o(123633);
          return 0;
        }
        localccm.EWm = locala.LVo.xF();
        AppMethodBeat.o(123633);
        return 0;
      }
      AppMethodBeat.o(123633);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccm
 * JD-Core Version:    0.7.0.1
 */
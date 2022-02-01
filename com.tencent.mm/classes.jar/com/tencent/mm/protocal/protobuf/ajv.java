package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajv
  extends com.tencent.mm.bw.a
{
  public String Gzq;
  public String appId;
  public String dLl;
  public String dlk;
  public int duK;
  public String iconUrl;
  public int kaX;
  public int kuE;
  public int subType;
  public int type;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.appId != null) {
        paramVarArgs.d(2, this.appId);
      }
      paramVarArgs.aS(3, this.duK);
      if (this.iconUrl != null) {
        paramVarArgs.d(4, this.iconUrl);
      }
      paramVarArgs.aS(5, this.type);
      if (this.dlk != null) {
        paramVarArgs.d(6, this.dlk);
      }
      if (this.Gzq != null) {
        paramVarArgs.d(7, this.Gzq);
      }
      paramVarArgs.aS(8, this.version);
      paramVarArgs.aS(9, this.kuE);
      paramVarArgs.aS(10, this.kaX);
      if (this.dLl != null) {
        paramVarArgs.d(11, this.dLl);
      }
      paramVarArgs.aS(12, this.subType);
      AppMethodBeat.o(127455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appId != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.appId);
      }
      i += f.a.a.b.b.a.bz(3, this.duK);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iconUrl);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.type);
      paramInt = i;
      if (this.dlk != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dlk);
      }
      i = paramInt;
      if (this.Gzq != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gzq);
      }
      i = i + f.a.a.b.b.a.bz(8, this.version) + f.a.a.b.b.a.bz(9, this.kuE) + f.a.a.b.b.a.bz(10, this.kaX);
      paramInt = i;
      if (this.dLl != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.dLl);
      }
      i = f.a.a.b.b.a.bz(12, this.subType);
      AppMethodBeat.o(127455);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127455);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ajv localajv = (ajv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127455);
          return -1;
        case 1: 
          localajv.username = locala.OmT.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 2: 
          localajv.appId = locala.OmT.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 3: 
          localajv.duK = locala.OmT.zc();
          AppMethodBeat.o(127455);
          return 0;
        case 4: 
          localajv.iconUrl = locala.OmT.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 5: 
          localajv.type = locala.OmT.zc();
          AppMethodBeat.o(127455);
          return 0;
        case 6: 
          localajv.dlk = locala.OmT.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 7: 
          localajv.Gzq = locala.OmT.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 8: 
          localajv.version = locala.OmT.zc();
          AppMethodBeat.o(127455);
          return 0;
        case 9: 
          localajv.kuE = locala.OmT.zc();
          AppMethodBeat.o(127455);
          return 0;
        case 10: 
          localajv.kaX = locala.OmT.zc();
          AppMethodBeat.o(127455);
          return 0;
        case 11: 
          localajv.dLl = locala.OmT.readString();
          AppMethodBeat.o(127455);
          return 0;
        }
        localajv.subType = locala.OmT.zc();
        AppMethodBeat.o(127455);
        return 0;
      }
      AppMethodBeat.o(127455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajv
 * JD-Core Version:    0.7.0.1
 */
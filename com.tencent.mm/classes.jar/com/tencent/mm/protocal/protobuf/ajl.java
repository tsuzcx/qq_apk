package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajl
  extends com.tencent.mm.bx.a
{
  public String GgH;
  public String appId;
  public String dJW;
  public String dki;
  public int dtF;
  public String iconUrl;
  public int jXI;
  public int kro;
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
      paramVarArgs.aS(3, this.dtF);
      if (this.iconUrl != null) {
        paramVarArgs.d(4, this.iconUrl);
      }
      paramVarArgs.aS(5, this.type);
      if (this.dki != null) {
        paramVarArgs.d(6, this.dki);
      }
      if (this.GgH != null) {
        paramVarArgs.d(7, this.GgH);
      }
      paramVarArgs.aS(8, this.version);
      paramVarArgs.aS(9, this.kro);
      paramVarArgs.aS(10, this.jXI);
      if (this.dJW != null) {
        paramVarArgs.d(11, this.dJW);
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
      i += f.a.a.b.b.a.bz(3, this.dtF);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iconUrl);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.type);
      paramInt = i;
      if (this.dki != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dki);
      }
      i = paramInt;
      if (this.GgH != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GgH);
      }
      i = i + f.a.a.b.b.a.bz(8, this.version) + f.a.a.b.b.a.bz(9, this.kro) + f.a.a.b.b.a.bz(10, this.jXI);
      paramInt = i;
      if (this.dJW != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.dJW);
      }
      i = f.a.a.b.b.a.bz(12, this.subType);
      AppMethodBeat.o(127455);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127455);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ajl localajl = (ajl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127455);
          return -1;
        case 1: 
          localajl.username = locala.NPN.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 2: 
          localajl.appId = locala.NPN.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 3: 
          localajl.dtF = locala.NPN.zc();
          AppMethodBeat.o(127455);
          return 0;
        case 4: 
          localajl.iconUrl = locala.NPN.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 5: 
          localajl.type = locala.NPN.zc();
          AppMethodBeat.o(127455);
          return 0;
        case 6: 
          localajl.dki = locala.NPN.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 7: 
          localajl.GgH = locala.NPN.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 8: 
          localajl.version = locala.NPN.zc();
          AppMethodBeat.o(127455);
          return 0;
        case 9: 
          localajl.kro = locala.NPN.zc();
          AppMethodBeat.o(127455);
          return 0;
        case 10: 
          localajl.jXI = locala.NPN.zc();
          AppMethodBeat.o(127455);
          return 0;
        case 11: 
          localajl.dJW = locala.NPN.readString();
          AppMethodBeat.o(127455);
          return 0;
        }
        localajl.subType = locala.NPN.zc();
        AppMethodBeat.o(127455);
        return 0;
      }
      AppMethodBeat.o(127455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajl
 * JD-Core Version:    0.7.0.1
 */
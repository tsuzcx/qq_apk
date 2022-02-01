package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agv
  extends com.tencent.mm.bw.a
{
  public String EyV;
  public String appId;
  public String cYQ;
  public int ccR;
  public int dib;
  public String dxK;
  public String iconUrl;
  public int jWX;
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
      paramVarArgs.aR(3, this.dib);
      if (this.iconUrl != null) {
        paramVarArgs.d(4, this.iconUrl);
      }
      paramVarArgs.aR(5, this.type);
      if (this.cYQ != null) {
        paramVarArgs.d(6, this.cYQ);
      }
      if (this.EyV != null) {
        paramVarArgs.d(7, this.EyV);
      }
      paramVarArgs.aR(8, this.version);
      paramVarArgs.aR(9, this.jWX);
      paramVarArgs.aR(10, this.ccR);
      if (this.dxK != null) {
        paramVarArgs.d(11, this.dxK);
      }
      paramVarArgs.aR(12, this.subType);
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
      i += f.a.a.b.b.a.bx(3, this.dib);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.iconUrl);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.type);
      paramInt = i;
      if (this.cYQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.cYQ);
      }
      i = paramInt;
      if (this.EyV != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EyV);
      }
      i = i + f.a.a.b.b.a.bx(8, this.version) + f.a.a.b.b.a.bx(9, this.jWX) + f.a.a.b.b.a.bx(10, this.ccR);
      paramInt = i;
      if (this.dxK != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.dxK);
      }
      i = f.a.a.b.b.a.bx(12, this.subType);
      AppMethodBeat.o(127455);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127455);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agv localagv = (agv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127455);
          return -1;
        case 1: 
          localagv.username = locala.LVo.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 2: 
          localagv.appId = locala.LVo.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 3: 
          localagv.dib = locala.LVo.xF();
          AppMethodBeat.o(127455);
          return 0;
        case 4: 
          localagv.iconUrl = locala.LVo.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 5: 
          localagv.type = locala.LVo.xF();
          AppMethodBeat.o(127455);
          return 0;
        case 6: 
          localagv.cYQ = locala.LVo.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 7: 
          localagv.EyV = locala.LVo.readString();
          AppMethodBeat.o(127455);
          return 0;
        case 8: 
          localagv.version = locala.LVo.xF();
          AppMethodBeat.o(127455);
          return 0;
        case 9: 
          localagv.jWX = locala.LVo.xF();
          AppMethodBeat.o(127455);
          return 0;
        case 10: 
          localagv.ccR = locala.LVo.xF();
          AppMethodBeat.o(127455);
          return 0;
        case 11: 
          localagv.dxK = locala.LVo.readString();
          AppMethodBeat.o(127455);
          return 0;
        }
        localagv.subType = locala.LVo.xF();
        AppMethodBeat.o(127455);
        return 0;
      }
      AppMethodBeat.o(127455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agv
 * JD-Core Version:    0.7.0.1
 */
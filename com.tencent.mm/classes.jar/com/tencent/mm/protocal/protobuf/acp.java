package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acp
  extends com.tencent.mm.bw.a
{
  public String Evg;
  public String deviceBrand;
  public String deviceModel;
  public String osName;
  public String osVersion;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32189);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.deviceModel != null) {
        paramVarArgs.d(1, this.deviceModel);
      }
      if (this.deviceBrand != null) {
        paramVarArgs.d(2, this.deviceBrand);
      }
      if (this.osName != null) {
        paramVarArgs.d(3, this.osName);
      }
      if (this.osVersion != null) {
        paramVarArgs.d(4, this.osVersion);
      }
      if (this.Evg != null) {
        paramVarArgs.d(5, this.Evg);
      }
      AppMethodBeat.o(32189);
      return 0;
    }
    if (paramInt == 1) {
      if (this.deviceModel == null) {
        break label465;
      }
    }
    label465:
    for (int i = f.a.a.b.b.a.e(1, this.deviceModel) + 0;; i = 0)
    {
      paramInt = i;
      if (this.deviceBrand != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.deviceBrand);
      }
      i = paramInt;
      if (this.osName != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.osName);
      }
      paramInt = i;
      if (this.osVersion != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.osVersion);
      }
      i = paramInt;
      if (this.Evg != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Evg);
      }
      AppMethodBeat.o(32189);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32189);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        acp localacp = (acp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32189);
          return -1;
        case 1: 
          localacp.deviceModel = locala.LVo.readString();
          AppMethodBeat.o(32189);
          return 0;
        case 2: 
          localacp.deviceBrand = locala.LVo.readString();
          AppMethodBeat.o(32189);
          return 0;
        case 3: 
          localacp.osName = locala.LVo.readString();
          AppMethodBeat.o(32189);
          return 0;
        case 4: 
          localacp.osVersion = locala.LVo.readString();
          AppMethodBeat.o(32189);
          return 0;
        }
        localacp.Evg = locala.LVo.readString();
        AppMethodBeat.o(32189);
        return 0;
      }
      AppMethodBeat.o(32189);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acp
 * JD-Core Version:    0.7.0.1
 */
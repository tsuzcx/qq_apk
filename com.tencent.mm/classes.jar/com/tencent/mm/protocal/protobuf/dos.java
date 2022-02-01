package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dos
  extends com.tencent.mm.bw.a
{
  public String HVA;
  public String HVz;
  public String appId;
  public String dKV;
  public String desc;
  public String ssR;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153000);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.dKV != null) {
        paramVarArgs.d(3, this.dKV);
      }
      if (this.HVz != null) {
        paramVarArgs.d(4, this.HVz);
      }
      if (this.HVA != null) {
        paramVarArgs.d(5, this.HVA);
      }
      if (this.appId != null) {
        paramVarArgs.d(6, this.appId);
      }
      if (this.ssR != null) {
        paramVarArgs.d(7, this.ssR);
      }
      AppMethodBeat.o(153000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.dKV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dKV);
      }
      paramInt = i;
      if (this.HVz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HVz);
      }
      i = paramInt;
      if (this.HVA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HVA);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.appId);
      }
      i = paramInt;
      if (this.ssR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ssR);
      }
      AppMethodBeat.o(153000);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153000);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dos localdos = (dos)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153000);
          return -1;
        case 1: 
          localdos.title = locala.OmT.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 2: 
          localdos.desc = locala.OmT.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 3: 
          localdos.dKV = locala.OmT.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 4: 
          localdos.HVz = locala.OmT.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 5: 
          localdos.HVA = locala.OmT.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 6: 
          localdos.appId = locala.OmT.readString();
          AppMethodBeat.o(153000);
          return 0;
        }
        localdos.ssR = locala.OmT.readString();
        AppMethodBeat.o(153000);
        return 0;
      }
      AppMethodBeat.o(153000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dos
 * JD-Core Version:    0.7.0.1
 */
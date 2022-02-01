package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dct
  extends com.tencent.mm.bx.a
{
  public String Euf;
  public String Eug;
  public String appId;
  public String desc;
  public String dzJ;
  public String qDs;
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
      if (this.dzJ != null) {
        paramVarArgs.d(3, this.dzJ);
      }
      if (this.Euf != null) {
        paramVarArgs.d(4, this.Euf);
      }
      if (this.Eug != null) {
        paramVarArgs.d(5, this.Eug);
      }
      if (this.appId != null) {
        paramVarArgs.d(6, this.appId);
      }
      if (this.qDs != null) {
        paramVarArgs.d(7, this.qDs);
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
      if (this.dzJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dzJ);
      }
      paramInt = i;
      if (this.Euf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Euf);
      }
      i = paramInt;
      if (this.Eug != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Eug);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.appId);
      }
      i = paramInt;
      if (this.qDs != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.qDs);
      }
      AppMethodBeat.o(153000);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153000);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dct localdct = (dct)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153000);
          return -1;
        case 1: 
          localdct.title = locala.KhF.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 2: 
          localdct.desc = locala.KhF.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 3: 
          localdct.dzJ = locala.KhF.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 4: 
          localdct.Euf = locala.KhF.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 5: 
          localdct.Eug = locala.KhF.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 6: 
          localdct.appId = locala.KhF.readString();
          AppMethodBeat.o(153000);
          return 0;
        }
        localdct.qDs = locala.KhF.readString();
        AppMethodBeat.o(153000);
        return 0;
      }
      AppMethodBeat.o(153000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dct
 * JD-Core Version:    0.7.0.1
 */
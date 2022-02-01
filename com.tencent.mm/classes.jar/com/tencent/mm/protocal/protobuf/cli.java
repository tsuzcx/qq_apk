package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cli
  extends com.tencent.mm.bw.a
{
  public String ELg;
  public String EyO;
  public int FyM;
  public String SmallImgUrl;
  public String ncR;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127295);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      paramVarArgs.aR(2, this.FyM);
      if (this.ndW != null) {
        paramVarArgs.d(3, this.ndW);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.d(4, this.SmallImgUrl);
      }
      if (this.EyO != null) {
        paramVarArgs.d(5, this.EyO);
      }
      if (this.ELg != null) {
        paramVarArgs.d(6, this.ELg);
      }
      AppMethodBeat.o(127295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FyM);
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ndW);
      }
      i = paramInt;
      if (this.SmallImgUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.SmallImgUrl);
      }
      paramInt = i;
      if (this.EyO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EyO);
      }
      i = paramInt;
      if (this.ELg != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ELg);
      }
      AppMethodBeat.o(127295);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127295);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cli localcli = (cli)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127295);
          return -1;
        case 1: 
          localcli.ncR = locala.LVo.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 2: 
          localcli.FyM = locala.LVo.xF();
          AppMethodBeat.o(127295);
          return 0;
        case 3: 
          localcli.ndW = locala.LVo.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 4: 
          localcli.SmallImgUrl = locala.LVo.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 5: 
          localcli.EyO = locala.LVo.readString();
          AppMethodBeat.o(127295);
          return 0;
        }
        localcli.ELg = locala.LVo.readString();
        AppMethodBeat.o(127295);
        return 0;
      }
      AppMethodBeat.o(127295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cli
 * JD-Core Version:    0.7.0.1
 */
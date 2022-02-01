package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cde
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String FrN;
  public String FrO;
  public String IconUrl;
  public String Title;
  public int sVO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117888);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FrN != null) {
        paramVarArgs.d(1, this.FrN);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(4, this.IconUrl);
      }
      if (this.FrO != null) {
        paramVarArgs.d(5, this.FrO);
      }
      paramVarArgs.aR(6, this.sVO);
      AppMethodBeat.o(117888);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FrN == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.FrN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Desc);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IconUrl);
      }
      i = paramInt;
      if (this.FrO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FrO);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.sVO);
      AppMethodBeat.o(117888);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117888);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cde localcde = (cde)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117888);
          return -1;
        case 1: 
          localcde.FrN = locala.LVo.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 2: 
          localcde.Title = locala.LVo.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 3: 
          localcde.Desc = locala.LVo.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 4: 
          localcde.IconUrl = locala.LVo.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 5: 
          localcde.FrO = locala.LVo.readString();
          AppMethodBeat.o(117888);
          return 0;
        }
        localcde.sVO = locala.LVo.xF();
        AppMethodBeat.o(117888);
        return 0;
      }
      AppMethodBeat.o(117888);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cde
 * JD-Core Version:    0.7.0.1
 */
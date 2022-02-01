package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvr
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String HbR;
  public String HbS;
  public String IconUrl;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117904);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HbR != null) {
        paramVarArgs.d(1, this.HbR);
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
      if (this.HbS != null) {
        paramVarArgs.d(5, this.HbS);
      }
      AppMethodBeat.o(117904);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HbR == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.HbR) + 0;; i = 0)
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
      if (this.HbS != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HbS);
      }
      AppMethodBeat.o(117904);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117904);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cvr localcvr = (cvr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117904);
          return -1;
        case 1: 
          localcvr.HbR = locala.NPN.readString();
          AppMethodBeat.o(117904);
          return 0;
        case 2: 
          localcvr.Title = locala.NPN.readString();
          AppMethodBeat.o(117904);
          return 0;
        case 3: 
          localcvr.Desc = locala.NPN.readString();
          AppMethodBeat.o(117904);
          return 0;
        case 4: 
          localcvr.IconUrl = locala.NPN.readString();
          AppMethodBeat.o(117904);
          return 0;
        }
        localcvr.HbS = locala.NPN.readString();
        AppMethodBeat.o(117904);
        return 0;
      }
      AppMethodBeat.o(117904);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvr
 * JD-Core Version:    0.7.0.1
 */
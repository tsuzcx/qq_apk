package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlf
  extends com.tencent.mm.bx.a
{
  public String ZQS;
  public int aaRi;
  public LinkedList<Integer> aaRj;
  public String icon_url;
  public String nickname;
  
  public dlf()
  {
    AppMethodBeat.i(259179);
    this.aaRj = new LinkedList();
    AppMethodBeat.o(259179);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259183);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaRi);
      if (this.ZQS != null) {
        paramVarArgs.g(2, this.ZQS);
      }
      if (this.nickname != null) {
        paramVarArgs.g(3, this.nickname);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(4, this.icon_url);
      }
      paramVarArgs.e(5, 2, this.aaRj);
      AppMethodBeat.o(259183);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aaRi) + 0;
      paramInt = i;
      if (this.ZQS != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZQS);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nickname);
      }
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.icon_url);
      }
      i = i.a.a.a.c(5, 2, this.aaRj);
      AppMethodBeat.o(259183);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaRj.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259183);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dlf localdlf = (dlf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259183);
        return -1;
      case 1: 
        localdlf.aaRi = locala.ajGk.aar();
        AppMethodBeat.o(259183);
        return 0;
      case 2: 
        localdlf.ZQS = locala.ajGk.readString();
        AppMethodBeat.o(259183);
        return 0;
      case 3: 
        localdlf.nickname = locala.ajGk.readString();
        AppMethodBeat.o(259183);
        return 0;
      case 4: 
        localdlf.icon_url = locala.ajGk.readString();
        AppMethodBeat.o(259183);
        return 0;
      }
      localdlf.aaRj.add(Integer.valueOf(locala.ajGk.aar()));
      AppMethodBeat.o(259183);
      return 0;
    }
    AppMethodBeat.o(259183);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlf
 * JD-Core Version:    0.7.0.1
 */
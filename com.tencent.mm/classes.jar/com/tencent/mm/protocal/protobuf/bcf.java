package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bcf
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> LLt;
  public LinkedList<String> LLu;
  public String cardId;
  public String oqZ;
  public b tVe;
  public String title;
  
  public bcf()
  {
    AppMethodBeat.i(196091);
    this.LLt = new LinkedList();
    this.LLu = new LinkedList();
    AppMethodBeat.o(196091);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196092);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.cardId != null) {
        paramVarArgs.e(1, this.cardId);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.oqZ != null) {
        paramVarArgs.e(3, this.oqZ);
      }
      paramVarArgs.e(4, 1, this.LLt);
      paramVarArgs.e(5, 1, this.LLu);
      if (this.tVe != null) {
        paramVarArgs.c(6, this.tVe);
      }
      AppMethodBeat.o(196092);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cardId == null) {
        break label510;
      }
    }
    label510:
    for (int i = g.a.a.b.b.a.f(1, this.cardId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.oqZ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.oqZ);
      }
      i = i + g.a.a.a.c(4, 1, this.LLt) + g.a.a.a.c(5, 1, this.LLu);
      paramInt = i;
      if (this.tVe != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.tVe);
      }
      AppMethodBeat.o(196092);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LLt.clear();
        this.LLu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(196092);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bcf localbcf = (bcf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196092);
          return -1;
        case 1: 
          localbcf.cardId = locala.UbS.readString();
          AppMethodBeat.o(196092);
          return 0;
        case 2: 
          localbcf.title = locala.UbS.readString();
          AppMethodBeat.o(196092);
          return 0;
        case 3: 
          localbcf.oqZ = locala.UbS.readString();
          AppMethodBeat.o(196092);
          return 0;
        case 4: 
          localbcf.LLt.add(locala.UbS.readString());
          AppMethodBeat.o(196092);
          return 0;
        case 5: 
          localbcf.LLu.add(locala.UbS.readString());
          AppMethodBeat.o(196092);
          return 0;
        }
        localbcf.tVe = locala.UbS.hPo();
        AppMethodBeat.o(196092);
        return 0;
      }
      AppMethodBeat.o(196092);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcf
 * JD-Core Version:    0.7.0.1
 */
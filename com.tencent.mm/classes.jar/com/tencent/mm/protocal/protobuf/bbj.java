package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bbj
  extends com.tencent.mm.bw.a
{
  public int KWR;
  public String LKO;
  public int LKP;
  public int LKQ;
  public long LKR;
  public long object_id;
  public String object_nonce_id;
  public b tabTipsByPassInfo;
  public int tab_type;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209649);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LKO != null) {
        paramVarArgs.e(1, this.LKO);
      }
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      paramVarArgs.aM(3, this.LKP);
      paramVarArgs.bb(4, this.object_id);
      paramVarArgs.aM(5, this.LKQ);
      paramVarArgs.aM(6, this.KWR);
      paramVarArgs.bb(7, this.LKR);
      if (this.tabTipsByPassInfo != null) {
        paramVarArgs.c(8, this.tabTipsByPassInfo);
      }
      if (this.object_nonce_id != null) {
        paramVarArgs.e(9, this.object_nonce_id);
      }
      paramVarArgs.aM(10, this.tab_type);
      AppMethodBeat.o(209649);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LKO == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = g.a.a.b.b.a.f(1, this.LKO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.username);
      }
      i = i + g.a.a.b.b.a.bu(3, this.LKP) + g.a.a.b.b.a.r(4, this.object_id) + g.a.a.b.b.a.bu(5, this.LKQ) + g.a.a.b.b.a.bu(6, this.KWR) + g.a.a.b.b.a.r(7, this.LKR);
      paramInt = i;
      if (this.tabTipsByPassInfo != null) {
        paramInt = i + g.a.a.b.b.a.b(8, this.tabTipsByPassInfo);
      }
      i = paramInt;
      if (this.object_nonce_id != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.object_nonce_id);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.tab_type);
      AppMethodBeat.o(209649);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209649);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bbj localbbj = (bbj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209649);
          return -1;
        case 1: 
          localbbj.LKO = locala.UbS.readString();
          AppMethodBeat.o(209649);
          return 0;
        case 2: 
          localbbj.username = locala.UbS.readString();
          AppMethodBeat.o(209649);
          return 0;
        case 3: 
          localbbj.LKP = locala.UbS.zi();
          AppMethodBeat.o(209649);
          return 0;
        case 4: 
          localbbj.object_id = locala.UbS.zl();
          AppMethodBeat.o(209649);
          return 0;
        case 5: 
          localbbj.LKQ = locala.UbS.zi();
          AppMethodBeat.o(209649);
          return 0;
        case 6: 
          localbbj.KWR = locala.UbS.zi();
          AppMethodBeat.o(209649);
          return 0;
        case 7: 
          localbbj.LKR = locala.UbS.zl();
          AppMethodBeat.o(209649);
          return 0;
        case 8: 
          localbbj.tabTipsByPassInfo = locala.UbS.hPo();
          AppMethodBeat.o(209649);
          return 0;
        case 9: 
          localbbj.object_nonce_id = locala.UbS.readString();
          AppMethodBeat.o(209649);
          return 0;
        }
        localbbj.tab_type = locala.UbS.zi();
        AppMethodBeat.o(209649);
        return 0;
      }
      AppMethodBeat.o(209649);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbj
 * JD-Core Version:    0.7.0.1
 */
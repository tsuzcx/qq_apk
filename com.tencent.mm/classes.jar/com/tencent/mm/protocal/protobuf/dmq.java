package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmq
  extends com.tencent.mm.bx.a
{
  public int Tqb;
  public String aaSS;
  public String aaST;
  public LinkedList<String> aazl;
  public String appid;
  public String desc;
  public String icon_url;
  public String nickname;
  public float score;
  
  public dmq()
  {
    AppMethodBeat.i(258781);
    this.aazl = new LinkedList();
    AppMethodBeat.o(258781);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258784);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(2, this.icon_url);
      }
      if (this.aaSS != null) {
        paramVarArgs.g(3, this.aaSS);
      }
      if (this.desc != null) {
        paramVarArgs.g(4, this.desc);
      }
      paramVarArgs.e(5, 1, this.aazl);
      paramVarArgs.l(6, this.score);
      if (this.aaST != null) {
        paramVarArgs.g(7, this.aaST);
      }
      paramVarArgs.bS(8, this.Tqb);
      if (this.nickname != null) {
        paramVarArgs.g(9, this.nickname);
      }
      AppMethodBeat.o(258784);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label665;
      }
    }
    label665:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.icon_url);
      }
      i = paramInt;
      if (this.aaSS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaSS);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.desc);
      }
      i = paramInt + i.a.a.a.c(5, 1, this.aazl) + (i.a.a.b.b.a.ko(6) + 4);
      paramInt = i;
      if (this.aaST != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aaST);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.Tqb);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.nickname);
      }
      AppMethodBeat.o(258784);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aazl.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258784);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dmq localdmq = (dmq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258784);
          return -1;
        case 1: 
          localdmq.appid = locala.ajGk.readString();
          AppMethodBeat.o(258784);
          return 0;
        case 2: 
          localdmq.icon_url = locala.ajGk.readString();
          AppMethodBeat.o(258784);
          return 0;
        case 3: 
          localdmq.aaSS = locala.ajGk.readString();
          AppMethodBeat.o(258784);
          return 0;
        case 4: 
          localdmq.desc = locala.ajGk.readString();
          AppMethodBeat.o(258784);
          return 0;
        case 5: 
          localdmq.aazl.add(locala.ajGk.readString());
          AppMethodBeat.o(258784);
          return 0;
        case 6: 
          localdmq.score = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(258784);
          return 0;
        case 7: 
          localdmq.aaST = locala.ajGk.readString();
          AppMethodBeat.o(258784);
          return 0;
        case 8: 
          localdmq.Tqb = locala.ajGk.aar();
          AppMethodBeat.o(258784);
          return 0;
        }
        localdmq.nickname = locala.ajGk.readString();
        AppMethodBeat.o(258784);
        return 0;
      }
      AppMethodBeat.o(258784);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmq
 * JD-Core Version:    0.7.0.1
 */
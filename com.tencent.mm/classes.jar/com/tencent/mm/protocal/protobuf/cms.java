package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cms
  extends com.tencent.mm.bw.a
{
  public int KXC;
  public String Mse;
  public String Msf;
  public LinkedList<String> Msg;
  public String dNI;
  public String desc;
  public String nickname;
  public String qGB;
  public float score;
  
  public cms()
  {
    AppMethodBeat.i(227878);
    this.Msg = new LinkedList();
    AppMethodBeat.o(227878);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(227879);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.qGB != null) {
        paramVarArgs.e(2, this.qGB);
      }
      if (this.Mse != null) {
        paramVarArgs.e(3, this.Mse);
      }
      if (this.desc != null) {
        paramVarArgs.e(4, this.desc);
      }
      paramVarArgs.e(5, 1, this.Msg);
      paramVarArgs.E(6, this.score);
      if (this.Msf != null) {
        paramVarArgs.e(7, this.Msf);
      }
      paramVarArgs.aM(8, this.KXC);
      if (this.nickname != null) {
        paramVarArgs.e(9, this.nickname);
      }
      AppMethodBeat.o(227879);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label669;
      }
    }
    label669:
    for (int i = g.a.a.b.b.a.f(1, this.dNI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qGB != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.qGB);
      }
      i = paramInt;
      if (this.Mse != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mse);
      }
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.desc);
      }
      i = paramInt + g.a.a.a.c(5, 1, this.Msg) + (g.a.a.b.b.a.fS(6) + 4);
      paramInt = i;
      if (this.Msf != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Msf);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.KXC);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.nickname);
      }
      AppMethodBeat.o(227879);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Msg.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(227879);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cms localcms = (cms)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(227879);
          return -1;
        case 1: 
          localcms.dNI = locala.UbS.readString();
          AppMethodBeat.o(227879);
          return 0;
        case 2: 
          localcms.qGB = locala.UbS.readString();
          AppMethodBeat.o(227879);
          return 0;
        case 3: 
          localcms.Mse = locala.UbS.readString();
          AppMethodBeat.o(227879);
          return 0;
        case 4: 
          localcms.desc = locala.UbS.readString();
          AppMethodBeat.o(227879);
          return 0;
        case 5: 
          localcms.Msg.add(locala.UbS.readString());
          AppMethodBeat.o(227879);
          return 0;
        case 6: 
          localcms.score = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(227879);
          return 0;
        case 7: 
          localcms.Msf = locala.UbS.readString();
          AppMethodBeat.o(227879);
          return 0;
        case 8: 
          localcms.KXC = locala.UbS.zi();
          AppMethodBeat.o(227879);
          return 0;
        }
        localcms.nickname = locala.UbS.readString();
        AppMethodBeat.o(227879);
        return 0;
      }
      AppMethodBeat.o(227879);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cms
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class p
  extends com.tencent.mm.bx.a
{
  public String Tpc;
  public String Tpd;
  public int Tpe;
  public int Tpf;
  public int Tpg;
  public int Tph;
  public int Tpi;
  public int Tpj;
  public long Tpk;
  public long Tpl;
  public long Tpm;
  public String oOW;
  public String sessionId;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290029);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.g(1, this.sessionId);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      if (this.Tpc != null) {
        paramVarArgs.g(3, this.Tpc);
      }
      if (this.Tpd != null) {
        paramVarArgs.g(4, this.Tpd);
      }
      paramVarArgs.bS(5, this.Tpe);
      paramVarArgs.bS(6, this.Tpf);
      paramVarArgs.bS(7, this.Tpg);
      paramVarArgs.bS(8, this.Tph);
      paramVarArgs.bS(9, this.Tpi);
      paramVarArgs.bS(10, this.Tpj);
      if (this.oOW != null) {
        paramVarArgs.g(11, this.oOW);
      }
      paramVarArgs.bv(12, this.Tpk);
      paramVarArgs.bv(13, this.Tpl);
      paramVarArgs.bv(14, this.Tpm);
      AppMethodBeat.o(290029);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label858;
      }
    }
    label858:
    for (int i = i.a.a.b.b.a.h(1, this.sessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.Tpc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Tpc);
      }
      paramInt = i;
      if (this.Tpd != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Tpd);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.Tpe) + i.a.a.b.b.a.cJ(6, this.Tpf) + i.a.a.b.b.a.cJ(7, this.Tpg) + i.a.a.b.b.a.cJ(8, this.Tph) + i.a.a.b.b.a.cJ(9, this.Tpi) + i.a.a.b.b.a.cJ(10, this.Tpj);
      paramInt = i;
      if (this.oOW != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.oOW);
      }
      i = i.a.a.b.b.a.q(12, this.Tpk);
      int j = i.a.a.b.b.a.q(13, this.Tpl);
      int k = i.a.a.b.b.a.q(14, this.Tpm);
      AppMethodBeat.o(290029);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(290029);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(290029);
          return -1;
        case 1: 
          localp.sessionId = locala.ajGk.readString();
          AppMethodBeat.o(290029);
          return 0;
        case 2: 
          localp.username = locala.ajGk.readString();
          AppMethodBeat.o(290029);
          return 0;
        case 3: 
          localp.Tpc = locala.ajGk.readString();
          AppMethodBeat.o(290029);
          return 0;
        case 4: 
          localp.Tpd = locala.ajGk.readString();
          AppMethodBeat.o(290029);
          return 0;
        case 5: 
          localp.Tpe = locala.ajGk.aar();
          AppMethodBeat.o(290029);
          return 0;
        case 6: 
          localp.Tpf = locala.ajGk.aar();
          AppMethodBeat.o(290029);
          return 0;
        case 7: 
          localp.Tpg = locala.ajGk.aar();
          AppMethodBeat.o(290029);
          return 0;
        case 8: 
          localp.Tph = locala.ajGk.aar();
          AppMethodBeat.o(290029);
          return 0;
        case 9: 
          localp.Tpi = locala.ajGk.aar();
          AppMethodBeat.o(290029);
          return 0;
        case 10: 
          localp.Tpj = locala.ajGk.aar();
          AppMethodBeat.o(290029);
          return 0;
        case 11: 
          localp.oOW = locala.ajGk.readString();
          AppMethodBeat.o(290029);
          return 0;
        case 12: 
          localp.Tpk = locala.ajGk.aaw();
          AppMethodBeat.o(290029);
          return 0;
        case 13: 
          localp.Tpl = locala.ajGk.aaw();
          AppMethodBeat.o(290029);
          return 0;
        }
        localp.Tpm = locala.ajGk.aaw();
        AppMethodBeat.o(290029);
        return 0;
      }
      AppMethodBeat.o(290029);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.p
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class bdp
  extends com.tencent.mm.bx.a
{
  public String ZOj;
  public int ZOk;
  public String ZOl;
  public String ZOm;
  public b ZOn;
  public String ZOo;
  public int ZOp;
  public b ZOq;
  public b ZOr;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258923);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOj != null) {
        paramVarArgs.g(1, this.ZOj);
      }
      paramVarArgs.bS(2, this.ZOk);
      if (this.ZOl != null) {
        paramVarArgs.g(3, this.ZOl);
      }
      if (this.ZOm != null) {
        paramVarArgs.g(4, this.ZOm);
      }
      if (this.ZOn != null) {
        paramVarArgs.d(5, this.ZOn);
      }
      if (this.ZOo != null) {
        paramVarArgs.g(101, this.ZOo);
      }
      paramVarArgs.bS(102, this.ZOp);
      if (this.ZOq != null) {
        paramVarArgs.d(103, this.ZOq);
      }
      paramVarArgs.bv(104, this.seq);
      if (this.ZOr != null) {
        paramVarArgs.d(105, this.ZOr);
      }
      AppMethodBeat.o(258923);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOj == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZOj) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZOk);
      paramInt = i;
      if (this.ZOl != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZOl);
      }
      i = paramInt;
      if (this.ZOm != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZOm);
      }
      paramInt = i;
      if (this.ZOn != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.ZOn);
      }
      i = paramInt;
      if (this.ZOo != null) {
        i = paramInt + i.a.a.b.b.a.h(101, this.ZOo);
      }
      i += i.a.a.b.b.a.cJ(102, this.ZOp);
      paramInt = i;
      if (this.ZOq != null) {
        paramInt = i + i.a.a.b.b.a.c(103, this.ZOq);
      }
      i = paramInt + i.a.a.b.b.a.q(104, this.seq);
      paramInt = i;
      if (this.ZOr != null) {
        paramInt = i + i.a.a.b.b.a.c(105, this.ZOr);
      }
      AppMethodBeat.o(258923);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258923);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bdp localbdp = (bdp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258923);
          return -1;
        case 1: 
          localbdp.ZOj = locala.ajGk.readString();
          AppMethodBeat.o(258923);
          return 0;
        case 2: 
          localbdp.ZOk = locala.ajGk.aar();
          AppMethodBeat.o(258923);
          return 0;
        case 3: 
          localbdp.ZOl = locala.ajGk.readString();
          AppMethodBeat.o(258923);
          return 0;
        case 4: 
          localbdp.ZOm = locala.ajGk.readString();
          AppMethodBeat.o(258923);
          return 0;
        case 5: 
          localbdp.ZOn = locala.ajGk.kFX();
          AppMethodBeat.o(258923);
          return 0;
        case 101: 
          localbdp.ZOo = locala.ajGk.readString();
          AppMethodBeat.o(258923);
          return 0;
        case 102: 
          localbdp.ZOp = locala.ajGk.aar();
          AppMethodBeat.o(258923);
          return 0;
        case 103: 
          localbdp.ZOq = locala.ajGk.kFX();
          AppMethodBeat.o(258923);
          return 0;
        case 104: 
          localbdp.seq = locala.ajGk.aaw();
          AppMethodBeat.o(258923);
          return 0;
        }
        localbdp.ZOr = locala.ajGk.kFX();
        AppMethodBeat.o(258923);
        return 0;
      }
      AppMethodBeat.o(258923);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdp
 * JD-Core Version:    0.7.0.1
 */
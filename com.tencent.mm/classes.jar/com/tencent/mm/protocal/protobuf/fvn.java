package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fvn
  extends com.tencent.mm.bx.a
{
  public String IHo;
  public String IKJ;
  public String YJY;
  public String ZoO;
  public String aaDN;
  public long abTH;
  public String abha;
  public String vgW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32491);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZoO != null) {
        paramVarArgs.g(1, this.ZoO);
      }
      if (this.YJY != null) {
        paramVarArgs.g(2, this.YJY);
      }
      if (this.abha != null) {
        paramVarArgs.g(3, this.abha);
      }
      if (this.IKJ != null) {
        paramVarArgs.g(4, this.IKJ);
      }
      if (this.vgW != null) {
        paramVarArgs.g(5, this.vgW);
      }
      if (this.IHo != null) {
        paramVarArgs.g(6, this.IHo);
      }
      if (this.aaDN != null) {
        paramVarArgs.g(7, this.aaDN);
      }
      paramVarArgs.bv(8, this.abTH);
      AppMethodBeat.o(32491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZoO == null) {
        break label636;
      }
    }
    label636:
    for (int i = i.a.a.b.b.a.h(1, this.ZoO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YJY != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YJY);
      }
      i = paramInt;
      if (this.abha != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abha);
      }
      paramInt = i;
      if (this.IKJ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IKJ);
      }
      i = paramInt;
      if (this.vgW != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.vgW);
      }
      paramInt = i;
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IHo);
      }
      i = paramInt;
      if (this.aaDN != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaDN);
      }
      paramInt = i.a.a.b.b.a.q(8, this.abTH);
      AppMethodBeat.o(32491);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32491);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fvn localfvn = (fvn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32491);
          return -1;
        case 1: 
          localfvn.ZoO = locala.ajGk.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 2: 
          localfvn.YJY = locala.ajGk.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 3: 
          localfvn.abha = locala.ajGk.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 4: 
          localfvn.IKJ = locala.ajGk.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 5: 
          localfvn.vgW = locala.ajGk.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 6: 
          localfvn.IHo = locala.ajGk.readString();
          AppMethodBeat.o(32491);
          return 0;
        case 7: 
          localfvn.aaDN = locala.ajGk.readString();
          AppMethodBeat.o(32491);
          return 0;
        }
        localfvn.abTH = locala.ajGk.aaw();
        AppMethodBeat.o(32491);
        return 0;
      }
      AppMethodBeat.o(32491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvn
 * JD-Core Version:    0.7.0.1
 */
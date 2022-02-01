package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends com.tencent.mm.bw.a
{
  public String DKA;
  public String DKB;
  public String DKO;
  public String DKP;
  public String DKQ;
  public long dBN;
  public int role;
  public int state;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91322);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DKA != null) {
        paramVarArgs.d(1, this.DKA);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aO(3, this.dBN);
      if (this.DKO != null) {
        paramVarArgs.d(5, this.DKO);
      }
      paramVarArgs.aR(10, this.state);
      paramVarArgs.aR(11, this.role);
      if (this.DKP != null) {
        paramVarArgs.d(12, this.DKP);
      }
      if (this.DKB != null) {
        paramVarArgs.d(13, this.DKB);
      }
      if (this.DKQ != null) {
        paramVarArgs.d(14, this.DKQ);
      }
      AppMethodBeat.o(91322);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DKA == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.b.b.a.e(1, this.DKA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      i += f.a.a.b.b.a.p(3, this.dBN);
      paramInt = i;
      if (this.DKO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DKO);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.state) + f.a.a.b.b.a.bx(11, this.role);
      paramInt = i;
      if (this.DKP != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DKP);
      }
      i = paramInt;
      if (this.DKB != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DKB);
      }
      paramInt = i;
      if (this.DKQ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DKQ);
      }
      AppMethodBeat.o(91322);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91322);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 4: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(91322);
          return -1;
        case 1: 
          localk.DKA = locala.LVo.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 2: 
          localk.title = locala.LVo.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 3: 
          localk.dBN = locala.LVo.xG();
          AppMethodBeat.o(91322);
          return 0;
        case 5: 
          localk.DKO = locala.LVo.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 10: 
          localk.state = locala.LVo.xF();
          AppMethodBeat.o(91322);
          return 0;
        case 11: 
          localk.role = locala.LVo.xF();
          AppMethodBeat.o(91322);
          return 0;
        case 12: 
          localk.DKP = locala.LVo.readString();
          AppMethodBeat.o(91322);
          return 0;
        case 13: 
          localk.DKB = locala.LVo.readString();
          AppMethodBeat.o(91322);
          return 0;
        }
        localk.DKQ = locala.LVo.readString();
        AppMethodBeat.o(91322);
        return 0;
      }
      AppMethodBeat.o(91322);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.k
 * JD-Core Version:    0.7.0.1
 */
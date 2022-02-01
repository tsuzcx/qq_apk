package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class fjo
  extends com.tencent.mm.bx.a
{
  public String nTA;
  public String nTB;
  public String nTu;
  public int nTv;
  public String nTw;
  public String nTx;
  public String nTy;
  public String nTz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125846);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nTu != null) {
        paramVarArgs.g(1, this.nTu);
      }
      paramVarArgs.bS(2, this.nTv);
      if (this.nTx != null) {
        paramVarArgs.g(3, this.nTx);
      }
      if (this.nTy != null) {
        paramVarArgs.g(4, this.nTy);
      }
      if (this.nTw != null) {
        paramVarArgs.g(5, this.nTw);
      }
      if (this.nTz != null) {
        paramVarArgs.g(6, this.nTz);
      }
      if (this.nTA != null) {
        paramVarArgs.g(7, this.nTA);
      }
      if (this.nTB != null) {
        paramVarArgs.g(8, this.nTB);
      }
      AppMethodBeat.o(125846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nTu == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = i.a.a.b.b.a.h(1, this.nTu) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.nTv);
      paramInt = i;
      if (this.nTx != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.nTx);
      }
      i = paramInt;
      if (this.nTy != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.nTy);
      }
      paramInt = i;
      if (this.nTw != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nTw);
      }
      i = paramInt;
      if (this.nTz != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.nTz);
      }
      paramInt = i;
      if (this.nTA != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.nTA);
      }
      i = paramInt;
      if (this.nTB != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.nTB);
      }
      AppMethodBeat.o(125846);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125846);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fjo localfjo = (fjo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125846);
          return -1;
        case 1: 
          localfjo.nTu = locala.ajGk.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 2: 
          localfjo.nTv = locala.ajGk.aar();
          AppMethodBeat.o(125846);
          return 0;
        case 3: 
          localfjo.nTx = locala.ajGk.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 4: 
          localfjo.nTy = locala.ajGk.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 5: 
          localfjo.nTw = locala.ajGk.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 6: 
          localfjo.nTz = locala.ajGk.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 7: 
          localfjo.nTA = locala.ajGk.readString();
          AppMethodBeat.o(125846);
          return 0;
        }
        localfjo.nTB = locala.ajGk.readString();
        AppMethodBeat.o(125846);
        return 0;
      }
      AppMethodBeat.o(125846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fjo
 * JD-Core Version:    0.7.0.1
 */
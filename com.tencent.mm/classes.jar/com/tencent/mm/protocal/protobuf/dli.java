package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dli
  extends com.tencent.mm.bx.a
{
  public String ZTB;
  public int ZTv;
  public String ZTw;
  public String ZTx;
  public String ZTy;
  public String aaRm;
  public String aaRn;
  public String aaRo;
  public String aaRp;
  public int aaRq;
  public String aaRr;
  public String aaRs;
  public String aaRt;
  public String aaRu;
  public String aaRv;
  public int aaRw;
  public int copyright;
  public int offset;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259246);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      paramVarArgs.bS(2, this.ZTv);
      if (this.aaRm != null) {
        paramVarArgs.g(3, this.aaRm);
      }
      if (this.ZTw != null) {
        paramVarArgs.g(4, this.ZTw);
      }
      if (this.ZTx != null) {
        paramVarArgs.g(5, this.ZTx);
      }
      if (this.ZTy != null) {
        paramVarArgs.g(6, this.ZTy);
      }
      if (this.aaRn != null) {
        paramVarArgs.g(7, this.aaRn);
      }
      if (this.aaRo != null) {
        paramVarArgs.g(8, this.aaRo);
      }
      if (this.aaRp != null) {
        paramVarArgs.g(9, this.aaRp);
      }
      paramVarArgs.bS(10, this.aaRq);
      if (this.ZTB != null) {
        paramVarArgs.g(11, this.ZTB);
      }
      if (this.aaRr != null) {
        paramVarArgs.g(12, this.aaRr);
      }
      if (this.aaRs != null) {
        paramVarArgs.g(13, this.aaRs);
      }
      if (this.aaRt != null) {
        paramVarArgs.g(14, this.aaRt);
      }
      if (this.aaRu != null) {
        paramVarArgs.g(15, this.aaRu);
      }
      if (this.aaRv != null) {
        paramVarArgs.g(16, this.aaRv);
      }
      paramVarArgs.bS(17, this.copyright);
      paramVarArgs.bS(18, this.offset);
      paramVarArgs.bS(19, this.aaRw);
      AppMethodBeat.o(259246);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0 + i.a.a.b.b.a.cJ(2, this.ZTv);
      paramInt = i;
      if (this.aaRm != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aaRm);
      }
      i = paramInt;
      if (this.ZTw != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZTw);
      }
      paramInt = i;
      if (this.ZTx != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZTx);
      }
      i = paramInt;
      if (this.ZTy != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZTy);
      }
      paramInt = i;
      if (this.aaRn != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aaRn);
      }
      i = paramInt;
      if (this.aaRo != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aaRo);
      }
      paramInt = i;
      if (this.aaRp != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaRp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.aaRq);
      paramInt = i;
      if (this.ZTB != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZTB);
      }
      i = paramInt;
      if (this.aaRr != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.aaRr);
      }
      paramInt = i;
      if (this.aaRs != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.aaRs);
      }
      i = paramInt;
      if (this.aaRt != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.aaRt);
      }
      paramInt = i;
      if (this.aaRu != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.aaRu);
      }
      i = paramInt;
      if (this.aaRv != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.aaRv);
      }
      paramInt = i.a.a.b.b.a.cJ(17, this.copyright);
      int j = i.a.a.b.b.a.cJ(18, this.offset);
      int k = i.a.a.b.b.a.cJ(19, this.aaRw);
      AppMethodBeat.o(259246);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259246);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dli localdli = (dli)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259246);
        return -1;
      case 1: 
        localdli.type = locala.ajGk.aar();
        AppMethodBeat.o(259246);
        return 0;
      case 2: 
        localdli.ZTv = locala.ajGk.aar();
        AppMethodBeat.o(259246);
        return 0;
      case 3: 
        localdli.aaRm = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 4: 
        localdli.ZTw = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 5: 
        localdli.ZTx = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 6: 
        localdli.ZTy = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 7: 
        localdli.aaRn = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 8: 
        localdli.aaRo = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 9: 
        localdli.aaRp = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 10: 
        localdli.aaRq = locala.ajGk.aar();
        AppMethodBeat.o(259246);
        return 0;
      case 11: 
        localdli.ZTB = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 12: 
        localdli.aaRr = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 13: 
        localdli.aaRs = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 14: 
        localdli.aaRt = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 15: 
        localdli.aaRu = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 16: 
        localdli.aaRv = locala.ajGk.readString();
        AppMethodBeat.o(259246);
        return 0;
      case 17: 
        localdli.copyright = locala.ajGk.aar();
        AppMethodBeat.o(259246);
        return 0;
      case 18: 
        localdli.offset = locala.ajGk.aar();
        AppMethodBeat.o(259246);
        return 0;
      }
      localdli.aaRw = locala.ajGk.aar();
      AppMethodBeat.o(259246);
      return 0;
    }
    AppMethodBeat.o(259246);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dli
 * JD-Core Version:    0.7.0.1
 */
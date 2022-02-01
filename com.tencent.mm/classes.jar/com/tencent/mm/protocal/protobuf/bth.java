package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bth
  extends com.tencent.mm.bx.a
{
  public String DGl;
  public String ESn;
  public String aabe;
  public String aabf;
  public String aabg;
  public String aabh;
  public String aabi;
  public int aabj;
  public int aabk;
  public String aabl;
  public String appId;
  public String coverUrl;
  public String finderUsername;
  public String hzy;
  public String productId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259541);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aabe != null) {
        paramVarArgs.g(1, this.aabe);
      }
      if (this.finderUsername != null) {
        paramVarArgs.g(2, this.finderUsername);
      }
      if (this.aabf != null) {
        paramVarArgs.g(3, this.aabf);
      }
      if (this.aabg != null) {
        paramVarArgs.g(4, this.aabg);
      }
      if (this.aabh != null) {
        paramVarArgs.g(5, this.aabh);
      }
      if (this.appId != null) {
        paramVarArgs.g(6, this.appId);
      }
      if (this.hzy != null) {
        paramVarArgs.g(7, this.hzy);
      }
      if (this.productId != null) {
        paramVarArgs.g(8, this.productId);
      }
      if (this.coverUrl != null) {
        paramVarArgs.g(9, this.coverUrl);
      }
      if (this.aabi != null) {
        paramVarArgs.g(10, this.aabi);
      }
      paramVarArgs.bS(11, this.aabj);
      paramVarArgs.bS(12, this.aabk);
      if (this.aabl != null) {
        paramVarArgs.g(13, this.aabl);
      }
      if (this.ESn != null) {
        paramVarArgs.g(14, this.ESn);
      }
      if (this.DGl != null) {
        paramVarArgs.g(15, this.DGl);
      }
      AppMethodBeat.o(259541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aabe == null) {
        break label1038;
      }
    }
    label1038:
    for (int i = i.a.a.b.b.a.h(1, this.aabe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.finderUsername);
      }
      i = paramInt;
      if (this.aabf != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aabf);
      }
      paramInt = i;
      if (this.aabg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aabg);
      }
      i = paramInt;
      if (this.aabh != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aabh);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.appId);
      }
      i = paramInt;
      if (this.hzy != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.hzy);
      }
      paramInt = i;
      if (this.productId != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.productId);
      }
      i = paramInt;
      if (this.coverUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.coverUrl);
      }
      paramInt = i;
      if (this.aabi != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aabi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.aabj) + i.a.a.b.b.a.cJ(12, this.aabk);
      paramInt = i;
      if (this.aabl != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.aabl);
      }
      i = paramInt;
      if (this.ESn != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.ESn);
      }
      paramInt = i;
      if (this.DGl != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.DGl);
      }
      AppMethodBeat.o(259541);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259541);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bth localbth = (bth)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259541);
          return -1;
        case 1: 
          localbth.aabe = locala.ajGk.readString();
          AppMethodBeat.o(259541);
          return 0;
        case 2: 
          localbth.finderUsername = locala.ajGk.readString();
          AppMethodBeat.o(259541);
          return 0;
        case 3: 
          localbth.aabf = locala.ajGk.readString();
          AppMethodBeat.o(259541);
          return 0;
        case 4: 
          localbth.aabg = locala.ajGk.readString();
          AppMethodBeat.o(259541);
          return 0;
        case 5: 
          localbth.aabh = locala.ajGk.readString();
          AppMethodBeat.o(259541);
          return 0;
        case 6: 
          localbth.appId = locala.ajGk.readString();
          AppMethodBeat.o(259541);
          return 0;
        case 7: 
          localbth.hzy = locala.ajGk.readString();
          AppMethodBeat.o(259541);
          return 0;
        case 8: 
          localbth.productId = locala.ajGk.readString();
          AppMethodBeat.o(259541);
          return 0;
        case 9: 
          localbth.coverUrl = locala.ajGk.readString();
          AppMethodBeat.o(259541);
          return 0;
        case 10: 
          localbth.aabi = locala.ajGk.readString();
          AppMethodBeat.o(259541);
          return 0;
        case 11: 
          localbth.aabj = locala.ajGk.aar();
          AppMethodBeat.o(259541);
          return 0;
        case 12: 
          localbth.aabk = locala.ajGk.aar();
          AppMethodBeat.o(259541);
          return 0;
        case 13: 
          localbth.aabl = locala.ajGk.readString();
          AppMethodBeat.o(259541);
          return 0;
        case 14: 
          localbth.ESn = locala.ajGk.readString();
          AppMethodBeat.o(259541);
          return 0;
        }
        localbth.DGl = locala.ajGk.readString();
        AppMethodBeat.o(259541);
        return 0;
      }
      AppMethodBeat.o(259541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bth
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bqj
  extends com.tencent.mm.bx.a
{
  public String HsD;
  public String ZYo;
  public String ZYp;
  public String ZYq;
  public String ZYr;
  public int ZYs;
  public String albumName;
  public String artist;
  public String name;
  public String rDm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257710);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.HsD != null) {
        paramVarArgs.g(1, this.HsD);
      }
      if (this.ZYo != null) {
        paramVarArgs.g(2, this.ZYo);
      }
      if (this.name != null) {
        paramVarArgs.g(3, this.name);
      }
      if (this.artist != null) {
        paramVarArgs.g(4, this.artist);
      }
      if (this.albumName != null) {
        paramVarArgs.g(5, this.albumName);
      }
      if (this.ZYp != null) {
        paramVarArgs.g(6, this.ZYp);
      }
      if (this.ZYq != null) {
        paramVarArgs.g(7, this.ZYq);
      }
      if (this.rDm != null) {
        paramVarArgs.g(8, this.rDm);
      }
      if (this.ZYr != null) {
        paramVarArgs.g(9, this.ZYr);
      }
      paramVarArgs.bS(10, this.ZYs);
      AppMethodBeat.o(257710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HsD == null) {
        break label746;
      }
    }
    label746:
    for (int i = i.a.a.b.b.a.h(1, this.HsD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZYo != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZYo);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.name);
      }
      paramInt = i;
      if (this.artist != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.artist);
      }
      i = paramInt;
      if (this.albumName != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.albumName);
      }
      paramInt = i;
      if (this.ZYp != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZYp);
      }
      i = paramInt;
      if (this.ZYq != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZYq);
      }
      paramInt = i;
      if (this.rDm != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.rDm);
      }
      i = paramInt;
      if (this.ZYr != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZYr);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.ZYs);
      AppMethodBeat.o(257710);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257710);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bqj localbqj = (bqj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257710);
          return -1;
        case 1: 
          localbqj.HsD = locala.ajGk.readString();
          AppMethodBeat.o(257710);
          return 0;
        case 2: 
          localbqj.ZYo = locala.ajGk.readString();
          AppMethodBeat.o(257710);
          return 0;
        case 3: 
          localbqj.name = locala.ajGk.readString();
          AppMethodBeat.o(257710);
          return 0;
        case 4: 
          localbqj.artist = locala.ajGk.readString();
          AppMethodBeat.o(257710);
          return 0;
        case 5: 
          localbqj.albumName = locala.ajGk.readString();
          AppMethodBeat.o(257710);
          return 0;
        case 6: 
          localbqj.ZYp = locala.ajGk.readString();
          AppMethodBeat.o(257710);
          return 0;
        case 7: 
          localbqj.ZYq = locala.ajGk.readString();
          AppMethodBeat.o(257710);
          return 0;
        case 8: 
          localbqj.rDm = locala.ajGk.readString();
          AppMethodBeat.o(257710);
          return 0;
        case 9: 
          localbqj.ZYr = locala.ajGk.readString();
          AppMethodBeat.o(257710);
          return 0;
        }
        localbqj.ZYs = locala.ajGk.aar();
        AppMethodBeat.o(257710);
        return 0;
      }
      AppMethodBeat.o(257710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqj
 * JD-Core Version:    0.7.0.1
 */
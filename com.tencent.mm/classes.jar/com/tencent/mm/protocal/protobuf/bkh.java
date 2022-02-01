package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkh
  extends com.tencent.mm.bx.a
{
  public String ZTA;
  public String ZTB;
  public String ZTC;
  public int ZTv;
  public String ZTw;
  public String ZTx;
  public String ZTy;
  public String ZTz;
  public boolean playable;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259653);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZTv);
      if (this.ZTw != null) {
        paramVarArgs.g(2, this.ZTw);
      }
      if (this.ZTx != null) {
        paramVarArgs.g(3, this.ZTx);
      }
      if (this.ZTy != null) {
        paramVarArgs.g(4, this.ZTy);
      }
      if (this.ZTz != null) {
        paramVarArgs.g(5, this.ZTz);
      }
      if (this.ZTA != null) {
        paramVarArgs.g(6, this.ZTA);
      }
      paramVarArgs.di(7, this.playable);
      if (this.ZTB != null) {
        paramVarArgs.g(8, this.ZTB);
      }
      if (this.ZTC != null) {
        paramVarArgs.g(9, this.ZTC);
      }
      AppMethodBeat.o(259653);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZTv) + 0;
      paramInt = i;
      if (this.ZTw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZTw);
      }
      i = paramInt;
      if (this.ZTx != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZTx);
      }
      paramInt = i;
      if (this.ZTy != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZTy);
      }
      i = paramInt;
      if (this.ZTz != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZTz);
      }
      paramInt = i;
      if (this.ZTA != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZTA);
      }
      i = paramInt + (i.a.a.b.b.a.ko(7) + 1);
      paramInt = i;
      if (this.ZTB != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZTB);
      }
      i = paramInt;
      if (this.ZTC != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZTC);
      }
      AppMethodBeat.o(259653);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259653);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bkh localbkh = (bkh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259653);
        return -1;
      case 1: 
        localbkh.ZTv = locala.ajGk.aar();
        AppMethodBeat.o(259653);
        return 0;
      case 2: 
        localbkh.ZTw = locala.ajGk.readString();
        AppMethodBeat.o(259653);
        return 0;
      case 3: 
        localbkh.ZTx = locala.ajGk.readString();
        AppMethodBeat.o(259653);
        return 0;
      case 4: 
        localbkh.ZTy = locala.ajGk.readString();
        AppMethodBeat.o(259653);
        return 0;
      case 5: 
        localbkh.ZTz = locala.ajGk.readString();
        AppMethodBeat.o(259653);
        return 0;
      case 6: 
        localbkh.ZTA = locala.ajGk.readString();
        AppMethodBeat.o(259653);
        return 0;
      case 7: 
        localbkh.playable = locala.ajGk.aai();
        AppMethodBeat.o(259653);
        return 0;
      case 8: 
        localbkh.ZTB = locala.ajGk.readString();
        AppMethodBeat.o(259653);
        return 0;
      }
      localbkh.ZTC = locala.ajGk.readString();
      AppMethodBeat.o(259653);
      return 0;
    }
    AppMethodBeat.o(259653);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkh
 * JD-Core Version:    0.7.0.1
 */
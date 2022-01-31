package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kw
  extends com.tencent.mm.bv.a
{
  public String kqi;
  public int ver;
  public String wyc;
  public int wyd;
  public String wyg;
  public String wyi;
  public String wyq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11709);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wyi != null) {
        paramVarArgs.e(1, this.wyi);
      }
      if (this.kqi != null) {
        paramVarArgs.e(2, this.kqi);
      }
      paramVarArgs.aO(3, this.ver);
      if (this.wyc != null) {
        paramVarArgs.e(4, this.wyc);
      }
      if (this.wyq != null) {
        paramVarArgs.e(5, this.wyq);
      }
      paramVarArgs.aO(6, this.wyd);
      if (this.wyg != null) {
        paramVarArgs.e(7, this.wyg);
      }
      AppMethodBeat.o(11709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wyi == null) {
        break label559;
      }
    }
    label559:
    for (paramInt = e.a.a.b.b.a.f(1, this.wyi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kqi != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.kqi);
      }
      i += e.a.a.b.b.a.bl(3, this.ver);
      paramInt = i;
      if (this.wyc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wyc);
      }
      i = paramInt;
      if (this.wyq != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wyq);
      }
      i += e.a.a.b.b.a.bl(6, this.wyd);
      paramInt = i;
      if (this.wyg != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wyg);
      }
      AppMethodBeat.o(11709);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11709);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        kw localkw = (kw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11709);
          return -1;
        case 1: 
          localkw.wyi = locala.CLY.readString();
          AppMethodBeat.o(11709);
          return 0;
        case 2: 
          localkw.kqi = locala.CLY.readString();
          AppMethodBeat.o(11709);
          return 0;
        case 3: 
          localkw.ver = locala.CLY.sl();
          AppMethodBeat.o(11709);
          return 0;
        case 4: 
          localkw.wyc = locala.CLY.readString();
          AppMethodBeat.o(11709);
          return 0;
        case 5: 
          localkw.wyq = locala.CLY.readString();
          AppMethodBeat.o(11709);
          return 0;
        case 6: 
          localkw.wyd = locala.CLY.sl();
          AppMethodBeat.o(11709);
          return 0;
        }
        localkw.wyg = locala.CLY.readString();
        AppMethodBeat.o(11709);
        return 0;
      }
      AppMethodBeat.o(11709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kw
 * JD-Core Version:    0.7.0.1
 */
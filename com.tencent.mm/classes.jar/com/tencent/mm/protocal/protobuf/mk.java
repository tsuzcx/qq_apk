package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mk
  extends com.tencent.mm.bw.a
{
  public String Ebl;
  public String Ebm;
  public int Ebn;
  public int Ebo;
  public String Ebp;
  public String Ebq;
  public int Ebr;
  public String name;
  public int type;
  public int ver;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ebl != null) {
        paramVarArgs.d(1, this.Ebl);
      }
      paramVarArgs.aR(2, this.type);
      if (this.Ebm != null) {
        paramVarArgs.d(3, this.Ebm);
      }
      if (this.name != null) {
        paramVarArgs.d(4, this.name);
      }
      paramVarArgs.aR(5, this.ver);
      paramVarArgs.aR(6, this.Ebn);
      paramVarArgs.aR(7, this.Ebo);
      if (this.Ebp != null) {
        paramVarArgs.d(8, this.Ebp);
      }
      if (this.Ebq != null) {
        paramVarArgs.d(9, this.Ebq);
      }
      paramVarArgs.aR(10, this.Ebr);
      AppMethodBeat.o(124416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ebl == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ebl) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.type);
      paramInt = i;
      if (this.Ebm != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ebm);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.name);
      }
      i = i + f.a.a.b.b.a.bx(5, this.ver) + f.a.a.b.b.a.bx(6, this.Ebn) + f.a.a.b.b.a.bx(7, this.Ebo);
      paramInt = i;
      if (this.Ebp != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Ebp);
      }
      i = paramInt;
      if (this.Ebq != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ebq);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.Ebr);
      AppMethodBeat.o(124416);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124416);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        mk localmk = (mk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124416);
          return -1;
        case 1: 
          localmk.Ebl = locala.LVo.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 2: 
          localmk.type = locala.LVo.xF();
          AppMethodBeat.o(124416);
          return 0;
        case 3: 
          localmk.Ebm = locala.LVo.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 4: 
          localmk.name = locala.LVo.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 5: 
          localmk.ver = locala.LVo.xF();
          AppMethodBeat.o(124416);
          return 0;
        case 6: 
          localmk.Ebn = locala.LVo.xF();
          AppMethodBeat.o(124416);
          return 0;
        case 7: 
          localmk.Ebo = locala.LVo.xF();
          AppMethodBeat.o(124416);
          return 0;
        case 8: 
          localmk.Ebp = locala.LVo.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 9: 
          localmk.Ebq = locala.LVo.readString();
          AppMethodBeat.o(124416);
          return 0;
        }
        localmk.Ebr = locala.LVo.xF();
        AppMethodBeat.o(124416);
        return 0;
      }
      AppMethodBeat.o(124416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mk
 * JD-Core Version:    0.7.0.1
 */
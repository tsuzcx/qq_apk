package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kp
  extends com.tencent.mm.bv.a
{
  public String name;
  public int type;
  public int ver;
  public String wyb;
  public String wyc;
  public int wyd;
  public int wye;
  public String wyf;
  public String wyg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11700);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wyb != null) {
        paramVarArgs.e(1, this.wyb);
      }
      paramVarArgs.aO(2, this.type);
      if (this.wyc != null) {
        paramVarArgs.e(3, this.wyc);
      }
      if (this.name != null) {
        paramVarArgs.e(4, this.name);
      }
      paramVarArgs.aO(5, this.ver);
      paramVarArgs.aO(6, this.wyd);
      paramVarArgs.aO(7, this.wye);
      if (this.wyf != null) {
        paramVarArgs.e(8, this.wyf);
      }
      if (this.wyg != null) {
        paramVarArgs.e(9, this.wyg);
      }
      AppMethodBeat.o(11700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wyb == null) {
        break label649;
      }
    }
    label649:
    for (paramInt = e.a.a.b.b.a.f(1, this.wyb) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.type);
      paramInt = i;
      if (this.wyc != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wyc);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.name);
      }
      i = i + e.a.a.b.b.a.bl(5, this.ver) + e.a.a.b.b.a.bl(6, this.wyd) + e.a.a.b.b.a.bl(7, this.wye);
      paramInt = i;
      if (this.wyf != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wyf);
      }
      i = paramInt;
      if (this.wyg != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wyg);
      }
      AppMethodBeat.o(11700);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(11700);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        kp localkp = (kp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(11700);
          return -1;
        case 1: 
          localkp.wyb = locala.CLY.readString();
          AppMethodBeat.o(11700);
          return 0;
        case 2: 
          localkp.type = locala.CLY.sl();
          AppMethodBeat.o(11700);
          return 0;
        case 3: 
          localkp.wyc = locala.CLY.readString();
          AppMethodBeat.o(11700);
          return 0;
        case 4: 
          localkp.name = locala.CLY.readString();
          AppMethodBeat.o(11700);
          return 0;
        case 5: 
          localkp.ver = locala.CLY.sl();
          AppMethodBeat.o(11700);
          return 0;
        case 6: 
          localkp.wyd = locala.CLY.sl();
          AppMethodBeat.o(11700);
          return 0;
        case 7: 
          localkp.wye = locala.CLY.sl();
          AppMethodBeat.o(11700);
          return 0;
        case 8: 
          localkp.wyf = locala.CLY.readString();
          AppMethodBeat.o(11700);
          return 0;
        }
        localkp.wyg = locala.CLY.readString();
        AppMethodBeat.o(11700);
        return 0;
      }
      AppMethodBeat.o(11700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kp
 * JD-Core Version:    0.7.0.1
 */
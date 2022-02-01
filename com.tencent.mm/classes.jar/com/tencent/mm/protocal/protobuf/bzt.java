package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzt
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String IMu;
  public String UserName;
  public String YFC;
  public int aaiS;
  public String aaiT;
  public String crB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149139);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFC != null) {
        paramVarArgs.g(1, this.YFC);
      }
      paramVarArgs.bS(2, this.CreateTime);
      paramVarArgs.bS(3, this.aaiS);
      if (this.crB != null) {
        paramVarArgs.g(4, this.crB);
      }
      if (this.aaiT != null) {
        paramVarArgs.g(5, this.aaiT);
      }
      if (this.UserName != null) {
        paramVarArgs.g(6, this.UserName);
      }
      if (this.IMu != null) {
        paramVarArgs.g(7, this.IMu);
      }
      AppMethodBeat.o(149139);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YFC == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = i.a.a.b.b.a.h(1, this.YFC) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.CreateTime) + i.a.a.b.b.a.cJ(3, this.aaiS);
      paramInt = i;
      if (this.crB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.crB);
      }
      i = paramInt;
      if (this.aaiT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaiT);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.UserName);
      }
      i = paramInt;
      if (this.IMu != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.IMu);
      }
      AppMethodBeat.o(149139);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(149139);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bzt localbzt = (bzt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149139);
          return -1;
        case 1: 
          localbzt.YFC = locala.ajGk.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 2: 
          localbzt.CreateTime = locala.ajGk.aar();
          AppMethodBeat.o(149139);
          return 0;
        case 3: 
          localbzt.aaiS = locala.ajGk.aar();
          AppMethodBeat.o(149139);
          return 0;
        case 4: 
          localbzt.crB = locala.ajGk.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 5: 
          localbzt.aaiT = locala.ajGk.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 6: 
          localbzt.UserName = locala.ajGk.readString();
          AppMethodBeat.o(149139);
          return 0;
        }
        localbzt.IMu = locala.ajGk.readString();
        AppMethodBeat.o(149139);
        return 0;
      }
      AppMethodBeat.o(149139);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzt
 * JD-Core Version:    0.7.0.1
 */
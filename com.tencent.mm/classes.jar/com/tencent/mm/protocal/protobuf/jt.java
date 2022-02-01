package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jt
  extends com.tencent.mm.bx.a
{
  public String YLZ;
  public String YMa;
  public String YMb;
  public String YMc;
  public String YMd;
  public String icon_url;
  public String jump_url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124392);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YLZ != null) {
        paramVarArgs.g(1, this.YLZ);
      }
      if (this.YMa != null) {
        paramVarArgs.g(2, this.YMa);
      }
      if (this.YMb != null) {
        paramVarArgs.g(3, this.YMb);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(4, this.icon_url);
      }
      if (this.jump_url != null) {
        paramVarArgs.g(5, this.jump_url);
      }
      if (this.YMc != null) {
        paramVarArgs.g(6, this.YMc);
      }
      if (this.YMd != null) {
        paramVarArgs.g(7, this.YMd);
      }
      AppMethodBeat.o(124392);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YLZ == null) {
        break label574;
      }
    }
    label574:
    for (int i = i.a.a.b.b.a.h(1, this.YLZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YMa != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YMa);
      }
      i = paramInt;
      if (this.YMb != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YMb);
      }
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.icon_url);
      }
      i = paramInt;
      if (this.jump_url != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.jump_url);
      }
      paramInt = i;
      if (this.YMc != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YMc);
      }
      i = paramInt;
      if (this.YMd != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YMd);
      }
      AppMethodBeat.o(124392);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124392);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        jt localjt = (jt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124392);
          return -1;
        case 1: 
          localjt.YLZ = locala.ajGk.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 2: 
          localjt.YMa = locala.ajGk.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 3: 
          localjt.YMb = locala.ajGk.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 4: 
          localjt.icon_url = locala.ajGk.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 5: 
          localjt.jump_url = locala.ajGk.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 6: 
          localjt.YMc = locala.ajGk.readString();
          AppMethodBeat.o(124392);
          return 0;
        }
        localjt.YMd = locala.ajGk.readString();
        AppMethodBeat.o(124392);
        return 0;
      }
      AppMethodBeat.o(124392);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jt
 * JD-Core Version:    0.7.0.1
 */
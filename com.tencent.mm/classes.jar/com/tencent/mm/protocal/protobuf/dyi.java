package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyi
  extends com.tencent.mm.bw.a
{
  public long MXW;
  public int actionType;
  public String dQx;
  public String icon;
  public String id;
  public String oqZ;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152995);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      paramVarArgs.bb(3, this.MXW);
      paramVarArgs.aM(4, this.actionType);
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      if (this.title != null) {
        paramVarArgs.e(6, this.title);
      }
      if (this.oqZ != null) {
        paramVarArgs.e(7, this.oqZ);
      }
      if (this.icon != null) {
        paramVarArgs.e(8, this.icon);
      }
      AppMethodBeat.o(152995);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = g.a.a.b.b.a.f(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dQx != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = i + g.a.a.b.b.a.r(3, this.MXW) + g.a.a.b.b.a.bu(4, this.actionType);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.title);
      }
      paramInt = i;
      if (this.oqZ != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.oqZ);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.icon);
      }
      AppMethodBeat.o(152995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152995);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dyi localdyi = (dyi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152995);
          return -1;
        case 1: 
          localdyi.id = locala.UbS.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 2: 
          localdyi.dQx = locala.UbS.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 3: 
          localdyi.MXW = locala.UbS.zl();
          AppMethodBeat.o(152995);
          return 0;
        case 4: 
          localdyi.actionType = locala.UbS.zi();
          AppMethodBeat.o(152995);
          return 0;
        case 5: 
          localdyi.url = locala.UbS.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 6: 
          localdyi.title = locala.UbS.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 7: 
          localdyi.oqZ = locala.UbS.readString();
          AppMethodBeat.o(152995);
          return 0;
        }
        localdyi.icon = locala.UbS.readString();
        AppMethodBeat.o(152995);
        return 0;
      }
      AppMethodBeat.o(152995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyi
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxs
  extends com.tencent.mm.bw.a
{
  public String MXr;
  public String MXs;
  public String MXt;
  public String MXu;
  public int MXv;
  public String MXw;
  public String content;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153299);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.e(1, this.content);
      }
      if (this.MXr != null) {
        paramVarArgs.e(2, this.MXr);
      }
      if (this.MXs != null) {
        paramVarArgs.e(3, this.MXs);
      }
      if (this.MXt != null) {
        paramVarArgs.e(4, this.MXt);
      }
      if (this.MXu != null) {
        paramVarArgs.e(5, this.MXu);
      }
      paramVarArgs.aM(6, this.MXv);
      paramVarArgs.aM(7, this.state);
      if (this.MXw != null) {
        paramVarArgs.e(8, this.MXw);
      }
      AppMethodBeat.o(153299);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label606;
      }
    }
    label606:
    for (int i = g.a.a.b.b.a.f(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MXr != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MXr);
      }
      i = paramInt;
      if (this.MXs != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MXs);
      }
      paramInt = i;
      if (this.MXt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MXt);
      }
      i = paramInt;
      if (this.MXu != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MXu);
      }
      i = i + g.a.a.b.b.a.bu(6, this.MXv) + g.a.a.b.b.a.bu(7, this.state);
      paramInt = i;
      if (this.MXw != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MXw);
      }
      AppMethodBeat.o(153299);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153299);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dxs localdxs = (dxs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153299);
          return -1;
        case 1: 
          localdxs.content = locala.UbS.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 2: 
          localdxs.MXr = locala.UbS.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 3: 
          localdxs.MXs = locala.UbS.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 4: 
          localdxs.MXt = locala.UbS.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 5: 
          localdxs.MXu = locala.UbS.readString();
          AppMethodBeat.o(153299);
          return 0;
        case 6: 
          localdxs.MXv = locala.UbS.zi();
          AppMethodBeat.o(153299);
          return 0;
        case 7: 
          localdxs.state = locala.UbS.zi();
          AppMethodBeat.o(153299);
          return 0;
        }
        localdxs.MXw = locala.UbS.readString();
        AppMethodBeat.o(153299);
        return 0;
      }
      AppMethodBeat.o(153299);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxs
 * JD-Core Version:    0.7.0.1
 */
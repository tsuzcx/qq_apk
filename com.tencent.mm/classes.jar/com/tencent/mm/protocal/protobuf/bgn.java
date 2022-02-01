package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgn
  extends com.tencent.mm.bw.a
{
  public String LQp;
  public String LQq;
  public String LzG;
  public String jfi;
  public String xut;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200178);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jfi != null) {
        paramVarArgs.e(1, this.jfi);
      }
      if (this.xut != null) {
        paramVarArgs.e(2, this.xut);
      }
      if (this.LzG != null) {
        paramVarArgs.e(3, this.LzG);
      }
      if (this.LQp != null) {
        paramVarArgs.e(4, this.LQp);
      }
      if (this.LQq != null) {
        paramVarArgs.e(5, this.LQq);
      }
      AppMethodBeat.o(200178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jfi == null) {
        break label454;
      }
    }
    label454:
    for (int i = g.a.a.b.b.a.f(1, this.jfi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xut != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xut);
      }
      i = paramInt;
      if (this.LzG != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LzG);
      }
      paramInt = i;
      if (this.LQp != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LQp);
      }
      i = paramInt;
      if (this.LQq != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LQq);
      }
      AppMethodBeat.o(200178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200178);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bgn localbgn = (bgn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200178);
          return -1;
        case 1: 
          localbgn.jfi = locala.UbS.readString();
          AppMethodBeat.o(200178);
          return 0;
        case 2: 
          localbgn.xut = locala.UbS.readString();
          AppMethodBeat.o(200178);
          return 0;
        case 3: 
          localbgn.LzG = locala.UbS.readString();
          AppMethodBeat.o(200178);
          return 0;
        case 4: 
          localbgn.LQp = locala.UbS.readString();
          AppMethodBeat.o(200178);
          return 0;
        }
        localbgn.LQq = locala.UbS.readString();
        AppMethodBeat.o(200178);
        return 0;
      }
      AppMethodBeat.o(200178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgn
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class pn
  extends com.tencent.mm.bv.a
{
  public String kWy;
  public String kmn;
  public String kqb;
  public String title;
  public String url;
  public String wFL;
  public String wFM;
  public long wGZ;
  public String wHa;
  public String wHb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89047);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.kmn != null) {
        paramVarArgs.e(2, this.kmn);
      }
      if (this.kqb != null) {
        paramVarArgs.e(3, this.kqb);
      }
      if (this.url != null) {
        paramVarArgs.e(4, this.url);
      }
      paramVarArgs.am(5, this.wGZ);
      if (this.wHa != null) {
        paramVarArgs.e(6, this.wHa);
      }
      if (this.wHb != null) {
        paramVarArgs.e(7, this.wHb);
      }
      if (this.kWy != null) {
        paramVarArgs.e(8, this.kWy);
      }
      if (this.wFL != null) {
        paramVarArgs.e(9, this.wFL);
      }
      if (this.wFM != null) {
        paramVarArgs.e(10, this.wFM);
      }
      AppMethodBeat.o(89047);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label750;
      }
    }
    label750:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kmn != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.kmn);
      }
      i = paramInt;
      if (this.kqb != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kqb);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.url);
      }
      i = paramInt + e.a.a.b.b.a.p(5, this.wGZ);
      paramInt = i;
      if (this.wHa != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wHa);
      }
      i = paramInt;
      if (this.wHb != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wHb);
      }
      paramInt = i;
      if (this.kWy != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.kWy);
      }
      i = paramInt;
      if (this.wFL != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wFL);
      }
      paramInt = i;
      if (this.wFM != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wFM);
      }
      AppMethodBeat.o(89047);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89047);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        pn localpn = (pn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(89047);
          return -1;
        case 1: 
          localpn.title = locala.CLY.readString();
          AppMethodBeat.o(89047);
          return 0;
        case 2: 
          localpn.kmn = locala.CLY.readString();
          AppMethodBeat.o(89047);
          return 0;
        case 3: 
          localpn.kqb = locala.CLY.readString();
          AppMethodBeat.o(89047);
          return 0;
        case 4: 
          localpn.url = locala.CLY.readString();
          AppMethodBeat.o(89047);
          return 0;
        case 5: 
          localpn.wGZ = locala.CLY.sm();
          AppMethodBeat.o(89047);
          return 0;
        case 6: 
          localpn.wHa = locala.CLY.readString();
          AppMethodBeat.o(89047);
          return 0;
        case 7: 
          localpn.wHb = locala.CLY.readString();
          AppMethodBeat.o(89047);
          return 0;
        case 8: 
          localpn.kWy = locala.CLY.readString();
          AppMethodBeat.o(89047);
          return 0;
        case 9: 
          localpn.wFL = locala.CLY.readString();
          AppMethodBeat.o(89047);
          return 0;
        }
        localpn.wFM = locala.CLY.readString();
        AppMethodBeat.o(89047);
        return 0;
      }
      AppMethodBeat.o(89047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pn
 * JD-Core Version:    0.7.0.1
 */
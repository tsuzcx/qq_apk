package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bla
  extends com.tencent.mm.bw.a
{
  public String ELE;
  public String FaE;
  public String FaF;
  public String FaG;
  public String FaH;
  public String vFb;
  public String vyy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72507);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vFb == null)
      {
        paramVarArgs = new b("Not all required fields were included: product_id");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.vyy == null)
      {
        paramVarArgs = new b("Not all required fields were included: price");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.ELE == null)
      {
        paramVarArgs = new b("Not all required fields were included: currency_type");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.FaE == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.vFb != null) {
        paramVarArgs.d(1, this.vFb);
      }
      if (this.vyy != null) {
        paramVarArgs.d(2, this.vyy);
      }
      if (this.ELE != null) {
        paramVarArgs.d(3, this.ELE);
      }
      if (this.FaE != null) {
        paramVarArgs.d(4, this.FaE);
      }
      if (this.FaF != null) {
        paramVarArgs.d(5, this.FaF);
      }
      if (this.FaG != null) {
        paramVarArgs.d(6, this.FaG);
      }
      if (this.FaH != null) {
        paramVarArgs.d(7, this.FaH);
      }
      AppMethodBeat.o(72507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vFb == null) {
        break label770;
      }
    }
    label770:
    for (int i = f.a.a.b.b.a.e(1, this.vFb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vyy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vyy);
      }
      i = paramInt;
      if (this.ELE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ELE);
      }
      paramInt = i;
      if (this.FaE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FaE);
      }
      i = paramInt;
      if (this.FaF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FaF);
      }
      paramInt = i;
      if (this.FaG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FaG);
      }
      i = paramInt;
      if (this.FaH != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FaH);
      }
      AppMethodBeat.o(72507);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.vFb == null)
        {
          paramVarArgs = new b("Not all required fields were included: product_id");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.vyy == null)
        {
          paramVarArgs = new b("Not all required fields were included: price");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.ELE == null)
        {
          paramVarArgs = new b("Not all required fields were included: currency_type");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.FaE == null)
        {
          paramVarArgs = new b("Not all required fields were included: session_data");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72507);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bla localbla = (bla)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72507);
          return -1;
        case 1: 
          localbla.vFb = locala.LVo.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 2: 
          localbla.vyy = locala.LVo.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 3: 
          localbla.ELE = locala.LVo.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 4: 
          localbla.FaE = locala.LVo.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 5: 
          localbla.FaF = locala.LVo.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 6: 
          localbla.FaG = locala.LVo.readString();
          AppMethodBeat.o(72507);
          return 0;
        }
        localbla.FaH = locala.LVo.readString();
        AppMethodBeat.o(72507);
        return 0;
      }
      AppMethodBeat.o(72507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bla
 * JD-Core Version:    0.7.0.1
 */
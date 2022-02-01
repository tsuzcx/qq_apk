package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class bqc
  extends com.tencent.mm.bw.a
{
  public String GOh;
  public String HdE;
  public String HdF;
  public String HdG;
  public String HdH;
  public String wTD;
  public String xbV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72507);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xbV == null)
      {
        paramVarArgs = new b("Not all required fields were included: product_id");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.wTD == null)
      {
        paramVarArgs = new b("Not all required fields were included: price");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.GOh == null)
      {
        paramVarArgs = new b("Not all required fields were included: currency_type");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.HdE == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72507);
        throw paramVarArgs;
      }
      if (this.xbV != null) {
        paramVarArgs.d(1, this.xbV);
      }
      if (this.wTD != null) {
        paramVarArgs.d(2, this.wTD);
      }
      if (this.GOh != null) {
        paramVarArgs.d(3, this.GOh);
      }
      if (this.HdE != null) {
        paramVarArgs.d(4, this.HdE);
      }
      if (this.HdF != null) {
        paramVarArgs.d(5, this.HdF);
      }
      if (this.HdG != null) {
        paramVarArgs.d(6, this.HdG);
      }
      if (this.HdH != null) {
        paramVarArgs.d(7, this.HdH);
      }
      AppMethodBeat.o(72507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xbV == null) {
        break label770;
      }
    }
    label770:
    for (int i = f.a.a.b.b.a.e(1, this.xbV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wTD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wTD);
      }
      i = paramInt;
      if (this.GOh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GOh);
      }
      paramInt = i;
      if (this.HdE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HdE);
      }
      i = paramInt;
      if (this.HdF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HdF);
      }
      paramInt = i;
      if (this.HdG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HdG);
      }
      i = paramInt;
      if (this.HdH != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HdH);
      }
      AppMethodBeat.o(72507);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.xbV == null)
        {
          paramVarArgs = new b("Not all required fields were included: product_id");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.wTD == null)
        {
          paramVarArgs = new b("Not all required fields were included: price");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.GOh == null)
        {
          paramVarArgs = new b("Not all required fields were included: currency_type");
          AppMethodBeat.o(72507);
          throw paramVarArgs;
        }
        if (this.HdE == null)
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
        bqc localbqc = (bqc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72507);
          return -1;
        case 1: 
          localbqc.xbV = locala.OmT.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 2: 
          localbqc.wTD = locala.OmT.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 3: 
          localbqc.GOh = locala.OmT.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 4: 
          localbqc.HdE = locala.OmT.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 5: 
          localbqc.HdF = locala.OmT.readString();
          AppMethodBeat.o(72507);
          return 0;
        case 6: 
          localbqc.HdG = locala.OmT.readString();
          AppMethodBeat.o(72507);
          return 0;
        }
        localbqc.HdH = locala.OmT.readString();
        AppMethodBeat.o(72507);
        return 0;
      }
      AppMethodBeat.o(72507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqc
 * JD-Core Version:    0.7.0.1
 */
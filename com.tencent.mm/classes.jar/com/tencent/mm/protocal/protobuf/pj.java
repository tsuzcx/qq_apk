package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class pj
  extends com.tencent.mm.bx.a
{
  public int CNA;
  public String CNB;
  public int CNC;
  public String CNy;
  public String CNz;
  public String Title;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117846);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.CNy == null)
      {
        paramVarArgs = new b("Not all required fields were included: Position");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.CNz == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      if (this.CNy != null) {
        paramVarArgs.d(3, this.CNy);
      }
      if (this.CNz != null) {
        paramVarArgs.d(4, this.CNz);
      }
      paramVarArgs.aR(5, this.CNA);
      if (this.CNB != null) {
        paramVarArgs.d(6, this.CNB);
      }
      paramVarArgs.aR(7, this.CNC);
      AppMethodBeat.o(117846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Url);
      }
      i = paramInt;
      if (this.CNy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CNy);
      }
      paramInt = i;
      if (this.CNz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CNz);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CNA);
      paramInt = i;
      if (this.CNB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CNB);
      }
      i = f.a.a.b.b.a.bA(7, this.CNC);
      AppMethodBeat.o(117846);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.CNy == null)
        {
          paramVarArgs = new b("Not all required fields were included: Position");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.CNz == null)
        {
          paramVarArgs = new b("Not all required fields were included: DetailInfo");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117846);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pj localpj = (pj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117846);
          return -1;
        case 1: 
          localpj.Title = locala.KhF.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 2: 
          localpj.Url = locala.KhF.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 3: 
          localpj.CNy = locala.KhF.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 4: 
          localpj.CNz = locala.KhF.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 5: 
          localpj.CNA = locala.KhF.xS();
          AppMethodBeat.o(117846);
          return 0;
        case 6: 
          localpj.CNB = locala.KhF.readString();
          AppMethodBeat.o(117846);
          return 0;
        }
        localpj.CNC = locala.KhF.xS();
        AppMethodBeat.o(117846);
        return 0;
      }
      AppMethodBeat.o(117846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pj
 * JD-Core Version:    0.7.0.1
 */
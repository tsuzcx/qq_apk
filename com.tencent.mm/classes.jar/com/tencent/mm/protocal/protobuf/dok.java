package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class dok
  extends com.tencent.mm.bx.a
{
  public String aaVs;
  public String aaVt;
  public String aaVu;
  public int aaVv;
  public int type;
  public String url;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91538);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.type);
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      if (this.aaVs != null) {
        paramVarArgs.g(4, this.aaVs);
      }
      if (this.aaVt != null) {
        paramVarArgs.g(5, this.aaVt);
      }
      if (this.aaVu != null) {
        paramVarArgs.g(6, this.aaVu);
      }
      paramVarArgs.bS(7, this.aaVv);
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.url);
      }
      paramInt = i;
      if (this.aaVs != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaVs);
      }
      i = paramInt;
      if (this.aaVt != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaVt);
      }
      paramInt = i;
      if (this.aaVu != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaVu);
      }
      i = i.a.a.b.b.a.cJ(7, this.aaVv);
      AppMethodBeat.o(91538);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.wording == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dok localdok = (dok)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91538);
        return -1;
      case 1: 
        localdok.type = locala.ajGk.aar();
        AppMethodBeat.o(91538);
        return 0;
      case 2: 
        localdok.wording = locala.ajGk.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 3: 
        localdok.url = locala.ajGk.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 4: 
        localdok.aaVs = locala.ajGk.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 5: 
        localdok.aaVt = locala.ajGk.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 6: 
        localdok.aaVu = locala.ajGk.readString();
        AppMethodBeat.o(91538);
        return 0;
      }
      localdok.aaVv = locala.ajGk.aar();
      AppMethodBeat.o(91538);
      return 0;
    }
    AppMethodBeat.o(91538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dok
 * JD-Core Version:    0.7.0.1
 */
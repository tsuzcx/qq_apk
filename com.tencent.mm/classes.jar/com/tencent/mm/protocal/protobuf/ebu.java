package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebu
  extends com.tencent.mm.bx.a
{
  public String YYZ;
  public int abhr;
  public String abhs;
  public String abht;
  public String appid;
  public String nQG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91579);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      paramVarArgs.bS(2, this.abhr);
      if (this.abhs != null) {
        paramVarArgs.g(3, this.abhs);
      }
      if (this.abht != null) {
        paramVarArgs.g(4, this.abht);
      }
      if (this.YYZ != null) {
        paramVarArgs.g(5, this.YYZ);
      }
      if (this.nQG != null) {
        paramVarArgs.g(6, this.nQG);
      }
      AppMethodBeat.o(91579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = i.a.a.b.b.a.h(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abhr);
      paramInt = i;
      if (this.abhs != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abhs);
      }
      i = paramInt;
      if (this.abht != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abht);
      }
      paramInt = i;
      if (this.YYZ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YYZ);
      }
      i = paramInt;
      if (this.nQG != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.nQG);
      }
      AppMethodBeat.o(91579);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91579);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ebu localebu = (ebu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91579);
          return -1;
        case 1: 
          localebu.appid = locala.ajGk.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 2: 
          localebu.abhr = locala.ajGk.aar();
          AppMethodBeat.o(91579);
          return 0;
        case 3: 
          localebu.abhs = locala.ajGk.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 4: 
          localebu.abht = locala.ajGk.readString();
          AppMethodBeat.o(91579);
          return 0;
        case 5: 
          localebu.YYZ = locala.ajGk.readString();
          AppMethodBeat.o(91579);
          return 0;
        }
        localebu.nQG = locala.ajGk.readString();
        AppMethodBeat.o(91579);
        return 0;
      }
      AppMethodBeat.o(91579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebu
 * JD-Core Version:    0.7.0.1
 */
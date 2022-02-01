package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class glv
  extends com.tencent.mm.bx.a
{
  public String aaBZ;
  public String aaCa;
  public String achm;
  public String hOQ;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123707);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.achm != null) {
        paramVarArgs.g(1, this.achm);
      }
      paramVarArgs.bS(2, this.version);
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      if (this.hOQ != null) {
        paramVarArgs.g(4, this.hOQ);
      }
      if (this.aaBZ != null) {
        paramVarArgs.g(5, this.aaBZ);
      }
      if (this.aaCa != null) {
        paramVarArgs.g(6, this.aaCa);
      }
      AppMethodBeat.o(123707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.achm == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = i.a.a.b.b.a.h(1, this.achm) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.url);
      }
      i = paramInt;
      if (this.hOQ != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.hOQ);
      }
      paramInt = i;
      if (this.aaBZ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaBZ);
      }
      i = paramInt;
      if (this.aaCa != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aaCa);
      }
      AppMethodBeat.o(123707);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123707);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        glv localglv = (glv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123707);
          return -1;
        case 1: 
          localglv.achm = locala.ajGk.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 2: 
          localglv.version = locala.ajGk.aar();
          AppMethodBeat.o(123707);
          return 0;
        case 3: 
          localglv.url = locala.ajGk.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 4: 
          localglv.hOQ = locala.ajGk.readString();
          AppMethodBeat.o(123707);
          return 0;
        case 5: 
          localglv.aaBZ = locala.ajGk.readString();
          AppMethodBeat.o(123707);
          return 0;
        }
        localglv.aaCa = locala.ajGk.readString();
        AppMethodBeat.o(123707);
        return 0;
      }
      AppMethodBeat.o(123707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.glv
 * JD-Core Version:    0.7.0.1
 */
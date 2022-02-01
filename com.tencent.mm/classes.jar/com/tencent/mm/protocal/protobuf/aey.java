package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aey
  extends com.tencent.mm.bx.a
{
  public String VcU;
  public String ZmZ;
  public String Zna;
  public int Znb;
  public int jump_type;
  public String jump_url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260079);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZmZ != null) {
        paramVarArgs.g(1, this.ZmZ);
      }
      if (this.Zna != null) {
        paramVarArgs.g(2, this.Zna);
      }
      paramVarArgs.bS(3, this.jump_type);
      if (this.jump_url != null) {
        paramVarArgs.g(4, this.jump_url);
      }
      if (this.VcU != null) {
        paramVarArgs.g(5, this.VcU);
      }
      paramVarArgs.bS(6, this.Znb);
      AppMethodBeat.o(260079);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZmZ == null) {
        break label482;
      }
    }
    label482:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZmZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zna != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Zna);
      }
      i += i.a.a.b.b.a.cJ(3, this.jump_type);
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.jump_url);
      }
      i = paramInt;
      if (this.VcU != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.VcU);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.Znb);
      AppMethodBeat.o(260079);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260079);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aey localaey = (aey)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260079);
          return -1;
        case 1: 
          localaey.ZmZ = locala.ajGk.readString();
          AppMethodBeat.o(260079);
          return 0;
        case 2: 
          localaey.Zna = locala.ajGk.readString();
          AppMethodBeat.o(260079);
          return 0;
        case 3: 
          localaey.jump_type = locala.ajGk.aar();
          AppMethodBeat.o(260079);
          return 0;
        case 4: 
          localaey.jump_url = locala.ajGk.readString();
          AppMethodBeat.o(260079);
          return 0;
        case 5: 
          localaey.VcU = locala.ajGk.readString();
          AppMethodBeat.o(260079);
          return 0;
        }
        localaey.Znb = locala.ajGk.aar();
        AppMethodBeat.o(260079);
        return 0;
      }
      AppMethodBeat.o(260079);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aey
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxl
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IHo;
  public String aaCS;
  public String aaCT;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152610);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaCS != null) {
        paramVarArgs.g(1, this.aaCS);
      }
      if (this.IHo != null) {
        paramVarArgs.g(2, this.IHo);
      }
      if (this.hAP != null) {
        paramVarArgs.g(3, this.hAP);
      }
      if (this.IGG != null) {
        paramVarArgs.g(4, this.IGG);
      }
      if (this.aaCT != null) {
        paramVarArgs.g(5, this.aaCT);
      }
      AppMethodBeat.o(152610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaCS == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.aaCS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IHo);
      }
      i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hAP);
      }
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGG);
      }
      i = paramInt;
      if (this.aaCT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaCT);
      }
      AppMethodBeat.o(152610);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152610);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cxl localcxl = (cxl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152610);
          return -1;
        case 1: 
          localcxl.aaCS = locala.ajGk.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 2: 
          localcxl.IHo = locala.ajGk.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 3: 
          localcxl.hAP = locala.ajGk.readString();
          AppMethodBeat.o(152610);
          return 0;
        case 4: 
          localcxl.IGG = locala.ajGk.readString();
          AppMethodBeat.o(152610);
          return 0;
        }
        localcxl.aaCT = locala.ajGk.readString();
        AppMethodBeat.o(152610);
        return 0;
      }
      AppMethodBeat.o(152610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxl
 * JD-Core Version:    0.7.0.1
 */
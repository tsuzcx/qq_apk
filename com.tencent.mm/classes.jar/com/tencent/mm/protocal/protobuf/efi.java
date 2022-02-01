package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efi
  extends com.tencent.mm.bx.a
{
  public String VcU;
  public String VcV;
  public String VmH;
  public String VsH;
  public String abkC;
  public int type;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91620);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      paramVarArgs.bS(2, this.type);
      if (this.VsH != null) {
        paramVarArgs.g(3, this.VsH);
      }
      if (this.VcU != null) {
        paramVarArgs.g(4, this.VcU);
      }
      if (this.VcV != null) {
        paramVarArgs.g(5, this.VcV);
      }
      if (this.abkC != null) {
        paramVarArgs.g(6, this.abkC);
      }
      if (this.VmH != null) {
        paramVarArgs.g(7, this.VmH);
      }
      AppMethodBeat.o(91620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = i.a.a.b.b.a.h(1, this.wording) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.VsH != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.VsH);
      }
      i = paramInt;
      if (this.VcU != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.VcU);
      }
      paramInt = i;
      if (this.VcV != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.VcV);
      }
      i = paramInt;
      if (this.abkC != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abkC);
      }
      paramInt = i;
      if (this.VmH != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.VmH);
      }
      AppMethodBeat.o(91620);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91620);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        efi localefi = (efi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91620);
          return -1;
        case 1: 
          localefi.wording = locala.ajGk.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 2: 
          localefi.type = locala.ajGk.aar();
          AppMethodBeat.o(91620);
          return 0;
        case 3: 
          localefi.VsH = locala.ajGk.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 4: 
          localefi.VcU = locala.ajGk.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 5: 
          localefi.VcV = locala.ajGk.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 6: 
          localefi.abkC = locala.ajGk.readString();
          AppMethodBeat.o(91620);
          return 0;
        }
        localefi.VmH = locala.ajGk.readString();
        AppMethodBeat.o(91620);
        return 0;
      }
      AppMethodBeat.o(91620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efi
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cph
  extends com.tencent.mm.bx.a
{
  public String CxM;
  public String EiV;
  public String hNH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152690);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: tp_username");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.EiV == null)
      {
        paramVarArgs = new b("Not all required fields were included: verify_content");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.CxM == null)
      {
        paramVarArgs = new b("Not all required fields were included: antispam_ticket");
        AppMethodBeat.o(152690);
        throw paramVarArgs;
      }
      if (this.hNH != null) {
        paramVarArgs.d(1, this.hNH);
      }
      if (this.EiV != null) {
        paramVarArgs.d(2, this.EiV);
      }
      if (this.CxM != null) {
        paramVarArgs.d(3, this.CxM);
      }
      AppMethodBeat.o(152690);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hNH == null) {
        break label478;
      }
    }
    label478:
    for (int i = f.a.a.b.b.a.e(1, this.hNH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EiV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EiV);
      }
      i = paramInt;
      if (this.CxM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CxM);
      }
      AppMethodBeat.o(152690);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.hNH == null)
        {
          paramVarArgs = new b("Not all required fields were included: tp_username");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.EiV == null)
        {
          paramVarArgs = new b("Not all required fields were included: verify_content");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        if (this.CxM == null)
        {
          paramVarArgs = new b("Not all required fields were included: antispam_ticket");
          AppMethodBeat.o(152690);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152690);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cph localcph = (cph)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152690);
          return -1;
        case 1: 
          localcph.hNH = locala.KhF.readString();
          AppMethodBeat.o(152690);
          return 0;
        case 2: 
          localcph.EiV = locala.KhF.readString();
          AppMethodBeat.o(152690);
          return 0;
        }
        localcph.CxM = locala.KhF.readString();
        AppMethodBeat.o(152690);
        return 0;
      }
      AppMethodBeat.o(152690);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cph
 * JD-Core Version:    0.7.0.1
 */
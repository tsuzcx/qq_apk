package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class dsr
  extends com.tencent.mm.bx.a
{
  public boolean EHf;
  public boolean EHg;
  public boolean EHh;
  public String dnC;
  public long hAg;
  public String neS;
  public String nha;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(193019);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(193019);
        throw paramVarArgs;
      }
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      paramVarArgs.aG(2, this.hAg);
      paramVarArgs.bg(3, this.EHf);
      paramVarArgs.bg(4, this.EHg);
      if (this.neS != null) {
        paramVarArgs.d(5, this.neS);
      }
      if (this.nha != null) {
        paramVarArgs.d(6, this.nha);
      }
      if (this.dnC != null) {
        paramVarArgs.d(7, this.dnC);
      }
      paramVarArgs.bg(8, this.EHh);
      AppMethodBeat.o(193019);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.hAg) + (f.a.a.b.b.a.fY(3) + 1) + (f.a.a.b.b.a.fY(4) + 1);
      paramInt = i;
      if (this.neS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.neS);
      }
      i = paramInt;
      if (this.nha != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.nha);
      }
      paramInt = i;
      if (this.dnC != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dnC);
      }
      i = f.a.a.b.b.a.fY(8);
      AppMethodBeat.o(193019);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(193019);
          throw paramVarArgs;
        }
        AppMethodBeat.o(193019);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dsr localdsr = (dsr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(193019);
          return -1;
        case 1: 
          localdsr.url = locala.KhF.readString();
          AppMethodBeat.o(193019);
          return 0;
        case 2: 
          localdsr.hAg = locala.KhF.xT();
          AppMethodBeat.o(193019);
          return 0;
        case 3: 
          localdsr.EHf = locala.KhF.fHu();
          AppMethodBeat.o(193019);
          return 0;
        case 4: 
          localdsr.EHg = locala.KhF.fHu();
          AppMethodBeat.o(193019);
          return 0;
        case 5: 
          localdsr.neS = locala.KhF.readString();
          AppMethodBeat.o(193019);
          return 0;
        case 6: 
          localdsr.nha = locala.KhF.readString();
          AppMethodBeat.o(193019);
          return 0;
        case 7: 
          localdsr.dnC = locala.KhF.readString();
          AppMethodBeat.o(193019);
          return 0;
        }
        localdsr.EHh = locala.KhF.fHu();
        AppMethodBeat.o(193019);
        return 0;
      }
      AppMethodBeat.o(193019);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsr
 * JD-Core Version:    0.7.0.1
 */
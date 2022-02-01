package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edt
  extends com.tencent.mm.bw.a
{
  public String FSh;
  public String IiF;
  public String IiG;
  public String IiH;
  public String gvo;
  public String gvp;
  public String gvq;
  public String gvr;
  public String nIN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116822);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FSh != null) {
        paramVarArgs.d(1, this.FSh);
      }
      if (this.gvp != null) {
        paramVarArgs.d(2, this.gvp);
      }
      if (this.gvo != null) {
        paramVarArgs.d(3, this.gvo);
      }
      if (this.nIN != null) {
        paramVarArgs.d(4, this.nIN);
      }
      if (this.IiF != null) {
        paramVarArgs.d(5, this.IiF);
      }
      if (this.gvq != null) {
        paramVarArgs.d(6, this.gvq);
      }
      if (this.gvr != null) {
        paramVarArgs.d(7, this.gvr);
      }
      if (this.IiG != null) {
        paramVarArgs.d(8, this.IiG);
      }
      if (this.IiH != null) {
        paramVarArgs.d(9, this.IiH);
      }
      AppMethodBeat.o(116822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FSh == null) {
        break label702;
      }
    }
    label702:
    for (int i = f.a.a.b.b.a.e(1, this.FSh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gvp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gvp);
      }
      i = paramInt;
      if (this.gvo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gvo);
      }
      paramInt = i;
      if (this.nIN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nIN);
      }
      i = paramInt;
      if (this.IiF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.IiF);
      }
      paramInt = i;
      if (this.gvq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.gvq);
      }
      i = paramInt;
      if (this.gvr != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.gvr);
      }
      paramInt = i;
      if (this.IiG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.IiG);
      }
      i = paramInt;
      if (this.IiH != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.IiH);
      }
      AppMethodBeat.o(116822);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116822);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edt localedt = (edt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116822);
          return -1;
        case 1: 
          localedt.FSh = locala.OmT.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 2: 
          localedt.gvp = locala.OmT.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 3: 
          localedt.gvo = locala.OmT.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 4: 
          localedt.nIN = locala.OmT.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 5: 
          localedt.IiF = locala.OmT.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 6: 
          localedt.gvq = locala.OmT.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 7: 
          localedt.gvr = locala.OmT.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 8: 
          localedt.IiG = locala.OmT.readString();
          AppMethodBeat.o(116822);
          return 0;
        }
        localedt.IiH = locala.OmT.readString();
        AppMethodBeat.o(116822);
        return 0;
      }
      AppMethodBeat.o(116822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edt
 * JD-Core Version:    0.7.0.1
 */
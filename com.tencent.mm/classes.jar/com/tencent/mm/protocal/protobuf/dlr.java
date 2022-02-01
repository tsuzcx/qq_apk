package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlr
  extends com.tencent.mm.bw.a
{
  public int MPl;
  public String iwl;
  public String iwm;
  public String iwn;
  public String iwo;
  public String iwp;
  public String iwq;
  public String iwr;
  public String iws;
  public String iwt;
  public String iwu;
  public String iwv;
  public String iww;
  public boolean iwx;
  public int iwy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169219);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.iwl != null) {
        paramVarArgs.e(1, this.iwl);
      }
      if (this.iwm != null) {
        paramVarArgs.e(2, this.iwm);
      }
      if (this.iwn != null) {
        paramVarArgs.e(3, this.iwn);
      }
      if (this.iwo != null) {
        paramVarArgs.e(4, this.iwo);
      }
      if (this.iwp != null) {
        paramVarArgs.e(5, this.iwp);
      }
      if (this.iwq != null) {
        paramVarArgs.e(6, this.iwq);
      }
      if (this.iwr != null) {
        paramVarArgs.e(7, this.iwr);
      }
      if (this.iws != null) {
        paramVarArgs.e(8, this.iws);
      }
      if (this.iwt != null) {
        paramVarArgs.e(9, this.iwt);
      }
      if (this.iwu != null) {
        paramVarArgs.e(10, this.iwu);
      }
      paramVarArgs.aM(11, this.MPl);
      if (this.iwv != null) {
        paramVarArgs.e(12, this.iwv);
      }
      if (this.iww != null) {
        paramVarArgs.e(13, this.iww);
      }
      paramVarArgs.cc(14, this.iwx);
      paramVarArgs.aM(15, this.iwy);
      AppMethodBeat.o(169219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iwl == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = g.a.a.b.b.a.f(1, this.iwl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iwm != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.iwm);
      }
      i = paramInt;
      if (this.iwn != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.iwn);
      }
      paramInt = i;
      if (this.iwo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.iwo);
      }
      i = paramInt;
      if (this.iwp != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.iwp);
      }
      paramInt = i;
      if (this.iwq != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.iwq);
      }
      i = paramInt;
      if (this.iwr != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.iwr);
      }
      paramInt = i;
      if (this.iws != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.iws);
      }
      i = paramInt;
      if (this.iwt != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.iwt);
      }
      paramInt = i;
      if (this.iwu != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.iwu);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.MPl);
      paramInt = i;
      if (this.iwv != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.iwv);
      }
      i = paramInt;
      if (this.iww != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.iww);
      }
      paramInt = g.a.a.b.b.a.fS(14);
      int j = g.a.a.b.b.a.bu(15, this.iwy);
      AppMethodBeat.o(169219);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169219);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dlr localdlr = (dlr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169219);
          return -1;
        case 1: 
          localdlr.iwl = locala.UbS.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 2: 
          localdlr.iwm = locala.UbS.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 3: 
          localdlr.iwn = locala.UbS.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 4: 
          localdlr.iwo = locala.UbS.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 5: 
          localdlr.iwp = locala.UbS.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 6: 
          localdlr.iwq = locala.UbS.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 7: 
          localdlr.iwr = locala.UbS.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 8: 
          localdlr.iws = locala.UbS.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 9: 
          localdlr.iwt = locala.UbS.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 10: 
          localdlr.iwu = locala.UbS.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 11: 
          localdlr.MPl = locala.UbS.zi();
          AppMethodBeat.o(169219);
          return 0;
        case 12: 
          localdlr.iwv = locala.UbS.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 13: 
          localdlr.iww = locala.UbS.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 14: 
          localdlr.iwx = locala.UbS.yZ();
          AppMethodBeat.o(169219);
          return 0;
        }
        localdlr.iwy = locala.UbS.zi();
        AppMethodBeat.o(169219);
        return 0;
      }
      AppMethodBeat.o(169219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlr
 * JD-Core Version:    0.7.0.1
 */
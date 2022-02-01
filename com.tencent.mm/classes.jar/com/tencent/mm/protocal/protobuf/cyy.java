package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cyy
  extends com.tencent.mm.bw.a
{
  public int FileSize;
  public int KKA;
  public String MEb;
  public int MEc;
  public String MEd;
  public String MEe;
  public String MEf;
  public String MEg;
  public String MEh;
  public int MEi;
  public String MEj;
  public int Scene;
  public String keb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(223891);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MEb == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileMD5");
        AppMethodBeat.o(223891);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Scene);
      paramVarArgs.aM(2, this.KKA);
      paramVarArgs.aM(3, this.FileSize);
      if (this.MEb != null) {
        paramVarArgs.e(4, this.MEb);
      }
      paramVarArgs.aM(5, this.MEc);
      if (this.MEd != null) {
        paramVarArgs.e(6, this.MEd);
      }
      if (this.MEe != null) {
        paramVarArgs.e(7, this.MEe);
      }
      if (this.MEf != null) {
        paramVarArgs.e(8, this.MEf);
      }
      if (this.MEg != null) {
        paramVarArgs.e(10, this.MEg);
      }
      if (this.MEh != null) {
        paramVarArgs.e(11, this.MEh);
      }
      paramVarArgs.aM(12, this.MEi);
      if (this.keb != null) {
        paramVarArgs.e(13, this.keb);
      }
      if (this.MEj != null) {
        paramVarArgs.e(14, this.MEj);
      }
      AppMethodBeat.o(223891);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Scene) + 0 + g.a.a.b.b.a.bu(2, this.KKA) + g.a.a.b.b.a.bu(3, this.FileSize);
      paramInt = i;
      if (this.MEb != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MEb);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MEc);
      paramInt = i;
      if (this.MEd != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MEd);
      }
      i = paramInt;
      if (this.MEe != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MEe);
      }
      paramInt = i;
      if (this.MEf != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MEf);
      }
      i = paramInt;
      if (this.MEg != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.MEg);
      }
      paramInt = i;
      if (this.MEh != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MEh);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.MEi);
      paramInt = i;
      if (this.keb != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.keb);
      }
      i = paramInt;
      if (this.MEj != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.MEj);
      }
      AppMethodBeat.o(223891);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.MEb == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileMD5");
        AppMethodBeat.o(223891);
        throw paramVarArgs;
      }
      AppMethodBeat.o(223891);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cyy localcyy = (cyy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 9: 
      default: 
        AppMethodBeat.o(223891);
        return -1;
      case 1: 
        localcyy.Scene = locala.UbS.zi();
        AppMethodBeat.o(223891);
        return 0;
      case 2: 
        localcyy.KKA = locala.UbS.zi();
        AppMethodBeat.o(223891);
        return 0;
      case 3: 
        localcyy.FileSize = locala.UbS.zi();
        AppMethodBeat.o(223891);
        return 0;
      case 4: 
        localcyy.MEb = locala.UbS.readString();
        AppMethodBeat.o(223891);
        return 0;
      case 5: 
        localcyy.MEc = locala.UbS.zi();
        AppMethodBeat.o(223891);
        return 0;
      case 6: 
        localcyy.MEd = locala.UbS.readString();
        AppMethodBeat.o(223891);
        return 0;
      case 7: 
        localcyy.MEe = locala.UbS.readString();
        AppMethodBeat.o(223891);
        return 0;
      case 8: 
        localcyy.MEf = locala.UbS.readString();
        AppMethodBeat.o(223891);
        return 0;
      case 10: 
        localcyy.MEg = locala.UbS.readString();
        AppMethodBeat.o(223891);
        return 0;
      case 11: 
        localcyy.MEh = locala.UbS.readString();
        AppMethodBeat.o(223891);
        return 0;
      case 12: 
        localcyy.MEi = locala.UbS.zi();
        AppMethodBeat.o(223891);
        return 0;
      case 13: 
        localcyy.keb = locala.UbS.readString();
        AppMethodBeat.o(223891);
        return 0;
      }
      localcyy.MEj = locala.UbS.readString();
      AppMethodBeat.o(223891);
      return 0;
    }
    AppMethodBeat.o(223891);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyy
 * JD-Core Version:    0.7.0.1
 */
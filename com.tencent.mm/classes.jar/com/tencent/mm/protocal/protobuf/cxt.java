package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxt
  extends com.tencent.mm.cd.a
{
  public String SjI;
  public String SjJ;
  public int TGb;
  public int TGc;
  public String UserName;
  public String mVA;
  public String mVB;
  public String mVH;
  public int mVy;
  public String mVz;
  public int rWu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32348);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      paramVarArgs.aY(2, this.rWu);
      paramVarArgs.aY(3, this.mVy);
      if (this.mVA != null) {
        paramVarArgs.f(4, this.mVA);
      }
      if (this.mVz != null) {
        paramVarArgs.f(5, this.mVz);
      }
      if (this.mVB != null) {
        paramVarArgs.f(6, this.mVB);
      }
      paramVarArgs.aY(7, this.TGb);
      paramVarArgs.aY(8, this.TGc);
      if (this.mVH != null) {
        paramVarArgs.f(9, this.mVH);
      }
      if (this.SjI != null) {
        paramVarArgs.f(10, this.SjI);
      }
      if (this.SjJ != null) {
        paramVarArgs.f(11, this.SjJ);
      }
      AppMethodBeat.o(32348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = g.a.a.b.b.a.g(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWu) + g.a.a.b.b.a.bM(3, this.mVy);
      paramInt = i;
      if (this.mVA != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.mVA);
      }
      i = paramInt;
      if (this.mVz != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.mVz);
      }
      paramInt = i;
      if (this.mVB != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.mVB);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.TGb) + g.a.a.b.b.a.bM(8, this.TGc);
      paramInt = i;
      if (this.mVH != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.mVH);
      }
      i = paramInt;
      if (this.SjI != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.SjI);
      }
      paramInt = i;
      if (this.SjJ != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.SjJ);
      }
      AppMethodBeat.o(32348);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32348);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cxt localcxt = (cxt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32348);
          return -1;
        case 1: 
          localcxt.UserName = locala.abFh.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 2: 
          localcxt.rWu = locala.abFh.AK();
          AppMethodBeat.o(32348);
          return 0;
        case 3: 
          localcxt.mVy = locala.abFh.AK();
          AppMethodBeat.o(32348);
          return 0;
        case 4: 
          localcxt.mVA = locala.abFh.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 5: 
          localcxt.mVz = locala.abFh.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 6: 
          localcxt.mVB = locala.abFh.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 7: 
          localcxt.TGb = locala.abFh.AK();
          AppMethodBeat.o(32348);
          return 0;
        case 8: 
          localcxt.TGc = locala.abFh.AK();
          AppMethodBeat.o(32348);
          return 0;
        case 9: 
          localcxt.mVH = locala.abFh.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 10: 
          localcxt.SjI = locala.abFh.readString();
          AppMethodBeat.o(32348);
          return 0;
        }
        localcxt.SjJ = locala.abFh.readString();
        AppMethodBeat.o(32348);
        return 0;
      }
      AppMethodBeat.o(32348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxt
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bky
  extends com.tencent.mm.bv.a
{
  public String cDz;
  public String cyA;
  public String title;
  public String type;
  public String uiP;
  public String ukg;
  public long uks;
  public long ukt;
  public long uku;
  public int ukv;
  public int ukw;
  public long ukx;
  public String urC;
  public String url;
  public String xzB;
  public String xzC;
  public String xzD;
  public int xzE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56883);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      if (this.cyA != null) {
        paramVarArgs.e(2, this.cyA);
      }
      if (this.cDz != null) {
        paramVarArgs.e(3, this.cDz);
      }
      if (this.urC != null) {
        paramVarArgs.e(4, this.urC);
      }
      if (this.ukg != null) {
        paramVarArgs.e(5, this.ukg);
      }
      if (this.xzB != null) {
        paramVarArgs.e(6, this.xzB);
      }
      if (this.type != null) {
        paramVarArgs.e(7, this.type);
      }
      if (this.title != null) {
        paramVarArgs.e(8, this.title);
      }
      paramVarArgs.am(9, this.uks);
      paramVarArgs.am(10, this.ukt);
      if (this.uiP != null) {
        paramVarArgs.e(11, this.uiP);
      }
      paramVarArgs.am(12, this.uku);
      paramVarArgs.aO(13, this.ukv);
      paramVarArgs.aO(14, this.ukw);
      if (this.xzC != null) {
        paramVarArgs.e(15, this.xzC);
      }
      if (this.xzD != null) {
        paramVarArgs.e(16, this.xzD);
      }
      paramVarArgs.am(17, this.ukx);
      paramVarArgs.aO(18, this.xzE);
      AppMethodBeat.o(56883);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1146;
      }
    }
    label1146:
    for (int i = e.a.a.b.b.a.f(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cyA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.cyA);
      }
      i = paramInt;
      if (this.cDz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cDz);
      }
      paramInt = i;
      if (this.urC != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.urC);
      }
      i = paramInt;
      if (this.ukg != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.ukg);
      }
      paramInt = i;
      if (this.xzB != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xzB);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.type);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.title);
      }
      i = paramInt + e.a.a.b.b.a.p(9, this.uks) + e.a.a.b.b.a.p(10, this.ukt);
      paramInt = i;
      if (this.uiP != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.uiP);
      }
      i = paramInt + e.a.a.b.b.a.p(12, this.uku) + e.a.a.b.b.a.bl(13, this.ukv) + e.a.a.b.b.a.bl(14, this.ukw);
      paramInt = i;
      if (this.xzC != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.xzC);
      }
      i = paramInt;
      if (this.xzD != null) {
        i = paramInt + e.a.a.b.b.a.f(16, this.xzD);
      }
      paramInt = e.a.a.b.b.a.p(17, this.ukx);
      int j = e.a.a.b.b.a.bl(18, this.xzE);
      AppMethodBeat.o(56883);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56883);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bky localbky = (bky)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56883);
          return -1;
        case 1: 
          localbky.url = locala.CLY.readString();
          AppMethodBeat.o(56883);
          return 0;
        case 2: 
          localbky.cyA = locala.CLY.readString();
          AppMethodBeat.o(56883);
          return 0;
        case 3: 
          localbky.cDz = locala.CLY.readString();
          AppMethodBeat.o(56883);
          return 0;
        case 4: 
          localbky.urC = locala.CLY.readString();
          AppMethodBeat.o(56883);
          return 0;
        case 5: 
          localbky.ukg = locala.CLY.readString();
          AppMethodBeat.o(56883);
          return 0;
        case 6: 
          localbky.xzB = locala.CLY.readString();
          AppMethodBeat.o(56883);
          return 0;
        case 7: 
          localbky.type = locala.CLY.readString();
          AppMethodBeat.o(56883);
          return 0;
        case 8: 
          localbky.title = locala.CLY.readString();
          AppMethodBeat.o(56883);
          return 0;
        case 9: 
          localbky.uks = locala.CLY.sm();
          AppMethodBeat.o(56883);
          return 0;
        case 10: 
          localbky.ukt = locala.CLY.sm();
          AppMethodBeat.o(56883);
          return 0;
        case 11: 
          localbky.uiP = locala.CLY.readString();
          AppMethodBeat.o(56883);
          return 0;
        case 12: 
          localbky.uku = locala.CLY.sm();
          AppMethodBeat.o(56883);
          return 0;
        case 13: 
          localbky.ukv = locala.CLY.sl();
          AppMethodBeat.o(56883);
          return 0;
        case 14: 
          localbky.ukw = locala.CLY.sl();
          AppMethodBeat.o(56883);
          return 0;
        case 15: 
          localbky.xzC = locala.CLY.readString();
          AppMethodBeat.o(56883);
          return 0;
        case 16: 
          localbky.xzD = locala.CLY.readString();
          AppMethodBeat.o(56883);
          return 0;
        case 17: 
          localbky.ukx = locala.CLY.sm();
          AppMethodBeat.o(56883);
          return 0;
        }
        localbky.xzE = locala.CLY.sl();
        AppMethodBeat.o(56883);
        return 0;
      }
      AppMethodBeat.o(56883);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bky
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvr
  extends com.tencent.mm.bw.a
{
  public String FhW;
  public String FrN;
  public String Gdb;
  public String Gdc;
  public String Gdd;
  public String Gde;
  public String Gdf;
  public int Scene;
  public int iIM;
  public String vyt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121110);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gdb != null) {
        paramVarArgs.d(1, this.Gdb);
      }
      if (this.Gdc != null) {
        paramVarArgs.d(2, this.Gdc);
      }
      if (this.FhW != null) {
        paramVarArgs.d(3, this.FhW);
      }
      if (this.FrN != null) {
        paramVarArgs.d(4, this.FrN);
      }
      paramVarArgs.aR(5, this.iIM);
      if (this.vyt != null) {
        paramVarArgs.d(6, this.vyt);
      }
      if (this.Gdd != null) {
        paramVarArgs.d(7, this.Gdd);
      }
      if (this.Gde != null) {
        paramVarArgs.d(8, this.Gde);
      }
      paramVarArgs.aR(9, this.Scene);
      if (this.Gdf != null) {
        paramVarArgs.d(19, this.Gdf);
      }
      AppMethodBeat.o(121110);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gdb == null) {
        break label770;
      }
    }
    label770:
    for (int i = f.a.a.b.b.a.e(1, this.Gdb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gdc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gdc);
      }
      i = paramInt;
      if (this.FhW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FhW);
      }
      paramInt = i;
      if (this.FrN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FrN);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.iIM);
      paramInt = i;
      if (this.vyt != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.vyt);
      }
      i = paramInt;
      if (this.Gdd != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gdd);
      }
      paramInt = i;
      if (this.Gde != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gde);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.Scene);
      paramInt = i;
      if (this.Gdf != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.Gdf);
      }
      AppMethodBeat.o(121110);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(121110);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvr localdvr = (dvr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(121110);
          return -1;
        case 1: 
          localdvr.Gdb = locala.LVo.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 2: 
          localdvr.Gdc = locala.LVo.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 3: 
          localdvr.FhW = locala.LVo.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 4: 
          localdvr.FrN = locala.LVo.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 5: 
          localdvr.iIM = locala.LVo.xF();
          AppMethodBeat.o(121110);
          return 0;
        case 6: 
          localdvr.vyt = locala.LVo.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 7: 
          localdvr.Gdd = locala.LVo.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 8: 
          localdvr.Gde = locala.LVo.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 9: 
          localdvr.Scene = locala.LVo.xF();
          AppMethodBeat.o(121110);
          return 0;
        }
        localdvr.Gdf = locala.LVo.readString();
        AppMethodBeat.o(121110);
        return 0;
      }
      AppMethodBeat.o(121110);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvr
 * JD-Core Version:    0.7.0.1
 */
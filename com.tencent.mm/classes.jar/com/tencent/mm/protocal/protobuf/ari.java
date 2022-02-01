package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ari
  extends com.tencent.mm.bw.a
{
  public int EKk;
  public int EKs;
  public String EKt;
  public String EKu;
  public String EKv;
  public String EKw;
  public int Scene;
  public String hOf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EKs);
      if (this.EKt != null) {
        paramVarArgs.d(2, this.EKt);
      }
      if (this.hOf != null) {
        paramVarArgs.d(3, this.hOf);
      }
      if (this.EKu != null) {
        paramVarArgs.d(4, this.EKu);
      }
      if (this.EKv != null) {
        paramVarArgs.d(5, this.EKv);
      }
      if (this.EKw != null) {
        paramVarArgs.d(7, this.EKw);
      }
      paramVarArgs.aR(8, this.EKk);
      paramVarArgs.aR(9, this.Scene);
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.EKs) + 0;
      paramInt = i;
      if (this.EKt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EKt);
      }
      i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hOf);
      }
      paramInt = i;
      if (this.EKu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EKu);
      }
      i = paramInt;
      if (this.EKv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EKv);
      }
      paramInt = i;
      if (this.EKw != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EKw);
      }
      i = f.a.a.b.b.a.bx(8, this.EKk);
      int j = f.a.a.b.b.a.bx(9, this.Scene);
      AppMethodBeat.o(152546);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ari localari = (ari)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(152546);
        return -1;
      case 1: 
        localari.EKs = locala.LVo.xF();
        AppMethodBeat.o(152546);
        return 0;
      case 2: 
        localari.EKt = locala.LVo.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 3: 
        localari.hOf = locala.LVo.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 4: 
        localari.EKu = locala.LVo.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 5: 
        localari.EKv = locala.LVo.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 7: 
        localari.EKw = locala.LVo.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 8: 
        localari.EKk = locala.LVo.xF();
        AppMethodBeat.o(152546);
        return 0;
      }
      localari.Scene = locala.LVo.xF();
      AppMethodBeat.o(152546);
      return 0;
    }
    AppMethodBeat.o(152546);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ari
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class py
  extends com.tencent.mm.bw.a
{
  public String BGR;
  public String Bxu;
  public int DOv;
  public String EgC;
  public String EgD;
  public String drM;
  public String title;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91383);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.BGR != null) {
        paramVarArgs.d(2, this.BGR);
      }
      if (this.drM != null) {
        paramVarArgs.d(3, this.drM);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.Bxu != null) {
        paramVarArgs.d(5, this.Bxu);
      }
      if (this.url != null) {
        paramVarArgs.d(6, this.url);
      }
      if (this.EgC != null) {
        paramVarArgs.d(7, this.EgC);
      }
      if (this.EgD != null) {
        paramVarArgs.d(8, this.EgD);
      }
      paramVarArgs.aR(9, this.DOv);
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.type) + 0;
      paramInt = i;
      if (this.BGR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.BGR);
      }
      i = paramInt;
      if (this.drM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.drM);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt;
      if (this.Bxu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Bxu);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.url);
      }
      i = paramInt;
      if (this.EgC != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EgC);
      }
      paramInt = i;
      if (this.EgD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EgD);
      }
      i = f.a.a.b.b.a.bx(9, this.DOv);
      AppMethodBeat.o(91383);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      py localpy = (py)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91383);
        return -1;
      case 1: 
        localpy.type = locala.LVo.xF();
        AppMethodBeat.o(91383);
        return 0;
      case 2: 
        localpy.BGR = locala.LVo.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 3: 
        localpy.drM = locala.LVo.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 4: 
        localpy.title = locala.LVo.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 5: 
        localpy.Bxu = locala.LVo.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 6: 
        localpy.url = locala.LVo.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 7: 
        localpy.EgC = locala.LVo.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 8: 
        localpy.EgD = locala.LVo.readString();
        AppMethodBeat.o(91383);
        return 0;
      }
      localpy.DOv = locala.LVo.xF();
      AppMethodBeat.o(91383);
      return 0;
    }
    AppMethodBeat.o(91383);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.py
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dii
  extends com.tencent.mm.bw.a
{
  public int BYF;
  public int BZA;
  public int BZB;
  public int BZz;
  public long FRm;
  public int FRn;
  public long FRo;
  public String drM;
  public String dtG;
  public int exP;
  public String extInfo;
  public int hTM;
  public long hVx;
  public String text;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153002);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dtG != null) {
        paramVarArgs.d(1, this.dtG);
      }
      paramVarArgs.aR(2, this.BZz);
      paramVarArgs.aR(3, this.BZA);
      paramVarArgs.aO(4, this.hVx);
      paramVarArgs.aR(5, this.BYF);
      paramVarArgs.aR(6, this.type);
      if (this.text != null) {
        paramVarArgs.d(7, this.text);
      }
      if (this.drM != null) {
        paramVarArgs.d(8, this.drM);
      }
      paramVarArgs.aO(9, this.FRm);
      paramVarArgs.aR(10, this.BZB);
      paramVarArgs.aR(11, this.FRn);
      paramVarArgs.aO(12, this.FRo);
      paramVarArgs.aR(13, this.exP);
      paramVarArgs.aR(14, this.hTM);
      if (this.extInfo != null) {
        paramVarArgs.d(15, this.extInfo);
      }
      AppMethodBeat.o(153002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dtG == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = f.a.a.b.b.a.e(1, this.dtG) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.BZz) + f.a.a.b.b.a.bx(3, this.BZA) + f.a.a.b.b.a.p(4, this.hVx) + f.a.a.b.b.a.bx(5, this.BYF) + f.a.a.b.b.a.bx(6, this.type);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.text);
      }
      i = paramInt;
      if (this.drM != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.drM);
      }
      i = i + f.a.a.b.b.a.p(9, this.FRm) + f.a.a.b.b.a.bx(10, this.BZB) + f.a.a.b.b.a.bx(11, this.FRn) + f.a.a.b.b.a.p(12, this.FRo) + f.a.a.b.b.a.bx(13, this.exP) + f.a.a.b.b.a.bx(14, this.hTM);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.extInfo);
      }
      AppMethodBeat.o(153002);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153002);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dii localdii = (dii)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153002);
          return -1;
        case 1: 
          localdii.dtG = locala.LVo.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 2: 
          localdii.BZz = locala.LVo.xF();
          AppMethodBeat.o(153002);
          return 0;
        case 3: 
          localdii.BZA = locala.LVo.xF();
          AppMethodBeat.o(153002);
          return 0;
        case 4: 
          localdii.hVx = locala.LVo.xG();
          AppMethodBeat.o(153002);
          return 0;
        case 5: 
          localdii.BYF = locala.LVo.xF();
          AppMethodBeat.o(153002);
          return 0;
        case 6: 
          localdii.type = locala.LVo.xF();
          AppMethodBeat.o(153002);
          return 0;
        case 7: 
          localdii.text = locala.LVo.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 8: 
          localdii.drM = locala.LVo.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 9: 
          localdii.FRm = locala.LVo.xG();
          AppMethodBeat.o(153002);
          return 0;
        case 10: 
          localdii.BZB = locala.LVo.xF();
          AppMethodBeat.o(153002);
          return 0;
        case 11: 
          localdii.FRn = locala.LVo.xF();
          AppMethodBeat.o(153002);
          return 0;
        case 12: 
          localdii.FRo = locala.LVo.xG();
          AppMethodBeat.o(153002);
          return 0;
        case 13: 
          localdii.exP = locala.LVo.xF();
          AppMethodBeat.o(153002);
          return 0;
        case 14: 
          localdii.hTM = locala.LVo.xF();
          AppMethodBeat.o(153002);
          return 0;
        }
        localdii.extInfo = locala.LVo.readString();
        AppMethodBeat.o(153002);
        return 0;
      }
      AppMethodBeat.o(153002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dii
 * JD-Core Version:    0.7.0.1
 */
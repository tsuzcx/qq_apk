package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcv
  extends com.tencent.mm.bx.a
{
  public int AGn;
  public int AHi;
  public int AHj;
  public int AHk;
  public long Eul;
  public int Eum;
  public long Eun;
  public String dub;
  public String dvT;
  public int evt;
  public String extInfo;
  public int htk;
  public long huV;
  public String text;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153002);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvT != null) {
        paramVarArgs.d(1, this.dvT);
      }
      paramVarArgs.aR(2, this.AHi);
      paramVarArgs.aR(3, this.AHj);
      paramVarArgs.aG(4, this.huV);
      paramVarArgs.aR(5, this.AGn);
      paramVarArgs.aR(6, this.type);
      if (this.text != null) {
        paramVarArgs.d(7, this.text);
      }
      if (this.dub != null) {
        paramVarArgs.d(8, this.dub);
      }
      paramVarArgs.aG(9, this.Eul);
      paramVarArgs.aR(10, this.AHk);
      paramVarArgs.aR(11, this.Eum);
      paramVarArgs.aG(12, this.Eun);
      paramVarArgs.aR(13, this.evt);
      paramVarArgs.aR(14, this.htk);
      if (this.extInfo != null) {
        paramVarArgs.d(15, this.extInfo);
      }
      AppMethodBeat.o(153002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dvT == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = f.a.a.b.b.a.e(1, this.dvT) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.AHi) + f.a.a.b.b.a.bA(3, this.AHj) + f.a.a.b.b.a.q(4, this.huV) + f.a.a.b.b.a.bA(5, this.AGn) + f.a.a.b.b.a.bA(6, this.type);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.text);
      }
      i = paramInt;
      if (this.dub != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dub);
      }
      i = i + f.a.a.b.b.a.q(9, this.Eul) + f.a.a.b.b.a.bA(10, this.AHk) + f.a.a.b.b.a.bA(11, this.Eum) + f.a.a.b.b.a.q(12, this.Eun) + f.a.a.b.b.a.bA(13, this.evt) + f.a.a.b.b.a.bA(14, this.htk);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.extInfo);
      }
      AppMethodBeat.o(153002);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153002);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dcv localdcv = (dcv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153002);
          return -1;
        case 1: 
          localdcv.dvT = locala.KhF.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 2: 
          localdcv.AHi = locala.KhF.xS();
          AppMethodBeat.o(153002);
          return 0;
        case 3: 
          localdcv.AHj = locala.KhF.xS();
          AppMethodBeat.o(153002);
          return 0;
        case 4: 
          localdcv.huV = locala.KhF.xT();
          AppMethodBeat.o(153002);
          return 0;
        case 5: 
          localdcv.AGn = locala.KhF.xS();
          AppMethodBeat.o(153002);
          return 0;
        case 6: 
          localdcv.type = locala.KhF.xS();
          AppMethodBeat.o(153002);
          return 0;
        case 7: 
          localdcv.text = locala.KhF.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 8: 
          localdcv.dub = locala.KhF.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 9: 
          localdcv.Eul = locala.KhF.xT();
          AppMethodBeat.o(153002);
          return 0;
        case 10: 
          localdcv.AHk = locala.KhF.xS();
          AppMethodBeat.o(153002);
          return 0;
        case 11: 
          localdcv.Eum = locala.KhF.xS();
          AppMethodBeat.o(153002);
          return 0;
        case 12: 
          localdcv.Eun = locala.KhF.xT();
          AppMethodBeat.o(153002);
          return 0;
        case 13: 
          localdcv.evt = locala.KhF.xS();
          AppMethodBeat.o(153002);
          return 0;
        case 14: 
          localdcv.htk = locala.KhF.xS();
          AppMethodBeat.o(153002);
          return 0;
        }
        localdcv.extInfo = locala.KhF.readString();
        AppMethodBeat.o(153002);
        return 0;
      }
      AppMethodBeat.o(153002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcv
 * JD-Core Version:    0.7.0.1
 */
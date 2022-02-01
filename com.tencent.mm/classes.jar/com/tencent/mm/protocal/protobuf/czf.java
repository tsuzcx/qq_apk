package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class czf
  extends com.tencent.mm.bw.a
{
  public String FIm;
  public String FIn;
  public String FIo;
  public int FIp;
  public String FIq;
  public String FIr;
  public String FIs;
  public int FIt;
  public int FIu;
  public int FIv;
  public int FIw;
  public int FIx;
  public int Scene;
  public String Title;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117927);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FIm == null)
      {
        paramVarArgs = new b("Not all required fields were included: PickedWord");
        AppMethodBeat.o(117927);
        throw paramVarArgs;
      }
      if (this.FIm != null) {
        paramVarArgs.d(1, this.FIm);
      }
      if (this.FIn != null) {
        paramVarArgs.d(2, this.FIn);
      }
      if (this.FIo != null) {
        paramVarArgs.d(3, this.FIo);
      }
      paramVarArgs.aR(4, this.Scene);
      paramVarArgs.aR(5, this.FIp);
      if (this.Url != null) {
        paramVarArgs.d(6, this.Url);
      }
      if (this.Title != null) {
        paramVarArgs.d(7, this.Title);
      }
      if (this.FIq != null) {
        paramVarArgs.d(8, this.FIq);
      }
      if (this.FIr != null) {
        paramVarArgs.d(9, this.FIr);
      }
      if (this.FIs != null) {
        paramVarArgs.d(10, this.FIs);
      }
      paramVarArgs.aR(11, this.FIt);
      paramVarArgs.aR(12, this.FIu);
      paramVarArgs.aR(13, this.FIv);
      paramVarArgs.aR(14, this.FIw);
      paramVarArgs.aR(15, this.FIx);
      AppMethodBeat.o(117927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FIm == null) {
        break label1018;
      }
    }
    label1018:
    for (int i = f.a.a.b.b.a.e(1, this.FIm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FIn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FIn);
      }
      i = paramInt;
      if (this.FIo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FIo);
      }
      i = i + f.a.a.b.b.a.bx(4, this.Scene) + f.a.a.b.b.a.bx(5, this.FIp);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Url);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Title);
      }
      paramInt = i;
      if (this.FIq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FIq);
      }
      i = paramInt;
      if (this.FIr != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FIr);
      }
      paramInt = i;
      if (this.FIs != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FIs);
      }
      i = f.a.a.b.b.a.bx(11, this.FIt);
      int j = f.a.a.b.b.a.bx(12, this.FIu);
      int k = f.a.a.b.b.a.bx(13, this.FIv);
      int m = f.a.a.b.b.a.bx(14, this.FIw);
      int n = f.a.a.b.b.a.bx(15, this.FIx);
      AppMethodBeat.o(117927);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FIm == null)
        {
          paramVarArgs = new b("Not all required fields were included: PickedWord");
          AppMethodBeat.o(117927);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117927);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        czf localczf = (czf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117927);
          return -1;
        case 1: 
          localczf.FIm = locala.LVo.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 2: 
          localczf.FIn = locala.LVo.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 3: 
          localczf.FIo = locala.LVo.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 4: 
          localczf.Scene = locala.LVo.xF();
          AppMethodBeat.o(117927);
          return 0;
        case 5: 
          localczf.FIp = locala.LVo.xF();
          AppMethodBeat.o(117927);
          return 0;
        case 6: 
          localczf.Url = locala.LVo.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 7: 
          localczf.Title = locala.LVo.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 8: 
          localczf.FIq = locala.LVo.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 9: 
          localczf.FIr = locala.LVo.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 10: 
          localczf.FIs = locala.LVo.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 11: 
          localczf.FIt = locala.LVo.xF();
          AppMethodBeat.o(117927);
          return 0;
        case 12: 
          localczf.FIu = locala.LVo.xF();
          AppMethodBeat.o(117927);
          return 0;
        case 13: 
          localczf.FIv = locala.LVo.xF();
          AppMethodBeat.o(117927);
          return 0;
        case 14: 
          localczf.FIw = locala.LVo.xF();
          AppMethodBeat.o(117927);
          return 0;
        }
        localczf.FIx = locala.LVo.xF();
        AppMethodBeat.o(117927);
        return 0;
      }
      AppMethodBeat.o(117927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czf
 * JD-Core Version:    0.7.0.1
 */
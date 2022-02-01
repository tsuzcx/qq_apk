package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class chb
  extends com.tencent.mm.bw.a
{
  public int Fve;
  public boolean Fvf;
  public boolean Fvg;
  public boolean Fvh;
  public boolean Fvi;
  public boolean Fvj;
  public boolean Fvk;
  public int hgY;
  public int id;
  public int nGQ;
  public boolean nGd;
  public int nLC;
  public int nuJ;
  public String url;
  public String znF = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198789);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(198789);
        throw paramVarArgs;
      }
      if (this.znF == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(198789);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.id);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.aR(3, this.hgY);
      paramVarArgs.aR(4, this.nGQ);
      paramVarArgs.aR(5, this.nuJ);
      paramVarArgs.aR(6, this.nLC);
      paramVarArgs.aR(7, this.Fve);
      if (this.znF != null) {
        paramVarArgs.d(8, this.znF);
      }
      paramVarArgs.bl(9, this.Fvf);
      paramVarArgs.bl(10, this.Fvg);
      paramVarArgs.bl(11, this.Fvh);
      paramVarArgs.bl(12, this.Fvi);
      paramVarArgs.bl(13, this.Fvj);
      paramVarArgs.bl(14, this.nGd);
      paramVarArgs.bl(15, this.Fvk);
      AppMethodBeat.o(198789);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.id) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.hgY) + f.a.a.b.b.a.bx(4, this.nGQ) + f.a.a.b.b.a.bx(5, this.nuJ) + f.a.a.b.b.a.bx(6, this.nLC) + f.a.a.b.b.a.bx(7, this.Fve);
      paramInt = i;
      if (this.znF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.znF);
      }
      i = f.a.a.b.b.a.fK(9);
      int j = f.a.a.b.b.a.fK(10);
      int k = f.a.a.b.b.a.fK(11);
      int m = f.a.a.b.b.a.fK(12);
      int n = f.a.a.b.b.a.fK(13);
      int i1 = f.a.a.b.b.a.fK(14);
      int i2 = f.a.a.b.b.a.fK(15);
      AppMethodBeat.o(198789);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(198789);
        throw paramVarArgs;
      }
      if (this.znF == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(198789);
        throw paramVarArgs;
      }
      AppMethodBeat.o(198789);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      chb localchb = (chb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(198789);
        return -1;
      case 1: 
        localchb.id = locala.LVo.xF();
        AppMethodBeat.o(198789);
        return 0;
      case 2: 
        localchb.url = locala.LVo.readString();
        AppMethodBeat.o(198789);
        return 0;
      case 3: 
        localchb.hgY = locala.LVo.xF();
        AppMethodBeat.o(198789);
        return 0;
      case 4: 
        localchb.nGQ = locala.LVo.xF();
        AppMethodBeat.o(198789);
        return 0;
      case 5: 
        localchb.nuJ = locala.LVo.xF();
        AppMethodBeat.o(198789);
        return 0;
      case 6: 
        localchb.nLC = locala.LVo.xF();
        AppMethodBeat.o(198789);
        return 0;
      case 7: 
        localchb.Fve = locala.LVo.xF();
        AppMethodBeat.o(198789);
        return 0;
      case 8: 
        localchb.znF = locala.LVo.readString();
        AppMethodBeat.o(198789);
        return 0;
      case 9: 
        localchb.Fvf = locala.LVo.fZX();
        AppMethodBeat.o(198789);
        return 0;
      case 10: 
        localchb.Fvg = locala.LVo.fZX();
        AppMethodBeat.o(198789);
        return 0;
      case 11: 
        localchb.Fvh = locala.LVo.fZX();
        AppMethodBeat.o(198789);
        return 0;
      case 12: 
        localchb.Fvi = locala.LVo.fZX();
        AppMethodBeat.o(198789);
        return 0;
      case 13: 
        localchb.Fvj = locala.LVo.fZX();
        AppMethodBeat.o(198789);
        return 0;
      case 14: 
        localchb.nGd = locala.LVo.fZX();
        AppMethodBeat.o(198789);
        return 0;
      }
      localchb.Fvk = locala.LVo.fZX();
      AppMethodBeat.o(198789);
      return 0;
    }
    AppMethodBeat.o(198789);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chb
 * JD-Core Version:    0.7.0.1
 */
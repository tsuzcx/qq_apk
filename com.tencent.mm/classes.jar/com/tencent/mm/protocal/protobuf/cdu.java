package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdu
  extends com.tencent.mm.bw.a
{
  public String BGR;
  public String Bxu;
  public String ByM;
  public long ByY;
  public long ByZ;
  public long Bza;
  public int Bzb;
  public int Bzc;
  public long Bzd;
  public String Fsw;
  public String Fsx;
  public String Fsy;
  public int Fsz;
  public String dlQ;
  public String drM;
  public String title;
  public String type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91578);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      if (this.drM != null) {
        paramVarArgs.d(3, this.drM);
      }
      if (this.BGR != null) {
        paramVarArgs.d(4, this.BGR);
      }
      if (this.ByM != null) {
        paramVarArgs.d(5, this.ByM);
      }
      if (this.Fsw != null) {
        paramVarArgs.d(6, this.Fsw);
      }
      if (this.type != null) {
        paramVarArgs.d(7, this.type);
      }
      if (this.title != null) {
        paramVarArgs.d(8, this.title);
      }
      paramVarArgs.aO(9, this.ByY);
      paramVarArgs.aO(10, this.ByZ);
      if (this.Bxu != null) {
        paramVarArgs.d(11, this.Bxu);
      }
      paramVarArgs.aO(12, this.Bza);
      paramVarArgs.aR(13, this.Bzb);
      paramVarArgs.aR(14, this.Bzc);
      if (this.Fsx != null) {
        paramVarArgs.d(15, this.Fsx);
      }
      if (this.Fsy != null) {
        paramVarArgs.d(16, this.Fsy);
      }
      paramVarArgs.aO(17, this.Bzd);
      paramVarArgs.aR(18, this.Fsz);
      AppMethodBeat.o(91578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1146;
      }
    }
    label1146:
    for (int i = f.a.a.b.b.a.e(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlQ);
      }
      i = paramInt;
      if (this.drM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.drM);
      }
      paramInt = i;
      if (this.BGR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.BGR);
      }
      i = paramInt;
      if (this.ByM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ByM);
      }
      paramInt = i;
      if (this.Fsw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fsw);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.type);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.title);
      }
      i = paramInt + f.a.a.b.b.a.p(9, this.ByY) + f.a.a.b.b.a.p(10, this.ByZ);
      paramInt = i;
      if (this.Bxu != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Bxu);
      }
      i = paramInt + f.a.a.b.b.a.p(12, this.Bza) + f.a.a.b.b.a.bx(13, this.Bzb) + f.a.a.b.b.a.bx(14, this.Bzc);
      paramInt = i;
      if (this.Fsx != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Fsx);
      }
      i = paramInt;
      if (this.Fsy != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.Fsy);
      }
      paramInt = f.a.a.b.b.a.p(17, this.Bzd);
      int j = f.a.a.b.b.a.bx(18, this.Fsz);
      AppMethodBeat.o(91578);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91578);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cdu localcdu = (cdu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91578);
          return -1;
        case 1: 
          localcdu.url = locala.LVo.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 2: 
          localcdu.dlQ = locala.LVo.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 3: 
          localcdu.drM = locala.LVo.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 4: 
          localcdu.BGR = locala.LVo.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 5: 
          localcdu.ByM = locala.LVo.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 6: 
          localcdu.Fsw = locala.LVo.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 7: 
          localcdu.type = locala.LVo.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 8: 
          localcdu.title = locala.LVo.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 9: 
          localcdu.ByY = locala.LVo.xG();
          AppMethodBeat.o(91578);
          return 0;
        case 10: 
          localcdu.ByZ = locala.LVo.xG();
          AppMethodBeat.o(91578);
          return 0;
        case 11: 
          localcdu.Bxu = locala.LVo.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 12: 
          localcdu.Bza = locala.LVo.xG();
          AppMethodBeat.o(91578);
          return 0;
        case 13: 
          localcdu.Bzb = locala.LVo.xF();
          AppMethodBeat.o(91578);
          return 0;
        case 14: 
          localcdu.Bzc = locala.LVo.xF();
          AppMethodBeat.o(91578);
          return 0;
        case 15: 
          localcdu.Fsx = locala.LVo.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 16: 
          localcdu.Fsy = locala.LVo.readString();
          AppMethodBeat.o(91578);
          return 0;
        case 17: 
          localcdu.Bzd = locala.LVo.xG();
          AppMethodBeat.o(91578);
          return 0;
        }
        localcdu.Fsz = locala.LVo.xF();
        AppMethodBeat.o(91578);
        return 0;
      }
      AppMethodBeat.o(91578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdu
 * JD-Core Version:    0.7.0.1
 */
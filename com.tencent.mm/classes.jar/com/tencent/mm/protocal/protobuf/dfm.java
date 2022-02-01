package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfm
  extends com.tencent.mm.bw.a
{
  public String FPa;
  public String FPb;
  public String ihe;
  public String ihf;
  public String ihg;
  public String ihh;
  public String ihi;
  public String ihj;
  public String ihk;
  public String ihl;
  public String ihm;
  public String ihn;
  public String iho;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152710);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ihe != null) {
        paramVarArgs.d(1, this.ihe);
      }
      if (this.ihf != null) {
        paramVarArgs.d(2, this.ihf);
      }
      if (this.ihg != null) {
        paramVarArgs.d(3, this.ihg);
      }
      if (this.ihh != null) {
        paramVarArgs.d(4, this.ihh);
      }
      if (this.ihi != null) {
        paramVarArgs.d(5, this.ihi);
      }
      if (this.ihj != null) {
        paramVarArgs.d(6, this.ihj);
      }
      if (this.ihk != null) {
        paramVarArgs.d(7, this.ihk);
      }
      if (this.ihl != null) {
        paramVarArgs.d(8, this.ihl);
      }
      if (this.ihm != null) {
        paramVarArgs.d(9, this.ihm);
      }
      if (this.ihn != null) {
        paramVarArgs.d(10, this.ihn);
      }
      if (this.iho != null) {
        paramVarArgs.d(11, this.iho);
      }
      if (this.FPa != null) {
        paramVarArgs.d(12, this.FPa);
      }
      if (this.FPb != null) {
        paramVarArgs.d(13, this.FPb);
      }
      AppMethodBeat.o(152710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ihe == null) {
        break label950;
      }
    }
    label950:
    for (int i = f.a.a.b.b.a.e(1, this.ihe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ihf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ihf);
      }
      i = paramInt;
      if (this.ihg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ihg);
      }
      paramInt = i;
      if (this.ihh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ihh);
      }
      i = paramInt;
      if (this.ihi != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ihi);
      }
      paramInt = i;
      if (this.ihj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ihj);
      }
      i = paramInt;
      if (this.ihk != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ihk);
      }
      paramInt = i;
      if (this.ihl != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ihl);
      }
      i = paramInt;
      if (this.ihm != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ihm);
      }
      paramInt = i;
      if (this.ihn != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ihn);
      }
      i = paramInt;
      if (this.iho != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.iho);
      }
      paramInt = i;
      if (this.FPa != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FPa);
      }
      i = paramInt;
      if (this.FPb != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FPb);
      }
      AppMethodBeat.o(152710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152710);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dfm localdfm = (dfm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152710);
          return -1;
        case 1: 
          localdfm.ihe = locala.LVo.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 2: 
          localdfm.ihf = locala.LVo.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 3: 
          localdfm.ihg = locala.LVo.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 4: 
          localdfm.ihh = locala.LVo.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 5: 
          localdfm.ihi = locala.LVo.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 6: 
          localdfm.ihj = locala.LVo.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 7: 
          localdfm.ihk = locala.LVo.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 8: 
          localdfm.ihl = locala.LVo.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 9: 
          localdfm.ihm = locala.LVo.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 10: 
          localdfm.ihn = locala.LVo.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 11: 
          localdfm.iho = locala.LVo.readString();
          AppMethodBeat.o(152710);
          return 0;
        case 12: 
          localdfm.FPa = locala.LVo.readString();
          AppMethodBeat.o(152710);
          return 0;
        }
        localdfm.FPb = locala.LVo.readString();
        AppMethodBeat.o(152710);
        return 0;
      }
      AppMethodBeat.o(152710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfm
 * JD-Core Version:    0.7.0.1
 */
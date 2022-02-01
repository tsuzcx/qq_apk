package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cne
  extends com.tencent.mm.bw.a
{
  public int FAp;
  public String hhi;
  public String hhj;
  public String hhk;
  public String hhl;
  public String hhm;
  public String hhn;
  public String hho;
  public String hhp;
  public String hhq;
  public String hhr;
  public String hhs;
  public String hht;
  public boolean hhu;
  public int hhv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169219);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hhi != null) {
        paramVarArgs.d(1, this.hhi);
      }
      if (this.hhj != null) {
        paramVarArgs.d(2, this.hhj);
      }
      if (this.hhk != null) {
        paramVarArgs.d(3, this.hhk);
      }
      if (this.hhl != null) {
        paramVarArgs.d(4, this.hhl);
      }
      if (this.hhm != null) {
        paramVarArgs.d(5, this.hhm);
      }
      if (this.hhn != null) {
        paramVarArgs.d(6, this.hhn);
      }
      if (this.hho != null) {
        paramVarArgs.d(7, this.hho);
      }
      if (this.hhp != null) {
        paramVarArgs.d(8, this.hhp);
      }
      if (this.hhq != null) {
        paramVarArgs.d(9, this.hhq);
      }
      if (this.hhr != null) {
        paramVarArgs.d(10, this.hhr);
      }
      paramVarArgs.aR(11, this.FAp);
      if (this.hhs != null) {
        paramVarArgs.d(12, this.hhs);
      }
      if (this.hht != null) {
        paramVarArgs.d(13, this.hht);
      }
      paramVarArgs.bl(14, this.hhu);
      paramVarArgs.aR(15, this.hhv);
      AppMethodBeat.o(169219);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hhi == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = f.a.a.b.b.a.e(1, this.hhi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hhj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hhj);
      }
      i = paramInt;
      if (this.hhk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hhk);
      }
      paramInt = i;
      if (this.hhl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hhl);
      }
      i = paramInt;
      if (this.hhm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hhm);
      }
      paramInt = i;
      if (this.hhn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hhn);
      }
      i = paramInt;
      if (this.hho != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hho);
      }
      paramInt = i;
      if (this.hhp != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hhp);
      }
      i = paramInt;
      if (this.hhq != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.hhq);
      }
      paramInt = i;
      if (this.hhr != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.hhr);
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.FAp);
      paramInt = i;
      if (this.hhs != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.hhs);
      }
      i = paramInt;
      if (this.hht != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hht);
      }
      paramInt = f.a.a.b.b.a.fK(14);
      int j = f.a.a.b.b.a.bx(15, this.hhv);
      AppMethodBeat.o(169219);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169219);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cne localcne = (cne)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169219);
          return -1;
        case 1: 
          localcne.hhi = locala.LVo.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 2: 
          localcne.hhj = locala.LVo.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 3: 
          localcne.hhk = locala.LVo.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 4: 
          localcne.hhl = locala.LVo.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 5: 
          localcne.hhm = locala.LVo.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 6: 
          localcne.hhn = locala.LVo.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 7: 
          localcne.hho = locala.LVo.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 8: 
          localcne.hhp = locala.LVo.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 9: 
          localcne.hhq = locala.LVo.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 10: 
          localcne.hhr = locala.LVo.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 11: 
          localcne.FAp = locala.LVo.xF();
          AppMethodBeat.o(169219);
          return 0;
        case 12: 
          localcne.hhs = locala.LVo.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 13: 
          localcne.hht = locala.LVo.readString();
          AppMethodBeat.o(169219);
          return 0;
        case 14: 
          localcne.hhu = locala.LVo.fZX();
          AppMethodBeat.o(169219);
          return 0;
        }
        localcne.hhv = locala.LVo.xF();
        AppMethodBeat.o(169219);
        return 0;
      }
      AppMethodBeat.o(169219);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cne
 * JD-Core Version:    0.7.0.1
 */
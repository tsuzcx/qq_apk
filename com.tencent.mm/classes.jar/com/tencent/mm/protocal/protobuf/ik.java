package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ik
  extends com.tencent.mm.bw.a
{
  public String BoQ;
  public String DWh;
  public String DWi;
  public String DWj;
  public boolean DWk;
  public String DWl;
  public String cZz;
  public String ofd;
  public String tGS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72419);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tGS != null) {
        paramVarArgs.d(1, this.tGS);
      }
      if (this.cZz != null) {
        paramVarArgs.d(2, this.cZz);
      }
      if (this.ofd != null) {
        paramVarArgs.d(3, this.ofd);
      }
      if (this.BoQ != null) {
        paramVarArgs.d(4, this.BoQ);
      }
      if (this.DWh != null) {
        paramVarArgs.d(5, this.DWh);
      }
      if (this.DWi != null) {
        paramVarArgs.d(6, this.DWi);
      }
      if (this.DWj != null) {
        paramVarArgs.d(8, this.DWj);
      }
      paramVarArgs.bl(9, this.DWk);
      if (this.DWl != null) {
        paramVarArgs.d(10, this.DWl);
      }
      AppMethodBeat.o(72419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tGS == null) {
        break label690;
      }
    }
    label690:
    for (int i = f.a.a.b.b.a.e(1, this.tGS) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cZz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cZz);
      }
      i = paramInt;
      if (this.ofd != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ofd);
      }
      paramInt = i;
      if (this.BoQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.BoQ);
      }
      i = paramInt;
      if (this.DWh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DWh);
      }
      paramInt = i;
      if (this.DWi != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DWi);
      }
      i = paramInt;
      if (this.DWj != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DWj);
      }
      i += f.a.a.b.b.a.fK(9) + 1;
      paramInt = i;
      if (this.DWl != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DWl);
      }
      AppMethodBeat.o(72419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72419);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ik localik = (ik)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          AppMethodBeat.o(72419);
          return -1;
        case 1: 
          localik.tGS = locala.LVo.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 2: 
          localik.cZz = locala.LVo.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 3: 
          localik.ofd = locala.LVo.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 4: 
          localik.BoQ = locala.LVo.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 5: 
          localik.DWh = locala.LVo.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 6: 
          localik.DWi = locala.LVo.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 8: 
          localik.DWj = locala.LVo.readString();
          AppMethodBeat.o(72419);
          return 0;
        case 9: 
          localik.DWk = locala.LVo.fZX();
          AppMethodBeat.o(72419);
          return 0;
        }
        localik.DWl = locala.LVo.readString();
        AppMethodBeat.o(72419);
        return 0;
      }
      AppMethodBeat.o(72419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ik
 * JD-Core Version:    0.7.0.1
 */
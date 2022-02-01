package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class agx
  extends com.tencent.mm.bw.a
{
  public int FNv;
  public String Gxe;
  public String Gxf;
  public String Gxg;
  public String Gxh;
  public String Gxi;
  public int Gxj;
  public int Gxk;
  public String Gxl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104780);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gxe == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegWord");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.Gxf == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.Gxg == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.Gxe != null) {
        paramVarArgs.d(1, this.Gxe);
      }
      if (this.Gxf != null) {
        paramVarArgs.d(2, this.Gxf);
      }
      if (this.Gxg != null) {
        paramVarArgs.d(3, this.Gxg);
      }
      if (this.Gxh != null) {
        paramVarArgs.d(4, this.Gxh);
      }
      if (this.Gxi != null) {
        paramVarArgs.d(5, this.Gxi);
      }
      paramVarArgs.aS(6, this.Gxj);
      paramVarArgs.aS(7, this.Gxk);
      if (this.Gxl != null) {
        paramVarArgs.d(8, this.Gxl);
      }
      paramVarArgs.aS(9, this.FNv);
      AppMethodBeat.o(104780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gxe == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.b.b.a.e(1, this.Gxe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gxf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gxf);
      }
      i = paramInt;
      if (this.Gxg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gxg);
      }
      paramInt = i;
      if (this.Gxh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gxh);
      }
      i = paramInt;
      if (this.Gxi != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gxi);
      }
      i = i + f.a.a.b.b.a.bz(6, this.Gxj) + f.a.a.b.b.a.bz(7, this.Gxk);
      paramInt = i;
      if (this.Gxl != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gxl);
      }
      i = f.a.a.b.b.a.bz(9, this.FNv);
      AppMethodBeat.o(104780);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Gxe == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegWord");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.Gxf == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.Gxg == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104780);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agx localagx = (agx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104780);
          return -1;
        case 1: 
          localagx.Gxe = locala.OmT.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 2: 
          localagx.Gxf = locala.OmT.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 3: 
          localagx.Gxg = locala.OmT.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 4: 
          localagx.Gxh = locala.OmT.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 5: 
          localagx.Gxi = locala.OmT.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 6: 
          localagx.Gxj = locala.OmT.zc();
          AppMethodBeat.o(104780);
          return 0;
        case 7: 
          localagx.Gxk = locala.OmT.zc();
          AppMethodBeat.o(104780);
          return 0;
        case 8: 
          localagx.Gxl = locala.OmT.readString();
          AppMethodBeat.o(104780);
          return 0;
        }
        localagx.FNv = locala.OmT.zc();
        AppMethodBeat.o(104780);
        return 0;
      }
      AppMethodBeat.o(104780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agx
 * JD-Core Version:    0.7.0.1
 */
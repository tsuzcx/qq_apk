package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aee
  extends com.tencent.mm.bw.a
{
  public int DPI;
  public String EwT;
  public String EwU;
  public String EwV;
  public String EwW;
  public String EwX;
  public int EwY;
  public int EwZ;
  public String Exa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104780);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EwT == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegWord");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.EwU == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.EwV == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.EwT != null) {
        paramVarArgs.d(1, this.EwT);
      }
      if (this.EwU != null) {
        paramVarArgs.d(2, this.EwU);
      }
      if (this.EwV != null) {
        paramVarArgs.d(3, this.EwV);
      }
      if (this.EwW != null) {
        paramVarArgs.d(4, this.EwW);
      }
      if (this.EwX != null) {
        paramVarArgs.d(5, this.EwX);
      }
      paramVarArgs.aR(6, this.EwY);
      paramVarArgs.aR(7, this.EwZ);
      if (this.Exa != null) {
        paramVarArgs.d(8, this.Exa);
      }
      paramVarArgs.aR(9, this.DPI);
      AppMethodBeat.o(104780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EwT == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.b.b.a.e(1, this.EwT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EwU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EwU);
      }
      i = paramInt;
      if (this.EwV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EwV);
      }
      paramInt = i;
      if (this.EwW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EwW);
      }
      i = paramInt;
      if (this.EwX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EwX);
      }
      i = i + f.a.a.b.b.a.bx(6, this.EwY) + f.a.a.b.b.a.bx(7, this.EwZ);
      paramInt = i;
      if (this.Exa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Exa);
      }
      i = f.a.a.b.b.a.bx(9, this.DPI);
      AppMethodBeat.o(104780);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EwT == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegWord");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.EwU == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.EwV == null)
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
        aee localaee = (aee)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104780);
          return -1;
        case 1: 
          localaee.EwT = locala.LVo.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 2: 
          localaee.EwU = locala.LVo.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 3: 
          localaee.EwV = locala.LVo.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 4: 
          localaee.EwW = locala.LVo.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 5: 
          localaee.EwX = locala.LVo.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 6: 
          localaee.EwY = locala.LVo.xF();
          AppMethodBeat.o(104780);
          return 0;
        case 7: 
          localaee.EwZ = locala.LVo.xF();
          AppMethodBeat.o(104780);
          return 0;
        case 8: 
          localaee.Exa = locala.LVo.readString();
          AppMethodBeat.o(104780);
          return 0;
        }
        localaee.DPI = locala.LVo.xF();
        AppMethodBeat.o(104780);
        return 0;
      }
      AppMethodBeat.o(104780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aee
 * JD-Core Version:    0.7.0.1
 */
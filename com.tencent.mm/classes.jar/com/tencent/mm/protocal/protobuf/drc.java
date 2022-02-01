package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class drc
  extends com.tencent.mm.bx.a
{
  public int CyE;
  public String Daj;
  public String EGm;
  public String EGn;
  public String EGo;
  public String EGp;
  public String EGq;
  public String EGr;
  public String eKv;
  public String mAV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32531);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EGm == null)
      {
        paramVarArgs = new b("Not all required fields were included: LocalNodeId");
        AppMethodBeat.o(32531);
        throw paramVarArgs;
      }
      if (this.EGm != null) {
        paramVarArgs.d(1, this.EGm);
      }
      if (this.mAV != null) {
        paramVarArgs.d(2, this.mAV);
      }
      if (this.EGn != null) {
        paramVarArgs.d(3, this.EGn);
      }
      if (this.eKv != null) {
        paramVarArgs.d(4, this.eKv);
      }
      if (this.EGo != null) {
        paramVarArgs.d(5, this.EGo);
      }
      if (this.Daj != null) {
        paramVarArgs.d(6, this.Daj);
      }
      if (this.EGp != null) {
        paramVarArgs.d(7, this.EGp);
      }
      if (this.EGq != null) {
        paramVarArgs.d(8, this.EGq);
      }
      if (this.EGr != null) {
        paramVarArgs.d(9, this.EGr);
      }
      paramVarArgs.aR(10, this.CyE);
      AppMethodBeat.o(32531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EGm == null) {
        break label814;
      }
    }
    label814:
    for (int i = f.a.a.b.b.a.e(1, this.EGm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mAV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAV);
      }
      i = paramInt;
      if (this.EGn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EGn);
      }
      paramInt = i;
      if (this.eKv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.eKv);
      }
      i = paramInt;
      if (this.EGo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EGo);
      }
      paramInt = i;
      if (this.Daj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Daj);
      }
      i = paramInt;
      if (this.EGp != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EGp);
      }
      paramInt = i;
      if (this.EGq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EGq);
      }
      i = paramInt;
      if (this.EGr != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EGr);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.CyE);
      AppMethodBeat.o(32531);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EGm == null)
        {
          paramVarArgs = new b("Not all required fields were included: LocalNodeId");
          AppMethodBeat.o(32531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32531);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        drc localdrc = (drc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32531);
          return -1;
        case 1: 
          localdrc.EGm = locala.KhF.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 2: 
          localdrc.mAV = locala.KhF.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 3: 
          localdrc.EGn = locala.KhF.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 4: 
          localdrc.eKv = locala.KhF.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 5: 
          localdrc.EGo = locala.KhF.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 6: 
          localdrc.Daj = locala.KhF.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 7: 
          localdrc.EGp = locala.KhF.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 8: 
          localdrc.EGq = locala.KhF.readString();
          AppMethodBeat.o(32531);
          return 0;
        case 9: 
          localdrc.EGr = locala.KhF.readString();
          AppMethodBeat.o(32531);
          return 0;
        }
        localdrc.CyE = locala.KhF.xS();
        AppMethodBeat.o(32531);
        return 0;
      }
      AppMethodBeat.o(32531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drc
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aa
  extends com.tencent.mm.bx.a
{
  public String Ctb;
  public String Ctc;
  public String Ctd;
  public String Cte;
  public LinkedList<String> Ctf;
  public String mAV;
  public String mBv;
  
  public aa()
  {
    AppMethodBeat.i(145665);
    this.Ctf = new LinkedList();
    AppMethodBeat.o(145665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mBv != null) {
        paramVarArgs.d(1, this.mBv);
      }
      if (this.mAV != null) {
        paramVarArgs.d(2, this.mAV);
      }
      if (this.Ctb != null) {
        paramVarArgs.d(3, this.Ctb);
      }
      if (this.Ctc != null) {
        paramVarArgs.d(4, this.Ctc);
      }
      if (this.Ctd != null) {
        paramVarArgs.d(5, this.Ctd);
      }
      if (this.Cte != null) {
        paramVarArgs.d(6, this.Cte);
      }
      paramVarArgs.e(7, 1, this.Ctf);
      AppMethodBeat.o(145666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mBv == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.mBv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mAV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAV);
      }
      i = paramInt;
      if (this.Ctb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ctb);
      }
      paramInt = i;
      if (this.Ctc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ctc);
      }
      i = paramInt;
      if (this.Ctd != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ctd);
      }
      paramInt = i;
      if (this.Cte != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Cte);
      }
      i = f.a.a.a.c(7, 1, this.Ctf);
      AppMethodBeat.o(145666);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ctf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(145666);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145666);
          return -1;
        case 1: 
          localaa.mBv = locala.KhF.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 2: 
          localaa.mAV = locala.KhF.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 3: 
          localaa.Ctb = locala.KhF.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 4: 
          localaa.Ctc = locala.KhF.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 5: 
          localaa.Ctd = locala.KhF.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 6: 
          localaa.Cte = locala.KhF.readString();
          AppMethodBeat.o(145666);
          return 0;
        }
        localaa.Ctf.add(locala.KhF.readString());
        AppMethodBeat.o(145666);
        return 0;
      }
      AppMethodBeat.o(145666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aa
 * JD-Core Version:    0.7.0.1
 */
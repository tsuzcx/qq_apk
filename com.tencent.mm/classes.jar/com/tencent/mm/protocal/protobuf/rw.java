package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class rw
  extends com.tencent.mm.bx.a
{
  public String CRq;
  public String CRr;
  public long CSH;
  public String CSI;
  public String CSJ;
  public String nrs;
  public String nvv;
  public String odo;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113980);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.nrs != null) {
        paramVarArgs.d(2, this.nrs);
      }
      if (this.nvv != null) {
        paramVarArgs.d(3, this.nvv);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      paramVarArgs.aG(5, this.CSH);
      if (this.CSI != null) {
        paramVarArgs.d(6, this.CSI);
      }
      if (this.CSJ != null) {
        paramVarArgs.d(7, this.CSJ);
      }
      if (this.odo != null) {
        paramVarArgs.d(8, this.odo);
      }
      if (this.CRq != null) {
        paramVarArgs.d(9, this.CRq);
      }
      if (this.CRr != null) {
        paramVarArgs.d(10, this.CRr);
      }
      AppMethodBeat.o(113980);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label750;
      }
    }
    label750:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nrs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nrs);
      }
      i = paramInt;
      if (this.nvv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nvv);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.CSH);
      paramInt = i;
      if (this.CSI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CSI);
      }
      i = paramInt;
      if (this.CSJ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CSJ);
      }
      paramInt = i;
      if (this.odo != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.odo);
      }
      i = paramInt;
      if (this.CRq != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CRq);
      }
      paramInt = i;
      if (this.CRr != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CRr);
      }
      AppMethodBeat.o(113980);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113980);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rw localrw = (rw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113980);
          return -1;
        case 1: 
          localrw.title = locala.KhF.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 2: 
          localrw.nrs = locala.KhF.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 3: 
          localrw.nvv = locala.KhF.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 4: 
          localrw.url = locala.KhF.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 5: 
          localrw.CSH = locala.KhF.xT();
          AppMethodBeat.o(113980);
          return 0;
        case 6: 
          localrw.CSI = locala.KhF.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 7: 
          localrw.CSJ = locala.KhF.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 8: 
          localrw.odo = locala.KhF.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 9: 
          localrw.CRq = locala.KhF.readString();
          AppMethodBeat.o(113980);
          return 0;
        }
        localrw.CRr = locala.KhF.readString();
        AppMethodBeat.o(113980);
        return 0;
      }
      AppMethodBeat.o(113980);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rw
 * JD-Core Version:    0.7.0.1
 */
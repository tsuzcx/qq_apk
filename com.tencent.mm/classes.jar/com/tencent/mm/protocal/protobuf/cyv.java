package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cyv
  extends com.tencent.mm.bw.a
{
  public long FIb;
  public int actionType;
  public String dlQ;
  public String drM;
  public String id;
  public String mBH;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152995);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      paramVarArgs.aO(3, this.FIb);
      paramVarArgs.aR(4, this.actionType);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.mBH != null) {
        paramVarArgs.d(7, this.mBH);
      }
      if (this.drM != null) {
        paramVarArgs.d(8, this.drM);
      }
      AppMethodBeat.o(152995);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dlQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dlQ);
      }
      i = i + f.a.a.b.b.a.p(3, this.FIb) + f.a.a.b.b.a.bx(4, this.actionType);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.title);
      }
      paramInt = i;
      if (this.mBH != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.mBH);
      }
      i = paramInt;
      if (this.drM != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.drM);
      }
      AppMethodBeat.o(152995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152995);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cyv localcyv = (cyv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152995);
          return -1;
        case 1: 
          localcyv.id = locala.LVo.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 2: 
          localcyv.dlQ = locala.LVo.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 3: 
          localcyv.FIb = locala.LVo.xG();
          AppMethodBeat.o(152995);
          return 0;
        case 4: 
          localcyv.actionType = locala.LVo.xF();
          AppMethodBeat.o(152995);
          return 0;
        case 5: 
          localcyv.url = locala.LVo.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 6: 
          localcyv.title = locala.LVo.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 7: 
          localcyv.mBH = locala.LVo.readString();
          AppMethodBeat.o(152995);
          return 0;
        }
        localcyv.drM = locala.LVo.readString();
        AppMethodBeat.o(152995);
        return 0;
      }
      AppMethodBeat.o(152995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyv
 * JD-Core Version:    0.7.0.1
 */
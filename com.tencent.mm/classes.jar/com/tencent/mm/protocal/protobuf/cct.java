package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cct
  extends com.tencent.mm.bw.a
{
  public LinkedList<Long> Frk;
  public int aFZ;
  public int dtw;
  public String qoi;
  public long qoj;
  public long qok;
  public long qol;
  public String qom;
  public String qon;
  public String sessionId;
  
  public cct()
  {
    AppMethodBeat.i(195329);
    this.aFZ = 0;
    this.qoj = 0L;
    this.qok = 0L;
    this.qol = 0L;
    this.dtw = 0;
    this.Frk = new LinkedList();
    AppMethodBeat.o(195329);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195330);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.d(1, this.sessionId);
      }
      if (this.qoi != null) {
        paramVarArgs.d(2, this.qoi);
      }
      paramVarArgs.aR(3, this.aFZ);
      paramVarArgs.aO(4, this.qoj);
      paramVarArgs.aO(5, this.qok);
      paramVarArgs.aO(6, this.qol);
      if (this.qom != null) {
        paramVarArgs.d(7, this.qom);
      }
      if (this.qon != null) {
        paramVarArgs.d(8, this.qon);
      }
      paramVarArgs.aR(9, this.dtw);
      paramVarArgs.e(10, 3, this.Frk);
      AppMethodBeat.o(195330);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label681;
      }
    }
    label681:
    for (paramInt = f.a.a.b.b.a.e(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qoi != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.qoi);
      }
      i = i + f.a.a.b.b.a.bx(3, this.aFZ) + f.a.a.b.b.a.p(4, this.qoj) + f.a.a.b.b.a.p(5, this.qok) + f.a.a.b.b.a.p(6, this.qol);
      paramInt = i;
      if (this.qom != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.qom);
      }
      i = paramInt;
      if (this.qon != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.qon);
      }
      paramInt = f.a.a.b.b.a.bx(9, this.dtw);
      int j = f.a.a.a.c(10, 3, this.Frk);
      AppMethodBeat.o(195330);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Frk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195330);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cct localcct = (cct)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195330);
          return -1;
        case 1: 
          localcct.sessionId = locala.LVo.readString();
          AppMethodBeat.o(195330);
          return 0;
        case 2: 
          localcct.qoi = locala.LVo.readString();
          AppMethodBeat.o(195330);
          return 0;
        case 3: 
          localcct.aFZ = locala.LVo.xF();
          AppMethodBeat.o(195330);
          return 0;
        case 4: 
          localcct.qoj = locala.LVo.xG();
          AppMethodBeat.o(195330);
          return 0;
        case 5: 
          localcct.qok = locala.LVo.xG();
          AppMethodBeat.o(195330);
          return 0;
        case 6: 
          localcct.qol = locala.LVo.xG();
          AppMethodBeat.o(195330);
          return 0;
        case 7: 
          localcct.qom = locala.LVo.readString();
          AppMethodBeat.o(195330);
          return 0;
        case 8: 
          localcct.qon = locala.LVo.readString();
          AppMethodBeat.o(195330);
          return 0;
        case 9: 
          localcct.dtw = locala.LVo.xF();
          AppMethodBeat.o(195330);
          return 0;
        }
        localcct.Frk.add(Long.valueOf(locala.LVo.xG()));
        AppMethodBeat.o(195330);
        return 0;
      }
      AppMethodBeat.o(195330);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cct
 * JD-Core Version:    0.7.0.1
 */
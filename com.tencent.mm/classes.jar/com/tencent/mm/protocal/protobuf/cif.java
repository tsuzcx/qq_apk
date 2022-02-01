package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cif
  extends com.tencent.mm.bw.a
{
  public LinkedList<Long> Hux;
  public int aHQ;
  public int dGC;
  public String duQ;
  public String extraInfo;
  public long rfl;
  public long rfm;
  public long rfn;
  public String rfo;
  public String rfp;
  public String rfr;
  public String sessionId;
  
  public cif()
  {
    AppMethodBeat.i(196274);
    this.aHQ = 0;
    this.rfl = 0L;
    this.rfm = 0L;
    this.rfn = 0L;
    this.dGC = 0;
    this.Hux = new LinkedList();
    AppMethodBeat.o(196274);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196275);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sessionId != null) {
        paramVarArgs.d(1, this.sessionId);
      }
      if (this.duQ != null) {
        paramVarArgs.d(2, this.duQ);
      }
      paramVarArgs.aS(3, this.aHQ);
      paramVarArgs.aZ(4, this.rfl);
      paramVarArgs.aZ(5, this.rfm);
      paramVarArgs.aZ(6, this.rfn);
      if (this.rfo != null) {
        paramVarArgs.d(7, this.rfo);
      }
      if (this.rfp != null) {
        paramVarArgs.d(8, this.rfp);
      }
      paramVarArgs.aS(9, this.dGC);
      paramVarArgs.e(10, 3, this.Hux);
      if (this.extraInfo != null) {
        paramVarArgs.d(11, this.extraInfo);
      }
      if (this.rfr != null) {
        paramVarArgs.d(12, this.rfr);
      }
      AppMethodBeat.o(196275);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sessionId == null) {
        break label801;
      }
    }
    label801:
    for (paramInt = f.a.a.b.b.a.e(1, this.sessionId) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.duQ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.duQ);
      }
      i = i + f.a.a.b.b.a.bz(3, this.aHQ) + f.a.a.b.b.a.p(4, this.rfl) + f.a.a.b.b.a.p(5, this.rfm) + f.a.a.b.b.a.p(6, this.rfn);
      paramInt = i;
      if (this.rfo != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.rfo);
      }
      i = paramInt;
      if (this.rfp != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.rfp);
      }
      i = i + f.a.a.b.b.a.bz(9, this.dGC) + f.a.a.a.c(10, 3, this.Hux);
      paramInt = i;
      if (this.extraInfo != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.extraInfo);
      }
      i = paramInt;
      if (this.rfr != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.rfr);
      }
      AppMethodBeat.o(196275);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hux.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(196275);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cif localcif = (cif)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(196275);
          return -1;
        case 1: 
          localcif.sessionId = locala.OmT.readString();
          AppMethodBeat.o(196275);
          return 0;
        case 2: 
          localcif.duQ = locala.OmT.readString();
          AppMethodBeat.o(196275);
          return 0;
        case 3: 
          localcif.aHQ = locala.OmT.zc();
          AppMethodBeat.o(196275);
          return 0;
        case 4: 
          localcif.rfl = locala.OmT.zd();
          AppMethodBeat.o(196275);
          return 0;
        case 5: 
          localcif.rfm = locala.OmT.zd();
          AppMethodBeat.o(196275);
          return 0;
        case 6: 
          localcif.rfn = locala.OmT.zd();
          AppMethodBeat.o(196275);
          return 0;
        case 7: 
          localcif.rfo = locala.OmT.readString();
          AppMethodBeat.o(196275);
          return 0;
        case 8: 
          localcif.rfp = locala.OmT.readString();
          AppMethodBeat.o(196275);
          return 0;
        case 9: 
          localcif.dGC = locala.OmT.zc();
          AppMethodBeat.o(196275);
          return 0;
        case 10: 
          localcif.Hux.add(Long.valueOf(locala.OmT.zd()));
          AppMethodBeat.o(196275);
          return 0;
        case 11: 
          localcif.extraInfo = locala.OmT.readString();
          AppMethodBeat.o(196275);
          return 0;
        }
        localcif.rfr = locala.OmT.readString();
        AppMethodBeat.o(196275);
        return 0;
      }
      AppMethodBeat.o(196275);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cif
 * JD-Core Version:    0.7.0.1
 */
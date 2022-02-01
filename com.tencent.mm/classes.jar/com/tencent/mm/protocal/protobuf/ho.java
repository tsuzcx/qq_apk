package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ho
  extends com.tencent.mm.bw.a
{
  public double FSA;
  public int FSB;
  public String FSC;
  public String FSq;
  public String FSr;
  public int FSs;
  public long FSt;
  public int FSu;
  public long FSv;
  public long FSw;
  public long FSx;
  public String FSy;
  public long FSz;
  public String Id;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87872);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      if (this.FSq != null) {
        paramVarArgs.d(2, this.FSq);
      }
      if (this.FSr != null) {
        paramVarArgs.d(3, this.FSr);
      }
      paramVarArgs.aS(4, this.FSs);
      paramVarArgs.aZ(5, this.FSt);
      paramVarArgs.aS(6, this.FSu);
      paramVarArgs.aS(7, this.nJb);
      paramVarArgs.aZ(8, this.FSv);
      paramVarArgs.aZ(9, this.FSw);
      paramVarArgs.aZ(10, this.FSx);
      if (this.FSy != null) {
        paramVarArgs.d(11, this.FSy);
      }
      paramVarArgs.aZ(12, this.FSz);
      paramVarArgs.e(13, this.FSA);
      paramVarArgs.aS(14, this.FSB);
      if (this.FSC != null) {
        paramVarArgs.d(15, this.FSC);
      }
      AppMethodBeat.o(87872);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label897;
      }
    }
    label897:
    for (int i = f.a.a.b.b.a.e(1, this.Id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FSq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FSq);
      }
      i = paramInt;
      if (this.FSr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FSr);
      }
      i = i + f.a.a.b.b.a.bz(4, this.FSs) + f.a.a.b.b.a.p(5, this.FSt) + f.a.a.b.b.a.bz(6, this.FSu) + f.a.a.b.b.a.bz(7, this.nJb) + f.a.a.b.b.a.p(8, this.FSv) + f.a.a.b.b.a.p(9, this.FSw) + f.a.a.b.b.a.p(10, this.FSx);
      paramInt = i;
      if (this.FSy != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FSy);
      }
      i = paramInt + f.a.a.b.b.a.p(12, this.FSz) + f.a.a.b.b.a.amD(13) + f.a.a.b.b.a.bz(14, this.FSB);
      paramInt = i;
      if (this.FSC != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FSC);
      }
      AppMethodBeat.o(87872);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(87872);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ho localho = (ho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87872);
          return -1;
        case 1: 
          localho.Id = locala.OmT.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 2: 
          localho.FSq = locala.OmT.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 3: 
          localho.FSr = locala.OmT.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 4: 
          localho.FSs = locala.OmT.zc();
          AppMethodBeat.o(87872);
          return 0;
        case 5: 
          localho.FSt = locala.OmT.zd();
          AppMethodBeat.o(87872);
          return 0;
        case 6: 
          localho.FSu = locala.OmT.zc();
          AppMethodBeat.o(87872);
          return 0;
        case 7: 
          localho.nJb = locala.OmT.zc();
          AppMethodBeat.o(87872);
          return 0;
        case 8: 
          localho.FSv = locala.OmT.zd();
          AppMethodBeat.o(87872);
          return 0;
        case 9: 
          localho.FSw = locala.OmT.zd();
          AppMethodBeat.o(87872);
          return 0;
        case 10: 
          localho.FSx = locala.OmT.zd();
          AppMethodBeat.o(87872);
          return 0;
        case 11: 
          localho.FSy = locala.OmT.readString();
          AppMethodBeat.o(87872);
          return 0;
        case 12: 
          localho.FSz = locala.OmT.zd();
          AppMethodBeat.o(87872);
          return 0;
        case 13: 
          localho.FSA = Double.longBitsToDouble(locala.OmT.gwc());
          AppMethodBeat.o(87872);
          return 0;
        case 14: 
          localho.FSB = locala.OmT.zc();
          AppMethodBeat.o(87872);
          return 0;
        }
        localho.FSC = locala.OmT.readString();
        AppMethodBeat.o(87872);
        return 0;
      }
      AppMethodBeat.o(87872);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ho
 * JD-Core Version:    0.7.0.1
 */
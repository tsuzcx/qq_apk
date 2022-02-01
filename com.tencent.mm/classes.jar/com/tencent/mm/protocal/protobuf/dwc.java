package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwc
  extends com.tencent.mm.bw.a
{
  public String DUp;
  public String Gds;
  public String Gdt;
  public String Gdu;
  public String fZq;
  public String fZr;
  public String fZs;
  public String fZt;
  public String ncV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116822);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUp != null) {
        paramVarArgs.d(1, this.DUp);
      }
      if (this.fZr != null) {
        paramVarArgs.d(2, this.fZr);
      }
      if (this.fZq != null) {
        paramVarArgs.d(3, this.fZq);
      }
      if (this.ncV != null) {
        paramVarArgs.d(4, this.ncV);
      }
      if (this.Gds != null) {
        paramVarArgs.d(5, this.Gds);
      }
      if (this.fZs != null) {
        paramVarArgs.d(6, this.fZs);
      }
      if (this.fZt != null) {
        paramVarArgs.d(7, this.fZt);
      }
      if (this.Gdt != null) {
        paramVarArgs.d(8, this.Gdt);
      }
      if (this.Gdu != null) {
        paramVarArgs.d(9, this.Gdu);
      }
      AppMethodBeat.o(116822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUp == null) {
        break label702;
      }
    }
    label702:
    for (int i = f.a.a.b.b.a.e(1, this.DUp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fZr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fZr);
      }
      i = paramInt;
      if (this.fZq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.fZq);
      }
      paramInt = i;
      if (this.ncV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ncV);
      }
      i = paramInt;
      if (this.Gds != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gds);
      }
      paramInt = i;
      if (this.fZs != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.fZs);
      }
      i = paramInt;
      if (this.fZt != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.fZt);
      }
      paramInt = i;
      if (this.Gdt != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gdt);
      }
      i = paramInt;
      if (this.Gdu != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Gdu);
      }
      AppMethodBeat.o(116822);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116822);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dwc localdwc = (dwc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116822);
          return -1;
        case 1: 
          localdwc.DUp = locala.LVo.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 2: 
          localdwc.fZr = locala.LVo.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 3: 
          localdwc.fZq = locala.LVo.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 4: 
          localdwc.ncV = locala.LVo.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 5: 
          localdwc.Gds = locala.LVo.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 6: 
          localdwc.fZs = locala.LVo.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 7: 
          localdwc.fZt = locala.LVo.readString();
          AppMethodBeat.o(116822);
          return 0;
        case 8: 
          localdwc.Gdt = locala.LVo.readString();
          AppMethodBeat.o(116822);
          return 0;
        }
        localdwc.Gdu = locala.LVo.readString();
        AppMethodBeat.o(116822);
        return 0;
      }
      AppMethodBeat.o(116822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwc
 * JD-Core Version:    0.7.0.1
 */
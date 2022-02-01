package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rh
  extends com.tencent.mm.bx.a
{
  public String CRq;
  public String CRr;
  public String country;
  public String descriptor;
  public float dpb;
  public float dqQ;
  public String evA;
  public String evz;
  public String hdQ;
  public String name;
  public String nrG;
  public String ntj;
  public float wUu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113969);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      if (this.descriptor != null) {
        paramVarArgs.d(2, this.descriptor);
      }
      if (this.nrG != null) {
        paramVarArgs.d(3, this.nrG);
      }
      if (this.country != null) {
        paramVarArgs.d(4, this.country);
      }
      if (this.evz != null) {
        paramVarArgs.d(5, this.evz);
      }
      if (this.evA != null) {
        paramVarArgs.d(6, this.evA);
      }
      if (this.hdQ != null) {
        paramVarArgs.d(7, this.hdQ);
      }
      paramVarArgs.x(8, this.wUu);
      paramVarArgs.x(9, this.dqQ);
      paramVarArgs.x(10, this.dpb);
      if (this.ntj != null) {
        paramVarArgs.d(11, this.ntj);
      }
      if (this.CRq != null) {
        paramVarArgs.d(12, this.CRq);
      }
      if (this.CRr != null) {
        paramVarArgs.d(13, this.CRr);
      }
      AppMethodBeat.o(113969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label903;
      }
    }
    label903:
    for (int i = f.a.a.b.b.a.e(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.descriptor != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.descriptor);
      }
      i = paramInt;
      if (this.nrG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nrG);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.country);
      }
      i = paramInt;
      if (this.evz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.evz);
      }
      paramInt = i;
      if (this.evA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.evA);
      }
      i = paramInt;
      if (this.hdQ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hdQ);
      }
      i = i + (f.a.a.b.b.a.fY(8) + 4) + (f.a.a.b.b.a.fY(9) + 4) + (f.a.a.b.b.a.fY(10) + 4);
      paramInt = i;
      if (this.ntj != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.ntj);
      }
      i = paramInt;
      if (this.CRq != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.CRq);
      }
      paramInt = i;
      if (this.CRr != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CRr);
      }
      AppMethodBeat.o(113969);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113969);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rh localrh = (rh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113969);
          return -1;
        case 1: 
          localrh.name = locala.KhF.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 2: 
          localrh.descriptor = locala.KhF.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 3: 
          localrh.nrG = locala.KhF.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 4: 
          localrh.country = locala.KhF.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 5: 
          localrh.evz = locala.KhF.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 6: 
          localrh.evA = locala.KhF.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 7: 
          localrh.hdQ = locala.KhF.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 8: 
          localrh.wUu = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(113969);
          return 0;
        case 9: 
          localrh.dqQ = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(113969);
          return 0;
        case 10: 
          localrh.dpb = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(113969);
          return 0;
        case 11: 
          localrh.ntj = locala.KhF.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 12: 
          localrh.CRq = locala.KhF.readString();
          AppMethodBeat.o(113969);
          return 0;
        }
        localrh.CRr = locala.KhF.readString();
        AppMethodBeat.o(113969);
        return 0;
      }
      AppMethodBeat.o(113969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rh
 * JD-Core Version:    0.7.0.1
 */
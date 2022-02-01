package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tn
  extends com.tencent.mm.bw.a
{
  public String GjJ;
  public String GjK;
  public String country;
  public float dBu;
  public String descriptor;
  public float dzE;
  public String eRf;
  public String eRg;
  public String hZQ;
  public String name;
  public String oED;
  public String oGf;
  public float zOO;
  
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
      if (this.oED != null) {
        paramVarArgs.d(3, this.oED);
      }
      if (this.country != null) {
        paramVarArgs.d(4, this.country);
      }
      if (this.eRf != null) {
        paramVarArgs.d(5, this.eRf);
      }
      if (this.eRg != null) {
        paramVarArgs.d(6, this.eRg);
      }
      if (this.hZQ != null) {
        paramVarArgs.d(7, this.hZQ);
      }
      paramVarArgs.y(8, this.zOO);
      paramVarArgs.y(9, this.dBu);
      paramVarArgs.y(10, this.dzE);
      if (this.oGf != null) {
        paramVarArgs.d(11, this.oGf);
      }
      if (this.GjJ != null) {
        paramVarArgs.d(12, this.GjJ);
      }
      if (this.GjK != null) {
        paramVarArgs.d(13, this.GjK);
      }
      AppMethodBeat.o(113969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label895;
      }
    }
    label895:
    for (int i = f.a.a.b.b.a.e(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.descriptor != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.descriptor);
      }
      i = paramInt;
      if (this.oED != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oED);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.country);
      }
      i = paramInt;
      if (this.eRf != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.eRf);
      }
      paramInt = i;
      if (this.eRg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.eRg);
      }
      i = paramInt;
      if (this.hZQ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hZQ);
      }
      i = i + f.a.a.b.b.a.amE(8) + f.a.a.b.b.a.amE(9) + f.a.a.b.b.a.amE(10);
      paramInt = i;
      if (this.oGf != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.oGf);
      }
      i = paramInt;
      if (this.GjJ != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GjJ);
      }
      paramInt = i;
      if (this.GjK != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GjK);
      }
      AppMethodBeat.o(113969);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113969);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        tn localtn = (tn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113969);
          return -1;
        case 1: 
          localtn.name = locala.OmT.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 2: 
          localtn.descriptor = locala.OmT.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 3: 
          localtn.oED = locala.OmT.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 4: 
          localtn.country = locala.OmT.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 5: 
          localtn.eRf = locala.OmT.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 6: 
          localtn.eRg = locala.OmT.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 7: 
          localtn.hZQ = locala.OmT.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 8: 
          localtn.zOO = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(113969);
          return 0;
        case 9: 
          localtn.dBu = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(113969);
          return 0;
        case 10: 
          localtn.dzE = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(113969);
          return 0;
        case 11: 
          localtn.oGf = locala.OmT.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 12: 
          localtn.GjJ = locala.OmT.readString();
          AppMethodBeat.o(113969);
          return 0;
        }
        localtn.GjK = locala.OmT.readString();
        AppMethodBeat.o(113969);
        return 0;
      }
      AppMethodBeat.o(113969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tn
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class uc
  extends com.tencent.mm.bw.a
{
  public String GjJ;
  public String GjK;
  public long GkZ;
  public String Gla;
  public String Glb;
  public String oEp;
  public String oIr;
  public String pqW;
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
      if (this.oEp != null) {
        paramVarArgs.d(2, this.oEp);
      }
      if (this.oIr != null) {
        paramVarArgs.d(3, this.oIr);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      paramVarArgs.aZ(5, this.GkZ);
      if (this.Gla != null) {
        paramVarArgs.d(6, this.Gla);
      }
      if (this.Glb != null) {
        paramVarArgs.d(7, this.Glb);
      }
      if (this.pqW != null) {
        paramVarArgs.d(8, this.pqW);
      }
      if (this.GjJ != null) {
        paramVarArgs.d(9, this.GjJ);
      }
      if (this.GjK != null) {
        paramVarArgs.d(10, this.GjK);
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
      if (this.oEp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oEp);
      }
      i = paramInt;
      if (this.oIr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oIr);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.GkZ);
      paramInt = i;
      if (this.Gla != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gla);
      }
      i = paramInt;
      if (this.Glb != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Glb);
      }
      paramInt = i;
      if (this.pqW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.pqW);
      }
      i = paramInt;
      if (this.GjJ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GjJ);
      }
      paramInt = i;
      if (this.GjK != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GjK);
      }
      AppMethodBeat.o(113980);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113980);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        uc localuc = (uc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113980);
          return -1;
        case 1: 
          localuc.title = locala.OmT.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 2: 
          localuc.oEp = locala.OmT.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 3: 
          localuc.oIr = locala.OmT.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 4: 
          localuc.url = locala.OmT.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 5: 
          localuc.GkZ = locala.OmT.zd();
          AppMethodBeat.o(113980);
          return 0;
        case 6: 
          localuc.Gla = locala.OmT.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 7: 
          localuc.Glb = locala.OmT.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 8: 
          localuc.pqW = locala.OmT.readString();
          AppMethodBeat.o(113980);
          return 0;
        case 9: 
          localuc.GjJ = locala.OmT.readString();
          AppMethodBeat.o(113980);
          return 0;
        }
        localuc.GjK = locala.OmT.readString();
        AppMethodBeat.o(113980);
        return 0;
      }
      AppMethodBeat.o(113980);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uc
 * JD-Core Version:    0.7.0.1
 */
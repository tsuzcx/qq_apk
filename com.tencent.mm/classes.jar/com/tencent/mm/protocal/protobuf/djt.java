package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djt
  extends com.tencent.mm.bw.a
{
  public LinkedList<Integer> MNJ;
  public int MNK;
  public String MNL;
  public String dNI;
  public String egn;
  public int status;
  
  public djt()
  {
    AppMethodBeat.i(214322);
    this.MNJ = new LinkedList();
    AppMethodBeat.o(214322);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214323);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      paramVarArgs.e(2, 2, this.MNJ);
      paramVarArgs.aM(3, this.MNK);
      if (this.MNL != null) {
        paramVarArgs.e(4, this.MNL);
      }
      if (this.egn != null) {
        paramVarArgs.e(5, this.egn);
      }
      paramVarArgs.aM(100, this.status);
      AppMethodBeat.o(214323);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label505;
      }
    }
    label505:
    for (paramInt = g.a.a.b.b.a.f(1, this.dNI) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 2, this.MNJ) + g.a.a.b.b.a.bu(3, this.MNK);
      paramInt = i;
      if (this.MNL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MNL);
      }
      i = paramInt;
      if (this.egn != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.egn);
      }
      paramInt = g.a.a.b.b.a.bu(100, this.status);
      AppMethodBeat.o(214323);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MNJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(214323);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        djt localdjt = (djt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(214323);
          return -1;
        case 1: 
          localdjt.dNI = locala.UbS.readString();
          AppMethodBeat.o(214323);
          return 0;
        case 2: 
          localdjt.MNJ.add(Integer.valueOf(locala.UbS.zi()));
          AppMethodBeat.o(214323);
          return 0;
        case 3: 
          localdjt.MNK = locala.UbS.zi();
          AppMethodBeat.o(214323);
          return 0;
        case 4: 
          localdjt.MNL = locala.UbS.readString();
          AppMethodBeat.o(214323);
          return 0;
        case 5: 
          localdjt.egn = locala.UbS.readString();
          AppMethodBeat.o(214323);
          return 0;
        }
        localdjt.status = locala.UbS.zi();
        AppMethodBeat.o(214323);
        return 0;
      }
      AppMethodBeat.o(214323);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djt
 * JD-Core Version:    0.7.0.1
 */
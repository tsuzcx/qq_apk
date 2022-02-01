package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cib
  extends com.tencent.mm.bx.a
{
  public int FJz;
  public String Gde;
  public int Gdf;
  public String Gdg;
  public String HbP;
  public String HbQ;
  public String nDo;
  public String ueY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117887);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FJz);
      if (this.ueY != null) {
        paramVarArgs.d(2, this.ueY);
      }
      if (this.nDo != null) {
        paramVarArgs.d(3, this.nDo);
      }
      if (this.Gde != null) {
        paramVarArgs.d(4, this.Gde);
      }
      paramVarArgs.aS(5, this.Gdf);
      if (this.Gdg != null) {
        paramVarArgs.d(6, this.Gdg);
      }
      if (this.HbP != null) {
        paramVarArgs.d(7, this.HbP);
      }
      if (this.HbQ != null) {
        paramVarArgs.d(8, this.HbQ);
      }
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FJz) + 0;
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ueY);
      }
      i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nDo);
      }
      paramInt = i;
      if (this.Gde != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gde);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Gdf);
      paramInt = i;
      if (this.Gdg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gdg);
      }
      i = paramInt;
      if (this.HbP != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HbP);
      }
      paramInt = i;
      if (this.HbQ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HbQ);
      }
      AppMethodBeat.o(117887);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cib localcib = (cib)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117887);
        return -1;
      case 1: 
        localcib.FJz = locala.NPN.zc();
        AppMethodBeat.o(117887);
        return 0;
      case 2: 
        localcib.ueY = locala.NPN.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 3: 
        localcib.nDo = locala.NPN.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 4: 
        localcib.Gde = locala.NPN.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 5: 
        localcib.Gdf = locala.NPN.zc();
        AppMethodBeat.o(117887);
        return 0;
      case 6: 
        localcib.Gdg = locala.NPN.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 7: 
        localcib.HbP = locala.NPN.readString();
        AppMethodBeat.o(117887);
        return 0;
      }
      localcib.HbQ = locala.NPN.readString();
      AppMethodBeat.o(117887);
      return 0;
    }
    AppMethodBeat.o(117887);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cib
 * JD-Core Version:    0.7.0.1
 */
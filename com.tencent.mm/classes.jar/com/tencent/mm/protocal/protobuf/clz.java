package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class clz
  extends com.tencent.mm.bx.a
{
  public String EgY;
  public String EgZ;
  public b Eha;
  public long Ehb;
  public String Ehc;
  public String Title;
  public String Username;
  public int oXH;
  public String sdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181512);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EgZ != null) {
        paramVarArgs.d(1, this.EgZ);
      }
      if (this.Username != null) {
        paramVarArgs.d(2, this.Username);
      }
      if (this.sdZ != null) {
        paramVarArgs.d(3, this.sdZ);
      }
      paramVarArgs.aR(4, this.oXH);
      if (this.Eha != null) {
        paramVarArgs.c(5, this.Eha);
      }
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      if (this.EgY != null) {
        paramVarArgs.d(7, this.EgY);
      }
      paramVarArgs.aG(8, this.Ehb);
      if (this.Ehc != null) {
        paramVarArgs.d(9, this.Ehc);
      }
      AppMethodBeat.o(181512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EgZ == null) {
        break label670;
      }
    }
    label670:
    for (int i = f.a.a.b.b.a.e(1, this.EgZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Username);
      }
      i = paramInt;
      if (this.sdZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sdZ);
      }
      i += f.a.a.b.b.a.bA(4, this.oXH);
      paramInt = i;
      if (this.Eha != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.Eha);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Title);
      }
      paramInt = i;
      if (this.EgY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EgY);
      }
      i = paramInt + f.a.a.b.b.a.q(8, this.Ehb);
      paramInt = i;
      if (this.Ehc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Ehc);
      }
      AppMethodBeat.o(181512);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(181512);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        clz localclz = (clz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181512);
          return -1;
        case 1: 
          localclz.EgZ = locala.KhF.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 2: 
          localclz.Username = locala.KhF.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 3: 
          localclz.sdZ = locala.KhF.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 4: 
          localclz.oXH = locala.KhF.xS();
          AppMethodBeat.o(181512);
          return 0;
        case 5: 
          localclz.Eha = locala.KhF.fMu();
          AppMethodBeat.o(181512);
          return 0;
        case 6: 
          localclz.Title = locala.KhF.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 7: 
          localclz.EgY = locala.KhF.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 8: 
          localclz.Ehb = locala.KhF.xT();
          AppMethodBeat.o(181512);
          return 0;
        }
        localclz.Ehc = locala.KhF.readString();
        AppMethodBeat.o(181512);
        return 0;
      }
      AppMethodBeat.o(181512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clz
 * JD-Core Version:    0.7.0.1
 */
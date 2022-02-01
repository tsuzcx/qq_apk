package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aa
  extends com.tencent.mm.bx.a
{
  public String FqA;
  public LinkedList<String> FqB;
  public String Fqx;
  public String Fqy;
  public String Fqz;
  public String nDT;
  public String nDt;
  
  public aa()
  {
    AppMethodBeat.i(145665);
    this.FqB = new LinkedList();
    AppMethodBeat.o(145665);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145666);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDT != null) {
        paramVarArgs.d(1, this.nDT);
      }
      if (this.nDt != null) {
        paramVarArgs.d(2, this.nDt);
      }
      if (this.Fqx != null) {
        paramVarArgs.d(3, this.Fqx);
      }
      if (this.Fqy != null) {
        paramVarArgs.d(4, this.Fqy);
      }
      if (this.Fqz != null) {
        paramVarArgs.d(5, this.Fqz);
      }
      if (this.FqA != null) {
        paramVarArgs.d(6, this.FqA);
      }
      paramVarArgs.e(7, 1, this.FqB);
      AppMethodBeat.o(145666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDT == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.nDT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nDt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nDt);
      }
      i = paramInt;
      if (this.Fqx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fqx);
      }
      paramInt = i;
      if (this.Fqy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fqy);
      }
      i = paramInt;
      if (this.Fqz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fqz);
      }
      paramInt = i;
      if (this.FqA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FqA);
      }
      i = f.a.a.a.c(7, 1, this.FqB);
      AppMethodBeat.o(145666);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FqB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(145666);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(145666);
          return -1;
        case 1: 
          localaa.nDT = locala.NPN.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 2: 
          localaa.nDt = locala.NPN.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 3: 
          localaa.Fqx = locala.NPN.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 4: 
          localaa.Fqy = locala.NPN.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 5: 
          localaa.Fqz = locala.NPN.readString();
          AppMethodBeat.o(145666);
          return 0;
        case 6: 
          localaa.FqA = locala.NPN.readString();
          AppMethodBeat.o(145666);
          return 0;
        }
        localaa.FqB.add(locala.NPN.readString());
        AppMethodBeat.o(145666);
        return 0;
      }
      AppMethodBeat.o(145666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aa
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class biv
  extends com.tencent.mm.bx.a
{
  public int DGs;
  public int DGt;
  public String DGu;
  public LinkedList<String> Dip;
  public String md5;
  public String name;
  public String url;
  
  public biv()
  {
    AppMethodBeat.i(82447);
    this.Dip = new LinkedList();
    AppMethodBeat.o(82447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.e(4, 1, this.Dip);
      paramVarArgs.aR(5, this.DGs);
      paramVarArgs.aR(6, this.DGt);
      if (this.DGu != null) {
        paramVarArgs.d(7, this.DGu);
      }
      AppMethodBeat.o(82448);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label542;
      }
    }
    label542:
    for (int i = f.a.a.b.b.a.e(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.a.c(4, 1, this.Dip) + f.a.a.b.b.a.bA(5, this.DGs) + f.a.a.b.b.a.bA(6, this.DGt);
      paramInt = i;
      if (this.DGu != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DGu);
      }
      AppMethodBeat.o(82448);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dip.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82448);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        biv localbiv = (biv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82448);
          return -1;
        case 1: 
          localbiv.name = locala.KhF.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 2: 
          localbiv.url = locala.KhF.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 3: 
          localbiv.md5 = locala.KhF.readString();
          AppMethodBeat.o(82448);
          return 0;
        case 4: 
          localbiv.Dip.add(locala.KhF.readString());
          AppMethodBeat.o(82448);
          return 0;
        case 5: 
          localbiv.DGs = locala.KhF.xS();
          AppMethodBeat.o(82448);
          return 0;
        case 6: 
          localbiv.DGt = locala.KhF.xS();
          AppMethodBeat.o(82448);
          return 0;
        }
        localbiv.DGu = locala.KhF.readString();
        AppMethodBeat.o(82448);
        return 0;
      }
      AppMethodBeat.o(82448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biv
 * JD-Core Version:    0.7.0.1
 */
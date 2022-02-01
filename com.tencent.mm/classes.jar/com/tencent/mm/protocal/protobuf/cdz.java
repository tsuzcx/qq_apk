package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdz
  extends com.tencent.mm.bx.a
{
  public int Eaa;
  public boolean Eab;
  public String Eac;
  public int Ead;
  public int Eae;
  public LinkedList<cdy> Eaf;
  public String dyc;
  
  public cdz()
  {
    AppMethodBeat.i(114057);
    this.Eaf = new LinkedList();
    AppMethodBeat.o(114057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114058);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyc != null) {
        paramVarArgs.d(1, this.dyc);
      }
      paramVarArgs.aR(2, this.Eaa);
      paramVarArgs.bg(3, this.Eab);
      if (this.Eac != null) {
        paramVarArgs.d(4, this.Eac);
      }
      paramVarArgs.aR(5, this.Ead);
      paramVarArgs.aR(6, this.Eae);
      paramVarArgs.e(7, 8, this.Eaf);
      AppMethodBeat.o(114058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyc == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.dyc) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Eaa) + (f.a.a.b.b.a.fY(3) + 1);
      paramInt = i;
      if (this.Eac != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Eac);
      }
      i = f.a.a.b.b.a.bA(5, this.Ead);
      int j = f.a.a.b.b.a.bA(6, this.Eae);
      int k = f.a.a.a.c(7, 8, this.Eaf);
      AppMethodBeat.o(114058);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Eaf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdz localcdz = (cdz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114058);
          return -1;
        case 1: 
          localcdz.dyc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 2: 
          localcdz.Eaa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114058);
          return 0;
        case 3: 
          localcdz.Eab = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(114058);
          return 0;
        case 4: 
          localcdz.Eac = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 5: 
          localcdz.Ead = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114058);
          return 0;
        case 6: 
          localcdz.Eae = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114058);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cdy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdz.Eaf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      AppMethodBeat.o(114058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdz
 * JD-Core Version:    0.7.0.1
 */
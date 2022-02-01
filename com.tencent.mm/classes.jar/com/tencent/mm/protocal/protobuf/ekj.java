package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ekj
  extends com.tencent.mm.bw.a
{
  public String Inr;
  public String Ins;
  public LinkedList<chi> Int;
  public String Inu;
  public int Inv;
  public String Title;
  
  public ekj()
  {
    AppMethodBeat.i(50125);
    this.Int = new LinkedList();
    AppMethodBeat.o(50125);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50126);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Inr != null) {
        paramVarArgs.d(1, this.Inr);
      }
      if (this.Ins != null) {
        paramVarArgs.d(2, this.Ins);
      }
      paramVarArgs.e(3, 8, this.Int);
      if (this.Inu != null) {
        paramVarArgs.d(4, this.Inu);
      }
      paramVarArgs.aS(5, this.Inv);
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      AppMethodBeat.o(50126);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Inr == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.b.b.a.e(1, this.Inr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ins != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ins);
      }
      i += f.a.a.a.c(3, 8, this.Int);
      paramInt = i;
      if (this.Inu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Inu);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Inv);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Title);
      }
      AppMethodBeat.o(50126);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Int.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(50126);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ekj localekj = (ekj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50126);
          return -1;
        case 1: 
          localekj.Inr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 2: 
          localekj.Ins = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((chi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localekj.Int.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50126);
          return 0;
        case 4: 
          localekj.Inu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 5: 
          localekj.Inv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(50126);
          return 0;
        }
        localekj.Title = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(50126);
        return 0;
      }
      AppMethodBeat.o(50126);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekj
 * JD-Core Version:    0.7.0.1
 */
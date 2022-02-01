package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejz
  extends com.tencent.mm.bw.a
{
  public int FYj;
  public ejt ImM;
  public String Ind;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153344);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ImM != null)
      {
        paramVarArgs.lJ(1, this.ImM.computeSize());
        this.ImM.writeFields(paramVarArgs);
      }
      if (this.Ind != null) {
        paramVarArgs.d(2, this.Ind);
      }
      paramVarArgs.aS(3, this.FYj);
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      AppMethodBeat.o(153344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ImM == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.lI(1, this.ImM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ind != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ind);
      }
      i += f.a.a.b.b.a.bz(3, this.FYj);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Md5);
      }
      AppMethodBeat.o(153344);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153344);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ejz localejz = (ejz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153344);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ejt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localejz.ImM = ((ejt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153344);
          return 0;
        case 2: 
          localejz.Ind = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153344);
          return 0;
        case 3: 
          localejz.FYj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153344);
          return 0;
        }
        localejz.Md5 = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(153344);
        return 0;
      }
      AppMethodBeat.o(153344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejz
 * JD-Core Version:    0.7.0.1
 */
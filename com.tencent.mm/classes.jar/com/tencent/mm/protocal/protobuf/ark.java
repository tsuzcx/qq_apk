package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ark
  extends com.tencent.mm.bx.a
{
  public arh Gpj;
  public String desc;
  public String dzZ;
  public String iconUrl;
  public int sMj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dzZ != null) {
        paramVarArgs.d(1, this.dzZ);
      }
      paramVarArgs.aS(2, this.sMj);
      if (this.iconUrl != null) {
        paramVarArgs.d(3, this.iconUrl);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      if (this.Gpj != null)
      {
        paramVarArgs.lC(5, this.Gpj.computeSize());
        this.Gpj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(164048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dzZ == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.dzZ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.sMj);
      paramInt = i;
      if (this.iconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.iconUrl);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.desc);
      }
      paramInt = i;
      if (this.Gpj != null) {
        paramInt = i + f.a.a.a.lB(5, this.Gpj.computeSize());
      }
      AppMethodBeat.o(164048);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ark localark = (ark)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(164048);
          return -1;
        case 1: 
          localark.dzZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 2: 
          localark.sMj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(164048);
          return 0;
        case 3: 
          localark.iconUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(164048);
          return 0;
        case 4: 
          localark.desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(164048);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new arh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((arh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localark.Gpj = ((arh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(164048);
        return 0;
      }
      AppMethodBeat.o(164048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ark
 * JD-Core Version:    0.7.0.1
 */